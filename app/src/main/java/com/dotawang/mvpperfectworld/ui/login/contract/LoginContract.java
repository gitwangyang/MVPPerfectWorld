package com.dotawang.mvpperfectworld.ui.login.contract;

import com.dotawang.mvpperfectworld.base.BasePresenter;
import com.dotawang.mvpperfectworld.base.IModel;
import com.dotawang.mvpperfectworld.base.IView;
import com.dotawang.mvpperfectworld.ui.bean.ArticleListBean;

import java.util.Map;

/**
 * Created on 2019/3/19
 * Title:
 * @author Android-汪洋
 * @Description:
 */
public interface LoginContract {
    interface View extends IView{
        /**
         * 更新数据
         */
        void setData(ArticleListBean dataMap);

        /**
         * 针对某一控件的局部刷新数据
         */
        void setSomethingData(String msg);
    }

    interface Model extends IModel{
        /**
         * 请求数据
         */
        void requestData();

        /**
         * 设置请求数据的回调
         */
        void setDataReceivedCallback(OnDataCallback onDataCallback);

        interface OnDataCallback{
            /**
             * 返回数据
             */
            void dataReceived(ArticleListBean data);

            /**
             * 返回失败
             */
            void errorReceived(String msg);
        }
    }

    abstract class Presenter<V extends LoginContract.View,M extends LoginContract.Model> extends BasePresenter<V, M>{
        public abstract void requestLoginData();
    }
}
