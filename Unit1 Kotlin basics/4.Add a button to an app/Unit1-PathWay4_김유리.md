# 2021 Landvibe Summer Coding - Android

## Unit1 - Kotlin Basics

## PathWay4 - Add a button to an app

### Kotlin의 클래스 및 객체 인스턴스

##### 📌랜덤 숫자 굴리기

- 랜덤 함수 사용

  1. `main()`함수 내에서 변수를 `diceRange`라는 `val`로 정의

  2. 1~6까지의 `IntRange`에 할당, `IntRange`는 시작점부터 끝점까지의 정수의 범위를 나타냄

     ```kotlin
     val diceRange = 1..6
     ```

  3. `main()`내에서 변수를 `randomNumber`라는 `val`로 정의

  4. `randomNumber`가 `dicRange`범위에서 `random()`를 호출한 결과 값을 갖도록 함

     ```kotlin
     val randomNumber = diceRange.random()
     ```

  5. `${randomNumber}`를 사용하여 출력

     ```kotlin
     println("Random number : ${randomNumber}")
     ```



##### 📌Dice 클래스 만들기

- Dice 클래스 정의

  1. 클래스는 키워드 `class`, 클래스 이름, 여는 중괄호, 닫는 중괄호 순으로 작성

  2. 클래스 내에 주사위 면 수를 위한 `sides`라는 변수 추가, 6으로 설정

     ```kotlin
     class Dice {
     	var sides = 6
     }
     ```

- Dice 클래스의 인스턴스 만들기

  1. `main()`함수에서 `myFirstDice`라는 변수를 만들어 `Dice`클래스의 인스턴스로 초기화

  2. `myFirstDice`의 `sides`속성에 액세스하려면 `MyFirstDice.sides`호출

  3. `println`문을 추가해 `myFirstDice.sides`출력

     ```kotlin
      fun main(){
     	val myFirstDice = Dice()
     	printlnt(myFirstDice.sides)
      }
     ```

  

##### 📌주사위 굴리기

- 클래스 내에서 정의된 함수를 *메서드*라고 한다.

1. 메서드는 키워드`fun`, 메서드 이름, 괄호`()`,여는 중괄호, 닫는 중괄호 순으로 작성

2. `roll()`메서드 내에서 변수 `randomNumber`생성 후 `1..6`범위에서 랜덤 숫자 할당, 점 표기법을 사용해 `random()`호출

3. 랜덤 숫자를 생성 한 후 출력

   ```kotlin
   fun roll() {
        val randomNumber = (1..6).random()
        println(randomNumber)
   }
   ```

4. `main()`에서 `myFirstDice`의 `roll()`메서드 호출

   ```kotlin
   myFirstDice.roll()
   ```

   

##### 📌주사위 굴리기 값 반환

1. `main()`에서 변수 `diceRoll`을 만들어 `roll()`메서드 반환 값으로 설정

2. `roll()`함수를 변경하여 반환할 데이터 유형 지정, 반환 유형을 지정하려면 함수 이름, 괄호, 콜론, 공백, 함수 반환 유형의 키워드 순으로 작성

3. `roll()`에서 `println()`문을 삭제하고 `randomNumber`의 `return`문으로 바꿈

4. `main()`에서 정보를 제공하는 문장에 `sides`및 `diceRoll`값을 출력하는 문을 추가

   ```kotlin
   fun main() {
       val myFirstDice = Dice()
       val diceRoll = myFirstDice.roll()
       println("Your ${myFirstDice.sides} sided dice rolled ${diceRoll}!")
   }
   
   class Dice {
       var sides = 6
   
       fun roll(): Int {
           val randomNumber = (1..6).random()
           return randomNumber
       }
   }
   ```



##### 📌주사위 면 수 변경

1. `Dice`클래스의 `roll()`메서드에서 `1..6`대신 `sides`를 사용하도록 변경

2. `main()`에서 주사위 굴리기 출력 후 `myFirstDice`의 `sides`값을 20으로 변경

3. 기존 출력 문 복사해서 붙여넣기

4. `diceRoll`의 출력을 `myFirstDice`의 `roll()`메서드 호출 결과의 출력으로 변경

   ```kotlin
   fun main() {
   
       val myFirstDice = Dice()
       val diceRoll = myFirstDice.roll()
       println("Your ${myFirstDice.sides} sided dice rolled ${diceRoll}!")
   
       myFirstDice.sides = 20
       println("Your ${myFirstDice.sides} sided dice rolled ${myFirstDice.roll()}!")
   }
   
   class Dice {
       var sides = 6
   
       fun roll(): Int {
           val randomNumber = (1..sides).random()
           return randomNumber
       }
   }
   ```

   

##### 📌주사위 맞춤설정

- 새 인스턴스를 만들 때 면 수를 지정할 수 있도록 클래스 수정

1. `Dice`클래스 정의를 수정하여 `numSides`라는 정수를 허용

2. `sides`변수 삭제 후 `numSides`를 사용하도록 범위 수정

   ```kotlin
   class Dice (val numSides: Int) {
   
       fun roll(): Int {
           val randomNumber = (1..numSides).random()
           return randomNumber
       }
   }
   ```

3. `main()`에서 `myFirstDice`의 `Dice`클래스에 인수 제공

4. 출력문의 `sides`를 `numSides`로 변경

5. `sides`변경 코드와 아래 출력문 삭제

6. `mySecondDice`라는 면이 20개인 두번째 `Dice`객체 생성 후 굴린 값 출력

   ```kotlin
   fun main() {
       val myFirstDice = Dice(6)
       val diceRoll = myFirstDice.roll()
       println("Your ${myFirstDice.numSides} sided dice rolled ${diceRoll}!")
   
       val mySecondDice = Dice(20)
       println("Your ${mySecondDice.numSides} sided dice rolled ${mySecondDice.roll()}!")
   }
   
   class Dice (val numSides: Int) {
   
       fun roll(): Int {
           val randomNumber = (1..numSides).random()
           return randomNumber
       }
   }
   ```

   

### 상호작용 Dice Roller 앱 만들기

##### 📌앱 설정

- Dice Roller라는 새로운 Project생성



##### 📌앱 레이아웃 만들기

- Layout Editor열기

  1. `activity_main.xml`을 열고 앱에 `Button`추가, `Button`은 `ConstraintLayout`의 하위요소로 간주

- Button 배치

  - `Button` 상단의 세로 제약 조건을 `TextView`하단에 추가

  1. `Button` 상단 가장자리의 테두기라 파란색인 흰색 원을 길게 눌러 `TextView`의 하단 가장자리에 놓음
  2. `Constraint Widget`에서 `TextView` 하단, **Top->BottomOf textView(0dp)**로 설정된 것 확인
  3. `Button`의 왼쪽과 오른쪽 가장자리를 `ContraintLayout`의 왼쪽과 오른쪽 가장자리에 연결

- Button 텍스트 변경

  1. `text`를 Roll로 변경
  2. 경고에서 `Fix`클릭
  3. `roll`이라는 문자열 리소스 생성

- TextView 스타일 지정

  1. 크기 36sp로 변경

  2. `text`속성 삭제

  3. 도구 아이콘이 있는 다른 `text`속성을 1로 설정, 도구 아이콘이 있는 `text`속성은 개발자만을 위한 '도구 텍스트'`Design Editor`에만 표시되고 실제 기기에는 표시되지 않음

     

##### 📌 Activity 소개

- `Activity`는 앱이 UI를 그리는 창을 제공한다. 실행되는 앱의 전체 화면을 차지한다.
- 최상위 수준 또는 첫번째 활동을 종종 `MainActivity`라고 하고 프로젝트 템플릿에서 제공한다.
- MainActivity.kt 파일 열기
  1. `MainActivity.kt`파일 열고 `import...`가 표시되면 `...`을 클릭하여 가져오기 펼치기
  2. `MainActivity`클래스의 코드 확인 - `main()`함수가 없음
  3. `main()`대신 `onCreate()`메서드 호출
  4. `onCreate()`메서드는 `setContentView()`로 시작 레이아웃을 설정
- 자동 가져오기 사용 설정
  1. **File > Other Setting > Setting for New Project...**로 이동
  2. **Auto Import**를 펼침
  3. **Java**및 **Kotlin**섹션에서 **Add unambiguous imports on the fly**(사용할 문을 결정할 수 있는 한 improt문 자동 추가)  및 **Optimize imports on the fly ( for current project ) **(사용되지 않는 가져오기 삭제)가 선택되어 있는지 확인



##### 📌 Button을 상호작용적으로 만들기

- Button을 클릭할 때 메시지 표시

  1. `setContentView()`호출 후 `noCreate()`메서드에 다음 코드 추가 - `findViewById()`메서드는 레이아웃에서 버튼을 찾는다. `R.id.button`을 버튼의 리소스 ID로 버튼의 고유한 식별자이다. 

     ```kotlin
     val rollButton: Button = findViewById(R.id.button)
     ```

  2. 버튼의 `import`문을 추가했는지 확인

  3. `rollButton`객체를 사용하고 `setOnClickListener{...}`메서드를 호출하여 클릭 리스터 설정

  4.  `Toast.makeText()`를 호출하여 "Dice Rolled!"텍스트로 간단한 메시지인 `Toast`를 만듦

  5. `show()`메서드를 호출하여 `Toast`에 자체를 표시하라고 지시

     ```kotlin
     rollButton.setOnClickListener { 
     	val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
     	toast.show()
     }
     ```

  6. 앱 실행하고 **Roll**버튼 클릭

- Button을 클릭할 때 TextView 업데이트

  - **Roll**버튼을 클릭할 때 화면의 `TextView`를 업데이트하는 코드

  1. `MainActivity.kt`에서 `Toast`를 만들고 표시하는 코드 줄 삭제

  2. `resultTextView`라는 새로운 변수를 만들어 `TextView`를 저장

  3. `findViewById()`를 사용해 레이아웃에서 ID로 `textView`를 찾고 그 참조를 저장

  4. `resultTextView`의 텍스트를 따옴표로 묶인 6으로 설정

     ```kotlin
     val resultTextView: TextView = findViewById(R.id.textView)
     resultTextView.text = "6"	
     ```

     

##### 📌 주사위 굴리기 로직  추가

- Dice 클래스 추가

  1. `MainActivity`클래스의 마지막 중괄호 뒤에 `roll()`메서드를 사용해 `Dice`클래스를 만듦

     ```kotlin
     class Dice(val numSides: Int) {
     
     	fun roll(): Int { 
     		return (1..numSides).random()
     	}
     }
     ```

  2. 회색선이 그어진 `numSides`위로 포인터를 가져가면 **Property 'numSides' could be private**라고 나타내는 팝업이 표시 - `numSides`를 `private`로 표시하면 `Dice`내에서만 액세스 가능

- rollDice() 메서드 만들기

  1. 텍스트를 '6'으로 설정하는 클릭 리스너의 코드를 `rollDice()`호출로 바꿈

     ```kotlin
     rollButton.setOnClickListenre{
     	rollDice()
     }
     ```

  2. `rollDice()`위로 포인터를 가져가 팝업창에서 **More actions...**클릭 후 **Create function 'rollDice'**선택

     ```kotlin
     private fun rollDice(){
     	TODO("Not yet implemented")
     }
     ```

- 새 Dice 객체 인스턴스 만들기

  1. `rollDice()`내에서 `TODO()`호출 삭제

  2. 6면 주사위를 만드는 코드 추가

     ```kotlin
     val dice = Dice(6)	
     ```

  3. `roll()`메서드 호출해 주사위를 굴리고 `diceRoll`이라는 변수에 결과 저장

     ```kotlin
     val diceRoll = dice.roll()
     ```

  4. `findViewById()`를 호출하여 `TextView`찾기

     ```kotlin
     val resultTextView: TextView = findViewById(R.id.textView)
     ```

  5. `diceRoll`을 문자열로 변환하고 이를 사용하여 `resultTextView`텍스트 업데이트

     ```kotlin
     resultTextView.text = diceRoll.toString()
     ```

     

### Kotlin에서 조건부 동작 추가

##### 📌코드 내에서 의사 결정

- **If**. `num`이 4보다 크면 `greater than 4`출력

- **Else if**. `num`이 4와 같으면 `equal to 4`출력

- **Else**. 모든 조건 false면 `less than`출력

  ```kotlin
  fun main(){
  	val num = 5
  	if( num > 4) {
  		println("The variable is greater than 4")
      } else if (num == 4) {
  		println("The variable is equal to 4")
      } else {
  		println("The variable is less than 4")
  	}
  }
  ```

  

##### 📌Lucky Dice Roll 게임 만들기

- 시작 코드 설정

  ```kotlin
  fun main() {
      val myFirstDice = Dice(6)
      val rollResult = myFirstDice.roll()
      println("Your ${myFirstDice.numSides} sided dice rolled ${rollResult}!")
  }
  
  class Dice (val numSides: Int) {
  
      fun roll(): Int {
          return (1..numSides).random()
      }
  }
  ```

- 행운의 숫자가 나왔는지 확인

  1. `main()`에서 출력문 삭제
  2. `luckyNumber`변수를 추가하고 4로 설정
  3. `rollResult`가 `luckyNumber`와 같은지 확인하는 조건이 있는 `if`문 추가
  4. `if`문 안에 `"You win!"`을 출력하는 코드 작성

- 행운의 숫자가 나오지 않았을 때 응답

  1. `else`문을 추가해 `"You didn't win, try again!"`출력

  2. `else if`문을 추가해 주사위를 굴릴 때마다 다른 메시지 출력

     ```kotlin
     fun main() {
         val myFirstDice = Dice(6)
         val rollResult = myFirstDice.roll()
         val luckyNumber = 4
     
         if (rollResult == luckyNumber) {
             println("You win!")
         } else if (rollResult == 1) {
             println("So sorry! You rolled a 1. Try again!")
         } else if (rollResult == 2) {
             println("Sadly, you rolled a 2. Try again!")
         } else if (rollResult == 3) {
             println("Unfortunately, you rolled a 3. Try again!")
         } else if (rollResult == 5) {
             println("Don't cry! You rolled a 5. Try again!")
         } else {
             println("Apologies! You rolled a 6. Try again!")
         }
     }
     ```



##### 📌when 문 사용

- `when`문은 키워드 `when`으로 시작하고 뒤이어 괄호가 나온다. 괄호 안에 테스트할 값을 입력하고 중괄호가 이어진다.

1. `when`문의 중괄호 안에 `luckyNumber`와 비교하여 `rollResult`를 테스트하는 문 추가

   ```kotlin
   luckyNumber -> println("You win!")	
   ```

   - `luckyNumber` : `rollResult`와 비교하려는 값
   - 화살표를 입력하고 일치하면 실행할 작업 추가

2. 같은 패턴을 사용해 결과값 1~6을 위한 줄과 메시지 추가

   ```kotlin
   fun main() {
       val myFirstDice = Dice(6)
       val rollResult = myFirstDice.roll()
       val luckyNumber = 4
   
       when (rollResult) {
           luckyNumber -> println("You won!")
           1 -> println("So sorry! You rolled a 1. Try again!")
           2 -> println("Sadly, you rolled a 2. Try again!")
           3 -> println("Unfortunately, you rolled a 3. Try again!")
           5 -> println("Don't cry! You rolled a 5. Try again!")
           6 -> println("Apologies! you rolled a 6. Try again!")
       }
   }
   
   class Dice(val numSides: Int) {
       fun roll(): Int {
           return (1..numSides).random()
       }
   }
   ```

   

### Dice Roller 앱에 이미지 추가

##### 📌앱 레이아웃 업데이트 

- 기존 TextView 삭제
- 레이아웃에 ImageView 추가
  1. `ImageView`를 드래그해 버튼 위에 배치
  2. **Pick a Resource** 대화상자의 **Sample data** 아래에서 **avatars**를 선택
- ImageView와 Button 배치
  1. 이미지에 가로 제약 조건 추가 - 이미지 왼쪽을 상위 요소의 왼쪽 가장자리에 연결, 오른쪽도 동일하게 연결
  2. 이미지에 세로 제약 조건 추가 - 이미지 상단을 상위 요소의 상단에 연결
  3. 버튼에 세로 제약 조건 추가 - 버튼의 상단을 이미지 하단에 연결
  4. 이미지에 세로 제약 조건 추가 - 이미지의 하단을 상위 요소의 하단에 연결



##### 📌주사위 이미지 추가

- 앱에 주사위 이미지 추가
  1. **Resource Manager**아래의 **+**를 클릭하고 **Import Drawables**선택
  2. 6개 이미지 **Import**



##### 📌주사위 이미지 사용

- 샘플 아바타 이미지 바꾸기

  1. 이미지 선택
  2. `Attributes`에서 `srcCompat`속성 찾기 - `srcCompat` 속성은 Android 스튜디오의 **Design**뷰 내에서만 제공된 이미지 사용, 실제 앱에선 표시되지 않음
  3. 아바타의 작은 미리보기를 클릭
  4. `dice_1`드로어블 선택 후 OK
  5. 이미지 고정너비 160dp와 고정 높이 200dp로 설정
  6. 버튼 상단에 여백 16dp 추가

- 버튼 클릭할 때 주사위 이미지 변경

  1. `MainActivity.kt`로 이동

  2. `rollDice`에서 `TextView`를 참조하는 코드 삭제

  3. `ImageView`유형의 `diceImage`라는 새 변수 만들기

  4. `findViewById()`메서드를 사용하고`ImageView`의 리소스 ID `R.id.imageView`를 입력 인수로 전달

     ```kotlin
     val diceImage: ImageView = findViewById(R.id.imageView)
     ```

  5. 버튼 클릭 시 `ImageView`를 올바르게 업데이트할 수 있는지 테스트

     ```kotlin
     diceImage.setImageResource(R.drawable.dice_2)
     ```



##### 📌주사위 굴리기에 따라 올바른 주사위 이미지 표시

- rollDice() 메서드 업데이트

  ```kotlin
  val drawableResource = when (diceRoll) {
     1 -> R.drawable.dice_1
     2 -> R.drawable.dice_2
     3 -> R.drawable.dice_3
     4 -> R.drawable.dice_4
     5 -> R.drawable.dice_5
     else -> R.drawable.dice_6
  }
  
  diceImage.setImageResource(drawableResource)
  ```

  - `when`표현식이 실제로 값을 반환할 수 있다.
  - `when`표현식의 값이 `drawableResource`에 할당되므로 `when`은 완전해야 한다. -> `else`문 필요

- ImageView에서 적절한 콘텐츠 설명 설정

  ```kotlin
  diceimage.contentDescription = diceRoll.toString()
  ```

  

#### 📌Quiz

1. Which of the following is an example of a class?

   - A Car class that has a make and model, and that can be driven
   - A Flower class that has a scent
   - A Puppy class that has breed, weight and age, and taht can bark
   - A ShoppingCart class that has a cart size and cart value, and that can hold items
   - A Song class that has lyrics

2. Which of the following is a difference between a class and an instance?

   - You can think of a class as a blueprint and a instance as the actual " thing".
   - A class is like architectural plans for a bridge, and the Golden Gate bridge an instance of those plans.
   - You can create multiple instances from a class, but you can't create classes from instances.

3. For each of the following types of information, select whether it should be part of a class or an instance.

   - Information about properties shared by all "things" belonging to the class, such as number of sides, number of legs, or that it has a color.

     👉 Class

   - The specifics about a property, such as the specific color of a “thing” that can have a color.

     👉Instance

4. True or false? Every MainActivity class in Android must have a main() function.

   👉Flase

5. Which of the following is NOT a way for creating a comment in Kotlin?

   - Use // to turn the rest of a function into a comment.
   - Use /* to start a comment that is one line long.

6. Which of the following statements about a conditional statement is true?

   - A conditional statement is a way for you to set up a condition and ensure that code following it is only executed if that condition is met.
   - A conditional statement can be used within functions to return output based on conditions defined in that function.

7. What is a good reason for you to add comments to your code?

   - To explain to yourself or others why the code is written a certain way.
   - To structure code, like chapter headings in books.
   - To point out some part of the code that is very important.
   - To explain to other developers how to use your code for their own programs.

8. Which of the following are Kotlin data types?

   - IntRange
   - Int
   - Boolean (true or false)

9. Which of the following are valid keywords used in conditional statements in Kotlin?

   - if, else
   - when

