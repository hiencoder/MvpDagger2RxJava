package com.example.hiennv.mvpdagger2rxjava.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CryptoData {

    @Expose
    @SerializedName("last_updated")
    public String lastUpdated;
    @Expose
    @SerializedName("percent_change_7d")
    public String percentChange7d;
    @Expose
    @SerializedName("percent_change_24h")
    public String percentChange24h;
    @Expose
    @SerializedName("percent_change_1h")
    public String percentChange1h;
    @Expose
    @SerializedName("max_supply")
    public String maxSupply;
    @Expose
    @SerializedName("total_supply")
    public String totalSupply;
    @Expose
    @SerializedName("available_supply")
    public String availableSupply;
    @Expose
    @SerializedName("market_cap_usd")
    public String marketCapUsd;
    @Expose
    @SerializedName("24h_volume_usd")
    public String volumeUsd;
    @Expose
    @SerializedName("price_btc")
    public String priceBtc;
    @Expose
    @SerializedName("price_usd")
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
