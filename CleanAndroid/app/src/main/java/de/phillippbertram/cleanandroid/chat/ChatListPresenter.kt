package de.phillippbertram.cleanandroid.chat

import android.util.Log
import de.phillippbertram.cleanandroid.internal.mvp.RxPresenter
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

/**
 * @author [PBE] Phillipp Bertram | phillipp.bertram@lmis.de
 */
class ChatListPresenter : RxPresenter<ChatListView>() {

    fun startSomething() {
        Observable.interval(500, TimeUnit.MILLISECONDS)
                .compose(bindToLifecycle<Long>())
                .doOnNext { aLong -> Log.d("ChatListPresenter", "ON NEXT: " + aLong!!) }
                .subscribe()
    }

}
