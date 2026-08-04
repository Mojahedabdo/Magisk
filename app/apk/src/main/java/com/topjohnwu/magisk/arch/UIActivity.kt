package com.topjohnwu.magisk.arch

import androidx.activity.ComponentActivity
import com.topjohnwu.magisk.core.base.ActivityExtension

abstract class UIActivity<T> : ComponentActivity() {
    abstract val extension: ActivityExtension

    fun withPermission(permission: String, callback: (Boolean) -> Unit) {
        extension.withPermission(permission, callback)
    }

    fun withAuthentication(callback: (Boolean) -> Unit) {
        extension.withAuthentication(callback)
    }
}

