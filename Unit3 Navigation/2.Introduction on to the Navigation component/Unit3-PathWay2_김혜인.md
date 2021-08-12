# 2021 Landvibe Summer Coding - Android

## Unit3 : Navigation

### PathWay2 : Introduction to the Navigation component



##### :rocket: Android Jetpack: 탐색 구성요소 소개

- **navigate** : 다른 화면으로 이동하는 것
  - **Bottom Navigator**
    - Navigates correctly
    - Highlights correct button
    - Handles back-stack
  - **Navigation Component**
    - A collection of `libraries`, `a plugin` and `tooling`
    - Navigation graph (New Resource)
      - xml 파일 형태, navigation(탐색)에 관련된 정보를 포함하고 중심화
    - NavHostFragment (Layout)
      - 레이아웃을 추가할 분할 위젯, 창 (분할 목적지를 교환하는 곳)
    - NavController (Fragment)
      - navigation이 작동하도록, 코틀린이나 자바 코드에서 사용하는 것
      - **SafeArgs Plugin** : 안전한 유형의 탐색과 인수 전달
        - :x: xml 아이디로 액션 지정, :o: 액션이 목적지와 연결되도록​ 
  - **Navigation UI**
    - Options Menus
    - Bottom Navagation
    - Navigation View
    - Navigation Drawer
    - ActionBar
    - ToolBar
    - Collapsing Toolbar





##### :rocket: 프래그먼트 및 탐색 구성요소

- **fragment**

  : 앱의 사용자 인터페이스에서 재사용 가능한 부분

  - 재사용성, 모듈성 :arrow_forward: single activity에서 여러 fragment 동시 호스팅 가능

  ***

  - **프래그먼트 수명주기**

    - **Lifecycle.State**
      - INITIALIZED : 프래그먼트의 새 인스턴스가 인스턴스화되었습니다.
      - CREATED : 첫 번째 프래그먼트 수명 주기 메서드가 호출됩니다. 이 상태에서 프래그먼트와 연결된 뷰도 만들어집니다.
      - STARTED : 프래그먼트가 화면에 표시되지만 '포커스'가 없으므로 사용자 입력에 응답할 수 없습니다.
      - RESUMED : 프래그먼트가 표시되고 포커스가 있습니다.
      - DESTROYED : 프래그먼트 객체의 인스턴스화가 취소되었습니다.

    ***

    - **method**
      - `onCreate()`: 프래그먼트가 인스턴스화되었고 `CREATED` 상태입니다. 그러나 이에 상응하는 뷰가 아직 만들어지지 않았습니다.
      - `onCreateView()`: 이 메서드에서 레이아웃을 확장합니다. 프래그먼트가 `CREATED` 상태로 전환되었습니다.
      - `onViewCreated()`: 뷰가 만들어진 후 호출됩니다. 이 메서드에서 일반적으로 `findViewById()`를 호출하여 특정 뷰를 속성에 바인딩합니다.
      - `onStart()`: 프래그먼트가 `STARTED` 상태로 전환되었습니다.
      - `onResume()`: 프래그먼트가 `RESUMED` 상태로 전환되었고 이제 포커스를 보유합니다(사용자 입력에 응답할 수 있음).
      - `onPause()`: 프래그먼트가 `STARTED` 상태로 다시 전환되었습니다. UI가 사용자에게 표시됩니다.
      - `onStop()`: 프래그먼트가 `CREATED` 상태로 다시 전환되었습니다. 객체가 인스턴스화되었지만 더 이상 화면에 표시되지 않습니다.
      - `onDestroyView()`: 프래그먼트가 `DESTROYED` 상태로 전환되기 직전에 호출됩니다. 뷰는 메모리에서 이미 삭제되었지만 프래그먼트 객체는 여전히 있습니다.
      - `onDestroy()`: 프래그먼트가 `DESTROYED` 상태로 전환됩니다.

    <img src="img/Unit3-Pathway2-1_hyein.png" width="50%" align="left">

    ***

    - fragment 파일 구성 : XML file & Kotlin(Java) class

      :arrow_forward: (activity와 마찬가지로) layout 확장 & 개별 view 바인딩

      ***

      1. LetterListFragment 구현

      ``````kotlin
      class LetterListFragment : Fragment() {
          //onCreateView() 호출 전까지 확장할 수 없으므로 null 허용
          //인스턴스가 만들어지는 시점(onCreate())와 속성을 실제로 사용할 수 있는 시점 사이에 기간이 있다.
          private var _binding: FragmentLetterListBinding? = null
          private val binding get() = _binding!!
          
          private lateinit var recyclerView: RecyclerView
          private var isLinearLayoutManager = true
      }
      ``````

      :key: `!!` : access할 때 값이 null이 아님을 확신하는 경우 type뒤에 추가한다.

      - `get()` : 속성이 'get-only'이다.

      ```````kotlin
      override fun onCreate(savedInstanceState: Bundle?) {
         	super.onCreate(savedInstanceState)
          // onCreate구현
         	setHasOptionsMenu(true)
      }
      
      override fun onCreateView(
         	inflater: LayoutInflater, container: ViewGroup?,
         	savedInstanceState: Bundle?
      ): View? {
          // 뷰 확장
         	_binding = FragmentLetterListBinding.inflate(inflater, container, false)
         	val view = binding.root // 루트뷰
         	return view
      }
      
      override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
          //binding클래스가 recyclerView속성을 만든다.
         	recyclerView = binding.recyclerView
         	chooseLayout()
      }
      
      override fun onDestroyView() {
         	super.onDestroyView()
        	//뷰가 더이상 없으므로 null로 재설정한다
         	_binding = null
      }
      
      override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
         	inflater.inflate(R.menu.layout_menu, menu)
      
         	val layoutButton = menu.findItem(R.id.action_switch_layout)
         	setIcon(layoutButton)
          // return이 필요하지 않다 (fragment)
      }
      ```````

      - activity : `menuInflater` 전역 속성 :o:
      - fragment : 메뉴 인플레이터가 대신 `onCreateOptionsMenu()`로 전달됨

      ``````kotlin
      private fun chooseLayout() {
         when (isLinearLayoutManager) {
             true -> {
                 recyclerView.layoutManager = LinearLayoutManager(context)
                 recyclerView.adapter = LetterAdapter()
             }
             false -> {
                 recyclerView.layoutManager = GridLayoutManager(context, 4)
                 recyclerView.adapter = LetterAdapter()
             }
         }
      }
      
      private fun setIcon(menuItem: MenuItem?) {
         if (menuItem == null)
             return
      
         menuItem.icon =
             if (isLinearLayoutManager)
                 ContextCompat.getDrawable(this.requireContext(), R.drawable.ic_grid_layout)
             else ContextCompat.getDrawable(this.requireContext(), R.drawable.ic_linear_layout)
      }
      
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
      ``````

      - **fragment는 `Context`가 아니다**

        :arrow_forward: `this`를 레이아웃 관리자의 컨텍스트로 전달할 수 x

        ​	대신, `context`속성을 제공한다.

      ***

      2. WordListFragment 구현

      ``````kotlin
      class WordListFragment : Fragment() {
          companion object {
              const val LETTER ="letter"
              const val SEARCH_PREFIX = "https://www.google.com/search?q="
          }
      
          private var _binding: FragmentWordListBinding? = null
          private val binding get() = _binding!!
          private lateinit var recyclerView: RecyclerView
      
          override fun onCreate(savedInstanceState: Bundle?) {
              super.onCreate(savedInstanceState)
              setHasOptionsMenu(true)
          }
      
          override fun onCreateView(
              inflater: LayoutInflater, container: ViewGroup?,
              savedInstanceState: Bundle?
          ): View? {
              _binding = FragmentWordListBinding.inflate(inflater, container, false)
              return binding.root
          }
      
          override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
              recyclerView = binding.recyclerView
              
              //fragment는 intent에 직접 액세스할 수 없으므로 activity.intent를 사용하여 참조
              //activity가 수명주기 초기에 존재한다는 보장이 없으므로 onViewCreated에서 실행한다.
              val letterId = activity?.intent?.extras?.getString(LETTER).toString()
              recyclerView.layoutManager = LinearLayoutManager(requireContext())
              recyclerView.adapter = WordAdapter(letterId, requireContext())
      
              recyclerView.addItemDecoration(
                  DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
              )
          }
      
          override fun onDestroyView() {
              super.onDestroyView()
              _binding = null
          }
      }
      ``````

***

- **Jectpack 탐색 구성요소**

  : 탐색, 특히 프래그먼트 간 탐색을 구현하기 위한 도구 모음

  - **탐색 그래프(NavGraph)**
    - 앱에서 탐색을 시각적으로 보여주는 XML 파일
    - 파일은 개별 활동 및 프래그먼트에 상응하는 *대상*과 한 대상에서 다른 대상으로 이동하려고 코드에서 사용할 수 있는 대상 사이의 작업으로 구성
    - 레이아웃 파일과 마찬가지로 Android 스튜디오는 탐색 그래프에 대상과 작업을 추가하는 *시각적 편집기*를 제공
  - **NavHost**
    - `NavHost`는 활동 내에서 탐색 그래프의 대상을 표시하는 데 사용
    - 프래그먼트 간에 이동하면 `NavHost`에 표시되는 대상이 업데이트된다.
    - `MainActivity`에서 `NavHostFragment`라는 기본 제공 구현을 사용
  - **NavController**
    - `NavController` 객체를 사용하면 `NavHost`에 표시되는 대상 간 탐색을 제어할 수 있다.
    - 탐색 구성요소를 사용하면 `NavController`의 `navigate()` 메서드를 호출하여 표시되는 프래그먼트를 교체할 수 있다.
    - `NavController`를 사용하면 시스템 '위로' 버튼에 응답하여 이전에 표시된 프래그먼트로 다시 이동하는 것과 같은 일반적인 작업을 처리할 수도 있다.

  ***

  - **Safe Args 플러그인**

    : 프래그먼트 간에 데이터를 전달할 떄 유형 안전성을 지원하는 Gradle 플러그인

  ***

  - **탐색 그래프 사용**

    : 앱 탐색의 가상 매핑

    - 프래그먼트(화면)​ :arrow_forward: 이동할 수 있는 가능한 '대상'

    - `NavGraph` : 각 대상이 서로 관련되는 방식을 보여주는 XML파일로 나타낼 수 있다.

    ``````kotlin
    <!--
    FragmentContainerView : 프래그먼트의 NaveHost 역할
    앱의 모든 탐색은 FragmentContainerView 내에서 실행된다.
    -->
    
    <androidx.fragment.app.FragmentContainerView
            android:id="@+id/nav_host_fragment"
            android:name="androidx.navigation.fragment.NavHostFragment"
            app:defaultNavHost="true"
            app:navGraph="@navigation/nav_graph"
            android:layout_width="match_parent"
            android:layout_height="match_parent" />
    ``````

    ```````kotlin
    //탐색 작업 검색
    val action = LetterListFragmentDirections.actionLetterListFragmentToWordListFragment(letter = holder.button.text.toString())
    //작업 전달
    holder.view.findNavController().navigate(action)
    ```````

    ``````kotlin
    class MainActivity : AppCompatActivity() {
        private lateinit var navController: NavController
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
    
            val binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)
    
            val navHostFragment = supportFragmentManager
                .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
            navController = navHostFragment.navController
            //navController 전달, 앱 바 버튼이 표시된다.
            setupActionBarWithNavController(navController)
        }
    
        //위로 버튼 처리
        override fun onSupportNavigateUp(): Boolean {
            return navController.navigateUp() || super.onSupportNavigateUp()
        }
    }
    ``````

    ``````kotlin
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    
        //let을 호출하여 람다를 전달 (arguments가 null이면 람다는 실행되지 않는다.)
        arguments?.let {
            letterId = it.getString(LETTER).toString()
        }
    }
    ``````

  

***



##### :rocket: Quiz

1. True or False: `onCreateView()` is only called once for a fragment’s entire lifecycle.
   - False



2. Which of the following is a benefit of using fragments?
   - All of the above
     - Navigation between fragments allows for more sophisticated user interface patterns, such as tab bars.
     - Using multiple fragments within an activity allows for an adaptive layout across multiple screen sizes.
     - The same fragments can be reused across multiple activities.



3. In the fragment lifecycle, which of the following tasks should be performed in `onViewCreated()`?
   - Binding view objects to properties in your fragment
   - Setting properties of individual views, such as a recycler view’s adapter



4. In the fragment lifecycle, which of the following tasks should be performed in `onCreateView()`?
   - Inflating the layout



5. 빈 칸 채우기

   *단어를 하나 이상 입력하여 문장을 완성하세요.*

   The `onSupportNavigateUp()` method needs to be overridden in the host activity to ensure your app’s fragment-based navigation responds to the app’s "Up" button.



6. Given the code for navigating between two fragments in a note-taking app, a list of books and a list of notes, which of the following is true about the navigation graph file?

   ``````kotlin
   val action = BooksListFragmentsDirections.actionBooksListToNotesList(bookIndex = index)
   holder.view.findNavController().navigate(action)
   ``````

   - E: Only A and C are true.
     - A: Both the books list and notes list are destinations.
     - C: There’s an action defined on the navigation graph that goes from the books list to the notes list.