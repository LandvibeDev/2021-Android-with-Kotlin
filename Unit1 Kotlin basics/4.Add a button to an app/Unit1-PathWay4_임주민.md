# π‘ Android Basics in Kotlin

## Unit #1 : Kotlin basics

## PATHWAY #4 : Add a button to an app

<br/>

<br/>



## 1οΈβ£ μ½νλ¦° ν΄λμ€ λ° κ°μ²΄ μΈμ€ν΄μ€

### π λλ€ μ«μ

* `IntRange` : μμμ λΆν° λμ κΉμ§ **μ μ**μ λ²μλ₯Ό λνλ. μ£Όμ¬μ κ΅΄λ¦¬κΈ°μμ μμ±ν  μ μλ κ°λ₯ν κ°μ λνλ΄λ μ μ ν λ°μ΄ν° μ ν ex) 3..46, 0..270, -6..+6, -10..-4
* `random()` : λλ€ ν¨μλ‘, μ£Όμ΄μ§ λ²μμ λλ€ μ«μ μμ±νκ³  λ°ν 

```kotlin
fun main() {
    val diceRange = 1..6
    val randomNumber = diceRange.random()
    // λ²μμμ ν¨μ μ§μ  νΈμΆ κ°λ₯ val randomNumber = (1..6).random()
  
    println("Random number: ${randomNumber}")
}
```

β	μ½λ μ€νν  λλ§λ€ λ§€λ² λ€λ₯Έ λλ€ μ«μλ‘ μΆλ ₯λ¨.

<br/>



### π Dice ν΄λμ€ λ§λ€κΈ°

```kotlin
fun main() {
  	// κ°μ²΄ μΈμ€ν΄μ€ μμ±
    val myFirstDice = Dice() 
  
  	// μ  νκΈ°λ²μΌλ‘ μμ±μ μμΈμ€
    println(myFirstDice.sides)

  	// roll() λ©μλ νΈμΆνμ¬ λλ€ μ«μ μμ±
  	myFirstDice.roll()
  	
}

class Dice {
   	var sides = 6
  	
  	// μ£Όμ¬μ κ΅΄λ¦¬λ ν¨μ
  	fun roll() {
      val randomNumber = (1..6).random()
      println(randomNumber)
    }
}
```

<br/>



### π μ£Όμ¬μ ν΄λμ€ λ³κ²½

* ν¨μλ°ν : fun ν¨μλͺ() : λ°μ΄ν° μ ν { return λ¬΄μΈκ° }

* μ£Όμ¬μ λ©΄ μ λ³κ²½ 

```kotlin
class Dice {
   	var sides = 6
  	
  	// Intλ₯Ό λ°ννλλ‘ ν¨μ μ μ λ³κ²½
  	fun roll() : Int {
      val randomNumber = (1..sides).random()
      return randomNumber
      // returnλ¬Έ μ¬μ©ν΄μ λ°νν΄μ£Όμ΄μΌν¨
    }
}

fun main() {
    val myFirstDice = Dice() 
  	val diceRoll = myFirstDice.roll()
  	println("Your ${myFirstDice.sides} sided dice rolled ${diceRoll}!")
  	
  	// μμ± λ³κ²½ (λ©΄ μ λ³κ²½)
  	myFirstDice.sides = 20 
 	  println("Your ${myFirstDice.sides} sided dice rolled ${myFirstDice.roll}!")
}
```

<br/>



### π μ μΈμ€ν΄μ€ λ§λ€ λ μμ± μ§μ νκΈ°

μΈμ€ν΄μ€λ₯Ό λ§λ€ λ κ°μ ν΄λμ€μ μ κ³΅ κ°λ₯

```kotlin
fun main() {
  	// μ²« λ²μ§Έ μ£Όμ¬μ κ°μ²΄
    val myFirstDice = Dice(6)
    val diceRoll = myFirstDice.roll()
    println("Your ${myFirstDice.numSides} sided dice rolled ${diceRoll}!")
	
  	// λ λ²μ§Έ μ£Όμ¬μ κ°μ²΄
    val mySecondDice = Dice(20)
    println("Your ${mySecondDice.numSides} sided dice rolled ${mySecondDice.roll()}!")
}


// numSidesλΌλ μ μλ₯Ό νμ©
class Dice (val numSides: Int) {

    fun roll(): Int {
        val randomNumber = (1..numSides).random()
        return randomNumber
      	// κ·Έλ₯ return (1..numSides).random()λ κ°λ₯
    }
}

```

<br/>

------

<br/>

## 2οΈβ£ μνΈμμ© Dice Roller μ± λ§λ€κΈ°

### π μ± μ€μ 

1. empty activity νλ‘μ νΈ λ§λ€κΈ°
2. layout editor μ΄κΈ°
3. Paletteμμ `Button` μΆκ°
4. Button μ¬λ°± μ€μ  ν text μμ 
5. `TextView` κΈμ μ¬μ΄μ¦ μμ  ν textμ λ΄μ© μμ κ³ , λκ΅¬ μμ΄μ½μ΄ μλ textμ λ¬Έμ μΆκ°(μ± μ€ν μμλ λ³΄μ΄μ§ μλλ€.)

<br/>



### π Activity

* `Activity` : μ±μ΄ UIλ₯Ό κ·Έλ¦¬λ μ°½μ μ κ³΅νλ©°, μΌλ°μ μΌλ‘ μ€νλλ μ±μ μ μ²΄ νλ©΄μ μ°¨μ§νλ€. μ΅μμ μμ€ λλ μ²« λ²μ§Έ νλμ `MainActivity`λΌκ³  νλ€.
  * μλ₯Ό λ€μ΄ μ¬μ§ κ°€λ¬λ¦¬ μ±μλ μ¬μ§ κ·Έλ¦¬λλ₯Ό νμνλ `Activity`, κ°λ³ μ¬μ§μ λ³΄λ λ λ²μ§Έ `Activity`, κ°λ³ μ¬μ§μ νΈμ§νλ μΈ λ²μ§Έ `Activity`κ° μμ μ μλ€.
* `MainActivity.kt` (app > java > com.example.diceroller > MainActivity.kt)λ₯Ό μ°λ€.
  * class MainActivityμλ λ©μΈν¨μκ° μλ€. μλλ‘μ΄λ μ±μμλ λ©μΈν¨μλ₯Ό νΈμΆνλ λμ , μ±μ΄ μ²μ μ΄λ¦΄ λ MainActivityμ `onCreate()` λ©μλλ₯Ό νΈμΆνλ€.
  * onCreate()μμλ `setContentView()`λ‘ μμ λ μ΄μμμ μ€μ νμ¬ MainActivityλ₯Ό μ€μ νλ€.
* `import`λ¬Έμ μ¬μ©νμ¬ μ½λμμ μ¬μ©ν  νλ μμν¬μ ν΄λμ€ μ§μ κ°λ₯.
  * μλ₯Ό λ€μ΄ Button ν΄λμ€λ androi.widget.Buttonμ μ μλμ΄ μλ€.
* **μλ κ°μ Έμ€κΈ° μ¬μ© μ€μ **
  *  File > New Project Settings > Preferences for New Projects
  * Other Settings > Auto Import > Java, Kotlin
  * **Add unambiguous imports** μ€μ  : Android μ€νλμ€μ μ¬μ©ν  λ¬Έμ κ²°μ ν  μ μλ ν import λ¬Έμ μλμΌλ‘ μΆκ°νλΌκ³  μ§μ 
  * **Optimize imports on the fly(for current project)** μ€μ  : Android μ€νλμ€μ μ½λμμ μ¬μ©λμ§ μλ κ°μ Έμ€κΈ°λ₯Ό μ­μ νλΌκ³  μ§μ

<br/>



### π Buttonμ μνΈμμ©μ μΌλ‘ λ§λ€κΈ°

##### Button ν΄λ¦­ν  λ λ©μμ§ νμ

* `onCreate()`λ©μλμ μΆκ°νμ¬ λ²νΌμ ν΄λ¦­ν  λ κ°λ¨ν λ©μμ§κ° νλ©΄ νλ¨μ νμνλλ‘ μ§μ 

* μ½λκ° μ€νλ  μ μλλ‘ μ½λλ₯Ό Buttonκ³Ό μ°κ²°
  * ν΄λ¦­ λ¦¬μ€λ : ν­ λλ ν΄λ¦­μ΄ λ°μν  λ μ€νν  μμμ μν μ½λμ΄λ€. μ¬κΈ°μ `rollButton` κ°μ²΄ μ¬μ©, `setOnClickListener()`λ©μλ νΈμΆνμ¬ μ€μ 
  * `Toast` : μ¬μ©μμκ² νμλλ κ°λ΅ν λ©μμ§. Toast.makeText()νΈμΆ, show()λ©μλ νΈμΆ

```kotlin
class MainActivity : AppCompatActivity() {

   override fun onCreate(savedInstanceState: Bundle?) {
       super.onCreate(savedInstanceState)
       setContentView(R.layout.activity_main)
     
			 // μΆκ°λ κ³³, μ΄ν μλλ‘μ΄λ μ€νλμ€λ μλμ μΌλ‘ importλ¬Έ μΆκ°
       val rollButton: Button = findViewById(R.id.button)
       rollButton.setOnClickListener { //ν΄λ¦­ λ¦¬μ€λ μ€μ 
           val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT) // "Dice Rolled!"νμ€νΈλ‘ ν μ€νΈ μμ±
           toast.show() //Toastμ μμ²΄λ₯Ό νμνλΌκ³  μ§μ
       }
   }
}
```

* λ³μ μμ΄ ν΄λ¦­ λ¦¬μ€λμ λ μ€μ ν μ€λ‘ κ²°ν© κ°λ₯ 

```kotlin
Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show()
```

<br/>



##### Button ν΄λ¦­ν  λ νλ©΄μ TextView μλ°μ΄νΈ

1. layout editorμμ TextViewν΄λ¦­ ν idκΈ°μ΅
2. `MainActivity.kt`(app > java > com.example.diceroller > MainActivity.kt)

```kotlin
class MainActivity : AppCompatActivity() {

   override fun onCreate(savedInstanceState: Bundle?) {
       super.onCreate(savedInstanceState)
       setContentView(R.layout.activity_main)

       val rollButton: Button = findViewById(R.id.button)
       rollButton.setOnClickListener { 
         	 // μμ λ κ³³
         	 // μλ‘μ΄ λ³μ λ§λ€κ³  TextView μ μ₯. 
           val resultTextView: TextView = findViewById(R.id.textView) //λ μ΄μμμμ IDλ‘ textViewμ°Ύκ³  κ·Έ μ°Έμ‘° μ μ₯
           resultTextView.text = "6" //νμ€νΈ μ€μ 
       }
   }
}
```

<br/>



### π μ£Όμ¬μ κ΅΄λ¦¬κΈ° λ‘μ§ μΆκ°

##### Dice ν΄λμ€ μΆκ°

* MainActivity ν΄λμ€μ λ§μ§λ§ μ€κ΄νΈ λ€μ μΆκ°
* ν΄λ¦­ λ¦¬μ€λμ μ½λλ₯Ό rollDice()λ‘ μμ 
* μ΄ν rollDice()ν¨μ ν΄λ¦­νκ³  `Option+Enter`λλ¬ λ©λ΄μμ ν¨μ μ μ λ²νΌ ν΄λ¦­

```kotlin
class Dice(val numSides: Int) {

   fun roll(): Int {
       return (1..numSides).random()
   }
}
private fun rollDice() {
    val dice = Dice(6)
    val diceRoll = dice.roll()
    val resultTextView: TextView = findViewById(R.id.textView)
    resultTextView.text = diceRoll.toString()
}
```

<br/>

<br/>

------



## 3οΈβ£ μ‘°κ±΄λΆ λμ μΆκ°

### π μ½λ λ΄μμ μμ¬ κ²°μ 

* `if`λ¬Έ : if ( μ‘°κ±΄μ true νΉμ false ) { μ½λ } 
* `else if`λ¬Έ : λμ²΄ μ‘°κ±΄ μΆκ°
* `else`λ¬Έ : μ‘°κ±΄ μΆ©μ‘±λμ§ μμ λ λμ μ κ³΅
* `when`λ¬Έ : when ( νμ€νΈν  κ° ) { μ½λ }

<br/>



### π νμ΄μ μ«μκ° μλ μ£Όμ¬μ

* λ©μΈμ `luckyNumber`λ³μ μΆκ° ν 4λ‘ μ€μ 

```kotlin
fun main() {
    val myFirstDice = Dice(6)
    val rollResult = myFirstDice.roll()
    val luckyNumber = 4
		
  	// if, else if, else μ¬μ©
    if (rollResult == luckyNumber) {
        println("You win!")
    } else if (rollResult == 1) {
        println("So sorry! You rolled a 1. Try again!")
    } else {
        println("Apologies! Try again!")
    }
  
    //when μ¬μ©
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

<br/>

<br/>

------



## 4οΈβ£ μ΄λ―Έμ§ μΆκ°

* TextViewλ₯Ό `ImageView`λ‘ λ°κΎΌ ν μμ μ΄λ―Έμ§ μΆκ°νκ³  μ μ½μ‘°κ±΄ μ€μ 

* μ΄λ―Έμ§ λ€μ΄λ‘λ ν Resource Manager ν­μμ import drawable μ€μ 

* `MainActivity.kt`(app > java > com.example.diceroller > MainActivity.kt)μ΄κ³  μ½λμμ 

  ```kotlin
  private fun rollDice() {
      val dice = Dice(6)
      val diceRoll = dice.roll()
      val diceImage: ImageView = findViewById(R.id.imageView)
      diceImage.setImageResource(R.drawable.dice_2)
    
    	val drawableResource = when (diceRoll) {
     		 1 -> R.drawable.dice_1
    		 2 -> R.drawable.dice_2
    		 3 -> R.drawable.dice_3
    		 4 -> R.drawable.dice_4
    		 5 -> R.drawable.dice_5
    	   else -> R.drawable.dice_6
  }
  
  diceImage.setImageResource(drawableResource)
  }
  ```

* ImageViewμ μ μ ν μ½νμΈ  μ€λͺ μ€μ 

  ```kotlin
  diceImage.contentDescription = diceRoll.toString()
  ```

  <br/>

  

  <br/>

  

------

### π ν΄μ¦

**1. Which of the following is an example of a class?**

> A Car class that has a make and model, and that can be driven
>
> A Flower class that has a scent
>
> A Puppy class that has breed, weight and age, and that can bark
>
> A ShoppingCart class that has a cart size and cart value, and that can hold items
>
> A Song class that has lyrics

<br/>



**2. Which of the following is a difference between a class and an instance?**

> You can think of a class as a blueprint and an instance as the actual βthing".
>
> A class is like architectural plans for a bridge, and the Golden Gate bridge an instance of those plans.
>
> You can create multiple instances from a class, but you can't create classes from instances.

<br/>



**3-1. Information about properties shared by all "things" belonging to the class, such as number of sides, number of legs, or that it has a color.**

> Class

<br/>



**3-2. The specifics about a property, such as the specific color of a βthingβ that can have a color.**

> Instance

<br/>



**4. Every MainActivity class in Android must have a main() function.**

> False

<br/>



**5. Which of the following is NOT a way for creating a comment in Kotlin?**

> Use // to turn the rest of a function into a comment.
>
> Use /* to start a comment that is one line long.

<br/>



**6. Which of the following statements about a conditional statement is true?**

> A conditional statement is a way for you to set up a condition and ensure that code following it is only executed if that condition is met.
>
> A conditional statement can be used within functions to return output based on conditions defined in that function.

<br/>



**7. What is a good reason for you to add comments to your code?**

> To explain to yourself or others why the code is written a certain way.
>
> To structure code, like chapter headings in books.
>
> To point out some part of the code that is very important.
>
> To explain to other developers how to use your code for their own programs.

<br/>



**8. Which of the following are Kotlin data types?**

> IntRange
>
> Int
>
> Boolean (true or false)

<br/>



**9. Which of the following are valid keywords used in conditional statements in Kotlin?**

> if, else
>
> when