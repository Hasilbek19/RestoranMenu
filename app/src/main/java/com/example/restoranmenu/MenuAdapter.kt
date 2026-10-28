package com.example.restoranmenu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class MenuAdapter(
    private val list: MutableList<MenuItem>,
    var isAdmin: Boolean,
    private val onEdit: (MenuItem) -> Unit,
    private val onDelete: (MenuItem) -> Unit
) : RecyclerView.Adapter<MenuAdapter.ViewHolder>() {



    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtName: TextView = view.findViewById(R.id.txtName)
        val txtPrice: TextView = view.findViewById(R.id.txtPrice)
        val btnEdit: ImageButton = view.findViewById(R.id.btnEdit)
        val btnDelete: ImageButton = view.findViewById(R.id.btnDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_menu, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]

        holder.txtName.text = item.name
        holder.txtPrice.text = "${item.price} so'm"

        if (!isAdmin) {
            holder.btnEdit.visibility = View.GONE
            holder.btnDelete.visibility = View.GONE
        }

        holder.btnEdit.setOnClickListener { onEdit(item) }
        holder.btnDelete.setOnClickListener { onDelete(item) }
    }

    override fun getItemCount() = list.size

}
