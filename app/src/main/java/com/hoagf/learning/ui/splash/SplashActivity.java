package com.hoagf.learning.ui.splash;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.hoagf.learning.R;
import com.hoagf.learning.BR;

import com.hoagf.learning.databinding.ActivitySplashBinding;
import com.hoagf.learning.di.component.ActivityComponent;
import com.hoagf.learning.ui.base.BaseActivity;

public class  SplashActivity extends BaseActivity<ActivitySplashBinding, SplashViewModel> implements SplashNavigator{
    private ActivitySplashBinding mActivitySplashBinding;
    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivitySplashBinding = getViewDataBinding();
        mViewModel.loadLessonData();
        mViewModel.getLessonData().observe(this, this::setLessonDataToView);


    }

    @SuppressLint("SetTextI18n")
    private void setLessonDataToView(DataSnapshot dataSnapshot) {
        if(dataSnapshot!=null){
            Log.d("hhh", ""+dataSnapshot);
            mActivitySplashBinding.txtLessons.setText(""+ dataSnapshot);
        }

    }


    @Override
    public void performDependencyInjection(ActivityComponent buildComponent) {
        buildComponent.inject(this);
    }

    @Override
    public void openMainActivity() {

    }
}