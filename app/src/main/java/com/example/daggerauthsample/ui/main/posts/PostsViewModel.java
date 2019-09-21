package com.example.daggerauthsample.ui.main.posts;

import androidx.lifecycle.ViewModel;

import com.example.daggerauthsample.SessionManager;
import com.example.daggerauthsample.network.main.MainApi;

import javax.inject.Inject;

public class PostsViewModel extends ViewModel {

    private static final String TAG = "PostsViewModel";

    private final SessionManager sessionManager;
    private final MainApi mainApi;

    @Inject
    public PostsViewModel(SessionManager sessionManager, MainApi mainApi) {
        this.sessionManager = sessionManager;
        this.mainApi = mainApi;
    }
}
