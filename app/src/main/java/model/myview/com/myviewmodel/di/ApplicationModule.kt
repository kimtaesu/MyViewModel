package model.myview.com.myviewmodel.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by tskim on 2018. 1. 19..
 */
@Module(includes = arrayOf(
        MainActivityModule::class
))
class ApplicationModule {
    @Provides
    @Singleton
    fun provideContext(application: Application): Context = application
}
