

# 2021 Landvibe Summer Coding - Android



## Unit3 : Navigation

## PathWay2 : Introduction to the Navigation component



### Android Jetpack : Introducing Navigation Component

- **Navigation Component**
  - A collection of libraries, a plugin and tooling for unifying and simplifying Android Navigation. (라이브러리, 플러그인 그리고 툴을 모아놓은 것으로 Android 탐색을 단순화 한 것)
  - **Benefits**
    - Simplified setup for common navigation patterns 
    - Handles backstack 
    - Automates fragment transactions
    - Type safe argument passing
    - Handles transition animations
    - Simplified deep linking
    - Centralizes and visualizes navigation
  - **SafeArgs Plugin**
    - Generates classes based off of your navigation graph to ensure type-safe access to arguments for destinations and actions. (코드를 생성해서 안전한 유형의 탐색과 인수 전달을 할 수 있게 해 줌.)

### Fragments and the Navigation component

- **Fragments**

  - a reusable piece of UI
  - Fragments can be reused and embedded in one or more activities

- **Fragment lifecycle**

  - INITIALIZED : A new instance of the fragment has been instantiated (프래그먼트의 새 인스턴스가 인스턴스화됨.)
  - CREATED : The first fragment lifecycle methods are called. During this state, the view associated with the fragment is also created. (첫 번째 프래그먼트 수명주기 메서드가 호출됨. 이 상태에서 프래그먼트와 연결된 뷰도 만들어짐.)
  - STARTED : The fragment is visible onscreen but does not have "focus", meaning it can't respond to user input (프래그먼트가 화면에 표시되지만 '포커스'가 없으므로 사용자 입력에 응답할 수 없음.')
  - RESUMED : The fragment is visible and has focus. (프래그먼트가 표시되고 포커스가 있음.)
  - DESTROYED : The fragment object has been de-instantiated. (프래그먼트 객체의 인스턴스화가 취소됨.)

- **Method**

  - `onCreated()`: The fragment has been instantiated and is in the `CREATED` state. However, **it's corresponding view has not been created yet.**

  - `onCreateView()` : This method is where **you inflate the layout**. The fragment has entered the `CREATED` state.

  - `onViewCreated()` : This is called after the view is created. In this method, you would typically bind specific views to properties by calling `findViewById()`.

  - `onStart()` : The fragment has entered the `STARTED` state.

  - `onResume()` : The fragment has entered the `RESUME` state and now has focus(can respond to user input).

  - `onPasue()` : The fragment has re-entered the `STARTED` state. The UI is visible to the user

  - `onStop()` : The fragment has re-entered the `CREATED` state. The object is instantiated but is no longer presented on screen.

  - `onDestroyView()` : Called right before the fragment enters the `DESTROYED` state. The view has already been removed from memory, but the fragment object still exists.

  - `onDestroy()` : The fragment enters the `DESTROY` state.

    <img src="img\Unit3-Pathway2-1_장유진.png" style="zoom:70%;" />

- **Navigation Component**

  - Setting the `navGraph` attribute of a `FragmentContainerView` allows you to navigate between fragments within an activity. (`FragmentContainerView`의 `navGraph` 속성을 설정하면 활동 내에서 프래그먼트 간에 이동할 수 있다.)
  - The `NavGraph` editor allows you to add navigation actions and specify arguments between different destinations.(`NavGraph` 편집기를 사용하면 탐색 작업을 추가하고 다양한 대상 간에 인수를 저장할 수 있다.)
  - While navigating using  intents requires you to pass in extras, the Navigation component uses SafeArgs to auto-generate classes and methods for your navigation actions, ensuring type safety with arguments.

### Navigation : Overview - MAD Skills

- **Navigation Component**
- 앱 내에서 탐색 흐름을 만들고 수정하기 위한 도구이자 API임
- `NavHostFragment`:point_right: Container for destinations (활동을 통해 탐색할 떄 대체되는 프래그먼트를 담는 컨테이너)
- `NavController` :point_right: Conducts navigation (탐색 구성요소의 내부 요소로 실제로 탐색 작업을 함)
- `NavigationView` :point_right: Menu for DrawerLayout (탐색구성요소 전에 존재했으며 탐색 창 내에 있는 메뉴와 관련이 있음 / 탐색 구성요소의 일부가 아님.)
- `NavigationUI` :point_right: Updates content outside NavHostFragment (탐색 구성요소 라이브러리에서 NavHostFragment 외부 콘텐츠 업데이트를 책임짐.)


### Quiz

1. **True of False : `onCreateView()` is only called once for a fragment's entire lifecycle**

   --> False
   
2. **Which of the following is a benefit of using fragments?**

   -->Navigation between fragments allows for more sophisticated user interface patterns, such as tab bars.
   
   --> Using multiple fragments within an activity allows for an adaptive layout across multiple screen sizes.
   
   --> The same fragments can be reused across multiple activities.

3. **In the fragment lifecycle, which of the following tasks should be performed in `onViewCreated()`**

   --> Binding view objects to properties in your fragment

   --> Setting properties of individual views, such as a recycler view's adapter

4. **In the fragment lifecycle, which of the following tasks should be performed in `onCreateView()` ** 

   --> Inflating the layout

5. **빈칸 채우기**

   **The ___ method needs to be overridden in the host activity to ensure your app's fragment-based navigation responds to the app's "Up" button.**

   --> `onSupportNavigateUp()`

   :pencil: `onSupportNavigateUp()` method is called whenever the user chooses to navigate Up within your application's activity hierarchy from the action bar.

   :pencil: Fragment에서 뒤로가기 버튼 동작하게 만들기 위해서 `onSupportNavigateUp()` method를 사용한다.

6. **Given the code for navigating between two fragments in a note-taking app, a list of books and a list of notes, which of the following is true about the navigation graph file?**

   ```kotlin
   val action = BooksListFragmentsDirections.actionBooksListToNotesList(bookIndex = index)
   holder.view.findNavController().navigate(action)
   ```

   --> Both the books list and notes list are destinations

   --> There's an action defined on the navigation graph that goes from the books list to the notes list.

   :question: 'The books list fragment has an argument called `bookIndex`.' 라는 문장은 왜 틀린것인가?

   :point_right: action을 처리하는 곳은 Notes List fragment 이므로 위 문장이 틀렸다.
   
   
   
   :question: 'Both the books list and notes list are destinations' 라는 문장에서 "books list --> notes list 방향"으로 판단하였는데 둘 다 왔다갔다가 가능하므로 모두 destinations이라고 표현하는 것인가..?
   
   :point_right: 뒤로 가기 버튼을 통해서 뒤로 돌아갈 수 있으므로 모두 destinations이 될 수 있다!
