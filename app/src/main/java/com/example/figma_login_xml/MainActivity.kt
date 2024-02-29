package com.example.figma_login_xml

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.figma_login_xml.databinding.ActivityListBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    //val randomContact = fetchRandomUserData()

    var binding: ActivityListBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(LayoutInflater.from(this))
        setContentView(binding!!.root!!)
        val list = mutableListOf<String>()
        repeat(20) {
            list.add(
//                randomContact.toString()
                Contact("Name", "number", "url").toString()
            )
        }

        val adapter = RecyclerListAdapter(list)
        binding?.let {
            it.rvList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            it.rvList.adapter = adapter

            it.rvList.adapter!!.notifyDataSetChanged()
        }


//        lifecycleScope.launch {
//            delay(2000)
//            setContentView(R.layout.secondscreen)
//        }

    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

}

