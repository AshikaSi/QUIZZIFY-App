package jiya.learning.quizzify

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class QuizDetailsActivity : AppCompatActivity() {

    private lateinit var tvquizid : TextView
    private lateinit var tvQuizgenre : TextView
    private lateinit var tvQuestionNum1 : TextView
    private lateinit var tvQuestion1 : TextView
    private lateinit var tvoptionA1 : TextView
    private lateinit var tvoptionB1 : TextView
    private lateinit var tvoptionC1 : TextView
    private lateinit var tvoptionD1 : TextView

    private lateinit var tvQuestionNum2 : TextView
    private lateinit var tvQuestion2 : TextView
    private lateinit var tvoptionA2 : TextView
    private lateinit var tvoptionB2 : TextView
    private lateinit var tvoptionC2 : TextView
    private lateinit var tvoptionD2 : TextView

    private lateinit var tvQuestionNum3 : TextView
    private lateinit var tvQuestion3 : TextView
    private lateinit var tvoptionA3 : TextView
    private lateinit var tvoptionB3 : TextView
    private lateinit var tvoptionC3 : TextView
    private lateinit var tvoptionD3 : TextView

    private lateinit var tvQuestionNum4 : TextView
    private lateinit var tvQuestion4 : TextView
    private lateinit var tvoptionA4 : TextView
    private lateinit var tvoptionB4 : TextView
    private lateinit var tvoptionC4 : TextView
    private lateinit var tvoptionD4 : TextView

    private lateinit var tvQuestionNum5 : TextView
    private lateinit var tvQuestion5 : TextView
    private lateinit var tvoptionA5 : TextView
    private lateinit var tvoptionB5 : TextView
    private lateinit var tvoptionC5 : TextView
    private lateinit var tvoptionD5 : TextView

    private lateinit var tvQuestionNum6 : TextView
    private lateinit var tvQuestion6 : TextView
    private lateinit var tvoptionA6 : TextView
    private lateinit var tvoptionB6 : TextView
    private lateinit var tvoptionC6 : TextView
    private lateinit var tvoptionD6 : TextView

    private lateinit var tvQuestionNum7 : TextView
    private lateinit var tvQuestion7 : TextView
    private lateinit var tvoptionA7 : TextView
    private lateinit var tvoptionB7 : TextView
    private lateinit var tvoptionC7 : TextView
    private lateinit var tvoptionD7 : TextView

    private lateinit var tvQuestionNum8 : TextView
    private lateinit var tvQuestion8 : TextView
    private lateinit var tvoptionA8 : TextView
    private lateinit var tvoptionB8 : TextView
    private lateinit var tvoptionC8 : TextView
    private lateinit var tvoptionD8 : TextView

    private lateinit var tvQuestionNum9 : TextView
    private lateinit var tvQuestion9 : TextView
    private lateinit var tvoptionA9 : TextView
    private lateinit var tvoptionB9 : TextView
    private lateinit var tvoptionC9 : TextView
    private lateinit var tvoptionD9 : TextView

    private lateinit var tvQuestionNum10 : TextView
    private lateinit var tvQuestion10 : TextView
    private lateinit var tvoptionA10 : TextView
    private lateinit var tvoptionB10 : TextView
    private lateinit var tvoptionC10 : TextView
    private lateinit var tvoptionD10 : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_details)

        initView()
        setValuesToViews()

    }
    private fun initView(){}
    private fun setValuesToViews(){

        tvquizid.text = intent.getStringExtra("quizid")
        tvQuizgenre.text = intent.getStringExtra("Quizgenre")
        tvQuestionNum1.text = intent.getStringExtra("QuestionNum1")
        tvQuestion1.text = intent.getStringExtra("Question1")
        tvoptionA1.text = intent.getStringExtra("optionA1")
        tvoptionB1.text = intent.getStringExtra("optionB1")
        tvoptionC1.text = intent.getStringExtra("optionC1")
        tvoptionD1.text = intent.getStringExtra("optionD1")

        tvQuestionNum2.text = intent.getStringExtra("QuestionNum2")
        tvQuestion2.text = intent.getStringExtra("Question2")
        tvoptionA2.text = intent.getStringExtra("optionA2")
        tvoptionB2.text = intent.getStringExtra("optionB2")
        tvoptionC2.text = intent.getStringExtra("optionC2")
        tvoptionD2.text = intent.getStringExtra("optionD2")

        tvQuestionNum3.text = intent.getStringExtra("QuestionNum3")
        tvQuestion3.text = intent.getStringExtra("Question3")
        tvoptionA3.text = intent.getStringExtra("optionA3")
        tvoptionB3.text = intent.getStringExtra("optionB3")
        tvoptionC3.text = intent.getStringExtra("optionC3")
        tvoptionD3.text = intent.getStringExtra("optionD3")

        tvQuestionNum4.text = intent.getStringExtra("QuestionNum4")
        tvQuestion4.text = intent.getStringExtra("Question4")
        tvoptionA4.text = intent.getStringExtra("optionA4")
        tvoptionB4.text = intent.getStringExtra("optionB4")
        tvoptionC4.text = intent.getStringExtra("optionC4")
        tvoptionD4.text = intent.getStringExtra("optionD4")

        tvQuestionNum5.text = intent.getStringExtra("QuestionNum5")
        tvQuestion5.text = intent.getStringExtra("Question5")
        tvoptionA5.text = intent.getStringExtra("optionA5")
        tvoptionB5.text = intent.getStringExtra("optionB5")
        tvoptionC5.text = intent.getStringExtra("optionC5")
        tvoptionD5.text = intent.getStringExtra("optionD5")

        tvQuestionNum6.text = intent.getStringExtra("QuestionNum6")
        tvQuestion6.text = intent.getStringExtra("Question6")
        tvoptionA6.text = intent.getStringExtra("optionA6")
        tvoptionB6.text = intent.getStringExtra("optionB6")
        tvoptionC6.text = intent.getStringExtra("optionC6")
        tvoptionD6.text = intent.getStringExtra("optionD6")

        tvQuestionNum7.text = intent.getStringExtra("QuestionNum7")
        tvQuestion7.text = intent.getStringExtra("Question7")
        tvoptionA7.text = intent.getStringExtra("optionA7")
        tvoptionB7.text = intent.getStringExtra("optionB7")
        tvoptionC7.text = intent.getStringExtra("optionC7")
        tvoptionD7.text = intent.getStringExtra("optionD7")

        tvQuestionNum8.text = intent.getStringExtra("QuestionNum8")
        tvQuestion8.text = intent.getStringExtra("Question8")
        tvoptionA8.text = intent.getStringExtra("optionA8")
        tvoptionB8.text = intent.getStringExtra("optionB8")
        tvoptionC8.text = intent.getStringExtra("optionC8")
        tvoptionD8.text = intent.getStringExtra("optionD8")

        tvQuestionNum9.text = intent.getStringExtra("QuestionNum9")
        tvQuestion9.text = intent.getStringExtra("Question9")
        tvoptionA9.text = intent.getStringExtra("optionA9")
        tvoptionB9.text = intent.getStringExtra("optionB9")
        tvoptionC9.text = intent.getStringExtra("optionC9")
        tvoptionD9.text = intent.getStringExtra("optionD9")

        tvQuestionNum10.text = intent.getStringExtra("QuestionNum10")
        tvQuestion10.text = intent.getStringExtra("Question10")
        tvoptionA10.text = intent.getStringExtra("optionA10")
        tvoptionB10.text = intent.getStringExtra("optionB10")
        tvoptionC10.text = intent.getStringExtra("optionC10")
        tvoptionD10.text = intent.getStringExtra("optionD10")


    }
}