package cn.itpiggy.animation.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {
    @Query("SELECT * FROM grid_item")
    fun getItems(): Flow<List<Item>>

    @Query("SELECT * FROM grid_item WHERE id = :id")
    fun getItemById(id:Long): Flow<Item>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(data: List<Item>)
}