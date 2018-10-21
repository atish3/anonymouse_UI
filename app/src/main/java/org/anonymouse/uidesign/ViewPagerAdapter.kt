package org.anonymouse.uidesign

import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class ViewPagerAdapter internal constructor(fm: FragmentManager, bnv: BottomNavigationView) : FragmentPagerAdapter(fm) {

    private val COUNT = 3
    public var fromViewPager = false
    private  val bottomNavigationView = bnv
    override fun getItem(position: Int): Fragment? {
        var fragment: Fragment? = null
        fromViewPager = true
        when (position) {
            0 -> {
                bottomNavigationView.setSelectedItemId(R.id.item_posts)
                fragment = PostFragment()
            }
            1 -> {
                bottomNavigationView.setSelectedItemId(R.id.item_add_post)
                fragment = AddPostFragment()
            }
            2 -> {
                bottomNavigationView.setSelectedItemId(R.id.item_profile)
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
