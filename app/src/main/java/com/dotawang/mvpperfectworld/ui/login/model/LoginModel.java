package com.dotawang.mvpperfectworld.ui.login.model;

import android.os.Handler;
import android.os.Message;

import com.dotawang.mvpperfectworld.api.ApiService;
import com.dotawang.mvpperfectworld.http.NetUtils;
import com.dotawang.mvpperfectworld.ui.bean.ArticleListBean;
import com.dotawang.mvpperfectworld.ui.login.contract.LoginContract;
import com.dotawang.mvpperfectworld.utils.KLog;
import com.dotawang.mvpperfectworld.utils.ToastUtils;

import org.reactivestreams.Subscriber;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.Subject;


/**
 * Created on 2019/3/19
 * Title:
 * @author Android-汪洋
 * @Description:
 */
public class LoginModel implements LoginContract.Model{

    private OnDataCallback mOnDataCallback;

    @Override
    public void requestData() {
        NetUtils.getRetrofit()
                .create(ApiService.class)
//                .getLoginData()//todo  调试用下面的接口，实际调用上面这个接口
                .getData(0)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subject<ArticleListBean>() {
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
                    protected void subscribeActual(Observer<? super ArticleListBean> observer) {
                    }

                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(ArticleListBean articleListBean) {
                        if (null == articleListBean){
                            mOnDataCallback.errorReceived("数据为空");
                        }else if (articleListBean.errorCode!= 0){
                            mOnDataCallback.errorReceived(articleListBean.errorMsg);
                        }else {
                            mOnDataCallback.dataReceived(articleListBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        ToastUtils.showShort("登录失败，请重新登录");
                        KLog.d("登录失败，请重新登录");
                    }

                    @Override
                    public void onComplete() {
                        KLog.d("complete");
                    }
                });
    }

    @Override
    public void setDataReceivedCallback(OnDataCallback onDataCallback) {
        this.mOnDataCallback = onDataCallback;
    }
}
