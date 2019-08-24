package com.pedoran.pocketepl.Repository

import com.pedoran.pocketepl.Entity.FootballMatch
import io.reactivex.Flowable

interface MatchRepo {
    fun getFootballMatch(id : String) : Flowable<FootballMatch>

    fun getUpcomingMatch(id : String) : Flowable<FootballMatch>

    fun getEventById(id: String) : Flowable<FootballMatch>
}