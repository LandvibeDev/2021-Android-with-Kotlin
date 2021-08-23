# 2021 Landvibe Summer Coding - Android

## Unit3 - Navigation

## PathWay1 - Navigate between screen

#### Kotlin의 컬렉션 

##### &#128204;컬렉션에 관해 알아보기

- 컬렉션 
  - 관련 항목 그룹 ( ex. 단어 목록, 직원 기록 목록 )
  - 순서 및 고유성 여부 선택 가능
  - ex) 목록 - 순서 o, 고유 x
  
- 집합 

  - 관련 항목 그룹
  - 중복될 수 없고 순서가 중요하지 않음
  - 항목이 있거나 없을 수 있지만, 있는 경우 한 개만 있음 (중복인 항목은 하나로 처리) 
  - `.toSet()` : 목록을 집합으로 변환
  - `setOf() `: 읽기 전용 집합
  - `mutableSetOf()` : 수정 가능한 집합
  - 순서나 변경 가능 여부와 상관없이 동일한 항목 집합을 포함하고 있으면 동일한 것으로 간주함
  - `contains()` : 특정 항목이 집합에 속하는지 확인하는 함수
  - `intersect()` : 교집합
  - `union() ` : 합집합

- 맵

  - key-value 쌍의 집합

  - 키는 고유하며 각 키는 정확히 하나의 값에 매핑, 값은 중복될 수 있음

  - 맵의 값은 문자열, 숫자, 객체 또는 다른 컬렉션일 수 있음

  - 초기화 예시

    ```kotlin
    val peopleAges = mutableMapOf<String, Int>(
    	"Fred" to 30,
    	"Ann" to 23
    )
    ```

  - `put()` : 맵에 항목 추가

  - `peopleAges["Joe"] = 51` : 약식 표기법으로 맵에 항목 추가

  - 동일한 키 중 하나를 사용하는 항목을 추가하면 해당 키의 값이 업데이트 됨



##### &#128204;컬렉션 사용

- forEach 
  - 자동으로 모든 항목을 탐색한 후 항목별로 작업 시행
  - 현재 항목의 변수를 지정하는 대신 특수 식별자 `it`사용
  - 마지막에 쉼표가 추가되어 있음 
- map
  - 컬렉션의 각 항목에 변환을 적용
  - `joinToString(", ") ` : 변환된 컬렉션의 각 항목을 문자열에 추가하고 `,`로 구분하며 마지막 항목에는 기호 추가 x
- filter
  - 컬렉션에서 표현식을 기반(조건)으로 일치하는 항목을 반환
  - `it`은 목록의 현재 항목을 나타냄



##### &#128204;람다 및 고차 함수에 관해 알아보기

- 람다

  - `forEach`, `map`, `filter`함수는 괄호 대신 함수 이름 다음에 중괄호를 사용, 중괄호 안에 람다 표현식 사용
  - 람다(익명함수) : 이름없이 곧바로 표현식으로 전달할 수 있는 함수
    - ex) { a: Int -> a*3 }

- 함수 유형

  - 입력 매개변수와 반환 값을 기반으로 특정 유형의 함수 정의

  - ex)  `(Int) -> Int` - `Int`유형의 매개변수를 사용하고 `Int`유형의 값을 반환

  - 람다를 변수에 저장

    ```kotlin
    val triple: (Int) -> Int = { a: Int -> a * 3 }
    ```

    -  `a: Int` 대신 `it` 사용

- 고차 함수

  - 함수를 다른 함수로 전달하거나 다른 함수에서 함수를 반환

- Android의 OnClickListener 및 OnKeyListener

  - 긴 버전

    ```kotlin
    calculateButton.setOnClickListener(object: View.OnClickListener {
    	override fun OnClick(view: View?){
    		calculateTip()
    	}
    })
    ```

  - 축약 버전

    ```kotlin
    calculateButton.setOnClickListener { view -> calculateTip() }
    ```

  - 함수 본문에서 특정 람다 매개변수를 사용하지 않는 경우 이름을 _로 지정 



##### &#128204;단어 목록 만들기

- `리스트.filter { it.startsWith(문자, ignoreCase = true ) } ` : 원하는 문자로 시작하는 단어의 컬렉션을 가져옴
- `shuffled() ` : 항목을 무작위로 섞음
- `take(숫자)` : 컬렉션의 첫 번재 항목부터 숫자만큼의 항목을 가져옴
- `sorted()` : 항목 정렬



#### 활동 및 인텐트

##### &#128204;Words 앱 개요

- `LetterAdapter` : `MainActivity`의 `RecyclerView`에서 사용
- `WordAdapter` : `RecyclerView`의 `DetailActivity`에서 단어 목록을 표시
- 각 문자는 `onClickListener`가 포함되어 버튼 누름을 처리해 `DetailActivity`로 이동
- 단어 목록에 있는 단어에도 `onClickListener`가 포함되어 버튼 누름을 처리해 브라우저로 이동



##### &#128204;인텐트 소개

- **암시적** 인텐트 
  - 추상적
  - 다른 앱이 관련된 작업을 실행하는 데 사용하고 시스템이 최종 결과를 결정
- **명시적** 인텐트 
  - 매우 구체적
  - 실행할 활동을 정확하게 알 수 있고 자체 앱의 화면인 경우가 많음
  - 전체 프로세스를 책임짐



##### &#128204;명시적 인텐트 설정

- 사용자가 문자를 탭하면 단어 목록으로 이동

  1. `LetterAdapter.kt`의 `holer.button`의 `onClickListener`설정

  2. `context`참조 가져옴

  3. `Intent`객체를 만들어 컨텍스트와 대상 활동의 클래스 이름을 전달

  4. `putExtra`메서드를 호출하여 '문자'를 첫 번째 인수로 전달하고 버튼 텍스트를 두 번재 인수로 전달해 `DetailActivity`에서 표시할 문자를 알려줌

     ```kotlin
     intent.putExtra("letter", holder.button.text.toString())
     ```

     :grey_question: `extra` : 나중에 검색할 수 있도록 이름이 지정된 숫자나 문자열과 같은 데이터, 함수 호출시 인수 전달하는 것과 유사

     :grey_question: `toString()`호출이 필요한 이유

      : 버튼의 텍스트는 `CharSequence`유형으로 *인터페이스*(문자열과 같은 클래스의 좀 더 일반적인 표현)라 부르는데 `putExtra`메서드는 `CharSequence`와 `String` 둘다 허용하므로 `toString()`으로 호출해줘야함

  5. 컨텍스트 객체에서 `startActivity()`메서드 호출해 `intent`전달



##### &#128204;DetailActivity 설정

- ```kotlin
  val letterId = intent?.extras?.getString("letter").toString()
  ```

  - `intent` 속성은 `DetailActivity`의 속성이라기보다는 모든 활동의 속성임

  - `extras`속성은 `Bundle`유형(여러가집 타입의 값을 저장하는 map 클래스)이고 인텐트에 전달된 모든 extras에 액세스하는 방법을 제공

  - `intent`와 `extras`속성이 물음표로 표시되는 이유

    : 두 속성은 null을 허용해 값이 있을 수도 있고 없을 수도 있기 때문

  - 물음표가 필요한 속성은 유형 뒤에 표시됨

  - 실제문자가 `getString`으로 검색되어 `String?`를 반환하므로 `toString()`을 호출해 null여부 확인

- 삭제

  - 인텐트를 실행하고 선택된 문자 검색해 `extra` 이름 'letter'를 하드코딩하면 추적할 인텐트 extras가 많은 큰 앱에서는 비 효율적
  - 'letter'라는 상수를 만들면 앱에 더 많은 인텐트 extras 추가하기 어려움

  :point_right: 컴패니언 객체의 재사용 가능한 상수를 유형의 인스턴스가 아닌 유형과 연결하는 기능을 이용해서 해결

  - 컴패니언 객체 : 객체의 생성없이 프로퍼티와 메서드에 대한 접근을 가능하게 함, 인스턴스가 하나 존재하여 싱글톤 패턴이라고도 함

  - `DetailActivity`의 `onCreate`위에 추가

    ```kotlin
    companion object {
    	const val LETTER = "letter"
    }
    ```

  - `onCreate()`에서 하드 코딩 문자 호출 업데이트

    ```kotlin
    val letterId = intent?.extras?.getString(LETTER).toString()
    ```

  - `LetterAdapter`의 `putExtra`수정

    ```kotlin
    intent.putExtra(DetailActivity.LETTER, holder.button.text.toString())
    ```



##### &#128204;암시적 인텐트 설정

- 단어 목록에서 단어 중 하나를 탭하면 기기가 URL로 이동(또는 설치된 앱에 따라 옵션 목록 표시)

- `DetailActivity` 수정

  ```kotlin
  companion object {
  	val LETTER = "letter"
  	val SEARCH_PREFIX = "https://www.google.com/serach?q="
  }
  ```

- `WordAdapter`의 `onBindViewHolder()`메서드의 버튼에서 `setOnClickListener()`호출 

  ```kotlin
  holder.button.setOnClickListener {
  	val queryUrl: Uri = Uri.parse("${DetailActivity.SEARCH_PREFIX}&{item}")
  }
  ```

  - URI : Uniform Resource Identifier, 인터넷에 있는 자원을 나타내는 주소 로 하위개념으로 URL, URN이 있음

- `queryUrl` 정의 후 새 `intent`객체 초기화

  ```kotlin
  val intent = Intent(Intent.ACTION_VIEW, queryUrl)
  ```

  - `ACTION_VIEW` : URI를 사용하는 일반적인 인텐트
  - `CATEGORY_APP_MAPS` : 지도 앱 실행
  - `CATEGORY_APP_EMAIL` : 이메일 앱 실행
  - `CATEGORY_APP_GALLERY` : 갤러리(사진) 앱 실행
  - `ACTION_SET_ALARM` : 백그라운드에서 알람 설정
  - `ACTION_DIAL` : 전화를 검

- 특정 활동을 실행하지 않더라도 `startActivity()`호출하고 `intent`전달해 시스템에서 다른 앱 실행 지시

  ```kotlin
  context.startActivity(intent)
  ```



##### &#128204;메뉴 및 아이콘 설정

- 메뉴 옵션을 추가해 사용자가 문자의 목록 및 그리드 레이아웃 간 전환 가능하게 함

- 앱 바 추가

  1. '뷰 모듈'과 '뷰 목록' 클립 아트 백터 애셋 추가

  2. **res**폴더에서 **New > Android Resource File**을 선택해 새 리로스 파일 추가 -  타입은 `Menu`, 이름은 `layout_menu`

  3. `layout_menu.xml`내용 수정

     ```kotlin
     <menu xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto">
        <item android:id="@+id/action_switch_layout"
            android:title="@string/action_switch_layout"
            android:icon="@drawable/ic_linear_layout"
            app:showAsAction="always" />
     </menu>
     ```

     - `showAsAction` : 시스템에 버튼 표시 방법을 알려줌
       - `always` : 앱 바에 항상 표시되고 더보기 메뉴에 속하지 않음



##### &#128204;메뉴 버튼 구현

- 레이아웃 상태 추적

  ```kotlin
  private var isLinearLayoutManager = true
  ```

- 버튼을 전환할 때 항목 목록을 항목 그리드로 전환

  ```kotlin
  private fun chooseLayout() {
  	if (isLinearLayoutManager) {
  		recyclerView.layoutManager = LinearLayoutManager(this)
  	}else {
  		recyclerView.layoutManager = GridLayoutManager(this,4)
  	}
  	recyclerView.adapter = LetterAdapter()
  }
  ```

- `onCreateOptionsMenu` : 옵션 메뉴를 확장해 추가 설정 실행

  ```kotlin
  override fun onCreateOptionsMenu(menu: Menu?): Boolean {
  	menuInflater.inflate(R.menu.layout_menu, menu)
  	
  	val layoutButton = menu?.findItem(R.id.action_switch_layout)
  	setIcon(layoutButton)
  	
  	return true
  }
  ```

- `onOptionsItemSelected` : 버튼이 선택될 때 실제로 `chooseLayout()`호출

  ```kotlin
  override fun onOptionsItemSelected(item: MenuItem): Boolean {
  	return when (item.itemId) {
  		R.id.action_switch_layout -> {
  			isLinearLayoutManager = !isLinearLayoutManager
  			chooseLayout()
  			setIcon(item)
  			
  			return true
  		}
  		else -> super.onOptionsItemSelected(item)
  	}
  }
  ```

- `onCreate` 업데이트

  ```kotlin
  override fun onCreate(savedInstanceState: Bundle?) {
  	super.onCreate(savedInstanceState)
  	
  	val binding = ActivityMainBinding.inflate(layoutInflater)
  	setContentView(binding.root)
  	
  	recyclerView = binding.recyclerView
  	chooseLayout()
  }
  ```



#### 활동 수명 주기 단계

##### &#128204;수명 주기 메서드 살펴보기 및 기본 로깅 추가

- 모든 활동에는 *수명 주기*가 있음

- 동작을 변경하거나 활동 수명 주기 상태가 변경될 때 

  - `Activity`클래스 자체와 `Activity`의 모든 서브클래스는 일련의 수명 주기 콜백 메서드 구현

    - 1단계 : onCreate() 메서드에서 `super.onCreate()`호출 뒤에 다음 줄 추가

      ```kotlin
      override fun onCreate(savedInstanceState: Bundle?){
      	Log.d("MainActivity", "onCreate Called")
      }
      ```

      - `Log`클래스는 **Logcat**에 메시지를 씀
      - `.d()` : 디버그 메시지 , `.i()` :정보 메시지, `.e()` : 오류 메시지, `.w()` : 경고 메시지, `.v()` : 자세한 메시지
      - 첫번째 매개변수 : Logcat에서 로그 메시지를 더 쉽게 찾을 수 있는 문자열, 클래스에서 TAG 상수를 선언하는게 좋음
      - 두번째 매개변수 : 실제 로그 메시지

    - 2단계 : onStart() 메서드 구현

      1. `MainActivity`클래스 내 커서가 있는 상태에서 **Code > Override Method** 선택

      2. `onStart` 검색해 `onStart()` 선택

      3. 함수 안 코드 작성

         ```kotlin
         override fun onStart() {
         	super.onStart()
         	Log.d(TAG, "onStart Called")
         }
         ```

      4. `class``MainActivity.`위에 있는 `MainActivity.kt`의 최상위 수준에 상수 추가

         ```kotlin
         const val TAG = "MainActivity"
         ```

    - 3단계 : 더 많은 로그 구문 추가

      - 활동이 처음부터 시작되면 다음 세가지 수명 주기 콜백이 순서대로 호출
        - `onCreate()` : 앱 만듦
        - `onStart()` : 활동을 시작하고 화면에 표시되게 함
        - `onResume()` : 활동 포커스를 제공하고 사용자가 상호작용할 수 있도록 활동을 준비, 다시 시작할 대상이 없어도 시작 시 호출됨



##### &#128204;수명 주기 사용 사례 살펴보기

- 사용 사례 1 : 활동 열기 및 닫기

  - 앱 열기 -> `onCreate()` , `onStart()` , `onResume()`가 순서대로 호출

  - 앱 닫기 -> `onPause()`, `onStop()`, `onDestroy()`가 순서대로 호출

  - `onDestroy() ` : 활동이 완전히 종료되었으며 가비지 컬렉션(더 이상 사용하지 않을 객체의 자동 정리)이 될 수 있음을 의미

- 사용 사례 2 : 활동에서 이동 및 활동으로 다시 이동

  - 활동이 백그라운드에 배치 -> `onPause()`, `onStop()`만 호출
  - 다시 백그라운드에 배치 -> `onRestart()`, `onStart()`로 다시 시작된 후 `onResume()`으로 재개

- 사용 사례 3 : 부분적으로 활동 숨기기

  - 대화형 수명 주기 : 앱이 완전히 화면에 표시되고 사용자 포커스를 보유하는 수명 주기 부분
  - 활동이 화면에 부분적으로 표시되지만 사용자 포커스가 없는 경우
    - 공유 버튼으로 앱의 절반만 표시될 때 -> `onPause()`호출
  - `onResume()`메서드는 활동에 포커스가 있을 때 호출, `onPause()`는 활동에 포커스가 없을 때 호출됨



##### &#128204;구성 변경사항 살펴보기

- 기기 회전 시 데이터 손실 

  - onSaveInstanceState()를 사용해 번들 데이터 저장

    - 클래스 정의 앞에 상수 추가

    ```kotlin
    const val KEY_REVENUE = "revenue_key"
    const val KEY_DESSERT_SOLD = "dessert_sold_key"
    ```

    - 로그 문구 추가 및 `revenue`값을 번들에 넣기

    ```kotlin
    override fun onSaveInstanceState(outState: Bundle) {
    	super.onSaveInstanceState(outState)
    	Log.d(TAg, "onSaveInstanceState Called")
        outState.putInt(KEY_REVENUE, revenue)
        outState.putIne(KEY_DESSERT_SOLD, dessertSold)
    }
    ```

  - onCreate()를 사용하여 번들 데이터 복원

    - `binding`변수가 설정된 직후에 다음 코드를 `onCreate()`에 추가

      ```kotlin
      if( savedInstanceState != null){
      	revenue = savedInstanceState.getInt(KEY_REVENUE, 0) 
          dessertsSold = savedInstanceState.getInt(KEY_DESSERT_SOLD, 0) 
      }
      ```

    - `MainActivity`에서 `showCurrentDessert()`메서드 업데이트

      ```kotlin
      for(dessert in allDesserts) {
      	if( dessertsSold >= dessert.startProductionAmount) {
      		newDessert = dessert
      	}
      	else break
      }
      ```

      

#### &#128204;Quiz

1.  컬렉션 및 고차 함수에 대한 설명

   - 목록, 맵 및 집합은 모두 고차 함수를 사용할 수 있음ㅇ
   - 집합의 요소와 마찬가지로 맵의 키는 고유해야 함, 그러나 여러 키가 동일한 값에 매핑 될 순 있음
   - 맵 및 필터와 같은 고차 함수는 람다 함수를 매개변수로 사용할 수 있음

2. 다음 코드가 주어지면 `oneWordCities[1]`의 결과는?

   ```kotlin
   val cities = listOf("Jeddah", "Bengaluru", "Shenzhen", "Abu Dhabi", "Mountain View", "Tripoli", "Bengaluru", "Lima", "Mandalay", "Tripoli")
   val oneWordCities = cities.toSet().toList().filter { !it.contains(" ")}.sorted()
   ```

   - Jeddah

3. `extras`는 인텐트를 시작할 때 활동 간에 전달되는 데이터 조각이다.

4. 앱을 연 다음 뒤로가기 버튼을 사용해 앱을 종료하는 경우 호출되는 활동 수명 주기 메서드 순서

   - `onCreate(), onStart(), onStop(), onDestroy()`

5. 대화 상자가 화면에 나타나 활동을 부분적으로 가리는 경우 호출되는 활동 수명 주기 메서드

   - `onPause()` - 활동이 계속 표시되지만 더이상 포커스가 없기 때문

6. 단일 활동의 수명 주기에 대한 설명

   - `onStart()` 는 여러번 호출 가능, `onCreate()`는 한번만 호출 가능
   - `onResume()`는 활동이 포커스를 얻을 때 호출됨

7. 인텐트에 대한 설명

   - 암시적 인텐트와 명시적 인텐트 모두 앱이 다른 활동을 시작할 수 있게 함
   - 명시적 인텐트를 사용하려면 표시하려는 활동의 클래스를 지정해야 함
   - 인텐트는 `startActivity()`메서드를 사용하여 수행됨

8. `onCreate().intent`속성이 `null`이면 어떻게 되는가?

   ```kotlin
   val message = intent.extras?.getString("message").toString()
   ```

   - null개체의 extras속성에 액세스하려고 했기 때문에 앱이 충돌함

9. `onCreate()`에서 수행할 수 있는 작업 

   - 재활용 보기의 레이아웃 관리자 설정과 같은 보기 구성
   - 활동을 시작할 때 인텐트의 추가 정보 획득

10. 앱 바의 버튼을 눌렀을 때 처리하는 방법

    - `onOptionsItemSelected()`

