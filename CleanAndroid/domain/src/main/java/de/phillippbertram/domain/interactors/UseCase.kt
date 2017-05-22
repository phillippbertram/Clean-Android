package de.phillippbertram.domain.interactors

import de.phillippbertram.domain.utils.SchedulerProvider
import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import timber.log.Timber

/**
 * @author [PBE] Phillipp Bertram | phillipp.bertram@lmis.de
 */
abstract class UseCase<Input, Output>(protected val schedulerProvider: SchedulerProvider) {

    protected abstract fun buildObservable(params: Input): Observable<Output>

    operator fun get(params: Input): Observable<Output> {
        return buildObservable(params).compose(applySchedulers()).compose(logAll())
    }

    private fun applySchedulers(): ObservableTransformer<Output, Output> {
        return ObservableTransformer { observable ->
            observable.subscribeOn(schedulerProvider.backgroundThreadScheduler())
                    .observeOn(schedulerProvider.mainThreadScheduler())
        }
    }

    private fun logAll(): ObservableTransformer<Output, Output> {
        return ObservableTransformer { upstream ->
            upstream.doOnComplete(
                    { Timber.d("[%s] COMPLETE", javaClass.simpleName) })
                    .doOnNext({ value -> Timber.d("[%s] NEXT - %s", javaClass.simpleName, value) })
                    .doOnSubscribe(
                            { disposable -> Timber.d("[%s] ONSUBSCRIBE", javaClass.simpleName) })
                    .doOnDispose({ Timber.d("[%s] DISPOSED", javaClass.simpleName) })
                    .doOnError({ throwable ->
                        Timber.w("[%s] ERROR - %s", javaClass.simpleName,
                                throwable.javaClass)
                    })
        }
    }

}
