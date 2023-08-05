package com.hoagf.learning.di.component;

import com.hoagf.learning.di.module.ActivityModule;
import com.hoagf.learning.di.scope.ActivityScope;
import com.hoagf.learning.ui.splash.SplashActivity;

import dagger.Component;

@ActivityScope
@Component(modules = ActivityModule.class, dependencies = AppComponent.class)
public interface ActivityComponent {

    void inject(SplashActivity splashActivity);
}
