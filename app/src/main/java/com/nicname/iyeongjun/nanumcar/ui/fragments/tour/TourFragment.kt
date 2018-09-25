package com.nicname.iyeongjun.nanumcar.ui.fragments.tour


import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nicname.iyeongjun.dobike.const.sections
import com.nicname.iyeongjun.gwangju_contest.extension.plusAssign

import com.nicname.iyeongjun.nanumcar.R
import com.nicname.iyeongjun.nanumcar.adapter.recycler.tour.TourSectionAdapter
import dagger.android.support.DaggerFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.subjects.BehaviorSubject
import kotlinx.android.synthetic.main.fragment_tour.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import javax.inject.Inject

class TourFragment : DaggerFragment(), AnkoLogger {
    @Inject
    lateinit var viewModelFactory: TourViewModelFactory
    lateinit var viewModel: TourViewModel

    val tourSectionDriver = BehaviorSubject.createDefault<String>("강남구")

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        viewModel = ViewModelProviders.of(this, viewModelFactory)[TourViewModel::class.java]
        return inflater.inflate(R.layout.fragment_tour, container, false)
    }

    override fun onResume() {
        super.onResume()
        tourProgressBar.visibility = View.INVISIBLE
        tourSectionRecycler.apply {
            adapter = TourSectionAdapter(tourSectionDriver)
            layoutManager = LinearLayoutManager(activity!!)
            addItemDecoration(DividerItemDecoration(activity, DividerItemDecoration.VERTICAL))
        }

        tourSectionDriver
                .subscribe({str ->
                    val temp = sections.items.filter { it.section == str }.first()
                    viewModel
                            .tourApi
                            .getTourData(lat = temp.lat.toDouble(),
                                    lon = temp.long.toDouble())
                            .observeOn(AndroidSchedulers.mainThread())
                            .doOnSubscribe { tourProgressBar.visibility = View.VISIBLE }
                            .doOnComplete { tourProgressBar.visibility = View.INVISIBLE }
                            .subscribe({
                                info { it }
                            },{
                                it.printStackTrace()
                            })
                }, {
                    it.printStackTrace()
                })
    }


}
