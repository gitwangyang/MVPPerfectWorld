package com.dotawang.mvpperfectworld.ui.main.model;

import com.dotawang.mvpperfectworld.ui.main.contract.MainContract;

/**
 * Created on 2019/3/22
 * Title:
 * @author Android-汪洋
 * @Description:
 */
public class MainModel implements MainContract.Model{

    private OnMainDataCallback mOnMainDataCallback;
    @Override
    public void requestData() {

    }

    @Override
    public void onDataCallBack(OnMainDataCallback onMainDataCallback) {

    }

    public void setOnMainDataCallback(OnMainDataCallback onMainDataCallback){
        this.mOnMainDataCallback = onMainDataCallback;
    }
}
