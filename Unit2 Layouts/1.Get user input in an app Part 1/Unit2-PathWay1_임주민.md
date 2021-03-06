# π‘ Android Basics in Kotlin

## Unit #2 : Layouts

## PATHWAY #1 : Get user input in an app: Part 1



<br/>



### π μ½νλ¦°μ ν΄λμ€μ©μ΄

- ν΄λμ€ κ³μΈ΅ κ΅¬μ‘° : ν΄λμ€κ° μμμ νμ μμμ κ³μΈ΅ κ΅¬μ‘°λ‘ κ΅¬μ±
- νμ ν΄λμ€ λλ μλΈν΄λμ€ λλ κΈ°λ³Έ ν΄λμ€ : κ³μΈ΅ κ΅¬μ‘°μμ λ€λ₯Έ ν΄λμ€ μλμ μλ λͺ¨λ  ν΄λμ€
- λ£¨νΈ λλ μ΅μμ ν΄λμ€ : ν΄λμ€ κ³μΈ΅ κ΅¬μ‘°μ μ΅μμμ μλ ν΄λμ€
- μμ : νμ ν΄λμ€κ° μμ ν΄λμ€μ λͺ¨λ  μμ±κ³Ό λ©μλ ν¬ν¨ νΉμ μμλ°λ κ²½μ°. μ½λ κ³΅μ μ μ¬μ¬μ© κ°λ₯μΌλ‘ νλ‘κ·Έλ¨ μ½κ² νμνκ³  μ μ§κ°λ₯
- μΆμ ν΄λμ€ : μμ ν κ΅¬νλμ§ μμ μΈμ€ν΄μ€νν  μ μλ ν΄λμ€, `abstract` ν€μλ μ¬μ© -> λμ€μ κ°κ³Ό κ΅¬νμ μ κ³΅νκ² λ€λ μ½μ
- ex) View > TextView > EditText, Button



<br/>



### π μ£Όν ν΄λμ€ - μΆμν΄λμ€ μ¬μ©

* Dwelling : λͺ¨λ  μ£Όνμ κ³΅ν΅μΌλ‘ μ μ©λλ μ λ³΄λ₯Ό λ΄κ³  μλ κ΅¬μ²΄μ μ΄μ§ μμ κΈ°λ³Έμ§ν΄λμ€

  * ```kotlin
    abstract class Dwelling(private var residents : Int) {
    	abstract val buildingMaterial : String 
      abstract val capacity : Int 
      //abstract ν€μλ μ¬μ©ν΄μ μμ±μ΄ μ¬κΈ°μ μ μλμ§ μμμ λνλ
      
      fun hasRoom() : Boolean {
        return residents < capacity
      }
      abstract fun floorArea() : Double {
        // μλΈ ν΄λμ€μμ ν¨μ κ΅¬ν 
      }
      fun getRoom() {
        if (capacity > residents) {
          residents++
          println("You got a room!")
        } else {
          println("Sorry, at capacity and no romms left.")
        }
      }
    }
    // λ©μΈ ν¨μμμ μΈμ€ν΄μ€ λ§λ€κΈ° λΆκ°λ₯
    
    ```

* SquareCabin : μ μ¬κ°ν ν΅λλ¬΄μ§ (μλΈν΄λμ€)

  * ```kotlin
    class SquareCabin(residents : Int, val length : Double) : Dwelling(residents) {
      override val buildingMaterial = "Wood"
      override val capacity = 6
    	override fun floorArea() : Double {
        return length*length
      }
    }
    ```

* `with`λ₯Ό μ¬μ©νμ¬ μ½λ λ¨μν 

  * ```kotlin
    // mainμμ μΈμ€ν΄μ€ μμ±ν μ΄ν
    
    with (squareCabin) {
    	// all operations to do with instanceName
    	println("\nSquare Cabin\n============")
      println("Capacity: ${capacity}")
      println("Material: ${buildingMaterial}")
      println("Has room? ${hasRoom()}")
    }
    ```

* RoundHut : μν μ§ μ€λλ§ (μλΈν΄λμ€)

  * ```kotlin
    class RoundHut(residents: Int, val radius : Double) : Dwelling(residents) {
        override val buildingMaterial = "Straw"
        override val capacity = 4
        override fun floorArea() : Double {
          	return PI*radius*radius
            // PIμ¬μ©νκΈ° μν΄μλ import kotlin.math.PIλ₯Ό μ¨μ€μΌν¨ 
        }
      	fun calculateMaxCarpetSize(): Double {
        	val diameter = 2 * radius
        	return sqrt(diameter * diameter / 2)
    		}
    }
    ```

* RoundTower : μν λ μ€λλ§ (RoundHutμ μλΈν΄λμ€)

  * `open` ν€μλλ₯Ό μ¬μ©νμ¬ μμλ  μ μλλ‘ λ³κ²½ (μ½νλ¦°μμλ `open`,  `abstract`ν΄λμ€μμλ§ μμν  μ μλ€.)

  * `super` ν€μλλ‘ μνΌν΄λμ€ κ΅¬ν : μμν΄λμ€μ μ μλ ν¨μ νΈμΆ

    ```kotlin
    open class RoundTower(residents: Int, radius : Double, val floors: Int = 2) : RoundHut(residents, radius) {
        override val buildingMaterial = "Stone"
        override val capacity = 4*floors
      
      	// floorArea() κ΅¬ν μν΄λλ¨. μμλ°λ μμν΄λμ€μ μΈμλ§ κ°λλ‘ μ€μ ν΄μ£ΌκΈ°
      	// μ¬μ μλ κ°λ₯
      	override fun floorArea() : Double {
          	return super.floorArea()*floors
        }
    }
    ```

<br/>

### π XML

* νμ₯μ± λ§ν¬μ μΈμ΄λ‘ νμ€νΈ κΈ°λ° λ¬Έμ μ¬μ©νμ¬ λ°μ΄ν°λ₯Ό μ€λͺνλ λ°©λ²

* `activity_main.xml`μμ μ€λ₯Έμͺ½ μλ¨ `Code`ν΄λ¦­

* νμμμλ‘ μΆκ°νλ €λ©΄, μλ¨ μμμ μμνκ·Έμ μ’λ£νκ·Έ μ¬μ΄μ μΆκ°

* λ€μ¬μ°κΈ°(κ°λμ± up)μ νκ·Έ νμΈ

* XMLμ μ£Όμ μΆκ° : `<!--`λ‘ μμ `-->`λ‘ λλλ€

  ```xml
  <!--1λ²μ§Έ λ°©λ²-->
  <TextView		
      android:text="Hello World!"
  />
  <!--2λ²μ§Έ λ°©λ²-->
  <TextView		
      android:text="Hello World!"
  ></TextView>
  <!--3λ²μ§Έ λ°©λ²-->
  <TextView		
      android:text="Hello World!" />
  ```

  

<br/>



### π XMLλ‘ ν μ΄ν λ μ΄μμ μμ 

* `ConstraintLayout`μ κ° νμ μμμλ μΈλ‘ λ° κ°λ‘ μ μ½ μ‘°κ±΄ νμ

  * `layout_constraint<Source>_to<Target>Of ` μμ 3κ°μ§

  ```xml
  app:layout_constraintEnd_toEndOf="parent"
  app:layout_constraintStart_toStartOf="parent"
  app:layout_constraintTop_toBottomOf="@id/tip_options"
  ```

* EditText μΆκ°

  * νμ€νΈ μλ ₯ or μμ 
  * `android:inputType`μμ±μΌλ‘ μλ ₯λμ μλ ₯ν  μ μλ νμ€νΈ μ ν μ ν

  ```xml
  <EditText
     	   android:id="@+id/cost_of_service"
      	 android:layout_width="160dp" 
      	 android:layout_height="wrap_content" 
      	 android:inputType="numberDecimal"   
      	 android:hint="Cost of Service"
     	   app:layout_constraintStart_toStartOf="parent"
      	 app:layout_constraintTop_toTopOf="parent"
  />	
  ```

* TextView μΆκ°

  ```xml
  <TextView
          android:id="@+id/service_question"
          android:layout_width="wrap_content"
          android:layout_height="wrap_content"
          android:text="How was the service?"
          app:layout_constraintStart_toStartOf="parent"
       	  app:layout_constraintTop_toBottomOf="@id/cost_of_service" />
  ```

* RadioButtons μΆκ°

  * `RadioGroup`μΌλ‘ κ·Έλ£Ήν, λ² νμ μΈ μ΅μ λͺ©λ‘ μμ±

  ```xml
  <RadioGroup
          android:id="@+id/tip_options"
          android:checkedButton="@id/option_twenty_percent"
          android:layout_width="wrap_content"
          android:layout_height="wrap_content"
          android:orientation="vertical"
          app:layout_constraintStart_toStartOf="parent"
          app:layout_constraintTop_toBottomOf="@id/service_question"></RadioGroup>
  
  		<RadioButton
         android:id="@+id/option_twenty_percent"
         android:layout_width="wrap_content"
         android:layout_height="wrap_content"
         android:text="Amazing (20%)" />
  		<!--λ€λ₯Έ λ²νΌλ λμΌνκ² μΆκ°-->
  
  </RadioGroup>
  ```

* Switch μμ ― - ν λ°μ¬λ¦Ό μ¬λΆ

  * λ μ΅μ κ°μ μ νκ°λ₯
  * `android:text`λ₯Ό μ¬μ©νμ¬ λΌλ²¨ μΆκ°(`TextView` μ¬μ©μν΄λ κΈμμΆκ° κ°λ₯)

  ```xml
  <Switch
      android:id="@+id/round_up_switch"
      android:layout_width="0dp"
      android:layout_height="wrap_content"
      android:checked="true"
      android:text="Round up tip?"
      app:layout_constraintEnd_toEndOf="parent"
      app:layout_constraintStart_toStartOf="parent"
      app:layout_constraintTop_toBottomOf="@id/tip_options" />
  ```

* κ³μ°λ²νΌκ³Ό νμ€νΈ μΆκ°

  ```xml
  <Button
          android:id="@+id/calculate_button"
          android:layout_width="0dp"
          android:layout_height="wrap_content"
          android:text="Calculate"
          app:layout_constraintTop_toBottomOf="@id/round_up_switch"
          app:layout_constraintStart_toStartOf="parent"
          app:layout_constraintEnd_toEndOf="parent" />
  
  <TextView
          android:id="@+id/tip_result"
          android:layout_width="wrap_content"
          android:layout_height="wrap_content"
          app:layout_constraintEnd_toEndOf="parent"
          app:layout_constraintTop_toBottomOf="@id/calculate_button"
          android:text="Tip Amount" />
  
  ```

  

<br/>



### π λ·°κ²°ν©

* Gradle Scripts > build.gradle (Module: Tip_Time.app) > android μΉμμ μΆκ°ν ν Sync Now

  ```kotlin
  buildFeatures {
      viewBinding = true
  }
  ```

* app > java > com.example.tiptime > MainActivity

  * `lateinit` : μ½λκ° λ³μλ₯Ό μ¬μ©νκΈ° μ μ λ¨Όμ  μ΄κΈ°νν  κ²μμ νμΈν΄μ€λ€. μ΄κΈ°ν μνλ©΄ μ±μ΄ λΉμ μ μ’λ£λλ€.

  ```kotlin
  class MainActivity : AppCompatActivity() {
  		// κ²°ν© κ°μ²΄μ μ΅μμ λ³μ μ μΈ
      private lateinit var binding: ActivityMainBinding
  		
      override fun onCreate(savedInstanceState: Bundle?) {
          super.onCreate(savedInstanceState)
        	// Viewμ μ‘μΈμ€νλ λ° μ¬μ©ν  bindingκ°μ²΄ μ΄κΈ°ν
          binding = ActivityMainBinding.inflate(layoutInflater)
        	//νλμ μ½νμΈ  λ·° μ€μ 
          setContentView(binding.root)
      }
  }
  ```

  *  `View`μ λν μ°Έμ‘°κ° νμν κ²½μ° `findViewById()`νΈμΆ λμ  `binding` κ°μ²΄μμ λ·° μ°Έμ‘°λ₯Ό κ°μ Έμ€κΈ° κ°λ₯. `binding` κ°μ²΄λ ID μλ μ±μ λͺ¨λ  `View`λ₯Ό μν μ°Έμ‘°λ₯Ό μλμΌλ‘ μ μ. 
  * λ·° κ²°ν©μ μ¬μ©νλ κ²μ΄ ν¨μ¬ λ κ°κ²°ν΄μ  `View`λ₯Ό μν μ°Έμ‘°λ₯Ό μ μ§ν  λ³μ μμ± νμ X, κ²°ν© κ°μ²΄μμ μ§μ  λ·° μ°Έμ‘°λ₯Ό μ¬μ©

  ```kotlin
  // Old way with findViewById()
  val myButton: Button = findViewById(R.id.my_button)
  myButton.text = "A button"
  
  // Best way with view binding and no extra variable
  binding.myButton.text = "A button"
  ```



<br/>



### π ν κ³μ°

* onCreate()μμ 

  ```kotlin
  override fun onCreate(savedInstanceState: Bundle?) {
          super.onCreate(savedInstanceState)
          binding = ActivityMainBinding.inflate(layoutInflater)
          setContentView(binding.root)
          binding.calculateButton.setOnClickListener{ calculateTip() }
  }
  ```

* calculateTip()

  * `%s`  λ¬Έμμ΄ λ§€κ°λ³μλ₯Ό μ¬μ©νμ¬ λ€λ₯Έ μΈμ΄λ‘ μ½κ² λ³νν  μ μλ λμ  λ¬Έμμ΄ μμ± κ°λ₯

  ```kotlin
  private fun calculateTip() {
          // μλΉμ€ λΉμ© κ°μ Έμ€κΈ° - toString()ν΄μ£Όμ΄μΌ toDouble()μ΄ κ°λ₯
          val stringInTextField = binding.costOfService.text.toString()
          val cost = stringInTextField.toDoubleOrNull()
    			// μμΈμ²λ¦¬
    			if (cost==null || cost==0.0) {
              displayTip(0.0)
              return
          }
          // μ νν ν λΉμ¨ κ°μ Έμ€κΈ°
          val tipPercentage = when (binding.tipOptions.checkedRadioButtonId) {
              R.id.option_twenty_percent -> 0.20
              R.id.option_eighteen_percent -> 0.18
              else -> 0.15
          }
          // var μ¬μ©ν μ  μ μ - κ° λ°μ¬λ¦Όν  μ μμ΄μΌ ν¨
          var tip = tipPercentage * cost
          if (binding.roundUpSwitch.isChecked) {
              tip = kotlin.math.ceil(tip) //ν μν ν λΉ
          }
          displayTip(tip)
  }
  private fun displayTip(tip : Double) {
          val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
          binding.tipResult.text = getString(R.string.tip_amount, formattedTip)
  }
  ```

<br/>



### π ν΄μ¦

1. Which of the following is true about class inheritance?

   > Class inheritance lets you reuse code and makes your program easier to maintain.
   >
   > Properties and functions of the parent class(es) are available to the child class.
   >
   > You can define additional properties and functions that are specific to subclasses.
   >
   > You can override parent class members in subclasses.

2. Which of the following are true about abstract classes?

   > They can be extended by subclasses and implementations can be provided for abstract members of the class.
   >
   > They may have abstract properties or abstract functions.
   >
   > They are not fully implemented and cannot be instantiated.

3. The is [                  ] called when you create an instance of a class.

   > constructor

4. How do you mark a property to be used only inside its current class?

   > Use the private keyword

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

   > The starting edge of `TextView A` is aligned to the starting edge of the parent view.
   >
   > The tops of `TextView A` and `TextView B` are aligned to top of the parent view.