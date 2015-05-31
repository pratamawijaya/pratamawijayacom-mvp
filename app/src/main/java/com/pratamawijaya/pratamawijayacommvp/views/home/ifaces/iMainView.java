package com.pratamawijaya.pratamawijayacommvp.views.home.ifaces;

import com.pratamawijaya.pratamawijayacommvp.models.Post;

import java.util.List;

/**
 * Created by pratama on 5/30/15.
 */
public interface iMainView {
    /**
     * display data to view
     *
     * @param posts
     */
    public void displayData(List<Post> posts);

    public void setupView();

    public void setupListener();

    public void showLoading();

    public void hideLoading();

    void onItemTouch(int position);
}
