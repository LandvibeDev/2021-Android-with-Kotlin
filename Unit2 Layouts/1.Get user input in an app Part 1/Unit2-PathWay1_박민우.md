# 🔥 Unit 2 : Layouts

## Pathway 1 : Get user input in an app Part 1



## 🎖 Track 3 : Kotlin의 클래스 및 상속

### What is a class hierarchy?

+  `Vegetable`을 Kotlin의 클래스로 만들면 `Legume`을 `Vegetable` 클래스의 *하위 클래스* 또는 *서브클래스*로 만들 수 있습니다. 즉, `Vegetable` 클래스의 모든 속성과 메서드가 `Legume` 클래스에 상속(즉, 사용 가능함)됩니다.

+ **상속** : 하위 클래스가 상위 클래스의 모든 속성과 메서드를 포함하거나 상속받는 경우입니다. 이를 통해 코드를 공유하고 재사용할 수 있어 프로그램을 더 쉽게 파악하고 유지할 수 있습니다.

  <img src = "https://user-images.githubusercontent.com/31370590/125270605-c823c200-e344-11eb-8748-8fd5840bdbd0.PNG" width = "600" height = "400">

+ 예를 들어 Android에는 화면의 직사각형 영역을 나타내고 그리기와 이벤트 처리를 담당하는 `View` 클래스가 있습니다. `TextView 클래스`는 `View` 클래스의 서브클래스입니다. 즉, `TextView`는 `View` 클래스의 모든 속성과 기능을 상속받고 사용자에게 텍스트를 표시하는 특정 로직을 추가합니다.

+ 한 단계 더 나아가 `EditText` 및 `Button` 클래스는 `TextView` 클래스의 하위 클래스입니다. `TextView` 및 `View` 클래스의 모든 속성과 메서드를 상속받고 고유한 특정 로직을 추가합니다. 예를 들어 `EditText`는 화면에서 텍스트를 수정할 수 있는 자체 기능을 추가합니다.



### 기본 Class 만들기

#### 주택의 클래스 계층 구조

<img src = "https://user-images.githubusercontent.com/31370590/125272109-6f552900-e346-11eb-9dfb-e0d3180cc974.PNG" width = "500" height = "400">



+ 구현할 클래스
  + `Dwelling`: 모든 주택에 공통으로 적용되는 정보를 담고 있는 구체적이지 않은 집을 나타내는 기본 클래스입니다.
  + `SquareCabin`: 바닥 면적이 정사각형인 나무로 만든 정사각형 통나무집입니다.
  + `RoundHut`: 바닥 면적이 원형인 짚으로 만든 둥근 오두막이고 `RoundTower`의 상위 요소입니다.
  + `RoundTower`: 바닥 면적이 원형이고 층이 여러 개인 돌로 만든 둥근 타워입니다



+ 추상 주택 클래스 
  + ***'추상' 클래스는 완전히 구현되지 않아서 인스턴스화할 수 없는 클래스***입니다. 스케치라고 생각하면 됩니다. 스케치를 통해 무언가에 관한 아이디어와 계획을 통합하지만 **그 무언가를 빌드하기에는 일반적으로 정보가 충분하지 않습니다.** 스케치(추상 클래스)를 사용하여 청사진(클래스)을 만들고 청사진을 통해 실제 객체 인스턴스를 빌드합니다. 
  + 일반적으로 **슈퍼클래스를 만들어 좋은 점은 모든 서브클래스에 공통적인 속성과 함수를 포함한다는 것**입니다. 속성값과 함수 구현을 알 수 없으면 클래스를 추상으로 만듭니다. 예를 들어 `Vegetables`에는 모든 채소에 일반적인 여러 속성이 있지만 구체적이지 않은 채소의 인스턴스를 만들 수는 없습니다. 모양이나 색상 등을 모르기 때문입니다. 따라서 `Vegetable`은 각 채소에 관한 구체적인 세부정보의 결정을 서브클래스에 맡기는 추상 클래스입니다. 
  + 추상 클래스 선언은 `abstract` 키워드로 시작합니다.



+ `Dwelling` class

  ```kotlin
  abstract class Dwelling(private var residents: Int) {
  
     abstract val buildingMaterial: String
     abstract val capacity: Int
  
     fun hasRoom(): Boolean {
         return residents < capacity
     }
  }
  ```

  + 이 `Dwelling` 클래스에서 주택마다 다를 수 있더라도 모든 주택에 적용되는 항목을 정의합니다. 모든 주택은 건축 자재로 만들어집니다. `Dwelling` 내에서 건축 자재를 나타내는 `String` 유형의 `buildingMaterial` 변수를 만듭니다. 건축 자재는 변경되지 않으므로 `val`을 사용하여 변경 불가능한 변수로 만듭니다.
  + 모든 주택에는 주택에 거주하는 여러 `residents`(`capacity` 이하일 수 있음)가 있으므로 모든 서브클래스가 상속받아 사용하도록 `Dwelling` 슈퍼클래스에서 `residents` 속성을 정의합니다. `residents`를 `Dwelling` 클래스의 생성자에 전달되는 매개변수로 만들 수 있습니다. `residents` 속성은 `var`입니다. 인스턴스가 만들어진 후 거주자 수가 변경될 수 있기 때문입니다. 
  + 주택의 `capacity`와 현재 `residents` 수가 모두 정의된 상태에서 주택의 또 다른 거주자를 위한 공간이 있는지 확인하는 `hasRoom()` 함수를 만들 수 있습니다. `Dwelling` 클래스에서 `hasRoom()` 함수를 정의하고 구현하면 됩니다. 공간이 있는지 계산하는 공식이 모든 주택에 동일하기 때문입니다. `residents` 수가 `capacity`보다 적으면 `Dwelling`에 공간이 있고 함수는 이 비교에 기반하여 `true`나 `false`를 반환해야 합니다.

   

### Sub class 만들기

```kotlin
abstract class Dwelling(private var residents: Int) {
    abstract val buildingMaterial: String
    abstract val capacity: Int

    fun hasRoom(): Boolean {
       return residents < capacity
   }
}

class SquareCabin(residents: Int) : Dwelling(residents) {
    override val buildingMaterial = "Wood"
    override val capacity = 6
}

fun main() {
    val squareCabin = SquareCabin(6)

    println("\nSquare Cabin\n============")
    println("Capacity: ${squareCabin.capacity}")
    println("Material: ${squareCabin.buildingMaterial}")
    println("Has room? ${squareCabin.hasRoom()}")
}
```

+ with를 사용하여 코드 단순화

  클래스의 특정 인스턴스로 작업하고 이 인스턴스의 여러 속성과 함수에 액세스해야 한다면 `with` 문을 사용하여 **이 인스턴스 객체로 다음 작업을 모두 실행**하라고 나타낼 수 있습니다. `with` 키워드로 시작하고 괄호로 묶인 인스턴스 이름, 실행하려는 작업이 포함된 중괄호가 차례로 이어집니다.

  ```kotlin
  with (instanceName) {
      // all operations to do with instanceName
  }
  ```

  ```kotlin
  with(squareCabin) {
      println("\nSquare Cabin\n============")
      println("Capacity: ${capacity}")
      println("Material: ${buildingMaterial}")
      println("Has room? ${hasRoom()}")
  }
  ```

  

+ RoundHut subclass

  ```kotlin
  fun main() {
      val roundHut = RoundHut(3)
      
      with(roundHut) {
      println("\nRound Hut\n=========")
      println("Material: ${buildingMaterial}")
      println("Capacity: ${capacity}")
      println("Has room? ${hasRoom()}")
      }
  }   
  
  class RoundHut(residents: Int) : Dwelling(residents) {
      override val buildingMaterial = "Straw"
      override val capacity = 4
  }
  ```

  

+ RoundTower subclass

  ```kotlin
  class RoundTower(residents: Int) : RoundHut(residents) {
      override val buildingMaterial = "Stone"
      override val capacity = 4
  }
  ```

  이 코드를 실행하면 오류가 발생한다. 

  ```kotlin
  This type is final, so it cannot be inherited from
  ```

  이 오류는 `RoundHut` 클래스를 서브클래스로 분류하거나 상속할 수 없음을 의미합니다. 기본적으로 Kotlin에서 클래스는 최종 클래스이며 서브클래스로 분류할 수 없습니다. `abstract` 클래스나 `open` 키워드로 표시된 클래스에서만 상속할 수 있습니다. 따라서 상속될 수 있도록 `RoundHut` 클래스를 `open` 키워드로 표시해야 합니다.

  `RoundHut` 선언 시작 부분에 `open` 키워드를 추가합니다.

  ```kotlin
  open class RoundHut(residents: Int) : Dwelling(residents) {
     override val buildingMaterial = "Straw"
     override val capacity = 4
  }
  ```

  

  여러 층이 있도록 `RoundTower`를 수정하고 층수에 따라 수용 인원을 조정합니다.

  ```kotlin
  class RoundTower(
      residents: Int,
      val floors: Int = 2) : RoundHut(residents) {
  
      override val buildingMaterial = "Stone"
      override val capacity = 4 * floors
  }
  ```





### 계층 구조의 클래스 수정

+ Dwelling  클래스에서 floorArea() 정의

  ```kotlin
  abstract class Dwelling(private var residents: Int) {
      abstract val buildingMaterial: String
      abstract val capacity: Int
  
      fun hasRoom(): Boolean {
         return residents < capacity
     }
      
      abstract fun floorArea(): Double
  }
  ```

  + 추상 클래스에서 정의된 모든 추상 메서드는 추상 클래스의 서브클래스에서 구현되어야 합니다. 코드를 실행하려면 먼저 서브클래스에서 `floorArea()`를 구현해야 합니다.



+ SquareCabin의 floorArea() 구현

  ```kotlin
  class SquareCabin(residents: Int, val length: Double) : Dwelling(residents) {
      
      override fun floorArea(): Double {
      return length * length
      }
  }
  ```



+ RoundHut의 floorArea() 구현

  ```kotlin
  open class RoundHut(
     val residents: Int,
     val radius: Double) : Dwelling(residents) {
      
      override fun floorArea(): Double {
      return PI * radius * radius
      }
  }
  ```



+ RoundTower의 floorArea() 구현

  ```kotlin
  class RoundTower(residents: Int, radius: Double,
      val floors: Int = 2) : RoundHut(residents, radius) {
  
      override val buildingMaterial = "Stone"
      override val capacity = 4 * floors
  
      override fun floorArea(): Double {
          return super.floorArea() * floors
      }
  }
  ```

  



+ 최종 코드

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





----

## 팁 계산기 app

## 🎖 Track 4 : Android의 XML 레이아웃 만들기

### XML 읽기 및 이해

+ 이미 익숙한 **Layout Editor**를 사용하는 대신 UI를 설명하는 **XML**을 수정하여 애플리케이션의 레이아웃을 빌드합니다. XML은 *확장성 마크업 언어(eXtensible Markup Language)* 를 의미하며 텍스트 기반 문서를 사용하여 데이터를 설명하는 방법입니다. XML은 확장 가능하고 매우 유연하므로 Android 앱의 UI 레이아웃 정의를 비롯하여 다양한 용도로 사용됩니다. 앱의 문자열과 같은 다른 리소스도 `strings.xml`이라는 XML 파일에 정의된다고 이전 Codelab에서 알아봤습니다.



+ 각 UI 요소는 XML 파일의 XML *요소*로 표현됩니다. 각 요소는 태그로 시작하고 끝나며 각 태그는 `<`로 시작하고 `>`로 끝납니다. **Layout Editor(디자인)**를 사용하여 UI 요소에서 속성을 설정할 수 있는 것처럼 XML 요소에도 *속성*이 있을 수 있습니다. 간단히 말해서 위 UI 요소의 XML은 다음과 같을 수 있습니다. 



```kotlin
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android">

</androidx.constraintlayout.widget.ConstraintLayout>
```



+ `ConstraintLayout` 태그를 보면 `TextView`와 같이 `ConstraintLayout`만이 아닌 `androidx.constraintlayout.widget.ConstraintLayout`이라고 표시됩니다. 이는 `ConstraintLayout`이 핵심 Android 플랫폼 외에도 추가 기능을 제공하는 코드 라이브러리가 포함된 Android Jetpack의 일부이기 때문입니다. Jetpack에는 앱을 더 쉽게 빌드하는 데 활용할 수 있는 유용한 기능이 있습니다. 이 UI 구성요소는 'androidx'로 시작하므로 Jetpack의 일부인 것을 알 수 있습니다.



+ `xmlns`는 XML 네임스페이스를 나타내고 각 줄은 *스키마*나 이러한 단어와 관련된 속성의 어휘를 정의합니다. 예를 들어 `android:` 네임스페이스는 Android 시스템에서 정의한 속성을 표시합니다. 레이아웃 XML의 속성은 모두 이러한 네임스페이스 중 하나로 시작합니다. 



+ `ConstraintLayout`의 UI 요소에는 `match_parent`를 설정할 수 없습니다. 



### XML로 레이아웃 빌드

+ `RadioGroup`
+ `RadioButton`
+ `Switch`
+ 'start' 및 'end' 제약 조건을 사용하여 왼쪽에서 오른쪽(LTR) 및 오른쪽에서 왼쪽(RTL) 방향 언어를 모두 처리합니다.
+ `View`의 너비를 포함되는 `ConstraintLayout`의 너비와 같게 하려면 시작과 끝을 상위 요소의 시작과 끝으로 제한하고 너비를 0dp로 설정합니다.





## 🎖 Track 5: 팁 계산

### 개요 - 학습할 내용

+ Android 앱의 기본 구조
+ UI에서 값을 읽어 코드에 입력하고 조작하는 방법
+ `findViewById()` 대신 뷰 결합을 사용하여 뷰와 상호작용하는 코드를 더 쉽게 작성하는 방법
+ Kotlin에서 `Double` 데이터 유형을 사용하여 십진수로 작업하는 방법
+ 숫자를 통화 형식으로 지정하는 방법
+ 문자열 매개변수를 사용하여 동적으로 문자열을 만드는 방법
+ Android 스튜디오에서 **Logcat**을 사용하여 앱의 문제를 찾는 방법



### View Binding

+ `findViewById()` 방식은 효과적이지만 앱에 뷰를 더 많이 추가하고 UI가 더 복잡해짐에 따라 `findViewById()`를 사용하는 것이 번거로워질 수 있습니다. Android는 **뷰 결합**이라는 기능을 제공합니다. 사전에 조금만 더 작업하면 뷰 결합을 통해 UI의 뷰에서 메서드를 훨씬 더 쉽고 빠르게 호출할 수 있습니다. Gradle에서 앱의 뷰 결합을 사용 설정하고 몇 가지 코드를 변경해야 합니다.

+ 다음의 코드를 `build.gradle` 파일의 `android` 섹션에 추가합니다. 

  ```kotlin
  buildFeatures {
          viewBinding = true
      }



### 결합 객체 초기화

<img src = "https://user-images.githubusercontent.com/31370590/125413956-9674fa02-f7ac-4de5-a4f0-bdcd9435ece9.PNG " width = "560" height = "400">

+ 앱의 각 `View`마다 `findViewById()`를 호출하는 대신, 결합 객체를 한 번 만들고 초기화합니다.  즉,  `MainActivity`가 뷰 결합을 사용하도록 설정합니다.

  ```kotlin
  class MainActivity : AppCompatActivity() {
  
      lateinit var binding: ActivityMainBinding
  
      override fun onCreate(savedInstanceState: Bundle?) {
          super.onCreate(savedInstanceState)
          binding = ActivityMainBinding.inflate(layoutInflater)
          setContentView(binding.root)
      }
  }
  ```

  + `lateinit var binding: ActivityMainBinding`

    `lateinit` 키워드는 새로운 키워드로, 코드가 변수를 사용하기 전에 먼저 초기화할 것임을 확인해 줍니다. 변수를 초기화하지 않으면 앱이 비정상 종료됩니다.

  

  + `binding = ActivityMainBinding.inflate(layoutInflater)`

     `activity_main.xml` 레이아웃에서 `Views`에 액세스하는 데 사용할 `binding` 객체를 초기화합니다.

  

  + `setContentView(binding.root)`

    활동의 콘텐츠 뷰를 설정합니다. 다음 코드는 레이아웃의 리소스 ID인 `R.layout.activity_main`을 전달하는 대신, 앱의 뷰 계층 구조 루트인 `binding.root`를 지정합니다.

  

+ 이제 앱에서 `View`에 대한 참조가 필요한 경우 `findViewById()`를 호출하는 대신 `binding` 객체에서 뷰 참조를 가져올 수 있습니다. `binding` 객체는 ID가 있는 앱의 모든 `View`를 위한 참조를 자동으로 정의합니다. 뷰 결합을 사용하는 것이 훨씬 더 간결해서 `View`를 위한 참조를 유지할 변수를 만들 필요조차 없으며 결합 객체에서 직접 뷰 참조를 사용하기만 하면 됩니다.

  ```kotlin
  // Old way with findViewById()
  val myButton: Button = findViewById(R.id.my_button)
  myButton.text = "A button"
  
  // Better way with view binding
  val myButton: Button = binding.myButton
  myButton.text = "A button"
  
  // Best way with view binding and no extra variable
  binding.myButton.text = "A button"
  ```

  

> 결합 클래스의 이름은 XML 파일의 이름을 카멜 표기법으로 변환하고 이름 끝에 'Binding'을 추가하여 생성됩니다. 마찬가지로 각 뷰를 위한 참조는 밑줄을 삭제하고 뷰 이름을 카멜 표기법으로 변환하여 생성됩니다. 예를 들어 `activity_main.xml`은 `ActivityMainBinding`이 되고 `binding.textView`로 `@id/text_view`에 액세스할 수 있습니다.





### 팁 계산

```kotlin
fun calculateTip() {
        val stringInTextField = binding.costOfService.text.toString()
        val cost  =  stringInTextField.toDouble()

        val selectedId = binding.tipOptions.checkedRadioButtonId

        val tipPercentage = when (selectedId) {
            R.id.option_twenty_percent -> 0.20
            R.id.option_eighteen_percent -> 0.18
            else -> 0.15
        }

        var tip = tipPercentage * cost

        val roundUp = binding.roundUpSwitch.isChecked
        if (roundUp) {
            tip = kotlin.math.ceil(tip)
        }

        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)

        binding.tipResult.text = getString(R.string.tip_amount, formattedTip)

    }
```





### 테스트 및 디버그

+ `calculateTip()` 메서드에서 정보가 앱을 통해 어떻게 이동하는지와 각 단계에서 어떤 문제가 발생할 수 있을지 

  

+ null

  + *Null*은 '값 없음'을 의미하는 특수 값으로, 값이 `0.0`인 `Double` 또는 문자 수가 0개인 빈 `String`(즉, `""`)과는 다릅니다. `Null`은 값이 없거나 `Double`이 없거나 `String`이 없음을 의미합니다. 많은 메서드가 값을 예상하고 `null`을 처리하는 방법을 몰라서 중지됩니다. 즉, 앱이 비정상 종료됩니다. 따라서 Kotlin은 `null`이 사용되는 위치를 제한하려고 합니다.
  + 앱은 `toDoubleOrNull()`에서 `null`이 반환되는지 확인하여 null이 반환되는 경우 다른 방식으로 처리할 수 있습니다. 따라서 앱이 비정상 종료되지 않습니다.
  + `val cost = stringInTextField.toDoubleOrNull()` 로 변경하고, 이 코드 줄 뒤에 `cost`가 `null`인지 확인하고 그렇다면 메서드에서 반환되는 문을 추가합니다. `return` 명령은 나머지 명령을 실행하지 않고 메서드를 종료하는 것을 의미합니다. 메서드가 값을 반환해야 하는 경우 표현식에서 `return` 명령을 사용하여 값 반환을 지정합니다. 

  ```kotlin
  val cost = stringInTextField.toDoubleOrNull()
  
  if (cost == null) {
      return
  }
  ```

  



### Good coding practice

+ 코드 검사

  **Analyze > Inspect Code... > **

  => private으로 설정 가능

 



## Quiz/Unit2/Pathway1

1. Which of the following is true about class inheritance?

   => 

   + Class inheritance lets you reuse code and makes your program easier to maintain.
   + Properties and functions of the parent class(es) are available to the child class.
   + You can define additional properties and functions that are specific to subclasses.
   + You can override parent class members in subclasses.



2. Which of the following are true about abstract classes?

   => 

   + They can be extended by subclasses and implementations can be provided for abstract members of the class.
   + They may have abstract properties or abstract functions.
   + They are not fully implemented and cannot be instantiated.



3. The  **constructor**  is called when you create an instance of a class.



4. How do you mark a property to be used only inside its current class?

   =>  Use the `private` keyword.



5. Select all answers that are true for this XML layout when displayed on the screen.

   ```kotlin
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

   => 

   + The starting edge of `TextView A` is aligned to the starting edge of the parent view.
   + The tops of `TextView A` and `TextView B` are aligned to top of the parent view.

