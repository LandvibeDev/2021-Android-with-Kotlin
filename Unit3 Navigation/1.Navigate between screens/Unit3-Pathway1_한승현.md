# Unit3-Pathway1



* **Kotlin의 컬렉션**

  * **컬렉션에 관해 알아보기**

    * **Collection**
      * 단어 목록(list), 직원 기록 모음(set)과 같은 관련 항목 그룹
      * 순서가 지정되거나 지정되지 않을 수 있음(ordered/unordered)
      * 고유하거나 고유하지 않을 수 있음(unique/not unique)
    * **list**
      * `sorted()` : 오름차순으로 정렬된 `list` 사본을 반환(`list` 자체를 정렬해주는 것 아님)
    * **set**
      * `list` 와 달리 중복될 수 없으며, 순서는 중요하지 않음
      * `list` 의 toSet() 메서드를 사용하면 `list` 를 `set` 으로 변환하여 반환
      * 순서가 중요하지 않고, 원소가 같고 순서가 다른 두 `set` 은 동일한 것으로 간주
      * ` contains()` : 특정 항목이 `set` 에 속하는지 여부를 반환
      * `intersect()` : 교집합
      * `union()` : 합집합
    * **map**
      * `key` 와 `value` 쌍의 집합
      * `key` 는 고유하며 각 `key` 는 하나의 값에만 mapping되지만, `value` 는 중복될 수 있음
      * 데이터 쌍이 있는 경우 유용하며 `key` 를 기반으로 각 쌍을 식별할 수 있음
      * `put(key, value)` 또는 `map[key] = value` 로 map에 항목을 추가할 수 있음

  * **컬렉션 사용**

    * **forEach { }**
      * `Collection.forEach { 실행문 }`  형태로 사용
      * 중괄호 내에서 `Collection` 에 접근할 때는 `it` 키워드로 현재 항목에 접근할 수 있음
    * **map { }**
      * `map{}` : `Collection` 의 각 항목에 변환을 적용하고 변환된 항목으로 이루어진 새 `Collection` 을 만듦
      * `it` 사용해서 현재 항목에 접근 가능
    * **filter { }**
      * `filter{}` : `Collection` 에서 표현식을 기반으로 일치하는 항목을 반환
      * `it` 사용해서 현재 항목에 접근 가능
      * 반환 유형은 `LinkedHashMap` 이, `list` 같은 다른 유형의 `Collection` 으로 변환 가능

  * **람다 및 고차 함수에 관해 알아보기**

    * **람다**

      * `람다` : 이름이 없으며 곧바로 표현식으로 사용할 수 있는 함수

        ```kotlin
        fun main() {
          val triple: (Int) -> Int = { a: Int -> a * 3 }
          println(triple(5))
        }
        ```

    * **고차 함수**

      * `고차 함수` : 함수를 다른 함수로 전달하거나 다른 함수에서 함수를 반환하는 것을 의미

      * `map` , `filter` , `forEach` 함수는 모두 매개변수로 함수를 사용했으므로 고차 함수의 예

      * `sortedWith()` 

        ```kotlin
        println(peopleNames.sortedWith { str1: String, str2: String -> str1.length - str2.length })
        ```

    * **Android의 OnClickListener 및 OnKeyListener**

      * 람다에 `OnClickListener`의 `onClick()` 메서드와 동일한 함수 유형이 있는 경우를 관찰(`View` 인수 하나를 사용하고 반환 값이 없음을 의미하는 `Unit`을 반환함)
      * Kotlin의 단일 추상 메서드(SAM) 변환 때문에 축약 버전의 코드가 가능, Kotlin은 람다를 단일 추상 메서드 `onClick()`을 구현하는 `OnClickListener` 객체로 변환하므로 람다의 함수 유형이 추상 함수의 함수 유형과 일치하는지 확인하면 됨
      * `view` 매개변수는 람다에서 사용되지 않으므로 이 매개변수를 생략해도 되며, 람다에 함수 본문을 배치하면 됨

  * **단어 목록 만들기**

    * `startsWith()` : string이 지정된 문자열로 시작할 경우 true 반환
    * `shuffled()` : 항목이 무작위로 섞인 컬렉션 사본을 반환
    * `take()` : 컬렉션의 처음 n개의 항목을 반환
    * `sorted()` : 컬렉션의 정렬된 사본을 반환

* **액티비티 및 인텐트**

  * **인텐트 소개**
    * `intent` : 실행할 작업을 나타내는 객체
    * `암시적 인텐트` : 좀 더 추상적이며 시스템에 링크 열기나 이메일 작성, 전화 걸기와 같은 작업 유형을 알려주고 시스템은 요청 처리 방법을 파악해야 함, 일반적으로 자체 앱에서 액티비티를 표시할 때 명시적 인텐트 사용하나, 현재 앱과 관련 없는 작업(예: 다른 사람에게 어떤 페이지를 공유하고자 할 때)의 경우 암시적 인텐트 사용하며 최종 결과는 시스템이 결정
    * `명시적 인텐트` : 매우 구체적이며 실행할 액티비티를 정확하게 알 수 있고 자체 앱의 화면인 경우가 많음

  * **명시적 인텐트 설정**

    * holder.button의 onClickListener 설정

    * context 참조 가져오기

    * Intent를 만들어 컨텍스트와 대상 액티비티의 클래스명을 전달

    * putExtra 메서드를 호출하여 letter을 첫 번째 인수로 전달하고 버튼의 텍스트를 두 번째 인수로 전달

    * 컨텍스트 객체에서 startActivity() 메서드를 호출하여 intent 전달

      ```kotlin
      holder.button.setOnClickListener {
      	val context = holder.view.context
        val intent = Intent(context, DetailActivity::class.java)
        intent.putExtra("letter", holder.button.text.toString())
        context.startActivity(intent)
      }
      ```

  * **DetailActivity 설정**

    * `DetailActivity`의 `onCreate` 메서드에서 `setContentView` 호출 후에 하드 코딩 문자를 `intent`에서 전달된 `letterId`를 가져오는 코드로 바꿈

      ```kotlin
      val letterId = intent?.extras?.getString("letter").toString()
      ```

    * 추적할 intent extras가 훨씬 많아질 경우에는 companion object를 활용해 싱글톤 패턴으로 extra를 더 체계적으로 처리할 수 있으며, 여러 클래스에서 사용할 수 있음

  * **암시적 인텐트 설정**

    * 앱이 작업 유형에 관한 정보를 시스템에 제공하면, 시스템은 이 작업으로 실행할 일을 파악하여 필요에 따라 사용자에게 추가 정보를 요청

    * companion object에 새 상수 `SEARCH_PREFIX` 를 추가하고, URL 값을 할당

    * `holder.button` 의 `setOnClickListener()` 내부에서 `URI` 를 만듦

    * 새 `intent` 객체를 초기화

      * `ACTION_VIEW` : URI를 사용하는 일반적인 인텐트
      * `CATEGORY_APP_MAPS` : 지도 앱 실행
      * `CATEGORY_APP_EMAIL` : 이메일 앱 실행
      * `CATEGORY_APP_GALERY` : 갤러리 앱 실행
      * `ACTION_SET_ALARM` : 백그라운드에서 알람 설정
      * `ACTION_DIAL` : 전화 걸기

    * `startActivity()` 호출하고 `intent` 전달하여 시스템에 다른 앱을 실행하라고 지시

    * 정확한 동작은 사용자마다 달라서 코드를 복잡하게 하지 않고도 모두에게 원활한 환경을 제공

      ```kotlin
      holder.button.setOnClickListener {
        val context = holder.view.context
        val queryUrl: Uri = Uri.parse("${DetailActivity.SEARCH_PREFIX}${item}")
        val intent = Intent(Intent.ACTION_VIEW, queryUrl)
        context.startActivity(intent)
      }
      ```

* **활동 수명 주기 단계**

  * **수명 주기 메서드 살펴보기 및 기본 로깅 추가**

    ![f6b25a71cec4e401.png](https://developer.android.com/codelabs/basic-android-kotlin-training-activity-lifecycle/img/f6b25a71cec4e401.png)

    * `onCreate()`
      * 모든 액티비티에서 구현해야 하는 메서드
      * 액티비티의 일회성 초기화를 실행해야 함
      * ex) 레이아웃 inflate, ClickListener 정의, View Binding 등
      * 액티비티가 초기화된 직후(새 액티비티 객체가 메모리에 할당될 때) 한 번 호출되고, `onCreate()` 가 실행되면 액티비티가 생성된 것으로 간주
    * `onStart()`
      * `onCreate()` 직후 호출
      * `onStart()` 가 실행되면 액티비티가 화면에 표시되고, 한 번만 호출되는 `onCreate()` 와 달리 액티비티 수명 주기에서 여러 번 호출될 수 있음
      * `onStop()` 메서드와 페어링되며, 이는 사용자가 앱을 시작한 후 기기 홈 화면으로 돌아오면 액티비티가 중지되고 더 이상 화면에 표시되지 않음
    * `onResume()`
      * 액티비티 포커스를 제공하고 사용자가 상호작용할 수 있게 액티비티를 준비
      * 다시 시작할 대상이 없어도 시작 시 호출됨

  * **수명 주기 사용 사례 살펴보기**

    * `onCreate()` > `onStart()` > `onResume()` > `onPause()` > `onStop()` > `onDestroy()`
    * `onDestroy()` 가 호출되면 액티비티가 완전히 종료되었으며 가비지 컬렉션될 수 있음을 의미
    * `finish()` 메서드를 호출하거나 사용자가 앱을 강제 종료하는 경우에도 완전히 종료될 수 있음
    * `onCreate()` 와 `onDestroy()` 는 나머지와 다르게 액티비티의 시작과 끝에서 딱 `1번` 만 호출됨
    * 나머지 메서드들은 액티비티 이동 간에 계속 호출될 수 있음

  * **수명 주기 최종 정리**

    * `onCreate()` : 액티비티의 초기화 담당, 시작할 때 1번만 호출됨
    * `onStart()` : 액티비티가 화면에 표시됨
    * `onResume()` : 액티비티가 포커스를 획득함
    * `onPause()` : 액티비티가 포커스를 상실함
    * `onStop()` : 액티비티가 화면에 표시되지 않음
    * `onDestroy()` : 액티비티가 종료되며, 메모리를 회수당하고 종료할 때 1번만 호출됨

  * **구성 변경사항 살펴보기**

    * 기기를 회전함으로써 `onCreate()` 가 다시 호출될 경우 기존의 가지고 있던 데이터를 잃어버릴 수 있음

    * `onSaveInstanceState()`

      *  액티비티가 소멸되면 필요할 수 있는 데이터를 저장하는 데 사용하는 콜백

      * 수명 주기 콜백 다이어그램(위 사진)에서 `onSaveInstanceState()` 는 액티비티가 중지된 후(`onStop()`)와 앱이 백그라운드로 전환될 때마다 호출됨

      * 액티비티가 포그라운드를 벗어날 때 소량의 정보를 번들에 저장할 수 있음

      * `onPause()` 와 `onStop()` 바로 다음에 콜백 발생

      * 번들에 key-value 형태로 데이터를 저장, 사용

      * `onCreate()` 에서 복원 가능

        ```kotlin
         if (savedInstanceState != null) {
           revenue = savedInstanceState.getInt(KEY_REVENUE, 0)
           dessertsSold = savedInstanceState.getInt(KEY_DESSERT_SOLD, 0)
           showCurrentDessert()
        }
        ```



### Quiz

1. **Which of the following is false about collections and higher order functions in Kotlin?**

   * Lists are unordered, while maps and sets are ordered data types.

2. **Given the following code, what is the result of `oneWordCities[1]`?**

   ```kotlin
   val cities = listOf("Jeddah", "Bengaluru", "Shenzhen", "Abu Dhabi", "Mountain View", "Tripoli", "Bengaluru", "Lima", "Mandalay", "Tripoli")
   val oneWordCities = cities.toSet().toList().filter { !it.contains(" ")}.sorted()
   ```

   * Jeddah

3. **Fill-in-the-blanks**

   A(n) `extra` is a piece of data passed between activities when launching an intent.

4. **If you open an app, and then leave the app using the back button, in which order were the following activity lifecycle methods called?**

   * `onCreate(), onStart(), onStop(), onDestroy()`

5. **Which activity lifecycle method would be called if a dialog appears onscreen, partially obscuring an activity?**

   `onPause()` because the activity is still displayed, but no longer has focus.

6. **Which of the following is true about the lifecycle of a single activity?**

   * `onStart()` can be called multiple times, while `onCreate()` can only be called once.

   * `onResume()` is called when the activity gains focus.

     정답입니다.

7. **Which of the following is false about intents?**

   * An implicit intent always results in the system asking the user which app to open.

8. **An activity contains the following code in `onCreate()`. What will happen when this code is executed, if the `intent` property is `null`?**

   ```kotlin
   val message = intent.extras?.getString("message"
   ).toString()
   ```

   * The app will crash because it attempted to access the extras property on a null object.

9. **Which of the following tasks can be performed in `onCreate()`?**

   * Configuring views, such as setting the layout manager of a recycler view.
   * Getting extras from the intent that launched the activity.

10. **In which method should you handle what happens when a button in the app bar is pressed?**

    * `onOptionsItemSelected()`

