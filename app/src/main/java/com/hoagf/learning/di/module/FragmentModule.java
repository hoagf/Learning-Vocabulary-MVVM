package com.hoagf.learning.di.module;

import com.hoagf.learning.ui.base.BaseFragment;

import dagger.Module;

@Module
public class FragmentModule {

    private BaseFragment<?,?> fragment;

    public FragmentModule(BaseFragment<?, ?> fragment){
        this.fragment = fragment;
    }
}
