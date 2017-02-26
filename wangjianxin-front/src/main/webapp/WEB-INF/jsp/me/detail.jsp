<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">

<%--<jsp:include  page="/WEB-INF/jsp/alert/alert.jsp"/>--%>
<head>
    <meta charset="UTF-8">
    <jsp:include  page="/WEB-INF/jsp/header.jsp"/>
    <title>${user.name}-个人主页</title>
    <link rel="stylesheet" type="text/css" href="/resources/css/star_detail/detail.css" />
    <link rel="stylesheet" type="text/css" href="/resources/css/dianzan/default.css" />
    <link rel="stylesheet" type="text/css" href="/resources/css/star/detial.css" />

    <script src="/resources/js/alert/jquery-confirm.js"></script>
    <script src="/resources/js/alert/jquery.sticky.min.js"></script>
    <script src="/resources/js/alert/pretty.js"></script>
    <script src="/resources/js/star/star.js"></script>
    <link rel="stylesheet" href="/resources/css/alert/jquery-confirm.css">
</head>

<body class="body">
<div>
    <div class="left">
        <div>
            <%--<button class="MenuOpen btn btn-success" id="show_table">单击此处显示导航</button>--%>
            <img class="left_img" src="http://101.201.235.59:8087/pic/${user.photo}" onclick="updatePhtot()"/>
            <div class="left_div">
                <%--<div>${star.starName}</div>--%>
                <%--<div>${star.starTime}</div>--%>
            </div>
        </div>
    </div>
    <div class="right">
        <div class="right_div">
            <div style="float: left">昵称：</div>
            <div id="username" class="rightdiv_item">${user.name}</div>
        </div>
        <div class="right_div">
            <div style="float: left">简介：</div>
            <div id="usersummary" class="rightdiv_item">${user.summary}</div>
        </div>
        <div class="right_div">
            <div style="float: left">微信：</div>
            <div id="userweixin" class="rightdiv_item">${user.weixin}</div>
        </div>
        <div class="right_div">
            <div class="edit" id="edit"  onclick="updateinfo()" >编辑</div>
        </div>
    </div>
</div>
<div>
    <div class="mokuai">${star.starName}个人专区</div><br/>
    <div class="mokuai_a">
        <a class="a" href="#">发表的文章</a>
        <a class="a" href="#">发表的说说</a>
        <a class="a" href="#">赞过我的人</a>
    </div>
</div>
<div>
    <div id="context">
        <div class="input" style="float: left;"></div>
    </div>
</div>
<script src="/resources/js/me/me.js"></script>
</body>
</html>