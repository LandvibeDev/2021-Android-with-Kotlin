# Unit2-Pathway3



* **Kotlin에서 List 사용**

  * **List 소개**
    * `List` : 만든 후 수정 불가(읽기 전용) - listOf()를 호출하여 만들면 됨
    * `MutableList` : 만든 후 수정 가능, 요소 추가, 삭제, 업데이트 가능(변경 가능) - mutableListOf()를 호출하여 만들면 됨
    * `contain()` : List에 해당 원소가 존재하면 true, 아니면 false 반환
    * `reversed()` : 원소가 역순으로 있는 새로운 List 반환
    * `sorted()` : 원소가 오름차순으로 정렬된 새 List 반환
  * **MutableList 소개**
    * `add()` : MutableList에 원소를 추가, 성공적으로 추가되면 true, 아니면 false 반환
    * `addAll()` : MutableList에 한 번에 여러 원소를 추가하고 List를 전달할 수 있으며 `add()` 와 마찬가지로 성공 여부를 반환
    * `remove()` : MutableList에서 원소를 삭제, 성공적으로 삭제되면 true, 아니면 false 반환
    * `removeAt()` : MutableList에 index로 접근하여 원소를 삭제하며 삭제된 원소를 반환
    * `clear()` : 전체 MutableList를 삭제
    * `isEmpty()` : MutableList가 비어있으면 true, 아니면 false 반환
  * **List 반복**
    * `while`
    * `for` - iterator 활용하면 더욱 효과적으로 사용 가능
  * **완성된 모양**
    * `vararg` : 가변 인자. 가변 인자를 사용하면 함수를 호출할 때 인자 개수를 유동적으로 지정할 수 있으며, 인자 앞에 `vararg` 키워드를 붙이면 됨. 일반적으로 List의 마지막 매개변수임
    * `joinToString()` : 쉼표로 문자열을 구분하면서 계속 add해주는 kotlin method

* **RecyclerView를 사용하여 스크롤 가능한 목록 표시하기**

  * **시작하기 전에**

    * `RecyclerView` 는 화면에서 스크롤된 뷰를 재사용하거나 재활용하여 목록이 큰 경우에도 매우 효율적으로 작동하도록 설계됨
    * 화면에서 목록 항목이 스크롤되면 `RecyclerView` 는 표시할 다음 목록 항목에 이 뷰를 재활용함으로써, 처리 시간을 크게 단축하고 목록이 더 원활하게 스크롤되도록 도와줌

  * **데이터 목록 설정하기**

    * data class 만들기
      * data class에는 속성이 하나 이상 정의되어 있어야 함
      * data class 생성자에 매개변수 추가할 수 있음
    * dataSource가 되는 클래스 만들기
      * `loadAffirmations()` : List<Affirmation> 을 return

  * **앱에 RecyclerView 추가하기**

    * RecyclerView 관련 항목들

      * `item` : 표시할 목록의 단일 데이터 항목, 앱의 `Affirmation` 객체 하나를 나타냄
      * `Adapter` : `RecyclerView` 에서 표시할 수 있도록 데이터를 가져와 준비함
      * `ViewHolder` : `Affirmation` 을 표시하기 위해 사용하거나 재사용할 `RecyclerView` 용 뷰의 풀
      * `RecyclerView` : 화면에 표시되는 뷰

    * 레이아웃에 RecyclerView 추가

      * `layoutManager` : Linear, Grid, StaggeredGrid 3가지 타입 존재
      * `scrollbars` : 스크롤 방향, vertical과 horizontal

    * RecyclerView용 Adapter 구현

      * `Adapter` : `Data`를 `RecyclerView` 에서 사용할 수 있는 형식으로 조정하는 설계 패턴
      * `RecyclerView` 는 목록의 첫 번째 `item`을 위한 새 목록 `item` 뷰를 만들도록 `Adapter` 에 요청하고, 뷰가 생성된 후에는 `item`을 그리기 위한 데이터를 제공하도록 `Adapter` 에 요청

    * Adapter 만들기

      * item의 레이아웃 만들기

        * 이 item 레이아웃이 확장되어 상위 `RecyclerView` 에 하위 요소로 추가되므로 레이아웃 주위에 `ViewGroup` 이 필요하지 않음

      * Adapter 클래스 만들기

        * `List<Affirmation>` 을 전달할 수 있도록 `Adapter` 생성자에 매개변수를 추가
        * 문자열 리소스를 확인하는 방법에 관한 정보가 필요한데, 이런 정보와 기타 앱 관련 정보는 `Adapter` 인스턴스에 전달할 수 있는 `Context` 객체 인스턴스에 저장되므로 `Adapter` 생성자에 `context` 라는 매개변수를 추가

      * Adapter 클래스 내부에 ViewHolder 만들기

        * `RecyclerView` 는 `item` 뷰와 직접 상호작용하지 않고 `ViewHolder` 를 처리함
        * `ViewHolder` 는 `RecyclerView` 의 단일 `List item` 뷰를 나타내며 가능한 경우 재사용 가능
        * `ViewHolder` 인스턴스는 `List item` 안에 개별 뷰의 참조를 보유하며, 이렇게 해서 새로운 데이터로 `List item` 뷰를 더 쉽게 업데이트할 수 있음
        * `ViewHolder` 는 `RecyclerView` 가 화면에서 뷰를 효율적으로 이동하기 위해 사용하는 정보도 추가
        * `RecyclerView.ViewHolder` 를 상속받으며, view를 매개변수로 넘겨받고, `item.xml` 을 `ViewHolder` 내부에서 각각의 타입별로 할당해줌

      * Adapter 메서드 재정의하기

        * `RecyclerView.Adapter` 를 `adapter` 가 상속받으며, `RecyclerView.Adapter<Adapter.ViewHolder>` 로 `ViewHolder` 유형을 지정

        * 반드시 구현해야 할 추상 메서드 3가지

          * `onCreateViewHolder()`

            ```kotlin
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
                // create a new view
                val adapterLayout = LayoutInflater.from(parent.context)
                    .inflate(R.layout.list_item, parent, false)
            
                return ItemViewHolder(adapterLayout)
            }
            ```

          * `getItemCount()`

            ```kotlin
            override fun getItemCount() = dataset.size
            ```

          * `onBindViewHolder()`

            ```kotlin
            override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
                val item = dataset[position]
                holder.textView.text =  context.resources.getString(item.stringResourceId)
            }
            ```

      * RecyclerView를 사용하도록 MainActivity 수정하기

        * `setHasFixedSize()` : 콘텐츠를 변경해도 `RecyclerView` 의 레이아웃 크기가 변경되지 않는다는 것을 아는 경우 이 설정 사용



### Quiz

1. **Fill-in-the-blanks**

   Before running the below code, simpleList should be initialized as a `mutable` list.

   ```kotlin
   println(simpleList)
   simpleList.add(-5)
   simpleList.remove(4)
   println(simpleList)
   ```

2. **Which of the following statements are valid?**

   ```kotlin
   val list = listOf(1, 2, 5)
   ```

   ```kotlin
   val oddNumbers = mutableListOf("1", "9", "15")
   ```

   ```kotlin
   val words: List<String> = listOf("jump", "run", "skip")
   ```

3. **Why does a `RecyclerView` need an Adapter?**

   * To create new `ViewHolders` and bind data to them

4. **Which of the following are advantages to using `RecyclerView`?**

   * `RecyclerView` comes with built-in layout managers.
   * `RecyclerView` helps save processing time, which can help scrolling through a list smoother.
   * `RecyclerView` is designed to be efficient for lists by reusing views that have scrolled off the screen.

5. **Which of the following is true about packages?**

   * You can use packages to organize your code.
   * In order to use a class from another package, you have to explicitly import it in your code.
   * It is good practice to use packages to group classes by functionality.

6. **What should you do to ensure that the correct type of resource ID is passed in to a constructor?**

   * Use resource annotations.

7. **Fill-in-the-blanks**

   In the below code, `num in numbers` should be written in the for loop, so that the output returned is the list of numbers 1 through 3, with each number printed on a new line.

   ```kotlin
   val numbers = listOf(1, 2, 3)
   for (_______) {
     println(num)
   }
   ```