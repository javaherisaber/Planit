package ir.logicbase.planit.app.ui.todo

import ir.logicbase.planit.app.R
import ir.logicbase.planit.app.data.db.entity.Todo
import ir.logicbase.planit.app.ui.base.BaseAdapter
import javax.inject.Inject

class TodoAdapter @Inject
constructor(private val presenter: TodoContract.AdapterAction) : BaseAdapter<Todo>() {

    override fun getItemCount(): Int = presenter.getTodoItemCount()

    override fun getItem(position: Int): Todo = presenter.getTodo(position)

    override fun getItemViewType(position: Int): Int = R.layout.item_todo

    fun refreshDataSet() = notifyDataSetChanged()

}