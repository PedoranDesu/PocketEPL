package com.pedoran.pocketepl.ui.matchResult

import com.pedoran.pocketepl.Entity.FootballMatch
import com.pedoran.pocketepl.Repository.MatchImpl
import com.pedoran.pocketepl.utils.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subscribers.ResourceSubscriber
import java.util.*

class UpcomingMatchPresenter(val upcomingView : UpcomingContract.View,
                              val matchImpl : MatchImpl,
                              val schedulers: SchedulerProvider
                           ) : UpcomingContract.Presenter{
    val compositeDisposable = CompositeDisposable()

    override fun getFootballMatchData(leagueId: String) {
        compositeDisposable.add(matchImpl.getUpcomingMatch(leagueId)
            .observeOn(schedulers.ui())
            .subscribeOn(schedulers.io())
            .subscribeWith(object : ResourceSubscriber<FootballMatch>(){
                override fun onComplete() {

                }

                override fun onNext(t: FootballMatch) {
                    upcomingView.displayFootballMatch(t.events)
                }

                override fun onError(t: Throwable?) {
                    upcomingView.displayFootballMatch(Collections.emptyList())
                }

            })
        )
    }

    override fun onDestroyPresenter() {
        compositeDisposable.dispose()
    }
}