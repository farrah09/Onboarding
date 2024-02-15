package com.fandroid.onboarding.termsOfService

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import com.fandroid.core_ui.ui.components.OnboardingCheckBox
import com.fandroid.core_ui.ui.components.OnboardingTopRoundedCard
import com.fandroid.core_ui.ui.components.SelectableButton
import com.fandroid.core_ui.ui.theme.LocalSpacing
import com.fandroid.core_ui.ui.theme.OnboardingAppTheme

@Composable
fun TermsOfServiceScreen() {
    val viewModel: TermsOfServicesViewModel = hiltViewModel()

    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                is UiEvent.Success -> viewModel.navigateToCredentials()
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
                TermsOfServiceInput(viewModel)
            }
        )
    }
}

@Composable
private fun TermsOfServiceInput(viewModel: TermsOfServicesViewModel) {
    val spacing = LocalSpacing.current

    var isTermsAccepted by rememberSaveable { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .padding(spacing.spaceMedium)
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                text = stringResource(id = R.string.terms_of_service),
                modifier = Modifier.align(Alignment.CenterHorizontally),
                color = MaterialTheme.colorScheme.onPrimary,
                style = MaterialTheme.typography.headlineLarge
                    .copy(fontWeight = FontWeight.Bold)
            )

            Text(
                text = stringResource(id = R.string.terms_of_service_content),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onPrimary
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                OnboardingCheckBox(
                    checked = isTermsAccepted,
                    onCheckedChange = { isTermsAccepted = !isTermsAccepted },
                    modifier = Modifier.padding(end = 8.dp)
                )
                Text(stringResource(id = R.string.proceed))
            }

            Spacer(modifier = Modifier.height(spacing.spaceMedium))

            SelectableButton(
                onClick = {
                    viewModel.onNextClick(isTermsAccepted)
                },
                modifier = Modifier.align(Alignment.End),
                isSelected = isTermsAccepted,
                text = stringResource(id = R.string.proceed)
            )
        }
    }
}

@Preview
@Composable
private fun TermsOfServiceScreenPreview() {
    OnboardingAppTheme {
        TermsOfServiceScreen()
    }
}
