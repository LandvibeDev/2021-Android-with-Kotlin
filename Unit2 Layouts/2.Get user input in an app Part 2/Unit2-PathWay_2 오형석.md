### Unit 2: Layouts

#### PATHWAY 1:Get user input in an app: Part 2

<hr/>

#### &#10004; Change the app theme

##### 머티리얼 디자인

머티리얼 디자인은 물체가 빛을 반사하고 그림자를 드리우는 방식을 포함하여 싲레 세계와 질감에서 영감을  받은 디자인. 머티리얼 테마를 사용하면 색상, 서체, 도형을 맞춤설정하는 방법으로 앱에 맞게 머티리얼 디자인을 조정 할 수 있음.

##### 테마 색상

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

정의되지 않은 색상은 상위 테마의 색상을 상속함.

```kotlin
<color name="white">#FFFFFFFF</color>
```

#FF는 알파값이며 색상이 100% 불투명하다는 의미.

##### 색상 선택을 위한 웹 기반 앱(머리티얼 팔레트 생성기)

https://material.io/resources/color/#!/?view.left=0&view.right=0



##### 앱에 색상 추가하고 테마에 색상 사용하기

color.xml에 새로운 색상 리소스를 정의하고 themes.xml에서 새로 정의한 색상들로 변경.



##### 어두운테마 

- 전력 사용을 크게 줄일 수 있음(기기의 화면 기술에 따라 다름)
- 시력이 낮은 사용자와 빛에 민감한 사용자의 가시성 개선 가능
- 조명이 어두운 황경에서 더 편하게 기기를 사용 할 수 있음.

어더운 테마의 색상은 읽기 쉬워야 하므로 어두운 테마는 제한된 강조 색상으로 어두운 표면 색상을 사용하고 가독성을 보장하기 위해 기본 색상은 항상 밝은 테마의 기본 색상보다 더 낮은 버전의 채도를 사용.

어두운 테마에서 더 많은 유연성과 사용성을 제공하려면 기본 색상 테마(900~00 사이의 강렬한 톤)대신 어두운 테마의 밝은 톤(200~0)을 사용하는게 좋음.



#### &#10004;Change the app icon

##### 아이콘

mdpi, hdpi, xhdpi 등은 밀도 한정자로, 리소스 디렉터리의 이름에 추가하여 특정 화면 밀도 기기의 리소스라고 나타낼 수 있다.

##### 밀도 한정자 목록

- `mdpi` - 중밀도 화면의 리소스(~160dpi)
- `hdpi` - 고밀도 화면의 리소스 (~240dpi)
- `xhdpi` - 초고밀도 화면의 리소스(~320dpi)
- `xxhdpi` - 초초고밀도 화면의 리소스(~480dpi)
- `xxxhdpi` - 초초초고밀도 화면의 리소스(~640dpi)
- `nodpi` - 화면의 픽셀 밀도와 관계없이 조정할 수 없는 리소스
- `anydpi` - 어떤 밀도로도 조정 가능한 리소스

##### 적응형 아이콘(adaptive icon)

적응형 런쳐 아이콘을 지원해 앱 아이콘이 더 유연해지고 흥미로운 시각 효과를 발휘할 수 있다. 개발자는 앱 아이콘을을 포그라운드 레이어와 백그라운드 레이어로 구성할 수 있다. 포그라운드 레이어는 백그라운드 레이어 위에 쌓인다.

벡터 드로어블과  비트맵 이미지는 모두 그래픽을 설명하지만 중요한 차이점이 있다. **비트맵 이미지는** 각 픽셀의 색상 정보를 제외하고 보유한 이미지에 관해 잘 알지 못합니다. 반면에 **벡터 그래픽**은 이미지를 정의하는 모양을 그리는 방법을 알고 있습니다. 이러한 지침은 색상 정보와 함께 일련의 점과 선, 곡선으로 구성됩니다. 벡터 그래픽은 화질 저하 없이 모든 화면 밀도의 어떤 캔버스 크기로도 조정할 수 있다는 것이 장점입니다.

###### 벡터드로어블 

벡터 드로어블은 안드로이드의 벡터 그래픽 구현으로, 휴대기기에서 충분히 유연하도록 만들어짐. 다양한 요소(ex:```android:name```)를 사용해 XML로 정의할 수 있다. 모든 밀도 버킷에 비트맵 애셋 버전을 제공하는 대신 이미지를  한 번만 정의하면 된다. 따라서 앱의 크기가 줄어 유지하기가 쉽다. 비트맵 이미지와 비교해 벡터 드로어블의 단점은 아이콘은 단순한 모양으로 구성되기 때문에 벡터 드로어블로 적합할 수 있지만 사진은 일련의 모양으로 설정하기 어려울 수 있다. 이 경우 비트맵 애셋을 사용하는 것이 더 효율적이다.

#### &#10004;Create a more polished user experience

#### material components

- 머티리얼 구성요소는 앱에서 머티리얼 스타일을 더 쉽게 구현할 수 있는 일반적인 UI위젯. 머티리얼 구구성요소를 사용하면 앱이 사용자 기기에 있는 다른 앱과 더 일관된 방식으로 작동하므로 사용자는 앱을 사용하는 방법을 훨씬 더 빠르게 배울 수 있음
- 머티리얼 구성요소는 머티리얼 디자인 구성요소(MDC) 라이브러리를 프로젝트의 종속  항목으로 포함해야함.

##### 스타일

- 단일 위젯 유형의 뷰 속성 값 모음.

- 뷰의 속성을 스타일로 추출하면 레이아웃의 스타일을 여러 뷰에 쉽게 적용하고 단일위치 유지가능

- 구성요소 스타일을 지정할 때는 일반적으로 ㅇ사용하는 위젯 유형의 상위 스타일에서 확장

- 상위 머티리얼 스타일에서 상속하는 경우 MaterialComponents를 앱 이름으로 바꿔 스타일을 지정. 이렇게하면 변경사항이 고유한 네임스페이스로 이동되어 향후 머티리얼 구성요소에 새로운 스타일이 도입될 때 충돌이 발생할 가능성이 없어짐. 

  ```kotlin
  <style name="Widget.TipTime.TextView" parent="Widget.MaterialComponents.TextView">
  </style>
  
  ```

- TextView 스타일은 TextViews에만 적용할 수 있음. (다른것도 마찬가지)

- 설정 값을 공유하는 구성요소가 많으면 dimes.xml을 사용하면 값 변경이 쉬움

##### 사용자 환경 향상하기

기기회전시 화면이 짤릴 수 있는데 ConstraintLayout` 주위에 `ScrollView를 추가하면 해결할 수 있음.

<hr/>

#### Quiz 

#### 1. Which line(s) of XML code will produce an error?

```kotlin
1    <TextView
2        android:layout_width="wrap_content"
3        android:layout_height"wrap_content"
4        android:padding="8dp"
5        android:text="@string/title"
6        android:textSize=18sp />
```

- Line 3 - Missing = symbol after `android:layout_height` attribute.
- Line 6 - Missing quotations around the attribute value `18sp`.

#### 2. Which of the following is true about Gradle?

- Gradle is an automated build system used by Android Studio to build your apps.
- Gradle handles installing your app on a device.
- You can configure Android-specific options for your project in your app’s `build.gradle` file.

#### 3. Which of the following statements about app icons are true?

- mdpi, hdpi, xhdpi, xxhdpi, and xxxhdpi are density qualifiers for resource directories to indicate that these are resources to be used on devices with a specific screen density.
- Adaptive icons are made up of a foreground and background layer, and an OEM mask will be applied on top of them.

#### 4. Which of the below steps are part of changing the color of your app theme?

- Modify the `themes.xml` (night) file.
- Set the primary and secondary color theme attributes of your app theme.
- Define the colors used in your app as color resources in the `colors.xml` file.

#### 5. Why use the Material Components for Android library?

-  It provides widgets that follow the Material Design guidelines such as text fields and switches.

-  It provides default Material themes that you can use directly or extend and then customize.
-  It helps you more quickly build beautiful user experiences.











