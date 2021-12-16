package cn.itpiggy.animation.di

import android.content.Context
import cn.itpiggy.animation.data.AppDatabase
import cn.itpiggy.animation.data.ItemDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton


@InstallIn(ApplicationComponent::class)
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase =
        AppDatabase.getInstance(context)

    @Provides
    fun provideItemDao(appDatabase: AppDatabase): ItemDao = appDatabase.itemDao()
}