package com.realandylawton.metrodeluxe;

import android.test.AndroidTestCase;

import com.realandylawton.metrodeluxe.mvp.ViewContract;
import com.realandylawton.metrodeluxe.mvp.ViewPresenter;

import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Created by realandylawton on 12/12/14.
 */
public abstract class PresenterTests<C extends ViewContract, P extends ViewPresenter> extends AndroidTestCase {

    private C mContract;
    private P mPresenter;

    public abstract Class<?> getContractClazz();

    @Override
    public void setUp() throws Exception {
        super.setUp();

        // Mock the View Contract so we can verify interactions with it
        mContract = (C)Mockito.mock(getContractClazz());

        // Let's Mockito mock/spy on Android classes
        System.setProperty("dexmaker.dexcache", getContext().getCacheDir().getPath());
        MockitoAnnotations.initMocks(this);

    }

    public C getViewContract() {
        return mContract;
    }

    public P getPresenter() {
        return mPresenter;
    }

    public void setPresenter(P presenter) {
        mPresenter = presenter;
    }
}
