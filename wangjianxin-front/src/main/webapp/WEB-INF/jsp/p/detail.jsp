<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">

<%--<jsp:include  page="/WEB-INF/jsp/alert/alert.jsp"/>--%>
<head>
    <meta charset="UTF-8">
    <jsp:include  page="/WEB-INF/jsp/header.jsp"/>
    <meta name="description" content=${p.pTitle}>
    <meta name="keywords" content=${p.pTitle}>
    <link rel="stylesheet" href="/resources/css/p/detial.css">
    <script src="/resources/js/p/detial.js" type="text/javascript"></script>
    <script src="/resources/js/p/share.js" type="text/javascript"></script>
    <link rel="stylesheet" href="/resources/css/p/share.css" type="text/css" />

    <!---->
    <script src="/resources/js/alert/jquery-confirm.js"></script>
    <script src="/resources/js/alert/jquery.sticky.min.js"></script>
    <script src="/resources/js/alert/pretty.js"></script>
    <link rel="stylesheet" href="/resources/css/alert/jquery-confirm.css">
    <title>${p.pTitle}</title>
</head>

<body>
<a class="write_a" target="_blank" href="/p/writer.htm/"><i class="ic">写文章</i></a>
<div class="article">
    <h1 class="title"id="title">${p.pTitle}</h1>
    <div class="author">
        <a class="avatar"><img src="http://101.201.235.59:8087/pic/${user.photo}" alt=""/></a>
        <div class="info">
            <span class="tag">作者</span>
            <span class="name">
                <a >${user.name}</a>
            </span>
            <div class="meta">
                <span class="time">${p.createtime}</span>
                <span class="word">查看：${p.look}</span>
                <span class="word">喜欢：${p.favour}</span>
                <%--<span class="word">${p.pContext}</span>--%>
            </div>
        </div>
    </div>
    <div class="article_show" id="context">${p.pContext}</div>
</div>
    <div class="di">
    <div id="socialShare" style="float: right"></div>
    <div class="like" onclick="favour(${p.id})" id="like">
        <div class="like_btn">
            <a>
                <i class="ic" id="like_btn">喜欢</i>
            </a>
        </div>
        <div class="modal_w">
            <a id="like_num">${p.favour}</a>
        </div>
    </div>
</div>

<script>
    $("#socialShare").socialShare({
        content: $('#context').text(),
        url:location.href,
        titile:$('#title').val()
    });
    look(${p.id});
    checkFavour(${p.id});
</script>
</body>
</html>