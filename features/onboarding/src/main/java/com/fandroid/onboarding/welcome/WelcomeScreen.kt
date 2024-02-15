package com.fandroid.onboarding.welcome

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.fandroid.core.R
import com.fandroid.core.util.UiEvent
import com.fandroid.core_ui.ui.components.OnboardingButton
import com.fandroid.core_ui.ui.components.OnboardingTopRoundedCard
import com.fandroid.core_ui.ui.theme.LocalSpacing
import com.fandroid.core_ui.ui.theme.OnboardingAppTheme

@Composable
fun WelcomeScreen() {
    val viewModel: WelcomeViewModel = hiltViewModel()

    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                is UiEvent.Success -> viewModel.navigateToTermsOfServicesScreen()
                else -> Unit
            }
        }
    }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface)
    ) {
        OnboardingTopRoundedCard(
            content = {
                WelcomeInput(viewModel)
            }
        )
    }
}

@Composable
private fun WelcomeInput(viewModel: WelcomeViewModel) {
    val spacing = LocalSpacing.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(spacing.spaceMedium),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.welcome),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.headlineLarge
        )
        Spacer(modifier = Modifier.height(spacing.spaceMedium))
        OnboardingButton(
            text = stringResource(id = R.string.proceed),
            onClick = { viewModel.onNextClick() },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}

@Preview
@Composable
private fun WelcomeScreenPreview() {
    OnboardingAppTheme {
        WelcomeScreen()
    }
}
