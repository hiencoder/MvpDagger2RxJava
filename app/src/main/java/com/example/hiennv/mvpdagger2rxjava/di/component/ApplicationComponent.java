package com.example.hiennv.mvpdagger2rxjava.di.component;

import android.app.Application;
import android.content.Context;

import com.example.hiennv.mvpdagger2rxjava.application.MyApplication;
import com.example.hiennv.mvpdagger2rxjava.di.module.ContextModule;
import com.example.hiennv.mvpdagger2rxjava.di.module.NetworkModule;
import com.example.hiennv.mvpdagger2rxjava.di.qualifier.ApplicationContext;
import com.example.hiennv.mvpdagger2rxjava.di.scope.ActivityScope;
import com.example.hiennv.mvpdagger2rxjava.di.scope.ApplicationScope;
import com.example.hiennv.mvpdagger2rxjava.network.ApiService;

import dagger.Component;

@ApplicationScope
@Component(modules = {ContextModule.class, NetworkModule.class})
public interface ApplicationComponent {
    //Các thành phần application
    ApiService getApiService();

    @ApplicationContext
    Context getContext();

    void inject(MyApplication myApplication);
}
