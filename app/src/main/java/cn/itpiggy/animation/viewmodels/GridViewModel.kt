package cn.itpiggy.animation.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import cn.itpiggy.animation.data.Item
import cn.itpiggy.animation.data.ItemRepository

class GridViewModel @ViewModelInject constructor(
    itemRepository: ItemRepository,
) : ViewModel() {
    val items: LiveData<List<Item>> = itemRepository.getItems().asLiveData()
}