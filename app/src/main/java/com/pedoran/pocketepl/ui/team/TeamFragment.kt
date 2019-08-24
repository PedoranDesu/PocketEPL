package com.pedoran.pocketepl.ui.team


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.pedoran.pocketepl.Entity.FootballMatch
import com.pedoran.pocketepl.Entity.Team

import com.pedoran.pocketepl.R
import com.pedoran.pocketepl.Repository.TeamImpl
import com.pedoran.pocketepl.Rest.ApiService
import com.pedoran.pocketepl.Rest.FootballRest
import com.pedoran.pocketepl.adapter.MatchAdapter
import com.pedoran.pocketepl.adapter.TeamAdapter
import com.pedoran.pocketepl.utils.AppScheduler
import com.pedoran.pocketepl.utils.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subscribers.ResourceSubscriber
import kotlinx.android.synthetic.main.fragment_match_result.*
import kotlinx.android.synthetic.main.fragment_team.*
import retrofit2.Retrofit
import java.util.*

/**
 * A simple [Fragment] subclass.
 */
class TeamFragment : Fragment() {
    private var teamLists : MutableList<Team> = mutableListOf()
    lateinit var schedulers : AppScheduler

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_team, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        rv_teams.layoutManager = GridLayoutManager(context,2)
        rv_teams.adapter = TeamAdapter(context,teamLists)

        schedulers = AppScheduler()
        val api = ApiService.getClient().create(FootballRest::class.java)
        val teamImpl = TeamImpl(api)
        CompositeDisposable().add(teamImpl.getAllTeam("4328")
            .observeOn(schedulers.ui())
            .subscribeOn(schedulers.io())
            .subscribe(
                {
                    displayTeams(it.teams)
                },{ error -> Log.e("Error",error.localizedMessage)}
            )
        )
    }

    private fun displayTeams(teamList: List<Team>) {
        teamLists.clear()
        teamLists.addAll(teamList)
        rv_teams.adapter?.notifyDataSetChanged()
    }


}
