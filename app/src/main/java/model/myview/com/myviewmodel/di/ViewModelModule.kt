package model.myview.com.myviewmodel.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import model.myview.com.myviewmodel.MyViewModel
import model.myview.com.myviewmodel.ViewModelFactory
import kotlin.reflect.KClass

/**
 * Created by tskim on 2018. 1. 22..
 */
@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelModule.ViewModelKey(MyViewModel::class)
    internal abstract fun bindVerifyEmailViewModel(viewModelVerify: MyViewModel): ViewModel


    @MustBeDocumented
    @Retention(AnnotationRetention.RUNTIME)
    @MapKey
    annotation class ViewModelKey(val value: KClass<out ViewModel>)
}
