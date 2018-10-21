package org.anonymouse.uidesign

import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class ViewPagerAdapter internal constructor(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private val COUNT = 3
    public var fromViewPager = false
    override fun getItem(position: Int): Fragment? {
        var fragment: Fragment? = null
        when (position) {
            0 -> {
                fragment = PostFragment()
            }
            1 -> {
                fragment = AddPostFragment()
            }
            2 -> {
                fragment = ProfileFragment()
            }
        }

        return fragment
    }

    override fun getCount(): Int {
        return COUNT
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return "Tab " + (position + 1)
    }
}
