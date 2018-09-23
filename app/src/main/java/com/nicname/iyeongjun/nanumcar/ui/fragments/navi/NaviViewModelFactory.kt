package com.nicname.iyeongjun.nanumcar.ui.fragments.navi

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

class NaviViewModelFactory : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NaviViewModel() as T
    }
}