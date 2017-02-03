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
        <h4><a href="/login.html">Login</a></h4>
        <h2>用户注册</h2>
        <label>邮箱<input type="text" name="reg_email" id="reg_email" style="width:215px;" /><span>邮箱为空</span></label>
        <div><h2><a style="cursor:pointer" onclick="sendMa()" id="sendMa">发送验证码</a></h2></div>
        <label>验证码<input type="text" name="reg_ma" id="reg_ma" style="width:215px;" /><span>输入验证码</span></label>
        <label>密码<input type="password" name="reg_pass" id="reg_pass" /><span>密码为空</span></label>
        <label>昵称<input type="text" name="reg_name" id="reg_name" /><span>昵称为空</span></label>
        <button type="button" onclick="reg()">注册</button>
    </form>
</div>
<script language="javascript" type="text/javascript" src="http://pv.sohu.com/cityjson"/>
<script>



</script>

</body>
</html>
