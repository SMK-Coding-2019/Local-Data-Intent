package com.ampersanda.datasiswa

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface SiswaDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun tambahSiswa(siswa: Siswa) : Long

    @Query("SELECT * FROM Siswa")
    fun ambilSemuaDataSiswa() : LiveData<List<Siswa>>
}