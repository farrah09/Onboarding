package com.fandroid.core.util

sealed class UiEvent {
    data object Success : UiEvent()
    data class ShowToast(val message: UiText) : UiEvent()

    data class SendParam(val params: String) : UiEvent()
}
