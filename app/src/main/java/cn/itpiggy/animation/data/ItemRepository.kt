package cn.itpiggy.animation.data

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ItemRepository @Inject constructor(
    private val itemDao: ItemDao
) {
    fun getItems() = itemDao.getItems()
    fun getItemById(id:Long) = itemDao.getItemById(id)
}