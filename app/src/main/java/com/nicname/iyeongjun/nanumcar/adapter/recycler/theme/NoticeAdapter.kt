package com.nicname.iyeongjun.nanumcar.adapter.recycler.theme

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.nicname.iyeongjun.nanumcar.R
import com.nicname.iyeongjun.nanumcar.api.model.notice.NoticeModel


class NoticeAdapter(noticeModel: NoticeModel,
                    val context: Context) : RecyclerView.Adapter<NoticeAdapter.NoticeViewHolder>(){
    val items = noticeModel.results
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoticeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_notice,parent,false)
        return NoticeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 4
    }

    override fun onBindViewHolder(holder: NoticeViewHolder, position: Int) {
        holder.apply {
            items[position].let {
                txtNotice.text = it.notice
            }
        }
    }

    inner class NoticeViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val txtNotice = view.findViewById<TextView>(R.id.txtNotice)
    }
}