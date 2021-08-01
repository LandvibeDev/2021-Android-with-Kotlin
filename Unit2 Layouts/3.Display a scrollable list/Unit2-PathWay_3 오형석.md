### Unit 2: Kotlin basics

#### PATHWAY 3:Display a scrollable list

<hr/>

#### ✔ Kotlin에서 List사용

##### List

```List``` :읽기 전용 목록으로 만든 후 수정할 수 없다

```kotlin
val numbers = listOf(1, 2, 3, 4, 5, 6)
```

표준 라이브러리 함수 ```listOf()```를 사용하여 만들 수 있음

```kotlin
println("First: ${numbers.first()}")
println("Last: ${numbers.last()}")
```

첫 번째 요소 반환과 마지막 요소 반환

```kotlin
println("Contains 4? ${numbers.contains(4)}")
println("Contains 7? ${numbers.contains(7)}")
```

주어진 요소가 목록에 있는지 확인

```kotlin
println("Reversed list: ${colors.reversed()}")
println("List: $colors")
```

```List.reversed()``` 함수는 요소가 역순으로 있는 새 목록을 반환

```kotlin
println("Sorted list: ${colors.sorted()}")
```

```sorted()```함수는 정렬된 목록을 반환

##### MutableList

```MutableList``` : 변경 가능한 목록으로 만든 후 수정할 수 있다.

```kotlin
val entrees = mutableListOf<String>()
```

```kotlin
val entrees: MutableList<String> = mutableListOf()
```

```mutableListOf()```을 사용해 만들 수 있음.

```kotlin
println("Add noodles: ${entrees.add("noodles")}")
println("Entrees: $entrees")
```

```add()```함수는 목록에 요소가 성공적으로 추가되면 true를 반환하고 아니면 false를 반환

```kotlin
val moreItems = listOf("ravioli", "lasagna", "fettuccine")
println("Add list: ${entrees.addAll(moreItems)}")
println("Entrees: $entrees")
```

```addAll()```을 사용해 한 번에 여러 요소 추가하고 목록을 전달할 수 있음.

```kotlin
println("Remove spaghetti: ${entrees.remove("spaghetti")}")
println("Entrees: $entrees")
```

```remove()```함수를 사용하여 삭제하고자 하는 요소를 삭제할 수 있음.

```kotlin
println("Remove first element: ${entrees.removeAt(0)}")
println("Entrees: $entrees")
```

```removeAt()```을 사용해 인덱스를 지정해 지울 수 있음.

```kotlin
entrees.clear()
println("Entrees: $entrees")
```

```clear()```를 통해 전체를 지울 수 있음.

##### for 루프

```kotlin
for (item in list) print(item) // Iterate over items in a list
for (item in 'b'..'g') print(item) // Range of characters in an alphabet
for (item in 1..5) print(item) // Range of numbers
for (item in 5 downTo 1) print(item) // Going backward
for (item in 3..6 step 2) print(item) // Prints: 35
```

###### toString()메서드 재정의

객체 인스턴스를 출력하면 객체의 ```toString()```메서드가 호출됨. Kotlin에서는 모든 클래스가 자동으로 ```toString()```메서드를 상속하므로 원하는 내용을 반환하기 위해서는 재정의해야함.

```kotlin
class Noodles : Item("Noodles", 10) {
   override fun toString(): String {
       return name
   }
}
```

##### vararg 수정자

```vavrarg```수정자를 사용하면 동일한 유형의 가변적인 인수 수를 함수나 생성자에 전달할 수 있음.

```kotlin
class Vegetables(vararg val toppings: String) : Item("Vegetables", 5) {
```

##### joinToString()메서드

```kotlin
class Vegetables(vararg val toppings: String) : Item("Vegetables", 5) {
    override fun toString(): String {
        return name + " " + toppings.joinToString()
    }
}
```

```joinToString```을 이용해 문자열 리스트에 저장된 내용을 하나의 문자열로 표시할 수 있음. 쉼표 외에 다른 구분자를 지정하려면 원하는 구분 문자열을 ```joinToString() ```메서드의 인수로 전달.

##### 빌더 패턴

빌더 패턴은 단계별 접근 방식으로 복잡한 객체를 빌드할 수 있는  프로그래밍의 디자인 패턴

```kotlin
val order4 = Order(4).addItem(Noodles()).addItem(Vegetables("Cabbage", "Onion"))
ordersList.add(order4)
```

✔RecyclerView를 사용하여 스크롤 가능한 목록 표시하기

##### 패키지 

패키지의 사용

- 코드의 여러 부분별로 서로 다른 패키지를 만듦. ex)개발자는 데이터 작업에 사용하는 클래스와 UI를 서로 다른 패키지로 빌드하는 클래스로 구분하는 경우가 많음.
- 코드에 있는 다른 패키지의 코드 사용. 다른 패키지의 클래스를 사용하려면 빌드 시스템의 종속 항목에 클래스를 정의해야함. 정규화된 이름 대신 축약 이름을 사용할 수 있도록 클래스 코드에 ```import```하는것도 표준 관행.

패키지 이름 

- 일반적으로 구체적인 순서로 구성되며 이름의 각 부분을 소문자료 표기하고 마침표로 구분. 마침표는 이름의 일부일 뿐이며 코드 내의 계층 구조를 나타내거나 폴더 구조를 지시하지 않음.
- 인터넷 도메인은 전역적으로 고유하므로 이름 첫 부분에 개발자의 도메인이나 비즈니스의 도메인을 사용하는 것이 규칙.
- com.example다음에 앱 이름을 사용하는 것이 일반적.

##### Affirmation 데이터 클래스 만들기

클래스 정의앞에 ```data```키워드를 추가하면 데이터클래스가됨.

##### 앱에 RecyclerView 추가하기

- **항목** - 표시할 목록의 단일 데이터 항목입니다. 앱의 `Affirmation` 객체 하나를 나타냅니다.
- **어댑터** - `RecyclerView`에서 표시할 수 있도록 데이터를 가져와 준비합니다.
- **ViewHolder** - 확인을 표시하기 위해 사용하거나 재사용할 `RecyclerView`용 뷰의 풀입니다.
- **RecyclerView** - 화면에 표시되는 뷰입니다.

RecycleView는 선형 목록이나 그리드와 같은 다양한 방식으로 항목을 표시하도록 지원. Affirmations앱은 항목은 세로 목록으로 표시하므로 ```LiinearLayoutManager```을 사용할 수 있음.

##### RecyclerView용 어댑터 구현하기

앱에는 ```Datasource```에서 데이터를 가져와 각  각 `Affirmation`을 `RecyclerView`에 항목으로 표시할 수 있도록 형식을 지정하는 방법이 필요함. 

어댑터는 데이터를 ```RecyclerView```에서 사용할 수 있는 형식으로 조정하는 설계패턴 이 경우에는 ```RecyclerView.```에 표시할 수 있도록`loadAffirmations()`에서 반환된 목록에서 `Affirmation` 인스턴스를 가져와 목록 항목 뷰로 전환하는 어댑터가 필요함.

##### ViewHolder 만들기

`RecyclerView`는 항목 뷰와 직접 상호작용하지 않는 대신 `ViewHolders`를 처리함. `ViewHolder`는 `RecyclerView`의 단일 목록 항목 뷰를 나타내며 가능한 경우 재사용할 수 있음. `ViewHolder` 인스턴스는 목록 항목 레이아웃 안에 개별 뷰의 참조를 보유합니다(따라서 이름이 '뷰 홀더'임). 이렇게 하면 새로운 데이터로 목록 항목 뷰를 더 쉽게 업데이트할 수 있음. 뷰 홀더는 `RecyclerView`가 화면에서 뷰를 효율적으로 이동하기 위해 사용하는 정보도 추가함.

```ViewHolder```를 ```ItemAdapter```안에 만드는데 다른 클래스 내부에 클래스를 정의하니 중첩클래스임.

##### getItemCount() 구현하기

`getItemCount()` 메서드는 데이터 셋의 크기를 반환해야 함. 앱의 데이터는 `ItemAdapter` 생성자에 전달하는 `dataset` 속성에 있으며, `size`를 사용해 데이터의 크기를 가져올 수 있습니다.

```kotlin
override fun getItemCount(): Int {
    return dataset.size
}
```



##### onCreateViewHolder() 구현하기

`onCreateViewHolder()` 메서드는 `RecyclerView`의 새 뷰 홀더를 만들기 위해 레이아웃 관리자가 호출(재사용할 수 있는 기존 뷰 홀더가 없는 경우). 뷰 홀더는 단일 목록 항목 뷰를 나타냄.

`onCreateViewHolder()` 메서드는 두 매개변수를 사용하며 새 `ViewHolder`를 반환

`viewType` 매개변수: 동일한 `RecyclerView`에 항목 뷰 유형이 여러 개 있을 때 중요해짐`RecyclerView` 내에 다른 목록 항목 레이아웃이 표시된다면 다른 항목 뷰 유형이 있는 것. 동일한 항목 뷰 유형을 가진 뷰만 재활용할 수 있음. 이 경우에는 목록 항목 레이아웃이 하나만 있고 항목 뷰 유형이 하나이므로 이 매개변수에 관해 걱정할 필요가 없다.

1. `onCreateViewHolder()` 메서드에서 제공된 컨텍스트(`parent`의 `context`)에서 `LayoutInflater` 인스턴스를 가져옵니다. 레이아웃 인플레이터는 XML 레이아웃을 뷰 객체의 계층 구조로 확장하는 방법을 알고 있습니다.

```kotlin
val adapterLayout = LayoutInflater.from(parent.context)
```

2. 가져온 `LayoutInflater` 객체 인스턴스에 마침표를 추가하고 그 뒤에 다른 메서드 호출을 배치하여 실제 목록 항목 뷰를 확장합니다. XML 레이아웃 리소스 ID `R.layout.list_item` 및 `parent` 뷰 그룹을 전달합니다. 세 번째 부울 인수는 `attachToRoot`입니다. 이 인수는 `false`여야 합니다. 왜냐하면 적절한 때가 되면 `RecyclerView`가 이 항목을 뷰 계층 구조에 추가하기 때문입니다.

```kotlin
val adapterLayout = LayoutInflater.from(parent.context)
       .inflate(R.layout.list_item, parent, false)
```

이제 `adapterLayout`은 목록 항목 뷰의 참조를 보유합니다(나중에 이 참조에서

`TextView` 같은 하위 뷰를 찾을 수 있음).

3. `onCreateViewHolder()`에서 루트 뷰가 `adapterLayout`인 새 `ItemViewHolder` 인스턴스를 반환합니다.

```kotlin
return ItemViewHolder(adapterLayout)
```

##### onBindViewHolder() 구현하기

이 메서드는 목록 항목 뷰의 콘텐츠를 바꾸기 위함 

`onBindViewHolder()` 는 두 개매개변수가 있는데 하나는 `onCreateViewHolder()`에서 생성된 `onCreateViewHolder()`이고 하나는 현재 항목 `position`을 나타내는 `int`임. 이 메서드는 우치ㅣ를 기븐으로 dataset에서 올바른`Affirmation` 객체를 찾음.

1. `onBindViewHolder()` 내부에 `val` `item`을 만들고 `dataset`의 지정된 `position`에 항목을 가져옵니다.

```kotlin
val item = dataset[position]
```

마지막으로 이 항목의 올바른 데이터를 반영하도록 뷰 홀더가 참조하는 모든 뷰를 업데이트해야함.

`Affirmation` 객체 인스턴스를 사용하면 `item.stringResourceId`를 호출하여 상응하는 문자열 리소스 ID를 찾을 수 있습니다. 하지만 이 ID는 정수이며, 실제 문자열 값에 관한 매핑을 찾아야 하므로 문자열 리로스 ID로 `getString()`을 호출하면 연결된 문자열 값이 반환됨. `getString()`은 `Resource`클래스의 메서드이며 `context`를 통해 `Resource` 클래스의 인스턴스를 가져올 수 있음.

즉 `context.resource.getString()`을 호출하고 문자열 리소스  ID를 전달할 수 있음. 결과 문자열을 `holder` `ItemViewHolder`에서 `textView`의 `text`로 설정할 수 있음. 간단히 말해, 이 코드 줄은 뷰 홀더를 업데이트하여 확인 문자열을 표시하도록 합니다. 

```kotlin
holder.textView.text = context.resources.getString(item.stringResourceId)
```

##### 완성된 어댑터코드

```kotlin
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
```

`ItemAdapter`구현을  마쳤으므로 어댑터를 사용하도록 `RecyclerView`에 알려야함.

##### RecyclerView를 사용하도록 MainActivity 수정하기

완료하기 위하여 `Datasource`클래스와 `ItemAdapter`클래스를 사용해 `RecyclerView`에 항목을 만들고 표시.

1. `Datasource` 인스턴스를 만들고 이 인스턴스에서 `loadAffirmations()` 메서드를 호출합니다. 반환된 확인 목록을 `myDataset`라는 `val`에 저장

```kotlin
val myDataset = Datasource().loadAffirmations()
```

2. `recyclerView`라는 변수를 만들고 `findViewById()`를 사용하여 레이아웃 내에서 `RecyclerView` 참조를 찾습니다.

```kotlin
al recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
```

3. 만든 `ItemAdapter` 클래스를 사용하도록 `recyclerView`에 알리려면 새 `ItemAdapter` 인스턴스를 만듭니다. `ItemAdapter`에는 두 매개변수, 즉 이 활동의 컨텍스트(`this`)와 `myDataset`의 확인 값이 필요합니다.
4. `ItemAdapter` 객체를 `recyclerView`의 `adapter` 속성에 할당

```kotlin
recyclerView.adapter = ItemAdapter(this, myDataset)
```

5. 활동 레이아웃에서 `RecyclerView`의 레이아웃 크기가 고정되어 있으므로 `RecyclerView`의 `setHasFixedSize` 매개변수를 `true`로 설정할 수 있습니다. 성능을 개선하기 위해서만 이 설정이 필요합니다. 콘텐츠를 변경해도 `RecyclerView`의 레이아웃 크기가 변경되지 않는다는 것을 아는 경우 이 설정을 사용

```kotlin
recyclerView.setHasFixedSize(true)
```

<hr/>

#### Quiz

1. 아래 코드를 실행하기 전에 simpleList를 **변경가능한** 목록으로 초기화해야 합니다.

```
println(simpleList)
simpleList.add(-5)
simpleList.remove(4)
println(simpleList)
```

2. 다음 중 올바른 설명은 무엇인가요?

적절한 답변을 모두 선택합니다.

- `val list = listOf(1, 2, 5)`

- `val oddNumbers = mutableListOf("1", "9", "15")`

- `val words: List<String> = listOf("jump", "run", "skip")`

3. `RecyclerView`에 어댑터가 필요한 이유는 무엇인가요?

- 새 `ViewHolders`를 만들고 데이터를 바인딩

4. 다음 중 `RecyclerView` 사용의 이점은 무엇인가요?

- `RecyclerView`는 기본 제공 레이아웃 관리자와 함께 제공됩니다
- `RecyclerView`를 사용하면 처리 시간을 절약하여 목록을 더욱 부드럽게 스크롤할 수 있습니다.

- `RecyclerView`는 화면 밖으로 스크롤된 뷰를 다시 사용하여 목록의 효율성을 높이도록 설계되었습니다.

5. 다음 중 패키지와 관련해 맞는 설명은 무엇인가요?

- 패키지를 사용하여 코드를 구성할 수 있습니다

- 다른 패키지의 클래스를 사용하려면 코드에서 명시적으로 가져와야 합니다.
- 패키지를 사용하여 기능별로 클래스를 그룹화하는 것이 좋습니다.

6. 알맞은 유형의 리소스 ID가 생성자에 전달되도록 하려면 어떻게 해야 하나요?

- 리소스 주석을 사용합니다.

7. 빈 칸 채우기

아래 코드에서` num in numbers` 은(는) for 루프에 작성하여 반환된 출력이 한 줄에 숫자가 하나씩 출력된 1~3의 숫자 목록이 되도록 해야 합니다.

```
val numbers = listOf(1, 2, 3)
for (_______) {
  println(num)
}
```

