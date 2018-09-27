package com.nicname.iyeongjun.nanumcar.ui.activities.detail

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.nicname.iyeongjun.nanumcar.di.driver.DataDriver

class DetailViewModelFactory(val driver: DataDriver) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DetailViewModel(driver) as T
    }
}