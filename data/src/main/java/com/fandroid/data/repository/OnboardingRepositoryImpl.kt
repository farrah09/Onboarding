package com.fandroid.data.repository

import com.fandroid.data.local.dao.UserCredentialsDao
import com.fandroid.data.local.dao.UserInfoDao
import com.fandroid.data.mapper.toUserCredentials
import com.fandroid.data.mapper.toUserCredentialsEntity
import com.fandroid.data.mapper.toUserInfo
import com.fandroid.data.mapper.toUserInfoEntity
import com.fandroid.domain.model.UserCredentials
import com.fandroid.domain.model.UserInfo
import com.fandroid.domain.repository.OnboardingRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class OnboardingRepositoryImpl(
    private val userCredentialsDao: UserCredentialsDao,
    private val userInfoDao: UserInfoDao
) : OnboardingRepository {

    override suspend fun insertUserInfo(userInfo: UserInfo) {
        userInfoDao.insert(userInfo.toUserInfoEntity())
    }

    override suspend fun insertUserCredentials(userCredentials: UserCredentials) {
        userCredentialsDao.insert(userCredentials.toUserCredentialsEntity())
    }

    override fun getUserInfo(): Flow<UserInfo> {
        return userInfoDao.getUserInfo().map {
            it.toUserInfo()
        }
    }

    override fun getUserCredentials(): Flow<UserCredentials> {
        return userCredentialsDao.getUserCredentials().map {
            it.toUserCredentials()
        }
    }
}
