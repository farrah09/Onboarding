package com.fandroid.core.util

sealed class OnboardingResult<T>(val data: T? = null, val message: UiText = UiText.DynamicString("")) {
    class Success<T> : OnboardingResult<T>()
    class Error<T>(message: UiText) : OnboardingResult<T>(message = message)
}
