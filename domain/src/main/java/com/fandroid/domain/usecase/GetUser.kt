package com.fandroid.domain.usecase

import com.fandroid.domain.model.User
import com.fandroid.domain.repository.OnboardingRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine

class GetUser(
    private val repository: OnboardingRepository
) {
    operator fun invoke(): Flow<User> = repository.getUserInfo()
        .combine(repository.getUserCredentials()) { userInfo, userCredentials ->
            User(userInfo, userCredentials)
        }
}
