package com.jiwoo.choi.gwangju_contest.api.inter

import com.jiwoo.choi.dobike.const.API_KEY
import com.jiwoo.choi.nanumcar.api.model.tour.TourModel2
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface TourApi{
    @GET("openapi/service/rest/KorService/locationBasedList")
    fun getTourData(
            @Query("numOfRows") numOfRows : Int = 100,
            @Query("pageNo") pageNo : Int = 1,
            @Query("MobileOS") mobileOs : String = "AND",
            @Query("MobileApp") mobileApp : String = "Gwangju",
            @Query("ServiceKey", encoded = true) serviceKey : String = API_KEY,
            @Query("mapX") lon : Double = 126.872869,
            @Query("mapY") lat : Double = 35.161683,
            @Query("radius") radius : Int = 50000
    ) : Observable<TourModel2>

    @GET("openapi/service/rest/KorService/locationBasedList")
    fun getTourDataWithContenttype(
            @Query("numOfRows") numOfRows : Int = 100,
            @Query("pageNo") pageNo : Int = 1,
            @Query("MobileOS") mobileOs : String = "AND",
            @Query("MobileApp") mobileApp : String = "Gwangju",
            @Query("ServiceKey", encoded = true) serviceKey : String = API_KEY,
            @Query("mapX") lon : Double = 126.872869,
            @Query("mapY") lat : Double = 35.161683,
            @Query("radius") radius : Int = 50000,
            @Query("contentTypeId") contentTypeId : Int
    ) : Observable<TourModel2>
}