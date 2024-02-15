package com.fandroid.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.fandroid.data.local.dao.UserCredentialsDao
import com.fandroid.data.local.dao.UserInfoDao
import com.fandroid.data.local.entity.UserCredentialsEntity
import com.fandroid.data.local.entity.UserInfoEntity

@Database(
    entities = [
        UserInfoEntity::class,
        UserCredentialsEntity::class
    ],
    version = 1
)
abstract class OnboardingDatabase : RoomDatabase() {

    abstract val userCredentialsDao: UserCredentialsDao

    abstract val userInfoDao: UserInfoDao
}
