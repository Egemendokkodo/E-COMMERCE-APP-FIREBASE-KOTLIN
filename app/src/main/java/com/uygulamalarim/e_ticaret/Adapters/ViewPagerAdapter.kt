package com.uygulamalarim.e_ticaret.Adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.uygulamalarim.e_ticaret.Fragments.clothingFragment
import com.uygulamalarim.e_ticaret.Fragments.fragmentHomeItems
import com.uygulamalarim.e_ticaret.Fragments.technologyFragment

class PageAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> {
                return technologyFragment()
            }
            1 -> {
                return fragmentHomeItems()
            }
            2 -> {
                return clothingFragment()
            }
            else -> {
                return technologyFragment()
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when (position) {
            0 -> {
                return "Technology"
            }
            1 -> {
                return "Home"
            }
            2 -> {
                return "Clothing"
            }
        }
        return super.getPageTitle(position)
    }

}