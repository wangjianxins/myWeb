<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
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
</head>

<body class="body">
<div >
    <div class="left">
        <div>
            <%--<button class="MenuOpen btn btn-success" id="show_table">单击此处显示导航</button>--%>
            <img class="left_img" src="/resources/images/sss.jpg" />
            <div class="left_div">
                <div>金牛座</div>
                <div>4.20~5.20</div>
            </div>
        </div>
    </div>
    <div class="right">
        <div class="right_div">
            <div style="float: left">星座描述：</div>
            <div>描述1111</div>
        </div>
        <div class="right_div">
            <div style="float: left">特点：</div>
            <div>特点112222</div>
        </div>
        <div class="right_div">
            <div style="float: left">标签：</div>
            <div>
                <code>牛逼</code>
                <code>屌丝</code>
            </div>
        </div>
    </div>
</div>

<div style="padding-left: 100px">
    <div class="mokuai">金牛座专区</div><br/>
    <div >
        <a class="a" href="/">金牛座最配的星座</a>
        <a class="a" href="/">金牛座最配的星座</a>
        <a class="a" href="/">金牛座最配的星座</a>
        <a class="a" href="/">金牛座最配的星座</a>
    </div>
</div>
<div>
    <div id="context">
        <div class="input" style="float: left;">1111</div>
        <div class="input" style="float: left;">1111</div>
    </div>
</div>

</body>

</html>