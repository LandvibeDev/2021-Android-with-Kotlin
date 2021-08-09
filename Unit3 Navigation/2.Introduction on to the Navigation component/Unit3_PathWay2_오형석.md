### Unit 2: Layouts

#### PATHWAY 1:Get user input in an app: Part 2

<hr/>

#### &#10004; 프래그먼트 및 탐색 구성요소

##### 프래그먼트

- 재사용 가능한 UI의 부분.
- 하나 이상의 활동에 재사용하고 삽입할 수 있음.
- 고품질 앱을 빌드하는데 필수 요소
- Acitivity와 마찬가지로 수명주기가 있고 사용자 입력에 응답 가능
- Activity가 화면에 표시될때 Acitivity의 뷰 계층 구조 내에 항상 포함
- 재사용성과 모듈성을 강조하므로 단일 활동에서 여러 프래그먼트 동시에 호스팅 가능
- 각 프래그먼트는 별도의 자체 수명 주기를 관리.

##### 프래그먼트 수명주기

Activity와  마찬가지로 프래그먼트는 초기화되고 메모리에서 삭제될 수 있으며 존쟇나ㅡㄴ 동안 화면에 표시되었다가 사라지고 다시 표시될 수 있음. 프래그먼트는 여러 수명 주기가 있고 이러한 상태 간 전환에 응답하도록 재정의할 수 있는 여러 메서드를 제공. 프래그먼트 수명 주기에는 Lifecycle.State 열거형으로 표현되는 다섯가지가 존재.

- INITIALIZED: 프래그먼트의 새 인스턴스가 인스턴스화되었습니다.
- CREATED: 첫 번째 프래그먼트 수명 주기 메서드가 호출됩니다. 이 상태에서 프래그먼트와 연결된 뷰도 만들어집니다.
- STARTED: 프래그먼트가 화면에 표시되지만 '포커스'가 없으므로 사용자 입력에 응답할 수 없습니다.
- RESUMED: 프래그먼트가 표시되고 포커스가 있습니다.
- DESTROYED: 프래그먼트 객체의 인스턴스화가 취소되었습니다.

또한 활동과 마찬가지로 `Fragment`클래스는 수명 주기 이벤트에 응답하기 위해 재정의할 수 있는 여러 메서드를 제공.

- `onCreate()`: 프래그먼트가 인스턴스화되었고 `CREATED` 상태입니다. 그러나 이에 상응하는 뷰가 아직 만들어지지 않았습니다.
- `onCreateView()`: 이 메서드에서 레이아웃을 확장합니다. 프래그먼트가 `CREATED` 상태로 전환되었습니다.
- `onViewCreated()`: 뷰가 만들어진 후 호출됩니다. 이 메서드에서 일반적으로 `findViewById()`를 호출하여 특정 뷰를 속성에 바인딩합니다.
- `onStart()`: 프래그먼트가 `STARTED` 상태로 전환되었습니다.
- `onResume()`: 프래그먼트가 `RESUMED` 상태로 전환되었고 이제 포커스를 보유합니다(사용자 입력에 응답할 수 있음).
- `onPause()`: 프래그먼트가 `STARTED` 상태로 다시 전환되었습니다. UI가 사용자에게 표시됩니다.
- `onStop()`: 프래그먼트가 `CREATED` 상태로 다시 전환되었습니다. 객체가 인스턴스화되었지만 더 이상 화면에 표시되지 않습니다.
- `onDestroyView()`: 프래그먼트가 `DESTROYED` 상태로 전환되기 직전에 호출됩니다. 뷰는 메모리에서 이미 삭제되었지만 프래그먼트 객체는 여전히 있습니다.
- `onDestroy()`: 프래그먼트가 `DESTROYED` 상태로 전환됩니다.

프래그먼트의 수명 주기와 상태 간 전환을 보여주는 그래프

<img src="img/3-2_1_ohs.png" width="400">

수명 주기 상태와 콜백 메서드는 활동에 사용된 것과 매우 비슷 그러나 `onCreate()`메서드의 차이에 유의해야함. Activity에서는 이 메서드를 사용하여 레이아웃을  확장하고 뷰를 바인딩. 그러나 프래그먼트는 수명 주기에서 `onCreate()`는 뷰가 만들어지기 전에 호출되므로 여기서 레이아웃을 확장할 수 없음. 대신 `onCreateView()`에서 확장. 그런 다음 뷰를 만든 후 `onViewCreated()`메서드가 호출되고 여기서 속성을 특정 뷰에 바인딩 할 수 있음.

##### 프래그먼트 및 레이아웃 파일 만들기

- 프래그먼트는 레이아웃용 XML파일과 상호작용을 처리하는 Kotlin클래스 두 개의 파일로 구성

##### LetterListFragment 구현

- `LetterListFragment`에서 뷰 바인딩을 구현하려면 먼저 null을 허용하는 `FragmentLetterListBinding` 참조를 가져와야 하는데 이와 같은 바인딩 클래스는 bulid.gradle 파일의 `buildFeatures`섹션에서 `viewBinding`속성이 사용 설정될 때 Android 스튜디오에서 각  레이아웃 파일에 생성됨. 그러므로 각 뷰에 프래그먼트 클래스의 속성을 할당하기만 하면 됨.
- 유형인 `FragmentLetterIistBinding?`이어여 하고 초기값은`null`이어야 함. null을 허용해야 하느 이유는 `onCreateView()`가 호출될 때까지 레이아웃을 확장할 수 없기 때문. 
- `LetterListFragnemt`의 인스턴스가 만들어지는 시점(수명 주기가 `onCreate()`로 시작될 때)과 이 속성을 실제로 사용할 수 있는 시점 사이에는  기간이 존재. 프래그먼트의 뷰는 프래그먼트의 수명 주기 동안 여러 번 만들어지고 소멸될 수 있다는 사실에도 유의해야함. 이러한 이유로 다른 수명 주기 메서드 `onDestroyView()`에서도 값을 재설정해야함.
- !!를 사용하여 변수를 null을 허용하는 것으로 만들 때 null이 아님을 아는(_binding이 onCreatevView()에서 할당된 후 값을 보유하는 것을 아는 것처럼) 위치 한두 군데에서만 사용하는 것이 좋음. 이런식으로 null을 허용하는 값에 ㅇ엑세스하는 것은 위험하며  비정상 종료가 발생할 수 있으므로 최소한으로 사용 //기본적으로 코틀린은 변수에 null값을 넣지 못함.
- 일반적응로 속성에 직접 엑세스하지 못하도록 막기 위해 Kotlin에서는 속성 이름앞에 밑줄을 붙음.

```kotlin
private val binding get() = _binding!!
```

`get()`은 이 속성이 'get-only'임을 나타냄. 즉 값을 가져올 수는 있지만 여기서와 같이 ㅅ할당되고 나면 다른 것에 할당할 수 없음.

##### Jetpack 탐색 구성요소

Android Jetpack에서 제공하는 탐색 구성요소를 통해 앱에서 간단하거나 복잡한 탐색 수현 처리를 할 수 있음. 탐색 구성요소에는 Words 앱에서 탐색을 구현하는데 사용할 세가지 주요 부분이 존재

- 탐색 그래프: 앱에서 탐색을 시각적으로 보여주는 XML 파일. 파일은 개별 활동 및 프래그먼트에 상응하는 대상과 한 대상에서 다른 대상으로 이동하려고 코드에서 사용할 수 있는 대상 사이의 작업으로 구성.
- `NavHost`: `NavHost`는 Activity 내에서 탐색 그래프의 대상을 표시하는데 사용. 프래그먼트 간에 이동하면 `NavHost`에 표시되는 대상이 업데이트됨.  `MainActivity`에서 `NavHostFragment`라는 기본 제공 구현을 사용
- `NavController` : `NavController` 객체를 사용하면 `NavHost`에 표시되는 대상 간 탐색을 제어할 수 있음. 인텐트를 사용하면 startActivity를 호출해 새 화면으로 이동해야 했지만 탐색 구성요소를 사용하면 `NavController`의 `navigate()` 메서드를 호출해 표시되는 프래그먼트를 교체할 수 있음. `NavController`을 사용하면 시스템 '위로'(뒤로?) 버튼에 응답해 이전에 표시된 프래그먼트로 다시 이동하는 것과 같은 작업도 처리가능.

##### Safe Args 플러그인

프래그먼트 간에 데이터를 전달할 때 유형 안정성을 지원하는 Gradle 플러그인인  **Safe Args**라는 항목도 추가헤야함.

- `build.gradle` 파일의 **buildscript > dependencies**에서 다음 클래스 경로를 추가

```kotlin
classpath "androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version"
```

- 앱 수준 `build.gradle` 파일의 상단에 있는 `plugins` 내에서`androidx.navigation.safeargs.kotlin` 을 추가

```kotlin
plugins {
    id 'com.android.application'
    id 'kotlin-android'
    id 'kotlin-kapt'
    id 'androidx.navigation.safeargs.kotlin'
}
```

##### 탐색 그래프 사용

탐색 구성요소는 탐색, 특히 프래그먼트 간 탐색을 구현하기 위한 도구 모음을 나타냄.  프래그먼트 간 탐색을 구현하는데 도움이 되는 새로운 시각적 편집기인 탐색 그래프(NavGraph)를 사용.

**탐색 그래프**

탐색 그래프는 앱 탐색의 가상 매핑. 각 화면(프래그먼트)는 이동할 수 있는 가능한 대상이 됨. 'NavGraph'는 각 대상이 서로 관련되는 방식을 보여주는 XML파일로 나타낼 수 있음.

배경에서는 실제로 `NavGraph`클래스의 새 인스턴스가 생성. 그러나 탐색 그래프의 대상은 `FragmentContainerView`로 사용자에게 표시됨. XML 파일을 만들고 가능한 대상을 정의하기만 하면 됨. 그 후 생성된 코드를 사용하여 프래그먼트 간에 이동할 수 있음.

##### 단락평가

bool 연산을 할 때 앞 연산자의 결과에 따라 뒤 연산자의 실행여부가 결정되는 계산 방식. 

### 요약

- 프래그먼트는 활동에 삽입할 수 있는 재사용 가능한 UI의 부분
- 프래그먼트 수명 주기는 활동 수명 주기와 다르며 뷰 설정이 `OnCreateView()`가 아닌 `onViewCreated()`에서 발생.
- `FramentContainerView`는 프래그먼트를 다른 활동에 삽입하는 데 사용되고 프래그먼트 간 탐색을 관리할 수 있음.

#### 탐색 구성요소 사용

- `FragmentContainerView`의 `navGraph` 속성을 설정하면 활동 내에서 프래그먼트 간에 이동할 수 있음.
- `NavGraph` 편집기를 사용하면 탐색 작업을 추가하고 다양한 대상 간에 인수를 지정할 수 있음.
- 인텐트를 사용하여 탐색하려면 extras를 전달해야 하지만 탐색 구성요소는 SafeArgs를 사용하여 탐색 작업의 클래스와 메서드를 자동 생성하므로 인수를 통해 유형 안전성을 보장

#### 프래그먼트 사용 사례

- 탐색 구성요소를 사 용하면 어러 앱이 단일 활동 내에서 전체 레이아웃을 관리할 수 있으며 모든 탐색은 프래그먼트 간에 발생
- 프래그먼트를 통해 태블릿의 마스터/세부정보 레이아웃이나 동일한 활동 내의 여러 탭과 같은 일반적인 레이아웃 패턴이 가능해짐.

<hr/>

### Quiz

1. True or False: `onCreateView()` is only called once for a fragment’s entire lifecycle.

- False

2. Which of the following is a benefit of using fragments?

- Navigation between fragments allows for more sophisticated user interface patterns, such as tab bars.
- Using multiple fragments within an activity allows for an adaptive layout across multiple screen sizes.
- The same fragments can be reused across multiple activities.

3. In the fragment lifecycle, which of the following tasks should be performed in `onViewCreated()`?

- Binding view objects to properties in your fragment
- Setting properties of individual views, such as a recycler view’s adapter

4. In the fragment lifecycle, which of the following tasks should be performed in `onCreateView()`?

- Inflating the layout

5. 빈 칸 채우기

- The **onSupportNavigateUp()** method needs to be overridden in the host activity to ensure your app’s fragment-based navigation responds to the app’s "Up" button.

6. Given the code for navigating between two fragments in a note-taking app, a list of books and a list of notes, which of the following is true about the navigation graph file?

```kotlin
val action = BooksListFragmentsDirections.actionBooksListToNotesList(bookIndex = index)
holder.view.findNavController().navigate(action)
```

- A: Both the books list and notes list are destinations.
- C: There’s an action defined on the navigation graph that goes from the books list to the notes list.

