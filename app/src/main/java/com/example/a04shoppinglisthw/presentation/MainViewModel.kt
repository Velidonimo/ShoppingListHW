package com.example.a04shoppinglisthw.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.a04shoppinglisthw.data.ShopListRepositoryImpl
import com.example.a04shoppinglisthw.domain.EditShopItemUseCase
import com.example.a04shoppinglisthw.domain.GetShopListUseCase
import com.example.a04shoppinglisthw.domain.RemoveShopItemUseCase
import com.example.a04shoppinglisthw.domain.ShopItem

class MainViewModel: ViewModel() {

    val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)
    private val removeShopItemUseCase = RemoveShopItemUseCase(repository)

    val shopList = MutableLiveData<List<ShopItem>>()


    fun getShopList(){
        val list = repository.getShopList()
        shopList.value = list
    }

    fun removeShopItem(shopItem: ShopItem){
        repository.removeShopItem(shopItem)
        getShopList()
    }

    fun editShopItem(shopItem: ShopItem){
        repository.editShopItem(shopItem.copy(enabled = !shopItem.enabled))
        getShopList()
    }
}