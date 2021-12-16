package cn.itpiggy.animation.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "grid_item",

    )
data class Item(
    @ColumnInfo
    val name: String,
    @ColumnInfo
    val author: String,
    @ColumnInfo(name = "photo_url")
    val photoUrl: String,
    @ColumnInfo(name = "thumbnail_url")
    val thumbnailUrl: String,
) {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="id")
    var itemId:Long = 0

    override fun toString(): String {
        return "Item(name='$name', author='$author', photoUrl='$photoUrl', thumbnailUrl='$thumbnailUrl', itemId=$itemId)"
    }


}