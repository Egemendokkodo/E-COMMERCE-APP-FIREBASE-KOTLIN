package com.uygulamalarim.e_ticaret

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.uygulamalarim.e_ticaret.Adapters.CartAdapter
import com.uygulamalarim.e_ticaret.DBhelper.DBHelper
import com.uygulamalarim.e_ticaret.Model.CartModel
import kotlinx.android.synthetic.main.activity_cart.*

class CartActivity : AppCompatActivity() {

    private lateinit var adapterCart: CartAdapter
    private lateinit var cartRecycler: RecyclerView
    private lateinit var cartList: ArrayList<CartModel>

    private lateinit var totalfee: ArrayList<Int>

    @SuppressLint("Range", "NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)


        button2.setOnClickListener {
            this.finish()
        }

        val db = DBHelper(this, null)
        val cursor = db.getContents()
        cursor!!.moveToFirst()


        val name = intent.getStringExtra("name")
        val desc = intent.getStringExtra("desc")
        val price = intent.getStringExtra("price")
        val person = intent.getStringExtra("person")
        val image = intent.getStringExtra("image")
        db.addContents(name.toString(),
            desc.toString(),
            price.toString(),
            person.toString(),
            image.toString())

        cartList = ArrayList()
        val layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        cartRecycler = findViewById(R.id.cartRecycler)
        cartRecycler.layoutManager = layoutManager
        cartRecycler.setHasFixedSize(true)
        adapterCart = CartAdapter(cartList)
        cartRecycler.adapter = adapterCart

        cursor!!.moveToFirst()
        cartList.add(CartModel(cursor.getString(cursor.getColumnIndex(DBHelper.PRICE_COL)),
            cursor.getString(cursor.getColumnIndex(DBHelper.IMAGE_COL)),
            cursor.getString(cursor.getColumnIndex(DBHelper.NAME_COl)),//BURASI DOĞRU
            cursor.getString(cursor.getColumnIndex(DBHelper.ADDEDBY_COL)),//BURASI DOĞRU
            cursor.getString(cursor.getColumnIndex(DBHelper.DESC_COL))))


        while (cursor.moveToNext()) {
            cartList.add(CartModel(cursor.getString(cursor.getColumnIndex(DBHelper.PRICE_COL)),
                cursor.getString(cursor.getColumnIndex(DBHelper.IMAGE_COL)),
                cursor.getString(cursor.getColumnIndex(DBHelper.NAME_COl)),//BURASI DOĞRU
                cursor.getString(cursor.getColumnIndex(DBHelper.ADDEDBY_COL)),//BURASI DOĞRU
                cursor.getString(cursor.getColumnIndex(DBHelper.DESC_COL))))
        }
        adapterCart.notifyDataSetChanged()


        /*totalfee = ArrayList()
        while (cursor.moveToNext()) {
            totalfee.add()
        }*/

    }


}