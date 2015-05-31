package com.pratamawijaya.pratamawijayacommvp.network;

import com.pratamawijaya.pratamawijayacommvp.models.Post;
import com.pratamawijaya.pratamawijayacommvp.models.ResponsePost;

import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

/**
 * Created by pratama on 5/31/15.
 */
public interface PratamaService {

    @GET("/get_recent_posts")
    public Observable<ResponsePost> getPosts();

    @GET("/get_post")
    public Observable<Post> getPost(@Path("post_id") int postId);
}
