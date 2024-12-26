package com.example.myapplication_app.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication_app.R
import de.hdodenhof.circleimageview.CircleImageView

class FruitsAdapter(
    val context: Context,
    val imageList: ArrayList<Int>,
    val fruitsTitle: ArrayList<String>,
    val fruitsDesc: ArrayList<String>


) : RecyclerView.Adapter<FruitsAdapter.FruitsViewHolder>() {
    class FruitsViewHolder(itemView: View)
        : RecyclerView.ViewHolder(itemView) {
            var image: CircleImageView = itemView.findViewById(R.id.profile_image)
            var title: TextView = itemView.findViewById(R.id.lblFruitName)
            var desc: TextView = itemView.findViewById(R.id.lblFruitDescription)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitsViewHolder {
        val itemView : View = LayoutInflater.from(context).inflate(R.layout.single_product,parent,false)
        return FruitsViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    override fun onBindViewHolder(holder: FruitsViewHolder, position: Int) {
        holder.title.text = fruitsTitle[position]
        holder.desc.text = fruitsDesc[position]
        holder.image.setImageResource(imageList[position])
    }
}