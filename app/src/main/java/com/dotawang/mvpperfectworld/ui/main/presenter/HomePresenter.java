package com.dotawang.mvpperfectworld.ui.main.presenter;

import com.dotawang.mvpperfectworld.ui.bean.HomeBean;
import com.dotawang.mvpperfectworld.ui.main.contract.HomeContract;
import com.dotawang.mvpperfectworld.ui.main.fragment.HomeFragment;
import com.dotawang.mvpperfectworld.ui.main.model.HomeModel;

/**
 * @author Dota.Wang
 * @date 2019/3/24
 * @description
 */

public class HomePresenter extends HomeContract.Presenter<HomeFragment, HomeModel> implements HomeContract.Model.OnHomeDataCallback {
    @Override
    public void onSuccess(HomeBean homeBean) {
        if (null != mView) {
            mView.setBannerData(homeBean);
//            mView.setNoticeData(homeBean);
        }
    }

    @Override
    public void onFailure(String errorMsg) {

    }

    @Override
    public void requestHomeData() {
        if (null != mModel) {
            mModel.setOnHomeDataCallback(this);
            mModel.requestData();
        }
    }
}
