package com.dotawang.mvpperfectworld.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created on 2019/3/19
 * Title:MVP activity的基类
 * @author Android-汪洋
 * @Description:
 */
public abstract class MVPBaseActivity<P extends BasePresenter> extends AppCompatActivity {
    /**
     * 定义Presenter
     */
    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindMVP();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            ContractProxy.getInstance().unbindView(getView(), mPresenter);
            mPresenter.unBindModel();
            ContractProxy.getInstance().unbindPresenter(this.toString() + getPresenterClazz().toString(), mPresenter);
        }
    }

    /**
     * 获取抽取View对象
     */
    protected abstract IView getView();

    /**
     * 获取presenter 实例
     */
    private void bindMVP() {
        if (getPresenterClazz() != null) {
            mPresenter = getPresenterImpl();
            bindVM();
        }
    }

    private void bindVM() {
        if (mPresenter != null && !mPresenter.isViewBind() && getView() != null) {
            ContractProxy.getInstance().bindView(getView(), mPresenter);
            mPresenter.bindModel();
        }
    }

    private <T> T getPresenterImpl() {
        return ContractProxy.getInstance().presenter(toString() + getPresenterClazz().toString(), getPresenterClazz());
    }


    /**
     * 获得抽取接口Presenter对象
     *
     * @return 获取当前Presenter的类对象
     */
    protected Class getPresenterClazz() {
        return (Class<P>) ContractProxy.getPresnterClazz(getClass(), 0);
    }
}
