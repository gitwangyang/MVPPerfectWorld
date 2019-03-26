package com.dotawang.mvpperfectworld.ui.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dotawang.mvpperfectworld.R;
import com.dotawang.mvpperfectworld.ui.bean.NineCaseAppIconBean;
import com.dotawang.mvpperfectworld.utils.ToastUtils;
import com.dotawang.mvpperfectworld.utils.custom.AutoScaleTextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created on 2019/3/26
 * Title:
 *
 * @author Android-汪洋
 * @Description:
 */
public class NineCaseAdapter extends BaseAdapter {
    private Context mContext;
    private List<NineCaseAppIconBean> mAppIconBeanList;

    public NineCaseAdapter(Context context, List<NineCaseAppIconBean> list) {
        super();
        this.mContext = context;
        this.mAppIconBeanList = list;
    }

    @Override
    public int getCount() {
        return mAppIconBeanList == null ? 0 : mAppIconBeanList.size();
    }

    @Override
    public NineCaseAppIconBean getItem(int position) {
        return mAppIconBeanList == null || position >= mAppIconBeanList.size() || null == mAppIconBeanList.get(position) ? null : mAppIconBeanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (null == convertView) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.nine_case_gridview_item_home, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        String txt = "";
        Drawable img = null;
        if (null != mAppIconBeanList && position < mAppIconBeanList.size() && null != mAppIconBeanList.get(position)) {
            if (null!= mAppIconBeanList.get(position).getText()){
                txt = mAppIconBeanList.get(position).getText();
            }
            if (null!= mAppIconBeanList.get(position).getLocalResource()){
                img = mAppIconBeanList.get(position).getLocalResource();
            }
        }
        holder.mText.setText(txt);
        if (null!= img){
            holder.mImg.setImageDrawable(img);
        }else {
            holder.mImg.setImageDrawable(mContext.getResources().getDrawable(R.mipmap.ic_launcher));
        }
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClick(position);
            }
        });
        return convertView;
    }

    private void itemClick(int position) {
        //todo  封装到fragment中调用实现跳转，需传递数据position
        ToastUtils.showShort("跳转成功-----"+position);
    }

    class ViewHolder {
        @BindView(R.id.img)
        ImageView mImg;
        @BindView(R.id.text)
        AutoScaleTextView mText;
        @BindView(R.id.tag_icon)
        ImageView mTagIcon;
        @BindView(R.id.icon)
        ImageView mIcon;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
