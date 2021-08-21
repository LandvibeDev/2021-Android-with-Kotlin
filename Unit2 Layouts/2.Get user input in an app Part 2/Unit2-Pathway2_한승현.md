# Unit2-Pathway2



* **앱 테마 변경**

  * **앱에 색상 추가하기**

    * `colors.xml` 에 추가하여 사용할 수 있음

      ```xml
      <color name="green">#1B5E20</color>
      ```

* **앱 아이콘 변경**

  * **런처 아이콘**
    * `app`>`src`>`main`>`res`>`mipmap`
    * `mipmap` 폴더는 Android 앱의 런처 아이콘 애셋을 배치해야 하는 위치
      * `mdpi` - 중밀도 화면의 리소스(~160dpi)
      * `hdpi` - 고밀도 화면의 리소스 (~240dpi)
      * `xhdpi` - 초고밀도 화면의 리소스(~320dpi)
      * `xxhdpi` - 초초고밀도 화면의 리소스(~480dpi)
      * `xxxhdpi` - 초초초고밀도 화면의 리소스(~640dpi)
      * `nodpi` - 화면의 픽셀 밀도와 관계없이 조정할 수 없는 리소스
      * `anydpi` - 어떤 밀도로도 조정 가능한 리소스
      * 런처 아이콘 애셋이 `drawable` 이 아닌 `mipmap` 에 있는 이유는, 일부 런처가 기기의 기본 밀도 버킷에서 제공한 것보다 큰 크기로 앱 아이콘을 표시할 수 있기 때문. 예를 들어 hdpi 기기에서 특정 기기 런처가 xhdpi 버전의 앱 아이콘을 대신 사용하려고 할 수 있음.
  * **적응형 아이콘**
    * 벡터(Vector)
      * 화질 저하 없이 모든 화면 밀도의 어떤 캔버스 크기로도 조정 가능
      * XML로 정의 가능하며, 모든 밀도 버킷에 비트맵 애셋 버전을 제공하는 대신 이미지를 한 번만 정의하면 됨
      * 앱의 크기가 줄어 유지하기 쉬워짐

* **더욱 세련된 사용자 환경 만들기**

  * **머터리얼 구성요소**

    * 앱에서 머터리얼 스타일을 더 쉽게 구현할 수 있는 일반적인 UI 위젯
    * 앱이 사용자 기기에 있는 다른 앱과 함께 더 일관된 방식으로 작동
    * 한 앱에서 학습된 UI 패턴이 다음 앱에 이전될 수 있어 사용자가 앱을 사용하는 방법을 더 빠르게 배울 수 있음

  * **스타일 및 테마**

    * style에서 지정한 속성과 layout에서 지정한 속성이 충돌할 경우, layout에서 설정한 값대로 실제 화면에 표시됨

  * **사용자 환경 향상하기**

    * ScrollView를 사용함으로써 ScrollView 안의 뷰들을 스크롤할 수 있게 할 수 있음

    * 엔터 키를 입력하면 키보드를 숨기기

      ```kotlin
      override fun onCreate(savedInstanceState: Bundle?) {
         ...
      
         setContentView(binding.root)
      
         binding.calculateButton.setOnClickListener { calculateTip() }
      
         binding.costOfServiceEditText.setOnKeyListener { view, keyCode, _ -> handleKeyEvent(view, keyCode)
         }
      }
      
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
      ```



### Quiz

1. **Which line(s) of XML code will produce an error?**

   ```xml
   <TextView
        android:layout_width="wrap_content"
        android:layout_height"wrap_content"
        android:padding="8dp"
        android:text="@string/title"
        android:textSize=18sp />
   ```

   * Line 3 - Missing = symbol after `android:layout_height` attribute.
   * Line 6 - Missing quotations around the attribute value `18sp`.

2. **Which of the following is true about Gradle?**

   * Gradle is an automated build system used by Android Studio to build your apps.
   * Gradle handles installing your app on a device.
   * You can configure Android-specific options for your project in your app’s `build.gradle` file.

3. **Which of the following statements about app icons are true?**

   * mdpi, hdpi, xhdpi, xxhdpi, and xxxhdpi are density qualifiers for resource directories to indicate that these are resources to be used on devices with a specific screen density.
   * Adaptive icons are made up of a foreground and background layer, and an OEM mask will be applied on top of them.

4. **Which of the below steps are part of changing the color of your app theme?**

   * Modify the `themes.xml` (night) file.
   * Set the primary and secondary color theme attributes of your app theme.
   * Define the colors used in your app as color resources in the `colors.xml` file.

5. **Why use the Material Components for Android library?**

   * It provides widgets that follow the Material Design guidelines such as text fields and switches.
   * It provides default Material themes that you can use directly or extend and then customize.
   * It helps you more quickly build beautiful user experiences.