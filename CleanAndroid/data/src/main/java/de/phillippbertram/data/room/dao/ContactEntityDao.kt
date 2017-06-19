package de.phillippbertram.data.room.dao

import android.arch.persistence.room.*
import de.lmis.entities.ContactEntity
import de.phillippbertram.domain.entities.Contact


/**
 * @author [CWO] Christof Wolke | christof.wolke@LMIS.de
 */
@Dao
interface ContactEntityDao {

    @Insert
    fun insertAll(tasks: List<ContactEntity>)

    @Insert
    fun insertSingle(task: ContactEntity)

    @Delete
    fun deleteSingle(task: ContactEntity)

    @Update
    fun updateSingle(task: ContactEntity)

    @Query("SELECT * FROM contactEntities")
    fun getAll(): List<ContactEntity>

    @Query("SELECT * FROM contactEntities WHERE username = :arg0")
    fun getContact(username: String): ContactEntity
}