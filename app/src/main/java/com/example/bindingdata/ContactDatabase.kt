package com.example.bindingdata

import android.content.Context
import androidx.room.*

@Database(entities = [Contact::class], version = 1)
@TypeConverters(Convertor::class)
abstract class ContactDatabase : RoomDatabase() {

    abstract fun contactDAO(): ContactDAO

    companion object {
        @Volatile
        private var INSTANCE: ContactDatabase? = null

        fun getDatabaseObject(context: Context): ContactDatabase {
            synchronized(this) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                        context,
                        ContactDatabase::class.java,
                        "contactDB"
                    ).build()
                }
            }

            return INSTANCE!!
        }
    }
}