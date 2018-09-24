package com.nicname.iyeongjun.nanumcar.ui.fragments.theme

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.nicname.iyeongjun.nanumcar.di.driver.DataDriver

class ThemeViewModelFactory(val driver: DataDriver) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ThemeViewModel(driver) as T
    }
}