package com.example.hiennv.mvpdagger2rxjava.application;

import android.app.Application;
import android.content.Context;

import com.example.hiennv.mvpdagger2rxjava.di.component.ApplicationComponent;
import com.example.hiennv.mvpdagger2rxjava.di.component.DaggerApplicationComponent;
import com.example.hiennv.mvpdagger2rxjava.di.module.ContextModule;

public class MyApplication extends Application{
    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent.builder()
                .contextModule(new ContextModule(this))
                .build();
        applicationComponent.inject(this);
    }

    //Get applicationcomponent
    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    public static MyApplication getMyApplication(Context context){
        return (MyApplication) context.getApplicationContext();
    }
}
