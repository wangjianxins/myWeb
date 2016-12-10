package com.wangjianxin.controller;

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
}
