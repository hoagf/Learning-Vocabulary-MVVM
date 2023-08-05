package com.hoagf.learning.data;

import androidx.lifecycle.MutableLiveData;

import com.google.firebase.database.DataSnapshot;
import com.hoagf.learning.data.local.prefs.PreferencesHelper;
import com.hoagf.learning.data.remote.FirebaseRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AppDataManager  implements DataManager{
    private final FirebaseRepository firebaseRepository;
    private final PreferencesHelper preferencesHelper;

    @Inject
    public AppDataManager(FirebaseRepository firebaseRepository, PreferencesHelper preferencesHelper) {
        this.firebaseRepository = firebaseRepository;
        this.preferencesHelper = preferencesHelper;
    }


    @Override
    public void incrementTotalNumberOfAppOpenings() {

    }

    @Override
    public MutableLiveData<DataSnapshot> getLessonData() {
        return firebaseRepository.getLessonData();
    }


}
