package com.ampersanda.datasiswa

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Siswa(
    @PrimaryKey(autoGenerate = true)
    var siswaId: Int? = null,
    var nama: String, var gender: String,
    var alamat: String, var email: String
)