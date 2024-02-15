package com.fandroid.onboarding.credentials

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fandroid.core.util.OnboardingResult
import com.fandroid.core.util.UiEvent
import com.fandroid.core_ui.navigation.AppNavigator
import com.fandroid.core_ui.navigation.Destination
import com.fandroid.domain.model.UserCredentials
import com.fandroid.domain.usecase.OnboardingUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class CredentialsEvent {
    data class OnSaveReference(
        val email: String,
        val password: String
    ) : CredentialsEvent()
}

@HiltViewModel
class CredentialsViewModel @Inject constructor(
    private val appNavigator: AppNavigator,
    private val onboardingUseCases: OnboardingUseCases
) : ViewModel() {

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onEvent(event: CredentialsEvent) {
        when (event) {
            is CredentialsEvent.OnSaveReference -> {
                viewModelScope.launch {
                    val userCredentials = UserCredentials(
                        email = event.email,
                        password = event.password
                    )

                    val result: OnboardingResult<Unit> = onboardingUseCases
                        .saveUserCredentials(userCredentials)

                    when (result) {
                        is OnboardingResult.Success ->
                            _uiEvent.send(UiEvent.Success)

                        is OnboardingResult.Error ->
                            _uiEvent.send(UiEvent.ShowToast(result.message))
                    }
                }
            }
        }
    }

    fun navigateToPersonalInfoScreen() {
        viewModelScope.launch {
            appNavigator.navigateTo(Destination.PersonalInfoScreen())
        }
    }
}
