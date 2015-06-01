package com.pratamawijaya.pratamawijayacommvp.presenters.home;

import com.pratamawijaya.pratamawijayacommvp.models.ResponsePost;
import com.pratamawijaya.pratamawijayacommvp.network.NetworkAPI;
import com.pratamawijaya.pratamawijayacommvp.views.home.ifaces.iMainView;
import com.pratamawijaya.pratamawijayacommvp.views.home.impl.MainActivity;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by pratama on 5/30/15.
 */
public class MainPresenter {

    private iMainView mView;
    private NetworkAPI network;

    public MainPresenter() {
    }

    public MainPresenter(MainActivity view) {
        this.mView = view;
        network = new NetworkAPI();
    }

    public int count(int x, int y) {
        return x + y;
    }

    public void onCreateView() {
        mView.setupView();
        mView.setupListener();
    }

    /**
     * from here you can decide from where you want to load data
     * server or local
     */
    public void loadData() {
        // load data from server
        // pass to recycler view adapter
        // show loader
        mView.showLoading(true);
        network.getService()
                .getPosts()// call api
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
