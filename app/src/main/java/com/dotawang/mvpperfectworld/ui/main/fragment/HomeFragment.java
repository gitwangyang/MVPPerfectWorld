package com.dotawang.mvpperfectworld.ui.main.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dotawang.mvpperfectworld.R;
import com.dotawang.mvpperfectworld.utils.ToastUtils;
import com.dotawang.mvpperfectworld.utils.custom.BannerIndicator;
import com.dotawang.mvpperfectworld.utils.custom.NewsViewFlipper;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    @BindView(R.id.vPager)
    Banner mVPager;
    @BindView(R.id.item_notice_num)
    BannerIndicator mItemNoticeNum;
    @BindView(R.id.vf_content)
    NewsViewFlipper mVfContent;
    @BindView(R.id.tvMore_notice)
    TextView mTvMoreNotice;
    Unbinder unbinder;

    private String url[] = {"http://n.sinaimg.cn/games/3c3de2ce/20160105/3.jpg","http://img4.duitang.com/uploads/item/201402/14/20140214120558_2f4NN.jpeg","http://s9.knowsky.com/bizhi/l/20090808/200911053%20%2838%29.jpg"};
    public HomeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this, view);
        initBanner();
        return view;
    }

    private void initBanner() {
        mVPager.setImages(Arrays.asList(url))
               .setBannerStyle(BannerConfig.NOT_INDICATOR)
               .setImageLoader(new ImageLoader() {
                   @Override
                   public void displayImage(Context context, Object path, ImageView imageView) {
                       Glide.with(context.getApplicationContext())
                               .load(path)
                               .into(imageView);
                   }
               }).setDelayTime(4000)
                .start();
        mItemNoticeNum.setUpWithViewPager(mVPager,url.length);
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
        if (null!= mVPager){
            mVPager.startAutoPlay();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (null!= mVPager){
            mVPager.stopAutoPlay();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
