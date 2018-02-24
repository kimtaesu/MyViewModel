package model.myview.com.myviewmodel.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import model.myview.com.myviewmodel.MainActivity
import model.myview.com.myviewmodel.SingleFragmentActivity
import javax.inject.Singleton

/**
 * Created by tskim on 2018. 2. 24..
 */
@Module()
abstract class MainActivityModule {
    @PerActivity
    @ContributesAndroidInjector(modules = arrayOf(
            MainFramentModule::class
    ))
    internal abstract fun bindJoinActivity(): MainActivity

    @PerActivity
    @ContributesAndroidInjector(modules = arrayOf(
            MainFramentModule::class
    ))
    internal abstract fun SingleFragmentActivity(): SingleFragmentActivity
}