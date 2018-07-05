package com.example.hiennv.mvpdagger2rxjava;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.example.hiennv.mvpdagger2rxjava.adapter.CryptoAdapter;
import com.example.hiennv.mvpdagger2rxjava.application.MyApplication;
import com.example.hiennv.mvpdagger2rxjava.di.component.DaggerMainActivityComponent;
import com.example.hiennv.mvpdagger2rxjava.di.component.MainActivityComponent;
import com.example.hiennv.mvpdagger2rxjava.di.module.MainActivityContextModule;
import com.example.hiennv.mvpdagger2rxjava.di.module.MainMvpModule;
import com.example.hiennv.mvpdagger2rxjava.di.qualifier.ActivityContext;
import com.example.hiennv.mvpdagger2rxjava.di.qualifier.ApplicationContext;
import com.example.hiennv.mvpdagger2rxjava.mvp.presenter.MainPresenterImpl;
import com.example.hiennv.mvpdagger2rxjava.mvp.view.MainContract;
import com.example.hiennv.mvpdagger2rxjava.pojo.CryptoData;
import com.example.hiennv.mvpdagger2rxjava.util.LogUtil;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements CryptoAdapter.OnClickListener,
        MainContract.MainViewCallBack{
    private static final String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.rv_crypto)
    RecyclerView rvCrypto;
    @BindView(R.id.pb_loading)
    ProgressBar pbLoading;

    @Inject
    MainPresenterImpl mainPresenter;

    @Inject
    CryptoAdapter cryptoAdapter;

    @Inject
    @ApplicationContext
    Context context;

    @Inject
    @ActivityContext
    Context activityContext;

    MainActivityComponent mainActivityComponent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mainActivityComponent = DaggerMainActivityComponent
                .builder()
                .applicationComponent(MyApplication.getMyApplication(this).getApplicationComponent())
                .mainActivityContextModule(new MainActivityContextModule(this))
                .mainMvpModule(new MainMvpModule(this))
                .build();
        mainActivityComponent.injectMainActivity(this);

        mainPresenter.loadData();
    }

    @Override
    public void onClick(CryptoData cryptoData) {

    }

    @Override
    public void showProgress() {
        pbLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        pbLoading.setVisibility(View.GONE);
    }

    @Override
    public void showData(List<CryptoData> list) {
        cryptoAdapter.setData(list);
    }

    @Override
    public void showError(String message) {
        LogUtil.e(TAG,message);
    }

    @Override
    public void showSuccess() {
        LogUtil.i(TAG,"Success");
    }
}
