package de.phillippbertram.cleanandroid.internal.mvp;

import android.support.annotation.Nullable;
import java.lang.ref.WeakReference;

/**
 * @author [PBE] Phillipp Bertram | phillipp.bertram@lmis.de
 */

public abstract class Presenter<V extends View> {


    /**
     * Die View für den verwendeten Presenter.
     */
    @Nullable
    private WeakReference<V> viewRef;


    public void bind(V view) {
        viewRef = new WeakReference<>(view);
    }

    public void unbind() {
        if (viewRef != null) {
            viewRef.clear();
            viewRef = null;
        }
    }


}
