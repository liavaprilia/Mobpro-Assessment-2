package org.d3if3165.assessment2.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import org.d3if3165.assessment2.model.Pelanggan

@Database(entities = [Pelanggan::class], version = 1, exportSchema = false)
abstract class PelangganDb : RoomDatabase() {
    abstract val dao: PelangganDao

    companion object {
        @Volatile
        private var INSTANCE: PelangganDb? = null

        fun getInstance(context: Context): PelangganDb {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        PelangganDb::class.java,
                        "pelanggan.db"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}