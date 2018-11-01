package com.sreeyainfotech.retrofitexample.networkCall;

import com.sreeyainfotech.retrofitexample.model.AllData;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {

    @GET("AlltypeCategoriesListNewV18")
    Call<AllData> doGetListResources();
}
