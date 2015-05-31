package com.pratamawijaya.pratamawijayacommvp.utils;

import android.util.Log;

import com.pratamawijaya.pratamawijayacommvp.BuildConfig;

/**
 * Created by pratama on 5/31/15.
 */
public class LogUtils {
    public static void Trace(String tag, String msg) {
        if (BuildConfig.DEBUG)
            Log.d(tag, msg);
    }
}
