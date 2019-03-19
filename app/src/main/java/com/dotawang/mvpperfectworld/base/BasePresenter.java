package com.dotawang.mvpperfectworld.base;


/**
 * description:presenter基类 bind model和view
 */
public class BasePresenter<V extends IView, M extends IModel> implements  IPresenter<V, M> {

    protected V mView;

    protected M mModel;

    //    获取绑定View实例
    @Override
    public void attachView(V view) {
        this.mView = view;
    }

    //    获取绑定Model层实例
    @Override
    public void attachModel(M m) {
        this.mModel = m;
    }


    public M getModel() {
        return mModel;
    }

    //    注销mModel实例
    @Override
    public void detachModel() {
        this.mModel = null;
    }

    //    注销View实例
    @Override
    public void detachView() {
        this.mView = null;
    }

    public V getView() {
        return mView;
    }

    public boolean isViewBind() {
        return mView != null;
    }


    //    获得抽取接口Model对象
    public Class getModelClazz() {
        return (Class<M>) ContractProxy.getModelClazz(getClass(), 1);

    }

    //    获得抽取接口Model对象
    public void bindModel() {
        ContractProxy.getInstance().bindModel(toString() + getModelClazz(), getModelClazz(), this);
    }

    public void unBindModel() {
        ContractProxy.getInstance().unbindModel(toString() + getModelClazz(), getModelClazz(), this);
    }
}
