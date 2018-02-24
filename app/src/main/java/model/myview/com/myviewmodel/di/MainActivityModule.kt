package model.myview.com.myviewmodel.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import model.myview.com.myviewmodel.MainActivity

/**
 * Created by tskim on 2018. 2. 24..
 */
@Module()
abstract class MainActivityModule {
    @ContributesAndroidInjector(modules = arrayOf(
    ))
    internal abstract fun bindJoinActivity(): MainActivity
}