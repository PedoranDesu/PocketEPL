package com.pedoran.pocketepl.ui.matchDetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.pedoran.pocketepl.Entity.Event
import com.pedoran.pocketepl.Entity.FootballTeams
import com.pedoran.pocketepl.Entity.Team
import com.pedoran.pocketepl.R
import com.pedoran.pocketepl.Repository.TeamImpl
import com.pedoran.pocketepl.Rest.ApiService
import com.pedoran.pocketepl.Rest.FootballRest
import com.pedoran.pocketepl.utils.AppScheduler
import com.pedoran.pocketepl.utils.DateConverter
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_match_detail.*

class MatchDetail : AppCompatActivity(),DetailContract.View {
    lateinit var event : Event
    lateinit var mPresenter : DetailPresenter
    var compositeDisposable = CompositeDisposable()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_match_detail)

        event = if(savedInstanceState != null){
            savedInstanceState.getParcelable("match")!!
        }else{
            intent.getParcelableExtra("match")
        }
        supportActionBar?.title = event.strEvent
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val api = ApiService.getClient().create(FootballRest::class.java)
        val teamImpl = TeamImpl(api)
        mPresenter = DetailPresenter(this,teamImpl)

        mPresenter.getTeamBadgeHome(event.idHomeTeam)
        mPresenter.getTeamBadgeAway(event.idAwayTeam)
        initData()
    }

    override fun displayTeamBadgeHome(team: Team) {
        Glide.with(applicationContext)
            .load(team.strTeamBadge)
            .into(homeImg)
    }

    override fun displayTeamBadgeAway(team: Team) {
        Glide.with(applicationContext)
            .load(team.strTeamBadge)
            .into(awayImg)
    }

    fun initData(){
        dateScheduleTv.text = event.dateEvent?.let { DateConverter.formatDateToMatch(it) }
        roundIdTv.text = "Matchday "+ event.intRound
        homeNameTv.text = event.strHomeTeam
        homeScoreTv.text = event.intHomeScore
        awayNameTv.text = event.strAwayTeam
        awayScoreTv.text = event.intAwayScore

        homeScorerTv.text = event.strHomeGoalDetails
        awayScorerTv.text = event.strAwayGoalDetails

        gkHomeTv.text = event.strHomeLineupGoalkeeper
        gkAwayTv.text = event.strAwayLineupGoalkeeper

        defHomeTv.text = event.strHomeLineupDefense
        defAwayTv.text = event.strAwayLineupDefense

        midHomeTv.text = event.strHomeLineupMidfield
        midAwayTv.text = event.strAwayLineupMidfield

        forHomeTv.text = event.strHomeLineupForward
        forAwayTv.text = event.strAwayLineupForward

        subHomeTv.text = event.strHomeLineupSubstitutes
        subAwayTv.text = event.strAwayLineupSubstitutes
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> this.finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
