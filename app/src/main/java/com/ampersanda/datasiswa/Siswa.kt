package com.ampersanda.datasiswa

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Siswa(var nama: String, var gender: String,
            var alamat: String, var email: String) : Parcelable