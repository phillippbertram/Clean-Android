package de.phillippbertram.cleanandroid.main;

import de.phillippbertram.cleanandroid.internal.mvp.RxPresenter;
import io.reactivex.Observable;
import java.util.concurrent.TimeUnit;

/**
 * @author [PBE] Phillipp Bertram | phillipp.bertram@lmis.de
 */

final class MainPresenter extends RxPresenter<MainView> {

    MainPresenter() {
        Observable.interval(1, TimeUnit.SECONDS).compose(bindToLifecycle()).subscribe();
    }
}
