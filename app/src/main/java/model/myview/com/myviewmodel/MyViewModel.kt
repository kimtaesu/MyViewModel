package model.myview.com.myviewmodel

import android.arch.lifecycle.ViewModel

/**
 * Created by tskim on 2018. 2. 24..
 */
class MyViewModel : ViewModel() {

    val c = CountObservable()
}