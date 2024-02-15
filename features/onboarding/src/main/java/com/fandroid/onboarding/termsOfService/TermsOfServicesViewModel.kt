package com.fandroid.onboarding.termsOfService

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fandroid.core.util.UiEvent
import com.fandroid.core_ui.navigation.AppNavigator
import com.fandroid.core_ui.navigation.Destination
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TermsOfServicesViewModel @Inject constructor(
    private val appNavigator: AppNavigator
) : ViewModel() {

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onNextClick(isTermsAccepted: Boolean) {
        viewModelScope.launch {
            if (isTermsAccepted) {
                _uiEvent.send(UiEvent.Success)
            }
        }
    }

    fun navigateToCredentials() {
        viewModelScope.launch {
            appNavigator.navigateTo(Destination.CredentialsScreen())
        }
    }
}
