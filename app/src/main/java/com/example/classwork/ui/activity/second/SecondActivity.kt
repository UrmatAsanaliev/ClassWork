package com.example.classwork.ui.activity.second

import android.os.Bundle
import com.example.classwork.core.activity.base.BaseActivity
import com.example.classwork.databinding.ActivitySecondBinding
import com.example.classwork.ui.activity.second.adapter.ResultAdapter

class SecondActivity : BaseActivity<ActivitySecondBinding>(ActivitySecondBinding::inflate) {

    private lateinit var adapter: ResultAdapter
    private var animalList :ArrayList<Int> = arrayListOf()

    override fun setupUI() {
        initAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initAdapter()
    }


    private fun initAdapter() {
        adapter = ResultAdapter()
        binding.rvResult.adapter = adapter
        initList()
    }


    private fun initList() {
        animalList =
            (intent.getIntegerArrayListExtra("selected") as ArrayList<Int>)
        adapter.addResult(animalList)
    }


}