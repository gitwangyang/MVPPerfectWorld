package com.dotawang.mvpperfectworld.ui.main;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.dotawang.mvpperfectworld.R;
import com.dotawang.mvpperfectworld.base.IView;
import com.dotawang.mvpperfectworld.base.MVPBaseActivity;
import com.dotawang.mvpperfectworld.ui.adapter.TabAdapter;
import com.dotawang.mvpperfectworld.ui.bean.TabEntity;
import com.dotawang.mvpperfectworld.ui.main.contract.MainContract;
import com.dotawang.mvpperfectworld.ui.main.fragment.FindFragment;
import com.dotawang.mvpperfectworld.ui.main.fragment.HomeFragment;
import com.dotawang.mvpperfectworld.ui.main.fragment.MyFragment;
import com.dotawang.mvpperfectworld.ui.main.fragment.ShopCityFragment;
import com.dotawang.mvpperfectworld.utils.ConvertUtils;
import com.dotawang.mvpperfectworld.utils.custom.CanScrollViewPager;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.flyco.tablayout.utils.UnreadMsgUtils;
import com.flyco.tablayout.widget.MsgView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends MVPBaseActivity<MainContract.Presenter> implements MainContract.View {

    @BindView(R.id.vp_main)
    CanScrollViewPager mVpMain;
    @BindView(R.id.tab_layout_main)
    CommonTabLayout mTabLayoutMain;

    private static final String[] mTitles = new String[]{"首页","商城","发现","我的"};
    private int[] mIconUnselectIds = {
            R.drawable.tab_home_unselect, R.drawable.tab_speech_unselect,
            R.drawable.tab_contact_unselect, R.drawable.tab_more_unselect};
    private int[] mIconSelectIds = {
            R.drawable.tab_home_select, R.drawable.tab_speech_select,
            R.drawable.tab_contact_select, R.drawable.tab_more_select};
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private TabAdapter mAdapter;
    private ArrayList<Fragment> mFragments;
    private Fragment homeFragment,shopCityFragment,findFragment,myFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initFragment();
        initListener();
    }

    private void initFragment() {
        mFragments = new ArrayList<>();
        if (null == homeFragment){
            homeFragment = new HomeFragment();
        }
        if (null == shopCityFragment){
            shopCityFragment = new ShopCityFragment();
        }
        if (null == findFragment){
            findFragment = new FindFragment();
        }
        if (null == myFragment){
            myFragment = new MyFragment();
        }
        mFragments.add(homeFragment);
        mFragments.add(shopCityFragment);
        mFragments.add(findFragment);
        mFragments.add(myFragment);

        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }

        if (null == mAdapter){
            mAdapter = new TabAdapter(getSupportFragmentManager(),mFragments,mTitles);
        }

        mVpMain.setAdapter(mAdapter);
        mTabLayoutMain.setTabData(mTabEntities);
        mVpMain.setCurrentItem(0);

        initDot();
    }

    /**
     * 设置红点/角标数量
     */
    private void initDot() {
        mTabLayoutMain.showMsg(0,55);
        mTabLayoutMain.setMsgMargin(0,-5,5);

        mTabLayoutMain.showMsg(1,100);
        mTabLayoutMain.setMsgMargin(1,-5,5);

        mTabLayoutMain.showDot(2);
        MsgView msgView = mTabLayoutMain.getMsgView(2);
        if (null!= msgView){
            UnreadMsgUtils.setSize(msgView, ConvertUtils.dp2px(7.5f));
        }

        mTabLayoutMain.showMsg(3,5);
        mTabLayoutMain.setMsgMargin(3,0,5);
        MsgView msgView2 = mTabLayoutMain.getMsgView(3);
        if (null!= msgView2){
            msgView2.setBackgroundColor(Color.parseColor("#6D8FB0"));
        }
    }

    private void initListener() {
        mVpMain.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mTabLayoutMain.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int position) {

            }
        });

        mTabLayoutMain.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                mVpMain.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        initRequest();
    }

    private void initRequest() {
        if (null!= mPresenter){
            mPresenter.requestMainData();
        }
    }

    @Override
    protected IView getView() {
        return this;
    }

    @Override
    public void setData() {

    }

    @Override
    public void setDataCount(List<Integer> listNum) {

    }
}
