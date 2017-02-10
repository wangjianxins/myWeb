<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"  class="demo-2 no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>星座</title>
    <link rel="stylesheet" type="text/css" href="/resources/css/star/baraja.css" />
    <link rel="stylesheet" type="text/css" href="/resources/css/star/demo.css" />
    <link rel="stylesheet" type="text/css" href="/resources/css/star/custom.css" />
    <jsp:include  page="/WEB-INF/jsp/header.jsp"/>
    <link rel="stylesheet" href="/resources/css/alert/jquery-confirm.css">
    <link rel="stylesheet" href="/resources/css/start_/start_.css">
    <script src="/resources/js/alert/jquery-confirm.js"></script>
    <script src="/resources/js/alert/jquery.sticky.min.js"></script>
    <script src="/resources/js/alert/pretty.js"></script>
    <!--新star-->
    <script type="text/javascript" src="/resources/js/star/modernizr.custom.79639.js"></script>
    <script type="text/javascript" src="/resources/js/star/jquery.baraja.js"></script>
    <script src="/resources/js/star/star.js"></script>
</head>
<body>
<a class="create_" target="_blank" onclick="test( ($('#user_id').val()) )"><i class="ic">创建星座</i></a>
<div id="nav-prev" class="left_">上一张</div>
<div id="nav-next" class="left_">下一张</div>
<div id="nav-fan5" class="left_">展开</div>

<%--<div id="close" class="left_">关闭</div>--%>

<div class="container">
    <section class="main">
        <nav class="actions">
            <%--<span id="nav-fanOther4">展开</span>--%>
            <%--<span id="add">Add items</span>--%>
        </nav>
        <div class="baraja-demo">
            <ul id="baraja-el" class="baraja-container">
                <c:forEach var="starlist" items="${starlist}">
                    <li><img src="http://101.201.235.59:8087/pic/${starlist.photo}" />
                        <h4>${starlist.starName}<span>  (${starlist.starTime})</span></h4>
                        <p onclick="star_detial(${starlist.id})" class="star_span">查看详情</p></li>
                </c:forEach>
            </ul>
        </div>
        <nav class="actions light">
        </nav>
    </section>

</div>
</body>
</html>