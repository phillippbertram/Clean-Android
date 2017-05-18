package de.phillippbertram.cleanandroid.internal.mvp

import java.lang.ref.WeakReference

/**
 * @author [PBE] Phillipp Bertram | phillipp.bertram@lmis.de
 */

abstract class Presenter<in V : View> {

    /**
     * Die View für den verwendeten Presenter.
     */
    private var viewRef: WeakReference<V>? = null

    open fun bind(view: V) {
        viewRef = WeakReference(view)
    }

    open fun unbind() {
        if (viewRef != null) {
            viewRef!!.clear()
            viewRef = null
        }
    }


}
