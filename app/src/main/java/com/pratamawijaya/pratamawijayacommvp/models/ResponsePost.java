package com.pratamawijaya.pratamawijayacommvp.models;

import java.util.List;

/**
 * Created by pratama on 5/31/15.
 */
public class ResponsePost {
    private List<Post> posts;
    private String status;

    public List<Post> getPosts() {
        return posts;
    }

    public String getStatus() {
        return status;
    }
}
