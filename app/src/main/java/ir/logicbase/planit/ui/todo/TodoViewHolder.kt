package ir.logicbase.planit.ui.todo

import android.view.View
import ir.logicbase.planit.ui.model.Todo
import ir.logicfan.core.ui.base.BaseViewHolder
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_todo.*

class TodoViewHolder(override val containerView: View) : BaseViewHolder<Todo>(containerView), LayoutContainer {

    override fun bind(item: Todo, position: Int) {
        with(item) {
            textView_itemTodo_title.text = title
            textView_itemTodo_time.text = time.toString()
            checkbox_itemTodo_tick.isChecked = isCompleted
        }
    }
}