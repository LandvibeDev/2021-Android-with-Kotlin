# 2021 Landvibe Summer Coding - Android

## Unit2 : Layouts

### PathWay2 : Get user input in an app: Part 2



##### :label: Change the app theme

- **머티리얼 테마**

머티리얼 테마를 사용하여 색상, 서체, 도형을 맞춤설정하는 방법으로 앱에 맞게 머티리얼 디자인을 조정할 수 있다

- **색상**

  - 색의 빨간색, 녹색, 파란색(RGB) 구성요소를 나타내는 3개의 16진수 숫자(#00~#FF(0~255))로 표현할 수 있다. (숫자가 클수록 구성요소의 색이 많이 포함된다)

  <img src="img/Unit2-Pathway2-1_hyein.jpg" width="300">

  - 알파 값 : 투명도 (#00 ~ #FF)



- `DarkActionBar`

``````kotlin
<style name="Theme.TipTime" parent="Theme.MaterialComponents.DayNight.DarkActionBar">
``````

작업 모음이 어두운 색상을 사용한다는 의미 (테마는 상위 테마의 속성을 상속한다)



- **색상 선택**

머티리얼팀에서 제공하는 웹기반 앱인 [색상 도구](https://material.io/resources/color/#!/?view.left=0&view.right=0)를 사용하여 쉽게 확인하고 선택할 수 있다.



- `colors.xml`(**app > res > values > colors.xml**)

``````kotlin
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <color name="black">#FF000000</color>
    <color name="white">#FFFFFFFF</color>
    <color name="green">#1B5E20</color>
    <color name="green_dark">#003300</color>
    <color name="green_light">#A5D6A7</color>
    <color name="blue">#0288D1</color>
    <color name="blue_dark">#005B9F</color>
    <color name="blue_light">#81D4FA</color>
</resources>
``````

- `values/themes.xml`(**app > res > values > themes > themes.xml**)

``````kotlin
<resources xmlns:tools="http://schemas.android.com/tools">
    <!-- Base application theme. -->
    <style name="Theme.TipTime" parent="Theme.MaterialComponents.DayNight.DarkActionBar">
        <!-- Primary brand color. -->
        <item name="colorPrimary">@color/green</item>
        <item name="colorPrimaryVariant">@color/green_dark</item>
        <item name="colorOnPrimary">@color/white</item>
        <!-- Secondary brand color. -->
        <item name="colorSecondary">@color/blue</item>
        <item name="colorSecondaryVariant">@color/blue_dark</item>
        <item name="colorOnSecondary">@color/black</item>
        <!-- Status bar color. -->
        <item name="android:statusBarColor" tools:targetApi="l">?attr/colorPrimaryVariant</item>
        <!-- Customize your theme here. -->
    </style>
</resources>
``````

- `values-night/themes.xml`(**app > res > values > themes > themes.xml(night)**)

``````kotlin
<resources xmlns:tools="http://schemas.android.com/tools">
    <!-- Application theme for dark theme. -->
    <style name="Theme.TipTime" parent="Theme.MaterialComponents.DayNight.DarkActionBar">
        <!-- Primary brand color. -->
        <item name="colorPrimary">@color/green_light</item>
        <item name="colorPrimaryVariant">@color/green</item>
        <item name="colorOnPrimary">@color/black</item>
        <!-- Secondary brand color. -->
        <item name="colorSecondary">@color/blue_light</item>
        <item name="colorSecondaryVariant">@color/blue_light</item>
        <item name="colorOnSecondary">@color/black</item>
        <!-- Status bar color. -->
        <item name="android:statusBarColor" tools:targetApi="l">?attr/colorPrimaryVariant</item>
        <!-- Customize your theme here. -->
    </style>
</resources>
``````





##### :label: Change the app icon

- **앱 아이콘**
  - 런처 아이콘이라고도 하며, 앱을 차별화 하는 중요한 방법이다.
  - 다양한 화면 밀도의 기기를 고려하려면 여러 버전의 앱 아이콘을 제공해야 한다.



- `minmap` 
  - Android 앱의 런처 아이콘 에셋을 배치하는 위치

- **밀도한정자**
  - `mdpi` - 중밀도 화면의 리소스(~160dpi)
  - `hdpi` - 고밀도 화면의 리소스 (~240dpi)
  - `xhdpi` - 초고밀도 화면의 리소스(~320dpi)
  - `xxhdpi` - 초초고밀도 화면의 리소스(~480dpi)
  - `xxxhdpi` - 초초초고밀도 화면의 리소스(~640dpi)
  - `nodpi` - 화면의 픽셀 밀도와 관계없이 조정할 수 없는 리소스
  - `anydpi` - 어떤 밀도로도 조정 가능한 리소스



- **적응형 런처 아이콘**
  - 포그라운드 레이어 / 백그라운드 레이어
    - 포그라운드 레이어는 백그라운드 레이어 위에 쌓임 :arrow_right: 마스크가 맨 위에 적용
  - **res > mipmap-anydpi-v26**
  - 벡터 그래픽
    - 이미지를 정의하는 모양을 그리는 방법을 알 고 있다
    - 화질 저하 없이 모든 화면 밀도의 어떤 캔버스 크기로도 조정할 수 있다
    - 비트맵 에셋 버전 제공 대신, 이미지를 한 번만 정의 가능하다





##### :label: Create a more polished user experience

- **머티리얼 구성요소**

[머티리얼 구성요소](https://material.io/components)는 앱에서 머티리얼 스타일을 더 쉽게 구현할 수 있는 일반적인 UI 위젯이다.

- **머티리얼 디자인 구성요소(MDC)**

`app/build.gradle`

```kotlin
dependencies {
    ...
    implementation 'com.google.android.material:material:<version>'
}
```

`EditText`

``````kotlin
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

    </com.google.android.material.textfield.TextInputLayout>
``````

`Switch`

``````kotlin
<com.google.android.material.switchmaterial.SwitchMaterial
    android:id="@+id/round_up_switch"
    android:layout_width="0dp"
    android:layout_height="wrap_content" ... />
``````





##### :label: Quiz

1. Which line(s) of XML code will produce an error?

   `````` kotlin
   1    <TextView
   2        android:layout_width="wrap_content"
   3        android:layout_height"wrap_content"
   4        android:padding="8dp"
   5        android:text="@string/title"
   6        android:textSize=18sp />
   ``````

   *적절한 답변을 모두 선택합니다.*

   - Line 3 - Missing = symbol after `android:layout_height` attribute.
   - Line 6 - Missing quotations around the attribute value `18sp`.

   

2. Which of the following is true about Gradle?

   *적절한 답변을 모두 선택합니다.*

   - Gradle is an automated build system used by Android Studio to build your apps.
   - Gradle handles installing your app on a device.
   - You can configure Android-specific options for your project in your app’s `build.gradle` file.

   

3. Which of the following statements about app icons are true?

   *적절한 답변을 모두 선택합니다.*

   - mdpi, hdpi, xhdpi, xxhdpi, and xxxhdpi are density qualifiers for resource directories to indicate that these are resources to be used on devices with a specific screen density.
   - Adaptive icons are made up of a foreground and background layer, and an OEM mask will be applied on top of them.

   

4. Which of the below steps are part of changing the color of your app theme?

   *적절한 답변을 모두 선택합니다.*

   - Modify the `themes.xml` (night) file.
   - Set the primary and secondary color theme attributes of your app theme.
   - Define the colors used in your app as color resources in the `colors.xml` file.

   

5. Why use the Material Components for Android library?

   *적절한 답변을 모두 선택합니다.*

   - It provides widgets that follow the Material Design guidelines such as text fields and switches.
   - It provides default Material themes that you can use directly or extend and then customize.
   - It helps you more quickly build beautiful user experiences.

