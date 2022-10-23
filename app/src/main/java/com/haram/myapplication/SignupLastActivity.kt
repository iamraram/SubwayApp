package com.haram.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

private var auth : FirebaseAuth? = null

class SignupLastActivity : AppCompatActivity() {
    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup_last)

        val etName = findViewById<EditText>(R.id.etName1)
        val etEmail = findViewById<EditText>(R.id.etEmail1)
        val etPw1 = findViewById<EditText>(R.id.etPw1)
        val etPw2 = findViewById<EditText>(R.id.etPw2)
        val txt = findViewById<TextView>(R.id.textCaution)
        val btn = findViewById<Button>(R.id.nextBtn2)

        val textBack = findViewById<TextView>(R.id.textBack)
        textBack.setOnClickListener {
            finish()
        }

        if (intent.hasExtra("name")) {
            etName.hint = intent.getStringExtra("name")
        }
        if (intent.hasExtra("email")) {
            etEmail.hint = intent.getStringExtra("email")
        }

        btn.setOnClickListener {
            if (etPw1.length() < 8 || etPw1.text != etPw2.text) {
                txt.text = "비밀번호가 일치하지 않거나 양식이 틀렸어요."
                txt.visibility = TextView.VISIBLE
                etPw2.background = getDrawable(R.drawable.roundbuttonwhitecaution)
            }
            else {
                auth = Firebase.auth
                signup(etName.hint.toString(), etEmail.hint.toString(), etPw1.text.toString())
            }
        }
    }

    private fun signup(email: String, password: String, name: String) {
        if (email.isNotEmpty() && password.isNotEmpty()) {
            auth?.createUserWithEmailAndPassword(email, password)
                ?.addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        val intent = Intent(this, CompleteActivity::class.java)
                        startActivity(intent)
                    }
                    else {
                        Toast.makeText(this, "회원가입에 실패했어요. 관리자에게 문의해주세요.", Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }
}