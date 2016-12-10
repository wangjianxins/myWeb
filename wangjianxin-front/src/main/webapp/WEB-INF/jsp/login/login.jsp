<%--
  Created by IntelliJ IDEA.
  User: wangjianxin
  Date: 2016/10/27
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <jsp:include  page="/WEB-INF/jsp/alert/alert.jsp"/>
</head>
<body class="cont_principal">
<div id="home" >
    <form id="login" class="current1" method="post">
        <h2>用户登录</h2>
        <img class="avator" src="/resources/images/avatar.png" width="96" height="96"/>
        <label>邮箱<input type="text" name="userName" id="email" /><span>邮箱为空</span></label>
        <label>密码<input type="password" name="pass" id="pass" /><span>密码为空</span></label>
        <button type="button" onclick="login()">登录</button>
        <button type="button" onclick="goReg()">注册</button>
    </form>
</div>

</body>
</html>
