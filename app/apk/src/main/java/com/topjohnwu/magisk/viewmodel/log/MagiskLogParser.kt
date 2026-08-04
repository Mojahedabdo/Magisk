package com.topjohnwu.magisk.viewmodel.log

data class MagiskLogEntry(
    val timestamp: String = "",
    val pid: Int = 0,
    val tid: Int = 0,
    val level: Char = 'I',
    val tag: String = "",
    val message: String = "",
    val isParsed: Boolean = false,
)

object MagiskLogParser {
    private val logcatRegex = Regex(
        """(\d{2}-\d{2}\s+\d{2}:\d{2}:\d{2}\.\d{3})\s+(\d+)\s+(\d+)\s+([VDIWEF])\s+(.+?)\s*:\s+(.*)"""
    )

    fun parse(raw: String): List<MagiskLogEntry> {
        if (raw.isBlank()) return emptyList()

        val result = mutableListOf<MagiskLogEntry>()
        for (line in raw.lines()) {
            if (line.isBlank()) continue
            val match = logcatRegex.find(line)
            if (match != null) {
                result += MagiskLogEntry(
                    timestamp = match.groupValues[1],
                    pid = match.groupValues[2].toIntOrNull() ?: 0,
                    tid = match.groupValues[3].toIntOrNull() ?: 0,
                    level = match.groupValues[4].firstOrNull() ?: 'I',
                    tag = match.groupValues[5].trim(),
                    message = match.groupValues[6],
                    isParsed = true,
                )
            } else if (result.isNotEmpty() && result.last().isParsed) {
                val previous = result.last()
                result[result.lastIndex] = previous.copy(
                    message = previous.message + "\n" + line.trimEnd()
                )
            } else {
                result += MagiskLogEntry(message = line.trimEnd())
            }
        }
        return result
    }
}
