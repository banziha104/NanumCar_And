package com.nicname.iyeongjun.nanumcar.api.inter

import com.nicname.iyeongjun.nanumcar.api.model.park.ParkModel
import com.nicname.iyeongjun.nanumcar.api.model.theme.ThemeModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ThemeApi{
    @GET("theme/")
    fun getTheme() : Observable<ThemeModel>
}