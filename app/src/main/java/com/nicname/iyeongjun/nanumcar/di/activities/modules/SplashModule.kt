package com.nicname.iyeongjun.nanumcar.di.activities.modules

import com.nicname.iyeongjun.nanumcar.api.inter.*
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
                                      themeApi: ThemeApi,
                                      carApi: CarApi,
                                      branchApi: BranchApi) = SplashViewModelFactory(driver,parkApi,noticeApi,themeApi,carApi,branchApi)
}
