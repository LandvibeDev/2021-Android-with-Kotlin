# 2021 Landvibe Summer Coding - Android

## Unit3 - Navigation

## PathWay4 - Advanced navigation app examples

### 프래그먼트 간 공유 ViewModel

##### &#128204;시작 앱 개요

- 레이아웃(res/layout 폴더)
  - `fragment_start.xml` : 앱에 표시되는 첫 번째 화면, 컵케이크 이미지와 주문할 컵케이크 수를 선택할 수 있는 버튼 3개(1개, 6개, 12개)가 있음
  - `fragment_flavor.xml` : 컵케이크 맛 목록이 라디오 버튼 옵션으로 표시되며 **Next** 버튼이 있음
  - `fragment_pickup.xml` : 수령일을 선택하는 옵션과 요약 화면으로 이동할 수 있는 **Next** 버튼을 제공
  - `fragment_summary.xml` :  수량, 맛과 같은 주문 세부정보의 요약이 표시되며 주문을 다른 앱으로 전송하는 버튼이 있음
- 프래그먼트 클래스
  - `StartFragment.kt` : 앱에 표시되는 첫 번째 화면, 3개의 버튼을 위한 클릭 핸들러 및 뷰 결합 코드가 있음
  - `FlavorFragment.kt`, `PickupFragment.kt`, `SummaryFragment.kt` : 대부분 상용구 코드와 토스트 메시지를 표시하는 **Next** 또는 **Send Order to Another App** 버튼의 클릭 핸들러가 있음
- 리소스(res폴더)
  - `drawable` 폴더 : 첫 번째 화면의 컵케이크 애셋뿐 아니라 런처 아이콘 파일이 있음
  - `navigation/nav_graph.xml` : *작업*이 없는 4개의 프래그먼트 대상(`startFragment`, `flavorFragment`, `pickupFragment`, `summaryFragment`)이 있으며
  - `values` 폴더 : 앱 테마를 맞춤설정하는 데 사용되는 색상, 크기, 문자열, 스타일, 테마가 있음



##### &#128204;탐색 그래프 완성

- 탐색 그래프에서 대상 연결

  1. **Project > res > navigation > nav_graph.xml**열고 **Design**탭으로 전환
  2. 탐색 그래프에서 프래그먼트 대상을 연결
     - `startFragment` -> `flavorFragment` -> `pickupFragment` -> `summaryFragment`

- start 프래그먼트에서 flavor 프래그먼트로 이동

  1. **app > java > com.example.cupcake > StartFragment** 파일 열기

  2. `onderCupcake()`메서드 수정

     ```kotlin
     fun orderCupcake(quantity: Int) {
     	findNavController().naviagte(R.id.action_startFragment_to_flavorFragment)
     }
     ```

  3. `import` `androidx.navigation.fragment.findNavController` 가져오기를 추가

- flavor 및 pickup 프래그먼트에 탐색 추가

  1. **app > java > com.example.cupcake > FlavorFragment.kt** 열기 

  2. `FlavorFragment.kt`의 `goToNextScreen()` 메서드 수정

     ```kotlin
     fun goToNextScreen() {
     	findNavController().navigate(R.id.action_flavorFragment_to_pickupFragment)
     }
     ```

  3. `PickupFragment.kt`의 `goToNextScreen()` 메서드 수정

     ```kotlin
     fun goToNextScreen() {
         findNavController().navigate(R.id.action_pickupFragment_to_summaryFragment)	
     }
     ```

- 앱 바에서 제목 업데이트

  - `MainActivity.kt`에서 `onCreate()`메서드 재정의

  - ```kotlin
    class MainActivity : AppCompatActivity(R.layout.activity_main) {
    
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
    
            val navHostFragment = supportFragmentManager
                    .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
            val navController = navHostFragment.navController
    
            setupActionBarWithNavController(navController)
        }
    }
    ```

  - `nav_graph.xml`

    ```kotlin
    <navigation ...>
        <fragment
            android:id="@+id/startFragment"
            ...
            android:label="@string/app_name" ... >
            <action ... />
        </fragment>
        <fragment
            android:id="@+id/flavorFragment"
            ...
            android:label="@string/choose_flavor" ... >
            <action ... />
        </fragment>
        <fragment
            android:id="@+id/pickupFragment"
            ...
            android:label="@string/choose_pickup_date" ... >
            <action ... />
        </fragment>
        <fragment
            android:id="@+id/summaryFragment"
            ...
            android:label="@string/order_summary" ... />
    </navigation>
    ```



##### &#128204;최종 코드

- `FlavorFragment.kt`

  ```kotlin
  package com.example.cupcake
  
  import android.os.Bundle
  import android.view.LayoutInflater
  import android.view.View
  import android.view.ViewGroup
  import androidx.fragment.app.Fragment
  import androidx.fragment.app.activityViewModels
  import androidx.navigation.fragment.findNavController
  import com.example.cupcake.databinding.FragmentFlavorBinding
  import com.example.cupcake.model.OrderViewModel
  
  
  class FlavorFragment : Fragment() {
  
     
      private var binding: FragmentFlavorBinding? = null
  
      //공유 뷰 모델의 참조를 클래스 변수로 가져옴
      private val sharedViewModel: OrderViewModel by activityViewModels()
  
      override fun onCreateView(
          inflater: LayoutInflater, container: ViewGroup?,
          savedInstanceState: Bundle?
      ): View? {
          val fragmentBinding = FragmentFlavorBinding.inflate(inflater, container, false)
          binding = fragmentBinding
          return fragmentBinding.root
      }
  
      override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
          super.onViewCreated(view, savedInstanceState)
  		//뷰 모델 인스턴스를 레이아웃의 공유 뷰 모델 인스턴스와 결합
          binding?.apply {
           
              lifecycleOwner = viewLifecycleOwner
  			//프래그먼트의 뷰 모델 객체 인스턴스를 레이아웃의 뷰 모델 데이터 변수에 결합
              viewModel = sharedViewModel
         
              flavorFragment = this@FlavorFragment
          }
      }
  
     
      fun goToNextScreen() {
          findNavController().navigate(R.id.action_flavorFragment_to_pickupFragment)
      }
  
      override fun onDestroyView() {
          super.onDestroyView()
          binding = null
      }
  }
  ```

- `MainActivity.kt`

  ```kotlin
  package com.example.cupcake
  
  import android.os.Bundle
  import androidx.appcompat.app.AppCompatActivity
  import androidx.navigation.NavController
  import androidx.navigation.fragment.NavHostFragment
  import androidx.navigation.ui.setupActionBarWithNavController
  
  
  class MainActivity : AppCompatActivity(R.layout.activity_main) {
  
      override fun onCreate(savedInstanceState: Bundle?) {
          super.onCreate(savedInstanceState)
  
          
          val navHostFragment = supportFragmentManager
                  .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
          val navController = navHostFragment.navController
  
          
          setupActionBarWithNavController(navController)
      }
  }
  ```

- `PickupFragment.kt`

  ```kotlin
  package com.example.cupcake
  
  import android.os.Bundle
  import android.view.LayoutInflater
  import android.view.View
  import android.view.ViewGroup
  import androidx.fragment.app.Fragment
  import androidx.fragment.app.activityViewModels
  import androidx.navigation.fragment.findNavController
  import com.example.cupcake.databinding.FragmentPickupBinding
  import com.example.cupcake.model.OrderViewModel
  
  
  class PickupFragment : Fragment() {
  
    
      private var binding: FragmentPickupBinding? = null
  
      //공유 뷰 모델의 참조를 클래스 변수로 가져옴
      private val sharedViewModel: OrderViewModel by activityViewModels()
  
      override fun onCreateView(
          inflater: LayoutInflater, container: ViewGroup?,
          savedInstanceState: Bundle?
      ): View? {
          val fragmentBinding = FragmentPickupBinding.inflate(inflater, container, false)
          binding = fragmentBinding
          return fragmentBinding.root
      }
  
      override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
          super.onViewCreated(view, savedInstanceState)
  		
          //apply : 범위함수로 객체의 컨텍스트 내에서 코드 블록을 실행하며 임시 범위를 형성, 객체에 다음 할당 적용이라는 의미
          binding?.apply {
              lifecycleOwner = viewLifecycleOwner
              viewModel = sharedViewModel
              pickupFragment = this@PickupFragment
          }
      }
  
  
      fun goToNextScreen() {
          findNavController().navigate(R.id.action_pickupFragment_to_summaryFragment)
      }
  
   
      override fun onDestroyView() {
          super.onDestroyView()
          binding = null
      }
  }
  ```

- `StartFragment.kt`

  ```kotlin
  package com.example.cupcake
  
  import android.os.Bundle
  import android.view.LayoutInflater
  import android.view.View
  import android.view.ViewGroup
  import androidx.fragment.app.Fragment
  import androidx.fragment.app.activityViewModels
  import androidx.navigation.fragment.findNavController
  import com.example.cupcake.databinding.FragmentStartBinding
  import com.example.cupcake.model.OrderViewModel
  
  
  class StartFragment : Fragment() {
  
      private var binding: FragmentStartBinding? = null
  
      //공유 뷰 모델의 참조를 클래스 변수로 가져옴
      private val sharedViewModel: OrderViewModel by activityViewModels()
  
      override fun onCreateView(
          inflater: LayoutInflater, container: ViewGroup?,
          savedInstanceState: Bundle?
      ): View? {
          val fragmentBinding = FragmentStartBinding.inflate(inflater, container, false)
          binding = fragmentBinding
          return fragmentBinding.root
      }
  
      override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
          super.onViewCreated(view, savedInstanceState)
          binding?.startFragment = this
      }
  
    
      fun orderCupcake(quantity: Int) {
          //공유 뷰 모델의 setQuantity()메서드를 호출해 수량 업데이트
          sharedViewModel.setQuantity(quantity)
  
          // 맛이 설정되지 않았다면 기본 맛을 vanilla로 설정
          if (sharedViewModel.hasNoFlavorSet()) {
              sharedViewModel.setFlavor(getString(R.string.vanilla))
          }
  
          
          findNavController().navigate(R.id.action_startFragment_to_flavorFragment)
      }
  
      override fun onDestroyView() {
          super.onDestroyView()
          binding = null
      }
  }
  ```

- `SummaryFragment.kt`

  ```kotlin
  package com.example.cupcake
  
  import android.os.Bundle
  import android.view.LayoutInflater
  import android.view.View
  import android.view.ViewGroup
  import android.widget.Toast
  import androidx.fragment.app.Fragment
  import androidx.fragment.app.activityViewModels
  import com.example.cupcake.databinding.FragmentSummaryBinding
  import com.example.cupcake.model.OrderViewModel
  
  
  class SummaryFragment : Fragment() {
  
    
      private var binding: FragmentSummaryBinding? = null
  	
      //공유 뷰 모델의 참조를 클래스 변수로 가져옴
      private val sharedViewModel: OrderViewModel by activityViewModels()
  
      override fun onCreateView(
          inflater: LayoutInflater, container: ViewGroup?,
          savedInstanceState: Bundle?
      ): View? {
          val fragmentBinding = FragmentSummaryBinding.inflate(inflater, container, false)
          binding = fragmentBinding
          return fragmentBinding.root
      }
  
      override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
          super.onViewCreated(view, savedInstanceState)
  		
          //apply : 범위함수로 객체의 컨텍스트 내에서 코드 블록을 실행하며 임시 범위를 형성, 객체에 다음 할당 적용이라는 의미
          binding?.apply {
              lifecycleOwner = viewLifecycleOwner
              viewModel = sharedViewModel
              summaryFragment = this@SummaryFragment
          }
      }
  
      
      fun sendOrder() {
          Toast.makeText(activity, "Send Order", Toast.LENGTH_SHORT).show()
      }
  
     
      override fun onDestroyView() {
          super.onDestroyView()
          binding = null
      }
  }
  ```

- `OrderViewModel.kt`

  ```kotlin
  package com.example.cupcake.model
  
  import androidx.lifecycle.LiveData
  import androidx.lifecycle.MutableLiveData
  import androidx.lifecycle.Transformations
  import androidx.lifecycle.ViewModel
  import java.text.NumberFormat
  import java.text.SimpleDateFormat
  import java.util.Calendar
  import java.util.Locale
  
  
  private const val PRICE_PER_CUPCAKE = 2.00
  
  
  private const val PRICE_FOR_SAME_DAY_PICKUP = 3.00
  
  
  class OrderViewModel : ViewModel() {
  
      
      private val _quantity = MutableLiveData<Int>()
      val quantity: LiveData<Int> = _quantity
  
    
      private val _flavor = MutableLiveData<String>()
      val flavor: LiveData<String> = _flavor
  
     
      val dateOptions: List<String> = getPickupOptions()
  
      
      private val _date = MutableLiveData<String>()
      val date: LiveData<String> = _date
  
     
      private val _price = MutableLiveData<Double>()
      //가격에 현지 통화를 사용하도록 가격 형식 지정
      val price: LiveData<String> = Transformations.map(_price) {
         //가격을 현지 통화 형식으로 변환
          NumberFormat.getCurrencyInstance().format(it)
      }
  
      init {
         
          resetOrder()
      }
  
      
      fun setQuantity(numberCupcakes: Int) {
          _quantity.value = numberCupcakes
          updatePrice()
      }
  
     
      fun setFlavor(desiredFlavor: String) {
          _flavor.value = desiredFlavor
      }
  
      fun setDate(pickupDate: String) {
          _date.value = pickupDate
          updatePrice()
      }
  
     //주문의 맛이 설정되었는지 여부를 확인
      fun hasNoFlavorSet(): Boolean {
          return _flavor.value.isNullOrEmpty()
      }
  
    	//뷰 모델의 MutableLiveData 속성 재설정
      fun resetOrder() {
          _quantity.value = 0
          _flavor.value = ""
          _date.value = dateOptions[0]
          _price.value = 0.0
      }
  
      
      private fun updatePrice() {
          //당일 수령 요금을 포함하도록 가격 로직 변경
          var calculatedPrice = (quantity.value ?: 0) * PRICE_PER_CUPCAKE
          
          if (dateOptions[0] == _date.value) {
              calculatedPrice += PRICE_FOR_SAME_DAY_PICKUP
          }
          _price.value = calculatedPrice
      }
  
      //수령 날짜 목록을 만들고 반환
      private fun getPickupOptions(): List<String> {
          val options = mutableListOf<String>()
          //형식 지정 문자열
          val formatter = SimpleDateFormat("E MMM d", Locale.getDefault())
          val calendar = Calendar.getInstance()
          repeat(4) {
              options.add(formatter.format(calendar.time))
              calendar.add(Calendar.DATE, 1)
          }
          return options
      }
  }
  ```

- `acivity_main.xml`

  ```kotlin
  <?xml version="1.0" encoding="utf-8"?>
  <androidx.constraintlayout.widget.ConstraintLayout
      xmlns:android="http://schemas.android.com/apk/res/android"
      xmlns:app="http://schemas.android.com/apk/res-auto"
      xmlns:tools="http://schemas.android.com/tools"
      android:layout_width="match_parent"
      android:layout_height="match_parent"
      tools:context=".MainActivity">
  
      <androidx.fragment.app.FragmentContainerView
          android:id="@+id/nav_host_fragment"
          android:name="androidx.navigation.fragment.NavHostFragment"
          android:layout_width="0dp"
          android:layout_height="0dp"
          app:defaultNavHost="true"
          app:layout_constraintBottom_toBottomOf="parent"
          app:layout_constraintLeft_toLeftOf="parent"
          app:layout_constraintRight_toRightOf="parent"
          app:layout_constraintTop_toTopOf="parent"
          app:navGraph="@navigation/nav_graph" />
  
  </androidx.constraintlayout.widget.ConstraintLayout>
  ```

- `fragment_flavor.xml`

  ```kotlin
  <?xml version="1.0" encoding="utf-8"?>
  <layout xmlns:android="http://schemas.android.com/apk/res/android"
      xmlns:app="http://schemas.android.com/apk/res-auto"
      xmlns:tools="http://schemas.android.com/tools"
      tools:context=".FlavorFragment">
  	
  	//viewModel 레이아웃 변수 추가
      <data>
          <variable
              name="viewModel"
              type="com.example.cupcake.model.OrderViewModel" />
  
          <variable
              name="flavorFragment"
              type="com.example.cupcake.FlavorFragment" />
      </data>
  
      <ScrollView
          android:layout_width="match_parent"
          android:layout_height="match_parent">
  
          <androidx.constraintlayout.widget.ConstraintLayout
              android:layout_width="match_parent"
              android:layout_height="wrap_content"
              android:padding="@dimen/side_margin">
  
              <RadioGroup
                  android:id="@+id/flavor_options"
                  android:layout_width="wrap_content"
                  android:layout_height="wrap_content"
                  android:orientation="vertical"
                  app:layout_constraintStart_toStartOf="parent"
                  app:layout_constraintTop_toTopOf="parent">
  
                  <RadioButton
                      android:id="@+id/vanilla"
                      android:layout_width="wrap_content"
                      android:layout_height="wrap_content"
                     //선택 상태에 대한 결합 표현식
  android:checked="@{viewModel.flavor.equals(@string/vanilla)}"
                      android:onClick="@{() -> viewModel.setFlavor(@string/vanilla)}"
                      android:text="@string/vanilla" />
  				
                  <RadioButton
                      android:id="@+id/chocolate"
                      android:layout_width="wrap_content"
                      android:layout_height="wrap_content"
                      android:checked="@{viewModel.flavor.equals(@string/chocolate)}"
                      android:onClick="@{() -> viewModel.setFlavor(@string/chocolate)}"
                      android:text="@string/chocolate" />
  
                  <RadioButton
                      android:id="@+id/red_velvet"
                      android:layout_width="wrap_content"
                      android:layout_height="wrap_content"
                      android:checked="@{viewModel.flavor.equals(@string/red_velvet)}"
                      android:onClick="@{() -> viewModel.setFlavor(@string/red_velvet)}"
                      android:text="@string/red_velvet" />
  
                  <RadioButton
                      android:id="@+id/salted_caramel"
                      android:layout_width="wrap_content"
                      android:layout_height="wrap_content"
                      android:checked="@{viewModel.flavor.equals(@string/salted_caramel)}"
                      android:onClick="@{() -> viewModel.setFlavor(@string/salted_caramel)}"
                      android:text="@string/salted_caramel" />
  
                  <RadioButton
                      android:id="@+id/coffee"
                      android:layout_width="wrap_content"
                      android:layout_height="wrap_content"
                      android:checked="@{viewModel.flavor.equals(@string/coffee)}"
                      android:onClick="@{() -> viewModel.setFlavor(@string/coffee)}"
                      android:text="@string/coffee" />
              </RadioGroup>
  
              <View
                  android:id="@+id/divider"
                  style="@style/Widget.Cupcake.Divider"
                  android:layout_width="0dp"
                  android:layout_height="1dp"
                  android:layout_marginTop="@dimen/side_margin"
                  app:layout_constraintEnd_toEndOf="parent"
                  app:layout_constraintStart_toStartOf="parent"
                  app:layout_constraintTop_toBottomOf="@id/flavor_options" />
  
              <TextView
                  android:id="@+id/subtotal"
                  style="@style/Widget.Cupcake.TextView"
                  android:layout_width="wrap_content"
                  android:layout_height="wrap_content"
                  android:layout_marginTop="@dimen/side_margin"
                  android:text="@{@string/subtotal_price(viewModel.price)}"
                  app:layout_constraintEnd_toEndOf="parent"
                  app:layout_constraintTop_toBottomOf="@id/divider"
                  tools:text="Subtotal $5.00" />
  
              <Button
                  android:id="@+id/next_button"
                  android:layout_width="0dp"
                  android:layout_height="wrap_content"
                  android:layout_marginTop="@dimen/side_margin"
                  android:onClick="@{() -> flavorFragment.goToNextScreen()}"
                  android:text="@string/next"
                  app:layout_constraintBottom_toBottomOf="parent"
                  app:layout_constraintEnd_toEndOf="parent"
                  app:layout_constraintStart_toStartOf="parent"
                  app:layout_constraintTop_toBottomOf="@id/subtotal" />
  
          </androidx.constraintlayout.widget.ConstraintLayout>
      </ScrollView>
  </layout>
  ```

- `fragment_pickup.xml`

  ```kotlin
  <?xml version="1.0" encoding="utf-8"?>
  <layout xmlns:android="http://schemas.android.com/apk/res/android"
      xmlns:app="http://schemas.android.com/apk/res-auto"
      xmlns:tools="http://schemas.android.com/tools"
      tools:context=".PickupFragment">
  
  	//viewModel 레이아웃 변수 추가
      <data>
          <variable
              name="viewModel"
              type="com.example.cupcake.model.OrderViewModel" />
  
          <variable
              name="pickupFragment"
              type="com.example.cupcake.PickupFragment" />
      </data>
  
      <ScrollView
          android:layout_width="match_parent"
          android:layout_height="match_parent">
  
          <androidx.constraintlayout.widget.ConstraintLayout
              android:layout_width="match_parent"
              android:layout_height="wrap_content"
              android:padding="@dimen/side_margin">
  
              <RadioGroup
                  android:id="@+id/date_options"
                  android:layout_width="wrap_content"
                  android:layout_height="wrap_content"
                  android:orientation="vertical"
                  app:layout_constraintStart_toStartOf="parent"
                  app:layout_constraintTop_toTopOf="parent">
  
                  <RadioButton
                      android:id="@+id/option0"
                      android:layout_width="wrap_content"
                      android:layout_height="wrap_content"
                     //date값에 따라 checked 속성 설정
  android:checked="@{viewModel.date.equals(viewModel.dateOptions[0])}"
                      android:onClick="@{() -> viewModel.setDate(viewModel.dateOptions[0])}"
                      android:text="@{viewModel.dateOptions[0]}"
                      tools:text="Thursday" />
  
                  <RadioButton
                      android:id="@+id/option1"
                      android:layout_width="wrap_content"
                      android:layout_height="wrap_content"
                      android:checked="@{viewModel.date.equals(viewModel.dateOptions[1])}"
                      android:onClick="@{() -> viewModel.setDate(viewModel.dateOptions[1])}"
                      android:text="@{viewModel.dateOptions[1]}"
                      tools:text="Friday" />
  
                  <RadioButton
                      android:id="@+id/option2"
                      android:layout_width="wrap_content"
                      android:layout_height="wrap_content"
                      android:checked="@{viewModel.date.equals(viewModel.dateOptions[2])}"
                      android:onClick="@{() -> viewModel.setDate(viewModel.dateOptions[2])}"
                      android:text="@{viewModel.dateOptions[2]}"
                      tools:text="Saturday" />
  
                  <RadioButton
                      android:id="@+id/option3"
                      android:layout_width="wrap_content"
                      android:layout_height="wrap_content"
                      android:checked="@{viewModel.date.equals(viewModel.dateOptions[3])}"
                      android:onClick="@{() -> viewModel.setDate(viewModel.dateOptions[3])}"
                      android:text="@{viewModel.dateOptions[3]}"
                      tools:text="Sunday" />
              </RadioGroup>
  
              <View
                  android:id="@+id/divider"
                  style="@style/Widget.Cupcake.Divider"
                  android:layout_width="0dp"
                  android:layout_height="1dp"
                  android:layout_marginTop="@dimen/side_margin"
                  android:layout_marginBottom="@dimen/side_margin"
                  app:layout_constraintEnd_toEndOf="parent"
                  app:layout_constraintStart_toStartOf="parent"
                  app:layout_constraintTop_toBottomOf="@id/date_options" />
  
              <TextView
                  android:id="@+id/subtotal"
                  style="@style/Widget.Cupcake.TextView"
                  android:layout_width="wrap_content"
                  android:layout_height="wrap_content"
                  android:layout_marginTop="@dimen/side_margin"
                  android:text="@{@string/subtotal_price(viewModel.price)}"
                  app:layout_constraintEnd_toEndOf="parent"
                  app:layout_constraintTop_toBottomOf="@id/divider"
                  tools:text="Subtotal $5.00" />
  
              <Button
                  android:id="@+id/next_button"
                  android:layout_width="0dp"
                  android:layout_height="wrap_content"
                  android:layout_marginTop="@dimen/side_margin"
                  android:onClick="@{() -> pickupFragment.goToNextScreen()}"
                  android:text="@string/next"
                  app:layout_constraintBottom_toBottomOf="parent"
                  app:layout_constraintEnd_toEndOf="parent"
                  app:layout_constraintStart_toStartOf="parent"
                  app:layout_constraintTop_toBottomOf="@id/subtotal" />
  
          </androidx.constraintlayout.widget.ConstraintLayout>
      </ScrollView>
  </layout>
  ```

- `fragment_start.xml`

  ```kotlin
  <?xml version="1.0" encoding="utf-8"?>
  <layout xmlns:android="http://schemas.android.com/apk/res/android"
      xmlns:app="http://schemas.android.com/apk/res-auto"
      xmlns:tools="http://schemas.android.com/tools"
      tools:context=".StartFragment">
  	
      <data>
          <variable
              name="startFragment"
              type="com.example.cupcake.StartFragment" />
      </data>
  
      <ScrollView
          android:layout_width="match_parent"
          android:layout_height="match_parent">
  
          <LinearLayout
              android:layout_width="match_parent"
              android:layout_height="wrap_content"
              android:orientation="vertical"
              android:padding="@dimen/side_margin">
  
              <ImageView
                  android:layout_width="@dimen/image_size"
                  android:layout_height="@dimen/image_size"
                  android:layout_gravity="center_horizontal"
                  android:layout_marginTop="@dimen/margin_between_elements"
                  android:importantForAccessibility="no"
                  android:scaleType="center"
                  app:srcCompat="@drawable/cupcake" />
  
              <TextView
                  android:layout_width="wrap_content"
                  android:layout_height="wrap_content"
                  android:layout_gravity="center_horizontal"
                  android:layout_marginBottom="@dimen/side_margin"
                  android:text="@string/order_cupcakes"
                  android:textAppearance="?attr/textAppearanceHeadline4"
                  android:textColor="@color/material_on_background_emphasis_medium" />
  
              <Button
                  android:id="@+id/order_one_cupcake"
                  android:layout_width="wrap_content"
                  android:layout_height="wrap_content"
                  android:layout_gravity="center_horizontal"
                  android:layout_marginTop="@dimen/margin_between_elements"
                  android:minWidth="@dimen/order_cupcake_button_width"
                  android:onClick="@{() -> startFragment.orderCupcake(1)}"
                  android:text="@string/one_cupcake" />
  
              <Button
                  android:id="@+id/order_six_cupcakes"
                  android:layout_width="wrap_content"
                  android:layout_height="wrap_content"
                  android:layout_gravity="center_horizontal"
                  android:layout_marginTop="@dimen/margin_between_elements"
                  android:minWidth="@dimen/order_cupcake_button_width"
                  android:onClick="@{() -> startFragment.orderCupcake(6)}"
                  android:text="@string/six_cupcakes" />
  
              <Button
                  android:id="@+id/order_twelve_cupcakes"
                  android:layout_width="wrap_content"
                  android:layout_height="wrap_content"
                  android:layout_gravity="center_horizontal"
                  android:layout_marginTop="@dimen/margin_between_elements"
                  android:minWidth="@dimen/order_cupcake_button_width"
                  android:onClick="@{() -> startFragment.orderCupcake(12)}"
                  android:text="@string/twelve_cupcakes" />
          </LinearLayout>
      </ScrollView>
  </layout>
  ```

- `fragment_summary.xml`

  ```kotlin
  <?xml version="1.0" encoding="utf-8"?>
  <layout xmlns:android="http://schemas.android.com/apk/res/android"
      xmlns:tools="http://schemas.android.com/tools"
      tools:context=".SummaryFragment">
  
  	//viewModel 레이아웃 변수 추가
      <data>
          <variable
              name="viewModel"
              type="com.example.cupcake.model.OrderViewModel" />
  
          <variable
              name="summaryFragment"
              type="com.example.cupcake.SummaryFragment" />
      </data>
  
      <ScrollView
          android:layout_width="match_parent"
          android:layout_height="match_parent">
  
          <LinearLayout
              android:layout_width="match_parent"
              android:layout_height="wrap_content"
              android:orientation="vertical"
              android:padding="@dimen/side_margin">
  
              <!-- Group the order details into a single ViewGroup and set focusable = true,
                   so all fields will be read aloud together by the accessibility service -->
              <LinearLayout
                  android:layout_width="match_parent"
                  android:layout_height="wrap_content"
                  android:focusable="true"
                  android:orientation="vertical">
  
                  <TextView
                      android:id="@+id/quantity_label"
                      style="@style/Widget.Cupcake.TextView.OrderSummary"
                      android:layout_width="wrap_content"
                      android:layout_height="wrap_content"
                      android:text="@string/quantity"
                      android:textAllCaps="true"
                      android:textStyle="normal" />
  
                  <TextView
                      android:id="@+id/quantity"
                      style="@style/Widget.Cupcake.TextView.OrderSummary"
                      android:layout_width="wrap_content"
                      android:layout_height="wrap_content"
                      android:layout_marginTop="@dimen/order_summary_margin"
                      android:text="@{viewModel.quantity.toString()}"
                      tools:text="6 cupcakes" />
  
                  <View
                      android:id="@+id/divider1"
                      style="@style/Widget.Cupcake.Divider"
                      android:layout_width="match_parent"
                      android:layout_height="1dp"
                      android:layout_marginTop="@dimen/side_margin"
                      android:layout_marginBottom="@dimen/side_margin" />
  
                  <TextView
                      android:id="@+id/flavor_label"
                      style="@style/Widget.Cupcake.TextView.Label"
                      android:layout_width="wrap_content"
                      android:layout_height="wrap_content"
                      android:text="@string/flavor" />
  
                  <TextView
                      android:id="@+id/flavor"
                      style="@style/Widget.Cupcake.TextView.OrderSummary"
                      android:layout_width="wrap_content"
                      android:layout_height="wrap_content"
                      android:layout_marginTop="@dimen/order_summary_margin"
                      android:text="@{viewModel.flavor}"
                      tools:text="Chocolate" />
  
                  <View
                      android:id="@+id/divider2"
                      style="@style/Widget.Cupcake.Divider"
                      android:layout_width="match_parent"
                      android:layout_height="1dp"
                      android:layout_marginTop="@dimen/side_margin"
                      android:layout_marginBottom="@dimen/side_margin" />
  
                  <TextView
                      android:id="@+id/pickup_label"
                      style="@style/Widget.Cupcake.TextView.Label"
                      android:layout_width="wrap_content"
                      android:layout_height="wrap_content"
                      android:text="@string/pickup_date" />
  
                  <TextView
                      android:id="@+id/date"
                      style="@style/Widget.Cupcake.TextView.OrderSummary"
                      android:layout_width="wrap_content"
                      android:layout_height="wrap_content"
                      android:layout_marginTop="@dimen/order_summary_margin"
                      android:text="@{viewModel.date}"
                      tools:text="Sunday" />
  
                  <View
                      android:id="@+id/divider3"
                      style="@style/Widget.Cupcake.Divider"
                      android:layout_width="match_parent"
                      android:layout_height="1dp"
                      android:layout_marginTop="@dimen/side_margin"
                      android:layout_marginBottom="@dimen/margin_between_elements" />
  
                  <TextView
                      android:id="@+id/total"
                      style="@style/Widget.Cupcake.TextView.FinalPrice"
                      android:layout_width="wrap_content"
                      android:layout_height="wrap_content"
                      android:layout_gravity="end"
                      android:layout_marginTop="@dimen/side_margin"
                      android:text="@{@string/total_price(viewModel.price)}"
                      tools:text="Total $5.00" />
  
              </LinearLayout>
  
              <Button
                  android:id="@+id/send_button"
                  android:layout_width="match_parent"
                  android:layout_height="wrap_content"
                  android:layout_marginTop="@dimen/side_margin"
                  android:onClick="@{() -> summaryFragment.sendOrder()}"
                  android:text="@string/send" />
  
          </LinearLayout>
      </ScrollView>
  </layout>
  ```



##### &#128204;LiveData 변환을 사용하여 가격 형식 지정

- LiveData변환을 사용할 수 있는 실시간 예 
  - 표시할 날짜 및 시간 문자열 형식 지정
  - 항목 목록 정렬
  - 항목 필터링 또는 그룹화
  - 모든 항목 합계, 항목 수, 마지막 항목 반환 등과 같이 목록의 결과 계산



##### &#128204;요약

- `ViewMode`은 Android 아키텍처 구성요소의 일부이며, `ViewModel` 내에 저장된 앱 데이터는 구성 변경 중에도 유지됨
- 앱에 `ViewModel`을 추가하려면 새 클래스를 만들어 `ViewModel`클래스에서 확장
- 공유 `ViewModel`은 여러 프래그먼트의 앱 데이터를 단일 `ViewModel`에 저장하는 데 사용됨
- 앱의 여러 프래그먼트는 활동 범위를 사용하여 공유 `ViewModel`에 액세스
- `LifecycleOwner`는 활동이나 프래그먼트와 같이 Android 수명 주기를 보유한 클래스
- `LiveData` 관찰자는 수명 주기 소유자가 활성 상태(`STARTED` 또는 `RESUMED`)인 경우에만 앱 데이터의 변경사항을 관찰
- 리스너 결합은 `onClick` 이벤트와 같은 이벤트가 발생할 때 실행되는 람다 표현식
- 리스너 결합은`textview.setOnClickListener(clickListener)`와 같은 메서드 참조와 비슷하지만, 리스너 결합을 사용하면 임의의 데이터 결합 표현식을 실행할 수 있음
- `LiveData` 변환 메서드는 `LiveData` 소스에서 데이터 조작을 실행하고 결과 `LiveData` 객체를 반환하는 방법을 제공
- Android 프레임워크는 언어에 민감한 방식으로 날짜 형식을 지정하고 파싱하는 클래스인 `SimpleDateFormat`이라는 클래스를 제공, 이 클래스를 통해 날짜의 형식 지정(날짜 → 텍스트) 및 파싱(텍스트 → 날짜)이 가능



### 탐색 및 백 스택

##### &#128204;Up 버튼 동작 구현하기

- `MainActivity`에 다음 추가

  ```kotlin
  override fun onSupportNavigateUp(): Boolean {
  	return navController.navigateUp() || super.onSupportNavigateUp()
  }
  ```

  

##### &#128204;작업 및 백 스택 알아보기

- 작업 

  - 활동은 백 스택이라는 스택으로 배열되며, 사용자가 방문하는 각각의 새 활동은 작업의 백 스택으로 푸시됨
  - 백 스택은 사용자가 뒤로 이동하는 경우 유용함

- Cupcake 앱의 기본 동작

  - 이 앱에는 활동이 하나만 있지만 사용자가 탐색하는 프래그먼트 대상은 여러개 -> Back 버튼을 탭할 때마다 이전 프래그먼트 대상으로 돌아가야 함

- Cupcake 앱에서 백 스택 수정하기

  - 탐색 작업 추가하기
    - `nav_graph.xml`의  `summaryFragment`에서, `pickupFragment`에서, `flavorFragment`에서 클릭하고 드래그하여 각각 `startFragment`로 이어지는 새 작업 만들기

- 레이아웃에 Cancel 버튼 추가하기

  - `fragment_flavor.xml`에서 소계 텍스트 뷰와 **Next**버튼 사이에 **Cancel**버튼 추가

    ```kotlin
    <TextView
        android:id="@+id/subtotal" ... />
    
    <Button
        android:id="@+id/cancel_button"
    	style = "?attr/materialButtonOutlinedStyle"
        android:layout_marginEnd="@dimen/side_margin"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:text="@string/cancel"
        app:layout_constraintEnd_toStartOf="@id/next_button"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="@id/next_button" />
    
    <Button
        android:id="@+id/next_button"
        app:layout_constraintStart_toEndOf="@id/cancel_button"... />
    ```

  - 위와 같은 방법으로 `fragment_pickup.xml`레이아웃에 **Cancel**버튼 추가

- Cancel 버튼의 클릭 리스너 추가하기

  - `FlavorFragment`에 다음 `cancelOrder()`메서드 추가

    ```kotlin
    fun cancelOrder() {
    	sharedViewModel.resetOrder()
    	findNavController().navigate(R.id.action_flavorFragment_to_startFragment)
    }
    ```

  - `fragment_flavor.xml`의 **Cancel**버튼에 클릭 리스너 설정

    ```kotlin
    <Button 
    	android:id = "@+id/cancel_button"
    	android:onClick = "@{() -> flavorFragment.cancelOrder() }" .../>
    ```

  - 위와 동일한 프로세스를 `PickupFragment`와 `fragment_pickup.xml`에서 반복

  - 위와 동일한 프로세스를 `SummaryFragment`와 `fragment_summary.xml`에서 반복

- 백 스택에서 추가 대상 팝하기

  - 탐색 작업 : popUpTo 속성
    - 탐색 그래프의 탐색 작업에 `app:popUpTo`속성을 포함하면 지저오딘 대상에 도달할 때까지 대상 두 개 이상이 백 스택에서 팝될 수 있음
  - 탐색 작업 : popUpToInclusive 속성
    - `StartFragment`에 이르기까지 모든 대상을 백 스택에서 팝하도록 요청 
    - 적절한 탐색 작업에 `app:popUpTo = "@id/startFragment"` 및 `app:popUpToInclusive="true"`를 지정해 백 스택에서 새 `StartFragment`인스턴스를 하나만 생성
  - 탐색 작업 수정하기
    - `nav_graph.xml`에서 **Navigation Editor**로 이동하여 `summaryFragment`에서 `startFragment`로 이어지는 작업을 선택해 **popUpTo**를 `startFragment`로 설정
    - `pickupFragment`를 `startFragment`에 연결하는 작업에 위 과정 반복
    - `flavorFragment`를 `startFragment`에 연결하는 작업에 위 과정 반복



##### &#128204;주문 전송하기

- `SummaryFragment.kt`

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

- `strings.xml`에 다음 추가

  ```kotlin
  //수량에 따라 사용할 다른 문자열 리소스를 지정
  <plurals name="cupcakes">
      <item quantity="one">%d cupcake</item>
      <item quantity="other">%d cupcakes</item>
  </plurals>
  ...
  //order_details 문자열 리소를 업데이트하여 복수형 cupcakes가 더 이상 하드코딩되지 않도록 함
  <string name="order_details">Quantity: %1$s \n Flavor: %2$s \nPickup date: %3$s \n
          Total: %4$s \n\n Thank you!</string>
  ```



##### &#128204;요약

- Android에서는 방문한 모든 대상의 백 스택이 유지되며 각각의 새 대상이 스택으로 푸시됨
- **Up** 버튼이나 **Back** 버튼을 탭하면 대상을 백 스택에서 팝할 수 있음
- Jetpack 탐색 구성요소를 사용하면 프래그먼트 대상을 백 스택으로 푸시하고 백 스택에서 팝할 수 있으므로 기본 **Back** 버튼 동작을 직접 구현할 필요 없음 
- 속성 값에 지정된 대상에 이를 때까지 대상을 백 스택에서 팝하기 위해 탐색 그래프에서 작업에 `app:popUpTo` 속성을 지정
- `app:popUpTo`에 지정된 대상도 백 스택에서 팝해야 하는 경우 작업에 `app:popUpToInclusive="true"`를 지정
- `Intent.ACTION_SEND`를 사용하고 `Intent.EXTRA_EMAIL`, `Intent.EXTRA_SUBJECT`, `Intent.EXTRA_TEXT` 등의 인텐트 추가항목을 채워 이메일 앱에 콘텐츠를 공유하도록 암시적 인텐트를 만들 수 있음
- 수량에 따라 서로 다른 문자열 리소스(예: 단수형 또는 복수형)를 사용하려면 `plurals` 리소스를 사용



#### &#128204;Quiz

1. 여러 활동 또는 프래그먼트에 동일한 ViewModel을 사용하여 데이터를 공유할 수 있음

   :point_right: 참

2. Kotlin 속성 위임 접근법을 사용하여 공유 뷰 모델에 액세스할 수 있는 올바른 방법

   - `val viewModel: OrderViewModel by activityViewModels()`

3. LiveData `Transformations`를 사용하여 다른 인스턴스의 값에 따라 다양한 LiveData 인스턴스를 반환한다.

4. `apply`함수를 사용하여 객체를 구성하는 방법

   - 객체에 할당 세트를 적용

5. 데이터 결합 레이아웃 표현식을 사용할 때 클릭 리스너를 결합하기 위해 이 레이아웃의 버튼에 속성을 추가하는 올바른 구문

   ```kotlin
   <Button
       android:id="@+id/next_button"
       android:layout_width="wrap_content"
       android:layout_height="wrap_content"
       android:text="@string/next" />
   ```

   - `android:onClick="@{() -> detailFragment.next()}"`

