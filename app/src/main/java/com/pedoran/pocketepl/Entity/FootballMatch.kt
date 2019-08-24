package com.pedoran.pocketepl.Entity

import com.google.gson.annotations.SerializedName

class FootballMatch (@SerializedName("events") var events: List<Event>)