package com.nicname.iyeongjun.nanumcar.di.fragments

import com.nicname.iyeongjun.nanumcar.di.fragments.modules.*
import com.nicname.iyeongjun.nanumcar.ui.fragments.info.InfoFragment
import com.nicname.iyeongjun.nanumcar.ui.fragments.navi.NaviFragment
import com.nicname.iyeongjun.nanumcar.ui.fragments.park.ParkFragment
import com.nicname.iyeongjun.nanumcar.ui.fragments.theme.ThemeFragment
import com.nicname.iyeongjun.nanumcar.ui.fragments.tour.TourFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


// 프래그먼트를 대거에 올림
@Module
abstract class FragmentBinder{
    @ContributesAndroidInjector(modules = arrayOf(InfoModule::class))
    abstract fun bindInfoModule() : InfoFragment

    @ContributesAndroidInjector(modules = arrayOf(NaviModule::class))
    abstract fun bindNaviModule() : NaviFragment

    @ContributesAndroidInjector(modules = arrayOf(ParkModule::class))
    abstract fun bindParkModule() : ParkFragment

    @ContributesAndroidInjector(modules = arrayOf(ThemeModule::class))
    abstract fun bindThemeModule() : ThemeFragment

    @ContributesAndroidInjector(modules = arrayOf(TourModule::class))
    abstract fun bindTourModule() : TourFragment
}

