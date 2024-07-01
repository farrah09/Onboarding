package com.fandroid.data.mapper

import com.fandroid.data.DataFixtures
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class UserMapperKtTest {
    @Test
    fun `data model with full data maps to AlbumDomainModel`() {
        // given
        val cut = DataFixtures.getUserInfoModel()

        // when
        // val domainModel = cut.toDomainModel()

        // then
    }
}
