# 🔥 Unit 3 : Navigation

## Pathway 4 : Advanced navigation app examples

-----

### <div align="center">목차</div>

- [Shared ViewModel](#Shared-ViewModel)
  - [탐색 그래프 완성하기](#탐색-그래프-완성하기)
  - [공유 ViewModel 만들기](#공유-ViewModel-만들기)
  - [ViewModel을 사용하여 UI 업데이트](#ViewModel을-사용하여-UI-업데이트)
  - [데이터 결합과 함께 ViewModel 사용](#데이터-결합과-함께-ViewModel-사용)
  - [Pickup 및 Summary 프래그먼트를 업데이트하여 뷰 모델 사용](#Pickup-및-Summary-프래그먼트를-업데이트하여-뷰-모델-사용)
  - [주문 세부 정보에서 가격 계산](#주문-세부-정보에서-가격-계산)
  - [리스너 결합을 사용하여 클릭 리스너 설정](#리스너-결합을-사용하여-클릭-리스너-설정)
- [Navigation and backstack](#-Navigation-and-backstack)
  + [작업 및 백스택 알아보기](#작업-및-백스택-알아보기)
  + [주문 전송하기](#주문-전송하기)

------

## <div align="center">🎖 Shared ViewModel</div>

### 학습할 내용

+ 고급 사용 사례 내에서 권장 앱 아키텍쳐 사례를 구현하는 방법
+ `Shared ViewModel`을 사용하여 동일한 activity의 fragment 간에 데이터를 공유하는 방법 
+  LiveData 변환 

<br></br>

<br></br>

### 앱 개요

`MainActivity.kt`

```kotlin
class MainActivity : AppCompatActivity(R.layout.activity_main)
```

이는 액티비티의 콘텐츠 뷰를 `activity_main.xml`로 설정하는 기본 생성 코드와 유사하다. 이 코드는 `super.onCreate(savedInstanceState)`의 일부로 확장될 레이아웃을 포함하는 매개변수화된 생성자 `AppCompatActivity(@LayoutRes int contentLayoutId)`를 사용합니다.

<br></br>

<br></br>

기본 `AppCompatActivity` 생성자를 사용하는 코드

```kotlin
class MainActivity : AppCompatActivity() {

   override fun onCreate(savedInstanceState: Bundle?) {
       super.onCreate(savedInstanceState)
       setContentView(R.layout.main_activity)
   }
}
```

<br></br>

<br></br>

### 탐색 그래프 완성하기

+ `nav_graph.xml`에서 각 프래그먼트 간 액션(화살표) 설정하기

+ start 프래그먼트에서 flavor 프래그먼트로 이동

  `startFragment.kt`

  ```kotlin
  fun orderCupcake(quantity: Int) {
          findNavController().navigate(R.id.action_startFragment_to_flavorFragment)
      }
  ```

  `startFragment`의 각 버튼마다 클릭 리스너가 설정되어 있고, 각 **버튼을 탭하면** 해당되는 컵케이크의 수량을 매개변수로 사용하여** `orderCupcake()` 메서드가 호출**되도록 되어있습니다. 

  이 `orderCupcake()` 메서드를  **flavor 프래그먼트로 이동**하는 코드로 바꿉니다.

  `findNavController()` 메서드를 사용하여 `NavController`를 가져오고 거기에서 `navigate()`를 호출하여 작업 ID인 `R.id.action_startFragment_to_flavorFragment`를 전달합니다. 이 작업 ID가 `nav_graph.xml.`에 선언된 작업과 일치하는지 확인합니다.

+ flavor와 pickup 프래그먼트에도 탐색 추가

  `FlavorFragment.kt`

  ```kotlin
  fun goToNextScreen() {
      findNavController().navigate(R.id.action_flavorFragment_to_pickupFragment)
  }
  ```

  `PickupFragment.kt`

  ```kotlin
  fun goToNextScreen() {
      findNavController().navigate(R.id.action_pickupFragment_to_summaryFragment)
  }
  ```

<br></br>

<br></br>

### 공유 ViewModel 만들기

+ 공유 `ViewModel`을 사용하여 앱의 데이터를 단일 `ViewModel`에 저장하고 **앱의 여러 프래그먼트는 activity 범위를 사용하여 공유 `ViewModel`에 액세스**합니다. 
+ `ViewModel`은 Android architecture 구성요소의 일부입니다. `ViewModel` 내에 저장된 앱 데이터는 **구성 변경 중에도 유지**됩니다. 

+ `OrderViewModel 만들기`

  **com.example.cupcake.model > New > Package**에서 `com.example.cupcake.model`이름의 패키지를 생성하고 `model` 패키지에서 `OverViewModel` Kotlin class를 생성합니다. 

  ```kotlin
  class OverViewModel : ViewModel() {
      private val _quantity = MutableLiveData<Int>(0)
      val quantity: LiveData<Int> = _quantity
  
      private val _flavor = MutableLiveData<String>("")
      val flavor: LiveData<String> = _flavor
  
      private val _date = MutableLiveData<String>("")
      val date: LiveData<String> = _date
  
      private val _price = MutableLiveData<Double>(0.0)
      val price: LiveData<Double> = _price
  
  
  
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
  ```

<br></br>

<br></br>

### ViewModel을 사용하여 UI 업데이트

shared view model 구현의 주요 차이점 : UI 컨트롤러에서 뷰 모델에 액세스하는 방식

액티비티 인스턴스 사용

뷰 모델을 여러 프래그먼트 간에 공유할 수 있음. **각 프래그먼트는 뷰 모델에 액세스**하여 주문의 일부 세부정보를 확인하거나 뷰 모델의 일부 데이터를 업데이트할 수 있습니다. 

<br></br>

<br></br>

#### ViewModel을 사용하도록 StartFragment 업데이트

`StartFragment`에서 공유 뷰 모델을 사용하려면 `viewModels()` 대리자 클래스 대신 `activityViewModels()`를 사용하여 `OrderViewModel`을 초기화합니다.

+ ** `viewModels()`는** **현재 프래그먼트로 범위가 지정된 `ViewModel` 인스턴스를 제공**합니다. 따라서 인스턴스는 프래그먼트마다 다릅니다.
+ ** `activityViewModels()`**는 **현재 activity로 범위가 지정된 `ViewModel` 인스턴스를 제공**합니다. 따라서 인스턴스는 동일한 액티비티의 여러 프래그먼트 간에 동일하게 유지됩니다.

<br></br>

<br></br>

#### kotlin 속성 위임 사용

Kotlin에는 각 변경 가능한(`var`) 속성에 자동으로 생성되는 기본 getter 및 setter 함수가 있습니다. 값을 할당하거나 속성의 값을 읽을 때 setter 및 getter 함수가 호출됩니다. (읽기 전용 속성(`val`)의 경우 기본적으로 getter 함수만 생성됩니다. 읽기 전용 속성의 값을 읽을 때 이 getter 함수가 호출됩니다.)

Kotlin에서 속성 위임을 사용하면 **getter-setter 책임을 다른 클래스에 넘길 수 있습니다. 이 클래스(*대리자 클래스*라고 함)는 속성의 getter 및 setter 함수를 제공하고 변경사항을 처리합니다.**

대리자 속성은 다음과 같이 `by` 절 및 대리자 클래스 인스턴스를 사용하여 정의됩니다.

```
// Syntax for property delegation
var <property-name> : <property-type> by <delegate-class>()
```

<br></br>

<br></br>

1. `StartFragment` 클래스에서 공유 뷰 모델의 참조를 클래스 변수로 가져옵니다. `fragment-ktx` 라이브러리의 `by activityViewModels()` Kotlin 속성 위임을 사용합니다.

   `StartFragment`

   ```kotlin
   private val sharedViewModel: OrderViewModel by activityViewModels()
   ```
   
   그럼 여기서는 `activityViewModels` class가 sharedViewModel애 대한 getter 및 setter 함수 제공?

<br></br>

<br></br>

2. `FlavorFragment`, `PickupFragment`, `SummaryFragment` 클래스에 대해 위의 단계를 반복합니다. Codelab의 이후 섹션에서 이 `sharedViewModel` 인스턴스를 사용합니다.

<br></br>

<br></br>

3. `StartFragment` 클래스로 돌아가면 이제 뷰 모델을 사용할 수 있습니다. `orderCupcake()` 메서드 시작 부분에서 flavor 프래그먼트로 이동하기 전에 공유 뷰 모델의 `setQuantity()` 메서드를 호출하여 수량을 업데이트합니다.

   ```kotlin
   fun orderCupcake(quantity: Int) 
       sharedViewModel.setQuantity(quantity)
       findNavController().navigate(R.id.action_startFragment_to_flavorFragment)
   }
   ```

   <br></br>

   <br></br>

4. `OrderViewModel` 클래스 내에서 **주문의 맛이 설정되었는지 여부를 확인**하는 다음 메서드를 추가합니다. 이후 단계의 `StartFragment` 클래스에서 이 메서드를 사용합니다.

   ```kotlin
   fun hasNoFlavorSet(): Boolean {
       return _flavor.value.isNullOrEmpty()
   }

<br></br>

<br></br>

5. `StartFragment` 클래스의 `orderCupcake()` 메서드 내에서 flavor 프래그먼트로 이동하기 전에 수량을 설정한 후에 맛이 설정되지 않았다면 기본 맛을 Vanilla로 설정합니다. 완성된 메서드는 다음과 같습니다.

   ```kotlin
   fun orderCupcake(quantity: Int) {
       sharedViewModel.setQuantity(quantity)
       if (sharedViewModel.hasNoFlavorSet()) {
           sharedViewModel.setFlavor(getString(R.string.vanilla))
       }
       findNavController().navigate(R.id.action_startFragment_to_flavorFragment)
   }
   ```

<br></br><br></br>

<br></br><br></br>

### 데이터 결합과 함께 ViewModel 사용

+ 데이터 결합을 사용하여 뷰 모델 데이터를 UI에 결합합니다. 또한 사용자가 UI에서 선택한 사항에 따라 공유 뷰 모델을 업데이트합니다. 

+ 데이터 결합에 대한 복습

  Data binding Library는 Andriod Jetpack의 구성 요소이다. 데이터 결합은 선언적 형식을 사용하여 **레이아웃의 UI 구성요소를 앱의 데이터 소스에 결합**합니다. 간단히 말해서 데이터 결합은 **데이터를 뷰에 바인딩**(레이아웃 파일에서 앱 데이터를 참조할 수 있도록) + **뷰를 코드에 바인딩**(코드에서 뷰를 참조가능 ex) binding.textField = " ")

  <br></br><br></br>

#### 사용자 선택으로 맛 업데이트

1. `layout/fragment_flavor.xml`에서 `<data>` 태그를 루트 `<layout>` 태그 내에 추가합니다. `com.example.cupcake.model.OrderViewModel` 유형의** `viewModel`이라는 레이아웃 변수를 추가**합니다. type 속성의 패키지 이름이 앱의 공유 뷰 모델 클래스, `OrderViewModel`의 패키지 이름과 일치하는지 확인합니다.

   ```kotlin
   <layout ...>
   
       <data>
           <variable
               name="viewModel"
               type="com.example.cupcake.model.OrderViewModel" />
       </data>
   
       <ScrollView ...>
   
       ...
   ```

<br></br><br></br>

2. 마찬가지로 `fragment_pickup.xml` 및 `fragment_summary.xml`에 대해 위의 단계를 반복하여 `viewModel` 레이아웃 변수를 추가합니다. 이후 섹션에서 이 변수를 사용합니다. `fragment_start.xml`에서는 이 코드를 추가할 필요가 없습니다. 이 레이아웃에서는 공유 뷰 모델을 사용하지 않기 때문입니다.

<br></br><br></br>

3. `FlavorFragment` 클래스의 `onViewCreated()` 내에서 **뷰 모델 인스턴스**를 **레이아웃의 공유 뷰 모델 인스턴스와 결합**합니다. `binding?.apply`블록 내에 다음 코드를 추가합니다. `PickupFragment` 및 `SummaryFragment` 클래스 내의 `onViewCreated()` 메서드에 대해 동일한 단계를 반복합니다

   ```kotlin
   binding?.apply {
       viewModel = sharedViewModel
       ...
   }
   ```

   > #### apply 범위 함수
   >
   > Kotlin에서 `apply` 함수를 보는 것이 이번이 처음일 수 있습니다. ** `apply`**는 Kotlin 표준 라이브러리의 **범위 함수**입니다. 이 함수는 **객체의 컨텍스트 내에서 코드 블록을 실행하며, 임시 범위를 형성**합니다. 그러면 **이 범위에서 이름을 사용하지 않고 객체에 액세스할 수 있습니다.** `apply`의 일반적인 사용 사례는 **객체를 구성**하는 것입니다. 이 함수 호출은 *'객체에 다음 할당 적용'*으로 읽을 수 있습니다.
   >
   > ex)
   >
   > ```kotlin
   > clark.apply {
   >     firstName = "Clark"
   >     lastName = "James"
   >     age = 18
   > }
   > 
   > // The equivalent code without apply scope function would look like the following.
   > 
   > clark.firstName = "Clark"
   > clark.lastName = "James"
   > clark.age = 18

<br></br><br></br>

4. `fragment_flavor.xml`에서 새 레이아웃 변수인 `viewModel`을 사용하여 **뷰 모델의 `flavor` 값에 따라 라디오 버튼의 `checked` 속성을 설정**합니다. 라디오 버튼이 나타내는 맛이 뷰 모델에 저장된 맛과 동일하면 라디오 버튼을 선택된 상태로 표시합니다(`checked` = true). 

   **Vanilla** `RadioButton`의 선택 상태에 대한 결합 표현식은 다음과 같습니다.
   `@{viewModel.flavor.equals(@string/vanilla)}`

   기본적으로 `equals` 함수를 사용해 `viewModel.flavor` 속성을 상응하는 문자열 리소스와 비교하여 선택 상태가 true인지 false인지 확인합니다.

   ```kotlin
   <RadioGroup
      ...>
   
      <RadioButton
          android:id="@+id/vanilla"
          ...
          android:checked="@{viewModel.flavor.equals(@string/vanilla)}"
          .../>
   
   </RadioGroup>
   ```





#### 리스너 결합

리스너 결합은 `onClick` 이벤트와 같은 이벤트가 발생할 때 실행되는 람다 표현식입니다. 리스너 결합은 `textview.setOnClickListener(clickListener)`와 같은 메서드 참조와 비슷하지만, 리스너 결합을 사용하면 임의의 데이터 결합 표현식을 실행할 수 있습니다.

1. `fragment_flavor.xml`에서 리스너 결합을 사용하여 이벤트 리스너를 라디오 버튼에 추가합니다. 매개변수 없이 람다 표현식을 사용하고 `viewModel`을 호출합니다.상응하는 flavor 문자열 리소스를 전달하여 `setFlavor()` 메서드를 호출합니다.

   ```kotlin
    <RadioButton
          android:id="@+id/vanilla"
          ...
          android:onClick="@{() -> viewModel.setFlavor(@string/vanilla)}"
          .../>
   ```







### Pickup 및 Summary 프래그먼트를 업데이트하여 뷰 모델 사용

#### 수령 옵션 목록 만들기

##### 날짜 형식 지정

+ Android 프레임워크는 `SimpleDateFormat`이라는 클래스를 제공합니다. 이 클래스는 언어에 민감한 방식으로 날짜 형식을 지정하고 파싱하는 클래스입니다. 이 클래스를 통해 날짜의  **formatting(날짜 → 텍스트)** 및 **parsing(텍스트 → 날짜)**이 가능합니다.

  다음과 같이 패턴 문자열과 언어를 전달하여 `SimpleDateFormat`의 인스턴스를 만들 수 있습니다.

  `SimpleDateFormat("E MMM d", Locale.getDefault())`

+ `"E MMM d"`와 같은 패턴 문자열은 날짜 및 시간 형식의 표현입니다. `'A'`부터 `'Z'`까지, `'a'`부터 `'z'`까지의 문자는 날짜 또는 시간 문자열의 구성요소를 나타내는 패턴 문자로 해석됩니다. 예를 들어 `d`는 월의 일, `y`는 연도, `M`은 월을 나타냅니다. 날짜가 2018년 1월 4일이면 패턴 문자열 `"EEE, MMM d"`는 `"Wed, Jul 4"`로 파싱됩니다. 
+ `Locale`객체는 특정한 지리적, 정치적 또는 문화적 지역을 나타냅니다. 또한 언어/국가/변형 조합을 나타냅니다. 언어 객체는 지역의 규칙에 맞게 숫자 또는 날짜와 같은 정보의 표시를 변경하는 데 사용됩니다. 날짜 및 시간은 세계 각지에서 서로 다르게 작성되기 때문에 언어에 민감합니다. `Locale.getDefault()` 메서드를 사용하여 사용자의 기기에 설정된 언어 정보를 가져와서 `SimpleDateFormat` 생성자에 전달합니다.

+ Android의 언어는 언어와 국가 코드의 조합입니다. 언어 코드는 2자로 된 소문자 ISO 언어 코드입니다(예: 영어의 경우 'en'). 국가 코드는 2자로 된 대문자 ISO 국가 코드입니다(예: 미국의 경우 'US').

<br>

이제 `SimpleDateFormat` 및 `Locale`을 사용하여 **Cupcake** 앱에서 **이용 가능한 수령 날짜를 결정**합니다.

1. `OrderViewModel` 클래스에서 다음과 같이 `getPickupOptions()`라는 함수를 추가하여 수령 날짜 목록을 만들고 반환합니다. 메서드 내에서 `options`라는 `val` 변수를 만들어 *`mutableListOf`*`<String>()`으로 초기화합니다.

   ```kotlin
   private fun getPickupOptions(): List<String> {
      val options = mutableListOf<String>()
   }
   ```

<br>

2. `SimpleDateFormat`을 사용하여 형식 지정 문자열을 만들어 `"E MMM d"` 패턴 문자열 및 언어를 전달합니다. 패턴 문자열에서 `E`는 요일 이름을 나타내며 '**Tue Dec 10**'으로 파싱됩니다.

   ```kotlin
   val formatter = SimpleDateFormat("E MMM d", Locale.getDefault())
   ```

<br>

3. `Calendar` 인스턴스를 가져와서 새 변수에 할당합니다. 그리고 변수를 `val`로 설정합니다. 이 변수에는 현재 날짜 및 시간이 포함됩니다. 또한 `java.util.Calendar`도 가져옵니다.

   ```kotlin
   val calendar = Calendar.getInstance()

<br>

4. 현재 날짜 및 다음 세 날짜로 시작하는 날짜 목록을 만듭니다. 4개의 날짜 옵션이 필요하므로 이 코드 블록을 4번 반복합니다. 이 `repeat`블록은 날짜 형식을 지정하여 날짜 옵션 목록에 추가한 후 캘린더를 1일씩 증가시킵니다.

   ```kotlin
   repeat(4) {
       options.add(formatter.format(calendar.time))
       calendar.add(Calendar.DATE, 1)
   }
   ```

<br>

5. 메서드의 끝부분에서 업데이트된 `options`를 반환합니다. 완성된 메서드는 다음과 같습니다.

   ```kotlin
   private fun getPickupOptions(): List<String> {
      val options = mutableListOf<String>()
      val formatter = SimpleDateFormat("E MMM d", Locale.getDefault())
      val calendar = Calendar.getInstance()
      // Create a list of dates starting with the current date and the following 3 dates
      repeat(4) {
          options.add(formatter.format(calendar.time))
          calendar.add(Calendar.DATE, 1)
      }
      return options
   }

<br>

6. `OrderViewModel` 클래스에서 `val`인 `dateOptions`라는 클래스 속성을 추가합니다. 방금 만든 `getPickupOptions()` 메서드를 사용하여 이 속성을 초기화합니다.

   ```kotlin
   val dateOptions = getPickupOptions()
   ```

<br>

#### 수령 옵션을 표시하도록 레이아웃 업데이트

이제 뷰 모델에 4개의 이용 가능한 수령 날짜가 있으므로 `PickupFragment`를 업데이트하여 이러한 날짜를 표시합니다. 또한 데이터 결합을 사용하여 각 라디오 버튼의 선택 상태를 표시하고 다른 라디오 버튼이 선택된 경우 뷰 모델의 날짜를 업데이트합니다. 이 구현은 flavor 프래그먼트의 데이터 결합과 비슷합니다. 

1. `fragment_pickup.xml`에서 `option0` 라디오 버튼에 대해 새 레이아웃 변수인 `viewModel`을 사용하여 뷰 모델의 `date` 값에 따라 `checked` 속성을 설정합니다. `viewModel.date` 속성을 `dateOptions` 목록의 첫 번째 문자열(즉, 현재 날짜)과 비교합니다. 이때 `equals`함수를 사용하여 비교합니다. 최종 결합 표현식은 다음과 같습니다. 

   `@{viewModel.date.equals(viewModel.dateOptions[0])}`

<br>

2. 동일한 라디오 버튼에 대해 리스너 결합을 사용하여 이벤트 리스너를 `onClick` 속성에 추가합니다. 이 라디오 버튼 옵션을 클릭하면 `viewModel`에서 `setDate()`를 호출하여 `dateOptions[0]`을 전달합니다. 동일한 라디오 버튼에 대해 `text` 속성 값을 `dateOptions` 목록의 첫 번째 문자열로 설정합니다. 다른 라디오 버튼에 대해서도 위 단계를 반복하여 `dateOptions`의 색인을 적절하게 변경합니다.

   ```kotlin
   <RadioButton
      android:id="@+id/option0"
      ...
      android:checked="@{viewModel.date.equals(viewModel.dateOptions[0])}"
      android:onClick="@{() -> viewModel.setDate(viewModel.dateOptions[0])}"
      android:text="@{viewModel.dateOptions[0]}"
      ...
      />
   ```

   <br>

3. `OrderViewModel` 클래스 내에서 `resetOrder()`라는 함수를 만들어 뷰 모델의 `MutableLiveData` 속성을 재설정합니다. `dateOptions` 목록의 현재 날짜 값을 `_date.`*`value.`*에 할당합니다.

   ```kotlin
   fun resetOrder() {
      _quantity.value = 0
      _flavor.value = ""
      _date.value = dateOptions[0]
      _price.value = 0.0
   }
   ```

   <br>

4. 클래스에 `init` 블록을 추가하고 여기에서 새로운 `resetOrder()` 메서드를 호출합니다.

   ```kotlin
   init {
      resetOrder()
   }
   ```

<br>

5. 클래스의 속성 선언에서 초깃값을 삭제합니다. 이제 `OrderViewModel` 인스턴스를 만들 때 `init` 블록을 사용하여 속성을 초기화합니다.

   <br>

#### 뷰 모델을 사용하도록 summary 프래그먼트 업데이트

1. `fragment_summary.xml`에서는, 뷰 모델에서 데이터를 읽어서 주문 요약 세부정보로 화면을 업데이트합니다. 다음 텍스트 속성을 추가하여 수량, 맛, 날짜 `TextViews`를 업데이트합니다. 수량은 `Int` 유형이므로 문자열로 변환해야 합니다.

   ```kotlin
   <TextView
      android:id="@+id/quantity"
      ...
      android:text="@{viewModel.quantity.toString()}"
      ... />
   ```

   ```kotlin
   <TextView
      android:id="@+id/flavor"
      ...
      android:text="@{viewModel.flavor}"
      ... />
   ```

   <br>

<br>

### 주문 세부 정보에서 가격 계산

#### 뷰 모델에서 가격 업데이트

1. `OrderViewModel.kt`를 열고 변수에 컵케이크당 가격을 저장합니다. 즉, 파일 맨 위, 클래스 정의 외부에서(하지만 import 문보다 뒤에) 최상위 private 상수로 선언합니다.

   ```kotlin
   private const val PRICE_PER_CUPCAKE = 2.00
   ```

   컵케이크당 가격을 정의했으므로 이제 도우미 메서드를 생성하여 가격을 계산합니다. 이 메서드는 이 클래스 내에서만 사용되므로 `private`일 수 있습니다. 다음 작업에서 당일 수령 요금을 포함하도록 가격 로직을 변경합니다.

   ```kotlin
   private fun updatePrice() {
       _price.value = (quantity.value ?: 0) * PRICE_PER_CUPCAKE
   }
   ```

   ​	<br>

2. 동일한 `OrderViewModel` 클래스에서 수량이 설정된 경우 가격 변수를 업데이트합니다. `setQuantity()` 함수에서 새 함수를 호출합니다.

<br>

<br>

#### UI에 가격 속성 결합

1. `fragment_flavor.xml`, `fragment_pickup.xml` 및 `fragment_summary.xml`의 레이아웃에서 `com.example.cupcake.model.OrderViewModel` 유형의 **데이터 변수 `viewModel`이 정의되어 있는지 확인**합니다.

   ```kotlin
   <layout ...>
   
       <data>
           <variable
               name="viewModel"
               type="com.example.cupcake.model.OrderViewModel" />
       </data>
   
       <ScrollView ...>
   
       ...

<br>

2. 각 프래그먼트 클래스의 `onViewCreated()` 메서드에서 **프래그먼트의 뷰 모델 객체 인스턴스**를 **레이아웃의 뷰 모델 데이터 변수에 결합**해야 합니다.

   ```kotlin
   binding?.apply {
       viewModel = sharedViewModel
       ...
   }
   ```

   <br>

3. 각 프래그먼트 레이아웃 내에서 `viewModel` 변수를 사용하여 레이아웃에 표시되는 가격을 설정합니다. 먼저, `fragment_flavor.xml` 파일을 수정합니다. `subtotal` 텍스트 뷰에서 `android:text` 속성의 값을 `"@{@string/subtotal_price(viewModel.price)}".`로 설정합니다. 이 데이터 결합 레이아웃 표현식은 문자열 리소스 `@string/subtotal_price`를 사용하고 뷰 모델의 가격인 매개변수를 전달합니다. 따라서 출력에는 예를 들면 **Subtotal 12.0**이 표시됩니다.

   ```kotlin
   ...
   
   <TextView
       android:id="@+id/subtotal"
       android:text="@{@string/subtotal_price(viewModel.price)}"
       ... />
   
   ...
   ```

   `strings.xml` 파일에서 이미 선언한 다음과 같은 문자열 리소스를 사용합니다.

   ```kotlin
   <string name="subtotal_price">Subtotal %s</string>
   ```

<br>

#### 당일 수령 시 추가 요금 청구

+ `updatePrice()`에서는 사용자가 당일 수령을 선택했는지 확인합니다. 뷰 모델의 날짜(`_date.value`)가 `dateOptions` 목록의 첫 번째 항목(항상 당일 날짜)과 동일한지 확인합니다.

  ```kotlin
  private fun updatePrice() {
      var calculatedPrice = (quantity.value ?: 0) * PRICE_PER_CUPCAKE
      // If the user selected the first option (today) for pickup, add the surcharge
      if (dateOptions[0] == _date.value) {
          calculatedPrice += PRICE_FOR_SAME_DAY_PICKUP
      }
      _price.value = calculatedPrice
  }
  ```

+ `setDate()` 메서드에서 `updatePrice()` 도우미 메서드를 호출하여 당일 수령 요금을 추가합니다.

  ```kotlin
  fun setDate(pickupDate: String) {
      _date.value = pickupDate
      updatePrice()
  }
  ```

  <br>

#### LiveData를 관찰하도록 수명 주기 소유자 설정

+ `LifecycleOwner`는 활동이나 프래그먼트와 같이 Android 수명 주기를 보유한 클래스입니다. `LiveData` 관찰자는 수명 주기 소유자가 활성 상태(`STARTED` 또는 `RESUMED`)인 경우에만 앱 데이터의 변경사항을 관찰합니다.

+ 이 앱에서 `LiveData` 객체 또는 관찰 가능한 데이터는 뷰 모델의 `price` 속성입니다. 수명 주기 소유자는 flavor, pickup, summary 프래그먼트입니다. `LiveData` 관찰자는 가격과 같은 관찰 가능한 데이터가 있는 레이아웃 파일의 결합 표현식입니다. **데이터 결합을 사용하면 관찰 가능한 값이 변경되는 경우 결합된 UI 요소가 자동으로 업데이트됩니다.**

+ UI 요소가 자동으로 업데이트되도록 하려면 `binding.lifecycleOwner`를

  앱의 수명 주기 소유자와 연결해야 합니다. 

1. `FlavorFragment`, `PickupFragment` 및 `SummaryFragment` 클래스의 `onViewCreated()` 메서드 내에서 `binding?.apply` 블록에 다음을 추가합니다. 이렇게 하면 **결합 객체에 수명 주기 소유자가 설정**됩니다. 수명 주기 소유자를 설정하면 앱이 `LiveData` 객체를 관찰할 수 있습니다.

   ```kotlin
   binding?.apply {
       lifecycleOwner = viewLifecycleOwner
       ...
   }
   ```

   <br>

#### LiveData 변환을 사용하여 가격 형식 지정

+ `LiveData` 변환 메서드는 `LiveData` 소스에서 데이터 조작을 실행하고 결과 `LiveData` 객체를 반환하는 방법을 제공합니다. 간단히 말해 `LiveData` 값을 다른 값으로 변환합니다. 관찰자가 `LiveData` 객체를 관찰하고 있지 않다면 이러한 변환은 계산되지 않습니다.
+ `Transformations.map()`은 변환 함수 중 하나이며, 이 메서드는 소스 `LiveData` 및 함수를 매개변수로 사용합니다. 이 함수는 `LiveData` 소스를 조작하고, 관찰할 수도 있는 업데이트된 값을 반환합니다.
+ LiveData 변환을 사용할 수 있는 몇 가지 실시간 예는 다음과 같습니다.
  - 표시할 날짜 및 시간 문자열 형식 지정
  - 항목 목록 정렬
  - 항목 필터링 또는 그룹화
  - 모든 항목 합계, 항목 수, 마지막 항목 반환 등과 같이 목록의 결과 계산

<br>

1. `OrderViewModel` 클래스에서 지원 속성 유형을 `LiveData<Double>.` 대신 `LiveData<String>`으로 변경합니다. `Transformations.map()`사용하여 새로운 변수를 초기화하고 `_price` 및 람다 함수를 전달합니다. `NumberFormat` 클래스의 `getCurrencyInstance()` 메서드를 사용하여 가격을 현지 통화 형식으로 변환합니다. 변환 코드는 다음과 같습니다.

   ```kotlin
   private val _price = MutableLiveData<Double>()
   val price: LiveData<String> = Transformations.map(_price) {
      NumberFormat.getCurrencyInstance().format(it)
   }

<br>

### 리스너 결합을 사용하여 클릭 리스너 설정

 리스너 결합을 사용하여 **프래그먼트 클래스의 버튼 클릭 리스너**를 **레이아웃**에 결합

1. `fragment_start.xml`

   `com.example.cupcake.StartFragment` 유형의 `startFragment`라는 데이터 변수를 추가합니다. 프래그먼트의 패키지 이름이 **앱의 패키지 이름과 일치하는지** 확인합니다.

   ```kotlin
   <layout ...>
   
       <data>
           <variable
               name="startFragment"
               type="com.example.cupcake.StartFragment" />
       </data>
       ...
       <ScrollView ...>
   ```

<br>

2. `StartFragment.kt` 

   `onViewCreated()` 메서드에서 새 **데이터 변수를 프래그먼트 인스턴스에 결합**합니다. `this` 키워드를 사용하여 프래그먼트 내에서 프래그먼트 인스턴스에 액세스할 수 있습니다. `binding?.apply` 블록과 그 안에 있는 코드를 함께 삭제합니다. 완성된 메서드는 다음과 같습니다.

   ```kotlin
   override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
       super.onViewCreated(view, savedInstanceState)
       binding?.startFragment = this
   }
   ```

<br>

3. `fragment_start.xml`

   리스너 결합을 사용하여 **이벤트 리스너를 버튼의 `onClick` 속성에 추가**하고, `startFragment`에서 `orderCupcake()`를 호출하여 컵케이크 수를 전달합니다.

   ```kotlin
   <Button
       android:id="@+id/order_one_cupcake"
       android:onClick="@{() -> startFragment.orderCupcake(1)}"
       ... />
   

<br>

<br>

<br>

## 🎖 Navigation and backstack

### 작업 및 백스택 알아보기

+ Android에서 액티비티는 Task안에 존재합니다. 런처 아이콘으로 앱을 처음 열면 Android는 기본 활동이 포함된 새로운 task를 생성합니다. task는 사용자가 이메일 확인, 컵케이크 주문 생성, 사진 촬영 등의 **특정한 일을 할 때 상호작용하는 활동의 모음**입니다.

+ 활동은 ***백 스택***이라는 스택으로 배열되며, 사용자가 방문하는 각각의 새 활동은 작업의 백 스택으로 푸시됩니다. 새로 만든 각 팬케이크가 스택 위에 추가되는 팬케이크 스택과 비슷하다고 생각할 수 있습니다. 스택 맨 위에 있는 활동은 사용자가 현재 상호작용하고 있는 활동이고, 스택에서 그 아래에 있는 활동은 백그라운드로 전환되었다가 중지되었습니다.

+ 백 스택은 사용자가 뒤로 이동하는 경우 유용합니다. Android는 스택 맨 위에 있는 현재 활동을 삭제하고 폐기한 후 그 아래에 있는 활동을 다시 시작할 수 있습니다. 즉, 스택에서 활동을 팝하고 사용자가 상호작용할 수 있게 이전 활동이 포그라운드로 이동합니다. 사용자가 여러 번 뒤로 이동하고 싶어하는 경우 Android는 스택의 맨 아래에 더 가까워질 때까지 계속 스택 상단에서 활동을 팝합니다. 백 스택에 더 이상 활동이 남아 있지 않으면 사용자는 기기의 런처 화면이나 이 활동을 실행한 앱으로 돌아가게 됩니다.

  > **참고:** 앱을 연 후에 기기에서 **Home**을 탭하면 **앱의 전체 작업이 백그라운드로 전환**됩니다. 앱의 런처 아이콘을 다시 탭하면 Android는 앱의 기존 작업이 있는지 확인한 후 기존 작업을 포그라운드로 가져옵니다(백 스택은 그대로 유지함). 기존 작업이 없는 경우 Android는 자동으로 새 작업을 생성하고 기본 활동을 실행하여 백 스택으로 푸시합니다.

+ 탐색 라이브러리를 사용하면 사용자가 **Back** 버튼을 누를 때마다 백 스택에서 프래그먼트 대상을 팝할 수 있습니다. 이 기본 동작은 무료로 제공되며 직접 구현할 필요가 없습니다. 맞춤 백 스택 동작이 필요한 경우에만 코드를 작성하면 됩니다. **Cupcake** 앱에서 이러한 코드를 작성할 것입니다.

<br>

#### Cupcake 앱의 기본 동작

+ 이  앱에는 Activity가 하나만 있지만 사용자가 탐색하는 프래그먼트 destination은 여러 개가 있습니다. 따라서 **Back** 버튼을 탭할 때마다 이전 프래그먼트 대상으로 돌아가야 합니다. 

+ 주문 흐름에서 이전 단계로(뒤로) 이동하면 대상이 한 번에 하나씩만 팝됩니다. 하지만 다음 작업에서는 앱에 **주문 취소 기능**을 추가합니다. 이렇게 하려면 사용자가 `StartFragment`로 돌아와 **새 주문을 시작할 수 있도록 백 스택의 여러 대상을 한꺼번에 팝**해야 할 수도 있습니다.

  <img src = "https://user-images.githubusercontent.com/31370590/128662549-fdbf4dc2-3fb2-4ac6-a449-4dbdb0435009.PNG" width = "650" height = "400">

  <br>

#### Cupcake 앱에서 백 스택 수정하기

##### 탐색 작업 추가하기

+ 먼저 앱의 탐색 그래프에 탐색 작업을 추가하여 사용자가 다음의 대상에서 `StartFragment`로 다시 이동할 수 있도록 합니다.  `summaryFragment`, `pickupFragment`, `flavorFragment`에서 클릭하고 드래그하여 `startFragment`로 이어지는 새 action을 만듭니다. 
+ 이러한 변경을 통해 사용자는 주문 흐름 내의 후반 프래그먼트 중 하나에서 주문 흐름의 시작으로 이동할 수 있습니다. 이제 이러한 작업으로 실제로 이동하는 코드가 필요합니다. 적합한 위치는 **Cancel** 버튼을 탭하는 시점입니다.

<br>

##### 레이아웃에 Cancel 버튼 추가하기

먼저 `StartFragment`를 제외한 모든 프래그먼트에 해당하는 **Cancel** 버튼을 레이아웃 파일에 추가합니다. 주문 흐름의 첫 번째 화면에 이미 있는 경우에는 주문을 취소할 필요가 없습니다.

<br>

#### Cancel 버튼의 클릭 리스너 추가하기

`StartFragment`를 제외한 각 프래그먼트 클래스 내부에 **Cancel** 버튼 클릭 시 처리하는 도우미 메서드를 추가합니다.

1. `FlavorFragment`에 다음 `cancelOrder()` 메서드를 추가합니다. 맛 옵션이 제시되었을 때 사용자가 주문을 취소하기로 결정하는 경우 `sharedViewModel.resetOrder()`를 호출하여 뷰 모델을 지웁니다. 그런 다음 ID가 `R.id.action_flavorFragment_to_startFragment.`인 탐색 작업을 사용하여 `StartFragment`로 다시 이동합니다.

   ```kotlin
   fun cancelOrder() {
       sharedViewModel.resetOrder()
       findNavController().navigate(R.id.action_flavorFragment_to_startFragment)
   }
   ```

   <br>

2. 리스너 결합을 사용하여 `fragment_flavor.xml` 레이아웃의 **Cancel** 버튼에 클릭 리스너를 설정합니다. 이 버튼을 클릭하면 `FragmentFlavor` 클래스에서 방금 생성한 `cancelOrder()` 메서드가 호출됩니다.

   ```kotlin
   <Button
       android:id="@+id/cancel_button"
       android:onClick="@{() -> flavorFragment.cancelOrder()}" ... />
   ```

<br>

3. 동일한 프로세스를 `PickupFragment`, `SummaryFragment`에도 반복합니다.

<br>

+ 아직까지의 문제점

  `SummaryFragment`에서 주문을 취소했습니다. `SummaryFragment`에서 `StartFragment`로 작업을 이동할 때 Android는 다른 `StartFragment` 인스턴스를 새 대상으로 백 스택에 추가했습니다. 이런 이유로 인해 `StartFragment`에서 **Back** 버튼을 탭하면 앱이 다시 `SummaryFragment`를 표시(주문 정보가 비어 있음)했습니다.

  <img src = "https://user-images.githubusercontent.com/31370590/128664429-dc374189-5bac-451b-a8d3-12f49f6eeca2.PNG" width = "500" height = "350">

 => 이 탐색 버그를 수정하려면 작업을 사용해 탐색할 때 탐색 구성요소가 **추가 대상을 백 스택에서 팝하는 방법**을 사용해야 한다.

<br>

#### 백 스택에서 추가 대상 팝하기

##### Navigation action: popUpTo attribute

+ 탐색 그래프의 탐색 작업에 `app:popUpTo` 속성을 포함하면 지정된 대상에 도달할 때까지 대상 두 개 이상이 백 스택에서 팝될 수 있습니다. `app:popUpTo="@id/startFragment"`를 지정하는 경우 스택에 남게 될 `StartFragment`에 도달할 때까지 백 스택에 있는 대상이 팝됩니다.

+ 이 변경사항을 코드에 추가하고 앱을 실행하면 주문 취소 시 `StartFragment`로 돌아가는 것을 확인하게 됩니다. 하지만 이번에는 `StartFragment`에서 **Back** 버튼을 탭하면 앱이 종료되는 대신 `StartFragment`가 다시 표시됩니다. 이 또한 의도한 동작이 아닙니다. 앞서 언급했듯이 `StartFragment`로 이동하면 Android는 실제로 `StartFragment`를 새 대상으로 백 스택에 추가하므로, 이제 백 스택에 StartFragment 인스턴스가 두 개 있습니다. 따라서 앱을 종료하려면 **Back** 버튼을 두 번 탭해야 합니다.

##### Navigation action: popUpToInclusive attribute

이 새로운 버그를 수정하려면 `StartFragment`에 이르기까지(포함) 모든 대상을 백 스택에서 팝하도록 요청합니다. 적절한 탐색 작업에 `app:popUpTo="@id/startFragment"` 및 `app:popUpToInclusive="true"`를 지정하면 됩니다. 이렇게 하면 백 스택에 새 `StartFragment` 인스턴스가 하나만 생성됩니다. 그런 다음 `StartFragment`에서 **Back** 버튼을 한 번 탭하면 앱이 종료됩니다. 지금 이렇게 변경하겠습니다.

<br>

<br>

### 주문 전송하기

암시적 인텐트를 사용하여 앱에서 다른 앱으로 정보를 공유하는 것

기기의 이메일 앱을 통해 상점에 주문을 이메일로 보내 컵케이크 주문 정보를 공유할 수 있습니다. 

1. `SummaryFragment.kt`에서 `sendOrder()` 메서드 내에 주문 요약 텍스트를 작성합니다. 공유 뷰 모델에서 주문 수량, 맛, 날짜, 가격을 가져와서 형식이 지정된 order_details 문자열을 만듭니다. 

   ```kotlin
   fun sendOrder() {
       val orderSummary = getString(
       R.string.order_details,
       sharedViewModel.quantity.value.toString(),
       sharedViewModel.flavor.value.toString(),
       sharedViewModel.date.value.toString(),
       sharedViewModel.price.value.toString()
   )
   }
   ```

<br>

2. `sendOrder()` 메서드 내에서 주문을 다른 앱에 공유하는 암시적 인텐트를 만듭니다. 이메일 인텐트를 만드는 방법은 문서를 참고하세요. 인텐트 작업에 `Intent.ACTION_SEND`를 지정하고, 유형을 `"text/plain"`으로 설정하고, 이메일 제목(`Intent.EXTRA_SUBJECT`)과 이메일 본문(`Intent.EXTRA_TEXT`)을 위한 인텐트 추가항목을 포함합니다. 필요한 경우 `android.content.Intent`를 가져옵니다.

   ```kotlin
   val intent = Intent(Intent.ACTION_SEND)
       .setType("text/plain")
       .putExtra(Intent.EXTRA_SUBJECT, getString(R.string.new_cupcake_order))
       .putExtra(Intent.EXTRA_TEXT, orderSummary)
   ```

   <br>

3. 암시적 인텐트이므로, 이 인텐트를 처리할 특정 구성요소나 앱을 사전에 알지 않아도 됩니다. 인텐트를 처리하는 데 사용할 앱을 사용자가 결정합니다. 하지만 이 인텐트로 활동을 실행하기 전에 이 인텐트를 처리할 수 있는 앱이 있는지 확인하세요. 이렇게 확인하면 인텐트를 처리할 앱이 없는 경우 **Cupcake** 앱이 비정상 종료되지 않습니다. 즉, 코드가 더 안전해집니다.

   ```kotlin
   if (activity?.packageManager?.resolveActivity(intent, 0) != null) {
       startActivity(intent)
   }
   ```

   <br>

+ 수량 값에 따라 단수형 cupcake나 복수형 cupcakes를 사용할지 여부를 선택하려면 Android에서 **수량 문자열**을 사용할 수 있습니다. `plurals` 리소스를 선언하면 수량에 따라 사용할 다른 문자열 리소스(예: 단수형 또는 복수형)를 지정할 수 있습니다.

  `strings.xml`

  ```kotlin
  <plurals name="cupcakes">
      <item quantity="one">%d cupcake</item>
      <item quantity="other">%d cupcakes</item>
  </plurals>
  ```

  => 

  `getQuantityString(R.string.cupcakes, 1, 1)` 호출 시 문자열 `1 cupcake` 반환

  `getQuantityString(R.string.cupcakes, 6, 6)` 호출 시 문자열 `6 cupcakes` 반환

<br>

4. `SummaryFragment` 클래스에서 새 수량 문자열을 사용하도록 `sendOrder()` 메서드를 업데이트합니다. 먼저 뷰 모델에서 수량을 파악하고 이 값을 변수에 저장하는 것이 가장 쉽습니다. 뷰 모델의 `quantity`가 `LiveData<Int>` 유형이므로 `sharedViewModel.quantity.value`가 null일 수 있습니다. null이면 `0`을 `numberOfCupcakes`의 기본값으로 사용합니다.

   `sendOrder()` 메서드

   ```kotlin
   val numberOfCupcakes = sharedViewModel.quantity.value ?: 0

<br>

5. 최종 `sendOrder()` 코드

   ```kotlin
   fun sendOrder() {
       val numberOfCupcakes = sharedViewModel.quantity.value ?: 0
       val orderSummary = getString(
           R.string.order_details,
           resources.getQuantityString(R.plurals.cupcakes, numberOfCupcakes, numberOfCupcakes),
           sharedViewModel.flavor.value.toString(),
           sharedViewModel.date.value.toString(),
           sharedViewModel.price.value.toString()
       )
   
       val intent = Intent(Intent.ACTION_SEND)
           .setType("text/plain")
           .putExtra(Intent.EXTRA_SUBJECT, getString(R.string.new_cupcake_order))
           .putExtra(Intent.EXTRA_TEXT, orderSummary)
   
       if (activity?.packageManager?.resolveActivity(intent, 0) != null) {
           startActivity(intent)
       }
   }
   ```

   <br>

<br>

<br>

## Quiz/Unit3/Pathway4

1. 참 또는 거짓: 여러 활동 또는 프래그먼트에 동일한 ViewModel을 사용하여 데이터를 공유할 수 있습니다.

   => 참

<br>

2. Kotin 속성 위임 접근법을 사용하여 공유 뷰 모델에 액세스할 수 있는 올바른 방법은 무엇인가요?
   + `val viewModel: OrderViewModel by activityViewModels()`

<br>

3. 빈 칸 채우기

   LiveData **변환**을(를) 사용하여 다른 인스턴스의 값에 따라 다양한 LiveData 인스턴스를 반환합니다.

<br>

4. 객체를 구성하는 데 Kotlin의 `apply` 함수를 사용하려면 어떻게 해야 하나요?
   + 객체에 할당 세트를 적용할 수 있습니다

<br>

5. 데이터 결합 레이아웃 표현식을 사용할 때 클릭 리스너를 결합하기 위해 이 레이아웃의 버튼에 속성을 추가하는 올바른 구문은 무엇인가요?

   ```kotlin
   <Button
       android:id="@+id/next_button"
       android:layout_width="wrap_content"
       android:layout_height="wrap_content"
       android:text="@string/next" />
   ```

   => `android:onClick="@{() -> detailFragment.next()}"`