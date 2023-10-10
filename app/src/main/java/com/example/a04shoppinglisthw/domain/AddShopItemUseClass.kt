package com.example.a04shoppinglisthw.domain

class AddShopItemUseClass(private val repository:ShopListRepository) {

    fun addShopItem(shopItem: ShopItem){
        repository.addShopItem(shopItem)
    }
}