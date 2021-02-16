package com.aleshatech.sqlitekotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aleshatech.sqlitekotlin.R
import com.aleshatech.sqlitekotlin.model.ImageM
import com.bumptech.glide.Glide

class ImageAdapter (val imageList:List<ImageM>,val context: Context):RecyclerView.Adapter<ImageAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.image_item,
                parent, false))
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.tvAuthName.text = imageList.get(position).author
        var picUrl:String = imageList.get(position).download_url

        Glide.with(context).load(picUrl).into(holder.imgvPic)

    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

            val tvAuthName = itemView.findViewById(R.id.tv_auth_name) as TextView
            val imgvPic  = itemView.findViewById(R.id.imv_pic) as ImageView

    }
}