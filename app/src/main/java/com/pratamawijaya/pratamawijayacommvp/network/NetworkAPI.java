package com.pratamawijaya.pratamawijayacommvp.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pratamawijaya.pratamawijayacommvp.BuildConfig;
import com.squareup.okhttp.OkHttpClient;

import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;

/**
 * Created by pratama on 5/31/15.
 */
public class NetworkAPI {
    private final String WEBSERVICE = "https://pratamawijaya.com/api/";

    private final PratamaService service;

    public NetworkAPI() {
        OkHttpClient httpClient = new OkHttpClient();
        Gson gson = new GsonBuilder().create();

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(WEBSERVICE)
                .setLogLevel(BuildConfig.DEBUG ?
                        RestAdapter.LogLevel.FULL :
                        RestAdapter.LogLevel.NONE)
                .setClient(new OkClient(httpClient))
                .setConverter(new GsonConverter(gson))
                .build();

        service = restAdapter.create(PratamaService.class);
    }

    public PratamaService getService() {
        return service;
    }
}
