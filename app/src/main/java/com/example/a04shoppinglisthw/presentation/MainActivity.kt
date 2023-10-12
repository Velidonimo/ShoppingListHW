package com.example.a04shoppinglisthw.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.a04shoppinglisthw.R

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var testEnabled = true
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        mainViewModel.shopList.observe(this){
            Log.d("MyMsg", it.toString())

            if (testEnabled){
                testEnabled = false
                val item = it[0]
                mainViewModel.changeEnableStateForShopItem(item)
                mainViewModel.removeShopItem(it[0])
            }

        }
    }
}