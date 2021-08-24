# Unit1-Pathway3



* **생일 카드 앱 디자인하기**

  * 좋은 앱이란?
    * 효과적(Effective), 효율적(Efficient), 아름다움(Beautiful), 접근성 우수(Accessible)

* **생일 카드 앱 만들기**

  * Happy Birthday 앱 설정

    * Empty Activity 프로젝트 만들기
      * Empty Activity 템플릿을 사용하여 새 Kotlin 프로젝트를 생성
      * Minimum SDK을 19로 설정
    * 사용자 인터페이스 정보
      * `View`
        * 앱 화면에 표시되는 대부분의 내용
        * `View` 는 클릭 가능한 버튼이나 수정 가능한 입력란처럼 상호작용이 가능
        * `View` 는 서로 관계가 있기 때문에 컨테이너에 배치함
        * `ViewGroup` 은 `View` 객체가 그 안에 존재할 수 있는 컨테이너로, 내부의 `View` 를 정렬하는 역할

  * 레이아웃에 `TextView` 추가

    ```kotlin
        <TextView
            android:id="@+id/textView"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginStart="16dp"
            android:layout_marginTop="16dp"
            android:text="Happy Birthday, Sam!"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent" />
    ```

    * `dp`
      * UI의 여백 및 기타 거리 단위
      * cm, inch와 비슷하지만 화면상의 거리 의미
      * Android에서는 이 값을 각 기기의 적절한 실제 픽셀 수로 변환
      * 기준으로 1dp는 1inch의 약 160분의 1이지만 기기에 따라 더 크거나 작을 수 있음

  * 텍스트에 스타일 추가

    ```kotlin
        <TextView
            android:id="@+id/textView"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginStart="16dp"
            android:layout_marginTop="16dp"
            android:text="Happy Birthday, Sam!"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent"
            android:textSize="36sp"
            android:fontFamily="casual"
            android:textColor="@color/black" />
    ```

* **Android 앱에 이미지 추가**

  ```kotlin
      <ImageView
          android:layout_width="0dp"
          android:layout_height="0dp"
          app:layout_constraintStart_toStartOf="parent"
          app:layout_constraintEnd_toEndOf="parent"
          app:layout_constraintTop_toTopOf="parent"
          app:layout_constraintBottom_toBottomOf="parent"
          android:scaleType="centerCrop"
          android:src="pathOfImageSrc"/>
  ```



### Quiz

1. **Which of the following elements is considered a View in an Android app?**
   * image, clickable button, text, etc
2. **What is the main purpose of a ViewGroup?**
   * View 개체의 컨테이너 역할, 그 안의 View를 정렬하는 역할
3. **Fill-in-the-blanks**
   * The type of ViewGroup that helps you arrange the views inside of it in a flexible way is called a `ConstraintLayout`.
4. **Which of the following are Attributes in Android?**
   * text, textSize, textColor
5. **Fill-in-the-blanks**
   * In Android, a graphic that can be drawn to the screen is generally referred to as a `Drawable`.
6. **Which of the following is an example of a “constraint” that could be applied to a view in a ConstraintLayout ViewGroup in the Layout Editor?**
   * margin
   * constraint
   * topmost view
7. **What is the purpose of the activity_main.xml file in the project you created?**
   * 화면의 ViewGroup과 View에 대한 설명
8. **Why should you use string resources instead of hard-coded strings in your apps?**
   * 앱을 더 쉽게 번역할 수 있음
   * 동일한 문자열을 앱의 다른 곳에서 하드코딩 없이 재사용할 수 있음