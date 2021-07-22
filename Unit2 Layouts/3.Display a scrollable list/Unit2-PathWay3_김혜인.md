# 2021 Landvibe Summer Coding - Android

## Unit2 : Layouts

### PathWay3 : Display a scrollable list



##### :label: Kotlin에서 목록 사용

- **목록**

  ``````kotlin
  fun main() {
      val numbers = listOf(1, 2, 3, 4, 5, 6) // List<int>
      println("List: $numbers")
      println("Size: ${numbers.size}")
  
      // Access elements of the list
      println("First element: ${numbers[0]}")
      println("Second element: ${numbers[1]}")
      println("Last index: ${numbers.size - 1}")
      println("Last element: ${numbers[numbers.size - 1]}")
      println("First: ${numbers.first()}")
      println("Last: ${numbers.last()}")
  
      // Use the contains() method
      println("Contains 4? ${numbers.contains(4)}")
      println("Contains 7? ${numbers.contains(7)}")
  }
  ``````

  - `listof()`

    리스트 생성

  - `numbers.first()`/ `numbers.last()`

    첫번째 요소 / 마지막 요소 반환

  - `contains()`

    특정 요소가 목록에 있는지 확인

  - `reversed()`

    역순 반환

  - `sorted()`

    오름차순 정렬



- `MutableList`

  - 변경 가능한 목록
  - `mutableListOf()` 를 호출하여 생성

  ``````kotlin
  val entrees = mutableListOf<String>() // String 유형 목록
  val entrees: MutableList<String> = mutableListOf() // 데이터유형 지정
  ``````

  

  ``````kotlin
  fun main() {
      val entrees = mutableListOf<String>()
      println("Entrees: $entrees")
  
      // Add individual items using add()
      println("Add noodles: ${entrees.add("noodles")}")
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
  ``````

  - `add()`

  목록에 요소 추가, true/false를 반환하여 성공 여부를 알 수 있다

  - `addAll()`

  한 번에 여러 요소를 추가하고 목록을 전달

  - `remove()`

  특정 요소를 삭제한다

  - `removeAt()`

  삭제할 요소의 색인(index)을 통해 특정 요소를 삭제한다

  - `clear()`

  전체 목록 삭제

  - `isEmpty()`

  목록이 비어있는지 확인할 수 있다



- **목록 반복**

  - `while`

  ``````kotlin
  val guestsPerFamily = listOf(2, 4, 1, 3)
  var totalGuests = 0
  var index = 0
  while (index < guestsPerFamily.size) {
      totalGuests += guestsPerFamily[index]
      index++
  }
  println("Total Guest Count: $totalGuests")
  ``````

  - `for`

    ``````kotlin
    val names = listOf("Jessica", "Henry", "Alicia", "Jose")
    
    // names의 모든 항목
    for (name in names) {
        println("$name - Number of characters: ${name.length}")
    }
    ``````

    - `for (item in list) print(item) // Iterate over items in a list`
    - `for (item in 'b'..'g') print(item) // Range of characters in an alphabet`
    - `for (item in 1..5) print(item) // Range of numbers`
    - `for (item in 5 downTo 1) print(item) // Going backward`
    - `for (item in 3..6 step 2) print(item) // Prints: 35`



``````kotlin
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
``````

- `vararg`

가변적인 인수 수를 함수나 생성자에게 전달 할 수 있다





##### :label: RecyclerView를 사용하여 스크롤 가능한 목록 표시

- **패키지**

  - 구분
    - 코드의 여러 부분별로 서로 다른 패키지를 만든다
    - 코드에 있는 다른 패키지의 코드를 사용

  - 이름
    - 마침표로 구분된 여러 단어

- **데이터 클래스**

  ``````kotlin
  package com.example.affirmations.model
  
  data class Affirmation(val stringResourceId: Int)
  ``````

  - `data`를 추가하여 데이터 클래스로 만듦 (데이터 클래스에는 속성이 하나 이상 정의 되어야 함)



- `RecyclerView`

  <img src="img/Unit2-Pathway3-1_hyein.jpg">

  - **항목** - 표시할 목록의 단일 데이터 항목입니다. 앱의 `Affirmation` 객체 하나를 나타낸다.
  - **어댑터** - `RecyclerView`에서 표시할 수 있도록 데이터를 가져와 준비한다.
  - **ViewHolder** - 확인을 표시하기 위해 사용하거나 재사용할 `RecyclerView`용 뷰의 풀이다.
  - **RecyclerView** - 화면에 표시되는 뷰이다.

``````kotlin
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
        android:scrollbars="vertical"
        app:layoutManager="LinearLayoutManager" />

</FrameLayout>
``````



- **어댑터**
  - `Context` 객체 인스턴스에 문자열 리소스를 확인하는 방법에 관한 정보 등이 저장된다.

``````kotlin
class ItemAdapter(private val context: Context, private val dataset: List<Affirmation>) {

}
``````

- **ViewHolder**
  - `RecyclerView`는 항목 뷰와 직접 상호작용하지 않는 대신 `ViewHolders`를 처리
  - `RecyclerView`의 단일 목록 항목 뷰를 나타낸다.

``````kotlin
class ItemAdapter(
    private val context: Context,
    private val dataset: List<Affirmation>
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_title)
    }
}
``````

:arrow_right: `ItemViewHolder`를 `RecyclerView`. `ViewHolder`의 서브클래스로 만든다.



``````kotlin
package com.example.affirmations.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.affirmations.R
import com.example.affirmations.model.Affirmation

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
``````





##### :label: 카드를 사용하여 이미지 목록 표시

- **리소스 주석 사용**

``````kotlin
package com.example.affirmations.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Affirmation(
   @StringRes val stringResourceId: Int,
   @DrawableRes val imageResourceId: Int
)
``````

​	올바른 유형의 리소스 ID가 클래스 생성자에 전달



- `ItemAdapter.kt`

``````kotlin
package com.example.affirmations.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.affirmations.R
import com.example.affirmations.model.Affirmation

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
    class ItemViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_title)
        val imageView: ImageView = view.findViewById(R.id.item_image)
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
        holder.imageView.setImageResource(item.imageResourceId)
    }

    /**
     * Return the size of your dataset (invoked by the layout manager)
     */
    override fun getItemCount() = dataset.size
}
``````





##### :label: Quiz

1. **빈 칸 채우기**

   *단어를 하나 이상 입력하여 문장을 완성하세요.*

   - 아래 코드를 실행하기 전에 simpleList를 `변경 가능한`목록으로 초기화해야 합니다.

   ```
   println(simpleList)
   simpleList.add(-5)
   simpleList.remove(4)
   println(simpleList)
   ```



2. **다음 중 올바른 설명은 무엇인가요?**

   *적절한 답변을 모두 선택합니다.*

   - `val list = listOf(1, 2, 5)`

   - `val oddNumbers = mutableListOf("1", "9", "15")`
   - `val words: List<String> = listOf("jump", "run", "skip")`

   

3. ** `RecyclerView`에 어댑터가 필요한 이유는 무엇인가요?**

   - 새 `ViewHolders`를 만들고 데이터를 바인딩

   

4. **다음 중 `RecyclerView` 사용의 이점은 무엇인가요?**

   *적절한 답변을 모두 선택합니다.*

   - `RecyclerView`는 기본 제공 레이아웃 관리자와 함께 제공됩니다.
   - `RecyclerView`를 사용하면 처리 시간을 절약하여 목록을 더욱 부드럽게 스크롤할 수 있습니다.
   - `RecyclerView`는 화면 밖으로 스크롤된 뷰를 다시 사용하여 목록의 효율성을 높이도록 설계되었습니다.



5. **다음 중 패키지와 관련해 맞는 설명은 무엇인가요?**

   *적절한 답변을 모두 선택합니다.*

   - 패키지를 사용하여 코드를 구성할 수 있습니다.
   - 다른 패키지의 클래스를 사용하려면 코드에서 명시적으로 가져와야 합니다.
   - 패키지를 사용하여 기능별로 클래스를 그룹화하는 것이 좋습니다.



6. **알맞은 유형의 리소스 ID가 생성자에 전달되도록 하려면 어떻게 해야 하나요?**
   - 리소스 주석을 사용합니다.



7. **빈 칸 채우기**

   *단어를 하나 이상 입력하여 문장을 완성하세요.*

   - 아래 코드에서 `조건` 은(는) for 루프에 작성하여 반환된 출력이 한 줄에 숫자가 하나씩 출력된 1~3의 숫자 목록이 되도록 해야 합니다.

   ``````kotlin
   val numbers = listOf(1, 2, 3)
   for (_______) {
     println(num)
   }
   ``````

   

