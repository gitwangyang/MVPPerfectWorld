package com.dotawang.mvpperfectworld.api;

import com.dotawang.mvpperfectworld.ui.bean.ArticleListBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created on 2019/3/19
 * Title:接口管理
 * @author Android-汪洋
 * @Description:
 */
public interface ApiService {
    /**
     * wanandroid 首页文章列表
     * @param curPage 当前第几页
     * @return
     */
    @GET("article/list/{curPage}/json")
    Observable<ArticleListBean> getData(@Path("curPage") int curPage);

    /**
     * 登录信息
     * @return
     */
    @GET
    Observable<ArticleListBean> getLoginData();
}
