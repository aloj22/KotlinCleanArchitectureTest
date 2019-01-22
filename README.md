# NinetyNineTest

This project was developed as a solution for [NinetyNine test](https://github.com/99markets/challenges/blob/master/mobile.md). It is written using kotlin and based on Clean Architecture.


## Architecture
![alt text](https://i.imgur.com/GSilkxa.png)

- **Views**: Interacts with the UI system and sends events to the presenter (e.g. A button was clicked).
- **Presenter**: Receives events from the view, call UseCases to perform actions and control what is displayed on the view.
- **UseCase**: Performs a single action using a repository, it is in charge of using background thread and process data if needed before passing it to the presenter.
- **Repository**: Uses one or more sources to get or store data.
- **Source**: Interfaces that should be implemented in every platform, implementations will perform an action that depends on the platform framework like access a database or make an api call.

Views and sources must be implemented in a different way for every platform we want the app running into (Android, iOS, web...). Others component don't depend on platform, which allows to reuse code and have same logic.


## App modules
Code is divided in different packages depending on functionality.

- **presentation**: Contains presenter and views interfaces.
- **data**: Contains use cases, repositories and sources interfaces.
- **domain**: Contains business models.
- **app**: Contains the Android implementation for views and sources.



## Libraries
These external libraries were used:
- **Retrofit**: HTTP client.
- **Koin**: Dependency injection.
- **Coroutines**: Asynchronous execution.
