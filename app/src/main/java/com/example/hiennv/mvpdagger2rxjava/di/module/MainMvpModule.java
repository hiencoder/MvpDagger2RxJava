package com.example.hiennv.mvpdagger2rxjava.di.module;

import com.example.hiennv.mvpdagger2rxjava.di.scope.ActivityScope;
import com.example.hiennv.mvpdagger2rxjava.mvp.view.MainContract;

import dagger.Module;
import dagger.Provides;

@Module
public class MainMvpModule {
    private MainContract.MainViewCallBack mainView;

    public MainMvpModule(MainContract.MainViewCallBack mainView) {
        this.mainView = mainView;
    }

    @Provides
    @ActivityScope
    public MainContract.MainViewCallBack provideMainView(){
        return mainView;
    }
}
