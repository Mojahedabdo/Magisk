package com.topjohnwu.magisk.ui.component

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration

private const val ESC = '\u001B'
private const val BEL = '\u0007'

internal fun String.toTerminalAnnotatedString(
    baseStyle: TextStyle,
    inverseForeground: Color
): AnnotatedString {
    if (ESC !in this) return AnnotatedString(this)

    val builder = AnnotatedString.Builder()
    var index = 0
    var segmentStart = 0
    var style = AnsiStyle()

    fun appendSegment(until: Int) {
        if (until <= segmentStart) return
        val text = substring(segmentStart, until)
        val span = style.toSpanStyle(baseStyle, inverseForeground)
        if (span == null) {
            builder.append(text)
        } else {
            builder.pushStyle(span)
            builder.append(text)
            builder.pop()
        }
    }

    while (index < length) {
        if (this[index] != ESC) {
            index++
            continue
        }

        appendSegment(index)
        val next = getOrNull(index + 1)
        when (next) {
            '[' -> {
                val end = findCsiEnd(index + 2)
                if (end < 0) {
                    segmentStart = index
                    break
                }
                val command = this[end]
                if (command == 'm') {
                    style = style.applySgr(substring(index + 2, end))
                }
                index = end + 1
                segmentStart = index
            }
            ']' -> {
                val end = findOscEnd(index + 2)
                if (end < 0) {
                    segmentStart = length
                    index = length
                } else {
                    index = end
                    segmentStart = index
                }
            }
            else -> {
                index += 1
                segmentStart = index
            }
        }
    }

    appendSegment(length)
    return builder.toAnnotatedString()
}

private fun String.findCsiEnd(start: Int): Int {
    var index = start
    while (index < length) {
        val char = this[index]
        if (char in '@'..'~') return index
        index++
    }
    return -1
}

private fun String.findOscEnd(start: Int): Int {
    var index = start
    while (index < length) {
        if (this[index] == BEL) return index + 1
        if (this[index] == ESC && getOrNull(index + 1) == '\\') return index + 2
        index++
    }
    return -1
}

private data class AnsiStyle(
    val foreground: Color? = null,
    val background: Color? = null,
    val bold: Boolean = false,
    val faint: Boolean = false,
    val italic: Boolean = false,
    val underline: Boolean = false,
    val strikeThrough: Boolean = false,
    val inverse: Boolean = false
) {
    fun toSpanStyle(baseStyle: TextStyle, inverseForeground: Color): SpanStyle? {
        if (this == AnsiStyle()) return null

        val baseColor = baseStyle.color.takeIf { it != Color.Unspecified } ?: Color.White
        val textColor = if (inverse) {
            background ?: inverseForeground
        } else {
            foreground ?: Color.Unspecified
        }.let { color ->
            if (faint && color != Color.Unspecified) color.copy(alpha = 0.68f) else color
        }
        val bgColor = if (inverse) {
            foreground ?: baseColor
        } else {
            background ?: Color.Unspecified
        }
        val decorations = buildList {
            if (underline) add(TextDecoration.Underline)
            if (strikeThrough) add(TextDecoration.LineThrough)
        }

        return SpanStyle(
            color = textColor,
            background = bgColor,
            fontWeight = if (bold) FontWeight.Bold else null,
            fontStyle = if (italic) FontStyle.Italic else null,
            textDecoration = if (decorations.isEmpty()) null else TextDecoration.combine(decorations)
        )
    }

    fun applySgr(rawCodes: String): AnsiStyle {
        val codes = rawCodes
            .takeIf { it.isNotBlank() }
            ?.split(';', ':')
            ?.mapNotNull { it.toIntOrNull() }
            ?.takeIf { it.isNotEmpty() }
            ?: listOf(0)

        var style = this
        var index = 0
        while (index < codes.size) {
            when (val code = codes[index]) {
                0 -> style = AnsiStyle()
                1 -> style = style.copy(bold = true, faint = false)
                2 -> style = style.copy(faint = true, bold = false)
                3 -> style = style.copy(italic = true)
                4 -> style = style.copy(underline = true)
                7 -> style = style.copy(inverse = true)
                9 -> style = style.copy(strikeThrough = true)
                21, 22 -> style = style.copy(bold = false, faint = false)
                23 -> style = style.copy(italic = false)
                24 -> style = style.copy(underline = false)
                27 -> style = style.copy(inverse = false)
                29 -> style = style.copy(strikeThrough = false)
                in 30..37 -> style = style.copy(foreground = terminalColor(code - 30, bright = false))
                39 -> style = style.copy(foreground = null)
                in 40..47 -> style = style.copy(background = terminalColor(code - 40, bright = false))
                49 -> style = style.copy(background = null)
                in 90..97 -> style = style.copy(foreground = terminalColor(code - 90, bright = true))
                in 100..107 -> style = style.copy(background = terminalColor(code - 100, bright = true))
                38, 48 -> {
                    val parsed = parseExtendedColor(codes, index + 1)
                    if (parsed != null) {
                        style = if (code == 38) {
                            style.copy(foreground = parsed.color)
                        } else {
                            style.copy(background = parsed.color)
                        }
                        index = parsed.nextIndex - 1
                    }
                }
            }
            index++
        }
        return style
    }
}

private data class ParsedColor(
    val color: Color,
    val nextIndex: Int
)

private fun parseExtendedColor(codes: List<Int>, modeIndex: Int): ParsedColor? {
    return when (codes.getOrNull(modeIndex)) {
        5 -> {
            val value = codes.getOrNull(modeIndex + 1) ?: return null
            ParsedColor(xtermColor(value.coerceIn(0, 255)), modeIndex + 2)
        }
        2 -> {
            val red = codes.getOrNull(modeIndex + 1) ?: return null
            val green = codes.getOrNull(modeIndex + 2) ?: return null
            val blue = codes.getOrNull(modeIndex + 3) ?: return null
            ParsedColor(rgb(red, green, blue), modeIndex + 4)
        }
        else -> null
    }
}

private fun terminalColor(index: Int, bright: Boolean): Color {
    val colors = if (bright) brightTerminalColors else normalTerminalColors
    return colors[index.coerceIn(colors.indices)]
}

private fun xtermColor(index: Int): Color {
    if (index < 16) {
        return if (index < 8) {
            terminalColor(index, bright = false)
        } else {
            terminalColor(index - 8, bright = true)
        }
    }

    if (index in 16..231) {
        val value = index - 16
        val levels = intArrayOf(0, 95, 135, 175, 215, 255)
        return rgb(
            red = levels[value / 36],
            green = levels[(value / 6) % 6],
            blue = levels[value % 6]
        )
    }

    val gray = 8 + (index - 232) * 10
    return rgb(gray, gray, gray)
}

private fun rgb(red: Int, green: Int, blue: Int): Color {
    val r = red.coerceIn(0, 255)
    val g = green.coerceIn(0, 255)
    val b = blue.coerceIn(0, 255)
    return Color(0xFF000000.toInt() or (r shl 16) or (g shl 8) or b)
}

private val normalTerminalColors = listOf(
    rgb(0, 0, 0),
    rgb(128, 0, 0),
    rgb(0, 128, 0),
    rgb(128, 128, 0),
    rgb(0, 0, 128),
    rgb(128, 0, 128),
    rgb(0, 128, 128),
    rgb(192, 192, 192)
)

private val brightTerminalColors = listOf(
    rgb(128, 128, 128),
    rgb(255, 0, 0),
    rgb(0, 255, 0),
    rgb(255, 255, 0),
    rgb(0, 0, 255),
    rgb(255, 0, 255),
    rgb(0, 255, 255),
    rgb(255, 255, 255)
)
