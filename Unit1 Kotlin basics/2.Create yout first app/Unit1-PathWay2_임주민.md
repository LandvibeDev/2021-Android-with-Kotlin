# 💡 Android Basics in Kotlin

## Unit #1 : Kotlin basics

## PATHWAY #1 : Create your first app



#### 📌 [안드로이드 스튜디오 설치하기](https://developer.android.com/studio/)

- m1은 인텔 CPU가 아니라서 에뮬레이터 설치 관련해서 오류발생

  > Unable to install Intel® HAXM
  >
  > Your CPU does not support VT-x.
  >
  > Unfortunately, your computer does not support hardware accelerated virtualization.
  >
  > Here are some of your options:
  >
  >  1) Use a physical device for testing
  >
  >  2) Develop on a Windows/OSX computer with an Intel processor that supports VT-x and NX
  >
  >  3) Develop on a Linux computer that supports VT-x or SVM
  >
  >  4) Use an Android Virtual Device based on an ARM system image
  >
  >   (This is 10x slower than hardware accelerated virtualization)

- 해결

  👉 [설치사이트](https://github.com/google/android-emulator-m1-preview)

  👉 [참고1](https://dev-repository.tistory.com/97)

  👉 [참고2](https://www.fmkorea.com/3547034326 )



#### 📌 안드로이드 스튜디오 실행하기

* 새 프로젝트 만들기 

  1. 안드로이드 스튜디오 시작 
  2. `Start a new android Studio project` 를 클릭 
  3. 프로젝트의 이름을 저장
  4. 템플릿을 선택한 후 세부정보 입력

* 앱을 실행할 에뮬레이터 생성

  1. `Tools` > `AVD Manager` 선택
  2. `AVD Manager` 를 사용하여 하드웨어 기기 및 시스템 이미지 선택

* 가상 기기에서 앱 실행

  1. 기기 만들었는지 확인
  2. 툴바 드롭다운 메뉴에서 기기 선택 후 툴바에서 `Run` 아이콘 클릭

* 프로젝트 파일 찾기

  1. `Project` 창의 드롭다운에서 `Project Source Files` 를 선택

  

#### 📌 퀴즈

1. What does IDE stand for?

   > 통합 개발 환경(Integrated Development Environment, **IDE**)

2. Which of the following are advantages of using android studio?

   > It can help prevent typos and other mistakes in your code.

   > It comes with a virtual device called an emulator that can run your app.

   > It can show you a real-time preview of how your app will look on-screen while you code

3. what does "Minimum SDK" refer to in an Android Studio project?

   > The minimum version of Android that your app can run on

4. What is the purpose of using a virtual device, or emulator, in Android Studio?

   > To test your app on a device without having that physical device

5. In Android Studio, what is a project template good for?

   > It makes getting started on building a new app faster.

   > It provides a structure that follows best practices.

   > It makes building a new app less error-prone by pre-populating the project with some app code.

6. How do you create a new project in Android Studio?

   > If you have a project already open, select File > New > New Project from the Android Studio menu.

   > In the “Welcome to Android Studio” window, click “Start a new Android Studio project.”
