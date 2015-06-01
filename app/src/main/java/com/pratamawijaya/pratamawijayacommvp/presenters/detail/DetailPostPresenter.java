package com.pratamawijaya.pratamawijayacommvp.presenters.detail;

import com.pratamawijaya.pratamawijayacommvp.models.ResponsePostDetail;
import com.pratamawijaya.pratamawijayacommvp.network.NetworkAPI;
import com.pratamawijaya.pratamawijayacommvp.views.detail.ifaces.iDetailPostView;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by pratama on 5/31/15.
 */
public class DetailPostPresenter {

    private iDetailPostView view;
    private NetworkAPI networkAPI;

    public DetailPostPresenter(iDetailPostView view, NetworkAPI networkAPI) {
        this.view = view;
        this.networkAPI = networkAPI;
    }

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
