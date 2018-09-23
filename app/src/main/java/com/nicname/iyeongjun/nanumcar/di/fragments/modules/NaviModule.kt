package com.nicname.iyeongjun.nanumcar.di.fragments.modules

import com.nicname.iyeongjun.nanumcar.ui.fragments.navi.NaviViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class NaviModule{
    @Provides
    fun provideNaviViewModelFactory() = NaviViewModelFactory()
}