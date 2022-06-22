package com.example.test.data.repository

import com.example.test.data.local.AppDatabase
import com.example.test.data.mapper.toToDoEntity
import com.example.test.data.mapper.toToDoModel
import com.example.test.data.remote.ApiApp
import com.example.test.data.remote.dto.ToDoPostDto
import com.example.test.domain.models.ToDoModel
import com.example.test.domain.repository.ToDoRepository
import com.example.test.util.Resource
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ToDoRepositoryImpl @Inject constructor(
    db: AppDatabase,
    private val api: ApiApp
) : ToDoRepository {
    private val dao = db.toDoDao
    override fun getData(): Flow<Resource<List<ToDoModel>>> = flow {

        emit(Resource.Loading(true))

        delay(10)

        val cache = dao.read()

        val isCacheEmpty = cache.isEmpty()

        if (!isCacheEmpty)
            emit(Resource.Success(cache.map { it.toToDoModel() }))

        val remoteData = try {
             api.getData()
        } catch (e: IOException) {
            e.printStackTrace()
            emit(Resource.Error(e.message.toString()))
            null
        } catch (e: HttpException) {
            e.printStackTrace()
            emit(Resource.Error(e.message.toString()))
            null
        }

        remoteData?.let { userDtoList ->
            userDtoList.todos.forEach { userDto ->
                dao.upsert(userDto.toToDoEntity())
            }

            emit(Resource.Success(dao.read().map { it.toToDoModel() }))
        }

        emit(Resource.Loading(false))
    }

    override fun createData(): Flow<Resource<List<ToDoPostDto>>> {
        TODO("Not yet implemented")
    }
}
