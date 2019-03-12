package ir.logicbase.planit.ui.todo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ir.logicbase.planit.R
import javax.inject.Inject

class TodoAdapter @Inject
constructor(private val presenter: TodoContract.AdapterAction) : RecyclerView.Adapter<TodoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent, false)
        return TodoViewHolder(view)
    }

    override fun getItemCount(): Int = presenter.getTodoItemCount()

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bind(presenter.getTodo(position), position)
    }

}