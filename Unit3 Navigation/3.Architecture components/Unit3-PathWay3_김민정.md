## 2021 Landvibe Summer Coding - Android

### 🔎 Android Basics In Kotlin

#### 📌 Unit3: Navigation

#### 📌 PathWay3: Architecture components

<hr>


##### 스타터 앱

: 단어 맞추기 게임

👉🏻 프래그먼트

- 글자가 뒤섞인 현재 단어(`currentScrambledWord`), 단어 수(`currentWordCount`), 점수(`score`)를 나타내는 변수가 정의됩니다.
- `game_fragment` 뷰에 액세스할 권한이 있는 결합 객체 인스턴스 `binding`이 정의됩니다.
- `onCreateView()` 함수는 결합 객체를 사용하여 `game_fragment` 레이아웃 XML을 확장합니다.
- `onViewCreated()` 함수는 버튼 클릭 리스너를 설정하고 UI를 업데이트합니다.
- `onSubmitWord()`는 **Submit** 버튼의 클릭 리스너입니다. 이 함수는 글자가 뒤섞인 다음 단어를 표시하고 텍스트 필드를 지우고 플레이어의 단어를 검증하지 않고 점수와 단어 수를 높입니다.
- `onSkipWord()`는 **Skip** 버튼의 클릭 리스너입니다. 이 함수는 점수를 제외하고 `onSubmitWord()`와 유사하게 UI를 업데이트합니다.
- `getNextScrambledWord()`는 단어 목록에서 임의의 단어를 선택하여 단어에 있는 글자를 섞는 도우미 함수입니다.
- `restartGame()` 함수와 `exitGame()` 함수는 각각 게임을 다시 시작하고 종료하는 데 사용됩니다. 이 함수를 나중에 사용하겠습니다.
- `resetTextField()`는 텍스트 필드의 내용을 지우고 오류 상태를 재설정합니다.
- `updateNextWordOnScreen()` 함수는 글자가 뒤섞인 새로운 단어를 표시합니다.



##### 아키텍처 원칙

1. 관심사 분리

   > 각각 별개의 책임이 있는 여러 클래스로 앱을 나누어야 한다는 원칙

2. 모델에서 UI 만들기

   > 모델은 앱의 데이터 처리를 담당하는 구성요소로, 앱의 `Views` 객체 및 앱 구성요소와 독립되어 있으므로 앱의 수명 주기 및 관련 문제의 영향을 받지 X

👉🏻 아키텍처 구성요소

1. UI 컨트롤러(활동,프래그먼트)

2. ViewModel

   | 프래그먼트/활동(UI 컨트롤러)의 책임                          | `ViewModel`의 책임                                           |
   | ------------------------------------------------------------ | ------------------------------------------------------------ |
   | 활동 및 프래그먼트는 뷰와 데이터를 화면에 그리고 사용자 이벤트에 응답 | `ViewModel`은 UI에 필요한 모든 데이터를 보유하고 처리! / 뷰 계층 구조(예: 뷰 결합 객체)에 액세스하거나 활동 또는 프래그먼트의 참조를 보유해서는 XX |

3. LiveData

4. Room

<img src="img/Unit3-Pathway3-1_minjeong.png">



##### ViewModel 추가하기

:  앱 데이터(글자가 뒤섞인 단어, 단어 수, 점수)를 저장하는 `ViewModel`을 앱에 추가

<img src="img/Unit3-Pathway3-2_minjeong.png" height="400">

##### ViewModel로 데이터 이동하기

> 활동과 프래그먼트는 화면에 뷰와 데이터를 그리고, `ViewModel`은 UI에 필요한 모든 데이터를 보유하고 처리

👉🏻 `GameFragment` 클래스에서 `GameViewModel` 클래스로 데이터 변수를 이동

1. 데이터 변수 `score`, `currentWordCount`, `currentScrambledWord`를 `GameViewModel` 클래스로 이동합니다.

   ```kotlin
   class GameViewModel : ViewModel() {
   
       private var score = 0
       private var currentWordCount = 0
       private var currentScrambledWord = "test"
   ...
   ```

2. 확인되지 않는 참조에 관한 오류가 표시됩니다. 이는 속성이 `ViewModel`에만 공개되며 UI 컨트롤러에서 액세스할 수 없기 때문입니다. 이 오류는 다음에 해결



##### ViewModel의 수명 주기

: 프레임워크는 활동이나 프래그먼트의 범위가 유지되는 동안 `ViewModel`을 유지함 /`ViewModel`은 소유자가 화면 회전과 같은 구성 변경으로 인해 소멸되는 경우에도 소멸되지 않음

<img src="img/Unit3-Pathway3-3_minjeong.png">



##### Livedata

: 수명 주기를 인식하는 식별 가능한 데이터 홀더 클래스

👉🏻 특성

- `LiveData`는 데이터를 보유. `LiveData`는 모든 유형의 데이터에 사용할 수 있는 래퍼!
- `LiveData`는 관찰 가능.  즉, `LiveData` 객체에서 보유한 데이터가 변경되면 관찰자에 알림이 제공
- `LiveData`는 수명 주기를 인식함.  `LiveData`에 관찰자를 연결하면 관찰자는 `LifecycleOwner`(활동 or 프래그먼트)와 연결됨.  `LiveData`는 `STARTED` 또는 `RESUMED`와 같은 활성 수명 주기 상태인 관찰자만 업데이트함



##### 데이터 결합과 함께 LiveData 사용하기

> 뷰를 코드에 바인딩할 수 있지만 코드를 뷰에 바인딩할 수는 없다!

1. 뷰 결합: 코드에서 뷰에 더 쉽게 액세스할 수 있는 기능 / 각 XML 레이아웃 파일의 결합 클래스를 생성

   🚨 뷰 결합을 사용하면 뷰(레이아웃 파일)에서 앱 데이터를 참조할 수 X 

   -> 이 작업은 데이터 결합을 사용

2. 데이터 결합: Jetpack 라이브버리의 일부 / 선언적 형식을 사용하여 레이아웃의 UI 구성요소를 앱의 데이터 소스에 바인딩. 즉, 코드에서 `데이터를 뷰 + 뷰 결합에 결합(뷰를 코드에 결합)`

   👍🏻 이점! 

   > 1. 활동에서 많은 UI 프레임워크 호출을 삭제할 수 있어, 파일이 더욱 단순해지고 더 손쉬운 유지관리가 가능
   > 2. 앱 성능이 향상되며 메모리 누수 및 null 포인터 예외를 방지



##### 결합 표현식

:  `@` 기호로 시작하고 중괄호 `{}`로 래핑

👉🏻 레이아웃 내에서 레이아웃 속성을 참조하는 속성에서 작성됨!



📌 [솔루션 코드](https://github.com/google-developer-training/android-basics-kotlin-unscramble-app/tree/main)



##### 퀴즈

1. 다음 중 ViewModel을 사용하는 이유는 무엇인가요?

   > ViewModel 및 관련 데이터는 활동/프래그먼트의 방향 변경사항을 유지할 수 있습니다.

   > ViewModel을 사용하면 UI 또는 수명 주기에 의존하지 않아도 되는 코드에서 UI를 업데이트하는 코드를 분리할 수 있습니다.

2. 다음 중 언제 ViewModel이 소멸되나요?

   > `onDestroy` 후(구성 변경이 아닌 경우)

3. 참 또는 거짓: 활동/프래그먼트에서 시간이 오래 걸리는 작업 및 I/O 요청을 실행해야 합니다.

   > 거짓

4. UI 컨트롤러 대신 ViewModel에서 LiveData를 초기화하고 저장해야 하는 이유는 무엇인가요?

   > ViewModel과 LiveData가 모두 수명 주기를 인식하므로

   > UI 컨트롤러가 소멸될 때 LiveData가 소멸되지 않도록 하기 위해

   > 구현 세부정보를 숨기거나 분리하여 앱의 유연성을 향상하기 위해

5. `observe`를 사용하면 변경을 위해 다음 중 무엇을 할 수 있나요?

   > LiveData 객체

6. 참 또는 거짓: ViewModel에서 `View` 또는 `LifecycleOwner` 클래스를 직접 참조해도 괜찮습니다.

   > 거짓

