# 2021 Landvibe Summer Coding - Android



## Unit2 : Layouts

## PathWay2 : Get user input in an app : Part2



### Change the app theme

* **색 표현**

  *  RGB 구성요소를 나타내는 3개의 16진수 숫자(#00~#FF)로 표현 가능

  * 투명도를 나타내는 알파 값(#00~#FF)을 포함하여 정의 

    :point_right: #00 = 0% = 완전 투명, #FF = 100% - 완전 불투명

    :point_right: 알파 값이 포함되지 않으면 #FF, 즉 불투명으로 간주됨.

    <img src="img\Unit2-Pathway2-1_장유진.png" style="zoom:70%;" />

  * `colors.xml` 파일을 통해 색상 관리

* **테마 색상**

  * 앱에 의미 있는 방식으로 색상을 사용하고 전체적으로 일관성 있게 적용할 수 있도록 텍스트, 아이콘 등에서 사용하는 색상과 관련된 12개의 속성에 이름을 지정하여 색상을 그룹화 한다.

    <img src="img\Unit2-Pathway2-2_장유진.png" style="zoom:70%;" />

    | #    | 이름       | 테마 속성              |
    | ---- | ---------- | ---------------------- |
    | 1    | 기본       | colorPrimary           |
    | 2    | 기본 변형  | colorPrimaryVariant    |
    | 3    | 보조       | colorSecondary         |
    | 4    | 보조 변형  | colorSeocondaryVariant |
    | 5    | 배경       | colorBackground        |
    | 6    | 표면       | colorSurface           |
    | 7    | 오류       | colorError             |
    | 8    | 기본(대비) | colorOnPrimary         |
    | 9    | 보조(대비) | colorOnSecondary       |
    | 10   | 배경(대비) | colorOnBackground      |
    | 11   | 표면(대비) | colorOnSurface         |
    | 12   | 오류(대비) | colorOnError           |

  * `themes.xml`

    ```xml
    <resources xmlns:tools="http://schemas.android.com/tools">
        <!-- Base application theme. -->
        <style name="Theme.TipTime" parent="Theme.MaterialComponents.DayNight.DarkActionBar">
            <!-- Primary brand color. -->
            <item name="colorPrimary">@color/purple_500</item>
            <item name="colorPrimaryVariant">@color/purple_700</item>
            <item name="colorOnPrimary">@color/white</item>
            <!-- Secondary brand color. -->
            <item name="colorSecondary">@color/teal_200</item>
            <item name="colorSecondaryVariant">@color/teal_700</item>
            <item name="colorOnSecondary">@color/black</item>
            <!-- Status bar color. -->
            <item name="android:statusBarColor" tools:targetApi="l">?attr/colorPrimaryVariant</item>
            <!-- Customize your theme here. -->
        </style>
    </resources>
    ```

  * `color.xml`

    ```xml
    <?xml version="1.0" encoding="utf-8"?>
    <resources>
        <color name="purple_200">#FFBB86FC</color>
        <color name="purple_500">#FF6200EE</color>
        <color name="purple_700">#FF3700B3</color>
        <color name="teal_200">#FF03DAC5</color>
        <color name="teal_700">#FF018786</color>
        <color name="black">#FF000000</color>
        <color name="white">#FFFFFFFF</color>
    </resources>
    ```

* **어두운 테마**

  * 장점

    * 전력 사용을 크게 줄일 수 있음
    * 시력이 낮은 사용자와 밝은 빛에 민감한 사용자의 가시성을 개선함
    * 조명이 어두운 환경에서 더 편하게 기기를 사용할 수 있음

  * 기본 색상보다 더 낮은 버전의 채도를 선택(200~50)

  * `themes.xml(night)`

    ```xml
    <resources xmlns:tools="http://schemas.android.com/tools">
        <!-- Base application theme. -->
        <style name="Theme.TipTime" parent="Theme.MaterialComponents.DayNight.DarkActionBar">
            <!-- Primary brand color. -->
            <item name="colorPrimary">@color/purple_200</item>
            <item name="colorPrimaryVariant">@color/purple_700</item>
            <item name="colorOnPrimary">@color/black</item>
            <!-- Secondary brand color. -->
            <item name="colorSecondary">@color/teal_200</item>
            <item name="colorSecondaryVariant">@color/teal_200</item>
            <item name="colorOnSecondary">@color/black</item>
            <!-- Status bar color. -->
            <item name="android:statusBarColor" tools:targetApi="l">?attr/colorPrimaryVariant</item>
            <!-- Customize your theme here. -->
        </style>
    </resources>
    ```

<img src="E:\#Summer_Coding_2021\img\Unit2-Pathway2-3_장유진.png" style="zoom:70%;" />

### Change the app icon

- **런처 아이콘**

  - 기기 모델이나 화면 밀도와 상관없이 런처 아이콘의 모양을 선명하고 명확하게 만드는 것 

  - `mdpi` :point_right: 중밀도 화면의 리소스(~160dpi)

  - `hdpi` :point_right: 고밀도 화면의 리소스(~24-dpi)

  - `xhdpi` :point_right: 초고밀도 화면의 리소스(~320dpi)

  - `xxhdpi` :point_right: 초초고밀도 화면의 리소스(~480dpi)

  - `xxxhpi` :point_right: 초초초고밀도 화면의 리소스(~640dpi)

  - `nodpi` :point_right: 화면의 픽셀 밀도와 관계없이 조정할 수 없는 리소스

  - `anydpi` :point_right: 어떤 밀도로도 조정 가능한 리소스

  - `mipmap-xxxhdpi` - `ic_launcher.png`

    <img src="img\Unit2-Pathway2-4_장유진.png" style="zoom:70%;" />

### Create a more polished user experience

- **Material Components**

  - 앱에서 Material Components 스타일을 더 쉽게 구현할 수 있는 일반적인 UI 위젯
  - 앱이 사용자 기기에 있는 다른 앱과 함께 더 일관된 방식으로 작동함.
  - 사용자는 앱을 사용하는 방법을 훨씬 더 빠르게 배울 수 있음
  - 유연성과 맞춤 설정 가능성이 높음

  ```xml
  dependencies {
      ...
      implementation 'com.google.android.material:material:1.4.0'
      ...
  }
  ```

  - 텍스트 필드

  ```xml
   <com.google.android.material.textfield.TextInputLayout
          android:id="@+id/cost_of_service"
          android:layout_width="160dp"
          android:layout_height="wrap_content"
          android:hint="@string/cost_of_service"
          app:layout_constraintStart_toStartOf="parent"
          app:layout_constraintTop_toTopOf="parent"
          android:layout_marginStart="16dp"
          app:layout_constraintStart_toEndOf="@id/icon_cost_of_service">
  
          <com.google.android.material.textfield.TextInputEditText
              android:id="@+id/cost_of_service_edit_text"
              android:layout_width="match_parent"
              android:layout_height="wrap_content"
              android:inputType="numberDecimal"
              />
  
      </com.google.android.material.textfield.TextInputLayout>
  ```

  - 스위치

  ```xml
  <com.google.android.material.switchmaterial.SwitchMaterial
         android:id="@+id/round_up_switch"
         android:layout_width="0dp"
         android:layout_height="wrap_content"
         android:checked="true"
         android:text="Round up tip?"
         android:layout_marginStart="16dp"
         app:layout_constraintEnd_toEndOf="parent"
         app:layout_constraintStart_toStartOf="parent"
         app:layout_constraintTop_toBottomOf="@id/tip_options"
         app:layout_constraintStart_toEndOf="@id/icon_round_up"/>
  ```

- **기기 회전**

  ```xml
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

### Quiz

1. **Which line(s) of XML code will produce an error?**

   ```xml
   1    <TextView
   2        android:layout_width="wrap_content"
   3        android:layout_height"wrap_content"
   4        android:padding="8dp"
   5        android:text="@string/title"
   6        android:textSize=18sp />
   ```

   --> Link3 - Missing = symbol after `android:layout_height` attribute.

   --> Link6 - Missing quotations around the attribute value `18sp`.

2. **Which of the following is true about Gradle?**

   --> Gradle is an automated build system used by Android Studio to build your apps.

   ​	(Gradle은 Android Studio에서 앱을 빌드하기 위해 사용하는 자동 빌드 시스템입니다.)

   --> Gradle handles installing your app on device

   ​	(Gradle은 Android Studio에서 앱을 빌드하기 위해 사용하는 자동 빌드 시스템입니다.)

   --> You can configure Android-specific options for your project in your app's `build.gradle` file.

      (앱의 'build.gradle' 파일에서 Android 관련 프로젝트 옵션을 구성할 수 있습니다.)

3. **Which of the following statements about app icons are true?**

   --> mdpi, hdpi, xhdpi, xxhdpi, and xxxhdpi are density qualifiers for resource directories to indicate that these are resources to be used on devices with a specific screen density.

   --> Adaptive icons are made up of a foreground and background layer, and an OEM mask will be applied on top of them.

4. **Which of the below steps are part of changing the color of your app theme?**

   --> Modify the `thems.xml`(night) file.

   --> Set the primary and secondary color theme attributes of your app theme.

   --> Define the colors used in your app as color resources in the `colors.xml` file.

5. **Why use the Material Components for Android library?**

   --> It provides widgets that follow the Material Design guideline such as text fields and switches.

   --> It provides default Material themes that you can use directly or extend and then customize.

   --> It helps you more quickly build beautiful user experiences.

   ------

   :pencil: **Gradle 이란?**​

   - 빌드 배포 도구이다.
   - `build.gradle`
     - 모듈의 빌드 방법이 정의된 빌드 스크립트이다.
     - 빌드에서 사용할 SDK 버전부터 시작하여 애플리케이션 버전, 사용하는 라이브러리 등 다양한 항목을 설정하는 것이 가능