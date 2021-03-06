# π‘ Android Basics in Kotlin

## Unit #2 : Layouts

## PATHWAY #2 : Get user input in an app : Part 2



<br/>





### π νλ§

- νλ§ μΆκ°

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

- [μμλκ΅¬](https://material.io/resources/color/#!/?view.left=0&view.right=0) μ¬μ΄νΈ

- μ±μ μμ λ¦¬μμ€ μΆκ°

  `color.xml` λ€μ΄κ° λ€

  ```xml
  <color name="μμμ΄λ¦"> #μΌλ‘μμνλμμμ½λ </color>
  ```

* μ΄λμ΄ νλ§ μλ°μ΄νΈ

  `themes.xml(night)` λ³ν

<br/>



### π μ± μμ΄μ½ λ³κ²½

- λ°μ² μμ΄μ½

  `project`λ·° μ ν ν (app>src>main>res>mipmap)μ ν΄μλμ λ°λ₯Έ κΈ°λ³Έ λΉνΈλ§΅ μ΄λ―Έμ§ νμΌ μ¬λ¬κ° μ‘΄μ¬

- μ μν μμ΄μ½

  ν¬κ·ΈλΌμ΄λ λ μ΄μ΄, λ°±κ·ΈλΌμ΄λ λ μ΄μ΄λ‘ κ΅¬μ±

  (res>mipmap-anydpi-v26)μ κΈ°λ³Έ λ°±ν° λλ‘μ΄λΈ νμΌ μ‘΄μ¬ 

  (drawable>ic_launcher_backgroud.xml), (drawable-v24 > ic_launcher_foreground.xml)

* μ μ΄λ―Έμ§ κ°μ Έμ€κΈ°

  resμμ New>Image Asset λ€μ΄κ° λ€ foregroundμ backgroundμ΄λ―Έμ§ κ°μ Έμ€κΈ°





<br/>



### π λ¨Έν°λ¦¬μΌ κ΅¬μ±μμ

##### π EditText λ³κ²½

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

##### π Switch λ³κ²½

* λμ λλ λ³νλ μμ§λ§, λΌμ΄λΈλ¬λ¦¬μ κ΅¬νμ΄ μλ°μ΄νΈλλ©΄ μ§μ  λ³κ²½νμ§ μκ³ λ λ¬΄λ£λ‘ μμ ―μ΄ μλ°μ΄νΈλλ€. (λ―Έλλ₯Ό λλΉ)

```xml
<com.google.android.material.switchmaterial.SwitchMaterial
...
/>
```

<br/>



### π μ± λ΄ μμ΄μ½ μΆκ°

1. `Resource Manager` > `+` > `vector Asset` > `clip art` μ΄λ―Έμ§ μ ν

2. `app/build.gradle` λ€μ λ΄μ© μΆκ°

   ```kotlin
   android {
   	defaultConfig {
   	vectorDrawables.useSupportLibrary = true
   	}
   }
   ```

3. **ImageView**μΆκ° 

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

### π μ€νμΌ λ° νλ§

##### π μ€νμΌ μμ±

* `res > values > styles.xml`μ μΆκ°

  ```xml
  <style name="Widget.TipTime.TextView" parent="Widget.MaterialComponents.TextView">
          <item name="android:minHeight">@dimen/min_text_height</item>
          <item name="android:gravity">center_vertical</item>
          <item name="android:textAppearance">?attr/textAppearanceBody1</item> </style>
  ```

* +) μμ£Ό μ¬μ©λλ κ°μ κ΄λ¦¬ ν¨μ¨μ±μ λμ΄λ €λ©΄ `dimens.xml`νμΌ μμ± ν κ° κ΄λ¦¬

  ```xml
  <dimen name="min_text_height">48dp</dimen>
  ```

* TextViewμ μ μ©

  ```xml
  <TextView
  	style="@style/Widget.TipTime.TextView"/>
  ```

  

<br/>

##### π νλ§μ μ€νμΌ μΆκ°

* `themes.xml` `themes.xml(night)`μ μΆκ°

  ```xml
  <style>
        <item name="textInputStyle">@style/Widget.MaterialComponents.TextInputLayout.OutlinedBox</item>
  			<item name="radioButtonStyle">@style/Widget.TipTime.CompoundButton.RadioButton</item>
  			<item name="switchStyle">@style/Widget.TipTime.CompoundButton.Switch</item>
  </style>
  ```

  

<br/>



### π λ²κ·Έ ν΄κ²°

##### π κ°λ‘λͺ¨λμ μΌλΆ UIκ΅¬μ±μμ μλ¦Ό ν΄κ²°

* `ConstraintLayout`μ£Όμμ  `ScrollView` μΆκ°

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

##### π Enterν€ λλ₯΄λ©΄ ν€λ³΄λ μλμΌλ‘ μ¨κΈ°κΈ°

* `MainActivity.kt` μμ 

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

##### π λ²‘ν° λλ‘μ΄λΈ μμ‘° μ‘°μ 

* λλ‘μ΄λΈ νμΌμ xmlνμΌ μμ 

  ```xml
  <vector>
  			android:tint="?attr/colorPrimary"
  </vector>
  ```

  <br/>

  <br/>

  ------

  

### π ν΄μ¦

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

   - You can configure Android-specific options for your project in your appβs `build.gradle` file.

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

   