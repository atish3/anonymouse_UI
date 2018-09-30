package org.anonymouse.uidesign

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_msg_list.*

class MsgFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_msg_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var postList = mutableListOf<Post>(
                Post("testing", "Jan 1, 2017", 32),
                Post("hello", "4 days ago", 11),
                Post("testing testing", "6 hours ago", 2)
        )
        recylcerview_posts.layoutManager = LinearLayoutManager(this.context)
        recylcerview_posts.adapter = PostsAdapter(this, postList)
    }
}