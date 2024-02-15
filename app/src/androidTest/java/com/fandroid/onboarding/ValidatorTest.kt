package com.fandroid.onboarding

import com.fandroid.core.util.Validator
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class ValidatorTest {

    @Test
    fun testValidEmail() {
        val validEmail = "test@example.com"
        assertTrue(Validator.isValidEmail(validEmail))
    }

    @Test
    fun testInvalidEmail() {
        val invalidEmail = "invalid-email"
        assertFalse(Validator.isValidEmail(invalidEmail))
    }

    @Test
    fun testValidPhoneNumber() {
        val validPhoneNumber = "1234567890"
        assertTrue(Validator.isValidPhoneNumber(validPhoneNumber))
    }

    @Test
    fun testInvalidPhoneNumber() {
        val invalidPhoneNumber = "12345"
        assertFalse(Validator.isValidPhoneNumber(invalidPhoneNumber))
    }
}
