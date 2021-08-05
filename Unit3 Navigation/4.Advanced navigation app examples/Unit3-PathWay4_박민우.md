# 🔥 Unit 3 : Navigation

## Pathway 4 : Advanced navigation app examples

-----

### <div align="center">목차</div>

- [Shared ViewModel](#Shared-ViewModel)

  - [탐색 그래프 완성하기](#탐색-그래프-완성하기)

  - [공유 ViewModel 만들기](#공유-ViewModel-만들기)

  - [ViewModel을 사용하여 UI 업데이트](#ViewModel을-사용하여-UI-업데이트)

  - [데이터 결합과 함께 ViewModel 사용](#데이터-결합과-함께-ViewModel-사용)

  - [Pickup 및 Summary 프래그먼트를 업데이트하여 뷰 모델 사용](Pickup-및-Summary-프래그먼트를-업데이트하여-뷰-모델-사용)

  - ㅇ

    

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

   

3. 





















## 🎖 Navigation and backstack

