# 💡 Android Basics in Kotlin

## Unit #1 : Kotlin basics

## PATHWAY #1 : Introduction to Kotlin



#### 📌 코틀린 코드 살펴보기

- `fun` : 함수를 의미하는 키워드

- `main` : 이 함수의 이름으로 기본 함수라는 의미. 모든 코틀린 프로그램에는 메인 함수가 필요하다. 

- `()` : 함수 이름 뒤에는 항상 두개의 괄호가 온다. 괄호 안에는 함수에서 사용할 정보를 넣을 수 있다. 이 정보를 `인수`또는 `args`라고 한다.

- `{}` : 괄호 뒤에는 중괄호 쌍이 있다. 중괄호는 코드를 둘러싸고 있다.

- `println( )` :  출력 후 줄바꿈

- `print( )` : 출력 후 줄바꿈 안 함.

- `\n` : 텍스트 내에 사용하면 줄바꿈이 추가된다. 혹은 `println("")` , `println()`

- `val` : 키워드라고 하며, val로 지정된 불변 타입 변수는 초기에 값을 할당되면 나중에 **값을 변경할 수 없으며** 값을 변경하게 되면 컴파일 에러가 발생. 

- `var` : var로 지정된 가변 타입 변수는 **초기화 후 값 변경 가능**. 다른 타입의 값을 넣을 수는 없다.

- `//` : 주석처리

- `${변수이름}` : print 문 내에서 변수를 사용하려면 변수임을 알려주는 기호로 변수를 둘러싸야 한다.  

- `repeat()` : 반복문으로, 괄호 () 안에는 반복 횟수가 있다. 뒤이어 중괄호 {}가 나오며 그 안에 반복할 코드가 표시된다.

- `함수이름(변수명 : 자료형)` : 함수 **정의**에 인수와 유형을 추가. 함수 뒤에 오는 소괄호에 들어간다. 함수의 정의의 인수의 수와 함수를 호출할 때의 인수의 수가 같아야 오류 발생 X. 

- `함수이름(변수명)` : 함수 **호출** 시 인수 제공

  

👉 예시코드

```kotlin
fun main() {
  println("Hi there")
  print(1)
  print("하나\n")
  print(2)
  
  // Happy Birthday!
  // Hi there
  // 1하나
  // 2
  
	val name = "Jenny"
  val age = 10
  val border = "="
  val timesToRepeat = 4
  printBorder(border, timesToRepeat)
  println("${name} is ${age} years old") 
  printBorder(border, timesToRepeat)
  
  // ======================
  // Jenny is 10 years old
  // ======================
}

fun printBorder(border : String, timesToRepeat : Int) {
 		repeat(timesToRepeat) {
    	print(border)
    }
  	println()
}

// 중첩 repeat문 사용 -> @가 12번 출력되는 줄이 10번 출력됨
fun printCakeBottom(age: Int, layers: Int) {
    repeat(age) { 
        repeat(age + 2) {
            print("@")
        }
        println()
    }
}
```



#### 📌 퀴즈

1. What is a program?

   > A series of instructions that a computer system executes to accomplish some action

   

2. Which keyword do you use to define a function in Kotlin?

   > fun

   

3. Which of the following do you need to create a Kotlin program that prints a line of text?

   > a `main()` function
   >
   > curly braces `{}` around the instructions to the system
   >
   > a call to `print()` or `println()`
   >
   > a piece of text surrounded by quotation marks

   

4. What do you expect this Kotlin code to do?

   ![](/Users/jumin/Desktop/스크린샷 2021-07-06 오후 3.45.59.png)

   > Print two lines of text

   

5. How would you modify this `main()` function so that it prints a 6-layer cake for someone's 4th birthday?

   ![image-20210706154714327](/Users/jumin/Library/Application Support/typora-user-images/image-20210706154714327.png)

   > Set val age to `4`, set val layers to `6`

   

6. Which of these options correctly calls the function, below, and passes it valid input arguments?

   ![스크린샷 2021-07-06 오후 3.47.43](/Users/jumin/Desktop/스크린샷 2021-07-06 오후 3.47.43.png)

   > createMessage("Amy", "Australia", 20)

   
   
   <img src="/Users/jumin/Desktop/스크린샷 2021-07-05 오후 4.00.30.png" alt="스크린샷 2021-07-05 오후 4.00.30" style="zoom:40%;" />

#### 📌 참고

👉 [브라우저 내의 대화형 코틀린 편집기](https://developer.android.com/training/kotlinplayground) 

👉 [코틀린에서 사용되는 안드로이드 기초 용어]( https://developer.android.com/courses/android-basics-kotlin/android-basics-kotlin-vocab)

