package com.example.daggerauthsample.di.main;

import androidx.lifecycle.ViewModel;

import com.example.daggerauthsample.di.ViewModelKey;
import com.example.daggerauthsample.ui.main.profile.ProfileViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class MainViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel.class)
    public abstract ViewModel bindProfileViewModel(ProfileViewModel viewModel);
}
