package com.example.daggerauthsample.di;

import android.app.Application;

import com.example.daggerauthsample.BaseApplication;
import com.example.daggerauthsample.SessionManager;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(
        modules = {
                AndroidSupportInjectionModule.class, // mandatory when we use AndroidInjector, only once in app level component
                ActivityBuildersModule.class,
                AppModule.class,
                ViewModelFactoryModule.class // used by all of the view models in the project
        }
)
public interface AppComponent extends AndroidInjector<BaseApplication> {

    SessionManager sessionManager();

    @Component.Builder
    interface Builder {

        AppComponent build(); // mandatory step - overriding the regular builder and returning the type of AppComponent

        @BindsInstance
        Builder application(Application application);
    }

}
