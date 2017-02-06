<%--
  Created by IntelliJ IDEA.
  User: wangjianxin
  Date: 2017/1/29
  Time: 21:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"  class="demo-2 no-js">
<head>
    <jsp:include  page="/WEB-INF/jsp/header.jsp"/>
    <link rel="stylesheet" type="text/css" href="/resources/css/p/p.css" />
    <link rel="stylesheet" href="/resources/css/p/trumbowyg.css">
    <link rel="stylesheet" href="/resources/css/p/p.css">
    <script src="/resources/js/p/jquery.min.js"></script>
    <script src="/resources/js/p/trumbowyg.js"></script>
    <script src="/resources/js/p/trumbowyg.base64.js"></script>
    <script src="/resources/js/p/writer.js"></script>

    <!---->
    <script src="/resources/js/alert/jquery-confirm.js"></script>
    <script src="/resources/js/alert/jquery.sticky.min.js"></script>
    <script src="/resources/js/alert/pretty.js"></script>
    <link rel="stylesheet" href="/resources/css/alert/jquery-confirm.css">

    <title>写文章</title>
</head>
<body>
<div id="odiv" style="display:none;position:absolute;z-index:100;">
    <img src="/resources/images/p/sx.png" title="缩小" border="0" alt="缩小" onclick="sub(-1);"/>
    <img src="/resources/images/p/fd.png" title="放大" border="0" alt="放大" onclick="sub(1)"/>
    <img src="/resources/images/p/cz.png" title="重置" border="0" alt="重置" onclick="sub(0)"/>
    <img src="/resources/images/p/sc.png" title="删除" border="0" alt="删除" onclick="del();odiv.style.display='none';"/>
</div>
<div contenteditable="true" id="title" class="title_input" placeholder="写入文章标题"></div>
<div onmousedown="show_element(event)" style="clear:both" id="customized-buttonpane" class="editor" ></div>
<div contenteditable="true" onkeyup="value=value.replace(/[^\u4E00-\u9FA5]/g,'')" id="article_tag" class="title_input" placeholder="添加一个文章标签（中文小于四个字）"></div>
<div onclick="fabu()" class="fabu">发布文章</div>
<div class="fabu" style="float: left">欢迎连载哦，后期会有悬赏打赏功能，暂时文章不能上传图片，编辑时请删除图片</div>
<script>
    checkLogin();
</script>
</body>
</html>
