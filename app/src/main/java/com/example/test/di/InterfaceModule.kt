package com.example.test.di

import com.example.test.data.repository.ToDoRepositoryImpl
import com.example.test.domain.repository.ToDoRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class InterfaceModule {
    @Singleton
    @Binds
    abstract fun provideToDoRepository(
        toDoRepository: ToDoRepositoryImpl
    ): ToDoRepository
}