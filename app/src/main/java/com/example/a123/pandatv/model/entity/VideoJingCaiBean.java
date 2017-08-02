package com.example.a123.pandatv.model.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/7/29.
 */

public class VideoJingCaiBean implements Serializable{

    /**
     * play_channel : 直播中国
     * f_pgmtime : 2017-06-12 11:50:38
     * tag : 精彩一刻搓澡小公主熊猫
     * cdn_info : {"cdn_vip":"vod.cntv.lxdns.com","cdn_code":"VOD-MP4-CDN-CNC","cdn_name":"3rd网宿"}
     * editer_name : fangjin
     * version : 0.2
     * title : 《精彩一刻》 20170612 搓澡的呢？小公主都要睡着了
     * is_fn_hot : true
     * is_protected : 0
     * hls_url : http://asp.cntv.lxdns.com/asp/hls/main/0303000a/3/default/d2a828ca5cd0400f82c2adee5581fc17/main.m3u8?maxbr=4096
     * hls_cdn_info : {"cdn_vip":"asp.cntv.lxdns.com","cdn_code":"VOD-HLS-CDN-CNC","cdn_name":"3rd网宿"}
     * client_sid : 84dd520c9e0b4fe1816af7db1159528f
     * is_ipad_support : true
     * video : {"totalLength":"19.00","chapters":[{"duration":"19","image":"http://p5.img.cctvpic.com/fmspic/2017/06/12/d2a828ca5cd0400f82c2adee5581fc17-9.jpg","url":"http://vod.cntv.lxdns.com/flash/mp4video60/TMS/2017/06/12/d2a828ca5cd0400f82c2adee5581fc17_h264418000nero_aac32.mp4"}],"validChapterNum":5,"chapters4":[{"duration":"19","image":"http://p5.img.cctvpic.com/fmspic/2017/06/12/d2a828ca5cd0400f82c2adee5581fc17-9.jpg","url":"http://vod.cntv.lxdns.com/flash/mp4video60/TMS/2017/06/12/d2a828ca5cd0400f82c2adee5581fc17_h2642000000nero_aac16.mp4"}],"chapters3":[{"duration":"19","image":"http://p5.img.cctvpic.com/fmspic/2017/06/12/d2a828ca5cd0400f82c2adee5581fc17-9.jpg","url":"http://vod.cntv.lxdns.com/flash/mp4video60/TMS/2017/06/12/d2a828ca5cd0400f82c2adee5581fc17_h2641200000nero_aac16.mp4"}],"lowChapters":[{"duration":"19","image":"http://p5.img.cctvpic.com/fmspic/2017/06/12/d2a828ca5cd0400f82c2adee5581fc17-9.jpg","url":"http://vod.cntv.lxdns.com/flash/mp4video60/TMS/2017/06/12/d2a828ca5cd0400f82c2adee5581fc17_h264200000nero_aac16.mp4"}],"chapters2":[{"duration":"19","image":"http://p5.img.cctvpic.com/fmspic/2017/06/12/d2a828ca5cd0400f82c2adee5581fc17-9.jpg","url":"http://vod.cntv.lxdns.com/flash/mp4video60/TMS/2017/06/12/d2a828ca5cd0400f82c2adee5581fc17_h264818000nero_aac32.mp4"}],"url":""}
     * is_invalid_copyright : 0
     * produce_id : wxsb01
     * default_stream : HD
     * ack : yes
     * is_fn_multi_stream : false
     * embed :
     * asp_error_code : 0
     * column : 熊猫频道精彩一刻高清
     * lc : {"isp_code":"1","city_code":"","provice_code":"BJ","country_code":"CN","ip":"115.171.131.71"}
     * public : 1
     * is_p2p_use : false
     * produce :
     */

    private String play_channel;
    private String f_pgmtime;
    private String tag;
    private CdnInfoBean cdn_info;
    private String editer_name;
    private String version;
    private String title;
    private String is_fn_hot;
    private String is_protected;
    private String hls_url;
    private HlsCdnInfoBean hls_cdn_info;
    private String client_sid;
    private String is_ipad_support;
    private VideoBean video;
    private String is_invalid_copyright;
    private String produce_id;
    private String default_stream;
    private String ack;
    private boolean is_fn_multi_stream;
    private String embed;
    private int asp_error_code;
    private String column;
    private LcBean lc;
    @SerializedName("public")
    private String publicX;
    private boolean is_p2p_use;
    private String produce;

    public String getPlay_channel() {
        return play_channel;
    }

    public void setPlay_channel(String play_channel) {
        this.play_channel = play_channel;
    }

    public String getF_pgmtime() {
        return f_pgmtime;
    }

    public void setF_pgmtime(String f_pgmtime) {
        this.f_pgmtime = f_pgmtime;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public CdnInfoBean getCdn_info() {
        return cdn_info;
    }

    public void setCdn_info(CdnInfoBean cdn_info) {
        this.cdn_info = cdn_info;
    }

    public String getEditer_name() {
        return editer_name;
    }

    public void setEditer_name(String editer_name) {
        this.editer_name = editer_name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIs_fn_hot() {
        return is_fn_hot;
    }

    public void setIs_fn_hot(String is_fn_hot) {
        this.is_fn_hot = is_fn_hot;
    }

    public String getIs_protected() {
        return is_protected;
    }

    public void setIs_protected(String is_protected) {
        this.is_protected = is_protected;
    }

    public String getHls_url() {
        return hls_url;
    }

    public void setHls_url(String hls_url) {
        this.hls_url = hls_url;
    }

    public HlsCdnInfoBean getHls_cdn_info() {
        return hls_cdn_info;
    }

    public void setHls_cdn_info(HlsCdnInfoBean hls_cdn_info) {
        this.hls_cdn_info = hls_cdn_info;
    }

    public String getClient_sid() {
        return client_sid;
    }

    public void setClient_sid(String client_sid) {
        this.client_sid = client_sid;
    }

    public String getIs_ipad_support() {
        return is_ipad_support;
    }

    public void setIs_ipad_support(String is_ipad_support) {
        this.is_ipad_support = is_ipad_support;
    }

    public VideoBean getVideo() {
        return video;
    }

    public void setVideo(VideoBean video) {
        this.video = video;
    }

    public String getIs_invalid_copyright() {
        return is_invalid_copyright;
    }

    public void setIs_invalid_copyright(String is_invalid_copyright) {
        this.is_invalid_copyright = is_invalid_copyright;
    }

    public String getProduce_id() {
        return produce_id;
    }

    public void setProduce_id(String produce_id) {
        this.produce_id = produce_id;
    }

    public String getDefault_stream() {
        return default_stream;
    }

    public void setDefault_stream(String default_stream) {
        this.default_stream = default_stream;
    }

    public String getAck() {
        return ack;
    }

    public void setAck(String ack) {
        this.ack = ack;
    }

    public boolean isIs_fn_multi_stream() {
        return is_fn_multi_stream;
    }

    public void setIs_fn_multi_stream(boolean is_fn_multi_stream) {
        this.is_fn_multi_stream = is_fn_multi_stream;
    }

    public String getEmbed() {
        return embed;
    }

    public void setEmbed(String embed) {
        this.embed = embed;
    }

    public int getAsp_error_code() {
        return asp_error_code;
    }

    public void setAsp_error_code(int asp_error_code) {
        this.asp_error_code = asp_error_code;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public LcBean getLc() {
        return lc;
    }

    public void setLc(LcBean lc) {
        this.lc = lc;
    }

    public String getPublicX() {
        return publicX;
    }

    public void setPublicX(String publicX) {
        this.publicX = publicX;
    }

    public boolean isIs_p2p_use() {
        return is_p2p_use;
    }

    public void setIs_p2p_use(boolean is_p2p_use) {
        this.is_p2p_use = is_p2p_use;
    }

    public String getProduce() {
        return produce;
    }

    public void setProduce(String produce) {
        this.produce = produce;
    }

    public static class CdnInfoBean implements Serializable{
        /**
         * cdn_vip : vod.cntv.lxdns.com
         * cdn_code : VOD-MP4-CDN-CNC
         * cdn_name : 3rd网宿
         */

        private String cdn_vip;
        private String cdn_code;
        private String cdn_name;

        public String getCdn_vip() {
            return cdn_vip;
        }

        public void setCdn_vip(String cdn_vip) {
            this.cdn_vip = cdn_vip;
        }

        public String getCdn_code() {
            return cdn_code;
        }

        public void setCdn_code(String cdn_code) {
            this.cdn_code = cdn_code;
        }

        public String getCdn_name() {
            return cdn_name;
        }

        public void setCdn_name(String cdn_name) {
            this.cdn_name = cdn_name;
        }
    }

    public static class HlsCdnInfoBean implements Serializable{
        /**
         * cdn_vip : asp.cntv.lxdns.com
         * cdn_code : VOD-HLS-CDN-CNC
         * cdn_name : 3rd网宿
         */

        private String cdn_vip;
        private String cdn_code;
        private String cdn_name;

        public String getCdn_vip() {
            return cdn_vip;
        }

        public void setCdn_vip(String cdn_vip) {
            this.cdn_vip = cdn_vip;
        }

        public String getCdn_code() {
            return cdn_code;
        }

        public void setCdn_code(String cdn_code) {
            this.cdn_code = cdn_code;
        }

        public String getCdn_name() {
            return cdn_name;
        }

        public void setCdn_name(String cdn_name) {
            this.cdn_name = cdn_name;
        }
    }

    public static class VideoBean implements Serializable{
        /**
         * totalLength : 19.00
         * chapters : [{"duration":"19","image":"http://p5.img.cctvpic.com/fmspic/2017/06/12/d2a828ca5cd0400f82c2adee5581fc17-9.jpg","url":"http://vod.cntv.lxdns.com/flash/mp4video60/TMS/2017/06/12/d2a828ca5cd0400f82c2adee5581fc17_h264418000nero_aac32.mp4"}]
         * validChapterNum : 5
         * chapters4 : [{"duration":"19","image":"http://p5.img.cctvpic.com/fmspic/2017/06/12/d2a828ca5cd0400f82c2adee5581fc17-9.jpg","url":"http://vod.cntv.lxdns.com/flash/mp4video60/TMS/2017/06/12/d2a828ca5cd0400f82c2adee5581fc17_h2642000000nero_aac16.mp4"}]
         * chapters3 : [{"duration":"19","image":"http://p5.img.cctvpic.com/fmspic/2017/06/12/d2a828ca5cd0400f82c2adee5581fc17-9.jpg","url":"http://vod.cntv.lxdns.com/flash/mp4video60/TMS/2017/06/12/d2a828ca5cd0400f82c2adee5581fc17_h2641200000nero_aac16.mp4"}]
         * lowChapters : [{"duration":"19","image":"http://p5.img.cctvpic.com/fmspic/2017/06/12/d2a828ca5cd0400f82c2adee5581fc17-9.jpg","url":"http://vod.cntv.lxdns.com/flash/mp4video60/TMS/2017/06/12/d2a828ca5cd0400f82c2adee5581fc17_h264200000nero_aac16.mp4"}]
         * chapters2 : [{"duration":"19","image":"http://p5.img.cctvpic.com/fmspic/2017/06/12/d2a828ca5cd0400f82c2adee5581fc17-9.jpg","url":"http://vod.cntv.lxdns.com/flash/mp4video60/TMS/2017/06/12/d2a828ca5cd0400f82c2adee5581fc17_h264818000nero_aac32.mp4"}]
         * url :
         */

        private String totalLength;
        private int validChapterNum;
        private String url;
        private List<ChaptersBean> chapters;
        private List<Chapters4Bean> chapters4;
        private List<Chapters3Bean> chapters3;
        private List<LowChaptersBean> lowChapters;
        private List<Chapters2Bean> chapters2;

        public String getTotalLength() {
            return totalLength;
        }

        public void setTotalLength(String totalLength) {
            this.totalLength = totalLength;
        }

        public int getValidChapterNum() {
            return validChapterNum;
        }

        public void setValidChapterNum(int validChapterNum) {
            this.validChapterNum = validChapterNum;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public List<ChaptersBean> getChapters() {
            return chapters;
        }

        public void setChapters(List<ChaptersBean> chapters) {
            this.chapters = chapters;
        }

        public List<Chapters4Bean> getChapters4() {
            return chapters4;
        }

        public void setChapters4(List<Chapters4Bean> chapters4) {
            this.chapters4 = chapters4;
        }

        public List<Chapters3Bean> getChapters3() {
            return chapters3;
        }

        public void setChapters3(List<Chapters3Bean> chapters3) {
            this.chapters3 = chapters3;
        }

        public List<LowChaptersBean> getLowChapters() {
            return lowChapters;
        }

        public void setLowChapters(List<LowChaptersBean> lowChapters) {
            this.lowChapters = lowChapters;
        }

        public List<Chapters2Bean> getChapters2() {
            return chapters2;
        }

        public void setChapters2(List<Chapters2Bean> chapters2) {
            this.chapters2 = chapters2;
        }

        public static class ChaptersBean implements Serializable{
            /**
             * duration : 19
             * image : http://p5.img.cctvpic.com/fmspic/2017/06/12/d2a828ca5cd0400f82c2adee5581fc17-9.jpg
             * url : http://vod.cntv.lxdns.com/flash/mp4video60/TMS/2017/06/12/d2a828ca5cd0400f82c2adee5581fc17_h264418000nero_aac32.mp4
             */

            private String duration;
            private String image;
            private String url;

            public String getDuration() {
                return duration;
            }

            public void setDuration(String duration) {
                this.duration = duration;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class Chapters4Bean implements Serializable{
            /**
             * duration : 19
             * image : http://p5.img.cctvpic.com/fmspic/2017/06/12/d2a828ca5cd0400f82c2adee5581fc17-9.jpg
             * url : http://vod.cntv.lxdns.com/flash/mp4video60/TMS/2017/06/12/d2a828ca5cd0400f82c2adee5581fc17_h2642000000nero_aac16.mp4
             */

            private String duration;
            private String image;
            private String url;

            public String getDuration() {
                return duration;
            }

            public void setDuration(String duration) {
                this.duration = duration;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class Chapters3Bean implements Serializable{
            /**
             * duration : 19
             * image : http://p5.img.cctvpic.com/fmspic/2017/06/12/d2a828ca5cd0400f82c2adee5581fc17-9.jpg
             * url : http://vod.cntv.lxdns.com/flash/mp4video60/TMS/2017/06/12/d2a828ca5cd0400f82c2adee5581fc17_h2641200000nero_aac16.mp4
             */

            private String duration;
            private String image;
            private String url;

            public String getDuration() {
                return duration;
            }

            public void setDuration(String duration) {
                this.duration = duration;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class LowChaptersBean implements Serializable{
            /**
             * duration : 19
             * image : http://p5.img.cctvpic.com/fmspic/2017/06/12/d2a828ca5cd0400f82c2adee5581fc17-9.jpg
             * url : http://vod.cntv.lxdns.com/flash/mp4video60/TMS/2017/06/12/d2a828ca5cd0400f82c2adee5581fc17_h264200000nero_aac16.mp4
             */

            private String duration;
            private String image;
            private String url;

            public String getDuration() {
                return duration;
            }

            public void setDuration(String duration) {
                this.duration = duration;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class Chapters2Bean implements Serializable{
            /**
             * duration : 19
             * image : http://p5.img.cctvpic.com/fmspic/2017/06/12/d2a828ca5cd0400f82c2adee5581fc17-9.jpg
             * url : http://vod.cntv.lxdns.com/flash/mp4video60/TMS/2017/06/12/d2a828ca5cd0400f82c2adee5581fc17_h264818000nero_aac32.mp4
             */

            private String duration;
            private String image;
            private String url;

            public String getDuration() {
                return duration;
            }

            public void setDuration(String duration) {
                this.duration = duration;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }

    public static class LcBean implements Serializable{
        /**
         * isp_code : 1
         * city_code :
         * provice_code : BJ
         * country_code : CN
         * ip : 115.171.131.71
         */

        private String isp_code;
        private String city_code;
        private String provice_code;
        private String country_code;
        private String ip;

        public String getIsp_code() {
            return isp_code;
        }

        public void setIsp_code(String isp_code) {
            this.isp_code = isp_code;
        }

        public String getCity_code() {
            return city_code;
        }

        public void setCity_code(String city_code) {
            this.city_code = city_code;
        }

        public String getProvice_code() {
            return provice_code;
        }

        public void setProvice_code(String provice_code) {
            this.provice_code = provice_code;
        }

        public String getCountry_code() {
            return country_code;
        }

        public void setCountry_code(String country_code) {
            this.country_code = country_code;
        }

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }
    }
}

