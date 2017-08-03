package de.lmis.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


/**
 * @author [CWO] Christof Wolke | christof.wolke@LMIS.de
 */
@Entity(tableName = "contactEntities")
data class ContactEntity(@PrimaryKey var username: String = "", var firstName: String? = null, var lastName: String? = null)
