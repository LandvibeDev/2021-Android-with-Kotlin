# 2021 Landvibe Summer Coding - Android



## Unit1 : Kotlin basics

## PathWay4 : Add a button to an app



### Classes and object instances in Kotlin

- `IntRange`는 시작점부터 끝점까지 정수의 범위를 나타내는 데이터 유형이다. 

  ex) `val diceRange = 1..6`

- 클래스는 건축가의 청사진 도면이 주택이 아니라 주택을 짓는 방법에 관한 안내도인 것과 비슷하다. 주택은 청사진에 따라 만들어진 실제 사물 또는 객체 인스턴스이다.

- 캡슐화는 논리적으로 관련된 기능을 단일 위치로 묶을 수 있다는 의미이다.

- class 이름은 카멜 표기법을 사용한다.

  ex) Car, ParkingMeter, CustomerRecord

```kotlin
fun main() {
    val myFirstDice = Dice() 
    // myFirstDice라는 변수를 만들어 Dice 클래스의 인스턴스로 초기화함.
}
```

```kotlin
fun main() {
    val myFirstDice = Dice()
    println(myFirstDice.sides)
    myFirstDice.roll()
}

class Dice {
    var sides = 6

    fun roll() { //Method
        val randomNumber = (1..6).random()
        println(randomNumber)
    }
}
//sides 변수와 roll() 함수를 사용하여 Dice 클래스르르 정의함. 
//main() 함수에서 새로운 Dice 객체 인스턴스를 만든 후 roll() 메서드를 호출하여 랜덤 숫자를 생성함.
```

```kotlin
fun main() {
    val myFirstDice = Dice()
    val diceRoll = myFirstDice.roll()
    println("Your ${myFirstDice.sides} sided dice rolled ${diceRoll}!")
}

class Dice {
    var sides = 6

    fun roll(): Int {
        val randomNumber = (1..6).random()
        return randomNumber
    }
}

//return문을 사용하여 randomNumber을 반환하였다. 
//반환되는 변수가 Int형이므로 roll() 메서드 옆에 Int라고 작성하였다.
//반환된 값은 main() 함수에서 diceRoll이라는 변수에 저장이 되어 출력을 할 수 있게 하였다.
```

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
    }
}

//주사위 변수를 parameter로 받아 원하는 주사위 면 수를 설정할 수 있게 하였다.
```



### Create an interactive Dice Roller app

```kotlin
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // findViewById() 메서드는 레이아웃에서 Button을 찾는다. 
        //R.id.button은 Button의 리소스 ID로, Button의 고유한 식별자이다.
        // Button 객체 자체가 아니라 First_rollButton이라는 변수에 Button 객체 참조를 저장한다.
        val First_rollButton : Button = findViewById(R.id.button)
        
        //setOnClickListener() 메서드를 호출하여 클릭 리스너를 설정한다.
        First_rollButton.setOnClickListener{
            First_rollDice()	// First_rollDice() 함수를 호춯한다.
        }

        // findViewById() 메서드는 레이아웃에서 Button을 찾는다. 
        //R.id.button2은 Button의 리소스 ID로, Button의 고유한 식별자이다.
        // Button 객체 자체가 아니라 Second_rollButton 변수에 Button 객체 참조를 저장한다.
        val Second_rollButton : Button = findViewById(R.id.button2)
        
         //setOnClickListener() 메서드를 호출하여 클릭 리스너를 설정한다.
        Second_rollButton.setOnClickListener{
            Second_rollDice()	// Second_rollDice() 함수를 호춯한다.
        }
    }

    private fun First_rollDice() {
        val dice = Dice(6)	//인스턴스화한다.
        val diceRoll = dice.roll()	//return 값을 저장한다.
        
        //findViewById()를 호출하여 TextView를 찾는다.
        val resultTextView : TextView = findViewById(R.id.textView)
        //diceRoll 변수는 숫자이므로 toString()메서드를 사용하여 문자열로 변환한다.
        //resultTextView의 텍스트를 업데이트한다.
        resultTextView.text = diceRoll.toString()
    }

    private fun Second_rollDice() {
        val dice = Dice(6)	//인스턴스화한다.
        val diceRoll = dice.roll()	//return 값을 저장한다.
        
        //findViewById()를 호출하여 TextView를 찾는다.
        val resultTextView : TextView = findViewById(R.id.textView2)
        //diceRoll 변수는 숫자이므로 toString()메서드를 사용하여 문자열로 변환한다.
        //resultTextView의 텍스트를 업데이트한다.
        resultTextView.text = diceRoll.toString()
    }
}

class Dice(val numSides:Int){
    fun roll() : Int{
        return (1..numSides).random()	//1부터 numSides까지의 수를 랜덤으로 return 한다.
    }
}
```





### Add conditional behavior in Kotlin

- `if`문을 사용하여 일부 명령을 실행하는 조건을 설정한다.

- `Boolean` 데이터 유형에는 `true` 및 `false`라는 값이 있고 의사 결정에 사용할 수 있다.

- 초과(`>`), 미만(`<`), 같음(`==`) 등의 연산자를 사용하여 값을 비교한다.

- `else if`문 체인을 사용하여 여러 조건을 설정한다.

- 조건 체인 끝에 `else`문을 사용하여 명시적으로 커버되지 않을 수 있는 사례를 포착한다.

- 값 비교에 따라 코드를 실행하는 간단한 형식으로 `when`문을 사용한다.

- if-else의 일반 형식

  ```kotlin
  if (condition-is-true) {
  	execute-this-code
  }
  else if (condition-is-true) {
  	execute-this-code
  }
  else {
  	execute-this-code
  }
  ```

- when 문

  ```kotlin
  when (variable) {
  matches-value -> execute-this-code
  matches-value -> execute-this-code
  
  ...
  
  }
  ```

- 예시 코드

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
  
  class Dice(val numSides: Int) {
      fun roll(): Int {
          return (1..numSides).random()
      }
  }
  ```



### Add images to the Dice Roller app

- 앱에 주사위 이미지 추가
  - Android 스튜디오의 메뉴에서 **View > Toll Windows > Resource Manager**를 클릭하거나 Project 창 왼쪽에 있는 **Resource Manager** 탭을 클릭한다.
  - Resource Manager 아래의 **+**를 클릭하고 **Import Drawables**를 선택한다.
  - 원하는 파일들을 선택한다.
  - **Open > Next > Import**를 통해 리소스를 가져온다.

- 소스 코드

  ```kotlin
  class MainActivity : AppCompatActivity() {
      override fun onCreate(savedInstanceState: Bundle?) {
          super.onCreate(savedInstanceState)
          setContentView(R.layout.activity_main)
  
          val rollButton : Button = findViewById(R.id.button)
          rollButton.setOnClickListener{
             rollDice()
          }
      }
  
      // Roll the dice and update the screen with the result.
      private fun rollDice() {
          //Create new Dice object with 6 sides and roll the dice
          val dice = Dice(6)
          val diceRoll = dice.roll()
  
          //Find the ImageView in the layout
          val diceImage : ImageView = findViewById(R.id.imageView)
  
          //Determint which drawable resource ID to use based on the dice roll
          val drawableResource =  when (diceRoll){
              1 -> R.drawable.dice_1
              2 -> R.drawable.dice_2
              3 -> R.drawable.dice_3
              4 -> R.drawable.dice_4
              5 -> R.drawable.dice_5
              else -> R.drawable.dice_6
          }
  
          //Update the ImageView with the correct drawable resource ID
          diceImage.setImageResource(drawableResource)
  
          //Update the content description
          diceImage.contentDescription = diceRoll.toString()
      }
  }
  
  class Dice(var numSides:Int){
      fun roll() : Int{
          return(1..numSides).random()
      }
  }
  ```

### Quiz

1. **Which of the following is an example of a class?**

   --> A Car class that has a make a model, and that can be driven

   --> A Flower class that has a scent

   --> A Puppy class that has breed, weight and age, and that can bark

   --> A ShoppingCart class that has a cart size and cart value, and that can hold items

   --> A Song class that has lyrics

2. **Which of the following is a difference between a class and an instance?**

   --> You can think of a class as a blueprint and an instance as the actual "thing"

   --> A class is like architectural plans for a bridge, and the Golden Gate bridge an instance of those plans.

   --> You can create multiple instances from a class, but you can't create classes from instances.

3. **For each of the following types of information, select whether it should be part of a class or an instance.**

   - **Information about properties shared by all "things" belonging to the class, such as number of sides, number of legs, or that it has a color.**

     --> Class

   - **The Specifics about a property, such as the specific color of a "thing" that can have a color.**

     --> Instance

4. **True or false? Every MainActivity class in Android must have a main() function.**

   --> False

   :point_right: (안드로이드 앱에서는 main()함수를 호출하는 대신 MainActivity의 onCreate() 메서드를 호출한다.)

5. **Which  of the following is NOT  a way for creating a comment in Kotlin?**

   --> Use // to turn the rest of a function into a comment.

   --> Use /* to start a comment that is one line long.

6. **Which of the following statements about a conditional statement is true?**

   --> A conditional statement is a way for you to set up a condition and ensuer that code following it is only executed if that condition is met.

   --> A conditional statement can be used within functions to return output based on conditions defined in that function.

7. **What is a good reason for you to add comments to your code?**

   --> To explain to yourself or others why the code is written a certain way.

   --> To structure code, like chapter headings in books.

   --> To point out some part of the code that is very important.

   --> To explain to other developers how to use your code for their own programs.

8. **Which of the following are Kotlin data type?**

   --> IntRange

   --> Int

   --> Boolean(true or false)

9. **Which of the following are valid keywords used in conditional statements in Kotlin?**

   --> if, else

   --> when