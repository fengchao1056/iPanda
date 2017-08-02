package com.example.a123.pandatv.model.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/7/28.
 */

public class LiveChinasBean implements Serializable {

    private List<LiveBean> live;

    public List<LiveBean> getLive() {
        return live;
    }

    public void setLive(List<LiveBean> live) {
        this.live = live;
    }

    public static class LiveBean implements Serializable{
        /**
         * title : 八达岭南四楼
         * brief : 八达岭长城位于北京市西北六十公里处，被评为中国旅游胜地四十家之首和北京旅游“世界之最”。因其机构严谨科学，虽经历五百多年的历史风烟，至今仍巍然屹立，足以说明古代汉族劳动人民在建筑科学和艺术上的卓越才能。
         * image : http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2015/12/28/1451290603994_440.jpg
         * id : bgws4
         * order : 1
         */

        private String title;
        private String brief;
        private String image;
        private String id;
        private String order;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getBrief() {
            return brief;
        }

        public void setBrief(String brief) {
            this.brief = brief;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }
    }
}
