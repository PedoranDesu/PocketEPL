package com.pedoran.pocketepl.ui.matchDetail

import android.util.Log
import com.pedoran.pocketepl.Repository.TeamImpl
import com.pedoran.pocketepl.Rest.ApiService
import com.pedoran.pocketepl.Rest.FootballRest
import com.pedoran.pocketepl.utils.AppScheduler
import io.reactivex.disposables.CompositeDisposable

class DetailPresenter(
    val mView : DetailContract.View,
    val teamImpl: TeamImpl
) : DetailContract.Presenter {
    val compositeDisposable = CompositeDisposable()
    val schedulers = AppScheduler()
    override fun getTeamBadgeHome(id: String) {
        compositeDisposable.add(teamImpl.getTeams(id)
            .observeOn(schedulers.ui())
            .subscribeOn(schedulers.io())
            .subscribe(
                {
                    mView.displayTeamBadgeHome(it.teams[0])
                },{error -> Log.d("Error",error.localizedMessage)}
            )
        )
    }

    override fun getTeamBadgeAway(id: String) {
        compositeDisposable.add(teamImpl.getTeams(id)
            .observeOn(schedulers.ui())
            .subscribeOn(schedulers.io())
            .subscribe(
                {
                    mView.displayTeamBadgeAway(it.teams[0])
                },{error -> Log.d("Error",error.localizedMessage)}
            )
        )
    }

    override fun onDestroyPresenter() {
        compositeDisposable.dispose()
    }
}