package com.pratamawijaya.pratamawijayacommvp.base;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.pratamawijaya.pratamawijayacommvp.R;

/**
 * Created by pratama on 5/30/15.
 */
public class BaseActivity extends AppCompatActivity {
    private Toolbar toolbar;

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        getToolbar();
    }

    protected Toolbar getToolbar() {
        if (toolbar == null) {
            toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
        }
        return toolbar;
    }
}
