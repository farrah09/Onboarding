package com.fandroid.domain.usecase

import com.fandroid.core.R
import com.fandroid.core.util.OnboardingResult
import com.fandroid.core.util.UiText
import com.fandroid.core.util.Validator
import com.fandroid.domain.model.UserCredentials
import com.fandroid.domain.repository.OnboardingRepository

class SaveUserCredentials(
    private val repository: OnboardingRepository
) {
    suspend operator fun invoke(userCredentials: UserCredentials): OnboardingResult<Unit> {
        if (!Validator.isValidEmail(userCredentials.email)) {
            return OnboardingResult.Error(UiText.StringResource(R.string.error_not_valid_email))
        }
        repository.insertUserCredentials(
            UserCredentials(
                email = userCredentials.email,
                password = userCredentials.password
            )
        )

        return OnboardingResult.Success()
    }
}
