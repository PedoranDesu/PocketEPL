package com.pedoran.pocketepl.Repository

import com.pedoran.pocketepl.Entity.FootballTeams
import io.reactivex.Flowable

interface TeamRepo {
    fun getTeams(id : String = "0") : Flowable<FootballTeams>

    fun getTeamsDetail(id : String = "0") : Flowable<FootballTeams>

    fun getAllTeam(id: String) : Flowable<FootballTeams>
}