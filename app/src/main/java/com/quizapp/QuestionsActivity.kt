package com.quizapp

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_questions.*

class QuestionsActivity : AppCompatActivity(), View.OnClickListener {
    private var currentPosition = 1
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedOption: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)
        setQuestion()

        tv_option_one.setOnClickListener(this)
        tv_option_two.setOnClickListener(this)
        tv_option_three.setOnClickListener(this)
        tv_option_four.setOnClickListener(this)


    }

    private fun setQuestion() {

        setDefault()
        mQuestionsList = Constent.getQuestions()
        val question: Question = mQuestionsList!![currentPosition - 1]

        tv_question.text = question.question
        iv_image.setImageResource(question.image)
        progressBar.progress = currentPosition
        tv_progress.text = "$currentPosition/10"
        tv_option_one.text = question.optionFirst
        tv_option_two.text = question.optionSecond
        tv_option_three.text = question.optionThird
        tv_option_four.text = question.optionFourth

    }

    private fun setDefault() {
        var mList = ArrayList<TextView>()
        mList.add(0, tv_option_one)
        mList.add(1, tv_option_two)
        mList.add(2, tv_option_three)
        mList.add(3, tv_option_four)

        for (tv in mList) {
            tv.setTextColor(Color.parseColor("#7A8089"))
            tv.typeface = Typeface.DEFAULT
            tv.background = getDrawable(R.drawable.question_textview_bg)
        }
    }

    private fun selectAnswer(tv: TextView, selected: Int) {
        setDefault()
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.typeface = Typeface.DEFAULT_BOLD
        tv.background = getDrawable(R.drawable.selected_textview_bg)
        mSelectedOption = selected
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tv_option_one -> {
                selectAnswer(tv_option_one, 1)
            }
            R.id.tv_option_two -> {
                selectAnswer(tv_option_two, 2)
            }
            R.id.tv_option_three -> {
                selectAnswer(tv_option_three, 3)
            }
            R.id.tv_option_four -> {
                selectAnswer(tv_option_four, 4)
            }

        }
    }
}