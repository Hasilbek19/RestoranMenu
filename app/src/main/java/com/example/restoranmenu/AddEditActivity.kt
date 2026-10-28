package com.example.restoranmenu

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class AddEditActivity : AppCompatActivity() {

    private var itemId = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_edit)

        val etName = findViewById<EditText>(R.id.etName)
        val etPrice = findViewById<EditText>(R.id.etPrice)
        val btnSave = findViewById<Button>(R.id.btnSave)

        if (intent.hasExtra("id")) {
            itemId = intent.getIntExtra("id", -1)
            etName.setText(intent.getStringExtra("name"))
            etPrice.setText(intent.getDoubleExtra("price", 0.0).toString())
        }

        btnSave.setOnClickListener {
            finish()
        }
    }
}
