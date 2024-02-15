package com.fandroid.data.di

import android.app.Application
import androidx.room.Room
import com.fandroid.data.local.OnboardingDatabase
import com.fandroid.data.repository.OnboardingRepositoryImpl
import com.fandroid.domain.repository.OnboardingRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object OnboardingDataModule {

    @Provides
    @Singleton
    fun provideOnboardingDatabaseDatabase(app: Application): OnboardingDatabase {
        return Room.databaseBuilder(
            app,
            OnboardingDatabase::class.java,
            "onboarding_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideOnboardingDatabaseRepository(db: OnboardingDatabase): OnboardingRepository {
        return OnboardingRepositoryImpl(
            userCredentialsDao = db.userCredentialsDao,
            userInfoDao = db.userInfoDao
        )
    }
}
