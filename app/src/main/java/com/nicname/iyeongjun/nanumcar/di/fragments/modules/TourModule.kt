package com.nicname.iyeongjun.nanumcar.di.fragments.modules

import com.nicname.iyeongjun.nanumcar.ui.fragments.tour.TourViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TourModule{
    @Provides
    fun provideTourViewModelFactory() = TourViewModelFactory()
}
