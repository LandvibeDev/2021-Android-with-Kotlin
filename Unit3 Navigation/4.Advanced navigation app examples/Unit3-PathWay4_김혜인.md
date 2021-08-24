# 2021 Landvibe Summer Coding - Android

## Unit3 : Navigation

### PathWay4 : Advanced navigation app examples



##### :rocket: Shared ViewModel

- **공유 ViewModel**

  :arrow_forward: 앱의 데이터를 단일 ViewModel에 저장

  - OrderViewModel 만들기

    :key: `ViewModel`에서는 뷰 모델 데이터를 `public` 변수로 노출하지 *않는* 것이 좋다.

    ``````kotlin
    class OrderViewModel : ViewModel() {
        private val _quantity = MutableLiveData<Int>(0)
        val quantity: LiveData<Int> = _quantity
    
        private val _flavor = MutableLiveData<String>("")
        val flavor: LiveData<String> = _flavor
    
        private val _date = MutableLiveData<String>("")
        val date: LiveData<String> = _date
    
        private val _price = MutableLiveData<Double>(0.0)
        val price: LiveData<Double> = _price
        
        //setter 메서드는 ㅠ 모델 외부에서 호출되어야 하므로 public(기본)으로 둔다
        fun setQuantity(numberCupcakes: Int) {
            _quantity.value = numberCupcakes
        }
    
        fun setFlavor(desiredFlavor: String) {
            _flavor.value = desiredFlavor
        }
    
        fun setDate(pickupDate: String) {
            _date.value = pickupDate
        }
    }
    ``````

  ***

  - **ViewModel을 사용하여 UI 업데이트**

    - 공유 뷰 모델을 사용하려면 ** `viewModels()` 대리자 클래스 대신 `activityViewModels()`를 사용하여 초기화**

      - `viewModels()`
        - 현재 프래그먼트로 범위가 지정된 `ViewModel` 인스턴스를 제공
        - 인스턴스는 프래그먼트마다 다릅니다.
      - `activityViewModels()`
        - 현재 활동으로 범위가 지정된 `ViewModel` 인스턴스를 제공
        - 인스턴스는 동일한 활동의 여러 프래그먼트 간에 동일하게 유지됩니다.

      ``````kotlin
      private val sharedViewModel: OrderViewModel by activityViewModels()
      
      fun orderCupcake(quantity: Int) {
          sharedViewModel.setQuantity(quantity)
          if (sharedViewModel.hasNoFlavorSet()) {
              sharedViewModel.setFlavor(getString(R.string.vanilla))
          }
          findNavController().navigate(R.id.action_startFragment_to_flavorFragment)
      }
      
      fun hasNoFlavorSet(): Boolean {
          return _flavor.value.isNullOrEmpty()
      }
      ``````

  ***

  - **데이터 결합 & ViewModel**

    - **데이터 결합**
      - Android Jetpack의 구성요소
      - 선언적 형식을 사용하여 레이아웃의 UI 구성요소를 앱의 데이터 소스에 결합
      - 결합을 설정하고 업데이트를 자동으로 설정하면 코드에서 UI를 직접 업데이트 하는 것을 잊은 경우 오류 발생 가능성을 줄일 수 있다

    ``````kotlin
    <layout ...>
    
        <data>
            <variable
                name="viewModel"
                type="com.example.cupcake.model.OrderViewModel" />
        </data>
    
        <ScrollView ...>
    
        ...
    ``````

    ``````kotlin
    //뷰 모델 인스턴스를 레이아웃의 공유 뷰 모델 인스턴스와 결합
    binding?.apply {
        viewModel = sharedViewModel
        ...
    }
    ``````

    - apply 범위 함수

      - 객체의 컨텍스트 내에서 코드 블록을 실행, 임시 범위 형성
      - 이 범위에서 이름을 사용하지 않고 객체에 액세스 가능

      ex) 객체 구성

      ``````kotlin
      clark.apply {
          firstName = "Clark"
          lastName = "James"
          age = 18
      }
      
      // The equivalent code without apply scope function would look like the following.
      
      clark.firstName = "Clark"
      clark.lastName = "James"
      clark.age = 18
      ``````

    - **리스너 결합**
      - `onClick`이벤트와 같은 이벤트가 발생할 때 실행되는 람다 표현식
      - 임의의 데이터 결합 표현식을 실행할 수 있다.

    ``````kotlin
    <RadioGroup
       ...>
    
       <RadioButton
           android:id="@+id/vanilla"
           ...
           android:onClick="@{() -> viewModel.setFlavor(@string/vanilla)}"
           .../>
    
       <RadioButton
           android:id="@+id/chocolate"
           ...
           android:onClick="@{() -> viewModel.setFlavor(@string/chocolate)}"
           .../>
    
       <RadioButton
           android:id="@+id/red_velvet"
           ...
           android:onClick="@{() -> viewModel.setFlavor(@string/red_velvet)}"
           .../>
    
       <RadioButton
           android:id="@+id/salted_caramel"
           ...
           android:onClick="@{() -> viewModel.setFlavor(@string/salted_caramel)}"
           .../>
    
       <RadioButton
           android:id="@+id/coffee"
           ...
           android:onClick="@{() -> viewModel.setFlavor(@string/coffee)}"
           .../>
    </RadioGroup>
    ``````

  ***

  - **날짜 형식 지정**

    - `SimpleDateFormat`

      - 날짜 형식을 지정하고 파싱하는 클래스

      - 날짜의 형식 지정(날짜 → 텍스트) 및 파싱(텍스트 → 날짜)이 가능

      - `SimpleDateFormat("E MMM d", Locale.getDefault())`

        ex) 2018년 1월 4일 :arrow_forward: `"Wed, Jul 4"`

      - `Locale`

        - 특정한 지리적, 정치적 또는 문화적 지역을 나타낸다.
        - `Locale.getDefault()` : 사용자의 기기에 설정된 언어 정보를 가져옴

    ``````kotlin
    private fun getPickupOptions(): List<String> {
       	val options = mutableListOf<String>()
       	val formatter = SimpleDateFormat("E MMM d", Locale.getDefault())
       	//현재 날짜 및 시간
        val calendar = Calendar.getInstance()
     
        //4개의 날짜 옵션
       	repeat(4) {
            //날짜 형식 지정하여 날짜 옵션 목록에 추가한 후 캘린더 1씩 증가
           	options.add(formatter.format(calendar.time))
           	calendar.add(Calendar.DATE, 1)
       	}
        //업데이트 된 options반환
       	return options
    }
    ``````

  ***

  - 뷰 모델에서 가격 업데이트

    ``````kotlin
    private const val PRICE_PER_CUPCAKE = 2.00
    private const val PRICE_FOR_SAME_DAY_PICKUP = 3.00
    
    class OrderViewModel : ViewModel() {
    	private fun updatePrice() {
        	var calculatedPrice = (quantity.value ?: 0) * PRICE_PER_CUPCAKE
        
            if (dateOptions[0] == _date.value) {
                calculatedPrice += PRICE_FOR_SAME_DAY_PICKUP
            }
            _price.value = calculatedPrice
    	}
        
        fun setQuantity(numberCupcakes: Int) {
            _quantity.value = numberCupcakes
            updatePrice()
        }
        
        fun setDate(pickupDate: String) {
            _date.value = pickupDate
            updatePrice()
        }
    }
    ``````

    - elvis 연산자 (`?:`)
      - 왼쪽의 표현식이 null이 아니면 이 값을 사용한다.
      - 왼쪽의 표현식이 null이면 오른쪽에 있는 표현식을 사용

  ***

  - **LiveData를 관찰하도록 수명 주기 소유자 설정**

    - `LifecycleOwner`

      - acitivity나 fragment와 같이 Android수명주기를 보유한 클래스

      :key: UI 요소 자동 업데이트 :arrow_forward:  `binding.lifecycleOwner`

    - `LiveData` 관찰자

      - 수명주기 소유자가 활성 상태인 경우에만 앱 데이터의 변경사항을 관찰



***



##### :rocket: Navigation and the backstack

- **Up 버튼**

  : 이전 화면으로 돌아가는 화살표

  ``````kotlin
  class MainActivity : AppCompatActivity(R.layout.activity_main) {
  
      private lateinit var navController: NavController
  
      override fun onCreate(savedInstanceState: Bundle?) {
          super.onCreate(savedInstanceState)
  
          val navHostFragment = supportFragmentManager
                  .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
          navController = navHostFragment.navController
  
          setupActionBarWithNavController(navController)
      }
      
      override fun onSupportNavigateUp(): Boolean {
          //위로 이동을 처리하도록 navController에 요청
         return navController.navigateUp() || super.onSupportNavigateUp()
      }
  }
  ``````



- **작업 및 백 스택**

  - **작업**

    : 사용자가 특정한 일을 할 때 상호작용하는 활동의 모음

    - activity는 작업 내에 존재한다.
      - activity는 *백 스택*이라는 스택으로 배열 된다.
      - 방문하는 각각의 새 activity는 작업의 백 스택으로 푸시된다.
      - 스택 맨 위의 활동 : 현재 상호작용하고 있는 활동
      - 스택 아리 활동 : 백그라운드로 전환되었다가 중지됨

    <img src="img/Unit3-Pathway4-1_hyein.png" width="30%" align="left">

  - **백 스택**
    - 사용자가 뒤로 이동하는 경우 유용
    - 스택에서 활동을  pop하고 사용자가 상호작용할 수 있게 이전 활동이 포그라운드로 이동
    - 백 스택에 더 이상 활동이 남아있지 않으면 사용자는 기기의 런처 화면이나 이 활동을 실행한 앱으로 돌아가게 된다.



***



##### :rocket: Quiz

1. True or False: You can use the same ViewModel for multiple Activities or Fragments to share data.
   - True



2. What is the correct way to access the shared view model using the Kotin property delegate approach?
   - `val viewModel: OrderViewModel by activityViewModels()`



3. Fill-in-the-blanks

   *Enter one or more words to complete the sentence.*

   Use a LiveData `Transformations` to return a different LiveData instance based on the value of another instance.



4. How can the `apply` function in Kotlin be used to configure an object?
   - It can apply a set of assignments to the object.



5. Using a data binding layout expression, what’s the correct syntax for adding an attribute to the button in this layout in order to bind a click listener to it?

   ``````kotlin
   <Button
       android:id="@+id/next_button"
       android:layout_width="wrap_content"
       android:layout_height="wrap_content"
       android:text="@string/next" />
   ``````

   - `android:onClick="@{() -> detailFragment.next()}"`