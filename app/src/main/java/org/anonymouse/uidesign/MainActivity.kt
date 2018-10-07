package org.anonymouse.uidesign

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.NonNull
import android.support.design.internal.BottomNavigationItemView
import android.support.design.widget.BottomNavigationView
import android.support.v4.view.ViewPager
import android.view.Menu
import android.widget.Button
import android.widget.ImageButton
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    val manager = supportFragmentManager
    val viewPager = viewpager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createPostFragment()

        val viewPager =  findViewById<ViewPager>(R.id.viewpager)
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
            bottomNavigationView.setOnNavigationItemSelectedListener{
                when(it.itemId) {
                    R.id.item_posts -> {
                        createPostFragment()
                        viewPager.setCurrentItem(0)
                        return@setOnNavigationItemSelectedListener true
                    }
                    R.id.item_add_post -> {
                        createAddPostFragment()
                        viewPager.setCurrentItem(1)
                        return@setOnNavigationItemSelectedListener true
                    }
                    R.id.item_profile -> {
                        createProfileFragment()
                        viewPager.setCurrentItem(2);
                        return@setOnNavigationItemSelectedListener true
                    }
                    else -> {
                        return@setOnNavigationItemSelectedListener true
                    }
                }

             }


    }

    fun createPostFragment() {
        val transaction = manager.beginTransaction()
        val fragment = PostFragment()
        transaction.replace(R.id.fragment_container,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    fun createAddPostFragment(){
        val transaction = manager.beginTransaction()
        val fragment = AddPostFragment()
        transaction.replace(R.id.fragment_container,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    fun createProfileFragment(){
        val transaction = manager.beginTransaction()
        val fragment = ProfileFragment()
        transaction.replace(R.id.fragment_container,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}

