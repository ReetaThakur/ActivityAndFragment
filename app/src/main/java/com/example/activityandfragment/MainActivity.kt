package com.example.activityandfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var responceModel: ResponceModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnclick.setOnClickListener{
            callApi()
        }
    }

    private fun callApi() {
        val apiClient=Network.getRetrofitInstance().create(ApiClient::class.java)
        apiClient.getUser(edtId.text.toString().toInt())
            .enqueue(object :Callback<ResponceModel>{
                override fun onResponse(
                    call: Call<ResponceModel>,
                    response: Response<ResponceModel>
                ) {
                     responceModel= response.body()!!
                    val email=responceModel.data.email
                    val company=responceModel.data.last_name
                    txtemail.text = email
                    txtCompany.text = company


                }

                override fun onFailure(call: Call<ResponceModel>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })



    }
}