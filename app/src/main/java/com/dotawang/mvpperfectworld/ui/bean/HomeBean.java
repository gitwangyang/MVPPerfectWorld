package com.dotawang.mvpperfectworld.ui.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @author Dota.Wang
 * @date 2019/3/24
 * @description 暂时只有轮播图的数据，后续扩展
 */

public class HomeBean implements Serializable{

    /**
     * Status : 1
     * Mssage : 成功
     * RealTime : 2019-03-24 12:21:07
     * Data : [{"Url":"https://shianyun-oss.oss-cn-beijing.aliyuncs.com/uploads/AppBanner/20161028_1.png","PageUrl":"http://www.shiandianping.com/Process/Food","PageTitle":"食安定制食品制作流程","PageDescribe":"食安定制食品制作流程"},{"Url":"https://shianyun-oss.oss-cn-beijing.aliyuncs.com/uploads/AppBanner/20161028_2.png","PageUrl":"http://www.shiandianping.com/Process/Placeorder","PageTitle":"手指一松，轻轻下单","PageDescribe":" "},{"Url":"https://shianyun-oss.oss-cn-beijing.aliyuncs.com/uploads/AppBanner/20161028_3.jpg","PageUrl":"http://www.shiandianping.com/Process/BostenLake","PageTitle":"美丽的博斯腾湖","PageDescribe":"跟着食安去旅行，探索美丽的博斯腾湖"}]
     */

    private int Status;
    private String Mssage;
    private String RealTime;
    private List<DataBean> Data;

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    public String getMssage() {
        return Mssage;
    }

    public void setMssage(String Mssage) {
        this.Mssage = Mssage;
    }

    public String getRealTime() {
        return RealTime;
    }

    public void setRealTime(String RealTime) {
        this.RealTime = RealTime;
    }

    public List<DataBean> getData() {
        return Data;
    }

    public void setData(List<DataBean> Data) {
        this.Data = Data;
    }

    public static class DataBean {
        /**
         * Url : https://shianyun-oss.oss-cn-beijing.aliyuncs.com/uploads/AppBanner/20161028_1.png
         * PageUrl : http://www.shiandianping.com/Process/Food
         * PageTitle : 食安定制食品制作流程
         * PageDescribe : 食安定制食品制作流程
         */

        private String Url;
        private String PageUrl;
        private String PageTitle;
        private String PageDescribe;

        public String getUrl() {
            return Url;
        }

        public void setUrl(String Url) {
            this.Url = Url;
        }

        public String getPageUrl() {
            return PageUrl;
        }

        public void setPageUrl(String PageUrl) {
            this.PageUrl = PageUrl;
        }

        public String getPageTitle() {
            return PageTitle;
        }

        public void setPageTitle(String PageTitle) {
            this.PageTitle = PageTitle;
        }

        public String getPageDescribe() {
            return PageDescribe;
        }

        public void setPageDescribe(String PageDescribe) {
            this.PageDescribe = PageDescribe;
        }
    }
}
