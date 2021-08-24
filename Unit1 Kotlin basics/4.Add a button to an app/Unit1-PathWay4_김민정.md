

## 2021 Landvibe Summer Coding - Android

### 🔎 Android Basics In Kotlin

#### 📌 Unit1: Kotlin basics

#### 📌 PathWay3: Build a basic layout

<hr>

##### Classes and object instances in Kotlin



데이터 유형: `intRange`

랜덤: `random()`



##### intRange & random 활용

```kotlin
fun main() {
    val diceRange=1..6
    val randomNumber=diceRange.random()
    println("Random number: ${randomNumber}")
}
```

##### class & intRange & random 활용

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

##### 주사위 면 수 변경

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



🚨 class에서 인자 선언시에 자료형 표기해주어야 함

```kotlin
class Dice(val numSides:Int){

}
```

##### 최종정리

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
        
        //val 선언하지 않고 바로 return도 가능
        return (1..numSides).random()
    }
}
```

##### 솔루션코드

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

`Activity`:앱이 UI를 그리는 창을 제공(하나의 화면이라고 생각하면 됨)

`MainActivity.kt` 파일(**app > java > com.example.diceroller > MainActivity.kt**)로 이동하여 파일을 엽니다

`main()` 함수를 호출하는 대신 Android 시스템은 앱이 처음 열릴 때 `MainActivity`의 `onCreate()` 메서드를 호출



##### 자동 가져오기 설정

**File > Other Setting > Setting for New Project**

**Other Settings > Auto Import**를 펼칩니다. **Java** 및 **Kotlin** 섹션에서 **Add unambiguous imports on the fly** 및 **Optimize imports on the fly (for current project)**가 선택



##### 클릭리스너 두줄 ->한줄로 요약하기

```
Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show()
```

 <hr>
##### 요약


- `setImageResource()`를 사용하여 `ImageView`에 표시되는 이미지를 변경합니다.
- `if / else` 표현식이나 `when` 표현식과 같은 제어 흐름 문을 사용하여 앱에서 다양한 사례를 처리합니다(예: 여러 상황에서 다양한 이미지 표시).

<hr>

##### 퀴즈

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

   > You can think of a class as a blueprint and an instance as the actual “thing".
>
   > A class is like architectural plans for a bridge, and the Golden Gate bridge an instance of those plans.
>
   > You can create multiple instances from a class, but you can't create classes from instances.

3. For each of the following types of information, select whether it should be part of a class or an instance.

   > Information about properties shared by all "things" belonging to the class, such as number of sides, number of legs, or that it has a color.

   ​                            Class  O                 Instance                

   > The specifics about a property, such as the specific color of a “thing” that can have a color.

   ​                            Class                   Instance O

4. True or false? Every MainActivity class in Android must have a main() function.

   > False

5. Which of the following is NOT a way for creating a comment in Kotlin?

   > Use // to turn the rest of a function into a comment.
>
   > Use /* to start a comment that is one line long.

   즉, 옳은 것은

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
