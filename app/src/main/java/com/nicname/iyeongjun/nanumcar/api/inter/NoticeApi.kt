package com.nicname.iyeongjun.nanumcar.api.inter

import com.nicname.iyeongjun.nanumcar.api.model.notice.NoticeModel
import io.reactivex.Observable
import retrofit2.http.GET

interface NoticeApi{
    @GET("notice/")
    fun getNotice() : Observable<NoticeModel>
}