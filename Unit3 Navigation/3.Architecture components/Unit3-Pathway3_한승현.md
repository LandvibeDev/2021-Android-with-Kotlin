# Unit3-Pathway3



* **ViewModel에 데이터 저장하기**

  * **시작하기 전에**

    * 앱 아키텍처는 일련의 디자인 규칙이며, 앱의 구조를 제시
    * 훌륭한 앱 아키텍처를 사용하면 유연하고 확장 가능하며 향후 유지관리가 가능한 코드를 짤 수 있음
    * `ViewModel` 을 사용하면저장된 데이터는 프레임워크에서 구성 변경이나 다른 이벤트 중에 액티비티와 프래그먼트가 소멸되고 다시 생성되는 경우에도 손실되지 않음
    * **학습할 내용**
      * Android 앱 아키텍처의 기본사항
      * 앱에서 `ViewModel` 클래스를 사용하는 방법
      * `ViewModel` 을 사용하여 기기 설정 변경 시에도 UI 데이터를 유지하는 방법
      * Kotiln의 지원 속성

  * **스타터 앱 개요**

    * **시작 코드의 문제**
      * **Submit** 버튼을 클릭해도 앱이 플레이어가 추측한 단어를 확인하지 않고 플레이어가 항상 득점
      * 게임을 종료할 방법이 없음. 한 게임에서 단어 10개를 초과하여 플레이할 수 있음
      * 게임 화면에 글자가 뒤섞인 단어, 플레이어의 점수, 단어 수가 표시됨. 기기나 에뮬레이터를 회전하면 현재 단어, 점수, 단어 수가 지워지고 게임이 처음부터 다시 시작됨

  * **앱 아키텍처 알아보기**

    * 아키텍처는 앱에서 클래스 간의 책임을 할당하는 가이드라인을 제공함

    * 앱 아키텍처가 잘 디자인되어 있으면 향후 앱을 확장하고 더 많은 기능을 포함할 수 있음

    * **일반적인 아키텍처 원칙**

      * **관심사 분리**

        * 관심사 분리 디자인 원칙은 각각 별개의 책임이 있는 여러 클래스로 앱을 나눠야 한다는 원칙

      * **모델에서 UI 만들기**

        * 가급적 지속적인 모델에서 UI를 만들어야 함

        * 모델은 앱의 데이터 처리를 담당하는 구성요소로, 앱의 `Views` 객체 및 앱 구성요소와 독립되어 있으므로 앱의 수명 주기 및 관련 문제의 영향을 받지 않음

        * Android 아키텍처의 기본 클래스 또는 컴포넌트는 UI 컨트롤러(액티비티/프래그먼트), `ViewModel`, `LiveData`, `Room`

        * 이러한 컴포넌트는 수명 주기의 복잡성을 어느 정도 처리하므로 수명 주기 관련 문제를 피하는 데 도움이 됨

        * 아래 다이어그램은 아키텍처의 기본적인 부분을 보여줌

          ![53dd5e42f23ffba9.png](https://developer.android.com/codelabs/basic-android-kotlin-training-viewmodel/img/53dd5e42f23ffba9.png)

        * **UI 컨트롤러(액티비티/프래그먼트)**

          * UI 컨트롤러는 화면에 뷰를 그리고 사용자 이벤트나 사용자가 상호작용하는 다른 모든 UI 관련 동작을 캡처하여 UI를 제어함. 앱의 데이터 또는 데이터에 관한 모든 의사 결정 로직은 UI 컨트롤러 클래스에 포함되어서는 안 됨
          * Android 시스템은 특정 사용자 상호작용을 기반으로 또는 메모리 부족과 같은 시스템 조건으로 인해 언제든지 UI 컨트롤러를 제거할 수 있음. 이러한 이벤트는 개발자가 직접 제어할 수 있는 것이 아니기 때문에, UI 컨트롤러에 앱 데이터나 상태를 저장해서는 안 됨. 대신 데이터에 관한 의사 결정 로직을 `ViewModel` 에 추가해야 함

        * **ViewModel**

          * `ViewModel` 은 뷰에 표시되는 앱 데이터의 모델. 모델은 앱의 데이터 처리를 담당하는 구성요소로, 아키텍처 원칙에 따라 모델에서 UI가 도출되는 앱을 만들 수 있음

          * `ViewModel` 은 Android 프레임워크에서 액티비티나 프래그먼트가 소멸되고 다시 생성될 때 폐기되지 않는 앱 관련 데이터를 저장함. `ViewModel` 객체는 구성이 변경되는 동안 자동으로 유지되어(액티비티나 프래그먼트 인스턴스처럼 소멸되지 않음) 보유하고 있는 데이터가 다음 액티비티 또는 프래그먼트 인스턴스에 즉시 사용될 수 있음

          * 앱에 `ViewModel` 을 구현하려면 아키텍처 컴포넌트 라이브러리에서 가져온 `ViewModel` 클래스를 확장하고 이 클래스 내에 앱 데이터를 저장함

            | 프래그먼트/액티비티(UI 컨트롤러)의 책임                      | `ViewModel`의 책임                                           |
            | ------------------------------------------------------------ | ------------------------------------------------------------ |
            | 액티비티 및 프래그먼트는 뷰와 데이터를 화면에 그리고 사용자 이벤트에 응답 | `ViewModel`은 UI에 필요한 모든 데이터를 보유하고 처리함. 뷰 계층 구조(예: 뷰 결합 객체)에 액세스하거나 활동 또는 프래그먼트의 참조를 보유해서는 안 됨 |

  * **ViewModel 추가하기**

    * 앱 데이터를 저장하는 `ViewModel` 을 앱에 추가함

    * 앱의 아키텍처는 다음과 같은 방식으로 구성됨. `MainActivity` 에 `GameFragment` 가 포함되어 있으며, `GameFragment` 는 `GameViewModel` 에 있는 게임 관련 정보에 액세스함

      <img src="https://developer.android.com/codelabs/basic-android-kotlin-training-viewmodel/img/2094f3414ddff9b9.png" alt="2094f3414ddff9b9.png" style="zoom:33%;" />

      1. Android 스튜디오의 Android 창에서 Gradle Scripts 폴더 아래에 있는 `build.gradle(Module:Unscramble.app)` 파일 열기

      2. 앱에서 `ViewModel` 을 사용하려면 `dependencies` 블록 내에 ViewModel 라이브러리 종속 항목이 있는지 확인

         ```
         // ViewModel
         implementation 'androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0'
         ```

      3. `GameViewModel` 이라는 새 Kotlin 클래스 파일 생성. Android 창에서 ui.game 폴더를 마우스 오른쪽 버튼으로 클릭하고 `New`>`Kotlin File/Class` 를 선택

      4. 이름을 `GameViewModel` 로 지정하고 목록에서 Class를 선택

      5. `GameViewModel` 을 `ViewModel` 의 서브클래스로 분류되도록 변경. `ViewModel` 은 추상 클래스이므로 앱에 사용할 수 있도록 확장해야 함

         ```kotlin
         class GameViewModel : ViewModel() {
         }
         ```

    * **ViewModel을 프래그먼트에 연결하기**

      * `ViewModel` 을 UI 컨트롤러(액티비티/프래그먼트)에 연결하려면 UI 컨트롤러 내에 `ViewModel` 에 관한 참조(객체)를 만들어야 함

      * 이 단계에서는 해당하는 UI 컨트롤러(`GameFragment`)내에 `GameViewModel` 의 객체 인스턴스 생성

        1. `GameFragment` 클래스 상단에 `GameViewModel` 유형의 속성을 추가

        2. `by viewModels()` Kotlin 속성 위임을 사용하여 `GameViewModel` 을 초기화

           ```kotlin
           private val viewModel: GameViewModel by viewModels()
           ```

        3. Android 스튜디오에서 메시지가 표시되면 `import androidx.fragment.app.viewModels` 를 추가

      * **Kotlin 속성 위임**

        * Kotlin에는 각 변경 가능한(var) 속성에 자동으로 생성된 기본 getter 함수와 setter 함수가 있음. 값을 할당하거나 속성 값을 읽을 때 setter 및 getter 함수가 호출됨

        * 읽기 전용 속성(val) 의 경우 변경 가능한 속성과 약간 다름. 기본적으로 getter 함수만 생성됨. 읽기 전용 속성의 값을 읽을 때 이 getter 함수가 호출됨

        * Kotlin에서 속성 위임을 사용하면 getter-setter 책임을 다른 클래스에 넘길 수 있음

        * 이 클래스(대리자 클래스라고 함)는 속성의 getter 및 setter 함수를 제공하고 변경사항을 처리

        * 대리자 속성은 다음과 같이 `by` 절 및 대리자 클래스 인스턴스를 사용하여 정의됨

          ```kotlin
          // Syntax for property delegation
          var <property-name> : <property-type> by <delegate-class>()
          ```

        * 앱에서 다음과 같이 기본 `GameViewModel` 생성자를 사용하여 뷰 모델을 초기화하는 경우

          ```kotlin
          private val viewModel = GameViewModel()
          ```

          기기에서 구성이 변경되는 동안 앱이 `viewModel` 참조의 상태를 손실하게 됨. 예를 들어 기기를 회전하면 액티비티가 소멸된 후 다시 생성되고 초기 상태의 새로운 뷰 모델 인스턴스가 다시 시작됨

        * 대신 속성 위임 접근 방식을 사용해 `viewModel` 객체의 책임을 `viewModels` 라는 별도의 클래스에 위임. 즉, `viewModel` 객체에 액세스하면 이 객체는 대리자 클래스 `viewModels` 에 의해 내부적으로 처리됨. 대리자 클래스는 첫 번째 액세스 시 자동으로 `viewModel` 객체를 만들고 이 값을 구성 변경 중에도 유지했다가 요청이 있을 때 반환함

  * **ViewModel로 데이터 이동하기**

    * 앱의 UI 데이터를 UI 컨트롤러(`Activity`/`Fragment` 클래스)에서 분리하면 위에서 설명한 단일 책임 원칙을 더 잘 준수할 수 있음. 액티비티와 프래그먼트는 화면에 뷰와 데이터를 그리고, `ViewModel` 은 UI에 필요한 모든 데이터를 보유하고 처리함

      1. 데이터 변수 `score`, `currentWordCount`, `currentScrambledWord` 를 `GameViewModel` 클래스로 이동

         ```kotlin
         class GameViewModel : ViewModel() {
         
             private var score = 0
             private var currentWordCount = 0
             private var currentScrambledWord = "test"
         ...
         ```

      2. 확인되지 않는 참조에 관한 오류가 표시됨(`GameFragment`에 있던 속성을 `GameViewModel`로 이동시켰기 때문). 이는 속성이 `ViewModel` 에만 공개되며 UI 컨트롤러에서 액세스할 수 없기 때문임

      위 문제를 해결하기 위해 접근 지정자를 `public` 으로 바꿀 수는 없음. 다른 클래스가 데이터를 수정해서는 안 되기 때문. 외부 클래스가 뷰 모델에 지정된 게임 규칙을 준수하지 않는 예기치 않은 방식으로 데이터를 변경할 수 있기 때문

      `ViewModel` 내에서는 데이터를 수정할 수 있어야 하므로 데이터는 `private` 및 `var` 이어야 함. `ViewModel` 외부에서는 데이터를 읽을 수 있지만 수정할 수는 없어야 하므로 데이터는 `public` 및 `val` 로 노출되어야 함. 이 동작을 실현하기 위해 Kotlin에는 `지원 속성` 이라는 기능이 존재함

    * **지원 속성**

      * 지원 속성을 사용하면 정확한 객체가 아닌 getter에서 무언가를 반환할 수 있음

      * Kotlin 프레임워크는 모든 속성별로 getter와 setter를 생성하는데, getter 메서드와 setter 메서드 중 하나 또는 둘 모두를 재정의하여 고유한 맞춤 동작을 제공할 수 있음. 지원 속성을 구현하려면 읽기 전용(val) 버전의 데이터를 반환하도록 getter 메서드를 재정의함

        ```kotlin
        // Declare private mutable variable that can only be modified
        // within the class it is declared.
        private var _count = 0
        
        // Declare another public immutable field and override its getter method.
        // Return the private property's value in the getter method.
        // When count is accessed, the get() function is called and
        // the value of _count is returned.
        val count: Int
           get() = _count
        ```

      * 앱에서 앱 데이터가 `ViewModel` 에만 공개되는 예시

        * `ViewModel` 클래스 내부: 
          * `_count` 속성이 `private var` 임. 따라서 `ViewModel` 클래스 내에서만 액세스하고 수정할 수 있음. 이름 지정 규칙은 `private` 속성 앞에 밑줄을 붙이는 것
        * `ViewModel` 클래스 외부: 
          * Kotlin의 기본 접근 지정자는 `public` 이므로, `count` 는 `public` 속성이며 UI 컨트롤러와 같은 다른 클래스에서 액세스할 수 있음. `get()` 메서드만 재정의되므로 이 속성은 변경할 수 없으며 읽기 전용임. 외부 클래스가 이 속성에 액세스하면 `_count` 의 값을 반환하며, 이 값은 수정할 수 없음. 이에 따라 `ViewModel` 에 있는 앱 데이터가 외부 클래스로 인해 원치 않게, 안전하지 않게 변경되지 않도록 보호되지만 외부 호출자는 값에 안전하게 액세스할 수 있음

      * **`currentScrambledWord`에 지원 속성 추가하기**

        1. `GameViewModel` 에서 `currentScrambledWord` 선언을 변경하여 지원 속성을 추가함. 이제 `GameViewModel` 내에서만 `_currentScrambledWord` 에 액세스하고 수정할 수 있음. UI 컨트롤러인 `GameFragment` 는 읽기 전용 속성 `currentScrambledWord` 를 사용하여 값을 읽을 수 있음

           ```kotlin
           private var _currentScrambledWord = "test"
           val currentScrambledWord: String
              get() = _currentScrambledWord
           ```

        2. `GameFragment` 에서 읽기 전용 `viewModel` 속성인 `currentScrambledWord` 를 사용하도록 `updateNextWordOnScreen()` 메서드를 업데이트

           ```kotlin
           private fun updateNextWordOnScreen() {
           	binding.textViewUnscrambledWord.text = viewModel.currentScrambledWord
           }
           ```

        3. `GameFragment` 에서 `onSubmitWord()` 메서드와 `onSkipWord()` 메서드 내의 코드를 삭제. 이런 메서드는 나중에 구현

        * 주의사항
          * `ViewModel` 에서 변경 가능한 데이터 필드를 노출하면 안 됨. 다른 클래스에서 이 데이터를 수정할 수 없도록 해야하며, `ViewModel` 내부의 변경 가능한 데이터는 항상 `private` 여야 함

  * **ViewModel 수명 주기**

    * 프레임워크는 액티비티나 프래그먼트의 범위가 유지되는 동안 `ViewModel` 을 유지함. `ViewModel` 은 소유자가 화면 회전과 같은 구성 변경으로 인해 소멸되는 경우에도 소멸되지 않으며, 소유자의 새 인스턴스는 아래 다이어그램과 같이 기존 `ViewModel` 인스턴스에 다시 연결됨

      <img src="https://developer.android.com/codelabs/basic-android-kotlin-training-viewmodel/img/18e67dc79f89d8a.png" alt="18e67dc79f89d8a.png" style="zoom:50%;" />

    * **ViewModel 수명 주기 이해하기**

      * `GameViewModel` 및 `GameFragment` 에 로깅을 추가하여 `ViewModel` 의 수명 주기를 더 잘 이해할 수 있음

        1. `GameViewModel.kt` 에서 로그 구문이 포함된 `init` 블록을 추가

           ```kotlin
           class GameViewModel : ViewModel() {
           	init {
           		Log.d("GameFragment", "GameViewModel created!")
           	}
           	...
           }
           ```

           Kotlin은 객체 인스턴스 초기화 중에 필요한 초기 설정 코드를 배치하는 장소로 이니셜라이저 블록(`init` 블록)을 제공함. 이 코드 블록은 객체 인스턴스가 처음 생성되어 초기화할 때 실행됨

        2. `GameViewModel` 클래스에서 `onCleared()` 메서드를 재정의함. `ViewModel` 은 연결된 프래그먼트가 분리되거나 액티비티가 완료되면 소멸됨. `ViewModel` 이 소멸되기 직전에 `onCleared()` 콜백이 호출됨

        3. `GameViewModel` 수명 주기를 추적하도록 `onCleared()` 내에 로그 구문을 추가

           ```kotlin
           override fun onCleared() {
           	super.onCleared()
           	Log.d("GameFragment", "GameViewModel destroyed!")
           }
           ```

        4. `onCreateView()` 내의 `GameFragment` 에서 binding 객체의 참조를 가져온 후에 프래그먼트 생성을 기록하는 로그 구문을 추가. `onCreateView()` 콜백은 프래그먼트가 처음 생성되면 트리거될 뿐 아니라 구성 변경과 같은 모든 이벤트에 관해 프래그먼트가 다시 생성될 때마다 트리거됨

           ```
           override fun onCreateView(
           	inflater: LayoutInflater, container: ViewGroup?,
           	savedInstanceState: Bundle?
           ): View {
           	binding = GameFragmentBinding.inflate(inflater, container, false)
           	Log.d("GameFragment", "GameFragment created/re-created!")
           	return binding.root
           }
           ```

        5. `GameFragment` 에서 상응하는 액티비티와 프래그먼트가 소멸될 때 호출되는 `onDetach()` 콜백 메서드를 재정의

           ```kotlin
           override fun onDetach() {
           	super.onDetach()
           	Log.d("GameFragment", "GameFragment destrooyed!")
           }
           ```

        6. Android 스튜디오에서 앱을 실행하고 Logcat 창을 열어 확인. 화면 방향을 바꾸면 `GameFragment` 는 계속 소멸되고 생성되지만 `GameViewModel` 은 한 번만 생성되며 매번 호출별로 다시 생성되거나 소멸되지 않으며, 게임을 종료하거나 앱에서 나갈 경우 `GameViewModel` 이 소멸되고 콜백 `onCleared()` 가 호출되고 `GameFragment` 가 소멸됨

  * **ViewModel 채우기**

    * 다음 단어를 가져오고, 플레이어의 단어를 검증하여 점수를 올리고, 단어 수를 확인하여 게임을 종료하는 도우미 메서드로 `GameViewModel` 을 더 채움

    * **지연 초기화**

      * 변수를 선언할 때는 일반적으로 사전에 변수에 초깃값을 제공하지만, 값을 할당할 준비가 되지 않을 경우 나중에 초기화할 수 있음. Kotlin에서 속성을 나중에 초기화하려면 지연된 초기화를 의미하는 `lateinit` 키워드를 사용
      * 속성을 사용하기 전에 초기화할 것을 보장한다면 `lateinit` 으로 속성을 선언할 수 있음. 변수가 초기화될 때까지는 변수에 메모리가 할당되지 않음. 초기화하기 전에 변수에 액세스하려고 할 경우 앱이 비정상 종료됨

    * **다음 단어 가져오기**

      * 다음 기능을 사용하여 `GameViewModel` 클래스에서 `getNextWord()` 메서드를 만듦

        * `allWordList` 에서 무작위로 단어를 가져와 `currentWord` 에 할당
        * `currentWord` 의 글자를 임의 배열하여 글자가 뒤섞인 단어를 만들고, `currentScrambledWord` 에 할당
        * 글자가 뒤섞인 단어와 뒤섞이지 않은 단어가 동일한 경우를 처리
        * 게임 중 같은 단어가 두 번 표시되지 않도록 함

      * `GameViewModel` 클래스에서 다음 단계를 구현

        1. `GameViewModel` 에서 `MutableList<String>` 유형의 새로운 클래스 변수 `wordsList` 를 추가하여 게임에 사용하는 단어의 목록을 보유함으로써 반복된 단어가 제시되지 않도록 함

        2. 플레이어가 추측해야 할 단어를 보유하는 `currentWord` 라는 또 다른 클래스 변수 추가. 이 속성은 나중에 초기화할 것이므로 `lateinit` 키워드 사용

           ```kotlin
           private var wordsList: MutableList<String> = mutableListOf()
           private lateinit var currentWord: String
           ```

        3. 매개변수가 없고 아무것도 반환하지 않는 새로운 `private` 메서드 `getNextWord()` 를 추가

        4. `allWordsList` 에서 무작위로 단어를 가져와 `currentWord` 에 할당

           ```kotlin
           private fun getNextWord() {
           	currentWord = allWordList.random()
           }
           ```

        5. `getNextWord()` 에서 `currentWord` 문자열을 문자 배열로 변환하여 `tempWord` 라는 새 `val` 에 할당. 단어의 글자를 뒤섞으려면 Kotlin 메서드 `shuffle()` 을 사용하여 이 배열의 글자 순서를 바꿈

           ```kotlin
           val tempWord = currentWord.toCharArray()
           tempWord.shuffle()
           ```

           `Array` 와 `List` 는 비슷하지만 초기화될 때 고정 크기를 가짐. `Array` 는 크기를 확장 및 축소할 수 없지만 `List` 에는 `add()` 와 `remove()` 가 있어 크기를 늘리고 줄일 수 있음

        6. 글자 순서를 바꾼 단어가 원래 단어와 동일한 경우가 있음. shuffle 호출 주위에 다음 `while` 루프를 추가하여 글자가 뒤섞인 단어가 원래 단어와 동일하지 않을 때까지 루프를 계속함

           ```kotlin
           while (tempWord.toString().equals(currentWord, false)) {
           	tempWord.shuffle()
           }
           ```

        7. 단어가 이미 사용되었는지 여부를 확인하는 `if-else` 블록을 추가. `wordList` 에 `currentWord` 가 포함된 경우 `getNextWord()` 를 호출하고 포함되지 않은 경우 새롭게 글자가 뒤섞인 단어로 `_currentScrambledWord` 값을 업데이트하고, 이 새 단어를 `wordsList`에 추가하고, 단어 수를 높임

           ```kotlin
           if (wordsList.contains(currentWord)) {
           	getNextWord()
           } else {
           	_currentScrambledWord = String(tempWord)
           	++currentWordCount
           	wordsList.add(currentWord)
           }
           ```

        8. 완성

    * **currentScrambledWord 지연 초기화**

      * `GameViewModel` 이 처음 초기화될 때 `getNextWord()` 를 호출함. `init` 블록을 사용해 클래스에서 `currentWord`와 같은 `lateinit` 속성을 초기화함. 그 결과, 화면에 표시되는 첫 번째 단어는 "test" 가 아닌 글자가 뒤섞인 단어가 됨

        1. 앱을 실행할 때, 첫 번째 단어는 항상 "test"임

        2. 앱 시작 시 글자가 뒤섞인 단어를 표시하려면 `getNextWord()` 메서드를 호출해야 함. 그러면 `currentScrambledWord` 가 업데이트되기 때문에, `GameViewModel` 의 `init` 블록 내에 `getNextWord()` 메서드를 호출함

           ```kotlin
           init {
           	Log.d("GameFragment", "GameViewModel created!")
           	getNextWord()
           }
           ```

        3. `_currentScrambledWord` 속성에 `lateinit` 한정자를 추가. 초깃값이 제공되지 않았으므로 `String` 데이터 유형의 명시적 언급을 추가함

           ```kotlin
           private lateinit var _currentScrambledWord: String
           ```

        4. 앱을 실행하면, 앱이 시작될 때 글자가 뒤섞인 새로운 단어가 표시됨

    * **도우미 메서드 추가하기**

      * `ViewModel`  내의 데이터를 처리하고 수정하는 도우미 메서드를 추가함. 이 메서드는 이후 작업에서 사용

        1. `GameViewModel` 클래스에서 `nextWord()` 라는 다른 메서드를 추가. 목록에서 다음 단어를 가져오고 단어 수가 `MAX_NO_OF_WORDS` 보다 적으면 `true` 반환

           ```kotlin
           fun nextWord(): Boolean {
           	return if (currentWordCount < MAX_NO_OF_WORDS) {
           		getNextWord()
               true
           	} else false
           }
           ```

  * **대화상자(Dialog)**

    * 단어 10개를 진행한 후에 게임이 종료되고 최종 점수 다이얼로그가 표시되도록 수정해보고, 사용자에게 다시 플레이하거나 게임을 종료할 옵션을 제공해보는 것이 목표

    * 대화상자(Dialog): 사용자에게 결정을 내리거나 추가 정보를 입력하라는 메시지를 표시하는 작은 창(화면)으로, 전체 화면을 가득 채우지 않으며 사용자가 조치를 취해야 계속 진행할 수 있음.

    * **알림 대화상자 구성**

      <img src="https://developer.android.com/codelabs/basic-android-kotlin-training-viewmodel/img/a5ecc09450ae44dc.png" alt="a5ecc09450ae44dc.png" />

      1. 알림 대화상자
      2. 제목(선택사항)
      3. 메시지
      4. 텍스트 버튼

    * **최종 점수 대화상자 구현하기**

      * 머터리얼 디자인 컴포넌트 라이브러리의 `MaterialAlertDialog` 를 사용하여 머터리얼 가이드라인을 따르는 대화상자를 앱에 추가. 대화상자는 UI와 관련이 있으므로, `GameFragment` 가 최종 점수 대화상자 생성과 표시를 담당함

        1. 먼저 `score` 변수에 지원 속성을 추가. `GameViewModel` 에서 `score` 변수 선언을 다음과 같이 변경

           ```kotlin
           private var _score = 0
           val score: Int
           	get() = _score
           ```

        2. `GameFragment` 에서 `showFinalScoreDialog()` 라는 `private` 함수를 추가. `MaterialAlertDialog` 를 만들려면 `MaterialAlertDialogBuilder` 클래스를 사용하여 대화상자의 부분을 단계별로 빌드해야 함. 프래그먼트의 `requireContext()` 메서드를 사용하여 콘텐츠를 전달하는 `MaterialAlertDialogBuilder` 생성자를 호출. `requireContext()` 메서드는 null이 아닌 `Context` 를 반환함

           ```kotlin
           private fun showFinalScoreDialog() {
           	MaterialAlertDialogBuilder(requireContext())
           }
           ```

           `Context` 라는 이름에서 알 수 있듯이 애플리케이션, 액티비티, 프래그먼트의 컨텍스트나 현재 상태를 의미함. 액티비티, 프래그먼트, 애플리케이션과 관련된 정보를 포함하고 있으며 일반적으로 리소스, 데이터베이스, 기타 시스템 서비스에 액세스하는 데 사용됨. 이 단계에서는 프래그먼트 컨텍스트를 전달하여 알림 대화상자를 만듦

           Android 스튜디오에서 메시지가 표시되면 `import com.google.android.material.dialog.MaterialAlertDialogBuilder` 를 추가

        3. 알림 대화상자의 제목을 설정하는 코드를 추가하고 `string.xml` 의 문자열 리소스를 사용

           ```kotlin
           MaterialAlertDialogBuilder(requireContext())
           	.setTitle(getString(R.string.congratulations))
           ```

        4. 최종 점수를 표시하도록 메시지를 설정한 후 이전에 추가한 읽기 전용 버전의 점수 변수를 사용

           ```kotlin
           	.setMessage(getString(R.string.you_scored, viewModel.score))
           ```

        5. 뒤로 키를 눌러 알림 대화상자를 취소할 수 없도록 함. `seteCancelable()` 메서드를 사용하고 `false` 를 전달하면 됨

           ```kotlin
           	.setCancelable(false)
           ```

        6. `setNegativeButton()` 메서드와 `setPositiveButton()` 메서드를 사용하여 **EXIT** 및 **PLAY AGAIN**의 두 텍스트 버튼을 추가. 람다에서 각각 `exitGame()` 과 `restartGame()` 을 호출

           ```kotlin
           	.setNegativeButton(getString(R.string.exit)) { _, _ ->
           		exitGame()
           	}
           	.setPositiveButton(getString(R.string.play_again)) { _, _ ->
           		restartGame()
           	}
           ```

           위 구문은 `setNegativeButton(getString(R.string.exit), { _, _ -> exitGame()})` 의 약식 표현임. 여기서 `setNegativeButton()` 메서드는 두 매개변수, 즉 `String` 과 함수 `DialogInterface.OnClickListener()` (람다로 표현 가능) 을 사용함. 전달되는 마지막 인수가 함수이면 괄호 바깥에 람다 표현식을 배치할 수 있음. 이를 **후행 람다 구문**일ㅏ고 하며, 람다를 괄호 안에 배치하거나 바깥에 배치하여 코드를 작성하는 방법 모두 허용됨. `setPositiveButton()` 도 마찬가지임

        7. 마지막으로 알림 대화상자를 만들고 표시하는 `show()`  를 추가

           ```kotlin
           	.show()
           ```

        8. 완성

  * **Submit 버튼의 OnClickListener 구현하기**

    * 이 작업에서는 추가한 `ViewModel` 과 알림 대화상자를 사용하여 **Submit** 버튼 클릭 리스너의 게임 로직을 구현

    * **글자가 뒤섞인 단어 표시하기**

      1. `GameFragment` 에서 **Submit** 버튼을 탭할 때 호출되는 `onSubmitWord()` 내의 코드를 삭제

      2. `viewModel.nextWord()` 메서드의 반환 값에 관한 확인을 추가. `true` 인 경우 다른 단어를 사용할 수 있으므로 `updateNextWordOnScreen()` 을 사용하여 글자가 뒤섞인 단어를 화면에 업데이트함. `true` 가 아닌 경우 게임이 종료되므로 최종 점수가 포함된 알림 대화상자를 표시

         ```kotlin
         private fun onSubmitWord() {
         	if(viewModel.nextWord()) {
         		updateNextWordOnScreen()
         	} else {
         		showFinalScoreDialog()
         	}
         }
         ```

      3. 앱을 실행하고 몇 단어를 플레이해보면, 텍스트 필드가 업데이트되지 않았으므로 플레이어가 이전 단어를 수동으로 삭제해야 함. 알림 대화상자의 최종 점수가 항상 0으로 표시되기 때문에 이러한 버그를 수정할 필요가 있음

  * **플레이어의 단어를 검증하는 도우미 메서드 추가하기**

    1. `GameViewModel` 에서 매개변수가 없고 반환 값이 없는 새로운 `private` 메서드 `increaseScore()` 를 추가. `score` 변수를 `SCORE_INCREASE` 단위로 증가시킴

       ```kotlin
       private fun increaseScore() {
       	_score += SCORE_INCREASE
       }
       ```

    2. `GameViewModel` 에서 `Boolean` 을 반환하고 `String`(플레이어의 단어)을 매개변수로 반환하는 `isUserWordCorrect()` 라는 도우미 메서드를 추가

    3. `isUserWordCorrect()` 에서 플레이어의 단어를 검증하고 플레이어가 추측한 단어가 올바르면 점수를 높임. 그러면 알림 대화상자의 최종 점수가 업데이트됨

       ```kotlin
       fun isUserWordCorrect(playerWord: String): Boolean {
       	if(playerWord.equals(currentWord, true)) {
       		increaseScore()
       		return true
       	} else {
       		return false
       	}
       }
       ```

  * **텍스트 필드 업데이트**

    * **텍스트 필드에 오류 표시하기**

      * 머터리얼 텍스트 필드의 경우 `TextInputLayout` 에 오류 메시지를 표시하는 기능이 내장되어 있음

      * 텍스트 필드에 오류를 표시하려면 코드에서 동적으로 또는 레이아웃 파일에서 정적으로 오류 메시지를 설정하면 됨

        ```kotlin
        // 코드에서 오류를 설정하고 재설정하는 예시
        // Set error text
        passwordLayout.error = getString(R.string.error)
        
        // Clear error text
        passwordLayout.error = null
        ```

      * 시작 코드에는 도우미 메서드인 `setErrorTextField(error: Boolean)` 가 이미 정의되어 있어서 텍스트 필드에 오류를 설정하고 재설정할 수 있음. 오류를 텍스트 필드에 표시할지 여부에 따라 `true` 나 `false` 를 입력 매개변수로 사용하여 이 메서드를 호출

      * 시작 코드의 코드 스니펫

        ```kotlin
        private fun setErrorTextField(error: Boolean) {
        	if (error) {
        		binding.textField.isErrorEnabled = true
            binding.textField.error = getString(R.string.try_again)
         	} else {
          	binding.textField.isErrorEnabled = false
            binding.textInputEditText.text = null
          }
        }
        ```

        이 작업에서는 onSubmitWord() 메서드를 구현함. 단어가 제출되면 사용자가 추측한 단어를 원래 단어와 비교하여 검증하고, 단어가 옳을 경우 다음 단어로 이동(게임이 종료된 경우 대화상자 표시)하며, 단어가 옳지 않은 경우 텍스트 필드에 오류를 표시하고 현재 단어를 유지함

        1. `GameFragment` 의 `onSubmitWord()` 시작 부분에 `playerWord` 라는 `val` 을 만듦. 플레이어의 단어를 `binding` 변수의 텍스트 필드에서 추출하여 저장함

           ```kotlin
           private fun onSubmitWord() {
           	val playerWord = binding.textInputEditText.text.toString()
           }
           ```

        2. `onSubmitWord()` 의 `playerWord` 선언 아래에서 플레이어의 단어를 검증. `playerWord` 를 전달하고 `isUserWordCorrect()` 메서드를 사용하여 플레이어의 단어를 확인하는 `if` 문을 추가

        3. `if` 블록 내에서 텍스트 필드를 재설정하고 `false` 를 전달하는 `setErrorTextField` 를 호출

        4. 기존 코드를 `if` 블록 내부로 이동

           ```kotlin
           private fun onSubmitWord() {
           	val playerWord = binding.textInputEditText.text.toString()
           	
           	if(viewModel.isUserWordCorrect(playerWord)) {
           		setErrorTextField(false)
           		if(viewModel.nextWord()) {
           			updateNextWordOnScreen()
           		} else {
           			showFinalScoreDialog()
           		}
           	}
           }
           ```

        5. 사용자 단어가 옳지 않은 경우 텍스트 필드에 오류 메시지를 표시. 위의 `if` 블록에 `else` 블록을 추가하고 `true` 를 전달하는 `setErrorTextField()` 를 호출

           ```kotlin
           private fun onSubmitWord() {
           	val playerWord = binding.textInputEditText.text.toString()
           	
           	if(viewModel.isUserWordCorrect(playerWord)) {
           		setErrorTextField(false)
           		if(viewModel.nextWord()) {
           			updateNextWordOnScreen()
           		} else {
           			showFinalScoreDialog()
           		}
           	} else {
           		setErrorTextField(true)
           	}
           }
           ```

  * **Skip 버튼 구현하기**

    * **Skip** 버튼을 클릭한 경우를 처리하는 `onSkipWord()` 의 구현을 추가

      1. `onSubmitWord()` 와 마찬가지로 `nextWord()` 메서드에 조건을 추가함. `true` 인 경우에 화면에 단어를 표시하고 텍스트 필드를 재설정함. `false` 이고 게임에 더 이상 남은 단어가 없는 경우 최종 점수가 포함된 알림 대화상자를 표시함

         ```
         private fun onSkipWord() {
         	if(viewModel.nextWord()) {
         		setErrorTextField(false)
         		updateNextWordOnScreen()
         	} else {
         		showFinalScoreDialog()
         	}
         }
         ```

      2. 실행해보면 **Skip** 버튼과 **Submit** 버튼이 의도한 대로 작동하는 것을 확인할 수 있음

  * **ViewModel에 데이터가 보존되는지 확인하기**

    * `GameFragment` 에 로깅을 추가하여 구성 변경 중에 앱 데이터가 `ViewModel` 에 보존되는지 관찰하고, `GameFragment` 의 `currentWordCount` 에 액세스하려면 지원 속성을 사용하여 읽기 전용 버전을 노출해야 함

      1. `GameViewModel` 에서 `currentWordCount` 변수를 마우스 오른쪽 버튼으로 클릭하고 `Refactor`>`Rename` 을 선택하고, 새 이름 앞에 밑줄을 붙여 `_currentWordCount` 로 변경

      2. 지원 필드를 추가

         ```kotlin
         private var _currentWordCount = 0
         val currentWordCount: Int
         	get() = _currentWordCount
         ```

      3. `GameFragment` 의 `onCreateView()` 에서 return 문 위에 앱 데이터, 단어, 점수, 단어 수를 출력하는 또 다른 로그를 추가

         ```kotlin
         Log.d("GameFragment", "Word: ${viewModel.currentScrambleWord} " +
         			"Score: ${viewModel.score} WordCount: ${viewModel.currentWordCount}")
         ```

      4. Android 스튜디오에서 Logcat을 열고 확인해보고, 기기의 방향을 변경해 프래그먼트(UI 컨트롤러) 가 소멸된 후 다시 생성되는 것을 확인한 후 로그를 관찰하면 이제 점수와 단어 수가 증가하는 것을 확인할 수 있음. 기기 방향이 변경되는 동안 `ViewModel` 의 앱 데이터가 보존된 것을 확인할 수 있음

  * **게임 재시작 로직 업데이트하기**

    1. 앱을 다시 실행하고 한 게임의 모든 단어를 플레이하고 **PLAY AGAIN** 을 눌렀을 때, 단어 수가 `MAX_NO_OF_WORDS` 에 도달하여 앱에서 더 플레이할 수 없음. 게임을 처음부터 다시 플레이하려면 단어 수를 0으로 재설정해야 함

    2. 앱 데이터를 재설정하려면 `GameViewModel` 에 `reinitializeData()` 라는 메서드를 추가. 점수와 단어 수를 0으로 설정하고, 단어 목록을 지우며 `getNextWord()` 메서드를 호출

       ```kotlin
       fun reinitializeData() {
       	_score = 0
       	_currentWordCount = 0
       	wordsList.clear()
       	getNextWord()
       }
       ```

    3. `GameFragment` 의 `restartGame()` 메서드 상단에 새로 생성된 메서드인 `reinitializeData()` 를 호출

       ```kotlin
       private fun restartGame() {
       	viewModel.reinitializeData()
       	setErrorTextField(false)
       	updateNextWordOnScreen()
       }
       ```

    4. 앱을 다시 실행하고 **PLAY AGAIN** 을 클릭해보면 게임을 다시 플레이할 수 있음
  
* **ViewModel과 함께 LiveData 사용하기**

  * **시작하기 전에**

    * `LiveData` 를 `ViewModel` 의 데이터와 통합하는 방법을 알아보기
    * **학습할 내용**
      * 앱에서 `LiveData` 및 `MutableLiveData` 를 사용하는 방법
      * `ViewModel` 에 저장된 데이터를 `LiveData` 로 캡슐화하는 방법
      * `LiveData` 에서 변경사항을 관찰하는 관찰자 메서드를 추가하는 방법
      * 레이아웃 파일에서 결합 표현식을 작성하는 방법

  * **LiveData란?**

    * `LiveData` 는 수명 주기를 인식하는 식별 가능한 데이터 홀더 클래스
    * `LiveData` 의 특성
      * `LiveData` 는 데이터를 보유함. `LiveData` 는 모든 유형의 데이터에 사용할 수 있는 래퍼
      * `LiveData` 는 관찰 가능함. `LiveData` 객체에서 보유한 데이터가 변경되면 관찰자에게 알림이 제공됨
      * `LiveData` 는 수명 주기를 인식함. `LiveData` 에 관찰자를 연결하면 관찰자는 `LifeCycleOwner`(일반적으로 액티비티 또는 프래그먼트) 와 연결됨. `LiveData` 는 `STARTED` 또는 `RESUMED` 와 같은 활성 수명 주기 상태인 관찰자만 업데이트함
    * **시작 코드의 UI 업데이트**
      * UI에 글자가 뒤섞인 새로운 단어를 표시하려고 할 때마다 시작 코드에서 `updateNextWordOnScreen()` 메서드가 명시적으로 호출됨. 게임이 초기화되는 동안이나 플레이어가 **Submit** 또는 **Skip** 버튼을 눌렀을 때 이 메서드를 호출함. 이 메서드는 `onViewCreated()`, `restartGame()`, `onSkipWord()`, `onSubmitWord()` 메서드에서 호출됨
      * `LiveData` 를 사용하면 UI를 업데이트하기 위해 여러 위치에서 이 메서드를 호출하지 않아도 됨. 관찰자에서 한 번만 실행됨

  * **글자가 뒤섞인 현재 단어에 LiveData 추가하기**

    * `GameViewModel` 의 현재 단어를 `LiveData` 로 변환하여 `LiveData` 로 데이터를 래핑하는 방법을 알아봄
    * 이후 작업에서는 이 `LiveData` 객체에 관찰자를 추가하고 `LiveData` 를 관찰하는 방법을 알아봄
    * **MutableLiveData**
      * `MutableLiveData` 는 변경 가능한 버전의 `LiveData` 임. 즉, 내부에 저장된 데이터의 값을 변경할 수 있음
        1. `GameViewModel` 에서 변수 `_currentScrambledWord` 의 유형을 `MutableLiveData<String>` 으로 변경. `LiveData` 및 `MutableLiveData` 는 일반 클래스이므로 이러한 클래스에 보유되는 데이터의 유형을 지정해야 함
        2. `LiveData` / `MutableLiveData` 객체의 값은 동일하게 유지되고 이 객체에 저장된 데이터만 변경되기 때문에 `_currentScrambledWord` 의 변수 유형을 `val` 로 변경
        3. 지원 필드 `currentScrambledWord` 를 변경할 수 없기 때문에 그 유형을 `LiveData<String>` 으로 변경. Android 스튜디오에서 몇 가지 오류가 표시되며, 이 오류를 다음 단계에서 수정함
        4. `LiveData` 객체 내의 데이터에 액세스하려면 `value` 속성을 사용. `getNextWord()` 메서드의 `GameViewModel` 에서 `else` 블록 내에 있는 `_currentScrambledWord` 의 참조를 `_currentScrambledWord.value` 로 변경

  * **LiveData 객체에 관찰자 연결하기**

    * 앱 구성요소 `GameFragment` 에서 관찰자를 설정. 추가할 관찰자는 앱 데이터 `currentScrambledWord` 의 변경 사항을 관찰. `LiveData` 는 수명 주기를 인식. 즉, 활성 수명 주기 상태인 관찰자만 업데이트함. 따라서 `GameFragment` 의 관찰자는 `GameFragment` 가 `STARTED` 또는 `RESUMED` 상태인 경우에만 알림을 받음

      1. `GameFragment` 에서 메서드 `updateNextWordOnScreen()` 및 이 메서드의 모든 호출을 삭제. 여기서는 `LiveData` 에 관찰자를 연결하므로 이 메서드가 필요하지 않음

      2. `onSubmitWord()` 에서 빈 `if-else` 블록을 다음과 같이 수정

         ```kotlin
         private fun onSubmitWord() {
             val playerWord = binding.textInputEditText.text.toString()
         
             if (viewModel.isUserWordCorrect(playerWord)) {
                 setErrorTextField(false)
                 if (!viewModel.nextWord()) {
                     showFinalScoreDialog()
                 }
             } else {
                 setErrorTextField(true)
             }
         }
         ```

      3. `currentScrambledWord` `LiveData` 의 관찰자를 연결. `GameFragment` 의 `onViewCreated()` 콜백 끝에서 `currentScrambledWord` 에 관해 `observe()` 메서드를 호출

         ```kotlin
         viewModel.currentScrambledWord.observe()
         ```

      4. `viewLifecycleOwner` 를 첫 번째 매개변수로 `observe()` 메서드에 전달. `viewLifecycleOwner` 는 프래그먼트의 뷰 수명 주기를 나타냄. 이 매개변수를 사용하면 `LiveData` 가 `GameFragment` 수명 주기를 인식하고 `GameFragment` 가 활성 상태(`STARTED` 또는 `RESUMED`) 일 때만 관찰자에게 알릴 수 있음

      5. `newWord` 를 함수 매개변수로 사용하여 두 번째 매개변수로 람다를 추가. `newWord` 에는 글자가 뒤섞인 새 단어 값이 포함됨

      6. 람다 표현식의 함수 본문에서 `newWord` 를 글자가 뒤섞인 단어 텍스트 뷰에 할당

         ```kotlin
         viewModel.currentScrambledWord.observe(viewLifecycleOwner, 
         	{ newWord ->
            		binding.textViewUnscrambledWord.text = newWord
         	})
         ```

      7. 앱을 컴파일하고 재실행하면 이제는 글자가 뒤섞인 단어 텍스트 뷰가 `updateNextWordOnScreen()` 메서드가 아닌 `LiveData` 관찰자에서 자동으로 업데이트됨

  * **점수 및 단어 수에 관찰자 연결하기**

    * 앞의 작업과 마찬가지로 이 작업에서는 `LiveData` 를 앱의 다른 데이터, 점수, 단어 수에 추가하여 게임 중에 UI에 점수와 단어 수의 값이 올바르게 업데이트되도록 함

      1. **LiveData로 점수 및 단어 수 래핑하기**

         1. `GameViewModel` 에서 `_score` 및 `_currentWordCount` 클래스 변수의 유형을 `val` 로 변경

         2. `_score` 변수와 `_currentWordCount` 변수의 데이터 유형을 `MutableLiveData` 로 변경하고 변수를 `0`으로 초기화

         3. 지원 필드 유형을 `LiveData<Int>` 로 변경

            ```kotlin
            private val _score = MutableLiveData(0)
            val score: LiveData<Int>
            	get() = _score
            
            private val _currentWordCount = MutableLiveData(0)
            val currentWordCount: LiveData<Int>
            	get() = _currentWordCount
            ```

         4. `GameViewModel` 의 `reinitializeData()` 메서드 시작 부분에서 `_score` 및 `_currentWordCount` 의 참조를 각각 `_score.value` 및 `_currentWordCount.value` 로 변경

            ```kotlin
            fun reinitializeData() {
            	_score.value = 0
              _currentWordCount.value = 0
              wordsList.clear()
              getNextWord()
            }
            ```

         5. `GameViewModel` 의 `nextWord()` 메서드 내에서 `_currentWordCount` 의 참조를 `_currentWordCount.value!!` 로 변경

            ```kotlin
            fun nextWord(): Boolean {
            	return if (_currentWordCount.value!! < MAX_NO_OF_WORDS) {
                getNextWord()
                true
              } else false
            }
            ```

         6. `GameViewModel` 의 `increaseScore()` 메서드와 `getNextWord()` 메서드 내에서 `_score` 및 `_currentWordCount` 의 참조를 각각 `_score.value` 및 `_currentWordCount.value` 로 변경

         7. Kotlin 함수 `plus()` 를 사용하여 `_score` 값을 늘림. 그러면 null에 안전하게 덧셈이 처리됨

            ```kotlin
            private fun increaseScore() {
            	_score.value = (_score.value)?.plus(SCORE_INCREASE)
            }
            ```

         8. 마찬가지로 Kotlin 함수 `inc()` 를 사용하여 null에 안전하게 값을 1씩 증분

            ```kotlin
            private fun getNextWord() {
            	...
            	} else {
            		_currentScrambledWord.value = String(tempWord)
            		_currentWordCount.value = (_currentWordCount.value)?.inc()
            		wordsList.add(currentWord)
            	}
            }
            ```

         9. `GameFragment` 에서 `value` 속성을 사용하여 `score` 값에 액세스함. `showFinalScoreDialog()` 메서드 내에서 `viewModel.score` 를 `viewModel.score.value` 로 변경

            ```kotlin
            private fun showFinalScoreDialog() {
            	MaterialAlertDialogBuilder(requireContext())
            		.setTitle(getString(R.string.congratulations))
            		.setMessage(getString(R.string.you_scored, viewModel.score.value))
            		...
            		.show()
            }
            ```

      2. **관찰자를 점수 및 단어 수에 연결하기**

         1. `GameFragment` 의 `onViewCreated()` 메서드 내에서 점수 및 단어 수 텍스트 뷰를 업데이트하는 코드를 삭제

         2. `GameFragment` 의 `onViewCreated()` 메서드 끝부분에 `score` 의 관찰자를 연결. `viewLifecycleOwner` 를 첫 번째 매개변수로 관찰자에 전달하고 두 번째 매개변수용으로 람다 표현식을 전달. 람다 표현식 내에서 새 점수를 매개변수로 전달하고 함수 본문 내에서 새 점수를 텍스트 뷰로 설정

            ```kotlin
            viewModel.score.observe(viewLifecycleOwner, 
            	{ newScore ->
            			binding.score.text = getString(R.string.score, newScore)
            	})
            ```

         3. `onViewCreated()` 메서드 끝부분에 `currentWordCount` `LiveData` 의 관찰자를 연결. `viewLifecycleOwner` 를 첫 번째 매개변수로 관찰자에 전달하고 두 번째 매개변수용으로 람다 표현식을 전달. 람다 표현식 내에서 새 단어 수를 매개변수로 전달하고 함수 본문에서 `MAX_NO_OF_WORDS` 와 함께 새 단어 수를 텍스트 뷰로 설정

            ```kotlin
            viewModel.currentWordCount.observe(viewLifecycleOwner, 
            	{ newWordCount ->
            			binding.wordCount.text = 
            				getString(R.string.word_count, newWordCount, MAX_NO_OF_WORDS)
            	})
            ```

            `ViewModel` 내에서 viewLifecycleOwner의 전체 기간(즉, `GameFragment`) 중에 점수와 단어 수의 값이 변경되면 새 관찰자가 트리거됨

         4. 앱을 실행하여 결과를 확인. 점수와 단어 수도 화면에 올바르게 업데이트됨. `score` 및 `currentWordCount` 는 `LiveData` 이며 기본 값이 변경되면 상응하는 관찰자가 자동으로 호출됨

  * **Data Binding과 함께 LiveData 사용하기**

    * 개념: **Data Binding**

      * 이전에는 단방향 결합인 `View Binding` 을 학습함. 뷰를 코드에 바인딩할 수 있지만 코드를 뷰에 바인딩할 수는 없음

      * `View Binding` 복습

        * 뷰 결합은 코드에서 뷰에 더 쉽게 액세스할 수 있는 기능으로, 각 XML 레이아웃 파일의 결합 클래스를 생성함. 결합 클래스의 인스턴스에 상응하는 레이아웃에 ID가 있는 모든 뷰의 직접 참조가 포함됨
        * 뷰 결합을 사용하면 뷰(레이아웃 파일)에서 앱 데이터를 참조할 수 없음. 이 작업은 데이터 결합(Data Binding) 을 사용하면 됨

      * **데이터 결합(Data Binding)**

        * 데이터 결합 라이브러리는 `Android Jetpack 라이브러리` 의 일부. 데이터 결합은 선언적 형식을 사용하여 레이아웃의 UI 구성요소를 앱의 데이터 소스에 바인딩함

        * 데이터 결합은 코드에서 데이터를 뷰 + 뷰 결합에 결합(뷰를 코드에 결합) 하는 것

        * UI 컨트롤러에서 뷰 바인딩 사용의 예

          ```kotlin
          binding.textViewUnscrambledWord.text = viewModel.currentScrambledWord
          ```

        * 레이아웃 파일에서 데이터 바인딩 사용의 예

          ```xml
          android:text="@{gameViewModel.currentScrambledWord}"
          ```

      1. **뷰 바인딩을 데이터 바인딩으로 변경하기**

         1. `build.gradle(Module)` 파일의 `buildFeatures` 섹션에서 `dataBinding` 속성을 사용 설정

            ```kotlin
            buildFeatures {
            	viewBinding = true
            	dataBinding = true
            }
            ```

         2. Kotlin 프로젝트에서 데이터 바인딩을 사용하려면 `kotlin-kapt` 플러그인을 적용해야 함

            ```kotlin
            plugins {
            	id 'com.android.application'
            	id 'kotlin-android'
            	id 'kotlin-kapt'
            }
            ```

            위의 단계는 앱의 모든 레이아웃 XML 파일용 바인딩 클래스를 자동으로 생성. 레이아웃 파일 이름이 `activity_main.xml` 인 경우 자동 생성 클래스의 이름은 `ActivityMainBinding` 이 됨

      2. **레이아웃 파일을 데이터 바인딩 레이아웃으로 변환하기**

         데이터 바인딩 레이아웃 파일은 약간 차이가 있으며 `<layout>` 의 루트 태그로 시작하고 선택적 `<data>` 요소 및 `view` 루트 요소가 뒤따름. 이 view 요소는 루트가 바인딩 레이아웃 파일이 아닌 파일에 있는 요소

         1. `game_fragment.xml` 을 열고 code 탭 선택

         2. 레이아웃을 데이터 바인딩 레이아웃으로 변환하려면 루트 요소를 `<layout>` 태그로 래핑. 또한 네임스페이스 정의(`xmlns:` 로 시작하는 속성)를 새 루트 요소로 이동해야 함. 루트 요소 위에 있는 `<layout>` 태그 내부에 `<data></data>` 태그를 추가. Android 스튜디오에서는 루트 요소(`ScrollView`) 를 마우스 오른쪽 버튼으로 클릭하고 **Show Context Actions > Convert to data binding layout**을 선택하면 자동으로 간편하게 추가할 수 있음

         3. `GameFragment` 의 `onCreateView()` 메서드 시작 부분에서 데이터 바인딩을 사용하도록 `binding` 변수의 인스턴스화를 변경

            ```kotlin
            binding = DataBindingUtil.inflate(inflater, R.layout.game_fragment, container, false)
            ```

         4. 이제 앱이 데이터 바인딩을 사용하고 레이아웃의 뷰가 앱 데이터에 액세스할 수 있음

  * **데이터 바인딩 변수 추가하기**

    * 이 작업에서는 레이아웃 파일에서 `viewModel` 의 앱 데이터에 액세스하도록 속성을 추가함. 코드에서 레이아웃 변수를 초기화함

      1. `game_fragment.xml` 의 `<data>` 태그 내에 `<variable>` 이라는 하위 태그를 추가하고 `GameViewModel` 유형의 `gameViewModel` 이라는 속성을 선언함. 이 속성을 사용하여 `ViewModel` 의 데이터를 레이아웃에 결합할 수 있음

         ```xml
         <data>
            <variable
                name="gameViewModel"
                type="com.example.android.unscramble.ui.game.GameViewModel" />
         </data>
         ```

      2. `gameViewModel` 선언 아래에서 `<data>` 태그 내부에 `Integer` 유형의 다른 변수를 추가하고 이 변수의 이름을 `maxNoOfWords` 로 지정. 이 변수는 ViewModel의 변수에 바인딩하여 게임별 단어 수를 저장하는 데 사용함

         ```xml
         <data>
            ...
            <variable
                name="maxNoOfWords"
                type="int" />
         </data>
         ```

      3. `GameFragment` 의 `onViewCreated()` 메서드 시작 부분에서 레이아웃 변수 `gameViewModel` 및 `maxNoOfWords` 를 초기화

         ```kotlin
         override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
         
            binding.gameViewModel = viewModel
         
            binding.maxNoOfWords = MAX_NO_OF_WORDS
         ...
         }
         ```

      4. `LiveData` 는 수명 주기를 인식하며 식별 가능함. 따라서 레이아웃에 LifecycleOwner를 전달해야 함. `GameFragment` 의 `onViewCreated()` 메서드 내에서 결합 변수 초기화 아래에 다음 코드를 추가

         ```kotlin
         binding.lifecycleOwner = viewLifecycleOwner
         ```

         `LiveData` 관찰자를 구현할 때 유사한 기능을 구현하였음. `viewLifecycleOwner` 를 매개변수 중 하나로 `LiveData` 관찰자에 전달

  * **결합 표현식 사용하기**

    * 결합 표현식은 레이아웃 내에서 레이아웃 속성을 참조하는 속성(attribute properties)(예: `android:text`) 에서 작성됨. 레이아웃 속성은 `<variable>` 태그를 통해 데이터 바인딩 레이아웃 파일의 상단에서 선언됨. 종속 변수 중 하나라도 변경되면 `DB 라이브러리` 가 결합 표현식을 실행하고 이에 따라 뷰를 업데이트함. 이러한 변경 감지는 데이터 바인딩 라이브러리를 사용할 때 무료로 제공되는 훌륭한 최적화 기능

    * **결합 표현식의 구문**

      * 결합 표현식은 `@` 로 시작하고 중괄호 `{}` 로 래핑됨. 다음 예에서 `TextView` 텍스트는 `user` 변수의 `firstName` 속성으로 설정됨

        ```xml
        <TextView android:layout_width="wrap_content"
                  android:layout_height="wrap_content"
                  android:text="@{user.firstName}" />
        ```

        1. **현재 단어에 결합 표현식 추가하기**

           1. `game_fragment.xml` 에서 `text` 속성을 `textView_unscrambled_word` 텍스트 뷰에 추가. 새 레이아웃 변수 `gameViewModel` 을 사용하고 `text` 속성에 `@{gameViewModel.currentScrambledWord}` 를 할당

              ```xml
              <TextView
                 android:id="@+id/textView_unscrambled_word"
                 ...
                 android:text="@{gameViewModel.currentScrambledWord}"
                 .../>
              ```

           2. `GameFragment` 에서 `currentScrambledWord` 의 `LiveData` 관찰자 코드를 삭제. 프래그먼트에 더 이상 관찰자 코드가 필요하지 않음. `LiveData` 변경사항 업데이트가 레이아웃에 직접 수신되므로 다음을 삭제

              ```kotlin
              viewModel.currentScrambledWord.observe(viewLifecycleOwner,
                 { newWord ->
                     binding.textViewUnscrambledWord.text = newWord
                 })
              ```

           3. 앱을 실행하면 앱이 전과 동일하게 작동하며 글자가 뒤섞인 단어 텍스트 뷰는 `LiveData` 관찰자가 아닌 결합 표현식을 사용하여 UI를 업데이트하게 됨

        2. **점수 및 단어 수에 결합 표현식 추가하기**

           데이터 결합 표현식은 다음 구문을 사용하여 앱 리소스를 참조할 수 있음

           ```xml
           android:paddin="@{@dimen/largePadding}"
           ```

           위의 예에서는 `padding` 속성에 `dimen.xml` 리소스 파일의 `largePadding` 값이 할당됨

           레이아웃 속성을 리소스 매개변수로 전달할 수도 있음

           ```xml
           android:text="@{@string/example_resource(user.lastName)}"
           ```

           `strings.xml`

           ```xml
           <string name="example_resource">Last Name: %s</string>
           ```

           위의 예에서 `example_resource` 는 `%s` 자리표시자가 있는 문자열 리소스임. `user.lastName` 을 결합 표현식의 리소스 매개변수로 전달함. 여기서 `user` 는 레이아웃 변수임

           이 단계에서는 점수 및 단어 수 텍스트 뷰에 결합 표현식을 추가하고 리소스 매개변수를 전달함. 이 단계는 위의 `textView_unscrambled_word` 에 실행한 과정과 유사함

           1. `game_fragment.xml` 에서 다음 결합 표현식을 사용하여 `word_count` 텍스트 뷰의 `text` 속성을 업데이트함. `word_count` 문자열 리소스를 사용하고 `gameViewModel.currentWordCount` 및 `maxNoOfWords` 를 리소스 매개변수로 전달함

              ```xml
              <TextView
                 android:id="@+id/word_count"
                 ...
                 android:text="@{@string/word_count(gameViewModel.currentWordCount, maxNoOfWords)}"
                 .../>
              ```

           2. 다음 결합 표현식을 사용하여 `score` 텍스트 뷰의 `text` 속성을 업데이트함. `score` 문자열 리소스를 사용하고 `gameViewModel.score` 를 리소스 매개변수로 전달함

              ```xml
              <TextView
                 android:id="@+id/score"
                 ...
                 android:text="@{@string/score(gameViewModel.score)}"
                 ... />
              ```

           3. `GameFragment` 에서 `LiveData` 관찰자를 삭제. 상응하는 `LiveData` 가 변경되면 결합 표현식이 UI를 업데이트하므로 이 관찰자는 더 이상 필요하지 않으므로 다음을 삭제

              ```kotlin
              viewModel.score.observe(viewLifecycleOwner,
                 { newScore ->
                     binding.score.text = getString(R.string.score, newScore)
                 })
              
              viewModel.currentWordCount.observe(viewLifecycleOwner,
                 { newWordCount ->
                     binding.wordCount.text =
                         getString(R.string.word_count, newWordCount, MAX_NO_OF_WORDS)
                 })
              
              ```

           4. 앱을 실행해보면 이제 코드는 `LiveData` 와 결합 표현식을 사용하여 UI를 업데이트함



#### Quiz

1. **Which of the following are reasons to use a ViewModel?**
   * ViewModel 및 관련 데이터는 액티비티/프래그먼트의 변경사항을 유지할 수 있음
   * ViewModel을 사용하면 UI 또는 수명 주기에 의존하지 않아도 되는 코드에서 UI를 업데이트하는 코드를 분리할 수 있음
2. **A ViewModel is destroyed after which of the following ?**
   * OnDestroy 후(컴포넌트 변경이 아닌 경우)
3. **True or False: You should execute time-consuming tasks and I/O requests in your Activity/Fragment.**
   * False
4. **Why should you initialize and store LiveData in your ViewModel instead of a UI Controller?**
   * ViewModel과 LiveData가 모두 수명 주기를 인식하므로
   * UI 컨트롤러가 소멸될 때 LiveData가 소멸되지 않도록 하기 위해
   * 구현 세부정보를 숨기거나 분리하여 앱의 유연성을 향상하기 위해
5. **`observe` allows you to do which of the following for changes?**
   * LiveData 객체
6. **True or False: It’s OK for a ViewModel to directly reference a `View` or `LifecycleOwner` class.**
   * False