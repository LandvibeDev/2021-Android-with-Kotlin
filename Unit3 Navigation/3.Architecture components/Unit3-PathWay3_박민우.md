# π₯ Unit 3 : Navigation

## Pathway 3 : Architecture components

## π ViewModelμ λ°μ΄ν° μ μ₯νκΈ°

+ νμ¬ μ€νν° μ±μ λ¬Έμ 

  + κΈ°κΈ° λ°©ν₯μ΄ λ³κ²½λλ κ²½μ°μ κ°μ΄ **κ΅¬μ±μ΄ λ³κ²½λλ λμ μ± μνμ λ°μ΄ν°λ₯Ό μ μ₯νκ³  λ³΅μνμ§ μλλ€.** μ΄λ¬ν λ¬Έμ λ `onSaveInstanceState()` μ½λ°±μ μ¬μ©νμ¬ ν΄κ²°ν  μ μμ΅λλ€. νμ§λ§ `onSaveInstanceState()` λ©μλλ₯Ό μ¬μ©νλ €λ©΄ λ²λ€μ μνλ₯Ό μ μ₯νλ μΆκ° μ½λλ₯Ό μμ±νκ³  μ΄ μνλ₯Ό κ²μνλ λ‘μ§μ κ΅¬νν΄μΌ νλ€, λ λ²λ€μ μ μ₯ν  μ μλ λ°μ΄ν°μ μλ μ λ€. 

    => λ°λΌμ, **Android Architecture Components**λ₯Ό μ¬μ©νμ¬ μ΄λ¬ν λ¬Έμ λ₯Ό ν΄κ²°νλ€. 

    μν€νμ³ κ΅¬μ±μμλ₯Ό μ¬μ©νμ¬ κΆμ₯ μ± μν€νμ³λ₯Ό κ΅¬ν 

  > μ±μ μνμ λ°μ΄ν°λ₯Ό μ μ₯νκ³  λ³΅μν΄μΌ νλ κ²½μ° 
  >
  > => λ‘κ·ΈμΈ μ μμ΄λ, λΉλ°λ²νΈ λ°μ΄ν° μ μ₯, κ²μ λ±μ μ± μ§ν μ νμ¬ μ μλ₯Ό μ μ₯

<br></br>

<br></br>

### App Architecture

+ μν€νμ³λ μ±μμ **ν΄λμ€ κ°μ μ±μμ ν λΉ**νλ κ°μ΄λλΌμΈμ μ κ³΅νλ€. μ± μν€νμ³κ° μ λμμΈλμ΄ μμΌλ©΄ ν₯ν μ±μ νμ₯νκ³  λ λ§μ κΈ°λ₯μ ν¬ν¨ν  μ μμ΅λλ€. λν ν κ³΅λμμλ λ κ°νΈν©λλ€. 

  + κ°μ₯ μΌλ°μ μΈ μν€νμ³ μμΉ : **Seperation of concerns, Drive UI from a model**

    + Seperation of concerns : κ°κ° λ³κ°μ μ±μμ΄ μλ μ¬λ¬ ν΄λμ€λ‘ μ±μ λλλ κ²

    + Drive UI from a model : λͺ¨λΈλ‘λΆν° UIλ₯Ό λ§λ€μ΄μΌ νλ€λ κ². κ°κΈμ  **μ§μμ μΈ λͺ¨λΈ**μ κΆμ₯νλ€.**λͺ¨λΈμ μ±μ λ°μ΄ν° μ²λ¦¬λ₯Ό λ΄λΉνλ κ΅¬μ±μμ**λ‘, μ±μ `Views` κ°μ²΄ λ° μ± κ΅¬μ±μμμ λλ¦½λμ΄ μμΌλ―λ‘ μ±μ μλͺ μ£ΌκΈ° λ° κ΄λ ¨ λ¬Έμ μ μν₯μ λ°μ§ μμ΅λλ€. 

      (κ·Έλ¬λκΉ modelμ΄λ, μ±μ UIλ₯Ό μ°μ  μκ°νμ§ μκ³ , κΈ°λ₯λ³λ‘ λλ κ²?)

+ Android architectureμ κΈ°λ³Έ ν΄λμ€ λλ κ΅¬μ±μμλ **UI controller,`Viewmodel`, `LiveData`, `Room`** μλλ€. μ΄λ¬ν κ΅¬μ±μμλ **μλͺ μ£ΌκΈ°μ λ³΅μ‘μ±μ μ΄λ μ λ μ²λ¦¬**νλ―λ‘ μλͺ μ£ΌκΈ° κ΄λ ¨ λ¬Έμ λ₯Ό νΌνλλ° λμμ΄ λλ€. 

  <img src = "https://user-images.githubusercontent.com/31370590/127764913-dc0f30c2-bb62-42e0-8b9b-b8dd0d281141.PNG">

  + UI Controller(activity/fragment)

    **Activity**μ **Fragment**λ UI μ»¨νΈλ‘€λ¬μλλ€. UI μ»¨νΈλ‘€λ¬λ **νλ©΄μ λ·°λ₯Ό κ·Έλ¦¬κ³  μ¬μ©μ μ΄λ²€νΈλ μ¬μ©μκ° μνΈμμ©νλ λ€λ₯Έ λͺ¨λ  UI κ΄λ ¨ λμμ μΊ‘μ³νμ¬ UIλ₯Ό μ μ΄**ν©λλ€. μ±μ λ°μ΄ν° λν λ°μ΄ν°μ κ΄ν λͺ¨λ  μμ¬ κ²°μ  λ‘μ§μ UI μ»¨νΈλ‘€λ¬ ν΄λμ€μ ν¬ν¨λμ΄μλ μλ©λλ€. 

    Android μμ€νμ νΉμ  μ¬μ©μ μνΈμμ©μ κΈ°λ°μΌλ‘ λλ λ©λͺ¨λ¦¬ λΆμ‘±κ³Ό κ°μ μμ€ν μ‘°κ±΄μΌλ‘ μΈν΄ μΈμ λ μ§ UI μ»¨νΈλ‘€λ¬λ₯Ό μ κ±°ν  μ μμ΅λλ€. μ΄λ¬ν μ΄λ²€νΈλ κ°λ°μκ° μ§μ  μ μ΄ν  μ μκΈ° λλ¬Έμ, **UI μ»¨νΈλ‘€λ¬μ μ± λ°μ΄ν°λ μνλ₯Ό μ μ₯ν΄μλ μ λ©λλ€.** λμ  **λ°μ΄ν°μ κ΄ν μμ¬ κ²°μ  λ‘μ§μ `ViewModel`μ μΆκ°ν΄μΌ ν©λλ€.**

    μλ₯Ό λ€μ΄ **Unscramble** μ±μμ κΈμκ° λ€μμΈ λ¨μ΄, μ μ, λ¨μ΄ μλ νλκ·Έλ¨ΌνΈ(UI μ»¨νΈλ‘€λ¬)μ νμλ©λλ€. κΈμκ° λ€μμΈ λ€μ λ¨μ΄λ₯Ό κ³ λ₯΄κ³  μ μμ λ¨μ΄ μλ₯Ό κ³μ°νλ λ±μ μμ¬ κ²°μ  μ½λλ `ViewModel`μ ν¬ν¨ν΄μΌ ν©λλ€.

    <br></br><br></br>

  + View model

    `ViewModel`μ **λ·°μ νμλλ μ± λ°μ΄ν°μ λͺ¨λΈ**μλλ€. λͺ¨λΈμ **μ±μ λ°μ΄ν° μ²λ¦¬λ₯Ό λ΄λΉ**νλ κ΅¬μ±μμλ‘, μν€νμ³ μμΉμ λ°λΌ λͺ¨λΈμμ UIκ° λμΆλλ μ±μ λ§λ€ μ μμ΅λλ€. 

    `ViewModel`μ Andriod νλ μμν¬μμ νλμ΄λ νλκ·Έλ¨ΌνΈκ° μλ©Έλκ³  λ€μ μμ±λ  λ νκΈ°λμ§ μλ μ± κ΄λ ¨ λ°μ΄ν°λ₯Ό μ μ₯ν©λλ€. `ViewModel` κ°μ²΄λ **κ΅¬μ±μ΄ λ³κ²½λλ λμ μλμΌλ‘ μ μ§**λμ΄(νλ λλ νλκ·Έλ¨ΌνΈ μΈμ€ν΄μ€μ²λΌ μλ©Έλμ§ μμ) λ³΄μ νκ³  μλ λ°μ΄ν°κ° λ€μ νλ λλ νλκ·Έλ¨ΌνΈ μΈμ€ν΄μ€μ μ¦μ μ¬μ©λ  μ μμ΅λλ€.

    <br></br>

    <br></br>

  + μμ½

    Activity/Fragmentμ μ±μ : λ·°μ λ°μ΄ν°λ₯Ό νλ©΄μ κ·Έλ¦¬κ³  μ¬μ©μ μ΄λ²€νΈμ μλ΅ν©λλ€.

    ViewModelμ μ±μ : UIμ νμν λͺ¨λ  λ°μ΄ν°λ₯Ό λ³΄μ νκ³  μ²λ¦¬ν©λλ€. λ·° κ³μΈ΅ κ΅¬μ‘°(ex) λ·° κ²°ν© κ°μ²΄)μ μ‘μΈμ€νκ±°λ νλ λλ νλκ·Έλ¨ΌνΈμ μ°Έμ‘°λ₯Ό λ³΄μ ν΄μλ μ λ©λλ€. 
    
    <br></br>
    
    <br></br>
    
    <br></br>

### ViewModel μΆκ°νκΈ°

+ μ΄ μμμμλ μ± λ°μ΄ν°(κΈμκ° λ€μ°μΈ λ¨μ΄, λ¨μ΄ μ, μ μ)λ₯Ό μ μ₯νλ `ViewModel`μ μ±μ μΆκ°ν©λλ€. 
+ μ±μ μν€νμ³λ `MainActivity` => `GameFragment` => `GameViewModel`λ‘ κ΅¬μ±λμ΄ μλ€.

<br></br>

<br></br>

###### 1. `GameViewModel` class μΆκ°νκΈ°

```kotlin
class GameViewModel : ViewModel() {
}
```

<br></br><br></br>

###### 2.  `ViewModel`μ νλκ·Έλ¨ΌνΈμ μ°κ²°νκΈ°

+ `ViewModel`μ UI μ»¨νΈλ‘€λ¬(Activity/Fragment)μ μ°κ²°νλ €λ©΄ UI μ»¨νΈλ‘€λ¬ λ΄μ `ViewModel`μ κ΄ν μ°Έμ‘°(κ°μ²΄)λ₯Ό λ§λ­λλ€.

  ```kotlin
  private val viewModel: GameViewModel by viewModels()
  ```

  <br></br><br></br>

+ `GameFragment` ν΄λμ€ μλ¨μ `GameViewModel` μ νμ μμ±μ μΆκ°νκ³ , `by viewModels()` **Kotlin μμ± μμ**μ μ¬μ©νμ¬ `GameViewModel`μ μ΄κΈ°ν

  <br></br><br></br>

+ Kotlin property delegate

  + μ½νλ¦°μλ κ° λ³κ²½ κ°λ₯ν(`var`)  μμ±μ μλμΌλ‘ μμ±λ κΈ°λ³Έ getterν¨μμ setterν¨μκ° μμ΅λλ€. νμ§λ§ μ½κΈ° μ μ©(`val`)μ κ²½μ° κΈ°λ³Έμ μΌλ‘ getterν¨μλ§ μμ±λ©λλ€. 

  + μ½νλ¦°μμ μμ± μμμ μ¬μ©νλ©΄ getter-setter μ±μμ λ€λ₯Έ ν΄λμ€μ λκΈΈ μ μμ΅λλ€. μ΄ ν΄λμ€(calleed **delegate class**)λ μμ±μ getter λ° setter ν¨μλ₯Ό μ κ³΅νκ³  λ³κ²½μ¬ν­μ μ²λ¦¬ν©λλ€. 

  + delegate propertyλ λ€μκ³Ό κ°μ΄ `by` μ  λ° λλ¦¬μ ν΄λμ€ μΈμ€ν΄μ€λ₯Ό μ¬μ©νμ¬ μ μλ©λλ€.

    ```kotlin
    // Syntax for property delegation
    var <property-name> : <property-type> by <delegate-class>()
    ```

  <br></br><br></br>

+ μ±μμ λ€μκ³Ό κ°μ΄ κΈ°λ³Έ `GameViewModel()`μμ±μλ₯Ό μ¬μ©νμ¬ λ·° λͺ¨λΈμ μ΄κΈ°ν νλ κ²½μ°

  ```kotlin
  private val viewModel = GameViewModel()
  ```

  + κΈ°κΈ°μμ κ΅¬μ±μ΄ λ³κ²½λλ λμ μ±μ΄ `ViewModel` μ°Έμ‘°μ μνλ₯Ό μμ€νκ² λ©λλ€. μλ₯Ό λ€μ΄ κΈ°κΈ°λ₯Ό νμ νλ©΄ νλμ΄ μλ©Έλ ν λ€μ μμ±λκ³  μ΄κΈ° μνμ μλ‘μ΄ λ·° λͺ¨λΈ μΈμ€ν΄μ€κ° λ€μ μμλ©λλ€. 

  <br></br><br></br>

+ λμ  μμ± μμ μ κ·Ό λ°©μμ μ¬μ©ν΄ ** `viewModel` κ°μ²΄μ μ±μμ `viewModels`λΌλ λ³λμ ν΄λμ€μ μμ**ν©λλ€. μ¦, `viewmodel` κ°μ²΄μ μ‘μΈμ€νλ©΄ μ΄ κ°μ²΄λ λλ¦¬μ ν΄λμ€ `viewModels`μ μν΄ λ΄λΆμ μΌλ‘ μ²λ¦¬λ©λλ€. 

  λλ¦¬μ ν΄λμ€λ μ²« λ²μ§Έ μ‘μΈμ€ μ μλμΌλ‘ `viewModel` κ°μ²΄λ₯Ό λ§λ€κ³  μ΄ κ°μΌλ‘ κ΅¬μ± λ³κ²½ μ€μλ μ μ§νλ€κ° μμ²­μ΄ μμ λ λ°νν©λλ€.  

  <br></br><br></br>

  <br></br>

### ViewModelλ‘ λ°μ΄ν° μ΄λνκΈ°

+ μ±μ UI λ°μ΄ν°λ₯Ό UI μ»¨νΈλ‘€λ¬μμ λΆλ¦¬νλ©΄ μμμ μ€λͺν λ¨μΌ μ±μ μμΉμ λ μ μ€μν  μ μμ΅λλ€.  μ‘ν°λΉν°μ νλκ·Έλ¨ΌνΈλ νλ©΄μ λ·°μ λ°μ΄ν°λ₯Ό κ·Έλ¦¬κ³ , `ViewModel`μ UIμ νμν λͺ¨λ  λ°μ΄ν°λ₯Ό λ³΄μ νκ³  μ²λ¦¬ν©λλ€. 

  <br></br><br></br>

+ `GameFragment` ν΄λμ€μμ `GameViewModel` ν΄λμ€λ‘ λ°μ΄ν° λ³μλ₯Ό μ΄λνλ€.

```kotlin
class GameViewModel : ViewModel() {

    private var score = 0
    private var currentWordCount = 0
    private var currentScrambledWord = "test"
}
```

+ `ViewModel`μμλ λ°μ΄ν°λ₯Ό μμ ν  μ μμ΄μΌ νλ―λ‘ λ°μ΄ν°λ `private` λ° `var` μ΄μ΄μΌ ν©λλ€. `ViewModel` μΈλΆμμλ λ°μ΄ν°λ₯Ό μ½μ μ μμ§λ§ μμ ν  μλ μμ΄μΌ νλ―λ‘ λ°μ΄ν°λ `public` λ° `val`λ‘ λΈμΆλμ΄μΌ ν©λλ€. μ΄λ₯Ό μν΄ μ§μ μμ±μ΄λΌλ κΈ°λ₯μ΄ μλ€.

  <br></br><br></br>

+ μ§μ μμ±

  ```kotlin
  // Declare private mutable variable that can only be modified
  // within the class it is declared.
  private var _count = 0
  
  // Declare another public immutable field and override its getter method.
  // Return the private property's value in the getter method.
  // When count is accessed, the get() function is called and
  // the value of _count is returned.
  val count: Int
     get() = _count
  ```

  + `count` λ³μκ° μ κ·Όλ  λ, `_count` κ°μ λ°ννλ `get()` ν¨μκ° νΈμΆλλ€. 

  + `ViewModel` ν΄λμ€ λ΄λΆ:
    - `_count` μμ±μ΄ `private`μ΄λ©° λ³κ²½ κ°λ₯ν©λλ€. λ°λΌμ `ViewModel` ν΄λμ€ λ΄μμλ§ μ‘μΈμ€νκ³  μμ ν  μ μμ΅λλ€. μ΄λ¦ μ§μ  κ·μΉμ `private` μμ± μμ λ°μ€μ λΆμ΄λ κ²μλλ€.
  + `ViewModel` ν΄λμ€ μΈλΆ:
    - Kotlinμ κΈ°λ³Έ κ³΅κ° μν νμ μλ `public`μ΄λ―λ‘, `count`λ κ³΅κ° μμ±μ΄λ©° UI μ»¨νΈλ‘€λ¬μ κ°μ λ€λ₯Έ ν΄λμ€μμ μ‘μΈμ€ν  μ μμ΅λλ€. `get()` λ©μλλ§ μ¬μ μλλ―λ‘, μ΄ μμ±μ λ³κ²½ν  μ μμΌλ©° μ½κΈ° μ μ©μλλ€. μΈλΆ ν΄λμ€κ° μ΄ μμ±μ μ‘μΈμ€νλ©΄ `_count`μ κ°μ λ°ννλ©°, μ΄ κ°μ μμ ν  μ μμ΅λλ€. μ΄μ λ°λΌ `ViewModel`μ μλ μ± λ°μ΄ν°κ° μΈλΆ ν΄λμ€λ‘ μΈν΄ μμΉ μκ², μμ νμ§ μκ² λ³κ²½λμ§ μλλ‘ λ³΄νΈλμ§λ§ μΈλΆ νΈμΆμλ κ°μ μμ νκ² μ‘μΈμ€ν  μ μμ΅λλ€.

<br></br><br></br>

+ `currentScrambleWord`μ μ§μ μμ± μΆκ°

  ```kotlin
  private var _currentScrambledWord = "test"
  val currentScrambledWord: String
     get() = _currentScrambledWord
  ```

<br></br><br></br><br></br>

###  ViewModel μλͺ μ£ΌκΈ° μ΄ν΄

+ ViewModel μλͺ μ£ΌκΈ°

  <img src = "https://user-images.githubusercontent.com/31370590/127839122-386439ab-9f5d-4097-9ebd-e395d9314cc7.PNG" width = "700" height = "500">

   νλ μμν¬λ νλμ΄λ νλκ·Έλ¨ΌνΈμ λ²μκ° μ μ§λλ λμ `ViewModel`μ μ μ§ν©λλ€. `ViewModel`μ μμ μκ° νλ©΄ νμ κ³Ό κ°μ κ΅¬μ± λ³κ²½μΌλ‘ μΈν΄ μλ©Έλλ κ²½μ°μλ μλ©Έλμ§ μμ΅λλ€. μμ μμ μ μΈμ€ν΄μ€λ λ€μ λ€μ΄μ΄κ·Έλ¨κ³Ό κ°μ΄ κΈ°μ‘΄ `ViewModel` μΈμ€ν΄μ€μ λ€μ μ°κ²°λ©λλ€.

  <br></br><br></br>

+ `GameViewModel.kt`μμ λ‘κ·Έ κ΅¬λ¬Έμ΄ ν¬ν¨λ `init` λΈλ‘ μΆκ°

  ```kotlin
  class GameViewModel : ViewModel() {
     init {
         Log.d("GameFragment", "GameViewModel created!")
     }
  }
  ```

  `init`λΈλ‘μ κ°μ²΄ μΈμ€ν΄μ€κ° μ²μ μμ±λμ΄ μ΄κΈ°ν λ  λ μ€νλ©λλ€.  

+ `GameViewModel` ν΄λμ€μμ`OnCleared()` λ©μλλ₯Ό μ¬μ μ

  ```
  override fun onCleared() {
      super.onCleared()
      Log.d("GameFragment", "GameViewModel destroyed!")
  }
  ```

  `ViewModel`μ μ°κ²°λ νλκ·Έλ¨ΌνΈκ° λΆλ¦¬λκ±°λ νλμ΄ μλ£λλ©΄ μλ©Έλ©λλ€. `ViewModel`μ΄ μλ©ΈλκΈ° μ§μ μ `onCleared()` μ½λ°±μ΄ νΈμΆλ©λλ€.

+ `GameFragment`μ λ‘κ·Έ κ΅¬λ¬Έ μΆκ°, `onDetach()` μ½λ°± λ©μλ μ¬μ μ

  ```kotlin
  override fun onCreateView(
     inflater: LayoutInflater, container: ViewGroup?,
     savedInstanceState: Bundle?
  ): View {
     binding = GameFragmentBinding.inflate(inflater, container, false)
     Log.d("GameFragment", "GameFragment created/re-created!")
     return binding.root
  }
  
  override fun onDetach() {
      super.onDetach()
      Log.d("GameFragment", "GameFragment destroyed!")
  }
  ```

=> κ²°κ³Ό : κΈ°κΈ°λ μλ?¬λ μ΄ν°μμ μλ νμ  μ€μ μ μΌκ³  νλ©΄ λ°©ν₯μ λͺ λ² λ°κΏλλ€. `GameFragment`λ λ§€λ² μλ©Έλκ³  λ€μ μμ±λμ§λ§ `GameViewModel`μ ν λ²λ§ μμ±λλ©° λ§€λ² νΈμΆλ³λ‘ λ€μ μμ±λκ±°λ μλ©Έλμ§ μμ΅λλ€.

<br></br><br></br><br></br>

###  ViewModel μ±μ°κΈ°

+ λ€μ λ¨μ΄ κ°μ Έμ€κΈ°

  ```kotlin
  /*
  * Updates currentWord and currentScrambledWord with the next word.
  */
  private fun getNextWord() {
     currentWord = allWordsList.random()
     val tempWord = currentWord.toCharArray()
     tempWord.shuffle()
  
     while (tempWord.toString().equals(currentWord, false)) {
         tempWord.shuffle()
     }
     if (wordsList.contains(currentWord)) {
         getNextWord()
     } else {
         _currentScrambledWord = String(tempWord)
         ++currentWordCount
         wordsList.add(currentWord)
     }
  }
  ```

<br></br><br></br>

+ `nextWord()` λ©μλ μΆκ°

  ```kotlin
  /*
  * Returns true if the current word count is less than MAX_NO_OF_WORDS.
  * Updates the next word.
  */
  fun nextWord(): Boolean {
      return if (currentWordCount < MAX_NO_OF_WORDS) {
          getNextWord()
          true
      } else false
  }
  ```

  λͺ©λ‘μμ λ€μ λ¨μ΄λ₯Ό κ°μ Έμ€κ³  λ¨μ΄ μκ° `MAX_NO_OF_WORDS`λ³΄λ€ μ μΌλ©΄ `true`λ₯Ό λ°νν©λλ€.

<br></br><br></br>

### λνμμ

+ μλ¦Ό λνμμ κ΅¬μ±
  1. μλ¦Ό λνμμ
  2. μ λͺ©(μ νμ¬ν­)
  3. λ©μμ§
  4. νμ€νΈ λ²νΌ

<br></br><br></br>μ΅μ’ μ μ λνμμ κ΅¬ν

+ λ¨Έν°λ¦¬μΌ λμμΈ κ΅¬μ±μμ λΌμ΄λΈλ¬λ¦¬μ `MaterialAlertDialog`λ₯Ό μ¬μ©νμ¬ λ¨Έν°λ¦¬μΌ κ°μ΄λλΌμΈμ λ°λ₯΄λ λνμμλ₯Ό μ±μ μΆκ°ν©λλ€. λνμμλ UIμ κ΄λ ¨μ΄ μμΌλ―λ‘, `GameFragment`κ° μ΅μ’ μ μ λνμμ μμ±κ³Ό νμλ₯Ό λ΄λΉν©λλ€.

  ```kotlin
  /*
  * Creates and shows an AlertDialog with the final score.
  */
  private fun showFinalScoreDialog() {
     MaterialAlertDialogBuilder(requireContext())
         .setTitle(getString(R.string.congratulations))
         .setMessage(getString(R.string.you_scored, viewModel.score)) // μ½κΈ° μ μ© λ²μ 
         .setCancelable(false) // λ€λ‘ ν€λ₯Ό λλ¬ μλ¦Ό λνμμλ₯Ό μ·¨μν  μ μλλ‘
         .setNegativeButton(getString(R.string.exit)) { _, _ ->
             exitGame()
         }
         .setPositiveButton(getString(R.string.play_again)) { _, _ ->
             restartGame()
         }
         .show()
  }
  ```

  + `MaterialAlertDialog`λ₯Ό λ§λ€λ €λ©΄ `MaterialAlertDialogBuilder` ν΄λμ€λ₯Ό μ¬μ©νμ¬ λνμμμ λΆλΆμ λ¨κ³λ³λ‘ λΉλν©λλ€. νλκ·Έλ¨ΌνΈμ `requireContext()`λ©μλλ₯Ό μ¬μ©νμ¬ μ½νμΈ λ₯Ό μ λ¬νλ `MaterialAlertDialogBuilder`μμ±μλ₯Ό νΈμΆν©λλ€. `requireContext()` λ©μλλ nullμ΄ μλ `Context`λ₯Ό λ°νν©λλ€.

    > `Context`λ μ΄λ¦μμ μ μ μλ―μ΄ μ νλ¦¬μΌμ΄μ, μ‘ν°λΉν°, νλκ·Έλ¨ΌνΈμ μ»¨νμ€νΈλ νμ¬ μνλ₯Ό μλ―Έν©λλ€. μ‘ν°λΉν°, νλκ·Έλ¨ΌνΈ, μ νλ¦¬μΌμ΄μκ³Ό κ΄λ ¨λ μ λ³΄λ₯Ό ν¬ν¨νκ³  μμΌλ©° μΌλ°μ μΌλ‘ λ¦¬μμ€, λ°μ΄ν°λ² μ΄μ€, κΈ°ν μμ€ν μλΉμ€μ μ‘μΈμ€νλ λ° μ¬μ©λ©λλ€. μ΄ λ¨κ³μμλ νλκ·Έλ¨ΌνΈ μ»¨νμ€νΈλ₯Ό μ λ¬νμ¬ μλ¦Ό λνμμλ₯Ό λ§λ­λλ€.

  + `setNegativeButton()` λ©μλμ `setPositiveButton()` λ©μλλ₯Ό μ¬μ©νμ¬ **EXIT** λ° **PLAY AGAIN**μ λ νμ€νΈ λ²νΌμ μΆκ°ν©λλ€. λλ€μμ κ°κ° `exitGame()`κ³Ό `restartGame()`μ νΈμΆν©λλ€.

    ```kotlin
    .setNegativeButton(getString(R.string.exit)) { _, _ ->
        exitGame()
    }
    
    .setPositiveButton(getString(R.string.play_again)) { _, _ ->
        restartGame()
    }
    ```

    μ΄ κ΅¬λ¬Έμ 

    `setNegativeButton(getString(R.string.exit), { _, _ -> exitGame()})`μ μ½μ ννμλλ€.

    μ¬κΈ°μ `setNegativeButton()` λ©μλλ λ λ§€κ°λ³μ, 

    μ¦ ** `String`**κ³Ό ν¨μ ** `DialogInterface.OnClickListener()`**(λλ€λ‘ νν κ°λ₯)λ₯Ό μ¬μ©ν©λλ€. **μ λ¬λλ λ§μ§λ§ μΈμκ° ν¨μμ΄λ©΄ κ΄νΈ *λ°κΉ₯μ*  λλ€ ννμμ λ°°μΉ**ν  μ μμ΅λλ€. μ΄λ₯Ό *νν λλ€ κ΅¬λ¬Έ*μ΄λΌκ³  ν©λλ€. λλ€λ₯Ό κ΄νΈ μμ λ°°μΉνκ±°λ λ°κΉ₯μ λ°°μΉνμ¬ μ½λλ₯Ό μμ±νλ λ°©λ²μ΄ λͺ¨λ νμ©λ©λλ€. `setPositiveButton` ν¨μμ κ²½μ°λ λ§μ°¬κ°μ§μλλ€.

<br></br><br></br><br></br>

## π ViewModelκ³Ό ν¨κ» LiveData μ¬μ©νκΈ°

### Livedataλ?

+ LiveDataλ **μλͺ μ£ΌκΈ°λ₯Ό μΈμ**νλ **μλ³ κ°λ₯ν λ°μ΄ν° νλ ν΄λμ€**μλλ€. 

  LiveDataμ νΉμ±

  + `LiveData`λ **λ°μ΄ν°λ₯Ό λ³΄μ **ν©λλ€. `LiveData`λ λͺ¨λ  μ νμ λ°μ΄ν°μ μ¬μ©ν  μ μλ wrapperμλλ€.
  
  + `LiveData`λ **μλ³ κ°λ₯**ν©λλ€. μ¦, ** `LiveData` κ°μ²΄μμ λ³΄μ ν λ°μ΄ν°κ° λ³κ²½λλ©΄ κ΄μ°°μμ μλ¦Όμ΄ μ κ³΅**λ©λλ€.
  
  + `LiveData`λ **μλͺ μ£ΌκΈ°λ₯Ό μΈμ**ν©λλ€. `LiveData`μ **κ΄μ°°μλ₯Ό μ°κ²°**νλ©΄ κ΄μ°°μλ `LifecycleOwner` (μΌλ°μ μΌλ‘ νλ λλ νλκ·Έλ¨ΌνΈ)μ μ°κ²°λ©λλ€. `LiveData`λ `STARTED` λλ `RESUMED` κ°μ νμ± μλͺ μ£ΌκΈ° μνμΈ κ΄μ°°μλ§ μλ°μ΄νΈν©λλ€. 
  
    <br></br><br></br><br></br>

### LiveData μΆκ°νκΈ°

```kotlin
private val _currentScrambledWord = MutableLiveData<String>()
```

+ `MutableLiveData`λ λ³κ²½ κ°λ₯ν λ²μ μ `LiveData`μλλ€. μ¦, **λ΄λΆμ μ μ₯λ λ°μ΄ν°μ κ°μ λ³κ²½ν  μ μμ΅λλ€.**
+ `LiveData`/`MutableLiveData` **κ°μ²΄μ κ°μ λμΌνκ² μ μ§**λκ³  μ΄ **κ°μ²΄μ μ μ₯λ λ°μ΄ν°λ§ λ³κ²½λκΈ° λλ¬Έ**μ `_currentScrambledWord`μ λ³μ μ νμ `val`λ‘ λ³κ²½ν©λλ€.

<br></br><br></br>

```kotlin
val currentScrambledWord: LiveData<String>
   get() = _currentScrambledWord
```

+ μ§μ νλ `currentScrambleWord`λ₯Ό λ³κ²½ν  μ μκΈ° λλ¬Έμ κ·Έ μ νμ `LiveData<String>`μΌλ‘ λ³κ²½ν©λλ€.

 <br></br><br></br>

```kotlin
private fun getNextWord() {
 
   } else {
       _currentScrambledWord.value = String(tempWord)
       ...
   }
}
```

+ `LiveData` κ°μ²΄ λ΄μ λ°μ΄ν°μ μ‘μΈμ€νλ €λ©΄ `value` μμ±μ μ¬μ©ν©λλ€.

<br></br><br></br><br></br>

### LiveData κ°μ²΄μ κ΄μ°°μ μ°κ²°νκΈ°

```kotlin
// Observe the scrambledCharArray LiveData, passing in the LifecycleOwner and the observer.
viewModel.currentScrambledWord.observe(viewLifecycleOwner,
   { newWord ->
       binding.textViewUnscrambledWord.text = newWord
   })
```

+ `currentScrambledWord` `LiveData`μ κ΄μ°°μλ₯Ό μ°κ²°ν©λλ€.  `GameFragment`μ ** `onViewCreated()` μ½λ°± λμμ** `currentScrambledWord`μ κ΄ν΄ `observe()`λ©μλλ₯Ό νΈμΆν©λλ€.
+ `viewLifecycleOwner`λ₯Ό μ²« λ²μ§Έ λ§€κ°λ³μλ‘ `observe()` λ©μλμ μ λ¬ν©λλ€. ** `viewLifecycleOwner` λ νλκ·Έλ¨ΌνΈμ λ·° μλͺ μ£ΌκΈ°λ₯Ό λνλλλ€.** μ΄ λ§€κ°λ³μλ₯Ό μ¬μ©νλ©΄ ** `LiveData` κ° `GameFragment` μλͺ μ£ΌκΈ°λ₯Ό μΈμνκ³  `GameFragment`κ° νμ± μν(`STARTED` λλ `RESUMED`)μΌ λλ§ κ΄μ°°μμ μλ¦΄ μ μμ΅λλ€.**

+ `newWord`λ₯Ό ν¨μ λ§€κ°λ³μλ‘ μ¬μ©νμ¬ λ λ²μ§Έ λ§€κ°λ³μλ‘ λλ€λ₯Ό μΆκ°ν©λλ€. `newWord`μλ κΈμκ° λ€μμΈ μ λ¨μ΄ κ°μ΄ ν¬ν¨λ©λλ€. λλ€ ννμμ ν¨μ λ³Έλ¬Έμμ `newWord`λ₯Ό κΈμκ° λ€μμΈ λ¨μ΄ νμ€νΈ λ·°μ ν λΉν©λλ€.

<br></br><br></br><br></br>

### λ°μ΄ν° κ²°ν©κ³Ό ν¨κ» LiveData μ¬μ©νκΈ°

μ΄μ  μμμμλ μ±μ΄ μ½λμ λ°μ΄ν° λ³κ²½μ¬ν­μ μμ ν©λλ€. λ§μ°¬κ°μ§λ‘, μ±μ **λ μ΄μμμμ λ°μ΄ν° λ³κ²½μ¬ν­μ μμ ν  μ μμ΅λλ€.** λ°μ΄ν° κ²°ν©μ μ¬μ©νλ©΄ **μλ³ κ°λ₯ν `LiveData` κ°μ΄ λ³κ²½λ  λ λ°μΈλ©λ λ μ΄μμμ UI μμμλ μλ¦Όμ΄ μ μ‘λλ©° λ μ΄μμ λ΄μμ UIλ₯Ό μλ°μ΄νΈν  μ μμ΅λλ€.**

<br></br><br></br>

#### view binding λ³΅μ΅ 

+ μ΄μ μλ λ¨λ°©ν₯ κ²°ν©μΈ  λ·° κ²°ν©μ νμΈνμ΅λλ€. **λ·°λ₯Ό μ½λμ λ°μΈλ©**ν  μ μμ§λ§ μ½λλ₯Ό λ·°μ λ°μΈλ©ν  μλ μμ΅λλ€. 

+ λ·° κ²°ν©μ μ½λμμ λ·°μ λ μ½κ² μ‘μΈμ€ν  μ μλ κΈ°λ₯μΌλ‘, κ° XML λ μ΄μμ νμΌμ κ²°ν© ν΄λμ€λ₯Ό μμ±ν©λλ€. κ²°ν© ν΄λμ€μ μΈμ€ν΄μ€μλ μμνλ λ μ΄μμμ IDκ° μλ λͺ¨λ  λ·°μ μ§μ  μ°Έμ‘°κ° ν¬ν¨λ©λλ€. μλ₯Ό λ€μ΄ Unscramble μ±μ νμ¬ λ·° κ²°ν©μ μ¬μ©νλ―λ‘ μμ±λ κ²°ν© ν΄λμ€λ₯Ό μ¬μ©νμ¬ μ½λμμ λ·°λ₯Ό μ°Έμ‘°ν  μ μμ΅λλ€.

  ```
  binding.textViewUnscrambledWord.text = newWord
  binding.score.text = getString(R.string.score, newScore)
  binding.wordCount.text =
                    getString(R.string.word_count, newWordCount, MAX_NO_OF_WORDS)
  ```

+ λ·° κ²°ν©μ μ¬μ©νλ©΄ **λ·°(λ μ΄μμ νμΌ)μμ μ± λ°μ΄ν°λ₯Ό μ°Έμ‘°ν  μ μμ΅λλ€.** μ΄ μμμ **λ°μ΄ν° κ²°ν©**μ μ¬μ©νλ©΄ λ©λλ€.

<br></br><br></br>

#### Data binding κ²°ν©

+ κ°λ¨ν λ§ν΄μ λ°μ΄ν° κ²°ν©μ 

  **binding data (from code) to views** + **view binding (binding views to code)**μ΄λ€. 

  => λ°μ΄ν°λ₯Ό λ·°μ λ°μΈλ©(λ μ΄μμ νμΌμμ μ± λ°μ΄ν°λ₯Ό μ°Έμ‘°ν  μ μλλ‘) + λ·°λ₯Ό μ½λμ λ°μΈλ©

  <br></br><br></br>

  + UI μ»¨νΈλ‘€λ¬μμ λ·° κ²°ν© μ¬μ©μ μ

    ```kotlin
    binding.textViewUnscrambledWord.text = viewModel.currentScrambledWord
    ```

  + λ μ΄μμ νμΌμμ λ°μ΄ν° κ²°ν© μ¬μ©μ μ

    ```kotlin
    android:text="@{gameViewModel.currentScrambledWord}"
    ```

  => μμ μμμλ λ°μ΄ν° κ²°ν© λΌμ΄λΈλ¬λ¦¬λ₯Ό μ¬μ©νμ¬ λ μ΄μμ νμΌμμ λ·°/μμ ―μ μ§μ  μ± λ°μ΄ν°λ₯Ό ν λΉνλ λ°©λ²μ λ³΄μ¬μ€λλ€. ν λΉ ννμμ μ¬μ©λλ `@{}` κ΅¬λ¬Έμ μ μνμΈμ. λ°μ΄ν° κ²°ν©μ μ¬μ©ν  λ μ£Όμ μ΄μ μ νλμμ λ§μ UI νλ μμν¬ νΈμΆμ μ­μ ν  μ μμ΄ νμΌμ΄ λμ± λ¨μν΄μ§κ³  λ μμ¬μ΄ μ μ§κ΄λ¦¬κ° κ°λ₯νλ€λ μ μλλ€. λν μ± μ±λ₯μ΄ ν₯μλλ©° λ©λͺ¨λ¦¬ λμ λ° null ν¬μΈν° μμΈλ₯Ό λ°©μ§ν  μ μμ΅λλ€.

<br></br><br></br>

#### 1. λ·° κ²°ν©μ λ°μ΄ν° κ²°ν©μΌλ‘ λ³κ²½νκΈ°

`build.gradle(Module)`

```kotlin
buildFeatures {
   dataBinding = true
}
 ...
plugins {
   id 'com.android.application'
   id 'kotlin-android'
   id 'kotlin-kapt'
}
```

μμ λ¨κ³λ μ±μ λͺ¨λ  λ μ΄μμ XML νμΌμ© κ²°ν© ν΄λμ€λ₯Ό μλμΌλ‘ μμ±ν©λλ€. λ μ΄μμ νμΌ μ΄λ¦μ΄ `activity_main.xml`μΈ κ²½μ° μλ μμ± ν΄λμ€μ μ΄λ¦μ `ActivityMainBinding`μ΄ λ©λλ€.

<br></br><br></br>

#### 2. λ μ΄μμ νμΌμ λ°μ΄ν° κ²°ν© λ μ΄μμμΌλ‘ λ³ννκΈ°

**λ°μ΄ν° κ²°ν© λ μ΄μμ** νμΌμ μ½κ° μ°¨μ΄κ° μμΌλ©° `<layout>`μ λ£¨νΈ νκ·Έλ‘ μμνκ³  μ νμ  `<data>` μμ λ° `view` λ£¨νΈ μμκ° λ€λ°λ¦λλ€. μ΄ view μμλ λ£¨νΈκ° κ²°ν© λ μ΄μμ νμΌμ΄ μλ νμΌμ μλ μμμλλ€.

1. `game_frament.xml`μ μ΄κ³  **code** ν­μ μ νν©λλ€.

2. λ μ΄μμμ λ°μ΄ν° κ²°ν© λ μ΄μμμΌλ‘ λ³ννλ €λ©΄ 

   ```kotlin
   <layout xmlns:android="http://schemas.android.com/apk/res/android"
      xmlns:app="http://schemas.android.com/apk/res-auto"
      xmlns:tools="http://schemas.android.com/tools">
   
      <data>
   
      </data>
   
      <ScrollView
          android:layout_width="match_parent"
          android:layout_height="match_parent">
   
          <androidx.constraintlayout.widget.ConstraintLayout
            ...
          </androidx.constraintlayout.widget.ConstraintLayout>
      </ScrollView>
   </layout>
   ```

   + **λ£¨νΈ μμλ₯Ό `<layout>` νκ·Έλ‘ wrapping**
   + **λ€μμ€νμ΄μ€ μ μ(`xmlns:`λ‘ μμνλ μμ±)λ₯Ό μ λ£¨νΈ μμλ‘ μ΄λ**
   + λ£¨νΈ μμ μμz μλ `<layout>` νκ·Έ λ΄λΆμ **`<data></data>` νκ·Έλ₯Ό μΆκ°**ν©λλ€.**

   => μ΄ κ³Όμ μ Android μ€νλμ€μμλ λ£¨νΈ μμ(`ScrollView`)λ₯Ό λ§μ°μ€ μ€λ₯Έμͺ½ λ²νΌμΌλ‘ ν΄λ¦­νκ³  **Show Context Actions** > **Convert to data binding layout**μ μ ννλ©΄ μλμΌλ‘ κ°νΈνκ² μΆκ°ν  μ μμ΅λλ€.

3. `GameFragment`μ `onCreateView()` λ©μλ μμ λΆλΆμμ λ°μ΄ν° κ²°ν©μ μ¬μ©νλλ‘ `binding` λ³μμ μΈμ€ν΄μ€νλ₯Ό λ³κ²½ν©λλ€. 

   ````kotlin
   // κΈ°μ‘΄ μ½λ
   binding = DataBindingUtil.inflate(inflater, R.layout.game_fragment, container, false)
   
   // data binding μ¬μ©
   binding = DataBindingUtil.inflate(inflater, R.layout.game_fragment, container, false)
   ````

<br></br><br></br><br></br>

### λ°μ΄ν° κ²°ν© λ³μ μΆκ°νκΈ°

+ λ μ΄μμ νμΌμμ `viewModel`μ μ± λ°μ΄ν°μ μ‘μΈμ€νλλ‘ μμ±μ μΆκ°ν©λλ€. μ½λμμ λ μ΄μμ λ³μλ₯Ό μ΄κΈ°νν©λλ€.

1. `game_frament.xml`μ `<data>` νκ·Έμ `<variable>`μ΄λΌλ νμ νκ·Έ λ΄μμ `GameViewModel` μ νμ `gameViewModel`μ΄λΌλ μμ±μ μ μΈν©λλ€. **μ΄ μμ±μ μ¬μ©νμ¬ `ViewModel`μ λ°μ΄ν°λ₯Ό λ μ΄μμμ κ²°ν©**ν  μ μμ΅λλ€.

   ```kotlin
   <data>
      <variable
          name="gameViewModel"
          type="com.example.android.unscramble.ui.game.GameViewModel" />
   </data>
   ```

   <br></br><br></br>

2. `gameViewModel` μ μΈ μλμμ `<data>` νκ·Έ λ΄λΆμ ** `Integer` μ νμ λ€λ₯Έ λ³μλ₯Ό μΆκ°**νκ³  μ΄ λ³μμ μ΄λ¦μ `maxNoOfWords`λ‘ μ§μ ν©λλ€. μ΄ λ³μλ **ViewModelμ λ³μμ λ°μΈλ©νμ¬ κ²μλ³ λ¨μ΄ μλ₯Ό μ μ₯**νλ λ° μ¬μ©ν©λλ€.

   ```kotlin
   <data>
      ...
      <variable
          name="maxNoOfWords"
          type="int" />
   </data>
   ```

   <br></br><br></br>

3. `GameFragment`μ `onViewCreated()` λ©μλ μμ λΆλΆμμ λ μ΄μμ λ³μ `gameViewModel` λ° `maxNoOfWords`λ₯Ό **μ΄κΈ°ν**ν©λλ€.

   ```kotlin
   override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
      super.onViewCreated(view, savedInstanceState)
   
      binding.gameViewModel = viewModel
   
      binding.maxNoOfWords = MAX_NO_OF_WORDS
   ...
   }
   ```

   <br></br><br></br>

4. `LiveData`λ μλͺ μ£ΌκΈ°λ₯Ό μΈμνλ©° μλ³ κ°λ₯ν©λλ€. λ°λΌμ λ μ΄μμμ **μλͺ μ£ΌκΈ° μμ μ**λ₯Ό μ λ¬ν΄μΌ ν©λλ€. `GameFragment`μ `onViewCreated()` λ©μλ λ΄μμ κ²°ν© λ³μ μ΄κΈ°ν μλμ λ€μ μ½λλ₯Ό μΆκ°ν©λλ€.

   ```kotlin
   // Specify the fragment view as the lifecycle owner of the binding.
   // This is used so that the binding can observe LiveData updates
   binding.lifecycleOwner = viewLifecycleOwner
   ```

   <br></br><br></br><br></br>

### κ²°ν© ννμ μ¬μ©νκΈ° 

κ²°ν© ννμμ λ μ΄μμ λ΄μμ λ μ΄μμ μμ±μ μ°¨μ‘°νλ μμ±(`andriod:text`)μμ μμ±λ©λλ€. λ μ΄μμ μμ±μ `<variable>` νκ·Έλ₯Ό ν΅ν΄ λ°μ΄ν° κ²°ν© λ μ΄μμ νμΌμ μλ¨μμ μ μΈλ©λλ€. μ’μ λ³μ μ€ νλλΌλ λ³κ²½λλ©΄ 'DB λΌμ΄λΈλ¬λ¦¬'κ° κ²°ν© ννμμ μ€ννκ³  μ΄μ λ°λΌ λ·°λ₯Ό μλ°μ΄νΈν©λλ€.

<br></br><br></br>

+ κ²°ν© ννμμ κ΅¬λ¬Έ

  κ²°ν© ννμμ `@` κΈ°νΈλ‘ μμνκ³  μ€κ΄νΈ `{}`λ‘ λνλ©λλ€. λ€μ μμμ `TextView` νμ€νΈλ `user` λ³μμ `firstName` μμ±μΌλ‘ μ€μ λ©λλ€.

  ex)

  ```
  <TextView android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="@{user.firstName}" />
  ```

<br></br><br></br>

1. νμ¬ λ¨μ΄μ κ²°ν© ννμ μΆκ°νκΈ°

   μ΄ λ¨κ³μμλ νμ¬ λ¨μ΄ νμ€νΈ λ·°λ₯Ό `ViewModel`μ `LiveData` κ°μ²΄μ λ°μΈλ©ν©λλ€. (λ·°λ₯Ό dataμ λ°μΈλ©)

   + `game_fragment.xml`μμ `text` μμ±μ `textView_unscrambled_word` νμ€νΈ λ·°μ μΆκ°ν©λλ€. μ λ μ΄μμ λ³μ `gameViewModel`μ μ¬μ©νκ³  `text` μμ±μ `@{gameViewModel.currentScrambledWord}`λ₯Ό ν λΉν©λλ€. 

     ```kotlin
     <TextView
        android:id="@+id/textView_unscrambled_word"
        ...
        android:text="@{gameViewModel.currentScrambledWord}"
        .../>
     ```

   + μ΄μ  `LiveData` λ³κ²½μ¬ν­ μλ°μ΄νΈκ° λ μ΄μμμ μ§μ  μμ λλ―λ‘ νλκ·Έλ¨ΌνΈμ λμ΄μ κ΄μ°°μ μ½λκ° νμνμ§ μμ΅λλ€. λ°λΌμ  `GameFragment`μμ `currentScrambledWord`μ `LiveData` κ΄μ°°μ μ½λλ₯Ό μ­μ ν©λλ€. 

     ```kotlin
     viewModel.currentScrambledWord.observe(viewLifecycleOwner,
        { newWord ->
            binding.textViewUnscrambledWord.text = newWord
        })
     ```

   μ±μ μ€ννλ©΄ μ κ³Ό λμΌνκ² μλνμ§λ§, μ΄μ  νμ€νΈ λ·°λ `LiveData` κ΄μ°°μκ° μλ **κ²°ν© ννμμ μ¬μ©νμ¬ UIλ₯Ό μλ°μ΄νΈ**ν©λλ€. 

<br></br><br></br>

2. μ μ λ° λ¨μ΄ μμ κ²°ν© ννμ μΆκ°νκΈ°

   + `game_fragment.xml`μμ λ€μ κ²°ν© ννμμ μ¬μ©νμ¬ `word_count` νμ€νΈ λ·°μ `text` μμ±μ μλ°μ΄νΈν©λλ€. `word_count` λ¬Έμμ΄ λ¦¬μμ€λ₯Ό μ¬μ©νκ³  `gameViewModel.currentWordCount` λ° `maxNoOfWords`λ₯Ό λ¦¬μμ€ λ§€κ°λ³μλ‘ μ λ¬ν©λλ€.

     ```kotlin
     <TextView
        android:id="@+id/word_count"
        ...
        android:text="@{@string/word_count(gameViewModel.currentWordCount, maxNoOfWords)}"  // getStringμ μ¬μ©ν΄μΌ νμ§ μλ 
        .../>
     ```

   + λ€μ κ²°ν© ννμμ μ¬μ©νμ¬ `score` νμ€νΈ λ·°μ `text` μμ±μ μλ°μ΄νΈν©λλ€. `score` λ¬Έμμ΄ λ¦¬μμ€λ₯Ό μ¬μ©νκ³  `gameViewModel.score`λ₯Ό λ¦¬μμ€ λ§€κ°λ³μλ‘ μ λ¬ν©λλ€.

     ```kotlin
     <TextView
        android:id="@+id/score"
        ...
        android:text="@{@string/score(gameViewModel.score)}"
        ... />
     ```

   + `GameFragment`μμ `LiveData` κ΄μ°°μλ₯Ό μ­μ ν©λλ€. μμνλ `LiveData`κ° λ³κ²½λλ©΄ κ²°ν© ννμμ΄ UIλ₯Ό μλ°μ΄νΈνλ―λ‘ μ΄ κ΄μ°°μλ λ μ΄μ νμνμ§ μμ΅λλ€.

     => λ°μ΄ν° λ°μΈλ© μ¬μ©νλ©΄ LiveData κ΄μ°°μ νμ γ΄

<br></br><br></br>

<br></br><br></br>



## π Quiz/Unit3/Pathway3

1. Which of the following are reasons to use a ViewModel?
   + A ViewModel and its data can survive orientation changes in an Activity/Fragment.
   + A ViewModel allows you to separate code that updates the UI from code that doesnβt need to rely on the UI or its lifecycle.

<br></br><br></br>

2. A ViewModel is destroyed after which of the following ?
   + after `onDestroy`, if it not a configuration change

<br></br><br></br>

3. True or False: You should execute time-consuming tasks and I/O requests in your Activity/Fragment.
   + False

<br></br><br></br>

4. Why should you initialize and store LiveData in your ViewModel instead of a UI Controller?
   + Both the ViewModel and LiveData are lifecycle aware.
   + To ensure that the LiveData isnβt destroyed when the UI Controller is destroyed.
   + To hide or separate implementation details making your app more flexible

<br></br><br></br>

5. `observe` allows you to do which of the following for changes?
   + a LiveData object

<br></br><br></br>

6. True or False: Itβs OK for a ViewModel to directly reference a `View` or `LifecycleOwner` class.
   + False
