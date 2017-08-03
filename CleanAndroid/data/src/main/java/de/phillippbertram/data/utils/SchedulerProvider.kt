package de.phillippbertram.data.utils

import io.reactivex.Scheduler

/**
 * @author [PBE] Phillipp Bertram | phillipp.bertram@lmis.de
 */
interface SchedulerProvider {

    fun mainThreadScheduler(): Scheduler

    fun backgroundThreadScheduler(): Scheduler
}
