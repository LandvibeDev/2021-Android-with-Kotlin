/*
 * Copyright (C) 2021 The Android Open Source Project.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.lemonade

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    /**
     * DO NOT ALTER ANY VARIABLE OR VALUE NAMES OR THEIR INITIAL VALUES.
     *
     * Anything labeled var instead of val is expected to be changed in the functions but DO NOT
     * alter their initial values declared here, this could cause the app to not function properly.
     */
    private val LEMONADE_STATE = "LEMONADE_STATE"
    private val LEMON_SIZE = "LEMON_SIZE"
    private val SQUEEZE_COUNT = "SQUEEZE_COUNT"
    // SELECT represents the "pick lemon" state
    private val SELECT = "select"
    // SQUEEZE represents the "squeeze lemon" state
    private val SQUEEZE = "squeeze"
    // DRINK represents the "drink lemonade" state
    private val DRINK = "drink"
    // RESTART represents the state where the lemonade has be drunk and the glass is empty
    private val RESTART = "restart"
    // Default the state to select
    private var lemonadeState = "select"
    // Default lemonSize to -1
    private var lemonSize = -1
    // Default the squeezeCount to -1
    private var squeezeCount = -1

    private var lemonTree = LemonTree()
    private var lemonImage: ImageView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // === DO NOT ALTER THE CODE IN THE FOLLOWING IF STATEMENT ===
        if (savedInstanceState != null) {
            lemonadeState = savedInstanceState.getString(LEMONADE_STATE, SELECT) //선언한 변수 사용하는 것이 더 효율적!
            lemonSize = savedInstanceState.getInt(LEMON_SIZE, -1)
            squeezeCount = savedInstanceState.getInt(SQUEEZE_COUNT, -1)
        }
        // === END IF STATEMENT ===

        lemonImage = findViewById(R.id.image_lemon_state)
        setViewElements()
        lemonImage?.setOnClickListener { //!!는 확실히 null이 아니다. ?는 null인 경우도 고려한 것!
            // TODO: call the method that handles the state when the image is clicked
            //클릭해야하는 리스너 2개
            //cickLemonImage() 메서드 이용
            clickLemonImage()
        }
        lemonImage?.setOnLongClickListener {
            // TODO: replace 'false' with a call to the function that shows the squeeze count
            //이미지 길게 누르는 이벤트
            //레몬 압착한 횟수 알려주기
            //showSnackbar() 메서드 이용
            showSnackbar()
        }
    }

    /**
     * === DO NOT ALTER THIS METHOD ===
     *
     * This method saves the state of the app if it is put in the background.
     */
    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString(LEMONADE_STATE, lemonadeState)
        outState.putInt(LEMON_SIZE, lemonSize)
        outState.putInt(SQUEEZE_COUNT, squeezeCount)
        super.onSaveInstanceState(outState)
    }

    /**
     * Clicking will elicit a different response depending on the state.
     * This method determines the state and proceeds with the correct action.
     */
    private fun clickLemonImage() {
        //select, squeeze, drink, restart 4가지 상태 가능
        //1. select: squeeze상태로 전환, pick() 호출, squeezeCount를 0으로 설정, lemonSize 설정
        //2. squeeze: sqeezeCount 1씩 늘리기, lemonSize 1씩 줄이기, lemonSize가 0인 경우 drink
        //3. drink: resatrt상태로 전환, lemonSize를 -1로
        //4. restart: select상태로 다시 전환
        //완료하면, setViewElements()호출하여 UI 업데이트

        when(LEMONADE_STATE){//상태에 따라 적도록!
            SELECT->{
                lemonadeState=SQUEEZE //상태 변화
                lemonSize=lemonTree.pick() //랜덤 사이즈 주기
                squeezeCount=0 //짜는 횟수 초기화
            }
            SQUEEZE->{
                squeezeCount+=1 //짜는 횟수 +1
                lemonSize-=1 //레몬사이즈 -1
                if (lemonSize==0) { //더 이상 짜낼 레몬이 없다면!
                    lemonadeState=DRINK //상태 변화
                }
                else { lemonadeState=SQUEEZE } //아니라면 여전히 짜내는 상태
            }
            DRINK->{
                lemonadeState=RESTART //상태 변화
                lemonSize=-1 //레몬 사이즈 초기화
            }
            RESTART->{
                lemonadeState=SELECT //상태 변화
            }
        }
        setViewElements() //when 밖에다 사용하기
    }

    /**
     * Set up the view elements according to the state.
     */
    private fun setViewElements() {
        //setViewElements()메서드는 앱 상태에 따라 UI 업데이트
        //1. select: 텍스트-레몬 클릭하여 선택, 이미지-R.drawable.lemon_tree
        //2. squeeze: 텍스트-레몬 클릭하여 즙, 이미지-R.drawable.lemon_squeeze
        //3. drink: 텍스트-레모네이드 클릭하여 마심, 이미지-R.drawable.lemon_drink
        //4. restart: 텍스트-클릭하여 다시 시작, 이미지-R.drawable.lemon_restart

        val textAction: TextView = findViewById(R.id.text_action)
        when(lemonadeState){
            SELECT->{
                textAction.resources.getString(R.string.lemon_select) //.(dot)찍고 작성
                lemonImage?.setImageResource(R.drawable.lemon_tree) //drawable 파일에 있는 image 가져오기
            }
            SQUEEZE->{
                textAction.resources.getString(R.string.lemon_squeeze)
                lemonImage?.setImageResource(R.drawable.lemon_squeeze)
            }
            DRINK->{
                textAction.resources.getString(R.string.lemon_drink)
                lemonImage?.setImageResource(R.drawable.lemon_drink)
            }
            RESTART->{
                textAction.resources.getString(R.string.lemon_empty_glass)
                lemonImage?.setImageResource(R.drawable.lemon_restart)
            }
        }
    }

    /**
     * === DO NOT ALTER THIS METHOD ===
     *
     * Long clicking the lemon image will show how many times the lemon has been squeezed.
     */
    private fun showSnackbar(): Boolean {
        if (lemonadeState != SQUEEZE) {
            return false
        }
        val squeezeText = getString(R.string.squeeze_count, squeezeCount)
        Snackbar.make(
            findViewById(R.id.constraint_Layout),
            squeezeText,
            Snackbar.LENGTH_SHORT
        ).show()
        return true
    }
}

/**
 * A Lemon tree class with a method to "pick" a lemon. The "size" of the lemon is randomized
 * and determines how many times a lemon needs to be squeezed before you get lemonade.
 */
class LemonTree {
    fun pick(): Int {
        return (2..4).random()
    }
}
