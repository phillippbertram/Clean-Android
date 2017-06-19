package de.lmis.entities

import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


/**
 * @author [CWO] Christof Wolke | christof.wolke@LMIS.de
 */
@Entity(tableName = "messageEntities")
data class MessageEntity(@PrimaryKey var id: String = "", var status: MessageStatus = MessageEntity.MessageStatus.UNKNOWN, var text: String = "", var sender: String = "",
                         @Embedded var details: MessageEntityDetails? = null, var chatId: String = "") {


    enum class MessageStatus {
        SENDING, SENT, DELIVERED, FAILED, UNKNOWN
    }
}
