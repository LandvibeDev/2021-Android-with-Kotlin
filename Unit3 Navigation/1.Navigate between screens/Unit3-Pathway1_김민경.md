## Unit3 : Navigation



### Pathway2: Navigate between screens



* ```kotlin
  val cities = listOf("Jeddah", "Bengaluru", "Shenzhen", "Abu Dhabi", "Mountain View", "Tripoli", "Bengaluru", "Lima", "Mandalay", "Tripoli")
  val oneWordCities = cities.toSet().toList().filter { !it.contains(" ")}.sorted()
  ```

  result of oneWordCities(1) = Jeddah

  

* Order of activity lifecycle method if you open an app, and then leave the app

  * ```
    onCreate(), onStart(), onStop(), onDestroy()
    ```

  

*  If a dialog appears onscreen and then partially obscuring an activity, ` onPause()`  method would be called because the activity is still displayed, but no longer has focus

*  When a button in the app bar is pressed, `onOptionsItemSelected()` method should be handled.

  

* An activity contains following code in onCreate() and if intent is null, the app will crash because it attempted to access the extras property on a null object.

* ```kotlin
  val message = intent.extras?.getString("message").toString()
  ```

  

* Intent

  - Both implicit and explicit intents allow your app to launch another activity.
  - Explicit intents require you to specify the class of the activity you want to show.
  - Intents are performed using the `startActivity()` method.

  

* Higher order functions and Collections

  - Lists, maps, and sets can all use higher order functions.

  - Like the elements in a set, the keys in a map must be unique. However, multiple keys can map to the same value.

  - Higher order functions such as map and filter can take lambda functions as parameters.

    

* Lifecycle of single Activity of method.

  - `onStart()` can be called multiple times, while `onCreate()` can only be called once.
  - `onResume()` is called when the activity gains focus.
  -  `onCreate()` is being operated,
    - Configuring views, such as setting the layout manager of a recycler view.
    - Getting extras from the intent that launched the activity.
