package de.phillippbertram.cleanandroid.internal.mvp;

import com.jakewharton.rxrelay2.BehaviorRelay;
import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.RxLifecycle;

import static de.phillippbertram.cleanandroid.internal.mvp.PresenterLifecycle.STARTED;
import static de.phillippbertram.cleanandroid.internal.mvp.PresenterLifecycle.STOPPED;


/**
 * @author [PBE] Phillipp Bertram | phillipp.bertram@lmis.de
 */

public abstract class RxPresenter<V extends View> extends Presenter<V> {

    private final BehaviorRelay<PresenterLifecycle> presenterLifecycle
            = BehaviorRelay.createDefault(STOPPED);

    @Override
    public void bind(V view) {
        super.bind(view);
        presenterLifecycle.accept(STARTED);
    }

    @Override
    public void unbind() {
        super.unbind();
        presenterLifecycle.accept(STOPPED);
    }

    protected final <T> LifecycleTransformer<T> bindToLifecycle() {
        return RxLifecycle.bind(presenterLifecycle, lifecycle -> {
            switch (lifecycle) {
                case STARTED:
                    return STOPPED;
                case STOPPED:
                default:
                    return STARTED;
            }
        });
    }


}
