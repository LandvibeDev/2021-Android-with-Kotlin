# 💡 Android Basics in Kotlin

## Unit #2 : Layouts

## PATHWAY #2 : Get user input in an app : Part 2



<br/>





### 📌 테마

- 테마 추가

  TextView, Button

  ```xml
  <?xml version="1.0" encoding="utf-8"?>
  <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
      xmlns:app="http://schemas.android.com/apk/res-auto"
      xmlns:tools="http://schemas.android.com/tools"
      android:layout_width="match_parent"
      android:layout_height="match_parent"
      android:layout_margin="16dp"
      android:orientation="vertical"
      tools:context=".MainActivity">
  
      <TextView
          android:layout_width="wrap_content"
          android:layout_height="48dp"
          android:layout_gravity="center_horizontal"
          android:gravity="center_vertical"
          android:text="@string/primary_color"
          android:textAllCaps="true"
          android:textSize="12sp" />
  
      <Button
          android:layout_width="wrap_content"
          android:layout_height="wrap_content"
          android:layout_gravity="center_horizontal"
          android:text="@string/button" />
  
      <TextView
          android:layout_width="wrap_content"
          android:layout_height="48dp"
          android:layout_gravity="center_horizontal"
          android:layout_marginTop="8dp"
          android:gravity="center_vertical"
          android:text="@string/secondary_color"
          android:textAllCaps="true"
          android:textSize="12sp" />
  
      <com.google.android.material.floatingactionbutton.FloatingActionButton
          android:layout_width="wrap_content"
          android:layout_height="wrap_content"
          android:layout_gravity="center_horizontal"
          android:contentDescription="@string/email_icon"
          app:srcCompat="@android:drawable/ic_dialog_email" />
  
  </LinearLayout>
  ```

- [색상도구](https://material.io/resources/color/#!/?view.left=0&view.right=0) 사이트

- 앱에 색상 리소스 추가

  `color.xml` 들어간 뒤

  ```xml
  <color name="색상이름"> #으로시작하는색상코드 </color>
  ```

* 어두운 테마 업데이트

  `themes.xml(night)` 변형

<br/>



### 📌 앱 아이콘 변경

- 런처 아이콘

  `project`뷰 전환 후 (app>src>main>res>mipmap)에 해상도에 따른 기본 비트맵 이미지 파일 여러개 존재

- 적응형 아이콘

  포그라운드 레이어, 백그라운드 레이어로 구성

  (res>mipmap-anydpi-v26)에 기본 백터 드로어블 파일 존재 

  (drawable>ic_launcher_backgroud.xml), (drawable-v24 > ic_launcher_foreground.xml)

* 새 이미지 가져오기

  res에서 New>Image Asset 들어간 뒤 foreground와 background이미지 가져오기





<br/>



### 📌 머티리얼 구성요소

##### 👉 EditText 변경

```xml
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
```

<br/>

##### 👉 Switch 변경

* 눈에 띄는 변화는 없지만, 라이브러리의 구현이 업데이트되면 직접 변경하지 않고도 무료로 위젯이 업데이트된다. (미래를 대비)

```xml
<com.google.android.material.switchmaterial.SwitchMaterial
...
/>
```

<br/>



### 📌 앱 내 아이콘 추가

1. `Resource Manager` > `+` > `vector Asset` > `clip art` 이미지 선택

2. `app/build.gradle` 다음 내용 추가

   ```kotlin
   android {
   	defaultConfig {
   	vectorDrawables.useSupportLibrary = true
   	}
   }
   ```

3. **ImageView**추가 

   ```xml
   <ImageView
           android:id="@+id/icon_cost_of_service"
           android:layout_width="wrap_content"
           android:layout_height="wrap_content"
           android:importantForAccessibility="no"
           app:srcCompat="@drawable/ic_store"
           app:layout_constraintStart_toStartOf="parent"
           app:layout_constraintTop_toTopOf="@id/cost_of_service"
           app:layout_constraintBottom_toBottomOf="@id/cost_of_service"
   />
   ```

<br/>

### 📌 스타일 및 테마

##### 👉 스타일 생성

* `res > values > styles.xml`에 추가

  ```xml
  <style name="Widget.TipTime.TextView" parent="Widget.MaterialComponents.TextView">
          <item name="android:minHeight">@dimen/min_text_height</item>
          <item name="android:gravity">center_vertical</item>
          <item name="android:textAppearance">?attr/textAppearanceBody1</item> </style>
  ```

* +) 자주 사용되는 값의 관리 효율성을 높이려면 `dimens.xml`파일 생성 후 값 관리

  ```xml
  <dimen name="min_text_height">48dp</dimen>
  ```

* TextView에 적용

  ```xml
  <TextView
  	style="@style/Widget.TipTime.TextView"/>
  ```

  

<br/>

##### 👉 테마에 스타일 추가

* `themes.xml` `themes.xml(night)`에 추가

  ```xml
  <style>
        <item name="textInputStyle">@style/Widget.MaterialComponents.TextInputLayout.OutlinedBox</item>
  			<item name="radioButtonStyle">@style/Widget.TipTime.CompoundButton.RadioButton</item>
  			<item name="switchStyle">@style/Widget.TipTime.CompoundButton.Switch</item>
  </style>
  ```

  

<br/>



### 📌 버그 해결

##### 👉 가로모드시 일부 UI구성요소 잘림 해결

* `ConstraintLayout`주위에  `ScrollView` 추가

  ```xml
  <ScrollView
      xmlns:android="http://schemas.android.com/apk/res/android"
      xmlns:app="http://schemas.android.com/apk/res-auto"
      xmlns:tools="http://schemas.android.com/tools"
      android:layout_width="match_parent"
      android:layout_height="match_parent">
  </ScrollView>
  ```

  <br/>

##### 👉 Enter키 누르면 키보드 자동으로 숨기기

* `MainActivity.kt` 수정

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
  ```

  ```kotlin
  override fun onCreate(savedInstanceState: Bundle?) {
          binding.costOfServiceEditText.setOnKeyListener { view, keyCode, _ -> handleKeyEvent(view,keyCode) }
      }
  ```

  

  <br/>

##### 👉 벡터 드로어블 색조 조정

* 드로어블 파일의 xml파일 수정

  ```xml
  <vector>
  			android:tint="?attr/colorPrimary"
  </vector>
  ```

  <br/>

  <br/>

  ------

  

### 📌 퀴즈

1. Which line(s) of XML code will produce an error?

   ```
   1    <TextView
   2        android:layout_width="wrap_content"
   3        android:layout_height"wrap_content"
   4        android:padding="8dp"
   5        android:text="@string/title"
   6        android:textSize=18sp />
   ```

   - Line 3 - Missing = symbol after `android:layout_height` attribute.

   - Line 6 - Missing quotations around the attribute value `18sp`.

   <br/>

2. Which of the following is true about Gradle?

   - Gradle is an automated build system used by Android Studio to build your apps.

   - Gradle handles installing your app on a device.

   - You can configure Android-specific options for your project in your app’s `build.gradle` file.

     <br/>

3. Which of the following statements about app icons are true?

   - mdpi, hdpi, xhdpi, xxhdpi, and xxxhdpi are density qualifiers for resource directories to indicate that these are resources to be used on devices with a specific screen density.
   - Adaptive icons are made up of a foreground and background layer, and an OEM mask will be applied on top of them.

   <br/>

4. Which of the below steps are part of changing the color of your app theme?

   - Modify the `themes.xml` (night) file.

   - Set the primary and secondary color theme attributes of your app theme.

   - Define the colors used in your app as color resources in the `colors.xml` file.

   

   <br/>

5. Why use the Material Components for Android library?

   - It provides widgets that follow the Material Design guidelines such as text fields and switches.

   - It provides default Material themes that you can use directly or extend and then customize.

   - It helps you more quickly build beautiful user experiences.

   