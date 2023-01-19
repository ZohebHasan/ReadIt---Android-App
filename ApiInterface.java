package com.example.readit;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    String baseUrl = "https://newsapi.org/v2/";

    @GET("top-headlines")
    Call<NewsList>  getNews(@Query("country") String country, @Query("pageSize") int pageSize, @Query("apiKey") String apiKey);

    @GET("top-headlines")
    Call<NewsList>  getCategoryNews(@Query("country") String country, @Query("category") String category, @Query("pageSize") int pageSize, @Query("apiKey") String apiKey);
}
