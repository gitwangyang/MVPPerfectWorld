package com.dotawang.mvpperfectworld.utils.custom;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.dotawang.mvpperfectworld.R;

/**
 * Created on 2019/3/26
 * Title:
 *
 * @author Android-汪洋
 * @Description:
 */
public class SearchEdittext extends LinearLayout implements View.OnClickListener, TextWatcher {

    public interface OnEditTextChange{
        void onValueChange(String s);
    }
    private OnEditTextChange onEditTextChange;
    private EditText et_search_input;
    private ImageView iv_delete;

    public SearchEdittext(Context context) {
        this(context,null);
    }

    public SearchEdittext(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public SearchEdittext(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setOrientation(LinearLayout.VERTICAL);
        setFocusable(true);
        setFocusableInTouchMode(true);
        View searchView = LayoutInflater.from(getContext()).inflate(R.layout.view_search_edittet, this, false);
        et_search_input = searchView.findViewById(R.id.et_search_input);
        iv_delete = searchView.findViewById(R.id.iv_delete);
        et_search_input.addTextChangedListener(this);
        iv_delete.setOnClickListener(this);
        addView(searchView);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.iv_delete:
                et_search_input.setText("");
                iv_delete.setVisibility(GONE);
                break;
            default:
                break;
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (onEditTextChange!=null){
            onEditTextChange.onValueChange(s.toString());
            if (null!= iv_delete){
                iv_delete.setVisibility(VISIBLE);
            }
        }else {
            if (null!= iv_delete){
                iv_delete.setVisibility(GONE);
            }
        }
    }

    @Override
    public void afterTextChanged(Editable s) {
        if (!TextUtils.isEmpty(s.toString())){
            iv_delete.setVisibility(VISIBLE);
        }else {
            iv_delete.setVisibility(GONE);
        }
    }

    public void setOnEditTextChange(OnEditTextChange onEditTextChange) {
        this.onEditTextChange = onEditTextChange;
    }

}
