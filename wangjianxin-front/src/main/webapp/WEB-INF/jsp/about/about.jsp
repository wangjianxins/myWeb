<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
<%--<jsp:include  page="/WEB-INF/jsp/alert/alert.jsp"/>--%>
<head>
    <meta charset="UTF-8">
    <title>关于</title>

    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/index/sui.css" />
    <link rel="stylesheet" type="text/css" href="/resources/css/myemojiPl.css" />
    <link rel="stylesheet" href="/resources/css/jindutiao/jindutiao.css">

    <link rel="stylesheet" type="text/css" href="/resources/css/dianzan/default.css" />

    <script src="/resources/js/jquery-1.10.2.min.js"></script>
    <script src="/resources/js/index/suimin.js" type="text/javascript" charset="utf-8"></script>
    <script src="/resources/js/myemojiPl.js"></script>
    <script src="/resources/js/index/index.js"></script>

    <jsp:include  page="/WEB-INF/jsp/header.jsp"/>

<%--<script src="/resources/js/login/index.js"></script>--%>
    <style>

        .avator{
            /*display: block;*/
            float: right;
            margin:5px;
            width: 30px;
            height: 30px;
            border-radius: 50%;
        }

    </style>

</head>
<body>
            <%--<div id="sui_nav" class="sui-nav horizontal">--%>
            <%--<div class="sui-nav-wrapper nav-border nav-line">--%>
                <%--<ul>--%>
                    <%--<li><a class="text-primary" onclick="a()"><span class="glyphicon glyphicon-home"></span> 主页</a></li>--%>
                    <%--<li><a class="text-primary" onclick="p()"><span></span> article</a></li>--%>
                    <%--<li><a href="#" class="text-primary" onclick="c()">about</a>--%>
                        <%--<ul>--%>
                            <%--<li><a href="#"><span class="glyphicon glyphicon-edit"></span> editor</a></li>--%>
                            <%--<li><a href="#"><span class="glyphicon glyphicon-pencil"></span> pencil</a></li>--%>
                            <%--<li><a href="#"><span class="glyphicon glyphicon-saved"></span> Level23</a>--%>
                                <%--<span class="indicator">&gt;</span>--%>
                                <%--<ul>--%>
                                    <%--<li><a href="#">Level31</a></li>--%>
                                    <%--<li><a href="#">Level32</a></li>--%>
                                    <%--<li class="hide-in-horizontal"><a href="#">Level33</a>--%>
                                        <%--<ul>--%>
                                            <%--<li><a href="#">Level331</a></li>--%>
                                            <%--<li><a href="#">Level332</a></li>--%>
                                            <%--<li><a href="#">Level333</a></li>--%>
                                            <%--<li><a href="#">Level334</a></li>--%>
                                        <%--</ul>--%>
                                        <%--<span class="indicator">&gt;</span>--%>
                                    <%--</li>--%>
                                    <%--<li><a href="#">Level34</a></li>--%>
                                <%--</ul>--%>
                            <%--</li>--%>
                            <%--<li><a href="#"><span class="glyphicon glyphicon-save"></span> Level24</a></li>--%>
                        <%--</ul>--%>
                    <%--</li>--%>
                    <%--<li><a class="text-danger" onclick="c()">star</a></li>--%>
                    <%--<li><a class="text-danger" onclick="l()">link</a></li>--%>
                    <%--<li><a class="text-danger" onclick="m()">music</a></li>--%>

                <%--</ul>--%>

                <%--<ul class="pull-right" id="login_names">--%>
                    <%--<li><a class="text-primary" onclick="d()">登录</a>--%>
                    <%--</li>--%>
                <%--</ul>--%>
                <%--<input type="text" id="user_id" style="display: none"/>--%>
                <%--<ul class="pull-right" id="login_name">--%>
                    <%--<li><a id="username" class="text-primary"></a>--%>
                        <%--<img  class="avator" src="" id="photo"/>--%>

                        <%--<ul>--%>
                            <%--<li><a onclick="quit()">注销登录</a></li>--%>
                            <%--<li><a>修改密码</a></li>--%>
                            <%--<li><a>我的消息</a></li>--%>
                            <%--<li><a>其他</a>--%>
                                <%--<ul>--%>
                                    <%--<li><a>这都能找到</a></li>--%>
                                <%--</ul>--%>
                            <%--</li>--%>
                        <%--</ul>--%>
                    <%--</li>--%>
                <%--</ul>--%>
            <%--</div>--%>
        <%--</div>--%>
            <%--<div class="container ">--%>
                <%--<div class="nav-second">--%>
                    <%--<div id="sui_nav2" class="sui-nav">--%>
                        <%--<script type="text/javascript">--%>
                            <%--var topbar;--%>
                            <%--$(function() {--%>
                                <%--topbar = $('#sui_nav').SuiNav({});--%>
                                <%--var navbar = $('#sui_nav2').SuiNav({});--%>
                                <%--$('.MenuOpen').click(function() {--%>
                                    <%--topbar.show();--%>
                                <%--});--%>
                            <%--});--%>
                        <%--</script>--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</div>--%>
            <%--<div class="container">--%>
                <%--<div class="row">--%>
                    <%--<div class="col-md-offset-3 col-md-6">--%>
                        <%--<div class="progress">--%>
                            <%--<div class="progress-bar progress-bar-info progress-bar-striped active" style="width:10%;">--%>
                                <%--<div class="progress-value">10%</div>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</div>--%>
        <div id="demo_content">
            <div id="container" style="width: 700px; height: 300px; margin: 0 auto" data-highcharts-chart="0">
                <div class="highcharts-container" id="highcharts-0" style="position: relative; overflow: hidden; width: 700px; height: 300px; line-height: normal; z-index: 0; -webkit-tap-highlight-color: rgba(0, 0, 0, 0);">
                    <svg version="1.1" style="font-family: &quot; Lucida Grande&quot; , &quot; Lucida Sans Unicode&quot; , Arial, Helvetica, sans-serif; font-size: 12px;" xmlns="http://www.w3.org/2000/svg" width="1000" height="400">
                        <desc></desc><defs><clippath id="highcharts-1"><rect x="0" y="0" width="903" height="306"></rect>
                        </clippath>
                        </defs><rect x="0" y="0" width="1000" height="400" strokeWidth="0" fill="#FFFFFF" class=" highcharts-background"></rect><path fill="none" d="M 87 308.5 L 990 308.5" stroke="#808080" stroke-width="1"></path><path fill="rgba(124,181,236,0.25)" d="M 561.3015540182698 193.3274228144437 C 574.6215540182699 193.3274228144437 574.6215540182699 213.3274228144437 561.3015540182698 213.3274228144437 C 547.9815540182698 213.3274228144437 547.9815540182698 193.3274228144437 561.3015540182698 193.3274228144437 Z"></path><g class="highcharts-grid" zIndex="1"></g><g class="highcharts-grid" zIndex="1"><path fill="none" d="M 87 308.5 L 990 308.5" stroke="#C0C0C0" stroke-width="1" zIndex="1" opacity="1"></path>
                            <path fill="none" d="M 87 104.5 L 990 104.5" stroke="#C0C0C0" stroke-width="1" zIndex="1" opacity="1"></path>
                            <path fill="none" d="M 87 52.5 L 990 52.5" stroke="#C0C0C0" stroke-width="1" zIndex="1" opacity="1"></path>
                            <path fill="none" d="M 87 155.5 L 990 155.5" stroke="#C0C0C0" stroke-width="1" zIndex="1" opacity="1"></path>
                            <path fill="none" d="M 87 206.5 L 990 206.5" stroke="#C0C0C0" stroke-width="1" zIndex="1" opacity="1"></path>
                            <path fill="none" d="M 87 257.5 L 990 257.5" stroke="#C0C0C0" stroke-width="1" zIndex="1" opacity="1"></path>
                            <path fill="none" d="M 87 359.5 L 990 359.5" stroke="#C0C0C0" stroke-width="1" zIndex="1" opacity="1"></path>
                        </g><g class="highcharts-axis" zIndex="2"><path fill="none" d="M 118.5 359 L 118.5 369" stroke="#C0D0E0" stroke-width="1" opacity="1"></path>
                            <path fill="none" d="M 211.5 359 L 211.5 369" stroke="#C0D0E0" stroke-width="1" opacity="1"></path>
                            <path fill="none" d="M 304.5 359 L 304.5 369" stroke="#C0D0E0" stroke-width="1" opacity="1"></path>
                            <path fill="none" d="M 397.5 359 L 397.5 369" stroke="#C0D0E0" stroke-width="1" opacity="1"></path>
                            <path fill="none" d="M 490.5 359 L 490.5 369" stroke="#C0D0E0" stroke-width="1" opacity="1"></path>
                            <path fill="none" d="M 582.5 359 L 582.5 369" stroke="#C0D0E0" stroke-width="1" opacity="1"></path>
                            <path fill="none" d="M 675.5 359 L 675.5 369" stroke="#C0D0E0" stroke-width="1" opacity="1"></path>
                            <path fill="none" d="M 768.5 359 L 768.5 369" stroke="#C0D0E0" stroke-width="1" opacity="1"></path>
                            <path fill="none" d="M 861.5 359 L 861.5 369" stroke="#C0D0E0" stroke-width="1" opacity="1"></path>
                            <path fill="none" d="M 953.5 359 L 953.5 369" stroke="#C0D0E0" stroke-width="1" opacity="1"></path>
                            <path fill="none" d="M 87 359.5 L 990 359.5" stroke="#C0D0E0" stroke-width="1" zIndex="7" visibility="visible"></path>
                        </g><g class="highcharts-axis" zIndex="2"><text x="28.484375" zIndex="7" text-anchor="middle" transform="translate(0,0) rotate(270 28.484375 206)" class=" highcharts-yaxis-title" style="color: #707070; fill: #707070;" visibility="visible" y="206">Value</text>
                        </g><g class="highcharts-series-group" zIndex="3"><g class="highcharts-series" visibility="visible" zIndex="0.1" transform="translate(87,53) scale(1 1)" clip-path="url(#highcharts-1)"><path fill="none" d="M 8.85294472976165 128.85317246429622 C 8.85294472976165 128.85317246429622 36.743675707958715 152.00509145390242 55.33749636009009 161.4517748085782 C 73.93131701222146 170.89845816325396 83.22822733828716 176.08658923767507 101.82204799041853 176.08658923767507 C 120.39731193531225 176.08658923767507 129.6849439077591 144.99110019933542 148.26020785265283 134.36388010438532 C 166.85402850478422 123.72604340594373 176.15093883084987 125.68161142151803 194.74475948298127 122.92394725419581 C 213.57981732920217 120.16628308687359 222.99734625231264 120.16628308687359 241.83240409853354 120.16628308687359 C 260.4447814579026 120.16628308687359 269.7509701375871 166.12020259257406 288.3633474969561 166.12020259257406 C 306.9571681490875 166.12020259257406 316.25407847515316 164.88258715253323 334.84789912728456 164.88258715253323 C 353.44171977941596 164.88258715253323 362.7386301054816 240.30810465384275 381.332450757613 240.30810465384275 C 399.92627140974434 240.30810465384275 409.22318173581004 72.83938021492213 427.81700238794144 72.83938021492213 C 446.4108230400728 72.83938021492213 455.70773336613854 150.3274228144437 474.3015540182699 150.3274228144437 C 492.87681796316355 150.3274228144437 502.16444993561043 55.11221928242594 520.7397138805042 55.11221928242594 C 539.3335345326356 55.11221928242594 548.6304448587013 145.26400727033615 567.2242655108327 145.26400727033615 C 585.818086162964 145.26400727033615 595.1149964890297 122.30409235786647 613.708817141161 122.30409235786647 C 632.2840810860547 122.30409235786647 641.5717130585016 202.71840201504529 660.1469770033954 228.07372207101434 C 678.7593543627643 253.4290421269834 688.0655430424489 253.4290421269834 706.6779204018179 253.4290421269834 C 725.9583392217426 253.4290421269834 735.598548631705 139.93858543038368 754.8789674516296 139.93858543038368 C 773.361447860335 139.93858543038368 782.6026880646878 163.80467434041202 801.0851684733932 163.80467434041202 C 819.6789891255245 163.80467434041202 828.9758994515902 152.25466374794055 847.5697201037216 136.50634683296084 C 866.2006541703282 120.72659615168382 894.1470552702383 84.98450534977019 894.1470552702383 84.98450534977019" stroke="#7cb5ec" stroke-width="3" zIndex="1" stroke-linejoin="round" stroke-linecap="round"></path>
                            <path fill="none" d="M -1.1470552702383507 128.85317246429622 L 8.85294472976165 128.85317246429622 C 8.85294472976165 128.85317246429622 36.743675707958715 152.00509145390242 55.33749636009009 161.4517748085782 C 73.93131701222146 170.89845816325396 83.22822733828716 176.08658923767507 101.82204799041853 176.08658923767507 C 120.39731193531225 176.08658923767507 129.6849439077591 144.99110019933542 148.26020785265283 134.36388010438532 C 166.85402850478422 123.72604340594373 176.15093883084987 125.68161142151803 194.74475948298127 122.92394725419581 C 213.57981732920217 120.16628308687359 222.99734625231264 120.16628308687359 241.83240409853354 120.16628308687359 C 260.4447814579026 120.16628308687359 269.7509701375871 166.12020259257406 288.3633474969561 166.12020259257406 C 306.9571681490875 166.12020259257406 316.25407847515316 164.88258715253323 334.84789912728456 164.88258715253323 C 353.44171977941596 164.88258715253323 362.7386301054816 240.30810465384275 381.332450757613 240.30810465384275 C 399.92627140974434 240.30810465384275 409.22318173581004 72.83938021492213 427.81700238794144 72.83938021492213 C 446.4108230400728 72.83938021492213 455.70773336613854 150.3274228144437 474.3015540182699 150.3274228144437 C 492.87681796316355 150.3274228144437 502.16444993561043 55.11221928242594 520.7397138805042 55.11221928242594 C 539.3335345326356 55.11221928242594 548.6304448587013 145.26400727033615 567.2242655108327 145.26400727033615 C 585.818086162964 145.26400727033615 595.1149964890297 122.30409235786647 613.708817141161 122.30409235786647 C 632.2840810860547 122.30409235786647 641.5717130585016 202.71840201504529 660.1469770033954 228.07372207101434 C 678.7593543627643 253.4290421269834 688.0655430424489 253.4290421269834 706.6779204018179 253.4290421269834 C 725.9583392217426 253.4290421269834 735.598548631705 139.93858543038368 754.8789674516296 139.93858543038368 C 773.361447860335 139.93858543038368 782.6026880646878 163.80467434041202 801.0851684733932 163.80467434041202 C 819.6789891255245 163.80467434041202 828.9758994515902 152.25466374794055 847.5697201037216 136.50634683296084 C 866.2006541703282 120.72659615168382 894.1470552702383 84.98450534977019 894.1470552702383 84.98450534977019 L 904.1470552702383 84.98450534977019" stroke-linejoin="round" visibility="visible" stroke="rgba(192,192,192,0.0001)" stroke-width="22" zIndex="2" class=" highcharts-tracker" style=""></path>
                        </g>
                            <g class="highcharts-markers highcharts-tracker" visibility="visible" zIndex="0.1" transform="translate(87,53) scale(1 1)" clip-path="none" style="">
                                <path fill="#7cb5ec" d="M 8 124.85317246429622 C 13.328 124.85317246429622 13.328 132.85317246429622 8 132.85317246429622 C 2.6719999999999997 132.85317246429622 2.6719999999999997 124.85317246429622 8 124.85317246429622 Z"></path>
                                <path fill="#7cb5ec" d="M 55 157.4517748085782 C 60.328 157.4517748085782 60.328 165.4517748085782 55 165.4517748085782 C 49.672 165.4517748085782 49.672 157.4517748085782 55 157.4517748085782 Z"></path>
                                <path fill="#7cb5ec" d="M 101 172.08658923767507 C 106.328 172.08658923767507 106.328 180.08658923767507 101 180.08658923767507 C 95.672 180.08658923767507 95.672 172.08658923767507 101 172.08658923767507 Z"></path>
                                <path fill="#7cb5ec" d="M 148 130.36388010438532 C 153.328 130.36388010438532 153.328 138.36388010438532 148 138.36388010438532 C 142.672 138.36388010438532 142.672 130.36388010438532 148 130.36388010438532 Z"></path>
                                <path fill="#7cb5ec" d="M 194 118.92394725419581 C 199.328 118.92394725419581 199.328 126.92394725419581 194 126.92394725419581 C 188.672 126.92394725419581 188.672 118.92394725419581 194 118.92394725419581 Z"></path>
                                <path fill="#7cb5ec" d="M 241 116.16628308687359 C 246.328 116.16628308687359 246.328 124.16628308687359 241 124.16628308687359 C 235.672 124.16628308687359 235.672 116.16628308687359 241 116.16628308687359 Z"></path>
                                <path fill="#7cb5ec" d="M 288 162.12020259257406 C 293.328 162.12020259257406 293.328 170.12020259257406 288 170.12020259257406 C 282.672 170.12020259257406 282.672 162.12020259257406 288 162.12020259257406 Z"></path>
                                <path fill="#7cb5ec" d="M 334 160.88258715253323 C 339.328 160.88258715253323 339.328 168.88258715253323 334 168.88258715253323 C 328.672 168.88258715253323 328.672 160.88258715253323 334 160.88258715253323 Z"></path>
                                <path fill="#7cb5ec" d="M 381 236.30810465384275 C 386.328 236.30810465384275 386.328 244.30810465384275 381 244.30810465384275 C 375.672 244.30810465384275 375.672 236.30810465384275 381 236.30810465384275 Z"></path>
                                <path fill="#7cb5ec" d="M 427 68.83938021492213 C 432.328 68.83938021492213 432.328 76.83938021492213 427 76.83938021492213 C 421.672 76.83938021492213 421.672 68.83938021492213 427 68.83938021492213 Z"></path>
                                <path fill="#7cb5ec" d="M 474.3015540182699 144.3274228144437 C 482.2935540182699 144.3274228144437 482.2935540182699 156.3274228144437 474.3015540182699 156.3274228144437 C 466.30955401826986 156.3274228144437 466.30955401826986 144.3274228144437 474.3015540182699 144.3274228144437 Z" stroke="#FFFFFF" stroke-width="1"></path>
                                <path fill="#7cb5ec" d="M 520 51.11221928242594 C 525.328 51.11221928242594 525.328 59.11221928242594 520 59.11221928242594 C 514.672 59.11221928242594 514.672 51.11221928242594 520 51.11221928242594 Z"></path>
                                <path fill="#7cb5ec" d="M 567 141.26400727033615 C 572.328 141.26400727033615 572.328 149.26400727033615 567 149.26400727033615 C 561.672 149.26400727033615 561.672 141.26400727033615 567 141.26400727033615 Z"></path>
                                <path fill="#7cb5ec" d="M 613 118.30409235786647 C 618.328 118.30409235786647 618.328 126.30409235786647 613 126.30409235786647 C 607.672 126.30409235786647 607.672 118.30409235786647 613 118.30409235786647 Z"></path>
                                <path fill="#7cb5ec" d="M 660 224.07372207101434 C 665.328 224.07372207101434 665.328 232.07372207101434 660 232.07372207101434 C 654.672 232.07372207101434 654.672 224.07372207101434 660 224.07372207101434 Z"></path>
                                <path fill="#7cb5ec" d="M 706 249.4290421269834 C 711.328 249.4290421269834 711.328 257.4290421269834 706 257.4290421269834 C 700.672 257.4290421269834 700.672 249.4290421269834 706 249.4290421269834 Z"></path>
                                <path fill="#7cb5ec" d="M 754 135.93858543038368 C 759.328 135.93858543038368 759.328 143.93858543038368 754 143.93858543038368 C 748.672 143.93858543038368 748.672 135.93858543038368 754 135.93858543038368 Z"></path>
                                <path fill="#7cb5ec" d="M 801 159.80467434041202 C 806.328 159.80467434041202 806.328 167.80467434041202 801 167.80467434041202 C 795.672 167.80467434041202 795.672 159.80467434041202 801 159.80467434041202 Z"></path>
                                <path fill="#7cb5ec" d="M 847 132.50634683296084 C 852.328 132.50634683296084 852.328 140.50634683296084 847 140.50634683296084 C 841.672 140.50634683296084 841.672 132.50634683296084 847 132.50634683296084 Z"></path>
                                <path fill="#7cb5ec" d="M 894 80.98450534977019 C 899.328 80.98450534977019 899.328 88.98450534977019 894 88.98450534977019 C 888.672 88.98450534977019 888.672 80.98450534977019 894 80.98450534977019 Z"></path>
                            </g>
                        </g><text x="500" text-anchor="middle" class="highcharts-title" zIndex="4" style="color: #333333; font-size: 18px; fill: #333333; width: 936px;" y="25"><tspan>每日下载量</tspan>
                        </text><g class="highcharts-axis-labels highcharts-xaxis-labels" zIndex="7"><text x="119.3735711534907" text-anchor="middle" style="color: #606060; cursor: default; font-size: 11px; fill: #606060;" y="380" opacity="1">13:54:44</text>
                            <text x="212.15710734177105" text-anchor="middle" style="color: #606060; cursor: default; font-size: 11px; fill: #606060;" y="380" opacity="1">13:54:46</text>
                            <text x="304.9406435300514" text-anchor="middle" style="color: #606060; cursor: default; font-size: 11px; fill: #606060;" y="380" opacity="1">13:54:48</text>
                            <text x="397.7241797183317" text-anchor="middle" style="color: #606060; cursor: default; font-size: 11px; fill: #606060;" y="380" opacity="1">13:54:50</text>
                            <text x="490.507715906612" text-anchor="middle" style="color: #606060; cursor: default; font-size: 11px; fill: #606060;" y="380" opacity="1">13:54:52</text>
                            <text x="583.2912520948923" text-anchor="middle" style="color: #606060; cursor: default; font-size: 11px; fill: #606060;" y="380" opacity="1">13:54:54</text>
                            <text x="676.0747882831727" text-anchor="middle" style="color: #606060; cursor: default; font-size: 11px; fill: #606060;" y="380" opacity="1">13:54:56</text>
                            <text x="768.858324471453" text-anchor="middle" style="color: #606060; cursor: default; font-size: 11px; fill: #606060;" y="380" opacity="1">13:54:58</text>
                            <text x="861.6418606597333" text-anchor="middle" style="color: #606060; cursor: default; font-size: 11px; fill: #606060;" y="380" opacity="1">13:55:00</text>
                            <text x="954.4253968480136" text-anchor="middle" style="color: #606060; cursor: default; font-size: 11px; fill: #606060;" y="380" opacity="1">13:55:02</text>
                        </g><g class="highcharts-axis-labels highcharts-yaxis-labels" zIndex="7"><text x="72" text-anchor="end" style="width: 310px; color: #606060; cursor: default; font-size: 11px; fill: #606060;" y="312" opacity="1">0</text>
                            <text x="72" text-anchor="end" style="width: 310px; color: #606060; cursor: default; font-size: 11px; fill: #606060;" y="108" opacity="1">1</text>
                            <text x="72" text-anchor="end" style="width: 310px; color: #606060; cursor: default; font-size: 11px; fill: #606060;" y="261" opacity="1">0.25</text>
                            <text x="72" text-anchor="end" style="width: 310px; color: #606060; cursor: default; font-size: 11px; fill: #606060;" y="210" opacity="1">0.5</text>
                            <text x="72" text-anchor="end" style="width: 310px; color: #606060; cursor: default; font-size: 11px; fill: #606060;" y="159" opacity="1">0.75</text>
                            <text x="72" text-anchor="end" style="width: 310px; color: #606060; cursor: default; font-size: 11px; fill: #606060;" y="57" opacity="1">1.25</text>
                            <text x="72" text-anchor="end" style="width: 310px; color: #606060; cursor: default; font-size: 11px; fill: #606060;" y="363" opacity="1">-0.25</text>
                        </g><g class="highcharts-tooltip" zIndex="8" style="cursor: default; padding: 0; white-space: nowrap;" transform="translate(487,121)" opacity="1" visibility="visible"><path fill="none" d="M 3.5 0.5 L 145.5 0.5 C 148.5 0.5 148.5 0.5 148.5 3.5 L 148.5 63.5 C 148.5 66.5 148.5 66.5 145.5 66.5 L 80.5 66.5 74.5 72.5 68.5 66.5 3.5 66.5 C 0.5 66.5 0.5 66.5 0.5 63.5 L 0.5 3.5 C 0.5 0.5 0.5 0.5 3.5 0.5" isShadow="true" stroke="black" stroke-opacity="0.049999999999999996" stroke-width="5" transform="translate(1, 1)" width="148" height="66"></path>
                            <path fill="none" d="M 3.5 0.5 L 145.5 0.5 C 148.5 0.5 148.5 0.5 148.5 3.5 L 148.5 63.5 C 148.5 66.5 148.5 66.5 145.5 66.5 L 80.5 66.5 74.5 72.5 68.5 66.5 3.5 66.5 C 0.5 66.5 0.5 66.5 0.5 63.5 L 0.5 3.5 C 0.5 0.5 0.5 0.5 3.5 0.5" isShadow="true" stroke="black" stroke-opacity="0.09999999999999999" stroke-width="3" transform="translate(1, 1)" width="148" height="66"></path>
                            <path fill="none" d="M 3.5 0.5 L 145.5 0.5 C 148.5 0.5 148.5 0.5 148.5 3.5 L 148.5 63.5 C 148.5 66.5 148.5 66.5 145.5 66.5 L 80.5 66.5 74.5 72.5 68.5 66.5 3.5 66.5 C 0.5 66.5 0.5 66.5 0.5 63.5 L 0.5 3.5 C 0.5 0.5 0.5 0.5 3.5 0.5" isShadow="true" stroke="black" stroke-opacity="0.15" stroke-width="1" transform="translate(1, 1)" width="148" height="66"></path>
                            <path fill="rgba(249, 249, 249, .85)" d="M 3.5 0.5 L 145.5 0.5 C 148.5 0.5 148.5 0.5 148.5 3.5 L 148.5 63.5 C 148.5 66.5 148.5 66.5 145.5 66.5 L 80.5 66.5 74.5 72.5 68.5 66.5 3.5 66.5 C 0.5 66.5 0.5 66.5 0.5 63.5 L 0.5 3.5 C 0.5 0.5 0.5 0.5 3.5 0.5" stroke="#7cb5ec" stroke-width="1"></path>
                            <text x="8" zIndex="1" style="font-size: 12px; color: #333333; fill: #333333;" y="21">
                                <tspan style="font-weight: bold">Random data</tspan>
                                <tspan x="8" dy="16">2015-01-24 13:54:53</tspan>
                                <tspan x="8" dy="16">0.51</tspan>
                            </text>
                        </g></svg>
                </div>
            </div>
    </div>

    <div style="text-align:center;margin-top: 50px">
        本人java开发者，网站建设中<br>
        联系qq：731461008
    </div>

    <script type="text/javascript" src="/resources/js/quxian/bootstrap-dropdown.js"></script>
    <script type="text/javascript" src="/resources/js/quxian/jquery.scrollUp.min.js"></script>
    <script type="text/javascript" src="/resources/js/quxian/highcharts.js"></script>
    <script type="text/javascript" src="/resources/js/quxian/exporting.js"></script>
    <script type="text/javascript" src="/resources/js/quxian/dynamic-update.js"></script>

</body>
</html>
