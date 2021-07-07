### Unit 1: Kotlin basics

#### PATHWAY 1: Introduction to Kotlin

<hr/>

##### Write your first program in Kotlin

<hr/>

##### 출력

```kotlin
fun main() {
    println("Happy Birthday!")
    println("Jhansi")
    println("You are 25!")
}
```

- ```fun```은 Kotlin에서 함수를 나타내는 키워드
- Kotlin 프로그램에는 ```fun main() {}```가 존재
- 출력은 ```print()```, ```println()```을 사용 (개행 차이)  /printf  없음(자바와 차이)

##### Create a birthday message in Kotlin

<hr/>



##### 주석

```kotlin
//This is a comment line
```

- Kotlin에서 주석은 ```//```을 이용



##### 변수

```kotlin
val age = 5
```

```kotlin
val name = "Rover"
```

- ```val``` 는 변수를 선언하는 키워드.  val키워드를 사용하여 선언된 변수는 한 번만 설정가능해 프로그램 후반부에 값을 변경할 수 없으나 var키워드로 변경 가능한 변수 선언 가능.
- 변수에 숫자뿐 아니라 텍스트도 넣을 수 있음.

```kotlin
println("You are already ${age}!")
println("Happy Birthday, ${name}!")
```

- print 문 내에서 변수 사용시 변수임을 알려줄 수 있도록 ```${}```사용



##### 함수

```kotlin
fun main() {
    printBorder()
    println("Happy Birthday, Jhansi!")
    printBorder()
}

fun printBorder() {
    println("=======================")
}
```

- ```fun```키워드 뒤에는 함수 이름 ,  선택적 함수 입력(인수)을 위한 괄호 그리고 중괄호가 이어짐.
- 카멜 표기법: 함수의 두 번째 단어는 대문자로 시작. ex)drawReallyCoolFancyBorder

##### 반복

```kotlin
fun printBorder() {
    repeat(23) {
        print("=")
    }
}
```

- `repeat()` 문은 `repeat` 단어로 시작하고 뒤이어 `()`가 오고 이후에 ```{}```가 온다.  ```()```안에는 반복 횟수가 있고 ```{}```안에는 반복할 코드가 있다.
- 이러한 종류의 문을 루프라고함.

##### 함수에 인수 사용

```kotlin
fun printBorder(border: String) {
    repeat(23) {
        print("%")
    }
    println()
}
```

- 인수의 이름, 콜론, 인수의 종류나 유형을 설명하는 단를 순서대로 입력
- 인수를 사용하면 함수를 더 유연하게 만들 수 있음.

##### 중첩 루프

```kotlin
fun printCakeBottom(age: Int, layers: Int) {
    repeat(layers) {
        repeat(age + 2) {
            print("@")
        }
        println()
    }
```

- `repeat()` 문 내에 `repeat()` 문을 만들어 중첩 루프가능



##### Quiz

<hr/>

1. What is a program?

- A series of instructions that a computer system executes to accomplish some action

2. Which keyword do you use to define a function in Kotlin?

- ```fun```

3. Which of the following do you need to create a Kotlin program that prints a line of text?

- a `main()` function
- curly braces `{}` around the instructions to the system
- a call to `print()` or `println()`
- a piece of text surrounded by quotation marks

4. What do you expect this Kotlin code to do?

   ```kotlin
   fun main(args: Array<String>) {
     println("Hello, world!")
     println("It's a sunny and warm day!")
   }
   ```

- Print two lines of text

5. How would you modify this `main()` function so that it prints a 6-layer cake for someone's 4th birthday?

   ```kotlin
   fun main() {
     val age = 24
     val layers = 5
     printCakeCandles(age)
     printCakeTop(age)
     printCakeBottom(age, layers)
   }
   ```

- Set val age to `4`, set val layers to `6`

6. Which of these options correctly calls the function, below, and passes it valid input arguments?

   ```kotlin
   fun createMessage(name: String, location: String, age: Int) {
     println("My name is ${name}. I am from ${location}, and I am ${age} years old.")
   }
   ```

- `createMessage("Amy", "Australia", 20)`



