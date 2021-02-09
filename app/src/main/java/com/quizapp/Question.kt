package com.quizapp

import android.media.Image

data class Question(
    val id: Int,
    val question: String,
    val image:Int,
    val optionFirst:String,
    val optionSecond:String,
    val optionThird:String,
    val optionFourth:String,
    val correctAnswer:Int

)