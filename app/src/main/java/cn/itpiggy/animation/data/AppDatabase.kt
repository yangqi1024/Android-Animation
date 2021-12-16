package cn.itpiggy.animation.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.workDataOf
import cn.itpiggy.animation.workers.ItemDatabaseWorker


@Database(entities = [Item::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun itemDao(): ItemDao

    companion object {
        const val DATABASE_NAME = "animation_db"
        const val ITEM_DATA_FILENAME = "item.json"

        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also {
                    instance = it
                }
            }
        }

        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
                .addCallback(object : RoomDatabase.Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        val request = OneTimeWorkRequestBuilder<ItemDatabaseWorker>()
                            .setInputData(workDataOf(ItemDatabaseWorker.KEY_FILENAME to ITEM_DATA_FILENAME))
                            .build()
                        WorkManager.getInstance(context).enqueue(request)
                    }
                })
                .build()
        }

    }
}