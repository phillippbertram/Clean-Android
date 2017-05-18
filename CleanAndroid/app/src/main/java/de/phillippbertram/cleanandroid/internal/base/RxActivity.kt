package de.phillippbertram.cleanandroid.internal.base

import android.os.Bundle
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity
import de.phillippbertram.cleanandroid.internal.mvp.Presenter
import de.phillippbertram.cleanandroid.internal.mvp.View

/**
 * @author [PBE] Phillipp Bertram | phillipp.bertram@lmis.de
 */
abstract class RxActivity<V : View, P : Presenter<V>> : RxAppCompatActivity(), View {

    protected lateinit var presenter: P

    protected abstract fun createPresenter(): P

    @Suppress("UNCHECKED_CAST")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = createPresenter()
        presenter.bind(this as V)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.unbind()
    }
}
