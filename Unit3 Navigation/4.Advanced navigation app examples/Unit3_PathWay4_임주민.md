# ๐ก Android Basics in Kotlin

## Unit #3 : Navigation

## PATHWAY #4 : Architecture components

<br/>

- `๋ง๋ค ๊ฒ` : 
  - ์ปต์ผ์ดํฌ ์ฃผ๋ฌธ ์ฑ (์ปต์ผ์ดํฌ ๋ง, ์๋, ์๋ น ๋ ์ง ์ ํ ๊ฐ๋ฅ)

- `๋ฐฐ์ธ ๊ฒ` :
  - ๊ณ ๊ธ ์ฌ์ฉ ์ฌ๋ก ๋ด์์ ๊ถ์ฅ ์ฑ ์ํคํ์ฒ ์ฌ๋ก ๊ตฌํํ๋ ๋ฐฉ๋ฒ
  - ํ๋์ ํ๋๊ทธ๋จผํธ ๊ฐ์ ๊ณต์  ViewModel์ ์ฌ์ฉํ๋ ๋ฐฉ๋ฒ -> ๋์ผํ ํ๋์ ํ๋๊ทธ๋จผํธ ๊ฐ์ ๋ฐ์ดํฐ ๊ณต์  ๋ฐฉ๋ฒ
  - LiveData ๋ณํ ์ ์ฉํ๋ ๋ฐฉ๋ฒ

<br/>

## ๐ฉ๐ปโ๐ป ํ๋๊ทธ๋จผํธ ๊ฐ ๊ณต์ ๋๋ ViewModel

- ํ๋๊ทธ๋จผํธ ์ฐ๊ฒฐ ๋ฐ ๋ฒํผ ๋๋ ์ ๋ ํ๋๊ทธ๋จผํธ ์ด๋

- ์ฑ ๋ฐ ์ ๋ชฉ ์๋ฐ์ดํธ - NavController

<br/>

#### ๐ ๊ณต์  ViewModel ์์ฑ

- ์ฑ์ ๋ฐ์ดํฐ๋ฅผ ๋จ์ผ ViewModel์ ์ ์ฅ

  - ์ปต์ผ์ดํฌ์ฑ : ์ฃผ๋ฌธ ์ ๋ณด(๊ฐ๊ฒฉ, ์๋, ๋ง, ์๋ น ๋ ์ง)๋ฅผ ๋จ์ผ ๋ทฐ๋ชจ๋ธ์ ์ ์ฅ -> `OrderViewModel`

- ์ฑ์ ์ฌ๋ฌ ํ๋๊ทธ๋จผํธ๋ ํ๋ ๋ฒ์๋ฅผ ์ฌ์ฉํ์ฌ ๊ณต์  ViewMoel์ ์ก์ธ์คํจ

- ๋ทฐ ๋ชจ๋ธ ๋ฐ์ดํฐ๋ฅผ `private` ๋ณ์๋ก ํ๋ ๊ฒ์ด ์ข์, ํ์ํ ๊ฒฝ์ฐ๋ง `public `์ผ๋ก(์ธ๋ถ์์ ํธ์ถ๋์ด์ผ ํ  ๋ ๋ฑ)

  ```kotlin
  class OrderViewModel : ViewModel() {
    
      private val _quantity = MutableLiveData<Int>(0)
      val quantity: LiveData<Int> = _quantity
      private val _flavor = MutableLiveData<String>("")
      val flavor: LiveData<String> = _flavor
      private val _date = MutableLiveData<String>("")
      val date: LiveData<String> = _date
      private val _price = MutableLiveData<Double>(0.0)
      val price: LiveData<Double> = _price
     
      fun setQuantity(numberCupcakes: Int) {
          _quantity.value = numberCupcakes
      }
      fun setFlavor(desiredFlavor: String) {
          _flavor.value = desiredFlavor
      }
      fun setDate(pickupDate: String) {
          _date.value = pickupDate
      }
   
  }
  ```

  

<br/>

#### ๐ ViewModel ์ฌ์ฉํ์ฌ UI์๋ฐ์ดํธ

- ๊ณต์  ๋ทฐ ๋ชจ๋ธ ์ฌ์ฉํ๋ ค๋ฉด **viewModels()** ๋๋ฆฌ์ ํด๋์ค ๋์  **acivitiyViewModels()**๋ฅผ ์ฌ์ฉ

  - `activityViewModels()` : ํ์ฌ ํ๋์ผ๋ก ๋ฒ์๊ฐ ์ง์ ๋ `ViewModel` ์ธ์คํด์ค๋ฅผ ์ ๊ณต. ๋ฐ๋ผ์ ์ธ์คํด์ค๋ ๋์ผํ ํ๋์ ์ฌ๋ฌ ํ๋๊ทธ๋จผํธ ๊ฐ์ ๋์ผํ๊ฒ ์ ์ง๋จ.

- Kotlin ์์ฑ ์์ ์ฌ์ฉ

  - ์๋์ผ๋ก ์์ฑ๋๋ ๊ธฐ๋ณธ getter ๋ฐ setter ํจ์ ์ฑ์์ ๋ค๋ฅธ ํด๋์ค(๋๋ฆฌ์ ํด๋์ค)์ ๋๊ธธ ์ ์๋ค.

    ```kotlin
    // Syntax for property delegation
    var <property-name> : <property-type> by <delegate-class>()
    
    // ์ฌ์ฉ ์์ - ๊ณต์ ํ  ๋ชจ๋  ํ๋๊ทธ๋จผํธ ํด๋์ค์ ์ ์ธ
    private val sharedViewModel : OrderViewModel by activityViewModels()
    ```



<br/>

#### ๐ ๋ฐ์ดํฐ ๊ฒฐํฉ๊ณผ ํจ๊ป ViewModel ์ฌ์ฉ

- ๋ฐ์ดํฐ ๊ฒฐํฉ(๋ทฐ๋ฅผ ์ฝ๋์ ๊ฒฐํฉ)์ ์ฌ์ฉํ์ฌ ๋ทฐ ๋ชจ๋ธ ๋ฐ์ดํฐ๋ฅผ UI์ ๊ฒฐํฉํ๊ณ  ์ฌ์ฉ์๊ฐ UI์์ ์ ํํ ์ฌํญ์ ๋ฐ๋ผ ๊ณต์  ๋ทฐ ๋ชจ๋ธ ์๋ฐ์ดํธํ๊ธฐ

- **apply ๋ฒ์ ํจ์** : ๊ฐ์ฒด์ ์ปจํ์คํธ ๋ด์์ ์ฝ๋ ๋ธ๋ก์ ์คํํ๋ฉฐ ์์ ๋ฒ์๋ฅผ ํ์ฑ -> ๋ฒ์ ๋ด์์ ์ด๋ฆ ์ฌ์ฉ ์ํ๊ณ  ๊ฐ์ฒด์ ์ก์ธ์ค ๊ฐ๋ฅ

  ```kotlin
  // ์ฌ์ฉ ์์
  
  clark.apply {
      firstName = "Clark"
      lastName = "James"
      age = 18
  }
  
  clark.firstName = "Clark"
  clark.lastName = "James"
  clark.age = 18
  ```

- ๋ฆฌ์ค๋ ๊ฒฐํฉ

  - ์ด๋ฒคํธ๊ฐ ๋ฐ์ํ  ๋ ์คํ๋๋ ๋๋ค ํํ์

    ```xml
    <RadioButton
           ...
           android:onClick="@{() -> viewModel.setFlavor(@string/vanilla)}"
           .../>
    ```

<br/>

#### ๐ ํ๋๊ทธ๋จผํธ ์๋ฐ์ดํธ

- ๋ ์ง ํ์ ์ง์  : `SimpleDateFormat` ํด๋์ค

  ใ ๋ ์ง์ ํ์ ์ง์ (๋ ์ง -> ํ์คํธ) ๋ฐ ํ์ฑ(ํ์คํธ -> ๋ ์ง) ๊ฐ๋ฅ
  
  ```kotlin
  SimpleDateFormat("E MMM d", Locale.getDefault())
  // "EEE, MMM d"๋ "Wed, Jul 4"๋ก ํ์ฑ
  // E : ์์ผ, M : ๋ฌ, d : ์ผ, y : ์ฐ๋
  
  // ์ปต์ผ์ดํฌ ์ฑ ์ฌ์ฉ ์ฝ๋
  private fun getPickupOptions(): List<String> {
  	  val options = mutableListOf<String>()
  	  val formatter = SimpleDateFormat("E MMM d", Locale.getDefault())
      val calendar = Calendar.getInstance()
      repeat(4) {
            options.add(formatter.format(calendar.time))
            calendar.add(Calendar.DATE, 1)
      }
     	return options
   }
  ```
  
  - `Locale` ๊ฐ์ฒด๋ ํน์ ํ ์ง๋ฆฌ์ , ์ ์น์  ๋๋ ๋ฌธํ์  ์ง์ญ์ ๋ํ๋ด๋ฉฐ ์ธ์ด/๊ตญ๊ฐ/๋ณํ ์กฐํฉ ๋ํ๋. `Locale.getDefault()` ๋ฉ์๋ ์ฌ์ฉํ์ฌ ์ฌ์ฉ์์ ๊ธฐ๊ธฐ์ ์ค์ ๋ ์ธ์ด ์ ๋ณด ๊ฐ์ ธ์์ ํด๋์ค ์์ฑ์์ ์ ๋ฌ

- `elvis ์ฐ์ฐ์ (?:)` : ์ผ์ชฝ์ ํํ์์ด null์ด ์๋๋ฉด ์ด ๊ฐ์ ์ฌ์ฉ. null์ด๋ผ๋ฉด ์ค๋ฅธ์ชฝ์ ์๋ ํํ์์ ์ฌ์ฉ

<br/>

- LiveData๋ฅผ ๊ด์ฐฐํ๋๋ก ์๋ช ์ฃผ๊ธฐ ์์ ์ ์ค์ 
  - `LifecycleOwner` : ํ๋์ด๋ ํ๋๊ทธ๋จผํธ์ ๊ฐ์ด ์๋๋ก์ด๋ ์๋ช ์ฃผ๊ธฐ ๋ณด์ ํ ํด๋์ค
  - `LiveData` ๊ด์ฐฐ์๋ ์๋ช ์ฃผ๊ธฐ ์์ ์๊ฐ ํ์ฑ ์ํ(`STARTED` ๋๋ `RESUMED`)์ธ ๊ฒฝ์ฐ์๋ง ์ฑ ๋ฐ์ดํฐ์ ๋ณ๊ฒฝ์ฌํญ์ ๊ด์ฐฐ
  - ์ปต์ผ์ดํฌ์ฑ
    -  LiveData ๊ฐ์ฒด ๋๋ ๊ด์ฐฐ ๊ฐ๋ฅํ ๋ฐ์ดํฐ : ๋ทฐ ๋ชจ๋ธ์  `price` ์์ฑ
    - ์๋ช ์ฃผ๊ธฐ ์์ ์ : `flavor`, `pickup`,`summary ` ๊ฐ๊ฐ์ ํ๋๊ทธ๋จผํธ
  - ๊ฒฐํฉ ํํ์
    - `android:text="@{@string/subtotal_price(viewModel.price)}"`

  <br/>

- LiveData ๋ณํ์ ์ฌ์ฉํ์ฌ ๊ฐ๊ฒฉ ํ์ ์ง์ 

  - `Transformations.map()` ๋ฉ์๋ ์ฌ์ฉํ์ฌ ๊ฐ๊ฒฉ์ ํ์ง ํตํ ์ฌ์ฉํ๋๋ก ๊ฐ๊ฒฉ ํ์ ์ง์ 

<br/>

<br/>

## ๐ฉ๐ปโ๐ป ํ์ ๋ฐ ๋ฐฑ ์คํ

#### ๐ Up ๋ฒํผ ๋์ ๊ตฌํ 

- `Up ๋ฒํผ` : ์ด์ ํ๋ฉด์ผ๋ก ๋์๊ฐ๋ ๋ฒํผ (๋ค๋ก๊ฐ๊ธฐ)

  ```kotlin
  // ์ฑ์์ ์๋ก ์ด๋์ ์ฒ๋ฆฌํ๋๋ก navController์ ์์ฒญ, ๊ทธ๋ฌ์ง ์์ผ๋ฉด Up๋ฒํผ ์ฒ๋ฆฌํ๋ ์ํผํด๋์ค ๊ตฌํ(AppCompatActivity)์ผ๋ก ๋์ฒด
  
  override fun onSupportNavigateUp(): Boolean {
     return navController.navigateUp() || super.onSupportNavigateUp()
  }
  ```

  

  

<br/>

#### ๐ ์์ ๋ฐ ๋ฐฑ ์คํ

- ์ฃผ๋ฌธ์ ์ธ์ ๋ ์ง ์ทจ์ํ๋ฉด `StartFragment`๋ก ์ฌ์ฉ์ ์ด๋

- **์์** : ์ฌ์ฉ์๊ฐ ์ด๋ฉ์ผ ํ์ธ, ์ปต์ผ์ดํฌ ์ฃผ๋ฌธ ์์ฑ ๋ฑ ํน์ ํ ์ผ์ ํ  ๋ ์ํธ์์ฉํ๋ `ํ๋`์ ๋ชจ์

  - **ํ๋** : `๋ฐฑ ์คํ` ์ด๋ผ๋ ์คํ์ผ๋ก ๋ฐฐ์ด๋๋ฉฐ, ์ฌ์ฉ์๊ฐ ๋ฐฉ๋ฌธํ๋ ๊ฐ๊ฐ์ ์ ํ๋์ ์์์ ๋ฐฑ ์คํ์ผ๋ก ํธ์๋จ

- **๋ฐฑ ์คํ** : ์คํ ๋งจ ์์ ์๋ ํ๋์ ์ฌ์ฉ์๊ฐ ํ์ฌ ์ํธ์์ฉํ๊ณ  ์๋ ํ๋์ด๋ฉฐ, ์คํ์์ ๊ทธ ์๋์ ์๋ ํ๋์ ๋ฐฑ๊ทธ๋ผ์ด๋๋ก ์ ํ๋์๋ค๊ฐ ์ค์ง๋จ

  - ๋ค๋ก ์ด๋ํ๋ ๊ฒฝ์ฐ, ์คํ์์ ํ๋์ ํํ๊ณ  ์ฌ์ฉ์๊ฐ ์ํธ์์ฉํ  ์ ์๊ฒ ์ด์  ํ๋์ด ํฌ๊ทธ๋ผ์ด๋๋ก ์ด๋ํจ
  - ๋ฐฑ ์คํ์ ๋ ์ด์ ํ๋์ด ๋จ์ ์์ง ์์ผ๋ฉด ์ฌ์ฉ์๋ ๊ธฐ๊ธฐ์ ๋ฐ์ฒ ํ๋ฉด์ด๋ ์ด ํ๋์ ์คํํ ์ฑ์ผ๋ก ๋์๊ฐ

  <img src="img/3_4_jumin.png" width=30% height=30%>

<br/>

#### ๐ ์ฃผ๋ฌธ ์ ์ก

- ์ฑ์์ ๋ค๋ฅธ ์ฑ์ผ๋ก ์ ๋ณด๋ฅผ ๊ณต์  -> ์ฌ์ฉ์๊ฐ ๊ธฐ๊ธฐ์ ์ด๋ฉ์ผ ์ฑ์ ํตํด ์ปต์ผ์ดํฌ ์์ ์ ์ฃผ๋ฌธ์ ์ด๋ฉ์ผ๋ก ๋ณด๋ด ์ปต์ผ์ดํฌ ์ฃผ๋ฌธ ์ ๋ณด๋ฅผ ๊ณต์ ํ  ์ ์์

  ```kotlin
  fun sendOrder() {
      val numberOfCupcakes = sharedViewModel.quantity.value ?: 0
      val orderSummary = getString(
          R.string.order_details,
          resources.getQuantityString(R.plurals.cupcakes, numberOfCupcakes, numberOfCupcakes),
          sharedViewModel.flavor.value.toString(),
          sharedViewModel.date.value.toString(),
          sharedViewModel.price.value.toString()
      )
  
      val intent = Intent(Intent.ACTION_SEND)
          .setType("text/plain")
          .putExtra(Intent.EXTRA_SUBJECT, getString(R.string.new_cupcake_order))
          .putExtra(Intent.EXTRA_TEXT, orderSummary)
  
      if (activity?.packageManager?.resolveActivity(intent, 0) != null) {
          startActivity(intent)
      }
  }
  ```

  

  

<br/>

<br/>

------

## ๐ฉ๐ปโ๐ป ํด์ฆ

1. ##### ์ฐธ ๋๋ ๊ฑฐ์ง: ์ฌ๋ฌ ํ๋ ๋๋ ํ๋๊ทธ๋จผํธ์ ๋์ผํ ViewModel์ ์ฌ์ฉํ์ฌ ๋ฐ์ดํฐ๋ฅผ ๊ณต์ ํ  ์ ์์ต๋๋ค.

   > ์ฐธ
   >
   
2. ##### Kotin ์์ฑ ์์ ์ ๊ทผ๋ฒ์ ์ฌ์ฉํ์ฌ ๊ณต์  ๋ทฐ ๋ชจ๋ธ์ ์ก์ธ์คํ  ์ ์๋ ์ฌ๋ฐ๋ฅธ ๋ฐฉ๋ฒ์ ๋ฌด์์ธ๊ฐ์?

   > `val viewModel: OrderViewModel by activityViewModels()`

3. ##### ๋น ์นธ ์ฑ์ฐ๊ธฐ : LiveData [          ]์(๋ฅผ) ์ฌ์ฉํ์ฌ ๋ค๋ฅธ ์ธ์คํด์ค์ ๊ฐ์ ๋ฐ๋ผ ๋ค์ํ LiveData ์ธ์คํด์ค๋ฅผ ๋ฐํํฉ๋๋ค.

   > ๋ณํ

4. ##### ๊ฐ์ฒด๋ฅผ ๊ตฌ์ฑํ๋ ๋ฐ Kotlin์ `apply` ํจ์๋ฅผ ์ฌ์ฉํ๋ ค๋ฉด ์ด๋ป๊ฒ ํด์ผ ํ๋์?

   > ๊ฐ์ฒด์ ํ ๋น ์ธํธ๋ฅผ ์ ์ฉํ  ์ ์์ต๋๋ค.
   >
   
5. ##### ๋ฐ์ดํฐ ๊ฒฐํฉ ๋ ์ด์์ ํํ์์ ์ฌ์ฉํ  ๋ ํด๋ฆญ ๋ฆฌ์ค๋๋ฅผ ๊ฒฐํฉํ๊ธฐ ์ํด ์ด ๋ ์ด์์์ ๋ฒํผ์ ์์ฑ์ ์ถ๊ฐํ๋ ์ฌ๋ฐ๋ฅธ ๊ตฌ๋ฌธ์ ๋ฌด์์ธ๊ฐ์?

   ```xml
   <Button
       android:id="@+id/next_button"
       android:layout_width="wrap_content"
       android:layout_height="wrap_content"
       android:text="@string/next" />
   ```

   > `android:onClick="@{() -> detailFragment.next()}"`

   
