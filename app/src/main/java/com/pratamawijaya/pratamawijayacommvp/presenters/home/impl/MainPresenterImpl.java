package com.pratamawijaya.pratamawijayacommvp.presenters.home.impl;

import com.pratamawijaya.pratamawijayacommvp.models.ResponsePost;
import com.pratamawijaya.pratamawijayacommvp.network.NetworkAPI;
import com.pratamawijaya.pratamawijayacommvp.presenters.home.ifaces.iMainPresenter;
import com.pratamawijaya.pratamawijayacommvp.views.home.ifaces.iMainView;
import com.pratamawijaya.pratamawijayacommvp.views.home.impl.MainActivity;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by pratama on 5/30/15.
 */
public class MainPresenterImpl implements iMainPresenter {
    private iMainView mView;
    private NetworkAPI network;

    public MainPresenterImpl(MainActivity view, NetworkAPI network) {
        this.mView = view;
        this.network = network;
    }

    @Override
    public void onCreateView() {
        mView.setupView();
        mView.setupListener();
    }

    @Override
    public void loadData() {
        // load data from server
        // pass to recycler view adapter
        // show loader
        mView.showLoading(true);
        network.getService()
                .getPosts()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponsePost>() {
                    @Override
                    public void onCompleted() {
                        // hide loader
                        mView.showLoading(false);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(ResponsePost responsePost) {
                        mView.displayData(responsePost.getPosts());
                    }
                });
    }
}
