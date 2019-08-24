package com.pedoran.pocketepl.Repository

import com.pedoran.pocketepl.Entity.FootballMatch
import com.pedoran.pocketepl.Rest.FootballRest
import io.reactivex.Flowable

class MatchImpl(private val footballRest: FootballRest) : MatchRepo {
    override fun getEventById(id: String): Flowable<FootballMatch> = footballRest.getEventById(id)

    override fun getUpcomingMatch(id: String): Flowable<FootballMatch> = footballRest.getUpcomingMatch(id)

    override fun getFootballMatch(id: String): Flowable<FootballMatch> = footballRest.getLastmatch(id)
}