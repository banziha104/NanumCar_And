package com.nicname.iyeongjun.nanumcar.ui.fragments.theme

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

class ThemeViewModelFactory : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ThemeViewModel() as T
    }
}