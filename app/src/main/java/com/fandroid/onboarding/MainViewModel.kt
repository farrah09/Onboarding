package com.fandroid.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fandroid.core.domain.Preferences
import com.fandroid.core_ui.navigation.AppNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class MainViewModel @Inject constructor(
    appNavigator: AppNavigator,
    private val preferences: Preferences
) : ViewModel() {
    val navigationChannel = appNavigator.navigationChannel

    private val _loading = MutableStateFlow(true)
    val loading = _loading.asStateFlow()

    init {
        viewModelScope.launch {
            delay(3500)
            _loading.value = false
        }
    }

    fun isShowOnboarding(): Boolean {
        return preferences.loadShouldShowOnboarding()
    }
}
