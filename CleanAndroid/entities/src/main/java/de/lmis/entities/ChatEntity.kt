package de.lmis.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


/**
 * @author [CWO] Christof Wolke | christof.wolke@LMIS.de
 */
@Entity(tableName = "chatEntities")
data class ChatEntity(@PrimaryKey var id: String = "", var status: ChatEntity.Status = ChatEntity.Status.ACTIVE) {

    enum class Status {
        ACTIVE, ARCHIVED
    }
}