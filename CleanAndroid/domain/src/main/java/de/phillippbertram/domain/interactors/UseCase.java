package de.phillippbertram.domain.interactors;

import de.phillippbertram.domain.utils.SchedulerProvider;
import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;
import timber.log.Timber;

/**
 * @author [PBE] Phillipp Bertram | phillipp.bertram@lmis.de
 */
public abstract class UseCase<T, Params> {

    protected final SchedulerProvider schedulerProvider;

    /**
     * Konstruktor.
     *
     * @param schedulerProvider Der SchedulerProvider.
     */
    public UseCase(SchedulerProvider schedulerProvider) {
        this.schedulerProvider = schedulerProvider;
    }

    /**
     * Baut das Observable für den UseCase..
     *
     * @return Observable
     */
    protected abstract Observable<T> buildObservable(Params params);


    /**
     * Liefert das auszuführende Observable.
     *
     * @param params Die Parameter
     * @return Observable.
     */
    public final Observable<T> get(Params params) {
        return buildObservable(params).compose(applySchedulers()).compose(logAll());
    }

    /**
     * Sorgt dafür, dass das Observable auf den entsprechenden Threads operiert.
     *
     * @return Observable.
     */
    private ObservableTransformer<T, T> applySchedulers() {
        return observable -> observable.subscribeOn(schedulerProvider.backgroundThreadScheduler())
                .observeOn(schedulerProvider.mainThreadScheduler());
    }

    private ObservableTransformer<T, T> logAll() {
        return upstream -> upstream.doOnComplete(
                () -> Timber.d("[%s] COMPLETE", getClass().getSimpleName()))
                .doOnNext(value -> Timber.d("[%s] NEXT - %s", getClass().getSimpleName(), value))
                .doOnSubscribe(
                        disposable -> Timber.d("[%s] ONSUBSCRIBE", getClass().getSimpleName()))
                .doOnDispose(() -> Timber.d("[%s] DISPOSED", getClass().getSimpleName()))
                .doOnError(throwable -> Timber.w("[%s] ERROR - %s", getClass().getSimpleName(),
                        throwable.getClass()));
    }

}
