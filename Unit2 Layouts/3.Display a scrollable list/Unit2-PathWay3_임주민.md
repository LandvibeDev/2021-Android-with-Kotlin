# 💡 Android Basics in Kotlin

## Unit #2 : Layouts

## PATHWAY #3 : Display a scrollable list

<br/>



## 👩🏻‍💻 목록사용

- `List` : 만든 후 수정 불가능 `listOf()`

- `MutableList` : 만든 후 수정 가능(추가, 삭제, 업데이트)  `mutableListOf()`

- 빈 목록을 초기화 할 때 요소 유형을 명시적으로 지정해야함

  ```kotlin
  fun main() {
      val numbers = listOf(1, 2, 3, 4, 5, 6)
      println("List: $numbers")        //List: [1, 2, 3, 4, 5, 6]
      println("Size: ${numbers.size}") 
  
      // 리스트 요소 접근
      println("First element: ${numbers[0]}")
      println("Second element: ${numbers[1]}")
      println("Last index: ${numbers.size - 1}")
      println("Last element: ${numbers[numbers.size - 1]}")
      println("First: ${numbers.first()}")
      println("Last: ${numbers.last()}")
  
      // contains() 사용
      println("Contains 4? ${numbers.contains(4)}") //true
      println("Contains 7? ${numbers.contains(7)}") //false
    	
    	// 새 목록 반환(변경 X)
    	println("Reversed list: ${numbers.reversed()}")
    	println("Sorted list: ${numbers.sorted()}")
  }
  ```

  ```kotlin
  fun main() {
      val entrees = mutableListOf<String>()
      println("Entrees: $entrees")
  
      // add()로 요소 추가
      println("Add noodles: ${entrees.add("noodles")}")
      println("Add spaghetti: ${entrees.add("spaghetti")}")
  
      // addAll()로 리스트 추가
      val moreItems = listOf("ravioli", "lasagna", "fettuccine")
      println("Add list: ${entrees.addAll(moreItems)}")
  
      // remove()로 삭제
      println("Remove spaghetti: ${entrees.remove("spaghetti")}")
      println("Remove item that doesn't exist: ${entrees.remove("rice")}")
  
      // removeAt()으로 해당 인덱스 요소 삭제
      println("Remove first element: ${entrees.removeAt(0)}")
  
      // 모두 삭제
      entrees.clear()
  
      // 비어있는지 확인
      println("Empty? ${entrees.isEmpty()}")
  }
  ```

  <br/>

##### 👉 목록 반복

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
  for (item in list) print(item) // 리스트
  for (item in 'b'..'g') print(item) // 알파벳범위
  for (item in 1..5) print(item) // 숫자범위
  for (item in 5 downTo 1) print(item) // 역순으로
  for (item in 3..6 step 2) print(item) // 3부터 6까지 2씩 건너뜀. Prints: 35
  ```

* `varag` : 동일한 유형의 가변적인 인수 수를 함수나 생성자에 전달가능.

  ```kotlin
  class Vegetables(vararg val toppings: String) : Item("Vegetables", 5) {
  }
  ```

  

<br/>



## 👩🏻‍💻 RecyclerView - 스크롤 가능한 목록 표시

##### 👉 파일 생성 혹은 수정

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

##### 👉 앱에 RecyclerView 추가

* 용어
  * **item** - 표시할 목록의 단일 데이터 항목. 앱의 `Affirmation` 객체 하나를 나타냄.
  * **adpater** - `RecyclerView`에서 표시할 수 있도록 데이터를 가져와 준비함.
  * **ViewHolder** - 확인을 표시하기 위해 사용하거나 재사용할 `RecyclerView`용 뷰의 풀.
  * **RecyclerView** - 화면에 표시되는 뷰. 위젯을 사용하여 데이터 목록을 표시함. 어댑터 패턴을 사용하여 데이터 조정하고 표시함

* `FrameLayout` 추가

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

* 어댑터 구현

  ```kotlin
  package com.example.affirmations.adapter
  
  // Adapter for the [RecyclerView] in [MainActivity]. Displays [Affirmation] data object.
  // 어댑터의 새 클래스 생성
  class ItemAdapter (private val context: Context, private val dataset: List<Affirmation>)
      : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>(){
      
    	// 단일 목록 항목 뷰를 내타내는 ViewHolder클래스
      class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
          val textView: TextView = view.findViewById(R.id.item_title)
      }
      
      // 메서드 1 : 새로운 뷰 홀더 생성 (레이아웃 관리자가 호출)
      override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
          // 새로운 view 생성
        	val adapterLayout = LayoutInflater.from(parent.context)
              .inflate(R.layout.list_item,parent,false)
          return ItemViewHolder(adapterLayout)
      }
  		
      // 메서드 2 : 목록 항목 뷰의 콘텐츠 바꿈 (레이아웃 관리자가 호출)
      override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
          val item = dataset[position]
          holder.textView.text =  context.resources.getString(item.stringResourceId)
      }
  
      // 메서드 3 : 데이터 세트의 크기 반환 (레이아웃 관리자가 호출)
     override fun getItemCount(): Int {
          return dataset.size
      }
  }
  ```

* `MainActivity.kt` 수정 - 어댑터 사용하도록 `RecyclerView`에 알림

  ```kotlin
  class MainActivity : AppCompatActivity() {
      override fun onCreate(savedInstanceState: Bundle?) {
          super.onCreate(savedInstanceState)
          setContentView(R.layout.activity_main)
          
        	// 데이터 초기화
        	val myDataset = Datasource().loadAffirmations()
        
          val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
          recyclerView.adapter = ItemAdapter(this, myDataset)
  				
        	// 내용변경으로 RecyclerView의 레이아웃 크기가 변경되지 않는 경우, 
        	// 이 설정을 사용하여 성능을 향상시킴.
          recyclerView.setHasFixedSize(true)
      }
  }
  ```

  

<br/>



<br/>



## 👩🏻‍💻 카드 사용하여 이미지 목록 표시

##### 👉 리소스 주석 사용

* `@` 기호로 선언

  ```kotlin
  data class Affirmation(
     @StringRes val stringResourceId: Int,
     @DrawableRes val imageResourceId: Int
  ) { }
  ```

<br/>



##### 👉 목록 항목 레이아웃에 ImageView추가

* `res > layout > list_item.xml` LinearLayout 추가

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
      // findViewById()를 사용하여 ID가 item_image인 ImageView에 대한 
      // 참조를 찾아 이를 imageView 속성에 할당
  		val imageView: ImageView = view.findViewById(R.id.item_image)
  }
  ```

* 긍정적 문구 항목의 imageResourceId를 목록 항목 뷰의 ImageView로 설정

  ```kotlin
   override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
          val item = dataset[position]
          holder.textView.text = context.resources.getString(item.stringResourceId)
          holder.imageView.setImageResource(item.imageResourceId)
      }
  ```

<br/>



##### 👉 UI 수정

* padding 추가 = LinearLayout과 TextView에 각각 추가

  ```xml
  android:padding="16dp"
  ```

* 카드 사용 - `MaterialCardView`

  ```xml
  <com.google.android.material.card.MaterialCardView 		xmlns:android="http://schemas.android.com/apk/res/android"
      android:layout_width="match_parent"
      android:layout_height="wrap_content"
      android:layout_margin="8dp">
      
  </com.google.android.material.card.MaterialCardView >
  ```

* 앱 테마 색상 변경

  * colors.xml에 색상 추가

    ```xml
    <color name="blue_200">#FF90CAF9</color>
    <color name="blue_500">#FF2196F3</color>
    <color name="blue_700">#FF1976D2</color>
    ```

  * themes.xml 수정

<br/>

<br/>

------



## 👩🏻‍💻 퀴즈



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

