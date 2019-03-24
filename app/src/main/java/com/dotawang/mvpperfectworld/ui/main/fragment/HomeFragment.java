package com.dotawang.mvpperfectworld.ui.main.fragment;


import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.dotawang.mvpperfectworld.R;
import com.dotawang.mvpperfectworld.base.BaseFragmentV4;
import com.dotawang.mvpperfectworld.base.IView;
import com.dotawang.mvpperfectworld.ui.bean.HomeBean;
import com.dotawang.mvpperfectworld.ui.main.contract.HomeContract;
import com.dotawang.mvpperfectworld.ui.main.presenter.HomePresenter;
import com.dotawang.mvpperfectworld.utils.ToastUtils;
import com.dotawang.mvpperfectworld.utils.custom.BannerIndicator;
import com.dotawang.mvpperfectworld.utils.custom.NewsViewFlipper;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragmentV4<HomePresenter> implements HomeContract.View {

    @BindView(R.id.vPager)
    Banner mVPager;
    @BindView(R.id.item_notice_num)
    BannerIndicator mItemNoticeNum;
    @BindView(R.id.vf_content)
    NewsViewFlipper mVfContent;
    @BindView(R.id.tvMore_notice)
    TextView mTvMoreNotice;
    Unbinder unbinder;
    private List<HomeBean.DataBean> bannerDataList = new ArrayList<>();
    private List<String> bannerUrlList = new ArrayList<>();

    public HomeFragment() {
    }

    @Override
    protected IView getViewImp() {
        return this;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this, view);
        initRequest();
        return view;
    }

    private void initRequest() {
        if (null != getPresenter()) {
            getPresenter().requestHomeData();
        }
    }

    private void initBanner() {
        mVPager
                .setImages(bannerUrlList)
                .setBannerStyle(BannerConfig.NOT_INDICATOR)
                .setImageLoader(new ImageLoader() {
                    @Override
                    public void displayImage(Context context, Object path, ImageView imageView) {
                        Glide.with(context.getApplicationContext())
                                .load(bannerUrlList)
                                .load(path)
                                .apply(new RequestOptions().error(R.drawable.dialog_loading_icon))
                                .into(imageView);
                    }
                }).setDelayTime(4000)
                .start();
        mItemNoticeNum.setUpWithViewPager(mVPager, bannerUrlList.size());
        mVPager.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int i) {
                ToastUtils.showShort("banner 被点击了");
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        if (null != mVPager) {
            mVPager.startAutoPlay();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (null != mVPager) {
            mVPager.stopAutoPlay();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void setBannerData(HomeBean homeBean) {
        if (null != homeBean) {
            if (null != homeBean.getData() && homeBean.getData().size() > 0) {
                bannerDataList.addAll(homeBean.getData());
                for (int i = 0; i < bannerDataList.size(); i++) {
                    bannerUrlList.add(bannerDataList.get(i).getUrl());
                }
            }
        }
        initBanner();
    }

    @Override
    public void setNoticeData(HomeBean homeBean) {

    }
}
