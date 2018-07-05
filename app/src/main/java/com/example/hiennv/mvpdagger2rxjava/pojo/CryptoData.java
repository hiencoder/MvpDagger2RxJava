package com.example.hiennv.mvpdagger2rxjava.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CryptoData {

    @Expose
    @SerializedName("lastupdated")
    public String lastUpdated;
    @Expose
    @SerializedName("percentchange7d")
    public String percentChange7d;
    @Expose
    @SerializedName("percentchange24h")
    public String percentChange24h;
    @Expose
    @SerializedName("percentchange1h")
    public String percentChange1h;
    @Expose
    @SerializedName("maxsupply")
    public String maxSupply;
    @Expose
    @SerializedName("totalsupply")
    public String totalSupply;
    @Expose
    @SerializedName("availablesupply")
    public String availableSupply;
    @Expose
    @SerializedName("marketcapusd")
    public String marketCapUsd;
    @Expose
    @SerializedName("24hvolumeusd")
    public String volumeUsd;
    @Expose
    @SerializedName("pricebtc")
    public String priceBtc;
    @Expose
    @SerializedName("priceusd")
    public String priceUsd;
    @Expose
    @SerializedName("rank")
    public String rank;
    @Expose
    @SerializedName("symbol")
    public String symbol;
    @Expose
    @SerializedName("name")
    public String name;
    @Expose
    @SerializedName("id")
    public String id;
}
