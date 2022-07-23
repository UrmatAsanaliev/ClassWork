package com.example.classwork.ui.activity.main

import android.content.Intent
import com.example.classwork.R
import com.example.classwork.core.activity.base.BaseActivity
import com.example.classwork.databinding.ActivityMainBinding
import com.example.classwork.ext.showToast
import com.example.classwork.ui.activity.main.adapter.AnimalAdapter
import com.example.classwork.ui.activity.second.SecondActivity

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate), AnimalAdapter.OnClick {
    private lateinit var adapter: AnimalAdapter
    private var animalList : ArrayList<Int> = arrayListOf()
    private var selectedAnimal:ArrayList<Int> = arrayListOf()

    override fun setupUI() {
        initAdapter()
    }

    override fun setupObserve() {
        super.setupObserve()
        initListeners()
    }

    private fun initListeners() {
        binding.btnSave.setOnClickListener {
            if (selectedAnimal.isEmpty()) {
                showToast("Вы не выбрали картинку!")
            } else {
                resetSelected()
                openActivity()
                selectedAnimal.clear()
            }
        }
    }

    private fun initAdapter() {
        adapter = AnimalAdapter(this)
        binding.rvAnimal.adapter = adapter
        adapter.addAnimal(animalList)
        initAnimals()
    }

    private fun initAnimals() {
        animalList.add(R.drawable.img)
        animalList.add(R.drawable.img_2)
        animalList.add(R.drawable.img)
        animalList.add(R.drawable.img_2)
        animalList.add(R.drawable.img)
        animalList.add(R.drawable.img_2)
        animalList.add(R.drawable.img)
        animalList.add(R.drawable.img_1)
        animalList.add(R.drawable.img_2)
        animalList.add(R.drawable.img_1)
        animalList.add(R.drawable.img)
        animalList.add(R.drawable.img)
        animalList.add(R.drawable.img_2)
        animalList.add(R.drawable.img)
        animalList.add(R.drawable.img_2)
        animalList.add(R.drawable.img)
        animalList.add(R.drawable.img_1)
        animalList.add(R.drawable.img)
    }

    private fun openActivity() {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putIntegerArrayListExtra("selected" , selectedAnimal)
        startActivity(intent)
    }

    private fun resetSelected() {
        for (i in 0..animalList.lastIndex) {
            adapter.notifyItemChanged(i)
        }
    }

    override fun click(pos: Int) {
        selectedAnimal.add(pos)
    }

}