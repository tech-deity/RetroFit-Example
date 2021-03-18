package com.demo.fileshareapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.demo.fileshareapp.R
import com.demo.fileshareapp.model.DataModel
import kotlinx.android.synthetic.main.item_list.view.*

class DataAdapter (private var dataList:List<DataModel>): RecyclerView.Adapter<DataAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val currentData=dataList.get(position)
        holder.titleTextView.text=currentData.title

    }

    override fun getItemCount(): Int {
        return dataList.size
    }
    class ViewHolder(itemLayoutView: View) :RecyclerView.ViewHolder(itemLayoutView){

        lateinit var titleTextView: TextView
        init {
            titleTextView=itemLayoutView.title

        }
    }

}