## Unit2 : Layouts



### Pathway2: Get user input in an app: Part 2



* Correct xml code

  ```kotlin
  1    <TextView
  2        android:layout_width="wrap_content"
  3        android:layout_height="wrap_content"
  4        android:padding="8dp"
  5        android:text="@string/title"
  6        android:textSize='18sp' />
  ```

  

* 

  - let you reuse code and makes your program easier to maintain
  - To child class, properties and functions of the parent class(es) are available.
  - You can define additional properties and functions that are  specific to subclasses.
  - You can override parent class members in subclasses.

* Gradle

  * Automated build system used by Android Studio to build apps.
  * To make it possible to install the app on a device.
  * Using app’s `build.gradle` file to configure Android-specific options for your project. 

  

* App icon

  - Adaptive icons are made up of a foreground and background layer, and an OEM mask will be applied on top of them.
  - mdpi, hdpi, xhdpi, xxhdpi, and xxxhdpi are density qualifiers for resource directories to indicates the resources of specific screen density.

  

* Changing color for your theme (sequence)

  * Modify the `themes.xml` (night) file.

  * Set the primary and secondary color theme attributes of your app theme.

  * Define the colors as color resources in the `colors.xml` file.

    

  

* Effectivitiy of  using Material Component

  * Providing widgets that follow the Material Design guidelines.
  
  * Providing default Material themes which can use easily or extend and then customize.
  
  * Quick & Beautiful
  
    

