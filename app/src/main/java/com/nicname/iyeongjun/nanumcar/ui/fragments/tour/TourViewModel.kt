package com.nicname.iyeongjun.nanumcar.ui.fragments.tour

import android.arch.lifecycle.ViewModel
import com.nicname.iyeongjun.gwangju_contest.api.inter.TourApi
import com.nicname.iyeongjun.nanumcar.di.driver.DataDriver

class TourViewModel(val driver: DataDriver,
                    val tourApi: TourApi) : ViewModel(){
}