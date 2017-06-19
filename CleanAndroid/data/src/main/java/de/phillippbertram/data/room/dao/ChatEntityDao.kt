package de.phillippbertram.data.room.dao

import android.arch.persistence.room.*
import de.lmis.entities.ChatEntity
import de.phillippbertram.domain.entities.Chat


/**
 * @author [CWO] Christof Wolke | christof.wolke@LMIS.de
 */
@Dao
interface ChatEntityDao {

    @Insert
    fun insertAll(tasks: List<ChatEntity>)

    @Insert
    fun insertSingle(task: ChatEntity)

    @Delete
    fun deleteSingle(task: ChatEntity)

    @Update
    fun updateSingle(task: ChatEntity)

    @Query("SELECT * FROM chatEntities")
    fun getAll(): List<ChatEntity>

    @Query("SELECT * FROM chatEntities WHERE id = :arg0")
    fun getChat(contactId: String): ChatEntity
}