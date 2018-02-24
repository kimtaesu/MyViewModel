package model.myview.com.myviewmodel

import android.arch.lifecycle.ViewModel
import javax.inject.Inject

/**
 * Created by tskim on 2018. 2. 24..
 */
open class MyViewModel @Inject constructor(): ViewModel() {

    val c = CountObservable()
}