package com.example.appcandybug.server;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitClient {
    private static Retrofit instance;
    public static Retrofit getInstance(){
        if(instance==null)
        {
            instance = new Retrofit.Builder()
                    .baseUrl("http://192.168.1.254/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return instance;
    }
}
