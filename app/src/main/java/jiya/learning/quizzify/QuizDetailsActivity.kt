package jiya.learning.quizzify
import android.util.Log
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.os.CountDownTimer
import android.content.Intent
import android.view.View
import android.widget.Toast
import android.widget.EditText
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class QuizDetailsActivity : AppCompatActivity() {

    private var score: Double = 0.0
    private lateinit var quizid: TextView
    private lateinit var tvQuizgenre: TextView
    private lateinit var tvQuestionNum1: TextView
    private lateinit var tvQuestion1: TextView
    private lateinit var tvoptionA1: TextView
    private lateinit var tvoptionB1: TextView
    private lateinit var tvoptionC1: TextView
    private lateinit var tvoptionD1: TextView

    private lateinit var tvQuestionNum2: TextView
    private lateinit var tvQuestion2: TextView
    private lateinit var tvoptionA2: TextView
    private lateinit var tvoptionB2: TextView
    private lateinit var tvoptionC2: TextView
    private lateinit var tvoptionD2: TextView

    private lateinit var tvQuestionNum3: TextView
    private lateinit var tvQuestion3: TextView
    private lateinit var tvoptionA3: TextView
    private lateinit var tvoptionB3: TextView
    private lateinit var tvoptionC3: TextView
    private lateinit var tvoptionD3: TextView

    private lateinit var tvQuestionNum4: TextView
    private lateinit var tvQuestion4: TextView
    private lateinit var tvoptionA4: TextView
    private lateinit var tvoptionB4: TextView
    private lateinit var tvoptionC4: TextView
    private lateinit var tvoptionD4: TextView

    private lateinit var tvQuestionNum5: TextView
    private lateinit var tvQuestion5: TextView
    private lateinit var tvoptionA5: TextView
    private lateinit var tvoptionB5: TextView
    private lateinit var tvoptionC5: TextView
    private lateinit var tvoptionD5: TextView

    private lateinit var tvQuestionNum6: TextView
    private lateinit var tvQuestion6: TextView
    private lateinit var tvoptionA6: TextView
    private lateinit var tvoptionB6: TextView
    private lateinit var tvoptionC6: TextView
    private lateinit var tvoptionD6: TextView

    private lateinit var tvQuestionNum7: TextView
    private lateinit var tvQuestion7: TextView
    private lateinit var tvoptionA7: TextView
    private lateinit var tvoptionB7: TextView
    private lateinit var tvoptionC7: TextView
    private lateinit var tvoptionD7: TextView

    private lateinit var tvQuestionNum8: TextView
    private lateinit var tvQuestion8: TextView
    private lateinit var tvoptionA8: TextView
    private lateinit var tvoptionB8: TextView
    private lateinit var tvoptionC8: TextView
    private lateinit var tvoptionD8: TextView

    private lateinit var tvQuestionNum9: TextView
    private lateinit var tvQuestion9: TextView
    private lateinit var tvoptionA9: TextView
    private lateinit var tvoptionB9: TextView
    private lateinit var tvoptionC9: TextView
    private lateinit var tvoptionD9: TextView

    private lateinit var tvQuestionNum10: TextView
    private lateinit var tvQuestion10: TextView
    private lateinit var tvoptionA10: TextView
    private lateinit var tvoptionB10: TextView
    private lateinit var tvoptionC10: TextView
    private lateinit var tvoptionD10: TextView
    private lateinit var textView: TextView

//    private lateinit var storageReference: StorageReference
//    private lateinit var recyclerView: RecyclerView
//    private lateinit var imageAdapter: ImageAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_details)

        val submitButton: Button = findViewById(R.id.btnsubmit)
        val correctOption = intent.getStringExtra("CORRECT_ANSWER_ID1")

        submitButton.setOnClickListener {
            // Handle button click, e.g., navigate to LeaderActivity

            if (correctOption != null) {
                Log.d("physics",correctOption);
                checkAnswer(correctOption.toString())
            }else
                Log.d("physics","NULL")
            val intent = Intent(this, LeaderActivity::class.java)
            startActivity(intent)

        }

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        val textView: TextView = findViewById(R.id.textView)
        // time count down for 30 seconds,
        // with 1 second as countDown interval
        object : CountDownTimer(300000, 1000) {

            // Callback function, fired on regular interval
            override fun onTick(millisUntilFinished: Long) {
                val minutes = (millisUntilFinished / 1000) / 60
                val seconds = (millisUntilFinished / 1000) % 60
                val timerText = String.format("Time remaining: %02d:%02d", minutes, seconds)
                textView.text = timerText
            }

            // Callback function, fired when the time is up
            override fun onFinish() {
                textView.text = "Time's up!"
                // Start the LeaderActivity
                val intent = Intent(this@QuizDetailsActivity, LeaderActivity::class.java)
                startActivity(intent)

                // Finish the current activity (optional)
                finish()
            }
        }.start()

        initView()
        setValuesToViews()

    }

    private fun initView() {
        quizid = findViewById(R.id.tvquizid)
        tvQuizgenre = findViewById(R.id.tvQuizgenre)
        tvQuestionNum1 = findViewById(R.id.tvQuestionNum1)
        tvQuestion1 = findViewById(R.id.tvQuestion1)
        tvoptionA1 = findViewById(R.id.tvoptionA1)
        tvoptionB1 = findViewById(R.id.tvoptionB1)
        tvoptionC1 = findViewById(R.id.tvoptionC1)
        tvoptionD1 = findViewById(R.id.tvoptionD1)

        tvQuestionNum2 = findViewById(R.id.tvQuestionNum2)
        tvQuestion2 = findViewById(R.id.tvQuestion2)
        tvoptionA2 = findViewById(R.id.tvoptionA2)
        tvoptionB2 = findViewById(R.id.tvoptionB2)
        tvoptionC2 = findViewById(R.id.tvoptionC2)
        tvoptionD2 = findViewById(R.id.tvoptionD2)

        tvQuestionNum3 = findViewById(R.id.tvQuestionNum3)
        tvQuestion3 = findViewById(R.id.tvQuestion3)
        tvoptionA3 = findViewById(R.id.tvoptionA3)
        tvoptionB3 = findViewById(R.id.tvoptionB3)
        tvoptionC3 = findViewById(R.id.tvoptionC3)
        tvoptionD3 = findViewById(R.id.tvoptionD3)

        tvQuestionNum4 = findViewById(R.id.tvQuestionNum4)
        tvQuestion4 = findViewById(R.id.tvQuestion4)
        tvoptionA4 = findViewById(R.id.tvoptionA4)
        tvoptionB4 = findViewById(R.id.tvoptionB4)
        tvoptionC4 = findViewById(R.id.tvoptionC4)
        tvoptionD4 = findViewById(R.id.tvoptionD4)

        tvQuestionNum5 = findViewById(R.id.tvQuestionNum5)
        tvQuestion5 = findViewById(R.id.tvQuestion5)
        tvoptionA5 = findViewById(R.id.tvoptionA5)
        tvoptionB5 = findViewById(R.id.tvoptionB5)
        tvoptionC5 = findViewById(R.id.tvoptionC5)
        tvoptionD5 = findViewById(R.id.tvoptionD5)

        tvQuestionNum6 = findViewById(R.id.tvQuestionNum6)
        tvQuestion6 = findViewById(R.id.tvQuestion6)
        tvoptionA6 = findViewById(R.id.tvoptionA6)
        tvoptionB6 = findViewById(R.id.tvoptionB6)
        tvoptionC6 = findViewById(R.id.tvoptionC6)
        tvoptionD6 = findViewById(R.id.tvoptionD6)

        tvQuestionNum8 = findViewById(R.id.tvQuestionNum8)
        tvQuestion8 = findViewById(R.id.tvQuestion8)
        tvoptionA8 = findViewById(R.id.tvoptionA8)
        tvoptionB8 = findViewById(R.id.tvoptionB8)
        tvoptionC8 = findViewById(R.id.tvoptionC8)
        tvoptionD8 = findViewById(R.id.tvoptionD8)

        tvQuestionNum7 = findViewById(R.id.tvQuestionNum7)
        tvQuestion7 = findViewById(R.id.tvQuestion7)
        tvoptionA7 = findViewById(R.id.tvoptionA7)
        tvoptionB7 = findViewById(R.id.tvoptionB7)
        tvoptionC7 = findViewById(R.id.tvoptionC7)
        tvoptionD7 = findViewById(R.id.tvoptionD7)

        tvQuestionNum9 = findViewById(R.id.tvQuestionNum9)
        tvQuestion9 = findViewById(R.id.tvQuestion9)
        tvoptionA9 = findViewById(R.id.tvoptionA9)
        tvoptionB9 = findViewById(R.id.tvoptionB9)
        tvoptionC9 = findViewById(R.id.tvoptionC9)
        tvoptionD9 = findViewById(R.id.tvoptionD9)

        tvQuestionNum10 = findViewById(R.id.tvQuestionNum10)
        tvQuestion10 = findViewById(R.id.tvQuestion10)
        tvoptionA10 = findViewById(R.id.tvoptionA10)
        tvoptionB10 = findViewById(R.id.tvoptionB10)
        tvoptionC10 = findViewById(R.id.tvoptionC10)
        tvoptionD10 = findViewById(R.id.tvoptionD10)

    }

    private fun setValuesToViews() {

        quizid.text = intent.getStringExtra("quizid")
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

//    private fun calculateScore(): Double {
//
//        return score // Change this based on your scoring logic
//    }

    public fun checkAnswer( correctOption:String ) {
        val radioGroup: RadioGroup = findViewById(R.id.radioGroupOptions)
        val selectedRadioButtonId = radioGroup.checkedRadioButtonId

        if (selectedRadioButtonId != -1) {
            val selectedRadioGroup: RadioButton = findViewById(selectedRadioButtonId)

//            val correctOption = intent.getStringExtra("CORRECT_ANSWER_ID1")
            println(correctOption);
            println(selectedRadioGroup.text.toString())
            if (correctOption != null) {
                Log.d("physics",correctOption)
            }
            else
                Log.d("physics","null");
            if (correctOption != null && selectedRadioGroup.text.toString()
                    .equals(correctOption, ignoreCase = true))
            {
                Toast.makeText(this@QuizDetailsActivity, "Correct Answer", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this@QuizDetailsActivity, "Incorrect Answer", Toast.LENGTH_SHORT)
                    .show()
            }
        }else{

        }

    }

}
