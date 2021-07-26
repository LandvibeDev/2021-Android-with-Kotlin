# 2021 Landvibe Summer Coding - Android

## Unit2 : Layouts

### PathWay1 : Get user input in an app: Part 1



##### :label: Kotlin의 클래스 및 상속

- **상속**

  하위 클래스가 상위 클래스의 모든 속성과 메서드를 포함하거나 상속받는 경우

  ​	:star:  코드 공유, 재사용이 가능 :arrow_right: 프로그램을 더 쉽게 파악, 유지 가능  

  - 상위클래스 (슈퍼클래스, 기본클래스)
  - 하위클래스 (서브클래스)
  - 루트 (최상위클래스)

  <img src="img/Unit2-Pathway1-1_hyein.jpg" width="500"/>

  

- **추상 클래스**
  - 완전히 구현되지 않아서 인스턴스화 할 수 없는 클래스, 스케치(아이디어와 계획)
    - 추상클래스 :arrow_right: 클래스 :arrow_right: 객체 인스턴스
  - `abstract`
  - 속성값과 함수 구현을 할 수 없을 때 클래스를 추상으로 만든다

``````kotlin
abstract class Dwelling(private var residents: Int) {

    abstract val buildingMaterial: String
    abstract val capacity: Int

    fun hasRoom(): Boolean {
        return residents < capacity
    }
}
``````



- **서브 클래스**
  - 슈퍼클래스에서 확장할 때는 슈퍼클래스의 필수 매개변수를 전달해야 한다.
  - 추상 클래스 상속의 경우, 함수 및 변수의 구현을 제공해야 한다.
    - `overrid` : 상위 클래스에서 정의된 것을 이 클래스에서 재정의 하겠다

``````kotlin
class SquareCabin(residents: Int) : Dwelling(residents) {
    override val buildingMaterial = "Wood"
    override val capacity = 6
}
``````



- `with`

해당 인스턴스 객체로 다음 작업을 모두 실행

``````kotlin
fun main() {
    val squareCabin = SquareCabin(6)

    with(squareCabin) {
        println("\nSquare Cabin\n============")
        println("Capacity: ${capacity}")
        println("Material: ${buildingMaterial}")
        println("Has room? ${hasRoom()}")
    }
}
``````



:key: `class` 는 최종 클래스이므로, `open` or `abstract` 키워드가 표시된 클래스에서만 상속 가능

``````kotlin
import kotlin.math.PI

fun main() {

    val squareCabin = SquareCabin(6, 50.0)
    val roundHut = RoundHut(3, 10.0)
    val roundTower = RoundTower(4, 15.5)

    with(squareCabin) {
        println("\nSquare Cabin\n============")
        println("Capacity: ${capacity}")
        println("Material: ${buildingMaterial}")
        println("Has room? ${hasRoom()}")
        println("Floor area: ${floorArea()}")
    }

    with(roundHut) {
        println("\nRound Hut\n=========")
        println("Material: ${buildingMaterial}")
        println("Capacity: ${capacity}")
        println("Has room? ${hasRoom()}")
        println("Floor area: ${floorArea()}")
    }

    with(roundTower) {
        println("\nRound Tower\n==========")
        println("Material: ${buildingMaterial}")
        println("Capacity: ${capacity}")
        println("Has room? ${hasRoom()}")
        println("Floor area: ${floorArea()}")
    }
 }

abstract class Dwelling(private var residents: Int) {

    abstract val buildingMaterial: String
    abstract val capacity: Int

    fun hasRoom(): Boolean {
        return residents < capacity
	}

    abstract fun floorArea(): Double
}

class SquareCabin(residents: Int,
    val length: Double) : Dwelling(residents) {

    override val buildingMaterial = "Wood"
    override val capacity = 6

    override fun floorArea(): Double {
       return length * length
    }
}

open class RoundHut(val residents: Int,
    val radius: Double) : Dwelling(residents) {

    override val buildingMaterial = "Straw"
    override val capacity = 4

    override fun floorArea(): Double {
        return PI * radius * radius
    }
}

class RoundTower(residents: Int, radius: Double,
    val floors: Int = 2) : RoundHut(residents, radius) {

    override val buildingMaterial = "Stone"
    override val capacity = 4 * floors

    override fun floorArea(): Double {
        return super.floorArea() * floors
    }
}
``````

- `super`

상위 클래스의  함수와 속성을 참조할 수 있다

- `open`

서브클래스로 분류, 상속 가능

- `private`

외부 접근 불가, 클래스 내에서만 사용할 수 있다





##### :label: Android용 XML 레이아웃 만들기

- UI
  - `RadioButton ` : 라디오 버튼
  - `RadioGroup` : 라디오 버튼을 그룹화
  - `Switch` : 켜기/끄기 전환 버튼



- **XML**

  - 확장성 마크업 언어(eXtensible Markup Language)

  - 텍스트 기반 문서를 사용하여 데이터를 설명하는 방법

  - Android 앱의 UI 레이아웃 정의 등의 용도로 사용된다

    - `xmlns` 

      XML 네임스페이스, 스키마 관련 속성 어휘 정의



:key:

- `ConstaintLayout`의 하위 요소에는 레이아웃이 정렬 방법을 알 수 있도록 제약 조건이 필요하다.

- `match_parent`는 `ConstraintLayout`에서 사용할 수 없다. 대신 `0dp`를 사용(일치제약조건)

``````kotlin
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
        android:hint="@string/cost_of_service"
        android:inputType="numberDecimal"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <TextView
        android:id="@+id/service_question"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/how_was_the_service"
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

        <RadioButton
            android:id="@+id/option_twenty_percent"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="@string/amazing_service" />

        <RadioButton
            android:id="@+id/option_eighteen_percent"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="@string/good_service" />

        <RadioButton
            android:id="@+id/option_fifteen_percent"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="@string/ok_service" />

    </RadioGroup>

    <Switch
        android:id="@+id/round_up_switch"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:checked="true"
        android:text="@string/round_up_tip"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@id/tip_options" />

    <Button
        android:id="@+id/calculate_button"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:text="@string/calculate"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@id/round_up_switch" />

    <TextView
        android:id="@+id/tip_result"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/tip_amount"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintTop_toBottomOf="@id/calculate_button" />
</androidx.constraintlayout.widget.ConstraintLayout>
``````





##### :label: 팁 계산

- 뷰 결합

``````kotlin
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
``````

- findViewById()`

`View`의 ID가 주어지면 이 뷰에 대한 참조를 반환하는 작업을 실행하는 메서드

- `lateinit`

코드가 변수를 사용하기 전에 먼저 초기화할 것임을 확인, 변수를 초기화하지 않으면 앱이 비정상 종료된다.



```````kotlin
// Old way with findViewById()
val myButton: Button = findViewById(R.id.my_button)
myButton.text = "A button"

// Better way with view binding
val myButton: Button = binding.myButton
myButton.text = "A button"

// Best way with view binding and no extra variable
binding.myButton.text = "A button"
```````

​	`findViewById()`를 호출하는 대신 `binding` 객체에서 뷰 참조를 가져올 수 있다.



``````kotlin
package com.example.tiptime

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tiptime.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculateButton.setOnClickListener { calculateTip() }
    }

    private fun calculateTip() {
        val stringInTextField = binding.costOfService.text.toString()
        val cost = stringInTextField.toDoubleOrNull()
        if (cost == null) {
            binding.tipResult.text = ""
            return
        }

        val tipPercentage = when (binding.tipOptions.checkedRadioButtonId) {
            R.id.option_twenty_percent -> 0.20
            R.id.option_eighteen_percent -> 0.18
            else -> 0.15
        }

        var tip = tipPercentage * cost
        if (binding.roundUpSwitch.isChecked) {
            tip = kotlin.math.ceil(tip)
        }

        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.tipResult.text = getString(R.string.tip_amount, formattedTip)
    }
}
``````

- `toDoubleOrNull()`

비어있는 `String`을 `Double`로 변환할 수 없으므로 `toDoubleOrNull()`을 사용하여 문제가 있다면 `null`을 반환하도록 한다.

- `NumberFormat.getCurrencyInstance()`

숫자를 통화 형식으로 지정하는데 이용할 형식 지정 클래스를 가져올 수 있다





##### :label: Quiz

1. Which of the following is true about class inheritance?

   - All of the above

     - Class inheritance lets you reuse code and makes your program easier to maintain.
     - Properties and functions of the parent class(es) are available to the child class.
     - You can define additional properties and functions that are specific to subclasses.
     - You can override parent class members in subclasses.

     

2. Which of the following are true about abstract classes?

   *적절한 답변을 모두 선택합니다.*

   - They can be extended by subclasses and implementations can be provided for abstract members of the class.
   - They may have abstract properties or abstract functions.
   - They are not fully implemented and cannot be instantiated.

   

3. 빈 칸 채우기

   *단어를 하나 이상 입력하여 문장을 완성하세요.*

   The `constructor` is called when you create an instance of a class.

   

4. How do you mark a property to be used only inside its current class?

   - Use the `private` keyword.

   

5. Select all answers that are true for this XML layout when displayed on the screen. (You can sketch this out on a piece of paper first, if that helps.)

   ``````kotlin
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
   ``````

   *적절한 답변을 모두 선택합니다.*

   - The starting edge of `TextView A` is aligned to the starting edge of the parent view.
   - The tops of `TextView A` and `TextView B` are aligned to top of the parent view.

