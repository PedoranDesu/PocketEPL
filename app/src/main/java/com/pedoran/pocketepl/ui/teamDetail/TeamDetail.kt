package com.pedoran.pocketepl.ui.teamDetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.pedoran.pocketepl.Entity.Player
import com.pedoran.pocketepl.Entity.Team
import com.pedoran.pocketepl.R
import com.pedoran.pocketepl.Repository.PlayersImpl
import com.pedoran.pocketepl.Repository.TeamImpl
import com.pedoran.pocketepl.Rest.ApiService
import com.pedoran.pocketepl.Rest.FootballRest
import com.pedoran.pocketepl.adapter.PlayerAdapter
import com.pedoran.pocketepl.adapter.TeamAdapter
import com.pedoran.pocketepl.utils.AppScheduler
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_team_detail.*
import kotlinx.android.synthetic.main.fragment_team.*

class TeamDetail : AppCompatActivity() {
    lateinit var team : Team
    private var playerLists : MutableList<Player> = mutableListOf()
    lateinit var schedulers : AppScheduler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team_detail)
        team = if(savedInstanceState != null){
            savedInstanceState.getParcelable("team")!!
        }else{
            intent.getParcelableExtra("team")
        }

        supportActionBar?.title = team.strTeam
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //overview
        Glide.with(applicationContext)
            .load(team.strTeamBadge)
            .into(imgDetailTeam)
        tvDetailStrTeam.text = team.strTeam
        tvStadium.text = team.strStadium
        tvWebsite.text = team.strWebsite
        //player list
        rv_detailPlayer.layoutManager = LinearLayoutManager(applicationContext)
        rv_detailPlayer.adapter = PlayerAdapter(applicationContext,playerLists)

        schedulers = AppScheduler()
        val api = ApiService.getClient().create(FootballRest::class.java)
        val playerImpl = PlayersImpl(api)
        CompositeDisposable().add(playerImpl.getAllPlayers(team.idTeam)
            .observeOn(schedulers.ui())
            .subscribeOn(schedulers.io())
            .subscribe(
                {
                    displayPlayers(it.player)
                },{ error -> Log.e("Error",error.localizedMessage)}
            )
        )
    }

    fun displayPlayers(playerList : List<Player>){
        playerLists.clear()
        playerLists.addAll(playerList)
        rv_detailPlayer.adapter?.notifyDataSetChanged()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> this.finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
