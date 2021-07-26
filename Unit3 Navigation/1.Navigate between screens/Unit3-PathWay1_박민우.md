# 🔥 Unit 3 : Navigation

## Pathway 1 : Navigate between screens

## 🎖Navigate between screens

--------

### collection

+ 컬렉션은 단어 목록이나 직원 기록 모음과 같은 관련 항목 그룹입니다. 컬렉션의 항목은 순서가 지정되거나 지정되지 않을 수 있으며 고유하거나 고유하지 않을 수 있습니다. 컬렉션의 한 유형인 List에 관해서는 이미 알아봤습니다. 목록의 항목에는 순서가 있지만 항목이 고유할 필요는 없습니다.

+ Kotlin의 또 다른 컬렉션 유형은 **집합**입니다. 관련 항목의 그룹이지만 목록과 달리 **중복될 수 없으며 순서는 중요하지 않습니다.** 집합에 항목이 있거나 없을 수 있지만, 있는 경우에는 한 개만 있습니다. 이는 집합의 수학적 개념과 유사합니다. 내가 읽은 책의 집합을 예로 들겠습니다. 특정 책을 여러 번 읽더라도 이 책이 내가 읽은 책의 집합에 속한다는 사실은 변하지 않습니다.

+ set

  ```kotlin
  val set1 = setOf(1,2,3)
  val set2 = mutableSetOf(3,2,1)
  
  println("$set1 == $set2: ${set1 == set2}") // true
  ```

+ `contains`

  ```kotlin
  println("contains 7: ${setOfNumbers.contains(7)}") // false
  ```

+ 정리

  ```kotlin
  fun main() {
      val numbers = listOf(0, 3, 8, 4, 0, 5, 5, 8, 9, 2)
      println("list:   ${numbers}")
      println("sorted: ${numbers.sorted()}")
      val setOfNumbers = numbers.toSet()  // .toSet 함수
      println("set:    ${setOfNumbers}")
      val set1 = setOf(1,2,3)
      val set2 = mutableSetOf(3,2,1)
      println("$set1 == $set2: ${set1 == set2}") // 집합이 서로 동일한지 비교
      println("contains 7: ${setOfNumbers.contains(7)}") // contains
  }
  ```





### map

+ 맵은 **특정 키가 부여된 값**을 쉽게 찾을 수 있도록 설계된 *key-value pairs*의 집합입니다. **키는 고유하며 각 키는 정확히 하나의 값에 매핑되지만, 값은 중복될 수 있습니다**. 맵의 값은 문자열, 숫자, 객체일 수 있으며 목록 또는 집합과 같은 다른 컬렉션일 수도 있습니다.

+ `map`

  ```kotlin
  fun main() {
      val peopleAges = mutableMapOf<String, Int>( // 사람의 이름과 나이를 저장
          "Fred" to 30,
          "Ann" to 23
      )
      println(peopleAges)
  }
  ```

  변경 가능한 `String`(키)-`Int`(값) 맵이 만들어진다.  

  

+ 맵에 항목을 더 추가하려면 `put()` 함수를 사용하여 키와 값을 전달하거나, 약식 표기법을 사용해도 된다.   

  ```kotlin
  peopleAges.put("Barbara", 42)
  peopleAges["Barbara"] =42  
  ```
  
  
  
+ 이미 존재하는 키 값을 사용하는 key-value 항목을 추가하려고 하면, 키는 다시 추가되진 않지만 이에 매핑되는 값은 새로운 value 값으로  업데이트 된다. 





### 컬렉션 사용

+ 추가, 삭제, 열거, 찾거나, 한 유형의 컬렉션을 다른 유형으로 변환

+ `forEach()` :  자동으로 모든 항목을 탐색한 후 항목별로 작업을 실행

  ```kotlin
  peopleAges.forEach { print("${it.key} is ${it.value}, ") }
  ```

  `forEach`는 현재 항목의 변수를 지정하는 대신 특수 식별자 `it`을 사용합니다. `forEach()` 메서드를 호출할 때 괄호를 추가할 필요가 없었습니다. 중괄호 `{}` 안에 코드를 전달하기만 하면 됩니다.



+ `map()` : 컬렉션의 각 항목에 변환을 적용(colleection의 한 종류인 `map`과는 다른 것)

  ```kotlin
  println(peopleAges.map { "${it.key} is ${it.value}" }.joinToString(", ") )
  ```

  + `peopleAges.map`은 `peopleAges`의 각 항목에 변환을 적용하고 변환된 항목으로 이루어진 새 컬렉션을 만듭니다.
  + 중괄호 `{}` 안에 있는 부분은 각 항목에 적용할 변환을 정의합니다. 키-값 쌍을 가져와서 문자열로 변환합니다. 예를 들어 `<Fred, 31>`을 `Fred is 31`로 변환됩니다.
  + `joinToString(", ")`은 변환된 컬렉션의 각 항목을 문자열에 추가하고 `,`로 구분하며 **마지막 항목에는 기호를 추가하지 않습니다.**



+ `filter()` : 특정 **조건**과 일치하는 항목들의 컬렉션을 반환

  ```kotlin
  val filteredNames = peopleAges.filter { it.key.length < 4 }
  println(filteredNames)
  ```

  + 이 경우 표현식은 키(`String`)의 길이를 가져와서 4글자 미만인지 여부를 확인합니다. 즉, 이름이 4글자 미만인 항목이 일치하여 새 컬렉션에 추가됩니다.
  + 맵에 필터를 적용할 때 반환되는 유형은 새 맵(`LinkedHashMap`)입니다. 새 맵에서 추가로 처리하거나 새 맵을 목록 같은 다른 유형의 컬렉션으로 변환할 수 있습니다.
  + 특정 조건이 아니라 특정 **값**에 대한 것은 `contains()`





### 람다 

```kotlin
peopleAges.forEach { print("${it.key} is ${it.value}") }
```

함수(`forEach`)가 호출되는 변수(`peopleAges`)가 있습니다. 함수 이름 다음에 매개변수가 포함된 괄호를 사용하는 대신 함수 이름 다음에 **코드를 포함하는 중괄호 `{}`**를 사용한 것을 볼 수 있습니다. `forEach` 함수는 `peopleAges` 변수에서 호출되며 중괄호 안에 코드를 사용합니다.

**중괄호 안에 작은 함수를 작성하는 것**과 같지만 함수 이름은 없습니다. 이렇게 **이름이 없으며 곧바로 표현식으로 사용할 수 있는 함수**는 아주 유용한 개념으로, ***람다 표현식*** 또는 간략하게 **람다**라고 합니다

=> 중괄호 안에 코드를 작성하는 것, 이름이 없는 작은 함수를 작성하는 것 => 람다

### 

#### Fuction Type

+ 람다의 화살표 왼쪽에 표시되는 값

+ ex) `(Int) -> Int` 

  괄호 안에 매개변수를 나열하고(여러개 있는 경우 쉼표로 구분) 다음에 화살표`->`를 배치한 후 반환 유형을 나열합니다. 

  + 이 기준을 충족하는 함수 유형 

  + ex) `{a: Int -> a * 3}`

  + ex) `val triple: (Int) -> Int = {a: Int -> a * 3}` <= 이렇게 람다를 **변수에 저장**할 수도 있음

    즉, `triple`은  `a`라는 매개변수를 입력받아 `a*3`을 반환하는 함수.

  + `val triple: (Int) -> Int = { it * 3 }` 이렇게 약식으로 표현할 수 있음.(매개변수가 하나일 때, `it`을 사용하여 매개변수의 선언과 함수 화살표를 생략하고 함수 본문만 사용할 수 있음)

<img src = "https://user-images.githubusercontent.com/31370590/126888310-65dfdcd6-fd49-4d63-ba4c-38a86787df64.PNG" width = "400" height = "100">

### 고차함수

+  **함수(이 경우에는 람다)를 다른 함수로 전달**하거나 **다른 함수에서 함수를 반환하는 것**

+ `sortedWith()`

  ```kotlin
  fun main() {
      val peopleNames = listOf("Fred", "Ann", "Barbara", "Joe")
      println(peopleNames.sorted())
      
      println(peopleNames.sortedWith { str1: String, str2: String -> str1.length - str2.length })
  }
  
  ```

  + `sortedWith()`에 전달된 람다에는 두 매개변수, 즉 `String`인 `str1`과 `String`인 `str2`가 있습니다. 그런 다음 함수 화살표가 나온 후에 함수 본문이 나옵니다. 이 경우에는 첫 번째 문자열의 길이와 두 번째 문자열 길이의 차이(`Int`)를 반환합니다. 정렬에 필요한 값과 일치시킵니다.



### 단어 목록 만들기

```kotlin
fun main() {
    val words = listOf("about", "acute", "awesome", "balloon", "best", "brief", "class", "coffee", "creative")
    val filteredWords = words.filter { it.startsWith("b", ignoreCase = true) }
        .shuffled()
        .take(2)
        .sorted()
    println(filteredWords)
}
```





## 🎖 Activities and intents

----------

### Intent

+ Intent란 안드로이드 4대 컴포넌트가 서로 데이터를 주고받기 위한 메시지 객체이다 .

  명시적 인텐트 : 액티비티 이름을 명확하게 지정할 때 사용하는 방법
  암시적 인텐트 : 약속된 액션을 지정하여 안드로이드에서 제공하는 기종의 응용 프로그램을 실행하는 것



## 명시적 인텐트 설정

+ 명시적 인텐트 설정

  ```kotlin
  val intent = Intent(this, DetailActivity::class.kotlin)
  intent.putExtra("letter", "hello bundle")
  intent.putExtra("letter2", 2020)
  
  startActivity(intent)
  ```

  

+ `DetailActivity`에서 intent로 넘겨진 정보를 받으려면

  ```kotlin
  val letterId = intent?.extras?.getString("letter").toString()
  
  // val letterId = intent.getStringExtra("letter") 
  ```

  + 여기서 intent는 `DetailActivity`의 property라기 보다는, property of any Activity 이다. 해당 액티비티를 launch하는데 사용된 intent에 대한 reference를 유지한다.
  + extras 속성은 `Bundle` 유형이고 짐작했겠지만 인텐트에 전달된 모든 extras에 액세스하는 방법을 제공합니다.
  + 실제 문자가 `getString`으로 검색되어 `String?`를 반환하므로 `toString()`을 호출하여 `null`이 아닌 `String`인지 확인한다. 

  

## 암시적 인텐트 설정

+ 대부분의 경우 자체 앱에서 특정 Activity를 표시합니다. 그러나 실행하려는 Activity나 앱을 알 수 없는 때도 있습니다.  
+ 세부정보 화면에서 각 단어는 단어의 사용자 정의를 보여주는 버튼입니다. 이 예에서는 버튼을 누를 때, Google 검색에서 제공하는 사전 기능을 사용합니다. 
+ 사용자가 어떤 앱을 설치했는지 확실히 알 수는 없습니다. 사용자가 단어를 어떤 방식으로 찾으려고 하는지도 추측할 수 없습니다. 이때 암시적 인텐트를 사용하면 가장 좋습니다. 앱이 작업 유형에 관한 정보를 시스템에 제공하면 시스템은 이 작업으로 실행할 일을 파악하여 필요에 따라 사용자에게 추가 정보를 요청합니다.



1. 모든 검색에 동일한 기본 URL이 사용되므로 이 URL을 자체 상수로 정의하는 것이 좋습니다. `DetailActivity`에서 컴패니언 객체를 수정하여 새 상수 `SEARCH_PREFIX`를 추가합니다. 이 URL이 Google 검색의 기본 URL입니다.

   ```kotlin
   companion object {
      val LETTER = "letter"
      val SEARCH_PREFIX = "https://www.google.com/search?q="
   }
   ```

   + 이를 `LetterAdapter`에서 접근하려면, `DetailActivity.LETTER` 이런 식으로 접근 해야함. 



2. 그런 다음 `WordAdapter`를 열고 `onBindViewHolder()` 메서드의 버튼에서 `setOnClickListener()`를 호출합니다. 먼저 검색어의 `URI`를 만듭니다. `parse()`를 호출하여 `String`에서 `URI`를 만들 때 문자열 형식을 사용하여 단어가 `SEARCH_PREFIX`에 추가되도록 해야 합니다.

   ```kotlin
   holder.button.setOnClickListener {
       val queryUrl: Uri = Uri.parse("${DetailActivity.SEARCH_PREFIX}${item}")
   }
   ```

   > URL은 웹 페이지를 가리키는 문자열, URI는 형식에 관한 좀 더 일반적인 용어



3. `queryUrl`를 정의한 후 새 `intent` 객체를 초기화합니다.

   ```kotlin
   val intent = Intent(Intent.ACTION_VIEW, queryUrl)
   ```

   context와 activity를 전달하는 대신 `Intent.ACTION_VIEW`와 `URI`를 전달합니다.

   `ACTION_VIEW`는 URI(이 경우 웹 주소)를 사용하는 일반적인 인텐트입니다. 그러면 시스템은 사용자의 웹브라우저에서 URI를 열어 이 인텐트를 처리할 수 있습니다. 



4. 마지막으로 앱에서 특정 활동을 실행하지 않더라도 `startActivity()`를 호출하고 `intent`를 전달하여 시스템에 다른 앱을 실행하라고 지시합니다.

   ```kotlin
   context.startActivity(intent)
   ```

   

## 메뉴 및 아이콘 설정

+ 앱 바에 버튼을 추가하여 사용자가 레이아웃을 변경할 수 있도록 







## 🎖 Stages of the activity lifecycle

+ *activity lifecycle*은 activity의 전체 기간 중 일련의 activity 상태입니다. 수명 주기는 활동이 생성되는 시점에 시작하여 활동이 소멸되어 시스템에서 활동 리소스가 회수될 때까지 이어집니다. 사용자는 앱에서 activity 간에 이동하므로(앱 안팎으로) 이러한 활동은 각각 활동 수명 주기의 다양한 상태로 전환됩니다. 

+ `Activity` 클래스 자체와 `Activity`의 모든 서브클래스(예: `AppCompatActivity`)는 **일련의 수명 주기 콜백 메서드**를 구현합니다. android에서는 **activity가 한 상태에서 다른 상태로 이동할 때 이러한 콜백을 호출**하고 개발자는 이러한 메서드를 **자체 activity에서 재정의**하여 **수명 주기 상태 변경에 응답해 작업을 실행**할 수 있습니다. 다음 다이어그램은 사용할 수 있는 재정의 가능한 콜백과 함께 수명 주기 상태를 보여줍니다.

  <img src = "https://user-images.githubusercontent.com/31370590/126263442-98e495ee-9610-4cfd-b41b-4f107b362c8e.PNG" width = "300" height = "400">

  이러한 콜백이 호출되는 시점과 각 콜백 메서드에서 할 작업을 알아야 한다.



### Callback method

#### 1. onCreate()

+ `onCreate()` 메서드에서 활동의 일회성 초기화를 실행해야 합니다. 예를 들어 `onCreate()`에서 레이아웃을 확장하거나 클릭 리스너를 정의하거나 뷰 결합을 설정합니다.

+ `onCreate()` 메서드는 활동이 초기화된 직후(새 `Activity` 객체가 메모리에 만들어질 때) 한 번 호출됩니다. `onCreate()`가 실행되면 활동이 *생성됨*으로 간주됩니다.

  > `onCreate()` 메서드를 재정의할 때 슈퍼클래스 구현을 호출하여 활동 생성을 완료해야 하므로 활동 내에서 `super.onCreate()`를 즉시 호출해야 합니다. 다른 수명 주기 콜백 메서드의 경우에도 마찬가지입니다.

+ `onCreate()` 메서드는 중요한 단계입니다. 여기서 첫 초기화가 모두 이루어지고 레이아웃을 확장하여 처음으로 레이아웃을 설정하며 변수를 초기화합니다.

+ log

  `onCreate()` method에 log 코드 추가

  ```Log.d("MainActivity", "onCreate Called")
  Log.d("MainActivity", "onCreate Called")
  ```

  `Log`클래스는 **Logcat**에 메시지를 씁니다. **Logcat**은 메시지를 기록하는 콘솔입니다. `Log.d()` 메서드나 기타 `Log` 클래스 메서드를 사용하여 로그에 명시적으로 전송하는 메시지를 비롯하여 앱에 관한 Android의 메시지가 여기에 표시됩니다.



#### 2. onStart()

+ `onStart()` 수명 주기 메서드는 `onCreate()` 직후에 호출됩니다. `onStart()`가 실행되면 **활동이 화면에 표시**됩니다. 활동을 초기화하는 데 한 번만 호출되는 `onCreate()`와 달리 `onStart()`는 **활동의 수명 주기에서 여러 번 호출**될 수 있습니다.

+ `onStart()`는 상응하는 `onStop()` 수명 주기 메서드와 페어링됩니다. 사용자가 앱을 시작한 후 기기 홈 화면으로 돌아오면 활동이 중지되고 더 이상 화면에 표시되지 않습니다.

  ```kotlin
  override fun onStart() {
     super.onStart()
     Log.d(TAG, "onStart Called") // 기본 로깅 설정 => 수명 주기 콜백이 트리거되는 방식 탐색 가능
  }
  ```



#### 3. onRestart()

+ `onCreate()`나 `onRestart()`는 활동이 표시되기 전에 호출됩니다. `onCreate()` 메서드는 처음에만 호출되고 `onRestart()`는 그 후에 호출됩니다. `onRestart()` 메서드는 **활동이 처음으로 시작되지 않은 경우에만 호출하려는 코드를 배치하는 위치**입니다.





#### acitivity lifecycle 사용 사례 1 : **활동 열기 및 닫기**

1. 앱이 처음 시작되면 `onCreate()`, `onStart()`, `onResume()` 콜백이 호출됩니다
   + `onCreate()` - 앱을 만듭니다.
   + `onStart()` - 활동을 시작하고 화면에 표시되게 합니다.
   + `onResume()` - 활동 포커스를 제공하고 사용자가 상호작용할 수 있도록 활동을 준비합니다.



2. 컵케이크를 몇 번 탭합니다.

3. 기기에서 **뒤로** 버튼을 탭합니다. Logcat에서 `onPause()`, `onStop()`, `onDestroy()`가 순서대로 호출됩니다.

   이 경우 **뒤로** 버튼을 사용하면 활동 및 앱이 완전히 닫힙니다. `onDestroy()` 메서드의 실행은 활동이 완전히 종료되었으며 가비지 컬렉션될 수 있음을 의미합니다. 가비지 컬렉션은 더 이상 사용하지 않을 객체의 자동 정리를 나타냅니다. 

   > 여기서 요점은 `onCreate()`와 `onDestroy()`가 단일 활동 인스턴스의 전체 기간에 한 번만 호출된다는 것입니다. `onCreate()`는 앱을 맨 처음 초기화할 때, `onDestroy()`는 앱에서 사용하는 리소스를 정리할 때 호출됩니다.



#### acitivity lifecycle 사용 사례 2 : 활동에서 이동 및 활동으로 다시 이동

+ 활동은 사용자가 활동에서 벗어날 때마다 완전히 닫히지 않습니다.
  + 활동이 화면에 더 이상 표시되지 않으면 이는 활동이 *background*에 배치되는 것입니다. 이와 반대의 경우는 활동이 *foreground*에 있거나 화면에 표시되는 것입니다.
  + 사용자가 앱으로 돌아오면 동일한 활동이 다시 시작되어 화면에 다시 표시됩니다. 수명 주기에서 이 부분을 앱의 *visible* life cycle라고 합니다. 
  + 앱은 백그라운드에 있을 때 시스템 리소스와 배터리 수명을 보존하기 위해 일반적으로 활발히 실행되지 않아야 합니다. `Activity` 수명 주기와 그 콜백을 사용하여 앱이 백그라운드로 이동하는 시점을 알 수 있어 진행 중인 작업을 일시중지할 수 있습니다. 그런 다음 앱이 포그라운드로 전환될 때 작업을 다시 시작합니다.

1. 앱이 처음 시작되면 `onCreate()`, `onStart()`,`onResume()` 콜백이 호출됩니다
2. 컵케이크를 몇 번 탭합니다.
3. 기기에서 **홈** 버튼을 누르고 Android 스튜디오에서 Logcat을 관찰합니다. **홈 화면으로 돌아오면 앱이 완전히 종료되는 대신 백그라운드로 전환**됩니다. `onPause()` 메서드와 `onStop()` 메서드가 호출되지만 `onDestroy()`는 호출되지 않습니다. 
   + `onPause()`가 호출되면 앱에 더 이상 포커스가 없습니다.
   + `onStop()` 이후에는 앱이 더 이상 화면에 표시되지 않습니다.
   + 활동이 중지되었지만 `Activity` 객체는 여전히 백그라운드에서 메모리에 있습니다. 활동은 소멸되지 않았습니다. 사용자가 앱으로 돌아올 수 있으므로 Android는 활동 리소스를 유지합니다. 

4. 최근 화면을 사용하여 앱으로 돌아갑니다. Logcat에서 활동은 `onRestart()`와 `onStart()`로 다시 시작된 후 `onResume()`으로 재개됩니다.

   + 활동이 포그라운드로 돌아오면 `onCreate()` 메서드가 다시 호출되지 않습니다. 활동 객체는 소멸되지 않았으므로 다시 만들지 않아도 됩니다. `onCreate()` 대신 `onRestart()` 메서드가 호출됩니다. 이번에는 활동이 포그라운드로 돌아올 때 **Desserts Sold** 수가 유지됩니다.

   > 여기서 핵심은 `onStart()`와 `onStop()`이 사용자가 활동에서 나가거나 활동으로 이동할 때 여러 번 호출된다는 점입니다.



#### acitivity lifecycle 사용 사례 3 : 부분적으로 활동 숨기기

+ `onCreate()` => 앱 시작
+ `onStart()`  => 앱이 화면에 표시
+ `onResume()` => 앱이 사용자 포커스 확보 : 즉 사용자가 앱과 상호작용 할 수 있음



+ 앱이 백그라운드로 이동하면
+ `onPause()` => 포커스 상실
+ `onStop()` => 앱 표시 x



+ 포커스와 가시성의 차이가 중요한 이유는 활동이 화면에 ***부분적으로*** 표시되지만 사용자 포커스는 없을 수 있기 때문. 

  ex) 오른쪽 상단의 공유 버튼을 누르면, **기존 activity는 계속 화면 위쪽 절반에 표시되므로 포커스는 상실했지만, 앱은 계속 표시되는 것이므로 `onPause()`만 호출**되고, `onStop()`은 호출되지 않는다. 포커스를 상실했으므로 사용자가 상호작용 할 수 없다. 포그라운드에 있는 '공유' activity에 사용자 포커스가 있다.

 

#### configuration changes

+ 화면 가로모드로 전환 시, 시스템은 모든 수명 주기 콜백을 호출하여 활동을 종료합니다. 그런 다음 활동이 다시 만들어질 때 시스템은 모든 수명 주기 콜백을 호출하여 활동을 시작합니다.
+ 기기가 회전되어 활동이 종료되고 다시 만들어지면 활동은 기본값(판매된 디저트 수와 수익이 0으로 재설정됨)으로 시작됩니다.



#### onSaveInstanceState()를 사용하여 번들 데이터 저장

+ `onSaveInstanceState()`

  **Activity가 소멸되면 필요할 수 있는 데이터를 저장**하는 데 사용하는 콜백입니다. 수명 주기 콜백 다이어그램에서 `onSaveInstanceState()`는 **활동이 중지된 후 호출**됩니다. 또한 앱이 **백그라운드로 전환될 때마다** 호출됩니다. 

  `onSaveInstanceState()` 호출을 안전 조치라고 생각하세요. 활동이 포그라운드를 벗어날 때 소량의 정보를 번들에 저장할 수 있습니다. 이제 시스템은 이 데이터를 저장합니다. 앱이 종료될 때까지 기다리면 시스템이 리소스 압력을 받을 수 있기 때문입니다.

  `MainActivity`에서 `onSaveInstanceState()` 콜백을 재정의하고 로그 구문을 추가

  ```kotlin
  override fun onSaveInstanceState(outState: Bundle) {
     super.onSaveInstanceState(outState)
  
     Log.d(TAG, "onSaveInstanceState Called")
  }
  ```

  + `Bundle`은 키-값 쌍 모음으로, 키가 항상 문자열입니다. `Int` 및 `Boolean` 값과 같은 간단한 데이터를 번들에 넣을 수 있습니다. 시스템이 이 **번들을 메모리에 유지**하므로 번들의 **데이터를 작게** 유지하는 것이 좋습니다.



+ `onSaveInstanceState()`에서 `revenue` 값(정수), `dessertsSold`을 `putInt()` 메서드를 사용하여 번들에 넣습니다.

  ```kotlin
  outState.putInt(KEY_REVENUE, revenue)
  outState.putInt(KEY_DESSERT_SOLD, dessertsSold)
  ```

  

+ `onCreate()`를 사용하여 번들 데이터 복원

  + 액티비티 상태는 `onCreate(Bundle)`이나 `onRestoreInstanceState(Bundle)`에서 복원할 수 있습니다. `onSaveInstanceState()` 메서드로 채워진 `Bundle`은 두 수명 주기 콜백 메서드에 모두 전달됩니다.

  + ```kotlin
    override fun onCreate(savedInstanceState: Bundle) {

  + `onCreate()`는 호출될 때마다 `Bundle`을 가져옵니다. 프로세스 종료로 인해 **활동이 다시 시작되면 저장한 번들이 `onCreate()`에 전달**됩니다. 활동이 새로 시작되었다면 `onCreate()`의 이 `Bundle`은 `null`입니다. 따라서 **번들이 `null`이 아니면 이전에 알려진 지점에서 활동을 '다시 생성'**하고 있음을 알 수 있습니다.

  + 활동이 다시 생성되는 경우 `onRestoreInstanceState()` 콜백은 번들과 함께 `onStart()` 후에 호출됩니다. 대부분의 경우 `onCreate()`에서 액티비티 상태를 복원합니다. 그러나 `onRestoreInstanceState()`는 `onStart()` 후에 호출되므로 `onCreate()`가 호출된 후 일부 상태를 복원해야 한다면 `onRestoreInstanceState()`를 사용하면 됩니다.

  + `onCreate()`

    ```kotlin
    if (savedInstanceState != null) {
       revenue = savedInstanceState.getInt(KEY_REVENUE, 0)
       dessertsSold = savedInstanceState.getInt(KEY_DESSERT_SOLD, 0)
    }
    ```

    `getInt()` 메서드는 두 가지 인수를 사용합니다.

    + key 역할을 하는 문자열(예: 수익 값의 `"key_revenue"`)
    + 번들의 키에 값이 없는 경우를 위한 기본값





## 🎖Quiz/Unit3/Pathway1

1. Which of the following is false about collections and higher order functions in Kotlin?

   =>  Lists are unordered, while maps and sets are ordered data types.



2. Given the following code, what is the result of `oneWordCities[1]`?

   ```kotlin
   val cities = listOf("Jeddah", "Bengaluru", "Shenzhen", "Abu Dhabi", "Mountain View", "Tripoli", "Bengaluru", "Lima", "Mandalay", "Tripoli")
   val oneWordCities = cities.toSet().toList().filter { !it.contains(" ")}.sorted()
   ```

   => Jeddah



3. A(n) **extra** is a piece of data passed between activities when launching an intent.



4. If you open an app, and then leave the app using the back button, in which order were the following activity lifecycle methods called?

   => `onCreate(), onStart(), onStop(), onDestroy()`



5. Which activity lifecycle method would be called if a dialog appears onscreen, partially obscuring an activity?

   =>  `onPause()` because the activity is still displayed, but no longer has focus.



6. Which of the following is true about the lifecycle of a single activity?

   => 

   + `onStart()` can be called multiple times, while `onCreate()` can only be called once.
   + `onResume()` is called when the activity gains focus.



7. Which of the following is false about intents?

   => An implicit intent always results in the system asking the user which app to open.

   > Intents are performed using the `startActivity()` method.

   

8. An activity contains the following code in `onCreate()`. What will happen when this code is executed, if the `intent` property is `null`?

   ```kotlin
   val message = intent.extras?.getString("message"
   ).toString()
   ```

   => The app will crash because it attempted to access the extras property on a null object.



9. Which of the following tasks can be performed in `onCreate()`?

   => 

   + Configuring views, such as setting the layout manager of a recycler view.
   + Getting extras from the intent that launched the activity.



10. In which method should you handle what happens when a button in the app bar is pressed?

    => `onOptionsItemSelected()`
