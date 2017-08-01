package com.example.a123.pandatv.config;

//网络请求地址
public class Urls {
    //服务器地址
    private static final String BASEURL="http://www.ipanda.com/kehuduan/";
    //首页
    public static final String HOMELIVE=BASEURL+"PAGE14501749764071042/index.json";
    //熊猫播报
    public static final String BOBAO=BASEURL+"xmwh/index.json";
    //熊猫播报第一个item
    public static final String BOADCASTITEM="http://api.cntv.cn/video/videolistById?p=1&serviceId=panda&n=150&vsid=VSET100311356635";

    //直播中国 http://www.ipanda.com/kehuduan/PAGE14501775094142282/index.json
    public static final String LIVECHINAS=BASEURL+"PAGE14501775094142282/index.json";

    //原创
    public static final String CEHUA = BASEURL + "PAGE14501767715521482/index.json";
    //版本升级
    public static final String UPDATE= "http://115.182.9.124/index.php?action=release-GetNewVersions&applyName=1426217325";



}
