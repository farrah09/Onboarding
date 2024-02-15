package com.fandroid.onboarding.newPin

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
class NewPinViewModel @Inject constructor(
    private val appNavigator: AppNavigator
) : ViewModel() {

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onNextClick(pin: String) {
        viewModelScope.launch {
            _uiEvent.send(UiEvent.SendParam(pin))
        }
    }

    fun navigateToConfirmPin(pin: String) {
        viewModelScope.launch {
            appNavigator.navigateTo(Destination.ConfirmPinScreen(pin))
        }
    }
}
