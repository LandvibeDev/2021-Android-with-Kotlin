## 2021 Landvibe Summer Coding - Android

### ๐ Android Basics In Kotlin

#### ๐ Unit2: Layouts

#### ๐ PathWay1: Get user input in an app: Part 1

<hr>

##### Kotlin์ ํด๋์ค ๋ฐ ์์

`์ต์์ or root class`

| (์์)

`์์ class/super class`

| (์์)

`ํ์ class/sub class`

์์ : `view` > `TextView` > `EditText` & `Button`



`์ถ์ํด๋์ค` : ์์ ํ ๊ตฌํ๋์ง ์์ ์ธ์คํดํ ํ  ์ ์๋ class

๐จ ์ถ์ ํด๋์ค์์ ์ ์๋ ๋ชจ๋  ์ถ์ ๋ฉ์๋๋ ์ถ์ ํด๋์ค์ ์๋ธํด๋์ค์์ ๊ตฌํ๋์ด์ผ ํจ

ex) `Vegetables`์ ์ถ์ class์. `ํ์ class`์๊ฒ ๋ชจ์, ์์ ๋ฑ ๊ตฌ์ฒดํ ๋งก๊ธฐ๊ธฐ ๋๋ฌธ์!



๐ฉ ์ ์ธ

```kotlin
//root class
abstract class Dwelling(private var residents){//private๋ก ์ ๊ธฐ
    abstract val buildingMaterial: String //abstract๋ฅผ ๋ถ์ฌ ๊ฐ์ ์์ฃผ์ด๋ OK
    abstract val capacity: Int

    fun hasRoom(): Boolean {
    return residents < capacity //true ๋๋ false ๋ฐํ
	}
}

//sub class -1
class SquareCabin(residents: Int) : Dwelling(residents) {//val์ด๋ผ๊ณ  ์ ๊ธฐ X
    override val buildingMaterial = "Wood" //์ ์ธ ํ์
    override val capacity = 6 //์ ์ธ ํ์
}

//sub class -1
class RoundHut(residents: Int) : Dwelling(residents) {
    override val buildingMaterial = "Straw"
    override val capacity = 4
}

//Round Hut์ sub class
//open์ด๋ผ๊ณ  ์ ๊ธฐ!
//๊ธฐ๋ณธ์ ์ผ๋ก class๊ฐ ์ต์ข class์ด๊ธฐ์..!

//val floors๋ RoundHut์ X RoundTower์ O
open class RoundTower(
    residents: Int,
	val floors:Int=2) : RoundHut(residents) {
   override val buildingMaterial = "Stone"
   override val capacity = 4*floors
}
```

์ถ๋ ฅ

```kotlin
fun main() {
    //sub class-1
    val squareCabin = SquareCabin(6)
	
    //squareCabin๋ค ์ ์ด์ฃผ๊ธฐ
    println("\nSquare Cabin\n============")
    println("Capacity: ${squareCabin.capacity}")
    println("Material: ${squareCabin.buildingMaterial}")
    println("Has room? ${squareCabin.hasRoom()}")
    
    //ํจ์จ์ ์ผ๋ก ์ฐ๋ ๋ฐฉ๋ฒ
    with(squareCabin){
        println("\nSquare Cabin\n============")
    	println("Capacity: ${squareCabin.capacity}")
    	println("Material: ${squareCabin.buildingMaterial}")
   		println("Has room? ${squareCabin.hasRoom()}")
    }
    
    //sub class-2
    val roundHut = RoundHut(3)
    with(roundHut) {
    println("\nRound Hut\n=========")
    println("Material: ${buildingMaterial}")
    println("Capacity: ${capacity}")
    println("Has room? ${hasRoom()}")
	}
    
    //sub sub class
    val roundTower = RoundTower(4)
    with(roundTower) {
    println("\nRound Tower\n==========")
    println("Material: ${buildingMaterial}")
    println("Capacity: ${capacity}")
    println("Has room? ${hasRoom()}")
	}
}
```



`abstract` ๋ฅผ ์ฌ์ฉํ๋ฉด, ๊ตฌ์ฒดํํ๋ ํจ์์๋ `override`์ฌ์ฉ!



๐ฉ์ํ ๋ผ์ด๋ธ๋ฌ๋ฆฌ ์ฌ์ฉํ๊ธฐ -ํ์ด

```kotlin
import kotlin.math.PI
```

```kotlin
override fun floorArea(): Double {
    return PI * radius * radius
}
```

๋๋

```kotlin
kotlin.math.PI * radius * radius
```



๐ฉ์์ ํด๋์ค์ ์ ์๋ ํจ์๋ฅผ ํธ์ถ

`super` ํค์๋ ์ฌ์ฉ

```kotlin
override fun floorArea(): Double {
    return super.floorArea() * floors
}
```



๐ฉ์ํ ๋ผ์ด๋ธ๋ฌ๋ฆฌ ์ฌ์ฉํ๊ธฐ -sqrt

```kotlin
import kotlin.math.sqrt
```

```kotlin
fun calculateMaxCarpetSize(): Double {
    val diameter = 2 * radius
    return sqrt(diameter * diameter / 2)
}
```



๐ฉ์ ์ฒด ์ฝ๋

```kotlin
/**
* Program that implements classes for different kinds of dwellings.
* Shows how to:
* Create class hierarchy, variables and functions with inheritance,
* abstract class, overriding, and private vs. public variables.
*/

import kotlin.math.PI
import kotlin.math.sqrt

fun main() {
   val squareCabin = SquareCabin(6, 50.0)
   val roundHut = RoundHut(3, 10.0)
   val roundTower = RoundTower(4, 15.5)

   with(squareCabin) {
       println("\nSquare Cabin\n============")
       println("Capacity: ${capacity}")
       println("Material: ${buildingMaterial}")
       println("Floor area: ${floorArea()}")
   }

   with(roundHut) {
       println("\nRound Hut\n=========")
       println("Material: ${buildingMaterial}")
       println("Capacity: ${capacity}")
       println("Floor area: ${floorArea()}")
       println("Has room? ${hasRoom()}")
       getRoom()
       println("Has room? ${hasRoom()}")
       getRoom()
       println("Carpet size: ${calculateMaxCarpetSize()}")
   }

   with(roundTower) {
       println("\nRound Tower\n==========")
       println("Material: ${buildingMaterial}")
       println("Capacity: ${capacity}")
       println("Floor area: ${floorArea()}")
       println("Carpet size: ${calculateMaxCarpetSize()}")
   }
}

/**
* Defines properties common to all dwellings.
* All dwellings have floorspace,
* but its calculation is specific to the subclass.
* Checking and getting a room are implemented here
* because they are the same for all Dwelling subclasses.
*
* @param residents Current number of residents
*/
abstract class Dwelling(private var residents: Int) {
   abstract val buildingMaterial: String
   abstract val capacity: Int

   /**
    * Calculates the floor area of the dwelling.
    * Implemented by subclasses where shape is determined.
    *
    * @return floor area
    */
   abstract fun floorArea(): Double

   /**
    * Checks whether there is room for another resident.
    *
    * @return true if room available, false otherwise
    */
   fun hasRoom(): Boolean {
       return residents < capacity
   }

   /**
    * Compares the capacity to the number of residents and
    * if capacity is larger than number of residents,
    * add resident by increasing the number of residents.
    * Print the result.
    */
   fun getRoom() {
       if (capacity > residents) {
           residents++
           println("You got a room!")
       } else {
           println("Sorry, at capacity and no rooms left.")
       }
   }

   }

/**
* A square cabin dwelling.
*
*  @param residents Current number of residents
*  @param length Length
*/
class SquareCabin(residents: Int, val length: Double) : Dwelling(residents) {
   override val buildingMaterial = "Wood"
   override val capacity = 6

   /**
    * Calculates floor area for a square dwelling.
    *
    * @return floor area
    */
   override fun floorArea(): Double {
       return length * length
   }

}

/**
* Dwelling with a circular floorspace
*
* @param residents Current number of residents
* @param radius Radius
*/
open class RoundHut(
       val residents: Int, val radius: Double) : Dwelling(residents) {

   override val buildingMaterial = "Straw"
   override val capacity = 4

   /**
    * Calculates floor area for a round dwelling.
    *
    * @return floor area
    */
   override fun floorArea(): Double {
       return PI * radius * radius
   }

   /**
    *  Calculates the max length for a square carpet
    *  that fits the circular floor.
    *
    * @return length of carpet
    */
   fun calculateMaxCarpetSize(): Double {
       val diameter = 2 * radius
       return sqrt(diameter * diameter / 2)
   }

}

/**
* Round tower with multiple stories.
*
* @param residents Current number of residents
* @param radius Radius
* @param floors Number of stories
*/
class RoundTower(
       residents: Int,
       radius: Double,
       val floors: Int = 2) : RoundHut(residents, radius) {

   override val buildingMaterial = "Stone"

   // Capacity depends on the number of floors.
   override val capacity = floors * 4

   /**
    * Calculates the total floor area for a tower dwelling
    * with multiple stories.
    *
    * @return floor area
    */
   override fun floorArea(): Double {
       return super.floorArea() * floors
   }
}
```

์ ์ฒด ์ถ๋ ฅ

```kotlin
Square Cabin
============
Capacity: 6
Material: Wood
Floor area: 2500.0

Round Hut
=========
Material: Straw
Capacity: 4
Floor area: 314.1592653589793
Has room? true
You got a room!
Has room? false
Sorry, at capacity and no rooms left.
Carpet size: 14.142135623730951

Round Tower
==========
Material: Stone
Capacity: 8
Floor area: 1509.5352700498956
Carpet size: 21.920310216782973
```



๐ฉ ์์ฝ

- ํ์ ํด๋์ค๊ฐ ์์ ํด๋์ค์์ ๊ธฐ๋ฅ์ ์์๋ฐ๋ ํด๋์ค ํธ๋ฆฌ์ธ ํด๋์ค ๊ณ์ธต ๊ตฌ์กฐ๋ฅผ ๋ง๋๋ ๋ฐฉ๋ฒ. ์์ฑ๊ณผ ํจ์๊ฐ ์๋ธํด๋์ค์ ์์๋ฉ๋๋ค.
- ์ผ๋ถ ๊ธฐ๋ฅ์ ์๋ธํด๋์ค์์ ๊ตฌํํ๋๋ก ๋จ๊ธฐ๋ `abstract` ํด๋์ค๋ฅผ ๋ง๋๋ ๋ฐฉ๋ฒ. ๋ฐ๋ผ์ `abstract` ํด๋์ค๋ ์ธ์คํด์คํํ  ์ ์์ต๋๋ค.
- `abstract` ํด๋์ค์ ์๋ธํด๋์ค๋ฅผ ๋ง๋๋ ๋ฐฉ๋ฒ
- `override` ํค์๋๋ฅผ ์ฌ์ฉํ์ฌ ์๋ธํด๋์ค์ ์์ฑ๊ณผ ํจ์๋ฅผ ์ฌ์ ์ํ๋ ๋ฐฉ๋ฒ
- `super` ํค์๋๋ฅผ ์ฌ์ฉํ์ฌ ์์ ํด๋์ค์ ํจ์์ ์์ฑ์ ์ฐธ์กฐํ๋ ๋ฐฉ๋ฒ
- ์๋ธํด๋์ค๋ก ๋ถ๋ฅํ  ์ ์๋๋ก ํด๋์ค๋ฅผ `open`์ผ๋ก ๋ง๋๋ ๋ฐฉ๋ฒ
- ์์ฑ์ `private`์ผ๋ก ๋ง๋ค์ด ํด๋์ค ๋ด์์๋ง ์ฌ์ฉํ  ์ ์๋๋ก ํ๋ ๋ฐฉ๋ฒ
- `with` ๊ตฌ๋ฌธ์ ์ฌ์ฉํ์ฌ ๋์ผํ ๊ฐ์ฒด ์ธ์คํด์ค์์ ์ฌ๋ฌ ํธ์ถ์ ์คํํ๋ ๋ฐฉ๋ฒ
- `kotlin.math` ๋ผ์ด๋ธ๋ฌ๋ฆฌ์์ ๊ธฐ๋ฅ์ ๊ฐ์ ธ์ค๋ ๋ฐฉ๋ฒ



##### ์๋๋ก์ด๋์ xml ๋ ์ด์์ ๋ง๋ค๊ธฐ

๐ฉ `XML`์ *ํ์ฅ์ฑ ๋งํฌ์ ์ธ์ด(eXtensible Markup Language)*๋ฅผ ์๋ฏธํ๋ฉฐ ํ์คํธ ๊ธฐ๋ฐ ๋ฌธ์๋ฅผ ์ฌ์ฉํ์ฌ ๋ฐ์ดํฐ๋ฅผ ์ค๋ชํ๋ ๋ฐฉ๋ฒ

ํ์ฅ ๊ฐ๋ฅํ๊ณ  ๋งค์ฐ ์ ์ฐํ๋ฏ๋ก Android ์ฑ์ UI ๋ ์ด์์ ์ ์๋ฅผ ๋น๋กฏํ์ฌ ๋ค์ํ ์ฉ๋๋ก ์ฌ์ฉ

UI ์์๋ XML ํ์ผ์ XML *์์*๋ก ํํ

๊ฐ ์์๋ ํ๊ทธ๋ก ์์ํ๊ณ  ๋๋๋ฉฐ ๊ฐ ํ๊ทธ๋ `<`๋ก ์์ํ๊ณ  `>`๋ก ๋๋จ



๐ฉ ์์

```xml
<androidx.constraintlayout.widget.ConstraintLayout>
    <TextView
        android:text="Hello World!" />
</androidx.constraintlayout.widget.ConstraintLayout>
```

`xmlns`๋ XML ๋ค์์คํ์ด์ค๋ฅผ ๋ํ๋ด๊ณ  ๊ฐ ์ค์ *์คํค๋ง*๋ ์ด๋ฌํ ๋จ์ด์ ๊ด๋ จ๋ ์์ฑ์ ์ดํ๋ฅผ ์ ์

`android:` ๋ค์์คํ์ด์ค๋ Android ์์คํ์์ ์ ์ํ ์์ฑ์ ํ์

์ฆ, ๋ ์ด์์ XML์ ์์ฑ์ ๋ชจ๋ ์ด๋ฌํ ๋ค์์คํ์ด์ค ์ค ํ๋๋ก ์์

์ฃผ์์ ์ถ๊ฐ: `<!--`๋ก ์์ํ๊ณ  `-->`๋ก ๋



๐ฉ **Split** ๋ทฐ๋ฅผ ์ฌ์ฉํ์ฌ ๊ฐ๋ฐ์๊ฐ ์์ ํ๋ XML๊ณผ ์ด๋ฌํ ์์ ์ผ๋ก ์ธํ **Design Editor**์ ๋ณ๊ฒฝ์ฌํญ์ ๋ชจ๋ ํ์ธ



๐ฉ ์ค์  ํ ํ๋ก๊ทธ๋จ ์ ์!

์์์ ์ด ์๋ ์ซ์๋ก ์ ํํ๋ `numberDecimal`

ํํธ ์ฃผ๊ธฐ: `android:hint="Cost of Service"`

์ ํ์ค์ ์๋ฌ ์๋จ๊ฒ ํ๋ ๋ฐฉ๋ฒ

```xml
app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
```

`RadioGroup`์ด ์์ ๋ทฐ / `RadioButtons`๋ ๊ทธ ์์ ์๋ ํ์ 

๐จ `ConstraintLayout`์ UI ์์์๋ `match_parent`๋ฅผ ์ค์ ํ  ์ ์๋ค!



๐ฉ ๋ฌธ์์ด ์ถ์ถ

ํ๋ ์ฝ๋ฉ ๋ฌธ์์ด์ ๊ดํ ๊ฒฝ๊ณ ๋ฅผ ํ์ธ > activity_main.xml`์ ์ดํด๋ณด๊ณ  ๋ชจ๋  ๋ฌธ์์ด ๋ฆฌ์์ค๋ฅผ ์ถ์ถ

1. ๋ฌธ์์ด์ ํด๋ฆญ

   ํ์๋๋ ๋ธ๋์ ์ ๊ตฌ ์์ด์ฝ ์๋ก ๋ง์ฐ์ค๋ฅผ ๊ฐ์ ธ๊ฐ ๋ค์ ์์ ์๋ ์ผ๊ฐํ์ ํด๋ฆญ

   **Extract String Resource**๋ฅผ ์ ํ(`Fix` ํด๋ฆญ)

2. **Project** ์ฐฝ์ด ํ์๋์ง ์์ผ๋ฉด ์ฐฝ ์ผ์ชฝ์ ์๋ **Project** ํญ์ ํด๋ฆญ

3. **app > res > values > strings.xml**์ ์ด์ด UI ๋ฌธ์์ด ๋ฆฌ์์ค๋ฅผ ๋ชจ๋ ํ์ธ



๐ฉ xml ํ์ ๋ค์ ์ง์ 

Android ์คํ๋์ค๋ ์ฝ๋๋ฅผ ๊น๋ํ๊ฒ ์ ๋ฆฌํ๊ณ  ๊ถ์ฅ ์ฝ๋ฉ ๊ท์น์ ๋ฐ๋ฅด๋์ง ํ์ธํ๋ ๋ค์ํ ๋๊ตฌ๋ฅผ ์ ๊ณต

1. `activity_main.xml`์์ **Edit > Select All**์ ์ ํ
2. **Code > Reformat Code**๋ฅผ ์ ํ
3. ํต์ผ๋ ํํ์ xmlํ์ผ๋ก ์ ๋ฆฌ๋ ๊ฒ ํ์ธ!



๐ฉ ์์ฝ

- XML(ํ์ฅ์ฑ ๋งํฌ์ ์ธ์ด)์ ํ์คํธ๋ฅผ ๊ตฌ์ฑํ๋ ๋ฐฉ๋ฒ์ด๋ฉฐ ํ๊ทธ, ์์, ์์ฑ์ผ๋ก ๊ตฌ์ฑ๋ฉ๋๋ค.
- XML์ ์ฌ์ฉํ์ฌ Android ์ฑ์ ๋ ์ด์์์ ์ ์ํฉ๋๋ค.
- `EditText`๋ฅผ ์ฌ์ฉํ์ฌ ์ฌ์ฉ์๊ฐ ํ์คํธ๋ฅผ ์๋ ฅํ๊ฑฐ๋ ์์ ํ๋๋ก ํฉ๋๋ค.
- `EditText`์๋ ์ฌ์ฉ์์๊ฒ ์๋ ฅ๋์ ์์๋๋ ๋ด์ฉ์ ์๋ ค์ฃผ๋ ํํธ๊ฐ ์์ ์ ์์ต๋๋ค.
- `android:inputType` ์์ฑ์ ์ง์ ํ์ฌ ์ฌ์ฉ์๊ฐ `EditText` ์๋ ฅ๋์ ์๋ ฅํ  ์ ์๋ ํ์คํธ ์ ํ์ ์ ํํฉ๋๋ค.
- `RadioGroup`์ผ๋ก ๊ทธ๋ฃนํ๋ `RadioButtons`๋ฅผ ์ฌ์ฉํ์ฌ ๋ฐฐํ์ ์ธ ์ต์ ๋ชฉ๋ก์ ๋ง๋ญ๋๋ค.
- `RadioGroup`์ ์ธ๋ก ๋๋ ๊ฐ๋ก๋ก ๋  ์ ์๊ณ  ๊ฐ๋ฐ์๋ ์ฒ์์ ์ ํํด์ผ ํ๋ `RadioButton`์ ์ง์ ํ  ์ ์์ต๋๋ค.
- `Switch`๋ฅผ ์ฌ์ฉํ์ฌ ์ฌ์ฉ์๊ฐ ๋ ์ต์ ๊ฐ์ ์ ํํ  ์ ์๋๋ก ํฉ๋๋ค.
- ๋ณ๋์ `TextView`๋ฅผ ์ฌ์ฉํ์ง ์๊ณ  `Switch`์ ๋ผ๋ฒจ์ ์ถ๊ฐํ  ์ ์์ต๋๋ค.
- `ConstraintLayout`์ ๊ฐ ํ์ ์์์๋ ์ธ๋ก ๋ฐ ๊ฐ๋ก ์ ์ฝ ์กฐ๊ฑด์ด ์์ด์ผ ํฉ๋๋ค.
- 'start' ๋ฐ 'end' ์ ์ฝ ์กฐ๊ฑด์ ์ฌ์ฉํ์ฌ ์ผ์ชฝ์์ ์ค๋ฅธ์ชฝ(LTR) ๋ฐ ์ค๋ฅธ์ชฝ์์ ์ผ์ชฝ(RTL) ๋ฐฉํฅ ์ธ์ด๋ฅผ ๋ชจ๋ ์ฒ๋ฆฌํฉ๋๋ค.
- ์ ์ฝ ์กฐ๊ฑด ์์ฑ์ ์ด๋ฆ์ `layout_constraint<Source>_to<Target>Of` ํ์์ ๋ฐ๋ฆ๋๋ค.
- `View`์ ๋๋น๋ฅผ ํฌํจ๋๋ `ConstraintLayout`์ ๋๋น์ ๊ฐ๊ฒ ํ๋ ค๋ฉด ์์๊ณผ ๋์ ์์ ์์์ ์์๊ณผ ๋์ผ๋ก ์ ํํ๊ณ  ๋๋น๋ฅผ 0dp๋ก ์ค์ ํฉ๋๋ค.



##### ํ ๊ณ์ฐ

๐ฉ ํด๋ ์ค๋ช

- **java** - Kotlin ํ์ผ(๋๋ ์๋ฐ ํ์ผ)์ ํด๋
- `MainActivity` - ํ ๊ณ์ฐ๊ธฐ ๋ก์ง์ ๋ชจ๋  Kotlin ์ฝ๋๊ฐ ๋ค์ด๊ฐ ํด๋์ค
- **res** - ์ฑ ๋ฆฌ์์ค์ ํด๋
- `activity_main.xml` - Android ์ฑ์ ๋ ์ด์์ ํ์ผ
- `strings.xml` - Android ์ฑ์ ๋ฌธ์์ด ๋ฆฌ์์ค๊ฐ ํฌํจ๋์ด ์๋ ํ์ผ
- **Gradle Scripts** - ํด๋



๐ฉ ๋ทฐ ๊ฒฐํฉ

1. ์ฑ์ `build.gradle` ํ์ผ์ ์ฝ๋๋ค(**Gradle Scripts > build.gradle (Module: Tip_Time.app)**).

2. `android` ์น์์์ ๋ค์ ์ค์ ์ถ๊ฐํฉ๋๋ค.

   ```kotlin
   buildFeatures {
       viewBinding = true
   }
   ```

3. '**Gradle files have changed since last project sync.**'๋ผ๋ ๋ฉ์์ง์ ์ฃผ์ํฉ๋๋ค.

4. **Sync Now**๋ฅผ ๋๋ฆ๋๋ค.



๐ฉ ๋น์ ์ ์ข๋ฃ ๋๋ฒ๊ทธ

1. Android ์คํ๋์ค ํ๋จ์ ์๋ **Logcat** ๋ฒํผ์ ๋๋ฅด๊ฑฐ๋ ๋ฉ๋ด์์ **View > Tool Windows > Logcat**์ ์ ํ

2. Android ์คํ๋์ค ํ๋จ์, ์ด์ํ๊ฒ ๋ณด์ด๋ ํ์คํธ๋ก ๊ฐ๋ ์ฐฌ **Logcat** ์ฐฝ์ด ํ์๋จ

3. **Logcat** ํ์คํธ์์ `FATAL EXCEPTION` ํ์คํธ๊ฐ ํฌํจ๋ ์ค์ ์ฐพ์ ๋๊น์ง ์๋ก ์คํฌ๋กค!

4. `NumberFormatException`์ด ์๋ ์ค์ ์ฐพ์ ๋๊น์ง ์๋์ชฝ์ผ๋ก ์ฝ๊ธฐ

5. ๊ณ์ํด์ ์๋์ชฝ์ผ๋ก ์ฝ์ผ๋ฉด `parseDouble()` ํธ์ถ์ ๋ช ๊ฐ์ง ํ์ธ

6. ์ด๋ฌํ ํธ์ถ ์๋์์ `calculateTip`์ด ์๋ ์ค์ ์ฐพ๊ธฐ > ์ด ์ค์๋ `MainActivity` ํด๋์ค๋ ํฌํจ๋์ด ์์

7. ์ด ์ค์ ์ฃผ์ ๊น๊ฒ ์ดํด๋ณด๋ฉด ์ฝ๋์์ ํธ์ถ์ด ๋ฐ์ํ ์ ํํ ์์น ์ฆ, `MainActivity.kt`์ 20๋ฒ์งธ ์ฝ๋ ์ค์ ํ์ธํ  ์ ์์

   (์ฝ๋๋ฅผ ๋ค๋ฅด๊ฒ ์๋ ฅํ ๊ฒฝ์ฐ ์ฝ๋ ์ค ๋ฒํธ๊ฐ ๋ค๋ฅผ ์ ์์ต๋๋ค.) 

   ์ด ์ค์ `String`์ `Double`๋ก ๋ณํํ๊ณ  ๊ฒฐ๊ณผ๋ฅผ `cost` ๋ณ์์ ํ 



๐ฉ null

๋น์ด ์๋ ๋ฌธ์์ด์ด๋ ์ ํจํ ์ญ์ง์๋ฅผ ๋ํ๋ด์ง ์๋ ๋ฌธ์์ด์์ `toDouble()`์ ํธ์ถํ๋ฉด ์๋ํ์ง ์์ต๋๋ค. ๋คํํ Kotlin์ ์ด๋ฌํ ๋ฌธ์ ๋ฅผ ์ฒ๋ฆฌํ๋ `toDoubleOrNull()`์ด๋ผ๋ ๋ฉ์๋๋ ์ ๊ณต



๐ฉ ์ฝ๋ ๊ฒ์ฌ

1. `MainActivity.kt`๋ฅผ ์ฐ ์ฑ๋ก ๋ฉ๋ด์์ **Analyze > Inspect Code...**๋ฅผ ์ ํํฉ๋๋ค. **Specify Inspection Scope**๋ผ๋ ๋ํ์์๊ฐ ํ์๋ฉ๋๋ค.
2. **File**๋ก ์์ํ๋ ์ต์์ ์ ํํ๊ณ  **OK**๋ฅผ ๋๋ฆ๋๋ค. ์ด๋ ๊ฒ ํ๋ฉด ๊ฒ์ฌ๊ฐ `MainActivity.kt`๋ก๋ง ์ ํ๋ฉ๋๋ค.
3. **Inspection Results**๊ฐ ์๋ ์ฐฝ์ด ํ๋จ์ ํ์๋ฉ๋๋ค.
4. ๋ฉ์์ง๊ฐ ํ์๋  ๋๊น์ง **Kotlin** ์๊ณผ **Style issues** ์์ ์๋ ํ์ ์ผ๊ฐํ์ ์ฐจ๋ก๋ก ํด๋ฆญํฉ๋๋ค. 
5. ์ํ๋ ๋ฉ์์ง๊ฐ ํ์๋  ๋๊น์ง ํ์ ์ผ๊ฐํ์ ํด๋ฆญํ๊ณ , ์ต์ข์ ์ผ๋ก ๋ฉ์์ง๋ฅผ ํด๋ฆญํฉ๋๋ค.
6. ์ค๋ฅธ์ชฝ ์๋จ์ ๋ฒํผ์ ๋๋ฆ๋๋ค. Android ์คํ๋์ค๊ฐ ๋ฌธ์ ๋ฅผ ์ญ์ ํฉ๋๋ค.



๐ฉ ์์ฝ

- ๋ทฐ ๊ฒฐํฉ์ ์ฌ์ฉํ๋ฉด ์ฑ์ UI ์์์ ์ํธ์์ฉํ๋ ์ฝ๋๋ฅผ ๋ ์ฝ๊ฒ ์์ฑํ  ์ ์์ต๋๋ค.
- Kotlin์ `Double` ๋ฐ์ดํฐ ์ ํ์ ์ญ์ง์๋ฅผ ์ ์ฅํ  ์ ์์ต๋๋ค.
- `RadioGroup`์ `checkRadioButtonId` ์์ฑ์ ์ฌ์ฉํ์ฌ ์ ํ๋ `RadioButton`์ ํ์ธํ  ์ ์์ต๋๋ค.
- `NumberFormat.getCurrencyInstance()`๋ฅผ ์ฌ์ฉํ์ฌ ์ซ์๋ฅผ ํตํ ํ์์ผ๋ก ์ง์ ํ๋ ๋ฐ ์ด์ฉํ  ํ์ ์ง์  ํด๋์ค๋ฅผ ๊ฐ์ ธ์ฌ ์ ์์ต๋๋ค.
- `%s`์ ๊ฐ์ ๋ฌธ์์ด ๋งค๊ฐ๋ณ์๋ฅผ ์ฌ์ฉํ์ฌ ๋ค๋ฅธ ์ธ์ด๋ก ์ฝ๊ฒ ๋ณํํ  ์ ์๋ ๋์  ๋ฌธ์์ด์ ๋ง๋ค ์ ์์ต๋๋ค.
- Android ์คํ๋์ค์์ **Logcat**์ ์ฌ์ฉํ์ฌ ์ฑ ๋น์ ์ ์ข๋ฃ์ ๊ฐ์ ๋ฌธ์ ๋ฅผ ํด๊ฒฐํ  ์ ์์ต๋๋ค.
- ์คํ ํธ๋ ์ด์ค๋ ํธ์ถ๋ ๋ฉ์๋ ๋ชฉ๋ก์ ๋ณด์ฌ ์ค๋๋ค. ์ด๋ ์ฝ๋๊ฐ ์์ธ๋ฅผ ์์ฑํ๋ ๊ฒฝ์ฐ์ ์ ์ฉํ  ์ ์์ต๋๋ค.
- ์ผ๋ถ ์ฝ๋๋ `null` ๊ฐ์ ์ฒ๋ฆฌํ  ์ ์์ผ๋ฏ๋ก ์ฃผ์ํด์ ์ฌ์ฉํด์ผ ํฉ๋๋ค.
- ์ถ์ฒ์ ํ์ธํ  ์ ์๋ **Analyze > Inspect Code**๋ฅผ ์ฌ์ฉํ์ฌ ์ฝ๋๋ฅผ ๊ฐ์ ํฉ๋๋ค.



##### ๋ฌธ์  ํ์ด

1. Which of the following is true about class inheritance?

   > Class inheritance lets you reuse code and makes your program easier to maintain.
   >
   > Properties and functions of the parent class(es) are available to the child class.
   >
   > You can define additional properties and functions that are specific to subclasses.
   >
   > You can override parent class members in subclasses.

2. Which of the following are true about abstract classes?

   >They can be extended by subclasses and implementations can be provided for abstract members of the class.
   >
   >They may have abstract properties or abstract functions.
   >
   >They are not fully implemented and cannot be instantiated.

3. ๋น ์นธ ์ฑ์ฐ๊ธฐ

   > The is ` constructor` called when you create an instance of a class.

4. How do you mark a property to be used only inside its current class?

   >Use the `private` keyword.

5. Select all answers that are true for this XML layout when displayed on the screen. (You can sketch this out on a piece of paper first, if that helps.)

   ```xml
   <androidx.constraintlayout.widget.ConstraintLayout
       android:layout_width="match_parent"
       android:layout_height="match_parent">
       <TextView
           android:id="@+id/textViewA"
           android:layout_width="wrap_content"
           android:layout_height="wrap_content"
           android:text="A"
           app:layout_constraintStart_toStartOf="parent"
           app:layout_constraintTop_toTopOf="parent" />
       <TextView
           android:id="@+id/textViewB"
           android:layout_width="wrap_content"
           android:layout_height="wrap_content"
           android:text="B"
           app:layout_constraintEnd_toEndOf="parent"
           app:layout_constraintTop_toTopOf="parent" />
   </androidx.constraintlayout.widget.ConstraintLayout>
   ```

   >The starting edge of `TextView A` is aligned to the starting edge of the parent view.
   >
   >The tops of `TextView A` and `TextView B` are aligned to top of the parent view.

