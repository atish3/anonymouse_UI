package org.anonymouse.uidesign

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.NonNull
import android.support.design.internal.BottomNavigationItemView
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v4.view.ViewPager
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageButton
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    val manager = supportFragmentManager

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item!!.itemId){
            R.id.id_setting ->{
                val intent = Intent(this,SettingActivity::class.java)
                this.startActivity(intent)
                return true
            }
            else ->{
                return true
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var MYPERMISSION =0
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            // Permission is not granted
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),MYPERMISSION)
        }
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

