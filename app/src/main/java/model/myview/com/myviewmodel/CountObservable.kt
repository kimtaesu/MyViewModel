package model.myview.com.myviewmodel

import android.databinding.BaseObservable
import android.databinding.Bindable

/**
 * Created by tskim on 2018. 2. 24..
 */
class CountObservable : BaseObservable() {

    @get:Bindable
    var input: String = ""
        set(value) {
            field = value
            digitCount = 0
            textCount = 0
            value.forEach {
                if (it.isDigit())
                    ++digitCount
                else
                    ++textCount
            }
        }

    @get:Bindable
    var digitCount = 0
        set(value) {
            field = value
            notifyPropertyChanged(BR.digitCount)
        }
    @get:Bindable
    var textCount = 0
        set(value) {
            field = value
            notifyPropertyChanged(BR.textCount)
        }

}