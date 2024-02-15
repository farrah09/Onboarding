package com.fandroid.domain.di

import com.fandroid.domain.repository.OnboardingRepository
import com.fandroid.domain.usecase.GetUser
import com.fandroid.domain.usecase.OnboardingUseCases
import com.fandroid.domain.usecase.SaveUserCredentials
import com.fandroid.domain.usecase.SaveUserInfo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object OnboardingDomainModule {

    @ViewModelScoped
    @Provides
    fun provideOnboardingUseCases(repository: OnboardingRepository): OnboardingUseCases {
        return OnboardingUseCases(
            getUser = GetUser(repository),
            saveUserInfo = SaveUserInfo(repository),
            saveUserCredentials = SaveUserCredentials(repository)
        )
    }
}
