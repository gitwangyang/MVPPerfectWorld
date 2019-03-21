package com.dotawang.mvpperfectworld.http;

import com.dotawang.mvpperfectworld.constant.Constant;
import com.dotawang.mvpperfectworld.utils.KLog;
import com.dotawang.mvpperfectworld.utils.interceptor.HeaderInterceptor;
import com.dotawang.mvpperfectworld.utils.interceptor.LogInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created on 2019/3/21
 * Title: 网络请求封装类 Retrofit + OkHttp
 * @author Android-汪洋
 * @Description:
 */
public class NetUtils {
    public static Retrofit retrofit = null;
    //可改变baseurl
    public static Retrofit mRetrofit = null;
    private static int DEFAULT_TIMEOUT = 60;
    private static int DEFAULT_TIMEOUT_WRITE = 60;
    public static OkHttpClient mOkHttpClient;

    private NetUtils() {

    }

    public static OkHttpClient getOkHttpClient() {
        if (mOkHttpClient == null) {
            synchronized (NetUtils.class) {
                try {
                    OkHttpClient.Builder builder = new OkHttpClient.Builder()
                            .addInterceptor(new HeaderInterceptor())
                            .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                            .writeTimeout(DEFAULT_TIMEOUT_WRITE, TimeUnit.SECONDS)
                            .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                            .addNetworkInterceptor(new LogInterceptor())
                            .retryOnConnectionFailure(true);

                    mOkHttpClient = builder.build();

                } catch (Exception e) {
                    e.printStackTrace();
                    KLog.d("Net", "okhttp try catch");
                }
            }
        }
        return mOkHttpClient;
    }

    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            synchronized (NetUtils.class) {
                retrofit = new Retrofit.Builder()
                        .baseUrl(Constant.mBaseUrl)
                        //增加返回值为String的支持
                        .addConverterFactory(ScalarsConverterFactory.create())
                        //增加返回值为Gson的支持(以实体类返回)
                        .addConverterFactory(GsonConverterFactory.create())
                        //增加返回值为Oservable<T>的支持
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .client(getOkHttpClient())
                        .build();
            }
        }
        return retrofit;
    }

    public static Retrofit getRetrofit(String baseUrl) {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                //增加返回值为String的支持
                .addConverterFactory(ScalarsConverterFactory.create())
                //增加返回值为Gson的支持(以实体类返回)
                .addConverterFactory(GsonConverterFactory.create())
                //增加返回值为Oservable<T>的支持
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(getOkHttpClient())
                .build();
        return mRetrofit;
    }
}
