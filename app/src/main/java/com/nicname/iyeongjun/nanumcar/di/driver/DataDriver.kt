package com.nicname.iyeongjun.nanumcar.di.driver

import com.nicname.iyeongjun.nanumcar.api.model.branch.BranchModel
import com.nicname.iyeongjun.nanumcar.api.model.car.CarModel
import com.nicname.iyeongjun.nanumcar.api.model.notice.NoticeModel
import com.nicname.iyeongjun.nanumcar.api.model.park.ParkModel
import com.nicname.iyeongjun.nanumcar.api.model.theme.Result
import com.nicname.iyeongjun.nanumcar.api.model.theme.ThemeModel
import com.nicname.iyeongjun.nanumcar.di.fragments.modules.ThemeModule
import io.reactivex.subjects.BehaviorSubject

class DataDriver{
    val noticeDriver = BehaviorSubject.create<NoticeModel>()
    val parkDriver = BehaviorSubject.create<ParkModel>()
    val themeDriver = BehaviorSubject.create<ThemeModel>()
    val carDriver = BehaviorSubject.create<CarModel>()
    val branchDriver = BehaviorSubject.create<BranchModel>()
    val detailDriver = BehaviorSubject.create<Result>()
}