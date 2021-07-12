# 2021 Landvibe Summer Coding - Android



## Unit1 : Kotlin basics

## PathWay3 : Build a basic layout



### Create a Birthday Card app

- Layout Editor를 사용하면 Android 앱 용 UI를 만들 수 있다.

- 앱 화면에 표시되는 대부분의 내용은 `View`이다.

- `TextView`는 앱에서 텍스트를 표시하는 UI 요소이다.

- `ConstraintLayout`은 다른 UI 요소의 컨테이너이다.

- `Views`는 `ConstraingLayout`내에서 가로와 세로로 제한되어야 한다.

- `View`를 배치하는 한 가지 방법은 여백을 사용하는 것이다.

- 여백을 통해 `View`가 컨테이너의 가장자리에서 떨어진 정도를 설정할 수 있다.

- `TextView`에 글꼴, 텍스트 크기, 색상과 같은 속성을 설정할 수 있다.

- fontFamily : sans-serif-light

- textSize : 36sp

- textColor : @android:color/black

- Constraint Widget : Top : 16, Left : 16

  <img src="E:\#Summer_Coding_2021\img\Unit1-Pathway3-1.png" alt="image-20210705170949131" style="zoom:67%;" />



### Add images to your Android app

* Layout Editor에서 Palette로 이동하여 `ImageView`를 앱으로 드래그한다.
* Constraints 섹션의 Constraint Widget 아래에서 layout_width와 layout_height를 0dp(match constraint)로 설정한다.
* 0dp는 `ImageView`의 너비에 match constraint를 사용하라고 Android 스튜디오에 알려주는 간단한 방법이다. 'match constraints'는 방금 추가한 제약조건으로 인해 `ConstraintLayout`에 여백을 뺀 만큼 넓어진다는 의미이다.
* scaleType을 centerCrop으로 설정한다. 그러면 이미지가 왜곡되지 않고 화면을 꽉 채운다.
* 이미지를 삽입하면 기존의 text가 보이지 않는데, 뷰 순서를 변경하면 된다.
* Component Tree에서 `ImageView`를 클릭하고 `ConstraintLayout` 바로 아래 `TextViews` 위로 드래그한다.  <span style="color:blue">제일 아래쪽에 깔리는게 `ConstraintLayout`에서 제일 위에 있어야 함.</span>

<img src="E:\#Summer_Coding_2021\img\Unit1-Pathway3-2.png" alt="image-20210705171300659" style="zoom:67%;" />

### Quiz

1. **Which of the following elements is considered a View in an Android app?**

   --> An image

   --> A clickable button

   --> Text on the screen

2. **What is the main purpose of a View Group?**

   --> It serves as a container for View objects, and is responsible for arranging the View objects within it.

   (View 개체의 컨테이너 역할을 하며, 이 컨테이너 내에서 View 개체를 정렬하는 역할을 합니다.)

3. **빈칸 채우기**

   **The type of ViewGroup that helps you arrange the views inside of it in a flexible way is called a ______.**

   --> ConstraintLayout

4. **Which of the following are Attributes in Android?**

   --> text

   --> textSize

   --> textColor

5. **빈칸 채우기**

   **In Android, a graphic that can be drawn to the screen is generally referred to as a ______.**

   --> Drawable

6. **Which of the following is an example of a "constraint " that could be applied to a view in a ConstraintLayout ViewGroup in the Layout Editor?**

   --> A view that must always be minimum distance away from the edge of its container.

   --> A view that must always be to the right of another view

   --> A view that must always be the topmost view inside a container.

7. **What is the purpose of the activity_main.xml file in the project you created?**

   --> It describes the layout of view groups and views for a screen.

8. **Why should you use string resources instead of hard-coded strings in your apps?**

   --> It makes your app easier to translate.

   --> It allows you to reuse the same string in multiple places in your program.

