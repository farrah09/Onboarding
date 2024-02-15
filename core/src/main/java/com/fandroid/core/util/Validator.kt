package com.fandroid.core.util

import android.util.Patterns

class Validator {
    companion object {
        fun isValidEmail(email: String): Boolean {
            return Patterns.EMAIL_ADDRESS.matcher(email).matches()
        }

        fun isValidPhoneNumber(phoneNumber: String): Boolean {
            return phoneNumber.length == 10
        }
    }
}
