package com.example.restoranmenu

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val etUser = findViewById<EditText>(R.id.etUser)
        val etPass = findViewById<EditText>(R.id.etPass)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        btnLogin.setOnClickListener {
            val user = etUser.text.toString()
            val pass = etPass.text.toString()

            if (user == "admin" && pass == "12345") {
                val i = Intent(this, MainActivity::class.java)
                i.putExtra("isAdmin", true)
                startActivity(i)
                finish()
            } else {
                etPass.error = "Login yoki parol noto‘g‘ri!"
            }
        }
    }
}
