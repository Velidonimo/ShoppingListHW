package com.example.a04shoppinglisthw.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.a04shoppinglisthw.domain.ShopItem
import com.example.a04shoppinglisthw.domain.ShopListRepository

object ShopListRepositoryImpl: ShopListRepository{

    private val shopList = mutableListOf<ShopItem>()
    private val shopListLD = MutableLiveData<List<ShopItem>>()

    private var autoIncrementId: Int = 0

    init {
        for (i in 0 until 10)
            addShopItem(ShopItem(i.toString(), i, true))
    }

    override fun addShopItem(shopItem: ShopItem) {
        if (shopItem.id == ShopItem.UNDEFINED_ID){
            shopItem.id = autoIncrementId++
        }
        shopList.add(shopItem)
        updateShopListLD()
    }

    override fun editShopItem(shopItem: ShopItem) {
        val oldShopItem = getShopItem(shopItem.id)
        removeShopItem(oldShopItem)
        addShopItem(shopItem)
    }

    override fun getShopItem(itemId: Int): ShopItem {
        return shopList.find {
            it.id == itemId
        } ?: throw RuntimeException("Item with id $itemId was not found")
    }

    override fun getShopList(): LiveData<List<ShopItem>> {
        return shopListLD
    }

    override fun removeShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
        updateShopListLD()
    }

    private fun updateShopListLD(){
        shopListLD.value = shopList
    }

}