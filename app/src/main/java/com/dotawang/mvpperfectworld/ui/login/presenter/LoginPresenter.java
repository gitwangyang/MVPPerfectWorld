package com.dotawang.mvpperfectworld.ui.login.presenter;

import com.dotawang.mvpperfectworld.ui.bean.ArticleListBean;
import com.dotawang.mvpperfectworld.ui.login.LoginActivity;
import com.dotawang.mvpperfectworld.ui.login.contract.LoginContract;
import com.dotawang.mvpperfectworld.ui.login.model.LoginModel;
import com.dotawang.mvpperfectworld.utils.StringUtils;

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
    public void dataReceived(ArticleListBean dataMap) {
        if (null!= mView){
            mView.setData(dataMap);
        }
        int s = dataMap.data.curPage;
        if (!StringUtils.isEmpty(s+"")){
            if (null!= mView){
                mView.setSomethingData(s+"");
            }
        }
    }

    @Override
    public void errorReceived(String msg) {

    }
}
