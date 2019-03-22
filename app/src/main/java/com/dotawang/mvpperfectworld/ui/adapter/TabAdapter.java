package com.dotawang.mvpperfectworld.ui.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created on 2019/3/22
 * Title:
 * @author Android-汪洋
 * @Description:
 */
public class TabAdapter extends FragmentPagerAdapter {
    private String[] titles;
    private ArrayList<Fragment> mFragment;

    public TabAdapter(FragmentManager fm, ArrayList<Fragment> mFragments, String[] mTitles) {
        super(fm);
        this.mFragment = mFragments;
        this.titles = mTitles;
    }

    @Override
    public int getCount() {
        if (mFragment == null || mFragment.size()<=0) {
            return 0;
        }
        return mFragment.size();
    }

    @Override
    public Fragment getItem(int position) {
        return mFragment.get(position);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
    }
}
