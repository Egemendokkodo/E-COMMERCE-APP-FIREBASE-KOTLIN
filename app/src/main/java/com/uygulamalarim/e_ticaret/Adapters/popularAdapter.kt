package com.uygulamalarim.e_ticaret.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.uygulamalarim.e_ticaret.R
import com.uygulamalarim.e_ticaret.Model.Kategori
import com.uygulamalarim.e_ticaret.Model.Popular

class popularAdapter(private val list: ArrayList<Popular>) :
    RecyclerView.Adapter<popularAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.popularitem, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = list[position]
        holder.popularPic.setImageResource(currentItem.popularPic)
        holder.popularTv.text = currentItem.popularTv
    }

    override fun getItemCount(): Int {
        return list.size
    }


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val popularPic: ShapeableImageView = itemView.findViewById(R.id.popularPic)
        val popularTv: TextView = itemView.findViewById(R.id.popularTv)
    }


}