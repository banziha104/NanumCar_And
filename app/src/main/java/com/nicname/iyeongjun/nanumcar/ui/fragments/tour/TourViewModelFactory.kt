package com.nicname.iyeongjun.nanumcar.ui.fragments.tour

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.nicname.iyeongjun.gwangju_contest.api.inter.TourApi
import com.nicname.iyeongjun.nanumcar.di.driver.DataDriver

class TourViewModelFactory(val driver: DataDriver,
                           val tourApi: TourApi) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TourViewModel(driver,tourApi) as T
    }
}