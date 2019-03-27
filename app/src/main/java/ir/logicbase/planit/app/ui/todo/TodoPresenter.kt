package ir.logicbase.planit.app.ui.todo

import ir.logicbase.planit.app.data.db.entity.Todo
import ir.logicfan.core.di.scope.PerFragment
import javax.inject.Inject

@PerFragment
class TodoPresenter @Inject
constructor(private val view: TodoContract.View) : TodoContract.Action, TodoContract.AdapterAction {

    private var todoList: List<Todo> = listOf()

    override fun onStart() {
        view.initializeAdapter()
    }

    override fun onStop() {

    }

    override fun addTodos(todoList: List<Todo>) {
        this.todoList = todoList
        view.displayNewItemsInAdapter()
    }

    override fun getTodo(position: Int): Todo = todoList[position]

    override fun getTodoItemCount(): Int = todoList.size
}