package com.fandroid.onboarding

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import com.fandroid.core_ui.navigation.Destination
import com.fandroid.core_ui.navigation.NavHost
import com.fandroid.core_ui.navigation.NavigationIntent
import com.fandroid.core_ui.navigation.composable
import com.fandroid.main.main.MainScreen
import com.fandroid.onboarding.confirmPin.ConfirmPinScreen
import com.fandroid.onboarding.credentials.CredentialsScreen
import com.fandroid.onboarding.personalInfo.PersonalInfoScreen
import com.fandroid.onboarding.termsOfService.TermsOfServiceScreen
import com.fandroid.onboarding.welcome.WelcomeScreen
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

@Composable
fun NavigatorComposable(navController: NavHostController, showOnboarding: Boolean) {
    NavHost(

        navController = navController,
        startDestination = if (showOnboarding) Destination.WelcomeScreen else Destination.MainScreen

    ) {
        composable(destination = Destination.WelcomeScreen) {
            WelcomeScreen()
        }

        composable(destination = Destination.TermsOfServiceScreen) {
            TermsOfServiceScreen()
        }

        composable(destination = Destination.CredentialsScreen) {
            CredentialsScreen()
        }

        composable(destination = Destination.PersonalInfoScreen) {
            PersonalInfoScreen()
        }

        composable(destination = Destination.NewPinScreen) {
            com.fandroid.onboarding.newPin.NewPinScreen()
        }

        composable(destination = Destination.ConfirmPinScreen) {
            ConfirmPinScreen()
        }

        composable(destination = Destination.MainScreen) {
            MainScreen()
        }
    }
}

@Composable
fun NavigationEffects(navigationChannel: Channel<NavigationIntent>, navHostController: NavHostController) {
    val activity = (LocalContext.current as? Activity)

    LaunchedEffect(activity, navHostController, navigationChannel) {
        navigationChannel.receiveAsFlow().collect { intent ->

            if (activity?.isFinishing == true) {
                return@collect
            }

            when (intent) {
                is NavigationIntent.NavigateBack -> {
                    if (intent.route != null) {
                        navHostController.popBackStack(intent.route!!, intent.inclusive)
                    } else {
                        navHostController.popBackStack()
                    }
                }

                is NavigationIntent.NavigateTo -> {
                    navHostController.navigate(intent.route) {
                        launchSingleTop = intent.isSingleTop
                        intent.popUpToRoute?.let { popUpToRoute ->
                            popUpTo(popUpToRoute) { inclusive = intent.inclusive }
                        }
                    }
                }
            }
        }
    }
}
