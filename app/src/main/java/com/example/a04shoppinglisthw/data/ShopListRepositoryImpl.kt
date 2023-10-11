package com.example.a04shoppinglisthw.data

import com.example.a04shoppinglisthw.domain.ShopItem
import com.example.a04shoppinglisthw.domain.ShopListRepository

object ShopListRepositoryImpl: ShopListRepository{

    private val shopList = mutableListOf<ShopItem>()

    private var autoIncrementId: Int = 0

    init {
        for (i in 0 until 10)
            shopList.add(ShopItem(i.toString(), i, true))
    }

    override fun addShopItem(shopItem: ShopItem) {
        if (shopItem.id == ShopItem.UNDEFINED_ID){
            shopItem.id = autoIncrementId++
        }
        shopList.add(shopItem)
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

    override fun getShopList(): List<ShopItem> {
        return shopList.toList()
    }

    override fun removeShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
    }
}