package com.wangjianxin.controller;

import com.wangjianxin.service.manager.*;
import com.wangjianxin.service.model.User;
import com.wangjianxin.util.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.CharArrayReader;
import java.util.List;
/**
 * Created by wangjianxin on 2016/10/26.
 */
@Controller
@RequestMapping("/")
public class IndexController extends MyBaseController{

    @Autowired
    private StudentManager studentManager;
    @Autowired
    private UserManager userManager;
    @Autowired
    private IndexWordManager indexWordManager;
    @Autowired
    private ArticleManager articleManager;
    @Autowired
    private StarManager starManager;

    /**
     * 登陆
     * @param email
     * @param pass
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/login.json",method = RequestMethod.GET)
    public  String ss(@RequestParam(value = "email") String email,
                      @RequestParam(value = "pass") String pass,
                      HttpServletResponse response){
         User user = userManager.login(email,pass);

        int result;
        if(null != user){
            boolean cookieresult =  CookieUtil.setUserCookie(response, user, CookieUtil.COOKIE_LIVE_EXPIRY);
            System.out.println("cookie注册"+cookieresult);
            result=99;
        }else{
            result=98;
        }
        return toJson(result);
    }

    @ResponseBody
    @RequestMapping(value = "/reg.json",method = RequestMethod.GET)
    public  String reg(@RequestParam(value = "email") String email,
                      @RequestParam(value = "pass") String pass,
                      @RequestParam(value = "name") String name,
//                      @RequestParam(value = "ma") String ma,
                      HttpServletResponse response,
                      HttpServletRequest request){
        List list = userManager.check(email);
        int result;
        if(list.size()>0){
            result=98;
        }else{
           List namelist =  userManager.checkName(name);
            if(namelist.size() > 0 ){
                result = 97;
            }else{
                //验证码
//                if(CookieUtil.getMaFromCookie(request).equals(ma)){
                    User user = new User();
                    user.setEmail(email);
                    user.setPass(pass);
                    user.setName(name);
                    result = userManager.insertSelective(user);
                    User cookieuser = userManager.login(email,pass);
                    boolean cookieresult =  CookieUtil.setUserCookie(response, cookieuser, CookieUtil.COOKIE_LIVE_EXPIRY);
//                }else{
//                    result = 96;
//                }
            }
        }
        return toJson(result);
    }
    /**
     * 得到用户名
     */
    @ResponseBody
    @RequestMapping(value = "/getName.json")
    public String getName(HttpServletRequest request) {
        String name;
        User user = CookieUtil.getUserFromCookie(request);
        if (user != null) {
            name = user.getName();
            return toJson(2, name, user.getId());
        } else {
            name = "登录";
            return toJson(1, name, "");
        }
    }
    /**
     * 退出
     */
    @ResponseBody
    @RequestMapping(value = "/quit.json")
    public String quit(HttpServletResponse response) {
        Boolean quit = CookieUtil.removeCookie(response,CookieUtil.COOKIE_KEY);
        if(quit){
            return toJson(99);
        }else{
            return toJson(98);
        }
    }
    @ResponseBody
    @RequestMapping(value = "/checkLogin.json",method = RequestMethod.GET)
    public  String checkLogin(HttpServletRequest request){
        String nickName ;
        User user = CookieUtil.getUserFromCookie(request);
        if(user!=null){
            nickName = user.getName();
            return toJson(2, nickName, user.getId());
        }else{
            nickName = "登录";
            return toJson(1, nickName, "");
        }
    }

    /**
     * 左侧赞数排行榜
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/paihang.json",method = RequestMethod.GET)
    public  String paihang(HttpServletRequest request){
        List list = articleManager.paihang();
        return toJson(list);
    }

    @ResponseBody
    @RequestMapping(value = "/getWord.json",method = RequestMethod.GET)
    public String getWord(){
        String words = indexWordManager.getWord();
        return toJson(words);
    }

    /**
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getNames.json",method = RequestMethod.GET)
    public String getName(@RequestParam(value = "user_id") int user_id){
        List list = userManager.getName(user_id);
        return toJson(list);
    }


    @RequestMapping(value = "/login.html")
    public String loginhtmkl () {
        return "/login/login";
    }
    @RequestMapping(value = "/reg.html")
    public String reg () {
        return "/login/reg";
    }
    @RequestMapping(value = "/")
    public String index () {
        return "/index/index";
    }
    @RequestMapping(value = "/about.html")
    public String about () {
        return "/about/about";
    }
    @RequestMapping(value = "/star.html")
    public String star (Model model) {
       List starlist =  starManager.selectAll();
        model.addAttribute("starlist",starlist);
        return "/star/star2";
    }
    @RequestMapping(value = "/stars.html")
    public String stars (Model model) {
        List starlist =  starManager.selectAll();
        model.addAttribute("starlist",starlist);
        return "/star/star2";
    }
    @RequestMapping(value = "/me.html")
    public String me() {
        return "/me/me";
    }
    @RequestMapping(value = "/music.html")
    public String music() {
        return "/music/music";
    }
    @RequestMapping(value = "/404.html")
    public String error() {
        return "404";
    }
    @RequestMapping(value = "/link.html")
    public String link() {
        return "link/link";
    }
    @RequestMapping(value = "/p.html")
    public String p() {
        return "p/p";
    }
}
