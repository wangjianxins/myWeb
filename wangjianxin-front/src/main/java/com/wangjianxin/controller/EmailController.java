package com.wangjianxin.controller;
import com.wangjianxin.service.mail.MailSenderInfo;
import com.wangjianxin.service.mail.SimpleMailSender;
import com.wangjianxin.util.ConstantUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wangjianxin on 2016/11/3.
 */
@Controller
@RequestMapping("/mail")
public class EmailController extends MyBaseController{


    @ResponseBody
    @RequestMapping(value = "/send.json",method = RequestMethod.GET)
    public String send(@RequestParam(value = "email") String email){
        String content = "恭喜注册成功哦，不要慌，这是个提示邮箱，加油。",subject = "邮箱账号注册成功";
//        String content = "美小阳，加油，你是最棒的！", subject = "加油";
        StringBuilder sb = new StringBuilder("恭喜注册成功：<br/><br/>");
        sb.append("欢迎你通过邮箱注册本站，嘿嘿!<br/>")
                .append("QQ：731461008 <br/>")
                .append("传真：木有<br/>")
                .append("有什么好玩的，一起讨论讨论。<br/><br/>")
                .append("Java开发者，求同行大神带<br/>")
                .append("此邮件为系统自动发送，无须回复。<br/>");
        content = sb.toString();

        MailSenderInfo mailInfo = new MailSenderInfo();
        mailInfo.setMailServerHost(ConstantUtil.WEBAPP_EMAIL_SMTP);
        mailInfo.setMailServerPort(ConstantUtil.WEBAPP_EMAIL_PORT);
        mailInfo.setValidate(true);
        mailInfo.setUserName(ConstantUtil.WEBAPP_EMAIL);
        mailInfo.setPassword(ConstantUtil.WEBAPP_EMAIL_PW);//您的邮箱密码
        mailInfo.setFromAddress(ConstantUtil.WEBAPP_EMAIL);
        mailInfo.setToAddress(email);
        mailInfo.setNick("wangjianxin");
        mailInfo.setSubject(subject);
        mailInfo.setContent(content);
        logger.debug(".mailInfo  " + subject + " from " + mailInfo.getFromAddress() + " to" + mailInfo.getToAddress() + " host " + mailInfo.getMailServerHost() +
                "port  " + mailInfo.getMailServerPort());
        SimpleMailSender sms = new SimpleMailSender();
//        sms.sendTextMail(mailInfo)
        if(SimpleMailSender.sendHtmlMail(mailInfo)){
            return toJson(99);
        }else{
            return toJson(98);
        }
    }

}
