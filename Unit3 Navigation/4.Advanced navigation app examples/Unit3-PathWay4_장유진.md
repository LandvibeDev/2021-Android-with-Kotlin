

# 2021 Landvibe Summer Coding - Android



## Unit3 : Navigation

## PathWay4 : Advanced navigation app examples



### Shared ViewModel

- **cupcake-app-starter 만들기** 
  - **MainActivity.kt**
    - 활동의 콘텐츠 뷰를 `activity_main.xml`로 설정하는 기본 생성 코드와 유사한 코드가 존재
    - `super.onCreate(savedInstanceState)`의 일부로 확장될 레이아웃을 포함하는 매개변수화된 생성자 `AppCompatActivity(@LayoutRes int contentLayoutId)`를 사용
  - **fragment_start.xml**
    - 앱에 표시되는 첫 번째 화면
    - 컵 케이크의 이미지와 주문할 컵케이크 수를 선택할 수 있는 버튼3개가 존재
  - **fragment_flavor.xml**
    - 컵케이크 맛 목록이 라디오 버튼 옵션으로 표시되며 Next 버튼 존재
  - **fragment_pickup.xml**
    - 수령일을 선택하는 옵션과 요약 화면으로 이동할 수 있는 Next 버튼 존재
  - **fragment_summary.xml**
    - 수량, 맛과 같은 주문 세부정보의 요약이 표시되며 주무을 다른 앱으로 전송하는 버튼 존재
  - **StartFragment.kt**
    - 앱에 표시되는 첫 번째 화면
    - 3개의 버튼을 위한 클릭 핸들러 및 뷰 결합 코드 존재
  - **FlaverFragment.kt, PickupFragment.kt, SummaryFragment.kt**
    - 대부분 상용구 코드와 톳트 메시지를 표시하는 Next 또는 Send Order to Another App 버튼의 클릭 핸들러 존재
  - **res 폴더**
    - `drawable` : 첫 번째 화면의 컵 케이크 애셋뿐 아니라 런처 아이콘 파일 존재
    - `navigation/nav_graph.xml` : 작업이 없는 4개의 프래그먼트 대상(`startFragment`, `flaovrFragment`, `pickupFragment`, `summaryFragment`)이 있음.
    - `values`  앱 테마를 맞춤설정하는 데 사용되는 색상, 크기, 문자열, 스타일, 테마가 존재
- 정리
  - `ViewModel`은 Android 아키텍쳐 구성요소의 일부이며, `ViewModel` 내에 저장된 앱 데이터는 구성 변경 중에도 유지됨.
  - 공유 `ViewModel`은 여러 프래그먼트의 앱 데이터를 단일 `ViewModel`에 저장하는데 사용됨. 앱의 여러 프래그먼트는 활동 범위를 사용하여 공유 `ViewModel`에 엑세스 함.
  - `LifecycleOwner`는 활동이나 프래그먼트와 같이 Android 수명 주기를 보유한 클래스이다.
  - `LiveData` 관찰자는 수명 주기 소유자가 활성 상태(`STARTED` 또는 `RESUMED`)인 경우에만 앱 데이터의 변경사항을 관찰함.
  - 리스너 결합은 `onClick` 이벤트와 같은 이벤트가 발생할 때 실행되는 람다 표현식임.
  - Android 프레임워크는 언어에 민감한 방식으로 날짜 형식을 지정하고 파싱하는 클래스인 `SimpleDataFormat` 이라는 클래스를 제공함. 이 클래스를 통해 날짜의 형식 지정(날짜->텍스트) 및 파싱(텍스트 -> 날짜)이 가능함.

### Navigation and the backstack

- 작업 및 백 스택

  <img src="img\Unit3-Pathway4-1_장유진.png" style="zoom:70%;" />

  - 취소 버튼 눌렀을 때

    <img src="img\Unit3-Pathway4-2_장유진.png" style="zoom:60%;" />

- 요약

  - Android에서는 방문한 모든 대상의 백 스택이 유지되며 각각의 새 대상이 스택으로 푸시됨

  - Up 버튼이나 Back 버튼을 탭하면 대상을 백 스택에서 팝 할 수 있음

  - Jetpack 탐색 구성요소를 사용하면 프래그먼트 대상을 백 스택으로 푸시하고 백 스택에서 팝할 수 있으므로 기본 Back 버튼 동작을 직접 구현할 필요가 없음.

    ```kotlin
    override fun onSupportNavigateUp(): Boolean {
            return navController.navigateUp() || super.onSupportNavigateUp()
        }
    ```

  - 속성 값에 지정된 대상에 이를 때까지 대상을 백 스택에서 팝하기 위해 탐색 그래프에서 작업에 `app:popUpTo` 속성을 지정함

  - `app:popUpTo`에 지정된 대상도 백 스택에 팝해야 하는 경우에 `app:popUpToInclusive="true"`를 지정함

  - `Intent.ACTION_SEND`를 사용하고 `Intent.EXTRA_EMAIL`, `Intent.EXTRA_SUBJECT`, `Intent.EXTRA_TEXT` 등의 인텐트 추가 항목을 채워 이메일 앱에 콘텐츠를 공유하도록 암시적 인텐트를 만들 수 있음

  - 수량에 따라 서로 다른 문자열 리소스(예 : 단수형 or 복수형)를 사용하려면 `plurals` 리소스를 사용함.


### Quiz

1. **True or False : You can use the same ViewModel for multiple Activities or Fragments to share data**

   --> True
   
2. **What is the correct way to access the shared view model using the Kotlin property delegate approach?**

   --> `val viewModel : OrderViewModel by activityViewModels()`
   
3. **Fill-in-the-blanks**

   **Use the LiveData ____ to return a different LiveData instance based on the value of another instance.** 

   --> Transformations

4. **How can the `apply` function in Kotlin be used to configure an object ** 

   --> It can apply a set of assignments to the object

5. **Using a data binding layout expression, what's the correct syntax for adding an attribute to the button in this layout in order to bind a click listener to it? **

   ```kotlin
   <Button
   	android:id="@+id/next_button"
   	android:layout_width="wrap_content"
   	android:layout_height="wrap_content"
   	android:text="@string/next"	/>
   ```

   --> `android:onClick()="@{()->detailFragment.next()}"`

