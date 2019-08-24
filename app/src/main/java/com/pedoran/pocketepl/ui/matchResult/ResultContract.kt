package com.pedoran.pocketepl.ui.matchResult

import com.pedoran.pocketepl.Entity.Event

interface ResultContract {
    interface View{
        fun displayFootballMatch(eventList:List<Event>)
    }

    interface Presenter{
        fun getFootballMatchData(leagueId : String = "4328")
        fun onDestroyPresenter()
    }
}