# 🔥 Unit 3 : Navigation

## Pathway 3 : Architecture components

## 🎖 ViewModel에 데이터 저장하기

+ 현재 스타터 앱의 문제

  + 기기 방향이 변경되는 경우와 같이 **구성이 변경되는 동안 앱 상태와 데이터를 저장하고 복원하지 않는다.** 이러한 문제는 `onSaveInstanceState()` 콜백을 사용하여 해결할 수 있습니다. 하지만 `onSaveInstanceState()` 메서드를 사용하려면 번들에 상태를 저장하는 추가 코드를 작성하고 이 상태를 검색하는 로직을 구현해야 한다, 또 번들에 저장할 수 있는 데이터의 양도 적다. 

    => 따라서, **Android Architecture Components**를 사용하여 이러한 문제를 해결한다. 

    아키텍쳐 구성요소를 사용하여 권장 앱 아키텍쳐를 구현 

  > 앱의 상태와 데이터를 저장하고 복원해야 하는 경우 
  >
  > => 로그인 시 아이디, 비밀번호 데이터 저장, 게임 등의 앱 진행 시 현재 점수를 저장

<br></br>

<br></br>

### App Architecture

+ 아키텍쳐는 앱에서 **클래스 간의 책임을 할당**하는 가이드라인을 제공한다. 앱 아키텍쳐가 잘 디자인되어 있으면 향후 앱을 확장하고 더 많은 기능을 포함할 수 있습니다. 또한 팀 공동작업도 더 간편합니다. 

  + 가장 일반적인 아키텍쳐 원칙 : **Seperation of concerns, Drive UI from a model**

    + Seperation of concerns : 각각 별개의 책임이 있는 여러 클래스로 앱을 나누는 것

    + Drive UI from a model : 모델로부터 UI를 만들어야 한다는 것. 가급적 **지속적인 모델**을 권장한다.**모델은 앱의 데이터 처리를 담당하는 구성요소**로, 앱의 `Views` 객체 및 앱 구성요소와 독립되어 있으므로 앱의 수명 주기 및 관련 문제의 영향을 받지 않습니다. 

      (그러니까 model이란, 앱을 UI를 우선 생각하지 않고, 기능별로 나눈 것?)

+ Android architecture의 기본 클래스 또는 구성요소는 **UI controller,`Viewmodel`, `LiveData`, `Room`** 입니다. 이러한 구성요소는 **수명 주기의 복잡성을 어느 정도 처리**하므로 수명 주기 관련 문제를 피하는데 도움이 된다. 

  <img src = "https://user-images.githubusercontent.com/31370590/127764913-dc0f30c2-bb62-42e0-8b9b-b8dd0d281141.PNG">

  + UI Controller(activity/fragment)

    **Activity**와 **Fragment**는 UI 컨트롤러입니다. UI 컨트롤러는 **화면에 뷰를 그리고 사용자 이벤트나 사용자가 상호작용하는 다른 모든 UI 관련 동작을 캡쳐하여 UI를 제어**합니다. 앱의 데이터 또한 데이터에 관한 모든 의사 결정 로직은 UI 컨트롤러 클래스에 포함되어서는 안됩니다. 

    Android 시스템은 특정 사용자 상호작용을 기반으로 또는 메모리 부족과 같은 시스템 조건으로 인해 언제든지 UI 컨트롤러를 제거할 수 있습니다. 이러한 이벤트는 개발자가 직접 제어할 수 없기 때문에, **UI 컨트롤러에 앱 데이터나 상태를 저장해서는 안 됩니다.** 대신 **데이터에 관한 의사 결정 로직을 `ViewModel`에 추가해야 합니다.**

    예를 들어 **Unscramble** 앱에서 글자가 뒤섞인 단어, 점수, 단어 수는 프래그먼트(UI 컨트롤러)에 표시됩니다. 글자가 뒤섞인 다음 단어를 고르고 점수와 단어 수를 계산하는 등의 의사 결정 코드는 `ViewModel`에 포함해야 합니다.

    <br></br><br></br>

  + View model

    `ViewModel`은 **뷰에 표시되는 앱 데이터의 모델**입니다. 모델은 **앱의 데이터 처리를 담당**하는 구성요소로, 아키텍쳐 원칙에 따라 모델에서 UI가 도출되는 앱을 만들 수 있습니다. 

    `ViewModel`은 Andriod 프레임워크에서 활동이나 프래그먼트가 소멸되고 다시 생성될 때 폐기되지 않는 앱 관련 데이터를 저장합니다. `ViewModel` 객체는 **구성이 변경되는 동안 자동으로 유지**되어(활동 또는 프래그먼트 인스턴스처럼 소멸되지 않음) 보유하고 있는 데이터가 다음 활동 또는 프래그먼트 인스턴스에 즉시 사용될 수 있습니다.

    <br></br>

    <br></br>

  + 요약

    Activity/Fragment의 책임 : 뷰와 데이터를 화면에 그리고 사용자 이벤트에 응답합니다.

    ViewModel의 책임 : UI에 필요한 모든 데이터를 보유하고 처리합니다. 뷰 계층 구조(ex) 뷰 결합 객체)에 액세스하거나 활동 또는 프래그먼트의 참조를 보유해서는 안 됩니다. 
    
    <br></br>
    
    <br></br>
    
    <br></br>

### ViewModel 추가하기

+ 이 작업에서는 앱 데이터(글자가 뒤섰인 단어, 단어 수, 점수)를 저장하는 `ViewModel`을 앱에 추가합니다. 
+ 앱의 아키텍쳐는 `MainActivity` => `GameFragment` => `GameViewModel`로 구성되어 있다.

<br></br>

<br></br>

###### 1. `GameViewModel` class 추가하기

```kotlin
class GameViewModel : ViewModel() {
}
```

<br></br><br></br>

###### 2.  `ViewModel`을 프래그먼트에 연결하기

+ `ViewModel`을 UI 컨트롤러(Activity/Fragment)에 연결하려면 UI 컨트롤러 내에 `ViewModel`에 관한 참조(객체)를 만듭니다.

  ```kotlin
  private val viewModel: GameViewModel by viewModels()
  ```

  <br></br><br></br>

+ `GameFragment` 클래스 상단에 `GameViewModel` 유형의 속성을 추가하고, `by viewModels()` **Kotlin 속성 위임**을 사용하여 `GameViewModel`을 초기화

  <br></br><br></br>

+ Kotlin property delegate

  + 코틀린에는 각 변경 가능한(`var`)  속성에 자동으로 생성된 기본 getter함수와 setter함수가 있습니다. 하지만 읽기 전용(`val`)의 경우 기본적으로 getter함수만 생성됩니다. 

  + 코틀린에서 속성 위임을 사용하면 getter-setter 책임을 다른 클래스에 넘길 수 있습니다. 이 클래스(calleed **delegate class**)는 속성의 getter 및 setter 함수를 제공하고 변경사항을 처리합니다. 

  + delegate property는 다음과 같이 `by` 절 및 대리자 클래스 인스턴스를 사용하여 정의됩니다.

    ```kotlin
    // Syntax for property delegation
    var <property-name> : <property-type> by <delegate-class>()
    ```

  <br></br><br></br>

+ 앱에서 다음과 같이 기본 `GameViewModel()`생성자를 사용하여 뷰 모델을 초기화 하는 경우

  ```kotlin
  private val viewModel = GameViewModel()
  ```

  + 기기에서 구성이 변경되는 동안 앱이 `ViewModel` 참조의 상태를 손실하게 됩니다. 예를 들어 기기를 회전하면 활동이 소멸된 후 다시 생성되고 초기 상태의 새로운 뷰 모델 인스턴스가 다시 시작됩니다. 

  <br></br><br></br>

+ 대신 속성 위임 접근 방식을 사용해 ** `viewModel` 객체의 책임을 `viewModels`라는 별도의 클래스에 위임**합니다. 즉, `viewmodel` 객체에 액세스하면 이 객체는 대리자 클래스 `viewModels`에 의해 내부적으로 처리됩니다. 

  대리자 클래스는 첫 번째 액세스 시 자동으로 `viewModel` 객체를 만들고 이 값으로 구성 변경 중에도 유지했다가 요청이 있을 때 반환합니다.  

  <br></br><br></br>

  <br></br>

### ViewModel로 데이터 이동하기

+ 앱의 UI 데이터를 UI 컨트롤러에서 분리하면 위에서 설명한 단일 책임 원칙을 더 잘 준수할 수 있습니다.  액티비티와 프래그먼트는 화면에 뷰와 데이터를 그리고, `ViewModel`은 UI에 필요한 모든 데이터를 보유하고 처리합니다. 

  <br></br><br></br>

+ `GameFragment` 클래스에서 `GameViewModel` 클래스로 데이터 변수를 이동한다.

```kotlin
class GameViewModel : ViewModel() {

    private var score = 0
    private var currentWordCount = 0
    private var currentScrambledWord = "test"
}
```

+ `ViewModel`에서는 데이터를 수정할 수 있어야 하므로 데이터는 `private` 및 `var` 이어야 합니다. `ViewModel` 외부에서는 데이터를 읽을 수 있지만 수정할 수는 없어야 하므로 데이터는 `public` 및 `val`로 노출되어야 합니다. 이를 위해 지원 속성이라는 기능이 있다.

  <br></br><br></br>

+ 지원 속성

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

  + `count` 변수가 접근될 때, `_count` 값을 반환하는 `get()` 함수가 호출된다. 

  + `ViewModel` 클래스 내부:
    - `_count` 속성이 `private`이며 변경 가능합니다. 따라서 `ViewModel` 클래스 내에서만 액세스하고 수정할 수 있습니다. 이름 지정 규칙은 `private` 속성 앞에 밑줄을 붙이는 것입니다.
  + `ViewModel` 클래스 외부:
    - Kotlin의 기본 공개 상태 한정자는 `public`이므로, `count`는 공개 속성이며 UI 컨트롤러와 같은 다른 클래스에서 액세스할 수 있습니다. `get()` 메서드만 재정의되므로, 이 속성은 변경할 수 없으며 읽기 전용입니다. 외부 클래스가 이 속성에 액세스하면 `_count`의 값을 반환하며, 이 값은 수정할 수 없습니다. 이에 따라 `ViewModel`에 있는 앱 데이터가 외부 클래스로 인해 원치 않게, 안전하지 않게 변경되지 않도록 보호되지만 외부 호출자는 값에 안전하게 액세스할 수 있습니다.

<br></br><br></br>

+ `currentScrambleWord`에 지원 속성 추가

  ```kotlin
  private var _currentScrambledWord = "test"
  val currentScrambledWord: String
     get() = _currentScrambledWord
  ```

<br></br><br></br><br></br>

###  ViewModel 수명 주기 이해

+ ViewModel 수명 주기

  <img src = "https://user-images.githubusercontent.com/31370590/127839122-386439ab-9f5d-4097-9ebd-e395d9314cc7.PNG" width = "700" height = "500">

   프레임워크는 활동이나 프래그먼트의 범위가 유지되는 동안 `ViewModel`을 유지합니다. `ViewModel`은 소유자가 화면 회전과 같은 구성 변경으로 인해 소멸되는 경우에도 소멸되지 않습니다. 소유자의 새 인스턴스는 다음 다이어그램과 같이 기존 `ViewModel` 인스턴스에 다시 연결됩니다.

  <br></br><br></br>

+ `GameViewModel.kt`에서 로그 구문이 포함된 `init` 블록 추가

  ```kotlin
  class GameViewModel : ViewModel() {
     init {
         Log.d("GameFragment", "GameViewModel created!")
     }
  }
  ```

  `init`블록은 객체 인스턴스가 처음 생성되어 초기화 될 때 실행됩니다.  

+ `GameViewModel` 클래스에서`OnCleared()` 메서드를 재정의

  ```
  override fun onCleared() {
      super.onCleared()
      Log.d("GameFragment", "GameViewModel destroyed!")
  }
  ```

  `ViewModel`은 연결된 프래그먼트가 분리되거나 활동이 완료되면 소멸됩니다. `ViewModel`이 소멸되기 직전에 `onCleared()` 콜백이 호출됩니다.

+ `GameFragment`에 로그 구문 추가, `onDetach()` 콜백 메서드 재정의

  ```kotlin
  override fun onCreateView(
     inflater: LayoutInflater, container: ViewGroup?,
     savedInstanceState: Bundle?
  ): View {
     binding = GameFragmentBinding.inflate(inflater, container, false)
     Log.d("GameFragment", "GameFragment created/re-created!")
     return binding.root
  }
  
  override fun onDetach() {
      super.onDetach()
      Log.d("GameFragment", "GameFragment destroyed!")
  }
  ```

=> 결과 : 기기나 에뮬레이터에서 자동 회전 설정을 켜고 화면 방향을 몇 번 바꿉니다. `GameFragment`는 매번 소멸되고 다시 생성되지만 `GameViewModel`은 한 번만 생성되며 매번 호출별로 다시 생성되거나 소멸되지 않습니다.

<br></br><br></br><br></br>

###  ViewModel 채우기

+ 다음 단어 가져오기

  ```kotlin
  /*
  * Updates currentWord and currentScrambledWord with the next word.
  */
  private fun getNextWord() {
     currentWord = allWordsList.random()
     val tempWord = currentWord.toCharArray()
     tempWord.shuffle()
  
     while (tempWord.toString().equals(currentWord, false)) {
         tempWord.shuffle()
     }
     if (wordsList.contains(currentWord)) {
         getNextWord()
     } else {
         _currentScrambledWord = String(tempWord)
         ++currentWordCount
         wordsList.add(currentWord)
     }
  }
  ```

<br></br><br></br>

+ `nextWord()` 메서드 추가

  ```kotlin
  /*
  * Returns true if the current word count is less than MAX_NO_OF_WORDS.
  * Updates the next word.
  */
  fun nextWord(): Boolean {
      return if (currentWordCount < MAX_NO_OF_WORDS) {
          getNextWord()
          true
      } else false
  }
  ```

  목록에서 다음 단어를 가져오고 단어 수가 `MAX_NO_OF_WORDS`보다 적으면 `true`를 반환합니다.

<br></br><br></br>

### 대화상자

+ 알림 대화상자 구성
  1. 알림 대화상자
  2. 제목(선택사항)
  3. 메시지
  4. 텍스트 버튼

<br></br><br></br>최종 점수 대화상자 구현

+ 머티리얼 디자인 구성요소 라이브러리의 `MaterialAlertDialog`를 사용하여 머티리얼 가이드라인을 따르는 대화상자를 앱에 추가합니다. 대화상자는 UI와 관련이 있으므로, `GameFragment`가 최종 점수 대화상자 생성과 표시를 담당합니다.

  ```kotlin
  /*
  * Creates and shows an AlertDialog with the final score.
  */
  private fun showFinalScoreDialog() {
     MaterialAlertDialogBuilder(requireContext())
         .setTitle(getString(R.string.congratulations))
         .setMessage(getString(R.string.you_scored, viewModel.score)) // 읽기 전용 버전
         .setCancelable(false) // 뒤로 키를 눌러 알림 대화상자를 취소할 수 없도록
         .setNegativeButton(getString(R.string.exit)) { _, _ ->
             exitGame()
         }
         .setPositiveButton(getString(R.string.play_again)) { _, _ ->
             restartGame()
         }
         .show()
  }
  ```

  + `MaterialAlertDialog`를 만들려면 `MaterialAlertDialogBuilder` 클래스를 사용하여 대화상자의 부분을 단계별로 빌드합니다. 프래그먼트의 `requireContext()`메서드를 사용하여 콘텐츠를 전달하는 `MaterialAlertDialogBuilder`생성자를 호출합니다. `requireContext()` 메서드는 null이 아닌 `Context`를 반환합니다.

    > `Context`는 이름에서 알 수 있듯이 애플리케이션, 액티비티, 프래그먼트의 컨텍스트나 현재 상태를 의미합니다. 액티비티, 프래그먼트, 애플리케이션과 관련된 정보를 포함하고 있으며 일반적으로 리소스, 데이터베이스, 기타 시스템 서비스에 액세스하는 데 사용됩니다. 이 단계에서는 프래그먼트 컨텍스트를 전달하여 알림 대화상자를 만듭니다.

  + `setNegativeButton()` 메서드와 `setPositiveButton()` 메서드를 사용하여 **EXIT** 및 **PLAY AGAIN**의 두 텍스트 버튼을 추가합니다. 람다에서 각각 `exitGame()`과 `restartGame()`을 호출합니다.

    ```kotlin
    .setNegativeButton(getString(R.string.exit)) { _, _ ->
        exitGame()
    }
    
    .setPositiveButton(getString(R.string.play_again)) { _, _ ->
        restartGame()
    }
    ```

    이 구문은 

    `setNegativeButton(getString(R.string.exit), { _, _ -> exitGame()})`의 약식 표현입니다.

    여기서 `setNegativeButton()` 메서드는 두 매개변수, 

    즉 ** `String`**과 함수 ** `DialogInterface.OnClickListener()`**(람다로 표현 가능)를 사용합니다. **전달되는 마지막 인수가 함수이면 괄호 *바깥에*  람다 표현식을 배치**할 수 있습니다. 이를 *후행 람다 구문*이라고 합니다. 람다를 괄호 안에 배치하거나 바깥에 배치하여 코드를 작성하는 방법이 모두 허용됩니다. `setPositiveButton` 함수의 경우도 마찬가지입니다.

<br></br><br></br><br></br>

## 🎖 ViewModel과 함께 LiveData 사용하기

### Livedata란?

+ LiveData란 **수명 주기를 인식**하는 **식별 가능한 데이터 홀드 클래스**입니다. 

  LiveData의 특성

  + `LiveData`는 **데이터를 보유**합니다. `LiveData`는 모든 유형의 데이터에 사용할 수 있는 wrapper입니다.
  
  + `LiveData`는 **식별 가능**합니다. 즉, ** `LiveData` 객체에서 보유한 데이터가 변경되면 관찰자에 알림이 제공**됩니다.
  
  + `LiveData`는 **수명 주기를 인식**합니다. `LiveData`에 **관찰자를 연결**하면 관찰자는 `LifecycleOwner` (일반적으로 활동 또는 프래그먼트)와 연결됩니다. `LiveData`는 `STARTED` 또는 `RESUMED` 같은 활성 수명 주기 상태인 관찰자만 업데이트합니다. 
  
    <br></br><br></br><br></br>

### LiveData 추가하기

```kotlin
private val _currentScrambledWord = MutableLiveData<String>()
```

+ `MutableLiveData`는 변경 가능한 버전의 `LiveData`입니다. 즉, **내부에 저장된 데이터의 값을 변경할 수 있습니다.**
+ `LiveData`/`MutableLiveData` **객체의 값은 동일하게 유지**되고 이 **객체에 저장된 데이터만 변경되기 때문**에 `_currentScrambledWord`의 변수 유형을 `val`로 변경합니다.

<br></br><br></br>

```kotlin
val currentScrambledWord: LiveData<String>
   get() = _currentScrambledWord
```

+ 지원 필드 `currentScrambleWord`를 변경할 수 없기 때문에 그 유형을 `LiveData<String>`으로 변경합니다.

 <br></br><br></br>

```kotlin
private fun getNextWord() {
 
   } else {
       _currentScrambledWord.value = String(tempWord)
       ...
   }
}
```

+ `LiveData` 객체 내의 데이터에 액세스하려면 `value` 속성을 사용합니다.

<br></br><br></br><br></br>

### LiveData 객체에 관찰자 연결하기

```kotlin
// Observe the scrambledCharArray LiveData, passing in the LifecycleOwner and the observer.
viewModel.currentScrambledWord.observe(viewLifecycleOwner,
   { newWord ->
       binding.textViewUnscrambledWord.text = newWord
   })
```

+ `currentScrambledWord` `LiveData`의 관찰자를 연결합니다.  `GameFragment`의 ** `onViewCreated()` 콜백 끝에서** `currentScrambledWord`에 관해 `observe()`메서드를 호출합니다.
+ `viewLifecycleOwner`를 첫 번째 매개변수로 `observe()` 메서드에 전달합니다. ** `viewLifecycleOwner` 는 프래그먼트의 뷰 수명 주기를 나타냅니다.** 이 매개변수를 사용하면 ** `LiveData` 가 `GameFragment` 수명 주기를 인식하고 `GameFragment`가 활성 상태(`STARTED` 또는 `RESUMED`)일 때만 관찰자에 알릴 수 있습니다.**

+ `newWord`를 함수 매개변수로 사용하여 두 번째 매개변수로 람다를 추가합니다. `newWord`에는 글자가 뒤섞인 새 단어 값이 포함됩니다. 람다 표현식의 함수 본문에서 `newWord`를 글자가 뒤섞인 단어 텍스트 뷰에 할당합니다.

<br></br><br></br><br></br>

### 데이터 결합과 함께 LiveData 사용하기

이전 작업에서는 앱이 코드의 데이터 변경사항을 수신합니다. 마찬가지로, 앱은 **레이아웃에서 데이터 변경사항을 수신할 수 있습니다.** 데이터 결합을 사용하면 **식별 가능한 `LiveData` 값이 변경될 때 바인딩된 레이아웃의 UI 요소에도 알림이 전송되며 레이아웃 내에서 UI를 업데이트할 수 있습니다.**

<br></br><br></br>

#### view binding 복습 

+ 이전에는 단방향 결합인  뷰 결합을 확인했습니다. **뷰를 코드에 바인딩**할 수 있지만 코드를 뷰에 바인딩할 수는 없습니다. 

+ 뷰 결합은 코드에서 뷰에 더 쉽게 액세스할 수 있는 기능으로, 각 XML 레이아웃 파일의 결합 클래스를 생성합니다. 결합 클래스의 인스턴스에는 상응하는 레이아웃에 ID가 있는 모든 뷰의 직접 참조가 포함됩니다. 예를 들어 Unscramble 앱은 현재 뷰 결합을 사용하므로 생성된 결합 클래스를 사용하여 코드에서 뷰를 참조할 수 있습니다.

  ```
  binding.textViewUnscrambledWord.text = newWord
  binding.score.text = getString(R.string.score, newScore)
  binding.wordCount.text =
                    getString(R.string.word_count, newWordCount, MAX_NO_OF_WORDS)
  ```

+ 뷰 결합을 사용하면 **뷰(레이아웃 파일)에서 앱 데이터를 참조할 수 없습니다.** 이 작업은 **데이터 결합**을 사용하면 됩니다.

<br></br><br></br>

#### Data binding 결합

+ 간단히 말해서 데이터 결합은 

  **binding data (from code) to views** + **view binding (binding views to code)**이다. 

  => 데이터를 뷰에 바인딩(레이아웃 파일에서 앱 데이터를 참조할 수 있도록) + 뷰를 코드에 바인딩

  <br></br><br></br>

  + UI 컨트롤러에서 뷰 결합 사용의 예

    ```kotlin
    binding.textViewUnscrambledWord.text = viewModel.currentScrambledWord
    ```

  + 레이아웃 파일에서 데이터 결합 사용의 예

    ```kotlin
    android:text="@{gameViewModel.currentScrambledWord}"
    ```

  => 위의 예에서는 데이터 결합 라이브러리를 사용하여 레이아웃 파일에서 뷰/위젯에 직접 앱 데이터를 할당하는 방법을 보여줍니다. 할당 표현식에 사용되는 `@{}` 구문에 유의하세요. 데이터 결합을 사용할 때 주요 이점은 활동에서 많은 UI 프레임워크 호출을 삭제할 수 있어 파일이 더욱 단순해지고 더 손쉬운 유지관리가 가능하다는 점입니다. 또한 앱 성능이 향상되며 메모리 누수 및 null 포인터 예외를 방지할 수 있습니다.

<br></br><br></br>

#### 1. 뷰 결합을 데이터 결합으로 변경하기

`build.gradle(Module)`

```kotlin
buildFeatures {
   dataBinding = true
}
 ...
plugins {
   id 'com.android.application'
   id 'kotlin-android'
   id 'kotlin-kapt'
}
```

위의 단계는 앱의 모든 레이아웃 XML 파일용 결합 클래스를 자동으로 생성합니다. 레이아웃 파일 이름이 `activity_main.xml`인 경우 자동 생성 클래스의 이름은 `ActivityMainBinding`이 됩니다.

<br></br><br></br>

#### 2. 레이아웃 파일을 데이터 결합 레이아웃으로 변환하기

**데이터 결합 레이아웃** 파일은 약간 차이가 있으며 `<layout>`의 루트 태그로 시작하고 선택적 `<data>` 요소 및 `view` 루트 요소가 뒤따릅니다. 이 view 요소는 루트가 결합 레이아웃 파일이 아닌 파일에 있는 요소입니다.

1. `game_frament.xml`을 열고 **code** 탭을 선택합니다.

2. 레이아웃을 데이터 결합 레이아웃으로 변환하려면 

   ```kotlin
   <layout xmlns:android="http://schemas.android.com/apk/res/android"
      xmlns:app="http://schemas.android.com/apk/res-auto"
      xmlns:tools="http://schemas.android.com/tools">
   
      <data>
   
      </data>
   
      <ScrollView
          android:layout_width="match_parent"
          android:layout_height="match_parent">
   
          <androidx.constraintlayout.widget.ConstraintLayout
            ...
          </androidx.constraintlayout.widget.ConstraintLayout>
      </ScrollView>
   </layout>
   ```

   + **루트 요소를 `<layout>` 태그로 wrapping**
   + **네임스페이스 정의(`xmlns:`로 시작하는 속성)를 새 루트 요소로 이동**
   + 루트 요소 위에z 있는 `<layout>` 태그 내부에 **`<data></data>` 태그를 추가**합니다.**

   => 이 과정은 Android 스튜디오에서는 루트 요소(`ScrollView`)를 마우스 오른쪽 버튼으로 클릭하고 **Show Context Actions** > **Convert to data binding layout**을 선택하면 자동으로 간편하게 추가할 수 있습니다.

3. `GameFragment`의 `onCreateView()` 메서드 시작 부분에서 데이터 결합을 사용하도록 `binding` 변수의 인스턴스화를 변경합니다. 

   ````kotlin
   // 기존 코드
   binding = DataBindingUtil.inflate(inflater, R.layout.game_fragment, container, false)
   
   // data binding 사용
   binding = DataBindingUtil.inflate(inflater, R.layout.game_fragment, container, false)
   ````

<br></br><br></br><br></br>

### 데이터 결합 변수 추가하기

+ 레이아웃 파일에서 `viewModel`의 앱 데이터에 액세스하도록 속성을 추가합니다. 코드에서 레이아웃 변수를 초기화합니다.

1. `game_frament.xml`의 `<data>` 태그와 `<variable>`이라는 하위 태그 내에서 `GameViewModel` 유형의 `gameViewModel`이라는 속성을 선언합니다. **이 속성을 사용하여 `ViewModel`의 데이터를 레이아웃에 결합**할 수 있습니다.

   ```kotlin
   <data>
      <variable
          name="gameViewModel"
          type="com.example.android.unscramble.ui.game.GameViewModel" />
   </data>
   ```

   <br></br><br></br>

2. `gameViewModel` 선언 아래에서 `<data>` 태그 내부에 ** `Integer` 유형의 다른 변수를 추가**하고 이 변수의 이름을 `maxNoOfWords`로 지정합니다. 이 변수는 **ViewModel의 변수에 바인딩하여 게임별 단어 수를 저장**하는 데 사용합니다.

   ```kotlin
   <data>
      ...
      <variable
          name="maxNoOfWords"
          type="int" />
   </data>
   ```

   <br></br><br></br>

3. `GameFragment`의 `onViewCreated()` 메서드 시작 부분에서 레이아웃 변수 `gameViewModel` 및 `maxNoOfWords`를 **초기화**합니다.

   ```kotlin
   override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
      super.onViewCreated(view, savedInstanceState)
   
      binding.gameViewModel = viewModel
   
      binding.maxNoOfWords = MAX_NO_OF_WORDS
   ...
   }
   ```

   <br></br><br></br>

4. `LiveData`는 수명 주기를 인식하며 식별 가능합니다. 따라서 레이아웃에 **수명 주기 소유자**를 전달해야 합니다. `GameFragment`의 `onViewCreated()` 메서드 내에서 결합 변수 초기화 아래에 다음 코드를 추가합니다.

   ```kotlin
   // Specify the fragment view as the lifecycle owner of the binding.
   // This is used so that the binding can observe LiveData updates
   binding.lifecycleOwner = viewLifecycleOwner
   ```

   <br></br><br></br><br></br>

### 결합 표현식 사용하기 

결합 표현식은 레이아웃 내에서 레이아웃 속성을 차조하는 속성(`andriod:text`)에서 작성됩니다. 레이아웃 속성은 `<variable>` 태그를 통해 데이터 결합 레이아웃 파일의 상단에서 선언됩니다. 종속 변수 중 하나라도 변경되면 'DB 라이브러리'가 결합 표현식을 실행하고 이에 따라 뷰를 업데이트합니다.

<br></br><br></br>

+ 결합 표현식의 구문

  결합 표현식은 `@` 기호로 시작하고 중괄호 `{}`로 래핑됩니다. 다음 예에서 `TextView` 텍스트는 `user` 변수의 `firstName` 속성으로 설정됩니다.

  ex)

  ```
  <TextView android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="@{user.firstName}" />
  ```

<br></br><br></br>

1. 현재 단어에 결합 표현식 추가하기

   이 단계에서는 현재 단어 텍스트 뷰를 `ViewModel`의 `LiveData` 객체에 바인딩합니다. (뷰를 data에 바인딩)

   + `game_fragment.xml`에서 `text` 속성을 `textView_unscrambled_word` 텍스트 뷰에 추가합니다. 새 레이아웃 변수 `gameViewModel`을 사용하고 `text` 속성에 `@{gameViewModel.currentScrambledWord}`를 할당합니다. 

     ```kotlin
     <TextView
        android:id="@+id/textView_unscrambled_word"
        ...
        android:text="@{gameViewModel.currentScrambledWord}"
        .../>
     ```

   + 이제 `LiveData` 변경사항 업데이트가 레이아웃에 직접 수신되므로 프래그먼트에 더이상 관찰자 코드가 필요하지 않습니다. 따라서  `GameFragment`에서 `currentScrambledWord`의 `LiveData` 관찰자 코드를 삭제합니다. 

     ```kotlin
     viewModel.currentScrambledWord.observe(viewLifecycleOwner,
        { newWord ->
            binding.textViewUnscrambledWord.text = newWord
        })
     ```

   앱을 실행하면 전과 동일하게 작동하지만, 이제 텍스트 뷰는 `LiveData` 관찰자가 아닌 **결합 표현식을 사용하여 UI를 업데이트**합니다. 

<br></br><br></br>

2. 점수 및 단어 수에 결합 표현식 추가하기

   + `game_fragment.xml`에서 다음 결합 표현식을 사용하여 `word_count` 텍스트 뷰의 `text` 속성을 업데이트합니다. `word_count` 문자열 리소스를 사용하고 `gameViewModel.currentWordCount` 및 `maxNoOfWords`를 리소스 매개변수로 전달합니다.

     ```kotlin
     <TextView
        android:id="@+id/word_count"
        ...
        android:text="@{@string/word_count(gameViewModel.currentWordCount, maxNoOfWords)}"  // getString을 사용해야 하지 않나 
        .../>
     ```

   + 다음 결합 표현식을 사용하여 `score` 텍스트 뷰의 `text` 속성을 업데이트합니다. `score` 문자열 리소스를 사용하고 `gameViewModel.score`를 리소스 매개변수로 전달합니다.

     ```kotlin
     <TextView
        android:id="@+id/score"
        ...
        android:text="@{@string/score(gameViewModel.score)}"
        ... />
     ```

   + `GameFragment`에서 `LiveData` 관찰자를 삭제합니다. 상응하는 `LiveData`가 변경되면 결합 표현식이 UI를 업데이트하므로 이 관찰자는 더 이상 필요하지 않습니다.

     => 데이터 바인딩 사용하면 LiveData 관찰자 필요 ㄴ

<br></br><br></br>

<br></br><br></br>



## 🎖 Quiz/Unit3/Pathway3

1. Which of the following are reasons to use a ViewModel?
   + A ViewModel and its data can survive orientation changes in an Activity/Fragment.
   + A ViewModel allows you to separate code that updates the UI from code that doesn’t need to rely on the UI or its lifecycle.

<br></br><br></br>

2. A ViewModel is destroyed after which of the following ?
   + after `onDestroy`, if it not a configuration change

<br></br><br></br>

3. True or False: You should execute time-consuming tasks and I/O requests in your Activity/Fragment.
   + False

<br></br><br></br>

4. Why should you initialize and store LiveData in your ViewModel instead of a UI Controller?
   + Both the ViewModel and LiveData are lifecycle aware.
   + To ensure that the LiveData isn’t destroyed when the UI Controller is destroyed.
   + To hide or separate implementation details making your app more flexible

<br></br><br></br>

5. `observe` allows you to do which of the following for changes?
   + a LiveData object

<br></br><br></br>

6. True or False: It’s OK for a ViewModel to directly reference a `View` or `LifecycleOwner` class.
   + False
