<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>
            <%
            String PostData = "account=帐号&password=接口密码&mobile=手机号码&content="+java.net.URLEncoder.encode("您的订单编码：4557。如需帮助请联系客服。","utf-8");
            //out.println(PostData);
            String ret = com.dxton.www.Send.SMS(PostData, "http://sms.106jiekou.com/utf8/sms.aspx");
            out.println(ret);
            //请自己反序列化返回的字符串并实现自己的逻辑
        %>

        </h1>
    </body>
</html>
