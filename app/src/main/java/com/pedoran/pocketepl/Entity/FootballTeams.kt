package com.pedoran.pocketepl.Entity

import com.google.gson.annotations.SerializedName

data class FootballTeams(
    @SerializedName("teams")
    var teams: List<Team>)