## 2021 Landvibe Summer Coding - Android

### π Android Basics In Kotlin

#### π Unit1: Kotlin basics

#### π PathWay3: Build a basic layout

<hr>

##### UI μ λ³΄

```UI(μΈν°νμ΄μ€)```  : νλ©΄μ νμλλ νμ€νΈ, μ΄λ―Έμ§, λ²νΌ, κΈ°ν μ¬λ¬ μ νμ μμ

```View```  : κ° μμ

```Views```  : μνΈμμ© κ°λ₯

```TextView```  : νμ€νΈλ₯Ό νμνλ ```View``` μ ν

```ViewGroup```  : ```View```κ°μ²΄κ° μμ μ μλ μ»¨νμ΄λ, ```Views``` μ λ ¬νλ μ­ν 

```ConstraintLayout```  : ```ViewGroup```μ ν μ’λ₯, λ΄λΆ ```View``` μ λ ¬ κ°λ₯



##### Layout ν΄λ μ°Ύλ λ°©λ²

1. ```app``` ν΄λ μ°ΎκΈ°
2. ```app``` ν΄λ >  ```res``` ν΄λ >  ```layout``` 
3. ```layout```μ μ‘΄μ¬νλ ```activity_main.xml```  μ°ΎκΈ° μλ£ ππ»



##### νμ€νΈ λ³κ²½νκΈ°

1. μ€λ₯Έμͺ½ ```Attributes```μμ ```Declared Attributes``` λΆλΆ μ°ΎκΈ°
2. ```text``` λΆλΆμ μμ νκΈ°



##### νμ€νΈ μΆκ°νκΈ°

1. μΌμͺ½ μλ¨μ Paletteμμ ```TextView``` μ°ΎκΈ°
2. νλ©΄μΌλ‘ λλκ·Ένμ¬ λλ‘­νκΈ°

β	π¨ μ΄λ, ```ComponentTree```μ λΉ¨κ°μ μ€λ₯κ° λ°μνλ κ² νμΈ

β	π¨ ```TextView```μ μ μ½μ‘°κ±΄μ μΆκ°ν΄μ£Όμ΄μΌ νλ€ (μλ₯Ό λ€μ΄, μ¬λ°±)

β	π¨ μ¬λ°±: ```View```κ° μ»¨νμ΄λμ κ°μ₯μλ¦¬μ λ¨μ΄μ§ μ λ

	3. μ€λ₯Έμͺ½ ```Attributes```μμ ```Layout``` μΉμμ μλ ```ConstraintWidget``` μ°ΎκΈ°
 	4. ```ConstraintWidget```μ μ‘΄μ¬νλ μ μ¬κ°νμ + ν΄λ¦­νμ¬ μνλ μ«μ λ£κΈ°



##### μμ½

> `Layout Editor`λ₯Ό μ¬μ©νλ©΄ Android μ±μ© UIλ₯Ό λ§λ€ μ μμ΅λλ€.
>
> μ± νλ©΄μ νμλλ λλΆλΆμ λ΄μ©μ `View`μλλ€.
>
> `TextView`λ μ±μμ νμ€νΈλ₯Ό νμνλ UI μμμλλ€.
>
> `ConstraintLayout`μ λ€λ₯Έ UI μμμ μ»¨νμ΄λμλλ€.
>
> `Views`λ `ConstraintLayout` λ΄μμ κ°λ‘μ μΈλ‘λ‘ μ νλμ΄μΌ ν©λλ€.
>
> `View`λ₯Ό λ°°μΉνλ ν κ°μ§ λ°©λ²μ μ¬λ°±μ μ¬μ©νλ κ²μλλ€.
>
> μ¬λ°±μ ν΅ν΄ `View`κ° μ»¨νμ΄λμ κ°μ₯μλ¦¬μμ λ¨μ΄μ§ μ λλ₯Ό μ€μ ν  μ μμ΅λλ€.
>
> `TextView`μ κΈκΌ΄, νμ€νΈ ν¬κΈ°, μμκ³Ό κ°μ μμ±μ μ€μ ν  μ μμ΅λλ€.



<hr>

##### νλ‘μ νΈ μ΄λ―Έμ§ μΆκ°

1. Android μ€νλμ€μ λ©λ΄μμ **View > Tool Windows > Resource Manager**
2. **Resource Manager** μλμ **+**λ₯Ό ν΄λ¦­νκ³  **Import Drawables**λ₯Ό μ ν
3. νμΌ λΈλΌμ°μ μμ λ€μ΄λ‘λν μ΄λ―Έμ§ νμΌμ μ°Ύμ **Open** ν΄λ¦­
4. **Next**λ₯Ό ν΄λ¦­ν©λλ€. Android μ€νλμ€μ μ΄λ―Έμ§μ λ―Έλ¦¬λ³΄κΈ°κ° νμλ¨
5. **Import**λ₯Ό ν΄λ¦­
6. μ΄λ―Έμ§λ₯Ό μ±κ³΅μ μΌλ‘ κ°μ Έμ€λ©΄ Android μ€νλμ€μμλ μ΄λ―Έμ§λ₯Ό **Drawable** λͺ©λ‘μ μΆκ°
7. λ©λ΄μμ **View > Tool Windows > Project**λ₯Ό ν΄λ¦­
8. **app > res > drawable**μ νΌμ³ μ΄λ―Έμ§κ° μ±μ **drawable** ν΄λμ μλμ§ νμΈ
9. **Project** μ°½μμ **activity_main.xml**μ°½μΌλ‘ μ΄λ
10. **Layout Editor**μμ **Palette**λ‘ μ΄λνμ¬ `ImageView`λ₯Ό μ±μΌλ‘ λλκ·Έ
11. **Pick a Resource** λνμμμ **Drawable** λͺ©λ‘μμ μΌμ΄ν¬ μ΄λ―Έμ§λ₯Ό μ°ΎκΈ°
12. μ΄λ―ΈμΉ ν΄λ¦­νκ³  **OK** ν΄λ¦­



##### μ΄λ―Έμ§ κΎΈλ―ΈκΈ°

ν¬κΈ° μ‘°μ 

> 1. `ImageView` νλ¨μ μ μ½μ‘°κ±΄μ `ConstraintLayout` νλ¨μ μΆκ°
> 2. **Constraint Widget**μμ νλ¨ **+**λ₯Ό ν΄λ¦­νμ¬ μνμ’μ° μ¬λ°± 0 λ§λ€κΈ°
> 3. **Constraint Widget** μλμμ **layout_width**λ₯Ό **0dp**λ‘ μ€μ 
> 4. **layout_height**λ₯Ό **0dp**λ‘ μ€μ 
> 5. **Common Attributes**μμ **ScaleType**μ **centerCrop**μΌλ‘ μ€μ  (κ·Έλ¦Ό μ μ²΄νλ©΄ μ±μ°κΈ°)

μ°μ μμ μ€μ 

>1. `ConstraintLayout`μ νλ¨μ μ‘΄μ¬νλ λͺ©λ‘ νμΈ
>2. λ§¨ μλΆν° μλ μμλ‘ μ°μ μμκ° λμ κ² νμΈ
>3. μνλ κ²μ κ°μ₯ μλ‘ μ¬λ¦¬κΈ°



##### μμ½

>Android μ€νλμ€μ **Resource Manager**λ₯Ό μ¬μ©νλ©΄ μ΄λ―Έμ§μ κΈ°ν λ¦¬μμ€λ₯Ό μΆκ°νκ³  κ΅¬μ±ν  μ μμ΅λλ€.
>
>`ImageView`λ μ±μμ μ΄λ―Έμ§λ₯Ό νμνλ UI μμμλλ€.
>
>`ImageViews`μλ μ±μ μ κ·Όμ±μ κ°μ ν  μ μλ μ½νμΈ  μ€λͺμ΄ μμ΄μΌ ν©λλ€.



##### μ°Έκ³ μ£Όμ

Layout Editor: https://developer.android.com/studio/write/layout-editor



##### ν΄μ¦

1. Which of the following elements is considered a View in an Android app?

   > An image
   >
   > A clickable button
   >
   > Text on the screen

2. What is the main purpose of a ViewGroup?

   >It serves as a container for View objects, and is responsible for arranging the View objects within it.

3. The type of ViewGroup that helps you arrange the views inside of it in a flexible way is called a [].

   >constraintlayout

4. Which of the following are Attributes in Android?(λ³΅μμ ν)

   >text
   >
   >textSize
   >
   >textColor

5. In Android, a graphic that can be drawn to the screen is generally referred to as a [].

   >layout(μ€λ΅)

6. Which of the following is an example of a βconstraintβ that could be applied to a view in a ConstraintLayout ViewGroup in the Layout Editor? (λ³΅μμ ν)

   > A view that must always be a minimum distance away from the edge of its container
   >
   > A view that must always include a contentDescription attribute(μ€λ΅)

7. What is the purpose of the activity_main.xml file in the project you created?

   > It describes the layout of view groups and views for a screen.

8. Why should you use string resources instead of hard-coded strings in your apps? (λ³΅μμ ν)

   > It makes your app easier to translate.
   >
   > It allows you to reuse the same string in multiple places in your program.