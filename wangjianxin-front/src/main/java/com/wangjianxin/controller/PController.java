package com.wangjianxin.controller;

import com.wangjianxin.service.dao.PfavourMapper;
import com.wangjianxin.service.manager.PManager;
import com.wangjianxin.service.manager.PfavourManager;
import com.wangjianxin.service.manager.UserFollowManager;
import com.wangjianxin.service.manager.UserManager;
import com.wangjianxin.service.model.P;
import com.wangjianxin.service.model.Pfavour;
import com.wangjianxin.service.model.User;
import com.wangjianxin.service.model.UserFollow;
import com.wangjianxin.util.CookieUtil;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
/**
 * Created by wangjianxin on 2017/1/16.
 */
@Controller
@RequestMapping("/p")
public class PController extends MyBaseController {

    @Autowired
    private PManager pManager;
    @Autowired
    private UserManager userManager;
    @Autowired
    private PfavourManager pfavourManager;
    @Autowired
    private UserFollowManager userFollowManager;
    @RequestMapping("/initp.json")
    @ResponseBody
    public String initP(@RequestParam(value = "pagenum") int pagenum,
                        @RequestParam(value = "pagesize") int pagesize){
        List list = pManager.initp(pagenum,pagesize);
        JSONArray jArray = new JSONArray();
        JSONObject jObj = null;
        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        for(int i =0; i< list.size();i++){
            Object itemlist =  list.get(i);
            jObj = JSONObject.fromObject(itemlist);
            for(int j=0;j<jObj.size();j++){
                String content = (String) jObj.get("p_context");
//                String time = (String)jObj.get("time");

//                Date createtime = (Date)jObj.get("time");
//                System.out.println(createtime);
//                String dateTime = format1.format(String.valueOf(createtime));
//                jObj.put("createtime",dateTime);
                jObj.put("p_context", stripHtml(content));
            }
            jArray.add(jObj);
        }
        int count = pManager.pcount();
        return toJson(count,"",jArray);
    }

    @RequestMapping("/howword.json")
    @ResponseBody
    public String howword(@RequestParam(value = "user_id") int user_id){
        List words = pManager.howword(user_id);
        return toJson(words);
    }

    @RequestMapping(value = "/detial/{id}", method = RequestMethod.GET)
    public String img(@PathVariable("id") int id, Model model) {
        P ps = pManager.select(id);
        User user  = userManager.selectByPrimaryKey(ps.getUserId());
        model.addAttribute("p", ps);
        model.addAttribute("user", user);
        return "p/detail";
    }

    @RequestMapping(value = "/insertArticle.json",method = RequestMethod.POST)
    @ResponseBody
    public String insertArticle(HttpServletRequest request,
                                @RequestParam(value = "title") String title,
                                @RequestParam(value = "context") String context,
                                @RequestParam(value = "tag") String tag){
        User user = CookieUtil.getUserFromCookie(request);
        int user_id = user.getId();
        int num = pManager.checkNum(user_id);
        if(num > 10){
            return toJson(2);
        }else{
            P p = new P();
            p.setpTitle(title);
            p.setpContext(context);
            p.setUserId(user_id);
            p.setTag(tag);
            int result = pManager.insertArticle(p);
            return toJson(result);
        }
    }

    @RequestMapping("/checkLogin.json")
    @ResponseBody
    public String checkLogin(HttpServletRequest request){
        User user = CookieUtil.getUserFromCookie(request);
        if(user != null ){
            return toJson(99);
        }else{
            return toJson(98);
        }
    }

    @RequestMapping("/look.json")
    @ResponseBody
    public String look(@RequestParam(value = "p_id") int p_id){
       int result =  pManager.look(p_id);
        return toJson(result);
    }

    @RequestMapping("/favour.json")
    @ResponseBody
    public String favour(@RequestParam(value = "p_id") int p_id,
                         @RequestParam(value = "type") int type,
                         HttpServletRequest request){
        int result =  pManager.favour(p_id, type);
        int likenum =  pManager.likenum(p_id);
        int user_id = 1;

        //favourv表插入
        try {
            User user = CookieUtil.getUserFromCookie(request);
            user_id = user.getId();
        }catch (Exception e){

        }

        Pfavour checkresult = pfavourManager.checkFavour(user_id,p_id);
        if(type == 1){//喜欢操作
                if(checkresult == null){
                    //直接插入
                    Pfavour pfavour = new Pfavour();
                    pfavour.setUserId(user_id);
                    pfavour.setpId(p_id);
                    int inserresult = pfavourManager.insertSelective(pfavour);
                }else{
                   int updateresult =  pfavourManager.updateFavour(user_id,1,p_id);
                }
        }else{//不喜欢操作
            int updateresult =  pfavourManager.updateFavour(user_id,2,p_id);
        }

        return toJson(result,"",likenum);
    }

    @RequestMapping("/checkFavour.json")
    @ResponseBody
    public String checkFavour(HttpServletRequest request,
                              @RequestParam(value = "p_id") int p_id){
        User user = CookieUtil.getUserFromCookie(request);
        if(user != null){
            int user_id = user.getId();
            Pfavour result = pfavourManager.checkFavour(user_id,p_id);
            if(result != null){
                if(result.getFlag() == 0){
                    return toJson(99);//已喜欢
                }else{
                    return toJson(98);//不喜欢（喜欢过）
                }
            }else{
                return toJson(98);//不喜欢(未喜欢过)
            }
        }else{
            return toJson(97);//未登录
        }
    }

    @ResponseBody
    @RequestMapping("/checkFollow.json")
    public String checkFollow(HttpServletRequest request,
                              @RequestParam(value = "taguser_id") int taguser_id){
        User user = CookieUtil.getUserFromCookie(request);
        if(user != null){
            UserFollow userFollow = userFollowManager.checkFollow(user.getId(),taguser_id);
            if(userFollow != null && userFollow.getFlag() == 0 ){
                return toJson(99);
            }else{
                return toJson(98);
            }
        }else{
            return toJson(97);//未登录
        }
    }

    @RequestMapping("/follow.json")
    @ResponseBody
    public String follow(HttpServletRequest request,
                         @RequestParam(value = "taguser_id") int taguser_id,
                         @RequestParam(value = "type") int type){
        User user = CookieUtil.getUserFromCookie(request);
        if(user != null){
            int user_id = user.getId();
            UserFollow result = userFollowManager.checkFollow(user_id,taguser_id);
            int updateFlagresult = 0;
            if(type == 1){
                if(result == null){
                    //直接插入
                    UserFollow userFollow = new UserFollow();
                    userFollow.setUserId(user_id);
                    userFollow.setTaguserId(taguser_id);
                     updateFlagresult = userFollowManager.insertSelective(userFollow);
                }else{
                    updateFlagresult =  userFollowManager.Follow(user_id,taguser_id,1);
                }
            }else{
                updateFlagresult = userFollowManager.Follow(user_id,taguser_id,2);
            }

            return toJson(updateFlagresult);
        }else{
            return toJson(2);
        }
    }

    @RequestMapping("/writer.htm")
    public String writer(){
        return "/p/pwriter";
    }
    @RequestMapping("/p.htm")
    public String p(Model model){
        List list =  pManager.recommend();
        model.addAttribute("recommendlist",list);
        return "/p/p";
    }

}
