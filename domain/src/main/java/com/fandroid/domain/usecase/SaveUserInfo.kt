package com.fandroid.domain.usecase

import com.fandroid.core.R
import com.fandroid.core.util.OnboardingResult
import com.fandroid.core.util.UiText
import com.fandroid.core.util.Validator
import com.fandroid.domain.model.UserInfo
import com.fandroid.domain.repository.OnboardingRepository

class SaveUserInfo(
    private val repository: OnboardingRepository
) {
    suspend operator fun invoke(userInfo: UserInfo): OnboardingResult<Unit> {
        if (!Validator.isValidPhoneNumber(userInfo.telephone)) {
            return OnboardingResult.Error(UiText.StringResource(R.string.error_not_valid_number))
        }

        repository.insertUserInfo(
            UserInfo(
                fName = userInfo.fName,
                lName = userInfo.lName,
                telephone = userInfo.telephone
            )
        )

        return OnboardingResult.Success()
    }
}
