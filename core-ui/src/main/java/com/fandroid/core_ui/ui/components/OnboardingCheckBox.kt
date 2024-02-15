package com.fandroid.core_ui.ui.components

import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.fandroid.core_ui.ui.theme.OnboardingAppTheme

@Composable
fun OnboardingCheckBox(
    checked: Boolean,
    onCheckedChange: () -> Unit,
    modifier: Modifier
) {
    Checkbox(
        checked = checked,
        onCheckedChange = { onCheckedChange() },
        modifier = modifier,
        colors = CheckboxDefaults.colors(
            checkedColor = MaterialTheme.colorScheme.primaryContainer,
            checkmarkColor = MaterialTheme.colorScheme.primary
        )
    )
}

@Composable
@Preview
fun OnboardingCheckBoxPreview() {
    var checkChange by remember { mutableStateOf(false) }
    OnboardingAppTheme {
        OnboardingCheckBox(
            onCheckedChange = { checkChange = !checkChange },
            checked = true,
            modifier = Modifier

        )
    }
}
