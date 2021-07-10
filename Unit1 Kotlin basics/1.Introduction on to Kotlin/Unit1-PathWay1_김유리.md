# 2021 Landvibe Summer Coding - Android

## Unit1 - Kotlin Basics

## PathWay1 - Introduction to Kotlin

### Write your first program in Kotlin 

- `fun`은 kotlin의 함수를 의미하고, 함수란 특정 작업을 실행하는 프로그램의 섹션을 말한다.

- 모든 kotlin 프로그램에는 프로그램 실행 시 호출되는 첫번째(기본) 함수인 `main`함수가 필요하다.

- 함수 뒤에 붙는 두개의 괄호`()` 안에는 함수에서 사용할 정보인 인수(`args`)를 넣는다.

- 괄호 뒤에는 함수가 실행할 코드를 둘러싼 중괄호 쌍`{}`이 있다.

- `println("")` 은 괄호안 따옴표로 묶인 텍스트를 출력한다. - `println`은 줄바꿈을 포함, `print`는 미포함

  ```kotlin
  fun main() {
  	println("Happy Birthday!")
  	println("Yuri")
  	println("You are 21!")
  }
  ```

  

- 프로그램에서 오류는 빨간색으로 표시된다. 출력 창에는 오류가 발생한 위치와 원인을 파악할 수 있는 오류 메시지가 표시된다.

  

### Create a birthday message in Kotlin

- 인라인 주석은 `//`을 사용한다.

- `val`은 *키워드*라고 하며 뒤에 오는 것이 변수 이름임을 나타낸다.

- `=`는 왼쪽의 값을 오른쪽의 값과 동일하게 만든다. - 값 할당

  *`val` 키워드를 사용하여 선언된 변수는 한번만 설정할 수 있다. 프로그램 후반부에 값을 변경할 수 없다.

- print문 내에서 변수를 사용하려면 `${}`의 중괄호 안에 변수 명을 넣어 사용한다.

  ```kotlin
  fun main(){
      var age = 21 * 365
      var name = "Yuri"
  	println("Happy Birthday, ${name}!")
  	println("You are already ${age} days old")
  	println("${age} days old is the very best age to celebrate!")
  }
  ```

- 함수 이름은 소문자와 동사로 시작하며 함수가 하는 작업을 설명해야 한다. 함수 이름의 두번째 단어는 대문자로 시작한다.(카멜 표기법)

- 출력을 변경하지 않고 더 효율적으로 코드를 변경하는 것을 *리펙터링*이라고 한다.

- *루프*는 명령어를 여러번 반복하는 명령어이다. `repeat()`문은 루프의 예

- 루프는 중첩 가능하다. 

- 함수 인수 사용 

  - 함수 정의에 인수와 유형 추가 `printBorder(border:String)`
  - 함수 내에서 인수 사용 `println(border)`
  - 함수 호출 시 인수 제공 `printBorder(border)`

- 테두리가 있는 생일 배너 출력

  ```kotlin
  fun main() {
      var border="'-._,-'"
      var timesToRepeat = 4
      printBorder(border, timesToRepeat)
      println("Happy Birthday, Yuri!")
      printBorder(border, timesToRepeat)
  }
  
  fun printBorder(border: String, timesToRepeat: Int){
      repeat(timesToRepeat){
  		print(border)
      }
      println()
  }
  ```

- 층과 초를 사용하여 케이크 만들기 

  ```kotlin
  fun main(){
      var age = 21
      var layers = 5 
      printCakeTop(age)
      printCakeCandles(age)
      printCakeBottom(age, layers)
  }
  
  fun printCakeCandles(age: Int){
  	repeat(age+2) {
  		print("=")
      }
      println()
  }
  
  fun printCakeTop(age : Int){
      print(" ")
      repeat(age){
          print(",")
      }
      println()
      print(" ")
      repeat(age){
  		print("|")
      }
      println()
  }
  
  fun printCakeBottom(age : Int, layers : Int){
      repeat(layers){
  		repeat(age+2){
              print("@")
          }
          println()
      }
  }
  ```

### Quiz.

1. What is program?

   => A series of instructions that a computer system executes to accomplish some action

2. Which keyword do you use to define a function in Kotlin?

   =>`fun`

3. Which of the following do you need to create a Kotlin program that prints a line of text?

   => a `main()` function

   ​     curly braces`{}` around the instructions to the system

   ​     a call to `print()` or `println()`

   ​     a piece of text surrounded by quotation marks

4. What do you expect this Kotlin code to do?

   ```kotlin
    fun main(args: Array<String>) {
      println("Hello, world!")
      println("It's a sunny and warm day!")
    }
   ```

   => Print two lines of text

5. How would you modify this `main()` function so that it prints a 6-layers cake for someone's 4th birthday?

   ```kotlin
   fun main() {
       val age = 24
       val layers = 5
       printCakeCandles(age)
       printCakeTop(age)
       printCakeBottom(age, layers)
     }
   ```

    => Set val age to `4`, set val layers to `6`

6. Which of these options correctly calls the function, below, and passes it valid input arguments?

   ```kotlin
   fun createMessage(name: String, location: String, age: Int) {
       println("My name is ${name}. I am from ${location}, and I am ${age} years old.")
     }
   ```

   =>`createMessage("Amy", "Australia", 20)`

   