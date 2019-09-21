package com.example.daggerauthsample.di;

import android.app.Application;

import com.example.daggerauthsample.BaseApplication;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Component(
        modules = {
                AndroidSupportInjectionModule.class // mandatory when we use AndroidInjector, only once in app level component
        }
)
public interface AppComponent extends AndroidInjector<BaseApplication> {

    @Component.Builder
    interface Builder {

        AppComponent build(); // mandatory step - overriding the regular builder and returning the type of AppComponent

        @BindsInstance
        Builder application(Application application);
    }

}
