# Unit 1: Kotlin basics



## PATHWAY 1 : Introduction to Kotlin

###  프로그램과 함수, 변수

+ __프로그램__이란 시스템에서 작업을 시행하기 위한 일련의 명령. 

+ 프로그램을 실행할 때 첫번째로 호출되는 함수 __main__

  ```kotlin
  fun main() {
      println("Happy Birthday!")
      print("Happy Birthday!") // 문자열 끝에 줄바꿈을 추가하지 않고 텍스트를 출력한다
      println("") // 텍스트를 입력하지 않고 빈 줄을 출력 
  }
  ```

+ ```val``` 키워드를 사용하여 선언된 변수는 한 번만 설정할 수 있다. 프로그램 후반부에 값을 변경할 수 없다.  ```var```  키워드로 변경가능한 변수를 선언할 수 있다.

+ print 문 내에서 변수를 사용하려면 시스템에 다음에 오는 것이 텍스트가 아니라 변수임을 알려주는 기호로 변수를 둘러싸야 한다. 텍스트를 출력하는 대신 시스템은 변수 값을 출력해야 한다. 

  ```kotlin
  ${variable}
  ```

  ```kotlin
  println("You are already ${age}!")
  println("${age} is the very best age to celebrate!")
  ```





### 함수 정의

+ 함수 이름은 __소문자__와 __동사__로 시작하는 경우가 거의 대부분이며, 이름은 함수가 하는 작업을 설명해야 한다. 

+ 함수 이름의 두 번째 단어는 대문자로 시작한다. 이러한 스타일을 '__camel case__' 라고 하며, 이를 통해 이름을 훨씬 쉽게 읽을 수 있다.

+ ```printBorder``` 함수 정의  

  ```kotlin
  fun printBorder() {
      println("===================")
  }
  ```





### repeat문

+ 코드에서는 ```repeat()``` 문을 사용하여 반복적인 작업을 간편히 할 수 있다. 

  ```kotlin
  fun printBorder(){
      repeat(23) {
          print("=")
      }
      println()
  }
  ```

+ 괄호 ```()``` 안에는 반복 횟수가 온다.
+ 중괄호 ```{}``` 안에는 반복할 코드를 표시한다.





### 함수 인수 전달

```kotlin
fun main() {
    val border = "`-._,-'"
    val timesToRepeat = 4
    printBorder(border, timesToRepeat)
    println("  Happy Birthday, Jhansi!")
    printBorder(border, timesToRepeat)
}

fun printBorder(border: String, timesToRepeat: Int) {
    repeat(timesToRepeat) {
        print(border)
    }
    println()
}
```

+ 인수의 이름은 ```border``` 이다. 
+ 이름 뒤에는 콜론 ```:``` 이 온다.
+ 그 다음에 인수의 종류나 유형을 설명하는 단어 ```string``` 이 이어진다.
+ **함수 인수 사용 요약:** 함수에 인수를 사용하려면 다음 세 가지 작업을 실행해야 합니다.
  - 함수 정의에 인수와 유형을 추가합니다. ```printBorder(border: String)```
  - 함수 내에서 인수를 사용합니다. ```println(border)```
  - 함수 호출 시 인수를 제공합니다. ```printBorder(border)```



### Quiz/Unit1/pathway1

1. What is a program?

   => a series of instructions that a computer system executes to accomplish action

   => 어떤 동작을 실행하기 위해 컴퓨터 시스템이 실행하는 일련의 명령어들의 집합

   

2. Which keyword do you use to define a function in Kotlin?

   => fun

   ```kotlin
   fun printBorder() {
       println("===================")
   }
   ```

   

3. Which of the following do you need to create a Kotlin program that prints a line of text?

   =>

   + ```main()``` 함수

   + 명령어들을 둘러싸는 중괄호 ```{}```

   + ```print()``` 또는 ```println()``` 함수의 호출

   + ```" "```로 둘러싸인 출력할 text

     

4. What do you expect this Kotlin code to do?

   ```kotlin
   fun main(args: Array<String>) {
     println("Hello, world!")
     println("It's a sunny and warm day!")
   }
   ```

   => 이 함수는 두 개의 text line을 출력할 것이다. 

   ```kotlin
   // "Hello, world!"
   // "It's a sunny and warm day!"
   ```



5. How would you modify this `main()` function so that it prints a 6-layer cake for someone's 4th birthday?

   ```kotlin
   fun main() {
     val age = 24 // val age = 4로 수정해야 함
     val layers = 5 // val layers = 6로 수정해야 함
     printCakeCandles(age)
     printCakeTop(age)
     printCakeBottom(age, layers)
   }
   ```

   

6. Which of these options correctly calls the function, below, and passes it valid input arguments?

   ```kotlin
   fun createMessage(name: String, location: String, age: Int) {
     println("My name is ${name}. I am from ${location}, and I am ${age} years old.")
   }
   ```

   => 이 함수를 제대로 호출하려면, ```createMessage("Amy", "Australia", 20)``` 같이 호출해야 한다. 
