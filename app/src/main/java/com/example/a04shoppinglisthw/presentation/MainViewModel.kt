package com.example.a04shoppinglisthw.presentation

import androidx.lifecycle.ViewModel
import com.example.a04shoppinglisthw.data.ShopListRepositoryImpl
import com.example.a04shoppinglisthw.domain.EditShopItemUseCase
import com.example.a04shoppinglisthw.domain.GetShopListUseCase
import com.example.a04shoppinglisthw.domain.RemoveShopItemUseCase
import com.example.a04shoppinglisthw.domain.ShopItem

class MainViewModel: ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)
    private val removeShopItemUseCase = RemoveShopItemUseCase(repository)

    val shopList = repository.getShopList()

    fun removeShopItem(shopItem: ShopItem){
        repository.removeShopItem(shopItem)
    }

    fun changeEnableStateForShopItem(shopItem: ShopItem){
        repository.editShopItem(shopItem.copy(enabled = !shopItem.enabled))
    }
}