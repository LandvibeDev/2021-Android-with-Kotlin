# π‘ Android Basics in Kotlin

## Unit #3 : Navigation

## PATHWAY #1 : Navigate between screens

<br/>

## π©π»βπ» Kotlinμ μ»¬λ μ

#### π μ»¬λ μ μ’λ₯

- **λͺ©λ‘** : μ€λ³΅ κ°λ₯

- **μ§ν©** : μ€λ³΅ λΆκ°λ₯

  - λͺ©λ‘ -> μ§ν© λ³κ²½ 

    ```kotlin
    val setOfNumbers = numbers.toSet()
    ```

  - νΉμ  ν­λͺ© νμΈ

    ```kotlin
    println("contains 7: ${setOfNumbers.contains(7)}")
    ```

  - `intersect()` : κ΅μ§ν©

  - `union()` : ν©μ§ν©

- **λ§΅** : ν€-κ° μμ μ§ν©μΌλ‘, κ° ν€λ μ νν νλμ κ°μ λ§€νλμ§λ§, κ°μ μ€λ³΅ κ°λ₯

  - μμ±

    ```kotlin
    fun main() {
        val peopleAges = mutableMapOf<String, Int>(
            "Fred" to 30,
            "Ann" to 23
        )
    }
    ```

  - μΆκ° : `put()` λλ μ½μ νκΈ°λ² μ¬μ©

    ```kotlin
    peopleAges.put("Barbara",42)
    peopleAges["Joe"] = 51
    ```

<br/>

#### π μ»¬λ μ μ¬μ©

- `forEach()` : μ΄κ±°ν¨μ. νΉμ μλ³μ itμ¬μ©

  ```kotlin
  peopleAges.forEach { print("${it.key} is ${it.value}, ") }
  ```

- `map()` : λ³νμ μ©ν¨μ. κ° ν­λͺ©μ λ³ν μ μ©νκ³  λ³νλ ν­λͺ©μΌλ‘ μ΄λ£¨μ΄μ§ μ μ»¬λ μ λ§λ¬. `joinToString`κ³Ό μ μ°μ°μ`.`λ‘ κ²°ν©

  ```kotlin
  println(peopleAges.map { "${it.key} is ${it.value}" }.joinToString(", ") )
  ```

- `filter()` : μΌμΉν­λͺ© λ°νν¨μ.

  ```kotlin
  val filteredNames = peopleAges.filter { it.key.length < 4 }
  println(filteredNames)
  ```

<br/>

#### π λλ€

- λλ€ : μ΄λ¦μ΄ μμΌλ©° κ³§λ°λ‘ ννμμΌλ‘ μ¬μ©ν  μ μλ ν¨μ.  `{ }` μ¬μ©

- ν¨μ μ ν : (μλ£ν1) -> μλ£ν2 :  μλ£ν1μΈ λ§€κ°λ³μλ₯Ό μ¬μ©νκ³  μλ£ν2μΈ κ°μ λ°ννλ€.

  ```kotlin
  val triple: (Int) -> Int = { a: Int -> a * 3 }	
  val triple: (Int) -> Int = { it * 3 }
  ```

- ν¨μ λ³Έλ¬Έμμ νΉμ  λλ€ λ§€κ°λ³μλ₯Ό μ¬μ©νμ§ μλ κ²½μ° μ΄λ¦μ `_`λ‘ μ§μ 

  ```kotlin
  costOfServiceEditText.setOnKeyListener { view, keyCode, _ -> handleKeyEvent(view, keyCode) }
  ```

<br/>

#### π κ³ μ°¨ ν¨μ

- κ³ μ°¨ν¨μ : ν¨μλ₯Ό λ€λ₯Έ ν¨μλ‘ μ λ¬νκ±°λ λ€λ₯Έ ν¨μμμ ν¨μλ₯Ό λ°ννλ κ².

- `map()` `filter()` `forEach()`

- `sortedWith()` : μ΄λ¦ κΈΈμ΄λ₯Ό κΈ°μ€μΌλ‘ μ€λ¦μ°¨μμΌλ‘ λͺ©λ‘ μΆλ ₯

  ```kotlin
  fun main() {
      val peopleNames = listOf("Fred", "Ann", "Barbara", "Joe")
      println(peopleNames.sortedWith { str1: String, str2: String -> str1.length - str2.length })
  }
  
  // [Ann, Joe, Fred, Barbara]
  ```

<br/>

#### π λ¨μ΄ λͺ©λ‘ λ§λ€κΈ°

- `filter` ,  `startsWith()` : μ§μ λ λ¬Έμμ΄λ‘ μμνλ λ¬Έμμ΄ μ°ΎκΈ°

- `shuffled()` : λ¬΄μμλ‘ μκΈ°

- `take()` : μ»¬λ μμ μ ν­λͺ© κ°μ Έμ€κΈ°

  ```kotlin
  fun main() {
      val words = listOf("about", "acute", "awesome", "balloon", "best", "brief", "class", "coffee", "creative")
      val filteredWords = words.filter { it.startsWith("b", ignoreCase = true) }
    	.shuffled()
    	.take(2)  //κ΄νΈμμ μ«μ -> λ°νν  λ¨μ΄ κ°μ
    	.sorted()
  		println(filteredWords)
    
  }
  ```

<br/>

<br/>

## π©π»βπ» μΈννΈ

#### π μΈννΈ

- μ€νν  μμμ λνλ΄λ κ°μ²΄
  - **μμμ  μΈννΈ** : λ§€μ° κ΅¬μ²΄μ , , μ±μ νΉμ  νλμΌλ‘ μ΄λνλ λ° μ¬μ©λλ€. μ€νν  νλμ μ ννκ² μ μ μκ³  μμ²΄ μ±μ νλ©΄μΈ κ²½μ°κ° λ§λ€.
  - **λͺμμ  μΈννΈ** : μ’ λ μΆμμ ,  νΉμ νλ(ex. λ§ν¬ μ΄κΈ°, μ΄λ―Έμ§ κ³΅μ , μ΄λ©μΌ μμ±, μ ν κ±ΈκΈ°) κ°μ μμ μ νμ μλ €μ£Όκ³  μμ€νμ΄ μΈννΈ μ²λ¦¬ λ°©λ²μ κ²°μ νλλ‘ νλ€.

<br/>

#### π Words μ± λͺμμ  μΈννΈ μ€μ 

- `LetterAdapter.kt` μ `onBindViewHolder()` μ μΆκ°

  ```kotlin
  holder.button.setOnClickListener {
    //1. μ»¨νμ€νΈ μ°Έμ‘° κ°μ Έμ€κΈ°
    val context = holder.view.context 
    //2. Intent κ°μ²΄λ₯Ό λ§λ€μ΄ μ»¨νμ€νΈμ λμ νλμ ν΄λμ€ μ΄λ¦ μ λ¬,
    //νμνλ €λ νλμ μ΄λ¦μ DetailActivity::class.javaλ‘ μ§μ .
    val intent = Intent(context, DetailActivity::class.java)
    //3. putExtra() νΈμΆνμ¬ λ¬Έμλ₯Ό μ²« λ²μ§Έ μΈμλ‘ μ λ¬, λ²νΌ νμ€νΈλ₯Ό λλ²μ§Έ μΈμλ‘ μ λ¬
    intent.putExtra("letter", holder.button.text.toString())
    //4. μ»¨νμ€νΈ κ°μ²΄μμ startActivity() λ©μλλ₯Ό νΈμΆνμ¬ intentλ₯Ό μ λ¬
    context.startActivity(intent)
   }
  ```
  
- DetailActivity μ€μ 

  - `DetailActivity` μ `onCreate` μ μΆκ°

    ```kotlin
    val letterId = intent?.extras?.getString("letter").toString()
    ```

    - βοΈ **λ¬Όμν** λΆμ΄λ μ΄μ λ? : `intent` λ° `extras` μμ±μ nullμ νμ©νλ―λ‘ κ°μ΄ μμ μλ μκ³  μμ μλ μκΈ° λλ¬Έμ μ΄ κ°μ μμ νκ² μ‘μΈμ€ νκΈ°μν΄ μ΄λ¦ λ€μ `?`λ₯Ό μλ ₯νλ€.

       λ¬Έμ  : κ°μ²΄κ° μκ±°λ `null`μΌ μ μλλ°, κ·Έλ₯ μ±μ΄ μμ±μ μ‘μΈμ€νκ±°λ `null` κ°μ²΄μμ ν¨μλ₯Ό νΈμΆνλ €κ³  νλ©΄ λ€μ΄λλ€. 

        μ μ½λμμ `intent`κ° `null`μ΄λ©΄ μ±μ extras μμ± μ‘μΈμ€λ₯Ό μλμ‘°μ°¨ νμ§ μμΌλ©° `extras`κ° nullμ΄λ©΄ μ½λμμ `getString()`μ νΈμΆνλ €κ³  μλμ‘°μ°¨ νμ§ μλλ€.

  - `companion` μ»΄ν¨λμΈ κ°μ²΄ 

    μ¬μ¬μ© κ°λ₯ν μμλ₯Ό μ νμ μΈμ€ν΄μ€κ° μλ μ νκ³Ό μ°κ²°νλ λ°©λ² μ κ³΅νλ€.

    ```kotlin
    companion object {
            const val LETTER = "letter"
    }
    val letterId = intent?.extras?.getString(LETTER).toString()
    ```

    μ΄ν, `LetterAdapter`μ `onBindViewHolder` μμ 

    ```kotlin
    intent.putExtra(DetailActivity.LETTER, holder.button.text.toString())
    ```

<br/>

#### π Words μ± μμμ  μΈννΈ μ€μ 

- μ¬κΈ°μλ λ¨μ΄λ²νΌ ν΄λ¦­νλ©΄ Google κ²μμμ μ κ³΅νλ μ¬μ  κΈ°λ₯μ μ¬μ©, μ±μ΄ μμ μ νμ κ΄ν μ λ³΄λ₯Ό μμ€νμ μ κ³΅νλ©΄ μμ€νμ μ΄ μμμΌλ‘ μ€νν  μΌμ νμνμ¬ νμμ λ°λΌ μ¬μ©μμκ² μΆκ° μ λ³΄λ₯Ό μμ²­νλ€. 

- `DetailActivity` μ μ»΄ν¨λμΈ κ°μ²΄ μμ 

  ```kotlin
  companion object {
     val LETTER = "letter"
     val SEARCH_PREFIX = "https://www.google.com/search?q="
  }
  ```

- `WordAdapter` > `onBindViewHolder()` μμ `setOnClickListener()`νΈμΆ

  ```kotlin
  holder.button.setOnClickListener {
    	//κ²μμ΄μ URI λ§λ  λ€, parse()νΈμΆνμ¬ stringμμ URI λ§λ€ λ λ¬Έμμ΄ νμ μ¬μ©νμ¬ λ¨μ΄κ° SEARCH_PREFIXμ μΆκ°λλλ‘ νλ€.
      val queryUrl: Uri = Uri.parse("${DetailActivity.SEARCH_PREFIX}${item}")
    	// queryUrl μ μ ν μ intentκ°μ²΄ μ΄κΈ°ν
    	// ACTION_VIEWλ URIλ₯Ό μ¬μ©νλ μΌλ°μ μΈ μΈννΈ.
   		val intent = Intent(Intent.ACTION_VIEW,queryUrl)
  }
  ```

  - βοΈ **URI** μ **URL** μ°¨μ΄λ? : URLμ *Uniform Resource Locator*λ μΉνμ΄μ§λ₯Ό κ°λ¦¬ν€λ λ¬Έμμ΄μ΄κ³ , URIλ *Uniform Resource Identifier* λ‘ URLλ³΄λ€ λ μΌλ°μ μΈ μ©μ΄μ΄λ€.

    **URI**μ΄λΌλ μ§ν© μμ **URL**κ³Ό **URN**(*Uniform Resource Name*, μ νλ²νΈμ μ£Όμ λ±)μ΄ μλ€.

  - βοΈ λ€λ₯Έ μΈννΈ μ νλ€μ?

    - `CATEGORY_APP_MAPS` - μ§λ μ±μ μ€ν.
    - `CATEGORY_APP_EMAIL` - μ΄λ©μΌ μ±μ μ€ν.
    - `CATEGORY_APP_GALLERY` - κ°€λ¬λ¦¬(μ¬μ§) μ±μ μ€ν.
    - `ACTION_SET_ALARM` - λ°±κ·ΈλΌμ΄λμμ μλμ μ€μ .
    - `ACTION_DIAL` - μ νλ₯Ό κ±΄λ€



<br/>

#### π λ©λ΄ &μμ΄μ½ μ€μ 

- μ¬κΈ°μλ λ²νΌμ μ± λ°μ μΆκ°νμ¬ λͺ©λ‘ λ° κ·Έλ¦¬λ λ μ΄μμ κ°μ μ νμ΄ κ°λ₯νκ² νλ€.

- λ©λ΄λ²νΌ μΆκ°

  - `res` > `drawable`μ iconμΆκ° (λ²‘ν° μμ)

  - `res`μ android resource file μΆκ° -> (`res` > `menu` > `layout_menu.xml`μμ±)

    ```xml
     <menu xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto">
        <item android:id="@+id/action_switch_layout"
            android:title="@string/action_switch_layout"
            android:icon="@drawable/ic_linear_layout"
            app:showAsAction="always" />
    </menu>
    ```

- λ©λ΄ λ²νΌ μλμν€κΈ° (`MainActivity.kt`)

  - μ±μ λ μ΄μμ μν μΆμ 

    ```kotlin
    private var isLinearLayoutManager = true
    ```

  - λ μ΄μμ μ ν

    ```kotlin
    private fun chooseLayout() {
        if (isLinearLayoutManager) {
            recyclerView.layoutManager = LinearLayoutManager(this)
        } else {
            recyclerView.layoutManager = GridLayoutManager(this, 4)
        }
        recyclerView.adapter = LetterAdapter()
    }
    ```

  - μμ΄μ½ μ ν

    ```kotlin
    private fun setIcon(menuItem: MenuItem?) {
       if (menuItem == null) return
      
       menuItem.icon =
           if (isLinearLayoutManager)
               ContextCompat.getDrawable(this, R.drawable.ic_grid_layout)
           else ContextCompat.getDrawable(this, R.drawable.ic_linear_layout)
    }
    ```

  - `OnCreateOptionsMenu()`  : μ΅μ λ©λ΄ νμ₯νμ¬ μΆκ° μ€μ  μ€ν 

    ```kotlin
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
       menuInflater.inflate(R.menu.layout_menu, menu)
       val layoutButton = menu?.findItem(R.id.action_switch_layout)
       //λ μ΄μμμ λ°λΌ setIcon()νΈμΆνμ¬ μμ΄μ½ μ¬λ°λ₯Έμ§ νμΈ
       setIcon(layoutButton)
       return true
    }
    ```

  - `onOptionsItemSelected() ` : λ²νΌμ΄ μ νλ  λ  `chooseLayout()` νΈμΆ

    ```kotlin
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
       return when (item.itemId) {
           R.id.action_switch_layout -> {
               // μν λ°λλ‘ λ°κΏμ£ΌκΈ°
               isLinearLayoutManager = !isLinearLayoutManager
               // λ μ΄μμκ³Ό μμ΄μ½ νΈμΆνμ¬ μ μ νκ² UI μλ°μ΄νΈ
               chooseLayout()
               setIcon(item)
    
               return true
           }
           //μ²λ¦¬λμ§ μμ κ²½μ° μ²λ¦¬
           else -> super.onOptionsItemSelected(item)
       }
    }
    ```

  - `onCreate()`μμ `chooseLayout()`νΈμΆλ‘ μμ 

<br/>

<br/>

## π©π»βπ» νλ μλͺ μ£ΌκΈ° λ¨κ³

- νλμ΄ μλͺ μ£ΌκΈ° μν λ³κ²½μ μ¬λ°λ₯΄κ² μλ΅νμ§ μμΌλ©΄, μ±μ μ΄μν λ²κ·Έκ° λ°μνμ¬ μ¬μ©μκ° λμμ νΌλνκ±°λ μ±μμ Android μμ€ν λ¦¬μμ€λ₯Ό λλ¬΄ λ§μ΄ μ¬μ©ν  μ μλ€.

- νλμ΄ μ²μ μ΄κΈ°νλ  λλΆν° λ§μ§λ§μΌλ‘ μλ©Έλμ΄ μμ€νμμ λ©λͺ¨λ¦¬λ₯Ό νμν  λκΉμ§ νλμ΄ κ±°μ³ κ° μ μλ μ¬λ¬ μνλ‘ κ΅¬μ±λλ€. μ¬μ©μκ° μ±μ μμνμ¬ νλ κ°μ μ΄λνκ³  μ± μνμΌλ‘ μ΄λν  λ νλμ μνλ₯Ό λ³κ²½νλ€.

  <img src="img/3-1_1_jumin.png" width=50% height=50%>

<br/>

#### π μλͺ μ£ΌκΈ° λ©μλ & λ‘κΉ μΆκ°

- `onCreate()`  : μ± μμ±.
  - νλ μ΄κΈ°νλ μ§ν **ν λ² νΈμΆ**λκ³ , λ©μλ μ€νλλ©΄ νλμ΄ μμ±λ¨μΌλ‘ κ°μ£Όλλ€.
  - νλ μμ±μ μλ£νκΈ° μν΄ `super.onCreate()` λ₯Ό μ¦μ νΈμΆν΄μΌ νλ€.
  - νλ¨ `Logcat`μμ `D/MainActivity`μμ λ©μμ§ νμΈκ°λ₯
- `onStart()`  : νλ μμ, νλ©΄μ νμλκ² νλ€.
  - `onCreate()` μ§ν νΈμΆλκ³  `onStop()`μ μμ.
  - νλ μλͺμ£ΌκΈ°μμ **μ¬λ¬ λ² νΈμΆ**λ  μ μλ€.

- `onResume()` : νλ ν¬μ»€μ€ μ κ³΅, μ¬μ©μκ° μνΈμμ©ν  μ μλλ‘ νλ μ€λΉ, λ€μ μμν  λμμ΄ μμ΄λ μμ μ νΈμΆλλ€.

- βοΈ `Log` ν΄λμ€μ λ€λ₯Έ λ©μλλ?
  - `Log.d()` : λλ²κ·Έ λ©μμ§ μμ± 
  - `Log.i()` : μ λ³΄ λ©μμ§ μμ± 
  - `Log.e() ` : μ€λ₯ λ©μμ§ μμ±
  - `Log.w()` : κ²½κ³  λ©μμ§ μμ±
  - `Log.v()` : μμΈν λ©μμ§ μμ±

- λͺ¨λ  μλͺ μ£ΌκΈ° λ©μλμ λ‘κΉ κ΅¬ν

  ```kotlin
  const val TAG = "MainActivity" 
  override fun onCreate() {
    	super.onCrate()
    	Log.d(TAG, "onCreate Called")
  }
  override fun onStart() {
      super.onStart()
      Log.d(TAG, "onStart Called")
  }
  override fun onResume() {
     super.onResume()
     Log.d(TAG, "onResume Called")
  }
  override fun onPause() {
     super.onPause()
     Log.d(TAG, "onPause Called")
  }
  override fun onStop() {
     super.onStop()
     Log.d(TAG, "onStop Called")
  }
  override fun onDestroy() {
     super.onDestroy()
     Log.d(TAG, "onDestroy Called")
  }
  override fun onRestart() {
     super.onRestart()
     Log.d(TAG, "onRestart Called")
  }
  ```

- μ¬λ‘
  - `λ€λ‘κ°κΈ°` λ²νΌ λλ₯Ό μ, `onPause`, `onStop`, `onDestroy`  νΈμΆλλ©° νλ μμ ν μ’λ£, λ©λͺ¨λ¦¬ μ λ¦¬
    - λ€μ μ±μΌλ‘ λμκ°λ©΄, `onCreate()`, `onStart()`, `onResume()` 
  - `ν` λ²νΌ λλ₯Ό μ, `onPause`, `onStop` νΈμΆλλ©°, νλμ΄ `λ°±κ·ΈλΌμ΄λ`μ λ°°μΉλλ€.
    - λ€μ μ±μΌλ‘ λμκ°λ©΄, `onRestart()`, `onStart()`, `onResume()`
  - `κ³΅μ ` λ²νΌ λλ₯Ό μ, `onPause()`λ§ νΈμΆ, μ± νλ©΄ λΆλΆμ μΌλ‘ κ³μ νμλ¨
    - λ€μ μ±μΌλ‘ λμκ°λ©΄, `onResume()` νΈμΆ
- `onSaveInstanceState()`  
  -  `Activity`κ° μλ©Έλλ©΄ νμν  μ μλ λ°μ΄ν°λ₯Ό μ μ₯νλ λ° μ¬μ©νλ μ½λ°±
  - νλ‘μΈμ€ μ’λ£μ λ§μ°¬κ°μ§λ‘ μ± μνλ₯Ό `onSaveInstanceState()`μ λ²λ€μ μ μ₯

<br/>

<br/>

------



## π©π»βπ» ν΄μ¦

1. Which of the following is false about collections and higher order functions in Kotlin?

   - Lists are unordered, while maps and sets are ordered data types.

     <br/>

2. Given the following code, what is the result of `oneWordCities[1]`?

   ```kotlin
   cities = listOf("Jeddah", "Bengaluru", "Shenzhen", "Abu Dhabi", "Mountain View", "Tripoli", "Bengaluru", "Lima", "Mandalay", "Tripoli")
   val oneWordCities = cities.toSet().toList().filter { !it.contains(" ")}.sorted()
   ```

   - Jeddah

   <br/>

3. A(n)  [        ]  is a piece of data passed between activities when launching an intent.

   - extra

   <br/>

4. If you open an app, and then leave the app using the back button, in which order were the following activity lifecycle methods called?

   - onCreate(), onStart(), onStop(), onDestroy()

   <br/>

   

5. Which activity lifecycle method would be called if a dialog appears onscreen, partially obscuring an activity?
   - `onPause()` because the activity is still displayed, but no longer has focus.

<br/>



6. Which of the following is true about the lifecycle of a single activity?

   - `onStart()` can be called multiple times, while `onCreate()` can only be called once.

   - `onResume()` is called when the activity gains focus.

<br/>



7. Which of the following is false about intents?
   - An implicit intent always results in the system asking the user which app to open.

<br/>



8. An activity contains the following code in `onCreate()`. What will happen when this code is executed, if the `intent` property is `null`?

   ```kotlin
   val message = intent.extras?.getString("message"
   ).toString()
   ```

   - The app will crash because it attempted to access the extras property on a null object.



<br/>

9. Which of the following tasks can be performed in `onCreate()`?
   - Configuring views, such as setting the layout manager of a recycler view.
   - Getting extras from the intent that launched the activity.

<br/>

10. In which method should you handle what happens when a button in the app bar is pressed?
    - `onOptionsItemSelected()`