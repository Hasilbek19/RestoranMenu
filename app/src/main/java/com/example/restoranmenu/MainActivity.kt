package com.example.restoranmenu

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: MenuAdapter
    private var menuList = mutableListOf<MenuItem>()
    private var isAdmin = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rv = findViewById<RecyclerView>(R.id.recyclerMenu)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val btnAdd = findViewById<Button>(R.id.btnAdd)

        // Demo ma'lumot
        menuList.add(MenuItem(1, "Osh", 15000.0))
        menuList.add(MenuItem(2, "Shashlik", 12000.0))

        adapter = MenuAdapter(menuList, isAdmin,
            onEdit = { item ->
                val i = Intent(this, AddEditActivity::class.java)
                i.putExtra("id", item.id)
                i.putExtra("name", item.name)
                i.putExtra("price", item.price)
                startActivity(i)
            },
            onDelete = { item ->
                menuList.remove(item)
                adapter.notifyDataSetChanged()
            }
        )

        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = adapter

        btnLogin.setOnClickListener {
            val loginIntent = Intent(this, LoginActivity::class.java)
            startActivityForResult(loginIntent, 1)
        }

        btnAdd.setOnClickListener {
            if (isAdmin) {
                startActivity(Intent(this, AddEditActivity::class.java))
            } else {
                btnLogin.text = "Avval LOGIN qiling!"
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            isAdmin = data?.getBooleanExtra("isAdmin", false) ?: false
            adapter.isAdmin = isAdmin
            adapter.notifyDataSetChanged()
        }
    }
}
