package com.pdm.runique.auth.presentation.login

import com.pdm.runique.core.presentation.ui.UiText

sealed interface LoginEvent {
    data object LoginSuccess : LoginEvent
    data class Error(val error: UiText) : LoginEvent
}