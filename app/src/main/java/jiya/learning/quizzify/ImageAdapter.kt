package jiya.learning.quizzify

import android.content.Context
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide

import jiya.learning.quizzify.UserImage
class ImageAdapter(private val imagesList:ArrayList<UserImage>,
    private val context: Context):
    RecyclerView.Adapter<ImageAdapter.ImageViewHolder>(){
    class ImageViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val image:ImageView= itemView.findViewById(R.id.imageView3)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.activity_quiz_details,parent,false)
        return ImageViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        Glide.with(context).load(imagesList[position].userImage).into(holder.image)
    }

    override fun getItemCount(): Int {
        return imagesList.size
    }
}