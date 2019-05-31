package com.example.instantlisten;

import android.app.Application;

import com.example.library.NetworkManager;

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        NetworkManager.getDefault().init(this);
    }
}
