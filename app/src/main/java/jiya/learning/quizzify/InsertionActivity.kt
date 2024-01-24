package jiya.learning.quizzify

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import androidx.core.content.FileProvider
import java.io.File
import java.io.FileOutputStream
import android.os.Bundle
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import android.provider.Browser
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.net.Uri
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.FirebaseApp
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import jiya.learning.quizzify.databinding.ActivitySecondBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.storage.FirebaseStorage
import android.provider.MediaStore
import com.google.firebase.storage.StorageReference
import java.util.*
import com.squareup.picasso.Picasso
import android.app.Activity



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
    private lateinit var btnSaveData: Button

    private lateinit var cp1: EditText
    private lateinit var cp2: EditText
    private lateinit var cp3: EditText
    private lateinit var cp4: EditText
    private lateinit var cp5: EditText
    private lateinit var cp6: EditText
    private lateinit var cp7: EditText
    private lateinit var cp8: EditText
    private lateinit var cp9: EditText
    private lateinit var cp10: EditText


    private lateinit var dbRef: DatabaseReference

    private var selectedImageUri: Uri? = null
    private lateinit var browseButton1: Button
    private lateinit var browseButton2: Button
    private lateinit var browseButton3: Button
    private lateinit var browseButton4: Button
    private lateinit var browseButton5: Button
    private lateinit var browseButton6: Button
    private lateinit var browseButton7: Button
    private lateinit var browseButton8: Button
    private lateinit var browseButton9: Button
    private lateinit var browseButton10: Button

    private lateinit var storageReference: StorageReference

    private lateinit var imageview1: ImageView
    private lateinit var imageview2: ImageView
    private lateinit var imageview3: ImageView
    private lateinit var imageview4: ImageView
    private lateinit var imageview5: ImageView
    private lateinit var imageview6: ImageView
    private lateinit var imageview7: ImageView
    private lateinit var imageview8: ImageView
    private lateinit var imageview9: ImageView
    private lateinit var imageview10: ImageView
    private lateinit var selectedImageView: ImageView

    private val PICK_IMAGE_REQUEST = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insertion)

        // Assuming you have the correct answer ID stored in a variable
        val correctanswer1 = "A1"

// Creating an Intent to start the second activity
        val intent = Intent(this, QuizDetailsActivity::class.java)

// Putting the correct answer ID as an extra in the Intent
        intent.putExtra("CORRECT_ANSWER_ID", correctanswer1)

// Starting the second activity
        startActivity(intent)

        storageReference = FirebaseStorage.getInstance().reference

        imageview1 = findViewById(R.id.imageView1)
        imageview2 = findViewById(R.id.imageView2)
        imageview3 = findViewById(R.id.imageView3)
        imageview4 = findViewById(R.id.imageView4)
        imageview5 = findViewById(R.id.imageView5)
        imageview6 = findViewById(R.id.imageView6)
        imageview7 = findViewById(R.id.imageView7)
        imageview8 = findViewById(R.id.imageView8)
        imageview9 = findViewById(R.id.imageView9)
        imageview10 = findViewById(R.id.imageView10)

        browseButton1 = findViewById(R.id.button1)
        browseButton2 = findViewById(R.id.button2)
        browseButton3 = findViewById(R.id.button3)
        browseButton4 = findViewById(R.id.button4)
        browseButton5 = findViewById(R.id.button5)
        browseButton6 = findViewById(R.id.button6)
        browseButton7 = findViewById(R.id.button7)
        browseButton8 = findViewById(R.id.button8)
        browseButton9 = findViewById(R.id.button9)
        browseButton10 = findViewById(R.id.button10)


        val imageSelectionClickListener = View.OnClickListener { view ->
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(intent, PICK_IMAGE_REQUEST)

            // Identify the corresponding ImageView based on the clicked button
            val imageView = when (view) {
                browseButton1 -> imageview1
                browseButton2 -> imageview2
                browseButton3 -> imageview3
                browseButton4 -> imageview4
                browseButton5 -> imageview5
                browseButton6 -> imageview6
                browseButton7 -> imageview7
                browseButton8 -> imageview8
                browseButton9 -> imageview9
                browseButton10 -> imageview10
                else -> throw IllegalArgumentException("Unknown button clicked")
            }

            // Save the ImageView reference for later use
            selectedImageView = imageView
        }

        browseButton1.setOnClickListener(imageSelectionClickListener)
        browseButton2.setOnClickListener(imageSelectionClickListener)
        browseButton3.setOnClickListener(imageSelectionClickListener)
        browseButton4.setOnClickListener(imageSelectionClickListener)
        browseButton5.setOnClickListener(imageSelectionClickListener)
        browseButton6.setOnClickListener(imageSelectionClickListener)
        browseButton7.setOnClickListener(imageSelectionClickListener)
        browseButton8.setOnClickListener(imageSelectionClickListener)
        browseButton9.setOnClickListener(imageSelectionClickListener)
        browseButton10.setOnClickListener(imageSelectionClickListener)
    }

    // Handle result from image picker
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null) {
            // Get the selected image URI
            selectedImageUri = data.data

            // Display the selected image in the corresponding ImageView
            selectedImageView?.setImageURI(selectedImageUri)

            // Upload the displayed image to Firebase Storage
            uploadImageToFirebase(selectedImageUri)
        }

//10 times
        Quizgenre = findViewById(R.id.Quizgenre)

        etQuestionNum1 = findViewById(R.id.QuestionNum1)
        etQuestion1 = findViewById(R.id.editTextQuestion1)
        etoptionA1 = findViewById(R.id.editTextOptionA1)
        etoptionB1 = findViewById(R.id.editTextOptionB1)
        etoptionC1 = findViewById(R.id.editTextOptionC1)
        etoptionD1 = findViewById(R.id.editTextOptionD1)
        cp1 = findViewById(R.id.correctanswer1)

        etQuestionNum2 = findViewById(R.id.QuestionNum2)
        etQuestion2 = findViewById(R.id.editTextQuestion2)
        etoptionA2 = findViewById(R.id.editTextOptionA2)
        etoptionB2 = findViewById(R.id.editTextOptionB2)
        etoptionC2 = findViewById(R.id.editTextOptionC2)
        etoptionD2 = findViewById(R.id.editTextOptionD2)
        cp2 = findViewById(R.id.correctanswer2)

        etQuestionNum3 = findViewById(R.id.QuestionNum3)
        etQuestion3 = findViewById(R.id.editTextQuestion3)
        etoptionA3 = findViewById(R.id.editTextOptionA3)
        etoptionB3 = findViewById(R.id.editTextOptionB3)
        etoptionC3 = findViewById(R.id.editTextOptionC3)
        etoptionD3 = findViewById(R.id.editTextOptionD3)
        cp3 = findViewById(R.id.correctanswer3)

        etQuestionNum4 = findViewById(R.id.QuestionNum4)
        etQuestion4 = findViewById(R.id.editTextQuestion4)
        etoptionA4 = findViewById(R.id.editTextOptionA4)
        etoptionB4 = findViewById(R.id.editTextOptionB4)
        etoptionC4 = findViewById(R.id.editTextOptionC4)
        etoptionD4 = findViewById(R.id.editTextOptionD4)
        cp4 = findViewById(R.id.correctanswer4)

        etQuestionNum5 = findViewById(R.id.QuestionNum5)
        etQuestion5 = findViewById(R.id.editTextQuestion5)
        etoptionA5 = findViewById(R.id.editTextOptionA5)
        etoptionB5 = findViewById(R.id.editTextOptionB5)
        etoptionC5 = findViewById(R.id.editTextOptionC5)
        etoptionD5 = findViewById(R.id.editTextOptionD5)
        cp5 = findViewById(R.id.correctanswer5)

        etQuestionNum6 = findViewById(R.id.QuestionNum6)
        etQuestion6 = findViewById(R.id.editTextQuestion6)
        etoptionA6 = findViewById(R.id.editTextOptionA6)
        etoptionB6 = findViewById(R.id.editTextOptionB6)
        etoptionC6 = findViewById(R.id.editTextOptionC6)
        etoptionD6 = findViewById(R.id.editTextOptionD6)
        cp6 = findViewById(R.id.correctanswer6)

        etQuestionNum7 = findViewById(R.id.QuestionNum7)
        etQuestion7 = findViewById(R.id.editTextQuestion7)
        etoptionA7 = findViewById(R.id.editTextOptionA7)
        etoptionB7 = findViewById(R.id.editTextOptionB7)
        etoptionC7 = findViewById(R.id.editTextOptionC7)
        etoptionD7 = findViewById(R.id.editTextOptionD7)
        cp7 = findViewById(R.id.correctanswer7)

        etQuestionNum8 = findViewById(R.id.QuestionNum8)
        etQuestion8 = findViewById(R.id.editTextQuestion8)
        etoptionA8 = findViewById(R.id.editTextOptionA8)
        etoptionB8 = findViewById(R.id.editTextOptionB8)
        etoptionC8 = findViewById(R.id.editTextOptionC8)
        etoptionD8 = findViewById(R.id.editTextOptionD8)
        cp8 = findViewById(R.id.correctanswer8)

        etQuestionNum9 = findViewById(R.id.QuestionNum9)
        etQuestion9 = findViewById(R.id.editTextQuestion9)
        etoptionA9 = findViewById(R.id.editTextOptionA9)
        etoptionB9 = findViewById(R.id.editTextOptionB9)
        etoptionC9 = findViewById(R.id.editTextOptionC9)
        etoptionD9 = findViewById(R.id.editTextOptionD9)
        cp9 = findViewById(R.id.correctanswer9)

        etQuestionNum10 = findViewById(R.id.QuestionNum10)
        etQuestion10 = findViewById(R.id.editTextQuestion10)
        etoptionA10 = findViewById(R.id.editTextOptionA10)
        etoptionB10 = findViewById(R.id.editTextOptionB10)
        etoptionC10 = findViewById(R.id.editTextOptionC10)
        etoptionD10 = findViewById(R.id.editTextOptionD10)
        btnSaveData = findViewById(R.id.buttonSavedata)
        cp10 = findViewById(R.id.correctanswer10)

        dbRef = FirebaseDatabase.getInstance()
            .getReference("QuizQuestions")//In future remember this name to open the database and fetch your data stored there

        btnSaveData.setOnClickListener {
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
        val co1=  cp1.text.toString()


        val QuestionNum2 = etQuestionNum2.text.toString()
        val Question2 = etQuestion2.text.toString()
        val optionA2 = etoptionA2.text.toString()
        val optionB2 = etoptionB2.text.toString()
        val optionC2 = etoptionC2.text.toString()
        val optionD2 = etoptionD2.text.toString()
        val co2=  cp2.text.toString()

        val QuestionNum3 = etQuestionNum3.text.toString()
        val Question3 = etQuestion3.text.toString()
        val optionA3 = etoptionA3.text.toString()
        val optionB3 = etoptionB3.text.toString()
        val optionC3 = etoptionC3.text.toString()
        val optionD3 = etoptionD3.text.toString()
        val co3=  cp3.text.toString()


        val QuestionNum4 = etQuestionNum4.text.toString()
        val Question4 = etQuestion4.text.toString()
        val optionA4 = etoptionA4.text.toString()
        val optionB4 = etoptionB4.text.toString()
        val optionC4 = etoptionC4.text.toString()
        val optionD4 = etoptionD4.text.toString()
        val co4=  cp4.text.toString()

        val QuestionNum5 = etQuestionNum5.text.toString()
        val Question5 = etQuestion5.text.toString()
        val optionA5 = etoptionA5.text.toString()
        val optionB5 = etoptionB5.text.toString()
        val optionC5 = etoptionC5.text.toString()
        val optionD5 = etoptionD5.text.toString()
        val co5=  cp5.text.toString()

        val QuestionNum6 = etQuestionNum6.text.toString()
        val Question6 = etQuestion6.text.toString()
        val optionA6 = etoptionA6.text.toString()
        val optionB6 = etoptionB6.text.toString()
        val optionC6 = etoptionC6.text.toString()
        val optionD6 = etoptionD6.text.toString()
        val co6=  cp6.text.toString()

        val QuestionNum7 = etQuestionNum7.text.toString()
        val Question7 = etQuestion7.text.toString()
        val optionA7 = etoptionA7.text.toString()
        val optionB7 = etoptionB7.text.toString()
        val optionC7 = etoptionC7.text.toString()
        val optionD7 = etoptionD7.text.toString()
        val co7=  cp7.text.toString()

        val QuestionNum8 = etQuestionNum8.text.toString()
        val Question8 = etQuestion8.text.toString()
        val optionA8 = etoptionA8.text.toString()
        val optionB8 = etoptionB8.text.toString()
        val optionC8 = etoptionC8.text.toString()
        val optionD8 = etoptionD8.text.toString()
        val co8=  cp8.text.toString()

        val QuestionNum9 = etQuestionNum9.text.toString()
        val Question9 = etQuestion9.text.toString()
        val optionA9 = etoptionA9.text.toString()
        val optionB9 = etoptionB9.text.toString()
        val optionC9 = etoptionC9.text.toString()
        val optionD9 = etoptionD9.text.toString()
        val co9=  cp9.text.toString()

        val QuestionNum10 = etQuestionNum10.text.toString()
        val Question10 = etQuestion10.text.toString()
        val optionA10 = etoptionA10.text.toString()
        val optionB10 = etoptionB10.text.toString()
        val optionC10 = etoptionC10.text.toString()
        val optionD10 = etoptionD10.text.toString()
        val co10=  cp10.text.toString()


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

        val QuizQuestions = Questionslist(
            quizGenre, quizid, QuestionNum1, Question1, optionA1, optionB1, optionC1, optionD1,co1,
            QuestionNum2, Question2, optionA2, optionB2, optionC2, optionD2,co2,
            QuestionNum3, Question3, optionA3, optionB3, optionC3, optionD3,co3,
            QuestionNum4, Question4, optionA4, optionB4, optionC4, optionD4,co4,
            QuestionNum5, Question5, optionA5, optionB5, optionC5, optionD5,co5,
            QuestionNum6, Question6, optionA6, optionB6, optionC6, optionD6,co6,
            QuestionNum7, Question7, optionA7, optionB7, optionC7, optionD7,co7,
            QuestionNum8, Question8, optionA8, optionB8, optionC8, optionD8,co8,
            QuestionNum9, Question9, optionA9, optionB9, optionC9, optionD9,co9,
            QuestionNum10, Question10, optionA10, optionB10, optionC10, optionD10,co10
        )

        dbRef.child(quizid).setValue(QuizQuestions)
            .addOnCompleteListener {
                Toast.makeText(this, "Data inserted successfully", Toast.LENGTH_LONG).show()

                Quizgenre.text.clear()

                etQuestionNum1.text.clear()
                etQuestion1.text.clear()
                etoptionA1.text.clear()
                etoptionB1.text.clear()
                etoptionC1.text.clear()
                etoptionD1.text.clear()
                cp1.text.clear()

                etQuestionNum2.text.clear()
                etQuestion2.text.clear()
                etoptionA2.text.clear()
                etoptionB2.text.clear()
                etoptionC2.text.clear()
                etoptionD2.text.clear()
                cp2.text.clear()

                etQuestionNum3.text.clear()
                etQuestion3.text.clear()
                etoptionA3.text.clear()
                etoptionB3.text.clear()
                etoptionC3.text.clear()
                etoptionD3.text.clear()
                cp3.text.clear()

                etQuestionNum4.text.clear()
                etQuestion4.text.clear()
                etoptionA4.text.clear()
                etoptionB4.text.clear()
                etoptionC4.text.clear()
                etoptionD4.text.clear()
                cp4.text.clear()

                etQuestionNum5.text.clear()
                etQuestion5.text.clear()
                etoptionA5.text.clear()
                etoptionB5.text.clear()
                etoptionC5.text.clear()
                etoptionD5.text.clear()
                cp5.text.clear()

                etQuestionNum6.text.clear()
                etQuestion6.text.clear()
                etoptionA6.text.clear()
                etoptionB6.text.clear()
                etoptionC6.text.clear()
                etoptionD6.text.clear()
                cp6.text.clear()

                etQuestionNum7.text.clear()
                etQuestion7.text.clear()
                etoptionA7.text.clear()
                etoptionB7.text.clear()
                etoptionC7.text.clear()
                etoptionD7.text.clear()
                cp7.text.clear()

                etQuestionNum8.text.clear()
                etQuestion8.text.clear()
                etoptionA8.text.clear()
                etoptionB8.text.clear()
                etoptionC8.text.clear()
                etoptionD8.text.clear()
                cp8.text.clear()

                etQuestionNum9.text.clear()
                etQuestion9.text.clear()
                etoptionA9.text.clear()
                etoptionB9.text.clear()
                etoptionC9.text.clear()
                etoptionD9.text.clear()
                cp9.text.clear()

                etQuestionNum10.text.clear()
                etQuestion10.text.clear()
                etoptionA10.text.clear()
                etoptionB10.text.clear()
                etoptionC10.text.clear()
                etoptionD10.text.clear()
                cp10.text.clear()

            }.addOnFailureListener { err ->
                Toast.makeText(this, "Error ${err.message}", Toast.LENGTH_LONG).show()
            }

    }

    private fun uploadImageToFirebase(imageUri: Uri?) {
        imageUri?.let { uri ->
            val fileName = "images/${System.currentTimeMillis()}.jpg"
            val imageRef = storageReference.child(fileName)

            // Upload file to Firebase Storage
            imageRef.putFile(uri)
                .addOnSuccessListener {
                    // Image upload success
                    // Now you can retrieve the download URL
                    imageRef.downloadUrl.addOnSuccessListener { downloadUri ->
                        // Save the image path in Firebase Realtime Database
                        saveImagePathToDatabase(fileName, downloadUri.toString())
                    }
                }
                .addOnFailureListener { e ->
                    // Handle unsuccessful uploads
                    // Log.e("Firebase", "Image upload failed: ${e.message}")
                }
        }
    }

    private fun saveImagePathToDatabase(imagePath: String, downloadUrl: String) {
        // Assume you have a Firebase Realtime Database reference
        val databaseReference = FirebaseDatabase.getInstance().reference.child("imagePaths")

        // Save the image path along with its download URL in the database
        val data = hashMapOf("imagePath" to imagePath, "downloadUrl" to downloadUrl)
        databaseReference.push().setValue(data)
    }


}




