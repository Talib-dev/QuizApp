package com.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.quizapp.Constent.USER_NAME

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var mUserName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        //This call the parent constructor
        super.onCreate(savedInstanceState)
        // This is used to align the xml view to this class
        setContentView(R.layout.activity_main)

        mUserName = intent.getStringExtra(USER_NAME)


        btn_start.setOnClickListener {
            if (et_name.text.toString().isEmpty()){
                Toast.makeText(this,
                    "Please enter Name!",Toast.LENGTH_SHORT).show()
            }
            else{
                val intent =Intent(this,QuestionsActivity::class.java)
                // START
                intent.putExtra(USER_NAME, et_name.text.toString())
                // END
                startActivity(intent)
                finish()
            }
        }
    }
}