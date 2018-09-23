package com.nicname.iyeongjun.nanumcar.di.activities.modules

import com.nicname.iyeongjun.nanumcar.api.inter.NoticeApi
import com.nicname.iyeongjun.nanumcar.api.inter.ParkApi
import com.nicname.iyeongjun.nanumcar.api.inter.ThemeApi
import com.nicname.iyeongjun.nanumcar.di.driver.DataDriver
import com.nicname.iyeongjun.nanumcar.ui.activities.splash.SplashViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class SplashModule{
    @Provides
    fun provideSplashViewModelFactory(driver: DataDriver,
                                      parkApi: ParkApi,
                                      noticeApi: NoticeApi,
                                      themeApi: ThemeApi) = SplashViewModelFactory(driver,parkApi,noticeApi,themeApi)
}
