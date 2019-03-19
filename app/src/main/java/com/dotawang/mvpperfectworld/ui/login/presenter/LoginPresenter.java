package com.dotawang.mvpperfectworld.ui.login.presenter;

import com.dotawang.mvpperfectworld.ui.login.LoginActivity;
import com.dotawang.mvpperfectworld.ui.login.contract.LoginContract;
import com.dotawang.mvpperfectworld.ui.login.model.LoginModel;

import java.util.Map;

/**
 * Created on 2019/3/19
 * Title:
 *
 * @author Android-汪洋
 * @Description:
 */
public class LoginPresenter extends LoginContract.Presenter<LoginActivity,LoginModel> implements LoginContract.Model.OnDataCallback{
    @Override
    public void requestLoginData() {
        if (null!= mModel){
            mModel.setDataReceivedCallback(this);
            mModel.requestData();
        }
    }

    @Override
    public void dataReceived(Map<String, String> dataMap) {
        if (null!= mView){
            mView.setData(dataMap);
        }
        String s = dataMap.get("2");
        if (null!= s){
            if (null!= mView){
                mView.setSomethingData(s);
            }
        }
    }
}
