package ir.logicbase.planit.ui.todo

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ir.logicbase.planit.data.db.entity.Todo
import ir.logicbase.planit.data.repository.TodoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class TodoViewModel @Inject constructor(private val todoRepository: TodoRepository) : ViewModel() {

    val allTodos: LiveData<List<Todo>> = todoRepository.allTodos

    fun insert(todo: Todo) = viewModelScope.launch(Dispatchers.IO) {
        todoRepository.insert(todo)
    }
}