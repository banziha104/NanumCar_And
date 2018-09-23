package com.nicname.iyeongjun.nanumcar

import com.nicname.iyeongjun.nanumcar.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication


class NanumApplication : DaggerApplication(){
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }
}