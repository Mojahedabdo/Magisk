package com.topjohnwu.magisk.arch

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.io.Writer
import kotlin.math.min

class TerminalLogStore {
    private val _lines = MutableStateFlow<List<String>>(emptyList())
    val lines: StateFlow<List<String>> = _lines.asStateFlow()

    val console: MutableList<String> = TerminalOutputList(::sync)
    val logs: MutableList<String> = TerminalOutputList()

    fun addLine(line: String) {
        console += line
    }

    fun sync() {
        _lines.value = console.toList()
    }

    fun writeTo(writer: Writer) {
        console.forEach { writer.write("$it\n") }
        if (logs.isNotEmpty()) {
            writer.write("\n")
            logs.forEach { writer.write("$it\n") }
        }
    }

    private class TerminalOutputList(
        private val onChanged: () -> Unit = {}
    ) : AbstractMutableList<String>() {
        private val lock = Any()
        private val items = mutableListOf<String>()

        override val size: Int
            get() = synchronized(lock) { items.size }

        override fun get(index: Int): String = synchronized(lock) {
            items[index]
        }

        override fun add(index: Int, element: String) {
            synchronized(lock) {
                items.add(min(index, items.size), element)
            }
            onChanged()
        }

        override fun set(index: Int, element: String): String {
            val previous = synchronized(lock) {
                items.set(index, element)
            }
            onChanged()
            return previous
        }

        override fun removeAt(index: Int): String {
            val removed = synchronized(lock) {
                items.removeAt(index)
            }
            onChanged()
            return removed
        }

        override fun clear() {
            synchronized(lock) {
                items.clear()
            }
            onChanged()
        }
    }
}
