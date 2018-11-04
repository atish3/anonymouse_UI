package org.anonymouse.uidesign

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_post_list.*
import kotlinx.android.synthetic.main.fragment_post_list.view.*

class PostFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_post_list, container, false)
        var postList = mutableListOf<Post>(
                Post("testing", "Jan 1, 2017", 32, listOf("Reply 1", "replyingggg")),
                Post("hello", "4 days ago", 11, listOf("Reply 2", "hello hello hello")),
                Post("testing testing", "6 hours ago", 2, listOf("Reply 3", "again", "another reply")),
                Post("testing 2", "4 hours ago", 4, listOf("ala","great","yolo"))
        )
        view.recylcerview_posts.layoutManager = LinearLayoutManager(this.context)
        view.recylcerview_posts.adapter = PostsAdapter(this, postList)
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}