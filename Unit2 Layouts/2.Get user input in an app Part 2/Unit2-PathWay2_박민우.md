# 🔥 Unit 2 : Layouts

## Pathway 2 : Get user input in an app Part 2

## 🎖 Track 1 : change the app theme

### 디자인 및 색상

+ 머터리얼 디자인은 물체가 빛을 반사하고 그림자를 드리우는 방식을 포함하여 실제 세계와 질감에서 영감을 받았습니다. 읽기 쉽고 매력적이며 일관된 방식으로 앱 UI를 빌드하는 방법에 관한 가이드라인을 제시합니다

<img src = "https://user-images.githubusercontent.com/31370590/125562774-35b060d6-1025-4ee6-9c51-d8093ab0525f.PNG" width = "400" height = "200">

+ **색상**은 색의 빨간색, 녹색, 파란색(RGB) 구성요소를 나타내는 3개의 16진수 숫자(#00~#FF(0~255))로 표현할 수 있습니다. 숫자가 클수록 구성요소의 색이 더 많이 포함됩니다. 또한, 색상은 투명도를 나타내는 알파 값(#00~#FF)을 포함하여 정의할 수 있습니다(#00=0%=완전 투명, #FF=100%=완전 불투명)



### 테마

+ **테마**는 개별 `View`뿐 아니라 앱, 활동 또는 뷰 계층 구조 전체에 적용되는 스타일의 모음입니다. 앱, 활동, 뷰 또는 뷰 그룹에 테마를 적용하면 요소와 하위 요소 전체에 동일한 테마가 적용됩니다. 또한, 테마를 사용하여 뷰가 아닌 요소(상태 표시줄 및 창 배경)에도 스타일을 적용할 수 있습니다.



## 🎖 Track 2 : change the app icon

### 런처 아이콘

+ 목표는 **기기 모델이나 화면 밀도와 상관없이 런처 아이콘의 모양을 멋지게(선명하고 명확)** 만드는 것입니다. 특히 **화면 픽셀 밀도**는 **화면의 인치당 픽셀 수**(또는 dpi, 인치당 도트 수)를 나타냅니다. 중밀도 기기(mdpi)의 경우 화면의 인치당 도트 수가 160이지만 초초초고밀도 기기(xxxhdpi)는 화면의 인치당 도트 수가 640입니다.

+ 소스 디렉터리(**app > src > main > res**)의 `mipmap` 폴더 : Andriod 앱의 런처 아이콘 에셋을 배치해야 하는 위치이다. 

  ex) mimmap-hdpi

  

+ Android의 밀도 한정자(density qualifier)

  + `mdpi` - 중밀도 화면의 리소스(~160dpi)
  + `hdpi` - 고밀도 화면의 리소스 (~240dpi)
  + `xhdpi` - 초고밀도 화면의 리소스(~320dpi)
  + `xxhdpi` - 초초고밀도 화면의 리소스(~480dpi)
  + `xxxhdpi` - 초초초고밀도 화면의 리소스(~640dpi)
  + `nodpi` - 화면의 픽셀 밀도와 관계없이 조정할 수 없는 리소스
  + `anydpi` - 어떤 밀도로도 조정 가능한 리소스



### 적응형 아이콘(adaptive icon)

+ 이는 **어떤 기기나 밀도에서든 획일화된 아이콘 스타일을 가질 수 있도록** 해주는 아이콘 스타일이다. 간단하게 말하자면 마스킹 처리해서 아이콘을 보여주는 형태입니다. 배경 레이어(Background-Layer)와 포그라운드 레이어(Foreground-Layer)를 합한 레이어를 마스크 레이어(Mask-Layer)를 적용해서 보여주는 방식으로 구현되어 있습니다. 

+ Foreground and bachground layer

  개발자는 앱 아이콘을 두 레이어, 즉 **포그라운드 레이어**와 **백그라운드 레이어**로 구성할 수 있습니다. 위 예에서 흰색 Android 아이콘은 포그라운드 레이어에 있지만 파란색과 흰색 그리드는 백그라운드 레이어에 있습니다. 포그라운드 레이어는 백그라운드 레이어 위에 쌓입니다. 그런 다음 마스크(이 경우에는 원형 마스크)가 맨 위에 적용되어 원형 모양의 앱 아이콘이 생성됩니다.

+ **vector drawble**(res->drawable->ic_launcher_background)과 **bitmap image**(res->mipmap-~dpi->ic_launcher)는 모두 그래픽을 설명하지만 중요한 차이점이 있습니다.

  **비트맵 이미지**는 각 픽셀의 색상 정보를 제외하고 보유한 이미지에 관해 잘 알지 못합니다. 반면에 벡터 그래픽은 이미지를 정의하는 모양을 그리는 방법을 알고 있습니다. 이러한 지침은 색상 정보와 함께 일련의 점과 선, 곡선으로 구성됩니다. 벡터 그래픽은 **화질 저하 없이 모든 화면 밀도의 어떤 캔버스 크기로도 조정할 수 있다**는 것이 장점입니다.

  **벡터 드로어블**은 Android의 벡터 그래픽 구현으로, 휴대기기에서 충분히 유연하도록 만들어졌습니다. 이러한 가능한 요소를 사용하여 **XML로 정의**할 수 있습니다. 모든 밀도 버킷에 비트맵 애셋 버전을 제공하는 대신 이미지를 한 번만 정의하면 됩니다. 따라서 앱의 크기가 줄어 유지하기가 쉬워집니다.
  
+ 어댑티브 아이콘에 사용하는 백그라운드 레이어와 포그라운드 레이어는 모두 **108x108dp**로 설정해야하며, 마스킹 되는 화면 영역은 최대 **72x72dp**, 최소 **66x66dp**로 설정합니다 

+ 이제 적응형 아이콘이 잘 작동하므로 모든 앱 아이콘 비트맵 이미지를 제거할 수 없는 이유가 궁금할 수 있습니다. 이전 버전의 Android에서 앱 아이콘이 고화질로 표시되기 위해(이전 버전과의 호환성이라고 함) 이러한 파일이 여전히 필요합니다.



Q)

+ drawable->**ic_launcher_background.xml**과  **drawable-v24->ic_launcher_foreground.xml** 모두 **vector drawble file**입니다. 픽셀 단위의 고정된 크기는 없다. 코드를 보면 `<vector>`요소를 사용해 벡터 드로어블의 XML선언을 확인할 수 있다. 

+ 이 두개의 벡터 드로어블 파일을 이용해 res > mipmap-anydpi-v26->**ic_launcher.xml** 같은 **적응형 아이콘**을 만드는 것

+ res->mipmap-~dpi->ic_launcher.**png**는 비트맵 이미지 파일(사진 같은 것은 일련의 모양으로 설명하기 어렵기 때문에 벡터 드로어블보다 비트랩 에셋을 사용하는 것이 더 효율적이다.)

  > **참고**: 적응형 아이콘은 플랫폼의 API 수준 26에서 추가되었으므로 `-v26` 리소스 한정자가 있는 `mipmap` 리소스 디렉터리에서 적응형 아이콘을 선언해야 합니다. 즉, 이 디렉터리의 리소스는 API 26(Android 8.0) 이상을 실행하는 기기에만 적용됩니다. 이 디렉터리의 리소스 파일은 이전 버전의 플랫폼을 실행하는 기기에서는 무시됩니다.



## 🎖 Track 3 : Create a more polished user experience

### material component

+ 머티리얼 구성요소는 앱에서 머티리얼 스타일을 더 쉽게 구현할 수 있는 일반적인 UI 위젯입니다. 머티리얼 구성요소를 사용하면 앱이 사용자 기기에 있는 다른 앱과 함께 더 일관된 방식으로 작동합니다. 이렇게 하면 한 앱에서 학습된 UI 패턴이 다음 앱에 이전될 수 있습니다. 따라서 사용자는 앱을 사용하는 방법을 훨씬 더 빠르게 배울 수 있습니다. 가능하면 항상 (비 머티리얼 위젯이 아닌) 머티리얼 구성요소를 사용하는 것이 좋습니다또한 머티리얼 구성요소는 유연성과 맞춤설정 가능성이 더 높습니다

+ 현재 팁 계산기 앱의 레이아웃 상단에는 서비스 비용을 위한 `EditText` 필드가 있습니다. 이 `EditText` 필드는 작동하지만 텍스트 필드의 모양과 동작 방식에 관한 최근 머티리얼 디자인 가이드라인을 따르지는 않습니다. 서비스 비용 `EditText`를 머티리얼 텍스트 필드(`TextInputLayout`와 `TextInputEditText`로 구성됨)로 바꿉니다. 

  ```kotlin
  <com.google.android.material.textfield.TextInputLayout
    android:id="@+id/cost_of_service"
     android:layout_width="160dp"
     android:layout_height="wrap_content"
     android:hint="@string/cost_of_service"
     app:layout_constraintStart_toStartOf="parent"
     app:layout_constraintTop_toTopOf="parent">
  
    <com.google.android.material.textfield.TextInputEditText
         android:id="@+id/cost_of_service_edit_text"
         android:layout_width="match_parent"
         android:layout_height="wrap_content"
         android:inputType="numberDecimal" />
      />
  
  </com.google.android.material.textfield.TextInputLayout>
  ```

+  `TextInputEditText` 요소에서 리소스 ID가 `cost_of_service_edit_text`인 사용자 입력을 가져옵니다. `MainActivity`에서 `binding.costOfServiceEditText`를 사용하여 저장된 텍스트 문자열에 액세스합니다. 

  ```kotlin
  private fun calculateTip() {
      // Get the decimal value from the cost of service text field
      val stringInTextField = binding.costOfServiceEditText.text.toString()
      val cost = stringInTextField.toDoubleOrNull()
  
      ...
  }

+ Android 플랫폼의 `Switch` 대신 MDC 라이브러리의 `SwitchMaterial`을 사용할 때 이점은 라이브러리의 `SwitchMaterial` 구현이 업데이트되면(예: 머티리얼 디자인 가이드라인 변경) 직접 변경하지 않고도 무료로 위젯이 업데이트된다는 점입니다. 덕분에 미래에 대비한 앱을 마련할 수 있습니다.





### 아이콘

+ 앱의 아이콘의 경우 다양한 화면 밀도에 맞는 여러 버전의 비트맵 이미지를 제공하는 대신 **벡터 드로어블**을 사용하는 것이 좋습니다. 벡터 드로어블은 이미지를 구성하는 실제 픽셀을 저장하는 대신 ***이미지를 만드는 방법에 관한 지침을 저장하는 XML 파일***로 표현됩니다. 벡터 드로어블은 시각적 품질 손실이나 파일 크기 증가 없이 확장하거나 축소할 수 있습니다. 



+ 이전 안드로이드 버전 지원하기

  앱에 벡터 드로어블을 추가했지만, Android 플랫폼의 벡터 드로어블 지원은 Android 5.0(API 수준 21) 전에는 추가되지 않았습니다. 앱이 이러한 이전 버전의 Android에서 작동(이전 버전과의 호환성)하게 하려면 `vectorDrawables` 요소를 앱의 `build.gradle` 파일에 추가하세요. 그러면 API 21 미만의 플랫폼 버전에서 벡터 드로어블을 사용할 수 있습니다. 

  `app/build.gradle`

  ```kotlin
  android {
    defaultConfig {
      ...
      vectorDrawables.useSupportLibrary = true
     }
     ...
  }



### 아이콘 추가하기

1. vector drawble asset 추가하기
   + **Resource Manager** > + > **Vector Asset**
   + **Clip Art:** 옆에 있는 버튼을 클릭하여 다른 클립 아트 이미지를 선택합니다. 메시지가 표시되면 나타나는 창에 'call made'를 입력합니다. 이 화살표 아이콘을 Round up tip 옵션에 사용하겠습니다. 아이콘을 선택하고 **OK**를 클릭합니다. 
   + 아이콘 이름 설정 ex) ic_~



2. imageView를 사용하여 앱에 아이콘 표시

   + ```kotlin
     <ImageView
         android:id="@+id/icon_cost_of_service"
         android:layout_width="wrap_content"
         android:layout_height="wrap_content"
         android:importantForAccessibility="no"
         app:srcCompat="@drawable/ic_store" />
     ```

     `app:srcCompat` 속성을 드로어블 리소스 `@drawable/ic_store`로 설정하면 이 XML 줄 옆에 아이콘의 미리보기가 표시됩니다. 이 이미지는 장식용으로만 사용되므로 `android:importantForAccessibility="no"`도 설정합니다.





### 스타일 및 테마

+ 스타일은 단일 위젯 유형의 뷰 속성 값 모음입니다. 예를 들어 `TextView` 스타일은 글꼴 색상, 글꼴 크기, 배경색 등을 지정할 수 있습니다. 이러한 속성을 스타일로 추출하면 레이아웃의 스타일을 여러 뷰에 쉽게 적용하고 단일 위치에 유지할 수 있습니다.

+ 스타일 만들기

  + **res > values** 디렉터리에 `styles.xml`이라는 새 파일을 만듭니다.

    ```kotlin
    <style name="Widget.TipTime.TextView" parent="Widget.MaterialComponents.TextView">
        <item name="android:minHeight">48dp</item>
        <item name="android:gravity">center_vertical</item>
        <item name="android:textAppearance">?attr/textAppearanceBody1</item>
    </style>
    ```

    

+ 테마에 스타일 추가하기

  + 새 `RadioButton` 스타일과 `Switch` 스타일을 각 위젯에 적용하지 않았음을 확인할 수 있습니다. 이것은 앱 테마에서 테마 속성을 사용하여 `radioButtonStyle` 및 `switchStyle`을 설정하기 때문입니다. 

  + 테마는 나중에 스타일, 레이아웃 등에 참조할 수 있는 명명된 리소스(테마 속성이라고 함)의 모음입니다. 개별 `View.`뿐만 아니라 전체 앱, 활동, 뷰 계층 구조에도 테마를 지정할 수 있습니다. 이전에 `themes.xml`에서 앱과 구성요소 전체적으로 사용되는 `colorPrimary`, `colorSecondary` 같은 테마 속성을 설정하여 앱의 테마를 수정했습니다. 

  + `radioButtonStyle` 및 `switchStyle`은 설정할 수 있는 다른 테마 속성입니다. 이 테마 속성에 제공하는 스타일 리소스는 테마가 적용되는 뷰 계층 구조의 모든 라디오 버튼과 모든 스위치에 적용됩니다.

  + `res/values/themes.xml`

    ```kotlin
    <item name="textInputStyle">@style/Widget.MaterialComponents.TextInputLayout.OutlinedBox</item>
    <item name="radioButtonStyle">@style/Widget.TipTime.CompoundButton.RadioButton</item>
    <item name="switchStyle">@style/Widget.TipTime.CompoundButton.Switch</item>
    ```

    



### 기기 회전하기

+ 기기를 회전해 가로 모드가 되면, Calculate 버튼을 포함한 일부 UI 구성요소가 잘리는 것을 확인할 수 있습니다. 이로 인해 앱을 사용하지 못합니다. 이 버그를 해결하려면 `ConstraintLayout` 주위에 `ScrollView`를 추가합니다.

  ```kotlin
  <ScrollView
     xmlns:android="http://schemas.android.com/apk/res/android"
     xmlns:app="http://schemas.android.com/apk/res-auto"
     xmlns:tools="http://schemas.android.com/tools"
     android:layout_height="match_parent"
     android:layout_width="match_parent">
  
     <androidx.constraintlayout.widget.ConstraintLayout
         android:layout_width="match_parent"
         android:layout_height="wrap_content"
         android:padding="16dp"
         tools:context=".MainActivity">
  
         ...
     </ConstraintLayout>
  
  </ScrollView>
  ```

  

### Enter 키를 누르면 키보드 숨기기

+ 텍스트 필드의 경우 특정 키를 탭할 때 이벤트에 응답하도록 키 리스너를 정의할 수 있습니다. 키보드에서 가능한 모든 입력 옵션에는 `Enter` 키를 포함한 키와 키 코드가 연결되어 있습니다. 터치 키보드는 소프트 키보드라고도 하며 실제 키보드가 아닙니다.

  ```kotlin
   private fun handleKeyEvent(view: View, keyCode: Int): Boolean {
          if (keyCode == KeyEvent.KEYCODE_ENTER) {
              // Hide the keyboard
              val inputMethodManager =
                  getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
              inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
              return true
          }
          return false
      }
  
  ...
  
  override fun onCreate(savedInstanceState: Bundle?) {
       binding.calculateButton.setOnClickListener { calculateTip() }
       binding.costOfServiceEditText.setOnKeyListener { view, keyCode, _ -> handleKeyEvent(view, keyCode)
          }
  }
  ```

  



### 🎖 Quiz/Unit2/Pathway2

1. Which line(s) of XML code will produce an error?

   ```kotlin
   1    <TextView
   2        android:layout_width="wrap_content"
   3        android:layout_height"wrap_content"
   4        android:padding="8dp"
   5        android:text="@string/title"
   6        android:textSize=18sp />
   ```

   => 

   + Line 3 - Missing = symbol after `android:layout_height` attribute.
   + Line 6 - Missing quotations around the attribute value `18sp`.



2. Which of the following is true about Gradle?

   =>

   + Gradle is an automated build system used by Android Studio to build your apps.
   + Gradle handles installing your app on a device.
   + You can configure Android-specific options for your project in your app’s `build.gradle` file.



3. Which of the following statements about app icons are true?

   => 

   + mdpi, hdpi, xhdpi, xxhdpi, and xxxhdpi are density qualifiers for resource directories to indicate that these are resources to be used on devices with a specific screen density.
   + Adaptive icons are made up of a foreground and background layer, and an OEM mask will be applied on top of them.



4. Which of the below steps are part of changing the color of your app theme?

   =>

   + Modify the `themes.xml` (night) file.
   + Set the primary and secondary color theme attributes of your app theme
   + Define the colors used in your app as color resources in the `colors.xml` file.



5. Why use the Material Components for Android library?

   => 

   + It provides widgets that follow the Material Design guidelines such as text fields and switches.
   + It provides default Material themes that you can use directly or extend and then customize.
   + It helps you more quickly build beautiful user experiences.

