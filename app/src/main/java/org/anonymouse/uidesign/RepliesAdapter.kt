package org.anonymouse.uidesign

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_post.view.*
import kotlinx.android.synthetic.main.reply_content.view.*
import java.io.Serializable


class RepliesAdapter(val postInfoActivity: PostInfoActivity, val repliesList: List<String>)
    : RecyclerView.Adapter<CustomViewHolder>() {
    override fun getItemCount(): Int {
        return repliesList.size
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(p0.context)
        val cellForRow = layoutInflater.inflate(R.layout.reply_content, p0, false)
        return CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.view.reply.text = repliesList[position]
    }


}

