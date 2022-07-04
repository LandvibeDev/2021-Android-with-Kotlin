# Pathway 1. Coroutines

# Unit4-Pathway1

- **Coroutine 소개**
    
    <aside>
    💡 스레드에 관해, 그리고 코루틴이라는 Kotlin 기능을 사용하여 명확한 비차단 동시 실행 코드를 작성하는 방법을 알아보자.
    
    </aside>
    
    - **학습할 내용**
        - 동시 실행의 정의와 동시 실행이 중요한 이유
        - 코루틴과 스레드를 사용하여 비차단 동시 실행 코드를 작성하는 방법
        - 백그라운드에서 작업을 실행할 때 기본 스레드에 액세스하여 UI 업데이트를 안전하게 실행하는 방법
        - 다른 동시 실행 패턴(Scope/Dispatchers/Deffered)의 사용 방법과 사용 시기
        - 네트워크 리소스와 상호작용하는 코드를 작성하는 방법
    - **멀티스레딩 및 동시 실행**
        - 동시 실행을 통해 여러 코드 단위를 순서에 맞지 않거나 병렬로 실행할 수 있어 리소스 사용의 효율성이 높아진다.
        - 운영체제는 시스템, 프로그래밍 언어, 동시 실행 단위의 특성을 사용하여 멀티태스킹을 관리할 수 있다.
            
            ![Untitled](Pathway%201%20%20ccd46/Untitled.png)
            
        - 동시 실행을 사용해야 하는 이유?
            - 앱이 점점 복잡해짐에 따라 코드가 차단되지 않는 것이 중요하다.
            - 네트워크 요청과 같은 장기 실행 작업을 실행하더라도 앱에서 다른 작업의 실행이 중지되지 않는다.
            - 동시 실행을 올바르게 구현하지 않으면, 앱이 사용자에게 응답하지 않는 것으로 보일 수 있다.
        - 스레드는 프로그램 범위 내에서 예약하고 실행할 수 있는 코드의 최소 단위이다.
        - 아래와 같이 람다를 제공하여 간단한 스레드를 만들 수 있다.
            
            ```kotlin
            fun main() {
                val thread = Thread {
                    println("${Thread.currentThread()} has run.")
                }
                thread.start()
            }
            ```
            
            ```kotlin
            Thread[Thread-0,5,main] has run.
            ```
            
    - **여러 스레드 만들기 및 실행**
        - 간단한 동시 실행을 보여주기 위해, 실행할 스레드를 몇 가지 만들어보자.
            
            ```kotlin
            fun main() {
               val states = arrayOf("Starting", "Doing Task 1", "Doing Task 2", "Ending")
               repeat(3) {
                   Thread {
                       println("${Thread.currentThread()} has started")
                       for (i in states) {
                           println("${Thread.currentThread()} - $i")
                           Thread.sleep(50)
                       }
                   }.start()
               }
            }
            ```
            
        - 출력이 다양하게 표시된다. 어떤 때는 스레드가 순서대로 실행되는 것처럼 보이고, 어떤 때는 콘텐츠가 여기저기 흩어져있다.
    - **많은 리소스가 필요한 스레드**
        - 스레드를 만들고 전환하고 관리하는 데는 동시에 관리할 수 있는 원시 스레드 수를 제한하는 시스템 리소스와 시간이 사용된다.
        - 기본 스레드는 앱의 UI 실행을 담당하므로 기본 스레드가 앱이 원활하게 실행되도록 성능 기준에 맞는 것이 중요하다.
        - 장기 실행 작업은 완료될 때까지 기본 스레드를 차단하여 앱이 응답하지 않는 원인이 된다.
    - **경합 상태 및 예측할 수 없는 동작**
        - 스레드는 프로세서가 어떻게 한 번에 여러 작업을 처리하는 것처럼 보이는지에 관한 추상화이다.
        - 프로세서가 여러 스레드의 명령어 집합 간에 전환될 때 스레드가 실행되는 정확한 시간과 스레드가 일시중지되는 시점은 개발자가 **제어할 수 없다**.
            
            ```kotlin
            fun main() {
               var count = 0
               for (i in 1..50) {
                   Thread {
                       count += 1
                       println("Thread: $i count: $count")
                   }.start()
               }
            }
            ```
            
            ```kotlin
            Thread: 50 count: 50 Thread: 1 count: 1
            Thread: 2 count: 2
            Thread: 3 count: 3
            Thread: 4 count: 4
            Thread: 7 count: 5
            Thread: 9 count: 6
            Thread: 8 count: 7
            Thread: 5 count: 8
            Thread: 11 count: 9
            Thread: 12 count: 10
            Thread: 10 count: 11
            Thread: 13 count: 12
            Thread: 6 count: 13
            Thread: 14 count: 14
            Thread: 15 count: 15
            Thread: 16 count: 16
            Thread: 19 count: 17
            Thread: 20 count: 18
            Thread: 21 count: 19
            Thread: 18 count: 20
            Thread: 17 count: 21
            Thread: 23 count: 22
            Thread: 24 count: 23
            Thread: 22 count: 24
            Thread: 25 count: 25
            Thread: 26 count: 26
            Thread: 28 count: 27
            Thread: 30 count: 28
            Thread: 29 count: 29
            Thread: 31 count: 30
            Thread: 32 count: 31
            Thread: 27 count: 32
            Thread: 34 count: 35
            Thread: 33 count: 35
            Thread: 35 count: 35
            Thread: 36 count: 36
            Thread: 37 count: 37
            Thread: 41 count: 39
            Thread: 40 count: 39
            Thread: 38 count: 40
            Thread: 42 count: 41
            Thread: 39 count: 42
            Thread: 43 count: 43
            Thread: 44 count: 44
            Thread: 45 count: 45
            Thread: 46 count: 46
            Thread: 47 count: 47
            Thread: 49 count: 48
            Thread: 48 count: 49
            ```
            
        - 코드가 의도한 것과 실제 출력 결과는 다를 수 있다.
        - 여러 스레드가 동시에 메모리의 동일한 값에 액세스하려고 할 때, 경합 상태가 발생할 수 있다.
        - **스레드 대신 동시 실행 코드 작성에 도움이 되는 코루틴이라는 Kotlin의 기능에 대해 알아보자.**
    - **Kotlin의 코루틴**
        - 코루틴은 멀티태스킹을 지원하지만 단순히 스레드로 작업하는 것보다 다른 수준의 추상화를 제공한다.
        - 코루틴의 주요 기능 중 하나는 **상태를 저장하여 중단했다가 재개할 수 있다는 것**이다.
        - 코루틴은 실행되거나 실행되지 않을 수 있다.
        - **협력형 멀티태스킹**
            - 연속으로 표시되는 상태를 통해 코드 일부가 제어권을 넘겨주거나 재개되기 전에 다른 코루틴이 작업을 완료할 때까지 기다려야 하는 시기를 나타낼 수 있다.
            - 코루틴 구현은 멀티태스킹을 지원하는 여러 기능을 추가한다.
            - 연속 외에도 코루틴을 만드는 것에는 `CoroutineScope` 내에서 수명 주기가 있는 취소 가능한 작업 단위인 `Job` 이 포함된다.
            - `CoroutineScope` 는 하위 요소와 그 하위 요소에 취소 및 기타 규칙을 반복적으로 적용하는 context이다.
            - `Dispatcher` 는 코루틴이 실행에 사용할 지원 스레드를 관리하므로 개발자가 새 스레드를 사용할 시기와 위치를 파악하지 않아도 된다.
            
            | Job | 취소 가능한 작업 단위(ex: launch() 함수로 만든 작업 단위)이다. |
            | --- | --- |
            | CoroutineScope | launch() 및 async()와 같은 새 코루틴을 만드는 데 사용되는 함수는 CoroutineScope를 확장한다. |
            | Dispatcher | 코루틴이 사용할 스레드를 결정한다. Main Dispatcher는 항상 기본 스레드에서 코루틴을 실행하지만 Default나 IO, Unconfined와 같은 Dispatcher는 다른 스레드를 사용한다. |
            - `launch()` 함수는 취소 가능한 Job 객체에 래핑된 닫힌 코드에서 코루틴을 만든다. `launch()` 는 반환 값이 코루틴의 범위 밖에서 필요하지 않을 때 사용된다.
            - `launch()` 의 전체 시그니처
                
                ```kotlin
                fun CoroutineScope.launch {
                    context: CoroutineContext = EmptyCoroutineContext,
                    start: CoroutineStart = CoroutineStart.DEFAULT,
                    block: suspend CoroutineScope.() -> Unit
                }
                ```
                
                - 실제로 개발자가 실행을 위해 전달한 코드 블록은 `suspend` 키워드로 표시된다. suspend는 코드 또는 함수 블록이 일시중지되거나 재개될 수 있음을 의미한다.
        - **runBlocking**
            - 새 코루틴을 시작하고 완료될 때까지 현재 스레드를 차단하는 `runBlocking()` 이 있다.
            - 주로 기본 함수와 테스트에서 차단 코드와 비차단 코드 사이를 연결하는 데 사용되며, 일반적인 Android 코드에서는 자주 사용하지 않는다.
            - `async()` 함수는 `Deferred` 유형의 값을 반환한다. `Deferred` 는 미래 값 참조를 보유할 수 있는 취소 가능한 `Job` 이다. `Deferred` 를 사용하면 즉시 값을 반환하는 것처럼 함수를 계속 호출할 수 있다.
            - `Deferred` 는 자리 표시자 역할만 한다. 비동기 작업이 언제 반환될지 확실히 알 수 없기 때문이다. `Deferred` 는 나중에 이 객체에 값이 반환된다고 보장한다. 반면 비동기 작업은 기본적으로 실행을 차단하거나 기다리지 않는다. 현재 코드 줄이 `Deferred` 의 출력을 기다리도록 하려면 코드에서 `await()` 을 호출하면 된다. 그러면 원시 값이 반환된다.
            - `async()` 의 전체 시그니처
                
                ```kotlin
                Fun CoroutineScope.async() {
                    context: CoroutineContext = EmptyCoroutineContext,
                    start: CoroutineStart = CoroutineStart.DEFAULT,
                    block: suspend CoroutineScope.() -> T
                }: Deferred<T>
                ```
                
        - **suspend로 표시하는 시기**
            - 함수가 또 다른 `suspend` 함수를 호출하면 언제든지 그 함수는 `suspend` 함수여야 한다.
- **Quiz**
    1. **Fill-in-the-blanks**
        
        *Enter one or more words to complete the sentence**.***
        
        **The `main` thread, sometimes called the UI thread, is responsible for updating the screen in an Android app.**
        
    2. **Which of the following are some of the pitfalls of directly using threads in your code?**
        - **Race Condition**
        - **Inconsistent output**
        - **Unresponsive UI**
        - `Thread` is deprecated
    3. **Which of the following is true about coroutines?**
        - Once started, a coroutine cannot be canceled.
        - A coroutine always runs on the main thread.
        - **A coroutine may or may not execute.**
        - Coroutines avoid the need to create new threads, by running every task on the same thread.
    4. **True or False: If a function already calls a `suspend` function, then it does not need to be marked as a suspend function itself.**
        - **False**
    5. **Which of the following are `suspend` functions?**
        - `async()`
        - **The lambda passed into `async()`**
        - `runBlocking()`
        - **The lambda passed into `runBlocking()`**
    6. **Which of the following are false about `async()` and `runBlocking()`?**
        - Both functions take a CoroutineScope (a `suspend` function) as a parameter.
        - **Both functions return a Deferred**
        - You'll typically not use runBlocking in Android app code.
        - When using async, you need to use await() to access the returned value.
    7. **True or False: In most apps, you would create coroutines using the global scope.**
        - **False**
    8. **What is responsible for determining which thread is used behind the scenes by a coroutine?**
        - `CoroutineScope`
        - **`Dispatcher`**
        - `Job`
        - `GlobalScope`
    9. **Fill-in-the-blanks**
        
        *Enter one or more words to complete the sentence.*
        
        **A `Deferred` is similar to a promise or future in other languages and serves as a placeholder for a return value.**
        
    10. **True or False: A `Job` is a cancelable unit of work performed by a coroutine.**
        - **True**