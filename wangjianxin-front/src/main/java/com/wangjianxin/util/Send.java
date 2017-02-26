package com.wangjianxin.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author Administrator
 */
public class Send {

    public static String SMS(String postData, String postUrl) {
        try {
            //发送POST请求
            URL url = new URL(postUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setUseCaches(false);
            conn.setDoOutput(true);

            conn.setRequestProperty("Content-Length", "" + postData.length());
            OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
            out.write(postData);
            out.flush();
            out.close();

            //获取响应状态
            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                System.out.println("connect failed!");
                return "";
            }
            //获取响应内容体
            String line, result = "";
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
            while ((line = in.readLine()) != null) {
                result += line + "\n";
            }
            in.close();
            return result;
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
        return "";
    }

    /**
     * 100 发送成功
     101 验证失败 102 手机号码格式不正确
     103 会员级别不够
     104 内容未审核
     105 内容过多或无合适匹配通道
     106 账户余额不足
     107 Ip受限
     108 手机号码发送太频繁，请换号或隔天再发
     109 帐号被锁定
     110 手机号发送频率持续过高，黑名单屏蔽数日
     120 系统升级
     * @param args
     */
    public static void main(String args[]){
        Long nowtime = System.currentTimeMillis();
        String time = "1970/01/01 00:00:00";
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long unixTimestamp = date.getTime()/1000;
        System.out.println(unixTimestamp);
    }

    public static String getRandomString(int length) { //length表示生成字符串的长度
        String base = "0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
}
