package com.pratamawijaya.pratamawijayacommvp.presenters.home;

import com.pratamawijaya.pratamawijayacommvp.views.home.ifaces.iMainView;

import junit.framework.TestCase;

/**
 * Created by pratama on 6/1/15.
 */
public class MainPresenterTest extends TestCase {

    MainPresenter presenter;
    iMainView view;

    public void setUp() throws Exception {
        super.setUp();
        presenter = new MainPresenter();
    }

    public void testCount() throws Exception {
        assertEquals(2, presenter.count(1, 1));
    }
}