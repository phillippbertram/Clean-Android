package de.phillippbertram.cleanandroid.internal.mvp

import com.jakewharton.rxrelay2.BehaviorRelay
import com.trello.rxlifecycle2.LifecycleTransformer
import com.trello.rxlifecycle2.RxLifecycle

import de.phillippbertram.cleanandroid.internal.mvp.PresenterLifecycle.STARTED
import de.phillippbertram.cleanandroid.internal.mvp.PresenterLifecycle.STOPPED

/**
 * @author [PBE] Phillipp Bertram | phillipp.bertram@lmis.de
 */
abstract class RxPresenter<in V : View> : Presenter<V>() {

    protected val presenterLifecycle = BehaviorRelay.createDefault(STOPPED)

    override fun bind(view: V) {
        super.bind(view)
        presenterLifecycle.accept(STARTED)
    }

    override fun unbind() {
        super.unbind()
        presenterLifecycle.accept(STOPPED)
    }

    protected fun <T> bindToLifecycle(): LifecycleTransformer<T> {
        return RxLifecycle.bind<T, PresenterLifecycle>(presenterLifecycle) { lifecycle ->
            when (lifecycle) {
                STARTED -> STOPPED
                else -> STARTED
            }
        }
    }


}
