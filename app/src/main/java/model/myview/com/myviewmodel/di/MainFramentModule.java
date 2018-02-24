package model.myview.com.myviewmodel.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import model.myview.com.myviewmodel.MainFragment;

/**
 * Created by tskim on 2018. 2. 8..
 */

@Module
abstract class MainFramentModule {
    @PerFragment
    @ContributesAndroidInjector()
    abstract MainFragment bindBasicFormFragment();
}