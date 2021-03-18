package com.demo.fileshareapp

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.demo.fileshareapp.adapters.DataAdapter
import com.demo.fileshareapp.model.DataModel
import com.demo.fileshareapp.retrofit.ApiClient
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    var dataList=ArrayList<DataModel>()
    lateinit var progerssProgressDialog:ProgressDialog
    lateinit var adapter: DataAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        recycler_view.adapter=DataAdapter(dataList)
        recycler_view.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        progerssProgressDialog=ProgressDialog(this)
        progerssProgressDialog.setTitle("Loading")
        progerssProgressDialog.setCancelable(false)
        progerssProgressDialog.show()
        getData()


    }

    private fun getData() {

        val call: Call<List<DataModel>> = ApiClient.getClient.getPhotos()
        call.enqueue(object : Callback<List<DataModel>>{
            override fun onResponse(
                call: Call<List<DataModel>>,
                response: Response<List<DataModel>>
            ) {
                progerssProgressDialog.dismiss()
                dataList.addAll(response!!.body()!!)
                recycler_view.adapter?.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<List<DataModel>>, t: Throwable) {
                progerssProgressDialog.dismiss()
            }

        })
    }
}