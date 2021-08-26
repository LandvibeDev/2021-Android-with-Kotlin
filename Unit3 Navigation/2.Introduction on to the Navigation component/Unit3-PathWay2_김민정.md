## 2021 Landvibe Summer Coding - Android

### 🔎 Android Basics In Kotlin

#### 📌 Unit3: Navigation

#### 📌 PathWay2: Introduction to the Navigation component

<hr>

##### 프래그먼트

: 재사용 가능한 UI의 부분

👉🏻 수명주기 O / 사용자 입력에 응답 O

👉🏻 프래그머트 `수명주기`

- INITIALIZED: 프래그먼트의 새 인스턴스가 인스턴스화되었습니다.
- CREATED: 첫 번째 프래그먼트 수명 주기 메서드가 호출됩니다. 이 상태에서 프래그먼트와 연결된 뷰도 만들어집니다.
- STARTED: 프래그먼트가 화면에 표시되지만 '포커스'가 없으므로 사용자 입력에 응답할 수 없습니다.
- RESUMED: 프래그먼트가 표시되고 포커스가 있습니다.
- DESTROYED: 프래그먼트 객체의 인스턴스화가 취소되었습니다.

👉🏻 프래그먼트 `클래스`

- `onCreate()`: 프래그먼트가 인스턴스화되었고 `CREATED` 상태입니다. 그러나 이에 상응하는 뷰가 아직 만들어지지 않았습니다.
- `onCreateView()`: 이 메서드에서 레이아웃을 확장합니다. 프래그먼트가 `CREATED` 상태로 전환되었습니다.
- `onViewCreated()`: 뷰가 만들어진 후 호출됩니다. 이 메서드에서 일반적으로 `findViewById()`를 호출하여 특정 뷰를 속성에 바인딩합니다.
- `onStart()`: 프래그먼트가 `STARTED` 상태로 전환되었습니다.
- `onResume()`: 프래그먼트가 `RESUMED` 상태로 전환되었고 이제 포커스를 보유합니다(사용자 입력에 응답할 수 있음).
- `onPause()`: 프래그먼트가 `STARTED` 상태로 다시 전환되었습니다. UI가 사용자에게 표시됩니다.
- `onStop()`: 프래그먼트가 `CREATED` 상태로 다시 전환되었습니다. 객체가 인스턴스화되었지만 더 이상 화면에 표시되지 않습니다.
- `onDestroyView()`: 프래그먼트가 `DESTROYED` 상태로 전환되기 직전에 호출됩니다. 뷰는 메모리에서 이미 삭제되었지만 프래그먼트 객체는 여전히 있습니다.
- `onDestroy()`: 프래그먼트가 `DESTROYED` 상태로 전환됩니다.

<img src="img/Unit3-Pathway2-1_minjeong.png" height="500">

🚨 `onCreate()` 메서드의 차이에 유의!

: 활동에서는 이 메서드를 사용하여 레이아웃을 확장하고 뷰를 바인딩함. But 프래그먼트 수명 주기에서 `onCreate()`는 뷰가 만들어지기 전에 호출되므로 여기서 레이아웃을 확장할 수 X

대신 `onCreateView()`에서 확장! 그런 다음 뷰를 만든 후 `onViewCreated()` 메서드가 호출되고 여기서 속성을 특정 뷰에 바인딩



##### 구현

1. null을 허용하는 `FragmentLetterListBinding` 참조를 가져오기
2. 바인딩 클래스는 **build.gradle** 파일의 `buildFeatures` 섹션에서 `viewBinding` 속성이 사용 설정될 때 Android 스튜디오에서 각 레이아웃 파일에 생성됨
3. `FragmentLetterListBinding`의 각 뷰에 프래그먼트 클래스의 속성을 할당

👉🏻 유형: `FragmentLetterListBinding?`

👉🏻 초깃값: null

🚨 프래그먼트의 뷰는 프래그먼트의 수명 주기 동안 여러 번 만들어지고 소멸될 수 있다는 사실!

: 다른 수명 주기 메서드 `onDestroyView()`에서도 값을 재설정



##### 탐색 구성요소

1. 탐색 그래프: 탐색 그래프는 앱에서 탐색을 시각적으로 보여주는 XML 파일

   > 파일은 개별 활동 및 프래그먼트에 상응하는 *대상*과 한 대상에서 다른 대상으로 이동하려고 코드에서 사용할 수 있는 대상 사이의 작업으로 구성
   >
   > 레이아웃 파일과 마찬가지로 Android 스튜디오는 탐색 그래프에 대상과 작업을 추가하는 시각적 편집기를 제공

2. `NavHost`:  활동 내에서 탐색 그래프의 대상을 표시

   > 프래그먼트 간에 이동하면 `NavHost`에 표시되는 대상이 업데이트됨
   >
   > `MainActivity`에서 `NavHostFragment`라는 기본 제공 구현을 사용

3. `NavController`: `NavController` 객체를 사용하면 `NavHost`에 표시되는 대상 간 탐색을 제어

   > `NavController`의 `navigate()` 메서드를 호출하여 표시되는 프래그먼트를 교체가능
   >
   > `NavController`를 사용하면 시스템 '위로' 버튼에 응답하여 이전에 표시된 프래그먼트로 다시 이동하는 것과 같은 일반적인 작업을 처리 가능

👉🏻 Safe Args 플러그인

: 프래그먼트 간에 데이터를 전달할 때 유형 안전성을 지원하는 Gradle 플러그인인 **Safe Args**라는 항목도 추가



##### 탐색그래프(NavGraph)

: 앱 탐색의 가상 매핑/각 프래그먼트는 이동할 수 있는 가능한 대상/각 대상이 서로 관련되는 방식을 보여주는 XML 파일로 나타낼 수 있음!

👉🏻 대상? `FragmentContainerView`로 사용자에게 표시

 

📌 [솔루션 코드](https://github.com/google-developer-training/android-basics-kotlin-words-app/tree/main)



##### 퀴즈

1. True or False: `onCreateView()` is only called once for a fragment’s entire lifecycle.

   > False

2. Which of the following is a benefit of using fragments?

   > Navigation between fragments allows for more sophisticated user interface patterns, such as tab bars.

   > Using multiple fragments within an activity allows for an adaptive layout across multiple screen sizes.

   > The same fragments can be reused across multiple activities.

3. In the fragment lifecycle, which of the following tasks should be performed in `onViewCreated()`?

   > Binding view objects to properties in your fragment

   > Setting properties of individual views, such as a recycler view’s adapter

4. In the fragment lifecycle, which of the following tasks should be performed in `onCreateView()`?

   > Inflating the layout

5. 빈 칸 채우기

   The `  onSuppoertNavigateUp`method needs to be overridden in the host activity to ensure your app’s fragment-based navigation responds to the app’s "Up" button.

6. Given the code for navigating between two fragments in a note-taking app, a list of books and a list of notes, which of the following is true about the navigation graph file?

   ```kotlin
   val action = BooksListFragmentsDirections.actionBooksListToNotesList(bookIndex = index)
   holder.view.findNavController().navigate(action)
   ```

   > Both the books list and notes list are destinations.

   > There’s an action defined on the navigation graph that goes from the books list to the notes list.