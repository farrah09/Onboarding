# Onboarding 

Welcome to Onboarding, a modern and feature-rich Android application designed to provide a seamless and engaging user experience.

## Table of Contents

1. [Overview](#overview)
2. [Tech Stack](#tech-stack)
3. [Features](#features)
4. [Getting Started](#getting-started)
5. [Project Structure](#project-structure)
6. [Running Tests](#running-tests)
7. [Contributing](#contributing)
8. [License](#license)

## Overview

Your App Name is built using cutting-edge technologies, incorporating Jetpack Compose, Room, Coroutines, Kotlin, Shared Preferences, Modular and Clean Architecture, Hilt, Navigation with Animation, and Unit Testing. The app emphasizes animations for navigation, robust email and password validations, and ensures data persistence on back navigation.

## Tech Stack

1. **Jetpack Compose**: Declarative UI framework for building modern interfaces.
2. **Room**: Local database for secure and efficient data storage and retrieval.
3. **Coroutines**: Manage asynchronous operations for smooth user interactions.
4. **Kotlin**: Concise and expressive language enhancing code readability.
5. **Shared Preferences**: Persist critical app states such as onboarding decisions.
6. **Modular Architecture**: Promotes scalability, maintainability, and separation of concerns.
7. **Clean Architecture**: Clear separation of business logic, presentation, and data layers.
8. **Hilt**: Efficient dependency injection for a clean and maintainable codebase.
9. **Navigation with Animation**: Enhance user experience with smooth animations.
10. **Unit Testing**: Comprehensive tests for email and phone validation and OnboardingDatabase functionality.

## Features

1. **WelcomeScreen() or MainScreen()**: Initial screen determined by the `should-show-onboard` key from Shared Preferences.
2. **WelcomeScreen() to TermAndConditionScreen()**: Users proceed to TermAndConditionScreen() based on actions taken on the WelcomeScreen().
3. **TermAndConditionScreen() to CredentialsScreen()**: Move to CredentialsScreen() after checking the checkbox on TermAndConditionScreen().
4. **CredentialsScreen() Validation and Room DB**: Proceed only if email and password fields are non-empty and email is valid. User credentials saved to Room database.
5. **PersonalInfoScreen() Validation and Room DB**: Proceed only if firstname, last name, and telephone fields are non-empty and telephone number is valid. User information saved to Room database.
6. **NewPinScreen() to ConfirmPinScreen()**: Insert pin on NewPinScreen(), pass pin as navigation parameter, and proceed after confirming on ConfirmPinScreen().
7. **MainScreen() and Sign Out**: Clear previous backstackEntry, set `shouldShowOnboarding` to false, display user information, and sign out functionality.

## Video Reference

Watch the app in action to experience both light and dark modes:

- **Light Mode**: [Watch Light Mode Video](https://youtu.be/kcssXjRKDeE?si=fADc11GNnnA4o0Dt)
- **Dark Mode**: [Watch Dark Mode Video](https://youtu.be/_PpeWIHqnRA?si=uONGbwTsP99Wnknr)


## Getting Started

Follow these steps to set up the project locally:

1. Clone the repository:

   ```bash
   git clone https://github.com/farrah09/Onboarding.git

1. Open the project in Android Studio.
2. Build and run the app on an emulator or a physical device.

## Project Structure

The project follows a modular and clean architecture. Key modules include:

app: Main application code.
data: Manages data-related operations, including Room database interactions.
domain: Defines use cases and business logic.
features: Implements the UI using Jetpack Compose.
Running Tests

To run unit tests, use the following command:

    ```bash
     ./gradlew test

**Happy coding! 🚀
