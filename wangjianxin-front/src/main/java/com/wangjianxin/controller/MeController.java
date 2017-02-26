package com.wangjianxin.controller;

import com.wangjianxin.service.manager.UserManager;
import com.wangjianxin.service.model.User;
import com.wangjianxin.util.CookieUtil;
import com.wangjianxin.util.CutImgUtil;
import com.wangjianxin.util.UploadImagesConfImpl;
import com.wangjianxin.util.UploadUtil;
import net.sf.json.JSONObject;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Iterator;

/**
 * Created by wangjianxin on 2016/11/14.
 */
@Controller
@RequestMapping("/me")
public class MeController extends MyBaseController {

    @Autowired
    private UserManager userManager;

    @RequestMapping("/initPhtot.json")
    @ResponseBody
    public String initPhoto(HttpServletRequest request){
        User user = CookieUtil.getUserFromCookie(request);
        User result = userManager.selectByPrimaryKey(user.getId());
        String photo = result.getPhoto();
//        System.out.print(user);

        return toJson(photo);
    }
    @RequiresAuthentication
//    @ResponseBody
    @RequestMapping(value = "/uploadByArticle.json", method = RequestMethod.POST)
    public String  picUploadByArticle(@ModelAttribute("pictemplate") MultipartFile pictemplate,
//                                      @RequestParam(value = "avatar_data")String avatar_data,
                                      ModelMap model,HttpServletRequest request,HttpServletResponse response) {

//        JSONObject jsStr = JSONObject.fromObject(avatar_data);
//        double x =jsStr.getDouble("x");
//        double y =jsStr.getDouble("y");
//        double height =jsStr.getDouble("height");
//        double width =jsStr.getDouble("width");
//        DecimalFormat df = new DecimalFormat("######0");
//        int x_ = Integer.parseInt(df.format(x));
//        int y_ = Integer.parseInt(df.format(y));
//        int height_ = Integer.parseInt(df.format(height));
//        int width_ = Integer.parseInt(df.format(width));


        UploadImagesConfImpl conf = new UploadImagesConfImpl();

        //long  startTime=System.currentTimeMillis();
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
//                        String path = "C:\\Users\\wangjianxin\\Desktop\\im\\"+fileNewName;
                        String path = "/www/img/pic/"+fileNewName;

                        newfile.transferTo(new File(path));//存原图
//                        CutImgUtil cutImgUtil = new CutImgUtil();
//                        cutImgUtil.cutImage(path,path,x_,y_,height_,width_);
                        User user = CookieUtil.getUserFromCookie(request);
                            User s = new User();
                                s.setId(user.getId());
                                s.setPhoto(fileNewName);
                             int updatePhoto = userManager.updateByPrimaryKeySelective(s);
                        System.out.println(updatePhoto);
                        logger.info("updatePhoto:" + updatePhoto);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return "me/me";
    }

    @RequestMapping("/updateinfo.json")
    @ResponseBody
    public String  updateinfo(HttpServletRequest request,
                             @RequestParam(value = "name") String name,
                             @RequestParam(value = "summary") String summary,
                             @RequestParam(value = "weixin") String weixin){
        User cookieuser = CookieUtil.getUserFromCookie(request);
       int user_id =cookieuser.getId();
        User user = new User();
        user.setId(user_id);
        user.setName(name);
        if(summary.length() > 30){
            summary = "兄弟简述不能大于30字符";
        }
        user.setSummary(summary);
        user.setWeixin(weixin);
        int list =  userManager.updateByPrimaryKeySelective(user);
        return toJson("请返回页面刷新" +list);
    }


    @RequestMapping("/getInfo.json")
    @ResponseBody
    public String getInfo(@RequestParam(value = "user_id") int user_id){
      User list =   userManager.selectByPrimaryKey(user_id);
        return toJson(list);
    }
    @RequestMapping("/detial.html")
    public String detial(HttpServletRequest request,Model model){
        User user = CookieUtil.getUserFromCookie(request);
        User result = userManager.selectByPrimaryKey(user.getId());
        model.addAttribute("user",result);
        return "me/detail";
    }
}