package model.myview.com.myviewmodel.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import model.myview.com.myviewmodel.MyApplication
import javax.inject.Singleton

/**
 * Created by tskim on 2018. 1. 19..
 */
@Singleton
@Component(modules = [(MainActivityModule::class), AndroidSupportInjectionModule::class])
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

    fun inject(app: MyApplication)
}
