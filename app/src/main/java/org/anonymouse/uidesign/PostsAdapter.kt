package org.anonymouse.uidesign

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_post.view.*

data class Post(var text: String, val time: String, var rating: Int) {
}
class PostsAdapter(val msgFragment: PostFragment, val postsList: List<Post>)
    : RecyclerView.Adapter<CustomViewHolder>() {
    override fun getItemCount(): Int {
        return postsList.size
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(p0.context)
        val cellForRow = layoutInflater.inflate(R.layout.fragment_post, p0, false)
        return CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.view.textview_post_content.text = postsList.get(position).text
        holder.view.textview_post_time.text = postsList.get(position).time
        holder.view.textview_post_rating.text = postsList.get(position).rating.toString()
        holder.view.btn_vote_up.setOnClickListener {
            postsList.get(position).rating +=1
            holder.view.textview_post_rating.text = postsList.get(position).rating.toString()
        }
        holder.view.btn_vote_down.setOnClickListener {
            postsList.get(position).rating -=1
            holder.view.textview_post_rating.text = postsList.get(position).rating.toString()
        }
    }


}


class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view) {
}