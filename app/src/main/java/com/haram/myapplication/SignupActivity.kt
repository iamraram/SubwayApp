package com.haram.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SignupActivity : AppCompatActivity() {
    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val etName = findViewById<EditText>(R.id.etName)
        val etEmail = findViewById<EditText>(R.id.etEmail)

        val btn = findViewById<Button>(R.id.nextBtn1)
        val txt = findViewById<TextView>(R.id.textCaution)

        btn.setOnClickListener {
            if (etName.text.isBlank() || etEmail.text.isBlank()) {
                txt.text = "빈칸 없이 입력해주세요."
                txt.visibility = TextView.VISIBLE
                etEmail.background = getDrawable(R.drawable.roundbuttonwhitecaution)
                etName.background = getDrawable(R.drawable.roundbuttonwhitecaution)
            }
            else if (!Patterns.EMAIL_ADDRESS.matcher(etEmail.text.toString()).matches()) {
                txt.text = "이메일 형식에 맞게 입력해주세요."
                txt.visibility = TextView.VISIBLE
                etEmail.background = getDrawable(R.drawable.roundbuttonwhitecaution)
                etName.background = getDrawable(R.drawable.roundbuttonwhite)
            }
            else {
                val intent = Intent(this, SignupLastActivity::class.java)
                intent.putExtra("name", etName.text.toString())
                intent.putExtra("email", etEmail.text.toString())
                startActivity(intent)
            }
        }
    }
}