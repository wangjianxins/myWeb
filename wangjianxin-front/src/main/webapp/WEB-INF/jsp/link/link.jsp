<%--
  Created by IntelliJ IDEA.
  User: wangjianxin
  Date: 2017/1/9
  Time: 14:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"  class="demo-2 no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>link</title>
    <jsp:include  page="/WEB-INF/jsp/header.jsp"/>

    <link rel="stylesheet" type="text/css" href="/resources/css/start_/normalize.css" />
    <link rel="stylesheet" type="text/css" href="/resources/css/start_/demo.css" />
    <link rel="stylesheet" type="text/css" href="/resources/css/start_/component.css" />
    <link rel="stylesheet" type="text/css" href="/resources/css/link/link.css" />
    <script src="/resources/js/star/snap.svg-min.js"></script>
    <!--[if IE]>
    <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <script src="/resources/js/alert/jquery-confirm.js"></script>
    <script src="/resources/js/alert/jquery.sticky.min.js"></script>
    <script src="/resources/js/alert/pretty.js"></script>
    <script src="/resources/js/star/star.js"></script>

    <link rel="stylesheet" href="/resources/css/alert/jquery-confirm.css">

    <link rel="stylesheet" href="/resources/css/start_/start_.css">
</head>
<body>
<div class="container ">
    <div class="nav-second">
        <div id="sui_nav2" class="sui-nav">
            <script type="text/javascript">
                var topbar;
                $(function() {
                    topbar = $('#sui_nav').SuiNav({});
                    var navbar = $('#sui_nav2').SuiNav({});
                    $('.MenuOpen').click(function() {
                        topbar.show();
                    });
                });
            </script>
        </div>
    </div>
</div>

<div class="link_center">
    <a class="link" href="javascript:void(0)" onclick="bolg('http://lfei.org/')" data-letters="fly">fly</a><br>
    <a class="link" href="javascript:void(0)" onclick="bolg('http://www.keen8.com/')" data-letters="keen8">keen8</a><br>
    <a class="link" href="javascript:void(0)" onclick="bolg('http://blog.m1910.com/')" data-letters="小左闲谈 ">小左闲谈 </a><br>
</div>

<div class="link_des">
    <span >添加友链接请到首页留言</span>
</div>
<script>
    function bolg(url){
        window.open(url);
    }
</script>
</body>
</html>
