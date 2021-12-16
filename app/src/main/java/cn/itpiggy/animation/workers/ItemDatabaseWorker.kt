package cn.itpiggy.animation.workers

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import cn.itpiggy.animation.data.AppDatabase
import cn.itpiggy.animation.data.Item
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

class ItemDatabaseWorker(
    context: Context,
    workerParameters: WorkerParameters
) : CoroutineWorker(context, workerParameters) {
    override suspend fun doWork(): Result = withContext(Dispatchers.IO) {
        try {
            val fileName = inputData.getString(KEY_FILENAME)
            Log.e(TAG, "Error seeding database fileName：$fileName")
            if (fileName != null) {
                applicationContext.assets.open(fileName).use { inputStream ->
                    JsonReader(inputStream.reader()).use { jsonReader ->
                        val itemType = object : TypeToken<List<Item>>() {}.type
                        val itemList: List<Item> = Gson().fromJson(jsonReader, itemType)
                        val database = AppDatabase.getInstance(applicationContext)
                        database.itemDao().insertAll(itemList)
                        Result.success()
                    }
                }
            } else {
                Log.e(TAG, "Error seeding database - no valid filename")
                Result.failure()
            }
        } catch (ex: Exception) {
            Log.e(TAG, "Error seeding database", ex)
            Result.failure()
        }
    }

    companion object {
        private const val TAG = "ItemDatabaseWorker"
        const val KEY_FILENAME = "ITEM_DATA_FILENAME"
    }
}