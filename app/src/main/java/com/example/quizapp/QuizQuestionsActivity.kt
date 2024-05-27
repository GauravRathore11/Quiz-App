package com.example.quizapp

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class QuizQuestionsActivity : AppCompatActivity(),View.OnClickListener {

    private var questionList : ArrayList<Question>? = null
    private var currentQuestion : Int = 1
    private var selectedOption : Int = 0
    private var score=0

    private var progressBar : ProgressBar? = null
    private var tvProgress : TextView? = null
    private var tvQuestion : TextView? = null
    private var ivFlag : ImageView? = null

    private var tvOptionOne : TextView? = null
    private var tvOptionTwo : TextView? = null
    private var tvOptionThree : TextView? = null
    private var tvOptionFour : TextView? = null
    private var nextBtn : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        progressBar=findViewById(R.id.progressBar)
        tvProgress=findViewById(R.id.tv_progress)
        tvQuestion=findViewById(R.id.tv_question)
        ivFlag=findViewById(R.id.iv_flag)
        tvOptionOne=findViewById(R.id.tv_option1)
        tvOptionTwo=findViewById(R.id.tv_option2)
        tvOptionThree=findViewById(R.id.tv_option3)
        tvOptionFour=findViewById(R.id.tv_option4)
        nextBtn=findViewById<Button>(R.id.btn_next)

        questionList  = Constants.getQuestions()

        setQuestion()
    }

    private fun QuizQuestionsActivity.setQuestion() {
        defaultOptionsView()
        val question = questionList!![currentQuestion - 1]

        ivFlag?.setImageResource(question.img)
        progressBar?.progress = currentQuestion
        tvProgress?.text = "${currentQuestion}/${progressBar?.max}"
        tvQuestion?.text = question.question
        tvOptionOne?.text = question.optionOne
        tvOptionTwo?.text = question.optionTwo
        tvOptionThree?.text = question.optionThree
        tvOptionFour?.text = question.optionFour

        tvOptionOne?.setOnClickListener(this)
        tvOptionTwo?.setOnClickListener(this)
        tvOptionThree?.setOnClickListener(this)
        tvOptionFour?.setOnClickListener(this)
        nextBtn?.setOnClickListener(this)

        if(currentQuestion==questionList!!.size){
            nextBtn?.text="Finish"
        }
        else{
            nextBtn?.text="Next"
        }
    }

    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()

        tvOptionOne?.let{
            options.add(0,it)
        }
        tvOptionTwo?.let{
            options.add(1,it)
        }
        tvOptionThree?.let{
            options.add(2,it)
        }
        tvOptionFour?.let{
            options.add(3,it)
        }

        for(option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface= Typeface.DEFAULT
            option.background=ContextCompat.getDrawable(
                this,
                R.drawable.default_option_background_bg
            )
        }
    }

    private fun selectedOptionView(tv : TextView,selectedOptionNum : Int){
        defaultOptionsView()
        selectedOption = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background=ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.tv_option1->{
                tvOptionOne?.let{
                    selectedOptionView(it,1)
                }
            }
            R.id.tv_option2->{
                tvOptionTwo?.let{
                    selectedOptionView(it,2)
                }
            }
            R.id.tv_option3->{
                tvOptionThree?.let{
                    selectedOptionView(it,3)
                }
            }
            R.id.tv_option4->{
                tvOptionFour?.let{
                    selectedOptionView(it,4)
                }
            }
            R.id.btn_next->{
                if(selectedOption==0){
                    currentQuestion++

                    if(currentQuestion<=questionList!!.size){
                        setQuestion()
                    }
                    else{
                        Toast.makeText(this,"Score : ${score}/10",Toast.LENGTH_LONG).show()
                    }
                }
                else{
                    val question = questionList!!.get(currentQuestion-1)
                    if(question!!.correctAns != selectedOption){
                        answerView(selectedOption,R.drawable.wrong_option_background_bg)
                    }
                    else{
                        score++
                    }
                    answerView(question!!.correctAns,R.drawable.correct_option_background_bg)
                }

                if(currentQuestion == questionList?.size){
                    nextBtn?.text="Finish"
                }



                selectedOption=0
            }
        }
    }

    private fun answerView(answer : Int,drawableView : Int){
        when(answer){
            1->{
                tvOptionOne?.background=ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            2->{
                tvOptionTwo?.background=ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            3->{
                tvOptionThree?.background=ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            4->{
                tvOptionFour?.background=ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
        }
    }
}