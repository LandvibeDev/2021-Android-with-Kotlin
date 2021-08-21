## 2021 Landvibe Summer Coding - Android

### 🔎 Android Basics In Kotlin

#### 📌 Unit2: Layouts

#### 📌 PathWay1: Get user input in an app: Part 1

<hr>

##### Kotlin의 클래스 및 상속

`최상위 or root class`

| (상속)

`상위 class/super class`

| (상속)

`하위 class/sub class`

예시 : `view` > `TextView` > `EditText` & `Button`



`추상클래스` : 완전히 구현되지 않아 인스턴화 할 수 없는 class

🚨 추상 클래스에서 정의된 모든 추상 메서드는 추상 클래스의 서브클래스에서 구현되어야 함

ex) `Vegetables`은 추상 class임. `하위 class`에게 모양, 색상 등 구체화 맡기기 때문에!



🚩 선언

```kotlin
//root class
abstract class Dwelling(private var residents){//private로 적기
    abstract val buildingMaterial: String //abstract를 붙여 값을 안주어도 OK
    abstract val capacity: Int

    fun hasRoom(): Boolean {
    return residents < capacity //true 또는 false 반환
	}
}

//sub class -1
class SquareCabin(residents: Int) : Dwelling(residents) {//val이라고 적기 X
    override val buildingMaterial = "Wood" //선언 필요
    override val capacity = 6 //선언 필요
}

//sub class -1
class RoundHut(residents: Int) : Dwelling(residents) {
    override val buildingMaterial = "Straw"
    override val capacity = 4
}

//Round Hut의 sub class
//open이라고 적기!
//기본적으로 class가 최종 class이기에..!

//val floors는 RoundHut엔 X RoundTower엔 O
open class RoundTower(
    residents: Int,
	val floors:Int=2) : RoundHut(residents) {
   override val buildingMaterial = "Stone"
   override val capacity = 4*floors
}
```

출력

```kotlin
fun main() {
    //sub class-1
    val squareCabin = SquareCabin(6)
	
    //squareCabin다 적어주기
    println("\nSquare Cabin\n============")
    println("Capacity: ${squareCabin.capacity}")
    println("Material: ${squareCabin.buildingMaterial}")
    println("Has room? ${squareCabin.hasRoom()}")
    
    //효율적으로 쓰는 방법
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



`abstract` 를 사용하면, 구체화하는 함수에는 `override`사용!



🚩수학 라이브러리 사용하기 -파이

```kotlin
import kotlin.math.PI
```

```kotlin
override fun floorArea(): Double {
    return PI * radius * radius
}
```

또는

```kotlin
kotlin.math.PI * radius * radius
```



🚩상위 클래스에 정의된 함수를 호출

`super` 키워드 사용

```kotlin
override fun floorArea(): Double {
    return super.floorArea() * floors
}
```



🚩수학 라이브러리 사용하기 -sqrt

```kotlin
import kotlin.math.sqrt
```

```kotlin
fun calculateMaxCarpetSize(): Double {
    val diameter = 2 * radius
    return sqrt(diameter * diameter / 2)
}
```



🚩전체 코드

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

전체 출력

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



🚩 요약

- 하위 클래스가 상위 클래스에서 기능을 상속받는 클래스 트리인 클래스 계층 구조를 만드는 방법. 속성과 함수가 서브클래스에 상속됩니다.
- 일부 기능을 서브클래스에서 구현하도록 남기는 `abstract` 클래스를 만드는 방법. 따라서 `abstract` 클래스는 인스턴스화할 수 없습니다.
- `abstract` 클래스의 서브클래스를 만드는 방법
- `override` 키워드를 사용하여 서브클래스의 속성과 함수를 재정의하는 방법
- `super` 키워드를 사용하여 상위 클래스의 함수와 속성을 참조하는 방법
- 서브클래스로 분류할 수 있도록 클래스를 `open`으로 만드는 방법
- 속성을 `private`으로 만들어 클래스 내에서만 사용할 수 있도록 하는 방법
- `with` 구문을 사용하여 동일한 객체 인스턴스에서 여러 호출을 실행하는 방법
- `kotlin.math` 라이브러리에서 기능을 가져오는 방법



##### 안드로이드의 xml 레이아웃 만들기

🚩 `XML`은 *확장성 마크업 언어(eXtensible Markup Language)*를 의미하며 텍스트 기반 문서를 사용하여 데이터를 설명하는 방법

확장 가능하고 매우 유연하므로 Android 앱의 UI 레이아웃 정의를 비롯하여 다양한 용도로 사용

UI 요소는 XML 파일의 XML *요소*로 표현

각 요소는 태그로 시작하고 끝나며 각 태그는 `<`로 시작하고 `>`로 끝남



🚩 예시

```xml
<androidx.constraintlayout.widget.ConstraintLayout>
    <TextView
        android:text="Hello World!" />
</androidx.constraintlayout.widget.ConstraintLayout>
```

`xmlns`는 XML 네임스페이스를 나타내고 각 줄은 *스키마*나 이러한 단어와 관련된 속성의 어휘를 정의

`android:` 네임스페이스는 Android 시스템에서 정의한 속성을 표시

즉, 레이아웃 XML의 속성은 모두 이러한 네임스페이스 중 하나로 시작

주석을 추가: `<!--`로 시작하고 `-->`로 끝



🚩 **Split** 뷰를 사용하여 개발자가 수정하는 XML과 이러한 수정으로 인한 **Design Editor**의 변경사항을 모두 확인



🚩 실제 팁 프로그램 제작!

소수점이 있는 숫자로 제한하는 `numberDecimal`

힌트 주기: `android:hint="Cost of Service"`

제한줘서 에러 안뜨게 하는 방법

```xml
app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
```

`RadioGroup`이 상위 뷰 / `RadioButtons`는 그 안에 있는 하위 

🚨 `ConstraintLayout`의 UI 요소에는 `match_parent`를 설정할 수 없다!



🚩 문자열 추출

하드 코딩 문자열에 관한 경고를 확인 > activity_main.xml`을 살펴보고 모든 문자열 리소스를 추출

1. 문자열을 클릭

   표시되는 노란색 전구 아이콘 위로 마우스를 가져간 다음 옆에 있는 삼각형을 클릭

   **Extract String Resource**를 선택(`Fix` 클릭)

2. **Project** 창이 표시되지 않으면 창 왼쪽에 있는 **Project** 탭을 클릭

3. **app > res > values > strings.xml**을 열어 UI 문자열 리소스를 모두 확인



🚩 xml 형식 다시 지정

Android 스튜디오는 코드를 깔끔하게 정리하고 권장 코딩 규칙을 따르는지 확인하는 다양한 도구를 제공

1. `activity_main.xml`에서 **Edit > Select All**을 선택
2. **Code > Reformat Code**를 선택
3. 통일된 형태의 xml파일로 정리된 것 확인!



🚩 요약

- XML(확장성 마크업 언어)은 텍스트를 구성하는 방법이며 태그, 요소, 속성으로 구성됩니다.
- XML을 사용하여 Android 앱의 레이아웃을 정의합니다.
- `EditText`를 사용하여 사용자가 텍스트를 입력하거나 수정하도록 합니다.
- `EditText`에는 사용자에게 입력란에 예상되는 내용을 알려주는 힌트가 있을 수 있습니다.
- `android:inputType` 속성을 지정하여 사용자가 `EditText` 입력란에 입력할 수 있는 텍스트 유형을 제한합니다.
- `RadioGroup`으로 그룹화된 `RadioButtons`를 사용하여 배타적인 옵션 목록을 만듭니다.
- `RadioGroup`은 세로 또는 가로로 될 수 있고 개발자는 처음에 선택해야 하는 `RadioButton`을 지정할 수 있습니다.
- `Switch`를 사용하여 사용자가 두 옵션 간에 전환할 수 있도록 합니다.
- 별도의 `TextView`를 사용하지 않고 `Switch`에 라벨을 추가할 수 있습니다.
- `ConstraintLayout`의 각 하위 요소에는 세로 및 가로 제약 조건이 있어야 합니다.
- 'start' 및 'end' 제약 조건을 사용하여 왼쪽에서 오른쪽(LTR) 및 오른쪽에서 왼쪽(RTL) 방향 언어를 모두 처리합니다.
- 제약 조건 속성의 이름은 `layout_constraint<Source>_to<Target>Of` 형식을 따릅니다.
- `View`의 너비를 포함되는 `ConstraintLayout`의 너비와 같게 하려면 시작과 끝을 상위 요소의 시작과 끝으로 제한하고 너비를 0dp로 설정합니다.



##### 팁 계산

🚩 폴더 설명

- **java** - Kotlin 파일(또는 자바 파일)의 폴더
- `MainActivity` - 팁 계산기 로직의 모든 Kotlin 코드가 들어갈 클래스
- **res** - 앱 리소스의 폴더
- `activity_main.xml` - Android 앱의 레이아웃 파일
- `strings.xml` - Android 앱의 문자열 리소스가 포함되어 있는 파일
- **Gradle Scripts** - 폴더



🚩 뷰 결합

1. 앱의 `build.gradle` 파일을 엽니다(**Gradle Scripts > build.gradle (Module: Tip_Time.app)**).

2. `android` 섹션에서 다음 줄을 추가합니다.

   ```kotlin
   buildFeatures {
       viewBinding = true
   }
   ```

3. '**Gradle files have changed since last project sync.**'라는 메시지에 주의합니다.

4. **Sync Now**를 누릅니다.



🚩 비정상 종료 디버그

1. Android 스튜디오 하단에 있는 **Logcat** 버튼을 누르거나 메뉴에서 **View > Tool Windows > Logcat**을 선택

2. Android 스튜디오 하단에, 이상하게 보이는 텍스트로 가득 찬 **Logcat** 창이 표시됨

3. **Logcat** 텍스트에서 `FATAL EXCEPTION` 텍스트가 포함된 줄을 찾을 때까지 위로 스크롤!

4. `NumberFormatException`이 있는 줄을 찾을 때까지 아래쪽으로 읽기

5. 계속해서 아래쪽으로 읽으면 `parseDouble()` 호출을 몇 가지 확인

6. 이러한 호출 아래에서 `calculateTip`이 있는 줄을 찾기 > 이 줄에는 `MainActivity` 클래스도 포함되어 있음

7. 이 줄을 주의 깊게 살펴보면 코드에서 호출이 발생한 정확한 위치 즉, `MainActivity.kt`의 20번째 코드 줄을 확인할 수 있음

   (코드를 다르게 입력한 경우 코드 줄 번호가 다를 수 있습니다.) 

   이 줄은 `String`을 `Double`로 변환하고 결과를 `cost` 변수에 할



🚩 null

비어 있는 문자열이나 유효한 십진수를 나타내지 않는 문자열에서 `toDouble()`을 호출하면 작동하지 않습니다. 다행히 Kotlin은 이러한 문제를 처리하는 `toDoubleOrNull()`이라는 메서드도 제공



🚩 코드 검사

1. `MainActivity.kt`를 연 채로 메뉴에서 **Analyze > Inspect Code...**를 선택합니다. **Specify Inspection Scope**라는 대화상자가 표시됩니다.
2. **File**로 시작하는 옵션을 선택하고 **OK**를 누릅니다. 이렇게 하면 검사가 `MainActivity.kt`로만 제한됩니다.
3. **Inspection Results**가 있는 창이 하단에 표시됩니다.
4. 메시지가 표시될 때까지 **Kotlin** 옆과 **Style issues** 옆에 있는 회색 삼각형을 차례로 클릭합니다. 
5. 원하는 메시지가 표시될 때까지 회색 삼각형을 클릭하고, 최종적으로 메시지를 클릭합니다.
6. 오른쪽 상단에 버튼을 누릅니다. Android 스튜디오가 문제를 삭제합니다.



🚩 요약

- 뷰 결합을 사용하면 앱의 UI 요소와 상호작용하는 코드를 더 쉽게 작성할 수 있습니다.
- Kotlin의 `Double` 데이터 유형은 십진수를 저장할 수 있습니다.
- `RadioGroup`의 `checkRadioButtonId` 속성을 사용하여 선택된 `RadioButton`을 확인할 수 있습니다.
- `NumberFormat.getCurrencyInstance()`를 사용하여 숫자를 통화 형식으로 지정하는 데 이용할 형식 지정 클래스를 가져올 수 있습니다.
- `%s`와 같은 문자열 매개변수를 사용하여 다른 언어로 쉽게 변환할 수 있는 동적 문자열을 만들 수 있습니다.
- Android 스튜디오에서 **Logcat**을 사용하여 앱 비정상 종료와 같은 문제를 해결할 수 있습니다.
- 스택 트레이스는 호출된 메서드 목록을 보여 줍니다. 이는 코드가 예외를 생성하는 경우에 유용할 수 있습니다.
- 일부 코드는 `null` 값을 처리할 수 없으므로 주의해서 사용해야 합니다.
- 추천을 확인할 수 있는 **Analyze > Inspect Code**를 사용하여 코드를 개선합니다.



##### 문제 풀이

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

3. 빈 칸 채우기

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

