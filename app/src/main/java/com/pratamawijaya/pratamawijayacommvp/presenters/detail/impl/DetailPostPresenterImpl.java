package com.pratamawijaya.pratamawijayacommvp.presenters.detail.impl;

import com.pratamawijaya.pratamawijayacommvp.models.ResponsePostDetail;
import com.pratamawijaya.pratamawijayacommvp.network.NetworkAPI;
import com.pratamawijaya.pratamawijayacommvp.presenters.detail.ifaces.iDetailPostPresenter;
import com.pratamawijaya.pratamawijayacommvp.views.detail.ifaces.iDetailPostView;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by pratama on 5/31/15.
 */
public class DetailPostPresenterImpl implements iDetailPostPresenter {

    private iDetailPostView view;
    private NetworkAPI networkAPI;

    public DetailPostPresenterImpl(iDetailPostView view, NetworkAPI networkAPI) {
        this.view = view;
        this.networkAPI = networkAPI;
    }

    @Override
    public void loadDetail(int id) {
        view.showLoading(true);
        networkAPI.getService()
                .getPost(id)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponsePostDetail>() {
                    @Override
                    public void onCompleted() {
                        view.showLoading(false);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(ResponsePostDetail responsePostDetail) {
                        view.displayData(responsePostDetail.getPost().getContent());
                    }
                });
    }
}
