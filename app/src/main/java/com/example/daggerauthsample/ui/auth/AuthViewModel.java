package com.example.daggerauthsample.ui.auth;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.example.daggerauthsample.network.auth.AuthApi;

import javax.inject.Inject;

public class AuthViewModel extends ViewModel {

    private static final String TAG = "AuthViewModelTest";

    private final AuthApi authApi;

    @Inject
    public AuthViewModel(AuthApi authApi){
        this.authApi = authApi;
    }

}
