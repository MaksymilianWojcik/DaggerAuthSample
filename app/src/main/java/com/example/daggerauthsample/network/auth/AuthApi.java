package com.example.daggerauthsample.network.auth;

import com.example.daggerauthsample.models.User;

import io.reactivex.Flowable;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface AuthApi {

    @GET("users/{id}")
    Flowable<User> getUserById(@Path("id") int id);
}
