# Unit1-Pathway4_한승현



* **Kotlin의 클래스 및 객체 인스턴스**

  * 랜덤 숫자 굴리기

    ```kotlin
    fun main() {
    	val diceRange: IntRange = 1..6 // 1 이상 6 이하의 범위 지정
    	val randomNumber = diceRange.random() // diceRange의 범위에서 random으로 randomNumber에 할당
    	println("Random number : ${randomNumber}")
    }
    ```

  * Dice 클래스 만들기

    ```kotlin
    fun main() {
      val myFirstDice = Dice()
      println(myFirstDice.sides)
      // myFirstDice 인스턴스의 roll() 함수 호출
      myFirstDice.roll()
    }
    
    // Dice 클래스 선언
    class Dice {
      var sides = 6
      
      // 1 이상 6 이하의 주사위의 눈이 나오도록 roll() 함수 선언
      fun roll() {
        val randomNumber = (1..6).random()
        println(randomNumber)
      }
    }
    ```

  * 주사위 굴리기 값 반환

    ```kotlin
    fun main() {
        val myFirstDice = Dice()
      	// diceRoll에 myFirstDice 인스턴스의 roll() 함수 결과값 할당
        val diceRoll = myFirstDice.roll()
        println("Your ${myFirstDice.sides} sided dice rolled ${diceRoll}!")
    }
    
    class Dice {
        var sides = 6
    
      	// roll() 함수가 randomNumber를 return하도록 수정
        fun roll(): Int {
            val randomNumber = (1..6).random()
            return randomNumber
        }
    }
    ```

  * 주사위의 면 수 변경

    ```kotlin
    fun main() {
    
        val myFirstDice = Dice()
        val diceRoll = myFirstDice.roll()
        println("Your ${myFirstDice.sides} sided dice rolled ${diceRoll}!")
    
    		// myFirstDice의 면 수를 20으로 재할당
        myFirstDice.sides = 20
        println("Your ${myFirstDice.sides} sided dice rolled ${myFirstDice.roll()}!")
    }
    
    class Dice {
        var sides = 6
    
      	// 1 이상 sides 이하의 주사위의 눈이 나오도록 roll() 함수 수정
        fun roll(): Int {
            val randomNumber = (1..sides).random()
            return randomNumber
        }
    }
    ```

  * 주사위 맞춤설정

    ```kotlin
    fun main() {
      	// myFirstDice는 면 수가 6인 주사위
        val myFirstDice = Dice(6)
        val diceRoll = myFirstDice.roll()
        println("Your ${myFirstDice.numSides} sided dice rolled ${diceRoll}!")
    
      	// mySecondDice는 면 수가 20인 주사위
        val mySecondDice = Dice(20)
        println("Your ${mySecondDice.numSides} sided dice rolled ${mySecondDice.roll()}!")
    }
    
    // Dice 클래스로 인스턴스 생성 시 numSides를 바로 할당할 수 있도록 코드 수정
    // numSides를 인자로 넘겨주지 않을 시 오류
    class Dice (val numSides: Int) {
    
        fun roll(): Int {
            val randomNumber = (1..numSides).random()
            return randomNumber
        }
    }
    ```

  * 적절한 코딩 사례 채택

    ```kotlin
    fun main() {
        val myFirstDice = Dice(6)
      	// println() 안에서 myFirstDice.roll() (not null)을 실행
        println("Your ${myFirstDice.numSides} sided dice rolled ${myFirstDice.roll()}!")
    
        val mySecondDice = Dice(20)
      	// println() 안에서 mySecondDice.roll() (not null)을 실행
        println("Your ${mySecondDice.numSides} sided dice rolled ${mySecondDice.roll()}!")
    }
    
    class Dice (val numSides: Int) {
    
        fun roll(): Int {
          	// randomNumber 변수 없이 바로 return
            return (1..numSides).random()
        }
    }
    ```

* **상호작용 Dice Roller 앱 만들기**

  * Button을 상호작용적으로 만들기

    ```kotlin
    class MainActivity : AppCompatActivity() {
    
       override fun onCreate(savedInstanceState: Bundle?) {
           super.onCreate(savedInstanceState)
           setContentView(R.layout.activity_main)
    
         	 // rollButton는 id가 button인 view를 참조(복사 후 할당 x)
           val rollButton: Button = findViewById(R.id.button)
           // rollButton에 setOnClickListener 구현
           rollButton.setOnClickListener {
             	 // Toast.makeText()를 사용하면 Toast 메시지를 띄울 수 있음
               val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
             	 // Toast.makeText().show() 로도 호출 가능
    					 toast.show()
               // resultTextView는 id가 textView인 view를 참조(복사 후 할당 x)
               val resultTextView: TextView = findViewById(R.id.textView)
               // resultTextView의 text를 6으로 값 변경
               resultTextView.text = "6"
           }
       }
    }
    ```

  * 주사위 굴리기 로직 추가

    ```kotlin
    class MainActivity : AppCompatActivity() {
    
       override fun onCreate(savedInstanceState: Bundle?) {
           super.onCreate(savedInstanceState)
           setContentView(R.layout.activity_main)
    
         	 // rollButton는 id가 button인 view를 참조(복사 후 할당 x)
           val rollButton: Button = findViewById(R.id.button)
           // rollButton에 setOnClickListener 구현
           rollButton.setOnClickListener {
             	 rollDice()
           }
         
         	 // rollButton.setOnClickListener() 안에서 호출할 rollDice 함수 구현
         	 private fun rollDice() {
             val dice = Dice(6)
             val diceRoll = dice.roll()
             val resultTextView: TextView = findViewById(R.id.textView)
             // return값은 Int이지만 TextView의 text 속성은 String이므로 toString() 메서드 사용
             resultTextView.text = diceRoll.toString()
           }
       }
      
       class Dice(private val numSides: Int) {
         
         fun roll(): Int {
           return (1..numSides).random()
         }
       }
    }
    ```

* Kotlin에서 조건부 동작 추가

  ```kotlin
  fun main() {
      val myFirstDice = Dice(6)
      val rollResult = myFirstDice.roll()
      val luckyNumber = 4
  
    	// kotlin에서도 if ~ else 문을 사용하여 조건부 연산 가능
      if (rollResult == luckyNumber) {
          println("You win!")
      } else if (rollResult == 1) {
          println("So sorry! You rolled a 1. Try again!")
      } else if (rollResult == 2) {
          println("Sadly, you rolled a 2. Try again!")
      } else if (rollResult == 3) {
          println("Unfortunately, you rolled a 3. Try again!")
      } else if (rollResult == 5) {
          println("Don't cry! You rolled a 5. Try again!")
      } else {
          println("Apologies! You rolled a 6. Try again!")
      }
  }
  ```

  ```kotlin
  fun main() {
      val myFirstDice = Dice(6)
      val rollResult = myFirstDice.roll()
      val luckyNumber = 4
  
    	// kotlin에서 if ~ else 문 대신 when 문을 사용하여 조건부 연산 가능
      when (rollResult) {
          luckyNumber -> println("You won!")
          1 -> println("So sorry! You rolled a 1. Try again!")
          2 -> println("Sadly, you rolled a 2. Try again!")
          3 -> println("Unfortunately, you rolled a 3. Try again!")
          5 -> println("Don't cry! You rolled a 5. Try again!")
          6 -> println("Apologies! you rolled a 6. Try again!")
      }
  }
  ```

* Dice Roller 앱에 이미지 추가

  * 주사위 굴리기에 따라 올바른 주사위 이미지 표시

    ```kotlin
    private fun rollDice() {
       val dice = Dice(6)
       val diceRoll = dice.roll()
    
       val diceImage: ImageView = findViewById(R.id.imageView)
    
       // when 문 안에서 setImageResource를 활용하여 ImageView의 image를 유동적으로 변화시킬 수 있음
       when (diceRoll) {
           1 -> diceImage.setImageResource(R.drawable.dice_1)
           2 -> diceImage.setImageResource(R.drawable.dice_2)
           3 -> diceImage.setImageResource(R.drawable.dice_3)
           4 -> diceImage.setImageResource(R.drawable.dice_4)
           5 -> diceImage.setImageResource(R.drawable.dice_5)
           6 -> diceImage.setImageResource(R.drawable.dice_6)
       }
    }
    ```



### Quiz

1. Which of the following is an example of a class?
   * `A Car class that has a make and model, and that can be driven`
   * `A Flower class that has a scent`
   * `A Puppy class that has breed, weight and age, and that can bark`
   * `A ShoppingCart class that has a cart size and cart value, and that can hold items`
   * `A Song class that has lyrics`
2. Which of the following is a difference between a class and an instance?
   * `You can think of a class as a blueprint and an instance as the actual “thing".`
   * `A class is like architectural plans for a bridge, and the Golden Gate bridge an instance of those plans.`
   * `You can create multiple instances from a class, but you can't create classes from instances.`
3. For each of the following types of information, select whether it should be part of a class or an instance.
   1. Information about properties shared by all "things" belonging to the class, such as number of sides, number of legs, or that it has a color.
      * `Class`
   2. The specifics about a property, such as the specific color of a “thing” that can have a color.
      * `Instance`
4. True or false? Every MainActivity class in Android must have a main() function.
   * `false`
5. Which of the following is NOT a way for creating a comment in Kotlin?
   * `Use // to turn the rest of a function into a comment.`
   * `Use /* to start a comment that is one line long.`
6. Which of the following statements about a conditional statement is true?
   * `A conditional statement is a way for you to set up a condition and ensure that code following it is only executed if that condition is met.`
   * `A conditional statement can be used within functions to return output based on conditions defined in that function.`
7. What is a good reason for you to add comments to your code?
   * `To explain to yourself or others why the code is written a certain way.`
   * `To structure code, like chapter headings in books.`
   * `To point out some part of the code that is very important.`
   * `To explain to other developers how to use your code for their own programs.`
8. Which of the following are Kotlin data types?
   * `IntRange`
   * `Int`
   * `Boolean`
9. Which of the following are valid keywords used in conditional statements in Kotlin?
   * `if, else`
   * `when`