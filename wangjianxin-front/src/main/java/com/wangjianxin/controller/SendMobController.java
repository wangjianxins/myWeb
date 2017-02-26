package com.wangjianxin.controller;
import com.wangjianxin.service.manager.UserManager;
import com.wangjianxin.util.CookieUtil;
import com.wangjianxin.util.Send;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

/**
 * Created by wangjianxin on 2017/2/26.
 */
@Controller
@RequestMapping("/send")
public class SendMobController extends MyBaseController{

    @Autowired
    private UserManager userManager;

    @RequestMapping("/mob.json")
    @ResponseBody
    public String mob(@RequestParam(value = "mob") String mob,
                      @RequestParam(value = "user_ip" ,required = false) String user_ip,
                      HttpServletResponse response){
        String data = Send.getRandomString(4);
        logger.info("注册ip"+user_ip+"注册手机号"+mob);
        String url = "http://sms.106jiekou.com/utf8/sms.aspx?account=wangjianxins&password=WJX18042690933&mobile="+mob+"&content=您的验证码是："+data+"。如需帮助请联系客服。";
        List list = userManager.check(mob);
        String result =null;
        int code = 0;
        if(list.size() > 0){
            code =1;
        }else{
             result  = Send.SMS(data,url);
            System.out.println(result);
            //注册验证码cookie
            boolean cookieresult =  CookieUtil.setMaCookie(response, user_ip, data, CookieUtil.COOKIE_LIVE_EXPIRY);
            logger.debug("验证码注册cookie"+cookieresult);
        }
        return toJson(code,data,result);
    }
}
