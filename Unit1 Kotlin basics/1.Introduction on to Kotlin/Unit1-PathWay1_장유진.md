# 2021 Landvibe Summer Coding - Android



## Unit1 : Kotlin basics

## PathWay1 : Introduction to Kotlin



### Write your first program in Kotlin

- <span style="color:red">`fun`</span>는 함수를 의미하며, 함수란 특정 작업을 실행하는 프로그램의 섹션을 말한다.

- 모든 Kotlin 프로그렘에는 다음과 같이<span style="color:red"> `main()`</span> 함수가 있어야 한다.  `fun main() {}`

- `println()` 함수를 사용하여 텍스트를 출력한다.

- 출력할 텍스트를 큰따옴표 사이에 입력한다. ex) `"Hello"`

- `println()` 명령을 반복하여 여러 줄의 텍스트를 인쇄한다.

- 예시 코드

  ```kotlin
  fun main() {
      println("Happy Birthday!")
      println("Yoojin")
      println("You are 22!")
  }
  ```

  

### Create a birthday message in Kotlin

- <span style="color:red">`${}`</span>를 사용하여 print 문 텍스트의 변수와 계산 값을 둘러싼다. ex) `${age}`에서 age가 변수이다.

- <span style="color:red">`val`</span>키워드와 이름을 사용하여 변수를 반든다.

- `String`은 `"Hello"`와 같이 따옴표로 묶인 텍스트이다. <span style="color:blue">--> C++과 동일</span>

- `Int`는 양의 정수 또는 음의 정수이다. <span style="color:blue">--> C++과 동일</span>

- 함수에서 사용할 인수 한 개 이상을 함수에 전달할 수 있다. 

  ex) `fun printCakeBottom(age : Int, layers : Int) {}`

- <span style="color:red">`repeat() {}`</span>문을 사용하여 일련의 명령어를 반복한다.  --> C++에서 for문과 while문의 역할을 함.

  ex) `repeat(23) {print ("%") }` 또는 `repeat(layers) {print ("@@@@@@") }`가 있다.

- 루프는 명령어를 여러 번 반복하는 명령어이다. `repeat()`문은 루프의 예이다.

- 루프를 중첩할 수 있다.

- 함수 인수 사용 요약

  - 함수 정의에 인수와 유형을 추가한다. `printBorder(border : String)`
  - 함수 내에서 인수를 사용한다. `println(border)`
  - 함수 호출 시 인수를 제공한다. `printBorder(border)`

- 예시 코드

  ```kotlin
  fun main(){
      val age = 22
      val name = "yoojin"
      val border = "`-._,-'"
      val timesToRepeat = 4
      val layers = 5
      printBorder(border, timesToRepeat)
      println("  Happy Birthday, ${name}!")
  	printBorder(border, timesToRepeat)
      
      printCakeCandles(age)
      printCakeTop(age)
      printCakeBottom(age, layers)
      println()
      
      println("You are already ${age}!")
      println("${age} is the very best age to celebrate!")
  }
  
  fun printBorder(border : String, timesToRepeat : Int){
     repeat(timesToRepeat){
         print(border)
     }
     println()
  }
  
  fun printCakeTop(age : Int) {
      repeat(age + 2) {
          print("=")
      }
      println()
  }
  
  fun printCakeCandles(age : Int){
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
  
  fun printCakeBottom(age : Int, layer : Int){
      repeat(layer){
          repeat(age + 2){
          	print("@")
          }
          println()
      }
  }
  ```

  

### Quiz

1.  **What is a program?**

   --> A series of instructions that a computer system executes to accomplish some action

2. **Which keyword do you use to define a function in Kotlin?**

   --> `fun`

3. **Which of the following do you need to create a Kotlin program that prints a line of text?**

   --> a `main()` function

   --> curly braces `{}` around the instructions to the system

   --> a call to `print()` or `println()`

   --> a piece of text surrounded by quotation marks

4. **What do you expect this Kotlin code to do?**

   ```kotlin
   fun main(args: Array<String>) {
     println("Hello, world!")
     println("It's a sunny and warm day!")
   }
   ```

   --> Print two lines of text

5.  **How would you modify this `main()` function so that it prints a 6-layer cake for someone's 4th birthday?**

   ```kotlin
   fun main() {
     val age = 24
     val layers = 5
     printCakeCandles(age)
     printCakeTop(age)
     printCakeBottom(age, layers)
   }
   ```

   --> Set val age to `4`, set val layers to `6`

6. **Which of these options correctly calls the function, below, and passes it valid input arguments?**

   ```kotlin
   fun createMessage(name: String, location: String, age: Int) {
     println("My name is ${name}. I am from ${location}, and I am ${age} years old.")
   }
   ```

   --> `createMessage("Amy", "Australia", 20)`