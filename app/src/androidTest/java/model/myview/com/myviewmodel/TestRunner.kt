package model.myview.com.myviewmodel

import android.app.Application
import android.content.Context
import android.support.test.runner.AndroidJUnitRunner
import model.myview.com.myviewmodel.TestApp

/**
 * Custom runner to disable dependency injection.
 */
class TestRunner : AndroidJUnitRunner() {
    @Throws(InstantiationException::class, IllegalAccessException::class, ClassNotFoundException::class)
    override fun newApplication(cl: ClassLoader, className: String, context: Context): Application {
        return super.newApplication(cl, TestApp::class.java!!.name, context)
    }
}