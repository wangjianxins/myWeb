package com.wangjianxin.controller;

import com.wangjianxin.service.manager.StarManager;
import com.wangjianxin.service.model.Star;
import com.wangjianxin.util.CutImgUtil;
import com.wangjianxin.util.UploadUtil;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by wangjianxin on 2016/11/16.
 */
@Controller
@RequestMapping("/star")
public class StarController extends MyBaseController {

    @Autowired
    private StarManager starManager;


    @RequiresAuthentication
    @ResponseBody
    @RequestMapping(value = "/create.json" ,method = RequestMethod.POST)
    public String create(@RequestParam(value = "star_name") String name,
                         @RequestParam(value = "star_des") String des,
                         @RequestParam(value = "star_time") String time,
                         @RequestParam(value = "star_userid") int user_id,
                         @ModelAttribute("photo") MultipartFile photo,
                         HttpServletRequest request){


        //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
        CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(
                request.getSession().getServletContext());
        //检查form中是否有enctype="multipart/form-data"
        String fileNewName ="";
        if(multipartResolver.isMultipart(request))
        {
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
            //获取multiRequest 中所有的文件名
            Iterator iter=multiRequest.getFileNames();
            UploadUtil uploadUtil = new UploadUtil();
            while(iter.hasNext())
            {
                //一次遍历所有文件
                MultipartFile file=multiRequest.getFile(iter.next().toString());
                MultipartFile newfile=file;
                if(file!=null)
                {
                    fileNewName = uploadUtil.generateFileName(file.getOriginalFilename());
                    //上传
                    try {
                        String path = "/www/img/pic/"+fileNewName;
                        newfile.transferTo(new File(path));//存原图
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        Star star = new Star();
        star.setStarName(name);
        star.setStarDes(des);
        star.setStarTime(time);
        star.setUserId(user_id);
        star.setPhoto(fileNewName);
        int result = starManager.insertSelective(star);
        return toJson(result,fileNewName,"");

    }
    @RequestMapping(value = "/detail.html")
    public String error() {
        return "/star/detail";
    }
}
