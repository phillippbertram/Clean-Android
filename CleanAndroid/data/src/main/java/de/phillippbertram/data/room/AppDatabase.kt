package de.phillippbertram.data.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import android.content.Context
import de.lmis.entities.ChatEntity
import de.lmis.entities.ContactEntity
import de.lmis.entities.MessageEntity
import de.phillippbertram.data.room.converters.ChatStatusConverter
import de.phillippbertram.data.room.converters.DateConverter
import de.phillippbertram.data.room.converters.MessageStatusConverter
import de.phillippbertram.data.room.dao.ChatEntityDao
import de.phillippbertram.data.room.dao.ContactEntityDao
import de.phillippbertram.data.room.dao.MessageEntityDao


/**
 * @author [CWO] Christof Wolke | christof.wolke@LMIS.de
 */
// ToDo: Initialize the db with dagger
@Database(entities = arrayOf(ChatEntity::class, ContactEntity::class, MessageEntity::class), version = 1)
@TypeConverters(DateConverter::class, ChatStatusConverter::class, MessageStatusConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun chatEntityDao(): ChatEntityDao

    abstract fun contactEntityDao(): ContactEntityDao

    abstract fun messageEntityDao(): MessageEntityDao

    companion object {
        private var INSTANCE: AppDatabase? = null
        @JvmStatic fun createDatabase(context: Context): AppDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "Clean-Android_db").build()
            }
            return INSTANCE!!
        }

        @JvmStatic fun destroyInstance() {
            INSTANCE = null
        }
    }
}