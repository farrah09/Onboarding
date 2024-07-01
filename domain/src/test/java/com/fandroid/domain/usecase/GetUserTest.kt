package com.fandroid.domain.usecase

import com.fandroid.domain.repository.OnboardingRepository
import io.mockk.coEvery
import kotlinx.coroutines.runBlocking
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class GetUserTest {

    private val mockAlbumRepository: OnboardingRepository = mockk()

    private val cut = GetUser(mockAlbumRepository)

    @Test
    fun `return list of albums`() {
        // given
        val albums = listOf(d.getAlbum(), DomainFixtures.getAlbum())
        coEvery { mockAlbumRepository.searchAlbum(any()) } returns Result.Success(albums)

        // when
        val actual = runBlocking { cut(null) }

        // then
        actual shouldBeEqualTo Result.Success(albums)
    }
}
