

# 2021 Landvibe Summer Coding - Android



## Unit3 : Navigation

## PathWay3 : Architecture components



### ViewModel에 데이터 저장

- **unscramble-app-starter 만들기** 

  - **game_fragment.xml**
    - 게임 화면의 레이아웃이 포함되어 있음
    - 플레이어의 단어를 위한 텍스트 필드와 점수 및 단어 수를 표시하는 `TextViews`가 존재
    - 게임 플레이를 위한 Submit과 Skip이 있음
  - **main_activity.xml**
    - 기본 활동 레이아웃 정의
  - **res/values**
    - `colors.xml` : 앱에서 사용되고 있는 테마 색상
    - `strings.xml` : 앱에 필요한 모든 문자열 존재
    - `thems` 폴더와 `styles` 폴더에는 앱의 UI 맟춤 설정이 존재
  - **MainActivity.kt**
    - 활동의 콘텐츠 뷰를 `activity_main.xml`로 설정하기 위한 기본 템플릿 생성 코드 존재
  - **ListOfWords.kt**
    - 게임에서 사용되고 있는 단어 목록 존재
    - 게임당 최대 단어 수와 올바르게 추측한 모든 단어에 적용할 점수가 상수로 존재
  - **GameFragment.kt**
    - `currentScrambleWord`(글자가 뒤섞인 현재 단어), `currentWordCount`(단어 수), `socre`(점수)를 나타내는 변수가 정의됨
    - `game_fragment` : 뷰예 엑세스할 권한이 있는 결합 객체 인스턴스 `binding`이 정의됨
    - `onCreateView()` : 결합 객체를 사용하여 `game_fragment` 레이아웃 XML을 확장
    - `onViewCreated()` : 버튼 클릭 리스너를 설정하고 UI를 업데이트 함
    - `onSubmitWord()` : Submit 버튼의 클릭 리스너이다. 글자가 뒤섞인 다음 단어를 표시하고 텍스트 필드를 지우고 플레이어의 단어를 검증하지 않고 점수와 단어 수를 높임.
    - `onSkipWord()` : Skip 버튼의 클릭 리스너이다. 점수를 제외하고 `onSubmitWord()`와 유사하게 UI를 업데이트 함.
    - `getNextScrambleWord()` : 단어 목록에서 임의의 단어를 선택하여 단어에 있는 글자를 섞는 도우미 함수
    - `restartGame()`, `exitGame()` : 게임을 다시 시작하고 종료하는데 사용
    - `resetTextField()` : 텍스트 필드의 내용을 지우고 오류 상태를 재설정함
    - `updateNextWordOnScreen()` L 글자가 뒤섞인 새로운 단어를 표시함.

- **모델**

  - 앱의 데이터 처리를 담당하는 구성요소로, 앱의 `Views` 객체 및 앱 구성요소와 독립되어 있으므로 앱의 수명 주기 및 관련 문제의 영향을 받지 않는다.

- **아키택처의 기본 클래스**

  - UI Controller(activity/fragment) 
    - Display data and capture user events
  - ViewModel
    - Holds all the data needed for the UI and prepares it for display

- **ViewModel의 수명주기**

  - 앱을 시작하면 `GameFragment`와 `GameViewModel`이 생성됨
  - 기기의 화면 방향을 바꾸면 `GameFragment`는 매번 소멸되고 다시 생성되지만 `GameViewModel`은 한 번만 생성되며 매번 호출별로 다시 생성되거나 소멸되지 않음.
  - 게임을 종료하거나 뒤로 화살표를 사용하여 앱을 나가면 `GameViewModel`이 소멸되고, `GameFragment`가 소멸됨.

  ```Log
  //앱 시작
  2021-07-30 14:57:41.939 12765-12765/com.example.android.unscramble D/GameFragment: GameFragment created/re-created!
  2021-07-30 14:57:41.945 12765-12765/com.example.android.unscramble D/GameFragment: GameViewMode created!
  
  //앱 방향 전환 - 1
  2021-07-30 14:58:07.886 12765-12765/com.example.android.unscramble D/GameFragment: GameFragment destroyed!
  2021-07-30 14:58:08.090 12765-12765/com.example.android.unscramble D/GameFragment: GameFragment created/re-created!
  
  //앱 방향 전환 - 2
  2021-07-30 14:58:23.161 12765-12765/com.example.android.unscramble D/GameFragment: GameFragment destroyed!
  2021-07-30 14:58:23.276 12765-12765/com.example.android.unscramble D/GameFragment: GameFragment created/re-created!
  
  //앱 종료
  2021-07-30 14:58:39.233 12765-12765/com.example.android.unscramble D/GameFragment: GameViewModel destroyed!
  2021-07-30 14:58:39.234 12765-12765/com.example.android.unscramble D/GameFragment: GameFragment destroyed!
  ```

### ViewModel과 함께 LiveData 사용

- `LiveData`

  - 수명 주기를 인식하는 식별 가능한 데이터 홀더 클래스
  - 데이터를 보유함. 즉, 모든 유형의 데이터에 사용할 수 있는 래퍼이다.
  - 식별 가능함. 즉, `LiveData` 객체에서 보유한 데이터가 변경되면 관찰자에게 알림이 제공됨
  - 수명 주기를 인식함. 즉, `LiveData`에 관찰자를 연결하면 `LifecycleOwner`와 연결됨. `LiveData`는 `STARTED` 또는 `RESUMED` 같은 활성 수명 주기 상태인 관찰자만 업데이트 함.

- **최종 코드**

  - **GameFragment.kt**

    ```kotlin
    package com.example.android.unscramble.ui.game
    
    import android.os.Bundle
    import android.util.Log
    import android.view.LayoutInflater
    import android.view.View
    import android.view.ViewGroup
    import androidx.databinding.DataBindingUtil
    import androidx.fragment.app.Fragment
    import androidx.fragment.app.viewModels
    import com.example.android.unscramble.R
    import com.example.android.unscramble.databinding.GameFragmentBinding
    import com.google.android.material.dialog.MaterialAlertDialogBuilder
    
    class GameFragment : Fragment() {
    
        private val viewModel : GameViewModel by viewModels()
    
        //game_fragment 뷰에 액세스할 권한이 있는 결합 객체 인스턴스 binding이 정의됨.
        private lateinit var binding: GameFragmentBinding
    
        //결합 객체를 사용하여 game_fragment 레이아웃 xml을 확장
        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View {
            // Inflate the layout XML file and return a binding object instance
            binding = DataBindingUtil.inflate(inflater, R.layout.game_fragment, container, false)
            return binding.root
        }
    
        // 버튼 클릭 리스너를 설정하고 UI를 업데이트 한다.
        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
    
            binding.gameViewModel = viewModel
            binding.maxNoOfWords = MAX_NO_OF_WORDS
    
            // 레이아웃에 수명 주기 소유자 전달
            binding.lifecycleOwner = viewLifecycleOwner
    
            // Setup a click listener for the Submit and Skip buttons.
            binding.submit.setOnClickListener { onSubmitWord() }
            binding.skip.setOnClickListener { onSkipWord() }
        }
    
        // Submit 버튼의 클릭 리스너이다. 이 함수는 글자가 뒤석인 다음 단어를 표시하고 텍스트 필드를 지우고
        // 플레이어의 단어를 검증하지 않고 점수와 단어 수를 높인다.
        private fun onSubmitWord() {
            // 플레이어가 입력한 단어
            val playerWord = binding.textInputEditText.text.toString()
    
            // true이면 정답과 일치하는 것
            if(viewModel.isUserWordCorrect(playerWord)){
                // textfield를 지움.
                setErrorTextField(false)
    
                // 마지막 단어까지 가면 최종 점수를 보여줌.
                if(!viewModel.nextWord()){
                    showFinalScoreDialog()
                }
            }
            else{
                setErrorTextField(true)
            }
        }
    
        // Skip 버튼의 클릭 리스너이다.
        // 이 함수는 점수를 제외하고 onSubmitWord() 함수와 유사하게 UI를 업데이트 한다.
        private fun onSkipWord() {
            // 화면에 단어를 표시하고 텍스트 필드를 재설정
            if(viewModel.nextWord()){
                setErrorTextField(false)
            }
            // 게임에 더 이상 남은 단어가 없는 경우 최종 점수가 포함된 알림 대화상자를 표시
            else{
                showFinalScoreDialog()
            }
        }
    
        // 단어 목록에서 임의의 단어를 선택하여 단어에 있는 글자를 섞는 도우미 함수이다.
        private fun getNextScrambledWord(): String {
            val tempWord = allWordsList.random().toCharArray()
            tempWord.shuffle()
            return String(tempWord)
        }
    
        // 게임을 다시 시작하는데 사용된다.
        private fun restartGame() {
            viewModel.reinitializeData()
            setErrorTextField(false)
        }
    
        // 게임을 종료하는데 사용된다.
        private fun exitGame() {
            activity?.finish()
        }
    
        // 텍스트 필드의 내용을 지우고 오류 상태를 재설정한다.
        private fun setErrorTextField(error: Boolean) {
            if (error) {
                binding.textField.isErrorEnabled = true
                binding.textField.error = getString(R.string.try_again)
            } else {
                binding.textField.isErrorEnabled = false
                binding.textInputEditText.text = null
            }
        }
    
    
        // 대화상자를 만들고, final score를 대화상자를 통해 표시
        private fun showFinalScoreDialog() {
            MaterialAlertDialogBuilder(requireContext())
                .setTitle(getString(R.string.congratulations))
                .setMessage(getString(R.string.you_scored, viewModel.score.value))
                .setCancelable(false)
                .setNegativeButton(getString(R.string.exit)) { _, _ ->
                    exitGame()
                }
                .setPositiveButton(getString(R.string.play_again)) { _, _ ->
                    restartGame()
                }
                .show()
        }
    }
    ```

  - **GameViewModel.kt**

    ```kotlin
    package com.example.android.unscramble.ui.game
    
    import android.util.Log
    import androidx.lifecycle.LiveData
    import androidx.lifecycle.MutableLiveData
    import androidx.lifecycle.ViewModel
    
    class GameViewModel : ViewModel() {
        private var _score = MutableLiveData(0)   //점수
        val score : LiveData<Int>
            get() = _score
    
        private var _currentWordCount = MutableLiveData(0)    //단어 수
        val currentWordCount : LiveData<Int>
            get() = _currentWordCount
    
        private var _currentScrambledWord = MutableLiveData<String>()   //글자가 뒤섞인 현재 단어
        val currentScrambledWord: LiveData<String>
            get() = _currentScrambledWord
    
        private var wordsList : MutableList<String> = mutableListOf() // 사용한 단어들의 목록
        private lateinit var currentWord : String
    
        init {
            Log.d("GameFragment", "GameViewMode created!")
    
            // 첫 단어는 항상 test였기 때문에 앱 시작 시 글자가 뒤섞인 단어를 표시하기 위해
            getNextWord()
        }
    
        private fun getNextWord(){
            currentWord = allWordsList.random() // 단어를 랜덤으로 선택
            val tempWord = currentWord.toCharArray()    // 선택한 단어 뒤섞기
            tempWord.shuffle()
    
            // 뒤섞은 단어와 기존 단어가 동일한 경우 계속 섞기
            while(tempWord.toString().equals(currentWord, false)){
                tempWord.shuffle()
            }
    
            if(wordsList.contains(currentWord)){
                getNextWord()
            }
            else{
                _currentScrambledWord.value = String(tempWord)
                _currentWordCount.value = (_currentWordCount.value)?.inc()
                wordsList.add(currentWord)
            }
        }
    
        // 목록에서 다음 단어를 가져오고 단어 수가 MAX_NO_OF_WORDS보다 적으면 true를 반환
        fun nextWord() : Boolean{
            return if(_currentWordCount.value!! < MAX_NO_OF_WORDS) {
                getNextWord()
                true
            }
            else false
        }
    
        //score 변수를 SCORE_INCREASE 단위로 높인다.
        private fun increaseScore(){
            _score.value = (_score.value)?.plus(SCORE_INCREASE)
        }
    
        // player가 입력한 단어가 정답인지 확인.
        // 일치하면 점수 증가 후 true 반환
        // 그렇지 않으면 false 반환
        fun isUserWordCorrect(playerWord : String) : Boolean{
            if(playerWord.equals(currentWord, true)){
                increaseScore()
                return true
            }
            return false
        }
    
        //앱 데이터 재설정
        fun reinitializeData(){
            _score.value = 0
            _currentWordCount.value = 0
            wordsList.clear()
            getNextWord()
        }
    }
    ```


### Quiz

1. **Which of the following are reasons to use a ViewModel?**

   --> A viewModel and its data can survive orientation changes in an Activity/Fragment.
   
   --> A viewModel allows you to separate code that update the UI from code that doesn't need to rely on the UI or its lifecycle.
   
2. **A ViewModel is destroyed after which of the following?**

   --> after `onDestroy` , if it not a configuration change
   
3. **True or False : You should execute time-consuming tasks and I/O requests in your Activity/Fragment.**

   --> False

4. **Why should you initialize and store LiveData in your ViewModel instead of a UI controller? ** 

   --> Both the ViewModel and LiveData are lifecycle aware.

   --> To ensure that the LiveData isn't destroyed when the UI Controller is destroyed.

   --> To hide or separate implementation details making your app more flexible.

5. ** `observe` allows you to do which of the following for changes?**

   --> a LiveData object

   1. **True or False : It's OK for a ViewModel to directly reference a `view` or `LifeCycleOwner` class**

   --> False
