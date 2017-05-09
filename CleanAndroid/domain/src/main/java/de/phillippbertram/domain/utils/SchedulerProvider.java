package de.phillippbertram.domain.utils;

import io.reactivex.Scheduler;

/**
 * @author [PBE] Phillipp Bertram | phillipp.bertram@lmis.de
 */
public interface SchedulerProvider {

    Scheduler mainThreadScheduler();

    Scheduler backgroundThreadScheduler();
}
