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
    <link rel="stylesheet" href="/resources/css/p/p.css">
    <script src="/resources/js/p/writer.js"></script>
    <title>文章</title>
    <jsp:include  page="/WEB-INF/jsp/header.jsp"/>

</head>
<body>
<a class="write_a" target="_blank" href="/p/writer.htm/"><i class="ic">写文章</i></a>
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

<div class="p_list" id="p_list">
    <div id="p_item">
        <%--<div class="author">--%>
            <%--<a class="avatar"><img src="http://101.201.235.59:8087/pic/sss.jpg" alt="" class="author_img"/></a>--%>
            <%--<div class="name">--%>
                <%--<a>牛顿</a>--%>
                <%--<span>2017-1-31</span>--%>
            <%--</div>--%>
        <%--</div>--%>
        <%--<a class="title">万有引力</a>--%>
        <%--<p class="context">以前我跟很多油头发的妹子一样，--%>
            <%--今天晚上洗了头发，明天晚上头发就油了。高中的时候因为头发油，剪短了头发，--%>
            <%--以为短发会好打理一点。但是，很久以后我才知道短发甚至比长发更难打理，因为.</p>--%>
        <%--<div class="meta">--%>
            <%--<a class="context_tag">物理</a>--%>
            <%--<a target="_blank">--%>
                <%--<i class="iconfont">50</i>--%>
            <%--</a>--%>
            <%--<a target="_blank">--%>
                <%--<i class="iconfont">2</i>--%>
            <%--</a>--%>
            <%--<a target="_blank">--%>
                <%--<i class="iconfont">10</i>--%>
            <%--</a>--%>
        <%--</div>--%>
    </div>
    <a data-page="3" onclick="loadmore()" class="load-more">加载更多</a>
    <input type="hidden" id="loadmore" value="2" />
    <div id="loadmore_result"></div>
</div>

<div class="recommend">
    <div class="rec_title">
        <span>推荐作者</span>
    </div>
    <c:forEach items="${recommendlist}" var="recommendlist">
    <div class="rec_list">
        <div class="rec_li">
            <a class="avatar"><img src="http://101.201.235.59:8087/pic/${recommendlist.photo}" alt="" class="author_img"/></a>
            <a class="follow">
                <i class="ic-follow"></i>
               +关注
            </a>
            <a class="rec_name">${recommendlist.name}</a>
            <p>写了${recommendlist.pcount}篇文章</p>
        </div>
    </div>
    </c:forEach>
</div>
<script>
    initP('p_item',1)
</script>
</body>
</html>
