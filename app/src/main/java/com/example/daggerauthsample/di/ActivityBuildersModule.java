package com.example.daggerauthsample.di;

import com.example.daggerauthsample.di.auth.AuthModule;
import com.example.daggerauthsample.di.auth.AuthViewModelsModule;
import com.example.daggerauthsample.di.main.MainFragmentBuildersModule;
import com.example.daggerauthsample.di.main.MainModule;
import com.example.daggerauthsample.di.main.MainViewModelsModule;
import com.example.daggerauthsample.ui.auth.AuthActivity;
import com.example.daggerauthsample.ui.main.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector( // classes that has this annotation need to be abstract
            modules = {
                    AuthViewModelsModule.class,
                    AuthModule.class
            }
    )
    abstract AuthActivity contributeAuthActivity();

    @ContributesAndroidInjector(
            modules = {
                    MainFragmentBuildersModule.class,
                    MainViewModelsModule.class,
                    MainModule.class
            }
    )
    abstract MainActivity contributeMainActivity();

}
