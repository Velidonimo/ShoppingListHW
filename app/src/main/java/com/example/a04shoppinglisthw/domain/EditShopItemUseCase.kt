package com.example.a04shoppinglisthw.domain

class EditShopItemUseCase (private val repository:ShopListRepository){

    fun editShopItem(shopItem: ShopItem){
        repository.editShopItem(shopItem)
    }
}