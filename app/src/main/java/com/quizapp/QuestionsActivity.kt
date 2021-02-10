package com.quizapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_questions.*

class QuestionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val TAG = "QuestionsActivity"
        val currentPosition=1

        setContentView(R.layout.activity_questions)
        val questionsList = Constent.getQuestions()
        Log.d(TAG, "${questionsList.size}")
        val question:Question=questionsList[currentPosition-1]

        tv_question.text=question.question
        iv_image.setImageResource(question.image)
        progressBar.progress=currentPosition
        tv_progress.text= "$currentPosition/10"
        tv_option_one.text =question.optionFirst
        tv_option_two.text =question.optionSecond
        tv_option_three.text = question.optionThird
        tv_option_four.text = question.optionFourth

    }
}