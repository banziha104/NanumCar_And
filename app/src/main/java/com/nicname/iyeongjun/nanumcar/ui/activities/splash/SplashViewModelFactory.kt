package com.nicname.iyeongjun.nanumcar.ui.activities.splash

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.nicname.iyeongjun.nanumcar.api.inter.NoticeApi
import com.nicname.iyeongjun.nanumcar.api.inter.ParkApi
import com.nicname.iyeongjun.nanumcar.api.inter.ThemeApi
import com.nicname.iyeongjun.nanumcar.di.driver.DataDriver

class SplashViewModelFactory(val driver: DataDriver,
                             val parkApi: ParkApi,
                             val noticeApi: NoticeApi,
                             val themeApi: ThemeApi) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SplashViewModel(driver, parkApi, noticeApi, themeApi) as T
    }
}