package com.example.postfreeapp.views;

import com.example.postfreeapp.models.response.PostsItem;

import java.util.List;

public interface PostView {
    void onLoading();
    void onHidingLoading();
    void onError(String message);
    void onSuccess(String message);
    void onGetPostSuccess(List<PostsItem> postsItemList);
    void onGetPostByIdSucess(PostsItem data);

}
