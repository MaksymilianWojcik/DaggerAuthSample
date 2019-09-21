package com.example.daggerauthsample;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.RequestManager;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class AuthActivity extends DaggerAppCompatActivity { // DaggerAppCompatActivity cause we use android dagger classes


    @Inject
    Drawable logo;

    @Inject
    RequestManager requestManager;

    ImageView logoImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        logoImageView = findViewById(R.id.login_logo);

        setLogo();
    }

    private void setLogo() {
        requestManager
                .load(logo)
                .into(logoImageView);
    }
}
