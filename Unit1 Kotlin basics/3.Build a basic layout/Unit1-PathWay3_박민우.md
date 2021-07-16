# Unit 1 : Kotlin basics



## PATHWAY 3 : Build a basic layout



### UI

+  앱의 사용자 인터페이스(UI)는 화면에 표시되는 텍스트, 이미지, 버튼, 기타 여러 유형의 요소이다. UI를 통해 앱은 사용자에게 콘텐츠를 표시하고 사용자는 앱과 상호작용한다.
+ 이러한 각 요소를 `View`라고 한다. 앱 화면에 표시되는 대부분의 내용은 `View`이다. `Views`는 클릭 가능한 버튼이나 수정 가능한 입력란처럼 상호작용할 수 있다.
+ Android 앱의 `Views`는 단순히 화면에 자체적으로 플로팅되지 않는다. `Views`는 서로 관계가 있다. 예를 들어 이미지는 텍스트 옆에 있을 수 있고 버튼은 행을 형성할 수 있다. `Views`를 구성하려면 컨테이너에 배치한다. `ViewGroup`은 `View` 객체가 있을 수 있는 컨테이너로, 내부에 있는 `Views`를 정렬하는 역할을 한다. 정렬 또는 *레이아웃*은 앱이 실행되는 Android 기기 화면의 크기와 가로세로 비율에 따라 변경될 수 있고 레이아웃은 기기가 세로 모드인지 가로 모드인지에 따라 조정될 수 있다.



### Layout Editor

+  UI의 여백 및 기타 거리 단위는 *밀도 독립형 픽셀*(dp)입니다. 센티미터나 인치와 비슷하지만 화면상의 거리를 나타냅니다. Android에서는 이 값을 각 기기의 적절한 실제 픽셀 수로 변환합니다. 기준으로 1dp는 1인치의 약 160분의 1이지만 기기에 따라 더 크거나 작을 수 있습니다.
+ dp가 화면상의 거리 측정 단위인 것처럼 **sp**는 글꼴 크기 측정 단위입니다. Android 앱의 UI 요소는 두 가지 측정 단위를 사용합니다. 하나는 *밀도 독립형 픽셀*(**dp**)로, 이전에 레이아웃에서 사용했고 또 하나는 *확장 가능한 픽셀*(**sp**)로, 텍스트 크기를 설정할 때 사용합니다. 기본적으로 sp는 dp와 같은 크기이지만 사용자가 선호하는 텍스트 크기에 따라 크기가 조절됩니다.
+ 0dp는 `ImageView`의 너비에 *match constraint*를 사용하라고 Android 스튜디오에 알려주는 간단한 방법입니다. 'match constraints'는 방금 추가한 제약조건으로 인해 `ConstraintLayout`에 여백을 뺀 만큼 넓어진다는 의미입니다.
+ **scaleType**을 **centerCrop**으로 설정합니다. 그러면 이미지가 왜곡되지 않고 화면을 채웁니다.



### Good coding practices

+ *하드코딩* 문자열은 앱 코드에 직접 작성된 문자열입니다. 하드코딩 문자열로 인해 앱을 다른 언어로 번역하기가 더 어렵고 앱의 다른 위치에서 문자열을 재사용하기가 더 힘듭니다. 이러한 문제는 '리소스 파일로 문자열을 추출'하여 해결할 수 있습니다. 즉, 코드에서 문자열을 하드코딩하는 대신 문자열을 파일에 넣고 이름을 지정한 후 문자열을 사용할 때마다 이름을 사용합니다. 이름은 문자열을 변경하거나 다른 언어로 번역하더라도 동일하게 유지됩니다.





### Quiz/Unit1/Pathway3

1. Which of the following elements is considered a View in an Android app?

   => 

   + An image
   + A clickable button
   + Text on the screen

   

2.  What is the main purpose of a ViewGroup?

   => It serves as a container for View objects, and is responsible for arranging the View objects within it.



3. The type of ViewGroup that helps you arrange the views inside of it in a flexible way is called a 
   **ConstraintLayout**



4. Which of the following are Attributes in Android?

   => text, textSize, textColor



5. In Android, a graphic that can be drawn to the screen is generally referred to as a **drawble**



6. Which of the following is an example of a “constraint” that could be applied to a view in a ConstraintLayout ViewGroup in the Layout Editor?

   => 

   +  A view that must always be a minimum distance away from the edge of its container
   +  A view that must always be to the right of another view
   + A view that must always be the topmost view inside a container



7. What is the purpose of the activity_main.xml file in the project you created?

   => It describes the layout of view groups and views for a screen.



8. Why should you use string resources instead of hard-coded strings in your apps?

   => 

   + It makes your app easier to translate.
   + It allows you to reuse the same string in multiple places in your program.