package org.anonymouse.uidesign

import android.database.sqlite.SQLiteOpenHelper
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_post_list.*
import kotlinx.android.synthetic.main.fragment_post_list.view.*
import android.database.sqlite.SQLiteDatabase
import android.provider.ContactsContract
import java.text.SimpleDateFormat
import java.util.*


class PostFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_post_list, container, false)

        val post_dbHelper = PostDatabaseHelper(this.context!!)
        val post_db = post_dbHelper.readableDatabase
        val post_cursor = post_db.rawQuery("select * from "+ post_dbTable,null)

        val reply_dbHelper = ReplyDatabaseHelper(this.context!!)
        val reply_db = reply_dbHelper.readableDatabase
        val postList = mutableListOf<Post>()
        with(post_cursor) {
            while (moveToNext()){
                val post_Id = getInt(0)
                val content = getString(1)
                val post_time = getLong(2)
                val rating = getInt(3)
                val reply_list = mutableListOf<Reply>()
                val reply_cur = reply_db.rawQuery("select * from "+ reply_dbTable+" where post_id = "+post_Id.toString() ,null)
                with(reply_cur){
                    while (moveToNext()){
                        val reply_content = getString(2)
                        val reply_time = getLong(3)
                        val author = getString(4)
                        val date = Date(reply_time)
                        val r_t = SimpleDateFormat("yyyy.MM.dd HH:mm").format(date)
                        reply_list.add(Reply(author,reply_content,r_t))
                    }
                }
                val post_date = Date(post_time)
                val p_t =SimpleDateFormat("yyyy.MM.dd HH:mm").format(post_date)
                postList.add(Post(content,p_t,rating,reply_list))
            }
        }
        view.recylcerview_posts.layoutManager = LinearLayoutManager(this.context)
        view.recylcerview_posts.adapter = PostsAdapter(this, postList)
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}