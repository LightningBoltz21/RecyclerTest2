package com.example.recyclertest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclertest.model.Countries
import kotlinx.android.synthetic.main.item_recycler.view.*

class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

}

class RecyclerAdapter(var list:List<Countries.Result>) : RecyclerView.Adapter<MyHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_recycler, parent, false)
        return MyHolder(view)

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {

        holder.itemView.countryName.text = list[position].name + ": " + list[position].code
        //delete button
        holder.itemView.setOnClickListener(){

        }
    }
}
