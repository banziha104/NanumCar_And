package com.nicname.iyeongjun.nanumcar.di.activities

import com.nicname.iyeongjun.nanumcar.di.activities.modules.MainModule
import com.nicname.iyeongjun.nanumcar.di.activities.modules.SplashModule
import com.nicname.iyeongjun.nanumcar.ui.activities.main.MainActivity
import com.nicname.iyeongjun.nanumcar.ui.activities.splash.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


// 액티비티를 대거 그래프에 올리는 클래스
@Module
abstract class ActivityBinder{

    @ContributesAndroidInjector(modules = arrayOf(MainModule::class))
    abstract fun bindMain() : MainActivity

    @ContributesAndroidInjector(modules = arrayOf(SplashModule::class))
    abstract fun bindSplashModule() : SplashActivity
}