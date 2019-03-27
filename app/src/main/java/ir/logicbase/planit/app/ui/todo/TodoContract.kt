package ir.logicbase.planit.app.ui.todo

import ir.logicbase.planit.app.data.db.entity.Todo
import ir.logicfan.core.ui.common.PresenterContract
import ir.logicfan.core.ui.common.ViewContract

interface TodoContract {

    interface View : ViewContract {
        fun initializeAdapter()
        fun displayNewItemsInAdapter()
    }

    interface Action : PresenterContract {
        fun addTodos(todoList: List<Todo>)
    }

    interface AdapterAction {
        fun getTodo(position: Int): Todo
        fun getTodoItemCount(): Int
    }
}