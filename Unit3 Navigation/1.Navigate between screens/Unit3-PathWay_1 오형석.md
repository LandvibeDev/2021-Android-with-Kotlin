### Unit 3: Navigation

#### PATHWAY 1:Navigate between screens

<hr/>

#### ✔Collections in Kotlin

##### 컬렉션 

컬렉션은 단어 목록이나 직우너 기록 모음과 같은 관련 항목 그룹. 컬렉션의 항목은 순서가 지정되거나 지정되지 않을 수 있으며 고유하거나 고유하지 않을 수 있다. 컬렉션의 한 유형인 list는 순서가 있지만 항목이 고유할 필요는 없다.

##### set

list와 달리 중복될 수 없으며 순서는 중요하지 않다. 집합의 수학적 개념과 유사.

변경 가능한 mutableSet과 불가능한 set이 있음.

```kotlin
fun main() {
    val numbers = listOf(0, 3, 8, 4, 0, 5, 5, 8, 9, 2)
    println("list:   ${numbers}")
    println("sorted: ${numbers.sorted()}")
    val setOfNumbers = numbers.toSet()
    println("set:    ${setOfNumbers}")
    val set1 = setOf(1,2,3)
    val set2 = mutableSetOf(3,2,1)
    println("$set1 == $set2: ${set1 == set2}")
    println("contains 7: ${setOfNumbers.contains(7)}")
}
```

두 집합의 교집합(∩) 또는 합집합(∪)과 같은 연산을 `intersect()` 또는 `union()`을 사용하여 실행할 수 있음. 차집합은 `subtract()`

```kotlin
val numbers = setOf("one", "two", "three")
println(numbers union setOf("four", "five")) 
println(setOf("four", "five") union numbers)
println(numbers intersect setOf("two", "one")) 
println(numbers subtract setOf("three", "four")) 
```

#####  map

map은 특정 키가 부여된 값을 쉽게 찾을 수 있도록 설계된 키-값 쌍의 집합. 키는 고유하며 각 키는 정확히 하나의 값에 매핑되지만 값은 중복될 수 있음.

```kotlin
fun main() {
    val peopleAges = mutableMapOf<String, Int>(
        "Fred" to 30,
        "Ann" to 23
    )
    peopleAges.put("Barbara", 42)
    peopleAges["Joe"] = 51
    println(peopleAges)
}
```

##### forEach

forEach는 현재 항목의 변수를 지정하는 대신 특수 식별자 it을 사용

```kotlin
println(peopleAges.forEach { print("${it.key} is ${it.value}, ") })
```

##### map()

```kotlin
println(peopleAges.map { "${it.key} is ${it.value}" }.joinToString(", ") )
```

- `peopleAges.map`은 `peopleAges`의 각 항목에 변환을 적용하고 변환된 항목으로 이루어진 새 컬렉션을 만듦.
- 중괄호 `{}` 안에 있는 부분은 각 항목에 적용할 변환을 정의합니다. 키-값 쌍을 가져와서 문자열로 변환합니다. 예를 들어 `<Fred, 31>`을 `Fred is 31`로 변환됩니다.
- `joinToString(", ")`은 변환된 컬렉션의 각 항목을 문자열에 추가하고 `,`로 구분하며 마지막 항목에는 기호를 추가하지 않습니다.
- 이 모든 과정이 이전 Codelab에서 함수 호출 및 속성 액세스에서 실행한 것처럼 점 연산자(`.`)로 결합됩니다.

##### filter

`filter()`함수는 컬렉션에서 표현식을 기반으로 일치하는 항목을 반환

```kotlin
val filteredNames = peopleAges.filter { it.key.length < 4 }
println(filteredNames)
```

##### 람다 

이름이 없으며 곧바로 표현식으로 사용할 수 있는 함수는 람다 표현식 또는 람다라고 부름.

단일 매개변수가 있는 람다는 매개변수에 특수 식별자 it을 사용

##### 함수 유형

입력 매개변수와 반환 값을 기반으로 특정 유형의 함수를 정의할 수 있음.

 유형의 함수는 `Int` 유형의 매개변수를 사용하고 `Int` 유형의 값을 반환해야 합니다. 함수 유형 표기에서 괄호 안에 매개변수를 나열합니다(매개변수가 여러 개 있는 경우 쉼표로 구분). 다음에 화살표 `->`를 배치한 후 반환 유형을 나열합니다.

ex) ```{a:Int-> a*3}```

람다를 변수에 저장 할 수도있다.

```kotlin
fun main() {
    val triple: (Int) -> Int = { a: Int -> a * 3 }
    println(triple(5))
}
```

it 사용코드

```kotlin
val triple: (Int) -> Int = { it * 3 }
```

##### 고차함수

함수를 다른 함수로 전달하거나 다른 함수에서 함수를 반환하는 것을 의미

`map`, `filter`, `forEach` 함수는 모두 매개변수로 함수를 사용했으므로 고차함수의 예

새로운 고차 함수 `sortedWith()`의 예

```kotlin
println(peopleNames.sortedWith { str1: String, str2: String -> str1.length - str2.length })
```

`sortedWith`에 전달된 람다에는 두 매개변수, 즉 `String`인 `str1`과 `str2`가있습니다.

정렬하는 함수에는 `sortedBy` 와 `sortedWith`이 있는데 기준이 2개 이상이면 `sortedWith`를 사용

#### Android의 OnClickListener 및 OnKeyListener

LONG FORM

```kotlin
calculateButton.setOnClickListener{ object:View.OnClickListener{
    override fun onClick(view:View?){
        calculateTip()
    }
} }
```

SHORT FORM

```kotlin
calculateButton.setOnClickListener{ view->calculateTip() }
```

람다에 `OnClickListener`의 `onClick()` 메서드와 동일한 함수 유형이 있는 경우를 관찰합니다(`View` 인수 하나를 사용하고 반환 값이 없음을 의미하는 `Unit`을 반환함).

Kotlin의 단일 추상 메서드(SAM) 변환 때문에 축약 버전의 코드가 가능합니다. Kotlin은 람다를 단일 추상 메서드 `onClick()`을 구현하는 `OnClickListener` 객체로 변환합니다. 람다의 함수 유형이 추상 함수의 함수 유형과 일치하는지 확인하면 됩니다.

`view` 매개변수는 람다에서 사용되지 않으므로 이 매개변수를 생략해도 됩니다. 그런 다음 람다에 함수 본문을 배치하면 됩니다.

##### 단어 목록 만들기

```kotlin
val filteredWords = words.filter { it.startsWith("b", ignoreCase = true) }
```

지정된 문자열로 시작하는 문자열의 경우 `startsWith()`함수가 true를반환. 대소문자를 구분하지 않도록 `ignoreCase=true`

순서를 무작위로 하고싶으면뒤에 `.shuffled`를 붙이면 됨.

`take()`함수를 이용하면 지정된 개수만 가져올 수 있음.

✔ Activities and intents

##### 인텐트

인텐트란 실행할 작업을 나타내는 객체. 인텐트는 활동을 실행하는데 가장 많이 사용되지만 다른 용도도 존재. 인텐트는 암시적 인텐트와 명시적 인텐트가 있는데 명시적 인텐트는 매우 구체적이며 실행할 활동을 정확하게 알 수 있고 자체 앱의 화면인 경우가 많음. 암시적 인텐트는 좀 더 추상적이며 시스템에 링크 열기나 이메일 작성, 전화 걸기와 같은 작업 유형을 아렬주고 시스템은 요청 처리 방법을 파악해야함.일반적으로 자체 앱에서 활동을 표시할 때 명시적 인텐트를 사용. 그러나 현재 앱과 관련이 없는 작업의 경우 암시적 인텐트를 사용

##### 명시적 인텐트 설정

```kotlin
override fun onBindViewHolder(holder: LetterViewHolder, position: Int) {
    val item = list.get(position)
    holder.button.text = item.toString()
    holder.button.setOnClickListener(){
        val context=holder.view.context
        val intent= Intent(context,DetailActivity::class.java)
        intent.putExtra("letter", holder.button.text.toString())
        context.startActivity(intent)
    }
}
```

`context`는 어플리케이션이나 객체의 현재 상태를 나타내주는 역할.

`extra`란?

인텐트는 명령어의 집합. 대상 활동의 인스턴스는 아직 존재하지않음. 대신 `extra`는 나중에 검색할 수 있도록 이름이 지정된 숫자나 문자열과 같은 데이터. 함수를 호출할 때 인수를 전달하는 것과 비슷함. `DetailActivity` 는 어떤 문자에도 표시될 수 있으므로 표시할 문자를 알려줘야함.

`toString`을 사용하는 이유는? 

버튼의 텍스트는 사실 `CharSequence`유형으로, 인터페이스라고함.  인터페이스에 관해서는 우선은 문자열과 같은 유형이 특정 함수와 속성을 구현하도록 하는 방법이라는 점만 알아두기. `CharSequence`를 문자열과 같은 클래스의 좀 더 일반적인 표현이라고 생각. 버튼의 `text`속성은 문자열이거나 `CharSequence`이기도 한 객체일 수 있음. 그러나 `putExtra()`메서드는 `CharSequence`만이 아니라 `String`을 허용하므로 `toString()`을 호출해야함.

##### DetailActivity 설정

```kotlin
val letterId = intent?.extras?.getString("letter").toString()
```

`intent`속성의 출처는 `DetailActivity`의 속성이라기보다는 모든 활동의 속성. 활동을 실행하는 데 상요된 인텐츠 참조를 유지

`extras`속성은 `bundle`유형이고 인텐트에 전달된 모든 extras에 엑세스하는 방법을 제공

`bundle`은 키값과 여러가지 타입의 값을 저장하는 클래스. HashMap과 비슷한듯함

`intent`와 `extras` 모두 물음표로 표시된 이유는 intent 및 extras 속성은 null을 허용하므로 값이 있을 수도 있고 없을 수도 있기 때문. 앱이 속성에 엑세스하거나 null 객체에서 함수를 호출하려고 하면 다운됨. 이 값에 안정하게 엑세스하려면 이름 뒤에 `?`를 입력함. `intent`가 `null`이면 앱은 extras 속성 액세스를 시도조차 하지 않으며 `extras`가 `null`이면 코드에서 `getString()`을 호출하려고 시도조차 하지않음.

null 안전을 보장하기 위해 물음표가 필요한 속성을 아는 방법은 유형 이름 뒤에 물음표가 오는지 느낌표가 오는지 알 수 있음.

##### 삭제

두 코드가 모두 인텐트를 실행하고 선택된 문자를 검색하여 `extra`이름 'letter'를 하드코딩합니다. 이작은 예에서는 이런 방법이 작동하지만 추적할 인텐츠 extras가 훨씰 많은 큰 앱에는 최상의 접근 방식이 아님.

단순히 'letter'라는 상수를 만들어도 되지만 앱에 더 많은 인텐트 extras를 추가할 때 다루기 어려워질 수 있음. 코드를 체계적으로 유지하면서 여러 클래스에서 사용할 수 있는 상수를 정의할 방법이 필요. 이를 위해 유용한 kotlin의 기능을 사용하면 컴패니언 객체 라는 클래스의 특정 인스턴스 없이 상수를 구분하여 사용할 수 있음. 컴패니언 객체는 다른 개체와 비슷하나 프로그램 기간에 컴패니언 객체의 인스턴스는 하나만 존재하므로 싱글톤 패턴이라고도함. 이번에는 상수를 구성하여 `DetailActivity`외부에서 엑세스할 수 있도록 하는 방법으로 컴패니언 객체를 사용. 먼저 컴패니언 객체를 사용하여 'letter' extra의 코드를 리팩터링(결과의 변경 없이 코드의 구조를 재조정)함.

companion object는 어떤 클래스의 모든 인스턴스가 공유하는 객체를 만들고 싶을때 사용하며 클래스당 한개만 가질 수 있다. static과 비슷한 역할을 하는듯 함 

##### 암시적 인텐트 설정

```kotlin
companion object {
   val LETTER = "letter"
   val SEARCH_PREFIX = "https://www.google.com/search?q="
}
```

```kotlin
holder.button.setOnClickListener {
    val queryUrl: Uri = Uri.parse("${DetailActivity.SEARCH_PREFIX}${item}")
}
```

```kotlin
val intent = Intent(Intent.ACTION_VIEW, queryUrl)
```

`ACTION_VIEW`는 URI를 사용하는 일반적인 인텐트. 그러면 시스템은 사용자의 웹브라우저에서 URI를 열어 이 인텐트를 처리할 수 있음. 다른 인텐트 유형은 다음과 같다.

- `CATEGORY_APP_MAPS` - 지도 앱을 실행합니다.
- `CATEGORY_APP_EMAIL` - 이메일 앱을 실행합니다.
- `CATEGORY_APP_GALLERY` - 갤러리(사진) 앱을 실행합니다.
- `ACTION_SET_ALARM` - 백그라운드에서 알람을 설정합니다.
- `ACTION_DIAL` - 전화를 겁니다.

##### LayoutManager

- LinearLayoutManager : 수평, 수직의 스크롤 리스트
- GridLayoutManager : 행에 표시되는 아이템 갯수가 여러개인 리스트
- StaggeredGridLayoutManage : 높이가 불구칙적인 형태의 그리드 리스트
  로 이루어져 있습니다.

`ContextCompat`은 Resource에서 값을 가져오거나 퍼미션을 확인할 때 사용할 때 SDK버전을 고려하지 않아도 도디로고 내부적으로 sdk버전을 처리해둔 클래스.

`inflate`는 xml에 표기된 레이아웃들을 메모리에 객체화시키는 행동. 즉 xml코드들을 객체화해서 코드에서 사용하기 위해 사용.



인텐트를 실행하려면

1. 컨텍스트 참조를 가져온다
2. 명시적인지 암시적인지에 따라 활동이나 인텐트 유형을 제공하는 `Intent`객체를 만든다
3. `putExtra()`를 호출하여 필요한 데이터를 전달
4. intent 객체를 전달하는 `startActivirt()`를 호출

✔Stages of the activity lifecycle

<img src="img/lifecycle_ohs.png" width="400">

활동 수명 주기도  활동이 처음 초기화 될 때부터 마지막으로 소멸되어 시스템에서 메모리를 회수할 때까지 활동이 거쳐갈 수 있는 여러 상태로 구성됨. 사용자가 앱 시작하여 활동 간에 이동하고 앱 안팎으로 이동할 때 활동은 상태를 변경함.  동작을 변경하거나 활동 수명 주기 상태가 변경될 때 코드를 실행하려고 할 때가 많음. 따라서 `Activity`클래스 자체와 `Activity`의 모든 서브클래스는 일련의 수명 주기 콜백 메서드를 구현. 안드로이드에서는 활동이 한 상태에서 다른 상태로 이동할 때 이러한 콜백을 호출하고 개발자는 이러한 메서드를  자체 활동에서 재정의해 수명 주기 상태 변경에 응답해  작업을 진행할 수 있음.

이러한 콜백이 호출되는 시점과 각 콜백 메서드에서 할 작업을 알아야함.

##### 1단계:onCreate()메서드 확인 및 로깅 추가

모든 Activity에서 `onCreate()` 를 구성하고. `onCreate()`메서드에서의 Activity 의 일회성 초기화를 실행해야함 . `onCreate()`수명주기 메서드는 활동이 초기화된 직후 한 번 호출됨. `onCreate()`가 실행되면 Activity가 Created로 간주됨.

**참고:** `onCreate()` 메서드를 재정의할 때 슈퍼클래스 구현을 호출하여 활동 생성을 완료해야 하므로 활동 내에서 `super.onCreate()`를 즉시 호출해야 합니다. 다른 수명 주기 콜백 메서드의 경우에도 마찬가지입니다.

```kotlin
Log.d("MainActivity", "onCreate Called")
```

`Log`클래스는 Logcat에 메세지를 씀. Logcat은 메세지를 기록하는 콘솔. `Log.d()`메서드나 기타`Log`클래스 메서드를 사용하여 로그에 명시적으로 전송하는 메세지를 비롯하여 앱에 관한 안드로이드의 메세지가 여기에 표시됨.

로그 메세지의 우선순위: 메세지의 중요도를 나타냄. 이 경우에는 `Log.d()`메서드가 디버그 메세지를 작성. `Log` 클래스의 다른 메서드에는 정보 메세지의 경우 `Log.i()`나 오류 메세지의 경우 `Log.e()`,경고 메세지의 경우 `Log.w()`, 자세한 메세지의 경우 `Log.v()`가 있다.

##### 2단계: onStart()메서드 구현

`onStart()` 수명 주기 메서드는 `onCreate()` 직후에 호출. `onStart()`가 실행되면 활동이 화면에 표tl. 활동을 초기화하는 데 한 번만 호출되는 `onCreate()`와 달리 `onStart()`는 활동의 수명 주기에서 여러 번 호출될 수 있다. `onStart()`는 상응하는 `onStop()` 수명 주기 메서드와 페어링된다. 사용자가 앱을 시작한 후 기기 홈 화면으로 돌아오면 활동이 중지되고 더 이상 화면에 표시되지 않습니다.`onStart()`는 상응하는 `onStop()` 수명 주기 메서드와 페어링됩니다. 사용자가 앱을 시작한 후 기기 홈 화면으로 돌아오면 활동이 중지되고 더 이상 화면에 표시되지 않습니다.

##### 3단계: 더 많은 로그 구문 추가

활동이 처음부터 시작되면 다음 세 가지 수명 주기 콜백이 모두 순서대로 호출됩니다.

- `onCreate()` - 앱을 만듭니다.
- `onStart()` - 활동을 시작하고 화면에 표시되게 합니다.
- `onResume()` - 활동 포커스를 제공하고 사용자가 상호작용할 수 있도록 활동을 준비합니다.

이름에도 불구하고 `onResume()` 메서드는 다시 시작할 대상이 없어도 시작 시 호출됩니다.

##### 수명 주기 사용 사례 살펴보기

###### 활동 열기 및 닫기

 `onDestroy()` 메서드의 실행은 활동이 완전히 종료되었으며 가비지 컬렉션될 수 있음을 의미합니다. 가비지 컬렉션은 더 이상 사용하지 않을 객체의 자동 정리를 나타냅니다. `onDestroy()`가 호출되면 시스템은 이러한 리소스가 삭제될 수 있음을 인식하고 메모리 정리를 시작합니다.

`onCreate()`는 앱을 맨 처음 초기화할 때, `onDestroy()`는 앱에서 사용하는 리소스를 정리할 때 호출

###### 활동에서 이동 및 활동으로 다시 이동

사용자가 Android 기기와 상호작용할 때는 앱 간에 전환하거나 홈으로 돌아가거나 새 앱을 시작하거나 다른 활동(전화 통화 등)으로 인한 중단을 처리하기도함.

활동은 사용자가 활동에서 벗어날 때마다 완전히 닫히지 않습니다.

- 활동이 화면에 더 이상 표시되지 않으면 이는 활동이 *백그라운드*에 배치되는 것입니다. 이와 반대의 경우는 활동이 *포그라운드*에 있거나 화면에 표시되는 것입니다.
- 사용자가 앱으로 돌아오면 동일한 활동이 다시 시작되어 화면에 다시 표시됩니다. 수명 주기에서 이 부분을 앱의 *표시* 수명 주기라고 합니다.

앱은 백그라운드에 있을 때 시스템 리소스와 배터리 수명을 보존하기 위해 일반적으로 활발히 실행되지 않아야 합니다. `Activity` 수명 주기와 그 콜백을 사용하여 앱이 백그라운드로 이동하는 시점을 알 수 있어 진행 중인 작업을 일시중지할 수 있습니다. 그런 다음 앱이 포그라운드로 전환될 때 작업을 다시 시작합니다.

###### 부분적으로 활동 숨기기

앱이 시작되고 `onStart()`가 호출되면 앱이 화면에 표시된다는 것을 알아봤습니다. 앱이 다시 시작되고 `onResume()`이 호출되면 앱은 사용자 포커스를 확보합니다. 즉, 사용자가 앱과 상호작용할 수 있습니다. 앱이 완전히 화면에 표시되고 사용자 포커스를 보유하는 수명 주기 부분은 *대화형* 수명 주기라고 합니다.

커스와 가시성의 차이가 중요한 이유는 활동이 화면에 *부분적으로* 표시되지만 사용자 포커스는 없을 수 있기 때문입니다.  EX)공유버튼 클릭 이때는 `onStop()`은 호출되지않음. 활동이 계속 부분적으로 표시되기 때문 그러나 사용자 포커스가 없어 사용자가 상호작용할 수 없음. 포그라운드에 있는 '공유' 활동에 사용자 포커스가 있음.

`onPause()`만 사용한 중단은 보통 활동으로 돌아가거나 다른 활동 또는 앱으로 이동하기 전에 잠시 지속됩니다. 일반적으로 UI를 계속 업데이트하여 나머지 앱이 멈춘 것처럼 보이지 않도록 하는 것이 좋습니다.

`onResume()`과 `onPause()`는 모두 포커스와 관련이 있습니다. `onResume()` 메서드는 활동에 포커스가 있을 때 호출되고 `onPause()`는 활동에 포커스가 없을 때 호출됩니다.

##### 구성 변경사항 살펴보기

구성 변경은 기기 사앹가 매우 급격하게 변경되어 시스템이 변경사항을 확인하는 가장 쉬운 방법이 활동을 완전히 종료하고 다시 빌드하는 것일때 발생. ex) 기기 언어 변경, 기기 방향 변경

기기를 회전하면 활동이 종료되고 다시 만들어지면 활동은 기본값으로 재시작. 

##### onSaveInstanceState()를 사용하여 번들 데이터 저장

`onSaveInstanceState()` 메서드는 `Activity`가 소멸되면 필요할 수 있는 데이터를 저장하는 데 사용하는 콜백입니다. 수명 주기 콜백 다이어그램에서 `onSaveInstanceState()`는 활동이 중지된 후 호출됩니다. 또한 앱이 백그라운드로 전환될 때마다 호출됩니다. `onSaveInstanceState()`를 사용하면 활동이 포그라운드를 벗어날 때 소량의 정보를 번들에 저장할 수 있음.

Android가 앱 전체 프로세스를 종료하는 경우도 있는데 이 프로세스에는 앱과 관련된 모든  활동이 포함됨. Android는 시스템이 스트레스를 받고 시각적 지연의 위험이 있을때 이와 같이 종료하므로 콜백이나 코드가 이 시점에서 추가로 실행되지 않고 앱 프로세스는 백그라운드에서 자동으로 간단히 종료됨. 그러나 사용자에게는 앱이 닫힌것처럼 보이지 않고 사용자가 시스템이 종료한 앱으로 다시 이동하면 Android는 앱을 다시 시작. 이 경우 사용자가 데이터 손실을 경험하지 않도록 해야함.

`Bundle`은 키-값 쌍 모음으로, 키가 항상 문자열입니다. `Int` 및 `Boolean` 값과 같은 간단한 데이터를 번들에 넣을 수 있습니다. 시스템이 이 번들을 메모리에 유지하므로 번들의 데이터를 작게 유지하는 것이 좋습니다. 이 번들의 크기도 제한되지만 기기마다 크기는 다릅니다. 너무 많은 데이터를 저장하면 `TransactionTooLargeException` 오류로 인해 앱이 비정상 종료될 수 있습니다.

`putInt()` 메서드와 `putFloat()` 및 `putString()`과 같은 `Bundle` 클래스의 유사한 메서드는 두 가지 인수를 사용합니다. 키 문자열(`KEY_REVENUE` 상수)과 저장할 실제 값입니다.



##### onCreate()를 사용하여 번들 데이터 복원

`onCreate()`는 호출될 때마다`Bundle`을 가져옴. 포르세스 종료로 인해 활동이 다시 시작되면 저장한 번들이 `onCreate()`에 전달됨. 활동이 새로 시작되었다면 `onCreate()` `Bundle`은 `null` 따라서 번들이 `null`이 아니면 이전에 알려진 지점에서 활동을 다시 생성하고 있음을 알 수 있음.

<hr/>

#### Quiz

1. Which of the following is false about collections and higher order functions in Kotlin?

- Lists are unordered, while maps and sets are ordered data types.

2. Given the following code, what is the result of `oneWordCities[1]`?

```kotlin
val cities = listOf("Jeddah", "Bengaluru", "Shenzhen", "Abu Dhabi", "Mountain View", "Tripoli", "Bengaluru", "Lima", "Mandalay", "Tripoli")
val oneWordCities = cities.toSet().toList().filter { !it.contains(" ")}.sorted()
```

- Jeddah

3. 빈 칸 채우기 단어를 하나 이상 입력하여 문장을 완성하세요

- extra

4. If you open an app, and then leave the app using the back button, in which order were the following activity lifecycle methods called?

- `onCreate(), onStart(), onStop(), onDestroy()`

5. Which activity lifecycle method would be called if a dialog appears onscreen, partially obscuring an activity?

- `onPause()` because the activity is still displayed, but no longer has focus.

6. Which of the following is true about the lifecycle of a single activity?

- `onStart()` can be called multiple times, while `onCreate()` can only be called once.
- `onResume()` is called when the activity gains focus.

7. Which of the following is false about intents?

- An implicit intent always results in the system asking the user which app to open

8. An activity contains the following code in `onCreate()`. What will happen when this code is executed, if the `intent` property is `null`? 

```kotlin
val message = intent.extras?.getString("message"
).toString()
```

- The app will crash because it attempted to access a null object.

// intent뒤에 ?붙고 null이면 속성에 access조차 안함. extras뒤에?이고 null이면 toString()을 호출하려는 시도조차 안함.

9. Which of the following tasks can be performed in `onCreate()`?

- Configuring views, such as setting the layout manager of a recycler view.
- Getting extras from the intent that launched the activity.

10. In which method should you handle what happens when a button in the app bar is pressed?

- `onOptionsItemSelected()`

//`onCreateOptionsMenu` : 옵션 메뉴를 확장해 추가 설정을 실행

//`onOptionsItemSelected`: 버튼이 선택될 때 실제로 `chooseLayout`을 호출

