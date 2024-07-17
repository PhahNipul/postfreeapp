package com.example.postfreeapp.presenters;

import android.view.View;

import androidx.recyclerview.widget.GridLayoutManager;

import com.example.postfreeapp.MainActivity;
import com.example.postfreeapp.adapter.PostAdapter;
import com.example.postfreeapp.api.APIClient;
import com.example.postfreeapp.api.ApiInterface;
import com.example.postfreeapp.models.response.PostResponse;
import com.example.postfreeapp.models.response.PostsItem;
import com.example.postfreeapp.views.PostView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostPresenter {
    private final PostView view;
    private ApiInterface apiInterface;

    public PostPresenter(PostView view) {
        this.view = view;
        apiInterface = APIClient.getClient().create(ApiInterface.class);
    }

    public void getAllPosts() {
        view.onLoading();
        apiInterface.getAllPost().enqueue(new Callback<PostResponse>() {
            @Override
            public void onResponse(Call<PostResponse> call, Response<PostResponse> response) {
                view.onHidingLoading();
                if (response.isSuccessful() && null != response.body()){
                    view.onGetPostSuccess(response.body().getPosts());
                }
            }

            @Override
            public void onFailure(Call<PostResponse> call, Throwable throwable) {
                view.onHidingLoading();

            }
        });
    }
    public void getPostById(int id){
        view.onLoading();
        apiInterface.getPostById(id).enqueue(new Callback<PostsItem>() {
            @Override
            public void onResponse(Call<PostsItem> call, Response<PostsItem> response) {
                view.onGetPostByIdSucess(response.body());
            }

            @Override
            public void onFailure(Call<PostsItem> call, Throwable throwable) {
                view.onHidingLoading();
                view.onSuccess(throwable.getLocalizedMessage());

            }
        });
    }
}
