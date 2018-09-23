package com.nicname.iyeongjun.nanumcar.di.fragments.modules

import com.nicname.iyeongjun.nanumcar.ui.fragments.theme.ThemeViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ThemeModule{
    @Provides
    fun provideThemeViewModelFactory() = ThemeViewModelFactory()

}