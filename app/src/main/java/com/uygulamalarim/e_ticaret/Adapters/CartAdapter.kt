package com.uygulamalarim.e_ticaret.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso
import com.uygulamalarim.e_ticaret.Model.CartModel
import com.uygulamalarim.e_ticaret.R

class CartAdapter(private val list: ArrayList<CartModel>) :
    RecyclerView.Adapter<CartAdapter.MyViewHolder>() {


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cartPic: ShapeableImageView = itemView.findViewById(R.id.cartPic)
        val cartTv: TextView = itemView.findViewById(R.id.cartTv)
        val cart_desc: TextView = itemView.findViewById(R.id.cart_desc)
        val cartPrice: TextView = itemView.findViewById(R.id.cartPrice)
        val cartAddedby: TextView = itemView.findViewById(R.id.cartAddedby)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.cartitem, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = list[position]
        holder.cartPrice.text = currentItem.ProductPrice
        Picasso.get().load(currentItem.image.toString()).into(holder.cartPic)
        holder.cartTv.text = currentItem.ProductName
        holder.cart_desc.text = currentItem.ProductDesc
        holder.cartAddedby.text = currentItem.Added_By


    }

    override fun getItemCount(): Int {
        return list.size
    }
}