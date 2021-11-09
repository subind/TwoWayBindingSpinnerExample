package com.example.spinnertwowaybinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.spinnertwowaybinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        populateSpinnerWithData()
    }

    private fun populateSpinnerWithData() {
        val rimSpinnerList = ArrayList<String>()
        rimSpinnerList.add("${"123"} ${"ABC"}")
        rimSpinnerList.add("${"456"} ${"DEF"}")
        rimSpinnerList.add("${"789"} ${"GHI"}")

        binding.myList = rimSpinnerList
    }
}