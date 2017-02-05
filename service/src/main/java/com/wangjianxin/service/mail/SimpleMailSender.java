package com.wangjianxin.service.mail;

/**
 * Created by zhaobk on 2014/12/25.
 */

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

public class SimpleMailSender {
    public boolean sendTextMail(MailSenderInfo mailInfo) {
        // 判断是否需要身份认证
        MyAuthenticator authenticator = null;
        Properties pro = mailInfo.getProperties();
        if (mailInfo.isValidate()) {
            // 如果需要身份认证，则创建一个密码验证器
            authenticator = new MyAuthenticator(mailInfo.getUserName(), mailInfo.getPassword());
        }
        // 根据邮件会话属性和密码验证器构造一个发送邮件的session
        Session sendMailSession = Session.getDefaultInstance(pro, authenticator);
        try {
            // 根据session创建一个邮件消息
            Message mailMessage = new MimeMessage(sendMailSession);
            // 创建邮件发送者地址
            String nick = "";
            try {
                nick = javax.mail.internet.MimeUtility.encodeText(mailInfo.getNick());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            Address from = new InternetAddress(nick + " <" + mailInfo.getFromAddress() + ">");
            //  Address from = new InternetAddress(mailInfo.getFromAddress());
            // 设置邮件消息的发送者
            mailMessage.setFrom(from);
            // 创建邮件的接收者地址，并设置到邮件消息中
            Address to = new InternetAddress(mailInfo.getToAddress());
            mailMessage.setRecipient(Message.RecipientType.TO, to);
            // 设置邮件消息的主题
            mailMessage.setSubject(mailInfo.getSubject());
            // 设置邮件消息发送的时间
            mailMessage.setSentDate(new Date());
            // 设置邮件消息的主要内容
            String mailContent = mailInfo.getContent();
            mailMessage.setText(mailContent);
            // 发送邮件
            Transport.send(mailMessage);
            return true;
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    /**
     * 以HTML格式发送邮件
     *
     * @param mailInfo 待发送的邮件信息
     */
    public  boolean sendHtmlMail(MailSenderInfo mailInfo) {
        // 判断是否需要身份认证
        MyAuthenticator authenticator = null;
        Properties pro = mailInfo.getProperties();
        //如果需要身份认证，则创建一个密码验证器
        if (mailInfo.isValidate()) {
            authenticator = new MyAuthenticator(mailInfo.getUserName(), mailInfo.getPassword());
        }
        // 根据邮件会话属性和密码验证器构造一个发送邮件的session
        Session sendMailSession = Session.getDefaultInstance(pro, authenticator);
        try {
            // 根据session创建一个邮件消息
            Message mailMessage = new MimeMessage(sendMailSession);
            // 创建邮件发送者地址

            String nick = "";
            try {
                nick = javax.mail.internet.MimeUtility.encodeText(mailInfo.getNick());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            Address from = new InternetAddress(nick + " <" + mailInfo.getFromAddress() + ">");
            // Address from = new InternetAddress(mailInfo.getFromAddress());
            // 设置邮件消息的发送者
            mailMessage.setFrom(from);
            // 创建邮件的接收者地址，并设置到邮件消息中
            Address to = new InternetAddress(mailInfo.getToAddress());
            // Message.RecipientType.TO属性表示接收者的类型为TO
            mailMessage.setRecipient(Message.RecipientType.TO, to);
            // 设置邮件消息的主题
            mailMessage.setSubject(mailInfo.getSubject());
            // 设置邮件消息发送的时间
            mailMessage.setSentDate(new Date());
            // MiniMultipart类是一个容器类，包含MimeBodyPart类型的对象
            Multipart mainPart = new MimeMultipart();
            // 创建一个包含HTML内容的MimeBodyPart
            BodyPart html = new MimeBodyPart();
            // 设置HTML内容
            html.setContent(mailInfo.getContent(), "text/html; charset=utf-8");
            mainPart.addBodyPart(html);
            // 将MiniMultipart对象设置为邮件内容
            mailMessage.setContent(mainPart);
            // 发送邮件
            Transport.send(mailMessage);
            return true;
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
        return false;
    }


//    public static void main(String[] args) {
//        Calendar calendar = Calendar.getInstance();//获取当前时间
//        calendar.add(Calendar.DAY_OF_YEAR, -2);
//        System.out.println(calendar.getTime());
//        //这个类主要是设置邮件
//        MailSenderInfo mailInfo = new MailSenderInfo();
//        mailInfo.setMailServerHost("smtp.exmail.qq.com");
//        mailInfo.setMailServerPort("25");
//        mailInfo.setValidate(true);
//
//        mailInfo.setUserName("zhaobk@etripworld.com");
//        mailInfo.setPassword("hou123");//您的邮箱密码
//        mailInfo.setFromAddress("zhaobk@etripworld.com");
//        mailInfo.setToAddress("zhaobk@etripworld.com");
//        mailInfo.setSubject("尚之旅同行采购系统用户注册确认");
//        mailInfo.setContent("请点击一下连接注册确认！");
//        //这个类主要来发送邮件
//        SimpleMailSender sms = new SimpleMailSender();
//        sms.sendTextMail(mailInfo);//发送文体格式
//        //  sms.sendHtmlMail(mailInfo);//发送html格式
//    }

}
