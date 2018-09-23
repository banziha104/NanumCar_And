package com.nicname.iyeongjun.nanumcar.ui.activities.splash

import android.arch.lifecycle.ViewModel
import com.nicname.iyeongjun.nanumcar.api.inter.NoticeApi
import com.nicname.iyeongjun.nanumcar.api.inter.ParkApi
import com.nicname.iyeongjun.nanumcar.api.inter.ThemeApi
import com.nicname.iyeongjun.nanumcar.di.driver.DataDriver

class SplashViewModel(val driver: DataDriver,
                      val parkApi: ParkApi,
                      val noticeApi: NoticeApi,
                      val themeApi: ThemeApi) : ViewModel() {
}