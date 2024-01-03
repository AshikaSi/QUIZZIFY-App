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
    private var tvquizlist = mutableListOf<Questionslist>()
    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fetch)

        quizRecyclerView = findViewById(R.id.rvQues)
        quizRecyclerView.layoutManager = LinearLayoutManager(this)
        quizRecyclerView.setHasFixedSize(true)

        loadtv = findViewById(R.id.loadtv)
        getQuizData()
    }

    private fun getQuizData() {
        quizRecyclerView.visibility = View.GONE
        loadtv.visibility = View.VISIBLE
        dbRef = FirebaseDatabase.getInstance().getReference("QuizQuestions")
        dbRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                tvquizlist.clear()
                if (snapshot.exists()) {
                    for (quizSnap in snapshot.children) {
                        val quizData = quizSnap.getValue(Questionslist::class.java)
                        quizData?.let {
                            tvquizlist.add(quizData!!)
                        }
                    }
                    val mAdapter = QuizAdapter(tvquizlist)
                    quizRecyclerView.adapter = mAdapter
                    mAdapter.notifyDataSetChanged()

                    mAdapter.setOnItemClickListener(object : QuizAdapter.onItemClickListener{
                        override fun onItemClick(position: Int) {
                            val intent = Intent (this@FetchActivity,QuizDetailsActivity::class.java)

                            intent.putExtra("quizid", tvquizlist[position].quizid)
                            intent.putExtra("Quizgenre", tvquizlist[position].Quizgenre)

                            intent.putExtra("QuestionNum1", tvquizlist[position].QuestionNum1)
                            intent.putExtra("Question1", tvquizlist[position].Question1)
                            intent.putExtra("optionA1", tvquizlist[position].optionA1)
                            intent.putExtra("optionB1", tvquizlist[position].optionB1)
                            intent.putExtra("optionC1", tvquizlist[position].optionC1)
                            intent.putExtra("optionD1", tvquizlist[position].optionD1)

                            intent.putExtra("QuestionNum2", tvquizlist[position].QuestionNum2)
                            intent.putExtra("Question2", tvquizlist[position].Question2)
                            intent.putExtra("optionA2",tvquizlist[position].optionA2)
                            intent.putExtra("optionB2", tvquizlist[position].optionB2)
                            intent.putExtra("optionC2", tvquizlist[position].optionC2)
                            intent.putExtra("optionD2", tvquizlist[position].optionD2)

                            intent.putExtra("QuestionNum3", tvquizlist[position].QuestionNum3)
                            intent.putExtra("Question3", tvquizlist[position].Question3)
                            intent.putExtra("optionA3", tvquizlist[position].optionA3)
                            intent.putExtra("optionB3", tvquizlist[position].optionB3)
                            intent.putExtra("optionC3", tvquizlist[position].optionC3)
                            intent.putExtra("optionD3", tvquizlist[position].optionD3)

                            intent.putExtra("QuestionNum4", tvquizlist[position].QuestionNum4)
                            intent.putExtra("Question4", tvquizlist[position].Question4)
                            intent.putExtra("optionA4", tvquizlist[position].optionA4)
                            intent.putExtra("optionB4", tvquizlist[position].optionB4)
                            intent.putExtra("optionC4", tvquizlist[position].optionC4)
                            intent.putExtra("optionD4", tvquizlist[position].optionD4)

                            intent.putExtra("QuestionNum5", tvquizlist[position].QuestionNum5)
                            intent.putExtra("Question5", tvquizlist[position].Question5)
                            intent.putExtra("optionA5", tvquizlist[position].optionA5)
                            intent.putExtra("optionB5", tvquizlist[position].optionB5)
                            intent.putExtra("optionC5", tvquizlist[position].optionC5)
                            intent.putExtra("optionD5", tvquizlist[position].optionD5)

                            intent.putExtra("QuestionNum6", tvquizlist[position].QuestionNum6)
                            intent.putExtra("Question6", tvquizlist[position].Question6)
                            intent.putExtra("optionA6", tvquizlist[position].optionA6)
                            intent.putExtra("optionB6", tvquizlist[position].optionB6)
                            intent.putExtra("optionC6", tvquizlist[position].optionC6)
                            intent.putExtra("optionD6", tvquizlist[position].optionD6)

                            intent.putExtra("QuestionNum7",tvquizlist[position].QuestionNum7)
                            intent.putExtra("Question7",tvquizlist[position].Question7)
                            intent.putExtra("optionA7", tvquizlist[position].optionA7)
                            intent.putExtra("optionB7", tvquizlist[position].optionB7)
                            intent.putExtra("optionC7", tvquizlist[position].optionC7)
                            intent.putExtra("optionD7", tvquizlist[position].optionD7)

                            intent.putExtra("QuestionNum8", tvquizlist[position].QuestionNum8)
                            intent.putExtra("Question8", tvquizlist[position].Question8)
                            intent.putExtra("optionA8", tvquizlist[position].optionA8)
                            intent.putExtra("optionB8", tvquizlist[position].optionB8)
                            intent.putExtra("optionC8", tvquizlist[position].optionC8)
                            intent.putExtra("optionD8", tvquizlist[position].optionD8)

                            intent.putExtra("QuestionNum9", tvquizlist[position].QuestionNum9)
                            intent.putExtra("Question9", tvquizlist[position].Question9)
                            intent.putExtra("optionA9", tvquizlist[position].optionA9)
                            intent.putExtra("optionB9", tvquizlist[position].optionB9)
                            intent.putExtra("optionC9", tvquizlist[position].optionC9)
                            intent.putExtra("optionD9", tvquizlist[position].optionD9)

                            intent.putExtra("QuestionNum10", tvquizlist[position].QuestionNum10)
                            intent.putExtra("Question10", tvquizlist[position].Question10)
                            intent.putExtra("optionA10", tvquizlist[position].optionA10)
                            intent.putExtra("optionB10", tvquizlist[position].optionB10)
                            intent.putExtra("optionC10", tvquizlist[position].optionC10)
                            intent.putExtra("optionD10", tvquizlist[position].optionD10)
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
