package com.dotawang.mvpperfectworld.ui.main.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dotawang.mvpperfectworld.R;
import com.dotawang.mvpperfectworld.ui.adapter.TabAdapter;
import com.dotawang.mvpperfectworld.ui.bean.TabEntity;
import com.flyco.tablayout.SlidingTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class FindFragment extends Fragment {

    @BindView(R.id.explore_tab_layout)
    SlidingTabLayout tabLayout;
    @BindView(R.id.view_pager)
    ViewPager vpMain;
    @BindView(R.id.app_barlayout)
    AppBarLayout appBarlayout;
    private static final String[] mTitles = new String[]{"首页11","商城11"};
    private TabAdapter mAdapter;
    private ArrayList<Fragment> mFragments;
    Unbinder unbinder;
    private Fragment testOneFragment,testTwoFragment;

    public FindFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_find, container, false);
        unbinder = ButterKnife.bind(this, view);
        initFragment();
        initListener();
        return view;
    }

    private void initListener() {

    }

    private void initFragment() {
        if (mFragments == null){
            mFragments = new ArrayList<>();
        }else {
            mFragments.clear();
        }
        if (testOneFragment == null){
            testOneFragment = new TestOneFragment();
        }
        if (testTwoFragment == null){
            testTwoFragment = new TestTwoFragment();
        }
        mFragments.add(testOneFragment);
        mFragments.add(testTwoFragment);

        if (null == mAdapter){
            mAdapter = new TabAdapter(getChildFragmentManager(),mFragments,mTitles);
        }
        vpMain.setAdapter(mAdapter);
        tabLayout.setViewPager(vpMain,mTitles);
        vpMain.setCurrentItem(0);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}
