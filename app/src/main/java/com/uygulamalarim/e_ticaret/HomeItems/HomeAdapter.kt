package com.uygulamalarim.e_ticaret.HomeItems

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso
import com.uygulamalarim.e_ticaret.R

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.MyViewHolder>() {

    private val homeUserList = ArrayList<HomeUser>()
    var onItemClick: ((HomeUser) -> Unit)? = null
    fun updateUserList(homeUserList: List<HomeUser>) {
        this.homeUserList.clear()
        this.homeUserList.addAll(homeUserList)
        notifyDataSetChanged()

    }


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ShapeableImageView = itemView.findViewById(R.id.techPic)
        val ProductName: TextView = itemView.findViewById(R.id.techTv)
        val ProductDesc: TextView = itemView.findViewById(R.id.product_desc)
        val ProductPrice: TextView = itemView.findViewById(R.id.product_price)
        val Added_By: TextView = itemView.findViewById(R.id.added_by)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.technologyitem, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = homeUserList[position]
        Picasso.get().load(currentItem.image.toString()).into(holder.image)
        holder.ProductName.text = currentItem.ProductName
        holder.ProductDesc.text = currentItem.ProductDesc
        holder.ProductPrice.text = currentItem.ProductPrice
        holder.Added_By.text = currentItem.Added_By

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(currentItem)
        }

    }

    override fun getItemCount(): Int {
        return homeUserList.size
    }


}