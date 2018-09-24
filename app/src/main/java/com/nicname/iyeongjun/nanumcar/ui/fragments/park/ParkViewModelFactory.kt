package com.nicname.iyeongjun.nanumcar.ui.fragments.park

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.nicname.iyeongjun.nanumcar.di.driver.DataDriver

class ParkViewModelFactory(val driver: DataDriver) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ParkViewModel(driver) as T
    }
}