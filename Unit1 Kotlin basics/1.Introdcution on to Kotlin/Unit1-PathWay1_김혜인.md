# 2021 Landvibe Summer Coding - Android

## Unit1 : Kotlin basics

### PathWay1 : Introduction to Kotlin



##### Write your first program in Kotlin

```kotlin
fun main(){
    println("Hello, world!")
    print("Hello, world!")
    print("Hello, \n world!")
}
```

- `fun`

함수 (특정 작업을 실행하는 프로그램의 섹션)

- `main`

함수의 이름, 프로그램 실행 시 호출되는 첫 번째 기본 함수

- `()`

함수에서 사용할 정보(`args`, 인수)를 넣을 수 있다.

- `{}`

작업을 실행하는 코드

- `println()`

`"Hello, world!"` 라는 텍스트를 출력하는 명령어, 괄호안에 텍스트를 작성한다. 

텍스트는 ""(따옴표) 사이에 있다.

문자열의 끝에 줄바꿈을 추가한다.

- `print()`

문자열의 끝에 줄바꿈을 추가하지 않고 텍스트를 출력한다.

- `\n`

`\n`을 텍스트 내에 사용하면 줄바꿈이 추가된다.



###### 오류

```kotlin
fun main(){
	println(Hyein)
}
```

`Unresolved reference: Hyein` 

`Hyein`이라는 텍스트를 `""`로 묶지 않았기에 오류가 발생한다.

###### 해결

``` kotlin
fun main(){
    println("Hyein")
}
```





##### Create a birthday message in Kotlin

- `//`

인라인 주석, `//` 뒤에 텍스트를 입력하여 주석을 작성한다.



```kotlin
val age = 5
println("You are already ${age}!")
```

- `val`

변수, 뒤에 오는 것이 변수 이름을 나타낸다.

값 변경 불가능.

- `age`

변수 이름

- `=`

왼쪽의 변수에 오른쪽의 값을 할당

- `&()`

print문에서 변수를 사용하기 위해서 `&{}`로 변수를 둘러싸, 변수임을 알려줘야 한다.



```kotlin
fun printBorder(border: String, timesToRepeat: Int) {
    repeat(timesToRepeat) {
        print(border)
    }
    println()
}
```

- `repeat()`

루프문, 괄호에 반복횟수를 작성한다.

- `border: String`

`border`는 인수 이름이고 그 뒤의 `:`, 그 후 인수의 종류를 나타내는 `String`이 나온다.

즉 `String`타입의 인수

- `timesToRepeat: Int`

`Int`타입의 인수



##### Quiz

1. What is a program?

   A series of instructions that a computer system executes to accomplish some action

2. Which keyword do you use to define a function in Kotlin?
   `fun`

3. Which of the following do you need to create a Kotlin program that prints a line of text?

   적절한 답변을 모두 선택합니다

   a `main()` function

   curly braces `{}` around the instructions to the system

   a call to `print()` or `println()`

   a piece of text surrounded by quotation marks

4. What do you expect this Kotlin code to do?

   ```kotlin
   fun main(args: Array<String>) {
     println("Hello, world!")
     println("It's a sunny and warm day!")
   }
   ```

   Print two lines of text

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

   Set val age to `4`, set val layers to `6`

6. Which of these options correctly calls the function, below, and passes it valid input arguments?

   ```kotlin
   fun createMessage(name: String, location: String, age: Int) {
     println("My name is ${name}. I am from ${location}, and I am ${age} years old.")
   }
   ```

   `createMessage("Amy", "Australia", 20)`

   