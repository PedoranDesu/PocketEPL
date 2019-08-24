package com.pedoran.pocketepl.ui.matchResult

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
import com.pedoran.pocketepl.utils.AppScheduler
import kotlinx.android.synthetic.main.fragment_match_result.*

/**
 * A simple [Fragment] subclass.
 */
class MatchResultFragment : Fragment(),ResultContract.View {
    lateinit var mPresenter : MatchResultPresenter

    private var eventLists : MutableList<Event> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_match_result, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val service = ApiService.getClient().create(FootballRest::class.java)
        val request =  MatchImpl(service)
        val scheduler = AppScheduler()
        mPresenter = MatchResultPresenter(this,request,scheduler)
        mPresenter.getFootballMatchData("4328")
    }

    override fun displayFootballMatch(eventList: List<Event>) {
        eventLists.clear()
        eventLists.addAll(eventList)
        val layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        rv_result.layoutManager = layoutManager
        rv_result.adapter = MatchAdapter(context,eventList)
    }
}
