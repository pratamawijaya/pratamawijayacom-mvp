package com.pratamawijaya.pratamawijayacommvp.views.home.ifaces;

import com.pratamawijaya.pratamawijayacommvp.models.Post;

import java.util.List;

/**
 * Created by pratama on 5/30/15.
 */
public interface iMainView {
    void displayData(List<Post> posts);

    void setupView();

    void setupListener();

    void showLoading(boolean showLoading);

    void onItemTouch(int position);
}
