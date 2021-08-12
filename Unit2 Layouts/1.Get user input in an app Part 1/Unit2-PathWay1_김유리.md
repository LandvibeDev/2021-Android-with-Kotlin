---

---

# 2021 Landvibe Summer Coding - Android

## Unit2 - Layouts

## PathWay1 - Get user input in an app : Part1

### Kotlin의 클래스 및 상속

##### 📌클래스 계층 구조

- **클래스 계층 구조** : 클래스가 상위 요소와 하위 요소의 계층 구조로 구성된 배열
- **하위 클래스 or 서브 클래스** : 계층 구조에서 다른 클래스 아래에 있는 모든 클래스
- **상위 클래스 or 슈퍼 클래스 or 기본 클래스** : 하위 클래스가 하나 이상 있는 모든 클래스
- **루트 or 최상위 클래스** : 클래스 계층 구조의 최상위에 있는 클래스
- **상속** : 하위 클래스가 상위 클래스의 모든 속성와 메서드를 포함하거나 상속받는 경우, 이를 통해 코드 공유 및 재사용 가능



##### 📌기본 클래스 만들기

- 주택의 클래스 계층구조![ceeee5c347df33dd.png](https://developer.android.com/codelabs/basic-android-kotlin-training-classes-and-inheritance/img/ceeee5c347df33dd.png) 

  - `Dwelling` : 모든 주택에 공통된 정보를 담고 있는 기본 클래스
  - `SquareCabin` : 바닥 면적이 정사각형인 통나무집
  - `RoundHut` : 바닥 면적이 원형인 짚으로 만든 둥근 오두막이고 `RoundTower`의 상위 요소 
  - `RoundTower` : 바닥 면적이 원형이고 층이 여러 개인 돌로 만든 둥근 타워

- 추상 주택 클래스 만들기

  - **추상 클래스**는 완전히 구현되지 않아서 인스턴스화할 수 없는 클래스이다. - 선언은 `abstract`키워드로 시작

    ```kotlin
    abstract class Dwelling() { 
    }
    ```

  - 건축 자재 속성 추가

    1. `Dwelling`내에 건축 자재를 나타내는 `String`유형의 `buildingMaterial`변수 생성
    2. 건물이 구체적이지 않아 구체적인 자재로 만들 수 없으므로 `buildingMaterial`변수에 `abstract`키워드 추가

  - 수용 인원 속성 추가

    1. `Dwelling`내에 `capacity`라는 `abstract`정수 변수 생성

  - 거주자 수에 관한 비공개 속성 추가

    1. `residents`를 `Dwelling`클래스의 생성자에 `private` 매개변수로 전달
    2. 주택의 또 다른 거주자를 위한 공간이 있는지 확인하는 `hasRoom()`함수 생성
    3. `residents`와 `capacity`값을 비교해 `true`나 `false`반환

  ```kotlin
  abstract class Dwelling( private var residents: Int){
  	abstract val buildingMaterial: String
  	abstract val capacity: Int
  	
  	fun hasRoom(): Boolean { 
  		return residents < capacity
  	}
  }
  ```



##### 📌서브 클래스 만들기

- SquareCabin 서브 클래스 만들기

  1. `Dwelling`클래스 아래에서 `SquareCabin`이라는 클래스 생성

  2. `SquareCabin`이 `Dwelling`에서 확장된다고( `Dwelling`의 서브 클래스라고) 나타내기 위해 `SquareCabin`클래스 이름 다음에 콜론을 추가하고 상위 클래스를 초기화하는 호출을 추가

  3. 슈퍼 클래스에서 확장할 때 슈퍼 클래스에서 예상하는 필수 매개변수 전달

  4. 가변적인 `SquareCabin` 거주자 수를 허용하기 위해 `residents`를 `SquareCabin`클래스 정의의 매개변수로 만듦

  5. `SquareCabin`클래스 내에서 `builingMaterial`속성을 `override`하고 `"Wood"`값 할당

  6. `capacity`에 6 할당

     ```kotlin
     abstract class Dwelling(private var residents : Int) {
     	abstract val buildingMaterial: String
     	abstract val capacity: Int
     	
     	fun hasRoom(): Boolean { 
     		return residents < capacity
     	}
     }
     
     class SquareCabin(residents: Int) : Dwelling(residents) {
     	override val buildingMaterial = "Wood" 
     	override val capacity = 6
     }
     ```

- SquareCabin 사용

  1. `Dwelling`및 `SquareCabin`클래스 정의 앞에 빈 `main()`함수 삽입

  2. `main()`함수 내에서 거주민이 6명인 `suqareCabin`이라는 `SquareCabin`인스턴스 생성

  3. 건축 자재, 수용인원, `hasRoom()`함수에 관한 print문 추가 - `hasRoom()`함수는 `Dwelling`에 정의되어 있지만 `SquareCabin`이 `Dwelling`에 상속되어 있어 `squareCabin.hasRoom()`으로 사용 가능

  4. `with`문을 사용해 '이 인스턴스 객체로 다음 작업을 모두 실행'하라고 나타내기 - `with`키워드로 시작하고 괄호로 묶인 인스턴스 이름, 실행하려는 작업이 포함된 중괄호

     ```kotlin
     fun main() {
     	val squareCabin = SquareCabin(6)
     	
     	with(squareCabin) {
     		println("\nSquare Cabin\n==========")
     		println("Capacity: &{capacity}")
     		println("Matrial: &{buldingMaterial}")
     		println("Has room? &{hasRoom()}")
     	}
     }
     ```

- RoundHut 서브 클래스 만들기

  1. `RoundHut`을 `Dwelling`에 추가
  2. `buildingMaterial`을 `"Straw"`로 설정, `capacity`를 4로 설정
  3. `main()`에서 거주민이 3인 `RoundHut`인스턴스 생성
  4. `with`문 사용해 `roundHut`에 관한 정보 출력

- RoundTower 서브 클래스 만들기

  1. `RoundHut`의 서브 클래스인 `RoundTower`클래스 생성 - `residents`매개변수를 `RoundTower`생성자에 추가하고 이 매개변수를 `RoundHut`슈퍼클래스 생성자에 전달
  2. `buildingMaterial`을 `"Stone"`으로 재정의, `capacity`를 4로 재정의
  3. 기본적으로 클래스는 최종클래스이며 서브클래스로 분류할 수 없음,`abstract`나 `open`으로 표시된 클래스에서만 상속할 수 있으므로 `RoundHut`에 `open`키워드 추가
  4. `main()`에 `roundTower`인스턴스를 만들고 관련 정보 출력

- RoundTower에 여러 층 추가

  1. `RoundTower` 생성자에 `floors`변수 추가, 이 변수를 상위 생성자에 전달하지 않아도 됨

  2. `floors`에 기본 값 2 할당

  3. `RoundTower`클래스에서 층수를 곱하도록 `capacity`재정의

     ```kotlin
     class RoundTower( residents: Int, val floors: Int = 2) : RoundHut(residents) {
     	override val buildingMaterial = "Stone"
     	override val capacity = 4 * floors
     }
     ```



##### 📌계층 구조의 클래스 수정

- 바닥 면적 계산

  - Dwelling클래스에서 floorArea()정의 

    1. `abstract``floorArea()`함수를 `Dwelling` 클래스에 추가하고 `Double`형으로 반환
    2. 추상 클래스에서 정의된 모든 추상 메서드는 서브클래스에서 구현되어야 함

  - SquareCabin의 floorArea() 구현

    1. `SquareCabin`클래스에서 `floorArea()``override`로 구현
    2. 계산된 바닥 면적 반환
    3. `SquareCabin`의 클래스 정의를 변경하여 `Double`유형의 속성이 `val`인 `length`매개변수 추가
    4. `main()`에서 `squareCabin`인스턴스에 `length`값을 전달
    5. `squareCabin`의 `with`문에 바닥면적 출력문 추가

  - RoundHut의 floorArea()구현

    1. 원형 주택 바닥 면적을 구하기 위해 수학 라이브러리에서 `PI`를 가져옴

       ```kotlin
       import kotlin.math.PI
       ```

    2. `RoundHut`의 `floorArea()`함수 구현

       ```kotlin
       override fun floorArea(): Double { 
       	return PI * radius * radius
       }
       ```

    3. `RoundHut`생성자를 업데이트하여 `radius`전달

       ```kotlin
       open class RoundHut(val residents: Int, val radius: Double ) : Dwelling(residents) {
       }
       ```

    4. `main()`에서 `radius``10.0`을 `RoudnHut` 생성자에 전달

    5. `roundHut`의 `with`문 내에 출력문 추가

  - RoundTower의 floorArea() 구현

    1. `RoundTower`의 상위 `RoundHut`과 `radius`인수도 같도록 `RoundTower`생성자 변경

       ```kotlin
       class RoundTower( residents: Int, radius: Double, val floors: Int = 2) : RoundHut(residents, radius) {
       }
       ```

    2. `main()`에서 `roundTower`의 초기화를 업데이트

    3. `floorArea()`호출하는 출력문 추가

    4. `RoundHut`에 상속되고 `floors`수를 고려하지 않아 계산 틀림 - `RoundTower`에서 `override floorArea()`하여 식 수정

       ```kotlin
       override fun floorArea(): Double { 
       	return PI * radius* radius* floors
       }
       ```

    5. `RoundTower`에서 `floorArea()`의 슈퍼클래스 구현을 사용하도록 `floorArea()`업데이트 - `super`키워드 사용해 상위 클래스 함수 호출

       ```kotlin
       override fun floorArea(): Double{ 
       	return super.floorArea() * floors
       }
       ```

  - 새 거주자가 방을 갖도록 허용

    1. `Dwelling`에 거주자 수를 1씩 늘리는 `getRoom()`함수를 사용해 새 거주자가 방을 갖도록 하는 기능 추가 
    2. 수용 인원이 남은 경우에만 거주자 추가하는 `if`문 사용
    3. 결과 메시지 출력
    4. `residents++`(`residents= residents+1`)을 사용해 변수에 1을 추가
    5. `roundHut`의 `with`문에 출력문 추가

  - 둥근 주택에 카펫 맞추기

    1. `kotlin.math`라이브러리에서 `sqrt()`함수 가져오기

    2. `RoundHut`클래스에서 `calculateMaxCarpetSize()`함수 구현

       ```kotlin
       fun calculateMaxCarpetSize(): Double { 
       	val diameter = 2 * radius
       	return sqrt(diameter * diameter /2 ) 
       }
       ```

    3. `main()`함수의 `roundHut`과 `roundTower`에 출력문 추가



##### 📌최종 코드

```kotlin
import kotlin.math.PI
import kotlin.math.sqrt

fun main() {
   val squareCabin = SquareCabin(6, 50.0)
   val roundHut = RoundHut(3, 10.0)
   val roundTower = RoundTower(4, 15.5)

   with(squareCabin) {
       println("\nSquare Cabin\n============")
       println("Capacity: ${capacity}")
       println("Material: ${buildingMaterial}")
       println("Floor area: ${floorArea()}")
   }

   with(roundHut) {
       println("\nRound Hut\n=========")
       println("Material: ${buildingMaterial}")
       println("Capacity: ${capacity}")
       println("Floor area: ${floorArea()}")
       println("Has room? ${hasRoom()}")
       getRoom()
       println("Has room? ${hasRoom()}")
       getRoom()
       println("Carpet size: ${calculateMaxCarpetSize()}")
   }

   with(roundTower) {
       println("\nRound Tower\n==========")
       println("Material: ${buildingMaterial}")
       println("Capacity: ${capacity}")
       println("Floor area: ${floorArea()}")
       println("Carpet size: ${calculateMaxCarpetSize()}")
   }
}

abstract class Dwelling(private var residents: Int) {
   abstract val buildingMaterial: String
   abstract val capacity: Int

   abstract fun floorArea(): Double

   fun hasRoom(): Boolean {
       return residents < capacity
   }

   fun getRoom() {
       if (capacity > residents) {
           residents++
           println("You got a room!")
       } else {
           println("Sorry, at capacity and no rooms left.")
       }
   }

   }


class SquareCabin(residents: Int, val length: Double) : Dwelling(residents) {
   override val buildingMaterial = "Wood"
   override val capacity = 6


   override fun floorArea(): Double {
       return length * length
   }

}

open class RoundHut(
       val residents: Int, val radius: Double) : Dwelling(residents) {

   override val buildingMaterial = "Straw"
   override val capacity = 4

   override fun floorArea(): Double {
       return PI * radius * radius
   }

   fun calculateMaxCarpetSize(): Double {
       val diameter = 2 * radius
       return sqrt(diameter * diameter / 2)
   }

}

class RoundTower(
       residents: Int,
       radius: Double,
       val floors: Int = 2) : RoundHut(residents, radius) {

   override val buildingMaterial = "Stone"

   override val capacity = floors * 4

   override fun floorArea(): Double {
       return super.floorArea() * floors
   }
}
```



##### 📌요약

- 일부 기능을 서브클래스에서 구현하도록 남기는 `abstract`클래스
- `abstract`클래스는 인스턴스화할 수 없음
- `override` 키워드를 사용해 서브 클래스의 속성과 함수 재정의
- `super`키워드를 사용해 상위 클래스의 함수와 속성 참조
- 서브클래스로 분류할 수 있도록 클래스를 `open`으로 정의
- 속성을 `private`으로 만들어 클래스 내에서만 사용
- `with`구문을 사용해 동일한 객체 인스턴스에서 여러 호출 실행
- `kotlin.math`라이브러리 사용법



### Android용 XML 레이아웃 만들기

##### 📌프로젝트 UI 요소 

- `EditText` : 텍스트 입력, 수정
- `TextView` : 서비스 질문, 팁 금액과 같은 텍스트 표시
- `RadioButton` : 각 팁 옵션의 선택 가능한 라디오 버튼
- `RadioGroup` : 라디오 버튼 옵션 그룹화
- `Switch` : 팁을 반올림할지 여부를 선택하는 켜기/끄기 전환 버튼



##### 📌XML 읽기 및 이해

- **XML**은 *확장성 마크업 언어*를 의미하며 텍스트 기반 문서를 사용해 데이터를 설명하는 방법이다. 확장 가능하고 매우 유연해 Android앱의 UI 레이아웃 정의를 비롯해 다양한 용도로 사용된다.

- 각 UI 요소는 XML 파일의 XML 요소로 표현된다. 각 요소는 태그`<`로 시작하고 태그`>`로 끝난다. 

- XML 태그, 요소, 속성

  - 빈 요소 태그

    ```kotlin
    <TextView  //태그의 시작
    	android:text = "Hello World!" // 태그 속성
    /> // 태그의 끝
    ```

    같은 의미

    ```kotlin
    <TextView
    	android:text = "Hello World!"
    ></TextView>
    ```

  - `ConstraintLayout`요소는 내부에 다른 요소를 보유할 수 있어야 하므로 별도의 시작 태그와 종료 태그로 작성된다.

- 레이아웃 XML에 관한 추가 정보

  1. `androidx.constraintlayout.widget.ConstraintLayout`은 `ConstraintLayout`이 Android Jetpack의 일부임을 나타냄

  2. Jetpack에는 앱을 더 쉽게 빌드하는 데 활용할 수 있는 유용한 기능이 있음 - 이 UI 구성요소는 'androidx'로 시작

  3. `xmls`는 XML 네임스페이스를 나타내고 각 줄은 *스키마*나 이러한 단어와 관련된 속성의 어휘 정리 - ex)`android:`네임스페이스는 Android 시스템에서 정의한 속성을 표시

  4. XML 요소 사이 공백은 의미 없음 - 가독성 높여줌

  5. 주석은 `<!-- -->`로 표시

  6. 파일이 XML파일이지만 모든 XML파일에 이 내용이 포함되는 것이 아님을 나타냄

     ```kotlin
     <?xml version="1.0" encoding="utf-8"?>
     ```



##### 📌XML로 레이아웃 빌드

-  TextView 삭제

  1. `<TextView`부터 닫는 `/>`까지 모든 항목 삭제

  2. 16dp 패딩을 `ConstraintLayout`에 추가

     ```kotlin
     android:padding="16dp"
     ```

- 서비스 비용 텍스트 입력란 추가

  1. `EditText`문서를 살펴보고 샘플 XML 복사

  2. `ConstraintLayout`안에 붙여넣기

  3. `EditText`에 '뷰가 제한되지 않음' 오류 표시됨 - 레이아웃이 정렬방법을 알 수 있도록 제약 조건 필요

  4. 제약 조건을 `EditText`에 추가하여 상위 요소의 왼쪽 상단에 고정

     ```kotlin
     app:layout_constraintStart_toStartOf="parent"
     app:layout_constraintTop_toTopOf="parent"
     ```

     - 왼쪽에서 오른쪽으로 작성되는 언어의 시작 가장자리는 왼쪽, 다른 언어는 오른쪽 - 제약 조건은 'start'와 'end'를 사용해 모든 언어에서 작동할 수 있도록 한다.
     - 제약 조건의 이름 : layout_constraint<Source>_to<Target>Of형식 - <Source>는 현재 뷰, <Target>은 현재 뷰가 제한되는 타겟 뷰의 가장자리

- EditText 속성 검토

  1. `@+id/plain_text_input`으로 설정된 id 속성 찾기
  2. `id`속성 이름을 `@+id/cost_of_service`로 변경
     - XML을 수동으로 입력할 때는 리소스 ID를 직접 명시적으로 선언해야 함 
     - 새로운 뷰 ID는 `@+id`접두사로 정의
     - 모두 소문자여야 하고 여러 단어는 밑줄로 구분
     - 리소스 ID참조할 때 `R.<type>.<name>`사용
  3. `layout_height`속성은 `wrap_content`로 되어있고 이는 높이가 내부 콘텐츠의 높이와 같다는 의미
  4. `ConstraintLayout`의 하위요소에서는 `match_parent`을 설정할 수 없으므로 `layout_width`의 속성을 고정너비 160dp로 설정
  5. `inputType`속성값은 `"text"`(입력란에 모든 텍스트(알파벳, 기호 등) 입력 가능)에서 `"numberDecimal"`(소수점이 있는 숫자)로 변경
  6. 입력란에 입력해야 할 내용을 설명하는 `hint`속성을 `EditText`에 추가

- 서비스 질문 추가

  1. `EditText`다음에 새 줄을 추가하고 `<TextView`입력

  2. 제안 사항에서 `TextView`를 선택하면 자동으로 `layout_width`와 `layout_height`속성 추가됨

  3. 두 속성 모두 `wrap_content`선택

  4. `text`속성 추가

  5. 태그 닫기

  6. 가로 제약 조건을 `TextView`에 추가하여 시작 가장자리를 상위 요소의 시작 가장자리로 제한

  7. 세로 제약 조건 `TextView`에 추가하여 `TextView`의 상단 가장자리를 서비스 비용 `View`의 하단 가장자리로 제한

     ```kotlin
     app:layout_constraintTop_toBottomOf="@id/cost_of_service"
     ```

  8. `TextView`에서 리소스 ID 추가

  

##### 📌팁 옵션 추가

- RadioButton 추가

  1. `ConstraintLayout`내에 `<RadioGroup` 추가 
  2. `RadioGroup`의 `layout_width`와 `layout_height`를 `wrap_content`로 설정
  3. `@+id/tip_options`로 설정된 리소스 ID추가
  4. `>`로 시작 태그를 닫고 `</RadioGroup>`추가 - `RadioGroup`요소에는 내부에 다른 요소가 있으므로 자체 줄로 이동하는 것이 좋음
  5. `RadioGroup`을 서비스 질문 아래(세로)와 상위 요소의 시작 부분(가로)으로 제한 - `wrap_content`
  6. `android:orientation`속성을 `vertical`로 설정 - 연속된 `RadioButtons`를 원하면 방향을 `horizontal`로 설정

  ```kotlin
  <RadioGroup 
  	android:id="@_id/tip_options"
  	android:layout_width="wrap_content"
  	android:layout_height="wrap_content"
  	android:orientation="vertical"
  	app:layout_constraintStart_toStartOf="parent"
  	app:layout_constraintTop_toBottomOf="@id/service_question"
  </RadioGroup>
  ```

- RadioButtons 추가

  1. `RadioGroup` 마지막 속성 뒤에 `RadioButton`을 추가
  2. `layout_width`와 `layout_height`를 `wrap_content`로 설정
  3. `@+id/option_twenty_percent`의 리소스 ID 할당
  4. 텍스트를 `Amazing(20%)`로 설정
  5. `/>`로 태그 닫기
  6. `Good(18%)`와 `Okay(15%)`옵션에 라디오 버튼 추가

- 기본 선택 추가

  1. `RadioGroup`에서 `android:checkedButton`속성을 `@id/option_twenty_perent`로 설정



##### &#128204;나머지 레이아웃 완료

- 팁을 반올림하기 위한 Switch 추가

  1. `RadioGroup`의 XML 뒤에 `Switch`요소 추가
  2. `layout_width`를 0dp.로 설정 - `ConstraintLayout`에서는 `match_parent`를 쓸 수 없음, 대신 일치 제약을 의미하는 `0dp`사용
  3. `layout_height`를 `wrap_content`로 설정 &#10140; `Switch` 뷰의 높이가 내부 콘텐츠의 높이와 같아짐
  4. `id` 속성을 `@+id/round_up_switch`로 설정
  5. `text`속성을 `Round up tip?`으로 설정 &#10140; `Switch`의 라벨로 사용됨
  6. `Switch`의 시작 가장자리를 상위 요소의 시작 가장자리로 제한하고 끝 가장자리를 상위 요소의 끝 가장자리로 제한
  7. `Switch` 상단을 `tip_options`하단으로 제한
  8. `/>`사용해 태그 닫기
  9. 스위치가 기본적으로 사용 설정되어 있고 가능한 값이 `true`(사용설정)나 `false`(사용중지)인 속성 `android:checked`를 `true`로 설정

  ```kotlin
  <Switch
      android:id="@+id/round_up_switch"
      android:layout_width="0dp"
      android:layout_height="wrap_content"
      android:checked="true"
      android:text="Round up tip?"
      app:layout_constraintEnd_toEndOf="parent"
      app:layout_constraintStart_toStartOf="parent"
      app:layout_constraintTop_toBottomOf="@id/tip_options" />
  ```

- Calculate 버튼 추가

  1. `Switch`뒤에 `Button`추가
  2. 너비를 `0dp`로 설정
  3. 높이를 `wrap_content`로 설정
  4. `"Calculate"`텍스트와 함께 리소스 ID `@+id/calculate_button`제공
  5. `Button`의 상단 가장자리를 `Switch`의 하당 가장자리로 제한
  6. 시작 가장자리를 상위요소의 시작 가장자리로 제한하고 끝 가장자리를 상위요소의 끝 가장자리로 제한
  7. `/>`로 태그 닫기

  ```kotlin
  <Button
     android:id="@+id/calculate_button"
     android:layout_width="0dp"
     android:layout_height="wrap_content"
     android:text="Calculate"
     app:layout_constraintTop_toBottomOf="@id/round_up_switch"
     app:layout_constraintStart_toStartOf="parent"
     app:layout_constraintEnd_toEndOf="parent" />
  ```

- 팁 결과 추가

  1. 이름이 `tip_result`인 리소스 ID와 텍스트 `Tip Amount`가 있는 `TextView`추가
  2. `TextView`의 끝 가장자리를 상위 요소의 끝 가장자리로 제한
  3. 상단 가장자리를 Calculate 버튼의 하단 가장자리로 제한

  ```kotlin
  <TextView
      android:id="@+id/tip_result"
      android:layout_width="wrap_content"
      android:layout_height="wrap_content"
      app:layout_constraintEnd_toEndOf="parent"
      app:layout_constraintTop_toBottomOf="@id/calculate_button"
      android:text="Tip Amount" />
  ```

  

##### &#128204;적절한 코딩 사례 채택

- 문자열 추출

  1. 문자열을 클릭하고 표시되는 노란색 전구 아이콘 위로 마우스를 가져간 다음 옆에 있는 삼각형을 클릭
  2. **Extract String Resource**를 선택 

- XMl 형식 다시 지정

  1. `activity_main.xml`에서 **Edit  > Select All**클릭
  2. **Code > Reformate Code**를 선택

  

### 팁 계산

##### &#128204;시작 앱 개요

- 앱 프로젝트 구조
  - java - Kotlin 파일 또는 자바 파일의 폴더
  - `MainActivity` - 팁 계산기 로직의 모든 코드가 들어갈 클래스
  - res - 앱 리소스 폴더
  - `activity_main.xmtl` - 앱의 레이아웃
  - `strings.xml` - 문자열 리소스가 포함되어 있는 파일
  - Gradle Scripts - 폴더
  - *Gradle*은 Android 스튜디오에서 사용하는 자동화된 빌드 시스템으로 개발자가 앱을 변경할 때마다 Gradle이 변경된 사항을 파악해 앱을 다시 빌드하는 데 필요한 조치를 취함



##### &#128204;뷰 결합

- `View`의 ID가 주어지면 이 뷰에 대한 참조를 반환하는 작업을 실행하는 `findViewById()`메서드가 있다. 이 접근 방식은 효과적이지만 UI가 복잡해지면 번거로워질 수 있다. &#10140; 뷰 결합을 통해 UI의 뷰에서 메서드 훨씬 쉽고 빠르게 호출

- 뷰 결합 사용 설정

  1. 앱의 `build.gradle`파일 열기 ( **Gradle Scripts > build.gradle (Module:Tip_Time.app)**)

  2. `android`섹션에 다음 줄 추가

     ```kotlin
     buildFeatures {
     	viewBinding = true
     }
     ```

  3. '**Gradle files have changed since last project sync.**'라는 메시지가 뜨면 **Sync Now** 클릭

- 결합 객체 초기화

  1. 앱의 각 `View`마다 `findViewById()`를 호출하는 대신, 결합 객체를 한 번 만들고 초기화

  2. `MainActivity.kt` 열기

  3. 모든 기존 코드를 다음 코드로 대체해 뷰 결합을 사용하도록 설정

     ```kotlin
     class MainActivity : AppCompatActivity() {
     
         lateinit var binding: ActivityMainBinding
     
         override fun onCreate(savedInstanceState: Bundle?) {
             super.onCreate(savedInstanceState)
             binding = ActivityMainBinding.inflate(layoutInflater)
             setContentView(binding.root)
         }
     }
     ```

  4. 다음 코드 줄은 클래스에서 결합 객체의 최상위 변수를 선언

     ```kotlin
     lateinit var binding: ActivityMainBinding
     ```

     - `lateinit`키워드는 모드가 변수를 사용하기 전에 먼저 초기화할 것임을 확인해줌 - 변수 초기화하지 않으면 앱이 비정상 종료됨

  5. 다음 코드 줄은 `activity_main.xml`레이아웃에서 `Views`에 액세스하는데 사용할 `binding`객체 초기화

     ```kotlin
     binding = ActivityMainBinding.inflate(layoutInflater)
     ```

  6. 활동의 콘텐츠 뷰 설정, 다음 코드는 레이아웃의 리소스 ID를 전달하는 대신, 앱의 뷰 계층 구조 루트인 `binding.root`를 지정

     ```kotlin
     setContentView(binding.root)
     ```



##### &#128204;팁 계산

- 버튼에 클릭 리스너 추가

  1. `onCreate()`의 `MainActivity.kt`에서 `setContentView()`호출 뒤에 **Calculate**버튼에 클릭 리스너 설정하고 `calculateTip()`을 호출하도록 함

     ```kotlin
     binding.calculateButton.setOnClickListener{calculateTip()}
     ```

  2. `MainActivity`클래스 내, `onCreate()`외부에 `calculateTip()`이라는 도우미 메서드 추가

- 서비스 비용 가져오기

  - `Int`는 정수만 보유할 수 있으므로 앱에서 십진수를 사용하려면 `Double`을 사용해야 함
  - `String`을 `Double`로 변환하는 `toDouble()`이라는 메서드 사용

  1. `calculateTip()`메서드에서 `EditText`의 텍스트 속성을 가져와서 `stringInTextField`라는 변수에 할당

     ```kotlin
     val stringInTextField = binding.costOfService.text.toString()
     ```

     - 끝부분에 `.text`를 추가해 결과를 얻은 후 이 객체에서 text속성을 가져옴, 이렇게 자기 자신 클래스를 리턴하여 기능을 이어나가는 것을  *체이닝*이라 하고 매우 일반적인 패턴임

  2. 텍스트를 십진수로 변환, `toDouble()`을 호출해 `cost`라는 변수에 저장

     ```kotlin
     val cost = stringInTextField.toDouble()
     ```

     - `toDouble()`은 `String`에서 호출되어야 함

- 팁 비율 가져오기

  1. `calculateTip()`에서 `tipOptions``RadioGroup`의 `checkedRadioButtonId`속성을 가져와 `selectedId`라는 변수에 할당

     ```kotlin
     val selectedId = binding.tipOptions.checkedRadioButtondId
     ```

     - 어느 `RadioButton`이 선택되었는지 알 수 있음

  2. 팁 비율 가져오기

     ```kotlin
     val tipPercentage = when (selectedId) {
     	R.id.option_twenty_percent -> 0.20
     	R.id.option_eighteen_percent -> 0.18
     	else -> 0.15
     }
     ```

- 팁 계산 및 반올림하기

  1. 앞서 추가한 다른 코드 뒤에 `tipPercentage`와 `cost`를 곱하고 `tip`이라는 변수에 할당

     ```kotlin
     var tip = tipPercentage * cost
     ```

     - `val`대신 `var`을 사용한 점에 유의 - 값을 반올림해야 할 수 있어 값이 변경될 수도 있기 때문

  2. 반올림 스위치의 `isChecked`속성을 `roundUP`이라는 변수에 할당

     ```kotlin
     val roundUp = binding.roundUpSwitch.isChecked
     ```

  3. 위로만 반올림하거나 상한(ceiling)을 찾아야 하므로 `ceil()` 함수 사용 - 함수는 `kotlin.math`에 정의되어 있음

  4. `roundUp`이 true인 경우 `tip`변수에 팁의 상한을 할당하는`if`문 추가

     ```kotlin
     if(roundUp){
     	tip = kotlin.math.ceil(tip)
     }
     ```

- 팁 형식 지정

  1. `calculateTip()`에서 다른 코드 뒤에서 `NumberFormat.getCurrencyInstance()`호출 - 숫자를 통화 형식으로 지정하는 데 사용할 수 있는 숫자 형식 지정 클래스 제공

  2. `tip`과 `format()`메서드 호출을 체이닝하고 `formattedTip`이라는 변수에 결과 할당 

     ```kotlin
     val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
     ```

  3. `NumberFormat`의 버전을 자동으로 파악할 수 없어 빨간색으로 표시됨

  4. `NumberFormat`위로 마우스 포인터를 가져가서 팝업이 표시되면 **Import**선택 

  5. 가능한 가져오기 목록에서 **NumberFormat(java.text)**선택

- 팁 표시

  - 문자열에 숫자를 표시할 위치가 언어마다 다름 &#10140; *문자열 매개변수*라는 매커니즘 사용해 숫자가 표시되는 위치 변경

  1. `strings.xml` 열기

  2. `tip_amount`문자열을 `Tip Amount`에서 `Tip Amount: %s`로 변경

     ```kotlin
     <string name="tip_amount">Tip Amount: %s</string>
     ```

  3. `tipResult`의 텍스트 설정

     ```kotlin
     binding.tipResult.text = getString(R.string.tip_amount, formattedTip)
     ```

  4. `activity_main.xml`에서 `tip_result` `TextView`의 `android:text`속성이 있는 코드 줄 삭제

  5. 다음 줄 추가

     ```kotlin
     tools:text = "Tip Amount: $10"
     ```

     

##### &#128204;테스트 및 디버그

- 비정상 종료 디버그

  1. Android 스튜디오 하단에 있는 **Logcat**버튼 클릭

  2. 출력되는 텍스트는 *스택 트레이스*로, 비정상 종료가 발생했을 때 호출된 메서드의 목록

  3. `FATAL EXCEPTION`텍스트가 포함된 줄 찾기

  4. `NumberFormatException`이 있는 줄 찾기

     ```kotlin
     java.lang.NumberFormatException: empty String
     ```

     - 값이 있는 `String`이어야 할 때 비어있는 `String`이 발견됨

  5. `parseDouble()`호출 아래에서 `calculateTip`이 있는 줄 찾기

  6. `MainActivity.kt`의 20번째 줄에서 `String`을 `Double`로 변환하고 결과를 `cost`변수에 할당

     ```kotlin
     at com.example.tiptime.MainActivity.calculateTip(MainActivity.kt:20)
     ```

     ```kotlin
     val cost = stringInTextField.toDouble()
     ```

  7. `String`에서 작동하는 `toDouble()`메서드 `String.toDouble()`찾기

  8. 페이지에 'Exceptions:`NumberFormatException`-if the string is not a valid representation of a number'라고 나와있음

  - *예외*는 시스템에서 문제가 있음을 표현하는 방법이다.
  - 이 케이스에서 문제는 `toDouble()`이 비어있는 `String`을 `Double`로 변환할 수 없다는 것이다.

- null에 관해 자세히 알아보기

  - 비어있거나 유효하지 않음 십진수를 나타내는 문자열에서 `toDouble()`을 호출하면 작동하지 않는 문제를 처리하는 `toDoubleOrNull()`이라는 메서드가 있다. 

  - *Null*은 '값 없음'을 의미하는 특수값이다.

  - `toDoubleOrNull()`에서 `null`이 반환되는지 확인해 `null`이 반환되는 경우 다른 방식으로 처리해 앱이 비정상 종료되지 않게 하는 방법

    1. `calculateTip()`에서 `cost`변수를 선언하는 코드 줄을, `toDouble()`을 호출하는 대신 `toDoubleOrNull()`을 호출하도록 변경

       ```kotlin
       val cost = stringInTextField.toDoubleOrNull()
       ```

    2. `cost`가 `null`인지 확인하고 그렇다면 메서드에서 반환되는 문 추가 

       ```kotlin
       if (cost == null) {
       	return 
       }
       ```

       - `return`명령은 나머지 명령을 실행하지 않고 메서드를 종료하는 것을 의미

- 다른 케이스 처리

  - 고려해야할 다른 케이스들 

    1. 비용에 유효한 금액 입력
    2. **Calculate**를 탭해 팁 계산
    3. 비용 삭제
    4. **Calculate**를 다시 탭

  - 두번째로 팁이 계산될 때 앞서 추가한 null 확인 코드로 인해 `calculateTip()`메서드가 조기에 반환되지만, 앱에 여전히 이전의 팁 금액이 표시됨 -> 팁 금액을 지우는 코드 추가

    1. 앞서 추가한 `if`내에서 `return`문 앞에 `tipResult`의 `text`속성을 빈 문자열로 설정하는 코드 줄 추가 

       ```kotlin
       if( cost == null ) {
       	binding.tipResult.text = ""
       	return
       }
       ```



##### &#128204;적절한 코딩 사례 채택

- 메서드 설정

  1. `MainActivity.kt`열기
  2. `calculateTip()`메서드의 시작 부분을 살펴보면 물결 모양의 회색 선으로 밑줄에 마우스 포인터 올리기
  3. **Make 'calculateTip' 'private'**이라는 추천이 있는 **Function 'calculateTip' could be private**메시지가 표시됨
  4. **Make 'calculateTip' 'private'**을 선택하거나 `fun calculateTip()`앞에 `private`키워드 추가

  - `private`은 메서드 또는 변수가 클래스(`MainActivity`) 내의 코드에만 공개된다는 것을 의미하는데 `MainActivity`외부의 코드가 `calculateTip()`을 호출할 이유가 없으므로 이 메서드를 `private`으로 만들 수 있다.

- 코드 검사 

  1. `MainActivity.kt`연 상태에서 메뉴에서 **Analyze > Inspect Code...**를 선택해서 **Specify Insepction Scope**라는 대화상자가 표시됨

  2. **File**로 시작하는 옵션을 선택하고 **OK**선택 - 검사가 `MainActivity.kt`로만 제한됨

  3. **Inspection Results**가 있는 창이 하단에 표시됨

  4. 2개의 메시지가 표시될 때까지 Kotlin옆과 Style issues 옆에 있는 회색 삼각형을 차례로 클릭, 첫번째 메시지는 **Class member can have 'private' visibility**

  5. **Property 'binding' could be private** 메시지가 표시될 때까지 회색 삼각형을 클릭하고, 메시지 클릭 - `MainActivity`의 일부 코드를 표시하고 `binding`변수를 강조표시함

  6. **Make 'binding' 'private'** 버튼 클릭 - **Inspection Results**에서 문제 삭제

  7. 코드에서 `binding`을 살펴보면 Android 스튜디오가 선언 앞에 `private`키워드 추가한 것 확인할 수 있음

     ```kotlin
     private lateinit var binding: ActivityMainBinding
     ```

  8. **Variable declaration could be inlined**메시지가 표시될 때까지 결과에서 회색 삼각형을 클릭 - `selectedId`변수 강조표시

  9. **Inline variable**버튼을 눌러 `when`표현식의 `selectedId`를 앞 코드 줄에서 할당된 값으로 바꿈

     ```kotlin
     when(binding.tipOptions.checkedRadioButtonId){
     	R.id.option_twenty_percent -> 0.20
     	R.id.option_eighteen_percent -> 0.18
     	else -> 0.15
     }
     ```

- 불필요한 변수 삭제 

  1. `roundUp`이 할당된 줄에서 `=`오른쪽에 있는 표현식 복사 

     ```kotlin
     val roundUp = binding.roundUpSwitch.isChecked 
     ```

  2. 그 다음 줄의 `roundUp`을 방금 복사한 표현식인 `binding.roundUpSwitch.isChecked`로 바꿈

     ```kotlin
     if(binding.roudnUpSwitch.isChecked) {
     	tip = kotlin.math.ceil(tip)
     }
     ```

  3. `roundUp`이 있는 코드 줄 삭제

- 반복 코드 제거

  - 서비스 비용에 값을 입력하지 않으면 앱이 `tipResult`를 빈 문자열이이 되도록 업데이트

  - 값이 있으면 `NumberFormat`을 사용해 값의 형식 지정 

  - 유사한 코드 중복을 줄이기 위해 자체 함수로 추출할 수 있음 

    1. 중복된 코드를 자체 함수로 이동 - 코드가 여러 위치에서 작동하도록 팁을 매개변수로 사용

       ```kotlin
       val formattedTip = NumberFormat.getCurrencyInstance().format(0.0)
       binding.tipResult.text = getString(R.string.tip_amount, formattedTip)
       ```

       ```kotlin
       private fun display(tip : Double) {
       	val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
       	binding.tipResult.text = getString(R.string.tip_amount, formattedTip)
       }
       ```

    2. `displayTip()`도우미 함수를 사용하고 `0.0`도 확인하도록 `calcualteTip()`함수 업데이트

       ```kotlin
       private fun calculateTip() {
           ...
       
               // If the cost is null or 0, then display 0 tip and exit this function early.
               if (cost == null || cost == 0.0) {
                   displayTip(0.0)
                   return
               }
       
           ...
           val roundUp = binding.roundUpSwitch.isChecked
           if (roundUp) {
               tip = kotlin.math.ceil(tip)
           }
       
           // Display the formatted tip value on screen
           displayTip(tip)
       }
       ```

       

#### &#128204;퀴즈

1. 클래스 상속에 대한 설명

   - 클래스 상속 사용하면 코드 재사용할 수 있고 프로그램을 더 쉽게 유지 관리 할 수 있다.
   - 부모 클래스의 속성과 기능은 자식 클래스에서 사용할 수 있다.
   - 서브클래스에 특정한 추가 속성 및 기능 정의할 수 있다.
   - 하위 클래스에서 상위 클래스 멤버를 재정의할 수 있다.

2. 추상 클래스에 대한 설명

   - 추상 클래스는 서브클래스에 의해 확장될 수 있으며 클래스의 추상 멤버에 대한 구현이 제공될 수 있다.
   - 추상 속성이나 추상 기능을 가질 수 있다.
   - 완전히 구현되지 않았으며 인스턴스화할 수 없다

3. `생성자(Constructor)`는 클래스의 인스턴스를 만들 때 호출된다.

4. 현재 클래스 내에서만 사용할 속성 표시법 

   - `private`키워드 사용

5. 화면에 표시될 때 이 XML 레이아웃에 대해 참인 모든 답변

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

   - `TextView A`의 시작 모서리는 상위 뷰의 시작 모서리에 맞춰진다.
   - `TextView A`와 `TextView B`의 상단은 부모 뷰의 맨 위로 정렬된다.