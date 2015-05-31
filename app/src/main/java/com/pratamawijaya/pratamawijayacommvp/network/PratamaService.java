package com.pratamawijaya.pratamawijayacommvp.network;

import com.pratamawijaya.pratamawijayacommvp.models.ResponsePost;
import com.pratamawijaya.pratamawijayacommvp.models.ResponsePostDetail;

import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by pratama on 5/31/15.
 */
public interface PratamaService {

    @GET("/get_recent_posts")
    public Observable<ResponsePost> getPosts();

    @GET("/get_post/")
    public Observable<ResponsePostDetail> getPost(@Query("post_id") int postId);
}
