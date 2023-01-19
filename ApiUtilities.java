package com.example.readit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiUtilities {
    public static Retrofit retrofit;

    public static ApiInterface getApiInterface(){
        if(retrofit == null)
            retrofit = new Retrofit.Builder().baseUrl(ApiInterface.baseUrl).addConverterFactory(GsonConverterFactory.create()).build();

        return retrofit.create(ApiInterface.class);
    }
}
