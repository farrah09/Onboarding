package com.fandroid.domain.repository

import com.fandroid.domain.model.UserCredentials
import com.fandroid.domain.model.UserInfo
import kotlinx.coroutines.flow.Flow

interface OnboardingRepository {
    suspend fun insertUserInfo(userInfo: UserInfo)

    suspend fun insertUserCredentials(userCredentials: UserCredentials)
    fun getUserInfo(): Flow<UserInfo>
    fun getUserCredentials(): Flow<UserCredentials>
}
