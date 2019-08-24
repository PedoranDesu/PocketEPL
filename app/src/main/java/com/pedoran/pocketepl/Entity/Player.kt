package com.pedoran.pocketepl.Entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Player (
    @SerializedName("idPlayer")
    var idPlayer: String,
    @SerializedName("idTeam")
    var idTeam: String?,
    @SerializedName("strPlayer")
    var strPlayer: String?,
    @SerializedName("dateBorn")
    var dateBorn: String?,
    @SerializedName("strHeight")
    var strHeight: String?,
    @SerializedName("strPosition")
    var strPosition: String?
): Parcelable