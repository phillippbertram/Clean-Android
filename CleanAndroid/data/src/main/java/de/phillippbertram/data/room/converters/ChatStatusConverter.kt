package de.phillippbertram.data.room.converters

import android.arch.persistence.room.TypeConverter
import de.lmis.entities.ChatEntity


/**
 * @author [CWO] Christof Wolke | christof.wolke@LMIS.de
 */
class ChatStatusConverter {

    @TypeConverter
    fun fromStatusToString(status: ChatEntity.Status): String {
        return status.name
    }

    @TypeConverter
    fun fromStringToStatus(status: String): ChatEntity.Status {
        return ChatEntity.Status.valueOf(status)
    }
}