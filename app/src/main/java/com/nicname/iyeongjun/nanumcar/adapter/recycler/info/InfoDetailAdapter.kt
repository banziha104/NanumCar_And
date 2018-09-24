package com.nicname.iyeongjun.nanumcar.adapter.recycler.info

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.nicname.iyeongjun.nanumcar.R
import com.nicname.iyeongjun.nanumcar.api.model.car.Result


class InfoDetailAdapter(val list : List<Result>,val context : Context) : RecyclerView.Adapter<InfoDetailAdapter.InfoDetailViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InfoDetailViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_info_detail,parent,false)
        return InfoDetailViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: InfoDetailViewHolder, position: Int) {
        holder.apply {
            list[position].let {
                txtName.text = it.model
            }
        }
    }

    inner class InfoDetailViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val txtName = view.findViewById<TextView>(R.id.txtInfoDetailName)
    }
}