

# 2021 Landvibe Summer Coding - Android



## Unit3 : Navigation

## PathWay1 : Navigate between screens



### Collections in Kotlin

- **Collections**

  - 단어 목록이나 직원 기록 모음과 같은 관련 항목 그룹
  - 순서가 지정되거나 지정되지 않을 수 있음
  - 항목이 고유하거나 고유하지 않을 수 있음
  - list와 set은 collections의 한 유형임

- **Set**

  - 중복 x
  - 순서 중요하지 않음
  - 변경 가능한 집합(mutableSetOf)과 변경 불가능한 집합(setOf)에 동일한 숫자 집합을 가지고 있으면 다른 순서로 정렬이 되어 있어도 동일한 것으로 간주됨.

  ```kotlin
  fun main() {
      //list
      val numbers = listOf(0, 3, 8, 4, 0, 5, 5, 8, 9, 2)
      println("list : 	${numbers}")
      println("sorted : ${numbers.sorted()}")
      
      //set
      val setOfNumbers = numbers.toSet()
      println("set :	${setOfNumbers}")
      println("contains7 : ${setOfNumbers.contains(7)}")
      
      val set1 = setOf(1, 2, 3)
      val set2 = mutableSetOf(3, 2, 1)
      println("#set1 == #set2 : ${set1 == set2}")
  
  }
  ```

- **Map**

  - 특정 키가 부여된 값을 쉽게 찾을 수 있도록 설계된 키-값 쌍의 집합이다
  - 키는 고유하며 각 키는 정확히 하나의 값에 매핑되지만, 값은 중복될 수 있음.

  ```kotlin
  fun main() {
      val peopleAges = mutableMapOf<String, Int>(
      	"Fred" to 30,
          "Ann" to 23
      )
      
      println(peopleAges)
      
      peopleAges.put("Barbara", 42)	//항목 추가
      peopleAges["Joe"] = 51	//항목 추가
      println(peopleAges)
      peopleAges["Fred"] = 31	//항목 업데이트
      println(peopleAges)
  }
  ```

- **forEach**

  - `for`문과 비슷하지만, `forEach`는 현재 항목의 변수를 지정하는 대신 특수 식별자 `it`을 사용한다.

- **map**

  - 컬렉션의 각 항목에 변환을 적용한다.
  - 위에서 설명한 Map과는 다른 것임

- **filter**

  - 특정 조건과 일치하는 항목을 찾아줌.

```kotlin
![Unit3-Pathway1-1_장유진](E:\#Summer_Coding_2021\summary\img\Unit3-Pathway1-1_장유진.png)fun main() {
    val peopleAges = mutableMapOf<String, Int>(
    	"Fred" to 30,
        "Ann" to 23
    )
        
    peopleAges.put("Barbara", 42)
    peopleAges["Joe"] = 51
    peopleAges["Fred"] = 31
    
    //forEach
    peopleAges.forEach{print("${it.key} is ${it.value}, ")}
    println()
    
    //map
    println(peopleAges.map{"${it.key} is ${it.value}"}.joinToString(", "))
    
    //filter
    val filteredNames = peopleAges.filter{it.key.length < 4}
    println(filteredNames)
}
```

- **람다**

  - 이름이 없으며 곧바로 표현식으로 사용할 수 있는 함수

- **함수 유형**

  - 입력 매개변수와 반환 값을 기반

  - 함수 유형의 예 : `(Int) -> Int`

    <img src="img\Unit3-Pathway1-1_장유진.png" style="zoom:70%;" />
    
    ```kotlin
    fun main() {
        val triple: (Int) -> Int = { a: Int -> a * 3 }
        println(triple(5)) // 5
    }
    ```
  
- **고차 함수**

  - 함수를 다른 함수로 전달하거나 다른 함수에서 함수를 반환하는 것을 의미

  - `map`, `filter`, `forEach` 함수 모두 매개변수로 함수를 사용했으므로 고차함수의 예시임.

  - `sortedWith()` 은 문자열 길이를 기준으로 목록을 정렬할 때 사용

    <img src="img\Unit3-Pathway1-2_장유진.png" style="zoom:70%;" />

    - 첫 번째 문자열의 길이와 두 번째 문자열 길이의 차이(`Int`)를 반환
    - 반환값이 '음수', '0', '양수'가 나올 수 있음.
    - `sortedWith()` 함수는 두 `Strings` 사이의 일련의 비교를 한꺼번에 처리하여 이름 길이를 기준으로 오름차순으로 목록을 출력함.

- **예시**

  ```kotlin
  fun main() {
      val words = listOf("about", "acute", "awesome", "balloon", "best", "brief", "class", "coffee", "creative")
      
      val filterdWords = words.filter{it.startsWith("b", ignoreCase=true)}.shuffled().take(2).sorted()
      //shuffled() -> random, take(i) -> i개 선택, sorted() -> 정렬
      println(filterdWords)
  }
  ```

  

### Activities and intents

- **Intents**

  - 실행할 작업을 나타내는 객체
  - **암시적 인텐트**
    - 추상적이며 시스템에 링크 열기나 이메일 작성, 전화 걸기와 같은 작업 유형을 알려주고 시스템은 요청 처리 방법을 파악해야 함.
    - 다른 앱이 관련된 작업을 실행하는 데 사용하고 시스템이 최종 결과를 결정함.
  - **명시적 인텐트**
    - 매우 구체적이며 실행할 활동을 정확하게 알 수 있고 자체 앱의 화면인 경우가 많다.
    - 일반적으로 자체 앱에서 활동을 표시할 때는 명시적 인텐트를 사용함.

  <img src="img\Unit3-Pathway1-3_장유진.png" style="zoom:50%;" />
  
- **예시 코드**

  - **LetterAdapter.kt**

    - extra는 나중에 검색할 수 있도록 이름이 지정된 숫자나 문자열과 같은 데이터이다.
    - `putExtra()`메서드는 `CharSequence`만 아니라 `String`을 허용하므로 `toString()`을 호출해야 함.

    ```kotlin
    override fun onBindViewHolder(holder: LetterViewHolder, position: Int) {
            val item = list.get(position)
            holder.button.text = item.toString()
            holder.button.setOnClickListener{
                val context = holder.view.context
                //인텐트 생성, DetailActivity에서 전역 변수로 설정한 LETTER를 첫번째 인수로 전달
                val intent = Intent(context, DetailActivity::class.java)
                intent.putExtra(DetailActivity.LETTER, holder.button.text.toString())
                context.startActivity(intent)
            }
        }
    ```

  - **DetailActivity.kt**

    - `intent` 및 `extras` 속성은 null을 허용하므로 값이 있을 수도 있고 없을 수도 있다. Kotlin에서 `null`은 값이 없음을 의미한다. 앱이 속성에 엑세스 하거나 `null` 객체에서 함수를 호출하려고 하면 다운이 된다. 이 값에 안전하게 엑세스 하려면 이름 뒤에 `?`를 입력해야 한다. `intent`가 `null`이면 앱은 extras 속성 엑세스를 시도조차 하지 않으며 `extras`가 null이면 코드에서 `getString()`을 호출하려고 시도조차 하지 않는다.

    :exclamation:  즉, `?`가 쓰이는 이유는 예외를 처리하기 위해서 라고 생각할 수 있다. :exclamation:  

    - companion object는 클래스의 특정 인스턴스 없이 상수를 구분하여 사용할 수 있게 해준다.
    - 프로그램 기간에 companion object의 인스턴스는 하나만 존재하므로 '싱글톤 패턴'이라고 한다.

    ```kotlin
    class DetailActivity : AppCompatActivity() {
        companion object{
            const val LETTER = "letter"
            val SEARCH_PERFIX = "https://www.google.com/search?q="
        }
    
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
    
            ....
    
            // Retrieve the LETTER from the Intent extras
            // intent.extras.getString returns String? (String or null)
            // so toString() guarantees that the value will be a String
            val letterId = intent?.extras?.getString(LETTER).toString()
    
            val recyclerView = binding.recyclerView
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = WordAdapter(letterId, this)
    
            // Adds a [DividerItemDecoration] between items
            recyclerView.addItemDecoration(
                DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
            )
    
            title = getString(R.string.detail_prefix) + " " + letterId
        }
    }
    ```

  - **WordAdapter.kt**

    - `ACTION_VIEW`는 URI(이 경우, 웹 주소)를 사용하는 일반적인 인텐트이다.
      - `CATEGORY_APP_MAPS` :point_right: 지도 앱을 실행
      - `CATEGOR_APP_EMAIL` :point_right: 이메일 앱을 실행
      - `CATEGORY_APP_GALLERY` :point_right: 갤러리(사진) 앱을 실행
      - `ACTION_SET_ALARM` :point_right: 백그라운드에서 알람을 설정
      - `ACTION_DIAL` :point_right: 전화를 건다.

    ```kotlin
        override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
    
            val item = filteredWords[position]
            // Needed to call startActivity
            val context = holder.view.context
    
            // Set the text of the WordViewHolder
            holder.button.text = item
    
            holder.button.setOnClickListener{
                val queryUrl : Uri = Uri.parse("${DetailActivity.SEARCH_PERFIX}${item}")
                val intent = Intent(Intent.ACTION_VIEW, queryUrl)
                context.startActivity(intent)
            }
    
        }
    ```

  - **MainActivity.kt**

    ```kotlin
    //레이아웃 설정
    private fun chooseLayout(){
        if(isLinearLayoutManager){
            recyclerView.layoutManager = LinearLayoutManager(this)
        }
        else{
            recyclerView.layoutManager = GridLayoutManager(this, 4)
        }
    
        recyclerView.adapter = LetterAdapter()
    }
    ```

  <img src="img\Unit3-Pathway1-4_장유진.png" style="zoom:70%;" />

### Stages of the activity lifecycle 

- **활동 수명 주기 단계**

  <img src="img\Unit3-Pathway1-5_장유진.png" style="zoom:70%;" />

  - 활동이 이동하는 일련의 상태이다. 활동이 처음 만들어질 떄 시작되고 활동이 소멸될 때 종료된다.

  - 활동 수명 주기의 각 상태에는 `Activity` 클래스에서 재정의 할 수 있는 상응하는 콜백 메서드가 있다. 수명 주기 메서드의 핵심 집합은 다음과 같다.

    - `onCreate()` `onStart()` `onPause()` `onRestart()` `onResume()` `onStop()` `onDestroy()`

    ```kotlin
    const val TAG = "MainActivity"
    const val KEY_REVENUE = "revenue_key"
    const val KEY_DESSERT_SOLD = "dessert_sold_key"
    
    ...
    
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart Called")	//Log.d() 디버그 메시지 작성
    }
    
    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume Called")
    }
    
    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause Called")
    }
    
    override fun onStop(){
        super.onStop()
        Log.d(TAG, "onStop Called")
    }
    
    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy Called")
    }
    
    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart Called")
    }
    
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG, "onSaveInstanceState Called")
        outState.putInt(KEY_REVENUE, revenue)
        outState.putInt(KEY_DESSERT_SOLD, dessertsSold)
    }
    ```

  - **활동 시작** -> `onCreate()`, `onStart()`, `onResume()`호출

    - `onCreate()` :point_right: 앱을 만든다
    - `onStart()` :point_right: 활동을 시작하고 화면에 표시되게 한다
    - `onResume()` :point_right: 활동 포커스를 제공하고 사용자가 상호작용 할 수 있도록 활동을 준비

  - **뒤로가기 버튼 탭** -> `onPause()`, `onStop()`, `onDestroy()` 호출

  - **홈 버튼 탭** -> `onSaveInstanceState()` `onPuse()`, `onStop()`

  - **최근 화면을 사용하여 앱으로 돌아옴** -> `onRestart()`, `onStart()`, `onResume()`

    - 활동 객체가 소멸되지 않았으므로`onCreate()` 메서드 대신 `onRestart()` 메서드 호출

  - **공유 버튼 클릭** -> `onPause()` 호출

    - `onPause()`만 사용한 중단은 보통 활동으로 돌아가거나 다른 활동 또는 앱으로 이동하기 전에 잠시 지속됨.

  - `onSaveInstanceState()` 콜백을 사용하여 앱이 자동으로 종료된 경우에도 유지하려는 번들에 기타 데이터를 저장한다. 

    ```log
    2021-07-23 17:54:27.970 1166-1166/com.example.android.dessertclicker D/MainActivity: onCreate Called
    2021-07-23 17:54:28.223 1166-1166/com.example.android.dessertclicker D/MainActivity: onStart Called
    2021-07-23 17:54:28.225 1166-1166/com.example.android.dessertclicker D/MainActivity: onResume Called
    2021-07-23 17:55:22.731 1166-1166/com.example.android.dessertclicker D/MainActivity: onPause Called
    2021-07-23 17:55:23.462 1166-1166/com.example.android.dessertclicker D/MainActivity: onStop Called
    2021-07-23 17:55:23.466 1166-1166/com.example.android.dessertclicker D/MainActivity: onDestroy Called
    2021-07-23 17:55:59.795 1166-1166/com.example.android.dessertclicker D/MainActivity: onCreate Called
    2021-07-23 17:55:59.838 1166-1166/com.example.android.dessertclicker D/MainActivity: onStart Called
    2021-07-23 17:55:59.839 1166-1166/com.example.android.dessertclicker D/MainActivity: onResume Called
    2021-07-23 17:56:27.134 1166-1166/com.example.android.dessertclicker D/MainActivity: onPause Called
    2021-07-23 17:56:27.897 1166-1166/com.example.android.dessertclicker D/MainActivity: onStop Called
    2021-07-23 17:56:27.900 1166-1166/com.example.android.dessertclicker D/MainActivity: onSaveInstanceState Called
    2021-07-23 17:56:58.693 1166-1166/com.example.android.dessertclicker D/MainActivity: onRestart Called
    2021-07-23 17:56:58.701 1166-1166/com.example.android.dessertclicker D/MainActivity: onStart Called
    2021-07-23 17:56:58.702 1166-1166/com.example.android.dessertclicker D/MainActivity: onResume Called
    2021-07-23 17:57:00.455 1166-1166/com.example.android.dessertclicker D/MainActivity: onPause Called
    ```

    


### Quiz

1. **Which of the following is false about collections and higher order functions in Kotlin?**

   --> Lists are unorderd, while maps and sets are ordered data types.
   
   :point_right: map은 순서 중요하지 않음.
   
2. **Given the following code, what is the result of `onWorldCities[1]`?**

   ```kotlin
   val cities = listOf("Jeddah", "Bengaluru", "Shenzhen", "Abu Dhabi", "Mountain View", "Tripoli", "Bengaluru", "Lima", "Mandalay", "Tripoli")
   
   val oneWordCities = cities.toSet().toList().filter { !it.contains(" ")}.sorted()
   ```

   --> Jeddah

3. **빈칸 채우기**

   **A(n) ___ is a piece of data passed between activities when launching an intent/**

   --> extra

4. **If you open an app, and then leave the app using the back button, in which order were the following activity lifecycle methods called?** 

   --> `onCreate(), onStart(), onStop(), onDestroy()`

5. **Which activity lifecycle method would be called if a dialog appears onscreen, partially obscuring an activity?**

   --> `onPause()` because the activity is still displayed, but no longer has focus.

6. **Which of the following is true about the lifecycle of a single activity?**

   --> `onStart()` can be called multiple times, while `onCreate()` can be called once.

   --> `onResume()` is called when the activity gains focus.

7. **Which of the following is false about intents? **

   --> An implicit intent always results in the system asking the user which app to open.

   :point_right: 항상 물어보는 것은 아님. app이 하나면 그거를 자동 실행.

8. **An activity contains the following code in `onCreate()`. What will happened when this code is executed, if the `intent` property is `null`**

   ```kotlin
   val message = intent.extras?.getString("message").toString()
   ```

   --> The app will crash because it attempted to access the extras property on a null object.

   :point_right: crash가 안 나려면 intent 뒤에도 `?`를 적어야함.

9. **Which of the following tasks can be performed in `onCreate()`?**

   --> Configuring view, such as setting the layout manager of a recycler view.

   --> Getting extras from the intent that launched the activity.

10. **In which method should you handle what happends when a button in the app bar is pressed?**

    --> `onOptionsItemSelected()`