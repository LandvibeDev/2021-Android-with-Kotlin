# 🔥 Unit 3 : Navigation

## Pathway 2: Introduction to the Navigation component

## 🎖 Fragments and the Navigation component



#### Fragment

+ 간단하게 말해 앱의 사용자 인터페이스에서 **재사용 가능한 부분**입니다. 활동과 마찬가지로 프래그먼트는 수명 주기가 있고 사용자 입력에 응답할 수 있습니다. 프래그먼트는 활동이 화면에 표시될 때 활동의 뷰 계층 구조 내에 항상 포함됩니다. 재사용성과 모듈성을 강조하므로 **단일 활동에서 여러 프래그먼트를 동시에 호스팅**할 수도 있습니다. 각 프래그먼트는 별도의 자체 수명 주기를 관리합니다.



#### Fragment Lifecycle

+  *Lifecycle.State* 열거형으로 표현되는 다섯 가지 상태
  + INITIALIZED: 프래그먼트의 새 인스턴스가 인스턴스화되었습니다.
  + CREATED: 첫 번째 프래그먼트 수명 주기 메서드가 호출됩니다. 이 상태에서 프래그먼트와 연결된 뷰도 만들어집니다.
  + STARTED: 프래그먼트가 화면에 표시되지만 '포커스'가 없으므로 사용자 입력에 응답할 수 없습니다.
  + RESUMED: 프래그먼트가 표시되고 포커스가 있습니다.
  + DESTROYED: 프래그먼트 객체의 인스턴스화가 취소되었습니다.



+ `Fragment` 클래스는 수명 주기 이벤트에 응답하기 위해 재정의할 수 있는 여러 메서드를 제공한다. 

  - `onCreate()`: 프래그먼트가 인스턴스화되었고 `CREATED` 상태입니다. 그러나 이에 상응하는 뷰가 아직 만들어지지 않았습니다.
  - `onCreateView()`: **이 메서드에서 레이아웃을 확장**합니다. 프래그먼트가 `CREATED` 상태로 전환되었습니다.
  - `onViewCreated()`: 뷰가 만들어진 후 호출됩니다. 이 메서드에서 일반적으로 `findViewById()`를 호출하여 특정 뷰를 속성에 바인딩합니다.
  - `onStart()`: 프래그먼트가 `STARTED` 상태로 전환되었습니다.
  - `onResume()`: 프래그먼트가 `RESUMED` 상태로 전환되었고 이제 포커스를 보유합니다(사용자 입력에 응답할 수 있음).
  - `onPause()`: 프래그먼트가 `STARTED` 상태로 다시 전환되었습니다. UI가 사용자에게 표시됩니다.
  - `onStop()`: 프래그먼트가 `CREATED` 상태로 다시 전환되었습니다. 객체가 인스턴스화되었지만 더 이상 화면에 표시되지 않습니다.
  - `onDestroyView()`: 프래그먼트가 `DESTROYED` 상태로 전환되기 직전에 호출됩니다. 뷰는 메모리에서 이미 삭제되었지만 프래그먼트 객체는 여전히 있습니다.
  - `onDestroy()`: 프래그먼트가 `DESTROYED` 상태로 전환됩니다.

  <img src = "https://user-images.githubusercontent.com/31370590/126290914-05546013-f2da-4dd0-b899-c93592aadd1f.PNG" width = "350" height = "500"> 

+ 수명 주기 상태와 콜백 메서드는 activity에 사용된 것과 매우 비슷합니다. 그러나 `onCreate()` 메서드의 차이에 유의해야 합니다. activity에서는 이 메서드를 사용하여 레이아웃을 확장하고 뷰를 바인딩합니다. 그러나 **프래그먼트 수명 주기에서 `onCreate()`는 뷰가 만들어지기 전에 호출**되므로 여기서 레이아웃을 확장할 수 없습니다. 대신 `onCreateView()`에서 확장합니다. 그런 다음 뷰를 만든 후 `onViewCreated()` 메서드가 호출되고 여기서 속성을 특정 뷰에 바인딩할 수 있습니다. 





#### LetterListFragment 구현

1. `LetterListFragment`에서 뷰 바인딩을 구현하려면 먼저 null을 허용하는 `FragmentLetterListBinding` 참조를 가져와야 합니다. 

   > 이와 같은 바인딩 클래스는 **build.gradle** 파일의 `buildFeatures` 섹션에서 `viewBinding` 속성이 사용 설정될 때 Android 스튜디오에서 **각 레이아웃 파일에 생성**됩니다. `FragmentLetterListBinding`의 각 뷰에 프래그먼트 클래스의 속성을 할당하기만 하면 됩니다

   유형은 `FragmentLetterListBinding?`이어야 하고 초깃값은 `null`이어야 합니다. null을 허용해야 하는 이유는 무엇인가요? `onCreateView()`가 호출될 때까지 레이아웃을 확장할 수 없기 때문입니다. `LetterListFragment`의 인스턴스가 만들어지는 시점(수명 주기가 `onCreate()`로 시작될 때)과 이 속성을 실제로 사용할 수 있는 시점 사이에는 기간이 있습니다. 프래그먼트의 뷰는 프래그먼트의 수명 주기 동안 여러 번 만들어지고 소멸될 수 있다는 사실에도 유의해야 합니다. 이러한 이유로 다른 수명 주기 메서드 `onDestroyView()`에서도 값을 재설정해야 합니다.

   ```kotlin
   private var _binding: FragmentLetterListBinding? = null
   ```

   > null을 허용하므로 `_binding` 속성(예: `_binding?.someView`)에 액세스할 때마다 null 안전을 위해 `?`를 포함해야 합니다. 그러나 null 값 하나 때문에 코드에 물음표를 다수 포함해야 한다는 의미는 아닙니다. 액세스할 때 값이 null이 아님을 확신하는 경우 유형 이름에 `!!`를 추가할 수 있습니다. 그런 다음 `?` 연산자 없이 다른 속성처럼 액세스할 수 있습니다.



2. 밑줄 없이 바인딩이라는 새 속성을 만들고 `_binding!!`와 동일하게 설정합니다.

   ```kotlin
   private val binding get() = _binding!!
   ```









Q)

+ `onCreate()`를 구현하려면 `setHasOptionsMenu()`를 호출하면 됩니다
+ 프래그먼트는 인텐트에 직접 액세스할 수 없으므로 `activity.intent`를 사용하여 참조해야 합니다



Andriod Jetpack에서 제공하는 *Navigation component*

- 탐색 그래프: 탐색 그래프는 앱에서 탐색을 시각적으로 보여주는 XML 파일입니다. 파일은 개별 활동 및 프래그먼트에 상응하는 *대상*과 한 대상에서 다른 대상으로 이동하려고 코드에서 사용할 수 있는 대상 사이의 작업으로 구성됩니다. 레이아웃 파일과 마찬가지로 Android 스튜디오는 탐색 그래프에 대상과 작업을 추가하는 시각적 편집기를 제공합니다.
- `NavHost`: `NavHost`는 활동 내에서 탐색 그래프의 대상을 표시하는 데 사용됩니다. 프래그먼트 간에 이동하면 `NavHost`에 표시되는 대상이 업데이트됩니다. `MainActivity`에서 `NavHostFragment`라는 기본 제공 구현을 사용합니다.
- `NavController`: `NavController` 객체를 사용하면 `NavHost`에 표시되는 대상 간 탐색을 제어할 수 있습니다. 인텐트를 사용할 때는 startActivity를 호출하여 새 화면으로 이동해야 했습니다. 탐색 구성요소를 사용하면 `NavController`의 `navigate()` 메서드를 호출하여 표시되는 프래그먼트를 교체할 수 있습니다. `NavController`를 사용하면 시스템 '위로' 버튼에 응답하여 이전에 표시된 프래그먼트로 다시 이동하는 것과 같은 일반적인 작업을 처리할 수도 있습니다.

+ 프래그먼트 간에 데이터를 전달할 때 유형 안전성을 지원하는 Gradle 플러그인인 **Safe Args**라는 항목도 추가해야 합니다.



#### 탐색 그래프 사용

+ `MainActivity`의 용도를 변경하여 프래그먼트의 NavHost 역할을 할 `FragmentContainerView`를 포함합니다. 이 시점부터 앱의 모든 탐색은 `FragmentContainerView` 내에서 실행됩니다. 



Navigation APIs

+ `NavHostFragment` : 탐색 구성요소가 교환되는 목적지 컨테이너 역할을 한다. 이는 activity를 통해  탐색할 때 대체되는 fragment를 담는 컨테이너이다.

+ `NavController` : 탐색 구성요소(navigate components)의 내부요소로 실제로 탐색 작업을 한다. 진행중인 작업을 보여주는 안내자와 같다.  

+ `NavigationView` : `NavHostFragment`안에 없고, 탐색 구성요소의 일부도 아님. 탐색 구성요소 전에 존재했으며, 탐색 창 내에 있는 메뉴와 관련이 있음. 메뉴 항목과 탐색 창을 선택하면 앱 내 다른 목적지로 이동한다. 하지만 탐색 구성요소의 일부가 아니며, 탐색 구성요소의 항목과 상호작용 하는 것이다.  

+ `NavigationUI` : `NavHostFragment` 외부 콘텐츠 업데이트를 책임집니다. ex) navigationView, BottomNavBar ? 

  => 이를 사용하면 훨씬 간편하게 앱 내 탐색을 만들고 수정할 수 있음.





#### Quiz/Unit3/Pathway2

1. True or False: `onCreateView()` is only called once for a fragment’s entire lifecycle.

   => False



2. Which of the following is a benefit of using fragments?

   => 

   + Navigation between fragments allows for more sophisticated user interface patterns, such as tab bars.
   + Using multiple fragments within an activity allows for an adaptive layout across multiple screen sizes.
   + The same fragments can be reused across multiple activities.



3. In the fragment lifecycle, which of the following tasks should be performed in `onViewCreated()`?

   => 

   + Binding view objects to properties in your fragment
   + Setting properties of individual views, such as a recycler view’s adapter



4. In the fragment lifecycle, which of the following tasks should be performed in `onCreateView()`?

   => Inflating the layout



5. The 				method needs to be overridden in the host activity to ensure your app’s fragment-based navigation responds to the app’s "Up" button.



6. Given the code for navigating between two fragments in a note-taking app, a list of books and a list of notes, which of the following is true about the navigation graph file?

   => 

   + Both the books list and notes list are destinations.
   + There’s an action defined on the navigation graph that goes from the books list to the notes list.