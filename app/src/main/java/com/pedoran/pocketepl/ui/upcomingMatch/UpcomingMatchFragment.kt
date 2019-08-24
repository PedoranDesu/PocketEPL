package com.pedoran.pocketepl.ui.upcomingMatch


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.pedoran.pocketepl.Entity.Event

import com.pedoran.pocketepl.R
import com.pedoran.pocketepl.Repository.MatchImpl
import com.pedoran.pocketepl.Rest.ApiService
import com.pedoran.pocketepl.Rest.FootballRest
import com.pedoran.pocketepl.adapter.MatchAdapter
import com.pedoran.pocketepl.ui.matchResult.UpcomingContract
import com.pedoran.pocketepl.ui.matchResult.UpcomingMatchPresenter
import com.pedoran.pocketepl.utils.AppScheduler
import kotlinx.android.synthetic.main.fragment_upcoming_match.*

/**
 * A simple [Fragment] subclass.
 */
class UpcomingMatchFragment : Fragment(),UpcomingContract.View {
    lateinit var mPresenter : UpcomingMatchPresenter

    private var upcomingLists : MutableList<Event> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_upcoming_match, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val service = ApiService.getClient().create(FootballRest::class.java)
        val request =  MatchImpl(service)
        val scheduler = AppScheduler()
        mPresenter = UpcomingMatchPresenter(this,request,scheduler)
        mPresenter.getFootballMatchData("4328")
    }

    override fun displayFootballMatch(eventList: List<Event>) {
        upcomingLists.clear()
        upcomingLists.addAll(eventList)
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
        rv_upcoming.layoutManager = layoutManager
        rv_upcoming.adapter = MatchAdapter(context,eventList)
    }


}
