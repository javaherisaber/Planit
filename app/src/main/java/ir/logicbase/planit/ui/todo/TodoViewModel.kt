package ir.logicbase.planit.ui.todo

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import ir.logicbase.planit.data.db.AppDatabase
import ir.logicbase.planit.data.db.entity.Todo
import ir.logicbase.planit.data.repository.TodoRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class TodoViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: TodoRepository
    val allTodos: LiveData<List<Todo>>
    private var parentJob = Job()
    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Main
    private val scope = CoroutineScope(coroutineContext)

    init {
        val todoDao = AppDatabase.getDatabase(application, scope).todoDao()
        repository = TodoRepository(todoDao)
        allTodos = repository.allTodos
    }

    fun insert(todo: Todo) = scope.launch(Dispatchers.IO) {
        repository.insert(todo)
    }

    override fun onCleared() {
        super.onCleared()
        parentJob.cancel()
    }
}