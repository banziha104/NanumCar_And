package com.nicname.iyeongjun.nanumcar.ui.fragments.park

import android.annotation.SuppressLint
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.location.Geocoder
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.nicname.iyeongjun.dobike.const.sections
import com.nicname.iyeongjun.gwangju_contest.extension.plusAssign

import com.nicname.iyeongjun.nanumcar.R
import com.nicname.iyeongjun.nanumcar.api.model.park.ParkModel
import com.nicname.iyeongjun.nanumcar.di.fragments.modules.ParkModule
import dagger.android.support.DaggerFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.fragment_park.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import javax.inject.Inject

class ParkFragment : DaggerFragment(), AnkoLogger, OnMapReadyCallback {
    @Inject
    lateinit var viewModelFactory: ParkViewModelFactory
    lateinit var viewModel: ParkViewModel
    var mapView: MapView? = null
    var model: ParkModel? = null

    var locationManager : LocationManager? = null
    var locationListener : LocationListener? = null
    var tempLocation : Location? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_park, container, false)

        viewModel = ViewModelProviders.of(this, viewModelFactory)[ParkViewModel::class.java]
        bindGps()
        viewModel
                .driver
                .parkDriver
                .subscribe({
                    model = it
                }, {
                    it.printStackTrace()
                })
        mapView = view.findViewById(R.id.mapView)
        mapView?.getMapAsync(this)
        mapView?.onCreate(savedInstanceState)
        return view
    }

    override fun onMapReady(map: GoogleMap?) {
        val temp = sections.items.filter { it.section == "강남구" }.first()// 강남구 주소로 초기세팅
        val location = LatLng(temp.lat.toDouble(), temp.long.toDouble())
        map?.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 14.5f))
        for (i in model?.results!!) {
            try {
                val marker = MarkerOptions()
                        .position(LatLng(i?.lat!!, i?.lon!!))
                        .title(i.title)
                map?.addMarker(marker)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        mapView?.onResume()
    }


    override fun onDestroy() {
        super.onDestroy()
        mapView?.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView?.onLowMemory()
    }
    @SuppressLint("MissingPermission")
    fun bindGps() {
        locationManager = activity!!.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        locationListener = object : LocationListener {
            override fun onLocationChanged(location: Location?) {
                location.let {
                    tempLocation = it
//                    val temp = Geocoder(activity!!).getFromLocation(location?.latitude!!,location?.longitude!!,1) // 위도경도정보 받아오기
                }
            }
            override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {
                info { "status : $status" }
            }

            override fun onProviderEnabled(provider: String?) {}

            override fun onProviderDisabled(provider: String?) {}
        }

        locationManager?.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 1.0f, locationListener!!)
        locationManager?.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1000, 1.0f, locationListener!!)
    }
}
