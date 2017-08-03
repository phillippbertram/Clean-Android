package de.phillippbertram.data.room.converters

import android.arch.persistence.room.TypeConverter
import de.lmis.entities.MessageEntity


/**
 * @author [CWO] Christof Wolke | christof.wolke@LMIS.de
 */
class MessageStatusConverter {

    @TypeConverter
    fun fromStatusToString(status: MessageEntity.MessageStatus): String {
        return status.name
    }

    @TypeConverter
    fun fromStringToStatus(status: String): MessageEntity.MessageStatus {
        return MessageEntity.MessageStatus.valueOf(status)
    }
}