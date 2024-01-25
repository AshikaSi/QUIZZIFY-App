package jiya.learning.quizzify

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class QuizAdapter(private val queslist: List<Questionslist>) :
    RecyclerView.Adapter<QuizAdapter.ViewHolder>() {

    private lateinit var mListener: onItemClickListener

    interface onItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(clickListener: onItemClickListener) {
        mListener = clickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.quesview, parent, false)
        return ViewHolder(itemView, mListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentquiz = queslist[position]
        holder.tvquizlist.text = currentquiz.quizid
        holder.itemView.setOnClickListener {
            mListener.onItemClick(position)
        }

    }

    override fun getItemCount(): Int {
        return queslist.size
    }

    class ViewHolder(itemView: View, clickListener: onItemClickListener) : RecyclerView.ViewHolder(itemView) {
        val tvquizlist: TextView = itemView.findViewById(R.id.tvquizlist)

        init{
            itemView.setOnClickListener{
                clickListener.onItemClick(adapterPosition)
            }
        }


        }
    }