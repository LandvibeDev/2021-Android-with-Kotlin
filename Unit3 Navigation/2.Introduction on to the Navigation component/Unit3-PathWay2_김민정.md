## 2021 Landvibe Summer Coding - Android

### π Android Basics In Kotlin

#### π Unit3: Navigation

#### π PathWay2: Introduction to the Navigation component

<hr>

##### νλκ·Έλ¨ΌνΈ

: μ¬μ¬μ© κ°λ₯ν UIμ λΆλΆ

ππ» μλͺμ£ΌκΈ° O / μ¬μ©μ μλ ₯μ μλ΅ O

ππ» νλκ·Έλ¨ΈνΈ `μλͺμ£ΌκΈ°`

- INITIALIZED: νλκ·Έλ¨ΌνΈμ μ μΈμ€ν΄μ€κ° μΈμ€ν΄μ€νλμμ΅λλ€.
- CREATED: μ²« λ²μ§Έ νλκ·Έλ¨ΌνΈ μλͺ μ£ΌκΈ° λ©μλκ° νΈμΆλ©λλ€. μ΄ μνμμ νλκ·Έλ¨ΌνΈμ μ°κ²°λ λ·°λ λ§λ€μ΄μ§λλ€.
- STARTED: νλκ·Έλ¨ΌνΈκ° νλ©΄μ νμλμ§λ§ 'ν¬μ»€μ€'κ° μμΌλ―λ‘ μ¬μ©μ μλ ₯μ μλ΅ν  μ μμ΅λλ€.
- RESUMED: νλκ·Έλ¨ΌνΈκ° νμλκ³  ν¬μ»€μ€κ° μμ΅λλ€.
- DESTROYED: νλκ·Έλ¨ΌνΈ κ°μ²΄μ μΈμ€ν΄μ€νκ° μ·¨μλμμ΅λλ€.

ππ» νλκ·Έλ¨ΌνΈ `ν΄λμ€`

- `onCreate()`: νλκ·Έλ¨ΌνΈκ° μΈμ€ν΄μ€νλμκ³  `CREATED` μνμλλ€. κ·Έλ¬λ μ΄μ μμνλ λ·°κ° μμ§ λ§λ€μ΄μ§μ§ μμμ΅λλ€.
- `onCreateView()`: μ΄ λ©μλμμ λ μ΄μμμ νμ₯ν©λλ€. νλκ·Έλ¨ΌνΈκ° `CREATED` μνλ‘ μ νλμμ΅λλ€.
- `onViewCreated()`: λ·°κ° λ§λ€μ΄μ§ ν νΈμΆλ©λλ€. μ΄ λ©μλμμ μΌλ°μ μΌλ‘ `findViewById()`λ₯Ό νΈμΆνμ¬ νΉμ  λ·°λ₯Ό μμ±μ λ°μΈλ©ν©λλ€.
- `onStart()`: νλκ·Έλ¨ΌνΈκ° `STARTED` μνλ‘ μ νλμμ΅λλ€.
- `onResume()`: νλκ·Έλ¨ΌνΈκ° `RESUMED` μνλ‘ μ νλμκ³  μ΄μ  ν¬μ»€μ€λ₯Ό λ³΄μ ν©λλ€(μ¬μ©μ μλ ₯μ μλ΅ν  μ μμ).
- `onPause()`: νλκ·Έλ¨ΌνΈκ° `STARTED` μνλ‘ λ€μ μ νλμμ΅λλ€. UIκ° μ¬μ©μμκ² νμλ©λλ€.
- `onStop()`: νλκ·Έλ¨ΌνΈκ° `CREATED` μνλ‘ λ€μ μ νλμμ΅λλ€. κ°μ²΄κ° μΈμ€ν΄μ€νλμμ§λ§ λ μ΄μ νλ©΄μ νμλμ§ μμ΅λλ€.
- `onDestroyView()`: νλκ·Έλ¨ΌνΈκ° `DESTROYED` μνλ‘ μ νλκΈ° μ§μ μ νΈμΆλ©λλ€. λ·°λ λ©λͺ¨λ¦¬μμ μ΄λ―Έ μ­μ λμμ§λ§ νλκ·Έλ¨ΌνΈ κ°μ²΄λ μ¬μ ν μμ΅λλ€.
- `onDestroy()`: νλκ·Έλ¨ΌνΈκ° `DESTROYED` μνλ‘ μ νλ©λλ€.

<img src="img/Unit3-Pathway2-1_minjeong.png" height="500">

π¨ `onCreate()` λ©μλμ μ°¨μ΄μ μ μ!

: νλμμλ μ΄ λ©μλλ₯Ό μ¬μ©νμ¬ λ μ΄μμμ νμ₯νκ³  λ·°λ₯Ό λ°μΈλ©ν¨. But νλκ·Έλ¨ΌνΈ μλͺ μ£ΌκΈ°μμ `onCreate()`λ λ·°κ° λ§λ€μ΄μ§κΈ° μ μ νΈμΆλλ―λ‘ μ¬κΈ°μ λ μ΄μμμ νμ₯ν  μ X

λμ  `onCreateView()`μμ νμ₯! κ·Έλ° λ€μ λ·°λ₯Ό λ§λ  ν `onViewCreated()` λ©μλκ° νΈμΆλκ³  μ¬κΈ°μ μμ±μ νΉμ  λ·°μ λ°μΈλ©



##### κ΅¬ν

1. nullμ νμ©νλ `FragmentLetterListBinding` μ°Έμ‘°λ₯Ό κ°μ Έμ€κΈ°
2. λ°μΈλ© ν΄λμ€λ **build.gradle** νμΌμ `buildFeatures` μΉμμμ `viewBinding` μμ±μ΄ μ¬μ© μ€μ λ  λ Android μ€νλμ€μμ κ° λ μ΄μμ νμΌμ μμ±λ¨
3. `FragmentLetterListBinding`μ κ° λ·°μ νλκ·Έλ¨ΌνΈ ν΄λμ€μ μμ±μ ν λΉ

ππ» μ ν: `FragmentLetterListBinding?`

ππ» μ΄κΉκ°: null

π¨ νλκ·Έλ¨ΌνΈμ λ·°λ νλκ·Έλ¨ΌνΈμ μλͺ μ£ΌκΈ° λμ μ¬λ¬ λ² λ§λ€μ΄μ§κ³  μλ©Έλ  μ μλ€λ μ¬μ€!

: λ€λ₯Έ μλͺ μ£ΌκΈ° λ©μλ `onDestroyView()`μμλ κ°μ μ¬μ€μ 



##### νμ κ΅¬μ±μμ

1. νμ κ·Έλν: νμ κ·Έλνλ μ±μμ νμμ μκ°μ μΌλ‘ λ³΄μ¬μ£Όλ XML νμΌ

   > νμΌμ κ°λ³ νλ λ° νλκ·Έλ¨ΌνΈμ μμνλ *λμ*κ³Ό ν λμμμ λ€λ₯Έ λμμΌλ‘ μ΄λνλ €κ³  μ½λμμ μ¬μ©ν  μ μλ λμ μ¬μ΄μ μμμΌλ‘ κ΅¬μ±
   >
   > λ μ΄μμ νμΌκ³Ό λ§μ°¬κ°μ§λ‘ Android μ€νλμ€λ νμ κ·Έλνμ λμκ³Ό μμμ μΆκ°νλ μκ°μ  νΈμ§κΈ°λ₯Ό μ κ³΅

2. `NavHost`:  νλ λ΄μμ νμ κ·Έλνμ λμμ νμ

   > νλκ·Έλ¨ΌνΈ κ°μ μ΄λνλ©΄ `NavHost`μ νμλλ λμμ΄ μλ°μ΄νΈλ¨
   >
   > `MainActivity`μμ `NavHostFragment`λΌλ κΈ°λ³Έ μ κ³΅ κ΅¬νμ μ¬μ©

3. `NavController`: `NavController` κ°μ²΄λ₯Ό μ¬μ©νλ©΄ `NavHost`μ νμλλ λμ κ° νμμ μ μ΄

   > `NavController`μ `navigate()` λ©μλλ₯Ό νΈμΆνμ¬ νμλλ νλκ·Έλ¨ΌνΈλ₯Ό κ΅μ²΄κ°λ₯
   >
   > `NavController`λ₯Ό μ¬μ©νλ©΄ μμ€ν 'μλ‘' λ²νΌμ μλ΅νμ¬ μ΄μ μ νμλ νλκ·Έλ¨ΌνΈλ‘ λ€μ μ΄λνλ κ²κ³Ό κ°μ μΌλ°μ μΈ μμμ μ²λ¦¬ κ°λ₯

ππ» Safe Args νλ¬κ·ΈμΈ

: νλκ·Έλ¨ΌνΈ κ°μ λ°μ΄ν°λ₯Ό μ λ¬ν  λ μ ν μμ μ±μ μ§μνλ Gradle νλ¬κ·ΈμΈμΈ **Safe Args**λΌλ ν­λͺ©λ μΆκ°



##### νμκ·Έλν(NavGraph)

: μ± νμμ κ°μ λ§€ν/κ° νλκ·Έλ¨ΌνΈλ μ΄λν  μ μλ κ°λ₯ν λμ/κ° λμμ΄ μλ‘ κ΄λ ¨λλ λ°©μμ λ³΄μ¬μ£Όλ XML νμΌλ‘ λνλΌ μ μμ!

ππ» λμ? `FragmentContainerView`λ‘ μ¬μ©μμκ² νμ

 

π [μλ£¨μ μ½λ](https://github.com/google-developer-training/android-basics-kotlin-words-app/tree/main)



##### ν΄μ¦

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

5. λΉ μΉΈ μ±μ°κΈ°

   The `  onSuppoertNavigateUp`method needs to be overridden in the host activity to ensure your appβs fragment-based navigation responds to the appβs "Up" button.

6. Given the code for navigating between two fragments in a note-taking app, a list of books and a list of notes, which of the following is true about the navigation graph file?

   ```kotlin
   val action = BooksListFragmentsDirections.actionBooksListToNotesList(bookIndex = index)
   holder.view.findNavController().navigate(action)
   ```

   > Both the books list and notes list are destinations.

   > Thereβs an action defined on the navigation graph that goes from the books list to the notes list.