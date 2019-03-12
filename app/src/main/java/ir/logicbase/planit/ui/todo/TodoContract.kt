package ir.logicbase.planit.ui.todo

import ir.logicbase.planit.ui.model.Todo
import ir.logicfan.core.ui.common.PresenterContract
import ir.logicfan.core.ui.common.ViewContract

interface TodoContract {

    interface View : ViewContract {
        fun initializeAdapter()
    }

    interface Action : PresenterContract

    interface AdapterAction {
        fun getTodo(position: Int): Todo
        fun getTodoItemCount(): Int
    }
}