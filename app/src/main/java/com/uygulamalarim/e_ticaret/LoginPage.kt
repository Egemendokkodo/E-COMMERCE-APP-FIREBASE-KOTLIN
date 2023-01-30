package com.uygulamalarim.e_ticaret

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_login_page.*

class LoginPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)



        backButton.setOnClickListener(View.OnClickListener {
            this.finish()
        })
        textButtonLogin.setOnClickListener(View.OnClickListener {
            val i = Intent(this, RegisterPage::class.java)
            this.finish()
            startActivity(i)

        })

        signInBtn.setOnClickListener {
            when {
                TextUtils.isEmpty(loginEmail.text.toString().trim { it <= ' ' }) -> {
                    Toast.makeText(
                        this@LoginPage,
                        getString(R.string.pleaseenteremail),
                        Toast.LENGTH_SHORT
                    ).show()
                }

                TextUtils.isEmpty(loginPassword.text.toString().trim { it <= ' ' }) -> {
                    Toast.makeText(
                        this@LoginPage,
                        getString(R.string.pleaseenterpassword),
                        Toast.LENGTH_SHORT
                    ).show()
                }

                else -> {

                    val email: String = loginEmail.text.toString().trim { it <= ' ' }
                    val password: String = loginPassword.text.toString().trim { it <= ' ' }

                    FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(
                            OnCompleteListener<AuthResult> { task ->

                                // If the registration is successfully done
                                if (task.isSuccessful) {

                                    // Firebase registered user
                                    val firebaseUser: FirebaseUser = task.result!!.user!!

                                    Toast.makeText(
                                        this@LoginPage,
                                        getString(R.string.yourelogginsuccesfully),
                                        Toast.LENGTH_SHORT
                                    ).show()

                                    val intent =
                                        Intent(this@LoginPage, AppPage::class.java)
                                    intent.flags =
                                        Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                    intent.putExtra("user_id",
                                        FirebaseAuth.getInstance().currentUser!!.uid)
                                    intent.putExtra("email_id", email)
                                    startActivity(intent)
                                    finish()
                                } else {
                                    Toast.makeText(
                                        this@LoginPage,
                                        task.exception!!.message.toString(),
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            })
                }
            }
        }


    }


}