package com.pedoran.pocketepl.Repository

import com.pedoran.pocketepl.Entity.FootballTeams
import com.pedoran.pocketepl.Rest.FootballRest
import io.reactivex.Flowable

class TeamImpl(private val footballRest: FootballRest): TeamRepo {
    override fun getAllTeam(id: String) = footballRest.getAllTeam(id)
    override fun getTeams(id: String): Flowable<FootballTeams> = footballRest.getAllTeam(id)
    override fun getTeamsDetail(id: String): Flowable<FootballTeams> = footballRest.getTeam(id)
}