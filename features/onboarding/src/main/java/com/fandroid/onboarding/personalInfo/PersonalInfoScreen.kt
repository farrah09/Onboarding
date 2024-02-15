package com.fandroid.onboarding.personalInfo

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material3.Icon
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.fandroid.core.R
import com.fandroid.core.util.UiEvent
import com.fandroid.core_ui.ui.components.OnboardingButton
import com.fandroid.core_ui.ui.components.OnboardingTextField
import com.fandroid.core_ui.ui.components.OnboardingTopRoundedCard
import com.fandroid.core_ui.ui.theme.LocalSpacing
import com.fandroid.core_ui.ui.theme.OnboardingAppTheme

@Composable
fun PersonalInfoScreen() {
    val viewModel: PersonalInfoViewModel = hiltViewModel()
    val context = LocalContext.current
    val density = LocalDensity.current.density

    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                is UiEvent.Success -> viewModel.navigateToNewPinScreen()
                is UiEvent.ShowToast -> {
                    Toast.makeText(
                        context,
                        event.message.asString(context),
                        Toast.LENGTH_SHORT
                    )
                        .apply {
                            setGravity(
                                android.view.Gravity.BOTTOM
                                    or android.view.Gravity.CENTER_HORIZONTAL,
                                0,
                                (64 * density).toInt()
                            )
                            show()
                        }
                }
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
                PersonalInfoInputScreen(viewModel)
            }
        )
    }
}

@Composable
private fun PersonalInfoInputScreen(viewModel: PersonalInfoViewModel) {
    val spacing = LocalSpacing.current

    var fName by rememberSaveable { mutableStateOf("") }
    var lName by rememberSaveable { mutableStateOf("") }
    var telephone by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.personal_info),
            modifier = Modifier.align(Alignment.CenterHorizontally),
            color = MaterialTheme.colorScheme.onSecondary,
            style = MaterialTheme.typography.headlineLarge
                .copy(fontWeight = FontWeight.Bold)
        )

        Spacer(modifier = Modifier.height(spacing.spaceLarge))

        OnboardingTextField(
            value = fName,
            onValueChange = { fName = it },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Outlined.Person,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSecondary
                )
            },
            placeholder = stringResource(id = R.string.fName)
        )

        Spacer(modifier = Modifier.height(spacing.spaceMedium))

        OnboardingTextField(
            value = lName,
            onValueChange = { lName = it },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Outlined.Person,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSecondary
                )
            },
            placeholder = stringResource(id = R.string.lName)
        )

        Spacer(modifier = Modifier.height(spacing.spaceMedium))

        OnboardingTextField(
            value = telephone,
            onValueChange = { telephone = it.take(10) },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Outlined.Phone,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSecondary
                )
            },
            prefix = "+44",
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Phone
            ),
            placeholder = "000 00000",
            supportingText = {
                Text(
                    text = "${telephone.length} / 10",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.End
                )
            }

        )

        Spacer(modifier = Modifier.height(spacing.spaceLarge))

        OnboardingButton(
            onClick = {
                viewModel.onEvent(
                    PersonalInfoEvent.OnSaveReference(
                        fName = fName,
                        lName = lName,
                        telephone = telephone
                    )
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            isEnabled = fName.isNotEmpty() &&
                lName.isNotEmpty() &&
                telephone.isNotEmpty(),
            text = stringResource(id = R.string.proceed)
        )
    }
}

@Preview
@Composable
private fun PersonalInfoScreenPreview() {
    OnboardingAppTheme {
        PersonalInfoScreen()
    }
}
