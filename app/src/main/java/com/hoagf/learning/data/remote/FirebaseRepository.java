package com.hoagf.learning.data.remote;

import androidx.lifecycle.MutableLiveData;

import com.google.firebase.database.DataSnapshot;

public interface FirebaseRepository {
    void incrementTotalNumberOfAppOpenings();
    MutableLiveData<DataSnapshot> getLessonData();
}
