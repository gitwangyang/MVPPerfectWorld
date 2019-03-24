package com.dotawang.mvpperfectworld.ui.main.contract;

import com.dotawang.mvpperfectworld.base.BasePresenter;
import com.dotawang.mvpperfectworld.base.IModel;
import com.dotawang.mvpperfectworld.base.IView;
import com.dotawang.mvpperfectworld.ui.bean.HomeBean;

/**
 * @author Dota.Wang
 * @date 2019/3/24
 * @description
 */

public interface HomeContract {

    interface View extends IView {
        /**
         * 设置轮播图数据
         * @param homeBean
         */
        void setBannerData(HomeBean homeBean);

        /**
         * 设置公告数据
         * @param homeBean
         */
        void setNoticeData(HomeBean homeBean);
    }

    interface Model extends IModel {
        void requestData();

        void setOnHomeDataCallback(OnHomeDataCallback onHomeDataCallback);

        interface OnHomeDataCallback{
            void onSuccess(HomeBean homeBean);

            void onFailure(String errorMsg);
        }
    }

    abstract class Presenter<V extends HomeContract.View,M extends HomeContract.Model> extends BasePresenter<V,M> {
        public abstract void requestHomeData();
    }

}
