package com.nicname.iyeongjun.nanumcar.di.activities.modules

import com.nicname.iyeongjun.nanumcar.di.driver.DataDriver
import com.nicname.iyeongjun.nanumcar.ui.activities.detail.DetailViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class DetailModule{
    @Provides
    fun provideDetailViewModelFactory(driver: DataDriver) = DetailViewModelFactory(driver)
}