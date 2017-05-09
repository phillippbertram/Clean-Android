package de.phillippbertram.cleanandroid.internal.di.scopes;

import java.lang.annotation.Retention;
import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author [PBE] Phillipp Bertram | phillipp.bertram@lmis.de
 */
@Scope
@Retention(RUNTIME)
public @interface PerFragment {

}
