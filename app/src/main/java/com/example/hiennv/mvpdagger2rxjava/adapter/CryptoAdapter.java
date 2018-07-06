package com.example.hiennv.mvpdagger2rxjava.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hiennv.mvpdagger2rxjava.R;
import com.example.hiennv.mvpdagger2rxjava.pojo.CryptoData;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CryptoAdapter extends RecyclerView.Adapter<CryptoAdapter.CryptoHolder>{
    private List<CryptoData> listCryptoData;
    private OnClickListener listener;

    public CryptoAdapter(OnClickListener listener) {
        this.listener = listener;
        listCryptoData = new ArrayList<>();
    }

    @NonNull
    @Override
    public CryptoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_crypto,parent,false);
        return new CryptoHolder(v);
    }

    @Override
    public void onBindViewHolder(CryptoHolder cryptoHolder, int position) {
        CryptoData cryptoData = listCryptoData.get(position);
        cryptoHolder.bindCrypto(cryptoData);
    }

    @Override
    public int getItemCount() {
        return listCryptoData.size();
    }

    public void setData(List<CryptoData> list){
        listCryptoData.addAll(list);
        notifyDataSetChanged();
    }

    public class CryptoHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_7_day)
        TextView tv7Day;
        @BindView(R.id.tv_7_day_change)
        TextView tv7DayChange;
        @BindView(R.id.tv_24_hour)
        TextView tv24Hour;
        @BindView(R.id.tv_24_hour_change)
        TextView tv24HourChange;
        @BindView(R.id.tv_coin)
        TextView tvCoin;
        @BindView(R.id.tv_current_price)
        TextView tvCurrentPrice;
        @BindView(R.id.tv_one_hour_change)
        TextView tvOneHourChange;
        @BindView(R.id.cv_item_crypto)
        CardView cvItemCrypto;
        public CryptoHolder(View view) {
            super(view);
            ButterKnife.bind(this,view);
            cvItemCrypto.setOnClickListener(view1 -> listener.onClick(listCryptoData.get(getAdapterPosition())));
        }

        public void bindCrypto(CryptoData cryptoData){
            tvOneHourChange.setText(cryptoData.percentChange1h + " %");
            tv7DayChange.setText(cryptoData.percentChange7d + " %");
            tv24HourChange.setText(cryptoData.percentChange24h + " %");
            tvCoin.setText(cryptoData.symbol);
            tvCurrentPrice.setText(cryptoData.priceUsd);
        }
    }

    public interface OnClickListener{
        void onClick(CryptoData cryptoData);
    }
}
