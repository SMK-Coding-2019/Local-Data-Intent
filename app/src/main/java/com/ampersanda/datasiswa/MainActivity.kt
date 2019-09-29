package com.ampersanda.datasiswa

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    lateinit var nama : EditText
    lateinit var spinnerGender : Spinner
    lateinit var email : EditText
    lateinit var alamat : EditText
    lateinit var submitButton : Button

    var spinnerIndex : Int = 0

    val genders = listOf("Laki-laki", "Perempuan")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nama = findViewById(R.id.et_name)
        spinnerGender = findViewById(R.id.sp_gender)
        email = findViewById(R.id.et_email)
        alamat = findViewById(R.id.et_address)
        submitButton = findViewById(R.id.bt_submit)

        spinnerGender.adapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_1, genders)

        spinnerGender.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                spinnerIndex = 0
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                spinnerIndex = position
            }

        }

        submitButton.setOnClickListener {
            val intent : Intent = Intent()

            val siswaYangAkanDikirim : Siswa =
                Siswa(nama.text.toString(),
                    genders[spinnerIndex], alamat.text.toString(),
                    email.text.toString())

            intent.putExtra("siswa", siswaYangAkanDikirim)

            setResult( 13, intent)
            finish()
        }
    }
}
