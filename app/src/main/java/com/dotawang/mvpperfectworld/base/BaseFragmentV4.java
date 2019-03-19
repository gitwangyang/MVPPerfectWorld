package com.dotawang.mvpperfectworld.base;


import android.support.v4.app.Fragment;


/**
 * 不需要懒加载的Fragment 继承该类
 * description:工程主要基类,主要逻辑fragment必须继承该BaseFragment方便管理
 * 重写getLayoutId()传入layoutId即可初始布局
 */
public abstract class BaseFragmentV4<P extends BasePresenter> extends Fragment {
    //    定义Presenter
    private P mPresenter;
    private String mName;

    public BaseFragmentV4() {
    }

    @Override
    public void onDetach() {
        unbind();
        super.onDetach();
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    protected P getPresenter() {
        if (mPresenter == null) {
            bindPresenter();
        } else {
        }
        return mPresenter;
    }

    //   获取抽取View对象
    protected abstract IView getViewImp();


    //    获得抽取接口Presenter对象
    protected Class getPresenterClazz() {
        return (Class<P>) ContractProxy.getPresnterClazz(getClass(), 0);
    }

    /**
     * 获取presenter 实例
     */
    private void bindPresenter() {
        if (null == mPresenter && getPresenterClazz() != null) {
            mPresenter = getPresenterImpl();
            presenterBindVM();
        }
    }

    /**
     * 获取 Presenter实例
     */
    private <T> T getPresenterImpl() {
        return ContractProxy.getInstance().presenter(toString() + getPresenterClazz(), getPresenterClazz());
    }

    /**
     * 绑定VM
     */
    private void presenterBindVM() {
        if (mPresenter != null && !mPresenter.isViewBind() && mPresenter.getModelClazz() != null && getViewImp() != null) {
            mPresenter.bindModel();
            ContractProxy.getInstance().bindView(getViewImp(), mPresenter);
        }
    }

    /**
     * 解除绑定
     */
    private void unbind() {
        if (mPresenter != null) {
            ContractProxy.getInstance().unbindView(getViewImp(), mPresenter);
            mPresenter.unBindModel();
            ContractProxy.getInstance().unbindPresenter(this.toString() + getPresenterClazz().toString(), mPresenter);
            mPresenter = null;
        }
    }

    public boolean onBackPressed() {
        return false;
    }

}
