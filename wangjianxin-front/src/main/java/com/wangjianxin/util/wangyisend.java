package com.wangjianxin.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * Created by wangjianxin on 2017/2/8.
 */
public class wangyisend {
    final static int BUFFER_SIZE = 4096;
    public static void sendPost(String url, Map data) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        String Nonce = getRandomString(10);
        String curtime = String.valueOf(time());
        httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");
        httpPost.setHeader("AppKey", "2954d53cb8c49a030da94935cc863976");
        httpPost.setHeader("Nonce", Nonce);
        httpPost.setHeader("CurTime", curtime);
        httpPost.setHeader("CheckSum", CheckSumBuilder.getCheckSum("58949275b01f",Nonce,curtime));

        try {
            List<NameValuePair> list = new ArrayList<NameValuePair>();
            Iterator iterator = data.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, String> elem = (Map.Entry<String, String>) iterator.next();
                list.add(new BasicNameValuePair(elem.getKey(), elem.getValue()));
            }
            if (list.size() > 0) {
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, "utf-8");
                httpPost.setEntity(entity);
            }
            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();

            InputStream in = null; // 读
            String returnStr ="";
            if (null != entity) {
                in = entity.getContent();
            }
            returnStr = InputStreamTOString(in);

            byte[] byteDatas = new byte[in.available()];
            in.read(byteDatas);
            System.out.println(returnStr);
        } catch (Exception e) {
            System.out.println("错误");
        }
    }


    public static void main(String[] args) throws IOException {
        Map<String,String> createMap = new HashMap<String,String>();
            createMap.put("mobile","15701288931");
            createMap.put("code", "6as666");
            sendPost("https://api.netease.im/sms/verifycode.action", createMap);
    }

    public static String getRandomString(int length) { //length表示生成字符串的长度
        String base = "1234567890";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    public static long time(){
        Long nowtime = System.currentTimeMillis();
        String time = "1970/01/01 00:00:00";
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long unixTimestamp = date.getTime()/1000;
        return nowtime-unixTimestamp;
    }

    public static String InputStreamTOString(InputStream in) throws Exception{

        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] data = new byte[BUFFER_SIZE];
        int count = -1;
        while((count = in.read(data,0,BUFFER_SIZE)) != -1)
            outStream.write(data, 0, count);

        data = null;
        return new String(outStream.toByteArray(),"utf-8");
    }
}
