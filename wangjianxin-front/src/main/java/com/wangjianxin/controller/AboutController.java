package com.wangjianxin.controller;

import com.wangjianxin.service.manager.AboutManager;
import com.wangjianxin.service.model.About;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wangjianxin on 2016/11/4.
 */
@Controller
@RequestMapping("/about")
public class AboutController extends MyBaseController{

    @Autowired
    private AboutManager aboutManager;

    @ResponseBody
    @RequestMapping(value = "/getY.json",method = RequestMethod.GET)
    public String  getY(){
        About about = aboutManager.selectByPrimaryKey(1);
        return toJson(about.getY());
    }

    /**
     * 访问量++
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/countY.json",method = RequestMethod.GET)
    public String  countY(){
        int result = aboutManager.countY();
        return toJson(result);
    }
}
