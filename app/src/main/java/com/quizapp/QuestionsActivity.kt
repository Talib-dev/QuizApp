package com.quizapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class QuestionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val TAG = "QuestionsActivity"

        setContentView(R.layout.activity_questions)
        val questionsList = Constent.getQuestions()
        Log.d(TAG, "${questionsList.size}")
    }
}