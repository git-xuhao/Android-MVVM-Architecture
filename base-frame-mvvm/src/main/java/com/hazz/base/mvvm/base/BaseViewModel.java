package com.hazz.base.mvvm.base;

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableBoolean;

import com.hazz.base.mvvm.rx.SchedulerProvider;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by xuhao on 2017/12/24.
 * desc: 基类 BaseViewModel
 */

public abstract class BaseViewModel<V> extends ViewModel{

    private V mRootView;
    private SchedulerProvider mSchedulerProvider;
    private ObservableBoolean mIsLoading = new ObservableBoolean(false);

    private CompositeDisposable mCompositeDisposable;

    protected BaseViewModel(SchedulerProvider mSchedulerProvider) {
        this.mSchedulerProvider = mSchedulerProvider;
        this.mCompositeDisposable = new CompositeDisposable() ;
    }


    public V getRootView() {
        return mRootView;
    }

    public void setRootView(V mRootView) {
        this.mRootView = mRootView;
    }

    public SchedulerProvider getSchedulerProvider() {
        return mSchedulerProvider;
    }

    public CompositeDisposable getCompositeDisposable() {
        return mCompositeDisposable;
    }


    public ObservableBoolean getIsLoading() {
        return mIsLoading;
    }

    public void setIsLoading(ObservableBoolean mIsLoading) {
        this.mIsLoading = mIsLoading;
    }

    @Override
    protected void onCleared() {
        mCompositeDisposable.dispose();
        super.onCleared();
    }
}
