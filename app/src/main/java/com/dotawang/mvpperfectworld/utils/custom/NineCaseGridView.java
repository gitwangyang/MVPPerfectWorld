package com.dotawang.mvpperfectworld.utils.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created on 2019/3/26
 * Title:
 *
 * @author Android-汪洋
 * @Description:
 */
public class NineCaseGridView extends GridView {
    public NineCaseGridView(Context context) {
        super(context);
    }

    public NineCaseGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NineCaseGridView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
