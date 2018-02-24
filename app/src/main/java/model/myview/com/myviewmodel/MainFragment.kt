package model.myview.com.myviewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.HasSupportFragmentInjector
import model.myview.com.myviewmodel.databinding.FragmentMainBinding
import model.myview.com.myviewmodel.di.Injectable
import javax.inject.Inject

/**
 * Created by tskim on 2018. 2. 25..
 */
class MainFragment : Fragment(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var binding: FragmentMainBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        binding.viewModel = viewModelFactory.get(this)
        return binding.root
    }
}

inline fun <reified T : ViewModel> ViewModelProvider.Factory.get(fragment: Fragment): T {
    return ViewModelProviders.of(fragment, this).get(T::class.java)
}
