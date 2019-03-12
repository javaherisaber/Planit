package ir.logicbase.planit.ui.todo

import androidx.fragment.app.Fragment
import dagger.Binds
import dagger.Module
import dagger.Provides
import ir.logicfan.core.di.qulifier.ParentFragment
import ir.logicfan.core.di.scope.PerFragment
import ir.logicfan.core.ui.base.BaseFragmentModule

@Module(includes = [BaseFragmentModule::class])
abstract class TodoFragmentModule {

    @Binds
    @ParentFragment
    @PerFragment
    abstract fun fragment(todoFragment: TodoFragment): Fragment

    @Binds
    @PerFragment
    abstract fun adapterAction(presenter: TodoPresenter): TodoContract.AdapterAction

    @Binds
    @PerFragment
    abstract fun action(presenter: TodoPresenter): TodoContract.Action

    @Binds
    @PerFragment
    abstract fun view(fragment: TodoFragment): TodoContract.View

    @Module
    companion object {
        @Provides
        @JvmStatic
        @PerFragment
        fun presenter(view: TodoContract.View): TodoPresenter {
            return TodoPresenter(view)
        }
    }
}