

# 2021 Landvibe Summer Coding - Android

## Unit3 - Navigation

## PathWay3 - Architecture Components

#### ViewModel에 데이터 저장하기

##### &#128204;Unscramble 앱

- game_fragment.xml
  - 게임 화면의 레이아웃 - 플레이어의 단어를 위한 텍스트 필드와 점수 및 단어 수를 표시하는 `TextViews`와 게임 플레이를 위한 안내 및 버튼 포함
- main_activity.xml
  - 기본 활동 레이아웃 정의
- res/value
  - `colors.xml` : 테마 색상
  - `strings.xml` : 문자열
  - `thems`폴더와 `styles` 폴더에는 앱의 UI 맞춤 설정이 존재
- MainActivity.kt
  - 활동의 콘텐츠 뷰를 `activity_main.xml`로 설정하기 위한 기본 템플릿 생성 코드 존재
- ListOfWords.kt
  - 게임에서 사용되는 단어 목록과 게임당 최대 단어 수, 올바르게 추측한 모든 단어에 적용할 점수가 상수로 포함되어 있음
- GameFragment.kt
  - 글자가 뒤섞인 현재 단어(`currentScrambledWord`), 단어 수(`currentWordCount`), 점수(`score`)를 나타내는 변수 정의
  - `game_fragment` 뷰에 액세스할 권한이 있는 결합 객체 인스턴스 `binding` 정의
  - `onCreateView()`는 결합 객체를 사용하여 `game_fragment` 레이아웃 XML 확장
  - `onViewCreated()`는 버튼 클릭 리스너를 설정하고 UI를 업데이트
  - `onSubmitWord()`는 **Submit** 버튼의 클릭 리스너로 글자가 뒤섞인 다음 단어를 표시하고 텍스트 필드를 지우고 플레이어의 단어를 검증하지 않고 점수와 단어 수를 높임
  - `onSkipWord()`는 **Skip** 버튼의 클릭 리스너로 점수를 제외하고 `onSubmitWord()`와 유사하게 UI를 업데이트
  - `getNextScrambledWord()`는 단어 목록에서 임의의 단어를 선택하여 단어에 있는 글자를 섞는 도우미 함수
  - `restartGame()` 함수와 `exitGame()` 함수는 각각 게임을 다시 시작하고 종료하는 데 사용됨
  - `resetTextField()`는 텍스트 필드의 내용을 지우고 오류 상태 재설정
  - `updateNextWordOnScreen()` 함수는 글자가 뒤섞인 새로운 단어를 표시



##### &#128204;앱 아키텍처 알아보기

- 아키텍처 원칙
  - 관심사 분리 : 각각 별개의 책임이 있는 여러 클래스로 앱을 나눠야 한다는 원칙
  - 모델에서 UI 만들기 : 모델에서 UI를 만들어야 한다는 원칙, 가급적 지속적인 모델을 권장
- 모델 : 앱의 데이터 처리를 담당하는 구성요소로 앱의 `Views` 객체 및 앱 구성요소와 독립되어 있으므로 앱의 수명 주기 및 관련 문제의 영향을 받지 않음 
- Android 아키텍처의 기본 클래스 or 구성요소 : UI 컨트롤러(활동/프래그먼트), `ViewModel`, `LiveData`, `Room`
- ViewModel : 뷰에 표시되는 앱 데이터의 모델



##### &#128204;ViewModel 추가하기

```kotlin
class GameViewModel : ViewModel() {
}
```

```kotlin
//ViewModel을 UI 컨트롤러에 연결하기 위해 ViewModel에 관한 참조(객체) 생성
//viewModel 객체의 책임을 viewModels(대리자 클래스)라는 별도 클래스에 위임
private val viewModel: GameViewModel by viewModels()
```

- Kotlin 속성 위임

  - getter-setter 책임을 다른 클래스에 넘길 수 있음

  - `var` 속성 : getter, setter 함수 생성

  - `val` 속성 : getter 함수만 생성

  - 대리자 클래스는 속성의 getter 및 setter 함수를 제공하고 변경사항 처리

    - `by` 및 대리자 클래스 인스턴스를 사용하여 정의됨

      ```kotlin
      var <property-name> : <property-type> by <delegate-class>()
      ```

  - 기본 생성자를 사용해 뷰 모델을 초기화 하는 경우 

    - 기기에서 구성이 변경되는 동안 앱이 `viewModel`참조의 상태를 손실하게 됨 :point_right: 속성 위임 접근 방식을 사용해 `viewModel` 객체의 책임을 `viewModels`라는 대리자 클래스에 위임

##### &#128204;ViewModel로 데이터 이동하기

- `GameFragment`클래스에서 `GameViewModel`클래스로 데이터 변수 이동

  ```kotlin
  class GameViewModel : ViewModel() {
  	private var score = 0
  	private var currentWordCount = 0
  	private var currentScrambledWord = "test"
  	...
  }
  ```

- 지원 속성

  - 지원 속성을 사용하면 정확한 객체가 아닌 getter에서 무언가를 반환할 수 있음
  - 지원 속성을 구현하려면 읽기 전용 버전의 데이터를 반환하도록 getter 메서드를 재정의
  - 앱에서 앱 데이터가 `ViewModel`에만 공개되는 예
    - `ViewModel` 클래스 내부 
      - `_count`속성이 `private`이며 변경 가능
      - `ViewModel` 클래스 내에서만 액세스, 수정 가능
    - `ViewModel` 클래스 외부
      - `count`는 공개 속성이며 UI 컨트롤러와 같은 다른 클래스에서 액세스 가능
      - `get()` 메서드만 재정의되므로, 변경할 수 없는 읽기 전용임

- currentScrambledWord에 지원 속성 추가하기

  ```kotlin
  private var _currentScrambledWord = "test"
  val currentScrambledWord: String
  	get() = _currentScrambledWord
  
  private fun updateNextWordOnScreen() {
      binding.textViewUnscrambledWord.text = viewModel.currentScrambledWord
  }
  ```

  - `GameFragment`에서 `onSubmitWord()`메서드와 `onSkipWord()`메서드 내의 코드 삭제

##### &#128204;ViewModel의 수명 주기

<img src="https://developer.android.com/codelabs/basic-android-kotlin-training-viewmodel/img/18e67dc79f89d8a.png" alt="18e67dc79f89d8a.png" style="zoom: 50%;" />

- ViewModel의 수명 주기 이해하기

  ```kotlin
  class GameViewModel : ViewModel() {
      //객체 인스턴스가 처음 생성되어 초기화될 때 실행
  	init {
  		Log.d("GameFragment", "GameViewModel created!")
  	}
      
      //ViewModel이 소멸되기 직전에 실행
      override fun onCleared() {
  		super.onCleared()
          Log.d("GameFragment", "GameViewModel destroyed!")
      }
      
      //프래그먼트가 처음으로 생성되면 트리거될 뿐만 아니라 구성 변경과 같은 모든 이벤트에 관해 프래그먼트가 다시 생성될 때마다 트리거 됨
      override fun onCreateView(
          inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) : View {
  		binding = GameFragmentBinding.inflate(inflater, container, false) 
          Log.d("GameFragment", "GameFragmet created/re-created!")
          return binding.root
      }
      
      //상응하는 활동과 프래그먼트가 소멸될 때 호출
      override fun onDetach() {
  		super.onDetach() 
          Log.d("GameFragment", "GameFragment destroyed!")
      }
  }
  ```



##### &#128204; ViewModel 채우기

- 자연 초기화

  - 속성을 나중에 초기화하려면 지연된 초기화를 의미하는 `lateinit`키워드 사용
  - 변수가 초기화될 때까지 변수에 메모리가 할당되지 않음
  - 초기화 전에 변수에 액세스하려고 하면 앱이 비정상 종료됨

- 다음 단어 가져오기

  - `GameViewModel` 클래스 구현

    ```kotlin
    //새로운 클래스 변수 wordList를 추가해 반복된 단어가 제시되지 않도록 함
    private var wordList: MutableList<String> = mutableListOf() 
    //플레이어가 추측해야 할 단어를 보유하는 변수 추가 - 나중에 초기화
    private lateinit var currentWord: String
    private lateinit var _currentScrambledWord: String
    
    private fun getNextWord() {
    	currentWord = allWordList.random()
    	
    	val tempWord = currentWord.toCharArray() 
    	tempWord.shuffle() //배열의 글자 순서 섞기
    	
    	//단어가 이미 사용되었는지 여부 확인
    	while(tempWord.toString().equals(currentWord, flase)){
    		if (wordsList.contains(currentWord)){
    			getNextWord()
    		} else {
    			_currentScrambledWord = String(tempWord) 
    			++currentWordCount
    			wordsList.add(currentWord)
    		}
    	}
    }
    
    private fun getNextWord() {
    	currentWord = allWordsList.random() 
    	val tempWord = currentWord.toCharArray()
    	tempWord.shuffle()
    	
    	while( tempWord.toString().equals(currentWord, false)){
    		tempWord.shuffle()
    	}
    	if( wordsList.contains(currentWord)){
    		getNextWord()
    	} else {
    		_currentScrambledWord = String(tempWord)
    		++currentWordCount
    		wordsList.add(currentWord)
    	}
    }
    ```

    ```kotlin
    init {
    	Log.d("GameFragment", "GameViewModel created!")
    	getNextWord()
    }
    ```

- 도우미 메서드 추가하기

  ```kotlin
  fun nextWord(): Boolean {
  	reutrn if( currentWordCount < MAX_NO_OF_WORDS) {
  		getNextWord()
  		true
  	} else false
  }
  ```

  

##### &#128204;대화상자

- 알림 대화상자 구성

  - 알림 대화상자
  - 제목(선택사항)
  - 메시지
  - 텍스트 버튼

- 최종 점수 대화상자 구현하기

  - `GameViewModel` 변경

    ```kotlin
    private var _score = 0
    val score: Int
    	get() = _score
    ```

  - `GameFragment`에 함수 추가

    ```kotlin
    private fun showFinalScoreDialog() {
            MaterialAlertDialogBuilder(requireContext()) //프래그먼트 컨텍스트를 전달해 알림 대화상자 생성
                .setTitle(getString(R.string.congratulations)) //문자열 리소스를 사용해 알림 대화상자 제목 설정
                .setMessage(getString(R.string.you_scored, viewModel.score)) // 최종 점수 표시
                .setCancelable(false) // 뒤로 키를 눌러 알림 대화상자를 취소할 수 없도록 함
                .setNegativeButton(getString(R.string.exit)) { _, _ ->
                    exitGame()
                } // EXIT 버튼 추가
                .setPositiveButton(getString(R.string.play_again)) { _, _ ->
                    restartGame()
                } // PLAY AGAIN 버튼 추가
                .show() // 알림 대화 상자를 만들고 표시
        }
    ```

    

##### &#128204;Submit 버튼의 OnClickListener 구현하기

- 글자가 뒤섞인 단어 표시하기

  - `GameFragment`

    ```kotlin
    private fun onSubmitWord() {
    	if( viewModel.nextWord()) {
    		updateNextWordOnScreen()
    	} else {
    		showFinalScoreDialog()
    	}
    }
    ```

- 플레이어의 단어를 검증하는 도우미 메서드 추가하기

  - `GameViewModel`

    ```kotlin
    private fun increaseScore() {
    	_score += SCORE_INCREASE
    }
    ...
    //플레이어의 단어를 검증하고 플레이어가 추측한 단어가 올바르면 점수를 높이는 함수 추가
    fun isUserWordCorrect(playerWord: String): Boolean {
    	if( playerWord.equals(currentWord, true)){
    		increaseScore()
            return true
        }
        return false
    }
    ```

- 텍스트 필드에 오류 표시하기

  - `GameViewModel`

    ```kotlin
    private fun onSubmitWord() {
        val playerWord = binding.textInputEditText.text.toString()
    	
        //사용자 단어가 옳지 않은 경우 텍스트 필드에 오류 메시지 표시
        if (viewModel.isUserWordCorrect(playerWord)) {
            setErrorTextField(false)
            if (viewModel.nextWord()) {
                updateNextWordOnScreen()
            } else {
                showFinalScoreDialog()
            }
        } else {
            setErrorTextField(true)
        }
    }
    ```



##### &#128204;Skip 버튼 구현하기

- `onSkipWord()` 구현

  ```kotlin
  private fun onSkipWord() {
  	if( viewModel.nextWord()) {
  		setErrorTextField(false)
  		updateNextWordOnScreen()
  	} else {
  		showFinalScoreDialog()
  	}
  }
  ```

  

##### &#128204;ViewModel에 데이터가 보존되는지 확인하기

- `GameViewModel`에서 `currentWordCount`변수를 마우스 오른쪽 버튼으로 클릭하고 **Refactor > Rename..**을 선택하고 새 이름 앞에 밑줄 붙이기

  ```kotlin
  private var _currentWordCount = 0
  val currentWordCount: Int
  	get() = _currentWordCount
  ```

- `GameFragment`의 `onCreateView()`에 로그 추가

  ```kotlin
  Log.d("GameFragment", "Word: ${viewModel.currentScrambledWord} " +
         "Score: ${viewModel.score} WordCount: ${viewModel.currentWordCount}")
  ```



##### &#128204;게임 재시작 로직 업데이트하기

- `GameViewModel`에 `reinitializeData()`메서드를 추가해 앱 데이터 재설정

  ```kotlin
  fun reinitializeData() {
  	_score = 0
  	_currentWordCount = 0
  	wordsList.clear()
  	getNextWord()
  }
  ```

- `GameFragment`

  ```kotlin
  private fun restartGame(){
  	viewModel.reinitializeData()
      setErrorTextField(false)
      updateNextWordOnScreen()
  }
  ```



##### &#128204;최종 코드

- `GameFragment.kt`

  ```kotlin
  package com.example.android.unscramble.ui.game
  
  import android.os.Bundle
  import android.util.Log
  import android.view.LayoutInflater
  import android.view.View
  import android.view.ViewGroup
  import androidx.fragment.app.Fragment
  import androidx.lifecycle.ViewModel
  import androidx.fragment.app.viewModels
  import com.example.android.unscramble.R
  import com.example.android.unscramble.databinding.GameFragmentBinding
  import com.google.android.material.dialog.MaterialAlertDialogBuilder
  
  
  class GameFragment : Fragment() {
      //ViewModel을 UI 컨트롤러에 연결하기 위해 ViewModel에 관한 참조(객체) 생성
      //viewModel 객체의 책임을 viewModels(대리자 클래스)라는 별도 클래스에 위임
      private val viewModel: GameViewModel by viewModels()
  
      private lateinit var binding: GameFragmentBinding
  
      override fun onCreateView(
              inflater: LayoutInflater, container: ViewGroup?,
              savedInstanceState: Bundle?
      ): View {
          binding = GameFragmentBinding.inflate(inflater, container, false)
          Log.d("GameFragment", "GameFragment created/re-created!")
          Log.d("GameFragment", "Word: ${viewModel.currentScrambledWord} " +
                  "Score: ${viewModel.score} WordCount: ${viewModel.currentWordCount}")
          return binding.root
      }
  
      override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
          super.onViewCreated(view, savedInstanceState)
  
          //submit과 skip버튼의 클릭 리스너 설정
          binding.submit.setOnClickListener { onSubmitWord() }
          binding.skip.setOnClickListener { onSkipWord() }
  
          updateNextWordOnScreen()
          binding.score.text = getString(R.string.score, 0)
          binding.wordCount.text = getString(R.string.word_count, 0, MAX_NO_OF_WORDS)
      }
  
      //사용자의 단어를 확인하고 점수 업데이트
      //다음 섞인 단어 표시
      //마지막 단어 후에는 사용자의 최종 점수 표시
      private fun onSubmitWord() {
          val playerWord = binding.textInputEditText.text.toString()
          if (viewModel.isUserWordCorrect(playerWord)) {
              setErrorTextField(false)
              if (viewModel.nextWord()) {
                  updateNextWordOnScreen()
              } else {
                  showFinalScoreDialog()
              }
          } else {
              setErrorTextField(true)
          }
      }
  
      //점수 변화 없이 해당 단어 넘기기
      private fun onSkipWord() {
          if( viewModel.nextWord()) {
              setErrorTextField(false)
              updateNextWordOnScreen()
          } else {
              showFinalScoreDialog()
          }
      }
  
      //랜덤 단어 뽑기
    private fun getNextScrambledWord(): String {
          val tempWord = allWordsList.random().toCharArray()
          tempWord.shuffle()
          return String(tempWord)
      }
  
      //ViewModel의 데이터 초기화 및 새로운 데이터의 뷰들을 업데이트
      private fun restartGame() {
          setErrorTextField(false)
          updateNextWordOnScreen()
      }
  
      //게임 나가기기
      private fun exitGame() {
          activity?.finish()
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
      //다음 섞인 단어를 표시
      private fun updateNextWordOnScreen() {
          binding.textViewUnscrambledWord.text = viewModel.currentScrambledWord
      }
  
      //최종 점수를 알림 대화상자로 표시
      private fun showFinalScoreDialog() {
          MaterialAlertDialogBuilder(requireContext()) //프래그먼트 컨텍스트를 전달해 알림 대화상자 생성
              .setTitle(getString(R.string.congratulations)) //문자열 리소스를 사용해 알림 대화상자 제목 설정
              .setMessage(getString(R.string.you_scored, viewModel.score)) // 최종 점수 표시
              .setCancelable(false) // 뒤로 키를 눌러 알림 대화상자를 취소할 수 없도록 함
              .setNegativeButton(getString(R.string.exit)) { _, _ ->
                  exitGame()
              } // EXIT 버튼 추가
              .setPositiveButton(getString(R.string.play_again)) { _, _ ->
                  restartGame()
              } // PLAY AGAIN 버튼 추가
              .show() // 알림 대화 상자를 만들고 표시
      }
  }
  ```

- `GameViewModel.kt`

  ```kotlin
  package com.example.android.unscramble.ui.game
  
  import android.util.Log
  import androidx.lifecycle.ViewModel
  
  class GameViewModel : ViewModel() {
      //GmaeFragment에서 GameViewModel로 데이터 변수 이동
      //score 변수에 지원 속성 추가
      private var _score = 0
      val score: Int
          get() = _score
  
      private var _currentWordCount = 0
      val currentWordCount: Int
          get() = _currentWordCount
  
      //지원 속성 추가 - GameViewModel내에서만 액세스하고 수정 가능
      private lateinit var _currentScrambledWord:String
      val currentScrambledWord: String
          get() = _currentScrambledWord
  
      private var wordsList: MutableList<String> = mutableListOf()
      private lateinit var currentWord: String
  
      init {
          Log.d("GameFragment", "GameViewModel created!")
          getNextWord()
      }
  
      override fun onCleared(){
          super.onCleared()
          Log.d("GameFragment", "GameViewModel destroyed!")
      }
  
      private fun getNextWord(){
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
              ++_currentWordCount
              wordsList.add(currentWord)
          }
      }
  
  
      private fun increaseScore() {
          _score += SCORE_INCREASE
      }
  
    fun nextWord(): Boolean{
        return if( _currentWordCount < MAX_NO_OF_WORDS) {
            getNextWord()
            true
        } else false
    }
  
  
      fun isUserWordCorrect(playerWord: String): Boolean {
          if (playerWord.equals(currentWord, true)) {
              increaseScore()
              return true
          }
          return false
      }
  
  }
  ```



### ViewModel과 함께 LiveData 사용하기

##### &#128204;Livedata란?

- `LiveData` : 수명 주기를 인식하는 식별 가능한 데이터 홀더 클래스
  - 특성
    - 데이터를 보유, 모든 유형의 데이터에 사용할 수 있는 래퍼
    - 관찰 가능, 객체에서 보유한 데이터가 변경되면 관찰자에 알림이 제공됨
    - 수명 주기를 인식함, `LiveData`에 관찰자를 연결하면 관찰자는 `LifecycleOwner`와 연결됨
    - `STARTED` 또는 `RESUMED`와 같은 활성 수명 주기 상태인 관찰자만 업데이트함



##### &#128204;글자가 뒤섞인 현재 단어에 LiveData 추가하기

- `MutableLiveData` : 변경 가능한 버전의 `LiveData`

- `GameViewModel`

  ```kotlin
  private val _currentScrambledWord = MutableLiveData<String>()
  val currentScrambledWord: LiveData<String>
  	get() = _currentScrambledWord
  ...
  private fun getNextWord() {
  ...
  	} else {
      	//LiveData 객체 내의 데이터에 액세스하려면 value속성 사용
  		_currentScrambledWord.value = String(tempWord)
      	...
  	}
  }
  ```



##### &#128204;LiveData 객체에 관찰자 연결하기

- `GameFragment`에서 앱 데이터 `currentScrambledWord`의 변경사항을 관찰하는 관찰자 추가(`STARTED` 또는 `RESUMED`상태인 경우에만 알림 받음)

  ```kotlin
  private fun onSubmitWord() {
  	val playerWord = binding.textInputEditText.text.toString()
  	
  	if( viewModel.isUserCorrect(playerWord)){
  		setErrorTextField(false)
  		if( !viewModel.nextWord()){
  			showFinalScoreDialog()
  		}
  	} else {
  		setErrorTextField(true)	
  	}
  }
  ```

- `onViewCreated()`콜백 끝에서 `observe()`메서드 호출

  ```kotlin
  viewModel.currentScrambledWord.observe()
  ```

- `viewLifecycleOwner`를 첫 번째 매개변수로 `observe()`메서드에 전달

  ```kotlin
  viewModel.currentScrambledWord.observe(viewLifecycleOwner, 
  	{newWord -> 
       	binding.textViewScrambledWord.text = newWord
  	})
  ```



##### &#128204;점수 및 단어 수에 관찰자 연결하기

- 1단계 : LiveData로 점수 및 단어 수 래핑하기

  - `GameViewModel`

    ```kotlin
    private val _score = MutableLiveData(0)
    val score: LiveData<Int>
    	get() = _score
    	
    private val _currentWordCount = MutableLiveData(0) 
    val currentWordCount: LiveData<Int>
    	get() = _currentWordCount
    
    ...
    
    fun reinitializeData() {
    	_score.value = 0
        _currentWordCount.value = 0
        wordsList.clear()
        getNextWord()
    }
    
    ...
    
    fun nextWord(): Boolean {
    	return if( _currentWordCount.value!! < MAX_NO_OF_WORDS) {
    		getNextWord()
            true
        } else false
    }
    
    ...
    
    private fun increaseScore() {
        //plus()를 사용해 _score값을 늘려 null에 안전하게 덧셈이 처리됨
        _score.value = (_score.value)?.plus(SCORE_INCREASE)
    }
    
    ...
    
    private fun getNextWord(){
    	...
    	} else {
    		_currentScrambledWord.value = String(tempWord)
        	_currentWordCount.value = (_currentWordCount.value)?.inc()
        	wordsList.add(currentWord)
    	}
    }
    ```

  - `GameFragment`

    ```kotlin
    private fun showFinalScoreDialog(){
    	MaterialAlertDialogBuilder(requireContext())
    		.setTitle(getString(R.string.congratulations))
    		.setMessage(getString(R.string.you_scored, viewModel.score.value))
    		...
    		.show()
    }
    ```

- 2단계 : 관찰자를 점수 및 단어 수에 연결하기

  - `GameFragment`의 `onViewCreated()`메서드 내에서 점수 및 단어 수 텍스트 뷰를 업데이트하는 코드 삭제

  - `GameFragment`

    ```kotlin
    override fun onViewCreated() {
    	...
    	viewModel.score.observe(viewLifecycleOwner, 
    		{ newScore -> 
    			binding.score.text = getString(R.string.score, newScore)
    	})
    	viewModel.currentWordCount.observe(viewLifecycleOwner, 
    	{ newWordCount -> 
    		binding.wordCount.text = 
    			getString(R.string.word_count,newWordCount, 			Max_NO_OF_WORDS)
    	})
    }
    ```

    

##### &#128204;데이터 결합과 함께 LiveData 사용하기

- 뷰 결합 : 코드에서 뷰에 더 쉽게 액세스할 수 있는 기능, 각 XML 레이아웃 파일의 결합 클래스 생성

- 데이터 결합 

  - 뷰 결합으로 인해 뷰에서 앱 데이터 참조가 불가능 할 때 사용
  - 선언적 형식을 사용해 레이아웃의 UI 구성요소를 앱의 데이터 소스에 바인딩
  - 코드에서 데이터를 뷰 + 뷰 결합에 결합하는 것
  - 할당 표현식 `@{}`
  - 활동에서 많은 UI 프레임워크 호출을 삭제할 수 있어 파일이 더욱 단순해지고 더 손쉬운 유지관리가 가능
  - 앱 성능이 향상되며 메모리 누수 및 null포인터 예외를 방지할 수 있음

- 1단계 : 뷰 결합을 데이터 결합으로 변경하기

  - `build.gradle(Module)`

    ```kotlin
    buildFeatures {
    	dataBinding = true
    }
    ```

- 2단계 : 레이아웃 파일을 데이터 결합 레이아웃으로 변환하기

  - `game_fragment.xml`을 열고 **code**탭 선택 후 루트 요소를 `<layout>` 태그로 래핑

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

  - `GameFragment`의 `onCreateView()`시작 부분

    ```kotlin
    binding = DataBindingUtil.inflate(inflater, R.layout.game_fragment, container, false)
    ```



##### &#128204;데이터 결합 변수 추가하기

- `game_fragment.xml`에 추가

  ```kotlin
  <data>
     <variable
         name="gameViewModel"
     <data>
     		...
     		<variable
     	    name="maxNoOfWords"
        	type="int" />
  	</data>
  type="com.example.android.unscramble.ui.game.GameViewModel" />
  </data>
  ```

- `GameFragment`

  ```kotlin
  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
     super.onViewCreated(view, savedInstanceState)
  
     binding.gameViewModel = viewModel
  
     binding.maxNoOfWords = MAX_NO_OF_WORDS     		
     binding.lifecycleOwner = viewLifecycleOwner
  ...
  }
  ```



##### &#128204;결합 표현식 사용하기

- 1단계 : 현재 단어에 결합 표현식 추가하기

  - `game_fragment.xml`

    ```kotlin
    <TextView
       android:id="@+id/textView_unscrambled_word"
       ...
       android:text="@{gameViewModel.currentScrambledWord}"
       .../>
    ```

  - `GameFragment`에서 `currentScrambledWord`의 `LiveData`관찰자 ㅗㅋ드 삭제

- 2단계 : 점수 및 단어 수에 결합 표현식 추가하기

  - `game_fragment.xml`

    ```kotlin
    <TextView
       android:id="@+id/word_count"
       ...
       android:text="@{@string/word_count(gameViewModel.currentWordCount, maxNoOfWords)}"
       .../>
    
    <TextView
       android:id="@+id/score"
       ...
       android:text="@{@string/score(gameViewModel.score)}"
       ... />
    ```

  - `GameFragment`에서 `LiveData`관찰자 삭제



##### &#128204;음성 안내 지원 사용 설정

```kotlin
val currentScrambledWord: LiveData<Spannable> = Transformations.map(_currentScrambledWord) {
    if (it == null) {
        SpannableString("")
    } else {
        val scrambledWord = it.toString()
        val spannable: Spannable = SpannableString(scrambledWord)
        spannable.setSpan(
            TtsSpan.VerbatimBuilder(scrambledWord).build(),
            0,
            scrambledWord.length,
            Spannable.SPAN_INCLUSIVE_INCLUSIVE
        )
        spannable
    }
}
```



##### &#128204;사용하지 않는 코드 삭제하기

- `GameFragment`에서 `getNextScrambledWord()` 메서드와 `onDetach()` 메서드 삭제
- `GameViewModel`에서 `onCleared()` 메서드 삭제
- 소스 파일 맨 위에서 사용되지 않는 가져오기를 삭제, 회색으로 표시됨
- 로그 구문 삭제



#### &#128204;Quiz

1. ViewModel을 사용하는 이유

   - ViewModel및 관련 데이터는 활동/프래그먼트의 방향 변경사항을 유지할 수 있음
   - ViewModel을 사용하면 UI 또는 수명 주기에 의존하지 않아도 되는 코드에서 UI를 업데이트하는 코드를 분리할 수 있음

2. ViewModel이 소멸되는 때

   - `onDestroy` 후 ( 구성 변경이 아닌 경우)

3. 활동/프래그먼트에서 시간이 오래 걸리는 작업 및 I/O요청을 실행해야 한다.

   :point_right: 거짓

4. UI컨트롤러 대신 ViewModel에서 LiveData를 초기화하고 저장해야 하는 이유

   - ViewModel과 LiveData가 모두 수명 주기를 인식해서
   - UI 컨트롤러가 소멸될 때 LiveData가 소멸되지 않도록 하기 위해
   - 구현 세부정보를 숨기거나 분리하여 앱의 유연성을 향상하기 위해

5. `observe`를 사용하면 변경할 수 있는 것

   :point_right: LiveData 객체​

6. ViewModel에서 `View`또는 `LifecycleOwner` 클래스를 직접 참조해도 괜찮다.

   :point_right: 거짓

   

