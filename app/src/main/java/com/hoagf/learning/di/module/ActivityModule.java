package com.hoagf.learning.di.module;

import androidx.lifecycle.ViewModelProvider;

import com.hoagf.learning.ViewModelProviderFactory;
import com.hoagf.learning.data.DataManager;
import com.hoagf.learning.ui.base.BaseActivity;
import com.hoagf.learning.ui.splash.SplashViewModel;

import java.util.function.Supplier;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {
    private BaseActivity<?, ?> activity;

    public ActivityModule(BaseActivity<?, ?> activity) {
        this.activity = activity;
    }

    @Provides
    SplashViewModel provideSplashViewModel(DataManager dataManager) {
        Supplier<SplashViewModel> supplier = () -> new SplashViewModel(dataManager);
        ViewModelProviderFactory<SplashViewModel> factory = new ViewModelProviderFactory<>(SplashViewModel.class, supplier);
        return new ViewModelProvider(activity, factory).get(SplashViewModel.class);
    }
}
