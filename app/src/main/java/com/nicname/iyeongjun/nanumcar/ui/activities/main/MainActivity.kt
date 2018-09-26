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
import com.nicname.iyeongjun.nanumcar.R.id.mainViewpager
import com.nicname.iyeongjun.nanumcar.R.id.tab
import com.nicname.iyeongjun.nanumcar.adapter.pager.MainPagerAdapter
import com.nicname.iyeongjun.nanumcar.util.TMapUtils
import com.skt.Tmap.TMapTapi
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject
import android.graphics.PorterDuff
import android.support.v4.content.ContextCompat



class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: MainViewModelFactory
    lateinit var viewModel : MainViewModel
    val disposable = AutoClearedDisposable(this)
    val viewDisposables = AutoClearedDisposable(lifecycleOwner = this,alwaysClearOnStop = false)
    val tabNames = arrayOf("테마","주차장","안내","여행지","네비")
    val tabIcons = arrayOf(
            R.drawable.tab_theme,
            R.drawable.tab_park,
            R.drawable.tab_info,
            R.drawable.tab_tour,
            R.drawable.tab_navi
    )
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
        for (i in 0..4) tab.addTab(tab.newTab().setText(tabNames[i]).setIcon(tabIcons[i]))
        mainViewpager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab))
        tab.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(mainViewpager))
        tab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                val tabIconColor = ContextCompat.getColor(this@MainActivity, R.color.icon_selected)
                tab.icon!!.setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN)
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                val tabIconColor = ContextCompat.getColor(this@MainActivity, R.color.icon_unselected)
                tab.icon!!.setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN)
            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })
    }

    override fun onBackPressed() {}
    private fun setTmap(){
        TMapUtils.setTmap(this)
    }
}
