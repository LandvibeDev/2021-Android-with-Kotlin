## Unit2 : Layouts



### Pathway2: Display a scrollable List



* Example of statements

  ```kotlin
  val list = listOf(1, 2, 5)
  
  val oddNumbers = mutableListOf("1", "9", "15")
  
  val words: List<String> = listOf("jump", "run", "skip")
  ```

  ```kotlin
  val numbers = listOf(1, 2, 3)
  for (num in numbers) {
    println(num)
  }
  ```

* Advantage of using  RecyclerView

  - `RecyclerView` comes with built-in layout managers.

  - `RecyclerView` helps save processing time, which can help scrolling through a list smoother.

  - `RecyclerView` is designed to be efficient for lists by reusing views that have scrolled off the screen.

    

* pacakges

  * You can use packages to organize your code.
  * In order to use a class from another package, you have to explicitly import it in your code.
  * It is good practice to use packages to group classes by functionality.

  

* Resource annotations should be used to ensure that the correct type of resouce ID is passed in to a constructor.

  

* Read-only list: `List` cannot be modified after you create it.

* Mutable list: `MutableList` can be modified after you create it, meaning you can add, remove, or update its elements.

* Above all is distinctive.

