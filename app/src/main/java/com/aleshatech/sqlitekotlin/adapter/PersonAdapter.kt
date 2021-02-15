package com.aleshatech.sqlitekotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aleshatech.sqlitekotlin.R
import com.aleshatech.sqlitekotlin.model.Name

class PersonAdapter(val personList:ArrayList<Name>) :RecyclerView.Adapter<PersonAdapter.ViewHolder>(){

    //the class is hodling the list view
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(name: Name) {
            val tvName = itemView.findViewById(R.id.tv_name) as TextView
            val tvMobile  = itemView.findViewById(R.id.tv_mobile) as TextView
            val tvEmail  = itemView.findViewById(R.id.tv_email) as TextView

            tvName.text = name.name
            tvMobile.text = name.mobile
            tvEmail.text = name.email
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return personList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(personList[position])
    }
}