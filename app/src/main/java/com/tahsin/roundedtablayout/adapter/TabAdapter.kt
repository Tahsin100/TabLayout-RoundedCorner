package com.tahsin.roundedtablayout.adapter

import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import java.util.ArrayList
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.tahsin.roundedtablayout.R
import com.tahsin.roundedtablayout.R.layout.*
import com.tahsin.roundedtablayout.RTLApplication


class TabAdapter internal constructor(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
    private val mFragmentList = ArrayList<Fragment>()
    private val mFragmentTitleList = ArrayList<String>()
    override fun getItem(position: Int): Fragment {
        return mFragmentList[position]
    }

    fun addFragment(fragment: Fragment, title: String) {
        mFragmentList.add(fragment)
        mFragmentTitleList.add(title)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mFragmentTitleList[position]
    }

    override fun getCount(): Int {
        return mFragmentList.size

    }

    fun getTabView(tabLayout : TabLayout, position: Int): View {

        val view = when (position) {
            1 -> LayoutInflater.from(RTLApplication.instance).inflate(custom_tab_middle, tabLayout, false)
            0 -> LayoutInflater.from(RTLApplication.instance).inflate(custom_tab_left, tabLayout, false)
            else -> LayoutInflater.from(RTLApplication.instance).inflate(custom_tab_right, tabLayout, false)
        }

        val button = view.findViewById<TextView>(R.id.tabTextView)
        button.text = mFragmentTitleList[position]
        return view
    }
}