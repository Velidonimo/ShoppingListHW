package com.example.a04shoppinglisthw.domain

import androidx.lifecycle.LiveData

interface ShopListRepository {

    fun addShopItem(shopItem: ShopItem)

    fun editShopItem(shopItem: ShopItem)

    fun getShopItem(itemId: Int): ShopItem

    fun getShopList(): LiveData<List<ShopItem>>

    fun removeShopItem(shopItem: ShopItem)
}