package com.topjohnwu.magisk.arch

import android.os.Bundle
import androidx.annotation.StringRes
import androidx.lifecycle.ViewModel
import com.topjohnwu.magisk.navigation.AppRoute
import kotlinx.coroutines.flow.SharedFlow

abstract class BaseViewModel : ViewModel() {

    private val effectEmitter = UiEffectEmitter()
    val effects: SharedFlow<UiEffect> = effectEmitter.effects

    open fun onSaveState(state: Bundle) {}
    open fun onRestoreState(state: Bundle) {}

    protected fun sendEffect(effect: UiEffect) {
        effectEmitter.tryEmit(effect)
    }

    protected suspend fun emitEffect(effect: UiEffect) {
        effectEmitter.emit(effect)
    }

    fun showMessage(@StringRes resId: Int, vararg args: Any) {
        sendEffect(UiEffect.Message(uiText(resId, *args)))
    }

    fun showMessage(message: String) {
        sendEffect(UiEffect.Message(uiText(message)))
    }

    fun navigateTo(route: AppRoute) {
        sendEffect(UiEffect.Navigate(route))
    }
}
