package com.dmp.project.generalandroidstudy;

import android.app.Application;

import timber.log.Timber;

public class GeneralAndroidStudyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();


        Timber.plant(new Timber.DebugTree());

        //TODO: this : https://github.com/sourcey/materiallogindemo
    }
}
