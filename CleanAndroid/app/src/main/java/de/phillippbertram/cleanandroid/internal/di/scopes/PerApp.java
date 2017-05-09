package de.phillippbertram.cleanandroid.internal.di.scopes;

import java.lang.annotation.Retention;
import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * A scoping annotation to permit objects whose lifetime should
 * conform to the life of application to be memorized in the
 * correct component.
 *
 * @author [PBE] Phillipp Bertram | phillipp.bertram@lmis.de
 */
@Scope
@Retention(RUNTIME)
public @interface PerApp {

}
