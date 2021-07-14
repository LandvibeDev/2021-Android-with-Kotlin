# 2021 Landvibe Summer Coding - Android



## Unit2 : Layouts

## PathWay1 : Get user input in an app : Part1



### Kotlin의 클래스 및 상속

- 클래스 계층 구조 : 클래스가 상위 요소와 하위 요소의 계층 구조로 구성된 배열이다.

- Android 클래스의 상속

  <img src="img\Unit2-Pathway1-1_장유진.png" style="zoom:70%;" />

- 주택의 클래스 계층 구조

  <img src="img\Unit2-Pathway1-2_장유진.png" style="zoom:70%;" />

- **추상 클래스** : 완전히 구현되지 않아서 인스턴스화 할 수 없는 클래스 :point_right: `abstract`

- **상속** :point_right: `하위 클래스 : 상위 클래스`

- **with()** : 클래스의 특정 인스턴스로 작업하고 이 인스턴스의 여러 속성과 함수에 엑세스 해야 한다면 with 문을 사용하여 '이 인스턴스 객체로 다음 작업을 모두 실행'하라고 나타낼 수 있다.

  ```kotlin
  with(instanceName){
  	//all operations to do with instanceName
  }
  ```

- **open()** : 부모 클래스 앞에 사용하는 키워드

- **Kotlin 수학 라이브러리** :point_right: `import kotlin.math.PI`, `import kotlin.math.sqrt`

- **예시 코드**

  ```kotlin
  import kotlin.math.PI
  import kotlin.math.sqrt
  
  fun main() {
     val squareCabin = SquareCabin(6, 50.0)
     val roundHut = RoundHut(3, 10.0)
     val roundTower = RoundTower(4, 15.5)
  
     with(squareCabin) {
         println("\nSquare Cabin\n============")
         println("Capacity: ${capacity}")
         println("Material: ${buildingMaterial}")
         println("Floor area: ${floorArea()}")
     }
  
     with(roundHut) {
         println("\nRound Hut\n=========")
         println("Material: ${buildingMaterial}")
         println("Capacity: ${capacity}")
         println("Floor area: ${floorArea()}")
         println("Has room? ${hasRoom()}")
         getRoom()
         println("Has room? ${hasRoom()}")
         getRoom()
         println("Carpet size: ${calculateMaxCarpetSize()}")
     }
  
     with(roundTower) {
         println("\nRound Tower\n==========")
         println("Material: ${buildingMaterial}")
         println("Capacity: ${capacity}")
         println("Floor area: ${floorArea()}")
         println("Carpet size: ${calculateMaxCarpetSize()}")
     }
  }
  
  abstract class Dwelling(private var residents: Int) {
     abstract val buildingMaterial: String
     abstract val capacity: Int
  
    
     abstract fun floorArea(): Double
  
     fun hasRoom(): Boolean {
         return residents < capacity
     }
  
     fun getRoom() {
         if (capacity > residents) {
             residents++
             println("You got a room!")
         } else {
             println("Sorry, at capacity and no rooms left.")
         }
     }
  
     }
  
  
  class SquareCabin(residents: Int, val length: Double) : Dwelling(residents) {
     override val buildingMaterial = "Wood"
     override val capacity = 6
  
     
     override fun floorArea(): Double {
         return length * length
     }
  
  }
  
  
  open class RoundHut(
         val residents: Int, val radius: Double) : Dwelling(residents) {
  
     override val buildingMaterial = "Straw"
     override val capacity = 4
  
     override fun floorArea(): Double {
         return PI * radius * radius
     }
  
     fun calculateMaxCarpetSize(): Double {
         val diameter = 2 * radius
         return sqrt(diameter * diameter / 2)
     }
  
  }
  
  class RoundTower(
         residents: Int,
         radius: Double,
         val floors: Int = 2) : RoundHut(residents, radius) {
  
     override val buildingMaterial = "Stone"
  
     override val capacity = floors * 4
  
     override fun floorArea(): Double {
         return super.floorArea() * floors
     }
  }
  ```
  
  

### Android의 XML 레이아웃 만들기

- **java** :point_right: Kotlin 파일(또는 자바 파일)의 폴더

- **`MainActivity`** :point_right: 팁 계산기 로직의 모든 Kotlin 코드가 들어갈 클래스

- **res** :point_right: 앱 리소스의 폴더

- **`activity_main.xml`** :point_right: Android 앱의 레이아웃 파일

- **`strings.xml`** :point_right: Android 앱의 문자열 리소스가 포함되어 있는 파일

- **activity_main.xml**

  ```xml
  <?xml version="1.0" encoding="utf-8"?>
  <androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
      xmlns:app="http://schemas.android.com/apk/res-auto"
      xmlns:tools="http://schemas.android.com/tools"
      android:layout_width="match_parent"
      android:layout_height="match_parent"
      android:padding="16dp"
      tools:context=".MainActivity">
  
      <EditText
          android:id="@+id/cost_of_service"
          android:layout_width="160dp"
          android:layout_height="wrap_content"
          android:hint="Cost of Service"
          android:inputType="numberDecimal"
          app:layout_constraintStart_toStartOf="parent"
          app:layout_constraintTop_toTopOf="parent" />
  
      <TextView
          android:id="@+id/service_question"
          android:layout_width="wrap_content"
          android:layout_height="wrap_content"
          android:text="How was the service?"
          app:layout_constraintStart_toStartOf="parent"
          app:layout_constraintTop_toBottomOf="@id/cost_of_service" />
  
      <RadioGroup
          android:id="@+id/tip_options"
          android:layout_width="wrap_content"
          android:layout_height="wrap_content"
          android:checkedButton="@id/option_twenty_percent"
          android:orientation="vertical"
          app:layout_constraintStart_toStartOf="parent"
          app:layout_constraintTop_toBottomOf="@id/service_question">
  
          <!-- add RadioButtons here-->
          <RadioButton
              android:id="@+id/option_twenty_percent"
              android:layout_width="wrap_content"
              android:layout_height="wrap_content"
              android:text="Amazing (20%)" />
  
          <RadioButton
              android:id="@+id/option_eighteen_percent"
              android:layout_width="wrap_content"
              android:layout_height="wrap_content"
              android:text="Good (18%)" />
  
          <RadioButton
              android:id="@+id/option_fifteen_percent"
              android:layout_width="wrap_content"
              android:layout_height="wrap_content"
              android:text="OK (15%)" />
  
      </RadioGroup>
  
      <Switch
          android:id="@+id/round_up_switch"
          android:layout_width="0dp"
          android:layout_height="wrap_content"
          android:checked="true"
          android:text="Round up tip?"
          app:layout_constraintEnd_toEndOf="parent"
          app:layout_constraintStart_toStartOf="parent"
          app:layout_constraintTop_toBottomOf="@id/tip_options" />
  
  
      <Button
          android:id="@+id/calculate_button"
          android:layout_width="0dp"
          android:layout_height="wrap_content"
          android:text="Calculate"
          app:layout_constraintEnd_toEndOf="parent"
          app:layout_constraintStart_toStartOf="parent"
          app:layout_constraintTop_toBottomOf="@id/round_up_switch" />
  
      <TextView
          android:id="@+id/tip_result"
          android:layout_width="wrap_content"
          android:layout_height="wrap_content"
          android:text="Tip Amount"
          app:layout_constraintEnd_toEndOf="parent"
          app:layout_constraintTop_toBottomOf="@id/calculate_button" />
  
  </androidx.constraintlayout.widget.ConstraintLayout>
  ```

- **strings.xml**

  ```xml
  <resources>
      <string name="app_name">Tip Time</string>
      <string name="cost_of_service">Cost of Service</string>
      <string name="how_was_the_service">How was the service?</string>
      <string name="amazing_service">Amazing (20%)</string>
      <string name="good_service">Good (18%)</string>
      <string name="ok_service">Okay (15%)</string>
      <string name="round_up_tip">Round up tip?</string>
      <string name="calculate">Calculate</string>
      <string name="tip_amount">Tip Amount</string>
  </resources>
  ```

  

### 팁 계산

- **build.gradle(Module:Tip_Time.app)** :point_right: **뷰 결합 사용 설정**

  ```
  buildFeatures{
          viewBinding = true
      }
  ```

- **MainActivity.kt**

  ```kotlin
  package com.example.tiptime
  
  import android.os.Bundle
  import androidx.appcompat.app.AppCompatActivity
  import com.example.tiptime.databinding.ActivityMainBinding
  import java.text.NumberFormat
  
  class MainActivity : AppCompatActivity() {
  
      //결합 객체의 최상위 변수 선언
      //lateinit 키워드는 코드가 변수를 사용하기 전에 먼저 초기화할 것임을 확인해줌
      private lateinit var binding : ActivityMainBinding
  
      override fun onCreate(savedInstanceState: Bundle?) {
          super.onCreate(savedInstanceState)
  
          //Views에 액세스하는데 사용할 binding 객체 초기화
          binding = ActivityMainBinding.inflate(layoutInflater)
          setContentView(binding.root) //활동의 콘텐츠 뷰를 binding.root로 지정
  
          //Calculate 버튼에 클릭 리스너 이벤트를 설정
          binding.calculateButton.setOnClickListener{ calculateTip() }
      }
  
      private fun calculateTip(){
  
          //EditText의 텍스트 속성을 가져와 stringInTextField 라는 변수에 할당
          val stringInTextField = binding.costOfService.text.toString()
          val cost = stringInTextField.toDouble()	//숫자로 변환
          if(cost == null){	//예외 처리
              binding.tipResult.text=""
              return
          }
  
          //팁 비율 설정
          val tipPercentage = when(binding.tipOptions.checkedRadioButtonId){
              R.id.option_twenty_percent -> 0.20
              R.id.option_eighteen_percent -> 0.18
              else -> 0.15
          }
  
          //팁 계산, 변경될 수 있는 값이므로 var로 선언
          var tip = tipPercentage * cost
          //팁 반올림
          if(binding.roundUpSwitch.isChecked){
              tip = kotlin.math.ceil(tip)
          }
  
          //팁 형식 지정, 숫자->통화 형식
          val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
  
          binding.tipResult.text = getString(R.string.tip_amount, formattedTip)
      }
  }
  ```

- **strings.xml**

  ```xml
  <string name="tip_amount">Tip Amount: %s</string>	//형식이 지정된 통화를 삽입
  ```

- **activity_main.xml**

  ```xml
  tools:text="Tip Amount: $10"
  ```

<img src="img\Unit2-Pathway1-3_장유진.png" style="zoom:70%;" />

### Quiz

1. **Which of the following is true about class inheritance?**

   --> Class inheritance lets you reuse code and makes your program easier to maintain.

   --> Properties and functions of the parent class(es) are available to the child class.

   --> You can define additional properties and functions that are specific to subclasses.

   --> You can override parent class members in subclasses.

2. **Which of the following are true about abstract classes?**

   --> They can be extended by subclasses and implementations can be provided for abstract members of the class.

   --> They may have abstract properties or abstract functions.

   --> They are not fully implemented and cannot be instantiated.

3. **빈칸 채우기**

   - **The ______ is called when you create an instance of a class.**

     --> constructor(생성자)

4. **How do you mark a property to be used only inside its current class?**

   --> Use the `private` keyword.

5. **Select all answers that are true for this XML layout when displayed on the screen.(You can sketch this out on a piece of paper fist, if that helps)**

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

   --> The starting edge of `TextView A` is aligned to the starting edge of the parent view.

   --> The tops of `TextView A` and `TextView B` are aligned to top of the parent view.

   :pencil: 제약 조건의 이름

   - 제약 조건의 이름은 layout_constraint<Source>_to<Target>Of 형식을 따른다.
   - 여기서<Source>는 현재 뷰를 나타내고, <Target>은 현재 뷰가 제한되는 타겟 뷰의 가장자리를 나타낸다.