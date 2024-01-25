//package jiya.learning.quizzify
//
//import android.content.Context
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.TextView
//import android.widget.Toast
//import androidx.recyclerview.widget.RecyclerView
//
//class OptionAdapter(
//    private val context: Context,
//    private val questionsList: Questionslist,
//    private val questionNumber: Int
//) :
//    RecyclerView.Adapter<OptionAdapter.OptionViewHolder>() {
//
//    private var score: Int = 0
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OptionViewHolder {
//        val view = LayoutInflater.from(context).inflate(R.layout.activity_quiz_details, parent, false)
//        return OptionViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: OptionViewHolder, position: Int) {
//        val option = getOptionByPosition(position)
//        holder.bind(option)
//    }
//
//    override fun getItemCount(): Int {
//        return 4 // Assuming you always have four options per question
//    }
//
//    inner class OptionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        private val optionTextView: TextView = itemView.findViewById(R.id.your_option_text_view)
//
//        init {
//            itemView.setOnClickListener {
//                // Handle click event for the option
//                val selectedOption = getOptionByPosition(adapterPosition)
//                checkAnswer(selectedOption)
//            }
//        }
//
//        fun bind(option: String) {
//            optionTextView.text = option
//        }
//    }
//
//    private fun getOptionByPosition(position: Int): String {
//        return when (position) {
//            0 -> questionsList.getOptionForQuestion(questionNumber, "A")
//            1 -> questionsList.getOptionForQuestion(questionNumber, "B")
//            2 -> questionsList.getOptionForQuestion(questionNumber, "C")
//            3 -> questionsList.getOptionForQuestion(questionNumber, "D")
//            else -> throw IndexOutOfBoundsException("Invalid option position: $position")
//        }
//    }
//
//    private fun checkAnswer(selectedOption: String) {
//        val correctOption = questionsList.getCorrectOptionForQuestion(questionNumber)
//
//        if (selectedOption == correctOption) {
//            score += 1
//            Toast.makeText(context, "Correct Answer\nScore - $score", Toast.LENGTH_LONG).show()
//        } else {
//            Toast.makeText(context, "Incorrect Answer", Toast.LENGTH_SHORT).show()
//        }
//    }
//
//    fun getScore(): Int {
//        return score
//    }
//}
