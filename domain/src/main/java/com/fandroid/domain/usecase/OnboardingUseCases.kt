package com.fandroid.domain.usecase

data class OnboardingUseCases(
    val getUser: GetUser,
    val saveUserInfo: SaveUserInfo,
    val saveUserCredentials: SaveUserCredentials
)
