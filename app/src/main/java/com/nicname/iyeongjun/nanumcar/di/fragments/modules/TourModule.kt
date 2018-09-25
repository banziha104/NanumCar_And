package com.nicname.iyeongjun.nanumcar.di.fragments.modules

import com.nicname.iyeongjun.gwangju_contest.api.inter.TourApi
import com.nicname.iyeongjun.nanumcar.di.driver.DataDriver
import com.nicname.iyeongjun.nanumcar.ui.fragments.tour.TourViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TourModule{
    @Provides
    fun provideTourViewModelFactory(driver: DataDriver, tourApi: TourApi) = TourViewModelFactory(driver,tourApi)
}
