package com.pedoran.pocketepl.Rest

import com.pedoran.pocketepl.Entity.*
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface FootballRest {
    //matchresult
    @GET("eventspastleague.php")
    fun getLastmatch(@Query("id") id:String) : Flowable<FootballMatch>
    //upcomingmatch
    @GET("eventsnextleague.php")
    fun getUpcomingMatch(@Query("id") id:String) : Flowable<FootballMatch>
    //teamdetail
    @GET("lookupteam.php")
    fun getTeam(@Query("id") id:String) : Flowable<FootballTeams>
    //teamview
    @GET("lookup_all_teams.php")
    fun getAllTeam(@Query("id") id:String) : Flowable<FootballTeams>
    //matchdetail
    @GET("lookupevent.php")
    fun getEventById(@Query("id") id:String) : Flowable<FootballMatch>
    //teamPlayer
    @GET("lookup_all_players.php")
    fun getAllPlayers(@Query("id") id:String?) : Flowable<FootballPlayer>

}