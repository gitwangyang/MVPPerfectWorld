package com.dotawang.mvpperfectworld.ui.main.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dotawang.mvpperfectworld.R;
import com.dotawang.mvpperfectworld.utils.custom.dragWidget.DragGridView;
import com.dotawang.mvpperfectworld.utils.custom.dragWidget.DragSortDialog;
import com.dotawang.mvpperfectworld.utils.custom.dragWidget.ItemTitle;
import com.dotawang.mvpperfectworld.utils.custom.dragWidget.ItemTitleDefault;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author DotaWang
 * @date 2019/6/6
 * @description
 */
public class TestTwoFragment extends Fragment implements View.OnClickListener {
    @BindView(R.id.tv_test_two)
    TextView tv;
    @BindView(R.id.drag_view)
    DragGridView gridView;

    Unbinder unbinder;

    private List<ItemTitleDefault> mList = new ArrayList<>();
    public TestTwoFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two_test,container, false);
        unbinder = ButterKnife.bind(this, view);
        initDragView();
        initListener();
        return view;
    }

    private void initDragView() {
        gridView.setHasDrag(true);
        gridView.setItemViews("ABCDEFG".split("\\B"));
        gridView.setColumnCount(3);
        gridView.setTextSize(14);
        Log.i("dota","gridView.getDefaultItems() ======"+gridView.getDefaultItems());
        Log.i("dota","gridView.getSortItems() ======"+gridView.getSortItems());
    }

    private void initListener() {
        tv.setOnClickListener(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public void showDialog(View view) {
        DragSortDialog dialog = new DragSortDialog(getActivity());
        dialog.setTopItemViews("ABCDEFG".split("\\B"));
        dialog.setBottomItemViews("OPQRST".split("\\B"));
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                List<String> list = ((DragSortDialog) dialog).getTopDefaultItemViews();
                for (String s : list) {
                    Log.d("MainActivity", s);
                }
            }
        });
        dialog.show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onClick(View v) {
        showDialog(v);
    }
}
