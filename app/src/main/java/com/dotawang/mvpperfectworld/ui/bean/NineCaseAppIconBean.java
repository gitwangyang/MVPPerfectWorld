package com.dotawang.mvpperfectworld.ui.bean;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

/**
 * Created on 2019/3/26
 * Title:
 *
 * @author Android-汪洋
 * @Description:
 */
public class NineCaseAppIconBean implements Serializable {
    private String jumpId;
    private String text;
    private String img;
    private String url;
    private String params;
    private String tagIcon;
    private int status;
    private Drawable localResource;

    public String getJumpId() {
        return jumpId;
    }

    public void setJumpId(String jumpId) {
        this.jumpId = jumpId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getTagIcon() {
        return tagIcon;
    }

    public void setTagIcon(String tagIcon) {
        this.tagIcon = tagIcon;
    }

    public Drawable getLocalResource() {
        return localResource;
    }

    public void setLocalResource(Drawable localResource) {
        this.localResource = localResource;
    }
}
