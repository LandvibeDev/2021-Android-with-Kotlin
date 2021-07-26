# 2021 Landvibe Summer Coding - Android

## Unit1 : Kotlin basics

### PathWay3 : Build a basic layout



##### :label: Design a Birthday Card app

- Qualities of a great app
  - Effective
  - Efficient
  - Beautiful
  - Accessible

->  pre : 필요한 작업 선정



##### :label: Create a Birthday Card app

- 사용자 인터페이스(UI)

화면에 표시되는 텍스트, 이미지, 버튼, 기타 여러 유형의 요소

UI를 통해 앱은 사용자에게 콘텐츠를 표시, 사용자는 앱과 상호작용

- `View`

UI의 각 요소, 앱 화면에 표시되는 대부분의 내용

컨테이너에 배치한다. (가로와 세로로 제한되어야 한다.)

- `TextView`

텍스트를 표시하는 `View`유형(UI 요소)

- `ViewGroup`

  `View`객체가 있을 수 있는 컨테이너, 내부의 `Views`를 정렬한다.

  - `ConstraintLayout`

- **Layout Editor**
  - Design 뷰 : 앱이 실행될 때 표시될 화면의 모습
  - Bluprint 뷰
  - Palette : 앱에 추가될 수 있는 다양한 유형의 `Views`목록
  - Component Tree : 화면의 모든 뷰 나열 (화면 뷰)
  - Attributes : `View`의 속성을 표시하고 변경

```xml
<TextView
        android:id="@+id/textView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="16dp"
        android:layout_marginLeft="16dp"
        android:layout_marginTop="16dp"
        android:fontFamily="sans-serif-light"
        android:text="Happy Birthday, Sam!"
        android:textColor="@android:color/black"
        android:textSize="36sp"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
```

* sp : `textSize`

글꼴 크기 측정 단위, dp와 같은 크기이지만 사용자가 선호하는 텍스트 크기에 따라 조정된다.





##### :label: Add images to your Android app

- `imageView`

이미지를 표시

``````xml
<ImageView
        android:id="@+id/imageView"
        android:layout_width="0dp"
        android:layout_height="0dp"
        android:scaleType="centerCrop"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:srcCompat="@drawable/androidparty" />
``````

- `android:layout_width="0dp"` `android:layout_height="0dp"`

0dp(match constraint) : 여백을 뺀 만큼 넓어진다.

- `android:scaleType="centerCrop"`

이미지의 가로/세로 길이 중 짧은 쪽을 해당 레이아웃에 꽉 차게 크기를 맞추어 출력한다.



:zap:하드코딩 문자열은 '리소스 파일로 문자열을 추출'하여 다른언어로 쉽게 번역되도록 할 수 있다.



###### practice

![](C:\Users\김혜인\AppData\Roaming\Typora\typora-user-images\image-20210712004732827.png)





##### :label:Quiz

1. Which of the following elements is considered a View in an Android app?

   - All of the above

     - An image
     - A clickable button
     - Text on the screen

     

2. What is the main purpose of a ViewGroup?

   - It serves as a container for View objects, and is responsible for arranging the View objects within it.

   

3. **빈 칸 채우기**

   *단어를 하나 이상 입력하여 문장을 완성하세요.*

   The type of ViewGroup that helps you arrange the views inside of it in a flexible way is called a `ConstraintLayout`

   

4. Which of the following are Attributes in Android?

   *적절한 답변을 모두 선택합니다.*

   - text
   - textSize
   - textColor

   

5. **빈 칸 채우기**

   *단어를 하나 이상 입력하여 문장을 완성하세요.*

   In Android, a graphic that can be drawn to the screen is generally referred to as a `Drawable`

   

6. Which of the following is an example of a “constraint” that could be applied to a view in a ConstraintLayout ViewGroup in the Layout Editor?

   - A view that must always be a minimum distance away from the edge of its container

   

7. What is the purpose of the activity_main.xml file in the project you created?

   - It describes the layout of view groups and views for a screen.
   - A view that must always be to the right of another view
   - A view that must always be the topmost view inside a container

   

8. Why should you use string resources instead of hard-coded strings in your apps?

   *적절한 답변을 모두 선택합니다.*

   - It makes your app easier to translate.
   - It allows you to reuse the same string in multiple places in your program.

