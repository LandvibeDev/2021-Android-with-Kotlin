# Unit2-Pathway1



* **Kotlin의 클래스 및 상속**

  * **클래스 계층 구조란 무엇인가요?**
    * 클래스 계층 구조
      * 클래스가 상위 요소와 하위 요소의 계층 구조로 구성된 배열
      * 계층 구조 다이어그램은 일반적으로 상위 요소가 하위 요소 위에 표시된 상태로 그려짐
    * Android 클래스의 상속
      * View > TextView > EditText, Button 등

  * **기본 클래스 만들기**

    * 추상 클래스
      * 완전히 구현되지 않아서 인스턴스화할 수 없는 클래스(스케치)
      * 추상 클래스를 사용하여 클래스(청사진)을 만들고 클래스를 통해 실제 객체 인스턴스를 빌드
      * 속성값과 함수 구현을 알 수 없으면 추상 클래스로 생성
      * 추상 클래스 선언은 `abstract` 키워드로 시작
    * 추상 속성
      * 값이 할당되지 않은 클래스의 멤버 변수
      * 추상 속성 선언은 `abstract` 키워드로 시작
    * 접근 제어자
      * `public` / `private`

  * **서브 클래스 만들기**

    * `class subClass: superClass()` 의 형식으로 선언

    * `constructor` 는 클래스에서 객체 인스턴스를 만들 때 호출

    * `subClass` 의 `constructor` 가 실행되고 상속 관계로 인해 `superClass` 의 `constructor` 가 실행됨

    * 추상 클래스의 모든 서브클래스는 추상 클래스의 추상 함수 및 변수를 모두 제공해야 함

    * 슈퍼클래스의 함수 및 변수에 접근할 때는 `override` 키워드 사용

    * `with`

      * 클래스의 특정 인스턴스로 작업하고 이 인스턴스의 여러 속성과 함수에 액세스해야 한다면 `with` 문을 사용하여 '이 인스턴스 객체로 다음 작업을 모두 실행' 하라고 나타낼 수 있음

        ```kotlin
        with(squareCabin) {
            println("\nSquare Cabin\n============")
            println("Capacity: ${capacity}")
            println("Material: ${buildingMaterial}")
            println("Has room? ${hasRoom()}")
        }
        ```

    * 슈퍼클래스는 `abstract` 나 `open` 키워드가 앞에 붙어있어야 함

    * 서브클래스의 생성자에 슈퍼클래스의 생성자 매개변수가 아닌 다른 변수가 들어갈 경우 `val` 또는 `var` 을 변수 앞에 선언해주어야 함

  * **계층 구조의 클래스 수정**

    * 슈퍼클래스에 추상 함수가 존재할 경우, 모든 서브클래스에서 슈퍼클래스의 추상 함수를 `override` 하여 구현해야 함
    * 슈퍼클래스에 `abstract` 가 아닌 함수를 구현했을 경우, 해당 클래스를 상속받는 모든 서브클래스에서 함수를 사용할 수 있음

* **Android용 XML 레이아웃 만들기**

  * **프로젝트 시작**

    * `RadioGroup` : RadioButton 옵션을 그룹화
    * `RadioButton` : 각 옵션의 선택 가능한 RadioButton
    * `Switch` : 켜기/끄기 전환 버튼

  * **팁 옵션 추가**

    ```xml
        <RadioGroup
            android:id="@+id/tip_options"
            android:checkedButton="@id/option_twenty_percent"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
         		app:layout_constraintTop_toBottomOf="@id/service_question"
            app:layout_constraintStart_toStartOf="parent"
            android:orientation="vertical">
    
            <RadioButton
                android:id="@+id/option_twenty_percent"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="Amazing (20%)" />
    
            <RadioButton
                android:id="@+id/option_eighteen_percent"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="Good (18%)" />
    
            <RadioButton
                android:id="@+id/option_fifteen_percent"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="OK (15%)" />
    ```

  * **나머지 레이아웃 완료**

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

* **팁 계산**

  * **뷰 결합** (View Binding)

    ```kotlin
    // viewBinding을 사용하기 위해서는 아래 코드를 build.gradle에 추가해야 함
    buildFeatures {
        viewBinding = true
    }
    ```

    ```kotlin
    // lateinit: 변수가 사용되기 전에 초기화해줄 것이지만 지금은 초기화하지 않을 때 사용하는 키워드로, 변수가 초기화되지 않고 사용되면 앱이 비정상 종료됨
    lateinit var binding: ActivityMainBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
    	super.onCreate(savedInstanceState)
      // xml에 정의된 Resource를 View 객체로 반환
    	binding = ActivityMainBinding.inflate(layoutInflater)
      // root뷰(레이아웃)을 화면에 표시하도록 설정
    	setContentView(binding.root)
    }
    ```

    * View Binding을 통해 findViewById() 대신 binding 객체에서 뷰 참조를 가져올 수 있음

  * 팁 계산

    * NumberFormat.getCurrencyInstance(Locale.US).format(tip)
      * NumberFormat을 US 달러 형식으로 맞추고 tip을 그 형식에 맞게 변환시킴

  * 테스트 및 디버그

    * toDouble() 은 String이 숫자 형식이 아니거나, 값이 비어있을 때 비정상 종료를 유발할 수 있기 때문에, inputType = numberDecimal과 toDoubleOrNull() 을 사용하면 값이 비어있을 때 처리해줄 수 있음



### Quiz

1. **Which of the following is true about class inheritance?**
   * Class inheritance lets you reuse code and makes your program easier to maintain.
   * Properties and functions of the parent class(es) are available to the child class.
   * You can define additional properties and functions that are specific to subclasses.
   * You can override parent class members in subclasses.
2. **Which of the following are true about abstract classes?**
   * They can be extended by subclasses and implementations can be provided for abstract members of the class.
   * They may have abstract properties or abstract functions.
   * They are not fully implemented and cannot be instantiated.

3. **Fill-in-the-blanks**

   The `constructor` is called when you create an instance of a class.

4. **How do you mark a property to be used only inside its current class?**
   * Use the `private` keyword.
5. **Select all answers that are true for this XML layout when displayed on the screen. (You can sketch this out on a piece of paper first, if that helps.)**
   * The starting edge of `TextView A` is aligned to the starting edge of the parent view.
   * The tops of `TextView A` and `TextView B` are aligned to top of the parent view.