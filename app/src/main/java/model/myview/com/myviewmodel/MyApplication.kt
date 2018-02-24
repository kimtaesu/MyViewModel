package model.myview.com.myviewmodel

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import model.myview.com.myviewmodel.di.AppInjector
import javax.inject.Inject

/**
 * Created by tskim on 2018. 2. 24..
 */
open class MyApplication : Application(), HasActivityInjector {
    override fun onCreate() {
        super.onCreate()
        AppInjector.init(this)
    }

    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> = activityDispatchingAndroidInjector

}