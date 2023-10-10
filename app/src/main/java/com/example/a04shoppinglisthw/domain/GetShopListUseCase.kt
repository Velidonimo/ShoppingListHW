package com.example.a04shoppinglisthw.domain

class GetShopListUseCase(private val repository:ShopListRepository) {

    fun getShopList(): List<ShopItem>{
        return repository.getShopList()
    }
}