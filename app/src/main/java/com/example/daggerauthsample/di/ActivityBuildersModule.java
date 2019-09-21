package com.example.daggerauthsample.di;

import com.example.daggerauthsample.AuthActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector // classes that has this annotation need to be abstract
    abstract AuthActivity contributeAuthActivity();

}
