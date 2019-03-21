package com.dotawang.mvpperfectworld.constant;

import android.os.Environment;

import com.dotawang.mvpperfectworld.utils.KLog;

import java.io.File;

/**
 * Created on 2019/3/21
 * Title: 常量
 * @author Android-汪洋
 * @Description:
 */
public class Constant {

    /**
     * baseUrl
     */
    public static String mBaseUrl = "http://www.wanandroid.com";
    /**
     * 文件存储路径
     */
    public static String basePath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/";
    /**
     * 文件分隔符
     */
    public static String SAVE_IMAGE_PATH = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separatorChar;

    /**
     * 服务端接口版本号
     */
    public static String serviceVersion = "v1";

    /**
     * 正式/测试环境
     */
    static {
        if (KLog.IS_SHOW_LOG){
            //调试模式
            mBaseUrl =  "http://www.wanandroid.com";
        }else {
            //正式环境
            mBaseUrl =  "http://www.wanandroid.com";
        }
    }
    /**
     * 请求头信息
     */
    public static final String USER_AGENT = "User-Agent";
    public static final String IMEI = "imei";
    public static final String TOKEN = "token";
    public static final String MEMBER_ID = "memberId";
    public static String USER_AGENT_VALUE = "1fy8LLuCLgc=";

    /**
     * 接口返回参数
     */
    public static final String NULL_RESPONSE = "";
    public static final String FAILURE_RESPONSE = "0";  //请求失败
    public static final String SUCCESS_RESPONSE = "1";  //请求成功
    public static final String KEEP_KEY_RESPONSE = "2"; //账号锁定

    /**
     * 用户信息保存key值
     */
    public static final String SHARED_PRENFENCE_MEMBERID = "saas_memberid";
    public static final String SHARED_PRENFENCE_LOGINID = "saas_loginid";
    public static final String SHARED_PRENFENCE_ACCOUNT = "saas_account";
    public static final String SHARED_PRENFENCE_PASSWORD = "saas_password";
    public static final String SHARED_PRENFENCE_EMAIL = "saas_email";
    public static final String SHARED_PRENFENCE_PHONE = "saas_phone";
    public static final String SHARED_PRENFENCE_USERNAME = "saas_username";
    public static final String SHARED_PRENFENCE_TOKEN = "saas_token";
    public static final String SHARED_PRENFENCE_POINTS = "saas_points";
}
