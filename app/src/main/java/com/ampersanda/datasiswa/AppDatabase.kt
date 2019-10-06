package com.ampersanda.datasiswa

import android.content.Context
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// TODO : buat tabel, dan definisi versi database
@Database(entities = [Siswa::class], version = 3)
abstract class AppDatabase : RoomDatabase() {

    // TODO : buat query | DAO
    abstract fun SiswaDAO(): SiswaDAO

    // TODO : init database, kalau database ada, tinggal pake, kalo gak ada, buat baru
    companion object {
        var INSTANCE: AppDatabase? = null

        fun getAppDatabase(context: Context): AppDatabase? {
            if (INSTANCE == null) {
                // TODO : buat database baru

                synchronized(AppDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java, "AppDatabase"
                    ).build()
                }
            }
//            else {
//                return INSTANCE
//            }

            // TODO : ambil database yang sudah ada
            return INSTANCE
        }

        // TODO : destroy database
        fun hapusDatabase() {
            INSTANCE = null
        }
    }
}