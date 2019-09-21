package com.example.daggerauthsample.di;

import androidx.lifecycle.ViewModelProvider;

import com.example.daggerauthsample.viewmodels.ViewModelProviderFactory;

import dagger.Binds;
import dagger.Module;

/***
 * Responsible for generating the dependency, doing the dependency injection for ViewModel factory class
 */
@Module
public abstract class ViewModelFactoryModule {

    @Binds
    public abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelProviderFactory modelProviderFactory);

}
