package de.phillippbertram.domain.entities

import de.lmis.entities.ChatEntity

/**
 * @author [PBE] Phillipp Bertram | phillipp.bertram@lmis.de
 */

data class Chat(val id: String, val status: ChatEntity.Status)

