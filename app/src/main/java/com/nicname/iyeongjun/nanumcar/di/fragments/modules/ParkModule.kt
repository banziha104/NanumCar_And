package com.nicname.iyeongjun.nanumcar.di.fragments.modules

import com.nicname.iyeongjun.nanumcar.ui.fragments.park.ParkViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ParkModule{
    @Provides
    fun provideParkViewModelFactory() = ParkViewModelFactory()
}
