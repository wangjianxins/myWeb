package com.wangjianxin.util;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by zhaobk on 2014/11/28.
 */
public class ConstantUtil {
    public static final String WEBAPP_URL;
    public static final String WEBAPP_EMAIL;
    public static final String WEBAPP_EMAIL_PW;
    public static final String WEBAPP_EMAIL_SMTP;
    public static final String WEBAPP_EMAIL_PORT;
    public static final int DEFAULT_EXPIRY = -1;
//    public static final String COOKIE_SEARCH_PARAM_EXPIRY;
    public static final String REG_URL = "/u/reg.html";
    public static final String LOGIN_URL = "/u/login.html";
    public static final String WEBAPP_COOKIE_DOMAIN;

    public static final String IMG_URL;
    public static final String DOWNLOAD_URL;

    private static Properties property;
    public static int CART_ORDER_TYPE_PLAN = 1;//行程单
    public static int CART_ORDER_TYPE_SHOP = 0;// 商城
    public static int CART_ORDER_TYPE_TRAVLE = 2;// 线路

    public static final String WEBAPP_ROOT;
    public static final String WEBAPP_CHARSET;

    public static final String SELLER_EMAIL;  //seller_email = "etrip@etripworld.com";
    public static final String PAYMENT_TYPE; //payment_type = "1";
    public static final String NOTIFY_URL;//notify_url = "http://car.etripworld.com/pay/notifyUrl";
    //需http://格式的完整路径，不能加?id=123这类自定义参数
    //页面跳转同步通知页面路径
    public static final String RETURN_URL;//return_url = "http://car.etripworld.com/pay/returnUrl";

    public static final String  DEPOSIT;

    static {
        //AreaController.showareaList();
        InputStream is = PropertyUtil.class.getResourceAsStream("/constant.properties");
        property = new Properties();
        try {
            property.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        WEBAPP_URL = getProperty("webapp.url", "").trim();
        WEBAPP_EMAIL = getProperty("webapp.service.email", "").trim();
        WEBAPP_EMAIL_PW = getProperty("webapp.service.email.pw", "").trim();
        WEBAPP_EMAIL_SMTP = getProperty("webapp.service.email.smtp", "").trim();
        WEBAPP_EMAIL_PORT = getProperty("webapp.service.email.port", "").trim();
        WEBAPP_COOKIE_DOMAIN = getProperty("webapp.cookie.domail", "www.wangjianxin.top").trim();
//        COOKIE_SEARCH_PARAM_EXPIRY = getProperty("cookie.search.param.expiry", "");



        //ystem.out.println("COOKIE_SEARCH_PARAM_EXPIRY" + COOKIE_SEARCH_PARAM_EXPIRY);

        IMG_URL = getProperty("img.url", "").trim();
        DOWNLOAD_URL = getProperty("download.url", "").trim();
        //System.out.println("COOKIE_SEARCH_PARAM_EXPIRY" + IMG_URL + "WEBAPP_URL" + WEBAPP_URL);
        WEBAPP_ROOT = getProperty("webapp.root", "").trim();
        WEBAPP_CHARSET = getProperty("webapp.charset", "").trim();


        //支付参数
        SELLER_EMAIL = getProperty("pay.seller_email", "").trim();
        PAYMENT_TYPE = getProperty("pay.payment_type", "").trim();
        NOTIFY_URL = getProperty("pay.notify_url", "").trim();
        RETURN_URL = getProperty("pay.return_url", "").trim();
        DEPOSIT  = getProperty("pay.deposit", "").trim();
    }

    /**
     * 根据key获取对应的value
     */
    public static String getProperty(String key, String def) {
        if (null != property) {
            return property.getProperty(key);
        }
        System.out.println(def);

        return def;
    }


}
