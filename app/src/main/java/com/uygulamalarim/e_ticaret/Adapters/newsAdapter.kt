package com.uygulamalarim.e_ticaret.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.uygulamalarim.e_ticaret.R
import com.uygulamalarim.e_ticaret.Model.News

class NewsAdapter(private val list: ArrayList<News>) :
    RecyclerView.Adapter<NewsAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.newsitem, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = list[position]
        holder.newsPic.setImageResource(currentItem.newsPic)

    }

    override fun getItemCount(): Int {
        return list.size
    }


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val newsPic: ShapeableImageView = itemView.findViewById(R.id.newsPic)
    }


}