package com.example.retrofitactivity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {
    //https://jsonplaceholder.typicode.com/posts

    Gson gson = new GsonBuilder().setDateFormat("yyy-MMM-ddd HH:mm:ss").create();

    ApiInterface apiIterface = new Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiInterface.class);

    @POST("posts")
    Call<Post> sendPost (@Body Post post);
}
