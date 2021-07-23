# 2021 Landvibe Summer Coding - Android



## Unit2 : Layouts

## PathWay3 : Display a scrollable list



### Kotlin에서 목록 사용

* `List`

  * 읽기 전용 목록

  * 수정 불가

    ```kotlin
    fun main() {
        val numbers : List<Int> = listOf(1, 2, 3, 4, 5, 6)
        println("List : $numbers")
        println("Size : ${numbers.size}")
        
        //Access elements of the list
        println("First element : ${numbers[0]}")
        println("Last index : ${numbers.size - 1}")
        println("Last element : ${numbers[numbers.size - 1]}")
        println("First : ${numbers.first()}")
        println("Last : ${numbers.last()}")
        
        //Use the contains() method
        println("Contains 4? ${numbers.contains(4)}")
        println("Contains 7? ${numbers.contains(7)}")
    }
    ```

    ```kotlin
    fun main() {
        val colors = listOf("green", "orange", "blue")
        //colors.add("purple") //읽기 전용이므로 에러 발생
        //colors[0] = "yellow" //읽기 전용이므로 에러 발생
        
        println("Reversed list : ${colors.reversed()}")
        println("List : $colors")
        println("Sorted list : ${colors.sorted()}")	//오름차순 정렬
    }
    ```

    

* `MutableList`

  * 변경 가능한 목록

  * 수정 가능 

  * 요소 추가, 삭제, 업데이트 가능

    ```kotlin
    fun main() {
        //빈 목록을 초기화하려면 유형을 명시적으로 표시해야 함.
        val entrees = mutableListOf<String>()	
        println("Entrees: $entrees")
    
        // Add individual items using add()
        println("Add noodles: ${entrees.add("noodles")}")	//True or false로 Return
        println("Entrees: $entrees")
        println("Add spaghetti: ${entrees.add("spaghetti")}")
        println("Entrees: $entrees")
    
        // Add a list of items using addAll()
        val moreItems = listOf("ravioli", "lasagna", "fettuccine")
        println("Add list: ${entrees.addAll(moreItems)}")
        println("Entrees: $entrees")
    
        // Remove an item using remove()
        println("Remove spaghetti: ${entrees.remove("spaghetti")}")
        println("Entrees: $entrees")
        println("Remove item that doesn't exist: ${entrees.remove("rice")}")
        println("Entrees: $entrees")
    
        // Remove an item using removeAt() with an index
        println("Remove first element: ${entrees.removeAt(0)}")
        println("Entrees: $entrees")
    
        // Clear out the list
        entrees.clear()
        println("Entrees: $entrees")
    
        // Check if the list is empty
        println("Empty? ${entrees.isEmpty()}")
    }
    ```

* While 루프

  ```kotlin
  while(expression){
  	//While the expression is true, execute this code block
  }
  ```

  ```kotlin
  fun main() {
      val guestPerFamily = listOf(2, 4, 1, 3)
      var totalGuests = 0
      var index = 0
      
      while(index < guestPerFamily.size){
          totalGuests += guestPerFamily[index]
          index++
      }
      println("Total Guest Count : $totalGuests")
  }
  ```

* for 루프

  ```kotlin
  for(number in numberList){
  	//For each element in the list, execute this code block
  }
  ```

  ```kotlin
  fun main() {
      val names = listOf("Jessica", "Henry", "Alicia", "Jose")
      
      for(name in names){
          println(name)
          println("$name - Number of characters : ${name.length}")
      }
  }
  ```

* 예시 코드

  ```kotlin
  open class Item(val name: String, val price: Int)
  
  class Noodles : Item("Noodles", 10) {
      override fun toString(): String {
          return name
      }
  }
  
  //vararg : 가변적인 인수 수를 함수나 생성자에 전달할 수 있음
  class Vegetables(vararg val toppings: String) : Item("Vegetables", 5) {
      override fun toString(): String {
          if (toppings.isEmpty()) {
              return "$name Chef's Choice"
          } else {
              return name + " " + toppings.joinToString()
          }
      }
  }
  
  class Order(val orderNumber: Int) {
      private val itemList = mutableListOf<Item>()
  
      fun addItem(newItem: Item): Order {
          itemList.add(newItem)
          return this
      }
  
      fun addAll(newItems: List<Item>): Order {
          itemList.addAll(newItems)
          return this
      }
  
      fun print() {
          println("Order #${orderNumber}")
          var total = 0
          for (item in itemList) {
              println("${item}: $${item.price}")
              total += item.price
          }
          println("Total: $${total}")
      }
  }
  
  fun main() {
      val ordersList = mutableListOf<Order>()
  
      // Add an item to an order
      val order1 = Order(1)
      order1.addItem(Noodles())
      ordersList.add(order1)
  
      // Add multiple items individually
      val order2 = Order(2)
      order2.addItem(Noodles())
      order2.addItem(Vegetables())
      ordersList.add(order2)
  
      // Add a list of items at one time
      val order3 = Order(3)
      val items = listOf(Noodles(), Vegetables("Carrots", "Beans", "Celery"))
      order3.addAll(items)
      ordersList.add(order3)
  
      // Use builder pattern
      val order4 = Order(4)
          .addItem(Noodles())
          .addItem(Vegetables("Cabbage", "Onion"))
      ordersList.add(order4)
  
      // Create and add order directly
      ordersList.add(
          Order(5)
              .addItem(Noodles())
              .addItem(Noodles())
              .addItem(Vegetables("Spinach"))
      )
  
      // Print out each order
      for (order in ordersList) {
          order.print()
          println()
      }
  }
  ```

  

### RecyclerView를 사용하여 스크롤 가능한 목록 표시

- 패키지
  - 이름은 일반적으로 일반에서 구체적인 순서로 구성되며 이름의 각 부분을 소문자로 표기하고 마침표로 구분한다.
  - 이름 첫 부분에 개발자의 도메인이나 비즈니스의 도메인을 사용하는 것이 규칙
  - 예외
    - `kotlin.math` :point_right: 수학 함수 및 상수
    - `android.widget` :point_right: 뷰(예 : `TextView`)
  
- `RecyclerView` 

  - 데이터 목록 표시
  - 어뎁터 패턴을 사용하여 데이터를 조정하고 표시함
  - `ViewHolder`는 `RecyclerView`의 뷰를 만들고 보유함
  - 내장된 `LayoutManagers`와 함께 제공됨
  - 항목을 배치하는 방식을 `LayoutManagers`에 위임한다.
  - 항목 :point_right: 표시할 목록의 단일 데이터 항목이다. 앱의 `Affirmation` 객체 하나를 나타낸다
  - 어댑터 :point_right: `RecyclerView`에서 표시할 수 있도록 데이터를 가져와 준비한다.
  - ViewHolder :point_right: 확인을 표시하기 위해 사용하거나 재사용할 `RecyclerView`용 뷰의 풀이다.
  - RecyclerView :point_right: 화면에 표시되는 뷰이다.

- 예시 코드

  ```
  I am strong.
  I believe in myself.
  Each day is a new opportunity to grow and be a better version of myself.
  Every challenge in my life is an opportunity to learn from.
  I have so much to be grateful for.
  Good things are always coming into my life.
  New opportunities await me at every turn.
  I have the courage to follow my heart.
  Things will unfold at precisely the right time.
  I will be present in all the moments that this day brings.
  ```

  <img src="img\Unit2-Pathway3-1_장유진.png" style="zoom:70%;" />

### 카드를 사용하여 이미지 목록 표시  

- `RecyclerView`에 추가 콘텐츠를 표시하려면 기본 데이터 모델 클래스와 데이터 소스를 수정한다. 그 후 목록 항목 레이아웃 및 어댑터를 업데이트하여 데이터를 뷰에 설정한다.

- `MaterialCardView`를 사용하여 Material Card에 콘텐츠를 표시한다.

  <img src="img\Unit2-Pathway3-2_장유진.png" style="zoom:70%;" />

### Quiz

1. **빈칸 채우기**

   **아래 코드를 실행하기 전에 simpleList를 _______목록으로 초기화해야 한다.**
   
   ```kotlin
   println(simpleList)
   simpleList.add(-5)
   simpleList.remove(4)
   println(simpleList)
   ```

   --> mutableListOf

2. **다음 중 올바른 설명은 무엇인가?**

   --> `val list = listOf(1, 2, 5)`

   -->`val oddNumbers = mutableListOf("1", "9", "15")`

   --> `val words : List<String> = listOf("jump", "run", "skip")`

3. ** `RecyclerView`에 어댑터가 필요한 이유는 무엇인가?**

   --> 새 `ViewHolders`를 만들고 데이터를 바인딩

4. **다음 중 `RecyclerView` 사용의 이점은 무엇인가?** 

   --> `RecyclerView`는 기본 제공 레이아웃 관리자와 함께 제공됩니다.

   --> `RecyclerView`를 사용하면 처리 시간을 절약하여 목록을 더욱 부드럽게 스크롤할 수 있습니다.

   --> `RecyclerView`는 화면 밖으로 스크롤된 뷰를 다시 사용하여 목록의 효율성을 높이도록 설계 되었습니다.

5. **다음 중 패키지와 관련해 맞는 설명은 무엇인가?**

   --> 패키지를 사용하여 코드를 구성할 수 있습니다.

   --> 다른 패키지의 클래스를 사용하려면 코드에서 명시적으로 가져와야 합니다.

   --> 패키지를 사용하여 기능별로 클래스를 그룹화하는 것이 좋습니다.

6. **알맞은 유형의 리소스 ID가 생성자에 전달되도록 하려면 어떻게 해야 하나?**

   --> 리소스 주석을 사용합니다.

7. **빈 칸 채우기**

   **아래 코드에서 ___은(는) for루프에 작성하여 반환된 출력이 한 줄에 숫자가 하나씩 출력된 1~3의 숫자 목록이 되도록 해야 한다.**

   ```kotlin
   val numbers = listOf(1, 2, 3)
   for (_______) {
     println(num)
   }
   ```

   --> ???