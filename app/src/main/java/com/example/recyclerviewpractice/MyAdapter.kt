package com.example.recyclerviewpractice

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MyAdapter(private val data:ArrayList<MyDataClass>):RecyclerView.Adapter<MyAdapter.CustomViewHolder>() {
    private var mOnClickListener: OnClickListener?= null

    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val profile: ImageView = itemView.findViewById(R.id.image)
        val title: TextView = itemView.findViewById(R.id.title)
        val date: TextView = itemView.findViewById(R.id.date)
        val button: Button = itemView.findViewById(R.id.button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.simple_layout,parent,false)
        return CustomViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val singleData = data[position]
        holder.title.text = singleData.title
        holder.date.text = singleData.date
        Glide.with(holder.profile.context).load(singleData.image).into(holder.profile)

        holder.button.setOnClickListener {
            if (mOnClickListener!= null){
                mOnClickListener!!.onClick(position,singleData)
            }
        }

    }

    override fun getItemCount(): Int {
        return data.size
    }

    interface OnClickListener{
        fun onClick(position: Int, model: MyDataClass)
    }
    fun setOnClickListener(onClickListener: OnClickListener){
        this.mOnClickListener = onClickListener
    }

}