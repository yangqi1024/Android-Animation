package cn.itpiggy.animation.viewmodels

import android.util.Log
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import cn.itpiggy.animation.data.Item
import cn.itpiggy.animation.data.ItemRepository

class ItemDetailModel @ViewModelInject constructor(
    itemRepository: ItemRepository,
    @Assisted
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val itemId = savedStateHandle.get<Long>(ITEM_ID_SAVED_STATE_KEY)!!

    val item = itemRepository.getItemById(itemId).asLiveData()

    val url = MutableLiveData<String>()

    fun setImageUrl(imageUrl:String){
        url.value = imageUrl
    }

    init {
        Log.d("ItemDetailModel", "itemId:$itemId,${item.value?.name}")
    }

    companion object {
        const val ITEM_ID_SAVED_STATE_KEY = "itemId";
    }
}