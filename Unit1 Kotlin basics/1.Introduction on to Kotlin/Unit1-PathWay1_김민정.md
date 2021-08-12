## 2021 Landvibe Summer Coding - Android

### 🔎 Android Basics In Kotlin

#### 📌 Unit1: Kotlin basics

#### 📌 PathWay1: Introduction to Kotlin



##### Write your first program in Kotlin

`fun`  : 함수를 의미

`main` : 가장 기본인 함수의 이름

`() `  : 인수를 넣는 부분

`{}`  : 함수 내용을 넣는 부분 

`print` & `println` : 출력을 담당

```kotlin
fun main(){
    println("=======================")
    println("Happy Birthday, Jhansi!")
    println("=======================")
}
```



##### Create a birthday message in Kotlin

`var  ` : 키워드

`//`  : 주석을 의미

+ 변수를 선언하는 방법

```kotlin
var age = 5
```

+ 출력 시에 변수 활용하는 방법

```kotlin
fun main() {
    val age=5*365 //변수 선언
    val name="Rover" //변수 선언
    
    println("Happy Birthday, ${name}!")
    println("You are already ${age} days old, ${name}!")
    println("${age} days old is the very best age to celebrate!")
}
```


`카멜표기법`  : 함수 이름을 선언할 때, '소문자+동사의 조합' + '대문자' 로 하는 것이 규칙

```kotlin
fun printBorder(){
    print("#####")
}
```

`repeat(숫자) `  : 반복구문

 ```kotlin
 fun main() {
     var border1="#" //한 개의 인수
     var border2="`-._,-'" //두 개 이상의 인수
     val timesToRepeat = 4 //반복
     printBorder(border2,timesToRepeat)
     println("  Happy Birthday, Jhansi!")
     printBorder(border2,timesToRepeat)
 }
 
 fun printBorder(border:String,time:Int){ //인자 활용
     repeat(time){
         print(border)
     }
     println("")
 }
 ```

+ 최종적인 결과물 (케이크 출력)

  ``` kotlin
  fun main(){
      var age=24
      var layers=5
      printCakeCandles(age)
      printCakeTop(age)
      printCakeBottom(age,layers)
  }
  
  fun printCakeCandles(age:Int){
      print(" ")
      repeat(age){
          print(",")
      }
      println() //빈 줄 출력
      
      print(" ")
      repeat(age){
          print("|")
      }
      println() //빈 줄 출력
  }
  fun printCakeTop(age:Int){
      repeat(age+2){
          print("=")
      }
      println()
  }
  fun printCakeBottom(age:Int, layers:Int){
      repeat(layers){
              repeat(age+2){
          		print("@")
      		}
              println() //빈 줄 출력
      }
      
  }
  ```

  

##### Quiz

1. What is a program?

   > A series of instructions that a computer system executes to accomplish some action

2. Which keyword do you use to define a function in Kotlin?

   >  `fun`

3. Which of the following do you need to create a Kotlin program that prints a line of text? (중복선택)

   > a `main()` function
   >
   > curly braces `{}` around the instructions to the system
   >
   > a call to `print()` or `println()`
   >
   > a piece of text surrounded by quotation marks

4. What do you expect this Kotlin code to do?

   > Print two lines of text

5. How would you modify this `main()` function so that it prints a 6-layer cake for someone's 4th birthday?

   > Set val age to `"4"`, set val layers to `"6"`

6. Which of these options correctly calls the function, below, and passes it valid input arguments?

   > `createMessage("Amy", "Australia", 20)`