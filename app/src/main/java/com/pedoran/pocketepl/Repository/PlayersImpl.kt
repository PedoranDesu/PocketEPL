package com.pedoran.pocketepl.Repository

import com.pedoran.pocketepl.Rest.FootballRest

class PlayersImpl (private val footballRest: FootballRest): PlayersRepo {
    override fun getAllPlayers(teamId: String?) = footballRest.getAllPlayers(teamId)
}