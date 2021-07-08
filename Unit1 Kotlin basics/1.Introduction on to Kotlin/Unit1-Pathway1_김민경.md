## Unit1-1 : Kotlin Basics



### Pathway1: Introduction to Kotlin



* Welcome to Android Basics

* Build your first Android app in Kotlin

  * program : A series of instructions that a computer system executes to accomplish some action

* Write your first program in Kotlin

  * basic structure

    ```kotlin
    fun main(){ 
    
    println("a")
    
    }
    ```

    * fun : function ---keyword
    * fun **A**  : the word after the keywords, which means function name
    * main() : all of programs need to use main() function
    * println : print with a line break
    * print : print with no line break

  * reference

    * [Vocabulary for Android Basics in Kotlin]()

      

* Create a birthday message in Kotlin

  ```kotlin
  fun main() {
      val age = 24
      val layers = 5
      printCakeCandles(age)
      printCakeTop(age)
      printCakeBottom(age, layers)
      println("congratulation ${age}th birthday")
  }
  
  fun printCakeCandles(age: Int) {
      print (" ")
      repeat(age) {
            print(",")
      }    
      println() // Print an empty line
  
      print(" ") // Print the inset of the candles on the cake
      repeat(age) {
          print("|")
      }    
      println()
  }
  
  fun printCakeTop(age: Int) {
      repeat(age + 2) {
          print("=")
      }
      println()
  }
  
  fun printCakeBottom(age: Int, layers: Int) {
      repeat(layers) {
          repeat(age + 2) {
              print("@")
          }
          println()
      }    
  }
  ```

  * 

    * val : static variable

    * ${} : to surround variable and calculation in the text of print 

      (ex) ${age} where age is a variable)

    * repeat() : the loop, which repeats the set of instructions multiple times. you can put the number of times you want in `` ( )``

    * repeat

    * variable type

      -String : text surrounded by quotes with `` ""`` 

      -Int : Integer

    * argument usage

      -function name(argument: argument type)

       ex) printBorder(age : Int, name : String)

      -function(argument)

      : of course you can supply the argument as you call the function

      

