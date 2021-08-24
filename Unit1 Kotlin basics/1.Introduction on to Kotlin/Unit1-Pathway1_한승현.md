# Unit1-Pathway1

- 함수
    - fun fun_name() {} : fun_name은 함수명, 소괄호() 안에는 인자(args), 중괄호 안에는 작업을 실행하는 코드가 들어있음
    - println()은 괄호 안의 String을 출력하며, 출력을 마친 후 개행까지 println()의 기능임
    - repeat() {} : 소괄호() 안에는 반복 횟수, 중괄호 안에는 반복할 작업을 실행하는 코드가 들어있음
    - 함수의 인자를 넣는 소괄호 안에는 (함수에서 사용할 인자의 이름: 인자의 자료형) 의 형식으로 표현함
    ex) (string: String) / (num: Int)
    - 
- 변수
    - val: value의 줄임말로 값을 한 번만 할당할 수 있음, 즉 나중에 다른 값을 할당할 수 없음
    - var: variable의 줄임말로 값을 여러 번 할당할 수 있음
    - print문 안에서 변수를 포함한 문자열을 출력하고 싶을 때는 ${변수명}으로 문자열 안에 변수의 값을 포함시킬 수 있음
- naming convention
    - 함수 이름은 보통 소문자와 동사로 시작하는 것이 일반적이며 2어절 이상의 복합어일 경우 두 번째 이후 어절부터는 첫 글자만 대문자로 표기하는 Camel Case를 사용함

### **퀴즈**

1. What is a program?

    → A series of instructions that a computer system executes to accomplish some action

2. Which keyword do you use to define a function in Kotlin?

    → fun

3. Which of the following do you need to create a Kotlin program that prints a line of text?

    → a main() function

    → curly brances {} around the instructions to the system

    → a call to print() and println()

    → a piece of text surrounded by quotation marks

4. What do you expect this Kotlin code to do?

    ```kotlin
    fun main(args: Array<String>) {
      println("Hello, world!")
      println("It's a sunny and warm day!")
    }
    ```

    → Print two lines of text

5. How would you modify this main() function so that it prints a 6-layer cake for someones's 4th birthday?

    ```kotlin
    fun main() {
      val age = 24
      val layers = 5
      printCakeCandles(age)
      printCakeTop(age)
      printCakeBottom(age, layers)
    }
    ```

    → Set val age to 4, set val layers to 6

6. Which of these options correctly calls the function, below, and passes it valid input arguments?

    ```kotlin
    fun createMessage(name: String, location: String, age: Int) {
      println("My name is ${name}. I am from ${location}, and I am ${age} years old.")
    }
    ```

    → createMessage("Amy", "Austrailia", 20)