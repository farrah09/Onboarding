package com.fandroid.core_ui.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fandroid.core_ui.ui.theme.OnboardingAppTheme

@Composable
fun OnboardingTextField(
    value: String,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit,
    isEnabled: Boolean = true,
    placeholder: String,
    prefix: String? = null,
    leadingIcon: @Composable () -> Unit,
    keyboardOptions: KeyboardOptions = KeyboardOptions(
        imeAction = ImeAction.Next
    ),
    supportingText: @Composable() () -> Unit = {},
    shape: RoundedCornerShape = RoundedCornerShape(25.dp)
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            enabled = isEnabled,
            placeholder = { Text(placeholder) },
            leadingIcon = leadingIcon,
            keyboardOptions = keyboardOptions,
            singleLine = true,
            shape = shape,
            prefix = { prefix?.let { Text(it) } },
            supportingText = supportingText,
            modifier = Modifier
                .width(IntrinsicSize.Min),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = MaterialTheme.colorScheme.onPrimary,
                focusedTextColor = MaterialTheme.colorScheme.onPrimary,
                unfocusedTextColor = MaterialTheme.colorScheme.onPrimary,
                unfocusedBorderColor = MaterialTheme.colorScheme.onSecondary
            )
        )
    }
}

@Composable
@Preview
fun OnboardingTextFieldPreview() {
    OnboardingAppTheme {
        OnboardingTextField(
            value = "",
            onValueChange = {},
            leadingIcon = {
                Icon(
                    imageVector = Icons.Outlined.Email,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSecondary
                )
            },
            placeholder = ""
        )
    }
}
