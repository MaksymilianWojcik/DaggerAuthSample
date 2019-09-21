package com.example.daggerauthsample.ui.main.profile;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.daggerauthsample.SessionManager;
import com.example.daggerauthsample.models.User;
import com.example.daggerauthsample.network.auth.AuthResource;

import javax.inject.Inject;

public class ProfileViewModel extends ViewModel {

    private static final String TAG = "ProfileViewModel";

    private final SessionManager sessionManager;

    @Inject
    public ProfileViewModel(SessionManager sessionManager) {
        Log.d(TAG, "ProfileViewModel: viewmodel ready");
        this.sessionManager = sessionManager;
    }

    public LiveData<AuthResource<User>> getAuthenticatedUser(){
        return sessionManager.getAuthUser();
    }
}
