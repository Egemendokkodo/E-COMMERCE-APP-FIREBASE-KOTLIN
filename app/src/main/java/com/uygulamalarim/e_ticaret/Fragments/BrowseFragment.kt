package com.uygulamalarim.e_ticaret.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.uygulamalarim.e_ticaret.Adapters.PageAdapter
import com.uygulamalarim.e_ticaret.R
import com.uygulamalarim.e_ticaret.TechnologyItems.User


class BrowseFragment : Fragment() {


    lateinit var tablayout: TabLayout
    lateinit var ViewPager: ViewPager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_browse, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val viewPager = view.findViewById<ViewPager>(R.id.ViewPager)
        viewPager.adapter = activity?.let { PageAdapter(it.supportFragmentManager) }

        val tabLayout = view.findViewById<TabLayout>(R.id.tablayout)
        tabLayout.setupWithViewPager(viewPager)


    }


}