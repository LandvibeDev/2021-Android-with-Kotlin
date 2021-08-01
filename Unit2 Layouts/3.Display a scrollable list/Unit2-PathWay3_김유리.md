# 2021 Landvibe Summer Coding - Android

## Unit2 - Layouts

## PathWay3 - Display a scrollable list

### Kotlin에서 목록 사용

##### &#128204;목록 소개

- 목록 유형

  - 읽기 전용 목록 : `List` 만든 후 수정할 수 없음
  - 변경 가능한 목록 : `MutableList` 만든 후 수정 가능

- 목록 만들기

  1. Kotlin 플레이그라운드를 열고 제공된 기존 코드 삭제

  2. 빈 `main()`함수 추가

  3. `main()`내부에서 `List<Int>`유형의 `numbers`변수 생성 

  4. `listOf()`함수를 사용해 새 `List`를 만들어 목록의 요소를 쉼표로 구분된 인수로 전달하고 `number`에 할당

  5. 할당 연산자 오른쪽에 있는 값에 기반하여 추측,추론할 수 있으면 변수 데이터 유형 생략 가능

     ```kotlin
     val numbers = listOf(1,2,3,4,5,6)
     ```

  6. `println()`을 사용해 `numbers`목록과 목록의 크기 출력

     ```kotlin
     println("List : $numbers")
     println("Size : &{numbers.size}")
     ```

- 액세스 목록 요소

  - **Index**는 첫번째 요소의 오프셋이다.
  - 원하는 **Index** 요소를 쓸 땐  `get()`함수를 `numbers.get(0)`또는 `numbers[0]`으로 사용한다.
  - `first()`및 `last()`함수는 첫 번째 요소와 마지막 요소 반환한다.
  - `contains()`메서드를 통해 주어진 요소가 목록에 있는지 확인할 수 있다. - `true`또는 `false`반환

- 읽기 전용인 목록

  1. Kotlin 플레이그라운드에서 코드 삭제 후 다음 코드로 변경

     ```kotlin
     fun main(){
     	val colors = listOf("green", "orange","blue")
     }
     ```

  2. `reversed()`메서드로 `colors`목록 역전

  3. `sorted()`메서드로 정렬된 목록 반환



##### &#128204;변경 가능한 목록 소개

- 변경 가능한 목록 만들기

  1. `main()`에서 기존 코드 삭제

  2. `main()`함수 내에서 변경 가능한 빈 목록을 만들고 `entrees`라는 `val`변수에 할당

  3. 요소 없이 빈 목록을 초기화하기 위해 유형을 명시

     ```kotlin
     val entrees = mutableListOf<String>()
     ```

- 목록에 요소 추가

  1. `entrees.add("noodles")`를 사용해 목록에 `"noodles"`추가 - 목록에 요소가 성공적으로 추가되면 `true`반환, 그렇지 않으면 `false`

  2. `moreItems`목록을 만들고 `addAll()`를 사용하여 새 목록의 항목을 모두 `entrees`에 추가

     ```kotlin
     val moreItmes = listOf("ravioli", "lasagna", "fettuccine")
     println("Add list : &{entrees.addAll(moreItems)}")
     ```

- 목록에서 요소 삭제

  1. `remove()`메서드를 호출하여 목록에서 `"spaghetti"`삭제 - 목록에 요소가 성공적으로 삭제되면 `true`반환, 그렇지 않으면 `false`
  2. `removeAt()`메서드를 사용하여 삭제할 요소의 **Index**지정
  3. 전체 목록을 삭제하려면 `clear()`호출
  4. `isEmpty()`메서드를 사용하여 목록이 비어 있는지 확인 - 비어있으면 `true`, 그렇지 않으면 `false`



##### &#128204;목록 반복

- while 루프

  - 괄호 안 표현식이 true인 한 계속해서 반복 실행됨
  - 무한 루프가 되지 않으려면 표현식의 값을 변경하는 로직을 포함해야 함

- for 루프

  - 괄호안에 코드 블록 실행 조건이 표시되어 있음

  - 목록에서 for 루프 사용

    ```kotlin
    for (item in list) print(item) // Iterate over items in a list
    
    for (item in 'b'..'g') print(item) // Range of characters in an alphabet
    
    for (item in 1..5) print(item) // Range of numbers
    
    for (item in 5 downTo 1) print(item) // Going backward
    
    for (item in 3..6 step 2) print(item) // Prints: 35
    ```



##### &#128204;완성된 모양

- 음식 주문 프로그램

  - `Item`클래스의 서브 클래스`Noodles`,`Vegetables`
  - `Item`은 상위 클래스이고 서브 클래스가 상위 클래스에서 확장되므로 클래스는 `open`키워드와 함께 표시

- toString() 메서드 정의

  - 객체 인스턴스를 출력하면 객체의 `toString()`메서드가 호출되는데 `Noodels@5451c3a8`보다 더 의미있게 재정의해야 함

  1. `Noodles`클래스 내에서 `toString()`메서드를 재정의해 메서드에서 `name`을 반환 		
  2. `Vegetables`클래스도 동일하게 작업

- 주문에서 채소 맞춤 설정

  1. `main()`함수에서 입력 인수가 없는 `Vegetables`인스턴스를 초기화하는 대신 고객이 원하는 특정 채소 유형 전달

     ```kotlin
     fun main() {
     	...
     	val vegetables = Vegetables("Cabbage", "Sprouts", "Onion")
     	...
     }
     ```

  2. 문자열 매개변수 3개를 사용하도록 `Vegetables`클래스 헤더 업데이트

     ```kotlin
     class Vegetables(val topping1: String, val topping2: String, val topping3: String) : Item ( "Vegetables", 5)
     ```

     - 고객이 정확히 채소 3개를 항상 주문하려는 경우에만 쓸 수 있음

  3. `Vegetables`클래스의 생성자에 채소 목록을 허용 - `List<String>`

     ```kotlin
     class Vegetables(val toppings: List<String>) : Item("Vegetables", 5)
     ```

  4. `vararg`수정자를 사용하면 동일한 유형의 가변적인 인수 수를 함수나 생성자에 전달 가능 - 개별 문자열로 다양한 채소 제공 가능

     ```kotlin
     class Vegetables(vararg val toppings: String) : Item("Vegetables", 5)
     ```

     - 매개변수 하나만 `vararg`로 표시할 수 있으며 이 하나는 일반적으로 목록의 마지막 매개 변수임
     - 이미 존재하는 배열을 vararg 함수의 인자로 넘겨야할 땐 배열 이름 앞에 `*`을 붙임

  5. `Vegetables`클래스의 `toString()`메서드를 수정

     ```kotlin
     class Vegetables( vararg val toppings: String) : Item("Vegetables", 5) {
     	override fun toString(): String{
     		return name + " " + toppings.joinToString()
     	}
     }
     ```

     - 쉼표 외에 다른 구분자를 지정하려면 원하는 구분자 문자열을 `joinToString()`메서드의 인수로 전달

  6. 채소 선택의 기본값으로 셰프가 선택한 채소를 제공하도록 업데이트

     ```kotlin
     override fun toString(): String {
         if (toppings.isEmpty()) {
             return "$name Chef's Choice"
         } else {
             return name + " " + toppings.joinToString()
         }
     }
     ```

- 주문 만들기

  1. 정수 `orderNumber`생성자 매개변수가 있는 `class``Order`생성

  2. 주문의 모든 항목을 미리 알지 못할 수 있으므로 전달할 항목 목록은 불필요

  3. 대신 최상위 클래스 변ㅇ수로 선언하고 `Item`유형의 요소를 보유할 수 있는 빈 `MutableList`로 초기화

     ```kotlin
     class Order(val orderNumber: Int) {
     	private val itemList = mutableListOf<Item>()
     }
     ```

  4. `addItem()`메서드 구현 - 새 `Item`을 가져오고 `itemList`에 새 항목 추가

     ```kotlin
     fun addItem(newItem: Item) {
     	itemList.add(newItem)
     }
     ```

  5. `addAll()`메서드 구현 - 가져온 읽기 전용 항목 목록을 내부 항목 목록에 추가

     ```kotlin
     fun addAll(newItems: List<Item>){
     	itemList.addAll(newItems)
     }
     ```

  6. `itemList`에 있는 각 `item`을 먼저 출력하고 항목의 `price`를 출력

  7. 현재 항목의 가격을 `total`에 추가하여 총계에 계속 추가

- 주문 만들기

  1. `main()`함수 내용 삭제

  2. `Order`인스턴스를 만들어 코드 테스트

     ```kotlin
     fun main() {
     	val order1 = Order(1)
     	order1.addItem(Noodles())
     	order1.print()
     	
     	println()
     	
     	val order2 = Order(2)
     	order2.addItem(Noodles())
     	order2.addItem(Vegetables())
     	ordere2.print()
     	
     	println()
     	
     	val order3 = Order(3)
     	val items = listOf(Noodles(), Vegetables("Carrots", "Beans", "Celery"))
     	order3.addAll(items)
     	order3.print()
     }
     ```



##### &#128204;코드 개선

- 주문 목록 유지

  1. 모든 주문을 저장할 변경가능한 목록 생성

  2. 다음 코드 `main()`함수에 추가하고 각 주문이 만들어지면 목록에 주문 추가

     ```kotlin
     fun main() {
         val ordersList = mutableListOf<Order>()
     
         val order1 = Order(1)
         order1.addItem(Noodles())
         ordersList.add(order1)
     
         val order2 = Order(2)
         order2.addItem(Noodles())
         order2.addItem(Vegetables())
         ordersList.add(order2)
     
         val order3 = Order(3)
         val items = listOf(Noodles(), Vegetables("Carrots", "Beans", "Celery"))
         order3.addAll(items)
         ordersList.add(order3)
     }
     ```

  3. 주문 목록이 있으면 루프를 사용해 각 주문 출력 가능

     ```kotlin
     for (order in orderList) {
     	order.print()
     	println()
     }
     ```

- 주문의 빌더 패턴 구현

  - 빌더 패턴은 단계별 접근 방식으로 복잡한 객체를 빌드할 수 있는 프로그래밍의 디자인 패턴

  1. `Order`클래스의 `addItem()`및 `addAll()`메서드에서 `Unit`(또는 아무것도 없음)을 반환하는 대신 변경된 `Order`를 반환 - `this`키워드를 사용해 현재 객체 인스턴스 참조

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

  2. 이 코드는 새 `Order`를 만들고 빌더 패턴을 활용 

     ```kotlin
     val order4 = Order(4).addItem(Noodles()).addItem(Vegetables("Cabbage", "Onion"))
     orderList.add(order4)
     ```

     - 빌더 패턴 : 복합 객체의 생성 과정과 표현 방법을 분리하여 동일한 생성 절차에서 서로 다른 표현 결과를 만들 수 있게 하는 패턴
     
  3. 실제로 주문을 변수에 저장 x , `main()`함수에서 주문을 출력하는 최종 루프 전에 `Order`를 직접 만들어 `orderList`에 추가
  
     ```kotlin
     ordersList.add(
     	Order(5)
     		.addItem(Noodles())
     		.addItem(Noodles()) 
     		.addItem(Vegetables("Spinach")))
     ```



### RecyclerView를 사용하여 스크롤 가능한 목록 표시하기

##### &#128204;데이터 목록 설정하기

- 확인 문자열 추가하기

  1. **strings.xml** 열기

  2. 다음 확인을 개별 문자열 리소스로 추가, 이름을 `affirmation1`, `affirmation2`등으로 지정

     ```kotlin
     <resources>
         <string name="app_name">Affirmations</string>
         <string name="affirmation1">I am strong.</string>
         <string name="affirmation2">I believe in myself.</string>
         <string name="affirmation3">Each day is a new opportunity to grow and be a better version of myself.</string>
         <string name="affirmation4">Every challenge in my life is an opportunity to learn from.</string>
     	...
     </resources>
     ```

- 새 패키지 만들기

  - 패키지 : 클래스를 분류해서 모아둔 것, 동일한 클래스 이름을 사용하는 클래스가 있을 때 충돌을 피할 수 있음 
  - 패키지 사용법 
    - 코드 여러 부분별로 서로 다른 패키지 만들기 - ex) 데이터 작업과 UI를 서로 다른 패키지로 빌드하는 클래스로 구분
    - 코드에 있는 다른 패키지의 코드 사용 - ex) 정규화된 이름(`android.widget.TextView`) 대신 축약 이름 (`TextView`)사용할 수 있도록 클래스를 코드에 `import`
  - 패키지 이름 지정하기
    - 고유한 이름 사용 - 위치에 관계없이 게시된 다른 패키지 이름 같을 수 없음
    - 일반에서 구체적인 순서로 구성, 각 부분을 소문자로 표기하고 마침표로 구분 ( 마침표는 이름의 일부일 뿐임) 
    - 인터넷 도메인은 전역적으로 고유하므로, 이름 첫 부분에 개발자 도메인이나 비즈니스의 도메인 사용
    - 패키지에 포함된 내용 및 패키지 간 관계 표시 가능
  - 패키지 만들기
    1. **com.example.affirmations**를 마우스 오른쪽 버튼으로 클릭 후 **New > Package** 선택
    2. 팝업에서 제안된 패키지 이름의 접두어는 마우스 오른쪽 버튼으로 클릭한 패키지의 이름 - 이름이 계층 구조를 만들진 않지만, 콘텐츠의 관계와 구성을 나타내기 위해 일부 재사용하기도 함
    3. 패키지 이름 끝에 **model** 추가 - 데이터를 모델링하거나 표현하는 클래스 패키지 이름으로 **model**을 사용하는 경우가 많음

- Affirmation 데이터 클래스 만들기

  1. **com.example.affirmation.model**패키지를 마우스 오른쪽 버튼으로 클릭 후 **New > Kotlin File/Class** 선택
  2. 팝업에서 **Class**를 선택하고 클래스 이름으로 `Affirmation`입력
  3. 클래스 정의 앞에 `data`키워드 추가해 `Affirmation`을 데이터 클래스로 만듦 -> 오류 - 데이터 클래스에 속성이 하나 이상 정의되어 있어야 함
  4. `val` 정수 매개변수 `stringResourceId`를 `Affirmation`클래스의 생성자에 추가

- 데이터 소스가 되는 클래스 만들기

  - 데이터는 다른 소스에서 가져올 수도 있음 -> 필요한 형식이 아닌 데이터를 얻을 수도 있음
  - 앱의 나머지 부분은 데이터의 출처나 데이터의 원래 형식을 염려하지 않아야 함 -> 앱 데이터를 준비하는 별도의 `Datasource`클래스에 데이터 준비를 숨겨야 함

  1. **com.example.affirmations**를 오른쪽 마우스로 클릭하고 **New > Package**선택

  2. 패키지 이름의 마지막 부분으로 `data`입력

  3. `data`패키지를 마우스 오른족 버튼으로 클릭하고 **new Kotlin File/Class**선택

  4. `Datasource`라는 클래스 만들고 내부에 `loadAffirmations()`라는 함수 생성 

  5. `List<Affirmation>`을 `loadAffirmations()`메서드의 반환 유형으로 선언 후 함수 본문에 `return `문 추가

  6. `return`키워드 다음에 `listOf<>()`를 호출해 `List`생성

  7. 꺽쇠 괄호 안에 목록 항목 유형을 `Affirmation`으로 지정

  8. 괄호 안에 `Affirmation`을 만들고 리소스 ID로 `R.string.affirmation1`전달

     ```kotlin
     Affirmation(R.string.affirmation1)
     ```

  9. `Affirmation`객체를 쉼표로 구분해 모든 확인 목록에 추가

- TextView에 확인 목록의 크기 표시하기

  - 확인 목록을 만들 수 있는지 확인하려면 `loadAffirmations()`를 호출하고 반환된 확인 목록의 크기를 `TextView`에 표시

  1. `activity_main.xml`의 `TextView`에 `textview`의 id 제공

  2. `MainActivity`에서 기존 코드 뒤에 있는 `onCreate()`메서드에 `textview`참조 가져옴

     ```kotlin
     val textView: TextView = findViewById(R.id.textview)
     ```

  3. 확인 목록의 크기를 생성하여 표시하는 코드 추가 - `Datasource`를 만들고, `loadAffirmations()`를 호출하고, 반환된 목록의 크기를 가져와 문자열로 변환하고 `textView`의 `text`로 할당

  4. 앱 실행해서 확인 후 코드 삭제 



##### &#128204;앱에 RecyclerView 추가하기

- `RecyclerView` 목록을 설정해 `Affirmations`목록 표시

  - 항목 - 표시할 목록의 단일 데이터 항목, 앱의 `Affirmation`객체 하나를 나타냄

  - 어댑터 - `RecyclerView`에서 표시할 수 있도록 데이터 가져와 준비

  - **ViewHolder** - 확인을 표시하기 위해 사용하거나 재사용할 `RecyclerView`용 뷰의 풀

  - **RecyclerView** - 화면에 표시되는 뷰

    <img src="https://developer.android.com/codelabs/basic-android-kotlin-training-recyclerview-scrollable-list/img/4e9c18b463f00bf7.png" alt="4e9c18b463f00bf7.png" style="zoom:67%;" />	

- 레이아웃에 RecyclerView 추가하기

  1. `acitivity_main.xml`을 **Split**뷰로 열기

  2. `TextView`삭제

  3. 한 레이아웃에 하위 뷰 여러 개를 배치하려면 `ConstraintLayout`이 가장 적합하지만 레이아웃에 단일 하위 뷰 `RecyclerView`만 있으므로 더 간단한 `ViewGroup`인 `FrameLayout`으로 전환

  4. **Design**뷰로 전환

  5. **Palette**에서 **Containers**선택 후 **RecyclerView**찾아 레이아웃으로 드래그

  6. 팝업이 표시되면 **OK**클릭

  7. `RecyclerView`가 전체 화면을 채울 수 있도록 필요한 경우 `layout_width`속성과 `layout_height`속성을 `match_parent`로 변경

  8. `RecyclerView`의 리소스 ID를 `recycler_view`로 설정

  9. 다시 **Code**뷰로 전환하고 XML 코드의 `RecyclerView`요소 내부에 `LinearLayoutManager`를 `RecyclerView`의 레이아웃 관리자 속성으로 추가 - `LayoutManager`에서 항목 정렬 처리, 세로 목록으로 표시하기 위해 `LinearLayoutManager`사용

  10. 화면 보다 긴 항목의 세로 목록을 스크롤할 수 있으려면 세로 스크롤바 추가 - `RecyclerView`내부에 `vertical`로 설정된 `android:scrollbars`속성 추가

      ```kotlin
      app:layoutManager="LinearLayoutManager"
      ```

  11. 데이터의 소스와 `RecyclerView`가 레이아웃에 추가되었지만 `RecyclerView`에는 `Affirmation`객체를 표시하는 방법에 관한 정보가 없음

- RecyclerView용 어댑터 구현하기

  - 앱에는 `Datasource`에서 데이터를 가져와 각 `Affirmation`을 `RecyclerView`에 항목으로 표시할 수 있도록 형식 지정하는 방법이 필요함
  - *어댑터*는 데이터를 `RecyclerView`에서 사용할 수 있는 형식으로 조정하는 설계 패턴 
  - 이 경우 `loadAffirmations()`에서 반환된 목록에서 `Affirmation`인스턴스를 가져와 목록 항목 뷰로 전환하는 어댑터가 필요
  - `RecyclerView`가 어댑터를 사용해 화면에 데이터 표시하는 방법 
    1. `RecyclerView`가 목록의 첫 번째 데이터 항목을 위한 새 목록 항목 뷰를 만들도록 어댑터에 요청
    2. 뷰가 생성된 후에는 항목을 그리기 위한 데이터를 제공하도록 어댑터에 요청
    3. 위 프로세스를 `RecyclerView`에 화면을 채울 뷰가 더이상 필요하지 않을 때까지 반복
    4. 한번에 목록 항목 뷰 3개만 화면에 들어가는 경우 전체 항목 뷰가 아님 3개만 준비하도록 어댑터에 요청
    5. 해당 단계에서는 `Affirmation`객체 인스턴스를 조정하는 어댑터를 빌드

- 어댑터 만들기

  - 항목의 레이아웃 만들기

    1. `list_item.xml`이라는 새로운 빈 파일 생성
    2. **Code**뷰에서 파일 열기
    3. `id``item_title`을 사용해 `TextView`추가
    4. `layout_width` 및 `layout_height`의 `wrap_content`추가

  - ItemAdapter 클래스 만들기

    1. **com.example.affirmations**를 마우스 오른쪽 버튼으로 클릭하고 **New > Package**선택
    2. 패키지 이름의 마지막 부분으로 `adapter`입력
    3. `adapter`패키지를 마우스 오른쪽 버튼으로 클릭하고 **New > Kotlin File/Class**선택 후 클래스 이름 `ItemAdapter`로 설정
    4. 확인 목록을 어댑터에 전달할 수 있도록 `ItemAdapter`의 생성자에 매개변수 추가 - `dataset`라는 `val`(`List<Affirmation>`유형)인 `private` 매개변수 추가
    5. 문자열 리소스를 확인하는 방법에 대한 정보를 `Context`객체 인스턴스에 저장 - 생성자에 `context`라는 `val`(`Context`유형)인 매개변수 추가

  - ViewHolder 만들기

    - `ViewHolder`는 `RecyclerView`의 단일 목록 항목 뷰와 화면에서 뷰를 효율적으로 이동하기 위해 사용하는 정보를 추가하며 가능한 경우 재사용할 수 있음 
    - `ViewHolder`인스턴스는 목록 항목 레이아웃 안에 개별 뷰의 참조를 보유 -> 새로운 데이터로 목록 항목 뷰를 더 쉽게 업데이트 가능

    1. `ItemAdapter`클래스 내부에서 닫는 중괄호 앞에 `ItemViewHolder`클래스 생성
       - 중첩 클래스 : 다른 클래스 내부에 클래스 정의
       - `ItemAdapter`만 `ItemViewHolder`를 사용하므로 중처 클래스로 생성해주면 ㄷ됨
    2. `View`유형의 `private``val``view`를 `ItemViewHolder` 클래스 생성자에 매개변수로 추가
    3. `ItemViewHolder`를 `RecyclerView`.`ViewHolder`의 서브클래스로 만들고 `view`매개변수를 슈퍼클래스 생성자에 전달
    4. `ItemViewHolder`내부에서 `TextView`유형인 `val `속성 `textView`를 정의 
    5. `list_item.xml`에서 정의한 ID `item_title`을 사용해 뷰를 할당

  - 어댑터 메서드 재정의하기

    1. 추상 클래스 `RecyclerView.Adapter`에서 `ItemAdapter`를 확장하는 코드 추가
    2. 꺽쇠 괄호 안에 뷰 홀더 유형으로 `ItemAdapter.ItemViewHolder`를 지정
    3. `ItemAdapter`에 커서를 놓고 **Control+I**를 눌러 구현해야하는 메서드를 모두 선택하고 **Ok**누르기

  - getItemCount() 구현하기

    - 데이터 세트의 크기 반환 - 앱의 데이터는 `dataset`속성에 있으며 `size`를 사용해 데이터 크기 가져올 수 있음

    1. `getItemCount()`를 다음으로 바꾸기

       ```kotlin
       override fun getItemCount() = dataset.size
       ```

  - onCreateViewHolder() 구현하기

    - `RecyclerView`의 새 뷰 홀더를 만들기 위해 레이아웃 관리자가 호출, 뷰 홀더는 단일 목록 항목 뷰를 나타냄
    - 두개의 변수를 사용해 새 `ViewHolder`반환
      - `parent`매개변수 : 새 목록 항목 뷰가 하위 요소로 사용되어 연결되는 뷰 그룹, 상위요소는 `RecyclerView`
      - `viewType`매개변수 : 동일한 `RecyclerView`에 항목 뷰 유형이 여러 개 있을 때 중요해짐, 다른 항목 레이아웃이 표시된다면 다른 항목 뷰 유혀잉 있다는 의미, 동일한 항목 뷰 유형을 가진 뷰만 재활용 가능 

    1. `onCreateViewHolder()`메서드에서 제공된 컨텍스트(`parent`의 `context`)에서 `LayoutInflater`인스턴스를 가져옴 - 레이아웃 인플레이터는 XML 레이아웃을 뷰 객체의 계층 구조로 확장하는 방법을 알고 있음

       ```kotlin
       val adapterLayout = LayoutInflater.from(parent.context)
       ```

    2. 가져온 `LayoutInflater` 객체 인스턴스에 마침표를 추가하고 그 뒤에 다른 메서드 호출을 배치해 실제 목록 항목 뷰 확장 

       ```kotlin
       val adpaterLayout = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
       ```

    3. `onCreateViewHolder()`에서 루트 뷰가 `adpaterLayout`인 새 `ItemViewHolder`인스턴스를 반환

       ```kotlin
       override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
           // create a new view
           val adapterLayout = LayoutInflater.from(parent.context)
               .inflate(R.layout.list_item, parent, false)
       
           return ItemViewHolder(adapterLayout)
       }
       ```

  - onBindViewHolder() 구현하기

    - `onCreateViewHolder()`메서드에서 생성된 `ItemViewHolder`와 목록에서 현재항목 `position`을 나타내는 `int` 총 두개의 매개변수가 있음
    - 이 메서드에서는 위치를 기반으로 데이터 세트에서 올바른 `Affirmation`객체를 찾음

    1. `onBindViewHolder()`내부에 `val``item`을 만들고 `dataset`의 지정된 `position`에 항목을 가져옴

       ```kotlin
       val item = dataset[position]
       ```

    2. 뷰 홀더가 참조하는 모든 뷰 업데이트 - 이 항목의 `Affirmation`문자열을 표시하도록 `TextView`의 텍스트 설정

    3. `Affirmation`객체 인스턴스를 사용해 `item.stringResourceId`를 호출해 상응하는 문자열 리소스 ID 찾기

    4. `context.resources.getString()`을 호출하고 문자열 리소스 ID를 전달할 수 있음 

    5. 뷰 홀더를 업데이트하여 확인 문자열 표시 - 결과 문자열을 `holder``ItemViewHolder`에서 `textView`의 `text`로 설정

- RecyclerView를 사용하도록 MainActivity 수정하기

  1. `MainActivity`에서 `onCreate()`메서드로 이동
  2. `setContentView(R.layout.activity_main)` 호출
  3. `Datasource`인스턴스를 만들고 이 인스턴스에서 `loadAffirmation()`메서드를 호출 후 반환된 확인 목록을 `myDataset`라는 `val`에 저장
  4. `recyclerView`라는 변수를 만들고 `findViewById()`를 사용해 레이아웃 내에서 `RecyclerView`참조 찾기
  5. 만든 `ItemAdapter`클래스를 사용하도록 `recyclerView`에 알리려면 새 `ItemAdapter`인스턴스 필요 - `ItemAdapter`에는 활동의 컨텍스트와 `myDataset`의 확인 값 매개변수가 필요
  6. `ItemAdapter`객체를 `recyclerView`의 `adapter`속성에 할당
  7. 활동 레이아웃에서 `RecyclerView`의 레이아웃 크기가 고정되어 있으므로 `RecyclerView`의 `setHasFixedSize`매개변수를 `true`로 설정 - 성능 개선 목적



### 카드를 사용하여 이미지 목록 표시

##### &#128204;목록 항목에 이미지 추가

- 이미지 다운로드
  1. 이미지를 다운받아 Android 스튜디오 내 프로젝트의 **res > drawable** 폴더로 복사 
- Affirmation 클래스에서 이미지 지원 추가
  1. `model`패키지 내의 `Affirmation.kt`파일 열기
  2. `imageResourceId`라는 또 다른 `Int`매개변수를 추가하여 `Affirmation`클래스의 생성자를 수정
- 리소스 주석 사용
  - 호출자가 실수로 잘못된 순서로 인수 전달하는 것을 방지하기 위해 리소스 주석을 사용 
  - 리소스 주석은 항상 @ 기호로 선언됨 
    1. `@StringRes`주석을 `stringResourceId`에 추가
    2. `@DrawableRes`주석을 `imageResourceId`에 추가
    3. 패키지 선언 뒤 파일의 상단에 `androidx.annotation.DrawableRes`및 `androidx.annotation.StringRes`가져오기를 추가했는지 확인
- 이미지로 긍정적 문구 목록 초기화
  1. `Datasource.kt`열기
  2. 각 `Affirmation`마다 이미지의 리소스 ID를 인수로 추가
- 목록 항목 레이아웃에 ImageView추가
  - 항목 레이아웃에 `ImageView`를 추가하고 `LinearLayout`을 사용해 뷰를 세로 열로 정렬
    1. **list_item.xml**열기 
    2. 기존 `TextView`주위에 `LinearLayout`을 추가하고 `orientation`속성을 `vertical`로 설정
    3. `xmlns schema`선언 줄을 `TextView`요소에서 `LinearLayout`요소로 이동해 오류 제거
    4. `LinearLayout`내에서 `TextView`앞에 리소스 ID가 `item_image`인 `ImageView`를 추가
    5. `ImageView`의 너비를 `match_parent`로 높이를 `194dp`로 설정
    6. `scaleType`을 `centerCrop`으로 설정
    7. 이미지가 장식용이므로 `importantAccessibility`속성을 `no`로 설정
- ItemAdapter를 업데이트하여 이미지 설정
  1. `adapter/ItemAdapter.kt`열기
  2. `ItemViewHolder`클래스로 이동
  3. `textView`속성의 초기화 아래에 `imageView`라는 `val`을 추가
  4. `findViewById()`를 사용해 ID가 `item_image`인 `ImageView`에 대한 참조를 찾아 이를 `imageView`속성에 할당
  5. `ItemAdapter`에서 `onBindViewHolder()`함수 찾기
  6. `imageResourceId`를 목록 항목 뷰의 `ImageView`로 설정



##### &#128204;세련되게 UI 수정

- 패딩 추가
  1. `list_item.xml`에 있는 `LinearLayout`에 `16dp`패딩 추가
  2. `item_title``TextView`에 `16dp`패딩 추가
  3. `TextView`에서 `textAppearance`속성을 `?attr/textAppearanceHeadline6`으로 설정 - `textAppearance`는 텍스트별 스타일을 정의할 수 있는 속성
- 카드 사용
  1. 기존 `LinearLayout`주위에 `MaterialCardView`를 추가
  2. 스키마 선언을 `LinearLayout`에서 `MaterialCardView`로 이동
  3. `MaterialCardView`의 `layout_width`를 `match_parent`로, `layout_height`를 `wrap_content`로 설정
  4. `8dp`의 `layout_margin`을 추가
  5. 공백이 너무 많지 않도록 `LinearLayout`에서 패딩을 삭제
- 앱 테마 색상 변경
  - 색상 리소스 추가
    1. `colors.xml`파일에 새 색상 리소스 추가
  - 테마 색상 변경
    1. `themes.xml` 열기
    2. `<!-- Primary brand color. -->`섹션 찾기
    3. `colorPrimary`를 추가하거나 변경하여 `@color/blue_500`을 사용
    4. `colorPrimaryVariant`를 추가하거나 변경하여 `@color/blue_700`을 사용
  - 어두운 테마 색상 업데이트
    1. 어두운 테마 `themes.xml`파일 열기
    2. `colorPrimary`및 `colorPrimaryVariant`테마 속성을 추가하거나 변경
- 앱 아이콘 변경
  1. `drawable/ic_launcher_background.xml`및 `drawable-v24/ic_launcher_foreground.xml`파일 삭제 - 두 파링릉 이전 앱 아이콘 용 파일
  2. **res > drawable**폴더를 마우스 오른쪽 버튼으로 클릭 후 **New > Image Asset**클릭
  3. **Configure Image Asset**창에서 **Foreground layer**가 선택되어 있는지 확인
  4. **Foreground Layer** 와 **Background Layer**의 **Path**에 다운로드한 파일 입력
  5. `drawable-v24`디렉토리가 비어있으면 삭제



#### &#128204;Quiz

1. 빈칸 채우기 

   - 아래 코드를 실행하기 전에 simpleList를 `변경 가능한`목록으로 초기화해야합니다.

     ```kotlin
     println(simpleList)
     simpleList.add(-5)
     simpleList.remove(4)
     println(simpleList)
     ```

2. 다음 중 올바른 설명은?

   - `val list = listOf(1,2,5)`
   - `val addNumbers = mutableListOf("1", "9", "15")`
   - `val words: List<String>  = listOf("jump", "run", "skip")`

3. `RecyclerView`에 어댑터가 필요한 이유는?

   - 새 `ViewHolders`를 만들고 데이터를 바인딩

4. 다음 중 `ReyclerView` 사용의 이점은?

   - `RecyclerView`는 기본 제공 레이아웃 관리자와 함께 제공됩니다.
   - `RecyclerView`를 사용하면 처리 시간을 절약하여 목록을 더욱 부드럽게 스크롤할 수 있습니다.
   - `RecyclerView`는 화면 밖으로 스크롤된 뷰를 다시 사용하여 목록의 효율성을 높이도록 설계되었습니다.

5. 다음 중 패키지와 관련해 맞는 설명은?

   - 패키지를 사용하여 코드를 구성할 수 있습니다.
   - 다른 패키지의 클래스를 사용하려면 코드에서 명시적으로 가져와야 합니다.
   - 패키지를 사용하여 기능벼롤 클래스를 그룹화하는 것이 좋습니다.

6. 알맞은 유형의 리소스ID가 생성자에 전달되도록 하려면 어떻게 해야하나?

   - 리소스 주석을 사용

7. 빈칸 채우기

   - 아래 코드에서 `조건`은 for루프에 작성하여 반환된 출력이 한 줄에 숫자가 하나씩 출력된 1~3의 숫자 목록이 되도록 해야 합니다.

     ```kotlin
     val numbers = listOf(1, 2, 3)
     for (_______) {
       println(num)
     }
     ```

     
