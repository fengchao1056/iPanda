package com.example.a123.pandatv.config;

//网络请求地址
public class Urls {
    //服务器地址
    private static final String BASEURL="http://www.ipanda.com/kehuduan/";
    //首页
    public static final String HOMELIVE=BASEURL+"PAGE14501749764071042/index.json";
    //熊猫播报
    public static final String BOBAO=BASEURL+"xmwh/index.json";

    //直播中国 http://www.ipanda.com/kehuduan/PAGE14501775094142282/index.json
    public static final String LIVECHINAS=BASEURL+"PAGE14501775094142282/index.json";

    //登录
    public static final String LOGIN="https://reg.cntv.cn/login/login.action";
    //手机注册
    public static final String PHONEREGISTER="https://reg.cntv.cn/regist/mobileRegist.do";
//    https://reg.cntv.cn/regist/mobileRegist.do
    //手机图片验证码
    public static final String FROM = "http://reg.cntv.cn/simple/verificationCode.action";
    //邮箱图片验证码
    public static final String EMILEYANZHENG = "http://reg.cntv.cn/simple/verificationCode.action";

    //邮箱注册
    public static final String EMILEREGIS = "https://reg.cntv.cn/api/register.action";

    //原创
    public static final String CEHUA = BASEURL + "PAGE14501767715521482/index.json";
}
