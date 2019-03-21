package com.dotawang.mvpperfectworld.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.dotawang.mvpperfectworld.app.AppApplication;

/**
 * Created on 2019/3/21
 * Title:本地存储文本信息
 * @author Android-汪洋
 * @Description:
 */
public class SaveValueToShared {
    private static SaveValueToShared instance;
    private static final String spName = "SAAS_sp";
    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;

    public SaveValueToShared(){
        sharedPreferences = AppApplication.getContext().getSharedPreferences(spName, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public static SaveValueToShared getInstance() {
        if (null == instance) {
            synchronized (SaveValueToShared.class) {
                if (null == instance) {
                    instance = new SaveValueToShared();
                }
            }
        }
        return instance;
    }


    public void saveDataToSharedpreference(String key, Boolean value) {
        editor.putBoolean(key, value);
        editor.commit();
    }

    public void saveDataToSharedpreference(String key, String value){
        editor.putString(key, value);
        editor.commit();
    }

    public void saveDataToSharedpreference(String key, int value){
        editor.putInt(key, value);
        editor.commit();
    }

    public void saveDataToSharedpreference(String key, long value){
        editor.putLong(key, value);
        editor.commit();
    }
    public void saveDataToSharedpreference(String key, float value){
        editor.putFloat(key, value);
        editor.commit();
    }

    public Boolean getBooleanValueFromSharedPreference(String key){
        return sharedPreferences.getBoolean(key, false);
    }

    public Boolean getBooleanValueFromSharedPreference(String key,boolean value){
        return sharedPreferences.getBoolean(key, value);
    }

    public String getStringValueFromSharedPreference(String key, String value){
        return sharedPreferences.getString(key, value);
    }

    public int getIntValueFromSharedPreference(String key, int value){
        return sharedPreferences.getInt(key, value);
    }

    public long getLongValueFromSharedPreference(String key, long value){
        return sharedPreferences.getLong(key, value);
    }
    public float getFloatValueFromSharedPreference(String key, float value){
        return sharedPreferences.getFloat(key, value);
    }
}
