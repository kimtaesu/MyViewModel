package model.myview.com.myviewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import javax.inject.Inject

/**
 * Created by tskim on 2018. 1. 22..
 */
class TestViewModelFactory
@Inject constructor(private val creators: Map<Class<out ViewModel>, ViewModel>)
    : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        var creator: ViewModel? = creators[modelClass]
        if (creator == null) {
            for ((key, value) in creators) {
                if (modelClass.isAssignableFrom(key)) {
                    creator = value
                    break
                }
            }
        }
        if (creator == null) throw IllegalArgumentException("unknown model class " + modelClass)
        return creator as T
    }
}

fun viewFactoryCreate(vararg viewModel: ViewModel): TestViewModelFactory {

    val map = viewModel.map {
        it::class.java to it
    }.toMap()

    return TestViewModelFactory(map)
}