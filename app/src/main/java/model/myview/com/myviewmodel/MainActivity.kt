package model.myview.com.myviewmodel

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import model.myview.com.myviewmodel.databinding.ActivityMainBinding

/**
 * Created by tskim on 2018. 2. 24..
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        binding.setVariable(BR.viewModel, MyViewModel())
    }
}