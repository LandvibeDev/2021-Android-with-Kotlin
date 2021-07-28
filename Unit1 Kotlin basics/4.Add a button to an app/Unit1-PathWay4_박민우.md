# 🔥 Unit 1 : Kotlin basics

## PATHWAY 4 : Add a button to an app



## 🎖 Track 1 : Classes and object instances in Kotlin 

###  학습할 내용

+ 프로그래매틱 방식으로 랜덤 숫자를 생성하여 주사위 굴리기를 시뮬레이션하는 방법
+ 변수와 메서드로 `Dice` 클래스를 만들어 코드를 구조화하는 방법
+ 클래스의 객체 인스턴스를 만들고 변수를 수정하며 메서드를 호출하는 방법



### 랜덤 숫자 굴리기

+  `IntRange`는 또 다른 데이터 유형으로, 시작점부터 끝점까지 정수의 범위를 나타냅니다. `1..6`은 Kotlin 범위인 것을 알 수 있습니다. 시작 숫자, 점 두 개, 끝 숫자가 순서대로 있기 때문입니다(사이에 공백 없음). 정수 범위의 다른 예로는 숫자 2~5의 `2..5`, 숫자 100~200의 `100..200`이 있습니다.

+ `main()` 내에서 변수를 `randomNumber`라는 `val`로 정의하고,   ** `randomNumber`가 `diceRange` 범위에서 `random()`를 호출한 결과 값을 갖도록** 합니다.

```kotlin
fun main() {
    val diceRange = 1..6
    val randomNumber = diceRange.random()
    // 범위에서 함수를 직접 호출해도 됩니다(예: `(1..6).random()`).
    
    println("Random number : ${randomNumber}")
}
```



### Dice class 만들기

```kotlin
fun main() {
    val myFirstDice = Dice()
    println(myFirstDice.sides)
    myFirstDice.roll()
}

class Dice {
    var sides = 6

    fun roll() {
        val randomNumber = (1..6).random()
        println(randomNumber)
    }
}
```



### 주사위 굴리기 값 반환, 주사위의 면 수 변경

```kotlin
fun main() {
    val myFirstDice = Dice()
    val diceRoll = myFirstDice.roll()
    println("Your ${myFirstDice.sides} sided dice rolled ${diceRoll}!")

    myFirstDice.sides = 20
    println("Your ${myFirstDice.sides} sided dice rolled ${myFirstDice.roll()}!")
}

class Dice {
    var sides = 6

    fun roll(): Int {
        val randomNumber = (1..sides).random()
        return randomNumber
    }
}
```



### 주사위 맞춤설정

```kotlin
fun main() {
    val myFirstDice = Dice(6)
    val diceRoll = myFirstDice.roll()
    println("Your ${myFirstDice.numSides} sided dice rolled ${diceRoll}!")

    val mySecondDice = Dice(20)
    println("Your ${mySecondDice.numSides} sided dice rolled ${mySecondDice.roll()}!")
}

class Dice (val numSides: Int) {
    fun roll(): Int {
        val randomNumber = (1..numSides).random()
        return randomNumber
        // return (1..numSides).random() 
    }
}
```



### 요약

+ `IntRange`에서 `random()` 함수를 호출하여 랜덤 숫자를 생성합니다. `(1..6).random()`
+ 클래스는 객체의 청사진과 같습니다. 변수와 함수로 구현된 속성과 동작을 포함할 수 있습니다.
+ 클래스 인스턴스는 주사위와 같은 실제 객체를 나타내는 경우가 많습니다. 객체에서 작업을 호출하고 속성을 변경할 수 있습니다.
+ 인스턴스를 만들 때 값을 클래스에 제공할 수 있습니다. 예를 들어 `class Dice(val numSides: Int)` 다음에 `Dice(6)`로 인스턴스를 만듭니다.
+ 함수에서 무언가를 반환할 수 있습니다. 함수 정의에서 반환할 데이터 유형을 지정하고 함수 본문에서 `return` 문을 사용하여 무언가를 반환합니다. 예: `fun example(): Int { return 5 }`



## 🎖 Track 2 : Create an interactive Dice Roller app

### 앱 레이아웃 만들기

+ 도구 아이콘이 있는 **text** 속성은 개발자만을 위한 '도구 텍스트' 속성입니다.  `TextView`에서 도구 텍스트를 '1'로 설정합니다(주사위 굴리기 값 1이 있다고 가정함). '1'은 Android 스튜디오 내 **Design Editor**에만 표시되고 실제 기기 또는 에뮬레이터에서 앱을 실행할 때는 표시되지 않습니다



### Activity 만들기

+ `Activity`는 앱이 UI를 그리는 창을 제공합니다. 일반적으로 `Activity`는 실행되는 앱의 전체 화면을 차지합니다. 모든 앱에는 활동이 하나 이상 있습니다. 최상위 수준 또는 첫 번째 활동을 종종 `MainActivity`라고 하고 프로젝트 템플릿에서 제공합니다. 예를 들어 사용자가 기기에서 앱 목록을 스크롤하여 'Dice Roller' 앱 아이콘을 탭하면 Android 시스템은 앱의 `MainActivity`를 시작합니다.



```kotlin
package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
```



+ 앞서 모든 Kotlin 프로그램에는 `main()` 함수가 있어야 한다고 알아봤습니다. Android 앱은 다르게 작동합니다. `main()` 함수를 호출하는 대신 Android 시스템은 앱이 처음 열릴 때 `MainActivity`의 `onCreate()` 메서드를 호출합니다.



+ **File > New Project Settings > Setting for New Project... > Other Settings > Auto Import**로 이동합니다.  **unambigous imports** 설정은 Android 스튜디오에 사용할 문을 결정할 수 있는 한 import 문을 자동으로 추가하라고 지시합니다. **optimize imports** 설정은 Android 스튜디오에 코드에서 사용되지 않는 가져오기를 삭제하라고 지시합니다



### Button을 상호작용적으로 만들기

```kotlin
class MainActivity : AppCompatActivity() {

   override fun onCreate(savedInstanceState: Bundle?) {
       super.onCreate(savedInstanceState)
       setContentView(R.layout.activity_main)

       val rollButton: Button = findViewById(R.id.button)
       rollButton.setOnClickListener {
           val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
           toast.show()
       }
   }
}
```



+ `val rollButton: Button = findViewById(R.id.button)`

  `findViewById()` method finds the `Button` in the layout.

  `R.id.button` is the resource ID for the `Button`, which is a unique identifier for it.

  The code saves a *reference* to the `Button` object in a variable called `rollButton`, not the `Button` object itself.

  > Android는 자동으로 **앱의 리소스에 ID 번호를 할당**합니다. 예를 들어 **Roll** 버튼에는 리소스 ID가 있고 버튼 텍스트의 문자열에도 리소스 ID가 있습니다. 리소스 ID의 형식은 `R.<type>.<name>`입니다(예: `R.string.roll`). `View` ID의 경우 `<type>`이 `id`입니다(예: `R.id.button`).



+ ```
   rollButton.setOnClickListener {
             val resultTextView: TextView = findViewById(R.id.textView)
             resultTextView.text = "6"
          }
  ```

  이렇게 `rollButton.setOnClickListener`함수의 코드를 바꿔, **Button을 클릭할 때 TextView를 업데이트** 할 수 있다.   



### 주사위 굴리기 로직 추가

```kotlin
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
           rollDice()
        }
    }

    private fun rollDice() {
       val dice = Dice(6)
        val diceRoll = dice.roll()
        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = diceRoll.toString()
    }
}

class Dice(private val numSides: Int) { 
    fun roll(): Int {
        return (1..numSides).random()
    }
}
```



### Good coding practices

+ `Control+A` + `Ctrl+Alt+L` => 공백, 들여쓰기 간격 등의 코드 서식 지정이 업데이트된다. 

+ class의 주석 예시

  ```kotlin
  /**
  * This activity allows the user to roll a dice and view the result
  * on the screen.
  */
  class MainActivity : AppCompatActivity() {
  ```

+ method의 주석 예시

  ```kotlin
  /**
  * Roll the dice and update the screen with the result.
  */
  private fun rollDice() {
  ```






## 🎖 Track 3 : Add conditional behavior in kotlin

### Decision making in your code

+ 정수의 경우 `Int` 데이터 유형이 있고 범위의 경우 `IntRange`가 있는 것처럼 `true` 및 `false`의 경우에는 `Boolean`이라는 데이터 유형이 있습니다. 이 과정의 뒷부분에서 `Boolean` 유형 변수를 다룹니다. 


  ```kotlin
  fun main() {
      val myFirstDice = Dice(6)
      val rollResult = myFirstDice.roll()
      val luckyNumber = 4
  
      if (rollResult == luckyNumber) {
          println("You win!")
      } else if (rollResult == 1) {
          println("So sorry! You rolled a 1. Try again!")
      } else if (rollResult == 2) {
          println("Sadly, you rolled a 2. Try again!")
      } else if (rollResult == 3) {
          println("Unfortunately, you rolled a 3. Try again!")
      } else if (rollResult == 4) {
          println("No luck! You rolled a 4. Try again!")
      } else if (rollResult == 5) {
          println("Don't cry! You rolled a 5. Try again!")
      } else {
          println("Apologies! you rolled a 6. Try again!")
      }
  }
  ```

  > if-else 코드 블록에서 `else` 문 하나와 함께 `if` 문 하나만 보유할 수 있지만 그 사이에는 필요한 만큼 `else if` 문을 보유할 수 있습니다.





### when 문 사용

```kotlin
fun main() {
    val myFirstDice = Dice(6)
    val rollResult = myFirstDice.roll()
    val luckyNumber = 4

    when (rollResult) {
        luckyNumber -> println("You won!")
        1 -> println("So sorry! You rolled a 1. Try again!")
        2 -> println("Sadly, you rolled a 2. Try again!")
        3 -> println("Unfortunately, you rolled a 3. Try again!")
        4 -> println("No luck! You rolled a 4. Try again!")
        5 -> println("Don't cry! You rolled a 5. Try again!")
        6 -> println("Apologies! you rolled a 6. Try again!")
    }
}
```

+ `rollResult`가 `luckyNumber`이면 `"You win!"` 메시지를 출력합니다. 





## 🎖 Track 4 : Add images to the Dice Roller app

```kotlin
val drawableResource = when (diceRoll) {
   1 -> R.drawable.dice_1
   2 -> R.drawable.dice_2
   3 -> R.drawable.dice_3
   4 -> R.drawable.dice_4
   5 -> R.drawable.dice_5
   6 -> R.drawable.dice_6
}

diceImage.setImageResource(drawableResource)
```

```kotlin
private fun rollDice() {
        // Create new Dice object with 6 sides and roll the dice
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // Find the ImageView in the layout
        val diceImage: ImageView = findViewById(R.id.imageView)

        // Determine which drawable resource ID to use based on the dice roll
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Update the ImageView with the correct drawable resource ID
        diceImage.setImageResource(drawableResource)

        // Update the content description
        diceImage.contentDescription = diceRoll.toString()
    }
```

+ `setImageResource()`를 사용하여 `ImageView`에 표시되는 이미지를 변경한다.  

+ `if / else` 표현식이나 `when` 표현식과 같은 제어 흐름 문을 사용하여 앱에서 다양한 사례를 처리합니다(예: 여러 상황에서 다양한 이미지 표시).



## 🎖 Track 5 : lemonade App

#### 리소스 접근하는 법

+ drawble resource
  `lemonImage?.setImageResource(R.drawable.lemon_tree)`

+ string resource

  `textAction.setText(R.string.lemon_select)`



#### 문자열 서식 지정

문자열의 서식을 지정해야 할 경우, 다음 예시와 같이 문자열 리소스에 서식 인수를 추가하여 지정할 수 있습니다.

```kotlin
<string name="welcome_messages">Hello, %1$s! You have %2$d new messages.</string>
```

이 예시는 서식 문자열에 두 개의 인수가 있습니다. `%1$s`는 문자열이고 `%2$d`는 10진수입니다. `getString(int, Object...)`을 호출하여 문자열의 서식을 지정해보겠습니다. 예를 들면 다음과 같습니다.

```kotlin
var text = getString(R.string.welcome_messages, username, mailCount)
```



#### View를 클릭했을 때, 동작 실행하기

```kotlin
private var lemonImage: ImageView? = null

lemonImage = findViewById(R.id.image_lemon_state)

lemonImage!!.setOnClickListener {
            // TODO: call the method that handles the state when the image is clicked
            clickLemonImage()
        }

lemonImage!!.setOnLongClickListener {
            // TODO: replace 'false' with a call to the function that shows the squeeze count
            // 길게 눌렀을 때 얼마나 레몬을 짰는지 알려줌
            showSnackbar()
        }
```



#### onSaveInstanceState 

+ `onSaveInstanceState()` 메소드를 이용하면 Activity가 종료될 때 데이터를 저장할 수 있습니다. 일반적으로 사용자가 정상적인 행동으로 Activity를 종료할 때는 해당 이벤트를 미리 감지하고 그에 맞는 대처를 해줄 수가 있지만, 실제로는 다양한 상황에서 Activity가 종료되는 현상이 발생할 수 있습니다. 그리고 다시 액티비티가 실행될 때는 `onCreate(savedInstanceState: Bundle?)`에서 Bundle안의 data를 받아서 이용할 수 있다.



+ Activity가 종료되는 경우
  + 사용자가 ‘뒤로 가기(Back)’ 버튼을 눌러 Activity를 종료한 경우
  + Activity가 백그라운드에 있을 때 시스템 메모리가 부족해진 경우(OS가 강제 종료시킴)
  + 언어 설정을 변경할 때
  + 화면을 가로/세로 회전할 때
  + 폰트 크기나 폰트를 변경했을 때



+ 사용 예시

  ```kotlin
  override fun onSaveInstanceState(outState: Bundle) {
      outState.putString(LEMONADE_STATE, lemonadeState)
      outState.putInt(LEMON_SIZE, lemonSize)
      outState.putInt(SQUEEZE_COUNT, squeezeCount)
      super.onSaveInstanceState(outState)
  }
  
  override fun onCreate(savedInstanceState: Bundle?) {
          super.onCreate(savedInstanceState)
          setContentView(R.layout.activity_main)
  
          // === DO NOT ALTER THE CODE IN THE FOLLOWING IF STATEMENT ===
          if (savedInstanceState != null) {
              lemonadeState = savedInstanceState.getString(LEMONADE_STATE, "select")
              lemonSize = savedInstanceState.getInt(LEMON_SIZE, -1)
              squeezeCount = savedInstanceState.getInt(SQUEEZE_COUNT, -1)
          }
  ```











## Quiz/Unit1/Pathway4

1. Which of the following is an example of a class?

   => 

   + A Car class that has a make and model, and that can be driven
   + A Flower class that has a scent
   + A Puppy class that has breed, weight and age, and that can bark
   + A ShoppingCart class that has a cart size and cart value, and that can hold items
   + A Song class that has lyrics



2. Which of the following is a difference between a class and an instance?

   => 

   + You can think of a class as a blueprint and an instance as the actual “thing".

   + A class is like architectural plans for a bridge, and the Golden Gate bridge an instance of those plans.
   + You can create multiple instances from a class, but you can't create classes from instances.



3. For each of the following types of information, select whether it should be part of a class or an instance.

   => 

   + Information about properties shared by all "things" belonging to the class, such as number of sides, number of legs, or that it has a color. => **class**

   + The specifics about a property, such as the specific color of a “thing” that can have a color. 

     => **Instance**

   

4. True or false? Every MainActivity class in Android must have a main() function.

   => False



5. Which of the following is NOT a way for creating a comment in Kotlin?

   =>  

   + Use // to turn the rest of a function into a comment.
   + Use /* to start a comment that is one line long.

   => way of creating comment in Kotlin

   + Add // at the beginning of or inside a line and anything after that // is considered a comment.
   + Put /* or /** to start a block comment, and end it with */.

   

6. Which of the following statements about a conditional statement is true?

   => 

   + A conditional statement is a way for you to set up a condition and ensure that code following it is only executed if that condition is met.
   + A conditional statement can be used within functions to return output based on conditions defined in that function.



7. What is a good reason for you to add comments to your code?

   => 

   + To explain to yourself or others why the code is written a certain way.
   + To structure code, like chapter headings in books.
   + To point out some part of the code that is very important.
   + To explain to other developers how to use your code for their own programs.



8. Which of the following are Kotlin data types?

   => 

   + IntRange
   + Int
   + Boolean(true or false)



9. Which of the following are valid keywords used in conditional statements in Kotlin?

   => 

   + if, else

   + when

 
