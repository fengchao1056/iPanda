package com.example.a123.pandatv.model.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/7/28.
 */

public class LiveChinaTitleBean implements Serializable{

    private List<TablistBean> tablist;
    private List<AlllistBean> alllist;

    public List<TablistBean> getTablist() {
        return tablist;
    }

    public void setTablist(List<TablistBean> tablist) {
        this.tablist = tablist;
    }

    public List<AlllistBean> getAlllist() {
        return alllist;
    }

    public void setAlllist(List<AlllistBean> alllist) {
        this.alllist = alllist;
    }

    public static class TablistBean implements Serializable{
        /**
         * title : 八达岭
         * url : http://www.ipanda.com/kehuduan/liebiao/badaling/index.json
         * type :
         * order : 1
         */

        private String title;
        private String url;
        private String type;
        private String order;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }
    }

    public static class AlllistBean implements Serializable{
        /**
         * title : 凤凰古城
         * url : http://www.ipanda.com/kehuduan/liebiao/fenghuanggucheng/index.json
         * type :
         * order : 1
         */

        private String title;
        private String url;
        private String type;
        private String order;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }
    }
}
