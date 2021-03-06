

## 2021 Landvibe Summer Coding - Android

### ๐ Android Basics In Kotlin

#### ๐ Unit1: Kotlin basics

#### ๐ PathWay3: Build a basic layout

<hr>

##### Classes and object instances in Kotlin



๋ฐ์ดํฐ ์ ํ: `intRange`

๋๋ค: `random()`



##### intRange & random ํ์ฉ

```kotlin
fun main() {
    val diceRange=1..6
    val randomNumber=diceRange.random()
    println("Random number: ${randomNumber}")
}
```

##### class & intRange & random ํ์ฉ

```kotlin
fun main() {
    val myFirstDice=Dice()
    println(myFirstDice.sides)
    myFirstDice.roll()
}

class Dice{
    var sides=6
    
    fun roll(){
        val randomNumber=(1..6).random()
        println(randomNumber)
    }
}
```

```kotlin
fun main() {
    val myFirstDice=Dice()
    val diceRoll=myFirstDice.roll()
    println("Your ${myFirstDice.sides} sided dice rolled ${diceRoll}!")
}

class Dice{
    var sides=6
    
    fun roll():Int{
        val randomNumber=(1..6).random()
        return randomNumber
    }
}
```

##### ์ฃผ์ฌ์ ๋ฉด ์ ๋ณ๊ฒฝ

```kotlin
fun main() {
    val myFirstDice=Dice()
    val diceRoll=myFirstDice.roll()
    println("Your ${myFirstDice.sides} sided dice rolled ${diceRoll}!")
    
    myFirstDice.sides=20
    println("Your ${myFirstDice.sides} sided dice rolled ${myFirstDice.roll()}!")
}

class Dice{
    var sides=6
    
    fun roll():Int{
        val randomNumber=(1..sides).random()
        return randomNumber
    }
}
```



๐จ class์์ ์ธ์ ์ ์ธ์์ ์๋ฃํ ํ๊ธฐํด์ฃผ์ด์ผ ํจ

```kotlin
class Dice(val numSides:Int){

}
```

##### ์ต์ข์ ๋ฆฌ

```kotlin
fun main() {
    val myFirstDice=Dice(6)
    println("Your ${myFirstDice.numSides} sided dice rolled ${myFirstDice.roll()}!")
	
    val mySecondDice=Dice(20)
    println("Your ${mySecondDice.numSides} sided dice rolled ${mySecondDice.roll()}!")
}

class Dice(val numSides:Int){
    fun roll():Int{
        //val randomNumber=(1..numSides).random()
        //return randomNumber
        
        //val ์ ์ธํ์ง ์๊ณ  ๋ฐ๋ก return๋ ๊ฐ๋ฅ
        return (1..numSides).random()
    }
}
```

##### ์๋ฃจ์์ฝ๋

```kotlin
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
```

<hr>

##### Create an interactive Dice Roller app

`Activity`:์ฑ์ด UI๋ฅผ ๊ทธ๋ฆฌ๋ ์ฐฝ์ ์ ๊ณต(ํ๋์ ํ๋ฉด์ด๋ผ๊ณ  ์๊ฐํ๋ฉด ๋จ)

`MainActivity.kt` ํ์ผ(**app > java > com.example.diceroller > MainActivity.kt**)๋ก ์ด๋ํ์ฌ ํ์ผ์ ์ฝ๋๋ค

`main()` ํจ์๋ฅผ ํธ์ถํ๋ ๋์  Android ์์คํ์ ์ฑ์ด ์ฒ์ ์ด๋ฆด ๋ `MainActivity`์ `onCreate()` ๋ฉ์๋๋ฅผ ํธ์ถ



##### ์๋ ๊ฐ์ ธ์ค๊ธฐ ์ค์ 

**File > Other Setting > Setting for New Project**

**Other Settings > Auto Import**๋ฅผ ํผ์นฉ๋๋ค. **Java** ๋ฐ **Kotlin** ์น์์์ **Add unambiguous imports on the fly** ๋ฐ **Optimize imports on the fly (for current project)**๊ฐ ์ ํ



##### ํด๋ฆญ๋ฆฌ์ค๋ ๋์ค ->ํ์ค๋ก ์์ฝํ๊ธฐ

```
Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show()
```

 <hr>
##### ์์ฝ


- `setImageResource()`๋ฅผ ์ฌ์ฉํ์ฌ `ImageView`์ ํ์๋๋ ์ด๋ฏธ์ง๋ฅผ ๋ณ๊ฒฝํฉ๋๋ค.
- `if / else` ํํ์์ด๋ `when` ํํ์๊ณผ ๊ฐ์ ์ ์ด ํ๋ฆ ๋ฌธ์ ์ฌ์ฉํ์ฌ ์ฑ์์ ๋ค์ํ ์ฌ๋ก๋ฅผ ์ฒ๋ฆฌํฉ๋๋ค(์: ์ฌ๋ฌ ์ํฉ์์ ๋ค์ํ ์ด๋ฏธ์ง ํ์).

<hr>

##### ํด์ฆ

1. Which of the following is an example of a class?

   > A Car class that has a make and model, and that can be driven
>
   > A Flower class that has a scent
>
   > A Puppy class that has breed, weight and age, and that can bark
>
   > A ShoppingCart class that has a cart size and cart value, and that can hold items
>
   > A Song class that has lyrics

2. Which of the following is a difference between a class and an instance?

   > You can think of a class as a blueprint and an instance as the actual โthing".
>
   > A class is like architectural plans for a bridge, and the Golden Gate bridge an instance of those plans.
>
   > You can create multiple instances from a class, but you can't create classes from instances.

3. For each of the following types of information, select whether it should be part of a class or an instance.

   > Information about properties shared by all "things" belonging to the class, such as number of sides, number of legs, or that it has a color.

   โ                            Class  O                 Instance                

   > The specifics about a property, such as the specific color of a โthingโ that can have a color.

   โ                            Class                   Instance O

4. True or false? Every MainActivity class in Android must have a main() function.

   > False

5. Which of the following is NOT a way for creating a comment in Kotlin?

   > Use // to turn the rest of a function into a comment.
>
   > Use /* to start a comment that is one line long.

   ์ฆ, ์ณ์ ๊ฒ์

   > Add // at the beginning of or inside a line and anything after that // is considered a comment.
>
   > Put /* or /** to start a block comment, and end it with */.

6. Which of the following statements about a conditional statement is true?

   > A conditional statement is a way for you to set up a condition and ensure that code following it is only executed if that condition is met.
>
   > A conditional statement can be used within functions to return output based on conditions defined in that function.

7. What is a good reason for you to add comments to your code?

   > To explain to yourself or others why the code is written a certain way.
>
   > To structure code, like chapter headings in books.
>
   > To point out some part of the code that is very important.
>
   > To explain to other developers how to use your code for their own programs.

8. Which of the following are Kotlin data types?

   > IntRange
>
   > Int
>
   > Boolean (true or false)

9. Which of the following are valid keywords used in conditional statements in Kotlin?

   > if, else
   >
   > when
