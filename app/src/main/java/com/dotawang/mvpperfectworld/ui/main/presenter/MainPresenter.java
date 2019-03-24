package com.dotawang.mvpperfectworld.ui.main.presenter;

import com.dotawang.mvpperfectworld.ui.main.MainActivity;
import com.dotawang.mvpperfectworld.ui.main.contract.MainContract;
import com.dotawang.mvpperfectworld.ui.main.model.MainModel;

import java.util.List;

/**
 * Created on 2019/3/22
 * Title:
 *
 * @author Android-汪洋
 * @Description:
 */
public class MainPresenter extends MainContract.Presenter<MainActivity, MainModel> implements MainContract.Model.OnMainDataCallback {
    @Override
    public void onSuccess(List<Integer> listNum) {
        if (null != mView) {
            mView.setData();
            mView.setDataCount(listNum);
        }
    }

    @Override
    public void onFailure() {

    }

    @Override
    public void requestMainData() {
        if (null != mModel) {
            mModel.setOnMainDataCallback(this);
            mModel.requestData();
        }
    }
}
