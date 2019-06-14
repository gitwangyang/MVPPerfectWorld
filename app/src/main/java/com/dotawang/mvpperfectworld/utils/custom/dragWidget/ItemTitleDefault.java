package com.dotawang.mvpperfectworld.utils.custom.dragWidget;

/**
 * @author DotaWang
 * @date 2019/6/14
 * @description
 */
public class ItemTitleDefault implements ItemTitle {
    private String mTitle;

    public ItemTitleDefault(String title) {
        mTitle = title;
    }

    public ItemTitleDefault() {
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    @Override
    public String getTitle() {
        return mTitle;
    }
}
