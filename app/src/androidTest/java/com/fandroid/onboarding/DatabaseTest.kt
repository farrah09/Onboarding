package com.fandroid.onboarding

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.filters.SmallTest
import com.fandroid.data.local.OnboardingDatabase
import com.fandroid.data.local.dao.UserCredentialsDao
import com.fandroid.data.local.dao.UserInfoDao
import com.fandroid.data.local.entity.UserCredentialsEntity
import com.fandroid.data.local.entity.UserInfoEntity
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@SmallTest
class DatabaseTest {

    private lateinit var db: OnboardingDatabase

    private lateinit var userInfoDao: UserInfoDao

    private lateinit var userCredentialsDao: UserCredentialsDao

    @Before
    fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()

        db = Room.inMemoryDatabaseBuilder(context, OnboardingDatabase::class.java).build()
        userInfoDao = db.userInfoDao
        userCredentialsDao = db.userCredentialsDao
    }

    @After
    fun closeDb() {
        db.close()
    }

    @Test
    fun insertUserInfoTest() = runBlocking {
        val userInfo = UserInfoEntity(
            "First Name",
            "Last Name",
            "1234",
            1
        )

        userInfoDao.insert(userInfo)

        assertEquals(userInfoDao.getUserInfo().first().fName, userInfo.fName)
        assertEquals(userInfoDao.getUserInfo().first().lName, userInfo.lName)
        assertEquals(userInfoDao.getUserInfo().first().telephone, userInfo.telephone)
        assertEquals(userInfoDao.getUserInfo().first().id, userInfo.id)
    }

    @Test
    fun insertUserCredentialsTest() = runBlocking {
        val userCredentials = UserCredentialsEntity(
            "test@example.com",
            "12345",
            1
        )

        userCredentialsDao.insert(userCredentials)

        assertEquals(userCredentialsDao.getUserCredentials().first().email, userCredentials.email)
        assertEquals(userCredentialsDao.getUserCredentials().first().password, userCredentials.password)
        assertEquals(userCredentialsDao.getUserCredentials().first().id, userCredentials.id)
    }
}
