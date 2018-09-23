package com.nicname.iyeongjun.nanumcar.di.global

import com.nicname.iyeongjun.dobike.const.API_URL
import com.nicname.iyeongjun.dobike.const.SERVER_URL
import com.nicname.iyeongjun.dobike.const.T_BASE_URL
import com.nicname.iyeongjun.gwangju_contest.api.inter.TourApi
import com.nicname.iyeongjun.nanumcar.api.inter.NoticeApi
import com.nicname.iyeongjun.nanumcar.api.inter.ParkApi
import com.nicname.iyeongjun.nanumcar.api.inter.ThemeApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module
class ApiModule{
    @Provides
    @Singleton
    fun provideNoticeModel(rxAdapter: CallAdapter.Factory,
                            @Named("gson")gsonConverter: Converter.Factory,
                            client: OkHttpClient)
            = Retrofit.Builder()
            .baseUrl(SERVER_URL)
            .client(client)
            .addCallAdapterFactory(rxAdapter)
            .addConverterFactory(gsonConverter)
            .build()
            .create(NoticeApi::class.java)

    @Provides
    @Singleton
    fun provideParkModel(rxAdapter: CallAdapter.Factory,
                         @Named("gson")gsonConverter: Converter.Factory,
                         client: OkHttpClient)
            = Retrofit.Builder()
            .baseUrl(SERVER_URL)
            .client(client)
            .addCallAdapterFactory(rxAdapter)
            .addConverterFactory(gsonConverter)
            .build()
            .create(ParkApi::class.java)

    @Provides
    @Singleton
    fun provideThemeModel(rxAdapter: CallAdapter.Factory,
                         @Named("gson")gsonConverter: Converter.Factory,
                         client: OkHttpClient)
            = Retrofit.Builder()
            .baseUrl(SERVER_URL)
            .client(client)
            .addCallAdapterFactory(rxAdapter)
            .addConverterFactory(gsonConverter)
            .build()
            .create(ThemeApi::class.java)

    @Provides
    @Singleton
    fun provideTourApi(rxAdapter: CallAdapter.Factory,
                       @Named("xml") xmlConverter : Converter.Factory,
                       client: OkHttpClient)
            = Retrofit.Builder()
            .baseUrl(API_URL)
            .client(client)
            .addCallAdapterFactory(rxAdapter)
            .addConverterFactory(xmlConverter)
            .build()
            .create(TourApi::class.java)
}