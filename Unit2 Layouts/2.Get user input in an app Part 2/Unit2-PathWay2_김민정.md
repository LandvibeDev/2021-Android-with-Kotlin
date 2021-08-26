## 2021 Landvibe Summer Coding - Android

### 🔎 Android Basics In Kotlin

#### 📌 Unit2: Layouts

#### 📌 PathWay2: Get user input in an app: Part 2

<hr>

##### 앱 테마 변경

🚩 색

+ 색의 빨간색, 녹색, 파란색(RGB) 구성요소를 나타내는 3개의 16진수 숫자(#00~#FF(0~255))로 표현

+ 숫자가 클수록 구성요소의 색이 더 많이 포함

+ \#00=0%=완전 투명
+ \#FF=100%=완전 불투명
+ xml 파일에서의 예

```xml
<color name="black">#FF000000</color>
<color name="white">#FFFFFFFF</color>
```



🚩 대비 색상 : 다양한 표면에 그려지는 텍스트와 아이콘에 사용

| **#** | **이름**   | **테마 속성**           |
| ----- | ---------- | ----------------------- |
| 1     | 기본       | `colorPrimary`          |
| 2     | 기본 변형  | `colorPrimaryVariant`   |
| 3     | 보조       | `colorSecondary`        |
| 4     | 보조 변형  | `colorSecondaryVariant` |
| 5     | 배경       | `colorBackground`       |
| 6     | 표면       | `colorSurface`          |
| 7     | 오류       | `colorError`            |
| 8     | 기본(대비) | `colorOnPrimary`        |
| 9     | 보조(대비) | `colorOnSecondary`      |
| 10    | 배경(대비) | `colorOnBackground`     |
| 11    | 표면(대비) | `colorOnSurface`        |
| 12    | 오류(대비) | `colorOnError`          |



🚩 기본 테마에 정의된 색상

`colors.xml`(**app > res > values > colors.xml**)을 열면 각 색상 리소스의 16진수 값을 볼 수 있습니다. 맨 앞의 `#FF`는 알파 값이며 색상이 100% 불투명하다는 의미



🚩 앱 테마 색상 선택

: 머티리얼팀에서 제공하는 웹 기반 앱인 [색상 도구](https://material.io/resources/color/#!/?view.left=0&view.right=0)를 사용하는 것



🚩 앱에 색상 추가하기

1. Android 스튜디오에서 `colors.xml`(**app > res > values > colors.xml**)을 엽니다.

2. 기존에 있던 색상 다음에 위에서 선택한 값(`#1B5E20`)을 사용하여 `green`이라는 색상 리소스를 정의합니다.

3. 다른 색상의 리소스를 계속 정의합니다. 이러한 색상의 대부분은 색상 도구에서 가져옵니다. `green_light` 및 `blue_light` 값은 도구에 표시되는 값과 다릅니다. 이러한 값은 이후 단계에서 사용합니다.

   | `green`       | `#1B5E20` |
   | ------------- | --------- |
   | `green_dark`  | `#003300` |
   | `green_light` | `#A5D6A7` |
   | `blue`        | `#0288D1` |
   | `blue_dark`   | `#005B9F` |
   | `blue_light`  | `#81D4FA` |



🚩 테마에 색상 사용하기

1. `themes.xml`(**app > res > values > themes > themes.xml**)을 엽니다.
2. `colorPrimary`를 선택한 기본 색상(`@color/green`)으로 변경합니다.
3. `colorPrimaryVariant`를 `@color/green_dark`로 변경합니다.
4. `colorSecondary`를 `@color/blue`으로 변경합니다.
5. `colorSecondaryVariant`를 `@color/blue_dark`로 변경합니다.
6. **P의 텍스트**와 **S의 텍스트**가 여전히 흰색(`#FFFFFF`)과 검은색(`#000000`)인지 확인합니다. 독자적인 색상 도구를 사용하고 있고 다른 색상을 선택한다면 색상 리소스를 추가로 정의해야 할 수도 있습니다.



🚩 어두운 테마 업데이트

1. `themes.xml (night)`(**app > res > values > themes > themes.xml(night)**)을 엽니다.
2. `colorPrimary`를 선택한 기본 색상(`@color/green_light`)의 밝은 변형으로 변경합니다.
3. `colorPrimaryVariant`를 `@color/green`으로 변경합니다.
4. `colorSecondary`를 `@color/blue_light`으로 변경합니다.
5. `colorSecondaryVariant`를 `@color/blue_light`으로 변경합니다.



🚩 Android 스튜디오에서 어두운 테마 확인 방법

: Orientation for Perview > Night 선택하기



##### 앱 아이콘 변경하기

🚩 런처 아이콘 파일 탐색

1. `Project` > `app` > `main` > `res` > `mipmap`들~
2. 이러한 `mipmap` 폴더는 Android 앱의 런처 아이콘 애셋을 배치해야 하는 위치!

`mdpi`, `hdpi`, `xhdpi` 등은 밀도 한정자로, 리소스 디렉터리(예: `mipmap`)의 이름에 추가하여 특정 화면 밀도 기기의 리소스

- `mdpi` - 중밀도 화면의 리소스(~160dpi)
- `hdpi` - 고밀도 화면의 리소스 (~240dpi)
- `xhdpi` - 초고밀도 화면의 리소스(~320dpi)
- `xxhdpi` - 초초고밀도 화면의 리소스(~480dpi)
- `xxxhdpi` - 초초초고밀도 화면의 리소스(~640dpi)
- `nodpi` - 화면의 픽셀 밀도와 관계없이 조정할 수 없는 리소스
- `anydpi` - 어떤 밀도로도 조정 가능한 리소스



🚩 앱 아이콘

+ 포그라운드 레이어 / 백그라운드 레이어

+ 포그라운드 레이어는 백그라운드 레이어 위에 쌓입니다



🚩 적응형 아이콘 파일 탐색

1. Android 스튜디오의 **Project 창**에서 **res > mipmap-anydpi-v26** 리소스 디렉터리를 찾아 펼칩니다.

2. XML 파일 중 하나를 엽니다(예: `ic_launcher.xml`). 다음과 같이 표시됩니다.
3. 각각에 리소스 드로어블을 제공하여 앱 아이콘의 `<background>` 및 `<foreground>` 레이어를 선언하는 데 `<adaptive-icon>` 요소가 어떻게 사용되는지 확인합니다.
4. **Project** 뷰로 돌아가서 드로어블이 선언된 위치를 찾습니다(**drawable > ic_launcher_background.xml**과 **drawable-v24 > ic_launcher_foreground.xml**).
5. **Design** 뷰로 전환하면 각각의 미리보기가 표시됩니다(왼쪽에 백그라운드, 오른쪽에 포그라운드).
6. 둘 다 벡터 드로어블 파일입니다. 픽셀 단위의 고정된 크기는 없습니다. **Code** 뷰로 전환하면 `<vector>` 요소를 사용하여 벡터 드로어블의 XML 선언을 확인할 수 있습니다.



🚩 그래픽

비트맵 이미지: 각 픽셀의 색상 정보를 제외하고 보유한 이미지에 대해 잘 알지 못함

벡터 그래픽: 화질 저하 없이 모든 화면 밀도의 어떤 캔버스 크기로도 조정할 수 있다는 것이 장점

벡터 드로어블: Android의 벡터 그래픽 구현 / 이러한 가능한 요소를 사용하여 xml로 정의 가능



🚩 앱 아이콘 변경하기

1. 먼저 Android 아이콘과 녹색 그리드 배경이 있는 이전 드로어블 리소스를 삭제합니다. **Project 뷰**에서 파일을 마우스 오른쪽 버튼으로 클릭하고 **Delete**를 선택합니다.

2. 새 **Image Asset**을 만듭니다. **res** 디렉터리를 마우스 오른쪽 버튼으로 클릭하고 **New > Image Asset**을 선택할 수 있습니다. 또는 **Resource Manager** 탭을 클릭하고 **+** 아이콘을 클릭한 후 **Image Asset**을 선택해도 됩니다.

3. Android 스튜디오의 **Image Asset Studio** 도구가 열립니다.

4. 기본 설정을 다음과 같이 그대로 유지합니다.

   > Icon Type: Launcher Icons (Adaptive and Legacy)
   >
   > Name: ic_launcher

5. **Foreground Layer 탭**이 이미 선택되어 있는 상태로 **Source Asset** 하위 섹션으로 이동합니다. **Path** 입력란에서 폴더 아이콘을 클릭합니다.

6. 컴퓨터를 탐색하여 파일을 선택하라는 메시지가 표시됩니다. 컴퓨터에 방금 다운로드한 새 `ic_launcher_foreground.xml` 파일의 위치를 찾습니다. 컴퓨터의 다운로드 폴더에 있을 수 있습니다. 파일을 찾았다면 **Open**을 클릭합니다.

7. 이제 **Path**가 새 포그라운드 벡터 드로어블의 위치로 업데이트됩니다. **Layer Name**은 **ic_launcher_foreground**로, **Asset Type**은 **Image**로 그대로 둡니다.

8. 이제 인터페이스의 **Background Layer 탭**으로 전환합니다. 기본값을 그대로 유지합니다. **Path**의 폴더 아이콘을 클릭합니다.

9. 방금 다운로드한 `ic_launcher_background.xml` 파일의 위치를 찾습니다. **Open**을 클릭합니다.

10. 새 리소스 파일을 선택하면 미리보기가 업데이트됩니다. 새로운 포그라운드 및 백그라운드 레이어가 적용된 모양은 다음과 같습니다.

11. 포그라운드 레이어의 주요 콘텐츠(이 경우 서비스 종 모양 아이콘)가 안전 영역 내에 포함되어 다양한 마스크 모양으로 인해 잘리지 않아야 합니다. 중요한 콘텐츠가 잘리거나 너무 작아 보이면 각 레이어의 **Scaling** 섹션에서 **Resize** 슬라이더 바를 사용하면 됩니다. 이 경우에는 크기를 조절하지 않아도 되므로 100%로 두면 됩니다.

12. **Next**를 클릭합니다.

13. 이 단계는 **Confirm Icon Path** 단계입니다. 개별 파일을 클릭하여 미리보기를 확인할 수 있습니다. 일부 기존 파일을 덮어쓴다는(빨간색으로 표시) 경고도 하단에 표시됩니다. 이러한 기존 파일은 이전 앱 아이콘용이었으므로 덮어써도 괜찮습니다.

14. 기본값이 좋으므로 **Finish**를 클릭합니다.

15. 생성된 모든 애셋이 `mipmap` 폴더에서 올바르게 표시되는지 확인합니다. 예를 들면 다음과 같습니다.



🚩 SDK에 따라..

+ 포그라운드 애셋은 `drawable-v24` 폴더에 

+ 백그라운드 애셋은 `drawable` 폴더에 

+ 백그라운드 애셋에는 그라데이션이 포함되어 있지 않아 기본 `drawable` 폴더에 넣을 수 있음

  별도의 두 `drawable` 폴더에 포그라운드 및 백그라운드 애셋을 두는 대신 두 벡터 드로어블 파일을 모두 `-v26` 리소스 디렉터리로 이동합니다. 이러한 애셋은 적응형 아이콘에만 사용되므로 이 두 드로어블은 API 26 이상에서만 필요합니다. 이 폴더 구조를 사용하면 적응형 아이콘 파일을 찾고 관리하기가 더 쉬워집니다.

  ```
  drawable-anydpi-v26
     ic_launcher_background.xml
     ic_launcher_foreground.xml
  mipmap-anydpi-v26
     ic_launcher.xml
     ic_launcher_round.xml
  ```



🚩 `drawable-anydpi-v26` 폴더 만드는 방법

1. 먼저 `drawable-anydpi-v26` 디렉터리를 만듭니다. **res** 폴더를 마우스 오른쪽 버튼으로 클릭합니다. **New > Android Resource Directory**를 선택합니다.

2. **New Resource Directory** 대화상자가 표시됩니다. 다음 옵션을 선택합니다.

   > **Directory name**: drawable-anydpi-v26
   >
   > **Resource type:** drawable(드롭다운에서 선택)
   >
   > **Source set:** main(기본값을 그대로 유지)

   **OK**를 클릭합니다. **Project** 뷰에서 새 리소스 디렉토리 **res > drawable-anydpi-v26**이 만들어졌는지 확인합니다.

3. `ic_launcher_foreground.xml` 파일을 마우스 왼쪽 버튼으로 클릭하고 **drawable** 폴더에서 **drawable-anydpi-v26** 폴더로 드래그합니다. 리소스를 'any dpi' 디렉터리에 넣는 것은 어떤 밀도로도 조정할 수 있는 리소스임을 나타냅니다.

4. `ic_launcher_background.xml`을 마우스 왼쪽 버튼으로 클릭하고 **drawable-v24** 폴더에서 **drawable-anydpi-v26** 폴더로 드래그합니다.

5. `drawable-v24` 폴더가 지금 비어 있다면 삭제합니다. 폴더를 마우스 오른쪽 버튼으로 클릭하고 **Delete**를 선택합니다.

6. 프로젝트의 모든 `drawable` 및 `mipmap` 파일을 클릭합니다. 이러한 아이콘의 미리보기가 올바르게 표시되는지 확인합니다.



##### 🚩 요약

- 앱 아이콘 파일을 `mipmap` 리소스 디렉터리에 배치합니다.
- Android의 이전 버전과의 호환성을 위해 각 밀도 버킷(`mdpi`, `hdpi`, `xhdpi`, `xxhdpi`, `xxxhdpi`)에 다양한 버전의 앱 아이콘 비트맵 이미지를 제공합니다.
- 리소스 디렉터리에 리소스 한정자를 추가하여 특정 구성(예: `v26`)의 기기에서 사용해야 하는 리소스를 지정합니다.
- 벡터 드로어블은 Android의 벡터 그래픽 구현입니다. 관련 색상 정보와 함께 일련의 점과 선, 곡선으로 XML에서 정의됩니다. 벡터 드로어블은 화질 저하 없이 어떤 밀도로도 조정할 수 있습니다.
- 적응형 아이콘은 API 26에서 Android 플랫폼에 도입되었습니다. 특정 요구사항을 준수하는 포그라운드 및 백그라운드 레이어로 구성되므로 다양한 OEM 마스크가 적용된 여러 기기에서 앱 아이콘이 고화질로 표시됩니다.
- Android 스튜디오에서 Image Asset Studio를 사용하여 앱의 레거시 및 적응형 아이콘을 만듭니다.



##### 더욱 세련된 사용자 환경 만들기

🚩 스위치

`activity_main.xml` 레이아웃에서 XML 태그를 `Switch`에서 `com.google.android.material.switchmaterial.SwitchMaterial.`로 변경합니다.

```
...

<com.google.android.material.switchmaterial.SwitchMaterial
    android:id="@+id/round_up_switch"
    android:layout_width="0dp"
    android:layout_height="wrap_content" ... />

...
```

장점: 라이브러리의 `SwitchMaterial` 구현이 업데이트되면(예: 머티리얼 디자인 가이드라인 변경) 직접 변경하지 않고도 무료로 위젯이 업데이트



🚩 아이콘

 [아이콘 목록을 확인](https://material.io/resources/icons/?style=baseline)



🚩 벡터 드로어블 애셋 추가

1. 애플리케이션 창의 왼쪽에 있는 **Resource Manager** 탭을 엽니다.
2. \+ 아이콘을 클릭하고 **Vector Asset**을 선택합니다.
3. **Asset Type**의 경우 **Clip Art**라는 라디오 버튼이 선택되어 있는지 확인합니다.
4. **Clip Art:** 옆에 있는 버튼을 클릭하여 다른 클립 아트 이미지를 선택합니다. 메시지가 표시되면 나타나는 창에 'call made'를 입력합니다. 이 화살표 아이콘을 Round up tip 옵션에 사용하겠습니다. 아이콘을 선택하고 **OK**를 클릭합니다.
5. 아이콘 이름을 `ic_round_up`으로 바꿉니다. 아이콘 파일의 이름을 지정할 때는 접두어 ic_을 사용하는 것이 좋습니다. **Size**를 24dp x 24dp로, **Color**를 black 000000으로 그대로 둡니다.
6. **Next**를 클릭합니다.
7. 기본 디렉터리 위치를 그대로 사용하고 **Finish**를 클릭합니다
8. 다른 두 아이콘에 2~7단계를 반복합니다.

- **서비스 질문 아이콘:** 'room service' 아이콘을 검색하여 `ic_service`로 저장합니다.
- **Cost of Service 아이콘:** 'store' 아이콘을 검색하여 `ic_store`로 저장합니다.

1. 완료하면 **Resource Manager**는 아래 스크린샷과 같으며 벡터 드로어블 세 개(`ic_round_up`, `ic_service`, `ic_store`)가 `res/drawable` 폴더에 나열됩니다.



<hr>

🚩 스타일: 단일 위젯 유형의 뷰 속성 값 모음

**res > values** 디렉터리에 `styles.xml`이라는 새 파일을 만듭니다. **values** 디렉터리를 마우스 오른쪽 버튼으로 클릭한 후 **New > Values Resource File**을 선택하여 파일을 만듭니다. 이름을 `styles.xml`로 지정합니다.

`style.xml`에 추가!

```xml
<style name="Widget.TipTime.TextView" parent="Widget.MaterialComponents.TextView">
</style>
```

세부설정

```xml
<style name="Widget.TipTime.TextView" parent="Widget.MaterialComponents.TextView">
    <item name="android:minHeight">48dp</item>
    <item name="android:gravity">center_vertical</item>
    <item name="android:textAppearance">?attr/textAppearanceBody1</item>
</style>
```

자주 사용되는 값의 관리 효율성을 높이려면 `dimens.xml` 파일

```xml
<resources>
   <dimen name="min_text_height">48dp</dimen>
</resources>
```



🚩 회전

`xml`

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



🚩 엔터 누르면 키보드 숨기기

`MainActivity.kt`

```kotlin
private fun handleKeyEvent(view: View, keyCode: Int): Boolean {
   if (keyCode == KeyEvent.KEYCODE_ENTER) {
       // Hide the keyboard
       val inputMethodManager =
           getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
       inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
       return true //이벤트 처리된 경우
   }
   return false //처리되지 않은 경우
}
```



🚩 뷰에 키 리스너를 설정하는 코드

`MainActivity.kt`

```kotlin
override fun onCreate(savedInstanceState: Bundle?) {
   ...

   setContentView(binding.root)

   binding.calculateButton.setOnClickListener { calculateTip() }

   binding.costOfServiceEditText.setOnKeyListener { view, keyCode, _ -> handleKeyEvent(view, keyCode)
   }
}
```



🚩 사진에 색 조정

`ic_service.xml` -> 다른 사진에도 적용해주기!

> 여기서, `android:tint` , `android:fillColor` 주목!

```xml
<vector xmlns:android="http://schemas.android.com/apk/res/android"
   android:width="24dp"
   android:height="24dp"
   android:viewportWidth="24"
   android:viewportHeight="24"
   android:tint="?attr/colorPirmary">
 <path
     android:fillColor="@android:color/white"
     android:pathData="M2,17h20v2L2,19zM13.84,7.79c0.1,-0.24 0.16,-0.51 0.16,-0.79 0,-1.1 -0.9,-2 -2,-2s-2,0.9 -2,2c0,0.28 0.06,0.55 0.16,0.79C6.25,8.6 3.27,11.93 3,16h18c-0.27,-4.07 -3.25,-7.4 -7.16,-8.21z"/>
</vector>
```



🚩 문제

1. Which line(s) of XML code will produce an error?

```kotlin
1    <TextView
2        android:layout_width="wrap_content"
3        android:layout_height"wrap_content"
4        android:padding="8dp"
5        android:text="@string/title"
6        android:textSize=18sp />
```

​		Line 3 - Missing = symbol after `android:layout_height` attribute.

 		Line 6 - Missing quotations around the attribute value `18sp`  

2. Which of the following is true about Gradle?

   Gradle is an automated build system used by Android Studio to build your apps.

   Gradle handles installing your app on a device.

   You can configure Android-specific options for your project in your app’s `build.gradle` file. 

3. Which of the following statements about app icons are true?

   mdpi, hdpi, xhdpi, xxhdpi, and xxxhdpi are density qualifiers for resource directories to indicate that these are resources to be used on devices with a specific screen density.

   Adaptive icons are made up of a foreground and background layer, and an OEM mask will be applied on top of them.

4. Which of the below steps are part of changing the color of your app theme?

   Modify the `themes.xml` (night) file.

   Set the primary and secondary color theme attributes of your app theme.

   Define the colors used in your app as color resources in the `colors.xml` file.

   set

5. Why use the Material Components for Android library?

   It provides widgets that follow the Material Design guidelines such as text fields and switches.

   It provides default Material themes that you can use directly or extend and then customize.

   It helps you more quickly build beautiful user experiences.

