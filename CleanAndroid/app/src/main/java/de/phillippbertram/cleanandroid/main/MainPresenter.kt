package de.phillippbertram.cleanandroid.main

import de.phillippbertram.cleanandroid.internal.mvp.RxPresenter
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable


/**
 * @author [PBE] Phillipp Bertram | phillipp.bertram@lmis.de
 */
class MainPresenter internal constructor() : RxPresenter<MainView>()
