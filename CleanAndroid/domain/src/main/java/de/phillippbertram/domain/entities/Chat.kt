package de.phillippbertram.domain.entities

/**
 * @author [PBE] Phillipp Bertram | phillipp.bertram@lmis.de
 */

data class Chat(val id: String, val status: Chat.Status) {

    enum class Status {
        ACTIVE, ARCHIVED
    }
}
