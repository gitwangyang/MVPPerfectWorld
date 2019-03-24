package com.dotawang.mvpperfectworld.ui.main.model;

import com.dotawang.mvpperfectworld.api.ApiService;
import com.dotawang.mvpperfectworld.http.NetUtils;
import com.dotawang.mvpperfectworld.ui.bean.HomeBean;
import com.dotawang.mvpperfectworld.ui.main.contract.HomeContract;
import com.dotawang.mvpperfectworld.utils.KLog;
import com.dotawang.mvpperfectworld.utils.ToastUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.Subject;

/**
 * @author Dota.Wang
 * @date 2019/3/24
 * @description
 */

public class HomeModel implements HomeContract.Model {

    private OnHomeDataCallback mOnHomeDataCallback;

    @Override
    public void requestData() {
        NetUtils.getRetrofit("http://api.shiandianping.com")
                .create(ApiService.class)
                .getBannerData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subject<HomeBean>() {
                    @Override
                    public boolean hasObservers() {
                        return false;
                    }

                    @Override
                    public boolean hasThrowable() {
                        return false;
                    }

                    @Override
                    public boolean hasComplete() {
                        return false;
                    }

                    @Override
                    public Throwable getThrowable() {
                        return null;
                    }

                    @Override
                    protected void subscribeActual(Observer<? super HomeBean> observer) {
                    }

                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(HomeBean homeBean) {
                        if (null == homeBean) {
                            mOnHomeDataCallback.onFailure("数据为空");
                        } else if (homeBean.getStatus() != 1) {
                            mOnHomeDataCallback.onFailure("请求数据失败");
                        } else {
                            mOnHomeDataCallback.onSuccess(homeBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        ToastUtils.showShort("数据获取失败，请重试");
                        KLog.d("数据获取失败，请重试");
                    }

                    @Override
                    public void onComplete() {
                        KLog.d("complete");
                    }
                });
    }

    public void setOnHomeDataCallback(OnHomeDataCallback onHomeDataCallback) {
        this.mOnHomeDataCallback = onHomeDataCallback;
    }
}
