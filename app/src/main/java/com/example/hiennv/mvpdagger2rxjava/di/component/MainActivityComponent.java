package com.example.hiennv.mvpdagger2rxjava.di.component;

import android.content.Context;

import com.example.hiennv.mvpdagger2rxjava.MainActivity;
import com.example.hiennv.mvpdagger2rxjava.di.module.AdapterModule;
import com.example.hiennv.mvpdagger2rxjava.di.module.MainActivityContextModule;
import com.example.hiennv.mvpdagger2rxjava.di.module.MainMvpModule;
import com.example.hiennv.mvpdagger2rxjava.di.qualifier.ActivityContext;
import com.example.hiennv.mvpdagger2rxjava.di.scope.ActivityScope;

import dagger.Component;
@ActivityScope
@Component(modules = {AdapterModule.class, MainMvpModule.class}, dependencies = ApplicationComponent.class)
public interface MainActivityComponent {
    /*Cac modlule trong Component can Inject*/
    @ActivityContext
    Context getContext();

    void injectMainActivity(MainActivity activity);
}
