package com.uygulamalarim.e_ticaret

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso
import com.uygulamalarim.e_ticaret.ClothingItems.ClothingUser
import com.uygulamalarim.e_ticaret.DBhelper.DBHelper
import com.uygulamalarim.e_ticaret.HomeItems.HomeUser
import com.uygulamalarim.e_ticaret.TechnologyItems.User
import kotlinx.android.synthetic.main.activity_detailed_page.*

class DetailedPage : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_page)

        backButton.setOnClickListener {
            this.finish()
        }

        if (intent.getStringExtra("keytech").equals("technology")) {
            val items = intent.getParcelableExtra<User>("user")
            if (items != null) {
                val db = DBHelper(this, null)
                val cursor = db.getContents()
                cursor!!.moveToFirst()
                val itemname: TextView = findViewById(R.id.itemname)
                val itemdesc: TextView = findViewById(R.id.itemdesc)
                val imagedetailed: ShapeableImageView = findViewById(R.id.image)
                val price: TextView = findViewById(R.id.price)
                val bywhom: TextView = findViewById(R.id.bywhom)

                itemname.text = items.ProductName
                itemdesc.text = items.ProductDesc
                price.text = items.ProductPrice
                bywhom.text = items.Added_By
                Picasso.get().load(items.image.toString()).into(imagedetailed)

                addtocartbtn.setOnClickListener {
                    val intent = Intent(this, CartActivity::class.java)
                    intent.putExtra("name", items.ProductName)
                    intent.putExtra("desc", items.ProductDesc)
                    intent.putExtra("price", items.ProductPrice)
                    intent.putExtra("person", items.Added_By)
                    intent.putExtra("image", items.image.toString())
                    startActivity(intent)
                    

                }

            }
        } else if (intent.getStringExtra("keyclothing").equals("clothing")) {
            val items = intent.getParcelableExtra<ClothingUser>("clothing")
            if (items != null) {

                val itemname: TextView = findViewById(R.id.itemname)
                val itemdesc: TextView = findViewById(R.id.itemdesc)
                val imagedetailed: ShapeableImageView = findViewById(R.id.image)
                val price: TextView = findViewById(R.id.price)
                val bywhom: TextView = findViewById(R.id.bywhom)

                itemname.text = items.ProductName
                itemdesc.text = items.ProductDesc
                price.text = items.ProductPrice
                bywhom.text = items.Added_By
                Picasso.get().load(items.image.toString()).into(imagedetailed)

            }
        } else if (intent.getStringExtra("keyhome").equals("home")) {
            val items = intent.getParcelableExtra<HomeUser>("home")
            if (items != null) {

                val itemname: TextView = findViewById(R.id.itemname)
                val itemdesc: TextView = findViewById(R.id.itemdesc)
                val imagedetailed: ShapeableImageView = findViewById(R.id.image)
                val price: TextView = findViewById(R.id.price)
                val bywhom: TextView = findViewById(R.id.bywhom)

                itemname.text = items.ProductName
                itemdesc.text = items.ProductDesc
                price.text = items.ProductPrice
                bywhom.text = items.Added_By
                Picasso.get().load(items.image.toString()).into(imagedetailed)


            }
        }


    }
}