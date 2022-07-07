package com.example.constraintlayout_navigation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.constraintlayout_navigation.Bean.TestBean

class nest_adapter(val nestList:List<TestBean>):RecyclerView.Adapter<nest_adapter.ViewHolder> (){
    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val nestImage: ImageView = view.findViewById(R.id.item_nest_image)
        val nestText: TextView = view.findViewById(R.id.item_nest_text)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.home_nest_cross, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val nestItem=nestList[position]
        holder.nestImage.setImageResource(nestItem.img)
        holder.nestText.text = nestItem.text
    }
    override fun getItemCount() = nestList.size
}