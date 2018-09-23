package com.nicname.iyeongjun.nanumcar.di.activities.modules

import com.nicname.iyeongjun.nanumcar.di.driver.DataDriver
import com.nicname.iyeongjun.nanumcar.ui.activities.main.MainViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MainModule{
    @Provides
    fun provideMainViewModelFactory(driver : DataDriver) = MainViewModelFactory(driver)
}
