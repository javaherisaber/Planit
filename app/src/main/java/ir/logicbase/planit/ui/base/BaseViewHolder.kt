package ir.logicbase.planit.ui.base

import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.recyclerview.widget.RecyclerView

class BaseViewHolder<T> (private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root), LifecycleOwner {

    private val lifecycleRegistry = LifecycleRegistry(this)

    init {
        lifecycleRegistry.markState(Lifecycle.State.INITIALIZED)
    }

    fun onAppear() = lifecycleRegistry.markState(Lifecycle.State.CREATED)

    fun onDisappear() = lifecycleRegistry.markState(Lifecycle.State.DESTROYED)

    override fun getLifecycle(): Lifecycle = lifecycleRegistry

    fun bind(item: T) {
        binding.setVariable(BR.item, item)
        binding.executePendingBindings()
    }
}