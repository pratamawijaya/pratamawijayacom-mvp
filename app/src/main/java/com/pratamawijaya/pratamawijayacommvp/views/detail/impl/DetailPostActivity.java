package com.pratamawijaya.pratamawijayacommvp.views.detail.impl;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.pratamawijaya.pratamawijayacommvp.R;
import com.pratamawijaya.pratamawijayacommvp.base.BaseActivity;
import com.pratamawijaya.pratamawijayacommvp.network.NetworkAPI;
import com.pratamawijaya.pratamawijayacommvp.presenters.detail.impl.DetailPostPresenterImpl;
import com.pratamawijaya.pratamawijayacommvp.utils.LogUtils;
import com.pratamawijaya.pratamawijayacommvp.views.detail.ifaces.iDetailPostView;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class DetailPostActivity extends BaseActivity implements iDetailPostView {

    private DetailPostPresenterImpl presenter;
    private NetworkAPI network;

    @InjectView(R.id.loader)
    ProgressBar loading;
    @InjectView(R.id.txtDetail)
    TextView txtContent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_post);
        ButterKnife.inject(this);

        network = new NetworkAPI();
        presenter = new DetailPostPresenterImpl(this, network);

        presenter.loadDetail(1683);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detail_post, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void displayData(String txt) {
        txtContent.setText("" + txt);
        LogUtils.Trace("DetailPostView", "finish display data");
    }

    @Override
    public void showLoading(boolean showLoading) {
        if (showLoading) {
            txtContent.setVisibility(View.GONE);
            loading.setVisibility(View.VISIBLE);
        } else {
            txtContent.setVisibility(View.VISIBLE);
            loading.setVisibility(View.GONE);
        }
    }
}
