package com.pdm.runique.core.presentation.ui

import android.content.Context
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

sealed interface UiText {
    data class DynamicString(val text: String) : UiText
    data class StringResource(@StringRes val resId: Int, val args: Array<Any> = arrayOf()) : UiText

    @Composable
    fun asString(): String {
        return when (this) {
            is DynamicString -> text
            is StringResource -> stringResource(resId, *args)
        }
    }

    fun asString(context: Context): String {
        return when (this) {
            is DynamicString -> text
            is StringResource -> context.getString(resId, *args)
        }
    }
}