# π‘ Android Basics in Kotlin

## Unit #3 : Navigation

## PATHWAY #2 : Introduction to the Navigation component

<br/>

## π©π»βπ» νλκ·Έλ¨ΌνΈ & νμ κ΅¬μ±μμ

#### π νλκ·Έλ¨ΌνΈ

- μ¬μ¬μ© κ°λ₯ν UIμ λΆλΆ
- νλμ UI λ΄μμ λλ¦½μ μΌλ‘ λμνλ νλ©΄ λΆλΆμ λ§λ€κ³  μΆμ λ μ¬μ©νλ€. νλμ λ·° κ³μΈ΅ κ΅¬μ‘° λ΄μ ν­μ ν¬ν¨, λμμ νΈμ€ν κ°λ₯.
- νλκ³Ό λ§μ°¬κ°μ§λ‘, μ΄κΈ°νλκ³  λ©λͺ¨λ¦¬μμ μ­μ λ  μ μμΌλ©° μ‘΄μ¬νλ λμ νλ©΄μ νμλμλ€κ° μ¬λΌμ§κ³  λ€μ νμλ  μ μλ€.

<br/>

#### π νλκ·Έλ¨ΌνΈ μλͺμ£ΌκΈ°

- κ° νλκ·Έλ¨ΌνΈλ λ³λμ μμ²΄ μλͺμ£ΌκΈ° κ΄λ¦¬

- λ€μ― κ°μ§ μν
  - `INITIALIZED`: νλκ·Έλ¨ΌνΈμ μ μΈμ€ν΄μ€κ° μΈμ€ν΄μ€νλμμ΅λλ€.
  - `CREATED`: μ²« λ²μ§Έ νλκ·Έλ¨ΌνΈ μλͺ μ£ΌκΈ° λ©μλκ° νΈμΆλ©λλ€. μ΄ μνμμ νλκ·Έλ¨ΌνΈμ μ°κ²°λ λ·°λ λ§λ€μ΄μ§λλ€.
  - `STARTED`: νλκ·Έλ¨ΌνΈκ° νλ©΄μ νμλμ§λ§ 'ν¬μ»€μ€'κ° μμΌλ―λ‘ μ¬μ©μ μλ ₯μ μλ΅ν  μ μμ΅λλ€.
  - `RESUMED`: νλκ·Έλ¨ΌνΈκ° νμλκ³  ν¬μ»€μ€κ° μμ΅λλ€.
  - `DESTROYED`: νλκ·Έλ¨ΌνΈ κ°μ²΄μ μΈμ€ν΄μ€νκ° μ·¨μλμμ΅λλ€.
- λ©μλ
  - `onCreate()`: νλκ·Έλ¨ΌνΈκ° μΈμ€ν΄μ€νλμκ³  `CREATED` μνμλλ€. κ·Έλ¬λ μ΄μ μμνλ λ·°κ° μμ§ λ§λ€μ΄μ§μ§ μμμ΅λλ€.
  - `onCreateView()`: μ΄ λ©μλμμ λ μ΄μμμ νμ₯ν©λλ€. νλκ·Έλ¨ΌνΈκ° `CREATED` μνλ‘ μ νλμμ΅λλ€.
  - `onViewCreated()`: λ·°κ° λ§λ€μ΄μ§ ν νΈμΆλ©λλ€. μ΄ λ©μλμμ μΌλ°μ μΌλ‘ `findViewById()`λ₯Ό νΈμΆνμ¬ νΉμ  λ·°λ₯Ό μμ±μ λ°μΈλ©ν©λλ€.
  - `onStart()`: νλκ·Έλ¨ΌνΈκ° `STARTED` μνλ‘ μ νλμμ΅λλ€.
  - `onResume()`: νλκ·Έλ¨ΌνΈκ° `RESUMED` μνλ‘ μ νλμκ³  μ΄μ  ν¬μ»€μ€λ₯Ό λ³΄μ ν©λλ€(μ¬μ©μ μλ ₯μ μλ΅ν  μ μμ).
  - `onPause()`: νλκ·Έλ¨ΌνΈκ° `STARTED` μνλ‘ λ€μ μ νλμμ΅λλ€. UIκ° μ¬μ©μμκ² νμλ©λλ€.
  - `onStop()`: νλκ·Έλ¨ΌνΈκ° `CREATED` μνλ‘ λ€μ μ νλμμ΅λλ€. κ°μ²΄κ° μΈμ€ν΄μ€νλμμ§λ§ λ μ΄μ νλ©΄μ νμλμ§ μμ΅λλ€.
  - `onDestroyView()`: νλκ·Έλ¨ΌνΈκ° `DESTROYED` μνλ‘ μ νλκΈ° μ§μ μ νΈμΆλ©λλ€. λ·°λ λ©λͺ¨λ¦¬μμ μ΄λ―Έ μ­μ λμμ§λ§ νλκ·Έλ¨ΌνΈ κ°μ²΄λ μ¬μ ν μμ΅λλ€.
  - `onDestroy()`: νλκ·Έλ¨ΌνΈκ° `DESTROYED` μνλ‘ μ νλ©λλ€.

- βοΈ νλκ³Ό νλκ·Έλ¨ΌνΈ μ°¨μ΄λ? : νλμμλ `onCreate()` μ¬μ©νμ¬ λ μ΄μμ νμ₯νκ³  λ·°λ₯Ό λ°μΈλ©νμ§λ§, νλκ·Έλ¨ΌνΈ μλͺ μ£ΌκΈ°μμ `onCreate()`λ λ·°κ° λ§λ€μ΄μ§κΈ° μ μ νΈμΆλλ―λ‘ μ¬κΈ°μ λ μ΄μμμ νμ₯ν  μ μλ€. λμ  `onCreateView()`μμ νμ₯νλ€.

<img src="img/3-2_1_jumin.png" width=50% height=50%>

<br/>

#### π νλκ·Έλ¨ΌνΈ μμ±

- `app` λλ₯Έ μνλ‘ `File > New > Fragment > Fragment(Blank)` νλ©΄ ν΄λμ€μ λ μ΄μμ νμΌμ΄ κ°κ° μμ±

- λ°μΈλ©

  ```kotlin
  private var _binding: FragmentLetterListBinding? = null
  private val binding get() = _binding!!
  ```

- `activity_main.xml` `activity_detail.xml` λ΄μ© λ³΅μ¬ν΄μ `fragment_,,,.xml`λ‘ μ΄λ 

- `MainActivity`, `DetailActivity`λ₯Ό `νλκ·Έλ¨ΌνΈ`λ‘ μ΄μ  

- νλκ·Έλ¨ΌνΈκ° λ·°μ νμλλλ‘ λ μ΄μμ νμ₯

- βοΈ μ£Όμμ  : νλκ·Έλ¨ΌνΈλ `Context`κ° μλλ€.`this`λ₯Ό λ μ΄μμ κ΄λ¦¬μμ μ»¨νμ€νΈλ‘ μ λ¬ λΆκ°λ₯. λμ  μ¬μ©ν  μ μλ `context` μμ± μ κ³΅λ¨. ( `this`->`this.requireContext()`λ‘ λ°κΏμ€. )

<br/>

#### π Jetpack νμ κ΅¬μ±μμ

- νμ κ΅¬μ±μμ : μ± λ΄μμ νμμ κ΅¬ννκ³  μμ νκΈ° μν λκ΅¬μ΄μ API

- νμ κ·Έλν(`NavGraph`) : μ±μμ νμμ μκ°μ μΌλ‘ λ³΄μ¬μ£Όλ XMLνμΌ. μ± νμμ κ°μ λ§€ν. κ°  νλ©΄(νλκ·Έλ¨ΌνΈ)λ μ΄λκ°λ₯ν λμμ΄ λλ€.

- `NavHost` : νλ λ΄μμ νμ κ·Έλνμ λμμ νμνλ λ° μ¬μ©λλ€.

- `NavController` : `NavController` κ°μ²΄λ₯Ό μ¬μ©νλ©΄ `NavHost`μ νμλλ λμ κ° νμμ μ μ΄ν  μ μλ€.  `navigate()` λ©μλλ₯Ό νΈμΆνμ¬ νμλλ νλκ·Έλ¨ΌνΈλ₯Ό κ΅μ²΄ν  μ μλ€. μμ€ν 'μλ‘' λ²νΌμ μλ΅νμ¬ μ΄μ μ νμλ νλκ·Έλ¨ΌνΈλ‘ λ€μ μ΄λνλ κ²κ³Ό κ°μ μΌλ°μ μΈ μμμ μ²λ¦¬ κ°λ₯νλ€.

- νμ μ’μ ν­λͺ©

  - `build.gradle(project)` > `buildscript` > `ext` 

    ```kotlin
     nav_version = "2.3.1"
    ```

  - `build.gradle(app)` 

    ```kotlin
    implementation "androidx.navigation:navigation-fragment-ktx:$nav_version"
    implementation "androidx.navigation:navigation-ui-ktx:$nav_version"
    ```

- Safe Args νλ¬κ·ΈμΈ

  - νλκ·Έλ¨ΌνΈ κ°μ λ°μ΄ν° μ λ¬ν  λ μ ν μμ μ±μ μ§μνλ νλ¬κ·ΈμΈ 

  - `build.gradle(project) > buildscript > dependencies`

    ```kotlin
    classpath "androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version"
    ```

  - `build.gradle(app) > plugins`

    ```kotlin
    id 'androidx.navigation.safeargs.kotlin'
    ```

<br/>

#### π νμ κ·Έλν μ¬μ©

- MainActivityμμ **FragmentContainerView** μ¬μ©

  - MainActivityμ μ©λλ₯Ό λ³κ²½νμ¬ νλκ·Έλ¨ΌνΈμ NavHost μ­ν μ ν  FragmentContainerViewλ₯Ό ν¬ν¨νλ€.

  - μ±μ λͺ¨λ  νμμ FragmentContainerViewλ΄μμ μ€νλλ€.

  - `activity_main.xml`μμ `RecyclerView`μ­μ  ν μμ 

    ```xml
    <androidx.fragment.app.FragmentContainerView
            android:id="@+id/nav_host_fragment"                                      
            android:name="androidx.navigation.fragment.NavHostFragment"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            app:defaultNavHost="true"
            app:navGraph="@navigation/nav_graph" />
    ```

  - `FrameLayout` μλ¨

    ```xml
    xmlns:app="http://schemas.android.com/apk/res-auto"
    ```

- νμ κ·Έλν μ€μ  
  - `File > New > Android Resource File`μμ λ¦¬μμ€ μ νμ `Navigation`μΌλ‘ μμ±
  - μλ¨ μΌμͺ½μμ κ° νλκ·Έλ¨ΌνΈμ λμ μμ±



<br/>

#### π WordListFragmentμμ μΈμ κ°μ Έμ€κΈ°

- `WordListFragment` μΆκ°

  ```kotlin
  private lateinit var letterId: String
  override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
  
      arguments?.let {
          letterId = it.getString(LETTER).toString()
      }
  }
  ```

- `onViewCreated()` μμ 

  ```kotlin
  recyclerView.adapter = WordAdapter(letterId, requireContext())
  ```

<br/>

## π©π»βπ» νμ : κ°μ - MAD(Modern Android Development) Skills

#### π ννλ¦Ώ μ΄ν΄λ³΄κΈ°

- Basic Activity 
  - 2κ°μ νλκ·Έλ¨ΌνΈ (λ²νΌ λλ₯΄λ©΄ μ΄λ)
  - λͺ©μ μ§ κ° μμ μλ€.
- Navigation Drawer Activity
  - νλκ·Έλ¨ΌνΈ 3κ°, λͺ©μ μ§ κ° μμ μμ
  - λ©λ΄ λλ₯΄λ©΄ νμ μ°½ νμ λ¨λλ°, κ·Έ μ°½μ μ΄μ©νμ¬ λͺ©μ μ§ κ° μ΄λ

#### π Navigation Pieces

- Toolbar
- NavHostFragment 
  - νλμ ν΅ν΄ νμν  λ λμ²΄λλ νλκ·Έλ¨ΌνΈλ₯Ό λ΄λ μ»¨νμ΄λ
  - νμ κ΅¬μ±μμκ° κ΅νλλ λͺ©μ μ§ μ»¨νμ΄λ μ­ν 

- NavController 
  - νμ κ΅¬μ±μμμ λ΄λΆ μμλ‘, μ€μ  νμμμμ νλ€. 
- NavigationView
  - νμ μ°½ λ΄μ μλ λ©λ΄μ κ΄λ ¨. νμ κ΅¬μ±μμμ μΌλΆκ° μλλ©° νμ κ΅¬μ±μμμ ν­λͺ©κ³Ό μνΈμμ©
- NavigationUI
  - νμ κ΅¬μ±μμ λΌμ΄λΈλ¬λ¦¬μμ NavHostFragment μΈλΆ μ½νμΈ  μλ°μ΄νΈλ₯Ό μ±μ
- +) Destination 0λΆν° μμ

<img src="img/3-2_2_jumin.png"  width=30% height=30%>

<img src="img/3-2_3_jumin.png" width=30% height=30%>

<br/>

<br/>

------

## π©π»βπ» ν΄μ¦

1. True or False: `onCreateView()` is only called once for a fragmentβs entire lifecycle.

   > False

2. Which of the following is a benefit of using fragments?

   > Navigation between fragments allows for more sophisticated user interface patterns, such as tab bars.

   > Using multiple fragments within an activity allows for an adaptive layout across multiple screen sizes.

   > The same fragments can be reused across multiple activities.

3. In the fragment lifecycle, which of the following tasks should be performed in `onViewCreated()`?

   > Binding view objects to properties in your fragment

   > Setting properties of individual views, such as a recycler viewβs adapter

4. In the fragment lifecycle, which of the following tasks should be performed in `onCreateView()`?

   > Inflating the layout

5. The [             ] method needs to be overridden in the host activity to ensure your appβs fragment-based navigation responds to the appβs "Up" button.

   > νλ¦Ό

6. Given the code for navigating between two fragments in a note-taking app, a list of books and a list of notes, which of the following is true about the navigation graph file?

   ```kotlin
   val action = BooksListFragmentsDirections.actionBooksListToNotesList(bookIndex = index)
   holder.view.findNavController().navigate(action)
   ```

   > Both the books list and notes list are destinations.

   > Thereβs an action defined on the navigation graph that goes from the books list to the notes list.