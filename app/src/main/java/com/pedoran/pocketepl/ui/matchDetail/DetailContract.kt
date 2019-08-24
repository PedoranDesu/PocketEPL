package com.pedoran.pocketepl.ui.matchDetail

import com.pedoran.pocketepl.Entity.Team

interface DetailContract {
    interface View{
        fun displayTeamBadgeHome(team : Team)
        fun displayTeamBadgeAway(team : Team)
    }
    interface Presenter{
        fun getTeamBadgeHome(id:String)
        fun getTeamBadgeAway(id:String)
        fun onDestroyPresenter()
    }
}