# 💡 Android Basics in Kotlin

## Unit #1 : Kotlin basics

## PATHWAY #4 : Add a button to an app

<br/>

<br/>



## 1️⃣ 코틀린 클래스 및 객체 인스턴스

### 📌 랜덤 숫자

* `IntRange` : 시작점부터 끝점까지 **정수**의 범위를 나타냄. 주사위 굴리기에서 생성할 수 있는 가능한 값을 나타내는 적절한 데이터 유형 ex) 3..46, 0..270, -6..+6, -10..-4
* `random()` : 랜덤 함수로, 주어진 범위의 랜덤 숫자 생성하고 반환 

```kotlin
fun main() {
    val diceRange = 1..6
    val randomNumber = diceRange.random()
    // 범위에서 함수 직접 호출 가능 val randomNumber = (1..6).random()
  
    println("Random number: ${randomNumber}")
}
```

​	코드 실행할 때마다 매번 다른 랜덤 숫자로 출력됨.

<br/>



### 📌 Dice 클래스 만들기

```kotlin
fun main() {
  	// 객체 인스턴스 생성
    val myFirstDice = Dice() 
  
  	// 점 표기법으로 속성에 엑세스
    println(myFirstDice.sides)

  	// roll() 메서드 호출하여 랜덤 숫자 생성
  	myFirstDice.roll()
  	
}

class Dice {
   	var sides = 6
  	
  	// 주사위 굴리는 함수
  	fun roll() {
      val randomNumber = (1..6).random()
      println(randomNumber)
    }
}
```

<br/>



### 📌 주사위 클래스 변경

* 함수반환 : fun 함수명() : 데이터 유형 { return 무언가 }

* 주사위 면 수 변경 

```kotlin
class Dice {
   	var sides = 6
  	
  	// Int를 반환하도록 함수 정의 변경
  	fun roll() : Int {
      val randomNumber = (1..sides).random()
      return randomNumber
      // return문 사용해서 반환해주어야함
    }
}

fun main() {
    val myFirstDice = Dice() 
  	val diceRoll = myFirstDice.roll()
  	println("Your ${myFirstDice.sides} sided dice rolled ${diceRoll}!")
  	
  	// 속성 변경 (면 수 변경)
  	myFirstDice.sides = 20 
 	  println("Your ${myFirstDice.sides} sided dice rolled ${myFirstDice.roll}!")
}
```

<br/>



### 📌 새 인스턴스 만들 때 속성 지정하기

인스턴스를 만들 때 값을 클래스에 제공 가능

```kotlin
fun main() {
  	// 첫 번째 주사위 객체
    val myFirstDice = Dice(6)
    val diceRoll = myFirstDice.roll()
    println("Your ${myFirstDice.numSides} sided dice rolled ${diceRoll}!")
	
  	// 두 번째 주사위 객체
    val mySecondDice = Dice(20)
    println("Your ${mySecondDice.numSides} sided dice rolled ${mySecondDice.roll()}!")
}


// numSides라는 정수를 허용
class Dice (val numSides: Int) {

    fun roll(): Int {
        val randomNumber = (1..numSides).random()
        return randomNumber
      	// 그냥 return (1..numSides).random()도 가능
    }
}

```

<br/>

------

<br/>

## 2️⃣ 상호작용 Dice Roller 앱 만들기

### 📌 앱 설정

1. empty activity 프로젝트 만들기
2. layout editor 열기
3. Palette에서 `Button` 추가
4. Button 여백 설정 후 text 수정
5. `TextView` 글자 사이즈 수정 후 text에 내용 없애고, 도구 아이콘이 있는 text에 문자 추가(앱 실행 시에는 보이지 않는다.)

<br/>



### 📌 Activity

* `Activity` : 앱이 UI를 그리는 창을 제공하며, 일반적으로 실행되는 앱의 전체 화면을 차지한다. 최상위 수준 또는 첫 번째 활동을 `MainActivity`라고 한다.
  * 예를 들어 사진 갤러리 앱에는 사진 그리드를 표시하는 `Activity`, 개별 사진을 보는 두 번째 `Activity`, 개별 사진을 편집하는 세 번째 `Activity`가 있을 수 있다.
* `MainActivity.kt` (app > java > com.example.diceroller > MainActivity.kt)를 연다.
  * class MainActivity에는 메인함수가 없다. 안드로이드 앱에서는 메인함수를 호출하는 대신, 앱이 처음 열릴 때 MainActivity의 `onCreate()` 메서드를 호출한다.
  * onCreate()에서는 `setContentView()`로 시작 레이아웃을 설정하여 MainActivity를 설정한다.
* `import`문을 사용하여 코드에서 사용할 프레임워크의 클래스 지정가능.
  * 예를 들어 Button 클래스는 androi.widget.Button에 정의되어 있다.
* **자동 가져오기 사용 설정**
  *  File > New Project Settings > Preferences for New Projects
  * Other Settings > Auto Import > Java, Kotlin
  * **Add unambiguous imports** 설정 : Android 스튜디오에 사용할 문을 결정할 수 있는 한 import 문을 자동으로 추가하라고 지시 
  * **Optimize imports on the fly(for current project)** 설정 : Android 스튜디오에 코드에서 사용되지 않는 가져오기를 삭제하라고 지시

<br/>



### 📌 Button을 상호작용적으로 만들기

##### Button 클릭할 때 메시지 표시

* `onCreate()`메서드에 추가하여 버튼을 클릭할 때 간단한 메시지가 화면 하단에 표시하도록 지정

* 코드가 실행될 수 있도록 코드를 Button과 연결
  * 클릭 리스너 : 탭 또는 클릭이 발생할 때 실행할 작업을 위한 코드이다. 여기서 `rollButton` 객체 사용, `setOnClickListener()`메서드 호출하여 설정
  * `Toast` : 사용자에게 표시되는 간략한 메시지. Toast.makeText()호출, show()메서드 호출

```kotlin
class MainActivity : AppCompatActivity() {

   override fun onCreate(savedInstanceState: Bundle?) {
       super.onCreate(savedInstanceState)
       setContentView(R.layout.activity_main)
     
			 // 추가된 곳, 이후 안드로이드 스튜디오는 자동적으로 import문 추가
       val rollButton: Button = findViewById(R.id.button)
       rollButton.setOnClickListener { //클릭 리스너 설정
           val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT) // "Dice Rolled!"텍스트로 토스트 생성
           toast.show() //Toast에 자체를 표시하라고 지시
       }
   }
}
```

* 변수 없이 클릭 리스너의 두 줄을 한 줄로 결합 가능 

```kotlin
Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show()
```

<br/>



##### Button 클릭할 때 화면의 TextView 업데이트

1. layout editor에서 TextView클릭 후 id기억
2. `MainActivity.kt`(app > java > com.example.diceroller > MainActivity.kt)

```kotlin
class MainActivity : AppCompatActivity() {

   override fun onCreate(savedInstanceState: Bundle?) {
       super.onCreate(savedInstanceState)
       setContentView(R.layout.activity_main)

       val rollButton: Button = findViewById(R.id.button)
       rollButton.setOnClickListener { 
         	 // 수정된 곳
         	 // 새로운 변수 만들고 TextView 저장. 
           val resultTextView: TextView = findViewById(R.id.textView) //레이아웃에서 ID로 textView찾고 그 참조 저장
           resultTextView.text = "6" //텍스트 설정
       }
   }
}
```

<br/>



### 📌 주사위 굴리기 로직 추가

##### Dice 클래스 추가

* MainActivity 클래스의 마지막 중괄호 뒤에 추가
* 클릭 리스너의 코드를 rollDice()로 수정
* 이후 rollDice()함수 클릭하고 `Option+Enter`눌러 메뉴에서 함수 정의 버튼 클릭

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



## 3️⃣ 조건부 동작 추가

### 📌 코드 내에서 의사 결정

* `if`문 : if ( 조건은 true 혹은 false ) { 코드 } 
* `else if`문 : 대체 조건 추가
* `else`문 : 조건 충족되지 않을 때 대안 제공
* `when`문 : when ( 테스트할 값 ) { 코드 }

<br/>



### 📌 행운의 숫자가 있는 주사위

* 메인에 `luckyNumber`변수 추가 후 4로 설정

```kotlin
fun main() {
    val myFirstDice = Dice(6)
    val rollResult = myFirstDice.roll()
    val luckyNumber = 4
		
  	// if, else if, else 사용
    if (rollResult == luckyNumber) {
        println("You win!")
    } else if (rollResult == 1) {
        println("So sorry! You rolled a 1. Try again!")
    } else {
        println("Apologies! Try again!")
    }
  
    //when 사용
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



## 4️⃣ 이미지 추가

* TextView를 `ImageView`로 바꾼 후 임시 이미지 추가하고 제약조건 설정

* 이미지 다운로드 후 Resource Manager 탭에서 import drawable 설정

* `MainActivity.kt`(app > java > com.example.diceroller > MainActivity.kt)열고 코드수정

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

* ImageView에 적절한 콘텐츠 설명 설정

  ```kotlin
  diceImage.contentDescription = diceRoll.toString()
  ```

  <br/>

  

  <br/>

  

------

### 📌 퀴즈

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

> You can think of a class as a blueprint and an instance as the actual “thing".
>
> A class is like architectural plans for a bridge, and the Golden Gate bridge an instance of those plans.
>
> You can create multiple instances from a class, but you can't create classes from instances.

<br/>



**3-1. Information about properties shared by all "things" belonging to the class, such as number of sides, number of legs, or that it has a color.**

> Class

<br/>



**3-2. The specifics about a property, such as the specific color of a “thing” that can have a color.**

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