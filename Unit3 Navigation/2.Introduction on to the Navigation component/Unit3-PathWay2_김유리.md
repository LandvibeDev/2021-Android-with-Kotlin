# 2021 Landvibe Summer Coding - Android

## Unit3 - Navigation

## PathWay2 - Introduction to the Navigation component

#### 프래그먼트 및 탐색 구성요소

##### &#128204;프래그먼트 및 프래그먼트 수명 주기

- 프래그먼트

  - 앱의 사용자 인터페이스에서 재사용 가능한 부분
  - 각 프래그먼트는 별도의 자체 수명주기가 있고 사용자 입력에 응답할 수 있음
  - 활동이 화면에 표시될 때 활동의 뷰 계층 구조 내에 항상 포함됨
  - 재사용성과 모듈성을 강조하므로 단일 활동에서 여러 프래그먼트 동시 호스팅 가능

- 프래그먼트 수명 주기

  - 열거형

    - INITIALIZED: 프래그먼트의 새 인스턴스가 인스턴스화 됨
    - CREATED: 첫 번째 프래그먼트 수명 주기 메서드 호출, 이 상태에서 프래그먼트와 연결된 뷰도 만들어짐
    - STARTED: 프래그먼트가 화면에 표시되지만 '포커스'가 없으므로 사용자 입력에 응답할 수 없음
    - RESUMED: 프래그먼트가 표시되고 포커스가 있음
    - DESTROYED: 프래그먼트 객체의 인스턴스화가 취소됨

  - 재정의 메서드

    - `onCreate()`: 프래그먼트가 인스턴스화되었고 `CREATED` 상태지만 이에 상응하는 뷰가 아직 만들어지지 않음
    - `onCreateView()`: 레이아웃을 확장, 프래그먼트가 `CREATED` 상태로 전환
    - `onViewCreated()`: 뷰가 만들어진 후 호출, 일반적으로 `findViewById()`를 호출하여 특정 뷰를 속성에 바인딩
    - `onStart()`: 프래그먼트가 `STARTED` 상태로 전환
    - `onResume()`: 프래그먼트가 `RESUMED` 상태로 전환하고 포커스를 보유
    - `onPause()`: 프래그먼트가 `STARTED` 상태로 다시 전환, UI가 사용자에게 표시됨
    - `onStop()`: 프래그먼트가 `CREATED` 상태로 다시 전환, 객체가 인스턴스화되었지만 더 이상 화면에 표시되지 않음
    - `onDestroyView()`: 프래그먼트가 `DESTROYED` 상태로 전환되기 직전에 호출됨, 뷰는 메모리에서 이미 삭제되었지만 프래그먼트 객체는 여전히 존재
    - `onDestroy()`: 프래그먼트가 `DESTROYED` 상태로 전환

  - 수명 주기와 상태 간 전환 차트

    <img src="https://developer.android.com/codelabs/basic-android-kotlin-training-fragments-navigation-component/img/74470aacefa170bd.png" alt="74470aacefa170bd.png" style="zoom: 33%;" />

- 활동과 프래그먼트의 `onCreate()`메서드의 차이
  - 활동에서는 레이아웃을 확장하고 뷰를 바인딩
  - 프래그먼트에서는 뷰가 만들어지기 전에 호출돼 레이아웃 확장은 불가능, 대신 `onCreateView()`에서 확장



##### &#128204;프래그먼트 및 레이아웃 파일 만들기

- 프래그먼트 추가 : **app**선택한 상태에서 **File > New > Fragment > Fragment(Blank)**로 프래그먼트 추가 
  - 문자 목록 프래그먼트 `LetterListFragment`
  - 단어 목록 프래그먼트 `WordListFragment`
- 레이아웃 파일 업데이트
  - `activity_main.xml`의 콘텐츠를 `fragment_letter_list.xml`에 복사, `tools:context`를 `.LetterListFragment`로 변경
  - `activity_detail.xml`의 콘텐츠를 `fragment_word_list.xml`에 복사, `tools:context`를 `.WordListFragment`로 변경



##### &#128204;LetterListFragment 구현

- 레이아웃을 확장하고 개별 뷰 바인딩

  - `LetterListFragment`에서 뷰 바인딩 구현

    - null을 허용하는 `FragmentLetterListBinding` 참조 가져오기 :point_right: `onCreateView()`가 호출될 때까지 레이아웃을 확장할 수 없기 때문에 null을 허용
    - 바인딩 클래스는 **build.gradle**파일의 `buildFeatures`섹션에서 `viewBinding`속성이 사용 설정될 때 각 레이아웃 파일에 생성됨
    - `LetterListFragment`의 인스턴스가 만들어지는 시점과 이 속성을 실제로 사용할 수 있는 시점 사이의 기간과 프래그먼트 뷰는 수명 주기 동안 여러 번 만들어지고 소멸될 수 있으므로 `onDestroyView()`에서도 값을 재설정 해줘야 함

  - `LetterListFragment` 설정

    1. `LetterListFragment.kt` 업데이트

       ```kotlin
       private var _binding: FragmentLetterListBinding? = null
       ```

       - null이 아님을 확신하는 경우 유형 이름에 `!!`를 추가
       - 속성 이름 앞 밑줄은 속성에 직접 액세스하지 못하도록 하기 위함임

    2. binding이라는 새 속성 생성

       ```kotlin
       private val binding get() = _binding!!
       ```

       - `get()` : 값을 가져올 수 있지만 할당디고 나면 다른 것에 할당할 수 없음

    3. `onCreate()` 업데이트

       ```kotlin
       override fun onCreate(savedInstanceState: Bundle?) {
       	super.onCreate(savedInstanceState)
       	setHasOptionsMenu(true)
       }
       ```

    4. `onCreateView()` 구현

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

    5. `binding` 속성 아래에 recycler 뷰 속성 생성

       ```kotlin
       private lateinit var recyclerView: RecyclerView
       ```

    6. `onViewCreated()` 업데이트

       ```kotlin
       override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
       	recyclerView = binding.recyclerView
       	chooseLayout()
       }
       ```

    7. `onDestroyView()`에서 뷰가 더이상 없으므로 `_binding`속성을 `null`로 재설정

    8. 메뉴 인플레이터 대신 `onCreateOptionsMenu()`로 전달되는데 이 메서드에는 return문이 필요하지 않음

       ```kotlin
       override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
          inflater.inflate(R.menu.layout_menu, menu)
       
          val layoutButton = menu.findItem(R.id.action_switch_layout)
          setIcon(layoutButton)
       }
       ```

    9. `MainActivity` 메서드 가져오기

       ```kotlin
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
       ```

       - 프래그먼트는 활동과 달리 `Context`가 아니고 `this`(프래그먼트 객체 참고)를 레이아웃 관리자의 컨텍스트로 전달할 수 없음
       - 프래그먼트는 대신 사용할 수 있는 `context`속성 제공

    10. `MainActivity`에서 `isLinearLayoutManager`속성을 복사해 `recyclerView`속성 바로 아래에 배치

        ```kotlin
        private var isLinearLayoutManager = true
        ```

    11. 프래그먼트가 뷰에 표시되도록 레이아웃 확장 - `onCreate()`와 다음 내용만 남김

        ```kotlin
        override fun onCreate(savedInstanceState: Bundle?) {
           super.onCreate(savedInstanceState)
        
           val binding = ActivityMainBinding.inflate(layoutInflater)
           setContentView(binding.root)
        }
        ```

    12. `DetailActivity`이전 작업도 수행

        

##### &#128204;DetailActivity를 WordListFragment로 변환

1. 컴패니언 객체를 `WordListFragment`로 복사

2. 인텐트를 실행하는 `LetterAdapter`의 `onClickListener()`에서 `putExtra()`호출을 업데이트 ( DetailActivity -> WordListFragment )

3. `WordAdapter`에서 `onClickListener()`를 업데이트 ( DetailActivity -> WordListFragment )

4. `WordListFragment`에 `LetterListFragment`와 같이  `_binding`과 `binding`속성 추가 및 `onCreateView()`업데이트

5. `onViewCreated()`에서 프래그먼트는 인텐트에 직접 액세스할 수 없으므로 `activity.intent`를 사용해 참조

6. `onDestroyView()`에서 `_binding`변수 재설정

7. `DetailActivity`와 `activity_detail.xml`삭제

8. `AndroidManifest.xml`에서 다음을 삭제

   ```kotlin
   <activity
      android:name=".DetailActivity"
      android:parentActivityName=".MainActivity" />
   ```



##### &#128204;Jetpack 탐색 구성요소

- 탐색 구성요소
  - 탐색 그래프 
    - 앱에서 탐색을 시각적으로 보여주는 xml 파일
    - 파일은 개별 활동 및 프래그먼트에 상응하는 *대상*과 한 대상에서 다른 대상으로 이동하려고 코드에서 사용할 수 있는 대상 사이의 작업으로 구성됨
    - Android 스튜디오는 시각적 편집기를 제공
  - `NavHost` 
    - 활동 내에서 탐색 그래프의 대상을 표시하는 데 사용됨
    - 프래그먼트 간에 이동하면 `NavHost`에 표시되는 대상이 업데이트됨
  - `NavController` 
    - 해당 객체를 사용하면 `NavHost`에 표시되는 대상 간 탐색을 제어할 수 있음
    - `navigate()`메서드를 호출하여 표시되는 프래그먼트 교체 가능
    - 시스템 '위로' 버튼에 응답하여 이전에 표시된 프래그먼트로 다시 이동하는 것과 같은 일반적인 작업을 처리할 수 있음
  
- 탐색 종속 항목

  1. 프로젝트 수준 `build.gradle` 파일 설정

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
     ```

  2. 앱 수준 `build.gradle`파일에서 종속 항목 그룹에 다음을 추가

     ```kotlin
     implementation "androidx.navigation:navigation-fragment-ktx:$nav_version"
     implementation "androidx.navigation:navigation-ui-ktx:$nav_version"
     ```

- Safe Args 플러그인

  - Safe Args : 프래그먼트 간에 데이터를 전달할 때 유형 안전성을 지원하는 Gradle 플러그인

  - 프로젝트에 Safe Args 통합

    1. 최상위 `build.gradle`파일의 **buildscript > dependencies**에서 다음 클래스 경로 추가

       ```kotlin
       classpath "androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version"
       ```

    2. 앱 수준 `build.gradle`파일의 상단에 있는 `plugins`에 다음 내용 추가

       ```kotlin
       plugins {
           id 'com.android.application'
           id 'kotlin-android'
           id 'kotlin-kapt'
           id 'androidx.navigation.safeargs.kotlin'
       }
       ```

    3. **Sync Now**를 클릭해 프로젝트 동기화



##### &#128204;탐색 그래프 사용

- 탐색 그래프 : 앱 탐색의 가상 매핑으로 프래그먼트 간 탐색을 구현하는 데 도움이 되는 새로운 시각적인 편집기를 의미함

- MainActivity에서 FragmentContainerView 사용

  1. `activity_main.xml`의 `FrameLayout` 콘텐츠를 `FragmentContainerView`로 변경, 
  2. `name`속성을 `androidx.navigation.fragment.NavHostFragment`로 설정해 `FragmentContainerView`가 프래그먼트 간 이동이 가능케 함
  3. `app:navHost`속성을 추가하고 `"true"`로 설정 - 프래그먼트 컨테이너가 탐색 계층 구조와 상호작용할 수 있게 해줌
  4. `app:navGraph` 속성을 추가하고 `"@navigation/nav_graph"`로 설정 - 앱의 프래그먼트가 서로 이동할 수 있는 방법을 정의하는 XML파일을 가리킴
  5. `FrameLayout`에 `xmls:app`속성 추가

- 탐색 그래프 설정

  - 탐색 그래프 파일 추가
    - 파일 이름 : `nav_graph.xml` , `app:navGraph` 
    - 리소스 유형 : Navigation - Directory Name이 탐색으로 자동 변경됨

- 탐색 작업 만들기

  - `letterListFragment` 대상 위로 마우스를 가져가서 오른쪽에 표시되는 원에서 `wordListFragment` 대상으로 드래그

- WordListFragment의 인수 지정

  - `LetterAdapter`에서 버튼의 `onClickListener()` 내용 삭제 후 다음 추가

  ```kotlin
  val action = LetterListFragmentDirections.actionLetterListFragmentToWordListFragment(letter = holder.button.text.toString())
  ```

- MainActivity 구성

  1. `navController`속성 생성

     ```kotlin
     private lateinit var navController: NavController
     ```

  2. `onCreate()`에서 `onContentView()`호출 후 `navController`속성에 `nav_host_fragment`참조 할당

  3. `onSupportNavigationUp()`구현 - 위로 버튼을 처리할 수 있음

     ```kotlin
     override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
     }
     ```



##### &#128204;WordListFragment에서 인수 가져오기

- 안전 인수 액세스

  1. `WordListFragment`에서 `letterId`속성 생성

     ```kotlin
     private lateinit var letterId: String
     ```

  2. `onCreate()`재정의 후 다음 추가

     ```kotlin
     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
     
         arguments?.let {
             letterId = it.getString(LETTER).toString()
         }
     }
     ```

     - `let()` 을 호출해 람다를 전달

  3. ```kotlin
     recyclerView.adapter = WordAdapter(letterId, requireContext())
     ```

     

##### &#128204;프래그먼트 라벨 업데이트

1. `strings.xml`에서 앱 이름 뒤에 다음 추가

   ```kotlin
   <string name="word_list_fragment_label">Words That Start With {letter}</string>
   ```

2. 탐색 그래프에서 각 프래그먼트의 라벨 설정

   

#### &#128204;Quiz

1. `onCreateView()`는 프래그먼트의 전체 수명 주기 동안 여러번 호출될 수 있다.

2. 프래그먼트 사용의 이점

   -  프래그먼트 간 탐색을 통해 더 정교한 사용자 인터페이스 패턴을 사용할 수 있음
   - 활동 내에서 여러 프래그먼트를 사용하면 여러 화면 크기에서 적응형 레이아웃이 가능함
   - 동일한 프래그먼트를 여러 활동에서 재사용 가능

3. 프래그먼트 수명 주기에서 `onViewCreated()`다음에 수행되는 것

   - 프래그먼트의 속성에 뷰 객체 바인딩
   - 리사이클러 보기의 어댑터와 같은 개별 보기의 속성 설정

4. 프래그먼트 수명 주기에서 `onCreateView()`다음에 수행되는 것

   - 레이아웃 확장

5. 앱 프래그먼트 기반 탐색이 앱의 "위로" 버튼에 응답하도록 하려면 호스트 활동에서 `onSupportNavigationUP`메서드를 재정의해야 함

6. ```kotlin
   val action = BooksListFragmentsDirections.actionBooksListToNotesList(bookIndex = index)
   holder.view.findNavController().navigate(action)
   ```

   - 책 목록과 메모 목록 모두 대상
   - 책 목록에서 메모 목록으로 이동하는 탐색 그래프에 정의된 작업이 있음

