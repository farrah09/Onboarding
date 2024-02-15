package com.fandroid.main.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fandroid.core.domain.Preferences
import com.fandroid.core.util.UiEvent
import com.fandroid.core_ui.navigation.AppNavigator
import com.fandroid.core_ui.navigation.Destination
import com.fandroid.domain.usecase.OnboardingUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MianViewModel @Inject constructor(
    private val preferences: Preferences,
    private val appNavigator: AppNavigator,
    private val onboardingUseCases: OnboardingUseCases
) : ViewModel() {

    var state by mutableStateOf(MainState())
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    init {
        preferences.saveShouldShowOnboarding(false)
        viewModelScope.launch {
            onboardingUseCases.getUser().collectLatest {
                state = state.copy(
                    email = it.userCredentials.email,
                    fName = it.userInfo.fName,
                    lName = it.userInfo.lName,
                    telephone = it.userInfo.telephone
                )
            }
        }
    }

    fun onSignOutClick() {
        viewModelScope.launch {
            preferences.saveShouldShowOnboarding(true)
            _uiEvent.send(UiEvent.Success)
        }
    }

    fun navigateToWelcomeScreen() {
        viewModelScope.launch {
            appNavigator.navigateTo(
                Destination.WelcomeScreen(),
                Destination.MainScreen(),
                true,
                true
            )
        }
    }
}
