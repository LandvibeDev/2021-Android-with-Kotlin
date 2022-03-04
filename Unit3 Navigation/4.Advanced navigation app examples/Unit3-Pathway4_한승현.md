# Pathway 4. Advanced Navigation Examples

# Unit3-Pathway4

- **프래그먼트 간 공유되는 ViewModel**
    
    <aside>
    💡 **Shared ViewModel**을 사용하여 동일한 액티비티의 프래그먼트 간에 데이터를 공유하는 방법 및 `**LiveData`** 변환과 같은 새로운 개념을 알아보자.
    
    </aside>
    
    - **학습할 내용**
        - 고급 사용 사례 내에서 권장 앱 아키텍처 사례를 구현하는 방법
        - 액티비티의 프래그먼트 간에 공유 `ViewModel` 을 사용하는 방법
        - `LiveData` 변환을 적용하는 방법
    - **Navigation Graph 되짚어보기**
        - Navigation Component를 사용하려면,
            - Jetpack Navigation 라이브러리를 포함하고,
            - 액티비티에 `NavHost` 를 추가하고,
            - nav_graph를 만들고,
            - nav_graph에 프래그먼트 대상을 추가하고,
            - Start Destination을 지정하고,
            - 프래그먼트 대상을 연결한다.
        - 실제 Kotlin 코드에서는,
            - `findNavController()` 메서드를 사용하여 `NavController` 를 가져오고, 거기에서 `navigate()` 메서드에 action의 id를 전달하여 nav_graph대로 동작하게끔 구현할 수 있다.
        - Navigation Component를 활용하여 앱 바에서 제목을 업데이트하려면,
            - `NavHostFragment` 에서 `NavController` 의 인스턴스를 가져오고,
            - `setupActionBarWithNavController(navController)` 를 호출하여 `NavController` 의 인스턴스를 전달한다. 이렇게 하면, 대상의 라벨을 기반으로 앱 바에 제목이 표시되며, 최상위 대상에 있지 않은 경우 항상 뒤로 버튼(화살표)이 표시된다.
            - `nav_graph.xml` 의 각 프래그먼트 대상의 `android:label` 속성을 설정하면,
            - 프래그먼트 대상의 라벨을 기반으로 앱 바에 제목이 표시된다.
    - **Shared ViewModel 만들기**
        - `Shared ViewModel` 을 사용하여 앱의 데이터를 단일 ViewModel에 저장할 수 있다.
        - **ViewModel 권장사항 준수**
            - ViewModel에서는 뷰 모델 데이터를 `public` 변수로 노출하지 않는 것이 좋다.
            - public 변수로 노출할 경우, 앱 데이터가 외부 클래스에 의해 예상치 못한 방식으로 수정될 수 있기 때문이다.
            - 변경 가능한 속성을 `private` 으로 만들고, 지원 속성을 구현하며, 필요한 경우 각 속성의 변경 불가능한 `public` 버전을 노출한다.
            - 변경 가능한 `private` 속성의 이름 앞에는 밑줄 `_` 을 붙이는 것이 일반적이다.
                
                ```kotlin
                private val _quantity = MutableLiveData<Int>(0)
                val quantity: LiveData<Int> = _quantity
                
                private val _flavor = MutableLiveData<String>("")
                val flavor: LiveData<String> = _flavor
                
                private val _date = MutableLiveData<String>("")
                val date: LiveData<String> = _date
                
                private val _price = MutableLiveData<Double>(0.0)
                val price: LiveData<Double> = _price
                ```
                
            - `setter` 메서드는 ViewModel 외부에서 호출되어야 하므로 `public` 메서드로 둔다.
                
                ```kotlin
                fun setQuantity(numberCupcakes: Int) {
                    _quantity.value = numberCupcakes
                }
                
                fun setFlavor(desiredFlavor: String) {
                    _flavor.value = desiredFlavor
                }
                
                fun setDate(pickupDate: String) {
                    _date.value = pickupDate
                }
                ```
                
    - **ViewModel을 사용하여 UI 업데이트**
        - Shared ViewModel을 사용하려면 `viewModels()` 대리자 클래스 대신 `activityViewModels()` 를 사용하여 `ViewModel` 을 초기화합니다.
            - `viewModels()` 는 현재 프래그먼트로 범위가 지정된 `ViewModel` 인스턴스를 제공하고, 따라서 인스턴스는 프래그먼트마다 다르다.
            - `activityViewModels()` 는 현재 액티비티로 범위가 지정된 `ViewModel` 인스턴스를 제공한다. 따라서 인스턴스는 동일한 액티비티의 여러 프래그먼트 간에 동일하게 유지된다.
        - **Kotlin 속성 위임 사용**
            - Kotlin에는 `var` 속성에 자동으로 생성되는 기본 setter 및 getter 함수가 있으며, 값을 쓰거나 읽을 때 setter 및 getter 함수가 호출된다. `val` 속성의 경우는 getter 함수만 생성되며, 읽을 때 getter 함수가 호출된다.
            - **Kotlin에서 속성 위임을 사용하면 getter-setter 책임을 다른 클래스에 넘길 수 있다**.
            - 대리자 속성은 `by` 절 및 대리자 클래스 인스턴스를 사용하여 정의된다.
                
                ```kotlin
                // Syntax for property delegation
                var <property-name> : <property-type> by <delegate-class>()
                
                // Example for ViewModel
                private val sharedViewModel: OrderViewModel by activityViewModels()
                ```
                
    - **DataBinding과 ViewModel 사용**
        - DataBinding을 설정하고 업데이트를 자동으로 설정하면 코드에서 UI를 직접 업데이트하는 것을 잊은 경우 오류 발생 가능성을 줄일 수 있다.
        - **`apply` 범위 함수**
            - `apply` 는 Kotlin 표준 라이브러리의 범위 함수이다.
            - 이 함수는 객체의 컨텍스트 내에서 코드 블록을 실행하며, 임시 범위를 형성한다.
            - 이 범위에서 이름을 사용하지 않고 객체에 액세스할 수 있다.
            - `apply` 의 일반적인 사용 사례는 객체를 구성하는 것이다.
                - 이 함수 호출은 ‘객체에 다음 할당 적용’ 으로 읽을 수 있다.
                    
                    ```kotlin
                    clark.apply {
                        firstName = "Clark"
                        lastName = "James"
                        age = 18
                    }
                    
                    // The equivalent code without apply scope function would look like the following.
                    
                    clark.firstName = "Clark"
                    clark.lastName = "James"
                    clark.age = 18
                    ```
                    
        - **리스너 결합**
            - 리스너 결합은 `onClick` 이벤트와 같은 이벤트가 발생할 때 실행되는 람다 표현식이다.
            - `view.setOnClickListener(clickListener)` 와 같은 메서드 참조와 비슷하나, 리스너 결합을 사용하면 임의의 DataBinding 표현식을 실행할 수 있다.
                
                ```xml
                <RadioButton
                       android:id="@+id/vanilla"
                       ...
                       android:onClick="@{() -> viewModel.setFlavor(@string/vanilla)}"
                       .../>
                ```
                
            - ViewModel 뿐만 아니라 액티비티나 프래그먼트도 DataBinding의 variable로 활용할 수 있으며, 마찬가지로 리스너 결합 또한 사용할 수 있다.
        - **init ViewModel**
            - `ViewModel` 클래스에 `init` 블록을 추가하고, 블록 내에서 `ViewModel`의 `MutableLiveData` 속성을 재설정하면 `ViewModel` 인스턴스를 만들 때 `init` 블록을 사용하여 속성을 초기화할 수 있다.
        - **elvis 연산자**
            - `?:` 은 엘비스 연산자라고 부르며, 왼쪽의 표현식이 null이 아니면 왼쪽의 표현식을, null이면 오른쪽의 표현식을 사용한다는 의미이다.
        - **LiveData를 관찰하도록 LifecycleOwner 설정**
            - `**LifecycleOwner**` 는 액티비티나 프래그먼트와 같이 Android 수명 주기를 보유한 클래스이다.
            - **`LiveData`** 관찰자는 LifecycleOwner가 활성 상태(`STARTED` or `RESUMED`)일 때만 앱 데이터의 변경사항을 관찰한다.
            - DataBinding을 사용하려면 관찰 가능한 값이 변경되는 경우 결합된 UI 요소가 자동으로 업데이트되는데, 자동으로 업데이트하려면 `binding.lifecycleOwner` 를 앱의 `LifecycleOwner` 와 연결해야 한다.
                
                ```kotlin
                binding?.apply {
                    lifecycleOwner = viewLifecycleOwner
                    ...
                }
                ```
                
- **Navigation 및 back stack**
    
    <aside>
    💡 앱의 작업과 백스택이 처리되는 방법을 알아보자.
    
    </aside>
    
    - **학습할 내용**
        - 탐색이 앱의 백스택에 미치는 영향
        - 맞춤 백스택 동작을 구현하는 방법
    - **Up 버튼(뒤로가기) 동작 구현**
        - `onSupportNavigationUp()` 메서드를 오버라이드하는 코드를 추가하고,
        - `navController.navigateUp()` 을 내부에서 호출하거나 `super.onSupportNavigateUp()` 으로 대체되도록 코드를 구현한다.
            
            ```kotlin
            override fun onSupportNavigateUp(): Boolean {
               return navController.navigateUp() || super.onSupportNavigateUp()
            }
            ```
            
    - **작업 및 백스택 알아보기**
        - Android에서 액티비티는 작업 내에 존재한다. 작업은 사용자가 특정한 일을 할 때 상호작용하는 액티비티의 모음이다.
        - 액티비티 **백스택**이라는 스택으로 배열되며, 사용자가 방문하는 각각의 새 액티비티는 작업의 백스택으로 푸시된다.
        - 스택의 맨 위에 있는 액티비티는 사용자가 현재 상호작용하고 있는 액티비티이고, 스택에서 그 아래에 있는 액티비티는 백그라운드로 전환되었다가 중지되었다.
            
            > **참고:** 앱을 연 후에 기기에서 **Home**을 탭하면 앱의 전체 작업이 백그라운드로 전환됩니다. 앱의 런처 아이콘을 다시 탭하면 Android는 앱의 기존 작업이 있는지 확인한 후 기존 작업을 포그라운드로 가져옵니다(백 스택은 그대로 유지함). 기존 작업이 없는 경우 Android는 자동으로 새 작업을 생성하고 기본 액티비티을 실행하여 백 스택으로 푸시합니다.
            > 
        - 같은 방법으로, Jetpack Navigation Component의 도움으로 사용자가 방문한 프래그먼트 대상도 추적할 수 있다.
        - Navigation 라이브러리를 사용하면 사용자가 **Back** 버튼을 누를 때마다 백스택에서 프래그먼트 대상을 없앨 수 있다.
        - **백스택에서 프래그먼트 하나씩 제거하는 것이 아니라 첫 프래그먼트로 이동하고싶다면?**
            - `nav_graph.xml` 에서 각 프래그먼트 대상에서 첫 프래그먼트 대상(Start Destination)으로 연결하고, `app:popUpTo="@id/startFragment"` 및 `app:popUpToInclusive="true"` 를 지정한다.
            - **Cancel** 버튼을 눌렀을 때,
                - `ViewModel` 의 속성을 초기화하고,
                - `findNavController().navigate(첫 프래그먼트로 이동하는 action의 id)` 를 호출한다.
            - 이렇게 하면, nav_graph의 action에 의해 첫 프래그먼트로 이동하며, `popUpTo` 관련 속성에 따라 백스택이 `POP` 된다.
    - **암시적 인텐트로 이메일 보내기**
        - `Intent.ACTION_SEND` 를 사용해 이메일을 보내는 작업을 설정하고, `Intent.EXTRA_SUBJECT` 및 `Intent.EXTRA_TEXT` 를 사용하여 이메일 제목과 이메일 본문을 설정할 수 있으며 `Intent.EXTRA_EMAIL` 을 사용하여 이메일 수신자를 지정할 수 있다.
        - 암시적 인텐트이기 때문에 이 인텐트를 처리할 특정 구성요소나 앱을 사전에 몰라도 된다.
- **ViewModel 및 LiveData 테스트**
    
    <aside>
    💡 **ViewModel** 및 **LiveData**의 단위 테스트를 작성하는 방법을 알아보자.
    
    </aside>
    
    - **학습할 내용**
        - `ViewModel` 및 `LiveData` 의 단위 테스트를 작성하는 방법
    - **ViewModel 테스트 작성**
        - `LiveData` 객체가 기본 스레드를 호출하면 안 된다고 지정하려면 `LiveData` 객체를 테스트할 때 특정 테스트 규칙을 지정해야 한다.
            
            ```kotlin
            @get:Rule
            var instantTaskExecutorRule = InstantTaskExecutorRule()
            ```
            
        - `setQuantity` 가 호출될 때 `ViewModel` 의 `quantity` 객체가 업데이트 되었는지 확인할 때, 변경사항을 내보내려면 `LiveData` 객체의 값을 테스트할 때 객체를 관찰해야 한다. 이를 위해 간단한 방법은 `observeForever` 메서드를 사용하는 것이다.
            
            ```kotlin
            val viewModel = OrderViewModel()
            viewModel.quantity.observeForever {}
            viewModel.setQuantity(12)
            ```
            
        - `LiveData` 객체는 값 자체가 아니므로, 다음과 같이 어설션을 만든다.
            
            ```kotlin
            assertEquals(12, viewModel.quantity.value)
            ```
            
        - 테스트는 다음과 같이 표시된다.
            
            ```kotlin
            @Test
            fun quantity_twelve_cupcakes() {
               val viewModel = OrderViewModel()
               viewModel.quantity.observeForever {}
               viewModel.setQuantity(12)
               assertEquals(12, viewModel.quantity.value)
            }
            ```
            
- **Quiz**
    1. **True or False: You can use the same ViewModel for multiple Activities or Fragments to share data.**
        
        `**TRUE**`
        
    2. **What is the correct way to access the shared view model using the Kotin property delegate approach?**
        
        **`val viewModel: OrderViewModel by activityViewModels()`**
        
    3. **Fill-in-the-blanks**
    *Enter one or more words to complete the sentence.*
    **Use a LiveData `Transformations`  to return a different LiveData instance based on the value of another instance.**
    4. **How can the `apply` function in Kotlin be used to configure an object?**
        
        **`It can apply a set of assignments to the object`**
        
    5. **Using a data binding layout expression, what’s the correct syntax for adding an attribute to the button in this layout in order to bind a click listener to it?**
        
        ```xml
        <Button
            android:id="@+id/next_button"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="@string/next" />
        ```
        
        **`android:onClick="@{() -> detailFragment.next()}"`**