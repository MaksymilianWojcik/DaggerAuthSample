package com.example.daggerauthsample.network.auth;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;

public interface AuthApi {

    @GET
    Call<Response> getFakeStuff();
}
