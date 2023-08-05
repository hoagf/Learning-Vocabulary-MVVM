package com.hoagf.learning.di.component;

import android.app.Application;

import com.hoagf.learning.MvvmApp;
import com.hoagf.learning.data.DataManager;
import com.hoagf.learning.di.module.AppModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(MvvmApp app);

    DataManager getDataManager();

    @Component.Builder
    interface Builder{

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }


}
