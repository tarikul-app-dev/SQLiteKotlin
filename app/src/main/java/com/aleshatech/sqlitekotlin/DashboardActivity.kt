package com.aleshatech.sqlitekotlin

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aleshatech.sqlitekotlin.adapter.ImageAdapter
import com.aleshatech.sqlitekotlin.model.ImageM
import com.aleshatech.sqlitekotlin.retrofit.ApiService
import com.aleshatech.sqlitekotlin.retrofit.RetroClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
class DashboardActivity : AppCompatActivity() {
    var rcvImage :RecyclerView ?=null
    var btnGoSqlite:Button?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        initViews()
    }

    @SuppressLint("WrongConstant")
    fun initViews(){
        rcvImage = findViewById<RecyclerView>(R.id.rcv_image)
        btnGoSqlite = findViewById(R.id.btn_go_sqlite)

        btnGoSqlite!!.setOnClickListener(){
            startActivity(Intent(this@DashboardActivity, PersonActivity::class.java))
        }

        //adding a layoutmanager
        rcvImage!!.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        getImageList()
    }

    fun getImageList(){
        var apiInterface: ApiService = RetroClient().getApiClient()!!.create(ApiService::class.java)
        apiInterface.getImageList().enqueue(object : Callback<List<ImageM>> {
            override fun onResponse(call: Call<List<ImageM>>?, response: Response<List<ImageM>>?) {
              var  imageList:List<ImageM> = response?.body()!!
                rcvImage!!.adapter = ImageAdapter(imageList, this@DashboardActivity)
            }

            override fun onFailure(call: Call<List<ImageM>>?, t: Throwable?) {
                Log.d("res_fail", t?.message.toString())
            }
        })

    }
}