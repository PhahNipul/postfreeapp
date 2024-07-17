package com.example.postfreeapp.api;

import com.example.postfreeapp.models.response.PostResponse;
import com.example.postfreeapp.models.response.PostsItem;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface  ApiInterface {
    @GET("/posts")
    Call<PostResponse> getAllPost();
    @GET("/posts/{id}")
    Call<PostsItem> getPostById(@Path("id")int id);
}
