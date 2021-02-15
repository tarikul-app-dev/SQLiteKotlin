package com.aleshatech.sqlitekotlin

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aleshatech.sqlitekotlin.adapter.PersonAdapter
import com.aleshatech.sqlitekotlin.model.Name


class MainActivity : AppCompatActivity() {
     private lateinit var dbHelper: DbHelper
     var  btnAddToDb : Button?=null
     var  btnShowData : Button?=null
     var  edtName : EditText?=null
     var  edtMobile : EditText?=null
     var  edtEmail : EditText?=null


    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dbHelper = DbHelper(this,null)
        btnAddToDb = findViewById(R.id.btnAddToDb)
        btnShowData = findViewById(R.id.btn_show_data)
        edtName = findViewById(R.id.edt_name)
        edtMobile = findViewById(R.id.edt_mobile)
        edtEmail = findViewById(R.id.edt_email)
        val rcvShowName = findViewById<RecyclerView>(R.id.rcv_show_name)

        //adding a layoutmanager
        rcvShowName.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)


        btnAddToDb?.setOnClickListener {
            val user = Name(edtName?.text.toString(),edtMobile?.text.toString(),edtEmail?.text.toString())
            dbHelper.addName(user)
            Toast.makeText(this, edtName?.text.toString() + "Added to database", Toast.LENGTH_LONG).show()
        }

        btnShowData?.setOnClickListener {
           val personList = dbHelper.getAllName();
            if (personList.size > 0) {
                val mAdapter = PersonAdapter(  personList)
                rcvShowName.adapter = mAdapter
            }
        }
    }
}