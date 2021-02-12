package com.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_questions.*

class QuestionsActivity : AppCompatActivity(), View.OnClickListener {
    private var currentPosition = 1
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedOption: Int = 1
    private var mSelectedOptionPosition: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)
        setQuestion()

        tv_option_one.setOnClickListener(this)
        tv_option_two.setOnClickListener(this)
        tv_option_three.setOnClickListener(this)
        tv_option_four.setOnClickListener(this)

        btn_submit.setOnClickListener(this)


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


    private fun setAnswer(tv: TextView, drawable: Int) {
        tv.background = getDrawable(drawable)

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tv_option_one -> {
                selectAnswer(tv_option_one, 1)
                mSelectedOptionPosition=1
            }
            R.id.tv_option_two -> {
                selectAnswer(tv_option_two, 2)
                mSelectedOptionPosition=2

            }
            R.id.tv_option_three -> {
                selectAnswer(tv_option_three, 3)
                mSelectedOptionPosition=3

            }
            R.id.tv_option_four -> {
                selectAnswer(tv_option_four, 4)
                mSelectedOptionPosition=4

            }
            R.id.btn_submit -> {
                setDefault()
                if (mSelectedOptionPosition == 0) {

                    currentPosition++

                    when {

                        currentPosition <= mQuestionsList!!.size -> {

                            setQuestion()
                        }
                        else -> {
                            Toast.makeText(this,"Completed",Toast.LENGTH_SHORT).show()
                        }
                    }
                } else {
                    val question = mQuestionsList?.get(currentPosition - 1)

                    // This is to check if the answer is wrong
                    if (question!!.correctAnswer != mSelectedOptionPosition) {
                        answerView(mSelectedOptionPosition, R.drawable.wrong_textview_bg)
                    }
                    // This is for correct answer
                    answerView(question.correctAnswer, R.drawable.correct_textview_bg)

                    if (currentPosition == mQuestionsList!!.size) {
                        btn_submit.text = "FINISH"
                    } else {
                        btn_submit.text = "GO TO NEXT QUESTION"
                    }

                    mSelectedOptionPosition = 0
                }
            }
        }

    }

    /**
     * A function for answer view which is used to highlight the answer is wrong or right.
     */
    private fun answerView(answer: Int, drawableView: Int) {

        when (answer) {

            1 -> {
                tv_option_one.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            2 -> {
                tv_option_two.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            3 -> {
                tv_option_three.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            4 -> {
                tv_option_four.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
        }
    }

}
