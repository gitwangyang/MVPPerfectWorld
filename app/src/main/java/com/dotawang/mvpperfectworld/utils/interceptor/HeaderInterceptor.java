package com.dotawang.mvpperfectworld.utils.interceptor;

import com.dotawang.mvpperfectworld.app.AppApplication;
import com.dotawang.mvpperfectworld.constant.Constant;
import com.dotawang.mvpperfectworld.constant.UserInfo;
import com.dotawang.mvpperfectworld.utils.DeviceUuidFactory;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * Created on 2019/3/21
 * Title: 头信息
 * @author Android-汪洋
 * @Description:
 */
public class HeaderInterceptor implements Interceptor{

    @Override
    public Response intercept(Chain chain) throws IOException {
        okhttp3.Request request = chain.request().newBuilder()
                .addHeader(Constant.USER_AGENT, Constant.USER_AGENT_VALUE)
                .addHeader(Constant.IMEI, DeviceUuidFactory.getUUID(AppApplication.getContext()))
                .addHeader(Constant.TOKEN, UserInfo.getInstance(AppApplication.getContext()).getToken())
                .addHeader(Constant.MEMBER_ID, UserInfo.getInstance(AppApplication.getContext()).getMemberid())
                .build();
        return chain.proceed(request);
    }
}
