package com.example.hiennv.mvpdagger2rxjava.mvp.presenter;

import android.util.Log;

import com.example.hiennv.mvpdagger2rxjava.mvp.view.MainContract;
import com.example.hiennv.mvpdagger2rxjava.network.ApiService;
import com.example.hiennv.mvpdagger2rxjava.pojo.CryptoData;
import com.example.hiennv.mvpdagger2rxjava.util.LogUtil;

import java.util.List;

import javax.inject.Inject;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainPresenterImpl implements MainContract.PresenterCallBack {
    private static final String TAG = MainPresenterImpl.class.getSimpleName();
    //instance mainView
    MainContract.MainViewCallBack mainView;

    ApiService apiService;

    @Inject //Nen dc inject vao MainActivity
    public MainPresenterImpl(MainContract.MainViewCallBack mainView, ApiService apiService) {
        this.mainView = mainView;
        this.apiService = apiService;
    }

    @Override
    public void loadData() {
        mainView.showProgress();
        apiService.getData("10")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<CryptoData>>() {
                    @Override
                    public void onCompleted() {
                        Log.i(TAG, "onCompleted: ");
                        mainView.showSuccess();
                        mainView.hideProgress();
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtil.e(TAG, e.getMessage());
                        mainView.hideProgress();
                        mainView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(List<CryptoData> list) {
                        LogUtil.i(TAG,list.size() + "");
                        mainView.showData(list);
                    }
                });

    }
}
