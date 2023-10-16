package com.example.a04shoppinglisthw.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.a04shoppinglisthw.R
import com.example.a04shoppinglisthw.domain.ShopItem

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel
    private lateinit var llShopList: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        llShopList = findViewById(R.id.ll_shop_list)

        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        mainViewModel.shopList.observe(this){
            showShopList(it)
        }
    }

    private fun showShopList(list : List<ShopItem>){
        llShopList.removeAllViews()

        for (item in list){
            val layoutId = if(item.enabled)
                R.layout.item_shop_enabled
            else
                R.layout.item_shop_disabled

            val view = LayoutInflater.from(this).inflate(layoutId, llShopList, false)
            view.findViewById<TextView>(R.id.tv_item_name).text = item.name
            view.findViewById<TextView>(R.id.tv_item_count).text = item.count.toString()

            view.setOnLongClickListener {
                mainViewModel.changeEnableStateForShopItem(item)
                true
            }

            llShopList.addView(view)
        }
    }
}