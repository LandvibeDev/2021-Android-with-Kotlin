# π‘ Android Basics in Kotlin

## Unit #3 : Navigation

## PATHWAY #3 : Architecture components

<br/>

## π©π»βπ» ViewModelμ λ°μ΄ν° μ μ₯

#### π ViewModel

- λ·°μ νμλλ μ± λ°μ΄ν°μ λͺ¨λΈ
  - λͺ¨λΈμ μ±μ λ°μ΄ν° μ²λ¦¬λ₯Ό λ΄λΉνλ κ΅¬μ±μμλ‘, μν€νμ² μμΉμ λ°λΌ λͺ¨λΈμμ UIκ° λμΆλλ μ±μ λ§λ€ μ μλ€.

- μλλ‘μ΄λ νλ μμν¬μμ νλμ΄λ νλκ·Έλ¨ΌνΈκ° μλ©Έλκ³  λ€μ μμ±λ  λ νκΈ°λμ§ μλ μ± κ΄λ ¨ λ°μ΄ν°λ₯Ό μ μ₯νλ€.

- κ°μ²΄λ κ΅¬μ±μ΄ λ³κ²½λλ λμ μλμΌλ‘ μ μ§λμ΄(νλ λλ νλκ·Έλ¨ΌνΈ μΈμ€ν΄μ€μ²λΌ μλ©Έλμ§ μμ) λ³΄μ νκ³  μλ λ°μ΄ν°κ° λ€μ νλ λλ νλκ·Έλ¨ΌνΈ μΈμ€ν΄μ€μ μ¦μ μ¬μ©λ  μ μλ€.

<br/>

#### π ViewModel μΆκ°

- `MainActivity`μ `GameFragment`κ° ν¬ν¨λμ΄ μμΌλ©°, `GameFragment`λ `GameViewModel`μ μλ κ²μ κ΄λ ¨ μ λ³΄μ μ‘μΈμ€νλ€.
- `GameViewModel.kt` μμ±
  - `ViewModel`μ μλΈν΄λμ€
- **μ§μ μμ±** : μ νν κ°μ²΄κ° μλ getterμμ λ¬΄μΈκ°λ₯Ό λ°νν  μ μλ€. μ½κΈ° μ μ© λ²μ μ λ°μ΄ν°λ₯Ό λ°ννλλ‘ getter λ©μλλ₯Ό μ¬μ μν΄μ μ§μ μμ±μ κ΅¬ννλ€.
- **lateinit** : μ§μ° μ΄κΈ°ν. μμ±μ λμ€μ μ΄κΈ°ννλ €κ³  ν  λ μ°λ ν€μλλ‘ λ³μκ° μ΄κΈ°νλ  λκΉμ§λ λ³μμ λ©λͺ¨λ¦¬κ° ν λΉλμ§ μμμ μ‘μΈμ€νλ €κ³ νλ©΄ μ± λΉμ μμΌλ‘ μ’λ£λλ€.

<br/>

#### π λνμμ

- μλ¦Ό λνμμ κ΅¬μ±

  1. μλ¦Ό λνμμ
  2. μ λͺ©(μ νμ¬ν­)
  3. λ©μμ§
  4. νμ€νΈ λ²νΌ

  <img src="img/3-3_1_jumin.png" width=50% height=50% align="left">

<br/>

#### π μ΅μ’ μ½λ μμ  λΆλΆ

- `GameFragment.kt`  μμ  λΆλΆ

  ```kotlin
  class GameFragment : Fragment() {
      //GameFragmen ν΄λμ€ μλ¨μ GameViewModel μ νμ μμ± μΆκ°
      private val viewModel: GameViewModel by viewModels()
  
      // GameFragmentμμ μ½κΈ° μ μ© viewModel μμ±μΈ currentScrambledWordλ₯Ό μ¬μ©νλλ‘ μλ°μ΄νΈ
      private fun updateNextWordOnScreen() {
          binding.textViewUnscrambledWord.text = viewModel.currentScrambledWord
      }
  
      private fun showFinalScoreDialog() {
         //νλκ·Έλ¨ΌνΈ μ»¨νμ€νΈ μ λ¬νμ¬ μλ¦Ό λνμμ μμ±
         MaterialAlertDialogBuilder(requireContext())
            //λνμμ μ λͺ© μ€μ 
            .setTitle(getString(R.string.congratulations))
            //λνμμ μ΅μ’ μ μ νμ
            .setMessage(getString(R.string.you_scored, viewModel.score))
            //λ€λ‘ ν€λ₯Ό λλ¬ μλ¦Ό λνμμ μ·¨μν  μ μλλ‘ ν¨
            .setCancelable(false)
            .setNegativeButton(getString(R.string.exit)) { _, _ ->
                exitGame()
            }
            .setPositiveButton(getString(R.string.play_again)) { _, _ ->
                restartGame()
            }
            //μλ¦Ό λνμμ λ§λ€κ³  νμ
            .show()
  
      }
    	
    	//submitλ²νΌ
    	private fun onSubmitWord() {
        	val playerWord = binding.textInputEditText.text.toString()
        	//trueμΈ κ²½μ° λ€λ₯Έ λ¨μ΄ μ¬μ© κ°λ₯ -> λ€μ λ¨μ΄λ₯Ό νλ©΄μ μλ°μ΄νΈ
          if (viewModel.isUserWordCorrect(playerWord)) {
              setErrorTextField(false)
              if (viewModel.nextWord()) {
                  updateNextWordOnScreen()
              } 
            	else {
                  showFinalScoreDialog()
              }
          } 
        	else {
          		setErrorTextField(true)
     			}
  		}
    
    	//skipλ²νΌ
    	private fun onSkipWord() {
          if (viewModel.nextWord()) {
              setErrorTextField(false)
              updateNextWordOnScreen()
          } else {
              showFinalScoreDialog()
          }
  		}
    	
      private fun setErrorTextField(error: Boolean) {
         if (error) {
             binding.textField.isErrorEnabled = true
             binding.textField.error = getString(R.string.try_again)
         } else {
             binding.textField.isErrorEnabled = false
             binding.textInputEditText.text = null
         }
   	 }
    
    private fun restartGame() {
       //μ¬μμ λ©μλ νΈμΆ
       viewModel.reinitializeData()
       setErrorTextField(false)
       updateNextWordOnScreen()
  	}
  }
  ```

- `GameViewModel.kt`  μμ  λΆλΆ

  ```kotlin
  class GameViewModel : ViewModel() {
    	//GameFragment ν΄λμ€μμ GameViewModel ν΄λμ€λ‘ λ°μ΄ν° λ³μλ₯Ό μ΄λ
      //λνμμ - scoreλ³μμ μ§μ μμ± μΆκ°
  		private var _score = 0
  		val score: Int
     			get() = _score
    	//μ§μ μμ±
      private var _currentWordCount = 0
      val currentWordCount: Int
          get() = _currentWordCount
    
    	//μ§μ μμ± μ¬μ©νμ¬ GameViewModelλ΄μμλ§ _currentScrambledWordμ μ‘μΈμ€νκ³  μμ  κ°λ₯νκ² λ§λ€κΈ°
      private lateinit var _currentScrambledWord: String
      val currentScrambledWord: String
          get() = _currentScrambledWord
    
      //κ²μμ μ¬μ©νλ λ¨μ΄μ λͺ©λ‘ λ³΄μ  -> λ°λ³΅λ λ¨μ΄κ° μ μλμ§ μλλ‘
      private var wordsList: MutableList<String> = mutableListOf()
      
      //νλ μ΄μ΄κ° μΆμΈ‘ν΄μΌ ν  λ¨μ΄ λ³΄μ νλ ν΄λμ€ λ³μ (μ§μ° μ΄κΈ°ν)
      private lateinit var currentWord: String
    	
    	init {
     		 Log.d("GameFragment", "GameViewModel created!")
         //μ²« λ¨μ΄κ° "test"μ¬μ, μ± μμ μ λ€μμΈ λ¨μ΄ νμνκΈ° μν΄
     		 getNextWord()
  		}
    
    	private fun getNextWord() {
     			currentWord = allWordsList.random()
        	//λ¬Έμμ΄μ λ¬Έμλ°°μ΄λ‘ λ³ν
        	val tempWord = currentWord.toCharArray()
        	//μ΄ λ¨μ΄ λ°°μ΄μ κΈμ μμλ₯Ό λ°κΎΈκΈ°
  				tempWord.shuffle()
        	// μμ λ¨μ΄κ° μλ λ¨μ΄μ λμΌν κ²½μ° μ²λ¦¬
        	while (tempWord.toString().equals(currentWord, false)) {
     				 tempWord.shuffle()
  				}
        	//λ¨μ΄κ° μ΄λ―Έ μ¬μ©λμλμ§ μ¬λΆ νμΈ
        	if (wordsList.contains(currentWord)) {
     				 getNextWord()
  				} else {
    		 		 _currentScrambledWord = String(tempWord)
    		 		 ++currentWordCount
     				 wordsList.add(currentWord)
  			}
  		}
    
    // ViewModel λ΄μ λ°μ΄ν°λ₯Ό μ²λ¦¬νκ³  μμ νλ λμ°λ―Έ λ©μλ
    fun nextWord(): Boolean {
      return if (currentWordCount < MAX_NO_OF_WORDS) {
          getNextWord()
          true
      } else false
  	}
    
    private fun increaseScore() {
    		 _score += SCORE_INCREASE
  		}
    
  	//νλ μ΄μ΄μ λ¨μ΄ κ²μ¦, μΆμΈ‘ν λ¨μ΄κ° μ¬λ°λ₯΄λ©΄ μ μ μ¬λ¦Ό.
    fun isUserWordCorrect(playerWord: String): Boolean {
       if (playerWord.equals(currentWord, true)) {
           increaseScore()
           return true
       }
       return false
    }
    
    // κ²μ μ¬μμ λ‘μ§ - λ¨μ΄ μ 0μΌλ‘ μ¬μ€μ 
    fun reinitializeData() {
       _score = 0
       _currentWordCount = 0
       wordsList.clear()
       getNextWord()
  	}
  
  }
  ```

<br/>

#### π ViewModel μλͺ μ£ΌκΈ°

- μμ μκ° νλ©΄ νμ κ³Ό κ°μ κ΅¬μ± λ³κ²½μΌλ‘ μΈν΄ μλ©Έλλ κ²½μ°μλ μλ©Έλμ§ μλλ€. μμ μμ μ μΈμ€ν΄μ€λ λ€μ λ€μ΄μ΄κ·Έλ¨κ³Ό κ°μ΄ κΈ°μ‘΄ `ViewModel` μΈμ€ν΄μ€μ λ€μ μ°κ²°λλ€.

<img src="img/3-3_2_jumin.png" width=70% height=70%>



<br/>

<br/>

## π©π»βπ» ViewModelκ³Ό ν¨κ» LiveData μ¬μ©

#### π Livedata

- **μλͺ μ£ΌκΈ°λ₯Ό μΈμνλ μλ³ κ°λ₯ν λ°μ΄ν° νλ ν΄λμ€**
- λ°μ΄ν°λ₯Ό λ³΄μ νλ©°, λͺ¨λ  μ νμ λ°μ΄ν°μ μ¬μ©ν  μ μλ λνΌ
- κ΄μ°° κ°λ₯νλ©°, λ³΄μ ν λ°μ΄ν°κ° λ³κ²½λλ©΄ κ΄μ°°μμ μλ¦Όμ΄ μ κ³΅
- μλͺ μ£ΌκΈ°λ₯Ό μΈμνλ©°, νμ± μλͺ μ£ΌκΈ° μνμΈ κ΄μ°°μλ§ μλ°μ΄νΈ ν¨
- **`MutableLiveData`** : λ³κ²½ κ°λ₯ν λ²μ μ LiveDataλ‘, λ΄λΆμ μ μ₯λ λ°μ΄ν°μ κ°μ λ³κ²½ κ°λ₯ 
- **λ°μ΄ν° κ²°ν©** : μ½λμμ λ°μ΄ν°λ₯Ό λ·° + λ·° κ²°ν©μ κ²°ν©(λ·°λ₯Ό μ½λμ κ²°ν©)νλ κ²
  - λ·° κ²°ν©(λ¨λ°©ν₯ κ²°ν©) : μ½λμμ λ·°μ λ μ½κ² μ‘μΈμ€ν  μ μλ κΈ°λ₯, κ° XML λ μ΄μμ νμΌμ κ²°ν© ν΄λμ€λ₯Ό μμ±
  - `@{}` : ν λΉ ννμ
  - μ₯μ  : νλμμ λ§μ UI νλ μμν¬ νΈμΆμ μ­μ ν  μ μμ΄ νμΌμ΄ λ¨μν΄μ§κ³  λ μμ¬μ΄ μ μ§κ΄λ¦¬κ° κ°λ₯. μ± μ±λ₯μ΄ ν₯μλλ©° λ©λͺ¨λ¦¬ λμ λ° null ν¬μΈν° μμΈλ₯Ό λ°©μ§

<br/>

<br/>

------

## π©π»βπ» ν΄μ¦

1. ##### λ€μ μ€ ViewModelμ μ¬μ©νλ μ΄μ λ λ¬΄μμΈκ°μ?

   > ViewModel λ° κ΄λ ¨ λ°μ΄ν°λ νλ/νλκ·Έλ¨ΌνΈμ λ°©ν₯ λ³κ²½μ¬ν­μ μ μ§ν  μ μμ΅λλ€.
   >
   > ViewModelμ μ¬μ©νλ©΄ UI λλ μλͺ μ£ΌκΈ°μ μμ‘΄νμ§ μμλ λλ μ½λμμ UIλ₯Ό μλ°μ΄νΈνλ μ½λλ₯Ό λΆλ¦¬ν  μ μμ΅λλ€.

2. ##### λ€μ μ€ μΈμ  ViewModelμ΄ μλ©Έλλμ?

   > `onDestroy` ν(κ΅¬μ± λ³κ²½μ΄ μλ κ²½μ°)

3. ##### μ°Έ λλ κ±°μ§: νλ/νλκ·Έλ¨ΌνΈμμ μκ°μ΄ μ€λ κ±Έλ¦¬λ μμ λ° I/O μμ²­μ μ€νν΄μΌ ν©λλ€.

   > κ±°μ§

4. ##### UI μ»¨νΈλ‘€λ¬ λμ  ViewModelμμ LiveDataλ₯Ό μ΄κΈ°ννκ³  μ μ₯ν΄μΌ νλ μ΄μ λ λ¬΄μμΈκ°μ?

   > ViewModelκ³Ό LiveDataκ° λͺ¨λ μλͺ μ£ΌκΈ°λ₯Ό μΈμνλ―λ‘
   >
   > UI μ»¨νΈλ‘€λ¬κ° μλ©Έλ  λ LiveDataκ° μλ©Έλμ§ μλλ‘ νκΈ° μν΄
   >
   > κ΅¬ν μΈλΆμ λ³΄λ₯Ό μ¨κΈ°κ±°λ λΆλ¦¬νμ¬ μ±μ μ μ°μ±μ ν₯μνκΈ° μν΄

5. ##### `observe`λ₯Ό μ¬μ©νλ©΄ λ³κ²½μ μν΄ λ€μ μ€ λ¬΄μμ ν  μ μλμ?

   > LiveData κ°μ²΄

6. ##### μ°Έ λλ κ±°μ§: ViewModelμμ `View` λλ `LifecycleOwner` ν΄λμ€λ₯Ό μ§μ  μ°Έμ‘°ν΄λ κ΄μ°?μ΅λλ€.

   >  κ±°μ§
