### Unit 2: Layouts

#### PATHWAY 1:Get user input in an app: Part 1

<hr/>

##### 클래스 계층 구조 

- **클래스 계층 구조.** 클래스가 상위 요소와 하위 요소의 계층 구조로 구성된 배열입니다. 계층 구조 다이어그램은 일반적으로 상위 요소가 하위 요소 위에 표시된 상태로 그려집니다.
- **하위 클래스 또는 서브클래스.** 계층 구조에서 다른 클래스 아래에 있는 모든 클래스입니다.
- **상위 클래스 또는 슈퍼클래스 또는 기본 클래스.** 하위 클래스가 하나 이상 있는 모든 클래스입니다.
- **루트 또는 최상위 클래스.** 클래스 계층 구조의 최상위(또는 루트)에 있는 클래스입니다.
- **상속:** 하위 클래스가 상위 클래스의 모든 속성과 메서드를 포함하거나 상속받는 경우입니다. 이를 통해 코드를 공유하고 재사용할 수 있어 프로그램을 더 쉽게 파악하고 유지할 수 있습니다.  ```:상위클래스()``` 형식으로 상속. Kotlin에서 ```abstract```클래스나 ```open```키워드로 표시된 클래스에서만 상속 가능. 

##### 추상 클래스

완전히 구현되지 않아서 인스턴스화 할 수 없는 클래스. 변수의 경우 추상클래스의 모든 서브클래스가 값을 제공해야하고 함수의 경우 모든 서브클래스가 함수를 구현해야 함.



##### 공개 상태 수정자

- private : 오직 클래스 내에서
- protected : private와 비슷하나 서브클래스에서도 볼 수 있음.
- internal: 같은 모듈 내에서만 볼 수 있음
- public: 모든곳에서 볼 수 있음. 디폴트

##### 서브 클래스

서브 클래스는 상위 클래스의 변수, 함수를 완성해야함. override를 통해 이 속성이 상위 클래스에서 정의되었고 이 클래스에서 재정의될 거라고 나타냄.



##### with

```kotlin
with (instanceName) {
    // all operations to do with instanceName
}
```

```instanceName``` 객체로 다음 작업을 모두 실행하도록 하는 키워드.

```with```(instanceName){} 형식으로 사용.



##### Import

import kotlin.math.PI : PI사용을 위함

import kotlin.math.sqrt :sqrt()사용을 위함



##### XML

확장성 마크업 언어(Extensible Markup Language)를 의미하며 텍스트 기반 문서를 사용하여 데이터를 설명하는 방법. XML은 확장 가능하고 매우 유연하므로 다양한 용도로 사용됨.

```kotlin
<ConstraintLayout>
    <TextView
        text="Hello World!">
    </TextView>
</ConstraintLayout>
```

![9e3f433a224ba1f4.png](https://developer.android.com/codelabs/basic-android-kotlin-training-xml-layouts/img/9e3f433a224ba1f4.png)

##### XML 태그,요소,속성

```kotlin
xmlns:android="http://schemas.android.com/apk/res/android"
xmlns:app="http://schemas.android.com/apk/res-auto"
xmlns:tools="http://schemas.android.com/tools"
```

```xmlns``` 는 XML 네이스페이스를 나타내고 각 줄은 스키마나 이러한 단어와 관련된 속성의 어휘를 정의

예를들어 ```android:```네임 스페이스는 Android 시스템에서 정의한 속성을표시. 레이아웃 XML의 속성은 모두 이러한 네임스페이스 중 하나로 시작.



```kotlin
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:padding="16dp"
    tools:context=".MainActivity">

    <EditText
        android:id="@+id/cost_of_service"
        android:layout_width="160dp"
        android:layout_height="wrap_content"
        android:hint="@string/cost_of_service"
        android:inputType="numberDecimal"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <TextView
        android:id="@+id/service_question"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/how_was_the_service"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@id/cost_of_service" />

    <RadioGroup
        android:id="@+id/tip_options"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:checkedButton="@id/option_twenty_percent"
        android:orientation="vertical"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@id/service_question">

        <RadioButton
            android:id="@+id/option_twenty_percent"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="@string/amazing_service" />

        <RadioButton
            android:id="@+id/option_eighteen_percent"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="@string/good_service" />

        <RadioButton
            android:id="@+id/option_fifteen_percent"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="@string/ok_service" />
    </RadioGroup>

    <Switch
        android:id="@+id/round_up_switch"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:checked="true"
        android:text="@string/round_up_tip"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@id/tip_options" />

    <Button
        android:id="@+id/calculate_button"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:text="@string/calculate"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@id/round_up_switch" />

    <TextView
        android:id="@+id/tip_result"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/tip_amount"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintTop_toBottomOf="@id/calculate_button" />
</androidx.constraintlayout.widget.ConstraintLayout>
```

- XML(확장성 마크업 언어)은 텍스트를 구성하는 방법이며 태그, 요소, 속성으로 구성됨.
- XML을 사용하여 Android 앱의 레이아웃을 정의.
- `EditText`를 사용하여 사용자가 텍스트를 입력하거나 수정하도록 함.
- `EditText`에는 사용자에게 입력란에 예상되는 내용을 알려주는 힌트를 줄 수 있음.
- `android:inputType` 속성을 지정하여 사용자가 `EditText` 입력란에 입력할 수 있는 텍스트 유형을 제한할 수 있음.
- `RadioGroup`으로 그룹화된 `RadioButtons`를 사용하여 옵션 목록을 만들 수 있음.
- `Switch`를 사용하여 사용자가 두 옵션 간에 전환할 수 있도록 함.
- 별도의 `TextView`를 사용하지 않고 `Switch`에 라벨을 추가할 수 있음
- `ConstraintLayout`의 각 하위 요소에는 세로 및 가로 제약 조건이 있어야 함.
- 'start' 및 'end' 제약 조건을 사용하여 왼쪽에서 오른쪽(LTR) 및 오른쪽에서 왼쪽(RTL) 방향 언어를 모두 처리할 수 있음.
- 제약 조건 속성의 이름은 `layout_constraint<Source>_to<Target>Of` 형식을 따름.
- `View`의 너비를 포함되는 `ConstraintLayout`의 너비와 같게 하려면 시작과 끝을 상위 요소의 시작과 끝으로 제한하고 너비를 0dp로 설정함.

<hr/>

##### Quiz

1. Which of the following is true about class inheritance?

- Class inheritance lets you reuse code and makes your program easier to maintain.
- Properties and functions of the parent class(es) are available to the child class.
- You can define additional properties and functions that are specific to subclasses.
- You can override parent class members in subclasses.

2. Which of the following are true about abstract classes?

- They may have abstract properties or abstract functions.
- They may have abstract properties or abstract functions.
- They are not fully implemented and cannot be instantiated.

3. 빈 칸 채우기 단어를 하나 이상 입력하여 문장을 완성하세요.

- The is called when you create an instance of a class.

4. How do you mark a property to be used only inside its current class?

- Use the `private` keyword.

5. Select all answers that are true for this XML layout when displayed on the screen.

```kotlin
<androidx.constraintlayout.widget.ConstraintLayout
    android:layout_width="match_parent"
    android:layout_height="match_parent">
    <TextView
        android:id="@+id/textViewA"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="A"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
    <TextView
        android:id="@+id/textViewB"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="B"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
</androidx.constraintlayout.widget.ConstraintLayout>
```

- The starting edge of `TextView A` is aligned to the starting edge of the parent view.
- The tops of `TextView A` and `TextView B` are aligned to top of the parent view.
