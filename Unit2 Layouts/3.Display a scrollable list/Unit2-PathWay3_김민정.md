## 2021 Landvibe Summer Coding - Android

### 🔎 Android Basics In Kotlin

#### 📌 Unit2: Layouts

#### 📌 PathWay3: Display a scrollable list

<hr>

##### `리스트` : 변화 불가능 리스트

```kotlin
fun main() {
    //val numbers: List<Int>=listOf(1,2,3,4,5,6)
    val numbers=listOf(1,2,3,4,5,6)
    println("List: $numbers")
    println("Size: ${numbers.size}")

    //리스트의 elements 접근
    println("First element: ${numbers[0]}")
    println("Second element: ${numbers[1]}")
    println("Last index: ${numbers.size-1}")
    println("Last element: ${numbers[numbers.size-1]}")

    //first(), last() 메서드 이용
    println("First: ${numbers.first()}")
    println("Last: ${numbers.last()}")

    //contains() 메서드 이용
    println("Contains 4? ${numbers.contains(4)}")
    println("Contains 7? ${numbers.contains(7)}")
}

/*출력
List: [1, 2, 3, 4, 5, 6]
Size: 6
First element: 1
Second element: 2
Last index: 5
Last element: 6
First: 1
Last: 6
Contains 4? true
Contains 7? false
*/
```
```kotlin
fun main() {
    val colors =listOf("green","orange","blue")
    //colors.add("purple")
    //colors[0]="yellow" -> 수정 불가능
    println("List: $colors")
    //정렬 출력
    println("Sorted list: ${colors.sorted()}")
    //역순 출력
    println("Reversed list: ${colors.reversed()}")
}

/*출력
List: [green, orange, blue]
Sorted list: [blue, green, orange]
Reversed list: [blue, orange, green]
*/
```


##### `MutableList` : 변화 가능 리스트

```kotlin
val entrees = mutableListOf<String>()
val entrees: MutableList<String> = mutableListOf()

println("Add noodles: ${entrees.add("noodles")}")
println("Remove spaghetti: ${entrees.remove("noodles")}")
println("Remove first element: ${entrees.removeAt(0)}")
entrees.clear()
println("Empty? ${entrees.isEmpty()}")
```

`for`문

**string도 들어갈 수 있음**

```kotlin
val names = listOf("Jessica", "Henry", "Alicia", "Jose")
for (name in names) {
    println(name) //문자열 출력
    println("$name - Number of characters: ${name.length}") //각각 문자열 길이
}
```

`class`

**전달되는 변수를 리스트로 받기** `vararg`

```kotlin
class Vegetables(vararg val toppings: String) : Item("Vegetables", 5) {
    override fun toString(): String {
        return name + " " + toppings.joinToString()
    }
}
```



📌솔루션 코드

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



##### RecyclerView를 사용하여 스크롤 가능한 목록 표시하기

`RecyclerView`: 위젯 사용해 데이터 목록을 표시 가능 /어댑터 패턴 사용해 데이터를 조정&표시 /내장된 `LayoutManagers`와 함께 제공됨 / 항목을 배치하는 방식을 `LayoutManagers`에 위임

`ViewHolder`: `RecyclerView`의 뷰를 만들고 보유함

👉🏻 어댑터를 구현하는 방법

1. 어댑터의 새 클래스(예: `ItemAdapter`)를 만듭니다.

2. 단일 목록 항목 뷰를 나타내는 맞춤 `ViewHolder` 클래스를 만들기 / `RecyclerView.ViewHolder` 클래스에서 확장

3. `ItemAdapter` 클래스를 수정하여 `RecyclerView`.`Adapter` 클래스에서 확장(맞춤 `ViewHolder` 클래스 사용).

4. 어댑터 내에서 `getItemsCount()`, `onCreateViewHolder()`, `onBindViewHolder()` 메서드를 구현



##### 퀴즈

1. 아래 코드를 실행하기 전에 simpleList를 _ 목록으로 초기화해야 합니다.

   ```
   println(simpleList)
   simpleList.add(-5)
   simpleList.remove(4)
   println(simpleList)
   ```

   변경 가능한

2. 다음 중 올바른 설명은 무엇인가요?

   ```kotlin
   val list = listOf(1, 2, 5)
   ```

   ```kotlin
   val oddNumbers = mutableListOf("1", "9", "15")
   ```

   ```kotlin
   val words: List<String> = listOf("jump", "run", "skip")
   ```

3. `RecyclerView`에 어댑터가 필요한 이유는 무엇인가요?

   새 `ViewHolders`를 만들고 데이터를 바인딩

4. 다음 중 `RecyclerView` 사용의 이점은 무엇인가요?

   `RecyclerView`는 기본 제공 레이아웃 관리자와 함께 제공됩니다.

   `RecyclerView`를 사용하면 처리 시간을 절약하여 목록을 더욱 부드럽게 스크롤할 수 있습니다.

   `RecyclerView`는 화면 밖으로 스크롤된 뷰를 다시 사용하여 목록의 효율성을 높이도록 설계되었습니다.

5. 다음 중 패키지와 관련해 맞는 설명은 무엇인가요?

   패키지를 사용하여 코드를 구성할 수 있습니다.

   다른 패키지의 클래스를 사용하려면 코드에서 명시적으로 가져와야 합니다.

   패키지를 사용하여 기능별로 클래스를 그룹화하는 것이 좋습니다.

6. 알맞은 유형의 리소스 ID가 생성자에 전달되도록 하려면 어떻게 해야 하나요?

   리소스 주석을 사용합니다.

7. 아래 코드에서 _은(는) for 루프에 작성하여 반환된 출력이 한 줄에 숫자가 하나씩 출력된 1~3의 숫자 목록이 되도록 해야 합니다.

   ```kotlin
   val numbers = listOf(1, 2, 3)
   for (_______) {
     println(num)
   }
   ```

   조건
