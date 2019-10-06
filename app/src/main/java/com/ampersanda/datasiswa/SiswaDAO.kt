package com.ampersanda.datasiswa

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface SiswaDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun tambahSiswa(siswa: Siswa) : Long

    @Query("SELECT * FROM Siswa")
    fun ambilSemuaDataSiswa() : LiveData<List<Siswa>>

    @Delete
    fun hapusSiswa(siswa: Siswa)
}