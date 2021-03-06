# π‘ Android Basics in Kotlin

## Unit #1 : Kotlin basics

## PATHWAY #1 : Introduction to Kotlin



#### π μ½νλ¦° μ½λ μ΄ν΄λ³΄κΈ°

- `fun` : ν¨μλ₯Ό μλ―Ένλ ν€μλ

- `main` : μ΄ ν¨μμ μ΄λ¦μΌλ‘ κΈ°λ³Έ ν¨μλΌλ μλ―Έ. λͺ¨λ  μ½νλ¦° νλ‘κ·Έλ¨μλ λ©μΈ ν¨μκ° νμνλ€. 

- `()` : ν¨μ μ΄λ¦ λ€μλ ν­μ λκ°μ κ΄νΈκ° μ¨λ€. κ΄νΈ μμλ ν¨μμμ μ¬μ©ν  μ λ³΄λ₯Ό λ£μ μ μλ€. μ΄ μ λ³΄λ₯Ό `μΈμ`λλ `args`λΌκ³  νλ€.

- `{}` : κ΄νΈ λ€μλ μ€κ΄νΈ μμ΄ μλ€. μ€κ΄νΈλ μ½λλ₯Ό λλ¬μΈκ³  μλ€.

- `println( )` :  μΆλ ₯ ν μ€λ°κΏ

- `print( )` : μΆλ ₯ ν μ€λ°κΏ μ ν¨.

- `\n` : νμ€νΈ λ΄μ μ¬μ©νλ©΄ μ€λ°κΏμ΄ μΆκ°λλ€. νΉμ `println("")` , `println()`

- `val` : ν€μλλΌκ³  νλ©°, valλ‘ μ§μ λ λΆλ³ νμ λ³μλ μ΄κΈ°μ κ°μ ν λΉλλ©΄ λμ€μ **κ°μ λ³κ²½ν  μ μμΌλ©°** κ°μ λ³κ²½νκ² λλ©΄ μ»΄νμΌ μλ¬κ° λ°μ. 

- `var` : varλ‘ μ§μ λ κ°λ³ νμ λ³μλ **μ΄κΈ°ν ν κ° λ³κ²½ κ°λ₯**. λ€λ₯Έ νμμ κ°μ λ£μ μλ μλ€.

- `//` : μ£Όμμ²λ¦¬

- `${λ³μμ΄λ¦}` : print λ¬Έ λ΄μμ λ³μλ₯Ό μ¬μ©νλ €λ©΄ λ³μμμ μλ €μ£Όλ κΈ°νΈλ‘ λ³μλ₯Ό λλ¬μΈμΌ νλ€.  

- `repeat()` : λ°λ³΅λ¬ΈμΌλ‘, κ΄νΈ () μμλ λ°λ³΅ νμκ° μλ€. λ€μ΄μ΄ μ€κ΄νΈ {}κ° λμ€λ©° κ·Έ μμ λ°λ³΅ν  μ½λκ° νμλλ€.

- `ν¨μμ΄λ¦(λ³μλͺ : μλ£ν)` : ν¨μ **μ μ**μ μΈμμ μ νμ μΆκ°. ν¨μ λ€μ μ€λ μκ΄νΈμ λ€μ΄κ°λ€. ν¨μμ μ μμ μΈμμ μμ ν¨μλ₯Ό νΈμΆν  λμ μΈμμ μκ° κ°μμΌ μ€λ₯ λ°μ X. 

- `ν¨μμ΄λ¦(λ³μλͺ)` : ν¨μ **νΈμΆ** μ μΈμ μ κ³΅

  

π μμμ½λ

```kotlin
fun main() {
  println("Hi there")
  print(1)
  print("νλ\n")
  print(2)
  
  // Happy Birthday!
  // Hi there
  // 1νλ
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

// μ€μ²© repeatλ¬Έ μ¬μ© -> @κ° 12λ² μΆλ ₯λλ μ€μ΄ 10λ² μΆλ ₯λ¨
fun printCakeBottom(age: Int, layers: Int) {
    repeat(age) { 
        repeat(age + 2) {
            print("@")
        }
        println()
    }
}
```



#### π ν΄μ¦

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

   ![](/Users/jumin/Desktop/αα³αα³αα΅α«αα£αΊ 2021-07-06 αα©αα? 3.45.59.png)

   > Print two lines of text

   

5. How would you modify this `main()` function so that it prints a 6-layer cake for someone's 4th birthday?

   ![image-20210706154714327](/Users/jumin/Library/Application Support/typora-user-images/image-20210706154714327.png)

   > Set val age to `4`, set val layers to `6`

   

6. Which of these options correctly calls the function, below, and passes it valid input arguments?

   ![αα³αα³αα΅α«αα£αΊ 2021-07-06 αα©αα? 3.47.43](/Users/jumin/Desktop/αα³αα³αα΅α«αα£αΊ 2021-07-06 αα©αα? 3.47.43.png)

   > createMessage("Amy", "Australia", 20)

   
   
   <img src="/Users/jumin/Desktop/αα³αα³αα΅α«αα£αΊ 2021-07-05 αα©αα? 4.00.30.png" alt="αα³αα³αα΅α«αα£αΊ 2021-07-05 αα©αα? 4.00.30" style="zoom:40%;" />

#### π μ°Έκ³ 

π [λΈλΌμ°μ  λ΄μ λνν μ½νλ¦° νΈμ§κΈ°](https://developer.android.com/training/kotlinplayground) 

π [μ½νλ¦°μμ μ¬μ©λλ μλλ‘μ΄λ κΈ°μ΄ μ©μ΄]( https://developer.android.com/courses/android-basics-kotlin/android-basics-kotlin-vocab)

