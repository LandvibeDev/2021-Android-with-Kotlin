## 2021 Landvibe Summer Coding - Android

### ๐ Android Basics In Kotlin

#### ๐ Unit1: Kotlin basics

#### ๐ PathWay1: Introduction to Kotlin



##### Write your first program in Kotlin

`fun`  : ํจ์๋ฅผ ์๋ฏธ

`main` : ๊ฐ์ฅ ๊ธฐ๋ณธ์ธ ํจ์์ ์ด๋ฆ

`() `  : ์ธ์๋ฅผ ๋ฃ๋ ๋ถ๋ถ

`{}`  : ํจ์ ๋ด์ฉ์ ๋ฃ๋ ๋ถ๋ถ 

`print` & `println` : ์ถ๋ ฅ์ ๋ด๋น

```kotlin
fun main(){
    println("=======================")
    println("Happy Birthday, Jhansi!")
    println("=======================")
}
```



##### Create a birthday message in Kotlin

`var  ` : ํค์๋

`//`  : ์ฃผ์์ ์๋ฏธ

+ ๋ณ์๋ฅผ ์ ์ธํ๋ ๋ฐฉ๋ฒ

```kotlin
var age = 5
```

+ ์ถ๋ ฅ ์์ ๋ณ์ ํ์ฉํ๋ ๋ฐฉ๋ฒ

```kotlin
fun main() {
    val age=5*365 //๋ณ์ ์ ์ธ
    val name="Rover" //๋ณ์ ์ ์ธ
    
    println("Happy Birthday, ${name}!")
    println("You are already ${age} days old, ${name}!")
    println("${age} days old is the very best age to celebrate!")
}
```


`์นด๋ฉํ๊ธฐ๋ฒ`  : ํจ์ ์ด๋ฆ์ ์ ์ธํ  ๋, '์๋ฌธ์+๋์ฌ์ ์กฐํฉ' + '๋๋ฌธ์' ๋ก ํ๋ ๊ฒ์ด ๊ท์น

```kotlin
fun printBorder(){
    print("#####")
}
```

`repeat(์ซ์) `  : ๋ฐ๋ณต๊ตฌ๋ฌธ

 ```kotlin
 fun main() {
     var border1="#" //ํ ๊ฐ์ ์ธ์
     var border2="`-._,-'" //๋ ๊ฐ ์ด์์ ์ธ์
     val timesToRepeat = 4 //๋ฐ๋ณต
     printBorder(border2,timesToRepeat)
     println("  Happy Birthday, Jhansi!")
     printBorder(border2,timesToRepeat)
 }
 
 fun printBorder(border:String,time:Int){ //์ธ์ ํ์ฉ
     repeat(time){
         print(border)
     }
     println("")
 }
 ```

+ ์ต์ข์ ์ธ ๊ฒฐ๊ณผ๋ฌผ (์ผ์ดํฌ ์ถ๋ ฅ)

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
      println() //๋น ์ค ์ถ๋ ฅ
      
      print(" ")
      repeat(age){
          print("|")
      }
      println() //๋น ์ค ์ถ๋ ฅ
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
              println() //๋น ์ค ์ถ๋ ฅ
      }
      
  }
  ```

  

##### Quiz

1. What is a program?

   > A series of instructions that a computer system executes to accomplish some action

2. Which keyword do you use to define a function in Kotlin?

   >  `fun`

3. Which of the following do you need to create a Kotlin program that prints a line of text? (์ค๋ณต์ ํ)

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