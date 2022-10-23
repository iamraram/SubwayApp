package com.haram.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

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
            if (etPw1.length() < 8 || etPw1 != etPw2) {
                txt.text = "비밀번호가 일치하지 않거나 양식이 틀렸어요."
                txt.visibility = TextView.VISIBLE
                etPw2.background = getDrawable(R.drawable.roundbuttonwhitecaution)
            }
            else {
                signup()
            }
        }
    }

    private fun signup() {
        // add firebase authorize function
    }
}