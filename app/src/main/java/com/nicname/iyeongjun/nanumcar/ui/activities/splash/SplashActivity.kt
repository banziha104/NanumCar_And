package com.nicname.iyeongjun.nanumcar.ui.activities.splash

import android.Manifest
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.gson.Gson
import com.nicname.iyeongjun.dobike.util.PermissionController
import com.nicname.iyeongjun.gwangju_contest.extension.plusAssign
import com.nicname.iyeongjun.gwangju_contest.rx.AutoClearedDisposable
import com.nicname.iyeongjun.nanumcar.R
import com.nicname.iyeongjun.nanumcar.api.model.notice.NoticeModel
import com.nicname.iyeongjun.nanumcar.api.model.park.ParkModel
import com.nicname.iyeongjun.nanumcar.api.model.theme.ThemeModel
import com.nicname.iyeongjun.nanumcar.ui.activities.main.MainActivity
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.rxkotlin.Observables
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.jetbrains.anko.startActivity
import javax.inject.Inject

class SplashActivity : DaggerAppCompatActivity() , PermissionController.CallBack,AnkoLogger {

    @Inject
    lateinit var viewModelFactory: SplashViewModelFactory
    lateinit var viewModel : SplashViewModel
    val disposable = AutoClearedDisposable(this)
    val viewDisposables = AutoClearedDisposable(lifecycleOwner = this,alwaysClearOnStop = false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        PermissionController(this, arrayOf(
                Manifest.permission.INTERNET,
                Manifest.permission.ACCESS_FINE_LOCATION
        )).checkVersion()
    }

    override fun init() {
        info { "init 실행" }
        lifecycle += viewDisposables
        viewModel = ViewModelProviders.of(this, viewModelFactory)[SplashViewModel::class.java]


        disposable += Observables.combineLatest(
                viewModel.noticeApi.getNotice(),
                viewModel.parkApi.getPark(),
                viewModel.themeApi.getTheme()
        ){ a1,a2,a3 -> arrayOf(a1,a2,a3) }.subscribe({
            viewModel.driver.noticeDriver.onNext(it[0] as NoticeModel)
            viewModel.driver.parkDriver.onNext(it[1] as ParkModel)
            viewModel.driver.themeDriver.onNext(it[2] as ThemeModel)
            startActivity<MainActivity>()
        },{
            it.printStackTrace()
        })
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if (requestCode == PermissionController.REQ_FLAG) {
            if (PermissionController.onCheckResult(grantResults)) {
                info { "사용자 확정" }
                init()
            } else {
                Toast.makeText(this, "권한을 허용하지 않으시면 프로그램을 실행할 수 없습니다.", Toast.LENGTH_LONG).show()
            }
        }
    }
}
