package com.example.daggerauthsample.di.main;

import com.example.daggerauthsample.network.main.MainApi;
import com.example.daggerauthsample.ui.main.posts.PostRecyclerAdapter;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public abstract class MainModule {

    @Provides
    static MainApi provideMainApi(Retrofit retrofit) {
        return retrofit.create(MainApi.class);
    }

    @Provides
    static PostRecyclerAdapter providePostAdapter(){
        return new PostRecyclerAdapter();
    }
}
