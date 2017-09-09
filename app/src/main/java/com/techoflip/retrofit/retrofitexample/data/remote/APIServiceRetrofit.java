package com.techoflip.retrofit.retrofitexample.data.remote;

import com.techoflip.retrofit.retrofitexample.data.model.ResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Sarthak Verma (github.com/IAmSarthakVerma)
 */


public interface APIServiceRetrofit {

    @GET("api")
    Call<ResponseModel> detailsget();


}
