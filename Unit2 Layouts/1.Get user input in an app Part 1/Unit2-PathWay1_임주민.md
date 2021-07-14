# 💡 Android Basics in Kotlin

## Unit #2 : Layouts

## PATHWAY #1 : Get user input in an app: Part 1



<br/>



### 📌 코틀린의 클래스용어

- 클래스 계층 구조 : 클래스가 상위와 하위 요소의 계층 구조로 구성
- 하위 클래스 또는 서브클래스 또는 기본 클래스 : 계층 구조에서 다른 클래스 아래에 있는 모든 클래스
- 루트 또는 최상위 클래스 : 클래스 계층 구조의 최상위에 있는 클래스
- 상속 : 하위 클래스가 상위 클래스의 모든 속성과 메서드 포함 혹은 상속받는 경우. 코드 공유와 재사용 가능으로 프로그램 쉽게 파악하고 유지가능
- 추상 클래스 : 완전히 구현되지 않아 인스턴스화할 수 없는 클래스, `abstract` 키워드 사용 -> 나중에 값과 구현을 제공하겠다는 약속
- ex) View > TextView > EditText, Button



<br/>



### 📌 주택 클래스 - 추상클래스 사용

* Dwelling : 모든 주택에 공통으로 적용되는 정보를 담고 있는 구체적이지 않은 기본집클래스

  * ```kotlin
    abstract class Dwelling(private var residents : Int) {
    	abstract val buildingMaterial : String 
      abstract val capacity : Int 
      //abstract 키워드 사용해서 속성이 여기서 정의되지 않음을 나타냄
      
      fun hasRoom() : Boolean {
        return residents < capacity
      }
      abstract fun floorArea() : Double {
        // 서브 클래스에서 함수 구현 
      }
      fun getRoom() {
        if (capacity > residents) {
          residents++
          println("You got a room!")
        } else {
          println("Sorry, at capacity and no romms left.")
        }
      }
    }
    // 메인 함수에서 인스턴스 만들기 불가능
    
    ```

* SquareCabin : 정사각형 통나무집 (서브클래스)

  * ```kotlin
    class SquareCabin(residents : Int, val length : Double) : Dwelling(residents) {
      override val buildingMaterial = "Wood"
      override val capacity = 6
    	override fun floorArea() : Double {
        return length*length
      }
    }
    ```

* `with`를 사용하여 코드 단순화 

  * ```kotlin
    // main에서 인스턴스 생성한 이후
    
    with (squareCabin) {
    	// all operations to do with instanceName
    	println("\nSquare Cabin\n============")
      println("Capacity: ${capacity}")
      println("Material: ${buildingMaterial}")
      println("Has room? ${hasRoom()}")
    }
    ```

* RoundHut : 원형 짚 오두막 (서브클래스)

  * ```kotlin
    class RoundHut(residents: Int, val radius : Double) : Dwelling(residents) {
        override val buildingMaterial = "Straw"
        override val capacity = 4
        override fun floorArea() : Double {
          	return PI*radius*radius
            // PI사용하기 위해서는 import kotlin.math.PI를 써줘야함 
        }
      	fun calculateMaxCarpetSize(): Double {
        	val diameter = 2 * radius
        	return sqrt(diameter * diameter / 2)
    		}
    }
    ```

* RoundTower : 원형 돌 오두막 (RoundHut의 서브클래스)

  * `open` 키워드를 사용하여 상속될 수 있도록 변경 (코틀린에서는 `open`,  `abstract`클래스에서만 상속할 수 있다.)

  * `super` 키워드로 슈퍼클래스 구현 : 상위클래스에 정의된 함수 호출

    ```kotlin
    open class RoundTower(residents: Int, radius : Double, val floors: Int = 2) : RoundHut(residents, radius) {
        override val buildingMaterial = "Stone"
        override val capacity = 4*floors
      
      	// floorArea() 구현 안해도됨. 상속받는 상위클래스와 인수만 같도록 설정해주기
      	// 재정의도 가능
      	override fun floorArea() : Double {
          	return super.floorArea()*floors
        }
    }
    ```

<br/>

### 📌 XML

* 확장성 마크업 언어로 텍스트 기반 문서 사용하여 데이터를 설명하는 방법

* `activity_main.xml`에서 오른쪽 상단 `Code`클릭

* 하위요소로 추가하려면, 상단 요소의 시작태그와 종료태그 사이에 추가

* 들여쓰기(가독성 up)와 태그 확인

* XML에 주석 추가 : `<!--`로 시작 `-->`로 끝난다

  ```xml
  <!--1번째 방법-->
  <TextView		
      android:text="Hello World!"
  />
  <!--2번째 방법-->
  <TextView		
      android:text="Hello World!"
  ></TextView>
  <!--3번째 방법-->
  <TextView		
      android:text="Hello World!" />
  ```

  

<br/>



### 📌 XML로 팁 어플 레이아웃 수정

* `ConstraintLayout`의 각 하위 요소에는 세로 및 가로 제약 조건 필요

  * `layout_constraint<Source>_to<Target>Of ` 예시 3가지

  ```xml
  app:layout_constraintEnd_toEndOf="parent"
  app:layout_constraintStart_toStartOf="parent"
  app:layout_constraintTop_toBottomOf="@id/tip_options"
  ```

* EditText 추가

  * 텍스트 입력 or 수정
  * `android:inputType`속성으로 입력란에 입력할 수 있는 텍스트 유형 제한

  ```xml
  <EditText
     	   android:id="@+id/cost_of_service"
      	 android:layout_width="160dp" 
      	 android:layout_height="wrap_content" 
      	 android:inputType="numberDecimal"   
      	 android:hint="Cost of Service"
     	   app:layout_constraintStart_toStartOf="parent"
      	 app:layout_constraintTop_toTopOf="parent"
  />	
  ```

* TextView 추가

  ```xml
  <TextView
          android:id="@+id/service_question"
          android:layout_width="wrap_content"
          android:layout_height="wrap_content"
          android:text="How was the service?"
          app:layout_constraintStart_toStartOf="parent"
       	  app:layout_constraintTop_toBottomOf="@id/cost_of_service" />
  ```

* RadioButtons 추가

  * `RadioGroup`으로 그룹화, 베타적인 옵션 목록 생성

  ```xml
  <RadioGroup
          android:id="@+id/tip_options"
          android:checkedButton="@id/option_twenty_percent"
          android:layout_width="wrap_content"
          android:layout_height="wrap_content"
          android:orientation="vertical"
          app:layout_constraintStart_toStartOf="parent"
          app:layout_constraintTop_toBottomOf="@id/service_question"></RadioGroup>
  
  		<RadioButton
         android:id="@+id/option_twenty_percent"
         android:layout_width="wrap_content"
         android:layout_height="wrap_content"
         android:text="Amazing (20%)" />
  		<!--다른 버튼도 동일하게 추가-->
  
  </RadioGroup>
  ```

* Switch 위젯 - 팁 반올림 여부

  * 두 옵션 간에 전환가능
  * `android:text`를 사용하여 라벨 추가(`TextView` 사용안해도 글자추가 가능)

  ```xml
  <Switch
      android:id="@+id/round_up_switch"
      android:layout_width="0dp"
      android:layout_height="wrap_content"
      android:checked="true"
      android:text="Round up tip?"
      app:layout_constraintEnd_toEndOf="parent"
      app:layout_constraintStart_toStartOf="parent"
      app:layout_constraintTop_toBottomOf="@id/tip_options" />
  ```

* 계산버튼과 텍스트 추가

  ```xml
  <Button
          android:id="@+id/calculate_button"
          android:layout_width="0dp"
          android:layout_height="wrap_content"
          android:text="Calculate"
          app:layout_constraintTop_toBottomOf="@id/round_up_switch"
          app:layout_constraintStart_toStartOf="parent"
          app:layout_constraintEnd_toEndOf="parent" />
  
  <TextView
          android:id="@+id/tip_result"
          android:layout_width="wrap_content"
          android:layout_height="wrap_content"
          app:layout_constraintEnd_toEndOf="parent"
          app:layout_constraintTop_toBottomOf="@id/calculate_button"
          android:text="Tip Amount" />
  
  ```

  

<br/>



### 📌 뷰결합

* Gradle Scripts > build.gradle (Module: Tip_Time.app) > android 섹션에 추가한 후 Sync Now

  ```kotlin
  buildFeatures {
      viewBinding = true
  }
  ```

* app > java > com.example.tiptime > MainActivity

  * `lateinit` : 코드가 변수를 사용하기 전에 먼저 초기화할 것임을 확인해준다. 초기화 안하면 앱이 비정상 종료된다.

  ```kotlin
  class MainActivity : AppCompatActivity() {
  		// 결합 객체의 최상위 변수 선언
      private lateinit var binding: ActivityMainBinding
  		
      override fun onCreate(savedInstanceState: Bundle?) {
          super.onCreate(savedInstanceState)
        	// View에 액세스하는 데 사용할 binding객체 초기화
          binding = ActivityMainBinding.inflate(layoutInflater)
        	//활동의 콘텐츠 뷰 설정
          setContentView(binding.root)
      }
  }
  ```

  *  `View`에 대한 참조가 필요한 경우 `findViewById()`호출 대신 `binding` 객체에서 뷰 참조를 가져오기 가능. `binding` 객체는 ID 있는 앱의 모든 `View`를 위한 참조를 자동으로 정의. 
  * 뷰 결합을 사용하는 것이 훨씬 더 간결해서  `View`를 위한 참조를 유지할 변수 생성 필요 X, 결합 객체에서 직접 뷰 참조를 사용

  ```kotlin
  // Old way with findViewById()
  val myButton: Button = findViewById(R.id.my_button)
  myButton.text = "A button"
  
  // Best way with view binding and no extra variable
  binding.myButton.text = "A button"
  ```



<br/>



### 📌 팁 계산

* onCreate()수정

  ```kotlin
  override fun onCreate(savedInstanceState: Bundle?) {
          super.onCreate(savedInstanceState)
          binding = ActivityMainBinding.inflate(layoutInflater)
          setContentView(binding.root)
          binding.calculateButton.setOnClickListener{ calculateTip() }
  }
  ```

* calculateTip()

  * `%s`  문자열 매개변수를 사용하여 다른 언어로 쉽게 변환할 수 있는 동적 문자열 생성 가능

  ```kotlin
  private fun calculateTip() {
          // 서비스 비용 가져오기 - toString()해주어야 toDouble()이 가능
          val stringInTextField = binding.costOfService.text.toString()
          val cost = stringInTextField.toDoubleOrNull()
    			// 예외처리
    			if (cost==null || cost==0.0) {
              displayTip(0.0)
              return
          }
          // 선택한 팁 비율 가져오기
          val tipPercentage = when (binding.tipOptions.checkedRadioButtonId) {
              R.id.option_twenty_percent -> 0.20
              R.id.option_eighteen_percent -> 0.18
              else -> 0.15
          }
          // var 사용한 점 유의 - 값 반올림할 수 있어야 함
          var tip = tipPercentage * cost
          if (binding.roundUpSwitch.isChecked) {
              tip = kotlin.math.ceil(tip) //팁 상한 할당
          }
          displayTip(tip)
  }
  private fun displayTip(tip : Double) {
          val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
          binding.tipResult.text = getString(R.string.tip_amount, formattedTip)
  }
  ```

<br/>



### 📌 퀴즈

1. Which of the following is true about class inheritance?

   > Class inheritance lets you reuse code and makes your program easier to maintain.
   >
   > Properties and functions of the parent class(es) are available to the child class.
   >
   > You can define additional properties and functions that are specific to subclasses.
   >
   > You can override parent class members in subclasses.

2. Which of the following are true about abstract classes?

   > They can be extended by subclasses and implementations can be provided for abstract members of the class.
   >
   > They may have abstract properties or abstract functions.
   >
   > They are not fully implemented and cannot be instantiated.

3. The is [                  ] called when you create an instance of a class.

   > constructor

4. How do you mark a property to be used only inside its current class?

   > Use the private keyword

5. Select all answers that are true for this XML layout when displayed on the screen. (You can sketch this out on a piece of paper first, if that helps.)

   ```xml
   <androidx.constraintlayout.widget.ConstraintLayout
       android:layout_width="match_parent"
       android:layout_height="match_parent">
       <TextView
           android:id="@+id/textViewA"
           android:layout_width="wrap_content"
           android:layout_height="wrap_content"
           android:text="A"
           app:layout_constraintStart_toStartOf="parent"
           app:layout_constraintTop_toTopOf="parent" />
       <TextView
           android:id="@+id/textViewB"
           android:layout_width="wrap_content"
           android:layout_height="wrap_content"
           android:text="B"
           app:layout_constraintEnd_toEndOf="parent"
           app:layout_constraintTop_toTopOf="parent" />
   </androidx.constraintlayout.widget.ConstraintLayout>
   ```

   > The starting edge of `TextView A` is aligned to the starting edge of the parent view.
   >
   > The tops of `TextView A` and `TextView B` are aligned to top of the parent view.