package com.example.a04shoppinglisthw.domain

class RemoveShopItemUseCase (private val repository:ShopListRepository){

    fun removeShopItem(shopItem: ShopItem){
        repository.removeShopItem(shopItem)
    }
}