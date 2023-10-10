package com.example.a04shoppinglisthw.domain

class GetShopItemUseCase(private val repository:ShopListRepository) {

    fun getShopItem(itemId: Int): ShopItem{
        return repository.getShopItem(itemId)
    }
}