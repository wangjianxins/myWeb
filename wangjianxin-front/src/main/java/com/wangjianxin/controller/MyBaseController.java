package com.wangjianxin.controller;

import com.google.gson.Gson;
import com.wangjianxin.service.model.P;
import com.wangjianxin.util.JsonResult;
import com.wangjianxin.util.JsonTools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by wangjianxin on 2016/10/27.
 */
public class MyBaseController {
    protected static Logger logger = LoggerFactory.getLogger(MyBaseController.class);
    public String toJson(int a,String b,Object c){
        JsonResult jsonResult = new JsonResult(a,b,c);
        return toJson(jsonResult);
    }
    public String toJson(Object d){
        String result;
        try {
            result = JsonTools.toJsonStr(d);
        } catch (Exception e) {
            logger.error("MyBaseController toJsonResult error:", e);
            result = JsonTools.toJsonStr("");
        }
        return result;
    }
    public String removeString(String obj){
        String result = obj.replaceAll("<img.*>.*</img>", "").replaceAll("<img.*/>", "").
                replaceAll("<p>","").replaceAll("</p>","").replaceAll("\n","").replaceAll("&nbsp","").replaceAll("\r","").
                replaceAll("<span.*>.*</span>","").replaceAll("<strong>","").replaceAll("</strong>","").replaceAll("<br/>","").
                replaceAll("<br />","").replaceAll("&Idquo","").replaceAll("&bull","·").replaceAll("&rdquo","").trim();
        return result;
    }
    public  String stripHtml(String content) {
    // <p>段落替换为换行
        content = content.replaceAll("<p .*?>", "\r\n");
    // <br><br/>替换为换行
        content = content.replaceAll("<br\\s*/?>", "\r\n");
    // 去掉其它的<>之间的东西
        content = content.replaceAll("\\<.*?>", "");
    // 还原HTML
    // content = HTMLDecoder.decode(content);
        return content;
    }
}
