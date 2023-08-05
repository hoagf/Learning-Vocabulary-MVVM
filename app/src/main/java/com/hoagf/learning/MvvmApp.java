package com.hoagf.learning;



import android.app.Application;

import com.hoagf.learning.di.component.AppComponent;
import com.hoagf.learning.di.component.DaggerAppComponent;

public class MvvmApp extends Application {

    public AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .application(this)
                .build();

        appComponent.inject(this);
    }
}
