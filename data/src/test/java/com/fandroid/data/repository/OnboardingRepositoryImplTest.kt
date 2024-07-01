package com.fandroid.data.repository

import com.fandroid.data.DataFixtures
import com.fandroid.data.local.dao.UserInfoDao
import com.fandroid.data.local.entity.UserInfoEntity
import com.fandroid.data.mapper.toUserInfoEntity
import io.mockk.mockk
import org.amshove.kluent.shouldBeEqualTo
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class OnboardingRepositoryImplTest {

    private lateinit var repository: OnboardingRepositoryImpl
    private lateinit var dao: UserInfoDao

    @Before
    fun setUp() {
        repository = OnboardingRepositoryImpl(
            userCredentialsDao = mockk(relaxed = true),
            userInfoDao = mockk(relaxed = true),
        )
    }

    @Test
    fun `data model with full data maps to UserInfoEntity`() {
        // given
        val cut = DataFixtures.getUserInfoModel()

        // when
        val domainModel = cut.toUserInfoEntity()

        // then
        domainModel shouldBeEqualTo UserInfoEntity(
            cut.fName,
            cut.lName,
            cut.telephone,
            1,
        )
    }
}
