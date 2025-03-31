# Code Sample for Fueled+ 10up 

A simple app that presents a list of different beers from all over the world. 

## Installation

Android 7 SDK Level 24 (Nougat) or higher.

## Explanation

- UI Composition using Jetpack Compose + Coil + Paging3
  - MVVM/MVI architectural pattern to expose beer flow, manage configuration changes, and handle user actions
  - MainUiState to keep track of UI state and actions
  - LazyColumn presents beer results
  - Pagination to control data retrieval and handle list state changes
- Data Persistence using Room
  - Caching data to local storage for offline support
- Networking Integration using Retrofit + Gson Converter + OkHttp
  - Collecting and parsing the data stream
  - Asynchronous operations with Coroutines + Flow to optimize performance
  - Monitor network traffic
- Dependency Injection using Hilt
  - Hide implementation details, decrease coupling, increase testability
- Clean architecture using SOLID principles
