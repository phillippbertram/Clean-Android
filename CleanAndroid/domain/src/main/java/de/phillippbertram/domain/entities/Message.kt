package de.phillippbertram.domain.entities

import de.lmis.entities.MessageEntity
import java.util.*

/**
 * @author [PBE] Phillipp Bertram | phillipp.bertram@lmis.de
 */
data class Message(val id: String?, val status: MessageEntity.MessageStatus, val text: String, val sender: Contact,
                   private val details: Message.Details) {

    data class Details(internal val sentAt: Date, internal val receivedAt: Date)

}
