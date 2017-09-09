package com.techoflip.retrofit.retrofitexample.data.remote;

/**
 * Created by Sarthak Verma (github.com/IAmSarthakVerma)
 */


public class AppUtilsRetrofit {

    public static final String BASE_URL = "http://uinames.com/";

    public AppUtilsRetrofit() {
    }

    public static APIServiceRetrofit getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIServiceRetrofit.class);
    }
}
