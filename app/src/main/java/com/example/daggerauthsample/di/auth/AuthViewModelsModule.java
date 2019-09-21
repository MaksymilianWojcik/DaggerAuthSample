package com.example.daggerauthsample.di.auth;

import androidx.lifecycle.ViewModel;

import com.example.daggerauthsample.di.ViewModelKey;
import com.example.daggerauthsample.ui.auth.AuthViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/***
 * Dependencies for this view model itself
 */
@Module
public abstract class AuthViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel.class)
    public abstract ViewModel bindAuthViewModel(AuthViewModel viewModel);
}
