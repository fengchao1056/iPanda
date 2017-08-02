package com.example.a123.pandatv.model.entity;


import java.io.Serializable;
import java.util.List;

public class PandaBoadCastBean implements Serializable {

    private List<BigImgBean> bigImg;
    private List<ListBean> list;

    public List<BigImgBean> getBigImg() {
        return bigImg;
    }

    public void setBigImg(List<BigImgBean> bigImg) {
        this.bigImg = bigImg;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class BigImgBean implements Serializable{
        /**
         * id : ARTILBLSMq3qlVgygrUMJEG2170523
         * image : http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2017/5/23/1495533604076_403.jpg
         * order : 1
         * pid :
         * stype :
         * title : 一碗简单的热干面，吃的也是仪式感
         * type : 5
         * url : http://culture.ipanda.com/2017/05/23/ARTILBLSMq3qlVgygrUMJEG2170523.shtml
         * vid :
         */

        private String id;
        private String image;
        private String order;
        private String pid;
        private String stype;
        private String title;
        private String type;
        private String url;
        private String vid;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }

        public String getPid() {
            return pid;
        }

        public void setPid(String pid) {
            this.pid = pid;
        }

        public String getStype() {
            return stype;
        }

        public void setStype(String stype) {
            this.stype = stype;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getVid() {
            return vid;
        }

        public void setVid(String vid) {
            this.vid = vid;
        }
    }

    public static class ListBean implements Serializable{
        /**
         * brief : 本期节目主要内容：    因教书先生教授了《诗经》中“关关雎鸠，在河之洲；窈窕淑女，君子好逑。”之词
         * id : VSET100311356635
         * image : http://p5.img.cctvpic.com/fmspic/2016/10/19/84f27011346547c595d78b47a48eb6de-129.jpg
         * order : 1
         * title : 戏曲动画·《牡丹亭·惊梦》
         * type : 2
         * url :
         * videoLength : 03:33
         */

        private String brief;
        private String id;
        private String image;
        private String order;
        private String title;
        private String type;
        private String url;
        private String videoLength;

        public String getBrief() {
            return brief;
        }

        public void setBrief(String brief) {
            this.brief = brief;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getVideoLength() {
            return videoLength;
        }

        public void setVideoLength(String videoLength) {
            this.videoLength = videoLength;
        }
    }
}
