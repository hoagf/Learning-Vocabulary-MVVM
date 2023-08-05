package com.hoagf.learning.di.component;

import com.hoagf.learning.di.module.FragmentModule;
import com.hoagf.learning.di.scope.FragmentScope;

import dagger.Component;

@FragmentScope
@Component(modules = FragmentModule.class, dependencies = AppComponent.class)
public interface FragmentComponent {
}
