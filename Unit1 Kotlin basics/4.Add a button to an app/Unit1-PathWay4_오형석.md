### Unit 1: Kotlin basics

#### PATHWAY 4:Add a button to an app

<hr/>

##### IntRange

- 시작점부터 끝점까지 정수의 범위를 나타내는 Int와 String 같은 데이터유형
- ```val z= x..y``` (x,y는 정수) 형식

##### 랜덤 주사위 값을 출력하는 코드

```kotlin
fun main() {
    val diceRange = 1..6
    val randomNumber = diceRange.random()
    println("Random number: ${randomNumber}")
}
```

- ```diceRange.random()```은```(1..6).random()```로 바꿔도 됨.(함수를 직접 호출해도 됨)

##### class

```kotlin
fun main() {
    val myFirstDice = Dice()
    println(myFirstDice.sides)
}

class Dice {
    var sides = 6
}
```

- 규칙에 따라 클래스 이름은 카멜 표기법을 사용
- 점 표기법을 사용해 클래스의 속성에 엑세스할 수 있음.
- 클래스 이름 뒤에 있는 괄호는 클래스에서 새 객체 인스턴스를 만들고 있음을 나타냄.

##### 함수 반환 유형 지정

```kotlin
fun roll(): Int {
     val randomNumber = (1..6).random()
     return randomNumber
}
```

- 함수 이름, 괄호, 콜론 ,함수 반환 유형 키워드 순으로 작성.

#### Layout Editor

##### ViewGroup

ConstrintLayout은 ViewGroup의 유형.

ViewGroup 내에 Views가 있으면 Views는 상위 ViewGroup의 하위 요소로 간주.

Button이 ConstraintLayout내에 있으면 세로 및 가로 제약 조건을 설정하여 배치해야함

##### Attributes

도구 아이콘이 있는 text 속성은 개발자믄을 위한 '도구 텍스트'속성.

'1'로 설정하면 Android 스튜디오 내 Design Editor에만 표시되고 실제 기기에서 실행할 땐 표시안됨.

#### Activity

앱이 UI를 그리는 창을 제공. 일반적으로 Activity는 실행되는 앱의 전체화면을 차지.

앱에는 활동이 하나 이상 있는데 최상위 활동을 MainActivity라고 하고 프로젝트 템플릿에서 제공

Android 앱은 ```main()```함수를 호출하는 대신 Android 시스템은 앱이 처음 열릴때 ```MainActivity ```의 ```onCreate()``` 메서드를 호출

Android는 자동으로 앱의 리소스에 ID번호를 할당. 리소스 ID의 형식은  R.<type>.<name> ex)R.string.roll

```kotlin
val rollButton: Button = findViewById(R.id.button)
```

R.id.button은 Button의 리소스로, Button의 고유한 식별자이다. 이 코드는 Button객체 자체가 아니라 rollButton이라는 변수에 Button 객체 참조를 저장.



객체를 변수에 할당할 때 Kotlin은 매번 전체 객체를 복사하지 않고  객체 참조를 저장.

클릭 리스너는 탭 또는 클릭이 발생할 때 실행할 작업을 위한 코드.

Toast: 사용자에게 표시되는 간략한 메세지

```kotlin
rollButton.setOnClickListener {
           val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
           toast.show()
```

##### if문

if문은 c++형식과 똑같음

조건문으로 실행을 안내하는 방식을 프로그램의 '제어 흐름'이라고 함.

##### when문

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
        5 -> println("Don't cry! You rolled a 5. Try again!")
        6 -> println("Apologies! you rolled a 6. Try again!")
    }
}
```

다른 언어의 switch문 처럼 작동함.



```kotlin
when (diceRoll) {
    1 -> diceImage.setImageResource(R.drawable.dice_1)
    2 -> diceImage.setImageResource(R.drawable.dice_2)
    3 -> diceImage.setImageResource(R.drawable.dice_3)
    4 -> diceImage.setImageResource(R.drawable.dice_4)
    5 -> diceImage.setImageResource(R.drawable.dice_5)
    6 -> diceImage.setImageResource(R.drawable.dice_6)
}
```



```kotlin
val drawableResource = when (diceRoll) {
   1 -> R.drawable.dice_1
   2 -> R.drawable.dice_2
   3 -> R.drawable.dice_3
   4 -> R.drawable.dice_4
   5 -> R.drawable.dice_5
   else -> R.drawable.dice_6
}

diceImage.setImageResource(drawableResource)
```

```when``` 표현식이 실제로 값을 반환할 수 있다.  이 새로운 코드 스니펫으로 ```when```표현식은 리소스 ID를 반환하고 이 ID는``` drawableResource``` 변수에 저장된다. 그러면 이 변수를 사용하여 표시된 이미지 리소스를 업데이트 할 수 있다. 이때 ```when``` 표현식의 값이 ```drawableResource```에 할당되기 때문에 ```when```은 완전해야 한다. 그러므로 6부터는 ```else```로 처리한다.



##### ImageView에서 적절한 콘텐츠 설명 설정

굴려진 숫자를 이미지로 바꿨으므로 스크린 리더가 굴려진 숫자를 알 수 없다. 이를 해결하기 위해 이미지 리소스를 업데이트한 후 ```ImageView```의 콘텐츠 설명을 업데이트 해야하는데 콘텐츠 설명은 스크린 리더가 설명할 수 있도록 ```ImageView```에 표시되는 설명이어야한다.

```kotlin
diceImage.contentDescription = diceRoll.toString()
```

<hr/>

#### Quiz 

#### 1.Which of the following is an example of a class?

- A Car class that has a make and model, and that can be driven

- A Puppy class that has breed, weight and age, and that can bark
- A ShoppingCart class that has a cart size and cart value, and that can hold items
- A Song class that has lyrics
- A Flower class that has a scent

#### 2. Which of the following is a difference between a class and an instance?

- You can think of a class as a blueprint and an instance as the actual “thing".

- A class is like architectural plans for a bridge, and the Golden Gate bridge an instance of those plans.

- You can create multiple instances from a class, but you can't create classes from instances.

#### 3. For each of the following types of information, select whether it should be part of a class or an instance.

- Information about properties shared by all "things" belonging to the class, such as number of sides, number of legs, or that it has a color : Class
- The specifics about a property, such as the specific color of a “thing” that can have a color: Instance

#### 4.True or false? Every MainActivity class in Android must have a main() function.

- False 

#### 5. Which of the following is NOT a way for creating a comment in Kotlin?

-  Use // to turn the rest of a function into a comment.

-  Use /* to start a comment that is one line long.

#### 6.Which of the following statements about a conditional statement is true?

- A conditional statement is a way for you to set up a condition and ensure that code following it is only executed if that condition is met.
- A conditional statement can be used within functions to return output based on conditions defined in that function.

#### 7.What is a good reason for you to add comments to your code?

- To explain to yourself or others why the code is written a certain way.
- To structure code, like chapter headings in books.
- To point out some part of the code that is very important.
- To explain to other developers how to use your code for their own programs.

#### 8.Which of the following are Kotlin data types?

- IntRange
- Int
- Boolean (true or false)

#### 9.Which of the following are valid keywords used in conditional statements in Kotlin?

- if, else
- when















