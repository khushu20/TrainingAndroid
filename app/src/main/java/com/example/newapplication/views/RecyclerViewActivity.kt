package com.example.newapplication.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.newapplication.R
import com.example.newapplication.databinding.ActivityRecyclerViewBinding

class RecyclerViewActivity : AppCompatActivity() {
   // private  lateinit var  binding:ActivityRecyclerViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
    }
}