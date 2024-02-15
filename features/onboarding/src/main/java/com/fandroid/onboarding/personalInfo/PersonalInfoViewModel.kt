package com.fandroid.onboarding.personalInfo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fandroid.core.util.OnboardingResult
import com.fandroid.core.util.UiEvent
import com.fandroid.core_ui.navigation.AppNavigator
import com.fandroid.core_ui.navigation.Destination
import com.fandroid.domain.model.UserInfo
import com.fandroid.domain.usecase.OnboardingUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class PersonalInfoEvent {
    data class OnSaveReference(
        val fName: String,
        val lName: String,
        val telephone: String
    ) : PersonalInfoEvent()
}

@HiltViewModel
class PersonalInfoViewModel @Inject constructor(
    private val appNavigator: AppNavigator,
    private val onboardingUseCases: OnboardingUseCases
) : ViewModel() {

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onEvent(event: PersonalInfoEvent) {
        when (event) {
            is PersonalInfoEvent.OnSaveReference -> {
                viewModelScope.launch {
                    val userInfo = UserInfo(
                        fName = event.fName,
                        lName = event.lName,
                        telephone = event.telephone
                    )

                    val result: OnboardingResult<Unit> = onboardingUseCases
                        .saveUserInfo(userInfo)

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

    fun navigateToNewPinScreen() {
        viewModelScope.launch {
            appNavigator.navigateTo(Destination.NewPinScreen())
        }
    }
}
