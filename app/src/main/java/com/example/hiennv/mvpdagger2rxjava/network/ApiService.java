package com.example.hiennv.mvpdagger2rxjava.network;

import com.example.hiennv.mvpdagger2rxjava.pojo.CryptoData;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface ApiService {
    @GET("ticker/?")
    Observable<List<CryptoData>> getData(@Query("limit") String limit);
}
