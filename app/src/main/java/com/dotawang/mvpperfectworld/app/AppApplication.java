package com.dotawang.mvpperfectworld.app;

import android.app.Activity;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.dotawang.mvpperfectworld.base.BaseApplication;

import java.util.ArrayList;

/**
 * Created on 2019/3/19
 * Title:
 *
 * @author Android-汪洋
 * @Description:
 */
public class AppApplication extends BaseApplication {
    public static AppApplication instance;
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        mContext = getApplicationContext();
    }

    /**
     * 分包
     * @param base
     */
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    public static AppApplication getInstance(){
        return instance;
    }

    public static Context getContext(){
        return mContext;
    }
}
