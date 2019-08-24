package com.pedoran.pocketepl.Entity

import com.google.gson.annotations.SerializedName

data class FootballPlayer(@SerializedName("player") var player: List<Player>)