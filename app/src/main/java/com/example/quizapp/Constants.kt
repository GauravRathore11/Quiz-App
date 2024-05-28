package com.example.quizapp

object Constants {

    const val USER_NAME : String = "user_name"
    const val TOTAL_QUESTIONS : String = "total_questions"
    const val CORRECT_ANSWERS : String = "correct_answers"

    fun getQuestions() : ArrayList<Question> {
        val questionsList = ArrayList<Question>()

        val ques1 = Question(
            1,"What Country does this flag belong to?",
            R.drawable.argentina_flag,
            "Argentina","Australia","India",
            "Kuwait",1
        )
        questionsList.add(ques1)

        val ques2 = Question(
            1,"What Country does this flag belong to?",
            R.drawable.australia_flag,
            "Austria","New Zee Land","India",
            "Australia",4
        )
        questionsList.add(ques2)

        val ques3 = Question(
            1,"What Country does this flag belong to?",
            R.drawable.belgium_flag,
            "Argentina","Belgium","India",
            "Kuwait",2
        )
        questionsList.add(ques3)

        val ques4 = Question(
            1,"What Country does this flag belong to?",
            R.drawable.brazil_flag,
            "Shri Lanka","Japan","Brazil",
            "Saudi Arabia",3
        )
        questionsList.add(ques4)

        val ques5 = Question(
            1,"What Country does this flag belong to?",
            R.drawable.denmark_flag,
            "Poland","China","India",
            "Denmark",4
        )
        questionsList.add(ques5)

        val ques6 = Question(
            1,"What Country does this flag belong to?",
            R.drawable.fiji_flag,
            "Fiji","canada","Nepal",
            "Kuwait",1
        )
        questionsList.add(ques6)

        val ques7 = Question(
            1,"What Country does this flag belong to?",
            R.drawable.germany_flag,
            "Russia","Ukraine","America",
            "Germany",4
        )
        questionsList.add(ques7)

        val ques8 = Question(
            1,"What Country does this flag belong to?",
            R.drawable.india_flag,
            "Ukraine","SwitzerLand","India",
            "Kuwait",3
        )
        questionsList.add(ques8)

        val ques9 = Question(
            1,"What Country does this flag belong to?",
            R.drawable.kuwait_flag,
            "Zimbabwe","Qatar","Hungary",
            "Kuwait",4
        )
        questionsList.add(ques9)

        val ques10 = Question(
            1,"What Country does this flag belong to?",
            R.drawable.finland_flag,
            "Finland","Austria","United States",
            "NetherLands",1
        )
        questionsList.add(ques10)

        return questionsList
    }
}