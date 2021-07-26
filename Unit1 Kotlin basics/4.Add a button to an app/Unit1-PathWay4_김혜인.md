# 2021 Landvibe Summer Coding - Android

## Unit1 : Kotlin basics

### PathWay4 : Add a button to an app



##### :label: Classes and object instance in Kotlin

- `IntRange`

시작점 부터 끝점까지 정수의 범위를 나타내는 데이터 유형

`random()`함수를 호출하여 래넘 숫자를 생성할 수 있다.

``````kotlin
fun main() {
    val diceRange = 1..6
    val randomNumber = diceRange.random()
    println("Random number: ${randomNumber}")
}
``````

- 클래스

객체의 청사진

``````kotlin
fun main() {
    val myFirstDice = Dice(6) // 인스턴스 생성
    val diceRoll = myFirstDice.roll()
    println("Your ${myFirstDice.numSides} sided dice rolled ${diceRoll}!")

    val mySecondDice = Dice(20)
    println("Your ${mySecondDice.numSides} sided dice rolled ${mySecondDice.roll()}!")
}

class Dice (val numSides: Int) {
    fun roll(): Int {
        val randomNumber = (1..numSides).random()
        return randomNumber
    }
}
``````

- 리팩터링

코드를 더 간결하고 효율적이며 읽고 이해하기 쉽게 변경하는 것

``````kotlin
fun main() {
    val myFirstDice = Dice(6)
    println("Your ${myFirstDice.numSides} sided dice rolled ${myFirstDice.roll()}!")

    val mySecondDice = Dice(20)
    println("Your ${mySecondDice.numSides} sided dice rolled ${mySecondDice.roll()}!")
}

class Dice (val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}
``````



##### :label: Create an interactive Dive Roller app

- `Button`

사용자가 탭하여 작업을 실항할 수 있는 Android의 사용자 인터페이스(UI) 요소



- `Activity`

앱이 UI를 그리는 창, 실행되는 앱의 전체 화면을 차지한다.

Android시스템은 앱이 처음 열릴 때 `MainActivity`의 `onCreate()` 메서드를 호출한다.

``````kotlin
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
``````

- R.<type>.<name>

리소스 ID의 형식

- `Toast`

사용자에게 표시되는 간략한 토스트 메시지



- `textView`

``````kotlin
class MainActivity : AppCompatActivity() {

   override fun onCreate(savedInstanceState: Bundle?) {
       super.onCreate(savedInstanceState)
       setContentView(R.layout.activity_main)

       val rollButton: Button = findViewById(R.id.button)
       rollButton.setOnClickListener {
           val resultTextView: TextView = findViewById(R.id.textView)
           resultTextView.text = "6"
       }
   }
}
``````



``````kotlin
package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        // Create new Dice object with 6 sides and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // Update the screen with the dice roll
        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = diceRoll.toString()
    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}
``````

- `Ctrl+Alt+L`

공백, 들여쓰기 간격 등의 코드 서식 지정이 업데이트 된다.



##### :label: Add conditional behavior in Kotlin

- `when`

``````kotlin
fun main() {
    val myFirstDice = Dice(6)
    val rollResult = myFirstDice.roll()
    val luckyNumber = 4

    when (rollResult) {
        luckyNumber -> println("You won!")
        1 -> println("So sorry! You rolled a 1. Try again!")
        2 -> println("Sadly, you rolled a 2. Try again!")
        3 -> println("Unfortunately, you rolled a 3. Try again!")
        5 -> println("Don't cry! You rolled a 5. Try again!")
        6 -> println("Apologies! you rolled a 6. Try again!")
   }
}

class Dice(val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}
``````



 ##### :label: Add images to the Dice Roller app

``````kotlin
package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }

        // Do a dice roll when the app starts
        rollDice()
    }

    /**
     * Roll the dice and update the screen with the result.
     */
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
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}
``````

- `setImageResource()`

`ImageView`에 표시되는 이미지를 변경할 수 있다.





##### :label: Quiz

1. Which of the following is an example of a class?

   *적절한 답변을 모두 선택합니다.*

   - A Car class that has a make and model, and that can be driven
   - A Flower class that has a scent
   - A Puppy class that has breed, weight and age, and that can bark
   - A ShoppingCart class that has a cart size and cart value, and that can hold items
   - A Song class that has lyrics

2. Which of the following is a difference between a class and an instance?

   *적절한 답변을 모두 선택합니다.*

   - You can think of a class as a blueprint and an instance as the actual “thing".
   - A class is like architectural plans for a bridge, and the Golden Gate bridge an instance of those plans.
   - You can create multiple instances from a class, but you can't create classes from instances.

3. For each of the following types of information, select whether it should be part of a class or an instance.

   *각 답변은 일치하는 항목이 하나만 존재합니다.*

   - Information about properties shared by all "things" belonging to the class, such as number of sides, number of legs, or that it has a color.
     - Class
   - The specifics about a property, such as the specific color of a “thing” that can have a color.
     - Instance

4. True or false? Every MainActivity class in Android must have a main() function.

   - False

5. Which of the following is NOT a way for creating a comment in Kotlin?

   *적절한 답변을 모두 선택합니다.*

   - Use // to turn the rest of a function into a comment.
   - Use /* to start a comment that is one line long.

6. Which of the following statements about a conditional statement is true?

   *적절한 답변을 모두 선택합니다.*

   - A conditional statement is a way for you to set up a condition and ensure that code following it is only executed if that condition is met.
   - A conditional statement can be used within functions to return output based on conditions defined in that function.

7. What is a good reason for you to add comments to your code?

   - All of the above
     - To explain to yourself or others why the code is written a certain way.
     - To structure code, like chapter headings in books.
     - To point out some part of the code that is very important.
     - To explain to other developers how to use your code for their own programs.

8. Which of the following are Kotlin data types?

   *적절한 답변을 모두 선택합니다.*

   - IntRange
   - Int
   - Boolean (true or false)

9. Which of the following are valid keywords used in conditional statements in Kotlin?

   *적절한 답변을 모두 선택합니다.*

   - if, else
   - when



