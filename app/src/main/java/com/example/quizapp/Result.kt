package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Result : AppCompatActivity() {
    private var userName : String? = null
    private var totalQuestions : String? = null
    private var correctAnswers : String? = null

    private var tvName : TextView? = null
    private var tvScore : TextView? = null
    private var btnFinish : Button? = null
    private var btnRestart : Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        userName = intent.getStringExtra(Constants.USER_NAME)
        totalQuestions = intent.getStringExtra(Constants.TOTAL_QUESTIONS)
        correctAnswers = intent.getStringExtra(Constants.CORRECT_ANSWERS)


        tvScore = findViewById(R.id.tv_score)
        tvName = findViewById(R.id.tv_name)
        btnFinish = findViewById(R.id.btn_finish)
        btnRestart = findViewById(R.id.btn_restart)

        tvName?.text=userName
        tvScore?.text= "Your Score is $correctAnswers out of $totalQuestions"

        btnFinish?.setOnClickListener{
            finish()
        }

        btnRestart?.setOnClickListener{
            val intent:Intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}