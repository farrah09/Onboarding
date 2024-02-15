package com.fandroid.onboarding

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.fandroid.core_ui.ui.theme.OnboardingAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen().apply {
            setKeepOnScreenCondition {
                viewModel.loading.value
            }
        }

        setContent {
            OnboardingAppTheme {
                val navController = rememberNavController()

                NavigationEffects(

                    navigationChannel = viewModel.navigationChannel,
                    navHostController = navController

                )
                NavigatorComposable(navController, viewModel.isShowOnboarding())
            }
        }
    }
}
