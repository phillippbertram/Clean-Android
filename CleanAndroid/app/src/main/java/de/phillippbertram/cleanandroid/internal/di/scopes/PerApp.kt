package de.phillippbertram.cleanandroid.internal.di.scopes


import javax.inject.Scope


/**
 * A scoping annotation to permit objects whose lifetime should
 * conform to the life of application to be memorized in the
 * correct component.

 * @author [PBE] Phillipp Bertram | phillipp.bertram@lmis.de
 */
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class PerApp
