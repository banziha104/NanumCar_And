package com.nicname.iyeongjun.nanumcar.ui.fragments.info

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

class InfoViewModelFactory : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return InfoViewModel() as T
    }
}