package com.nicname.iyeongjun.nanumcar.ui.fragments.park

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

class ParkViewModelFactory : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ParkViewModel() as T
    }
}