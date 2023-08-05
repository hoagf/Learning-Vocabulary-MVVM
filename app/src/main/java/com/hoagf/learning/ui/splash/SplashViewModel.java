package com.hoagf.learning.ui.splash;

import androidx.lifecycle.MutableLiveData;

import com.google.firebase.database.DataSnapshot;
import com.hoagf.learning.data.DataManager;
import com.hoagf.learning.ui.base.BaseViewModel;

public class SplashViewModel extends BaseViewModel<SplashNavigator> {
    private MutableLiveData<DataSnapshot> lessonData = new MutableLiveData<>();

    public SplashViewModel(DataManager dataManager) {
        super(dataManager);
    }

    public MutableLiveData<DataSnapshot> getLessonData(){
        return lessonData;
    }
    public void loadLessonData() {
        lessonData = getDataManager().getLessonData();
    }
}
