package com.nicname.iyeongjun.nanumcar.ui.activities.main

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.system.Os.bind
import com.nicname.iyeongjun.dobike.const.T_MAP_KEY
import com.nicname.iyeongjun.gwangju_contest.extension.plusAssign
import com.nicname.iyeongjun.gwangju_contest.rx.AutoClearedDisposable
import com.nicname.iyeongjun.nanumcar.R
import com.nicname.iyeongjun.nanumcar.adapter.pager.MainPagerAdapter
import com.nicname.iyeongjun.nanumcar.util.TMapUtils
import com.skt.Tmap.TMapTapi
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: MainViewModelFactory
    lateinit var viewModel : MainViewModel
    val disposable = AutoClearedDisposable(this)
    val viewDisposables = AutoClearedDisposable(lifecycleOwner = this,alwaysClearOnStop = false)
    val tabNames = arrayOf("테마","주차장","안내","여행지","네비")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lifecycle += viewDisposables
        viewModel = ViewModelProviders.of(this, viewModelFactory)[MainViewModel::class.java]
        setTmap()
        bindViewPager(viewModel.fragements)
    }

    private fun bindViewPager(list : List<Fragment>) {
        mainViewpager.adapter = MainPagerAdapter(supportFragmentManager, list)
        for (i in 0..4) tab.addTab(tab.newTab().setText(tabNames[i]))
        mainViewpager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab))
        tab.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(mainViewpager))
        tab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tabs: TabLayout.Tab) {

            }

            override fun onTabUnselected(tabs: TabLayout.Tab) {

            }

            override fun onTabReselected(tabs: TabLayout.Tab) {

            }
        })
    }

    private fun setTmap(){
        TMapUtils.setTmap(this)
    }
}
