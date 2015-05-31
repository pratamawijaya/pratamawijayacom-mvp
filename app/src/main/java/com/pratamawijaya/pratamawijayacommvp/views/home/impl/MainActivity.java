package com.pratamawijaya.pratamawijayacommvp.views.home.impl;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.pratamawijaya.pratamawijayacommvp.R;
import com.pratamawijaya.pratamawijayacommvp.base.BaseActivity;
import com.pratamawijaya.pratamawijayacommvp.helper.RecyclerItemClickListener;
import com.pratamawijaya.pratamawijayacommvp.models.Post;
import com.pratamawijaya.pratamawijayacommvp.network.NetworkAPI;
import com.pratamawijaya.pratamawijayacommvp.presenters.home.impl.MainPresenterImpl;
import com.pratamawijaya.pratamawijayacommvp.utils.LogUtils;
import com.pratamawijaya.pratamawijayacommvp.views.detail.impl.DetailPostActivity;
import com.pratamawijaya.pratamawijayacommvp.views.home.adapter.HomeAdapter;
import com.pratamawijaya.pratamawijayacommvp.views.home.ifaces.iMainView;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends BaseActivity implements iMainView {

    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    @InjectView(R.id.recyclerView)
    RecyclerView recyclerView;
    @InjectView(R.id.loader)
    ProgressBar loader;

    private MainPresenterImpl presenter;
    private HomeAdapter adapter;
    private NetworkAPI network;
    private List<Post> posts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        network = new NetworkAPI();
        presenter = new MainPresenterImpl(this, network);
        presenter.onCreateView();
        presenter.loadData();

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(
                this,
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View v, int position) {
                        onItemTouch(position);
                    }
                }));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
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
    public void displayData(List<Post> posts) {
        // adapter notifychanged
        this.posts = posts;
        adapter = new HomeAdapter(this, posts);
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);
        LogUtils.Trace("MainActivity", "finish display data");
    }

    @Override
    public void setupView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        LogUtils.Trace("MainActivity", "SetupView done");
    }

    @Override
    public void setupListener() {
        LogUtils.Trace("MainActivity", "SetupListener done");
    }

    @Override
    public void showLoading() {
        recyclerView.setVisibility(View.GONE);
        loader.setVisibility(View.VISIBLE);
        LogUtils.Trace("MainActivity", "show loading");
    }

    @Override
    public void hideLoading() {
        recyclerView.setVisibility(View.VISIBLE);
        loader.setVisibility(View.GONE);
        LogUtils.Trace("MainActivity", "hide loading");
    }

    @Override
    public void onItemTouch(int position) {
        int id = posts.get(position).getId();
        String title = posts.get(position).getTitle();
        startActivity(new Intent(this, DetailPostActivity.class).putExtra("id", id)
                .putExtra("title", title));
    }
}
