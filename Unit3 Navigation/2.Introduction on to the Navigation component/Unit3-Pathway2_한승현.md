# Unit3-Pathway2



* **프래그먼트 및 탐색 구성요소**

  * **시작하기 전에**

    * 대다수 안드로이드 앱에는 화면마다 별도의 액티비티가 필요하지 않음
    * 실제로 여러 일반적인 UI 패턴이 `프래그먼트` 라는 섹션을 사용하는 단일 액티비티 내에 존재
    * `프래그먼트` 는 재사용 가능한 UI의 부분
    * 탭을 전환할 때, 다른 액티비티를 실행하는 것이 아닌 이전 프래그먼트가 다른 프래그먼트로 교체됨
    * `프래그먼트` 는 고품질 앱을 빌드하는데 필수 요소이며, 이 Codelab에서는 프래그먼트의 기본사항을 알아보고 프래그먼트를 사용하도록 Words 앱을 변환하고, Jetpack 탐색 구성요소를 사용하고 탐색 그래프라는 새로운 리소스 파일을 사용하여 동일한 호스트 액티비티에서 프래그먼트 간에 이동하는 방법도 알아봄

  * **프래그먼트 및 프래그먼트 수명 주기**

    * 프래그먼트는 별도의 자체 수명 주기를 관리함

    * **프래그먼트 수명 주기**

      <img src="https://developer.android.com/codelabs/basic-android-kotlin-training-fragments-navigation-component/img/74470aacefa170bd.png" alt="74470aacefa170bd.png" style="zoom:30%;" />

      * 초기화되고 메모리에서 삭제될 수 있으며 존재하는 동안 화면에 표시되었다가 사라지고 다시 표시될 수 있음
      * 액티비티처럼 프래그먼트도 여러 상태의 수명 주기가 있고 이러한 상태 간 전환에 응답하도록 재정의할 수 있는 여러 메서드 제공
      * 프래그먼트의 수명 주기에는 Lifecycle.State 열거형으로 표현되는 5가지 상태 존재
        * `INITIALIZED` : 프래그먼트의 새 인스턴스가 인스턴스화됨
        * `CREATED` : 첫 번째 프래그먼트 수명 주기 메서드가 호출됨. 이 상태에서 프래그먼트와 연결된 뷰도 만들어짐
        * `STARTED` : 프래그먼트가 화면에 표시되지만 '포커스' 가 없으므로 사용자 입력에 응답할 수 없음
        * `RESUMED` : 프래그먼트가 표시되고 포커스가 있음
        * `DESTROYED` : 프래그먼트 객체의 인스턴스화가 취소됨
      * `Fragment` 클래스는 액티비티와 마찬가지로 수명 주기 이벤트에 응답하기 위해 재정의할 수 있는 여러 메서드를 제공
        * `onCreate()` : 프래그먼트가 인스턴스화되었고 `CREATED`  상태이지만 이에 상응하는 뷰가 아직 만들어지지 않음
        * `onCreateView()` : 레이아웃을 inflate하고, 프래그먼트가 `CREATED` 상태로 전환됨
        * `onViewCreated()` : 뷰가 만들어진 후 호출됨. 일반적으로 이 메서드에서 뷰를 바인딩함
        * `onStart()` : 프래그먼트가 `STARTED` 상태로 전환됨
        * `onResume()` : 프래그먼트가 `RESUMED` 상태로 전환되었고 이제 포커스를 보유(사용자 입력에 응답 가능)
        * `onPause()` : 프래그먼트가 `STARTED` 상태로 다시 전환됨. UI가 사용자에게 표시됨
        * `onStop()` : 프래그먼트가 `CREATED` 상태로 다시 전환됨. 객체가 인스턴스화되었지만 더 이상 화면에 표시되지 않음
        * `onDestroyView()` : 프래그먼트가 `DESTROYED` 상태로 전환되기 직전에 호출됨. 뷰는 메모리에서 이미 삭제되었지만 프래그먼트 객체는 여전히 존재
        * `onDestroy()` : 프래그먼트가 `DESTROYED` 상태로 전환됨
      * 수명 주기 상태와 콜백 메서드는 액티비티와 프래그먼트가 비슷해보이지만 차이가 있음
        * `Activity`
          * `onCreate()` 를 사용해 레이아웃을 inflate하고 뷰를 바인딩함
        * `Fragment`
          * `onCreate()` 는 뷰가 만들어지기 전에 호출되며, 프래그먼트를 인스턴스화할 뿐 뷰는 아직 만들어지지 않음
          * `onCreateView()` 에서 뷰를 inflate하며, 실질적으로 여기서 뷰를 만듦
          * `onViewCreated()` 에서 뷰를 바인딩함

  * **LetterListFragment 구현**

    * `LetterListFragment` 에서 뷰 바인딩을 구현하려면 먼저 null을 허용하는 `FragmentLetterListBinding` 참조를 가져와야 함. 
    * 이와 같은 바인딩 클래스는 **build.gradle** 파일의 `buildFeatures` 섹션에서 `viewBinding` 속성이 사용 설정될 때 Android 스튜디오에서 각 레이아웃 파일에 생성됨
    * `FragmentLetterListBinding` 의 각 뷰에 프래그먼트 클래스의 속성을 할당해주면 됨
    * null을 허용해야 하는 이유
      * `onCreateView()` 가 호출될 때까지 레이아웃을 확장(inflate) 할 수 없기 때문
      * 프래그먼트 인스턴스가 만들어지는 시점(`onCreate()`)과 이 속성을 실제로 사용할 수 있는 시점, 즉 뷰가 만들어지는 시점 사이의 텀이 존재함
      * 프래그먼트의 뷰는 프래그먼트 수명 주기 동안 여러 번 만들어지고 소멸될 수 있음
      * 이러한 이유로, 다른 수명 주기 메서드 `onDestroyView()` 에서도 값을 재설정해야 함

    1. `LetterListFragment.kt`에서 먼저 `FragmentLetterListBinding` 참조를 가져와서 참조의 이름을 `_binding`으로 지정

       ```kotlin
       private var _binding: FragmentLetterListBinding? = null
       ```

       * null을 허용하므로 ? 를 포함해야 함

    2. 밑줄 없이 바인딩이라는 새 속성을 만들고 `_binding!!`와 동일하게 설정

       ```kotlin
       private val binding get() = _binding!!
       ```

       * `get()` 은 이 속성이 `get-only` 임을 나타냄. 값을 가져올 수 있지만 여기서와 같이 할당되고 나면 다른 것에 할당할 수 없음

    3. `onCreate()` 를 구현하려면 `setHasOptionMenu()` 를 호출하면 됨

       ```kotlin
       override fun onCreate(savedInstanceState: Bundle?) {
          super.onCreate(savedInstanceState)
          setHasOptionsMenu(true)
       }
       ```

    4. 프래그먼트에서는 레이아웃이 `onCreateView()` 에서 확장(inflate)됨. 뷰를 확장하고 _binding 값을 설정한 다음 루트 뷰를 반환하여 `onCreateView()` 를 구현

       ```kotlin
       override fun onCreateView(
          inflater: LayoutInflater, container: ViewGroup?,
          savedInstanceState: Bundle?
       ): View? {
          _binding = FragmentLetterListBinding.inflate(inflater, container, false)
          val view = binding.root
          return view
       }
       ```

    5. `binding` 속성 아래에서 RecyclerView 속성을 만듦

       ```kotlin
       private lateinit var recyclerView: RecyclerView
       ```

    6. `onViewCreated()` 에서 `recyclerView` 속성 값을 설정하고 `MainActivity` 에서와 마찬가지로 `chooseLayout()` 호출

       ```kotlin
       override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
          recyclerView = binding.recyclerView
          chooseLayout()
       }
       ```

    7. 마지막으로 `onDestroyView()` 에서 뷰가 더 이상 없으므로 `_binding` 속성을 `null` 로 재설정

       ```kotlin
       override fun onDestroyView() {
          super.onDestroyView()
          _binding = null
       }
       ```

  * * 유의사항

      * `Activity` 클래스에는 `menuInflater` 라는 전역 속성이 있지만 `Fragment` 에는 없음

      * 또한 프래그먼트와 함께 사용되는 `onCreateOptionsMenu()` 메서드에는 return 문이 필요하지 않음

        ```kotlin
        override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
           inflater.inflate(R.menu.layout_menu, menu)
        
           val layoutButton = menu.findItem(R.id.action_switch_layout)
           setIcon(layoutButton)
        }
        ```

      * 프래그먼트는 액티비티와 다르게 `Context` 가 아님

      * `this` 를 LayoutManager의 Context로 전달할 수 없음

      * 프래그먼트는 대신 사용할 수 있는 `context` 속성을 제공

    8. 프래그먼트가 뷰에 표시되도록 `MainActivity` 레이아웃을 확장

       ```kotlin
       override fun onCreate(savedInstanceState: Bundle?) {
          super.onCreate(savedInstanceState)
       
          val binding = ActivityMainBinding.inflate(layoutInflater)
          setContentView(binding.root)
       }
       ```

  * **Jetpack 내비게이션 컴포넌트**

    * Android Jetpack에서 제공하는 탐색 구성요소를 통해 앱에서 간단하거나 복잡한 탐색 구현을 처리할 수 있음

      * `Navigation Graph` : 앱에서 탐색을 시각적으로 보여주는 XML 파일. 파일은 개별 액티비티 및 프래그먼트에 상응하는 대상과, 한 대상에서 다른 대상으로 이동하려고 코드에서 사용할 수 있는 대상 사이의 작업으로 구성됨. 레이아웃 파일과 마찬가지로 Android 스튜디오는 Navigation Graph에 대상과 작업을 추가하는 시각적 편집기를 제공
      * `NavHost` : 액티비티 내에서 내비게이션 그래프의 대상을 표시하는 데 사용. 프래그먼트 간에 이동하면 NavHost에 표시되는 대상이 업데이트됨. `MainActivity` 에서 `NavHostFragment` 라는 기본 제공 구현을 사용
      * `NavController` : `NavHost` 에 표시되는 대상 간 탐색을 제어할 수 있음. 탐색 구성요소를 사용하면 `NavController` 의 `navigate()` 메서드를 호출하여 표시되는 프래그먼트를 교체할 수 있음. `NavController` 를 사용하면 시스템 `UP` 버튼에 응답하여 이전에 표시된 프래그먼트로 다시 이동하는 것과 같은 일반적인 작업을 처리할 수도 있음

    * **Navigation Dependency**

      * 프로젝트 수준 `build.gradle` > `buildscript` > `ext` 에서 `nav_version` 을 `2.3.1` 로 설정

        ```kotlin
        buildscript {
            ext {
                appcompat_version = "1.2.0"
                constraintlayout_version = "2.0.2"
                core_ktx_version = "1.3.2"
                kotlin_version = "1.3.72"
                material_version = "1.2.1"
                nav_version = "2.3.1"
            }
        
            ...
        ```

      * 앱 수준 `build.gradle`

        ```kotlin
        implementation "androidx.navigation:navigation-fragment-ktx:$nav_version"
        implementation "androidx.navigation:navigation-ui-ktx:$nav_version"
        ```

    * **Safe Args 플러그인**

      * 내비게이션 컴포넌트를 구현하기 전에 프래그먼트 간에 데이터를 전달할 때 유형 안정성을 지원하는 Gradle 플러그인인 **Safe Args** 라는 항목도 추가해야 함

      * 프로젝트 수준 `build.gradle` > `buildscript` > `dependencies` 에서 다음 클래스 경로 추가

        ```kotlin
        classpath "androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version"
        ```

      * 앱 수준 `build.gradle` 상단의 `plugins` 내에서 `androidx.navigation.safeargs.kotlin` 추가

        ```kotlin
        plugins {
            id 'com.android.application'
            id 'kotlin-android'
            id 'kotlin-kapt'
            id 'androidx.navigation.safeargs.kotlin'
        }
        ```

  * **NavGraph 사용**

    * 내비게이션 컴포넌트는 프래그먼트 간 탐색을 구현하기 위한 도구 모음을 나타냄

    * 프래그먼트 간 탐색을 구현하는 데 도움이 되는 새로운 시각적 편집기인 `NavGraph` 를 사용

    * **NavGraph란 무엇인가요?**

      * `NavGraph` 란 앱 탐색의 가상 매핑
      * 각 화면은 이동할 수 있는 가능한 대상이 되며, `NavGraph` 는 각 대상이 서로 관련되는 방식을 보여주는 XML 파일로 나타낼 수 있음
      * 백그라운드에서는 실제로 `NavGraph` 클래스의 새 인스턴스가 생성되지만 `NavGraph` 의 대상은 `FragmentContainerView` 로 사용자에게 표시됨. XML 파일을 만들고 가능한 대상을 정의하기만 하면 되고, 생성된 코드를 사용하여 프래그먼트 간 이동 가능

    * **MainActivity에서 FragmentContainerView 사용**

      1. `androidx.recyclerview.widget.RecyclerView`인 **activity_main.xml**의 `FrameLayout` 콘텐츠를 `FragmentContainerView`로 바꿈

         `nav_host_fragment`라는 ID를 제공하고 높이와 너비를 `match_parent`로 설정하여 전체 프레임 레이아웃을 채움

         ```xml
         <androidx.fragment.app.FragmentContainerView
            android:id="@+id/nav_host_fragment"
            android:layout_width="match_parent"
            android:layout_height="match_parent" />
         ```

      2. ID 속성 아래에 `name` 속성을 추가하고 `androidx.navigation.fragment.NavHostFragment` 로 설정

         이 속성의 특정 프래그먼트를 지정할 수 있지만 `NavHostFragment` 로 설정하면 `FragmentContainerView` 가 프래그먼트 간에 이동할 수 있음

         ```xml
         android:name="androidx.navigation.fragment.NavHostFragment"
         ```

      3. layout_height 및 layout_width 속성 아래에 app:navHost라는 속성을 추가하고 `"true"`와 동일하게 설정

         이렇게 하면 프래그먼트 컨테이너가 탐색 계층 구조와 상호작용할 수 있음

         예를 들어 시스템 뒤로 버튼을 누르면 컨테이너는 새 액티비티가 표시될 때와 마찬가지로 이전에 표시된 프래그먼트로 다시 이동

         ```xml
         app:defaultNavHost="true"
         ```

      4. `app:navGraph`라는 속성을 추가하고 `"@navigation/nav_graph"`와 동일하게 설정

         이는 앱의 프래그먼트가 서로 이동할 수 있는 방법을 정의하는 XML 파일을 가리킴

         ```xml
         app:navGraph="@navigation/nav_graph"
         ```

      5. 마지막으로 앱 네임스페이스가 있는 두 속성을 추가했으므로 `FrameLayout`에 xmlns:app 속성을 추가

         ```xml
         <xmlns:android="http://schemas.android.com/apk/res/android"
            xmlns:tools="http://schemas.android.com/tools"
            xmlns:app="http://schemas.android.com/apk/res-auto"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            tools:context=".MainActivity">
         ```

    * **NavGraph 설정**

      1. Resource type이 `Navigation` 인 `NavGraph` 파일을 만듦
      2. 새 대상을 추가하려면 화면 상단 왼쪽에서 새로 만들기 버튼을 클릭하여 각 프래그먼트의 대상을 만듦

    * **탐색 작업 만들기**

      * 탐색 작업을 만드려면 대상 위로 마우스를 가져가서 오른쪽에 표시되는 원에서 이동하길 원하는 대상으로 드래그하면 됨

    * **WordListFragment의 인수 지정**

      * 인텐트를 사용하여 액티비티 사이를 이동할 때 선택된 문자가 전달될 수 있도록 extra를 지정한 것처럼, 내비게이션도 대상 간 매개변수 전달도 지원하면서 유형에 안전한 방식으로 이를 실행함
      * 전달받을 대상을 선택하고 속성 창의 Arguments에서 더하기 버튼을 클릭하여 새 인수 만듦
      * 인수는 `letter` , 유형은 `String` 이어야 하며, 여기서 이전에 추가한 `Safe Args` 플러그인이 필요함

    * **시작 대상 설정**

      * 시작할 대상을 선택하고 **Assign start destination** 버튼을 클릭하여 시작 대상을 설정

    * **탐색 작업 실행**

      * `LetterAdapter.kt` 의 `onClickListener()` 의 내용을 아래와 같이 바꿈

        ```kotlin
        val action = LetterListFragmentDirections.actionLetterListFragmentToWordListFragment(letter = holder.button.text.toString())
        ```

        `LetterListFragmentDirections` 를 사용하면 `letterListFragment` 로부터 가능한 모든 내비게이션 경로를 참조할 수 있음

      * 내비게이션 작업 참조가 있으면 `NavController` 참조를 가져와서 작업을 전달하는 `navigate()` 를 호출하면 됨

        ```kotlin
        holder.view.findNavController().navigate(action)
        ```

    * **MainActivity 구성**

      1. `navController` 속성 만듦

         ```kotlin
         private lateinit var navController: NavController
         ```

      2. `onCreate()` 에서 `setContentView()` 를 호출한 후 `nav_host_fragment`(`FragmentContainerView`의 ID) 참조를 가져와서 `navController` 속성에 할당

         ```kotlin
         val navHostFragment = supportFragmentManager
             .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
         navController = navHostFragment.navController
         ```

      3. `onCreate()` 에서 `setupActionBarWithNavController()` 를 호출하여 `navController` 를 전달함

         ```kotlin
         setupActionBarWithNavController(navController)
         ```

      4. `onSupportNavigateUp()` 구현

         ```kotlin
         override fun onSupportNavigateUp(): Boolean {
            return navController.navigateUp() || super.onSupportNavigateUp()
         }
         ```

  * **WordListFragment에서 인수 가져오기**

    * 액티비티의 인텐트를 참조하는 방법은 효과적이나 권장되지 않음. 프래그먼트가 다른 레이아웃에 삽입될 수 있고 큰 앱에서는 프래그먼트가 속하는 액티비티를 추측하기가 훨씬 더 어렵기 때문이며, `nav_graph` 를 사용하여 탐색을 실행하고 `Safe Args` 를 사용하면 인텐트가 없으므로 인텐트 extras에 액세스하려고 해도 효과가 없음
    * `Safe Args` 액세스는 아주 간단하며 `onViewCreated()` 가 호출될 때까지 기다리지 않아도 됨

    1. `WordListFragment` 에서 `letterId`  속성을 만듦

       ```kotlin
       private lateinit var letterId: String
       ```

    2. `onCreateView()` 나 `onViewCreated()` 가 아닌 `onCreate()` 를 재정의하고 다음을 추가

       ```kotlin
       override fun onCreate(savedInstanceState: Bundle?) {
           super.onCreate(savedInstanceState)
       
           arguments?.let {
               letterId = it.getString(LETTER).toString()
           }
       }
       ```

       `arguments` 는 선택사항일 수 있으므로 `let()` 을 호출하여 람다를 전달

    3. recyclerView의 어댑터를 설정할 때 `letterId` 에 액세스할 수 있음

       `onViewCreated()` 의 `activity?.intent?.extras?.getString(LETTER).toString()` 을 `letterId` 로 바꿈

       ```kotlin
       recyclerView.adapter = WordAdapter(letterId, requireContext())
       ```

  * **프래그먼트 라벨 업데이트**

    * `NavGraph` 에서 label을 원하는대로 변경



### Quiz

1. **True or False: `onCreateView()` is only called once for a fragment’s entire lifecycle.**

   * False

2. **Which of the following is a benefit of using fragments?**

   * Navigation between fragments allows for more sophisticated user interface patterns, such as tab bars.
   * Using multiple fragments within an activity allows for an adaptive layout across multiple screen sizes.
   * The same fragments can be reused across multiple activities.

3. **In the fragment lifecycle, which of the following tasks should be performed in `onViewCreated()`?**

   * Binding view objects to properties in your fragment
   * Setting properties of individual views, such as a recycler view’s adapter

4. **In the fragment lifecycle, which of the following tasks should be performed in `onCreateView()`?**

   * Inflating the layout

5. **Fill the blank.**

   The `onSupportNavigateUp` method needs to be overridden in the host activity to ensure your app’s fragment-based navigation responds to the app’s "Up" button.

6. **Given the code for navigating between two fragments in a note-taking app, a list of books and a list of notes, which of the following is true about the navigation graph file?**

   ```kotlin
   val action = BooksListFragmentsDirections.actionBooksListToNotesList(bookIndex = index)
   holder.view.findNavController().navigate(action)
   ```

   * Both the books list and notes list are destinations.
   * There’s an action defined on the navigation graph that goes from the books list to the notes list.