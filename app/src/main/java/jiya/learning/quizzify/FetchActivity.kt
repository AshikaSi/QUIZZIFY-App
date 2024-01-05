package jiya.learning.quizzify

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.content.Intent

class FetchActivity : AppCompatActivity() {
    private lateinit var quizRecyclerView: RecyclerView
    private lateinit var loadtv: TextView
    private var queslist = mutableListOf<Questionslist>()
    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fetch)

        quizRecyclerView = findViewById(R.id.rvQues)
        quizRecyclerView.layoutManager = LinearLayoutManager(this)
        quizRecyclerView.setHasFixedSize(true)
        loadtv = findViewById(R.id.loadtv)

        queslist = arrayListOf<Questionslist>()
        getQuizQuestionsData()
    }

    private fun getQuizQuestionsData() {
        quizRecyclerView.visibility = View.GONE
        loadtv.visibility = View.VISIBLE
        dbRef = FirebaseDatabase.getInstance().getReference("QuizQuestions")
        dbRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                queslist.clear()
                if (snapshot.exists()) {
                    for (quizSnap in snapshot.children) {
                        val quizData = quizSnap.getValue(Questionslist::class.java)
                        quizData?.let {
                            queslist.add(quizData!!)
                        }
                    }
                    val mAdapter = QuizAdapter(queslist)
                    quizRecyclerView.adapter = mAdapter
                    mAdapter.notifyDataSetChanged()

                    mAdapter.setOnItemClickListener(object : QuizAdapter.onItemClickListener{
                        override fun onItemClick(position: Int) {
                            val intent = Intent (this@FetchActivity,QuizDetailsActivity::class.java)

                            intent.putExtra("quizid", queslist[position].quizid)
                            intent.putExtra("Quizgenre", queslist[position].Quizgenre)

                            intent.putExtra("QuestionNum1", queslist[position].QuestionNum1)
                            intent.putExtra("Question1", queslist[position].Question1)
                            intent.putExtra("optionA1", queslist[position].optionA1)
                            intent.putExtra("optionB1", queslist[position].optionB1)
                            intent.putExtra("optionC1", queslist[position].optionC1)
                            intent.putExtra("optionD1", queslist[position].optionD1)

                            intent.putExtra("QuestionNum2", queslist[position].QuestionNum2)
                            intent.putExtra("Question2",queslist[position].Question2)
                            intent.putExtra("optionA2",queslist[position].optionA2)
                            intent.putExtra("optionB2", queslist[position].optionB2)
                            intent.putExtra("optionC2", queslist[position].optionC2)
                            intent.putExtra("optionD2", queslist[position].optionD2)

                            intent.putExtra("QuestionNum3", queslist[position].QuestionNum3)
                            intent.putExtra("Question3", queslist[position].Question3)
                            intent.putExtra("optionA3", queslist[position].optionA3)
                            intent.putExtra("optionB3", queslist[position].optionB3)
                            intent.putExtra("optionC3", queslist[position].optionC3)
                            intent.putExtra("optionD3", queslist[position].optionD3)

                            intent.putExtra("QuestionNum4", queslist[position].QuestionNum4)
                            intent.putExtra("Question4", queslist[position].Question4)
                            intent.putExtra("optionA4", queslist[position].optionA4)
                            intent.putExtra("optionB4", queslist[position].optionB4)
                            intent.putExtra("optionC4", queslist[position].optionC4)
                            intent.putExtra("optionD4", queslist[position].optionD4)

                            intent.putExtra("QuestionNum5",queslist[position].QuestionNum5)
                            intent.putExtra("Question5", queslist[position].Question5)
                            intent.putExtra("optionA5", queslist[position].optionA5)
                            intent.putExtra("optionB5",queslist[position].optionB5)
                            intent.putExtra("optionC5", queslist[position].optionC5)
                            intent.putExtra("optionD5", queslist[position].optionD5)

                            intent.putExtra("QuestionNum6", queslist[position].QuestionNum6)
                            intent.putExtra("Question6", queslist[position].Question6)
                            intent.putExtra("optionA6", queslist[position].optionA6)
                            intent.putExtra("optionB6", queslist[position].optionB6)
                            intent.putExtra("optionC6", queslist[position].optionC6)
                            intent.putExtra("optionD6", queslist[position].optionD6)

                            intent.putExtra("QuestionNum7",queslist[position].QuestionNum7)
                            intent.putExtra("Question7",queslist[position].Question7)
                            intent.putExtra("optionA7", queslist[position].optionA7)
                            intent.putExtra("optionB7", queslist[position].optionB7)
                            intent.putExtra("optionC7", queslist[position].optionC7)
                            intent.putExtra("optionD7", queslist[position].optionD7)

                            intent.putExtra("QuestionNum8", queslist[position].QuestionNum8)
                            intent.putExtra("Question8", queslist[position].Question8)
                            intent.putExtra("optionA8", queslist[position].optionA8)
                            intent.putExtra("optionB8", queslist[position].optionB8)
                            intent.putExtra("optionC8", queslist[position].optionC8)
                            intent.putExtra("optionD8", queslist[position].optionD8)

                            intent.putExtra("QuestionNum9", queslist[position].QuestionNum9)
                            intent.putExtra("Question9", queslist[position].Question9)
                            intent.putExtra("optionA9", queslist[position].optionA9)
                            intent.putExtra("optionB9", queslist[position].optionB9)
                            intent.putExtra("optionC9", queslist[position].optionC9)
                            intent.putExtra("optionD9", queslist[position].optionD9)

                            intent.putExtra("QuestionNum10", queslist[position].QuestionNum10)
                            intent.putExtra("Question10", queslist[position].Question10)
                            intent.putExtra("optionA10", queslist[position].optionA10)
                            intent.putExtra("optionB10", queslist[position].optionB10)
                            intent.putExtra("optionC10", queslist[position].optionC10)
                            intent.putExtra("optionD10", queslist[position].optionD10)
                            startActivity(intent)

                        }
                    })

                    quizRecyclerView.visibility = View.VISIBLE
                    loadtv.visibility = View.GONE
                }
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
    }
}
