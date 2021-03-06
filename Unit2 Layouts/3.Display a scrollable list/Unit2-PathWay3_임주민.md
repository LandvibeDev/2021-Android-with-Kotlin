# π‘ Android Basics in Kotlin

## Unit #2 : Layouts

## PATHWAY #3 : Display a scrollable list

<br/>



## π©π»βπ» λͺ©λ‘μ¬μ©

- `List` : λ§λ  ν μμ  λΆκ°λ₯ `listOf()`

- `MutableList` : λ§λ  ν μμ  κ°λ₯(μΆκ°, μ­μ , μλ°μ΄νΈ)  `mutableListOf()`

- λΉ λͺ©λ‘μ μ΄κΈ°ν ν  λ μμ μ νμ λͺμμ μΌλ‘ μ§μ ν΄μΌν¨

  ```kotlin
  fun main() {
      val numbers = listOf(1, 2, 3, 4, 5, 6)
      println("List: $numbers")        //List: [1, 2, 3, 4, 5, 6]
      println("Size: ${numbers.size}") 
  
      // λ¦¬μ€νΈ μμ μ κ·Ό
      println("First element: ${numbers[0]}")
      println("Second element: ${numbers[1]}")
      println("Last index: ${numbers.size - 1}")
      println("Last element: ${numbers[numbers.size - 1]}")
      println("First: ${numbers.first()}")
      println("Last: ${numbers.last()}")
  
      // contains() μ¬μ©
      println("Contains 4? ${numbers.contains(4)}") //true
      println("Contains 7? ${numbers.contains(7)}") //false
    	
    	// μ λͺ©λ‘ λ°ν(λ³κ²½ X)
    	println("Reversed list: ${numbers.reversed()}")
    	println("Sorted list: ${numbers.sorted()}")
  }
  ```

  ```kotlin
  fun main() {
      val entrees = mutableListOf<String>()
      println("Entrees: $entrees")
  
      // add()λ‘ μμ μΆκ°
      println("Add noodles: ${entrees.add("noodles")}")
      println("Add spaghetti: ${entrees.add("spaghetti")}")
  
      // addAll()λ‘ λ¦¬μ€νΈ μΆκ°
      val moreItems = listOf("ravioli", "lasagna", "fettuccine")
      println("Add list: ${entrees.addAll(moreItems)}")
  
      // remove()λ‘ μ­μ 
      println("Remove spaghetti: ${entrees.remove("spaghetti")}")
      println("Remove item that doesn't exist: ${entrees.remove("rice")}")
  
      // removeAt()μΌλ‘ ν΄λΉ μΈλ±μ€ μμ μ­μ 
      println("Remove first element: ${entrees.removeAt(0)}")
  
      // λͺ¨λ μ­μ 
      entrees.clear()
  
      // λΉμ΄μλμ§ νμΈ
      println("Empty? ${entrees.isEmpty()}")
  }
  ```

  <br/>

##### π λͺ©λ‘ λ°λ³΅

* while

  ```kotlin
  val guestsPerFamily = listOf(2, 4, 1, 3)
  var totalGuests = 0
  var index = 0
  while (index < guestsPerFamily.size) {
      totalGuests += guestsPerFamily[index]
      index++
  }
  println("Total Guest Count: $totalGuests")
  ```

* for

  ```kotlin
  for (item in list) print(item) // λ¦¬μ€νΈ
  for (item in 'b'..'g') print(item) // μνλ²³λ²μ
  for (item in 1..5) print(item) // μ«μλ²μ
  for (item in 5 downTo 1) print(item) // μ­μμΌλ‘
  for (item in 3..6 step 2) print(item) // 3λΆν° 6κΉμ§ 2μ© κ±΄λλ. Prints: 35
  ```

* `varag` : λμΌν μ νμ κ°λ³μ μΈ μΈμ μλ₯Ό ν¨μλ μμ±μμ μ λ¬κ°λ₯.

  ```kotlin
  class Vegetables(vararg val toppings: String) : Item("Vegetables", 5) {
  }
  ```

  

<br/>



## π©π»βπ» RecyclerView - μ€ν¬λ‘€ κ°λ₯ν λͺ©λ‘ νμ

##### π νμΌ μμ± νΉμ μμ 

* `res/values/strings.xml`

  ```xml
  <resources>
      <string name="app_name">Affirmations</string>
      <string name="affirmation1">I am strong.</string>
      <string name="affirmation2">I believe in myself.</string>
      <string name="affirmation3">Each day is a new opportunity to grow and be a better version of myself.</string>
      <string name="affirmation4">Every challenge in my life is an opportunity to learn from.</string>
      <string name="affirmation5">I have so much to be grateful for.</string>
      <string name="affirmation6">Good things are always coming into my life.</string>
      <string name="affirmation7">New opportunities await me at every turn.</string>
      <string name="affirmation8">I have the courage to follow my heart.</string>
      <string name="affirmation9">Things will unfold at precisely the right time.</string>
      <string name="affirmation10">I will be present in all the moments that this day brings.</string>
  </resources>
  ```

* `affirmations/data/Datasource.kt`

  ```kotlin
  package com.example.affirmations.data
  
  import com.example.affirmations.R
  import com.example.affirmations.model.Affirmation
  
  class Datasource {
  
      fun loadAffirmations(): List<Affirmation> {
          return listOf<Affirmation>(
              Affirmation(R.string.affirmation1),
              Affirmation(R.string.affirmation2),
              Affirmation(R.string.affirmation3),
              Affirmation(R.string.affirmation4),
              Affirmation(R.string.affirmation5),
              Affirmation(R.string.affirmation6),
              Affirmation(R.string.affirmation7),
              Affirmation(R.string.affirmation8),
              Affirmation(R.string.affirmation9),
              Affirmation(R.string.affirmation10)
          )
      }
  }
  ```

* `affirmations/model/Affirmation.kt`

  ```kotlin
  package com.example.affirmations.model
  
  data class Affirmation(val stringResourceId: Int)
  ```

* `src/main/res/layout/list_item.xml`

  ```xml
  <?xml version="1.0" encoding="utf-8"?>
  <TextView xmlns:android="http://schemas.android.com/apk/res/android"
      android:id="@+id/item_title"
      android:layout_width="wrap_content"
      android:layout_height="wrap_content" />
  ```

<br/>

##### π μ±μ RecyclerView μΆκ°

* μ©μ΄
  * **item** - νμν  λͺ©λ‘μ λ¨μΌ λ°μ΄ν° ν­λͺ©. μ±μ `Affirmation` κ°μ²΄ νλλ₯Ό λνλ.
  * **adpater** - `RecyclerView`μμ νμν  μ μλλ‘ λ°μ΄ν°λ₯Ό κ°μ Έμ μ€λΉν¨.
  * **ViewHolder** - νμΈμ νμνκΈ° μν΄ μ¬μ©νκ±°λ μ¬μ¬μ©ν  `RecyclerView`μ© λ·°μ ν.
  * **RecyclerView** - νλ©΄μ νμλλ λ·°. μμ ―μ μ¬μ©νμ¬ λ°μ΄ν° λͺ©λ‘μ νμν¨. μ΄λν° ν¨ν΄μ μ¬μ©νμ¬ λ°μ΄ν° μ‘°μ νκ³  νμν¨

* `FrameLayout` μΆκ°

  ```xml
  <?xml version="1.0" encoding="utf-8"?>
  <FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
      xmlns:app="http://schemas.android.com/apk/res-auto"
      xmlns:tools="http://schemas.android.com/tools"
      android:layout_width="match_parent"
      android:layout_height="match_parent"
      tools:context=".MainActivity">
  
      <androidx.recyclerview.widget.RecyclerView
          android:id="@+id/recycler_view"
          android:layout_width="match_parent"
          android:layout_height="match_parent"
          app:layoutManager="LinearLayoutManager"
          android:scrollbars="vertical"/>
  </FrameLayout>
  ```

* μ΄λν° κ΅¬ν

  ```kotlin
  package com.example.affirmations.adapter
  
  // Adapter for the [RecyclerView] in [MainActivity]. Displays [Affirmation] data object.
  // μ΄λν°μ μ ν΄λμ€ μμ±
  class ItemAdapter (private val context: Context, private val dataset: List<Affirmation>)
      : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>(){
      
    	// λ¨μΌ λͺ©λ‘ ν­λͺ© λ·°λ₯Ό λ΄νλ΄λ ViewHolderν΄λμ€
      class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
          val textView: TextView = view.findViewById(R.id.item_title)
      }
      
      // λ©μλ 1 : μλ‘μ΄ λ·° νλ μμ± (λ μ΄μμ κ΄λ¦¬μκ° νΈμΆ)
      override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
          // μλ‘μ΄ view μμ±
        	val adapterLayout = LayoutInflater.from(parent.context)
              .inflate(R.layout.list_item,parent,false)
          return ItemViewHolder(adapterLayout)
      }
  		
      // λ©μλ 2 : λͺ©λ‘ ν­λͺ© λ·°μ μ½νμΈ  λ°κΏ (λ μ΄μμ κ΄λ¦¬μκ° νΈμΆ)
      override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
          val item = dataset[position]
          holder.textView.text =  context.resources.getString(item.stringResourceId)
      }
  
      // λ©μλ 3 : λ°μ΄ν° μΈνΈμ ν¬κΈ° λ°ν (λ μ΄μμ κ΄λ¦¬μκ° νΈμΆ)
     override fun getItemCount(): Int {
          return dataset.size
      }
  }
  ```

* `MainActivity.kt` μμ  - μ΄λν° μ¬μ©νλλ‘ `RecyclerView`μ μλ¦Ό

  ```kotlin
  class MainActivity : AppCompatActivity() {
      override fun onCreate(savedInstanceState: Bundle?) {
          super.onCreate(savedInstanceState)
          setContentView(R.layout.activity_main)
          
        	// λ°μ΄ν° μ΄κΈ°ν
        	val myDataset = Datasource().loadAffirmations()
        
          val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
          recyclerView.adapter = ItemAdapter(this, myDataset)
  				
        	// λ΄μ©λ³κ²½μΌλ‘ RecyclerViewμ λ μ΄μμ ν¬κΈ°κ° λ³κ²½λμ§ μλ κ²½μ°, 
        	// μ΄ μ€μ μ μ¬μ©νμ¬ μ±λ₯μ ν₯μμν΄.
          recyclerView.setHasFixedSize(true)
      }
  }
  ```

  

<br/>



<br/>



## π©π»βπ» μΉ΄λ μ¬μ©νμ¬ μ΄λ―Έμ§ λͺ©λ‘ νμ

##### π λ¦¬μμ€ μ£Όμ μ¬μ©

* `@` κΈ°νΈλ‘ μ μΈ

  ```kotlin
  data class Affirmation(
     @StringRes val stringResourceId: Int,
     @DrawableRes val imageResourceId: Int
  ) { }
  ```

<br/>



##### π λͺ©λ‘ ν­λͺ© λ μ΄μμμ ImageViewμΆκ°

* `res > layout > list_item.xml` LinearLayout μΆκ°

  ```xml
  <?xml version="1.0" encoding="utf-8"?>
  <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
      android:layout_width="match_parent"
      android:layout_height="wrap_content"
      android:orientation="vertical">
  		 <ImageView
          android:layout_width="match_parent"
          android:layout_height="194dp"
          android:id="@+id/item_image"
          android:importantForAccessibility="no"
          android:scaleType="centerCrop" />
      <TextView
          android:id="@+id/item_title"
          android:layout_width="wrap_content"
          android:layout_height="wrap_content" />
  
  </LinearLayout>
  ```

* ```kotlin
  class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
      val textView: TextView = view.findViewById(R.id.item_title)
      // findViewById()λ₯Ό μ¬μ©νμ¬ IDκ° item_imageμΈ ImageViewμ λν 
      // μ°Έμ‘°λ₯Ό μ°Ύμ μ΄λ₯Ό imageView μμ±μ ν λΉ
  		val imageView: ImageView = view.findViewById(R.id.item_image)
  }
  ```

* κΈμ μ  λ¬Έκ΅¬ ν­λͺ©μ imageResourceIdλ₯Ό λͺ©λ‘ ν­λͺ© λ·°μ ImageViewλ‘ μ€μ 

  ```kotlin
   override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
          val item = dataset[position]
          holder.textView.text = context.resources.getString(item.stringResourceId)
          holder.imageView.setImageResource(item.imageResourceId)
      }
  ```

<br/>



##### π UI μμ 

* padding μΆκ° = LinearLayoutκ³Ό TextViewμ κ°κ° μΆκ°

  ```xml
  android:padding="16dp"
  ```

* μΉ΄λ μ¬μ© - `MaterialCardView`

  ```xml
  <com.google.android.material.card.MaterialCardView 		xmlns:android="http://schemas.android.com/apk/res/android"
      android:layout_width="match_parent"
      android:layout_height="wrap_content"
      android:layout_margin="8dp">
      
  </com.google.android.material.card.MaterialCardView >
  ```

* μ± νλ§ μμ λ³κ²½

  * colors.xmlμ μμ μΆκ°

    ```xml
    <color name="blue_200">#FF90CAF9</color>
    <color name="blue_500">#FF2196F3</color>
    <color name="blue_700">#FF1976D2</color>
    ```

  * themes.xml μμ 

<br/>

<br/>

------



## π©π»βπ» ν΄μ¦



1. Before running the below code, simpleList should be initialized as a [            ] list.

   ```kotlin
   println(simpleList)
   simpleList.add(-5)
   simpleList.remove(4)
   println(simpleList)
   ```

   * Mutable

2. Which of the following statements are valid?
   * `val list = listOf(1, 2, 5)`
   * `val oddNumbers = mutableListOf("1", "9", "15")`
   * `val words: List<String> = listOf("jump", "run", "skip")`
3. Why does a `RecyclerView` need an Adapter?
   * To create new `ViewHolders` and bind data to them
4. Which of the following are advantages to using `RecyclerView`?
   * `RecyclerView` comes with built-in layout managers.
   * `RecyclerView` helps save processing time, which can help scrolling through a list smoother.
   * `RecyclerView` is designed to be efficient for lists by reusing views that have scrolled off the screen

5. Which of the following is true about packages?

   * You can use packages to organize your code.
   * It is good practice to use packages to group classes by functionality.
   * In order to use a class from another package, you have to explicitly import it in your code.

6. What should you do to ensure that the correct type of resource ID is passed in to a constructor?

   * Use resource annotations.

7. In the below code, should be written in the for loop, so that the output returned is the list of numbers 1 through 3, with each number printed on a new line.

   ```
   val numbers = listOf(1, 2, 3)
   for (_______) {
     println(num)
   }
   ```

   * num in numbers

