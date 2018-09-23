package com.nicname.iyeongjun.nanumcar.di.fragments.modules

import com.nicname.iyeongjun.nanumcar.ui.fragments.info.InfoViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class InfoModule{
    @Provides
    fun provideInfoViewModelFactory() = InfoViewModelFactory()
}