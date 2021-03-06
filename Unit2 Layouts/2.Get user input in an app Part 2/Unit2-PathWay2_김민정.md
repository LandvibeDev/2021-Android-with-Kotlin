## 2021 Landvibe Summer Coding - Android

### π Android Basics In Kotlin

#### π Unit2: Layouts

#### π PathWay2: Get user input in an app: Part 2

<hr>

##### μ± νλ§ λ³κ²½

π© μ

+ μμ λΉ¨κ°μ, λΉμ, νλμ(RGB) κ΅¬μ±μμλ₯Ό λνλ΄λ 3κ°μ 16μ§μ μ«μ(#00~#FF(0~255))λ‘ νν

+ μ«μκ° ν΄μλ‘ κ΅¬μ±μμμ μμ΄ λ λ§μ΄ ν¬ν¨

+ \#00=0%=μμ  ν¬λͺ
+ \#FF=100%=μμ  λΆν¬λͺ
+ xml νμΌμμμ μ

```xml
<color name="black">#FF000000</color>
<color name="white">#FFFFFFFF</color>
```



π© λλΉ μμ : λ€μν νλ©΄μ κ·Έλ €μ§λ νμ€νΈμ μμ΄μ½μ μ¬μ©

| **#** | **μ΄λ¦**   | **νλ§ μμ±**           |
| ----- | ---------- | ----------------------- |
| 1     | κΈ°λ³Έ       | `colorPrimary`          |
| 2     | κΈ°λ³Έ λ³ν  | `colorPrimaryVariant`   |
| 3     | λ³΄μ‘°       | `colorSecondary`        |
| 4     | λ³΄μ‘° λ³ν  | `colorSecondaryVariant` |
| 5     | λ°°κ²½       | `colorBackground`       |
| 6     | νλ©΄       | `colorSurface`          |
| 7     | μ€λ₯       | `colorError`            |
| 8     | κΈ°λ³Έ(λλΉ) | `colorOnPrimary`        |
| 9     | λ³΄μ‘°(λλΉ) | `colorOnSecondary`      |
| 10    | λ°°κ²½(λλΉ) | `colorOnBackground`     |
| 11    | νλ©΄(λλΉ) | `colorOnSurface`        |
| 12    | μ€λ₯(λλΉ) | `colorOnError`          |



π© κΈ°λ³Έ νλ§μ μ μλ μμ

`colors.xml`(**app > res > values > colors.xml**)μ μ΄λ©΄ κ° μμ λ¦¬μμ€μ 16μ§μ κ°μ λ³Ό μ μμ΅λλ€. λ§¨ μμ `#FF`λ μν κ°μ΄λ©° μμμ΄ 100% λΆν¬λͺνλ€λ μλ―Έ



π© μ± νλ§ μμ μ ν

: λ¨Έν°λ¦¬μΌνμμ μ κ³΅νλ μΉ κΈ°λ° μ±μΈ [μμ λκ΅¬](https://material.io/resources/color/#!/?view.left=0&view.right=0)λ₯Ό μ¬μ©νλ κ²



π© μ±μ μμ μΆκ°νκΈ°

1. Android μ€νλμ€μμ `colors.xml`(**app > res > values > colors.xml**)μ μ½λλ€.

2. κΈ°μ‘΄μ μλ μμ λ€μμ μμμ μ νν κ°(`#1B5E20`)μ μ¬μ©νμ¬ `green`μ΄λΌλ μμ λ¦¬μμ€λ₯Ό μ μν©λλ€.

3. λ€λ₯Έ μμμ λ¦¬μμ€λ₯Ό κ³μ μ μν©λλ€. μ΄λ¬ν μμμ λλΆλΆμ μμ λκ΅¬μμ κ°μ Έμ΅λλ€. `green_light` λ° `blue_light` κ°μ λκ΅¬μ νμλλ κ°κ³Ό λ€λ¦λλ€. μ΄λ¬ν κ°μ μ΄ν λ¨κ³μμ μ¬μ©ν©λλ€.

   | `green`       | `#1B5E20` |
   | ------------- | --------- |
   | `green_dark`  | `#003300` |
   | `green_light` | `#A5D6A7` |
   | `blue`        | `#0288D1` |
   | `blue_dark`   | `#005B9F` |
   | `blue_light`  | `#81D4FA` |



π© νλ§μ μμ μ¬μ©νκΈ°

1. `themes.xml`(**app > res > values > themes > themes.xml**)μ μ½λλ€.
2. `colorPrimary`λ₯Ό μ νν κΈ°λ³Έ μμ(`@color/green`)μΌλ‘ λ³κ²½ν©λλ€.
3. `colorPrimaryVariant`λ₯Ό `@color/green_dark`λ‘ λ³κ²½ν©λλ€.
4. `colorSecondary`λ₯Ό `@color/blue`μΌλ‘ λ³κ²½ν©λλ€.
5. `colorSecondaryVariant`λ₯Ό `@color/blue_dark`λ‘ λ³κ²½ν©λλ€.
6. **Pμ νμ€νΈ**μ **Sμ νμ€νΈ**κ° μ¬μ ν ν°μ(`#FFFFFF`)κ³Ό κ²μμ(`#000000`)μΈμ§ νμΈν©λλ€. λμμ μΈ μμ λκ΅¬λ₯Ό μ¬μ©νκ³  μκ³  λ€λ₯Έ μμμ μ ννλ€λ©΄ μμ λ¦¬μμ€λ₯Ό μΆκ°λ‘ μ μν΄μΌ ν  μλ μμ΅λλ€.



π© μ΄λμ΄ νλ§ μλ°μ΄νΈ

1. `themes.xml (night)`(**app > res > values > themes > themes.xml(night)**)μ μ½λλ€.
2. `colorPrimary`λ₯Ό μ νν κΈ°λ³Έ μμ(`@color/green_light`)μ λ°μ λ³νμΌλ‘ λ³κ²½ν©λλ€.
3. `colorPrimaryVariant`λ₯Ό `@color/green`μΌλ‘ λ³κ²½ν©λλ€.
4. `colorSecondary`λ₯Ό `@color/blue_light`μΌλ‘ λ³κ²½ν©λλ€.
5. `colorSecondaryVariant`λ₯Ό `@color/blue_light`μΌλ‘ λ³κ²½ν©λλ€.



π© Android μ€νλμ€μμ μ΄λμ΄ νλ§ νμΈ λ°©λ²

: Orientation for Perview > Night μ ννκΈ°



##### μ± μμ΄μ½ λ³κ²½νκΈ°

π© λ°μ² μμ΄μ½ νμΌ νμ

1. `Project` > `app` > `main` > `res` > `mipmap`λ€~
2. μ΄λ¬ν `mipmap` ν΄λλ Android μ±μ λ°μ² μμ΄μ½ μ μμ λ°°μΉν΄μΌ νλ μμΉ!

`mdpi`, `hdpi`, `xhdpi` λ±μ λ°λ νμ μλ‘, λ¦¬μμ€ λλ ν°λ¦¬(μ: `mipmap`)μ μ΄λ¦μ μΆκ°νμ¬ νΉμ  νλ©΄ λ°λ κΈ°κΈ°μ λ¦¬μμ€

- `mdpi` - μ€λ°λ νλ©΄μ λ¦¬μμ€(~160dpi)
- `hdpi` - κ³ λ°λ νλ©΄μ λ¦¬μμ€ (~240dpi)
- `xhdpi` - μ΄κ³ λ°λ νλ©΄μ λ¦¬μμ€(~320dpi)
- `xxhdpi` - μ΄μ΄κ³ λ°λ νλ©΄μ λ¦¬μμ€(~480dpi)
- `xxxhdpi` - μ΄μ΄μ΄κ³ λ°λ νλ©΄μ λ¦¬μμ€(~640dpi)
- `nodpi` - νλ©΄μ ν½μ λ°λμ κ΄κ³μμ΄ μ‘°μ ν  μ μλ λ¦¬μμ€
- `anydpi` - μ΄λ€ λ°λλ‘λ μ‘°μ  κ°λ₯ν λ¦¬μμ€



π© μ± μμ΄μ½

+ ν¬κ·ΈλΌμ΄λ λ μ΄μ΄ / λ°±κ·ΈλΌμ΄λ λ μ΄μ΄

+ ν¬κ·ΈλΌμ΄λ λ μ΄μ΄λ λ°±κ·ΈλΌμ΄λ λ μ΄μ΄ μμ μμλλ€



π© μ μν μμ΄μ½ νμΌ νμ

1. Android μ€νλμ€μ **Project μ°½**μμ **res > mipmap-anydpi-v26** λ¦¬μμ€ λλ ν°λ¦¬λ₯Ό μ°Ύμ νΌμΉ©λλ€.

2. XML νμΌ μ€ νλλ₯Ό μ½λλ€(μ: `ic_launcher.xml`). λ€μκ³Ό κ°μ΄ νμλ©λλ€.
3. κ°κ°μ λ¦¬μμ€ λλ‘μ΄λΈμ μ κ³΅νμ¬ μ± μμ΄μ½μ `<background>` λ° `<foreground>` λ μ΄μ΄λ₯Ό μ μΈνλ λ° `<adaptive-icon>` μμκ° μ΄λ»κ² μ¬μ©λλμ§ νμΈν©λλ€.
4. **Project** λ·°λ‘ λμκ°μ λλ‘μ΄λΈμ΄ μ μΈλ μμΉλ₯Ό μ°Ύμ΅λλ€(**drawable > ic_launcher_background.xml**κ³Ό **drawable-v24 > ic_launcher_foreground.xml**).
5. **Design** λ·°λ‘ μ ννλ©΄ κ°κ°μ λ―Έλ¦¬λ³΄κΈ°κ° νμλ©λλ€(μΌμͺ½μ λ°±κ·ΈλΌμ΄λ, μ€λ₯Έμͺ½μ ν¬κ·ΈλΌμ΄λ).
6. λ λ€ λ²‘ν° λλ‘μ΄λΈ νμΌμλλ€. ν½μ λ¨μμ κ³ μ λ ν¬κΈ°λ μμ΅λλ€. **Code** λ·°λ‘ μ ννλ©΄ `<vector>` μμλ₯Ό μ¬μ©νμ¬ λ²‘ν° λλ‘μ΄λΈμ XML μ μΈμ νμΈν  μ μμ΅λλ€.



π© κ·Έλν½

λΉνΈλ§΅ μ΄λ―Έμ§: κ° ν½μμ μμ μ λ³΄λ₯Ό μ μΈνκ³  λ³΄μ ν μ΄λ―Έμ§μ λν΄ μ μμ§ λͺ»ν¨

λ²‘ν° κ·Έλν½: νμ§ μ ν μμ΄ λͺ¨λ  νλ©΄ λ°λμ μ΄λ€ μΊλ²μ€ ν¬κΈ°λ‘λ μ‘°μ ν  μ μλ€λ κ²μ΄ μ₯μ 

λ²‘ν° λλ‘μ΄λΈ: Androidμ λ²‘ν° κ·Έλν½ κ΅¬ν / μ΄λ¬ν κ°λ₯ν μμλ₯Ό μ¬μ©νμ¬ xmlλ‘ μ μ κ°λ₯



π© μ± μμ΄μ½ λ³κ²½νκΈ°

1. λ¨Όμ  Android μμ΄μ½κ³Ό λΉμ κ·Έλ¦¬λ λ°°κ²½μ΄ μλ μ΄μ  λλ‘μ΄λΈ λ¦¬μμ€λ₯Ό μ­μ ν©λλ€. **Project λ·°**μμ νμΌμ λ§μ°μ€ μ€λ₯Έμͺ½ λ²νΌμΌλ‘ ν΄λ¦­νκ³  **Delete**λ₯Ό μ νν©λλ€.

2. μ **Image Asset**μ λ§λ­λλ€. **res** λλ ν°λ¦¬λ₯Ό λ§μ°μ€ μ€λ₯Έμͺ½ λ²νΌμΌλ‘ ν΄λ¦­νκ³  **New > Image Asset**μ μ νν  μ μμ΅λλ€. λλ **Resource Manager** ν­μ ν΄λ¦­νκ³  **+** μμ΄μ½μ ν΄λ¦­ν ν **Image Asset**μ μ νν΄λ λ©λλ€.

3. Android μ€νλμ€μ **Image Asset Studio** λκ΅¬κ° μ΄λ¦½λλ€.

4. κΈ°λ³Έ μ€μ μ λ€μκ³Ό κ°μ΄ κ·Έλλ‘ μ μ§ν©λλ€.

   > Icon Type: Launcher Icons (Adaptive and Legacy)
   >
   > Name: ic_launcher

5. **Foreground Layer ν­**μ΄ μ΄λ―Έ μ νλμ΄ μλ μνλ‘ **Source Asset** νμ μΉμμΌλ‘ μ΄λν©λλ€. **Path** μλ ₯λμμ ν΄λ μμ΄μ½μ ν΄λ¦­ν©λλ€.

6. μ»΄ν¨ν°λ₯Ό νμνμ¬ νμΌμ μ ννλΌλ λ©μμ§κ° νμλ©λλ€. μ»΄ν¨ν°μ λ°©κΈ λ€μ΄λ‘λν μ `ic_launcher_foreground.xml` νμΌμ μμΉλ₯Ό μ°Ύμ΅λλ€. μ»΄ν¨ν°μ λ€μ΄λ‘λ ν΄λμ μμ μ μμ΅λλ€. νμΌμ μ°Ύμλ€λ©΄ **Open**μ ν΄λ¦­ν©λλ€.

7. μ΄μ  **Path**κ° μ ν¬κ·ΈλΌμ΄λ λ²‘ν° λλ‘μ΄λΈμ μμΉλ‘ μλ°μ΄νΈλ©λλ€. **Layer Name**μ **ic_launcher_foreground**λ‘, **Asset Type**μ **Image**λ‘ κ·Έλλ‘ λ‘λλ€.

8. μ΄μ  μΈν°νμ΄μ€μ **Background Layer ν­**μΌλ‘ μ νν©λλ€. κΈ°λ³Έκ°μ κ·Έλλ‘ μ μ§ν©λλ€. **Path**μ ν΄λ μμ΄μ½μ ν΄λ¦­ν©λλ€.

9. λ°©κΈ λ€μ΄λ‘λν `ic_launcher_background.xml` νμΌμ μμΉλ₯Ό μ°Ύμ΅λλ€. **Open**μ ν΄λ¦­ν©λλ€.

10. μ λ¦¬μμ€ νμΌμ μ ννλ©΄ λ―Έλ¦¬λ³΄κΈ°κ° μλ°μ΄νΈλ©λλ€. μλ‘μ΄ ν¬κ·ΈλΌμ΄λ λ° λ°±κ·ΈλΌμ΄λ λ μ΄μ΄κ° μ μ©λ λͺ¨μμ λ€μκ³Ό κ°μ΅λλ€.

11. ν¬κ·ΈλΌμ΄λ λ μ΄μ΄μ μ£Όμ μ½νμΈ (μ΄ κ²½μ° μλΉμ€ μ’ λͺ¨μ μμ΄μ½)κ° μμ  μμ­ λ΄μ ν¬ν¨λμ΄ λ€μν λ§μ€ν¬ λͺ¨μμΌλ‘ μΈν΄ μλ¦¬μ§ μμμΌ ν©λλ€. μ€μν μ½νμΈ κ° μλ¦¬κ±°λ λλ¬΄ μμ λ³΄μ΄λ©΄ κ° λ μ΄μ΄μ **Scaling** μΉμμμ **Resize** μ¬λΌμ΄λ λ°λ₯Ό μ¬μ©νλ©΄ λ©λλ€. μ΄ κ²½μ°μλ ν¬κΈ°λ₯Ό μ‘°μ νμ§ μμλ λλ―λ‘ 100%λ‘ λλ©΄ λ©λλ€.

12. **Next**λ₯Ό ν΄λ¦­ν©λλ€.

13. μ΄ λ¨κ³λ **Confirm Icon Path** λ¨κ³μλλ€. κ°λ³ νμΌμ ν΄λ¦­νμ¬ λ―Έλ¦¬λ³΄κΈ°λ₯Ό νμΈν  μ μμ΅λλ€. μΌλΆ κΈ°μ‘΄ νμΌμ λ?μ΄μ΄λ€λ(λΉ¨κ°μμΌλ‘ νμ) κ²½κ³ λ νλ¨μ νμλ©λλ€. μ΄λ¬ν κΈ°μ‘΄ νμΌμ μ΄μ  μ± μμ΄μ½μ©μ΄μμΌλ―λ‘ λ?μ΄μ¨λ κ΄μ°?μ΅λλ€.

14. κΈ°λ³Έκ°μ΄ μ’μΌλ―λ‘ **Finish**λ₯Ό ν΄λ¦­ν©λλ€.

15. μμ±λ λͺ¨λ  μ μμ΄ `mipmap` ν΄λμμ μ¬λ°λ₯΄κ² νμλλμ§ νμΈν©λλ€. μλ₯Ό λ€λ©΄ λ€μκ³Ό κ°μ΅λλ€.



π© SDKμ λ°λΌ..

+ ν¬κ·ΈλΌμ΄λ μ μμ `drawable-v24` ν΄λμ 

+ λ°±κ·ΈλΌμ΄λ μ μμ `drawable` ν΄λμ 

+ λ°±κ·ΈλΌμ΄λ μ μμλ κ·ΈλΌλ°μ΄μμ΄ ν¬ν¨λμ΄ μμ§ μμ κΈ°λ³Έ `drawable` ν΄λμ λ£μ μ μμ

  λ³λμ λ `drawable` ν΄λμ ν¬κ·ΈλΌμ΄λ λ° λ°±κ·ΈλΌμ΄λ μ μμ λλ λμ  λ λ²‘ν° λλ‘μ΄λΈ νμΌμ λͺ¨λ `-v26` λ¦¬μμ€ λλ ν°λ¦¬λ‘ μ΄λν©λλ€. μ΄λ¬ν μ μμ μ μν μμ΄μ½μλ§ μ¬μ©λλ―λ‘ μ΄ λ λλ‘μ΄λΈμ API 26 μ΄μμμλ§ νμν©λλ€. μ΄ ν΄λ κ΅¬μ‘°λ₯Ό μ¬μ©νλ©΄ μ μν μμ΄μ½ νμΌμ μ°Ύκ³  κ΄λ¦¬νκΈ°κ° λ μ¬μμ§λλ€.

  ```
  drawable-anydpi-v26
     ic_launcher_background.xml
     ic_launcher_foreground.xml
  mipmap-anydpi-v26
     ic_launcher.xml
     ic_launcher_round.xml
  ```



π© `drawable-anydpi-v26` ν΄λ λ§λλ λ°©λ²

1. λ¨Όμ  `drawable-anydpi-v26` λλ ν°λ¦¬λ₯Ό λ§λ­λλ€. **res** ν΄λλ₯Ό λ§μ°μ€ μ€λ₯Έμͺ½ λ²νΌμΌλ‘ ν΄λ¦­ν©λλ€. **New > Android Resource Directory**λ₯Ό μ νν©λλ€.

2. **New Resource Directory** λνμμκ° νμλ©λλ€. λ€μ μ΅μμ μ νν©λλ€.

   > **Directory name**: drawable-anydpi-v26
   >
   > **Resource type:** drawable(λλ‘­λ€μ΄μμ μ ν)
   >
   > **Source set:** main(κΈ°λ³Έκ°μ κ·Έλλ‘ μ μ§)

   **OK**λ₯Ό ν΄λ¦­ν©λλ€. **Project** λ·°μμ μ λ¦¬μμ€ λλ ν λ¦¬ **res > drawable-anydpi-v26**μ΄ λ§λ€μ΄μ‘λμ§ νμΈν©λλ€.

3. `ic_launcher_foreground.xml` νμΌμ λ§μ°μ€ μΌμͺ½ λ²νΌμΌλ‘ ν΄λ¦­νκ³  **drawable** ν΄λμμ **drawable-anydpi-v26** ν΄λλ‘ λλκ·Έν©λλ€. λ¦¬μμ€λ₯Ό 'any dpi' λλ ν°λ¦¬μ λ£λ κ²μ μ΄λ€ λ°λλ‘λ μ‘°μ ν  μ μλ λ¦¬μμ€μμ λνλλλ€.

4. `ic_launcher_background.xml`μ λ§μ°μ€ μΌμͺ½ λ²νΌμΌλ‘ ν΄λ¦­νκ³  **drawable-v24** ν΄λμμ **drawable-anydpi-v26** ν΄λλ‘ λλκ·Έν©λλ€.

5. `drawable-v24` ν΄λκ° μ§κΈ λΉμ΄ μλ€λ©΄ μ­μ ν©λλ€. ν΄λλ₯Ό λ§μ°μ€ μ€λ₯Έμͺ½ λ²νΌμΌλ‘ ν΄λ¦­νκ³  **Delete**λ₯Ό μ νν©λλ€.

6. νλ‘μ νΈμ λͺ¨λ  `drawable` λ° `mipmap` νμΌμ ν΄λ¦­ν©λλ€. μ΄λ¬ν μμ΄μ½μ λ―Έλ¦¬λ³΄κΈ°κ° μ¬λ°λ₯΄κ² νμλλμ§ νμΈν©λλ€.



##### π© μμ½

- μ± μμ΄μ½ νμΌμ `mipmap` λ¦¬μμ€ λλ ν°λ¦¬μ λ°°μΉν©λλ€.
- Androidμ μ΄μ  λ²μ κ³Όμ νΈνμ±μ μν΄ κ° λ°λ λ²ν·(`mdpi`, `hdpi`, `xhdpi`, `xxhdpi`, `xxxhdpi`)μ λ€μν λ²μ μ μ± μμ΄μ½ λΉνΈλ§΅ μ΄λ―Έμ§λ₯Ό μ κ³΅ν©λλ€.
- λ¦¬μμ€ λλ ν°λ¦¬μ λ¦¬μμ€ νμ μλ₯Ό μΆκ°νμ¬ νΉμ  κ΅¬μ±(μ: `v26`)μ κΈ°κΈ°μμ μ¬μ©ν΄μΌ νλ λ¦¬μμ€λ₯Ό μ§μ ν©λλ€.
- λ²‘ν° λλ‘μ΄λΈμ Androidμ λ²‘ν° κ·Έλν½ κ΅¬νμλλ€. κ΄λ ¨ μμ μ λ³΄μ ν¨κ» μΌλ ¨μ μ κ³Ό μ , κ³‘μ μΌλ‘ XMLμμ μ μλ©λλ€. λ²‘ν° λλ‘μ΄λΈμ νμ§ μ ν μμ΄ μ΄λ€ λ°λλ‘λ μ‘°μ ν  μ μμ΅λλ€.
- μ μν μμ΄μ½μ API 26μμ Android νλ«νΌμ λμλμμ΅λλ€. νΉμ  μκ΅¬μ¬ν­μ μ€μνλ ν¬κ·ΈλΌμ΄λ λ° λ°±κ·ΈλΌμ΄λ λ μ΄μ΄λ‘ κ΅¬μ±λλ―λ‘ λ€μν OEM λ§μ€ν¬κ° μ μ©λ μ¬λ¬ κΈ°κΈ°μμ μ± μμ΄μ½μ΄ κ³ νμ§λ‘ νμλ©λλ€.
- Android μ€νλμ€μμ Image Asset Studioλ₯Ό μ¬μ©νμ¬ μ±μ λ κ±°μ λ° μ μν μμ΄μ½μ λ§λ­λλ€.



##### λμ± μΈλ ¨λ μ¬μ©μ νκ²½ λ§λ€κΈ°

π© μ€μμΉ

`activity_main.xml` λ μ΄μμμμ XML νκ·Έλ₯Ό `Switch`μμ `com.google.android.material.switchmaterial.SwitchMaterial.`λ‘ λ³κ²½ν©λλ€.

```
...

<com.google.android.material.switchmaterial.SwitchMaterial
    android:id="@+id/round_up_switch"
    android:layout_width="0dp"
    android:layout_height="wrap_content" ... />

...
```

μ₯μ : λΌμ΄λΈλ¬λ¦¬μ `SwitchMaterial` κ΅¬νμ΄ μλ°μ΄νΈλλ©΄(μ: λ¨Έν°λ¦¬μΌ λμμΈ κ°μ΄λλΌμΈ λ³κ²½) μ§μ  λ³κ²½νμ§ μκ³ λ λ¬΄λ£λ‘ μμ ―μ΄ μλ°μ΄νΈ



π© μμ΄μ½

 [μμ΄μ½ λͺ©λ‘μ νμΈ](https://material.io/resources/icons/?style=baseline)



π© λ²‘ν° λλ‘μ΄λΈ μ μ μΆκ°

1. μ νλ¦¬μΌμ΄μ μ°½μ μΌμͺ½μ μλ **Resource Manager** ν­μ μ½λλ€.
2. \+ μμ΄μ½μ ν΄λ¦­νκ³  **Vector Asset**μ μ νν©λλ€.
3. **Asset Type**μ κ²½μ° **Clip Art**λΌλ λΌλμ€ λ²νΌμ΄ μ νλμ΄ μλμ§ νμΈν©λλ€.
4. **Clip Art:** μμ μλ λ²νΌμ ν΄λ¦­νμ¬ λ€λ₯Έ ν΄λ¦½ μνΈ μ΄λ―Έμ§λ₯Ό μ νν©λλ€. λ©μμ§κ° νμλλ©΄ λνλλ μ°½μ 'call made'λ₯Ό μλ ₯ν©λλ€. μ΄ νμ΄ν μμ΄μ½μ Round up tip μ΅μμ μ¬μ©νκ² μ΅λλ€. μμ΄μ½μ μ ννκ³  **OK**λ₯Ό ν΄λ¦­ν©λλ€.
5. μμ΄μ½ μ΄λ¦μ `ic_round_up`μΌλ‘ λ°κΏλλ€. μμ΄μ½ νμΌμ μ΄λ¦μ μ§μ ν  λλ μ λμ΄ ic_μ μ¬μ©νλ κ²μ΄ μ’μ΅λλ€. **Size**λ₯Ό 24dp x 24dpλ‘, **Color**λ₯Ό black 000000μΌλ‘ κ·Έλλ‘ λ‘λλ€.
6. **Next**λ₯Ό ν΄λ¦­ν©λλ€.
7. κΈ°λ³Έ λλ ν°λ¦¬ μμΉλ₯Ό κ·Έλλ‘ μ¬μ©νκ³  **Finish**λ₯Ό ν΄λ¦­ν©λλ€
8. λ€λ₯Έ λ μμ΄μ½μ 2~7λ¨κ³λ₯Ό λ°λ³΅ν©λλ€.

- **μλΉμ€ μ§λ¬Έ μμ΄μ½:** 'room service' μμ΄μ½μ κ²μνμ¬ `ic_service`λ‘ μ μ₯ν©λλ€.
- **Cost of Service μμ΄μ½:** 'store' μμ΄μ½μ κ²μνμ¬ `ic_store`λ‘ μ μ₯ν©λλ€.

1. μλ£νλ©΄ **Resource Manager**λ μλ μ€ν¬λ¦°μ·κ³Ό κ°μΌλ©° λ²‘ν° λλ‘μ΄λΈ μΈ κ°(`ic_round_up`, `ic_service`, `ic_store`)κ° `res/drawable` ν΄λμ λμ΄λ©λλ€.



<hr>

π© μ€νμΌ: λ¨μΌ μμ ― μ νμ λ·° μμ± κ° λͺ¨μ

**res > values** λλ ν°λ¦¬μ `styles.xml`μ΄λΌλ μ νμΌμ λ§λ­λλ€. **values** λλ ν°λ¦¬λ₯Ό λ§μ°μ€ μ€λ₯Έμͺ½ λ²νΌμΌλ‘ ν΄λ¦­ν ν **New > Values Resource File**μ μ ννμ¬ νμΌμ λ§λ­λλ€. μ΄λ¦μ `styles.xml`λ‘ μ§μ ν©λλ€.

`style.xml`μ μΆκ°!

```xml
<style name="Widget.TipTime.TextView" parent="Widget.MaterialComponents.TextView">
</style>
```

μΈλΆμ€μ 

```xml
<style name="Widget.TipTime.TextView" parent="Widget.MaterialComponents.TextView">
    <item name="android:minHeight">48dp</item>
    <item name="android:gravity">center_vertical</item>
    <item name="android:textAppearance">?attr/textAppearanceBody1</item>
</style>
```

μμ£Ό μ¬μ©λλ κ°μ κ΄λ¦¬ ν¨μ¨μ±μ λμ΄λ €λ©΄ `dimens.xml` νμΌ

```xml
<resources>
   <dimen name="min_text_height">48dp</dimen>
</resources>
```



π© νμ 

`xml`

```xml
<ScrollView
   xmlns:android="http://schemas.android.com/apk/res/android"
   xmlns:app="http://schemas.android.com/apk/res-auto"
   xmlns:tools="http://schemas.android.com/tools"
   android:layout_height="match_parent"
   android:layout_width="match_parent">

   <androidx.constraintlayout.widget.ConstraintLayout
       android:layout_width="match_parent"
       android:layout_height="wrap_content"
       android:padding="16dp"
       tools:context=".MainActivity">

       ...
   </ConstraintLayout>

</ScrollView>
```



π© μν° λλ₯΄λ©΄ ν€λ³΄λ μ¨κΈ°κΈ°

`MainActivity.kt`

```kotlin
private fun handleKeyEvent(view: View, keyCode: Int): Boolean {
   if (keyCode == KeyEvent.KEYCODE_ENTER) {
       // Hide the keyboard
       val inputMethodManager =
           getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
       inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
       return true //μ΄λ²€νΈ μ²λ¦¬λ κ²½μ°
   }
   return false //μ²λ¦¬λμ§ μμ κ²½μ°
}
```



π© λ·°μ ν€ λ¦¬μ€λλ₯Ό μ€μ νλ μ½λ

`MainActivity.kt`

```kotlin
override fun onCreate(savedInstanceState: Bundle?) {
   ...

   setContentView(binding.root)

   binding.calculateButton.setOnClickListener { calculateTip() }

   binding.costOfServiceEditText.setOnKeyListener { view, keyCode, _ -> handleKeyEvent(view, keyCode)
   }
}
```



π© μ¬μ§μ μ μ‘°μ 

`ic_service.xml` -> λ€λ₯Έ μ¬μ§μλ μ μ©ν΄μ£ΌκΈ°!

> μ¬κΈ°μ, `android:tint` , `android:fillColor` μ£Όλͺ©!

```xml
<vector xmlns:android="http://schemas.android.com/apk/res/android"
   android:width="24dp"
   android:height="24dp"
   android:viewportWidth="24"
   android:viewportHeight="24"
   android:tint="?attr/colorPirmary">
 <path
     android:fillColor="@android:color/white"
     android:pathData="M2,17h20v2L2,19zM13.84,7.79c0.1,-0.24 0.16,-0.51 0.16,-0.79 0,-1.1 -0.9,-2 -2,-2s-2,0.9 -2,2c0,0.28 0.06,0.55 0.16,0.79C6.25,8.6 3.27,11.93 3,16h18c-0.27,-4.07 -3.25,-7.4 -7.16,-8.21z"/>
</vector>
```



π© λ¬Έμ 

1. Which line(s) of XML code will produce an error?

```kotlin
1    <TextView
2        android:layout_width="wrap_content"
3        android:layout_height"wrap_content"
4        android:padding="8dp"
5        android:text="@string/title"
6        android:textSize=18sp />
```

β		Line 3 - Missing = symbol after `android:layout_height` attribute.

 		Line 6 - Missing quotations around the attribute value `18sp`  

2. Which of the following is true about Gradle?

   Gradle is an automated build system used by Android Studio to build your apps.

   Gradle handles installing your app on a device.

   You can configure Android-specific options for your project in your appβs `build.gradle` file. 

3. Which of the following statements about app icons are true?

   mdpi, hdpi, xhdpi, xxhdpi, and xxxhdpi are density qualifiers for resource directories to indicate that these are resources to be used on devices with a specific screen density.

   Adaptive icons are made up of a foreground and background layer, and an OEM mask will be applied on top of them.

4. Which of the below steps are part of changing the color of your app theme?

   Modify the `themes.xml` (night) file.

   Set the primary and secondary color theme attributes of your app theme.

   Define the colors used in your app as color resources in the `colors.xml` file.

   set

5. Why use the Material Components for Android library?

   It provides widgets that follow the Material Design guidelines such as text fields and switches.

   It provides default Material themes that you can use directly or extend and then customize.

   It helps you more quickly build beautiful user experiences.

