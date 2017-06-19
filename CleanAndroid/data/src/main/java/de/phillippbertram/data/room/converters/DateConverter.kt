package de.phillippbertram.data.room.converters

import android.arch.persistence.room.TypeConverter
import java.util.*


/**
 * @author [CWO] Christof Wolke | christof.wolke@LMIS.de
 */
class DateConverter {

    @TypeConverter
    fun fromLongToDate(value: Long): Date {
        return Date(value)
    }

    @TypeConverter
    fun fromDateToLong(date: Date): Long {
        return date.time
    }
}