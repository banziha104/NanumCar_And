package com.nicname.iyeongjun.nanumcar.ui.activities.splash

import android.arch.lifecycle.ViewModel
import com.nicname.iyeongjun.nanumcar.api.inter.*
import com.nicname.iyeongjun.nanumcar.di.driver.DataDriver

class SplashViewModel(val driver: DataDriver,
                      val parkApi: ParkApi,
                      val noticeApi: NoticeApi,
                      val themeApi: ThemeApi,
                      val carApi: CarApi,
                      val branchApi: BranchApi ) : ViewModel() {
}