package com.nicname.iyeongjun.nanumcar.di.global

import com.nicname.iyeongjun.nanumcar.di.driver.DataDriver
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DriverModule{
    @Provides
    @Singleton
    fun provideDriver() = DataDriver()
}