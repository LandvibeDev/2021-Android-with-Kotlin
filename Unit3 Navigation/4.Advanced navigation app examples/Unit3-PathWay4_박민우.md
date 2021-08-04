# 🔥 Unit 3 : Navigation

## Pathway 4 : Advanced navigation app examples

-----

### <div align="center">목차</div>

- [Shared ViewModel](#Shared-ViewModel)

  - [탐색 그래프 완성하기](#탐색-그래프-완성하기)

  - [공유 ViewModel 만들기](#공유-ViewModel-만들기)

  - [ViewModel을 사용하여 UI 업데이트](#ViewModel을-사용하여-UI-업데이트)

  - ㅇ

  - ㅇ

  - ㅇ

    

-----

<br></br>

<br></br>

## <div align="center">🎖 Shared ViewModel</div>

## 학습할 내용

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

이는 활동의 콘텐츠 뷰를 `activity_main.xml`로 설정하는 기본 생성 코드와 유사하다. 이 코드는 `super.onCreate(savedInstanceState)`의 일부로 확장될 레이아웃을 포함하는 매개변수화된 생성자 `AppCompatActivity(@LayoutRes int contentLayoutId)`를 사용합니다.

<br></br>

<br></br>

```kotlin
class MainActivity : AppCompatActivity() {

   override fun onCreate(savedInstanceState: Bundle?) {
       super.onCreate(savedInstanceState)
       setContentView(R.layout.main_activity)
   }
}
```

기본 `AppCompatActivity` 생성자를 사용하는 코드

<br></br>

<br></br>

### 탐색 그래프 완성하기

+ `nav_graph.xml`에서 각 프래그먼트 간 액션 설정하기

+ start 프래그먼트에서 flavor 프래그먼트로 이동

  `startFragment.kt`

  ```kotlin
  fun orderCupcake(quantity: Int) {
          findNavController().navigate(R.id.action_startFragment_to_flavorFragment)
      }
  ```

  `startFragment`의 각 버튼마다 클릭 리스너가 설정되어 있고, 각 버튼을 탭하면 해당되는 컵케이크의 수량을 매개변수로 사용하여 `orderCupcake()` 메서드가 호출되도록 되어있습니다. 

  이 `orderCupcake()` 메서드를  flavor 프래그먼트로 이동하는 코드로 바꿉니다.

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

+ 공유 `ViewModel`을 사용하여 앱의 데이터를 단일 `ViewModel`에 저장하고 앱의 여러 프래그먼트는 activity 범위를 사용하여 공유 `ViewModel`에 액세스합니다. 
+ `ViewModel`이 Android architecture 구성요소의 일부입니다. `ViewModel` 내에 저장된 앱 데이터는 구성 변경 중에도 유지됩니다. 

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



### ViewModel을 사용하여 UI 업데이트 

공유 뷰 모델 구현의 주요 차이점 : UI 컨트롤러에서 뷰 모델에 액세스하는 방식

활동 인스턴스 사용

뷰 모델을 여러 프래그먼트 간에 공유할 수 있음. **각 프래그먼트는 뷰 모델에 액세스**하여 주문의 일부 세부정보를 확인하거나 뷰 모델의 일부 데이터를 업데이트할 수 있습니다. 

#### ViewModel을 사용하도록 StartFragment 업데이트



































































`binding.apply?` 는 뭐지

binding 객체가 생성이 되면? 적용해라~?







## 🎖 Navigation and backstack

