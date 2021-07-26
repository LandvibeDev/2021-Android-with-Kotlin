# 🔥 Unit 2 : Layouts

## Pathway 3 : Display a scrollable list

## 🎖 Track 2 : Kotlin에서 목록 사용

### List

+ List : 특정 순서가 있는 항목의 모음

  + `List` : 읽기 전용 List로, 만든 후 수정할 수 없다.

  + `MutableList` : 변경 가능한 List로, 만든 후 수정할 수 있다. 즉, 요소를 추가, 삭제, 업데이트할 수 있다.

  + ```kotlin
    val numbers: List<Int> = listOf(1, 2, 3, 4, 5, 6)
    ```

  + 변수 유형을 할당 연산자(=) 오른쪽에 있는 값에 기반하여 추측하거나 추론할 수 있으면 **변수의 데이터 유형을 생략할 수 있다.**  => `val numbers = listOf(1, 2, 3, 4, 5, 6)`

  + ```kotlin
    println("List: $numbers")   		// List: [1, 2, 3, 4, 5, 6]
    println("Size: ${numbers.size}") 	// Size: 6
    ```

  + List의 요소 접근 => `numbers[0]` or `numbers.get(0)`

    ```kotlin
    println("First element: ${numbers[0]}") // First element: 1
    println("First: ${numbers.first()}")	// First: 1
    println("Last: ${numbers.last()}")	   	// Last: 6
    ```

  + `contains()` : List에 특정 item이 있는지 확인

  + `reversed()` : 요소가 역순으로 있는 새 목록을 반환

  + `sorted()` : 요소가 오름차순으로 정렬된 새 목록을 반환    



+ Mutable List : 변경가능한 List

  + `mutableListOf()`를 호출하여 생성 => `val entrees = mutableListOf<dayatype>()`

    ```kotlin
    val entrees = mutableListOf()
    // Error => Not enough information to infer type variable T
    // 목록에 어떤 유형(datatype)의 itme이 올지를 추론할 수 없기 때문에
    
    val entrees = mutableListOf<String>() // 변경가능한 String 유형의 목록을 만든다.
    val entrees: MutableList<String> = mutableListOf()
    ```

    > **You can use `val`** for a mutable list because the **`entrees` variable contains a *reference* to the list**, and that **reference doesn't change** even if the contents of the list do.

  + `add()` : 요소 추가, List에 요소가 성공적으로 추가되면 `true`를 반환하고 추가되지 않으면 `false`를 반환합니다. => `entrees.add("noodles")`

  + `addAll()` : List에 요소 여러개 추가 => `entrees.addAll(moreItems)`

  + `entrees.remove("rice")` : List에서 해당 요소 삭제, 삭제에 성공하면 `true`를 반환

  + `entrees.removeAt(0)` : 1번째 요소를 삭제

  + `entrees.clear()` : 전체 List 삭제

  + `entrees.isEmpty()`





### List 반복

+ `while`문

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



+ `for`문

  ```kotlin
  for (number in numberList) {
     // For each element in the list, execute this code block
  }
  ```

  `number` 변수는 `numberList`의 첫 번째 요소와 같게 설정되고 코드 블록이 실행됩니다. 그러면 `number` 변수가 자동으로 `numberList`의 다음 요소가 되도록 업데이트되고 코드 블록이 다시 실행됩니다. 이 작업은 `numberList`가 끝날 때까지 목록의 각 요소에 반복됩니다. 





### 클래스 구현

+ toString() 메서드 재정의

  + **객체 인스턴스를 출력하면 객체의 `toString()` 메서드가 호출**됩니다. Kotlin에서는 모든 클래스가 자동으로 `toString()` 메서드를 상속합니다. 이 메서드의 기본 구현에서는 **인스턴스의 메모리 주소가 있는 객체 유형**을 반환합니다. 좀 더 의미 있고 사용자 친화적인 내용을 반환하도록 `toString()`을 재정의해야 합니다.

  + ```kotlin
    class Noodles : Item("Noodles", 10) {
       override fun toString(): String {
           return name // 상위 클래스 Item에서 name을 상속받음
       }
    }
    ```



+ `vararg`

  + Kotlin에서 `vararg` 수정자를 사용하면 동일한 유형의 가변적인 인수 수를 함수나 생성자에 전달할 수 있습니다. 이렇게 하면 목록 대신 개별 문자열로 다양한 채소를 제공할 수 있습니다. 

  + ```kotlin
    class Vegetables(vararg val toppings: String) : Item("Vegetables", 5) {
    ```

  + 매개변수 하나만 `vararg`로 표시할 수 있으며 이 하나는 일반적으로 목록의 마지막 매개변수입니다.



+ toString() 메서드 재정의

  ```kotlin
  class Vegetables(vararg val toppings: String) : Item("Vegetables", 5) {
      override fun toString(): String {
      if (toppings.isEmpty()) {
          return "$name Chef's Choice"
      } else {
          return name + " " + toppings.joinToString()
      }
  }
  }
  ```

  + 이제 `Vegetables` 클래스의 `toString()` 메서드를 수정하여 `Vegetables Cabbage, Sprouts, Onion` 형식의 토핑도 언급하는 `String`을 반환하도록 합니다. 

  + 항목 이름(`Vegetables`)으로 시작해, `joinToString()` 메서드를 사용하여 모든 토핑을 단일 문자열로 결합합하고, 사이에 공백이 있는 `+` 연산자를 사용하여 두 부분을 함께 추가합니다

    > 쉼표 외에 다른 구분자를 지정하려면 원하는 구분자 문자열을 `joinToString()` 메서드의 인수로 전달하세요. 예: 공백으로 각 항목을 구분하는 `joinToString(" ")`

  + 전달된 토핑이 없다면 `Vegetables Chef's Choice`를 반환한다. 



+ 빌더 패턴

  빌더 패턴은 단계별 접근 방식으로 복잡한 객체를 빌드할 수 있는 프로그래밍의 디자인 패턴입니다.

  ```kotlin
  fun addItem(newItem: Item): Order {
      itemList.add(newItem)
      return this
  }
  
  fun addAll(newItems: List<Item>): Order {
      itemList.addAll(newItems)
      return this
  }
  ```

  + `Order` 클래스의 `addItem()` 및 `addAll()` 메서드에서 `Unit`(또는 아무것도 없음)을 반환하는 대신 ***변경된 `Order`를 반환***합니다. Kotlin은 키워드 `this`를 제공하여 **현재 객체 인스턴스를 참조**합니다. `addItem()` 및 `addAll()` 메서드 내에서 `this`를 반환하여 현재 `Order`를 반환합니다.

  + `main()` 함수에서 이제 다음 코드와 같이 ***호출을 함께 연결***할 수 있습니다. 이 코드는 새 `Order`를 만들고 빌더 패턴을 활용합니다.

    ```kotlin
    val order4 = Order(4).addItem(Noodles()).addItem(Vegetables("Cabbage", "Onion"))
    ordersList.add(order4)
    ```

    `Order(4)`가 `Order` 인스턴스를 반환한 후 이 인스턴스에서 `addItem(Noodles())`를 호출할 수 있습니다. `addItem()` 메서드가 동일한 `Order` 인스턴스(새 상태)를 반환하면 다시 이 인스턴스에서 채소로 `addItem()`을 호출할 수 있습니다. 반환된 `Order` 결과는 `order4` 변수에 저장될 수 있습니다.

  + 실제로 주문을 변수에 저장하지 않아도 된다.

    ```kotlin
    ordersList.add(
        Order(5)
            .addItem(Noodles())
            .addItem(Noodles())
            .addItem(Vegetables("Spinach")))
    ```

  => 이러한 호출을 연결하는 것이 필수는 아니지만 함수의 반환 값을 활용하는 일반적이고 권장되는 방법이다.



### Solution code

```kotlin
open class Item(val name: String, val price: Int)

class Noodles : Item("Noodles", 10) {
    override fun toString(): String {
        return name
    }
}

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





-----

## 🎖 Track 3 : RecyclerView

+ Android는 목록이 있는 앱을 빌드할 수 있도록 `RecyclerView`를 제공합니다. `RecyclerView`는 화면에서 스크롤된 뷰를 재사용하거나 재활용하여 목록이 큰 경우에도 매우 효율적으로 작동하도록 설계되었습니다. 화면에서 목록 항목이 스크롤되면 `RecyclerView`는 표시할 다음 목록 항목에 이 뷰를 재사용합니다. 다시 말해서, 항목이 화면에 스크롤되는 새로운 콘텐츠로 채워집니다. 이 `RecyclerView` 동작은 처리 시간을 크게 단축하고 목록이 더 원활하게 스크롤되도록 도와줍니다.    



###  새 패키지 만들기

+ 코드를 논리적으로 구성하면 다른 개발자들도 코드를 이해하고 유지관리하고 확장할 수 있습니다. 서류를 파일과 폴더로 정리하는 것과 동일한 방법으로 코드를 파일 및 패키지로 구성할 수 있습니다.
+ Android 스튜디오의 **Project** 창(**Android**)에서 **app > java** 아래에 있는 새 프로젝트 파일을 살펴보고 Affirmations 앱을 찾습니다. 패키지 세 개, 즉 코드용 패키지 한 개(**com.example.affirmations**)와 테스트 파일용 패키지 두 개(**com.example.affirmations (androidTest)** 및 **com.example.affirmations (test)**)가 표시됩니다.
+ 다음 두 가지 방법으로 패키지를 사용할 수 있습니다.
  + 코드의 여러 부분별로 서로 다른 패키지를 만듭니다. 예를 들어, 개발자는 **데이터 작업에 사용하는 클래스**와 **UI**를 **서로 다른 패키지로 빌드하는 클래스로 구분**하는 경우가 많습니다.
  + 코드에 있는 다른 패키지의 코드를 사용합니다. 다른 패키지의 클래스를 사용하려면 빌드 시스템의 종속 항목에 클래스를 정의해야 합니다. 또한 정규화된 이름(예: `android.widget.TextView`) 대신 축약 이름(예: `TextView`)을 사용할 수 있도록 클래스를 코드에 `import`하는 것도 표준 관행입니다. 예를 들어 클래스에 `sqrt`(`import kotlin.math.sqrt`) 및 `View`(`import android.view.View`) 같은 `import` 문을 이미 사용한 경우를 예로 들 수 있습니다.
+ Affirmations 앱에서 Android 클래스와 Kotlin 클래스를 가져오는 것 외에도 앱을 여러 패키지로 구성합니다. **앱의 클래스가 많지 않더라도 패키지를 사용하여 기능별로 클래스를 그룹화하는 것이 좋습니다.**   





### 패키지 이름 정하기

+ 패키지 이름은 일반적으로 일반에서 구체적인 순서로 구성되며 이름의 각 부분을 소문자로 표기하고 마침표로 구분합니다. 중요: 마침표는 이름의 일부일 뿐이며 코드 내의 계층 구조를 나타내거나 폴더 구조를 지시하지 않습니다.
+ 인터넷 도메인은 전역적으로 고유하므로, 이름 첫 부분에 개발자의 도메인이나 비즈니스의 도메인을 사용하는 것이 규칙입니다.
+ 패키지 이름을 선택하여 패키지에 포함된 내용 및 패키지 간의 관계를 표시할 수 있습니다.
+ 이런 코드의 예로, `com.example` 다음에 앱 이름을 사용하는 것이 일반적입니다.   





### Affirmation 데이터 클래스 만들기

`Affirmation.kt`

```kotlin
package com.example.affirmations.model

data class Affirmation(val stringResourceId: Int)
```



### 데이터 소스가 되는 클래스 만들기

`Datasource.kt`

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





### 앱에 RecyclerView 추가하기

<img src = "https://user-images.githubusercontent.com/31370590/125922681-8fc4d14b-2785-45a7-a84a-121edd87b17d.PNG" width = "400" height = "300">

+ **항목** - 표시할 목록의 단일 데이터 항목입니다. 앱의 `Affirmation` 객체 하나를 나타냅니다.
+ **어댑터** - `RecyclerView`에서 표시할 수 있도록 데이터를 가져와 준비합니다.
+ **ViewHolder** - 확인을 표시하기 위해 사용하거나 재사용할 `RecyclerView`용 뷰의 풀입니다.
+ **RecyclerView** - 화면에 표시되는 뷰입니다.



### RecyclerView

+ activity_main.xml 파일에서 `FrameLayout`으로 설정하고, `RecyclerView` 배치
+ 한 레이아웃에 하위 뷰 여러 개를 배치하려면 `ConstraintLayout`이 가장 적합하고 유연하지만, 레이아웃에 단일 하위 뷰 `RecyclerView`만 있으므로, 단일 하위 뷰를 보유하는 데 사용해야 하는 더 간단한 `ViewGroup`인 `FrameLayout`으로 전환할 수 있습니다.
+ `RecyclerView`의 `layout_width` 속성과 `layout_height` 속성을 `match_parent`로 변경

+ `RecyclerView` 요소 내부에 다음과 같이 `LinearLayoutManager`를 `RecyclerView`의 레이아웃 관리자 속성으로 추가합니다. 

  => `app:layoutManager="LinearLayoutManager"`

+ 화면보다 긴 항목의 세로 목록을 스크롤할 수 있으려면 세로 스크롤바를 추가해야 합니다.

  => `android:scrollbars="vertical"`



### RecyclerView용 Adapter 구현하기

+ `Datasource`에서 데이터를 가져와 각 `Affirmation`을 `RecyclerView`에 항목으로 표시할 수 있도록 형식을 지정해줘야 한다. 
+ ***Adapter*** is a design pattern that adapts the data into something that can be used by `RecyclerView`.
+ 여기서는, `RecyclerView`에 표시할 수 있도록 `loadAffirmations()`에서 반환된 목록에서 `Affirmation` 인스턴스를 가져와 list item view로 전환하는 어댑터가 필요합니다

+ 앱을 실행하면 `RecyclerView`가 어댑터를 사용하여 화면에 데이터를 표시하는 방법을 파악합니다. 
+ 앱을 실행하면 `RecyclerView`가 어댑터를 사용하여 화면에 데이터를 표시하는 방법을 파악합니다. `RecyclerView`는 목록의 첫 번째 데이터 항목을 위한 새 목록 항목 뷰를 만들도록 어댑터에 요청합니다. 뷰가 생성된 후에는 항목을 그리기 위한 데이터를 제공하도록 어댑터에 요청합니다. 이 프로세스는 `RecyclerView`에 화면을 채울 뷰가 더 이상 필요하지 않을 때까지 반복됩니다.   



###  Adapter 만들기

`ItemAdapter.kt`

```kotlin
class ItemAdapter(private val context: Context, private val dataset: List<Affirmation>) {

}
```

+ `ItemAdapter`에는 문자열 리소스를 확인하는 방법에 관한 정보가 필요합니다. 이러한 정보와 기타 앱 관련 정보는 `ItemAdapter` 인스턴스에 전달할 수 있는 `Context` 객체 인스턴스에 저장됩니다. 



### ViewHolder

+ `RecyclerView`는 항목 뷰와 직접 상호작용하지 않는 대신 `ViewHolders`를 처리합니다. `ViewHolder`는 `RecyclerView`의 단일 목록 항목 뷰를 나타내며 가능한 경우 재사용할 수 있습니다. `ViewHolder` 인스턴스는 목록 항목 레이아웃 안에 개별 뷰의 참조를 보유합니다(따라서 이름이 '뷰 홀더'임). 이렇게 하면 새로운 데이터로 목록 항목 뷰를 더 쉽게 업데이트할 수 있습니다. 



### Adapter 및 ViewHolder 코드

```kotlin
/**
 * Adapter for the [RecyclerView] in [MainActivity]. Displays [Affirmation] data object.
 */
class ItemAdapter(
    private val context: Context,
    private val dataset: List<Affirmation>
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just an Affirmation object.
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_title)
    }

    /**
     * Create new views (invoked by the layout manager)
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // create a new view
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    /**
     * Replace the contents of a view (invoked by the layout manager)
     */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView.text = context.resources.getString(item.stringResourceId)
    }

    /**
     * Return the size of your dataset (invoked by the layout manager)
     */
    override fun getItemCount() = dataset.size
}
```

+ `onCreateViewHolder()`

  `RecyclerView`의 새 뷰 홀더를 만들기 위해 레이아웃 관리자가 호출합니다(재사용할 수 있는 기존 뷰 홀더가 없는 경우). 뷰 홀더는 단일 목록 항목 뷰를 나타냅니다.

  + `parent` 매개변수: 새 목록 항목 뷰가 하위 요소로 사용되어 연결되는 뷰 그룹입니다. 상위 요소는 `RecyclerView`입니다.
  + `viewType` 매개변수: 동일한 `RecyclerView`에 항목 뷰 유형이 여러 개 있을 때 중요해집니다. `RecyclerView` 내에 다른 목록 항목 레이아웃이 표시된다면 다른 항목 뷰 유형이 있는 것입니다. 동일한 항목 뷰 유형을 가진 뷰만 재활용할 수 있습니다. 이 경우에는 목록 항목 레이아웃이 하나만 있고 항목 뷰 유형이 하나이므로 이 매개변수에 관해 걱정할 필요가 없습니다.

+ `onBindViewHolder()`

  목록 항목 뷰의 콘텐츠를 바꾸기 위해 레이아웃 관리자가 호출합니다



### RecyclerView를 사용하도록 MainActivity 수정

```kotlin
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize data.
        val myDataset = Datasource().loadAffirmations()

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = ItemAdapter(this, myDataset)

        // Use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true)
    }
}
```







## 🎖 Quiz/Unit2/Pathway3

1. 아래 코드를 실행하기 전에 simpleList를 **변경가능한**목록으로 초기화해야 합니다.

   ```kotlin
   println(simpleList)
   simpleList.add(-5)
   simpleList.remove(4)
   println(simpleList)
   ```



2. 다음 중 올바른 설명은 무엇인가요?

   => 

   + `val list = listOf(1, 2, 5)`
   + `val oddNumbers = mutableListOf("1", "9", "15")`
   + `val words: List<String> = listOf("jump", "run", "skip")`



3. `RecyclerView`에 어댑터가 필요한 이유는 무엇인가요?

   => 새 `ViewHolders`를 만들고 데이터를 바인딩



4. 다음 중 `RecyclerView` 사용의 이점은 무엇인가요?

   => 

   + `RecyclerView`는 기본 제공 레이아웃 관리자와 함께 제공됩니다.
   + `RecyclerView`를 사용하면 처리 시간을 절약하여 목록을 더욱 부드럽게 스크롤할 수 있습니다.

   + `RecyclerView`는 화면 밖으로 스크롤된 뷰를 다시 사용하여 목록의 효율성을 높이도록 설계되었습니다.



5. 다음 중 패키지와 관련해 맞는 설명은 무엇인가요?

   => 

   + 패키지를 사용하여 코드를 구성할 수 있습니다.
   + 다른 패키지의 클래스를 사용하려면 코드에서 명시적으로 가져와야 합니다.
   + 패키지를 사용하여 기능별로 클래스를 그룹화하는 것이 좋습니다.



6. 알맞은 유형의 리소스 ID가 생성자에 전달되도록 하려면 어떻게 해야 하나요?

   => 리소스 주석을 사용합니다



7. 아래 코드에서 **```num in numbers```**은(는) for 루프에 작성하여 반환된 출력이 한 줄에 숫자가 하나씩 출력된 1~3의 숫자 목록이 되도록 해야 합니다. 

   ```kotlin
   val numbers = listOf(1, 2, 3)
   for (_______) {
     println(num)
   }
   ```

 => 아무리 생각해도 빈칸에 num in numbers가 들어가야 하는데 왜 틀렸는지 모르겠다.
