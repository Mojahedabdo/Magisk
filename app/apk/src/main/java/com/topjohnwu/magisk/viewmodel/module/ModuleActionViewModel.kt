package com.topjohnwu.magisk.viewmodel.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.topjohnwu.magisk.arch.TerminalLogStore
import com.topjohnwu.magisk.arch.UiText
import com.topjohnwu.magisk.arch.uiText
import com.topjohnwu.magisk.core.AppContext
import com.topjohnwu.magisk.core.ktx.timeFormatStandard
import com.topjohnwu.magisk.core.ktx.toTime
import com.topjohnwu.magisk.core.utils.MediaStoreUtils
import com.topjohnwu.magisk.core.utils.MediaStoreUtils.outputStream
import com.topjohnwu.superuser.Shell
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.Locale
import com.topjohnwu.magisk.core.R as CoreR

data class ModuleActionUiState(
    val running: Boolean = false, val success: Boolean = false
)

class ModuleActionViewModel : ViewModel() {

    private val _state = MutableStateFlow(ModuleActionUiState())
    val state: StateFlow<ModuleActionUiState> = _state.asStateFlow()

    private val _messages = MutableSharedFlow<UiText>(extraBufferCapacity = 1)
    val messages: SharedFlow<UiText> = _messages.asSharedFlow()

    private val terminal = TerminalLogStore()
    val lines = terminal.lines
    private var started = false

    fun start(actionId: String, actionName: String) {
        if (started) return
        started = true
        viewModelScope.launch(Dispatchers.IO) {
            _state.update { it.copy(running = true, success = false) }
            val success = runCatching {
                Shell.cmd("run_action ${shellQuote(actionId)}").to(terminal.console, terminal.logs)
                    .exec().isSuccess
            }.getOrDefault(false)
            terminal.sync()
            withContext(Dispatchers.Main) {
                _state.update { it.copy(running = false, success = success) }
                if (success) {
                    _messages.emit(uiText(CoreR.string.done_action, actionName))
                }
            }
        }
    }

    fun saveLog(actionName: String) {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                val safeName = actionName.ifBlank {
                    AppContext.getString(CoreR.string.module_log_fallback).lowercase(Locale.ROOT)
                }
                val name = "%s_action_log_%s.log".format(
                    safeName, System.currentTimeMillis().toTime(timeFormatStandard)
                )
                val file = MediaStoreUtils.getFile(name)
                file.uri.outputStream().bufferedWriter().use(terminal::writeTo)
                file.toString()
            }.onSuccess { path ->
                _messages.emit(uiText(CoreR.string.saved_to_path, path))
            }.onFailure {
                _messages.emit(uiText(CoreR.string.failure))
            }
        }
    }

    companion object {
        val Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                @Suppress("UNCHECKED_CAST") return ModuleActionViewModel() as T
            }
        }
    }
}

private fun shellQuote(value: String): String = "'${value.replace("'", "'\\''")}'"
