package com.hoagf.learning.ui.base;

import androidx.lifecycle.ViewModel;

import com.hoagf.learning.data.DataManager;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;

public class BaseViewModel<N> extends ViewModel {
    private final DataManager mDataManager;
    private CompositeDisposable mCompositeDisposable;
    private WeakReference<N> mNavigator;

    public BaseViewModel(DataManager mDataManager) {
        this.mDataManager = mDataManager;
        this.mCompositeDisposable = new CompositeDisposable();
    }
    public DataManager getDataManager() {
        return mDataManager;
    }

    public N getNavigator() {
        return mNavigator.get();
    }

    public void setNavigator(N navigator) {
        this.mNavigator = new WeakReference<>(navigator);
    }

    public CompositeDisposable getCompositeDisposable() {
        return mCompositeDisposable;
    }


}
