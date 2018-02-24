
package model.myview.com.myviewmodel.di;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import dagger.android.AndroidInjection;
import dagger.android.support.AndroidSupportInjection;
import dagger.android.support.HasSupportFragmentInjector;
import model.myview.com.myviewmodel.MyApplication;

/**
 * Created by tskim on 2018. 1. 19..
 */
public final class AppInjector {
    private AppInjector() {
    }

    public static void init(MyApplication application) {
        DaggerApplicationComponent
                .builder()
                .application(application)
                .build()
                .inject(application);

        application
                .registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
                    @Override
                    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                        if (activity instanceof HasSupportFragmentInjector) {
                            AndroidInjection.inject(activity);
                        }
                        if (activity instanceof FragmentActivity) {
                            ((FragmentActivity) activity).getSupportFragmentManager()
                                    .registerFragmentLifecycleCallbacks(
                                            new FragmentManager.FragmentLifecycleCallbacks() {
                                                @Override
                                                public void onFragmentCreated(
                                                        FragmentManager fm,
                                                        Fragment f,
                                                        Bundle savedInstanceState) {
                                                    if (f instanceof Injectable) {
                                                        AndroidSupportInjection.inject(f);
                                                    }
                                                }
                                            }, true);
                        }
                    }

                    @Override
                    public void onActivityStarted(Activity activity) {
                        // unused
                    }

                    @Override
                    public void onActivityResumed(Activity activity) {
                        // unused
                    }

                    @Override
                    public void onActivityPaused(Activity activity) {
                        // unused
                    }

                    @Override
                    public void onActivityStopped(Activity activity) {
                        // unused
                    }

                    @Override
                    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
                        // unused
                    }

                    @Override
                    public void onActivityDestroyed(Activity activity) {
                        // unused
                    }
                });
    }
}