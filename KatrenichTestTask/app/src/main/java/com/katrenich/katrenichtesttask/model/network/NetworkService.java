package com.katrenich.katrenichtesttask.model.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkService {
    private static NetworkService mInstance;
    public static final String BASE_URL = "https://api.inrating.top/v1/";
    private Retrofit mRetrofit;

    private NetworkService() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static NetworkService getInstance() {
        return mInstance == null ? new NetworkService() : mInstance;
    }

    public UserPostStatisticInfo getUserPostInfoJSON(){
        return mRetrofit.create(UserPostStatisticInfo.class);
    }
}
