package com.pedoran.pocketepl.Entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class Event(
    @SerializedName("idEvent") var idEvent : String,
    @SerializedName("dateEvent") var dateEvent: Date?,
    @SerializedName("idLeague") var idLeague: String?,
    @SerializedName("strEvent") var strEvent: String?,
    @SerializedName("strSeason") var strSeason: String?,
    @SerializedName("strDate") var strDate: String?,
    @SerializedName("strTime") var strTime: String,
    @SerializedName("idHomeTeam") var idHomeTeam: String,
    @SerializedName("idAwayTeam") var idAwayTeam: String,
    @SerializedName("strHomeTeam") var strHomeTeam: String?,
    @SerializedName("strAwayTeam") var strAwayTeam: String?,
    @SerializedName("intHomeScore") var intHomeScore: String?,
    @SerializedName("intAwayScore") var intAwayScore: String?,
    @SerializedName("intRound") var intRound: String?,
    @SerializedName("strHomeGoalDetails") var strHomeGoalDetails: String?,
    @SerializedName("strHomeLineupDefense") var strHomeLineupDefense: String?,
    @SerializedName("strHomeLineupForward") var strHomeLineupForward: String?,
    @SerializedName("strHomeLineupGoalkeeper") var strHomeLineupGoalkeeper: String?,
    @SerializedName("strHomeLineupMidfield") var strHomeLineupMidfield: String?,
    @SerializedName("strHomeLineupSubstitutes") var strHomeLineupSubstitutes: String?,
    @SerializedName("strAwayGoalDetails") var strAwayGoalDetails: String?,
    @SerializedName("strAwayLineupDefense") var strAwayLineupDefense: String?,
    @SerializedName("strAwayLineupForward") var strAwayLineupForward: String?,
    @SerializedName("strAwayLineupGoalkeeper") var strAwayLineupGoalkeeper: String?,
    @SerializedName("strAwayLineupMidfield") var strAwayLineupMidfield: String?,
    @SerializedName("strAwayLineupSubstitutes") var strAwayLineupSubstitutes: String?
): Parcelable