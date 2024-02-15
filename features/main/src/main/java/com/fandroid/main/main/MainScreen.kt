package com.fandroid.main.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.fandroid.core.R
import com.fandroid.core.util.UiEvent
import com.fandroid.core_ui.ui.components.OnboardingButton
import com.fandroid.core_ui.ui.components.OnboardingTopRoundedCard
import com.fandroid.core_ui.ui.theme.LocalSpacing

@Composable
fun MainScreen() {
    val viewModel: MianViewModel = hiltViewModel()

    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                is UiEvent.Success -> viewModel.navigateToWelcomeScreen()
                else -> Unit
            }
        }
    }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface),
    ) {
        OnboardingTopRoundedCard(
            content = {
                MainScreenInput(viewModel)
            },
        )
    }
}

@Composable
private fun MainScreenInput(viewModel: MianViewModel) {
    val spacing = LocalSpacing.current

    val state = viewModel.state

    Box(
        modifier = Modifier
            .padding(spacing.spaceMedium)
            .fillMaxSize(),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = stringResource(id = R.string.hi),
                modifier = Modifier.align(Alignment.CenterHorizontally),
                color = MaterialTheme.colorScheme.onPrimary,
                style = MaterialTheme.typography.headlineLarge
                    .copy(fontWeight = FontWeight.Bold),
            )

            Spacer(modifier = Modifier.height(spacing.spaceSmall))

            Text(
                text = "${state.fName} ${state.lName}",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onPrimary,
            )

            Spacer(modifier = Modifier.height(spacing.spaceMedium))

            Text(
                text = stringResource(id = R.string.telephone_main).plus("+44 ${state.telephone}"),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onPrimary,
            )

            Spacer(modifier = Modifier.height(spacing.spaceMedium))

            Text(
                text = stringResource(id = R.string.email_main).plus(" ${state.email}"),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onPrimary,
            )

            Spacer(modifier = Modifier.height(spacing.spaceExtraLarge))

            OnboardingButton(
                onClick = {
                    viewModel.onSignOutClick()
                },
                modifier = Modifier.align(Alignment.CenterHorizontally),
                isEnabled = true,
                text = stringResource(id = R.string.sign_out),
            )
        }
    }
}

@Preview
@Composable
fun PreviewMainScreen() {
    MainScreen()
}
