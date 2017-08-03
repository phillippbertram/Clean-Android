package de.phillippbertram.data.room.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import de.lmis.entities.MessageEntity


/**
 * @author [CWO] Christof Wolke | christof.wolke@LMIS.de
 */
@Dao
interface MessageEntityDao {

    @Insert
    fun insertAll(tasks: List<MessageEntity>)

    @Insert
    fun insertSingle(task: MessageEntity)

    @Delete
    fun deleteSingle(task: MessageEntity)

    @Update
    fun updateSingle(task: MessageEntity)

    @Query("SELECT * FROM messageEntities")
    fun getAll(): List<MessageEntity>

    @Query("SELECT * FROM messageEntities WHERE chatId = :arg0")
    fun getAllMessagesFromChat(chatId: String): LiveData<List<MessageEntity>>

    @Query("SELECT * FROM messageEntities WHERE id = :arg0")
    fun getMessage(id: String): MessageEntity
}