package com.example.hiennv.mvpdagger2rxjava.di.module;

import android.content.Context;

import com.example.hiennv.mvpdagger2rxjava.MainActivity;
import com.example.hiennv.mvpdagger2rxjava.di.qualifier.ActivityContext;
import com.example.hiennv.mvpdagger2rxjava.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityContextModule {
    private MainActivity mainActivity;

    public Context context;

    public MainActivityContextModule(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        context = mainActivity;
    }

    @Provides
    @ActivityScope
    public MainActivity provideMainActivity(){
        return mainActivity;
    }

    @Provides
    @ActivityScope
    @ActivityContext
    public Context provideContext(){
        return context;
    }
}
