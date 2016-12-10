<%--
  Created by IntelliJ IDEA.
  User: wangjianxin
  Date: 2016/11/7
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <jsp:include  page="/WEB-INF/jsp/header.jsp"/>
    <title>星座</title>
    <%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">--%>
    <link rel="stylesheet" href="/resources/css/alert/jquery-confirm.css">

    <link rel="stylesheet" href="/resources/css/start_/start_.css">


    <script src="/resources/js/alert/jquery-confirm.js"></script>
    <script src="/resources/js/alert/jquery.sticky.min.js"></script>
    <script src="/resources/js/alert/pretty.js"></script>
    <script src="/resources/js/star/star.js"></script>



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
                    var topbar;
                    $(function() {
                        topbar = $('#sui_nav').SuiNav({});
                        var navbar = $('#sui_nav2').SuiNav({});
                        $('.MenuOpen').click(function() {
                            topbar.show();
                        });
                    });
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
                                    ' <label>输入星座:</label> ' +
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
                            confirm: function(){
                                if($('#star_name').val() ==0 || $('#star_des').val() ==0 ||
                                        $('#star_time').val() ==0 ||  $('#photo').val() == ''){
                                    $.alert('请填写完整');
                                    return false;
                                }else{
                                    $("#uploadForm").submit();
//                                    location.href=location.href;
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
        <div class="body"  id="max">

            <div class="Main">

                <div class="faceDiv">
                    <section class="emoji_container">
                    </section>
                    <section class="emoji_tab"></section>
                </div>
            </div><br/><br/>
            <!--文字-->
            <div id="context" class="Main">

            </div>
            <div class="tcdPageCode"></div>
            <!--文字结束-->
            <!--分页-->

        </div >

    </div>

    <link href="https://fonts.googleapis.com/css?family=Alegreya+Sans" rel="stylesheet">
    <%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" type="text/css" />--%>
    <%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">--%>

    <div class="container">
        <div class="row">
            <c:forEach var="starlist" items="${starlist}">
            <div class="col-md-3 col-sm-6 ">
                <div class="service-box" style="cursor: pointer">
                    <div class="service-icon hui">
                        <div class="front-content">
                            <%--<i class="fa fa-trophy"></i>--%>
                                <img src="/resources/images/upload/${starlist.photo}" width="150px" height="140px" style="margin-top: 10px"/>
                            <h3>${starlist.starName}</h3>
                        </div>
                    </div>
                    <div class="service-content" onclick="starDetail(${starlist.id})" >
                        <h3>${starlist.starTime}</h3>
                        <p>${starlist.starDes}</p>
                        <h3 id="${starlist.id}">
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
                        </h3>
                    </div>
                </div>
            </div>
           </c:forEach>
                    <%--<div class="service-icon orange">--%>
                    <%--<div class="service-icon red">--%>
                    <%--<div class="service-icon grey">--%>
                    <%--<div class="service-icon grey">--%>
        </div>
    </div>
<script>

</script>
</body>
</html>
