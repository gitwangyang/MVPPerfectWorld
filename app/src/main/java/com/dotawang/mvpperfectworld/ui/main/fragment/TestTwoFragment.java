package com.dotawang.mvpperfectworld.ui.main.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dotawang.mvpperfectworld.R;

/**
 * @author DotaWang
 * @date 2019/6/6
 * @description
 */
public class TestTwoFragment extends Fragment {
    public TestTwoFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two_test,container, false);

        return view;
    }
}
