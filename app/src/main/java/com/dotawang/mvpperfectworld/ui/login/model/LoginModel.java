package com.dotawang.mvpperfectworld.ui.login.model;

import android.os.Handler;
import android.os.Message;

import com.dotawang.mvpperfectworld.ui.login.contract.LoginContract;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on 2019/3/19
 * Title:
 *
 * @author Android-汪洋
 * @Description:
 */
public class LoginModel implements LoginContract.Model{

    private OnDataCallback mOnDataCallback;
    Map<String,String> data = new HashMap<>();
    @Override
    public void requestData() {
        data.clear();
        //okhttp请求
    }

    @Override
    public void setDataReceivedCallback(OnDataCallback onDataCallback) {
        this.mOnDataCallback = onDataCallback;
    }

    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            //todo  数据处理
            data.put("1","跪拜");
            data.put("2","服气");
            data.put("1","你牛");
            if (null!= mOnDataCallback){
                mOnDataCallback.dataReceived(data);
            }
        }

        //handler需要调整为AcyTask
    };
}
