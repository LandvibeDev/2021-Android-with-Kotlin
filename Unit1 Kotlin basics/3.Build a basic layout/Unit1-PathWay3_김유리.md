# 2021 Landvibe Summer Coding - Android

## Unit1 - Kotlin Basics

## PathWay3 - Build a basic layout

### 생일 카드 앱 만들기

##### 📌사용자 인터페이스(UI) 정보

- 앱의 UI는 화면에 표시되는 텍스트, 이미지, 버튼, 기타 여러 유형의 요소이다. 이러한 각 요소를 `View`라고 한다.

- 앱 화면에 표시되는 대부분의 내용이 `View`

- `Views`는 클릭 가능한 버튼이나 수정가능한 입력란처럼 상호작용할 수 있다.

- `ViewGroup`은 `View`객체가 있을 수 있는 컨테이너로, 내부에 있는 `Views`를 정렬하는 역할을 한다. 

  

##### 📌Layout Editor 정보

- `Layout Editor`의 구성
  1. `Project`창으로 프로젝트를 구성하는 파일을 모두 나열한다.
  2. `Palette`에는 앱에 추가할 수 있는 다양한 유형의 `Views`목록이 포함된다.
  3. `Component Tree`은 화면의 모든 뷰가 나열된다.
  4. `Design`뷰는 앱이 실행될 때 표시될 화면의 모습과 가깝다.
  5. `Blueprint`뷰는 특정 작업에 유용할 수 있다.
  6. `Attributes`은 `View`의 속성을 표시하고 변경할 수 있도록 한다.

![ba8fee53dbc7dba4](C:\Users\a9681\OneDrive\바탕 화면\ba8fee53dbc7dba4.png)



##### 📌Hello World 메시지 변경

1. `Project`창에서 `app > res > layout`폴더를 펼치고 `activity_main.xml`선택

2. `Component Tree`에서 `TextView`선택

3. `Attributes`에서 `Declared Attributes`의 `text`속성값 변경

   

##### 📌앱 실행 오류 

- 현재 연결은 사용자의 호스트 시스템의 소프트웨어에 의해 중단되었습니다 

  👉핫스팟 실행 여부 확인 - 핫스팟 실행시 로컬 루프백(127.0.0.1)을 사용할 수 없게 되기 때문



##### 📌레이아웃에 TextView 추가

- 현재 TextView 삭제
  1. `Layout Editor`에서 중앙에 있는 `TextView`클릭
  2. `Delete`키를 눌러 삭제
- TextView 추가
  1. `Palette`에서 `TextView`를 찾아 `Layout Editor`에 드래그하여 드롭
- TextView의 배치
  1. `Attributes`의 `Layout`섹션에 있는 `Constraint Widget`찾기
  2. 정사각형의 **+**를 클릭해 여백값(dp : 밀도 독립형 픽셀) 설정



##### 📌텍스트에 스타일 추가

1. `Component Tree`에서 `TextView`를 클릭하고 `Common Attributes`섹션 찾기
2. `textApperance`에서 `textSize`(sp : 확장 가능한 픽셀), `fontFamily`, `textColor`설정



### Android 앱에 이미지 추가

##### 📌프로젝트에 이미지 추가

1. `Resource Manager`탭 클릭 후 아래 `+`에서 `Import Drawbles`선택
2. 이미지를 찾아 `Open`, `Next`후 `Import`
3. `Project`탭에서 `app > res > drawable`을 펼쳐 이미지가 있는지 확인



#####  📌ImageView 추가

- ImageView 추가 및 이미지 설정
  1. `activity_main.xml)`열기
  2. `Layout Editor`에서 `Palette`로 이동하여 `ImageView`를 앱으로 드래기 
  3. `Pick a Resource(앱에서 사용 가능한 이미지 리소스가 나열됨)` 대화상자에서 이미지 클릭후 `OK
- ImageView 배치 및 크기 조절
  1. `Layout Editor`에서 `ImageView`를 클릭하고 드래그, 드래그 시 뜨는 분홍색 직사각형은 `ImageView`를 배치하기 위한 화면 경계를 나타냄
- 제약조건 추가 - 중앙 정렬
  1. `ImageView` 윤곽선의 상단에 있는 원 위로 포인터를 가져가면 다른 원과 함께 강조 표시됨
  2. 원을 상단에 맞춰질 때까지 드래그 후 하단에 있는 원도 하단에 맞춰질때까지 드래그(`Constraint Widget`의 위 아래 여백이 0인지 확인)
- 제약조건 추가 - 전체 화면 채우기
  1. `Constraint Widget`아래에서 `layout_width`를 **0dp(match constraint)**로 설정, 'match constraints'는 방금 추가한 제약조건으로 인해 `ConstraintLayout`에 여백을 뺀 만큼 넓어진다는 의미
  2. `layout_height`도 **0dp**로 설정
  3. `scaleType`속성을 `centerCrop`으로 설정
- ImageView를 텍스트 뒤로 이동
  1. `Component Tree`에서 `ImageView`를 `TextViews`위로 드래그



##### 📌적절한 코딩 사례 채택

- 경고 문제 

  - *하드코딩* 문자열은 앱 코드에 직접 작성된 문자열이다. 하드코딩 문자열로 인해 앱을 다른 언어로 변역하기 어렵고 앱의 다른 위치에서 문자열 재사용이 어렵다. 

    👉 '리소스 파일로 문자열을 추출'하여 해결

    1. 첫번째 `TextView`옆에 있는 주황색 삼각형 클릭 후 `Fix`클릭
    2. `Resource name`은 문자열이 앞으로 호출될 이름이고 `Resource value`는 실제 문자열 자체, `Resource name`은 소문자 이름이 있어야하고 여러 단어는 밑줄로 구분
    3. `Resource name`설정 후 `OK`클릭
    4. `Attribute`에서 `text`속성 변경된 값 확인
    5. `strings.xml`변경된 값 확인

  - 이미지의 누락된 `contentDescription`속성에 경고

    👉`importantForAccessibility`속성을 `no`로 설정

    1. `Component Tree`에서 `ImageView`선택
    2. `All Attribute`섹션에서 `importantForAccessibility`를 찾아 `no`로 설정



#### 📌Quiz

1. Which of the following elements is considered a View in an Android app?
   - An image
   - A clickable button
   - Text on the screen
2. What is the main purpose of a ViewGroup?
   - It serves as a container for View objects, and is responsible for arranging the View objects within it.
3. The type of ViewGroup that helps you arrange the views inside of it in a flexible way is called a **ConstraintLayout**.
4. Which of the following are Attributes in Android?
   - text
   - textSize
   - textColor
5. In Android, a graphic that can be drawn to the screen is generally referred to as a **Drawable**.
6. Which of the following is an example of a “constraint” that could be applied to a view in a ConstraintLayout ViewGroup in the Layout Editor?
   - A view that must always be a minimum distance away from the edge of its container
   - A view that must always be the topmost view inside a container
7. What is the purpose of the activity_main.xml file in the project you created?
   - It describes the layout of view groups and views for a screen.
8. Why should you use string resources instead of hard-coded strings in your apps?
   - It makes your app easier to translate.
   - It allows you to reuse the same string in multiple places in your program.

