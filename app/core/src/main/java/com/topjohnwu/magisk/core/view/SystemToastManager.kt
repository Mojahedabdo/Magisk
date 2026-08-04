package com.topjohnwu.magisk.view

import android.content.Context
import android.widget.Toast
import com.topjohnwu.superuser.internal.UiThreadHandler

object SystemToastManager {

    fun show(
        context: Context,
        message: CharSequence,
        duration: Int = Toast.LENGTH_SHORT
    ) {
        val appContext = context.applicationContext
        UiThreadHandler.run {
            Toast.makeText(appContext, message, duration).show()
        }
    }

    fun show(
        context: Context,
        resId: Int,
        duration: Int = Toast.LENGTH_SHORT
    ) {
        show(context, context.getText(resId), duration)
    }
}
