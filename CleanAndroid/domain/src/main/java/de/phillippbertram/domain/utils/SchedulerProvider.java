package de.phillippbertram.domain.utils;

import io.reactivex.Scheduler;

/**
 * @author [PBE] Phillipp Bertram | phillipp.bertram@lmis.de
 */
public interface SchedulerProvider {

    /**
     * With this method it is possible to use a Main-Thread-Scheduler.
     *
     * @return Is the Scheduler.
     */
    Scheduler mainThreadScheduler();

    /**
     * With this method it is possible to use a Background-Thread-Scheduler.
     *
     * @return Is the Scheduler.
     */
    Scheduler backgroundThreadScheduler();
}
