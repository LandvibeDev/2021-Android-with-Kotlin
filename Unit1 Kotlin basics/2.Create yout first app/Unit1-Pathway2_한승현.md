# Unit1-Pathway2



- **Android Studio**
  - IDE (통합 개발 환경)
    - 도구가 가득 찬 작업장과 같은 개념
    - 코드를 작성하고 앱이 화면에 어떻게 표시될 지 볼 수 있음
    - 오류를 확인할 수 있으며, 더 나은 코딩을 지원함
    - 구동되는 모습을 실제 기기나 에뮬레이터를 통해 확인할 수 있음
    - <u>IDE를 사용함으로서 개발 과정을 더 쉽게 할 수 있음</u>
- **Android Studio 설치**
  - 사양 : https://developer.android.com/studio#Requirements
  - 설치 : https://developer.android.com/studio
- **첫 번째 Android 앱 만들기 및 실행**
  - Project Template
    - 필요한 모든 부분을 가지고 있지만 실행하는 작업은 많지 않은 Android App
    - 템플릿을 사용하면 개발자가 더 빠르게 시작하고 일부 작업을 줄일 수 있음
    - 지도가 있는 앱, 여러 화면을 사용하는 앱 등 여러 템플릿이 제공됨
  - Empty Activity 프로젝트 만들기
    - Start a new Android Studio project 선택
    - 기기 선택(Phone and Tablet)
    - 여러 템플릿 중 `Empty Activity` 선택
      - Name: 앱의 이름
      - Package name: Android 시스템에서 앱을 고유하게 식별하기 위해 사용하는 이름으로, 일반적으로 조직의 이름 뒤에 앱 이름이 나오는 기본 이름으로 지정되며 모두 소문자(ex: org.sopt.android)
      - Save location: 프로젝트와 관련된 모든 파일이 저장되는 위치
      - Language: 프로젝트에서 사용할 프로그래밍 언어, Kotlin인지 확인
      - Minimum SDK: 앱을 실행할 수 있는 Android의 최소 버전, API 뒤에 오는 숫자가 낮을수록 오래된 버전이며 높을수록 최신 버전이고, 나의 Android 공기계에서 실행하기 위해서는 MinSDK가 24 이하여야 함
    - Use legacy android.support library가 선택 해제되어 있는지 확인
      - 신규 API에서 추가된 기능을 사용하게 되면, 이전에 설치된 안드로이드 기기에서는 해당 API를 사용할 수 없음
      - 이럴 때 android.support libraries 기능을 사용하면 모두 정상동작 가능하도록 지원함
    - Android Studio 하단에 `Gradle sync finished in 00s 000ms` 메시지가 표시될 때까지 대기
  - 가상 기기(에뮬레이터) 에서 앱 실행
    - `AVD` : Android Virtual Device, 가상 기기라는 의미로 에뮬레이터를 의미함
      - `Tools` > `AVD Manager` 에서 `Create Virtual Device` 클릭
      - 기존에 정의된 크기와 해상도, 밀도의 기기를 선택할 수도 있고, 필요 시 Custom할 수 있음
      - `System Image` 창에서는 가상 기기에서 실행할 Android 시스템 버전을 선택
      - `AVD Name` 입력란에 AVD 이름을 입력
      - Finish
    - 실행하고자 하는 AVD를 선택하고, `Run` > `Run app` 을 선택하여 실행
  - 프로젝트 파일 찾기
    * Android Studio의 프로젝트 폴더 계층 구조에는 대표적으로 두 가지 뷰가 있음
      * `Project`
      * `Android`
  - 휴대기기에서 앱 실행
    - 휴대기기 설정
      - `설정` > `개발자 옵션` > `USB 디버깅` 사용 설정
    - Mac 설정
      - USB 케이블 이용하여 기기 연결
      - 실제 기기가 자동으로 선택됨



### Quiz

1. **What does IDE stand for?**
   * IDE : 통합 개발 환경(Integrated Development Environment)
2. **Which of the following are advantages of using Android Studio?**
   * 오타 및 실수를 방지
   * 에뮬레이터 제공
   * 코딩하는 중에 앱이 어떻게 화면에 표시되는지 실시간으로 미리 볼 수 있음(xml)
3. **What does “Minimum SDK” refer to in an Android Studio project?**
   * 앱이 실행할 수 있는 Android 최소 버전
4. **What is the purpose of using a virtual device, or emulator, in Android Studio?**
   * 실기기 없이 앱을 테스트하기 위함
5. **In Android Studio, what is a project template good for?**
   * 새로운 앱 구현을 더 빠르게 시작할 수 있음
   * 모범 사례에 해당하는 구조를 제공
   * 프로젝트를 일부 제공되는 앱 코드로 채워서 새 앱을 빌드할 때 오류가 덜 발생하도록 함
6. **How do you create a new project in Android Studio?**
   * 이미 프로젝트를 열어둔 상태라면, `File` > `New` > `New project from the Android Studio`
   * `Welcome to Android Studio` 화면이라면, `Start a new Android Studio project`

