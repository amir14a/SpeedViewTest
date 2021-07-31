package com.aa.speedviewtest

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class MainFragmentPager(fa: AppCompatActivity) : FragmentStateAdapter(fa) {
    override fun getItemCount(): Int = 1
    override fun createFragment(position: Int): Fragment = MyFragment()
}