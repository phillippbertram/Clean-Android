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

    public UseCase(SchedulerProvider schedulerProvider) {
        this.schedulerProvider = schedulerProvider;
    }

    protected abstract Observable<T> buildObservable(Params params);

    public final Observable<T> get(Params params) {
        return buildObservable(params).compose(applySchedulers()).compose(logAll());
    }

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
