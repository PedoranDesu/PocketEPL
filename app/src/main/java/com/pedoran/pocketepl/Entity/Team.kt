package com.pedoran.pocketepl.Entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Team (
    @SerializedName("idTeam")
    var idTeam: String,
    @SerializedName("idLeague")
    var idLeague: String?,
    @SerializedName("strTeam")
    var strTeam: String?,
    @SerializedName("strStadium")
    var strStadium: String?,
    @SerializedName("strTeamBadge")
    var strTeamBadge: String,
    @SerializedName("strWebsite")
    var strWebsite: String?
): Parcelable