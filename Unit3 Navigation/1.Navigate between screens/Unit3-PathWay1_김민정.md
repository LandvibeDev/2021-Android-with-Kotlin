## 2021 Landvibe Summer Coding - Android

### π Android Basics In Kotlin

#### π Unit3: Navigation

#### π PathWay1: Navigate between screens

<hr>

##### μ»¬λ μ

: λ¨μ΄ λͺ©λ‘μ΄λ μ§μ κΈ°λ‘ λͺ¨μκ³Ό κ°μ κ΄λ ¨ ν­λͺ© κ·Έλ£Ή

ππ» ν­λͺ©μ μμκ° μ§μ λκ±°λ μ§μ λμ§ μμ μ μμΌλ©° κ³ μ νκ±°λ κ³ μ νμ§ μμ μ μμ

ππ» μ»¬λ μμ ν μ ν: λͺ©λ‘ /λͺ©λ‘μ ν­λͺ©μλ μμκ° μμ§λ§ ν­λͺ©μ΄ κ³ μ ν  νμX

ππ» μ»¬λ μμ ν μ ν: μ§ν©



##### μ§ν©

: λͺ©λ‘κ³Ό λ¬λ¦¬ μ€λ³΅λ  μ μμΌλ©° μμλ μ€μνμ§ μμ

ππ» contains(): ν¨μλ₯Ό μ¬μ©νμ¬ νΉμ  ν­λͺ©μ΄ μ§ν©μ μνλμ§ μ¬λΆ νμΈ



##### λ§΅

: νΉμ  ν€κ° λΆμ¬λ κ°μ μ½κ² μ°Ύμ μ μλλ‘ μ€κ³λ *ν€-κ° μ*μ μ§ν©

(ν€λ κ³ μ νλ©° κ° ν€λ μ νν νλμ κ°μ λ§€νλμ§λ§, κ°μ μ€λ³΅λ  μ μμ

/ν€λ ν΄λΉνλ κ°μ 'λ§€ν'λ¨)

```kotlin
fun main() {
    val peopleAges = mutableMapOf<String, Int>(
        "Fred" to 30,
        "Ann" to 23
    )
    peopleAges.put("Barbara", 42)
    peopleAges["Joe"] = 51
    println(peopleAges)
}
```



ππ» forEach(): λͺ¨λ  ν­λͺ©μ νμν ν ν­λͺ©λ³λ‘ μμμ μ€ν

```kotlin
peopleAges.forEach { print("${it.key} is ${it.value}, ") }
```

ππ» map(): μ»¬λ μμ κ° ν­λͺ©μ λ³ν

```kotlin
println(peopleAges.map { "${it.key} is ${it.value}" }.joinToString(", ") )
```

 ππ» filter(): μ»¬λ μμμ ννμμ κΈ°λ°μΌλ‘ μΌμΉνλ ν­λͺ©μ λ°ν

```kotlin
val filteredNames = peopleAges.filter { it.key.length < 4 }
```



##### λλ€

: μ΄λ¦μ΄ μμΌλ©° κ³§λ°λ‘ ννμμΌλ‘ μ¬μ©ν  μ μλ ν¨μ

<img src="img/Unit3-Pathway1-1_minjeong.png">

ππ» νΉμ μλ³μ `it` μ¬μ©

```kotlin
val triple: (Int) -> Int = { it * 3 }
```



##### κ³ μ°¨ν¨μ

: λλ€λ₯Ό λ€λ₯Έ ν¨μλ‘ μ λ¬νκ±°λ λ€λ₯Έ ν¨μμμ ν¨μλ₯Ό λ°ννλ κ²

ππ» μμ: `map`, `filter`, `forEach` ν¨μλ λͺ¨λ λ§€κ°λ³μλ‘ ν¨μλ₯Ό μ¬μ©!

ππ» λλ€λ₯Ό `sortedWith()` λ©μλμ μ λ¬νμ¬ μμ±ν  μ μμ!

```kotlin
println(peopleNames.sortedWith { str1: String, str2: String -> str1.length - str2.length })
```



##### μΈννΈ

: μμμ  μΈννΈ(κ΅¬μ²΄μ , μ ννκ² μλ €μ€) / λͺμμ  μΈννΈ(μΆμμ , νμ νμ)

ππ» μμμ : νΉμ  μμ(λ§ν¬μ΄κΈ°, μ΄λ―Έμ§ κ³΅μ )μ μμ/μμ€νμ΄ μΈννΈ μ²λ¦¬ λ°©λ²μ κ²°μ νλλ‘ ν¨

ππ» λͺμμ : μ±μ νΉμ  νλμΌλ‘ μ΄λνλ λ° μ¬μ©

ππ» μ€ν

	1. μ»¨νμ€νΈ μ°Έμ‘° κ°μ Έμ€κΈ°
	2. λͺ/μμμ μ λ°λΌ νλorμΈννΈ μ νμ μ κ³΅νλ `Intent`κ°μ²΄ λ§λ€κΈ°
	3. `putExtra()` νΈμΆνμ¬ νμν λ°μ΄ν° μ λ¬
	4. `intent`κ°μ²΄λ₯Ό μ λ¬νλ `startActivity()`νΈμΆ



π [ λ¨μ΄μ₯ - μλ£¨μμ½λ](https://github.com/google-developer-training/android-basics-kotlin-words-app/tree/activities)



##### νλ μλͺμ£ΌκΈ°

: νλμ΄ μ²μ μ΄κΈ°νλ  λλΆν° λ§μ§λ§μΌλ‘ μλ©Έλμ΄ μμ€νμμ λ©λͺ¨λ¦¬λ₯Ό νμν  λκΉμ§ νλμ΄ κ±°μ³ κ° μ μλ μ¬λ¬ μνλ‘ κ΅¬μ±λ¨

<img src="img/Unit3-Pathway1-2_minjeong.png" height="600">

ππ» `Activity` ν΄λ΄μ€μμ μ¬μ μν  μ μλ μ½λ°± λ©μλ μ‘΄μ¬: `onCreate()` `onStart()` `onPause()` `onRestart()` `onResume()` `onStop()` `onDestroy()`

1λ¨κ³: onCreate() λ©μλ νμΈ λ° λ‘κΉ μΆκ° 

2λ¨κ³: onStart() λ©μλ κ΅¬ν 

3λ¨κ³: λ λ§μ λ‘κ·Έ κ΅¬λ¬Έ μΆκ° 

`onCreate()` ->μ± λ§λ λ€

`onStart()` ->νλμ μμνκ³  νλ©΄μ νμλκ² νλ€

`onResume() `->νλ ν¬κ±°μ€λ₯Ό μ κ³΅ & μ¬μ©μκ° μνΈμμ©ν  μ μλλ‘ νλ μ€λΉ (λ€μ μμν  λμμ΄ μμ΄λ μμ μ νΈμΆ)

ππ» μλͺ μ£ΌκΈ° μ¬μ© μ¬λ‘

1. νλ μ΄κΈ° λ° λ«κΈ°
2. νλμμ μ΄λ λ° νλμΌλ‘ λ€μ μ΄λ
3. λΆλΆμ μΌλ‘ νλ μ¨κΈ°κΈ°



##### κ΅¬μ± λ³κ²½

: κΈ°κΈ° μνκ° λ§€μ° κΈκ²©νκ² λ³κ²½λμ΄ μμ€νμ΄ λ³κ²½μ¬ν­μ νμΈνλ κ°μ₯ μ¬μ΄ λ°©λ²μ΄ νλμ μμ ν μ’λ£νκ³  λ€μ λΉλνλ κ²μΌ λ λ°μ

ππ» κΈ°κΈ° νμ  μ λ°μ΄ν° μμ€

ππ» `onSaveInstanceState()`λ₯Ό μ¬μ©νμ¬ λ²λ€ λ°μ΄ν° μ μ₯

ππ» `onCreate()`λ₯Ό μ¬μ©νμ¬ λ²λ€ λ°μ΄ν° λ³΅μ



##### ν΄μ¦

1. Which of the following is false about collections and higher order functions in Kotlin?

   > Lists are unordered, while maps and sets are ordered data types.

2. Given the following code, what is the result of `oneWordCities[1]`?

   ```kotlin
   val cities = listOf("Jeddah", "Bengaluru", "Shenzhen", "Abu Dhabi", "Mountain View", "Tripoli", "Bengaluru", "Lima", "Mandalay", "Tripoli")
   val oneWordCities = cities.toSet().toList().filter { !it.contains(" ")}.sorted()
   ```

   > Jeddah

3. λΉ μΉΈ μ±μ°κΈ°

   > A(n) `extra` is a piece of data passed between activities when launching an intent.

4. If you open an app, and then leave the app using the back button, in which order were the following activity lifecycle methods called?

   ```kotlin
   onCreate(), onStart(), onStop(), onDestroy()
   ```

5. Which activity lifecycle method would be called if a dialog appears onscreen, partially obscuring an activity?

   > `onPause()` because the activity is still displayed, but no longer has focus.

6. Which of the following is true about the lifecycle of a single activity?

   > `onStart()` can be called multiple times, while `onCreate()` can only be called once.

   > `onResume()` is called when the activity gains focus.

7. Which of the following is false about intents?

   > An implicit intent always results in the system asking the user which app to open.

8. An activity contains the following code in `onCreate()`. What will happen when this code is executed, if the `intent` property is `null`?

   ```kotlin
   val message = intent.extras?.getString("message"
   ).toString()
   ```

   > The app will crash because it attempted to access the extras property on a null object.

9. Which of the following tasks can be performed in `onCreate()`?

   > Configuring views, such as setting the layout manager of a recycler view.

   > Getting extras from the intent that launched the activity.

10. In which method should you handle what happens when a button in the app bar is pressed?

    ```kotlin
    onOptionsItemSelected()
    ```

