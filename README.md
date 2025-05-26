> <p style="text-align: right;">
>   🇧🇷 <a href="README.pt.md">Versão em Português</a>
> </p>

# GitHub User Explorer (Electrolux BR Interview Project)

## About This Project

This Android application was developed as part of the selection process for an Android Developer role at Electrolux BR. The initial development occurred during a 2-hour live coding session with an interviewer, followed by a 24-hour period for finalization and submission.

The core challenge was to build an app that integrates with the GitHub API to:
1.  List GitHub users.
2.  Display detailed information when a specific user is selected from the list.

## Features

*   **User Listing**: Displays a list of GitHub users fetched from the GitHub API.
*   **User Details**: Shows more detailed information for a selected user, including:
    *   Avatar/Profile Picture
    *   Name
    *   Bio
*   **Image Loading**: Efficiently loads and displays user avatars using Glide.
*   **Clean Architecture**: Structured following Clean Architecture principles to promote separation of concerns, testability, and maintainability.

## Architecture & Technologies

This project was built adhering to modern Android development best practices:

*   **Programming Language**: Kotlin
*   **Architecture**:
    *   Clean Architecture (Domain, Data, Presentation layers)
    *   MVVM (Model-View-ViewModel) for the presentation layer
*   **Dependency Injection**: Koin
*   **Networking**:
    *   Retrofit: For making API calls to the GitHub API.
    *   OkHttp: (Typically used by Retrofit for HTTP requests)
*   **Image Loading**: Glide
*   **Asynchronous Programming**: Kotlin Coroutines
*   **Data Handling**:
    *   Repository Pattern: Mediates between data sources (network, local database) and the domain layer.
    *   Use Cases: Encapsulate specific business logic.
*   **Testing**: Unit Tests using MockK

## Project Structure

The project is organized into packages reflecting the Clean Architecture layers:

*   `presentation`: Contains UI (Activities, ViewModels).
*   `domain`: Contains Use Cases (Interactors) and pure Kotlin models/entities.
*   `data`: Contains Repository implementations, API service definitions (Retrofit), data source interfaces.
*   `core`: Custom view to load images, shared utilities, and extensions.

## 📸 Screenshot
![Home](screenshots/user-list.png)
