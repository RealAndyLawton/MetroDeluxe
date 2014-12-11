package com.realandylawton.metrodeluxe.mvp;

/**
 * Created by realandylawton on 12/11/14.
 */
public abstract class ViewPresenter<T extends ViewContract> {

    protected T mView;

    public abstract Class<T> getPresenterContractClazz();

    public void takeView(T view) {
        mView = view;
    }

    public void dropView() {
        final T stubContractInstance = createStubContractInstance();
        if(stubContractInstance == null) {
            // We had a problem making the stub, so keep the View reference around--it's better to leak than crash
            return;
        }
        mView = stubContractInstance;
    }

    private T createStubContractInstance() {
        final Class<T> presenterContractClazz = getPresenterContractClazz();
        T contractInstance = null;
        try {
            contractInstance = presenterContractClazz.newInstance();
        } catch (Exception e) {
            // Failed to create instance
        }
        return contractInstance;
    }

    public T getView() {
        return mView;
    }

}
