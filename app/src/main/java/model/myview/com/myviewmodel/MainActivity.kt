package model.myview.com.myviewmodel

import android.os.Bundle

/**
 * Created by tskim on 2018. 2. 24..
 */


class MainActivity : model.myview.com.myviewmodel.di.DaggerActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.beginTransaction().replace(android.R.id.content, MainFragment()).commit()
    }
}