package ir.logicbase.planit.app.data.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import ir.logicbase.planit.app.data.db.dao.TodoDao
import ir.logicbase.planit.app.data.db.entity.Todo
import javax.inject.Inject

class TodoRepository @Inject constructor(private val todoDao: TodoDao) {

    val allTodos: LiveData<List<Todo>> = todoDao.getAllTodos()

    @WorkerThread
    suspend fun insert(todo: Todo) {
        todoDao.insert(todo)
    }
}