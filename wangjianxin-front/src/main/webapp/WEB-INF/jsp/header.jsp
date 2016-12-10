<%--
  Created by IntelliJ IDEA.
  User: wangjianxin
  Date: 2016/10/25
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
<head>
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/index/sui.css" />
    <link rel="stylesheet" type="text/css" href="/resources/css/myemojiPl.css" />
    <link rel="stylesheet" type="text/css" href="/resources/css/dianzan/default.css" />



    <script src="/resources/js/jquery-1.10.2.min.js"></script>
    <script src="/resources/js/index/suimin.js" type="text/javascript" charset="utf-8"></script>
    <script src="/resources/js/myemojiPl.js" ></script>
    <script src="/resources/js/index/index.js" type="text/javascript" charset="utf-8"></script>



</head>
<body>
<div id="sui_nav" class="sui-nav horizontal">
    <div class="sui-nav-wrapper nav-border nav-line">
        <ul>
            <li><a class="text-primary" onclick="a()"><span class="glyphicon glyphicon-home"></span> 主页</a></li>
            <li><a href="#" class="text-primary" onclick="b()"> 关于</a>
                <ul>
                    <li><a href="#"><span class="glyphicon glyphicon-edit"></span> editor</a></li>
                    <li><a href="#"><span class="glyphicon glyphicon-pencil"></span> pencil</a></li>
                    <li><a href="#"><span class="glyphicon glyphicon-saved"></span> Level23</a>
                        <span class="indicator">&gt;</span>
                        <ul>
                            <li><a href="#">Level31</a></li>
                            <li><a href="#">Level32</a></li>
                            <li class="hide-in-horizontal"><a href="#">Level33</a>
                                <ul>
                                    <li><a href="#">Level331</a></li>
                                    <li><a href="#">Level332</a></li>
                                    <li><a href="#">Level333</a></li>
                                    <li><a href="#">Level334</a></li>
                                </ul>
                                <span class="indicator">&gt;</span>
                            </li>
                            <li><a href="#">Level34</a></li>
                        </ul>
                    </li>
                    <li><a href="#"><span class="glyphicon glyphicon-save"></span> Level24</a></li>
                </ul>
            </li>
            <li><a class="text-danger" onclick="c()">star</a></li>
        </ul>

        <ul class="pull-right" id="login_names">
            <li><a class="text-primary" onclick="d()">登录</a>
            </li>
        </ul>
        <input type="text" id="user_id" style="display: none"/>
        <ul class="pull-right" id="login_name">
            <li><a id="username" class="text-primary"></a>
                <ul>
                    <li><a onclick="quit()">注销登录</a></li>
                    <li><a>修改密码</a></li>
                    <li><a>我的消息</a></li>
                    <li><a>其他</a>
                        <ul>
                            <li><a>这都能找到</a></li>
                        </ul>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
</div>
<script type="text/javascript">
    //					document.write(document.getElementById('sui_nav').innerHTML);
    var topbar;
    $(function() {
        topbar = $('#sui_nav').SuiNav({});
        var navbar = $('#sui_nav2').SuiNav({});
        $('.MenuOpen').click(function() {
            topbar.show();
        });
    });
</script>
</body>
</html>
