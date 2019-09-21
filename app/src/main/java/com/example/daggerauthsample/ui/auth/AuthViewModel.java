package com.example.daggerauthsample.ui.auth;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.example.daggerauthsample.models.User;
import com.example.daggerauthsample.network.auth.AuthApi;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class AuthViewModel extends ViewModel {

    private static final String TAG = "AuthViewModelTest";

    private final AuthApi authApi;

    @Inject
    public AuthViewModel(AuthApi authApi){
        this.authApi = authApi;

        authApi.getUserById(1)
                .toObservable()
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<User>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(User user) {
                        Log.d(TAG, "onNext: " + user.toString());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: ", e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}
