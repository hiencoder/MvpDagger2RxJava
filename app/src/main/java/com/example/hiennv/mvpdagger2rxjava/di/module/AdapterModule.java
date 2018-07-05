package com.example.hiennv.mvpdagger2rxjava.di.module;

import com.example.hiennv.mvpdagger2rxjava.MainActivity;
import com.example.hiennv.mvpdagger2rxjava.adapter.CryptoAdapter;
import com.example.hiennv.mvpdagger2rxjava.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

@Module(includes = {MainActivityContextModule.class})
public class AdapterModule {

    @Provides
    @ActivityScope
    public CryptoAdapter provideCryptoAdapter(CryptoAdapter.OnClickListener onClickListener){
        return new CryptoAdapter(onClickListener);
    }

    @Provides
    @ActivityScope
    public CryptoAdapter.OnClickListener provideOnClickListener(MainActivity mainActivity){
        return mainActivity;
    }
}
