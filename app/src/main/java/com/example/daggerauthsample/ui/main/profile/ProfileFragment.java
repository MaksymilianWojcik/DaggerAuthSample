package com.example.daggerauthsample.ui.main.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.daggerauthsample.R;

import dagger.android.support.DaggerFragment;

public class ProfileFragment extends DaggerFragment {

    private static ProfileFragment profileFragment;

    public static ProfileFragment newInstance() {
        if(profileFragment == null ) {
            Bundle args = new Bundle();
            profileFragment = new ProfileFragment();
            profileFragment.setArguments(args);
        }
        return profileFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }
}
