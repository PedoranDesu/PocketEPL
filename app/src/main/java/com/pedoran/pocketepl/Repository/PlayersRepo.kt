package com.pedoran.pocketepl.Repository

import com.pedoran.pocketepl.Entity.FootballPlayer
import io.reactivex.Flowable

interface PlayersRepo {
    fun getAllPlayers(teamId: String?) : Flowable<FootballPlayer>
}