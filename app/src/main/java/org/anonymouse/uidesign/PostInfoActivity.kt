package org.anonymouse.uidesign

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_post_info.*

class PostInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_info)

        //Retrieve post from PostFragment/PostsAdapter
        val post = intent.getSerializableExtra("Post") as Post

        //Fill in views
        post_content_post_info.setText(post.text)
        timestamp_post_info.setText(post.time)
        rating_post_info.setText(post.rating)


    }


}
