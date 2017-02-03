package com.wangjianxin.util;

import com.wangjianxin.service.model.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;


public final class CookieUtil {
    private static final Log logger = LogFactory.getLog(CookieUtil.class);
    private static final String CPS_USER_KEY = "WCVBML23%^&*(*";

    public static final String COOKIE_KEY = "logon_wangjianxin";
    public static final String COOKIE_KEY_FAVOR = "favor";
    private static final String SPLITER = "|";
    public static final int COOKIE_LIVE_DAYS = 30;
    public static final int COOKIE_LIVE_EXPIRY = 1800;//半小时
    public static final int COOKIE_LIVE_FAVOR = 300;//赞砸收藏间隔
    public static final String DOMAIN = ConstantUtil.WEBAPP_COOKIE_DOMAIN;
    private static final String DEFAULT_CHARSET = "utf-8";

    public static boolean setUserCookie(HttpServletResponse response, User user, int expiry) {
        String cookieValue = CookieUtil.generateCookieValue(user);
        return cookieValue != null && CookieUtil.setCookie(response, COOKIE_KEY, cookieValue, expiry);
    }
    //赞砸收藏cookie
    public static boolean setFavorCookie(HttpServletResponse response, String user_ip,String code,int expiry) {
        String cookieValue = CookieUtil.generateCookieValueToFavor(user_ip,code);
        return cookieValue != null && CookieUtil.setCookie(response, COOKIE_KEY_FAVOR, cookieValue, expiry);
    }
    //验证码cookie
    public static boolean setMaCookie(HttpServletResponse response, String user_ip,String code,int expiry) {
        String cookieValue = CookieUtil.generateCookieValueToFavor(user_ip,code);
        return cookieValue != null && CookieUtil.setCookie(response, COOKIE_KEY_FAVOR, cookieValue, 300);
    }

    //登录后
    private static String generateCookieValue(User user) {
        StringBuilder sb = new StringBuilder();
        sb.append(base64Encode(user.getId() + "")).append(SPLITER)
                .append(base64Encode("A")).append(SPLITER)
                .append(base64Encode((user.getName() == null || user.getName().equals("")) ? "" : user.getName())).append(SPLITER) //登录名
                // .append(base64Encode((user.getContactphone() == null|| user.getContactphone().equals(""))  ? "Contactphone" : user.getContactphone())).append(SPLITER)
                .append(base64Encode(user.getEmail() + ""));

        String sign = MD5(sb.toString() + CPS_USER_KEY);
        sb.append(SPLITER).append(sign);
        try {
            String result = URLEncoder.encode(sb.toString(), "utf-8");
            return result;
        } catch (UnsupportedEncodingException e) {
            logger.error(e.getMessage());
            return null;
        }
    }
    private static String generateCookieValueToFavor(String user_ip,String code) {
        StringBuilder sb = new StringBuilder();

        sb.append(base64Encode(user_ip + "")).append(SPLITER)
                .append(base64Encode("A")).append(SPLITER)
        .append(base64Encode(code)).append(SPLITER);

        String sign = MD5(sb.toString() + CPS_USER_KEY);
        sb.append(SPLITER).append(sign);
        try {
            String result = URLEncoder.encode(sb.toString(),"utf-8");
            return result;
        } catch (UnsupportedEncodingException e) {
            logger.error(e.getMessage());
            return null;
        }
    }


    public static User getUserFromCookie(HttpServletRequest request) {
        String cookieValue = CookieUtil.getCookie(request, COOKIE_KEY);

        if (null != cookieValue) {
            try {
                cookieValue = URLDecoder.decode(cookieValue, DEFAULT_CHARSET);

            } catch (UnsupportedEncodingException e) {
                return null;
            }
        } else {
            return null;
        }

        String[] strs = cookieValue.split("\\|");
        if (strs.length <5) {
            return null;
        }
        StringBuffer sb = new StringBuffer();
        sb.append(strs[0]).append(SPLITER).append(strs[1]).append(SPLITER)
                .append(strs[2]).append(SPLITER).append(strs[3]);

        String sign = MD5(sb.toString() + CPS_USER_KEY);

        User user = null;
        if (sign.equals(strs[4])){
            user = new User();
            user.setId(Integer.parseInt(base64Decode(strs[0])));
            //user.setPwUserId(Long.parseLong(base64Decode(strs[1])));
            user.setName(base64Decode(strs[2]));
            //System.out.println(base64Decode(strs[2]));
            user.setEmail(base64Decode(strs[3]));
//            user.setStatus(Integer.valueOf(base64Decode(strs[4])));
            return user;
        }
        return null;
    }


    public static String getMaFromCookie(HttpServletRequest request) {
        String cookieValue = CookieUtil.getCookie(request, COOKIE_KEY_FAVOR);
        if (null != cookieValue) {
            try {
                cookieValue = URLDecoder.decode(cookieValue, DEFAULT_CHARSET);
            } catch (UnsupportedEncodingException e) {
                return null;
            }
        } else {
            return null;
        }
        String[] strs = cookieValue.split("\\|");
        if (strs.length <5) {
            return null;
        }
        StringBuffer sb = new StringBuffer();
        sb.append(strs[0]).append(SPLITER).append(strs[1]).append(SPLITER)
                .append(strs[2]).append(SPLITER).append(strs[3]);
        String sign = MD5(sb.toString() + CPS_USER_KEY);
        if (sign.equals(strs[4])){
//            System.out.println(base64Decode(strs[0])); 123.118.93.220
//            System.out.println(base64Decode(strs[1])); A
//            System.out.println(base64Decode(strs[4]));!w����tqA�]��~9�{�
//            System.out.println(base64Decode(strs[2])); 验证码
            return base64Decode(strs[2]);
        }
        return null;
    }

    public static User getUserfromCookieValue(String cookieValue) {
        if (null != cookieValue) {
            try {
                cookieValue = URLDecoder.decode(cookieValue, DEFAULT_CHARSET);
            } catch (UnsupportedEncodingException e) {
                return null;
            }
        } else {
            return null;
        }

        String[] strs = cookieValue.split("\\|");

        if (strs.length < 6) {
            return null;
        }

        StringBuffer sb = new StringBuffer();
        sb.append(strs[0]).append(SPLITER).append(strs[1]).append(SPLITER)
                .append(strs[2]).append(SPLITER).append(strs[3]).append(SPLITER).append(strs[4]);
        String sign = MD5(sb.toString() + CPS_USER_KEY);

        if (sign.equals(strs[5])) {
            User user = new User();
            user.setId(Integer.parseInt(base64Decode(strs[0])));
            //user.setPwUserId(Long.parseLong(base64Decode(strs[1])));
            user.setEmail(base64Decode(strs[2]));
            user.setName(base64Decode(strs[3]));
            user.setMoney(Integer.valueOf(base64Decode(strs[4])));
            return user;
        }

        return null;
    }


    /*
    * 参数expiry应是一个整数。正值表示cookie将在这么多秒以后失效。注意这个值是cookie将要存在的最大时间，
    * 而不是cookie现在的存在时间。负值表示当浏览器关闭时，Cookie将会被删除。零值则是要删除该Cookie。
    * */
    public static boolean setCookie(HttpServletResponse response, String key, String value, int expiry) {
        try {
            Cookie cookie = new Cookie(key, value); //will be throw new IllegalArgumentException(errMsg);
            cookie.setPath("/"); // very important
            cookie.setDomain("localhost");
            cookie.setMaxAge(expiry);
            response.addCookie(cookie);
            return true;
        } catch (IllegalArgumentException e) {
            logger.error(e.getMessage());
            return false;
        }
    }

    public static boolean removeCookie(HttpServletResponse response, String key) {
        try {
            Cookie cookie = new Cookie(key, null);
            cookie.setPath("/"); // very important! but not response 呀。。。
            cookie.setDomain("localhost");
            cookie.setMaxAge(0);//过期
            response.addCookie(cookie);
            return true;
        } catch (IllegalArgumentException e) {
            logger.error(e.getMessage());
            return false;
        }
    }

    private static boolean setAutoCookie(HttpServletResponse response, String value) {
        try {
            Cookie c = new Cookie(COOKIE_KEY, value);
            c.setPath("/");
            c.setDomain(DOMAIN);
            c.setMaxAge(COOKIE_LIVE_DAYS * 24 * 60 * 60);
            response.addCookie(c);
            return true;
        } catch (IllegalArgumentException e) {
            logger.error(e.getMessage());
            return false;
        }
    }

    public static String getCookie(HttpServletRequest request, String key) {
        try {
            Cookie[] cookies = request.getCookies();
            if ((cookies == null) || (cookies.length == 0)) {
                return null;
            }
            for (Cookie cooky : cookies) {
                if (cooky.getName().equals(key)) {
                    return cooky.getValue();
                }
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return null;
    }

    private static String byteHex(byte ib) {
        char[] Digit = {
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C',
                'D', 'E', 'F'
        };
        char[] ob = new char[2];
        ob[0] = Digit[(ib >>> 4) & 0X0F];
        ob[1] = Digit[ib & 0X0F];
        String s = new String(ob);
        return s;
    }

    public static String MD5(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            md.update(str.getBytes(DEFAULT_CHARSET));

            byte[] b = md.digest();
            StringBuffer result = new StringBuffer();
            for (byte aB : b)
                result.append(byteHex(aB));
            return result.toString();
        } catch (Exception e) {
            return "";
        }
    }

    private static String base64Encode(String inStr) {
        BASE64Encoder encoder = new BASE64Encoder();
        try {
            //  return inStr;
            return encoder.encode(inStr.getBytes(DEFAULT_CHARSET));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String base64Decode(String inStr) {
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            //   return inStr;
            return new String(decoder.decodeBuffer(inStr), DEFAULT_CHARSET);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public static void main(String sr[]) {
        CookieUtil u = new CookieUtil();
        String s = "MQ==|QQ==|dGVzdA==|QQ==|MQ==WCVBML23%^&*(*";
        User user = new User();
        user.setId(1);
        user.setEmail("test");
        user.setMoney(1);
        setUserCookie(null, user, 3);

        User cpsuser = getUserfromCookieValue("MQ%3D%3D%7CQQ%3D%3D%7CdGVzdA%3D%3D%7CQQ%3D%3D%7CMQ%3D%3D%7CB46B7768C7A9F3C6BA921DB1A919C197");
   /*
        //    Cpsuser cpsuser =  getUserfromCookieValue("MTg%3D%7CQQ%3D%3D%7CdHR0dHR0dHl5eQ%3D%3D%7CQQ%3D%3D%7CMQ%3D%3D%7C5F6729BC2C4D81DD3D24D9BD17DBF4D1");//okset
        System.out.println("user is:" + cpsuser.toString());
        //String d = u.MD5("MQ==|QQ==|dGVzdA==|QQ==|MA==WCVBML23%^&*(*");
        //  js after md5:C3933506B952AC0D5475961EFCB1038A
        //  key value after md5:B46B7768C7A9F3C6BA921DB1A919C197
        //System.out.println("after md5:" + d);
        */

    }

}
