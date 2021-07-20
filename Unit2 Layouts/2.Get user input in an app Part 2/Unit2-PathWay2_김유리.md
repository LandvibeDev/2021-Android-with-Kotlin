# 2021 Landvibe Summer Coding - Android

## Unit2 - Layouts

## PathWay2 - Get user input in an app : Part2

### 앱 테마 변경

##### 📌디자인 및 색상

- **머티리얼 디자인**은 읽기 쉽고 일관된 방식으로 앱 UI를 빌드하는 방법에 관한 가이드 라인 제시한다.
- :link:[**머티리얼 테마**](https://material.io/resources/color/#!/?view.left=0&view.right=0&primary.color=c5e1a5)를 사용하면 색상, 서체, 도형을 맞춤 설정하는 방법으로 앱에 맞게 머티리얼 디자인 조정 가능하다.

- **색상**은 색의 RGB 구성요소를 나타내는 3개의 16진수 숫자와 투명도를 나타내는 알파값을 포함하여 정의할 수 있다. 

##### &#128204;테마

1. Android 스튜디오에서 `themes.xml` 열기
2. 앱 이름을 기반으로 하는 테마 이름( `Theme.TipTime` ) 확인
3. XML 행에서 상위 테마인 `Theme.MaterialComponents.DayNight.DarkActionBar`지정 - `DayNight`는 머티리얼 구성요소 라이브러리에 미리 정의된 테마, `DarkActionBar`는 작업모음이 어두운 색상
4. 테마에 정의되지 않은 테마 색상 속성은 상위 테마 색상 사용
5. 색상은 RGB값을 직접 사용하는 것이 아니라 색상 리소스(예 : `@color/purple_500`)로 지정
6. `colors.xml`을 열면 각 색상 리소스의 16진수 값을 볼 수 있음



##### &#128204;앱 테마 색상 선택

- 웹 기반 앱인 **색상 도구**를 사용하면 더 쉽게 색상을 서ㄴ택할 수 있다.
- 색상 선택하기
  1. 기본 색상(`colorPrimary`) 선택 
  2. 보조 섹션을 탭하고 보조 색상(`colorSecondary`) 선택 
  3. **접근성** 탭을 통해 선택한 색상에서 검은색 또는 흰색 텍스트를 사용할 때 명확하게 읽을 수 있는지 알 수 있음
  4. `primaryColorVariant`및 `secondaryColorVariant`의 경우 추천하는 밝은 변형이나 어두운 변형 선택 가능
- 앱에 색상 추가하기
  1. `colors.xml`열기
  2. 기존에 있는 색상 다음에 값이 `#1B5E20`인 `green`이라는 색상 리소스 정의
  3. 다른 색상의 리로스 계속 정의
- 테마에 색상 사용하기
  1. `themes.xml`사용
  2. `colorPrimary`를 선택한 기본 색상 `@color/green`으로 변경
  3. `colorPrimaryVariant`를 `@color/green_dark`로 변경
  4. `colorSecondary`를 `@color/blue`로 변경
  5. `colorSecondaryVariant`를 `@color/blue_dark`로 변경
  6. P의 텍스트와 S의 텍스트가 여전히 흰색과 검은색이니 확인



##### &#128204;어두운 테마

- 장점
  - 전력 사용을 크게 줄일 수 있음
  - 시력이 낮은 사용자와 밝은 빛에 민감한 사용자의 가시성 개선
  - 조명이 어두운 환경에서 더 편하게 기기 사용
- 어두운 테마의 색상 선택하기
  - 기본 색상 테마 대신 어두운 테마의 밝은 톤(200~50) 사용하는 것이 좋음
- 어두운 테마 업데이트하기
  1. `themes.xml(night)`열기
  2. `colorPrimary`를 선택한 기본 색상 `@color/green_light`의 밝은 변형으로 변경
  3. `colorPrimaryVariant`를 `@color/green`으로 변경
  4. `colorSecondary`를 `@color/blue_light`로 변경
  5. `colorSecondaryVariant`를 `@color/blure_light`로 변경
  6. 원래 정의된 색상 삭제
- 어두운 테마 사용해보기
  1. 설정 앱에서 디스플레이 섹션으로 이동
  2. 어두운 테마 스위치 ON



### 앱 아이콘 변경

##### &#128204;런처 아이콘

- 화면 픽셀 밀도는 기기마다 다르므로 여러 버전의 앱 아이콘을 제공해야 한다.
- 런처 아이콘 파일 탐색
  1. **Project 창**에서 **Project**뷰로 전환
  2. 리소스 디렉터리로 이동해 일부 `mipmap`폴더를 펼치기 - `mipmap`폴더는 Android 앱의 런처 아이콘 애셋을 배치해야 하는 위치
     - 밀도 한정자 목록 
       - `mdpi` - 중밀도 화면 리소스(160dpi)
       - `hdpi` - 고밀도 화면의 리소스 (~240dpi)
       - `xhdpi` - 초고밀도 화면의 리소스(~320dpi)
       - `xxhdpi` - 초초고밀도 화면의 리소스(~480dpi)
       - `xxxhdpi` - 초초초고밀도 화면의 리소스(~640dpi)
       - `nodpi` - 화면의 픽셀 밀도와 관계없이 조정할 수 없는 리소스
       - `anydpi` - 어떤 밀도로도 조정 가능한 리소스



##### &#128204;적응형 아이콘

- 포그라운드 및 백그라운드 레이어

  : 포그라운드 레이어와 백그라운드 레이어가 나뉘어 백그라운드 위에 포그라운드가 쌓인다. 그런 다음 마스크가 맨 위에 적용되어 앱 아이콘이 생성된다.

- 적응형 아이콘 파일 탐색

  1. **Project 창**에서 **res > mipmap-anydpi-v26** 리소스 디렉터리 펼치기
  2. XML 파일 중 하나 열기 ( 예 : `ic_launcher.xml`)
  3. 각각에 리소스 드로어블을 제공하여 앱 아이콘의 `<background>`및 `<foreground>`레이어 선언하는데 `<adaptive-icon>`요소가 어떻게 사용되는지 확인
  4. **Project**뷰로 돌아가서 드로어블이 선언된 위치 찾기
  5. 백그라운드와 포그라운드 둘다 벡터 드로어블 파일로 픽셀 단위의 고정된 크기는 없음 - **Code**뷰로 전환하면 `<vector>`요소임을 확인할 수 있음

- 벡터 드로어블과 비트맵 이미지 차이점

  - 비트맵 이미지는 각 픽셀의 색상 정보를 제외하고 보유한 이미지에 관한 정보가 없음
  - 벡터 드로어블은 이미지를 정의하는 모양을 그리는 방법을 알고 있음 - 색상정보와 함께 일련의 점, 선, 곡선으로 구성
  - 벡터 드로어블은 화질 저하 없이 크기 조정 가능
  - 아이콘은 단순한 모양이므로 벡터 드로어블이 적합할 수 있지만 사진은 비트맵이 더 효율적임



##### &#128204;앱 아이콘 변경

- 새 애셋 사용
  1. 이전 드로어블 리소스 삭제 
  2. 새 **Image Asset** 만들기
  3. **Foreground Layer**탭에서 **Path**입력란에 다운로드 한 `ic_launcher_foreground.xml` 파일 넣기
  4. **Background Layer**에도 `ic_launcher_background.xml`파일 넣기
  5. 나머진 기본값
- 벡터 드로어블 파일은 -v26 디렉터리로 이동
  - 앱의 최소 SDK에 따라 포그라운드 애셋은 그라데이션이 포함되어 있어`drawable-v24`폴더에 있고 백그라운드 애셋은 그라데이션이 포함되지 않으므로 `drawable`에 있다. 
  - 포그라운드 및 백그라운드 애셋을 `-v26`리소스 디렉터리로 이동 - 적응형 아이콘 파일을 찾고 관리하기 더 쉬워짐
- 적응형 및 레거시 런처 아이콘
  - 모든 앱 아이콘 비트맵 이미지를 제거할 수 없는 이유는 이전 버전의 Android에서 앱 아이콘이 고화질로 표시되기 위해서는 비트맵 이미지가 필요하기 때문이다.
  - Android 8.0 미만을 실행하는 기기에서는 레거시 런처 아이콘이 사용된다.( 여러 밀도 버킷의 `mipmap`폴더에 있는 비트맵 이미지)



### 더욱 세련된 사용자 환경 만들기

##### &#128204;머티리얼 구성 요소

- :link:[**머티리얼 구성요소**](https://material.io/components)는 앱에서 머티리얼 스타일을 더 쉽게 구현할 수 있는 일반적인 UI 위젯이다. 

- 텍스트 필드 

  1. **Tip Time**앱을 열고 `activity_main.xml`레이아웃 파일로 이동
  2. `ConstraintLayout`에 첫번재 하위요소로 머티리얼 텍스트 필드 삽입
  3. `EditText`필드 제거
  4. 텍스트 필드에 가로 세로 제약 조건 추가
  5. `TextInputEditText`요소에 적절한 속성이 모두 있는지 확인
  6. `EditText`에서 입력 유형을 잘라 `TextInputEditText.`에 붙여 넣고 요소 리소스 ID를 `cost_of_service_edit_text.`로 변경
  7. 레이아웃에서 `EditText`삭제 
  8. `MainActivity.kt`파일의 `calculateTip()`메서드 오류 - 뷰 결합을 사용 설정한 경우 Android는 리소스 ID 이름을 기반으로 결합 객체에 속성을 생성하므로 코드 업데이트 필요
  9. `TextInputEditText`요소에서 리소스 ID가 `cost_of_service_edit_text`인 사용자 입력을 가져오고 `MainActivity`에서 `binding.costOfServiceEditText`를 사용해 저장된 텍스트 문자열에 액세스

- 스위치

  - 설정을 사용 또는 사용중지로 전환할 수 있는 위젯

  1. `activity_main.xml`레이아웃에서 XML 태그를 `Switch`에서 `com.google.android.material.switchmaterial.SwitchMaterail.`로 변경
  2. `Switch`대신 `SwitchMaterial`을 사용하면 구현이 업데이트되면 직접 변경하지 않고도 무료로 위젯이 업데이트 됨



##### &#128204;아이콘

- 앱의 아이콘은 벡터 드로어블을 사용하는 것이 좋다.

- 아이콘 추가하기

  - 벡터 드로어블 애셋 추가하기 
    1. 애플리케이션 창의 왼쪽에 있는 **Resource Manager** 열기
    2. **+**아이콘 클릭 후 **Vector Asset** 선택
    3. **Asset Type**에 **Clip Art** 선택
    4. **Clip Art:**옆에 있는 버튼을 클릭해 다른 클립 아트 이미지 선택  - 여기선 'call made'선택
    5. 아이콘 이름을 `ic_round_up`으로 변경 - 아이콘 파일 이름을 지정할 때는 접두어 ic_을 사용하는 것이 좋음
    6. 위 단계를 다른 두 아이콘도 반복
       - 서비스 질문 아이콘 : 'room service'아이콘 검색 후 `ic_service`로 저장
       - Cost of Service 아이콘 : 'store' 아이콘 검색 후 `ic_store`로 저장

- 이전 Android 버전 지원하기

  1. 벡터 지원 라이브러리를 사용하도록 앱을 구성하기 위해 `vectorDrawables`요소를 앱의 `build.gradle` 파일에 추가

     `app/build.gradle`

     ```kotlin
     android {
     	defaultConfig {
     		...
     		vectorDrawables.useSupportLibrary = true
     	}
     	...
     }
     ```

- 아이콘을 삽입하고 요소 배치하기

  1. `activity_main.xml` 열기

  2. 먼저 Cost of Service 텍스트 필드 옆에 상점 아이콘 배치, 새 `ImageView`를 `ConstraintLayout`의 첫번째 하위 요소로 삽입

  3. `ic_store`아이콘을 보유하도록 `ImageView`에서 적절한 속성 설정 - ID는 `icon_cost_of_service`로 설정, `app:srcCompat`속성을 드로어블 리소스 `@drawable/ic_store`로 설정

  4. 이 이미지는 장식용으로만 사용되므로 `android:importantForAccessibility="no"`로 설정

  5. `ImageView`에 제약 조건을 추가한 후 그 옆의 `TextInputLayout`에서 제약 조건을 업데이트 - `ImageView`에서 시작 가장자리를 상위 뷰의 시작 가장자리로 제한, `ImageView`의 상단은 텍스트 필드의 상단으로, 하단은 텍스트 필드의 하단으로 제한 

     ```kotlin
     app:layout_constraintStart_toStartOf="parent"
     app:layout_constraintTop_toTopOf="@id/cost_of_service"
     app:layout_constraintBottom_toBottomOf="@id/cost_of_service"
     ```

  6. `cost_of_service`텍스트 필드의 제약 조건 업데이트 - `TextInputLayout`의 시작 가장자리는 `ImageView`의 끝 가장자리로 제한, 두 뷰 사이의 간격 추가하기 위해 `TextInputLayot`에 시작 여백 `16dp`추가

     ```kotlin
     android.layout_marginStart="16dp"
     app:layout_constraintStart_toEndOf="@id/icon_cost_of_service"
     ```

  7. "How was the service?"`TextView`옆에 종 모양 아이콘 삽입 - `TextInputLayout`뒤, `service_question``TextView`앞에 삽입

  8. 새 `ImageView`의 경우 리소스 ID `@+id/icon_service_question`할당 후 제약 조건 설정

     ```kotlin
     <ImageView
             android:id="@+id/icon_service_question"
             android:layout_width="wrap_content"
             android:layout_height="wrap_content"
             android:importantForAccessibility="no"
             app:srcCompat="@drawable/ic_service"
             app:layout_constraintStart_toStartOf="parent"
             app:layout_constraintTop_toTopOf="@id/service_question"
             app:layout_constraintBottom_toBottomOf="@id/service_question" />
     ```

  9. `RadioGroup` 제약 조건 업데이트 - `RadioGroup`의 시작 가장자리를 `service_question``TextVie`의 시작 가장자리로 제한 

     ```kotlin
     app:layout_constraintStart_toStartOf="@id/service_question"
     ```

  10. "Round up tip?"스위치 옆에 `ic_round_up`아이콘 추가

  11. 새 `ImageView`에 리소스 ID `icon_round_up` 할당

  12. `RadioGroup`뒤, `SwitchMaterial`위젯 앞에 새 `ImageView`삽입

  13. 새 `ImageView`에 `srcCompat`을 `@drawable/ic_round_up` 아이콘의 드로어블로 설정하고 이미지의 시작 부분을 상위 요소의 시작 부분으로 제한하고 `SwitchMaterial`을 기준으로 아이콘 세로로 중앙에 배치

  14. `SwitchMaterial`을 아이콘 옆에 위치하도록 업데이트하고 시작여백 `16dp`설정

  15. Calculate 버튼과 그 위의 스위치 사이에 세로 여백 `8dp`추가

  16. `tip_result``TextView`에 상단 여백 `8dp`추가



##### &#128204;스타일 및 테마

- 스타일 만들기

  1. 아직 없는 경우 **res > values**디렉터리에 **New > Values Resource File**을 선택해 `style.xml`이라는 파일 생성

     ```kotlin
     <?xml version="1.0" encoding="utf-8"?>
     <resources>
     </resources>
     ```

  2. 앱 전체에서 텍스트를 일관되게 표시하도록 새 `TextView`스타일 생성 - 한번 정의하면 레이아웃의 모든 `TextViews`에 적용가능

  3. `android:minHeight, android:gravity` 속성과 `android:textAppearance`속성을 재정의하도록 설정

     ```kotlin
     <style name="Widget.TipTime.TextView" parent="Widget.MaterialComponents.TextView">
     <item name="android:minHeight">48dp</item> 
         <item name="android:gravity">center_vertical</item> //세로 중앙 배치
         <item name="android:textAppearance">?attr/textAppearanceBody1</item> // defaults to regular 16sp text.
     </style>
     ```

     - `android:minHeight`는 최소 높이
     - `android:gravity`속성은 뷰 안의 콘텐츠가 배치되는 방식 제어 - 가능한 중력 값에는 `center`,`center_vertical`,`center_horizontal`,`top`,`bottom`이 있음
     - `android:textAppearance`는 텍스트 큭, 글꼴, 기타 텍스트 속성과 관련된 일련의 사전 제작된 스타일

  4. `activity_main.xml`에서 각 `TextView`에 스타일 속성 추가해 `Widget.TipTime.TextView` 스타일을 `service_question``TextView`에 적용

  5. 스위치 텍스트 라벨에 적용할 새로운 스타일 만들기 - 속성은 이전과 동일

  6. MDB 라이브러리의 `Switch`스타일에서 상속 받으므로 `Widget.TipTime.CompountButton.Switch`가 상위 스타일 `Widget.MaterialComponents.CompountButton.Switch`에 상속

  7. 라디오 버튼에 적용할 새로운 스타일 만들기 - `paddingStart`속성에 8dp 설정, `textAppearance`에 `?attr/textAppearanceBody1` 적용

  8. 자주 사용되는 값의 관리 효율성을 높이려면 `dimens.xml`파일을 만들어 공통적인 값을 명명된 치수로 표준화

     `dimens.xml`

     ```kotlin
     <resources>
     	<dimen name="min_text_height">48dp</dimen>
     </resources>
     ```

  9. `48dp`대신 `@dimen/min_text_heigh`사용하도록 `styles.xml`파일 업데이트

- 구성요소 스타일 지정시엔 일반적으로 사용하는 위젯 유형의 상위 스타일에서 확장해야 한다.

  - 이유
    1. 중요한 모든 기본 값을 구성요소에 설정
    2. 스타일이 계속해서 상위 스타일의 향후 변경사항을 상속

- 스타일 이름 지정 권장 규칙

  - 상위 머티리얼 스타일에서 상속하는 경우 유사한 방식으로 `MaterialComponents`를 앱 이름으로 바꿔 스타일 이름 지정

- 테마에 스타일 추가하기

  - 테마와 스타일은 모두 동일한 `<style>`구문을 사용하지만 용도가 다름

  - 스타일

    - 보기 속성 값의 모음
    - 위젯마다 다른 속성 집합을 지원하므로 스타일은 단일 유형의 위젯에만 해당됨
    - 스타일로 추출하면 여러 보기에서 쉽게 재사용하고 유지 관리 가능
    - 해당 뷰에만 적용되고 자식은 적용 안됨 -> 스타일 지정 우선 순위 사용하여 해결

  - 테마

    - 나중에 스타일, 레이아웃 등으로 참조할 수 있는 명명된 리소스 모음
    - Android 리소스에 의미 체계 이름(테마 속성)을 제공해 나중에 참조 가능
    - 테마 속성은 앱에서 광범위하게 적용할 수 있는 값에 대한 *의미상 명명된*포인터이기 때문에 보기 속성과는 다름
    - 인터페이스와 유사 - 테마 속성에 대해 레이아웃과 스타일 작성해 다양한 테마에서 사용가능, 다양한 구체적인 리소스 제공

  - `OutlineBox`스타일 사용

    1. 원하는 스타일이 테마에서 참조되도록 `themes.xml`파일 수정

       ```kotlin
       <item name="textInputStyle">@style/Widget.MaterialComponents.TextInputLayout.OutlinedBox</item>
       <item name="radioButtonStyle">@style/Widget.TipTime.CompoundButton.RadioButton</item>
       <item name="switchStyle">@style/Widget.TipTime.CompoundButton.Switch</item>
       ```



##### &#128204;사용자 환경 향상하기

- 기기 회전하기

  1. 기기에서 **설정 > 디스플레이  > 고급 > 화면 자동 회전**에서 **자동 회전**설정

  2. **Calculate**버튼을 포함한 일부 UI 구성요소 잘림

  3. `ConstraintLayout`주위에 `ScrollView`추가

     ```kotlin
     <ScrollView
     
     xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_height="match_parent"
        android:layout_width="match_parent">
     ```

- Enter 키를 누르면 키보드 숨기기

  - 터치 키보드는 소프트 키보드라고도 하며 실제 키보드가 아님

  1. 다음 도우미 메서드를 복사해 `MainActivity`클래스에 붙여넣기

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

     - `handleKeyEvent()`는 `keyCode`입력 매개변수가 `KeyEvent.KEYCODE_ENTER`와 같은 경우 터치 키보드를 숨기는 비공개 도우미 함수
     - 키 이벤트가 처리되면 true, 처리 되지 않으면 false 반환

  2. `TextInputEditText`위젯에서 키 리스너 연결

  3. `costOfServiceEditText`에서 `setOnKeyListener()`메서드 호출하고 `OnKeyListener`전달 

  4. 텍스트 필드에 키 리스너를 설정하는 코드를 `onCreate()`메서드 내에 추가

     ```kotlin
     override fun onCreate(savedInstanceState: Bundle?) {
        ...
     
        setContentView(binding.root)
     
        binding.calculateButton.setOnClickListener { calculateTip() }
     
        binding.costOfServiceEditText.setOnKeyListener { view, keyCode, _ -> handleKeyEvent(view, keyCode)
        }
     }
     ```

     - `OnKeyListener`에 있는 키 누름이 발생될 때 트리거되는 `onKey()`메서드는 뷰, 누른 키의 콛, 키 이벤트를 입력 인수로 사용함

- 음성 안내 지원을 사용하여 앱 테스트하기

  - 음성 안내 사용 또는 사용 중지
    1. 볼륨 키 2개 3초 동안 눌러서 켜고 끄기
    2. "Hey Google"이라고 말해 Google 어시스턴트를 불러 "음성 안내 지원 꺼/켜 줘"라고 말하기
    3. 기기 설정에서 **접근성 > 음성 안내 지원**의 **음성 안내 지원 사용**을 사용 또는 사용 중지
  - 음성 안내 지원으로 앱 탐색
    - 선형 탐색 : 오른쪽 또는 왼쪽으로 빠르게 스와이프하여 화면 요소 순서대로 탐색, 선택하려면 아무 곳이나 두번 탭
    - 터치하여 탐색 : 화면에서 손가락을 드래그해 표시된 항목에 관한 설명 듣기, 선택하려면 아무 곳이나 두번 탭

- 벡터 드로어블의 색조 조정하기

  - `colorPrimary`테마 속성(기본 색상)을 기반으로 색조 변경
    1. `ic_service.xml`에서 `android:tint`속성 값 `?attr/colorPrimary`로 변경 - `colorPrimary`테마 속성이 가리키는 값은 밝은 테마와 어두운 테마에 따라 다름
    2. 다른 벡터 드로어블에서도 색조 변경



#### &#128204;퀴즈

1. 다음 XML 코드에서 일어나는 오류

   ```kotlin
   1    <TextView
   2        android:layout_width="wrap_content"
   3        android:layout_height"wrap_content"
   4        android:padding="8dp"
   5        android:text="@string/title"
   6        android:textSize=18sp />
   ```

   - 3행 - `android:layout_height`속성 뒤에 = 기호가 없음
   - 6행 - 속성 값 주위에 따옴표가 없음

2. Gradle에 대한 설명

   - Gradle은 Android Studio에서 앱을 빌드하는 데 사용하는 자동화된 빌드 시스템
   - Gradle은 기기에 앱 설치를 처리
   - 앱 `build.gradle`파일에서 프로젝트에 대한 Android 관련 옵션 구성 가능

3. 앱 아이콘에 대한 설명

   - mdpi, hdpi, xhdpi, xxhdpi 및 xxxhdpi는 특정 화면 밀도를 가진 장치에서 사용할 리소스임을 나타내는 리소스 디렉터리의 밀도 한정자
   - 적응형 아이콘은 포그라운드와 백그라운드로 구성되며 그 위에 OEM 마스크가 적용됨

4. 앱 테마의 색상을 변경하는 단계

   - `themse.xml`(night) 파일 수정
   - 앱 테마의 기본 및 보조 색상 테마 속성 설정
   - 앱에 사용된 색상을 `colors.xml`파일의 색상 리소스로 정의

5. Android 라이브러리용 머티리얼 구성요소를 사용하는 이유

   - 텍스트 필드 및 스위치와 같은 머티리얼 디자인 지침을 따르는 위젯 제공

   - 직접 사용하거나 확장한 다음 사용자 지정할 수 있는 기본 머티리얼 테마 제공

   - 사용자 경험을 더 바르게 구축하는 데 도움을 줌

     

