package com.fandroid.onboarding.confirmPin

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fandroid.core.R
import com.fandroid.core.util.UiEvent
import com.fandroid.core.util.UiText
import com.fandroid.core_ui.navigation.AppNavigator
import com.fandroid.core_ui.navigation.Destination
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ConfirmPinViewModel @Inject constructor(
    private val appNavigator: AppNavigator,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _viewState = MutableStateFlow(ConfirmPinState())
    val viewState = _viewState.asStateFlow()

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    init {
        val pin =
            savedStateHandle.get<String>(Destination.ConfirmPinScreen.PIN_KEY) ?: ""

        _viewState.update {
            it.copy(
                pin = pin
            )
        }
    }

    fun onNextClick(confirmPin: String) {
        viewModelScope.launch {
            val resultEvent = if (confirmPin == viewState.value.pin) {
                UiEvent.Success
            } else {
                UiEvent.ShowToast(UiText.StringResource(R.string.error_pins_do_not_match))
            }

            _uiEvent.send(resultEvent)
        }
    }

    fun navigateToMainScreen() {
        viewModelScope.launch {
            appNavigator.tryNavigateTo(
                Destination.MainScreen(),
                Destination.WelcomeScreen(),
                inclusive = true,
                isSingleTop = true
            )
        }
    }
}
