## Unit2 : Layouts



### Pathway1: Get user input in an app: Part1



* Class inheritance

  - let you reuse code and makes your program easier to maintain
  - To child class, properties and functions of the parent class(es) are available.
  - You can define additional properties and functions that are  specific to subclasses.
  - You can override parent class members in subclasses.

* Abstract classes

  * They can be extended by subclasses and implementations can be provided for abstract members of the class.
  * They may have abstract properties or abstract functions.
  * They are not fully implemented and cannot be instantiated.

* The Constructor is  called when you create an instance of a class

* Using only ``private`` keyword to mark a property inside the current class.

* When this XML layout displays on the screen,

  ```kotlin
  <androidx.constraintlayout.widget.ConstraintLayout
      android:layout_width="match_parent"
      android:layout_height="match_parent">
      <TextView
          android:id="@+id/textViewA"
          android:layout_width="wrap_content"
          android:layout_height="wrap_content"
          android:text="A"
          app:layout_constraintStart_toStartOf="parent"
          app:layout_constraintTop_toTopOf="parent" />
      <TextView
          android:id="@+id/textViewB"
          android:layout_width="wrap_content"
          android:layout_height="wrap_content"
          android:text="B"
          app:layout_constraintEnd_toEndOf="parent"
          app:layout_constraintTop_toTopOf="parent" />
  </androidx.constraintlayout.widget.ConstraintLayout>
  ```

  * The starting edge of `TextView A` is aligned to the starting edge of the parent view

  * The tops of `TextView A` and `TextView B` are aligned to top of the parent view.

    

