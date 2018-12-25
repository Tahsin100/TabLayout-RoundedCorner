package com.tahsin.roundedtablayout

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import com.tahsin.roundedtablayout.adapter.TabAdapter
import com.tahsin.roundedtablayout.fragments.Fragment1
import com.tahsin.roundedtablayout.fragments.Fragment2
import com.tahsin.roundedtablayout.fragments.Fragment3
import kotlinx.android.synthetic.main.activity_main.*
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    private var adapter : TabAdapter ?= null
    //private var tabTitleList = arrayListOf<String>("Tab1", "Tab2", "Tab3")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = TabAdapter(supportFragmentManager)
        adapter?.addFragment(Fragment1(), "TAB1")
        adapter?.addFragment(Fragment2(), "TAB2")
        adapter?.addFragment(Fragment3(), "TAB3")

        viewPager.adapter = adapter

        tabLayout.setupWithViewPager(viewPager)

        // Without ViewPager
        /*tabLayout.addTab(tabLayout.newTab())
        tabLayout.addTab(tabLayout.newTab())
        tabLayout.addTab(tabLayout.newTab())*/

        highLightCurrentTab(0)

        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(p0: Int) {
                highLightCurrentTab(p0)
            }

            override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {

            }

            override fun onPageSelected(p0: Int) {

            }

        })


/*      // Without ViewPager
        tabLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
            override fun onTabReselected(p0: TabLayout.Tab?) {

            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {

            }

            override fun onTabSelected(p0: TabLayout.Tab?) {
              highLightCurrentTab(p0?.position!!)
            }
        })*/
    }

    private fun highLightCurrentTab(position: Int) {
        for (i in 0 until tabLayout.tabCount) {
            val tab = tabLayout.getTabAt(i)!!
            tab.customView = null
            tab.customView = adapter?.getTabView(tabLayout, i)
        }
        val tab = tabLayout.getTabAt(position)!!
        tab.customView = null
        tab.customView = adapter?.getTabView(tabLayout, position)
    }


/*      // Without ViewPager
        private fun getTabView(tabLayout : TabLayout, position: Int): View {

        val view = when (position) {
            1 -> LayoutInflater.from(RTLApplication.instance).inflate(R.layout.custom_tab_middle, tabLayout, false)
            0 -> LayoutInflater.from(RTLApplication.instance).inflate(R.layout.custom_tab_left, tabLayout, false)
            else -> LayoutInflater.from(RTLApplication.instance).inflate(R.layout.custom_tab_right, tabLayout, false)
        }

        val button = view.findViewById<TextView>(R.id.tabTextView)
        button.text = tabTitleList[position]
        return view
    }*/

}
