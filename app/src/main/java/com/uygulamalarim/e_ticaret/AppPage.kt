package com.uygulamalarim.e_ticaret

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.uygulamalarim.e_ticaret.Fragments.BrowseFragment
import com.uygulamalarim.e_ticaret.Fragments.MainFragment
import com.uygulamalarim.e_ticaret.Fragments.ProfileFragment
import kotlinx.android.synthetic.main.activity_app_page.*

class AppPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_page)
        val emailId = intent.getStringExtra("email_id")
        replaceFragment(MainFragment(emailId))

        bottom_navbar.setOnNavigationItemReselectedListener({
            when (it.itemId) {
                R.id.nav_home -> replaceFragment(MainFragment(emailId))
                R.id.nav_search -> replaceFragment(BrowseFragment())
                R.id.nav_profile -> replaceFragment(ProfileFragment(emailId))
                R.id.nav_cart -> {
                    val intent = Intent(this, CartActivity::class.java)
                    startActivity(intent)
                }
            }
        })

    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.container, fragment)
        fragmentTransaction.commit()
    }
}