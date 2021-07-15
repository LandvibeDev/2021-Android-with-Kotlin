### Unit 1: Kotlin basics

#### PATHWAY 3:Build a basic layout

<hr/>

##### 인터페이스(UI)

- 화면에 표시되는 텍스트, 이미지, 버튼, 기타 여러 유형의 요소.
- UI를 통해 앱은 사용자에게 콘텐츠를 표시하고 사용자는 앱과 상호작용
- 이러한 각각의 요소를 ```View``` 라고한다.



##### Layout Editor

- Design 뷰 : 앱이 실행될 때 표시될 화면의 모습

- Blueprint 뷰 :특정 작업에 유용

- Palette : 앱에 추가할 수 있는 다양한 유형의 ```Views``` 목록이 포함되어있음.

- Component Tree : 화면 뷰의 다른표현 화면의 모든 뷰가 나열됨.

- Attributes: View의 속성을 표시하고 변경할 수 있도록 함.

- TextView- : 앱에서 텍스트를 표시하는 UI요소.

- ConstraintLayout : 다른 UI요소의 컨테이너. (View는 이 내에서 가로와 세로로 제한되어야함)

- Resource Manager를 사용하면 이미지와 기타 리소스를 추가하고 구성할 수 있음.

- ImagView는 앱에서 이미지를 표시하는 UI요소

  ##### 앱을 작성할 때는 다른 언어로 번역될  수 있음을 기억

  하드코딩 문자열은 앱 코드에 직접 작성된 문자열. 

  하드코딩 문자열로 인해 앱을 다른 언어로 번역하기 더 어렵고 앱의 다른 위치에서 문자열을 재사용하기 힘들다. 이 문제는 리소스 파일로 문자열을 추출하여 해결.

  즉 코드에서 문자열을 하드코딩하는 대신 문자열을 파일에 넣고 이름을 지정한 후 문자열을 사용할 때마다 이름을 사용.

<hr/>

#### Quiz

1.Which of the following elements is considered a View in an Android app?

- An image
- A clickable button
- Text on the screen

2.What is the main purpose of a ViewGroup?

- It serves as a container for View objects, and is responsible for arranging the View objects within it.

3. The type of ViewGroup that helps you arrange the views inside of it in a flexible way is called a ConstraintLayout 
4. Which of the following are Attributes in Android?

- text
- textSize
- textColor

5.  In Android, a graphic that can be drawn to the screen is generally referred to as a  Drawable
6. Which of the following is an example of a “constraint” that could be applied to a view in a ConstraintLayout ViewGroup in the Layout Editor?

- A view that must always be a minimum distance away from the edge of its container
- A view that must always be to the right of another view
- A view that must always be the topmost view inside a container

7.What is the purpose of the activity_main.xml file in the project you created?

- It describes the layout of view groups and views for a screen.

8.Why should you use string resources instead of hard-coded strings in your apps?

- It makes your app easier to translate.
- It allows you to reuse the same string in multiple places in your program.



