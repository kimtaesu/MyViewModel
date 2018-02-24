package model.myview.com.myviewmodel

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import model.myview.com.myviewmodel.databinding.ActivityMainBinding
import javax.inject.Inject

/**
 * Created by tskim on 2018. 2. 24..
 */
class MainActivity : AppCompatActivity(), HasSupportFragmentInjector {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setVariable(BR.viewModel, MyViewModel())
    }

    @Inject
    lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return fragmentDispatchingAndroidInjector
    }
}