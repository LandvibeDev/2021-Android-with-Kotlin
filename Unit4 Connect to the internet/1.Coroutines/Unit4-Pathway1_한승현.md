# Pathway 1. Coroutines

# Unit4-Pathway1

- **Coroutine μκ°**
    
    <aside>
    π‘ μ€λ λμ κ΄ν΄, κ·Έλ¦¬κ³  μ½λ£¨ν΄μ΄λΌλ Kotlin κΈ°λ₯μ μ¬μ©νμ¬ λͺνν λΉμ°¨λ¨ λμ μ€ν μ½λλ₯Ό μμ±νλ λ°©λ²μ μμλ³΄μ.
    
    </aside>
    
    - **νμ΅ν  λ΄μ©**
        - λμ μ€νμ μ μμ λμ μ€νμ΄ μ€μν μ΄μ 
        - μ½λ£¨ν΄κ³Ό μ€λ λλ₯Ό μ¬μ©νμ¬ λΉμ°¨λ¨ λμ μ€ν μ½λλ₯Ό μμ±νλ λ°©λ²
        - λ°±κ·ΈλΌμ΄λμμ μμμ μ€νν  λ κΈ°λ³Έ μ€λ λμ μ‘μΈμ€νμ¬ UI μλ°μ΄νΈλ₯Ό μμ νκ² μ€ννλ λ°©λ²
        - λ€λ₯Έ λμ μ€ν ν¨ν΄(Scope/Dispatchers/Deffered)μ μ¬μ© λ°©λ²κ³Ό μ¬μ© μκΈ°
        - λ€νΈμν¬ λ¦¬μμ€μ μνΈμμ©νλ μ½λλ₯Ό μμ±νλ λ°©λ²
    - **λ©ν°μ€λ λ© λ° λμ μ€ν**
        - λμ μ€νμ ν΅ν΄ μ¬λ¬ μ½λ λ¨μλ₯Ό μμμ λ§μ§ μκ±°λ λ³λ ¬λ‘ μ€νν  μ μμ΄ λ¦¬μμ€ μ¬μ©μ ν¨μ¨μ±μ΄ λμμ§λ€.
        - μ΄μμ²΄μ λ μμ€ν, νλ‘κ·Έλλ° μΈμ΄, λμ μ€ν λ¨μμ νΉμ±μ μ¬μ©νμ¬ λ©ν°νμ€νΉμ κ΄λ¦¬ν  μ μλ€.
            
            ![Untitled](Pathway%201%20%20ccd46/Untitled.png)
            
        - λμ μ€νμ μ¬μ©ν΄μΌ νλ μ΄μ ?
            - μ±μ΄ μ μ  λ³΅μ‘ν΄μ§μ λ°λΌ μ½λκ° μ°¨λ¨λμ§ μλ κ²μ΄ μ€μνλ€.
            - λ€νΈμν¬ μμ²­κ³Ό κ°μ μ₯κΈ° μ€ν μμμ μ€ννλλΌλ μ±μμ λ€λ₯Έ μμμ μ€νμ΄ μ€μ§λμ§ μλλ€.
            - λμ μ€νμ μ¬λ°λ₯΄κ² κ΅¬ννμ§ μμΌλ©΄, μ±μ΄ μ¬μ©μμκ² μλ΅νμ§ μλ κ²μΌλ‘ λ³΄μΌ μ μλ€.
        - μ€λ λλ νλ‘κ·Έλ¨ λ²μ λ΄μμ μμ½νκ³  μ€νν  μ μλ μ½λμ μ΅μ λ¨μμ΄λ€.
        - μλμ κ°μ΄ λλ€λ₯Ό μ κ³΅νμ¬ κ°λ¨ν μ€λ λλ₯Ό λ§λ€ μ μλ€.
            
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
            
    - **μ¬λ¬ μ€λ λ λ§λ€κΈ° λ° μ€ν**
        - κ°λ¨ν λμ μ€νμ λ³΄μ¬μ£ΌκΈ° μν΄, μ€νν  μ€λ λλ₯Ό λͺ κ°μ§ λ§λ€μ΄λ³΄μ.
            
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
            
        - μΆλ ₯μ΄ λ€μνκ² νμλλ€. μ΄λ€ λλ μ€λ λκ° μμλλ‘ μ€νλλ κ²μ²λΌ λ³΄μ΄κ³ , μ΄λ€ λλ μ½νμΈ κ° μ¬κΈ°μ κΈ° ν©μ΄μ Έμλ€.
    - **λ§μ λ¦¬μμ€κ° νμν μ€λ λ**
        - μ€λ λλ₯Ό λ§λ€κ³  μ ννκ³  κ΄λ¦¬νλ λ°λ λμμ κ΄λ¦¬ν  μ μλ μμ μ€λ λ μλ₯Ό μ ννλ μμ€ν λ¦¬μμ€μ μκ°μ΄ μ¬μ©λλ€.
        - κΈ°λ³Έ μ€λ λλ μ±μ UI μ€νμ λ΄λΉνλ―λ‘ κΈ°λ³Έ μ€λ λκ° μ±μ΄ μννκ² μ€νλλλ‘ μ±λ₯ κΈ°μ€μ λ§λ κ²μ΄ μ€μνλ€.
        - μ₯κΈ° μ€ν μμμ μλ£λ  λκΉμ§ κΈ°λ³Έ μ€λ λλ₯Ό μ°¨λ¨νμ¬ μ±μ΄ μλ΅νμ§ μλ μμΈμ΄ λλ€.
    - **κ²½ν© μν λ° μμΈ‘ν  μ μλ λμ**
        - μ€λ λλ νλ‘μΈμκ° μ΄λ»κ² ν λ²μ μ¬λ¬ μμμ μ²λ¦¬νλ κ²μ²λΌ λ³΄μ΄λμ§μ κ΄ν μΆμνμ΄λ€.
        - νλ‘μΈμκ° μ¬λ¬ μ€λ λμ λͺλ Ήμ΄ μ§ν© κ°μ μ νλ  λ μ€λ λκ° μ€νλλ μ νν μκ°κ³Ό μ€λ λκ° μΌμμ€μ§λλ μμ μ κ°λ°μκ° **μ μ΄ν  μ μλ€**.
            
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
            
        - μ½λκ° μλν κ²κ³Ό μ€μ  μΆλ ₯ κ²°κ³Όλ λ€λ₯Ό μ μλ€.
        - μ¬λ¬ μ€λ λκ° λμμ λ©λͺ¨λ¦¬μ λμΌν κ°μ μ‘μΈμ€νλ €κ³  ν  λ, κ²½ν© μνκ° λ°μν  μ μλ€.
        - **μ€λ λ λμ  λμ μ€ν μ½λ μμ±μ λμμ΄ λλ μ½λ£¨ν΄μ΄λΌλ Kotlinμ κΈ°λ₯μ λν΄ μμλ³΄μ.**
    - **Kotlinμ μ½λ£¨ν΄**
        - μ½λ£¨ν΄μ λ©ν°νμ€νΉμ μ§μνμ§λ§ λ¨μν μ€λ λλ‘ μμνλ κ²λ³΄λ€ λ€λ₯Έ μμ€μ μΆμνλ₯Ό μ κ³΅νλ€.
        - μ½λ£¨ν΄μ μ£Όμ κΈ°λ₯ μ€ νλλ **μνλ₯Ό μ μ₯νμ¬ μ€λ¨νλ€κ° μ¬κ°ν  μ μλ€λ κ²**μ΄λ€.
        - μ½λ£¨ν΄μ μ€νλκ±°λ μ€νλμ§ μμ μ μλ€.
        - **νλ ₯ν λ©ν°νμ€νΉ**
            - μ°μμΌλ‘ νμλλ μνλ₯Ό ν΅ν΄ μ½λ μΌλΆκ° μ μ΄κΆμ λκ²¨μ£Όκ±°λ μ¬κ°λκΈ° μ μ λ€λ₯Έ μ½λ£¨ν΄μ΄ μμμ μλ£ν  λκΉμ§ κΈ°λ€λ €μΌ νλ μκΈ°λ₯Ό λνλΌ μ μλ€.
            - μ½λ£¨ν΄ κ΅¬νμ λ©ν°νμ€νΉμ μ§μνλ μ¬λ¬ κΈ°λ₯μ μΆκ°νλ€.
            - μ°μ μΈμλ μ½λ£¨ν΄μ λ§λλ κ²μλ `CoroutineScope` λ΄μμ μλͺ μ£ΌκΈ°κ° μλ μ·¨μ κ°λ₯ν μμ λ¨μμΈ `Job` μ΄ ν¬ν¨λλ€.
            - `CoroutineScope` λ νμ μμμ κ·Έ νμ μμμ μ·¨μ λ° κΈ°ν κ·μΉμ λ°λ³΅μ μΌλ‘ μ μ©νλ contextμ΄λ€.
            - `Dispatcher` λ μ½λ£¨ν΄μ΄ μ€νμ μ¬μ©ν  μ§μ μ€λ λλ₯Ό κ΄λ¦¬νλ―λ‘ κ°λ°μκ° μ μ€λ λλ₯Ό μ¬μ©ν  μκΈ°μ μμΉλ₯Ό νμνμ§ μμλ λλ€.
            
            | Job | μ·¨μ κ°λ₯ν μμ λ¨μ(ex: launch() ν¨μλ‘ λ§λ  μμ λ¨μ)μ΄λ€. |
            | --- | --- |
            | CoroutineScope | launch() λ° async()μ κ°μ μ μ½λ£¨ν΄μ λ§λλ λ° μ¬μ©λλ ν¨μλ CoroutineScopeλ₯Ό νμ₯νλ€. |
            | Dispatcher | μ½λ£¨ν΄μ΄ μ¬μ©ν  μ€λ λλ₯Ό κ²°μ νλ€. Main Dispatcherλ ν­μ κΈ°λ³Έ μ€λ λμμ μ½λ£¨ν΄μ μ€ννμ§λ§ Defaultλ IO, Unconfinedμ κ°μ Dispatcherλ λ€λ₯Έ μ€λ λλ₯Ό μ¬μ©νλ€. |
            - `launch()` ν¨μλ μ·¨μ κ°λ₯ν Job κ°μ²΄μ λνλ λ«ν μ½λμμ μ½λ£¨ν΄μ λ§λ λ€. `launch()` λ λ°ν κ°μ΄ μ½λ£¨ν΄μ λ²μ λ°μμ νμνμ§ μμ λ μ¬μ©λλ€.
            - `launch()` μ μ μ²΄ μκ·Έλμ²
                
                ```kotlin
                fun CoroutineScope.launch {
                    context: CoroutineContext = EmptyCoroutineContext,
                    start: CoroutineStart = CoroutineStart.DEFAULT,
                    block: suspend CoroutineScope.() -> Unit
                }
                ```
                
                - μ€μ λ‘ κ°λ°μκ° μ€νμ μν΄ μ λ¬ν μ½λ λΈλ‘μ `suspend` ν€μλλ‘ νμλλ€. suspendλ μ½λ λλ ν¨μ λΈλ‘μ΄ μΌμμ€μ§λκ±°λ μ¬κ°λ  μ μμμ μλ―Ένλ€.
        - **runBlocking**
            - μ μ½λ£¨ν΄μ μμνκ³  μλ£λ  λκΉμ§ νμ¬ μ€λ λλ₯Ό μ°¨λ¨νλ `runBlocking()` μ΄ μλ€.
            - μ£Όλ‘ κΈ°λ³Έ ν¨μμ νμ€νΈμμ μ°¨λ¨ μ½λμ λΉμ°¨λ¨ μ½λ μ¬μ΄λ₯Ό μ°κ²°νλ λ° μ¬μ©λλ©°, μΌλ°μ μΈ Android μ½λμμλ μμ£Ό μ¬μ©νμ§ μλλ€.
            - `async()` ν¨μλ `Deferred` μ νμ κ°μ λ°ννλ€. `Deferred` λ λ―Έλ κ° μ°Έμ‘°λ₯Ό λ³΄μ ν  μ μλ μ·¨μ κ°λ₯ν `Job` μ΄λ€. `Deferred` λ₯Ό μ¬μ©νλ©΄ μ¦μ κ°μ λ°ννλ κ²μ²λΌ ν¨μλ₯Ό κ³μ νΈμΆν  μ μλ€.
            - `Deferred` λ μλ¦¬ νμμ μ­ν λ§ νλ€. λΉλκΈ° μμμ΄ μΈμ  λ°νλ μ§ νμ€ν μ μ μκΈ° λλ¬Έμ΄λ€. `Deferred` λ λμ€μ μ΄ κ°μ²΄μ κ°μ΄ λ°νλλ€κ³  λ³΄μ₯νλ€. λ°λ©΄ λΉλκΈ° μμμ κΈ°λ³Έμ μΌλ‘ μ€νμ μ°¨λ¨νκ±°λ κΈ°λ€λ¦¬μ§ μλλ€. νμ¬ μ½λ μ€μ΄ `Deferred` μ μΆλ ₯μ κΈ°λ€λ¦¬λλ‘ νλ €λ©΄ μ½λμμ `await()` μ νΈμΆνλ©΄ λλ€. κ·Έλ¬λ©΄ μμ κ°μ΄ λ°νλλ€.
            - `async()` μ μ μ²΄ μκ·Έλμ²
                
                ```kotlin
                Fun CoroutineScope.async() {
                    context: CoroutineContext = EmptyCoroutineContext,
                    start: CoroutineStart = CoroutineStart.DEFAULT,
                    block: suspend CoroutineScope.() -> T
                }: Deferred<T>
                ```
                
        - **suspendλ‘ νμνλ μκΈ°**
            - ν¨μκ° λ λ€λ₯Έ `suspend` ν¨μλ₯Ό νΈμΆνλ©΄ μΈμ λ μ§ κ·Έ ν¨μλ `suspend` ν¨μμ¬μΌ νλ€.
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
    4. **True or False: If a function already calls aΒ `suspend`Β function, then it does not need to be marked as a suspend function itself.**
        - **False**
    5. **Which of the following areΒ `suspend`Β functions?**
        - `async()`
        - **The lambda passed intoΒ `async()`**
        - `runBlocking()`
        - **The lambda passed intoΒ `runBlocking()`**
    6. **Which of the following are false aboutΒ `async()`Β andΒ `runBlocking()`?**
        - Both functions take a CoroutineScope (aΒ `suspend`Β function) as a parameter.
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
        
    10. **True or False: AΒ `Job`Β is a cancelable unit of work performed by a coroutine.**
        - **True**