## 2021 Landvibe Summer Coding - Android

### ๐ Android Basics In Kotlin

#### ๐ Unit2: Layouts

#### ๐ PathWay3: Display a scrollable list

<hr>

##### `๋ฆฌ์คํธ` : ๋ณํ ๋ถ๊ฐ๋ฅ ๋ฆฌ์คํธ

```kotlin
fun main() {
    //val numbers: List<Int>=listOf(1,2,3,4,5,6)
    val numbers=listOf(1,2,3,4,5,6)
    println("List: $numbers")
    println("Size: ${numbers.size}")

    //๋ฆฌ์คํธ์ elements ์ ๊ทผ
    println("First element: ${numbers[0]}")
    println("Second element: ${numbers[1]}")
    println("Last index: ${numbers.size-1}")
    println("Last element: ${numbers[numbers.size-1]}")

    //first(), last() ๋ฉ์๋ ์ด์ฉ
    println("First: ${numbers.first()}")
    println("Last: ${numbers.last()}")

    //contains() ๋ฉ์๋ ์ด์ฉ
    println("Contains 4? ${numbers.contains(4)}")
    println("Contains 7? ${numbers.contains(7)}")
}

/*์ถ๋ ฅ
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
    //colors[0]="yellow" -> ์์  ๋ถ๊ฐ๋ฅ
    println("List: $colors")
    //์ ๋ ฌ ์ถ๋ ฅ
    println("Sorted list: ${colors.sorted()}")
    //์ญ์ ์ถ๋ ฅ
    println("Reversed list: ${colors.reversed()}")
}

/*์ถ๋ ฅ
List: [green, orange, blue]
Sorted list: [blue, green, orange]
Reversed list: [blue, orange, green]
*/
```


##### `MutableList` : ๋ณํ ๊ฐ๋ฅ ๋ฆฌ์คํธ

```kotlin
val entrees = mutableListOf<String>()
val entrees: MutableList<String> = mutableListOf()

println("Add noodles: ${entrees.add("noodles")}")
println("Remove spaghetti: ${entrees.remove("noodles")}")
println("Remove first element: ${entrees.removeAt(0)}")
entrees.clear()
println("Empty? ${entrees.isEmpty()}")
```

`for`๋ฌธ

**string๋ ๋ค์ด๊ฐ ์ ์์**

```kotlin
val names = listOf("Jessica", "Henry", "Alicia", "Jose")
for (name in names) {
    println(name) //๋ฌธ์์ด ์ถ๋ ฅ
    println("$name - Number of characters: ${name.length}") //๊ฐ๊ฐ ๋ฌธ์์ด ๊ธธ์ด
}
```

`class`

**์ ๋ฌ๋๋ ๋ณ์๋ฅผ ๋ฆฌ์คํธ๋ก ๋ฐ๊ธฐ** `vararg`

```kotlin
class Vegetables(vararg val toppings: String) : Item("Vegetables", 5) {
    override fun toString(): String {
        return name + " " + toppings.joinToString()
    }
}
```



๐์๋ฃจ์ ์ฝ๋

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



##### RecyclerView๋ฅผ ์ฌ์ฉํ์ฌ ์คํฌ๋กค ๊ฐ๋ฅํ ๋ชฉ๋ก ํ์ํ๊ธฐ

`RecyclerView`: ์์ ฏ ์ฌ์ฉํด ๋ฐ์ดํฐ ๋ชฉ๋ก์ ํ์ ๊ฐ๋ฅ /์ด๋ํฐ ํจํด ์ฌ์ฉํด ๋ฐ์ดํฐ๋ฅผ ์กฐ์ &ํ์ /๋ด์ฅ๋ `LayoutManagers`์ ํจ๊ป ์ ๊ณต๋จ / ํญ๋ชฉ์ ๋ฐฐ์นํ๋ ๋ฐฉ์์ `LayoutManagers`์ ์์

`ViewHolder`: `RecyclerView`์ ๋ทฐ๋ฅผ ๋ง๋ค๊ณ  ๋ณด์ ํจ

๐๐ป ์ด๋ํฐ๋ฅผ ๊ตฌํํ๋ ๋ฐฉ๋ฒ

1. ์ด๋ํฐ์ ์ ํด๋์ค(์: `ItemAdapter`)๋ฅผ ๋ง๋ญ๋๋ค.

2. ๋จ์ผ ๋ชฉ๋ก ํญ๋ชฉ ๋ทฐ๋ฅผ ๋ํ๋ด๋ ๋ง์ถค `ViewHolder` ํด๋์ค๋ฅผ ๋ง๋ค๊ธฐ / `RecyclerView.ViewHolder` ํด๋์ค์์ ํ์ฅ

3. `ItemAdapter` ํด๋์ค๋ฅผ ์์ ํ์ฌ `RecyclerView`.`Adapter` ํด๋์ค์์ ํ์ฅ(๋ง์ถค `ViewHolder` ํด๋์ค ์ฌ์ฉ).

4. ์ด๋ํฐ ๋ด์์ `getItemsCount()`, `onCreateViewHolder()`, `onBindViewHolder()` ๋ฉ์๋๋ฅผ ๊ตฌํ



##### ํด์ฆ

1. ์๋ ์ฝ๋๋ฅผ ์คํํ๊ธฐ ์ ์ simpleList๋ฅผ _ ๋ชฉ๋ก์ผ๋ก ์ด๊ธฐํํด์ผ ํฉ๋๋ค.

   ```
   println(simpleList)
   simpleList.add(-5)
   simpleList.remove(4)
   println(simpleList)
   ```

   ๋ณ๊ฒฝ ๊ฐ๋ฅํ

2. ๋ค์ ์ค ์ฌ๋ฐ๋ฅธ ์ค๋ช์ ๋ฌด์์ธ๊ฐ์?

   ```kotlin
   val list = listOf(1, 2, 5)
   ```

   ```kotlin
   val oddNumbers = mutableListOf("1", "9", "15")
   ```

   ```kotlin
   val words: List<String> = listOf("jump", "run", "skip")
   ```

3. `RecyclerView`์ ์ด๋ํฐ๊ฐ ํ์ํ ์ด์ ๋ ๋ฌด์์ธ๊ฐ์?

   ์ `ViewHolders`๋ฅผ ๋ง๋ค๊ณ  ๋ฐ์ดํฐ๋ฅผ ๋ฐ์ธ๋ฉ

4. ๋ค์ ์ค `RecyclerView` ์ฌ์ฉ์ ์ด์ ์ ๋ฌด์์ธ๊ฐ์?

   `RecyclerView`๋ ๊ธฐ๋ณธ ์ ๊ณต ๋ ์ด์์ ๊ด๋ฆฌ์์ ํจ๊ป ์ ๊ณต๋ฉ๋๋ค.

   `RecyclerView`๋ฅผ ์ฌ์ฉํ๋ฉด ์ฒ๋ฆฌ ์๊ฐ์ ์ ์ฝํ์ฌ ๋ชฉ๋ก์ ๋์ฑ ๋ถ๋๋ฝ๊ฒ ์คํฌ๋กคํ  ์ ์์ต๋๋ค.

   `RecyclerView`๋ ํ๋ฉด ๋ฐ์ผ๋ก ์คํฌ๋กค๋ ๋ทฐ๋ฅผ ๋ค์ ์ฌ์ฉํ์ฌ ๋ชฉ๋ก์ ํจ์จ์ฑ์ ๋์ด๋๋ก ์ค๊ณ๋์์ต๋๋ค.

5. ๋ค์ ์ค ํจํค์ง์ ๊ด๋ จํด ๋ง๋ ์ค๋ช์ ๋ฌด์์ธ๊ฐ์?

   ํจํค์ง๋ฅผ ์ฌ์ฉํ์ฌ ์ฝ๋๋ฅผ ๊ตฌ์ฑํ  ์ ์์ต๋๋ค.

   ๋ค๋ฅธ ํจํค์ง์ ํด๋์ค๋ฅผ ์ฌ์ฉํ๋ ค๋ฉด ์ฝ๋์์ ๋ช์์ ์ผ๋ก ๊ฐ์ ธ์์ผ ํฉ๋๋ค.

   ํจํค์ง๋ฅผ ์ฌ์ฉํ์ฌ ๊ธฐ๋ฅ๋ณ๋ก ํด๋์ค๋ฅผ ๊ทธ๋ฃนํํ๋ ๊ฒ์ด ์ข์ต๋๋ค.

6. ์๋ง์ ์ ํ์ ๋ฆฌ์์ค ID๊ฐ ์์ฑ์์ ์ ๋ฌ๋๋๋ก ํ๋ ค๋ฉด ์ด๋ป๊ฒ ํด์ผ ํ๋์?

   ๋ฆฌ์์ค ์ฃผ์์ ์ฌ์ฉํฉ๋๋ค.

7. ์๋ ์ฝ๋์์ _์(๋) for ๋ฃจํ์ ์์ฑํ์ฌ ๋ฐํ๋ ์ถ๋ ฅ์ด ํ ์ค์ ์ซ์๊ฐ ํ๋์ฉ ์ถ๋ ฅ๋ 1~3์ ์ซ์ ๋ชฉ๋ก์ด ๋๋๋ก ํด์ผ ํฉ๋๋ค.

   ```kotlin
   val numbers = listOf(1, 2, 3)
   for (_______) {
     println(num)
   }
   ```

   ์กฐ๊ฑด
