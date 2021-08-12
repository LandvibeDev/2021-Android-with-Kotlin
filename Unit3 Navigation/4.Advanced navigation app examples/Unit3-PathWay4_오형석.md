### Unit 3: Layouts

#### PATHWAY 4:Advanced navigation app examples

<hr/>

#### &#10004; Shared ViewModel

###### `ViewModel` 권장사항

`ViewModel`에서는 뷰 모델 데이터를 `public` 변수로 노출되지 않는 것이 좋음. 공개 변수로 노출하게 되면 앱 데이터가 외부 클래스에 의해 예상치 못한 방식을 수정될 수 있으며, 앱에서 처리할 것으로 예상하지 못한 극단적인 케이스가 발생할 수 있음. 대신 이러한 변경 가능한 속성을 `private`으로 만들고 지원 속성을 구현하며 필요한 경우 각 속성의 변경 불가능한 `public`버전을 노출.이름 지정 규칙은 변경 가능한 `private` 속성의 이름 앞에 밑줄(_)을 붙이는 것.

##### ViewModel을 사용하여 UI 업데이트

공유 뷰 모델 구현의 주요 차이점은 UI 컨트롤러에서 뷰 모델에 엑세스하는 방식. 프래그먼트 인스턴스 대신 활동 인스턴스를 사용. 

즉 뷰 모델을 여러 프래그먼트 간에 공유할 수 있음.

###### apply

`apply`는 범위함수임. 이 함수는 객체의 컨텍스트 내에서 코드 블록을 실행하며 임시 범위를 형성. 그러면 이 범위에서 이름을 사용하지 않고 객체에 액세스할 수 있음. `apply`의 일반적인 사용 사례는 객체를 구성하는 것. 이 함수 호출은 객체에 다음 할당 적용으로 읽을 수 있음.

###### SimpleDateForamat

`SimpleDateForamt`클래스는 언어에 민감한 방식으로 날짜 형식을 지정하고 파싱하는 클래스. 이 클래스를 통해 날짜의 형식 지정(날짜->텍스트)및 파싱(텍스트->날짜)이 가능함.

```SimpleDateFormat("E MMM d", Locale.getDefault())```

이렇게 패턴 문자열과 언어를 전달해 클래스의 인스턴스를 만들 수 있음.

`"E MMM d"`와 같은 패턴 문자열은 날짜 및 시간 형식의 표현입니다. `'A'`부터 `'Z'`까지, `'a'`부터 `'z'`까지의 문자는 날짜 또는 시간 문자열의 구성요소를 나타내는 패턴 문자로 해석됩니다. 예를 들어 `d`는 월의 일, `y`는 연도, `M`은 월을 나타냅니다. 날짜가 2018년 1월 4일이면 패턴 문자열 `"EEE, MMM d"`는 `"Wed, Jul 4"`로 파싱됩니다.

`Locale` 객체는 특정한 지리적, 정치적 또는 문화적 지역을 나타냅니다. 또한 언어/국가/변형 조합을 나타냅니다. 언어 객체는 지역의 규칙에 맞게 숫자 또는 날짜와 같은 정보의 표시를 변경하는 데 사용됩니다. 날짜 및 시간은 세계 각지에서 서로 다르게 작성되기 때문에 언어에 민감합니다. `Locale.getDefault()` 메서드를 사용하여 사용자의 기기에 설정된 언어 정보를 가져와서 `SimpleDateFormat` 생성자에 전달합니다.

상수`const`는 변경되지 않으며 컴파일 시간에 값이 알려짐.

###### elvis연산자

`?:` : 엘비스 연산자로 왼쪽의 표현식이 null이 아니면 이 값을 사용한다는 것을 의미. 왼쪽의 표현식이 null이면 elvis 연산자의 오른쪽에 있는 표현식을 사용

###### LifecycleOwner

LifecycleOwner는 활동이나 프래그먼트와 같이 안드로이드 수명 주기를 보유한 클래스.

###### Transformations.map()

`Transformations.map()`는 변환 함수 중 하나이며 이 메서드는 소스 `LiveData`및 함수를 매개변수로 사용. 이 함수는 `LiveData` 소스를 조작하고 관찰할 수도 있는 업데이트된 값을 반환.

LiveData 변환을 사용할 수 있는 몇 가지 실시간 예는 다음과 같습니다.

- 표시할 날짜 및 시간 문자열 형식 지정
- 항목 목록 정렬
- 항목 필터링 또는 그룹화
- 모든 항목 합계, 항목 수, 마지막 항목 반환 등과 같이 목록의 결과 계산



##### 작업

안드로이드에서 Activity은 작업 내에 존재. 런처 아이콘으로 앱을 처음 열면 안드로이드는 기본 Activity가 포함된 새로운 작업을 생성. 작업은 사용자가 이메일확인, 컵케이크 주문 생성, 사진 촬영 등의 특정한 일을 할때  상호작용하는 Activity의 모음.

Activity는 백 스팩이라는 스택으로 배열되며 사용자가 방문하는 각각의 새 활동은 작업의 백 스택으로 푸시됨. 스택 맨 위에 있는  Activity는 사용자가 현재 상호작용하고 있는 Activity다. 백 스택은 사용자가 뒤로 이동하는 경우 유용. 안드로이드는 스택 맨 위에 있는 현재 활동을 삭제하고 폐기한 후 그 아래에 있는 Activity를 다시 시작할 수 있음. 즉 스택에서 Activity를 팝하고 사용자가 상호작용 할 수 있게 잊너 활동이 포그라운드로 이동. 사용자가 여러 번 뒤로 이동하고 싶어하는 경우 안드로이드는 스택의 맨 아래에 더 가까워질 때까지 계속 스택 상단에서 활동을 팝. 백 스택에 더이상 Activity가 남아있지 않으면 사용자는 기기의 런쳐 화면이나 이 활동을 실행한 앱으로 돌아감.

##### 탐색 작업: popUpTo()속성

탐색 그래프의 탐색 작업에 `app:popUpTo()`속성을 포함하면 지정된 대상에 도달할 때까지 대상 두 개 이상이 백스택에서 팝 될 수 있음. `app:popUpTo="@id/startFragment"`를 지정하는 경우 스택에 남게 될 `StartFragment`에 도달할 때까지 백 스택에 있는 대상이 팝됨.



##### 탐색 작업: popUpToInclusive 속성

적절한 탐색 작업에 `app:popUpTo="@id/startFragment"` 및 `app:popUpToInclusive="true"`를 지정하면 됩니다. 이렇게 하면 백 스택에 새 `StartFragment` 인스턴스가 하나만 생성됩니다. 그런 다음 `StartFragment`에서 Back 버튼을 한 번 탭하면 앱이 종료됩니다. 

###### 서식인수

ex)

```kotlin
<string name="subtotal_price">Subtotal %s</string>
<string name="total_price">Total %s</string>
```

여기서 `%s`는 형식이 지정된 가격 문자열의 자리표시자

###### 수량 문자열

`plurals`리소스를 선언하면 수량에 따라 사용할 다른 문자열 리소스(예: 단수형 또는 복수형)를 지정할 수 있음.

```kotlin
<plurals name="cupcakes">
    <item quantity="one">%d cupcake</item>
    <item quantity="other">%d cupcakes</item>
</plurals>
```

단수(`quantity="one"`)인 경우 단수형 문자열이 사용됩니다. 다른 모든 경우에는(`quantity="other"`) 복수형 문자열이 사용됩니다. 문자열 인수가 필요한 `%s` 대신 `%d`에는 정수 인수가 필요하며, 인수는 문자열의 형식을 지정할 때 전달됩니다.

`getQuantityString(R.string.cupcakes, 1, 1)` 호출 시 문자열 `1 cupcake` 반환

`getQuantityString(R.string.cupcakes, 6, 6)` 호출 시 문자열 `6 cupcakes` 반환

`getQuantityString(R.string.cupcakes, 0, 0)` 호출 시 문자열 `0 cupcakes` 반환

<hr/>

##### Quiz

1. 참 또는 거짓: 여러 활동 또는 프래그먼트에 동일한 ViewModel을 사용하여 데이터를 공유할 수 있습니다.

- True

2. Kotin 속성 위임 접근법을 사용하여 공유 뷰 모델에 액세스할 수 있는 올바른 방법은 무엇인가요?

- `val viewModel: OrderViewModel by activityViewModels()`

3. 빈 칸 채우기

- LiveData Transformations 을(를) 사용하여 다른 인스턴스의 값에 따라 다양한 LiveData 인스턴스를 반환합니다.

4. 객체를 구성하는 데 Kotlin의 `apply` 함수를 사용하려면 어떻게 해야 하나요?

- 객체에 할당 세트를 적용할 수 있습니다.

5. 데이터 결합 레이아웃 표현식을 사용할 때 클릭 리스너를 결합하기 위해 이 레이아웃의 버튼에 속성을 추가하는 올바른 구문은 무엇인가요?

- ```kotlin
  android:onClick="@{() -> detailFragment.next()}"
  ```

