<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">

<%--<jsp:include  page="/WEB-INF/jsp/alert/alert.jsp"/>--%>
<head>
    <meta charset="UTF-8">
    <jsp:include  page="/WEB-INF/jsp/header.jsp"/>
    <title>星座社区</title>
    <script src="http://www.jq22.com/jquery/jquery-1.7.1.js"></script>
    <link rel="stylesheet" type="text/css" href="/resources/css/star_detail/detail.css" />
    <link rel="stylesheet" type="text/css" href="/resources/css/dianzan/default.css" />
    <link rel="stylesheet" type="text/css" href="/resources/css/star/detial.css" />
</head>

<body class="body">
<div >
    <div class="left">
        <div>
            <%--<button class="MenuOpen btn btn-success" id="show_table">单击此处显示导航</button>--%>
            <img class="left_img" src="http://101.201.235.59:8087/pic/${star.photo}" />
            <div class="left_div">
                <div>${star.starName}</div>
                <div><fmt:formatDate value="${star.starTime}" type="date"/></div>
            </div>
        </div>
    </div>
    <div class="right">
        <div class="right_div">
            <div style="float: left">星座描述：</div>
            <div>${star.starDes}</div>
        </div>
        <div class="right_div">
            <div style="float: left">星座标签：</div>
            <div>
                <code>牛逼</code>
                <code>屌丝</code>
                <code>静态标签</code>
            </div>
        </div>
        <div class="right_div">
            <div style="float: left">星座创建：</div>
            <div id="star_username">${user.name}</div>
        </div>
        <div class="right_div"  >
            <div class="edit" id="edit" style="display: none" onclick="editstar()" >编辑</div>
        </div>
    </div>
</div>

<div style="padding-left: 100px">
    <div class="mokuai">${star.starName}专区</div><br/>
    <div>
        <a class="a" href="#">${star.starName}最配的星座</a>
        <a class="a" href="#">${star.starName}的性格</a>
        <a class="a" href="#">${star.starName}最配的优点</a>
        <a class="a" href="#">${star.starName}最配的缺点</a>
    </div>
</div>
<div>
    <div id="context">
        <div class="input" style="float: left;">暂无</div>
        <div class="input" style="float: left;"></div>
    </div>
</div>
<script src="/resources/js/link/link.js"></script>
</body>
</html>