package com.dotawang.mvpperfectworld.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
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

    private ArrayList<Activity> activityList = new ArrayList<Activity>();

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
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
}
