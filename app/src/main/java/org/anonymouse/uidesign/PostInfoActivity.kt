package org.anonymouse.uidesign

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_post_info.*

class PostInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_info)

        //Retrieve post from PostFragment/PostsAdapter
        val post = intent.getSerializableExtra("Post") as Post
        val username: String = intent.getStringExtra("Username") as String
        //Fill in views
        post_content_post_info.setText(post.text)
        timestamp_post_info.setText(post.time)
        rating_post_info.setText(post.rating.toString())

        replies_recyclerview_post_info.layoutManager = LinearLayoutManager(this)
        replies_recyclerview_post_info.adapter = RepliesAdapter(this, post.replies)
        reply_button_post_info.setOnClickListener {
            post.replies.add(Reply(username, new_reply_post_info.text.toString(),"1-1-1970"))
            (replies_recyclerview_post_info.adapter as RepliesAdapter).notifyItemInserted(post.replies.size-1)
        }
    }

}
