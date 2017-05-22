package de.phillippbertram.domain.entities

import java.util.*

/**
 * @author [PBE] Phillipp Bertram | phillipp.bertram@lmis.de
 */
data class Message(val id: String?, val status: Message.Status, val text: String, val sender: Contact,
                   private val details: Message.Details) {

    enum class Status {
        SENDING, SENT, DELIVERED, FAILED
    }

    data class Details(internal val sentAt: Date, internal val receivedAt: Date)

}
