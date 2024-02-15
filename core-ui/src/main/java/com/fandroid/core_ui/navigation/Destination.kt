package com.fandroid.core_ui.navigation

import com.fandroid.core_ui.navigation.Route.CONFIRM_PIN
import com.fandroid.core_ui.navigation.Route.CREDENTIALS
import com.fandroid.core_ui.navigation.Route.MAIN
import com.fandroid.core_ui.navigation.Route.NEW_PIN
import com.fandroid.core_ui.navigation.Route.PERSONAL_INFO
import com.fandroid.core_ui.navigation.Route.TERMS_OF_SERVICE
import com.fandroid.core_ui.navigation.Route.WELCOME

sealed class Destination(protected val route: String, vararg params: String) {
    val fullRoute: String = if (params.isEmpty()) {
        route
    } else {
        val builder = StringBuilder(route)
        params.forEach { builder.append("/{$it}") }
        builder.toString()
    }

    sealed class NoArgumentsDestination(route: String) : Destination(route) {
        operator fun invoke(): String = route
    }

    data object WelcomeScreen : NoArgumentsDestination(WELCOME)

    data object TermsOfServiceScreen : NoArgumentsDestination(TERMS_OF_SERVICE)

    data object CredentialsScreen : NoArgumentsDestination(CREDENTIALS)

    data object PersonalInfoScreen : NoArgumentsDestination(PERSONAL_INFO)

    data object NewPinScreen : NoArgumentsDestination(NEW_PIN)

    data object ConfirmPinScreen : Destination(CONFIRM_PIN, "pin") {
        const val PIN_KEY = "pin"
        operator fun invoke(pin: String): String = route.appendParams(
            PIN_KEY to pin
        )
    }

    data object MainScreen : NoArgumentsDestination(MAIN)
}

internal fun String.appendParams(vararg params: Pair<String, Any?>): String {
    val builder = StringBuilder(this)

    params.forEach {
        it.second?.toString()?.let { arg ->
            builder.append("/$arg")
        }
    }

    return builder.toString()
}
