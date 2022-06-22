package com.example.test.di

import android.app.Application
import androidx.room.Room
import com.example.test.data.local.AppDatabase
import com.example.test.data.remote.ApiApp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideApiApp(): ApiApp {
        return Retrofit.Builder()
            .baseUrl("https://dummyjson.com/todos/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiApp::class.java)



    }
    @Provides
    @Singleton
    fun provideAppDatabase(app: Application): AppDatabase {
        return Room.databaseBuilder(
            app,
            AppDatabase::class.java,
            "app_database.db"
        )
            .fallbackToDestructiveMigration()
            .build()
    }
}