# 💡 Android Basics in Kotlin

## Unit #1 : Kotlin basics

## PATHWAY #3 : Build a basic layout



<br/>



### 📌 사용자 인터페이스 정보

- `UI` : 사용자인터페이스. 화면에 표시되는 텍스트, 이미지, 버튼, 기타 여러 유형의 요소. 앱은 사용자에게 콘텐츠 표시, 사용자는 앱과 상호작용
- `View` : 앱 화면에 표시되는 대부분의 내용
- `Views` : 클릭 가능한 버튼이나 수정 가능한 입력란처럼 상호작용 가능. 단순히 화면에 자체적으로 플로팅되지 않는다. 서로 관계가 있다. Views를 구성하려면 **컨테이너**에 배치
- `ViewGroup` : View 객체가 있을 수 있는 컨테이너로, 내부에 있는 View를 정렬하는 역할
- **정렬 또는 레이아웃**은 앱이 실행되는 안드로이드 기기 화면의 크기와 가로세로 비율에 따라 변경될 수 있고, 레이아웃은 기기가 세로 모드인지 가로 모드인지에 따라 조정될 수 있다.
- `ConstraintLayout` : ViewGroup의 한 종류로, 내부 Views를 유연한 방식으로 정렬 가능
- `TextView` : View 유형 중 하나로 텍스트를 표시
- `ImageView` : View 유형 중 하나로 이미지를 표시



<br/>



### 📌 레이아웃 에디터 정보, 구성

- `Layout Editor` : 사용자 인터페이스 만드는 작업을 실행하는데 도움을 줌.

- `Project창` : 프로젝트를 구성하는 파일을 모두 나열
- `Design뷰` : 앱의 화면 레이아웃을 나타내는 2개의 그림 중 왼쪽 그림으로 **앱이 실행될 때 표시될 화면의 모습**과 가깝다
- `Blueprint뷰` : 앱의 화면 레이아웃을 나타내는 2개의 그림 중 오른쪽 그림
- `Palette` : 앱에 추가할 수 있는 **다양한 유형의 Views 목록**이 포함된다
- `Component Tree` : 화면 뷰의 다른 표현으로 **화면의 모든 뷰**가 나열된다.
- `Attributes` : **View의 속성**을 표시하고 변경할 수 있도록 한다.



<br/>



### 📌 생일카드 앱 만들기

##### 👉 1. Empty acivity 프로젝트 만들기

1. `empty activity` 템플릿 사용하여 새 코틀린 프로젝트 만들기 (최고 api수준으로 앱 호출 - minimum sdk)

   

<br/>



##### 👉 2. 메시지 변경

1. `activity_main.xml`을 더블클릭
2. `Component Tree` > `ConstraintLayout` > `TextView` 클릭
3. `Attributes` > `Declared Attributes` > `text` 의 'Hello World!'를 다른 문구로 수정



<br/>



##### 👉 3. 레이아웃에 TextView추가

1. TextView 삭제 : 디자인뷰에서 `TextView`를 클릭하고 `delete`

2. TextView 추가 : `Palette` > `TextView` 를 디자인 화면으로 드래그하여 드롭

3. TextView 배치 : `Attibutes` > `Layout` > `Constraint Widget` 에서 정사각형 주위의 `+` 를 눌러서 **여백** 추가. 앱 실행시 다른 위치로 이동하는 경고 문제를 TextView에 제약조건을 추가하여 해결 

   

<br/>



##### 👉 4. 텍스트에 스타일 추가

1. `Component Tree` >` TextView`클릭
2. `Attributes` > `Common Attributes`> `textAppearance` 클릭
3. `textSize`(글자 크기), `fontFamily`(글꼴), `textColor`(글자 색상) 변경
4. +) `shadowColor`, `shadowDx`, `shadowDy`, `ShadowRadius` (그림자설정)



<br/>



##### 👉 5. 이미지 추가 

###### 프로젝트에 이미지 추가

1. `Resource Manager` 탭 클릭
2. Resource Manager 아래의 `+ ` 클릭 후 `Import Drawables` 선택
3. 파일브라우저에서 이미지 파일 찾고 `Open` > `Next` > `Import`
4. Project 탭 전환 (import한 사진은 app > res > drawable에 있다.)

<br/>



###### ImageView 추가

1. `activity_main.xml` 클릭 (혹은 오른쪽 상단에서 `Design` 모드 버튼 클릭)
2. `Palatte` > `ImageView` 버튼 앱으로 드래그
3. `Pick a Resource` >` Drawable` 에서 이미지 찾고 `OK` 클릭
4. 화면에서 이미지 드래그하여 위치 조절
5. 원을 드래그하거나 Attributes창 이용하여 여백 설정해서 제약조건 추가
6. `Attributes` > `Constraints` > `Constraint Widget` > `layout_width`, `layout_height`를 0dp(match constraint)로 설정 (여백을 뺀 만큼 넓어진다는 의미)

7. `Attributes` > `scaleType`에서 `centerCrop` 설정 (이미지 왜곡 없이 화면 채움)
8. `Component Tree`에서 드래그로 뷰 순서 변경하여 이미지가 맨 뒤로 가도록 설정 



<br/>



##### 👉 +) 경고창 해결

* TextView : 경고창에서 Fix 버튼 누른 후 Extract Resource > Resouce name을 happy_birthday_text 혹은 signature_txt로 설정

*  ImageView : Attributes > importantForAccessibility에서 no설정



<br/>



### 📌 퀴즈

**1. Which of the following elements is considered a View in an Android app?**

- An image, A clickable button, Text on the screen. So, All of the above

**2. What is the main purpose of a ViewGroup?**

* It serves as a container for View objects, and is responsible for arranging the View objects within it.

**3. The type of ViewGroup that helps you arrange the views inside of it in a flexible way is called a [         ].**

- ConstraintLayout

**4. Which of the following are Attributes in Android?**

- text, textSize, textColor

**5. In Android, a graphic that can be drawn to the screen is generally referred to as a [         ]** 

- Drawable

**6. Which of the following is an example of a “constraint” that could be applied to a view in a ConstraintLayout ViewGroup in the Layout Editor?**

- A view that must always be a minimum distance away from the edge of its container

- A view that must always be to the right of another view

- A view that must always be the topmost view inside a container

**7. What is the purpose of the activity_main.xml file in the project you created?**

- It describes the layout of view groups and views for a screen.

**8. Why should you use string resources instead of hard-coded strings in your apps?**

- It makes your app easier to translate.

- It allows you to reuse the same string in multiple places in your program.