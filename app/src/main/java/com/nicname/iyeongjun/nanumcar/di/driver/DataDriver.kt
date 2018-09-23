package com.nicname.iyeongjun.nanumcar.di.driver

import com.nicname.iyeongjun.nanumcar.api.model.notice.NoticeModel
import com.nicname.iyeongjun.nanumcar.api.model.park.ParkModel
import com.nicname.iyeongjun.nanumcar.api.model.theme.ThemeModel
import com.nicname.iyeongjun.nanumcar.di.fragments.modules.ThemeModule
import io.reactivex.subjects.BehaviorSubject

class DataDriver{
    val noticeDriver = BehaviorSubject.create<NoticeModel>()
    val parkDriver = BehaviorSubject.create<ParkModel>()
    val themeDriver = BehaviorSubject.create<ThemeModel>()
}