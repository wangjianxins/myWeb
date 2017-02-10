<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"  class="demo-2 no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>星座</title>
    <jsp:include  page="/WEB-INF/jsp/header.jsp"/>

    <link rel="stylesheet" type="text/css" href="/resources/css/start_/normalize.css" />
    <link rel="stylesheet" type="text/css" href="/resources/css/start_/demo.css" />
    <link rel="stylesheet" type="text/css" href="/resources/css/start_/component.css" />
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

    <style type="text/css">
        .container {
            margin: 10px auto;
        }
        .container .body {
            padding: 0px 10px;
            position: relative;
            padding-left: 250px;
        }
        .nav-second {
            position: fixed;
            width: 250px;
            float: left;
            margin-left: -50px;
            z-index: 100;
        }
        @media only screen and (max-width: 768px) {
            .container .body {
                padding: 0px;
            }
        }
    </style>
</head>
<body>
<div class="container ">
    <div class="nav-second">
        <div id="sui_nav2" class="sui-nav">
            <button class="MenuOpen btn btn-success" id="show_table" onclick="test( ($('#user_id').val()) )">创建星座</button>
            <%--<div  id="paihang_div">--%>
            <%--</div>--%>
            <script type="text/javascript">
//                var topbar;
//                $(function() {
//                    topbar = $('#sui_nav').SuiNav({});
//                    var navbar = $('#sui_nav2').SuiNav({});
//                    $('.MenuOpen').click(function() {
//                        topbar.show();
//                    });
//                });
                function test(user_id){
                    if(user_id == ""){
                        $.confirm({
                            content:'先登录'
                        })
                        return false;
                    }
                    $.confirm({
                        animation:'scaleY',
                        content:'<form id="uploadForm" action="/star/create.json" method="post" enctype="multipart/form-data">' +
                                ' <label>输入星座(一个用户只能创建一个):</label> ' +
                                '<input  type="text" id="star_userid" name="star_userid" value="'+user_id+'" style="display: none">'+
                                '<input  type="text" id="star_name" name="star_name" placeholder="星座" class="form-control">'+
                                '<label>输入星座描述(描述不当内容将被删除):</label>'+
                                '<textarea rows="10" cols="4" placeholder="星座描述" class="form-control" id="star_des" name="star_des"></textarea>'+
                                '<label>输入星座时间段例如：4.21～5.20</label>'+
                                '<input type="text" id="star_time" name="star_time" placeholder="星座时间段" class="form-control">'+
                                '<label>上传星座图片:</label>'+
                                '<input  type="file" name="photo" id="photo">' +
                                '</form>',
                                title: '创建星座',
                        theme: 'white',
                        contentLoaded: function(data, status, xhr){
                            var self = this;
                            setTimeout(function(){
                            }, 1500);
                        },
                        confirm: function (){
                            if($('#star_name').val() ==0 || $('#star_des').val() ==0 ||
                                    $('#star_time').val() ==0 ||  $('#photo').val() == ''){
                                $.alert('请填写完整');
                                return false;
                            }else{
                                $("#uploadForm").submit();
                                    location.href="/star.html";
                            }
                        },
                        cancel: function (){
                        },
                        closeAnimation: 'scaleY'
                    });
                }

            </script>
        </div>


    </div>
<div class="container">
    <section id="grid" class="grid clearfix">
        <c:forEach var="starlist" items="${starlist}">
        <a href="/star/detial/${starlist.id}"  data-path-hover="m 0,0 0,47.7775 c 24.580441,3.12569 55.897012,-8.199417 90,-8.199417 34.10299,0 65.41956,11.325107 90,8.199417 L 180,0 z">
            <figure>
                <img src="http://101.201.235.59:8087/pic/${starlist.photo}"/>
                <svg viewBox="0 0 180 320" preserveAspectRatio="none"><path d="m 0,0 0,171.14385 c 24.580441,15.47138 55.897012,24.75772 90,24.75772 34.10299,0 65.41956,-9.28634 90,-24.75772 L 180,0 0,0 z"/></svg>
                <figcaption>
                    <h2>${starlist.starName}</h2>
                    <p>${starlist.starTime}</p>
                    <button id="${starlist.id}">
                        <script >
                        $.ajax({
                            url:'/getNames.json',
                            type:'get',
                            data:{
                                user_id:${starlist.userId}
                            },
                            success:function (data){
                                $('#${starlist.id}').text("创建者:"+data[0].name);
                            }
                        })
                    </script>
                    </button>
                </figcaption>
            </figure>
        </a>
        </c:forEach>
    </section>
</div>
<script>
    (function() {

        function init() {
            var speed = 330,
                    easing = mina.backout;

            [].slice.call ( document.querySelectorAll( '#grid > a' ) ).forEach( function( el ) {
                var s = Snap( el.querySelector( 'svg' ) ), path = s.select( 'path' ),
                        pathConfig = {
                            from : path.attr( 'd' ),
                            to : el.getAttribute( 'data-path-hover' )
                        };

                el.addEventListener( 'mouseenter', function() {
                    path.animate( { 'path' : pathConfig.to }, speed, easing );
                } );

                el.addEventListener( 'mouseleave', function() {
                    path.animate( { 'path' : pathConfig.from }, speed, easing );
                } );
            } );
        }

        init();

    })();
</script>
</body>
</html>