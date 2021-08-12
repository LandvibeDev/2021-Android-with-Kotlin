## 2021 Landvibe Summer Coding - Android

### 🔎 Android Basics In Kotlin

#### 📌 Unit1: Kotlin basics

#### 📌 PathWay3: Build a basic layout

<hr>

##### UI 정보

```UI(인터페이스)```  : 화면에 표시되는 텍스트, 이미지, 버튼, 기타 여러 유형의 요소

```View```  : 각 요소

```Views```  : 상호작용 가능

```TextView```  : 텍스트를 표시하는 ```View``` 유형

```ViewGroup```  : ```View```객체가 있을 수 있는 컨테이너, ```Views``` 정렬하는 역할

```ConstraintLayout```  : ```ViewGroup```의 한 종류, 내부 ```View``` 정렬 가능



##### Layout 폴더 찾는 방법

1. ```app``` 폴더 찾기
2. ```app``` 폴더 >  ```res``` 폴더 >  ```layout``` 
3. ```layout```에 존재하는 ```activity_main.xml```  찾기 완료 👍🏻



##### 텍스트 변경하기

1. 오른쪽 ```Attributes```에서 ```Declared Attributes``` 부분 찾기
2. ```text``` 부분을 수정하기



##### 텍스트 추가하기

1. 왼쪽 상단의 Palette에서 ```TextView``` 찾기
2. 화면으로 드래그하여 드롭하기

​	🚨 이때, ```ComponentTree```에 빨간색 오류가 발생하는 것 확인

​	🚨 ```TextView```에 제약조건을 추가해주어야 한다 (예를 들어, 여백)

​	🚨 여백: ```View```가 컨테이너의 가장자리에 떨어진 정도

	3. 오른쪽 ```Attributes```에서 ```Layout``` 섹션에 있는 ```ConstraintWidget``` 찾기
 	4. ```ConstraintWidget```에 존재하는 정사각형의 + 클릭하여 원하는 숫자 넣기



##### 요약

> `Layout Editor`를 사용하면 Android 앱용 UI를 만들 수 있습니다.
>
> 앱 화면에 표시되는 대부분의 내용은 `View`입니다.
>
> `TextView`는 앱에서 텍스트를 표시하는 UI 요소입니다.
>
> `ConstraintLayout`은 다른 UI 요소의 컨테이너입니다.
>
> `Views`는 `ConstraintLayout` 내에서 가로와 세로로 제한되어야 합니다.
>
> `View`를 배치하는 한 가지 방법은 여백을 사용하는 것입니다.
>
> 여백을 통해 `View`가 컨테이너의 가장자리에서 떨어진 정도를 설정할 수 있습니다.
>
> `TextView`에 글꼴, 텍스트 크기, 색상과 같은 속성을 설정할 수 있습니다.



<hr>

##### 프로젝트 이미지 추가

1. Android 스튜디오의 메뉴에서 **View > Tool Windows > Resource Manager**
2. **Resource Manager** 아래의 **+**를 클릭하고 **Import Drawables**를 선택
3. 파일 브라우저에서 다운로드한 이미지 파일을 찾아 **Open** 클릭
4. **Next**를 클릭합니다. Android 스튜디오에 이미지의 미리보기가 표시됨
5. **Import**를 클릭
6. 이미지를 성공적으로 가져오면 Android 스튜디오에서는 이미지를 **Drawable** 목록에 추가
7. 메뉴에서 **View > Tool Windows > Project**를 클릭
8. **app > res > drawable**을 펼쳐 이미지가 앱의 **drawable** 폴더에 있는지 확인
9. **Project** 창에서 **activity_main.xml**창으로 이동
10. **Layout Editor**에서 **Palette**로 이동하여 `ImageView`를 앱으로 드래그
11. **Pick a Resource** 대화상자의 **Drawable** 목록에서 케이크 이미지를 찾기
12. 이미치 클릭하고 **OK** 클릭



##### 이미지 꾸미기

크기 조절

> 1. `ImageView` 하단의 제약조건을 `ConstraintLayout` 하단에 추가
> 2. **Constraint Widget**에서 하단 **+**를 클릭하여 상하좌우 여백 0 만들기
> 3. **Constraint Widget** 아래에서 **layout_width**를 **0dp**로 설정
> 4. **layout_height**를 **0dp**로 설정
> 5. **Common Attributes**에서 **ScaleType**을 **centerCrop**으로 설정 (그림 전체화면 채우기)

우선순위 설정

>1. `ConstraintLayout`의 하단에 존재하는 목록 확인
>2. 맨 위부터 아래 순서로 우선순위가 높은 것 확인
>3. 원하는 것을 가장 위로 올리기



##### 요약

>Android 스튜디오의 **Resource Manager**를 사용하면 이미지와 기타 리소스를 추가하고 구성할 수 있습니다.
>
>`ImageView`는 앱에서 이미지를 표시하는 UI 요소입니다.
>
>`ImageViews`에는 앱의 접근성을 개선할 수 있는 콘텐츠 설명이 있어야 합니다.



##### 참고주소

Layout Editor: https://developer.android.com/studio/write/layout-editor



##### 퀴즈

1. Which of the following elements is considered a View in an Android app?

   > An image
   >
   > A clickable button
   >
   > Text on the screen

2. What is the main purpose of a ViewGroup?

   >It serves as a container for View objects, and is responsible for arranging the View objects within it.

3. The type of ViewGroup that helps you arrange the views inside of it in a flexible way is called a [].

   >constraintlayout

4. Which of the following are Attributes in Android?(복수선택)

   >text
   >
   >textSize
   >
   >textColor

5. In Android, a graphic that can be drawn to the screen is generally referred to as a [].

   >layout(오답)

6. Which of the following is an example of a “constraint” that could be applied to a view in a ConstraintLayout ViewGroup in the Layout Editor? (복수선택)

   > A view that must always be a minimum distance away from the edge of its container
   >
   > A view that must always include a contentDescription attribute(오답)

7. What is the purpose of the activity_main.xml file in the project you created?

   > It describes the layout of view groups and views for a screen.

8. Why should you use string resources instead of hard-coded strings in your apps? (복수선택)

   > It makes your app easier to translate.
   >
   > It allows you to reuse the same string in multiple places in your program.