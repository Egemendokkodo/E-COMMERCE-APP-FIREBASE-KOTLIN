package com.uygulamalarim.e_ticaret.Adapters

import android.graphics.drawable.VectorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.uygulamalarim.e_ticaret.R
import com.uygulamalarim.e_ticaret.Model.Kategori

class KategoriAdapter(private val list: ArrayList<Kategori>) :
    RecyclerView.Adapter<KategoriAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.kategoriitem, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = list[position]
        holder.kategoriPic.setImageResource(currentItem.kategoriPic)
        holder.kategoriTv.text = currentItem.kategoriTv
    }

    override fun getItemCount(): Int {
        return list.size
    }


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val kategoriPic: ShapeableImageView = itemView.findViewById(R.id.kategoriPic)
        val kategoriTv: TextView = itemView.findViewById(R.id.kategoriTv)
    }


}