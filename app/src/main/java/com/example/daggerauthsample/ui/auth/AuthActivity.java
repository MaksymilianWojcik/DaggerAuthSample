package com.example.daggerauthsample.ui.auth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.RequestManager;
import com.example.daggerauthsample.R;
import com.example.daggerauthsample.models.User;
import com.example.daggerauthsample.network.auth.AuthResource;
import com.example.daggerauthsample.viewmodels.ViewModelProviderFactory;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class AuthActivity extends DaggerAppCompatActivity implements View.OnClickListener { // DaggerAppCompatActivity cause we use android dagger classes

    private static final String TAG = "AuthActivityTest";

    private AuthViewModel viewModel;

    @Inject
    ViewModelProviderFactory providerFactory;

    @Inject
    Drawable logo;

    @Inject
    RequestManager requestManager;

    ImageView logoImageView;
    EditText userIdEditText;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        logoImageView = findViewById(R.id.login_logo);
        userIdEditText = findViewById(R.id.user_id_input);
        progressBar = findViewById(R.id.progress_bar);

        findViewById(R.id.login_button).setOnClickListener(this);

        viewModel = ViewModelProviders.of(this, providerFactory).get(AuthViewModel.class);

        setLogo();

        subscribeObservers();
    }

    private void subscribeObservers() {
//        viewModel.observeuser().observe(this, new Observer<User>() {
//            @Override
//            public void onChanged(User user) {
//                if (user != null) {
//                    Log.d(TAG, "onChanged: authenticated for user " + user.getEmail());
//                } else {
//                    Log.d(TAG, "onChanged: user is null");
//                }
//            }
//        });

        viewModel.observeuser().observe(this, new Observer<AuthResource<User>>() {
            @Override
            public void onChanged(AuthResource<User> userAuthResource) {
                if(userAuthResource != null) {
                    switch (userAuthResource.status) {
                        case LOADING:
                            showProgressBar(true);
                            break;
                        case AUTHENTICATED:
                            showProgressBar(false);
                            Log.d(TAG, "onChanged: LOGIN SUCCESS: " + userAuthResource.data.getEmail());
                            break;
                        case ERROR:
                            showProgressBar(false);
                            Log.e(TAG, userAuthResource.message);
                            break;
                        case NOT_AUTHENTICATED:
                            showProgressBar(false);
                            break;
                    }
                }
            }
        });
    }

    private void showProgressBar(boolean isVisible) {
        if(isVisible) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }

    private void setLogo() {
        requestManager
                .load(logo)
                .into(logoImageView);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_button: {
                attemptLogin();
                break;
            }
        }
    }

    private void attemptLogin() {
        if(TextUtils.isEmpty(userIdEditText.getText().toString())) {
            return;
        }
        viewModel.authenticateById(Integer.parseInt(userIdEditText.getText().toString()));
    }
}
