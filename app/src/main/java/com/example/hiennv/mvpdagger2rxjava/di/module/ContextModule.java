package com.example.hiennv.mvpdagger2rxjava.di.module;

import android.content.Context;

import com.example.hiennv.mvpdagger2rxjava.di.qualifier.ApplicationContext;
import com.example.hiennv.mvpdagger2rxjava.di.scope.ApplicationScope;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {
    private Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @Provides
    @ApplicationScope
    @ApplicationContext
    public Context provideContext(){
        return context;
    }
}
