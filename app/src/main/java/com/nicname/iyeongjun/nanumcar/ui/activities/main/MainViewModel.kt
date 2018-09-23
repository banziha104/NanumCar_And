package com.nicname.iyeongjun.nanumcar.ui.activities.main

import android.arch.lifecycle.ViewModel
import com.nicname.iyeongjun.nanumcar.di.driver.DataDriver
import com.nicname.iyeongjun.nanumcar.ui.fragments.info.InfoFragment
import com.nicname.iyeongjun.nanumcar.ui.fragments.navi.NaviFragment
import com.nicname.iyeongjun.nanumcar.ui.fragments.park.ParkFragment
import com.nicname.iyeongjun.nanumcar.ui.fragments.theme.ThemeFragment
import com.nicname.iyeongjun.nanumcar.ui.fragments.tour.TourFragment

class MainViewModel(val driver: DataDriver) : ViewModel(){

    val fragements = listOf(
            ThemeFragment(),
            ParkFragment(),
            InfoFragment(),
            TourFragment(),
            NaviFragment())
}