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
import kotlinx.android.synthetic.main.activity_register_page.*

class RegisterPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_page)


        backButton.setOnClickListener(View.OnClickListener {
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
            this.finish()
        })
        registerBtn.setOnClickListener {
            when {
                TextUtils.isEmpty(registerEmail.text.toString().trim { it <= ' ' }) -> {
                    Toast.makeText(
                        this@RegisterPage,
                        getString(R.string.pleaseenteremail),
                        Toast.LENGTH_SHORT
                    ).show()
                }

                TextUtils.isEmpty(registerPassword.text.toString().trim { it <= ' ' }) -> {
                    Toast.makeText(
                        this@RegisterPage,
                        getString(R.string.pleaseenterpassword),
                        Toast.LENGTH_SHORT
                    ).show()
                }
                TextUtils.isEmpty(registerSurname.text.toString().trim { it <= ' ' }) -> {
                    Toast.makeText(
                        this@RegisterPage,
                        getString(R.string.pleaseenteryoursurname),
                        Toast.LENGTH_SHORT
                    ).show()
                }
                TextUtils.isEmpty(registerName.text.toString().trim { it <= ' ' }) -> {
                    Toast.makeText(
                        this@RegisterPage,
                        getString(R.string.pleaseenteryourname),
                        Toast.LENGTH_SHORT
                    ).show()
                }
                else -> {

                    val email: String = registerEmail.text.toString().trim { it <= ' ' }
                    val password: String = registerPassword.text.toString().trim { it <= ' ' }
                    val name: String = registerName.text.toString().trim { it <= ' ' }
                    val surname: String = registerSurname.text.toString().trim { it <= ' ' }

                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(
                            OnCompleteListener<AuthResult> { task ->

                                // If the registration is successfully done
                                if (task.isSuccessful) {

                                    // Firebase registered user
                                    val firebaseUser: FirebaseUser = task.result!!.user!!

                                    Toast.makeText(
                                        this@RegisterPage,
                                        getString(R.string.youareregisteredsccflly),
                                        Toast.LENGTH_SHORT
                                    ).show()

                                    val intent =
                                        Intent(this@RegisterPage, MainActivity::class.java)
                                    intent.flags =
                                        Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                    intent.putExtra("user_id", firebaseUser.uid)
                                    intent.putExtra("email_id", email)
                                    intent.putExtra("surname", name)
                                    intent.putExtra("name", surname)
                                    startActivity(intent)
                                    finish()
                                } else {
                                    Toast.makeText(
                                        this@RegisterPage,
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