package com.hoagf.learning.di.module;

import android.app.Application;
import android.content.Context;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.hoagf.learning.data.AppDataManager;
import com.hoagf.learning.data.DataManager;
import com.hoagf.learning.data.local.prefs.AppPreferencesHelper;
import com.hoagf.learning.data.local.prefs.PreferencesHelper;
import com.hoagf.learning.data.remote.AppFirebaseRepository;
import com.hoagf.learning.data.remote.FirebaseRepository;
import com.hoagf.learning.di.PreferenceInfo;
import com.hoagf.learning.utils.Constants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Provides
    @Singleton
    DatabaseReference provideDatabaseReference(){
        return FirebaseDatabase.getInstance().getReference();
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager){
        return appDataManager;
    }

    @Provides
    @Singleton
    FirebaseRepository provideFirebaseRepository(AppFirebaseRepository firebaseRepository){
        return firebaseRepository;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper preferencesHelper){
        return preferencesHelper;
    }

    @Provides
    @Singleton
    Context provideContext(Application application){
        return application;
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return Constants.PREF_NAME;
    }
}
