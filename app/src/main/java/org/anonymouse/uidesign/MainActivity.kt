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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager =  findViewById<ViewPager>(R.id.fragment_container)
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        val adapter = ViewPagerAdapter(supportFragmentManager)
        viewPager.setOnTouchListener { v, event ->  return@setOnTouchListener true}
        if (viewPager != null) {
            viewPager.adapter = adapter
        }

            bottomNavigationView.setOnNavigationItemSelectedListener{
                when(it.itemId) {
                    R.id.item_posts -> {
                        viewPager.setCurrentItem(0)
                        return@setOnNavigationItemSelectedListener true
                    }
                    R.id.item_add_post -> {
                        viewPager.setCurrentItem(1)
                        return@setOnNavigationItemSelectedListener true
                    }
                    R.id.item_profile -> {
                        viewPager.setCurrentItem(2)
                        return@setOnNavigationItemSelectedListener true
                    }
                    else -> {
                        return@setOnNavigationItemSelectedListener true
                    }
                }
            }


    }

}

