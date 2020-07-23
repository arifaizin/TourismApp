package com.dicoding.core.di

import android.content.Context
import androidx.room.Room
import com.dicoding.core.data.source.local.room.TourismDao
import com.dicoding.core.data.source.local.room.TourismDatabase
import dagger.Module
import dagger.Provides
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(context: Context): TourismDatabase {
        val passphrase: ByteArray = SQLiteDatabase.getBytes("dicoding".toCharArray())
        val factory = SupportFactory(passphrase)
        return Room.databaseBuilder(
            context,
            TourismDatabase::class.java, "Tourism.db"
        ).fallbackToDestructiveMigration()
            .openHelperFactory(factory)
            .build()
    }

    @Provides
    fun provideTourismDao(database: TourismDatabase): TourismDao = database.tourismDao()

}