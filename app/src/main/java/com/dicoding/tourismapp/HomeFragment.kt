package com.dicoding.tourismapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.tourismapp.model.DataItem
import com.dicoding.tourismapp.model.ResponseTourism
import com.dicoding.tourismapp.network.ApiConfig
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    private lateinit var adapter: UserAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = UserAdapter(mutableListOf())

        rv_users.setHasFixedSize(true)
        rv_users.layoutManager = LinearLayoutManager(activity)
        rv_users.adapter = adapter

        getUser()
    }

    private fun getUser() {
        val client = ApiConfig.getApiService().getList()

        client.enqueue(object : Callback<ResponseTourism> {
            override fun onResponse(call: Call<ResponseTourism>, response: Response<ResponseTourism>) {
                val dataArray = response.body()?.data as List<DataItem>
                for (data in dataArray) {
                    adapter.addUser(data)
                }
            }

            override fun onFailure(call: Call<ResponseTourism>, t: Throwable) {
                Toast.makeText(activity, t.message, Toast.LENGTH_SHORT).show()
                t.printStackTrace()
            }
        })
    }

}
