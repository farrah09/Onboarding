package com.fandroid.onboarding.newPin

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.fandroid.core.R
import com.fandroid.core.util.UiEvent
import com.fandroid.core_ui.ui.components.OnboardingButton
import com.fandroid.core_ui.ui.components.OnboardingPasswordTextField
import com.fandroid.core_ui.ui.components.OnboardingTopRoundedCard
import com.fandroid.core_ui.ui.theme.LocalSpacing

@Composable
fun NewPinScreen() {
    val viewModel: NewPinViewModel = hiltViewModel()

    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                is UiEvent.SendParam -> viewModel.navigateToConfirmPin(event.params)
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
                NewPinInputScreen(viewModel)
            }
        )
    }
}

@Composable
fun NewPinInputScreen(viewModel: NewPinViewModel) {
    val spacing = LocalSpacing.current

    var pin by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.pin_number),
            modifier = Modifier.align(Alignment.CenterHorizontally),
            color = MaterialTheme.colorScheme.onSecondary,
            style = MaterialTheme.typography.headlineLarge
                .copy(fontWeight = FontWeight.Bold)
        )

        Spacer(modifier = Modifier.height(spacing.spaceLarge))

        OnboardingPasswordTextField(
            value = pin,
            onValueChange = { pin = it },
            placeholder = stringResource(id = R.string.pin_heading)
        )

        Spacer(modifier = Modifier.height(spacing.spaceLarge))

        OnboardingButton(
            onClick = {
                viewModel.onNextClick(pin)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            isEnabled = pin.isNotEmpty(),
            text = stringResource(id = R.string.proceed)
        )
    }
}

@Preview
@Composable
fun PreviewNewPinScreen() {
    NewPinScreen()
}
