package com.example.hiennv.mvpdagger2rxjava.mvp.view;

import com.example.hiennv.mvpdagger2rxjava.pojo.CryptoData;

import java.util.List;

public interface MainContract {
    interface MainViewCallBack{
        void showProgress();

        void hideProgress();

        void showData(List<CryptoData> list);

        void showError(String message);

        void showSuccess();
    }

    interface PresenterCallBack{
        void loadData();
    }
}
