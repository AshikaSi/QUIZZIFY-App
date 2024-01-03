package jiya.learning.quizzify

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import jiya.learning.quizzify.databinding.ActivitySecondBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import androidx.recyclerview.widget.RecyclerView;




class InsertionActivity : AppCompatActivity() {

    //10 times
    private lateinit var Quizgenre: EditText

    private lateinit var etQuestionNum1: EditText
    private lateinit var etQuestion1: EditText
    private lateinit var etoptionA1: EditText
    private lateinit var etoptionB1: EditText
    private lateinit var etoptionC1: EditText
    private lateinit var etoptionD1: EditText

    private lateinit var etQuestionNum2: EditText
    private lateinit var etQuestion2: EditText
    private lateinit var etoptionA2: EditText
    private lateinit var etoptionB2: EditText
    private lateinit var etoptionC2: EditText
    private lateinit var etoptionD2: EditText

    private lateinit var etQuestionNum3: EditText
    private lateinit var etQuestion3: EditText
    private lateinit var etoptionA3: EditText
    private lateinit var etoptionB3: EditText
    private lateinit var etoptionC3: EditText
    private lateinit var etoptionD3: EditText

    private lateinit var etQuestionNum4: EditText
    private lateinit var etQuestion4: EditText
    private lateinit var etoptionA4: EditText
    private lateinit var etoptionB4: EditText
    private lateinit var etoptionC4: EditText
    private lateinit var etoptionD4: EditText

    private lateinit var etQuestionNum5: EditText
    private lateinit var etQuestion5: EditText
    private lateinit var etoptionA5: EditText
    private lateinit var etoptionB5: EditText
    private lateinit var etoptionC5: EditText
    private lateinit var etoptionD5: EditText

    private lateinit var etQuestionNum6: EditText
    private lateinit var etQuestion6: EditText
    private lateinit var etoptionA6: EditText
    private lateinit var etoptionB6: EditText
    private lateinit var etoptionC6: EditText
    private lateinit var etoptionD6: EditText

    private lateinit var etQuestionNum7: EditText
    private lateinit var etQuestion7: EditText
    private lateinit var etoptionA7: EditText
    private lateinit var etoptionB7: EditText
    private lateinit var etoptionC7: EditText
    private lateinit var etoptionD7: EditText

    private lateinit var etQuestionNum8: EditText
    private lateinit var etQuestion8: EditText
    private lateinit var etoptionA8: EditText
    private lateinit var etoptionB8: EditText
    private lateinit var etoptionC8: EditText
    private lateinit var etoptionD8: EditText

    private lateinit var etQuestionNum9: EditText
    private lateinit var etQuestion9: EditText
    private lateinit var etoptionA9: EditText
    private lateinit var etoptionB9: EditText
    private lateinit var etoptionC9: EditText
    private lateinit var etoptionD9: EditText

    private lateinit var etQuestionNum10: EditText
    private lateinit var etQuestion10: EditText
    private lateinit var etoptionA10: EditText
    private lateinit var etoptionB10: EditText
    private lateinit var etoptionC10: EditText
    private lateinit var etoptionD10: EditText

    private lateinit var dbRef: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insertion)

//10 times
        Quizgenre = findViewById(R.id.Quizgenre)

        etQuestionNum1 = findViewById(R.id.QuestionNum1)
        etQuestion1 = findViewById(R.id.editTextQuestion1)
        etoptionA1 = findViewById(R.id.editTextOptionA1)
        etoptionB1 = findViewById(R.id.editTextOptionB1)
        etoptionC1 = findViewById(R.id.editTextOptionC1)
        etoptionD1 = findViewById(R.id.editTextOptionD1)

        etQuestionNum2 = findViewById(R.id.QuestionNum2)
        etQuestion2 = findViewById(R.id.editTextQuestion2)
        etoptionA2 = findViewById(R.id.editTextOptionA2)
        etoptionB2 = findViewById(R.id.editTextOptionB2)
        etoptionC2 = findViewById(R.id.editTextOptionC2)
        etoptionD2 = findViewById(R.id.editTextOptionD2)

        etQuestionNum3 = findViewById(R.id.QuestionNum3)
        etQuestion3 = findViewById(R.id.editTextQuestion3)
        etoptionA3 = findViewById(R.id.editTextOptionA3)
        etoptionB3 = findViewById(R.id.editTextOptionB3)
        etoptionC3 = findViewById(R.id.editTextOptionC3)
        etoptionD4 = findViewById(R.id.editTextOptionD4)

        etQuestionNum4 = findViewById(R.id.QuestionNum4)
        etQuestion4 = findViewById(R.id.editTextQuestion4)
        etoptionA4 = findViewById(R.id.editTextOptionA4)
        etoptionB4 = findViewById(R.id.editTextOptionB4)
        etoptionC4 = findViewById(R.id.editTextOptionC4)
        etoptionD4 = findViewById(R.id.editTextOptionD4)

        etQuestionNum5 = findViewById(R.id.QuestionNum5)
        etQuestion5 = findViewById(R.id.editTextQuestion5)
        etoptionA5 = findViewById(R.id.editTextOptionA5)
        etoptionB5 = findViewById(R.id.editTextOptionB5)
        etoptionC5 = findViewById(R.id.editTextOptionC5)
        etoptionD5 = findViewById(R.id.editTextOptionD5)

        etQuestionNum6 = findViewById(R.id.QuestionNum6)
        etQuestion6 = findViewById(R.id.editTextQuestion6)
        etoptionA6 = findViewById(R.id.editTextOptionA6)
        etoptionB6 = findViewById(R.id.editTextOptionB6)
        etoptionC6 = findViewById(R.id.editTextOptionC6)
        etoptionD6 = findViewById(R.id.editTextOptionD6)

        etQuestionNum7 = findViewById(R.id.QuestionNum7)
        etQuestion7 = findViewById(R.id.editTextQuestion7)
        etoptionA7 = findViewById(R.id.editTextOptionA7)
        etoptionB7 = findViewById(R.id.editTextOptionB7)
        etoptionC7 = findViewById(R.id.editTextOptionC7)
        etoptionD7 = findViewById(R.id.editTextOptionD7)

        etQuestionNum8 = findViewById(R.id.QuestionNum8)
        etQuestion8 = findViewById(R.id.editTextQuestion8)
        etoptionA8 = findViewById(R.id.editTextOptionA8)
        etoptionB8 = findViewById(R.id.editTextOptionB8)
        etoptionC8 = findViewById(R.id.editTextOptionC8)
        etoptionD8 = findViewById(R.id.editTextOptionD8)

        etQuestionNum9 = findViewById(R.id.QuestionNum9)
        etQuestion9 = findViewById(R.id.editTextQuestion9)
        etoptionA9 = findViewById(R.id.editTextOptionA9)
        etoptionB9 = findViewById(R.id.editTextOptionB9)
        etoptionC9 = findViewById(R.id.editTextOptionC9)
        etoptionD9 = findViewById(R.id.editTextOptionD9)

        etQuestionNum10 = findViewById(R.id.QuestionNum10)
        etQuestion10 = findViewById(R.id.editTextQuestion10)
        etoptionA10 = findViewById(R.id.editTextOptionA10)
        etoptionB10 = findViewById(R.id.editTextOptionB10)
        etoptionC10 = findViewById(R.id.editTextOptionC10)
        etoptionD10 = findViewById(R.id.editTextOptionD10)

        dbRef = FirebaseDatabase.getInstance()
            .getReference("QuizQuestions")//In future remember this name to open the database and fetch your data stored there

        val buttonSaveData: Button = findViewById(R.id.buttonSavedata)
        buttonSaveData.setOnClickListener {
            saveQuizQuestionsData()//function
        }
    }

    private fun saveQuizQuestionsData() {
        //getting or retrieve values
        val quizGenre = Quizgenre.text.toString()
        val QuestionNum1 = etQuestionNum1.text.toString()
        val Question1 = etQuestion1.text.toString()
        val optionA1 = etoptionA1.text.toString()
        val optionB1 = etoptionB1.text.toString()
        val optionC1 = etoptionC1.text.toString()
        val optionD1 = etoptionD1.text.toString()

        val QuestionNum2 = etQuestionNum2.text.toString()
        val Question2 = etQuestion2.text.toString()
        val optionA2 = etoptionA2.text.toString()
        val optionB2 = etoptionB2.text.toString()
        val optionC2 = etoptionC2.text.toString()
        val optionD2 = etoptionD2.text.toString()

        val QuestionNum3 = etQuestionNum3.text.toString()
        val Question3 = etQuestion3.text.toString()
        val optionA3 = etoptionA3.text.toString()
        val optionB3 = etoptionB3.text.toString()
        val optionC3 = etoptionC3.text.toString()
        val optionD3 = etoptionD3.text.toString()

        val QuestionNum4 = etQuestionNum4.text.toString()
        val Question4 = etQuestion4.text.toString()
        val optionA4 = etoptionA4.text.toString()
        val optionB4 = etoptionB4.text.toString()
        val optionC4 = etoptionC4.text.toString()
        val optionD4 = etoptionD4.text.toString()

        val QuestionNum5 = etQuestionNum5.text.toString()
        val Question5 = etQuestion5.text.toString()
        val optionA5 = etoptionA5.text.toString()
        val optionB5 = etoptionB5.text.toString()
        val optionC5 = etoptionC5.text.toString()
        val optionD5 = etoptionD5.text.toString()

        val QuestionNum6 = etQuestionNum6.text.toString()
        val Question6 = etQuestion6.text.toString()
        val optionA6 = etoptionA6.text.toString()
        val optionB6 = etoptionB6.text.toString()
        val optionC6 = etoptionC6.text.toString()
        val optionD6 = etoptionD6.text.toString()

        val QuestionNum7 = etQuestionNum7.text.toString()
        val Question7 = etQuestion7.text.toString()
        val optionA7 = etoptionA7.text.toString()
        val optionB7 = etoptionB7.text.toString()
        val optionC7 = etoptionC7.text.toString()
        val optionD7 = etoptionD7.text.toString()

        val QuestionNum8 = etQuestionNum8.text.toString()
        val Question8 = etQuestion8.text.toString()
        val optionA8 = etoptionA8.text.toString()
        val optionB8 = etoptionB8.text.toString()
        val optionC8 = etoptionC8.text.toString()
        val optionD8 = etoptionD8.text.toString()

        val QuestionNum9 = etQuestionNum9.text.toString()
        val Question9 = etQuestion9.text.toString()
        val optionA9 = etoptionA9.text.toString()
        val optionB9 = etoptionB9.text.toString()
        val optionC9 = etoptionC9.text.toString()
        val optionD9 = etoptionD9.text.toString()

        val QuestionNum10 = etQuestionNum10.text.toString()
        val Question10 = etQuestion10.text.toString()
        val optionA10 = etoptionA10.text.toString()
        val optionB10 = etoptionB10.text.toString()
        val optionC10 = etoptionC10.text.toString()
        val optionD10 = etoptionD10.text.toString()


        if (QuestionNum1.isEmpty()) {
            etQuestionNum1.error = "Please enter the question number."
        }
        if (Question1.isEmpty()) {
            etQuestion1.error = "Please enter the question."
        }
        if (optionA1.isEmpty()) {
            etoptionA1.error = "Please enter the option A."
        }
        if (optionB1.isEmpty()) {
            etoptionB1.error = "Please enter the option B."
        }
        if (optionC1.isEmpty()) {
            etoptionC1.error = "Please enter the option C."
        }
        if (optionD1.isEmpty()) {
            etoptionD1.error = "Please enter the option D."
        }


        val quizid = dbRef.push().key!! //to denote an id for a quiz

        val list = Questionslist(
            quizGenre, quizid, QuestionNum1, Question1, optionA1, optionB1, optionC1, optionD1,
            QuestionNum2, Question2, optionA2, optionB2, optionC2, optionD2,
            QuestionNum3, Question3, optionA3, optionB3, optionC3, optionD3,
            QuestionNum4, Question4, optionA4, optionB4, optionC4, optionD4,
            QuestionNum5, Question5, optionA5, optionB5, optionC5, optionD5,
            QuestionNum6, Question6, optionA6, optionB6, optionC6, optionD6,
            QuestionNum7, Question7, optionA7, optionB7, optionC7, optionD7,
            QuestionNum8, Question8, optionA8, optionB8, optionC8, optionD8,
            QuestionNum9, Question9, optionA9, optionB9, optionC9, optionD9,
            QuestionNum10, Question10, optionA10, optionB10, optionC10, optionD10
        )

        dbRef.child(quizid).setValue(list)
            .addOnCompleteListener {
                Toast.makeText(this, "Data inserted successfully", Toast.LENGTH_LONG).show()

                Quizgenre.text.clear()

                etQuestionNum1.text.clear()
                etQuestion1.text.clear()
                etoptionA1.text.clear()
                etoptionB1.text.clear()
                etoptionC1.text.clear()
                etoptionD1.text.clear()

                etQuestionNum2.text.clear()
                etQuestion2.text.clear()
                etoptionA2.text.clear()
                etoptionB2.text.clear()
                etoptionC2.text.clear()
                etoptionD2.text.clear()

                etQuestionNum3.text.clear()
                etQuestion3.text.clear()
                etoptionA3.text.clear()
                etoptionB3.text.clear()
                etoptionC3.text.clear()
                etoptionD3.text.clear()

                etQuestionNum4.text.clear()
                etQuestion4.text.clear()
                etoptionA4.text.clear()
                etoptionB4.text.clear()
                etoptionC4.text.clear()
                etoptionD4.text.clear()

                etQuestionNum5.text.clear()
                etQuestion5.text.clear()
                etoptionA5.text.clear()
                etoptionB5.text.clear()
                etoptionC5.text.clear()
                etoptionD5.text.clear()

                etQuestionNum6.text.clear()
                etQuestion6.text.clear()
                etoptionA6.text.clear()
                etoptionB6.text.clear()
                etoptionC6.text.clear()
                etoptionD6.text.clear()

                etQuestionNum7.text.clear()
                etQuestion7.text.clear()
                etoptionA7.text.clear()
                etoptionB7.text.clear()
                etoptionC7.text.clear()
                etoptionD7.text.clear()

                etQuestionNum8.text.clear()
                etQuestion8.text.clear()
                etoptionA8.text.clear()
                etoptionB8.text.clear()
                etoptionC8.text.clear()
                etoptionD8.text.clear()

                etQuestionNum9.text.clear()
                etQuestion9.text.clear()
                etoptionA9.text.clear()
                etoptionB9.text.clear()
                etoptionC9.text.clear()
                etoptionD9.text.clear()

                etQuestionNum10.text.clear()
                etQuestion10.text.clear()
                etoptionA10.text.clear()
                etoptionB10.text.clear()
                etoptionC10.text.clear()
                etoptionD10.text.clear()

            }.addOnFailureListener { err ->
                Toast.makeText(this, "Error ${err.message}", Toast.LENGTH_LONG).show()
            }
    }
}


